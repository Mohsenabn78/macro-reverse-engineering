package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes2.dex */
public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    private final Set<LottieListener<T>> f1374a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<LottieListener<Throwable>> f1375b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f1376c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private volatile LottieResult<T> f1377d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LottieTask.this.f1377d != null) {
                LottieResult lottieResult = LottieTask.this.f1377d;
                if (lottieResult.getValue() != null) {
                    LottieTask.this.g(lottieResult.getValue());
                } else {
                    LottieTask.this.e(lottieResult.getException());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends FutureTask<LottieResult<T>> {
        b(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (!isCancelled()) {
                try {
                    LottieTask.this.h(get());
                } catch (InterruptedException | ExecutionException e4) {
                    LottieTask.this.h(new LottieResult(e4));
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList(this.f1375b);
        if (arrayList.isEmpty()) {
            Logger.warning("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (LottieListener lottieListener : arrayList) {
            lottieListener.onResult(th);
        }
    }

    private void f() {
        this.f1376c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(T t3) {
        for (LottieListener lottieListener : new ArrayList(this.f1374a)) {
            lottieListener.onResult(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(@Nullable LottieResult<T> lottieResult) {
        if (this.f1377d == null) {
            this.f1377d = lottieResult;
            f();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        if (this.f1377d != null && this.f1377d.getException() != null) {
            lottieListener.onResult(this.f1377d.getException());
        }
        this.f1375b.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        if (this.f1377d != null && this.f1377d.getValue() != null) {
            lottieListener.onResult(this.f1377d.getValue());
        }
        this.f1374a.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        this.f1375b.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        this.f1374a.remove(lottieListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> callable, boolean z3) {
        this.f1374a = new LinkedHashSet(1);
        this.f1375b = new LinkedHashSet(1);
        this.f1376c = new Handler(Looper.getMainLooper());
        this.f1377d = null;
        if (z3) {
            try {
                h(callable.call());
                return;
            } catch (Throwable th) {
                h(new LottieResult<>(th));
                return;
            }
        }
        EXECUTOR.execute(new b(callable));
    }
}
