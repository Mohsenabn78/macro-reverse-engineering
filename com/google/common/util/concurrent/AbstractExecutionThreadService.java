package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class AbstractExecutionThreadService implements Service {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f28278b = Logger.getLogger(AbstractExecutionThreadService.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final Service f28279a = new AnonymousClass1();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 extends AbstractService {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String s() {
            return AbstractExecutionThreadService.this.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t() {
            try {
                AbstractExecutionThreadService.this.h();
                m();
                if (isRunning()) {
                    AbstractExecutionThreadService.this.e();
                }
                AbstractExecutionThreadService.this.g();
                n();
            } catch (Throwable th) {
                Platform.b(th);
                l(th);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void e() {
            MoreExecutors.e(AbstractExecutionThreadService.this.c(), new Supplier() { // from class: com.google.common.util.concurrent.b
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    String s3;
                    s3 = AbstractExecutionThreadService.AnonymousClass1.this.s();
                    return s3;
                }
            }).execute(new Runnable() { // from class: com.google.common.util.concurrent.c
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractExecutionThreadService.AnonymousClass1.this.t();
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void f() {
            AbstractExecutionThreadService.this.i();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    }

    protected AbstractExecutionThreadService() {
    }

    static /* synthetic */ Logger b() {
        return f28278b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Runnable runnable) {
        MoreExecutors.c(f(), runnable).start();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.f28279a.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.f28279a.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.f28279a.awaitTerminated();
    }

    protected Executor c() {
        return new Executor() { // from class: com.google.common.util.concurrent.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                AbstractExecutionThreadService.this.d(runnable);
            }
        };
    }

    protected abstract void e() throws Exception;

    protected String f() {
        return getClass().getSimpleName();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.f28279a.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f28279a.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.f28279a.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f28279a.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.f28279a.stopAsync();
        return this;
    }

    public String toString() {
        return f() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j4, TimeUnit timeUnit) throws TimeoutException {
        this.f28279a.awaitRunning(j4, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j4, TimeUnit timeUnit) throws TimeoutException {
        this.f28279a.awaitTerminated(j4, timeUnit);
    }

    protected void g() throws Exception {
    }

    protected void h() throws Exception {
    }

    protected void i() {
    }
}
