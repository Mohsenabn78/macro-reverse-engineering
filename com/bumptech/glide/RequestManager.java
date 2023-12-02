package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class RequestManager implements LifecycleListener {

    /* renamed from: l  reason: collision with root package name */
    private static final RequestOptions f16628l = RequestOptions.decodeTypeOf(Bitmap.class).lock();

    /* renamed from: m  reason: collision with root package name */
    private static final RequestOptions f16629m = RequestOptions.decodeTypeOf(GifDrawable.class).lock();

    /* renamed from: n  reason: collision with root package name */
    private static final RequestOptions f16630n = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);

    /* renamed from: a  reason: collision with root package name */
    protected final Glide f16631a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f16632b;

    /* renamed from: c  reason: collision with root package name */
    final Lifecycle f16633c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private final RequestTracker f16634d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private final RequestManagerTreeNode f16635e;
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private final TargetTracker f16636f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f16637g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f16638h;

    /* renamed from: i  reason: collision with root package name */
    private final ConnectivityMonitor f16639i;

    /* renamed from: j  reason: collision with root package name */
    private final CopyOnWriteArrayList<RequestListener<Object>> f16640j;
    @GuardedBy("this")

    /* renamed from: k  reason: collision with root package name */
    private RequestOptions f16641k;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestManager requestManager = RequestManager.this;
            requestManager.f16633c.addListener(requestManager);
        }
    }

    /* loaded from: classes3.dex */
    private class c implements ConnectivityMonitor.ConnectivityListener {
        @GuardedBy("RequestManager.this")

        /* renamed from: a  reason: collision with root package name */
        private final RequestTracker f16643a;

        c(@NonNull RequestTracker requestTracker) {
            this.f16643a = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z3) {
            if (z3) {
                synchronized (RequestManager.this) {
                    this.f16643a.restartRequests();
                }
            }
        }
    }

    public RequestManager(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.c(), context);
    }

    private void g(@NonNull Target<?> target) {
        if (!f(target) && !this.f16631a.i(target) && target.getRequest() != null) {
            Request request = target.getRequest();
            target.setRequest(null);
            request.clear();
        }
    }

    private synchronized void h(@NonNull RequestOptions requestOptions) {
        this.f16641k = this.f16641k.apply(requestOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<RequestListener<Object>> a() {
        return this.f16640j;
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> requestListener) {
        this.f16640j.add(requestListener);
        return this;
    }

    @NonNull
    public synchronized RequestManager applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        h(requestOptions);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> RequestBuilder<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.f16631a, this, cls, this.f16632b);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply((BaseRequestOptions<?>) f16628l);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> asFile() {
        return as(File.class).apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply((BaseRequestOptions<?>) f16629m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized RequestOptions b() {
        return this.f16641k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public <T> TransitionOptions<?, T> c(Class<T> cls) {
        return this.f16631a.d().getDefaultTransitionOptions(cls);
    }

    public void clear(@NonNull View view) {
        clear(new b(view));
    }

    protected synchronized void d(@NonNull RequestOptions requestOptions) {
        this.f16641k = requestOptions.mo4145clone().autoClone();
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> download(@Nullable Object obj) {
        return downloadOnly().m4151load(obj);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply((BaseRequestOptions<?>) f16630n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void e(@NonNull Target<?> target, @NonNull Request request) {
        this.f16636f.track(target);
        this.f16634d.runRequest(request);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean f(@NonNull Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (this.f16634d.clearRemoveAndRecycle(request)) {
            this.f16636f.untrack(target);
            target.setRequest(null);
            return true;
        }
        return false;
    }

    public synchronized boolean isPaused() {
        return this.f16634d.isPaused();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        this.f16636f.onDestroy();
        for (Target<?> target : this.f16636f.getAll()) {
            clear(target);
        }
        this.f16636f.clear();
        this.f16634d.clearRequests();
        this.f16633c.removeListener(this);
        this.f16633c.removeListener(this.f16639i);
        this.f16638h.removeCallbacks(this.f16637g);
        this.f16631a.k(this);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        resumeRequests();
        this.f16636f.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        pauseRequests();
        this.f16636f.onStop();
    }

    public synchronized void pauseAllRequests() {
        this.f16634d.pauseAllRequests();
    }

    public synchronized void pauseRequests() {
        this.f16634d.pauseRequests();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        for (RequestManager requestManager : this.f16635e.getDescendants()) {
            requestManager.pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.f16634d.resumeRequests();
    }

    public synchronized void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        for (RequestManager requestManager : this.f16635e.getDescendants()) {
            requestManager.resumeRequests();
        }
    }

    @NonNull
    public synchronized RequestManager setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        d(requestOptions);
        return this;
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f16634d + ", treeNode=" + this.f16635e + "}";
    }

    public synchronized void clear(@Nullable Target<?> target) {
        if (target == null) {
            return;
        }
        g(target);
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f16636f = new TargetTracker();
        a aVar = new a();
        this.f16637g = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f16638h = handler;
        this.f16631a = glide;
        this.f16633c = lifecycle;
        this.f16635e = requestManagerTreeNode;
        this.f16634d = requestTracker;
        this.f16632b = context;
        ConnectivityMonitor build = connectivityMonitorFactory.build(context.getApplicationContext(), new c(requestTracker));
        this.f16639i = build;
        if (Util.isOnBackgroundThread()) {
            handler.post(aVar);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
        this.f16640j = new CopyOnWriteArrayList<>(glide.d().getDefaultRequestListeners());
        d(glide.d().getDefaultRequestOptions());
        glide.h(this);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<Drawable> m4155load(@Nullable Bitmap bitmap) {
        return asDrawable().m4146load(bitmap);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<Drawable> m4156load(@Nullable Drawable drawable) {
        return asDrawable().m4147load(drawable);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<Drawable> m4161load(@Nullable String str) {
        return asDrawable().m4152load(str);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<Drawable> m4157load(@Nullable Uri uri) {
        return asDrawable().m4148load(uri);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<Drawable> m4158load(@Nullable File file) {
        return asDrawable().m4149load(file);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<Drawable> m4159load(@Nullable @DrawableRes @RawRes Integer num) {
        return asDrawable().m4150load(num);
    }

    @CheckResult
    @Deprecated
    /* renamed from: load */
    public RequestBuilder<Drawable> m4162load(@Nullable URL url) {
        return asDrawable().m4153load(url);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<Drawable> m4163load(@Nullable byte[] bArr) {
        return asDrawable().m4154load(bArr);
    }

    @NonNull
    @CheckResult
    /* renamed from: load */
    public RequestBuilder<Drawable> m4160load(@Nullable Object obj) {
        return asDrawable().m4151load(obj);
    }

    /* loaded from: classes3.dex */
    private static class b extends ViewTarget<View, Object> {
        b(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }
    }
}
