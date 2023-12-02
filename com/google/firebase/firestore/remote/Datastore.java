package com.google.firebase.firestore.remote;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.FirestoreChannel;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Util;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.FirestoreGrpc;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.StructuredAggregationQuery;
import com.google.firestore.v1.Target;
import com.google.firestore.v1.Value;
import com.sun.mail.imap.IMAPStore;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;

/* loaded from: classes5.dex */
public class Datastore {

    /* renamed from: e  reason: collision with root package name */
    static final Set<String> f31071e = new HashSet(Arrays.asList(IMAPStore.ID_DATE, "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace"));

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseInfo f31072a;

    /* renamed from: b  reason: collision with root package name */
    private final RemoteSerializer f31073b;

    /* renamed from: c  reason: collision with root package name */
    private final AsyncQueue f31074c;

    /* renamed from: d  reason: collision with root package name */
    private final FirestoreChannel f31075d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.remote.Datastore$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31080a;

        static {
            int[] iArr = new int[FirebaseFirestoreException.Code.values().length];
            f31080a = iArr;
            try {
                iArr[FirebaseFirestoreException.Code.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.DEADLINE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.RESOURCE_EXHAUSTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.INTERNAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.UNAVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.UNAUTHENTICATED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.INVALID_ARGUMENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.NOT_FOUND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.ALREADY_EXISTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.PERMISSION_DENIED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.FAILED_PRECONDITION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.ABORTED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.OUT_OF_RANGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.UNIMPLEMENTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f31080a[FirebaseFirestoreException.Code.DATA_LOSS.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public Datastore(DatabaseInfo databaseInfo, AsyncQueue asyncQueue, CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2, Context context, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        this.f31072a = databaseInfo;
        this.f31074c = asyncQueue;
        this.f31073b = new RemoteSerializer(databaseInfo.getDatabaseId());
        this.f31075d = h(databaseInfo, asyncQueue, credentialsProvider, credentialsProvider2, context, grpcMetadataProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List i(Task task) throws Exception {
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof FirebaseFirestoreException) && ((FirebaseFirestoreException) task.getException()).getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
                this.f31075d.invalidateToken();
            }
            throw task.getException();
        }
        CommitResponse commitResponse = (CommitResponse) task.getResult();
        SnapshotVersion decodeVersion = this.f31073b.decodeVersion(commitResponse.getCommitTime());
        int writeResultsCount = commitResponse.getWriteResultsCount();
        ArrayList arrayList = new ArrayList(writeResultsCount);
        for (int i4 = 0; i4 < writeResultsCount; i4++) {
            arrayList.add(this.f31073b.decodeMutationResult(commitResponse.getWriteResults(i4), decodeVersion));
        }
        return arrayList;
    }

    public static boolean isMissingSslCiphers(Status status) {
        status.getCode();
        Throwable cause = status.getCause();
        if (cause instanceof SSLHandshakeException) {
            cause.getMessage().contains("no ciphers available");
            return false;
        }
        return false;
    }

    public static boolean isPermanentError(Status status) {
        return isPermanentError(FirebaseFirestoreException.Code.fromValue(status.getCode().value()));
    }

    public static boolean isPermanentWriteError(Status status) {
        if (isPermanentError(status) && !status.getCode().equals(Status.Code.ABORTED)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map j(HashMap hashMap, Task task) throws Exception {
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof FirebaseFirestoreException) && ((FirebaseFirestoreException) task.getException()).getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
                this.f31075d.invalidateToken();
            }
            throw task.getException();
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, Value> entry : ((RunAggregationQueryResponse) task.getResult()).getResult().getAggregateFieldsMap().entrySet()) {
            Assert.hardAssert(hashMap.containsKey(entry.getKey()), "%s not present in aliasMap", entry.getKey());
            hashMap2.put((String) hashMap.get(entry.getKey()), entry.getValue());
        }
        return hashMap2;
    }

    public Task<List<MutationResult>> commit(List<Mutation> list) {
        CommitRequest.Builder newBuilder = CommitRequest.newBuilder();
        newBuilder.setDatabase(this.f31073b.databaseName());
        for (Mutation mutation : list) {
            newBuilder.addWrites(this.f31073b.encodeMutation(mutation));
        }
        return this.f31075d.m(FirestoreGrpc.getCommitMethod(), newBuilder.build()).continueWith(this.f31074c.getExecutor(), new Continuation() { // from class: com.google.firebase.firestore.remote.j
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                List i4;
                i4 = Datastore.this.i(task);
                return i4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WatchStream e(WatchStream.Callback callback) {
        return new WatchStream(this.f31075d, this.f31074c, this.f31073b, callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteStream f(WriteStream.Callback callback) {
        return new WriteStream(this.f31075d, this.f31074c, this.f31073b, callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DatabaseInfo g() {
        return this.f31072a;
    }

    FirestoreChannel h(DatabaseInfo databaseInfo, AsyncQueue asyncQueue, CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2, Context context, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        return new FirestoreChannel(asyncQueue, context, credentialsProvider, credentialsProvider2, databaseInfo, grpcMetadataProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        this.f31075d.shutdown();
    }

    public Task<List<MutableDocument>> lookup(final List<DocumentKey> list) {
        BatchGetDocumentsRequest.Builder newBuilder = BatchGetDocumentsRequest.newBuilder();
        newBuilder.setDatabase(this.f31073b.databaseName());
        for (DocumentKey documentKey : list) {
            newBuilder.addDocuments(this.f31073b.encodeKey(documentKey));
        }
        final ArrayList arrayList = new ArrayList();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f31075d.n(FirestoreGrpc.getBatchGetDocumentsMethod(), newBuilder.build(), new FirestoreChannel.StreamingListener<BatchGetDocumentsResponse>() { // from class: com.google.firebase.firestore.remote.Datastore.1
            @Override // com.google.firebase.firestore.remote.FirestoreChannel.StreamingListener
            /* renamed from: a */
            public void onMessage(BatchGetDocumentsResponse batchGetDocumentsResponse) {
                arrayList.add(batchGetDocumentsResponse);
                if (arrayList.size() == list.size()) {
                    HashMap hashMap = new HashMap();
                    for (BatchGetDocumentsResponse batchGetDocumentsResponse2 : arrayList) {
                        MutableDocument decodeMaybeDocument = Datastore.this.f31073b.decodeMaybeDocument(batchGetDocumentsResponse2);
                        hashMap.put(decodeMaybeDocument.getKey(), decodeMaybeDocument);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (DocumentKey documentKey2 : list) {
                        arrayList2.add((MutableDocument) hashMap.get(documentKey2));
                    }
                    taskCompletionSource.trySetResult(arrayList2);
                }
            }

            @Override // com.google.firebase.firestore.remote.FirestoreChannel.StreamingListener
            public void onClose(Status status) {
                if (status.isOk()) {
                    taskCompletionSource.trySetResult(Collections.emptyList());
                    return;
                }
                FirebaseFirestoreException exceptionFromStatus = Util.exceptionFromStatus(status);
                if (exceptionFromStatus.getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
                    Datastore.this.f31075d.invalidateToken();
                }
                taskCompletionSource.trySetException(exceptionFromStatus);
            }
        });
        return taskCompletionSource.getTask();
    }

    public Task<Map<String, Value>> runAggregateQuery(Query query, List<AggregateField> list) {
        Target.QueryTarget encodeQueryTarget = this.f31073b.encodeQueryTarget(query.toTarget());
        final HashMap<String, String> hashMap = new HashMap<>();
        StructuredAggregationQuery C = this.f31073b.C(encodeQueryTarget, list, hashMap);
        RunAggregationQueryRequest.Builder newBuilder = RunAggregationQueryRequest.newBuilder();
        newBuilder.setParent(encodeQueryTarget.getParent());
        newBuilder.setStructuredAggregationQuery(C);
        return this.f31075d.m(FirestoreGrpc.getRunAggregationQueryMethod(), newBuilder.build()).continueWith(this.f31074c.getExecutor(), new Continuation() { // from class: com.google.firebase.firestore.remote.i
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Map j4;
                j4 = Datastore.this.j(hashMap, task);
                return j4;
            }
        });
    }

    public static boolean isPermanentError(FirebaseFirestoreException.Code code) {
        switch (AnonymousClass2.f31080a[code.ordinal()]) {
            case 1:
                throw new IllegalArgumentException("Treated status OK as error");
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                throw new IllegalArgumentException("Unknown gRPC status code: " + code);
        }
    }
}
