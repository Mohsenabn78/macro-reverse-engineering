package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {

    /* renamed from: k  reason: collision with root package name */
    private static final a f17429k = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f17430a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17431b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17432c;

    /* renamed from: d  reason: collision with root package name */
    private final a f17433d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private R f17434e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Request f17435f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17436g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17437h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17438i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private GlideException f17439j;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j4) throws InterruptedException {
            obj.wait(j4);
        }
    }

    public RequestFutureTarget(int i4, int i5) {
        this(i4, i5, true, f17429k);
    }

    private synchronized R a(Long l4) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f17432c && !isDone()) {
            Util.assertBackgroundThread();
        }
        if (!this.f17436g) {
            if (!this.f17438i) {
                if (this.f17437h) {
                    return this.f17434e;
                }
                if (l4 == null) {
                    this.f17433d.b(this, 0L);
                } else if (l4.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l4.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.f17433d.b(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.f17438i) {
                        if (!this.f17436g) {
                            if (this.f17437h) {
                                return this.f17434e;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.f17439j);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.f17439j);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z3) {
        Request request;
        if (isDone()) {
            return false;
        }
        this.f17436g = true;
        this.f17433d.a(this);
        if (z3 && (request = this.f17435f) != null) {
            request.clear();
            this.f17435f = null;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public synchronized Request getRequest() {
        return this.f17435f;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.f17430a, this.f17431b);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f17436g;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z3;
        if (!this.f17436g && !this.f17437h) {
            if (!this.f17438i) {
                z3 = false;
            }
        }
        z3 = true;
        return z3;
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(@NonNull R r4, @Nullable Transition<? super R> transition) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(@Nullable Request request) {
        this.f17435f = request;
    }

    RequestFutureTarget(int i4, int i5, boolean z3, a aVar) {
        this.f17430a = i4;
        this.f17431b = i5;
        this.f17432c = z3;
        this.f17433d = aVar;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z3) {
        this.f17438i = true;
        this.f17439j = glideException;
        this.f17433d.a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r4, Object obj, Target<R> target, DataSource dataSource, boolean z3) {
        this.f17437h = true;
        this.f17434e = r4;
        this.f17433d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j4, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j4)));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }
}
