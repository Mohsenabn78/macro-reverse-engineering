package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class Callables {
    private Callables() {
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> callable, final ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new AsyncCallable() { // from class: com.google.common.util.concurrent.o
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                ListenableFuture submit;
                submit = ListeningExecutorService.this.submit(callable);
                return submit;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object g(Supplier supplier, Callable callable) throws Exception {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean k4 = k((String) supplier.get(), currentThread);
        try {
            return callable.call();
        } finally {
            if (k4) {
                k(name, currentThread);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Supplier supplier, Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean k4 = k((String) supplier.get(), currentThread);
        try {
            runnable.run();
        } finally {
            if (k4) {
                k(name, currentThread);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @J2ktIncompatible
    @GwtIncompatible
    public static Runnable i(final Runnable runnable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return new Runnable() { // from class: com.google.common.util.concurrent.m
            @Override // java.lang.Runnable
            public final void run() {
                Callables.h(Supplier.this, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @J2ktIncompatible
    @GwtIncompatible
    public static <T> Callable<T> j(final Callable<T> callable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new Callable() { // from class: com.google.common.util.concurrent.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object g4;
                g4 = Callables.g(Supplier.this, callable);
                return g4;
            }
        };
    }

    @J2ktIncompatible
    @GwtIncompatible
    private static boolean k(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static <T> Callable<T> returning(@ParametricNullness final T t3) {
        return new Callable() { // from class: com.google.common.util.concurrent.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object f4;
                f4 = Callables.f(t3);
                return f4;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object f(Object obj) throws Exception {
        return obj;
    }
}
