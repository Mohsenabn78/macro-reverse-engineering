package com.koushikdutta.async.future;

import com.koushikdutta.async.AsyncSemaphore;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public class SimpleFuture<T> extends SimpleCancellable implements DependentFuture<T> {

    /* renamed from: d  reason: collision with root package name */
    AsyncSemaphore f34887d;

    /* renamed from: e  reason: collision with root package name */
    Exception f34888e;

    /* renamed from: f  reason: collision with root package name */
    T f34889f;

    /* renamed from: g  reason: collision with root package name */
    boolean f34890g;

    /* renamed from: h  reason: collision with root package name */
    FutureCallback<T> f34891h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements FutureCallback<T> {
        a() {
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        public void onCompleted(Exception exc, T t3) {
            SimpleFuture.this.setComplete(exc, t3);
        }
    }

    public SimpleFuture() {
    }

    private boolean d(boolean z3) {
        FutureCallback<T> h4;
        if (!super.cancel()) {
            return false;
        }
        synchronized (this) {
            this.f34888e = new CancellationException();
            i();
            h4 = h();
            this.f34890g = z3;
        }
        g(h4);
        return true;
    }

    private T f() throws ExecutionException {
        if (this.f34888e == null) {
            return this.f34889f;
        }
        throw new ExecutionException(this.f34888e);
    }

    private void g(FutureCallback<T> futureCallback) {
        if (futureCallback != null && !this.f34890g) {
            futureCallback.onCompleted(this.f34888e, this.f34889f);
        }
    }

    private FutureCallback<T> h() {
        FutureCallback<T> futureCallback = this.f34891h;
        this.f34891h = null;
        return futureCallback;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z3) {
        return cancel();
    }

    public boolean cancelSilently() {
        return d(true);
    }

    AsyncSemaphore e() {
        if (this.f34887d == null) {
            this.f34887d = new AsyncSemaphore();
        }
        return this.f34887d;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        synchronized (this) {
            if (!isCancelled() && !isDone()) {
                e().acquire();
                return f();
            }
            return f();
        }
    }

    public FutureCallback<T> getCallback() {
        return this.f34891h;
    }

    public FutureCallback<T> getCompletionCallback() {
        return new a();
    }

    void i() {
        AsyncSemaphore asyncSemaphore = this.f34887d;
        if (asyncSemaphore != null) {
            asyncSemaphore.release();
            this.f34887d = null;
        }
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable
    public boolean setComplete() {
        return setComplete((SimpleFuture<T>) null);
    }

    @Override // com.koushikdutta.async.future.Future
    public final <C extends FutureCallback<T>> C then(C c4) {
        if (c4 instanceof DependentCancellable) {
            ((DependentCancellable) c4).setParent(this);
        }
        setCallback((FutureCallback) c4);
        return c4;
    }

    @Override // com.koushikdutta.async.future.Future
    public T tryGet() {
        return this.f34889f;
    }

    @Override // com.koushikdutta.async.future.Future
    public Exception tryGetException() {
        return this.f34888e;
    }

    public SimpleFuture(T t3) {
        setComplete((SimpleFuture<T>) t3);
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable, com.koushikdutta.async.future.Cancellable
    public boolean cancel() {
        return d(this.f34890g);
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable
    public SimpleFuture<T> reset() {
        super.reset();
        this.f34889f = null;
        this.f34888e = null;
        this.f34887d = null;
        this.f34891h = null;
        this.f34890g = false;
        return this;
    }

    @Override // com.koushikdutta.async.future.Future
    public SimpleFuture<T> setCallback(FutureCallback<T> futureCallback) {
        FutureCallback<T> h4;
        synchronized (this) {
            this.f34891h = futureCallback;
            if (!isDone() && !isCancelled()) {
                h4 = null;
            }
            h4 = h();
        }
        g(h4);
        return this;
    }

    public boolean setComplete(Exception exc) {
        return setComplete(exc, null);
    }

    public boolean setComplete(T t3) {
        return setComplete(null, t3);
    }

    @Override // com.koushikdutta.async.future.SimpleCancellable, com.koushikdutta.async.future.DependentCancellable
    public SimpleFuture<T> setParent(Cancellable cancellable) {
        super.setParent(cancellable);
        return this;
    }

    public SimpleFuture(Exception exc) {
        setComplete(exc);
    }

    public boolean setComplete(Exception exc, T t3) {
        synchronized (this) {
            if (super.setComplete()) {
                this.f34889f = t3;
                this.f34888e = exc;
                i();
                g(h());
                return true;
            }
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j4, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        synchronized (this) {
            if (!isCancelled() && !isDone()) {
                AsyncSemaphore e4 = e();
                if (e4.tryAcquire(j4, timeUnit)) {
                    return f();
                }
                throw new TimeoutException();
            }
            return f();
        }
    }

    public SimpleFuture<T> setComplete(Future<T> future) {
        future.setCallback(getCompletionCallback());
        setParent((Cancellable) future);
        return this;
    }
}
