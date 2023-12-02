package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class AbstractService implements Service {

    /* renamed from: h  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f28345h = new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.1
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.Listener listener) {
            listener.starting();
        }

        public String toString() {
            return "starting()";
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f28346i = new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.2
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Service.Listener listener) {
            listener.running();
        }

        public String toString() {
            return "running()";
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f28347j;

    /* renamed from: k  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f28348k;

    /* renamed from: l  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f28349l;

    /* renamed from: m  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f28350m;

    /* renamed from: n  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f28351n;

    /* renamed from: o  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f28352o;

    /* renamed from: a  reason: collision with root package name */
    private final Monitor f28353a = new Monitor();

    /* renamed from: b  reason: collision with root package name */
    private final Monitor.Guard f28354b = new IsStartableGuard();

    /* renamed from: c  reason: collision with root package name */
    private final Monitor.Guard f28355c = new IsStoppableGuard();

    /* renamed from: d  reason: collision with root package name */
    private final Monitor.Guard f28356d = new HasReachedRunningGuard();

    /* renamed from: e  reason: collision with root package name */
    private final Monitor.Guard f28357e = new IsStoppedGuard();

    /* renamed from: f  reason: collision with root package name */
    private final ListenerCallQueue<Service.Listener> f28358f = new ListenerCallQueue<>();

    /* renamed from: g  reason: collision with root package name */
    private volatile StateSnapshot f28359g = new StateSnapshot(Service.State.NEW);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.util.concurrent.AbstractService$6  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28364a;

        static {
            int[] iArr = new int[Service.State.values().length];
            f28364a = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28364a[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28364a[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28364a[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28364a[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28364a[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes5.dex */
    private final class HasReachedRunningGuard extends Monitor.Guard {
        HasReachedRunningGuard() {
            super(AbstractService.this.f28353a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (AbstractService.this.state().compareTo(Service.State.RUNNING) >= 0) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    private final class IsStartableGuard extends Monitor.Guard {
        IsStartableGuard() {
            super(AbstractService.this.f28353a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (AbstractService.this.state() == Service.State.NEW) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    private final class IsStoppableGuard extends Monitor.Guard {
        IsStoppableGuard() {
            super(AbstractService.this.f28353a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (AbstractService.this.state().compareTo(Service.State.RUNNING) <= 0) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    private final class IsStoppedGuard extends Monitor.Guard {
        IsStoppedGuard() {
            super(AbstractService.this.f28353a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (AbstractService.this.state().compareTo(Service.State.TERMINATED) >= 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class StateSnapshot {

        /* renamed from: a  reason: collision with root package name */
        final Service.State f28369a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f28370b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        final Throwable f28371c;

        StateSnapshot(Service.State state) {
            this(state, false, null);
        }

        Service.State a() {
            if (this.f28370b && this.f28369a == Service.State.STARTING) {
                return Service.State.STOPPING;
            }
            return this.f28369a;
        }

        Throwable b() {
            boolean z3;
            Service.State state = this.f28369a;
            if (state == Service.State.FAILED) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "failureCause() is only valid if the service has failed, service is %s", state);
            Throwable th = this.f28371c;
            Objects.requireNonNull(th);
            return th;
        }

        StateSnapshot(Service.State state, boolean z3, @CheckForNull Throwable th) {
            Preconditions.checkArgument(!z3 || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            Preconditions.checkArgument((th != null) == (state == Service.State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.f28369a = state;
            this.f28370b = z3;
            this.f28371c = th;
        }
    }

    static {
        Service.State state = Service.State.STARTING;
        f28347j = o(state);
        Service.State state2 = Service.State.RUNNING;
        f28348k = o(state2);
        f28349l = p(Service.State.NEW);
        f28350m = p(state);
        f28351n = p(state2);
        f28352o = p(Service.State.STOPPING);
    }

    @GuardedBy("monitor")
    private void b(Service.State state) {
        Service.State state2 = state();
        if (state2 != state) {
            if (state2 == Service.State.FAILED) {
                throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but the service has FAILED", failureCause());
            }
            throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but was " + state2);
        }
    }

    private void c() {
        if (!this.f28353a.isOccupiedByCurrentThread()) {
            this.f28358f.c();
        }
    }

    private void g(final Service.State state, final Throwable th) {
        this.f28358f.d(new ListenerCallQueue.Event<Service.Listener>(this) { // from class: com.google.common.util.concurrent.AbstractService.5
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            /* renamed from: a */
            public void call(Service.Listener listener) {
                listener.failed(state, th);
            }

            public String toString() {
                return "failed({from = " + state + ", cause = " + th + "})";
            }
        });
    }

    private void h() {
        this.f28358f.d(f28346i);
    }

    private void i() {
        this.f28358f.d(f28345h);
    }

    private void j(Service.State state) {
        if (state == Service.State.STARTING) {
            this.f28358f.d(f28347j);
        } else if (state == Service.State.RUNNING) {
            this.f28358f.d(f28348k);
        } else {
            throw new AssertionError();
        }
    }

    private void k(Service.State state) {
        switch (AnonymousClass6.f28364a[state.ordinal()]) {
            case 1:
                this.f28358f.d(f28349l);
                return;
            case 2:
                this.f28358f.d(f28350m);
                return;
            case 3:
                this.f28358f.d(f28351n);
                return;
            case 4:
                this.f28358f.d(f28352o);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    private static ListenerCallQueue.Event<Service.Listener> o(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.4
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            /* renamed from: a */
            public void call(Service.Listener listener) {
                listener.stopping(Service.State.this);
            }

            public String toString() {
                return "stopping({from = " + Service.State.this + "})";
            }
        };
    }

    private static ListenerCallQueue.Event<Service.Listener> p(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.3
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            /* renamed from: a */
            public void call(Service.Listener listener) {
                listener.terminated(Service.State.this);
            }

            public String toString() {
                return "terminated({from = " + Service.State.this + "})";
            }
        };
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.f28358f.b(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.f28353a.enterWhenUninterruptibly(this.f28356d);
        try {
            b(Service.State.RUNNING);
        } finally {
            this.f28353a.leave();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.f28353a.enterWhenUninterruptibly(this.f28357e);
        try {
            b(Service.State.TERMINATED);
        } finally {
            this.f28353a.leave();
        }
    }

    @ForOverride
    protected abstract void e();

    @ForOverride
    protected abstract void f();

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.f28359g.b();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        if (state() == Service.State.RUNNING) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(Throwable th) {
        Preconditions.checkNotNull(th);
        this.f28353a.enter();
        try {
            Service.State state = state();
            int i4 = AnonymousClass6.f28364a[state.ordinal()];
            if (i4 != 1) {
                if (i4 != 2 && i4 != 3 && i4 != 4) {
                    if (i4 != 5) {
                    }
                } else {
                    this.f28359g = new StateSnapshot(Service.State.FAILED, false, th);
                    g(state, th);
                }
                return;
            }
            throw new IllegalStateException("Failed while in state:" + state, th);
        } finally {
            this.f28353a.leave();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m() {
        this.f28353a.enter();
        try {
            if (this.f28359g.f28369a == Service.State.STARTING) {
                if (this.f28359g.f28370b) {
                    this.f28359g = new StateSnapshot(Service.State.STOPPING);
                    f();
                } else {
                    this.f28359g = new StateSnapshot(Service.State.RUNNING);
                    h();
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.f28359g.f28369a);
            l(illegalStateException);
            throw illegalStateException;
        } finally {
            this.f28353a.leave();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n() {
        this.f28353a.enter();
        try {
            Service.State state = state();
            switch (AnonymousClass6.f28364a[state.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    throw new IllegalStateException("Cannot notifyStopped() when the service is " + state);
                case 2:
                case 3:
                case 4:
                    this.f28359g = new StateSnapshot(Service.State.TERMINATED);
                    k(state);
                    break;
            }
        } finally {
            this.f28353a.leave();
            c();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        if (this.f28353a.enterIf(this.f28354b)) {
            try {
                this.f28359g = new StateSnapshot(Service.State.STARTING);
                i();
                e();
            } finally {
                try {
                    return this;
                } finally {
                }
            }
            return this;
        }
        throw new IllegalStateException("Service " + this + " has already been started");
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f28359g.a();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        if (this.f28353a.enterIf(this.f28355c)) {
            try {
                Service.State state = state();
                switch (AnonymousClass6.f28364a[state.ordinal()]) {
                    case 1:
                        this.f28359g = new StateSnapshot(Service.State.TERMINATED);
                        k(Service.State.NEW);
                        break;
                    case 2:
                        Service.State state2 = Service.State.STARTING;
                        this.f28359g = new StateSnapshot(state2, true, null);
                        j(state2);
                        d();
                        break;
                    case 3:
                        this.f28359g = new StateSnapshot(Service.State.STOPPING);
                        j(Service.State.RUNNING);
                        f();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        throw new AssertionError("isStoppable is incorrectly implemented, saw: " + state);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return this;
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j4, TimeUnit timeUnit) throws TimeoutException {
        if (this.f28353a.enterWhenUninterruptibly(this.f28356d, j4, timeUnit)) {
            try {
                b(Service.State.RUNNING);
                return;
            } finally {
                this.f28353a.leave();
            }
        }
        throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j4, TimeUnit timeUnit) throws TimeoutException {
        if (this.f28353a.enterWhenUninterruptibly(this.f28357e, j4, timeUnit)) {
            try {
                b(Service.State.TERMINATED);
                return;
            } finally {
                this.f28353a.leave();
            }
        }
        throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + state());
    }

    @ForOverride
    protected void d() {
    }
}
