package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.firestore.remote.AbstractStream;
import com.google.firebase.firestore.remote.Stream;
import com.google.firebase.firestore.remote.Stream.StreamCallback;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class AbstractStream<ReqT, RespT, CallbackT extends Stream.StreamCallback> implements Stream<CallbackT> {

    /* renamed from: n  reason: collision with root package name */
    private static final long f31022n;

    /* renamed from: o  reason: collision with root package name */
    private static final long f31023o;

    /* renamed from: p  reason: collision with root package name */
    private static final long f31024p;

    /* renamed from: q  reason: collision with root package name */
    private static final long f31025q;

    /* renamed from: r  reason: collision with root package name */
    private static final long f31026r;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private AsyncQueue.DelayedTask f31027a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private AsyncQueue.DelayedTask f31028b;

    /* renamed from: c  reason: collision with root package name */
    private final FirestoreChannel f31029c;

    /* renamed from: d  reason: collision with root package name */
    private final MethodDescriptor<ReqT, RespT> f31030d;

    /* renamed from: f  reason: collision with root package name */
    private final AsyncQueue f31032f;

    /* renamed from: g  reason: collision with root package name */
    private final AsyncQueue.TimerId f31033g;

    /* renamed from: h  reason: collision with root package name */
    private final AsyncQueue.TimerId f31034h;

    /* renamed from: k  reason: collision with root package name */
    private ClientCall<ReqT, RespT> f31037k;

    /* renamed from: l  reason: collision with root package name */
    final ExponentialBackoff f31038l;

    /* renamed from: m  reason: collision with root package name */
    final CallbackT f31039m;

    /* renamed from: i  reason: collision with root package name */
    private Stream.State f31035i = Stream.State.Initial;

    /* renamed from: j  reason: collision with root package name */
    private long f31036j = 0;

    /* renamed from: e  reason: collision with root package name */
    private final AbstractStream<ReqT, RespT, CallbackT>.IdleTimeoutRunnable f31031e = new IdleTimeoutRunnable();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class CloseGuardedRunner {

        /* renamed from: a  reason: collision with root package name */
        private final long f31040a;

        CloseGuardedRunner(long j4) {
            this.f31040a = j4;
        }

        void a(Runnable runnable) {
            AbstractStream.this.f31032f.verifyIsCurrentThread();
            if (AbstractStream.this.f31036j == this.f31040a) {
                runnable.run();
            } else {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    class IdleTimeoutRunnable implements Runnable {
        IdleTimeoutRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractStream.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class StreamObserver implements IncomingStreamObserver<RespT> {

        /* renamed from: a  reason: collision with root package name */
        private final AbstractStream<ReqT, RespT, CallbackT>.CloseGuardedRunner f31043a;

        StreamObserver(AbstractStream<ReqT, RespT, CallbackT>.CloseGuardedRunner closeGuardedRunner) {
            this.f31043a = closeGuardedRunner;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Status status) {
            if (status.isOk()) {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream closed.", Integer.valueOf(System.identityHashCode(AbstractStream.this)));
            } else {
                Logger.warn(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", Integer.valueOf(System.identityHashCode(AbstractStream.this)), status);
            }
            AbstractStream.this.k(status);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Metadata metadata) {
            if (Logger.isDebugEnabled()) {
                HashMap hashMap = new HashMap();
                for (String str : metadata.keys()) {
                    if (Datastore.f31071e.contains(str.toLowerCase(Locale.ENGLISH))) {
                        hashMap.put(str, (String) metadata.get(Metadata.Key.of(str, Metadata.ASCII_STRING_MARSHALLER)));
                    }
                }
                if (!hashMap.isEmpty()) {
                    Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(AbstractStream.this)), hashMap);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(Object obj) {
            if (Logger.isDebugEnabled()) {
                Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream received: %s", Integer.valueOf(System.identityHashCode(AbstractStream.this)), obj);
            }
            AbstractStream.this.onNext(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            Logger.debug(AbstractStream.this.getClass().getSimpleName(), "(%x) Stream is open", Integer.valueOf(System.identityHashCode(AbstractStream.this)));
            AbstractStream.this.o();
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void a(final Metadata metadata) {
            this.f31043a.a(new Runnable() { // from class: com.google.firebase.firestore.remote.e
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.StreamObserver.this.g(metadata);
                }
            });
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onClose(final Status status) {
            this.f31043a.a(new Runnable() { // from class: com.google.firebase.firestore.remote.c
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.StreamObserver.this.f(status);
                }
            });
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onNext(final RespT respt) {
            this.f31043a.a(new Runnable() { // from class: com.google.firebase.firestore.remote.d
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.StreamObserver.this.h(respt);
                }
            });
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onOpen() {
            this.f31043a.a(new Runnable() { // from class: com.google.firebase.firestore.remote.f
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.StreamObserver.this.i();
                }
            });
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f31022n = timeUnit.toMillis(1L);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        f31023o = timeUnit2.toMillis(1L);
        f31024p = timeUnit2.toMillis(1L);
        f31025q = timeUnit.toMillis(10L);
        f31026r = timeUnit.toMillis(10L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractStream(FirestoreChannel firestoreChannel, MethodDescriptor<ReqT, RespT> methodDescriptor, AsyncQueue asyncQueue, AsyncQueue.TimerId timerId, AsyncQueue.TimerId timerId2, AsyncQueue.TimerId timerId3, CallbackT callbackt) {
        this.f31029c = firestoreChannel;
        this.f31030d = methodDescriptor;
        this.f31032f = asyncQueue;
        this.f31033g = timerId2;
        this.f31034h = timerId3;
        this.f31039m = callbackt;
        this.f31038l = new ExponentialBackoff(asyncQueue, timerId, f31022n, 1.5d, f31023o);
    }

    private void g() {
        AsyncQueue.DelayedTask delayedTask = this.f31027a;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.f31027a = null;
        }
    }

    private void h() {
        AsyncQueue.DelayedTask delayedTask = this.f31028b;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.f31028b = null;
        }
    }

    private void i(Stream.State state, Status status) {
        boolean z3;
        Assert.hardAssert(isStarted(), "Only started streams should be closed.", new Object[0]);
        Stream.State state2 = Stream.State.Error;
        if (state != state2 && !status.isOk()) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assert.hardAssert(z3, "Can't provide an error when not in an error state.", new Object[0]);
        this.f31032f.verifyIsCurrentThread();
        if (Datastore.isMissingSslCiphers(status)) {
            Util.crashMainThread(new IllegalStateException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", status.getCause()));
        }
        h();
        g();
        this.f31038l.cancel();
        this.f31036j++;
        Status.Code code = status.getCode();
        if (code == Status.Code.OK) {
            this.f31038l.reset();
        } else if (code == Status.Code.RESOURCE_EXHAUSTED) {
            Logger.debug(getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", Integer.valueOf(System.identityHashCode(this)));
            this.f31038l.resetToMax();
        } else if (code == Status.Code.UNAUTHENTICATED && this.f31035i != Stream.State.Healthy) {
            this.f31029c.invalidateToken();
        } else if (code == Status.Code.UNAVAILABLE && ((status.getCause() instanceof UnknownHostException) || (status.getCause() instanceof ConnectException))) {
            this.f31038l.setTemporaryMaxDelay(f31026r);
        }
        if (state != state2) {
            Logger.debug(getClass().getSimpleName(), "(%x) Performing stream teardown", Integer.valueOf(System.identityHashCode(this)));
            q();
        }
        if (this.f31037k != null) {
            if (status.isOk()) {
                Logger.debug(getClass().getSimpleName(), "(%x) Closing stream client-side", Integer.valueOf(System.identityHashCode(this)));
                this.f31037k.halfClose();
            }
            this.f31037k = null;
        }
        this.f31035i = state;
        this.f31039m.onClose(status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (isOpen()) {
            i(Stream.State.Initial, Status.OK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        if (isOpen()) {
            this.f31035i = Stream.State.Healthy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        boolean z3;
        Stream.State state = this.f31035i;
        if (state == Stream.State.Backoff) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "State should still be backoff but was %s", state);
        this.f31035i = Stream.State.Initial;
        start();
        Assert.hardAssert(isStarted(), "Stream should have started", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.f31035i = Stream.State.Open;
        this.f31039m.onOpen();
        if (this.f31027a == null) {
            this.f31027a = this.f31032f.enqueueAfterDelay(this.f31034h, f31025q, new Runnable() { // from class: com.google.firebase.firestore.remote.b
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractStream.this.l();
                }
            });
        }
    }

    private void p() {
        boolean z3;
        if (this.f31035i == Stream.State.Error) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Should only perform backoff in an error state", new Object[0]);
        this.f31035i = Stream.State.Backoff;
        this.f31038l.backoffAndRun(new Runnable() { // from class: com.google.firebase.firestore.remote.a
            @Override // java.lang.Runnable
            public final void run() {
                AbstractStream.this.m();
            }
        });
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void inhibitBackoff() {
        Assert.hardAssert(!isStarted(), "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.f31032f.verifyIsCurrentThread();
        this.f31035i = Stream.State.Initial;
        this.f31038l.reset();
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public boolean isOpen() {
        this.f31032f.verifyIsCurrentThread();
        Stream.State state = this.f31035i;
        if (state != Stream.State.Open && state != Stream.State.Healthy) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public boolean isStarted() {
        this.f31032f.verifyIsCurrentThread();
        Stream.State state = this.f31035i;
        if (state != Stream.State.Starting && state != Stream.State.Backoff && !isOpen()) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    void k(Status status) {
        Assert.hardAssert(isStarted(), "Can't handle server close on non-started stream!", new Object[0]);
        i(Stream.State.Error, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        if (isOpen() && this.f31028b == null) {
            this.f31028b = this.f31032f.enqueueAfterDelay(this.f31033g, f31024p, this.f31031e);
        }
    }

    public abstract void onNext(RespT respt);

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(ReqT reqt) {
        this.f31032f.verifyIsCurrentThread();
        Logger.debug(getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), reqt);
        h();
        this.f31037k.sendMessage(reqt);
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void start() {
        boolean z3;
        boolean z4;
        this.f31032f.verifyIsCurrentThread();
        boolean z5 = true;
        if (this.f31037k == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Last call still set", new Object[0]);
        if (this.f31028b == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assert.hardAssert(z4, "Idle timer still set", new Object[0]);
        Stream.State state = this.f31035i;
        if (state == Stream.State.Error) {
            p();
            return;
        }
        if (state != Stream.State.Initial) {
            z5 = false;
        }
        Assert.hardAssert(z5, "Already started", new Object[0]);
        this.f31037k = this.f31029c.l(this.f31030d, new StreamObserver(new CloseGuardedRunner(this.f31036j)));
        this.f31035i = Stream.State.Starting;
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void stop() {
        if (isStarted()) {
            i(Stream.State.Initial, Status.OK);
        }
    }

    protected void q() {
    }
}
