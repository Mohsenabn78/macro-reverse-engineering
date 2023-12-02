package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import com.google.firestore.v1.FirestoreGrpc;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.android.AndroidChannelBuilder;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class GrpcCallProvider {

    /* renamed from: h  reason: collision with root package name */
    private static Supplier<ManagedChannelBuilder<?>> f31114h;

    /* renamed from: a  reason: collision with root package name */
    private Task<ManagedChannel> f31115a;

    /* renamed from: b  reason: collision with root package name */
    private final AsyncQueue f31116b;

    /* renamed from: c  reason: collision with root package name */
    private CallOptions f31117c;

    /* renamed from: d  reason: collision with root package name */
    private AsyncQueue.DelayedTask f31118d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f31119e;

    /* renamed from: f  reason: collision with root package name */
    private final DatabaseInfo f31120f;

    /* renamed from: g  reason: collision with root package name */
    private final CallCredentials f31121g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GrpcCallProvider(AsyncQueue asyncQueue, Context context, DatabaseInfo databaseInfo, CallCredentials callCredentials) {
        this.f31116b = asyncQueue;
        this.f31119e = context;
        this.f31120f = databaseInfo;
        this.f31121g = callCredentials;
        k();
    }

    private void h() {
        if (this.f31118d != null) {
            Logger.debug("GrpcCallProvider", "Clearing the connectivityAttemptTimer", new Object[0]);
            this.f31118d.cancel();
            this.f31118d = null;
        }
    }

    private ManagedChannel j(Context context, DatabaseInfo databaseInfo) {
        ManagedChannelBuilder<?> managedChannelBuilder;
        try {
            ProviderInstaller.installIfNeeded(context);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IllegalStateException e4) {
            Logger.warn("GrpcCallProvider", "Failed to update ssl context: %s", e4);
        }
        Supplier<ManagedChannelBuilder<?>> supplier = f31114h;
        if (supplier != null) {
            managedChannelBuilder = supplier.get();
        } else {
            ManagedChannelBuilder<?> forTarget = ManagedChannelBuilder.forTarget(databaseInfo.getHost());
            if (!databaseInfo.isSslEnabled()) {
                forTarget.usePlaintext();
            }
            managedChannelBuilder = forTarget;
        }
        managedChannelBuilder.keepAliveTime(30L, TimeUnit.SECONDS);
        return AndroidChannelBuilder.usingBuilder(managedChannelBuilder).context(context).build();
    }

    private void k() {
        this.f31115a = Tasks.call(Executors.BACKGROUND_EXECUTOR, new Callable() { // from class: com.google.firebase.firestore.remote.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ManagedChannel n4;
                n4 = GrpcCallProvider.this.n();
                return n4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task l(MethodDescriptor methodDescriptor, Task task) throws Exception {
        return Tasks.forResult(((ManagedChannel) task.getResult()).newCall(methodDescriptor, this.f31117c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ManagedChannel n() throws Exception {
        final ManagedChannel j4 = j(this.f31119e, this.f31120f);
        this.f31116b.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.remote.q
            @Override // java.lang.Runnable
            public final void run() {
                GrpcCallProvider.this.m(j4);
            }
        });
        this.f31117c = ((FirestoreGrpc.FirestoreStub) ((FirestoreGrpc.FirestoreStub) FirestoreGrpc.newStub(j4).withCallCredentials(this.f31121g)).withExecutor(this.f31116b.getExecutor())).getCallOptions();
        Logger.debug("GrpcCallProvider", "Channel successfully reset.", new Object[0]);
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(ManagedChannel managedChannel) {
        Logger.debug("GrpcCallProvider", "connectivityAttemptTimer elapsed. Resetting the channel.", new Object[0]);
        h();
        t(managedChannel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(final ManagedChannel managedChannel) {
        this.f31116b.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.remote.v
            @Override // java.lang.Runnable
            public final void run() {
                GrpcCallProvider.this.p(managedChannel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(ManagedChannel managedChannel) {
        managedChannel.shutdownNow();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void p(final ManagedChannel managedChannel) {
        ConnectivityState state = managedChannel.getState(true);
        Logger.debug("GrpcCallProvider", "Current gRPC connectivity state: " + state, new Object[0]);
        h();
        if (state == ConnectivityState.CONNECTING) {
            Logger.debug("GrpcCallProvider", "Setting the connectivityAttemptTimer", new Object[0]);
            this.f31118d = this.f31116b.enqueueAfterDelay(AsyncQueue.TimerId.CONNECTIVITY_ATTEMPT_TIMER, 15000L, new Runnable() { // from class: com.google.firebase.firestore.remote.s
                @Override // java.lang.Runnable
                public final void run() {
                    GrpcCallProvider.this.o(managedChannel);
                }
            });
        }
        managedChannel.notifyWhenStateChanged(state, new Runnable() { // from class: com.google.firebase.firestore.remote.t
            @Override // java.lang.Runnable
            public final void run() {
                GrpcCallProvider.this.q(managedChannel);
            }
        });
    }

    private void t(final ManagedChannel managedChannel) {
        this.f31116b.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.remote.u
            @Override // java.lang.Runnable
            public final void run() {
                GrpcCallProvider.this.r(managedChannel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <ReqT, RespT> Task<ClientCall<ReqT, RespT>> i(final MethodDescriptor<ReqT, RespT> methodDescriptor) {
        return (Task<ClientCall<ReqT, RespT>>) this.f31115a.continueWithTask(this.f31116b.getExecutor(), new Continuation() { // from class: com.google.firebase.firestore.remote.r
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task l4;
                l4 = GrpcCallProvider.this.l(methodDescriptor, task);
                return l4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        try {
            ManagedChannel managedChannel = (ManagedChannel) Tasks.await(this.f31115a);
            managedChannel.shutdown();
            try {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (!managedChannel.awaitTermination(1L, timeUnit)) {
                    Logger.debug(FirestoreChannel.class.getSimpleName(), "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.", new Object[0]);
                    managedChannel.shutdownNow();
                    if (!managedChannel.awaitTermination(60L, timeUnit)) {
                        Logger.warn(FirestoreChannel.class.getSimpleName(), "Unable to forcefully shutdown the gRPC ManagedChannel.", new Object[0]);
                    }
                }
            } catch (InterruptedException unused) {
                managedChannel.shutdownNow();
                Logger.warn(FirestoreChannel.class.getSimpleName(), "Interrupted while shutting down the gRPC Managed Channel", new Object[0]);
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused2) {
            Logger.warn(FirestoreChannel.class.getSimpleName(), "Interrupted while retrieving the gRPC Managed Channel", new Object[0]);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e4) {
            Logger.warn(FirestoreChannel.class.getSimpleName(), "Channel is not initialized, shutdown will just do nothing. Channel initializing run into exception: %s", e4);
        }
    }
}
