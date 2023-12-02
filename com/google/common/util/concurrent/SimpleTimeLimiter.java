package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public final class SimpleTimeLimiter implements TimeLimiter {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f28601a;

    /* renamed from: com.google.common.util.concurrent.SimpleTimeLimiter$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f28602a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f28603b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TimeUnit f28604c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Set f28605d;

        AnonymousClass1(Object obj, long j4, TimeUnit timeUnit, Set set) {
            this.f28602a = obj;
            this.f28603b = j4;
            this.f28604c = timeUnit;
            this.f28605d = set;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object b(Method method, Object obj, Object[] objArr) throws Exception {
            try {
                return method.invoke(obj, objArr);
            } catch (InvocationTargetException e4) {
                throw SimpleTimeLimiter.h(e4, false);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        @CheckForNull
        public Object invoke(Object obj, final Method method, @CheckForNull final Object[] objArr) throws Throwable {
            final Object obj2 = this.f28602a;
            return SimpleTimeLimiter.this.c(new Callable() { // from class: com.google.common.util.concurrent.y
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object b4;
                    b4 = SimpleTimeLimiter.AnonymousClass1.b(method, obj2, objArr);
                    return b4;
                }
            }, this.f28603b, this.f28604c, this.f28605d.contains(method));
        }
    }

    private SimpleTimeLimiter(ExecutorService executorService) {
        this.f28601a = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ParametricNullness
    public <T> T c(Callable<T> callable, long j4, TimeUnit timeUnit, boolean z3) throws Exception {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        d(j4);
        Future<T> submit = this.f28601a.submit(callable);
        try {
            if (z3) {
                try {
                    return submit.get(j4, timeUnit);
                } catch (InterruptedException e4) {
                    submit.cancel(true);
                    throw e4;
                }
            }
            return (T) Uninterruptibles.getUninterruptibly(submit, j4, timeUnit);
        } catch (ExecutionException e5) {
            throw h(e5, true);
        } catch (TimeoutException e6) {
            submit.cancel(true);
            throw new UncheckedTimeoutException(e6);
        }
    }

    public static SimpleTimeLimiter create(ExecutorService executorService) {
        return new SimpleTimeLimiter(executorService);
    }

    private static void d(long j4) {
        boolean z3;
        if (j4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "timeout must be positive: %s", j4);
    }

    private static boolean e(Method method) {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    private static Set<Method> f(Class<?> cls) {
        Method[] methods;
        HashSet newHashSet = Sets.newHashSet();
        for (Method method : cls.getMethods()) {
            if (e(method)) {
                newHashSet.add(method);
            }
        }
        return newHashSet;
    }

    private static <T> T g(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Exception h(Exception exc, boolean z3) throws Exception {
        Throwable cause = exc.getCause();
        if (cause != null) {
            if (z3) {
                cause.setStackTrace((StackTraceElement[]) ObjectArrays.concat(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
            }
            if (!(cause instanceof Exception)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw exc;
            }
            throw ((Exception) cause);
        }
        throw exc;
    }

    private void i(Throwable th) throws ExecutionException {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                throw new UncheckedExecutionException(th);
            }
            throw new ExecutionException(th);
        }
        throw new ExecutionError((Error) th);
    }

    private void j(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        throw new UncheckedExecutionException(th);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j4, TimeUnit timeUnit) throws TimeoutException, ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        d(j4);
        Future<T> submit = this.f28601a.submit(callable);
        try {
            return (T) Uninterruptibles.getUninterruptibly(submit, j4, timeUnit);
        } catch (ExecutionException e4) {
            i(e4.getCause());
            throw new AssertionError();
        } catch (TimeoutException e5) {
            submit.cancel(true);
            throw e5;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> callable, long j4, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        d(j4);
        Future<T> submit = this.f28601a.submit(callable);
        try {
            return submit.get(j4, timeUnit);
        } catch (InterruptedException e4) {
            e = e4;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e5) {
            i(e5.getCause());
            throw new AssertionError();
        } catch (TimeoutException e6) {
            e = e6;
            submit.cancel(true);
            throw e;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T t3, Class<T> cls, long j4, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t3);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        d(j4);
        Preconditions.checkArgument(cls.isInterface(), "interfaceType must be an interface type");
        return (T) g(cls, new AnonymousClass1(t3, j4, timeUnit, f(cls)));
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable runnable, long j4, TimeUnit timeUnit) throws TimeoutException {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        d(j4);
        Future<?> submit = this.f28601a.submit(runnable);
        try {
            Uninterruptibles.getUninterruptibly(submit, j4, timeUnit);
        } catch (ExecutionException e4) {
            j(e4.getCause());
            throw new AssertionError();
        } catch (TimeoutException e5) {
            submit.cancel(true);
            throw e5;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable runnable, long j4, TimeUnit timeUnit) throws TimeoutException, InterruptedException {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        d(j4);
        Future<?> submit = this.f28601a.submit(runnable);
        try {
            submit.get(j4, timeUnit);
        } catch (InterruptedException e4) {
            e = e4;
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e5) {
            j(e5.getCause());
            throw new AssertionError();
        } catch (TimeoutException e6) {
            e = e6;
            submit.cancel(true);
            throw e;
        }
    }
}
