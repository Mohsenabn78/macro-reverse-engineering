package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public final class ServiceManager implements ServiceManagerBridge {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f28581c = Logger.getLogger(ServiceManager.class.getName());

    /* renamed from: d  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Listener> f28582d = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.1
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Listener listener) {
            listener.healthy();
        }

        public String toString() {
            return "healthy()";
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Listener> f28583e = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.2
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        /* renamed from: a */
        public void call(Listener listener) {
            listener.stopped();
        }

        public String toString() {
            return "stopped()";
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final ServiceManagerState f28584a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<Service> f28585b;

    /* loaded from: classes5.dex */
    private static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void e() {
            m();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void f() {
            n();
        }
    }

    /* loaded from: classes5.dex */
    private static final class ServiceListener extends Service.Listener {

        /* renamed from: a  reason: collision with root package name */
        final Service f28586a;

        /* renamed from: b  reason: collision with root package name */
        final WeakReference<ServiceManagerState> f28587b;

        ServiceListener(Service service, WeakReference<ServiceManagerState> weakReference) {
            this.f28586a = service;
            this.f28587b = weakReference;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State state, Throwable th) {
            ServiceManagerState serviceManagerState = this.f28587b.get();
            if (serviceManagerState != null) {
                if (!(this.f28586a instanceof NoOpService)) {
                    Logger logger = ServiceManager.f28581c;
                    Level level = Level.SEVERE;
                    logger.log(level, "Service " + this.f28586a + " has failed in the " + state + " state.", th);
                }
                serviceManagerState.n(this.f28586a, state, Service.State.FAILED);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            ServiceManagerState serviceManagerState = this.f28587b.get();
            if (serviceManagerState != null) {
                serviceManagerState.n(this.f28586a, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            ServiceManagerState serviceManagerState = this.f28587b.get();
            if (serviceManagerState != null) {
                serviceManagerState.n(this.f28586a, Service.State.NEW, Service.State.STARTING);
                if (!(this.f28586a instanceof NoOpService)) {
                    ServiceManager.f28581c.log(Level.FINE, "Starting {0}.", this.f28586a);
                }
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(Service.State state) {
            ServiceManagerState serviceManagerState = this.f28587b.get();
            if (serviceManagerState != null) {
                serviceManagerState.n(this.f28586a, state, Service.State.STOPPING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State state) {
            ServiceManagerState serviceManagerState = this.f28587b.get();
            if (serviceManagerState != null) {
                if (!(this.f28586a instanceof NoOpService)) {
                    ServiceManager.f28581c.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.f28586a, state});
                }
                serviceManagerState.n(this.f28586a, state, Service.State.TERMINATED);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ServiceManagerState {

        /* renamed from: a  reason: collision with root package name */
        final Monitor f28588a = new Monitor();
        @GuardedBy("monitor")

        /* renamed from: b  reason: collision with root package name */
        final SetMultimap<Service.State, Service> f28589b;
        @GuardedBy("monitor")

        /* renamed from: c  reason: collision with root package name */
        final Multiset<Service.State> f28590c;
        @GuardedBy("monitor")

        /* renamed from: d  reason: collision with root package name */
        final Map<Service, Stopwatch> f28591d;
        @GuardedBy("monitor")

        /* renamed from: e  reason: collision with root package name */
        boolean f28592e;
        @GuardedBy("monitor")

        /* renamed from: f  reason: collision with root package name */
        boolean f28593f;

        /* renamed from: g  reason: collision with root package name */
        final int f28594g;

        /* renamed from: h  reason: collision with root package name */
        final Monitor.Guard f28595h;

        /* renamed from: i  reason: collision with root package name */
        final Monitor.Guard f28596i;

        /* renamed from: j  reason: collision with root package name */
        final ListenerCallQueue<Listener> f28597j;

        /* loaded from: classes5.dex */
        final class AwaitHealthGuard extends Monitor.Guard {
            AwaitHealthGuard() {
                super(ServiceManagerState.this.f28588a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                int count = ServiceManagerState.this.f28590c.count(Service.State.RUNNING);
                ServiceManagerState serviceManagerState = ServiceManagerState.this;
                if (count != serviceManagerState.f28594g && !serviceManagerState.f28590c.contains(Service.State.STOPPING) && !ServiceManagerState.this.f28590c.contains(Service.State.TERMINATED) && !ServiceManagerState.this.f28590c.contains(Service.State.FAILED)) {
                    return false;
                }
                return true;
            }
        }

        /* loaded from: classes5.dex */
        final class StoppedGuard extends Monitor.Guard {
            StoppedGuard() {
                super(ServiceManagerState.this.f28588a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                if (ServiceManagerState.this.f28590c.count(Service.State.TERMINATED) + ServiceManagerState.this.f28590c.count(Service.State.FAILED) == ServiceManagerState.this.f28594g) {
                    return true;
                }
                return false;
            }
        }

        ServiceManagerState(ImmutableCollection<Service> immutableCollection) {
            SetMultimap<Service.State, Service> build = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
            this.f28589b = build;
            this.f28590c = build.keys();
            this.f28591d = Maps.newIdentityHashMap();
            this.f28595h = new AwaitHealthGuard();
            this.f28596i = new StoppedGuard();
            this.f28597j = new ListenerCallQueue<>();
            this.f28594g = immutableCollection.size();
            build.putAll(Service.State.NEW, immutableCollection);
        }

        void a(Listener listener, Executor executor) {
            this.f28597j.b(listener, executor);
        }

        void b() {
            this.f28588a.enterWhenUninterruptibly(this.f28595h);
            try {
                f();
            } finally {
                this.f28588a.leave();
            }
        }

        void c(long j4, TimeUnit timeUnit) throws TimeoutException {
            this.f28588a.enter();
            try {
                if (this.f28588a.waitForUninterruptibly(this.f28595h, j4, timeUnit)) {
                    f();
                    return;
                }
                throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.filterKeys((SetMultimap) this.f28589b, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
            } finally {
                this.f28588a.leave();
            }
        }

        void d() {
            this.f28588a.enterWhenUninterruptibly(this.f28596i);
            this.f28588a.leave();
        }

        void e(long j4, TimeUnit timeUnit) throws TimeoutException {
            this.f28588a.enter();
            try {
                if (this.f28588a.waitForUninterruptibly(this.f28596i, j4, timeUnit)) {
                    return;
                }
                throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.filterKeys((SetMultimap) this.f28589b, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
            } finally {
                this.f28588a.leave();
            }
        }

        @GuardedBy("monitor")
        void f() {
            Multiset<Service.State> multiset = this.f28590c;
            Service.State state = Service.State.RUNNING;
            if (multiset.count(state) == this.f28594g) {
                return;
            }
            throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.filterKeys((SetMultimap) this.f28589b, Predicates.not(Predicates.equalTo(state))));
        }

        void g() {
            Preconditions.checkState(!this.f28588a.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.f28597j.c();
        }

        void h(final Service service) {
            this.f28597j.d(new ListenerCallQueue.Event<Listener>(this) { // from class: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.2
                @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
                /* renamed from: a */
                public void call(Listener listener) {
                    listener.failure(service);
                }

                public String toString() {
                    return "failed({service=" + service + "})";
                }
            });
        }

        void i() {
            this.f28597j.d(ServiceManager.f28582d);
        }

        void j() {
            this.f28597j.d(ServiceManager.f28583e);
        }

        void k() {
            this.f28588a.enter();
            try {
                if (!this.f28593f) {
                    this.f28592e = true;
                    return;
                }
                ArrayList newArrayList = Lists.newArrayList();
                UnmodifiableIterator<Service> it = l().values().iterator();
                while (it.hasNext()) {
                    Service next = it.next();
                    if (next.state() != Service.State.NEW) {
                        newArrayList.add(next);
                    }
                }
                throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + newArrayList);
            } finally {
                this.f28588a.leave();
            }
        }

        ImmutableSetMultimap<Service.State, Service> l() {
            ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
            this.f28588a.enter();
            try {
                for (Map.Entry<Service.State, Service> entry : this.f28589b.entries()) {
                    if (!(entry.getValue() instanceof NoOpService)) {
                        builder.put((Map.Entry) entry);
                    }
                }
                this.f28588a.leave();
                return builder.build();
            } catch (Throwable th) {
                this.f28588a.leave();
                throw th;
            }
        }

        ImmutableMap<Service, Long> m() {
            this.f28588a.enter();
            try {
                ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(this.f28591d.size());
                for (Map.Entry<Service, Stopwatch> entry : this.f28591d.entrySet()) {
                    Service key = entry.getKey();
                    Stopwatch value = entry.getValue();
                    if (!value.isRunning() && !(key instanceof NoOpService)) {
                        newArrayListWithCapacity.add(Maps.immutableEntry(key, Long.valueOf(value.elapsed(TimeUnit.MILLISECONDS))));
                    }
                }
                this.f28588a.leave();
                Collections.sort(newArrayListWithCapacity, Ordering.natural().onResultOf(new Function<Map.Entry<Service, Long>, Long>(this) { // from class: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.1
                    @Override // com.google.common.base.Function
                    /* renamed from: a */
                    public Long apply(Map.Entry<Service, Long> entry2) {
                        return entry2.getValue();
                    }
                }));
                return ImmutableMap.copyOf(newArrayListWithCapacity);
            } catch (Throwable th) {
                this.f28588a.leave();
                throw th;
            }
        }

        void n(Service service, Service.State state, Service.State state2) {
            boolean z3;
            Preconditions.checkNotNull(service);
            if (state != state2) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.f28588a.enter();
            try {
                this.f28593f = true;
                if (!this.f28592e) {
                    return;
                }
                Preconditions.checkState(this.f28589b.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                Preconditions.checkState(this.f28589b.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                Stopwatch stopwatch = this.f28591d.get(service);
                if (stopwatch == null) {
                    stopwatch = Stopwatch.createStarted();
                    this.f28591d.put(service, stopwatch);
                }
                Service.State state3 = Service.State.RUNNING;
                if (state2.compareTo(state3) >= 0 && stopwatch.isRunning()) {
                    stopwatch.stop();
                    if (!(service instanceof NoOpService)) {
                        ServiceManager.f28581c.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatch});
                    }
                }
                Service.State state4 = Service.State.FAILED;
                if (state2 == state4) {
                    h(service);
                }
                if (this.f28590c.count(state3) == this.f28594g) {
                    i();
                } else if (this.f28590c.count(Service.State.TERMINATED) + this.f28590c.count(state4) == this.f28594g) {
                    j();
                }
            } finally {
                this.f28588a.leave();
                g();
            }
        }

        void o(Service service) {
            this.f28588a.enter();
            try {
                if (this.f28591d.get(service) == null) {
                    this.f28591d.put(service, Stopwatch.createStarted());
                }
            } finally {
                this.f28588a.leave();
            }
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        boolean z3;
        ImmutableList<Service> copyOf = ImmutableList.copyOf(iterable);
        if (copyOf.isEmpty()) {
            f28581c.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new EmptyServiceManagerWarning());
            copyOf = ImmutableList.of(new NoOpService());
        }
        ServiceManagerState serviceManagerState = new ServiceManagerState(copyOf);
        this.f28584a = serviceManagerState;
        this.f28585b = copyOf;
        WeakReference weakReference = new WeakReference(serviceManagerState);
        UnmodifiableIterator<Service> it = copyOf.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            next.addListener(new ServiceListener(next, weakReference), MoreExecutors.directExecutor());
            if (next.state() == Service.State.NEW) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Can only manage NEW services, %s", next);
        }
        this.f28584a.k();
    }

    public void addListener(Listener listener, Executor executor) {
        this.f28584a.a(listener, executor);
    }

    public void awaitHealthy() {
        this.f28584a.b();
    }

    public void awaitStopped() {
        this.f28584a.d();
    }

    public boolean isHealthy() {
        UnmodifiableIterator<Service> it = this.f28585b.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    @CanIgnoreReturnValue
    public ServiceManager startAsync() {
        boolean z3;
        UnmodifiableIterator<Service> it = this.f28585b.iterator();
        while (it.hasNext()) {
            if (it.next().state() == Service.State.NEW) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Not all services are NEW, cannot start %s", this);
        }
        UnmodifiableIterator<Service> it2 = this.f28585b.iterator();
        while (it2.hasNext()) {
            Service next = it2.next();
            try {
                this.f28584a.o(next);
                next.startAsync();
            } catch (IllegalStateException e4) {
                Logger logger = f28581c;
                Level level = Level.WARNING;
                logger.log(level, "Unable to start Service " + next, (Throwable) e4);
            }
        }
        return this;
    }

    public ImmutableMap<Service, Long> startupTimes() {
        return this.f28584a.m();
    }

    @CanIgnoreReturnValue
    public ServiceManager stopAsync() {
        UnmodifiableIterator<Service> it = this.f28585b.iterator();
        while (it.hasNext()) {
            it.next().stopAsync();
        }
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Class<?>) ServiceManager.class).add("services", Collections2.filter(this.f28585b, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
    }

    public void awaitHealthy(long j4, TimeUnit timeUnit) throws TimeoutException {
        this.f28584a.c(j4, timeUnit);
    }

    public void awaitStopped(long j4, TimeUnit timeUnit) throws TimeoutException {
        this.f28584a.e(j4, timeUnit);
    }

    public ImmutableSetMultimap<Service.State, Service> servicesByState() {
        return this.f28584a.l();
    }

    /* loaded from: classes5.dex */
    public static abstract class Listener {
        public void healthy() {
        }

        public void stopped() {
        }

        public void failure(Service service) {
        }
    }
}
