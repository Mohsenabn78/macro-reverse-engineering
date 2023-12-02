package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public final class FuturesGetChecked {

    /* renamed from: a  reason: collision with root package name */
    private static final Ordering<Constructor<?>> f28512a = Ordering.natural().onResultOf(new Function() { // from class: com.google.common.util.concurrent.u
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            Boolean i4;
            i4 = FuturesGetChecked.i((Constructor) obj);
            return i4;
        }
    }).reverse();

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public interface GetCheckedTypeValidator {
        void a(Class<? extends Exception> cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static class GetCheckedTypeValidatorHolder {

        /* renamed from: a  reason: collision with root package name */
        static final GetCheckedTypeValidator f28513a = a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public enum WeakSetValidator implements GetCheckedTypeValidator {
            INSTANCE;
            

            /* renamed from: b  reason: collision with root package name */
            private static final Set<WeakReference<Class<? extends Exception>>> f28515b = new CopyOnWriteArraySet();

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void a(Class<? extends Exception> cls) {
                for (WeakReference<Class<? extends Exception>> weakReference : f28515b) {
                    if (cls.equals(weakReference.get())) {
                        return;
                    }
                }
                FuturesGetChecked.c(cls);
                Set<WeakReference<Class<? extends Exception>>> set = f28515b;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference<>(cls));
            }
        }

        GetCheckedTypeValidatorHolder() {
        }

        static GetCheckedTypeValidator a() {
            return FuturesGetChecked.m();
        }
    }

    private FuturesGetChecked() {
    }

    private static GetCheckedTypeValidator b() {
        return GetCheckedTypeValidatorHolder.f28513a;
    }

    @VisibleForTesting
    static void c(Class<? extends Exception> cls) {
        Preconditions.checkArgument(h(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        Preconditions.checkArgument(g(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    @ParametricNullness
    static <V, X extends Exception> V d(GetCheckedTypeValidator getCheckedTypeValidator, Future<V> future, Class<X> cls) throws Exception {
        getCheckedTypeValidator.a(cls);
        try {
            return future.get();
        } catch (InterruptedException e4) {
            Thread.currentThread().interrupt();
            throw k(cls, e4);
        } catch (ExecutionException e5) {
            n(e5.getCause(), cls);
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V, X extends Exception> V e(Future<V> future, Class<X> cls) throws Exception {
        return (V) d(b(), future, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V, X extends Exception> V f(Future<V> future, Class<X> cls, long j4, TimeUnit timeUnit) throws Exception {
        b().a(cls);
        try {
            return future.get(j4, timeUnit);
        } catch (InterruptedException e4) {
            Thread.currentThread().interrupt();
            throw k(cls, e4);
        } catch (ExecutionException e5) {
            n(e5.getCause(), cls);
            throw new AssertionError();
        } catch (TimeoutException e6) {
            throw k(cls, e6);
        }
    }

    private static boolean g(Class<? extends Exception> cls) {
        try {
            k(cls, new Exception());
            return true;
        } catch (Error | RuntimeException unused) {
            return false;
        }
    }

    @VisibleForTesting
    static boolean h(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean i(Constructor constructor) {
        return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
    }

    @CheckForNull
    private static <X> X j(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i4 = 0; i4 < parameterTypes.length; i4++) {
            Class<?> cls = parameterTypes[i4];
            if (cls.equals(String.class)) {
                objArr[i4] = th.toString();
            } else if (!cls.equals(Throwable.class)) {
                return null;
            } else {
                objArr[i4] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static <X extends Exception> X k(Class<X> cls, Throwable th) {
        for (Constructor constructor : l(Arrays.asList(cls.getConstructors()))) {
            X x3 = (X) j(constructor, th);
            if (x3 != null) {
                if (x3.getCause() == null) {
                    x3.initCause(th);
                }
                return x3;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    private static <X extends Exception> List<Constructor<X>> l(List<Constructor<X>> list) {
        return (List<Constructor<X>>) f28512a.sortedCopy(list);
    }

    @VisibleForTesting
    static GetCheckedTypeValidator m() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    private static <X extends Exception> void n(Throwable th, Class<X> cls) throws Exception {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                throw new UncheckedExecutionException(th);
            }
            throw k(cls, th);
        }
        throw new ExecutionError((Error) th);
    }
}
