package com.google.common.util.concurrent;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class AbstractIdleService implements Service {

    /* renamed from: a  reason: collision with root package name */
    private final Supplier<String> f28314a = new ThreadNameSupplier();

    /* renamed from: b  reason: collision with root package name */
    private final Service f28315b = new DelegateService();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class DelegateService extends AbstractService {
        private DelegateService() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s() {
            try {
                AbstractIdleService.this.g();
                m();
            } catch (Throwable th) {
                Platform.b(th);
                l(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t() {
            try {
                AbstractIdleService.this.f();
                n();
            } catch (Throwable th) {
                Platform.b(th);
                l(th);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void e() {
            MoreExecutors.e(AbstractIdleService.this.c(), AbstractIdleService.this.f28314a).execute(new Runnable() { // from class: com.google.common.util.concurrent.f
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractIdleService.DelegateService.this.s();
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void f() {
            MoreExecutors.e(AbstractIdleService.this.c(), AbstractIdleService.this.f28314a).execute(new Runnable() { // from class: com.google.common.util.concurrent.e
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractIdleService.DelegateService.this.t();
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractIdleService.this.toString();
        }
    }

    /* loaded from: classes5.dex */
    private final class ThreadNameSupplier implements Supplier<String> {
        private ThreadNameSupplier() {
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a */
        public String get() {
            return AbstractIdleService.this.e() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + AbstractIdleService.this.state();
        }
    }

    protected AbstractIdleService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Runnable runnable) {
        MoreExecutors.c(this.f28314a.get(), runnable).start();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.f28315b.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.f28315b.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.f28315b.awaitTerminated();
    }

    protected Executor c() {
        return new Executor() { // from class: com.google.common.util.concurrent.d
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                AbstractIdleService.this.d(runnable);
            }
        };
    }

    protected String e() {
        return getClass().getSimpleName();
    }

    protected abstract void f() throws Exception;

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.f28315b.failureCause();
    }

    protected abstract void g() throws Exception;

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f28315b.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.f28315b.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f28315b.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.f28315b.stopAsync();
        return this;
    }

    public String toString() {
        return e() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j4, TimeUnit timeUnit) throws TimeoutException {
        this.f28315b.awaitRunning(j4, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j4, TimeUnit timeUnit) throws TimeoutException {
        this.f28315b.awaitTerminated(j4, timeUnit);
    }
}
