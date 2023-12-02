package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.BuildConfig;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Util;
import io.grpc.ClientCall;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;

/* loaded from: classes5.dex */
public class FirestoreChannel {

    /* renamed from: g  reason: collision with root package name */
    private static final Metadata.Key<String> f31093g;

    /* renamed from: h  reason: collision with root package name */
    private static final Metadata.Key<String> f31094h;

    /* renamed from: i  reason: collision with root package name */
    private static final Metadata.Key<String> f31095i;

    /* renamed from: j  reason: collision with root package name */
    private static volatile String f31096j;

    /* renamed from: a  reason: collision with root package name */
    private final AsyncQueue f31097a;

    /* renamed from: b  reason: collision with root package name */
    private final CredentialsProvider<User> f31098b;

    /* renamed from: c  reason: collision with root package name */
    private final CredentialsProvider<String> f31099c;

    /* renamed from: d  reason: collision with root package name */
    private final GrpcCallProvider f31100d;

    /* renamed from: e  reason: collision with root package name */
    private final String f31101e;

    /* renamed from: f  reason: collision with root package name */
    private final GrpcMetadataProvider f31102f;

    static {
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        f31093g = Metadata.Key.of("x-goog-api-client", asciiMarshaller);
        f31094h = Metadata.Key.of("google-cloud-resource-prefix", asciiMarshaller);
        f31095i = Metadata.Key.of("x-goog-request-params", asciiMarshaller);
        f31096j = "gl-java/";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirestoreChannel(AsyncQueue asyncQueue, Context context, CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2, DatabaseInfo databaseInfo, GrpcMetadataProvider grpcMetadataProvider) {
        this.f31097a = asyncQueue;
        this.f31102f = grpcMetadataProvider;
        this.f31098b = credentialsProvider;
        this.f31099c = credentialsProvider2;
        this.f31100d = new GrpcCallProvider(asyncQueue, context, databaseInfo, new FirestoreCallCredentials(credentialsProvider, credentialsProvider2));
        DatabaseId databaseId = databaseInfo.getDatabaseId();
        this.f31101e = String.format("projects/%s/databases/%s", databaseId.getProjectId(), databaseId.getDatabaseId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseFirestoreException f(Status status) {
        if (Datastore.isMissingSslCiphers(status)) {
            return new FirebaseFirestoreException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", FirebaseFirestoreException.Code.fromValue(status.getCode().value()), status.getCause());
        }
        return Util.exceptionFromStatus(status);
    }

    private String g() {
        return String.format("%s fire/%s grpc/", f31096j, BuildConfig.VERSION_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(final ClientCall[] clientCallArr, final IncomingStreamObserver incomingStreamObserver, Task task) {
        ClientCall clientCall = (ClientCall) task.getResult();
        clientCallArr[0] = clientCall;
        clientCall.start(new ClientCall.Listener() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.1
            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata metadata) {
                try {
                    incomingStreamObserver.onClose(status);
                } catch (Throwable th) {
                    FirestoreChannel.this.f31097a.panic(th);
                }
            }

            @Override // io.grpc.ClientCall.Listener
            public void onHeaders(Metadata metadata) {
                try {
                    incomingStreamObserver.a(metadata);
                } catch (Throwable th) {
                    FirestoreChannel.this.f31097a.panic(th);
                }
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(Object obj) {
                try {
                    incomingStreamObserver.onNext(obj);
                    clientCallArr[0].request(1);
                } catch (Throwable th) {
                    FirestoreChannel.this.f31097a.panic(th);
                }
            }

            @Override // io.grpc.ClientCall.Listener
            public void onReady() {
            }
        }, k());
        incomingStreamObserver.onOpen();
        clientCallArr[0].request(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(final TaskCompletionSource taskCompletionSource, Object obj, Task task) {
        ClientCall clientCall = (ClientCall) task.getResult();
        clientCall.start(new ClientCall.Listener() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.4
            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata metadata) {
                if (status.isOk()) {
                    if (!taskCompletionSource.getTask().isComplete()) {
                        taskCompletionSource.setException(new FirebaseFirestoreException("Received onClose with status OK, but no message.", FirebaseFirestoreException.Code.INTERNAL));
                        return;
                    }
                    return;
                }
                taskCompletionSource.setException(FirestoreChannel.this.f(status));
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(Object obj2) {
                taskCompletionSource.setResult(obj2);
            }
        }, k());
        clientCall.request(2);
        clientCall.sendMessage(obj);
        clientCall.halfClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(final StreamingListener streamingListener, Object obj, Task task) {
        final ClientCall clientCall = (ClientCall) task.getResult();
        clientCall.start(new ClientCall.Listener() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.3
            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata metadata) {
                streamingListener.onClose(status);
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(Object obj2) {
                streamingListener.onMessage(obj2);
                clientCall.request(1);
            }
        }, k());
        clientCall.request(1);
        clientCall.sendMessage(obj);
        clientCall.halfClose();
    }

    private Metadata k() {
        Metadata metadata = new Metadata();
        metadata.put(f31093g, g());
        metadata.put(f31094h, this.f31101e);
        metadata.put(f31095i, this.f31101e);
        GrpcMetadataProvider grpcMetadataProvider = this.f31102f;
        if (grpcMetadataProvider != null) {
            grpcMetadataProvider.updateMetadata(metadata);
        }
        return metadata;
    }

    public static void setClientLanguage(String str) {
        f31096j = str;
    }

    public void invalidateToken() {
        this.f31098b.invalidateToken();
        this.f31099c.invalidateToken();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <ReqT, RespT> ClientCall<ReqT, RespT> l(MethodDescriptor<ReqT, RespT> methodDescriptor, final IncomingStreamObserver<RespT> incomingStreamObserver) {
        final ClientCall[] clientCallArr = {null};
        final Task<ClientCall<ReqT, RespT>> i4 = this.f31100d.i(methodDescriptor);
        i4.addOnCompleteListener(this.f31097a.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.remote.m
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirestoreChannel.this.h(clientCallArr, incomingStreamObserver, task);
            }
        });
        return new ForwardingClientCall<ReqT, RespT>() { // from class: com.google.firebase.firestore.remote.FirestoreChannel.2
            @Override // io.grpc.ForwardingClientCall, io.grpc.b
            protected ClientCall<ReqT, RespT> a() {
                boolean z3;
                if (clientCallArr[0] != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assert.hardAssert(z3, "ClientCall used before onOpen() callback", new Object[0]);
                return clientCallArr[0];
            }

            @Override // io.grpc.ForwardingClientCall, io.grpc.b, io.grpc.ClientCall
            public void halfClose() {
                if (clientCallArr[0] == null) {
                    i4.addOnSuccessListener(FirestoreChannel.this.f31097a.getExecutor(), new OnSuccessListener() { // from class: com.google.firebase.firestore.remote.o
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            ((ClientCall) obj).halfClose();
                        }
                    });
                } else {
                    super.halfClose();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <ReqT, RespT> Task<RespT> m(MethodDescriptor<ReqT, RespT> methodDescriptor, final ReqT reqt) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f31100d.i(methodDescriptor).addOnCompleteListener(this.f31097a.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.remote.n
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirestoreChannel.this.i(taskCompletionSource, reqt, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <ReqT, RespT> void n(MethodDescriptor<ReqT, RespT> methodDescriptor, final ReqT reqt, final StreamingListener<RespT> streamingListener) {
        this.f31100d.i(methodDescriptor).addOnCompleteListener(this.f31097a.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.remote.l
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirestoreChannel.this.j(streamingListener, reqt, task);
            }
        });
    }

    public void shutdown() {
        this.f31100d.u();
    }

    /* loaded from: classes5.dex */
    public static abstract class StreamingListener<T> {
        public void onClose(Status status) {
        }

        public void onMessage(T t3) {
        }
    }
}
