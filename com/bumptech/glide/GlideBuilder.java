package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class GlideBuilder {

    /* renamed from: b  reason: collision with root package name */
    private Engine f16575b;

    /* renamed from: c  reason: collision with root package name */
    private BitmapPool f16576c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayPool f16577d;

    /* renamed from: e  reason: collision with root package name */
    private MemoryCache f16578e;

    /* renamed from: f  reason: collision with root package name */
    private GlideExecutor f16579f;

    /* renamed from: g  reason: collision with root package name */
    private GlideExecutor f16580g;

    /* renamed from: h  reason: collision with root package name */
    private DiskCache.Factory f16581h;

    /* renamed from: i  reason: collision with root package name */
    private MemorySizeCalculator f16582i;

    /* renamed from: j  reason: collision with root package name */
    private ConnectivityMonitorFactory f16583j;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private RequestManagerRetriever.RequestManagerFactory f16586m;

    /* renamed from: n  reason: collision with root package name */
    private GlideExecutor f16587n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f16588o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private List<RequestListener<Object>> f16589p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f16590q;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, TransitionOptions<?, ?>> f16574a = new ArrayMap();

    /* renamed from: k  reason: collision with root package name */
    private int f16584k = 4;

    /* renamed from: l  reason: collision with root package name */
    private RequestOptions f16585l = new RequestOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Glide a(@NonNull Context context) {
        if (this.f16579f == null) {
            this.f16579f = GlideExecutor.newSourceExecutor();
        }
        if (this.f16580g == null) {
            this.f16580g = GlideExecutor.newDiskCacheExecutor();
        }
        if (this.f16587n == null) {
            this.f16587n = GlideExecutor.newAnimationExecutor();
        }
        if (this.f16582i == null) {
            this.f16582i = new MemorySizeCalculator.Builder(context).build();
        }
        if (this.f16583j == null) {
            this.f16583j = new DefaultConnectivityMonitorFactory();
        }
        if (this.f16576c == null) {
            int bitmapPoolSize = this.f16582i.getBitmapPoolSize();
            if (bitmapPoolSize > 0) {
                this.f16576c = new LruBitmapPool(bitmapPoolSize);
            } else {
                this.f16576c = new BitmapPoolAdapter();
            }
        }
        if (this.f16577d == null) {
            this.f16577d = new LruArrayPool(this.f16582i.getArrayPoolSizeInBytes());
        }
        if (this.f16578e == null) {
            this.f16578e = new LruResourceCache(this.f16582i.getMemoryCacheSize());
        }
        if (this.f16581h == null) {
            this.f16581h = new InternalCacheDiskCacheFactory(context);
        }
        if (this.f16575b == null) {
            this.f16575b = new Engine(this.f16578e, this.f16581h, this.f16580g, this.f16579f, GlideExecutor.newUnlimitedSourceExecutor(), GlideExecutor.newAnimationExecutor(), this.f16588o);
        }
        List<RequestListener<Object>> list = this.f16589p;
        if (list == null) {
            this.f16589p = Collections.emptyList();
        } else {
            this.f16589p = Collections.unmodifiableList(list);
        }
        return new Glide(context, this.f16575b, this.f16578e, this.f16576c, this.f16577d, new RequestManagerRetriever(this.f16586m), this.f16583j, this.f16584k, this.f16585l.lock(), this.f16574a, this.f16589p, this.f16590q);
    }

    @NonNull
    public GlideBuilder addGlobalRequestListener(@NonNull RequestListener<Object> requestListener) {
        if (this.f16589p == null) {
            this.f16589p = new ArrayList();
        }
        this.f16589p.add(requestListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.f16586m = requestManagerFactory;
    }

    @NonNull
    public GlideBuilder setAnimationExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f16587n = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setArrayPool(@Nullable ArrayPool arrayPool) {
        this.f16577d = arrayPool;
        return this;
    }

    @NonNull
    public GlideBuilder setBitmapPool(@Nullable BitmapPool bitmapPool) {
        this.f16576c = bitmapPool;
        return this;
    }

    @NonNull
    public GlideBuilder setConnectivityMonitorFactory(@Nullable ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.f16583j = connectivityMonitorFactory;
        return this;
    }

    @NonNull
    public GlideBuilder setDefaultRequestOptions(@Nullable RequestOptions requestOptions) {
        this.f16585l = requestOptions;
        return this;
    }

    @NonNull
    public <T> GlideBuilder setDefaultTransitionOptions(@NonNull Class<T> cls, @Nullable TransitionOptions<?, T> transitionOptions) {
        this.f16574a.put(cls, transitionOptions);
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCache(@Nullable DiskCache.Factory factory) {
        this.f16581h = factory;
        return this;
    }

    @NonNull
    public GlideBuilder setDiskCacheExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f16580g = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean z3) {
        this.f16588o = z3;
        return this;
    }

    @NonNull
    public GlideBuilder setLogLevel(int i4) {
        if (i4 >= 2 && i4 <= 6) {
            this.f16584k = i4;
            return this;
        }
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    public GlideBuilder setLogRequestOrigins(boolean z3) {
        this.f16590q = z3;
        return this;
    }

    @NonNull
    public GlideBuilder setMemoryCache(@Nullable MemoryCache memoryCache) {
        this.f16578e = memoryCache;
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@NonNull MemorySizeCalculator.Builder builder) {
        return setMemorySizeCalculator(builder.build());
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(@Nullable GlideExecutor glideExecutor) {
        return setSourceExecutor(glideExecutor);
    }

    @NonNull
    public GlideBuilder setSourceExecutor(@Nullable GlideExecutor glideExecutor) {
        this.f16579f = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder setMemorySizeCalculator(@Nullable MemorySizeCalculator memorySizeCalculator) {
        this.f16582i = memorySizeCalculator;
        return this;
    }
}
