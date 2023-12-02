package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class Engine implements i, MemoryCache.ResourceRemovedListener, l.a {

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f16792i = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    private final m f16793a;

    /* renamed from: b  reason: collision with root package name */
    private final k f16794b;

    /* renamed from: c  reason: collision with root package name */
    private final MemoryCache f16795c;

    /* renamed from: d  reason: collision with root package name */
    private final b f16796d;

    /* renamed from: e  reason: collision with root package name */
    private final q f16797e;

    /* renamed from: f  reason: collision with root package name */
    private final c f16798f;

    /* renamed from: g  reason: collision with root package name */
    private final a f16799g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a f16800h;

    /* loaded from: classes3.dex */
    public class LoadStatus {

        /* renamed from: a  reason: collision with root package name */
        private final h<?> f16801a;

        /* renamed from: b  reason: collision with root package name */
        private final ResourceCallback f16802b;

        LoadStatus(ResourceCallback resourceCallback, h<?> hVar) {
            this.f16802b = resourceCallback;
            this.f16801a = hVar;
        }

        public void cancel() {
            synchronized (Engine.this) {
                this.f16801a.o(this.f16802b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final g.e f16804a;

        /* renamed from: b  reason: collision with root package name */
        final Pools.Pool<g<?>> f16805b = FactoryPools.threadSafe(150, new C0133a());

        /* renamed from: c  reason: collision with root package name */
        private int f16806c;

        /* renamed from: com.bumptech.glide.load.engine.Engine$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0133a implements FactoryPools.Factory<g<?>> {
            C0133a() {
            }

            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* renamed from: a */
            public g<?> create() {
                a aVar = a.this;
                return new g<>(aVar.f16804a, aVar.f16805b);
            }
        }

        a(g.e eVar) {
            this.f16804a = eVar;
        }

        <R> g<R> a(GlideContext glideContext, Object obj, j jVar, Key key, int i4, int i5, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z3, boolean z4, boolean z5, Options options, g.b<R> bVar) {
            g gVar = (g) Preconditions.checkNotNull(this.f16805b.acquire());
            int i6 = this.f16806c;
            this.f16806c = i6 + 1;
            return gVar.j(glideContext, obj, jVar, key, i4, i5, cls, cls2, priority, diskCacheStrategy, map, z3, z4, z5, options, bVar, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final GlideExecutor f16808a;

        /* renamed from: b  reason: collision with root package name */
        final GlideExecutor f16809b;

        /* renamed from: c  reason: collision with root package name */
        final GlideExecutor f16810c;

        /* renamed from: d  reason: collision with root package name */
        final GlideExecutor f16811d;

        /* renamed from: e  reason: collision with root package name */
        final i f16812e;

        /* renamed from: f  reason: collision with root package name */
        final Pools.Pool<h<?>> f16813f = FactoryPools.threadSafe(150, new a());

        /* loaded from: classes3.dex */
        class a implements FactoryPools.Factory<h<?>> {
            a() {
            }

            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* renamed from: a */
            public h<?> create() {
                b bVar = b.this;
                return new h<>(bVar.f16808a, bVar.f16809b, bVar.f16810c, bVar.f16811d, bVar.f16812e, bVar.f16813f);
            }
        }

        b(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, i iVar) {
            this.f16808a = glideExecutor;
            this.f16809b = glideExecutor2;
            this.f16810c = glideExecutor3;
            this.f16811d = glideExecutor4;
            this.f16812e = iVar;
        }

        <R> h<R> a(Key key, boolean z3, boolean z4, boolean z5, boolean z6) {
            return ((h) Preconditions.checkNotNull(this.f16813f.acquire())).i(key, z3, z4, z5, z6);
        }

        @VisibleForTesting
        void b() {
            Executors.shutdownAndAwaitTermination(this.f16808a);
            Executors.shutdownAndAwaitTermination(this.f16809b);
            Executors.shutdownAndAwaitTermination(this.f16810c);
            Executors.shutdownAndAwaitTermination(this.f16811d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c implements g.e {

        /* renamed from: a  reason: collision with root package name */
        private final DiskCache.Factory f16815a;

        /* renamed from: b  reason: collision with root package name */
        private volatile DiskCache f16816b;

        c(DiskCache.Factory factory) {
            this.f16815a = factory;
        }

        @Override // com.bumptech.glide.load.engine.g.e
        public DiskCache a() {
            if (this.f16816b == null) {
                synchronized (this) {
                    if (this.f16816b == null) {
                        this.f16816b = this.f16815a.build();
                    }
                    if (this.f16816b == null) {
                        this.f16816b = new DiskCacheAdapter();
                    }
                }
            }
            return this.f16816b;
        }

        @VisibleForTesting
        synchronized void b() {
            if (this.f16816b == null) {
                return;
            }
            this.f16816b.clear();
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z3) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, z3);
    }

    private l<?> a(Key key) {
        Resource<?> remove = this.f16795c.remove(key);
        if (remove == null) {
            return null;
        }
        if (remove instanceof l) {
            return (l) remove;
        }
        return new l<>(remove, true, true);
    }

    @Nullable
    private l<?> b(Key key, boolean z3) {
        if (!z3) {
            return null;
        }
        l<?> e4 = this.f16800h.e(key);
        if (e4 != null) {
            e4.a();
        }
        return e4;
    }

    private l<?> c(Key key, boolean z3) {
        if (!z3) {
            return null;
        }
        l<?> a4 = a(key);
        if (a4 != null) {
            a4.a();
            this.f16800h.a(key, a4);
        }
        return a4;
    }

    private static void d(String str, long j4, Key key) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.getElapsedMillis(j4));
        sb.append("ms, key: ");
        sb.append(key);
    }

    public void clearDiskCache() {
        this.f16798f.a().clear();
    }

    public synchronized <R> LoadStatus load(GlideContext glideContext, Object obj, Key key, int i4, int i5, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z3, boolean z4, Options options, boolean z5, boolean z6, boolean z7, boolean z8, ResourceCallback resourceCallback, Executor executor) {
        long j4;
        boolean z9 = f16792i;
        if (z9) {
            j4 = LogTime.getLogTime();
        } else {
            j4 = 0;
        }
        long j5 = j4;
        j a4 = this.f16794b.a(obj, key, i4, i5, map, cls, cls2, options);
        l<?> b4 = b(a4, z5);
        if (b4 != null) {
            resourceCallback.onResourceReady(b4, DataSource.MEMORY_CACHE);
            if (z9) {
                d("Loaded resource from active resources", j5, a4);
            }
            return null;
        }
        l<?> c4 = c(a4, z5);
        if (c4 != null) {
            resourceCallback.onResourceReady(c4, DataSource.MEMORY_CACHE);
            if (z9) {
                d("Loaded resource from cache", j5, a4);
            }
            return null;
        }
        h<?> a5 = this.f16793a.a(a4, z8);
        if (a5 != null) {
            a5.b(resourceCallback, executor);
            if (z9) {
                d("Added to existing load", j5, a4);
            }
            return new LoadStatus(resourceCallback, a5);
        }
        h<R> a6 = this.f16796d.a(a4, z5, z6, z7, z8);
        g<R> a7 = this.f16799g.a(glideContext, obj, a4, key, i4, i5, cls, cls2, priority, diskCacheStrategy, map, z3, z4, z8, options, a6);
        this.f16793a.c(a4, a6);
        a6.b(resourceCallback, executor);
        a6.p(a7);
        if (z9) {
            d("Started new load", j5, a4);
        }
        return new LoadStatus(resourceCallback, a6);
    }

    @Override // com.bumptech.glide.load.engine.i
    public synchronized void onEngineJobCancelled(h<?> hVar, Key key) {
        this.f16793a.d(key, hVar);
    }

    @Override // com.bumptech.glide.load.engine.i
    public synchronized void onEngineJobComplete(h<?> hVar, Key key, l<?> lVar) {
        if (lVar != null) {
            lVar.e(key, this);
            if (lVar.c()) {
                this.f16800h.a(key, lVar);
            }
        }
        this.f16793a.d(key, hVar);
    }

    @Override // com.bumptech.glide.load.engine.l.a
    public synchronized void onResourceReleased(Key key, l<?> lVar) {
        this.f16800h.d(key);
        if (lVar.c()) {
            this.f16795c.put(key, lVar);
        } else {
            this.f16797e.a(lVar);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(@NonNull Resource<?> resource) {
        this.f16797e.a(resource);
    }

    public void release(Resource<?> resource) {
        if (resource instanceof l) {
            ((l) resource).d();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    public void shutdown() {
        this.f16796d.b();
        this.f16798f.b();
        this.f16800h.g();
    }

    @VisibleForTesting
    Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, m mVar, k kVar, com.bumptech.glide.load.engine.a aVar, b bVar, a aVar2, q qVar, boolean z3) {
        this.f16795c = memoryCache;
        c cVar = new c(factory);
        this.f16798f = cVar;
        com.bumptech.glide.load.engine.a aVar3 = aVar == null ? new com.bumptech.glide.load.engine.a(z3) : aVar;
        this.f16800h = aVar3;
        aVar3.f(this);
        this.f16794b = kVar == null ? new k() : kVar;
        this.f16793a = mVar == null ? new m() : mVar;
        this.f16796d = bVar == null ? new b(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this) : bVar;
        this.f16799g = aVar2 == null ? new a(cVar) : aVar2;
        this.f16797e = qVar == null ? new q() : qVar;
        memoryCache.setResourceRemovedListener(this);
    }
}
