package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EngineJob.java */
/* loaded from: classes3.dex */
class h<R> implements g.b<R>, FactoryPools.Poolable {

    /* renamed from: x  reason: collision with root package name */
    private static final c f17006x = new c();

    /* renamed from: a  reason: collision with root package name */
    final e f17007a;

    /* renamed from: b  reason: collision with root package name */
    private final StateVerifier f17008b;

    /* renamed from: c  reason: collision with root package name */
    private final Pools.Pool<h<?>> f17009c;

    /* renamed from: d  reason: collision with root package name */
    private final c f17010d;

    /* renamed from: e  reason: collision with root package name */
    private final i f17011e;

    /* renamed from: f  reason: collision with root package name */
    private final GlideExecutor f17012f;

    /* renamed from: g  reason: collision with root package name */
    private final GlideExecutor f17013g;

    /* renamed from: h  reason: collision with root package name */
    private final GlideExecutor f17014h;

    /* renamed from: i  reason: collision with root package name */
    private final GlideExecutor f17015i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInteger f17016j;

    /* renamed from: k  reason: collision with root package name */
    private Key f17017k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f17018l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17019m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f17020n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f17021o;

    /* renamed from: p  reason: collision with root package name */
    private Resource<?> f17022p;

    /* renamed from: q  reason: collision with root package name */
    DataSource f17023q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f17024r;

    /* renamed from: s  reason: collision with root package name */
    GlideException f17025s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17026t;

    /* renamed from: u  reason: collision with root package name */
    l<?> f17027u;

    /* renamed from: v  reason: collision with root package name */
    private g<R> f17028v;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f17029w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ResourceCallback f17030a;

        a(ResourceCallback resourceCallback) {
            this.f17030a = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (h.this) {
                if (h.this.f17007a.b(this.f17030a)) {
                    h.this.c(this.f17030a);
                }
                h.this.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ResourceCallback f17032a;

        b(ResourceCallback resourceCallback) {
            this.f17032a = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (h.this) {
                if (h.this.f17007a.b(this.f17032a)) {
                    h.this.f17027u.a();
                    h.this.d(this.f17032a);
                    h.this.o(this.f17032a);
                }
                h.this.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class c {
        c() {
        }

        public <R> l<R> a(Resource<R> resource, boolean z3) {
            return new l<>(resource, z3, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        final ResourceCallback f17034a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f17035b;

        d(ResourceCallback resourceCallback, Executor executor) {
            this.f17034a = resourceCallback;
            this.f17035b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f17034a.equals(((d) obj).f17034a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17034a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes3.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f17036a;

        e() {
            this(new ArrayList(2));
        }

        private static d d(ResourceCallback resourceCallback) {
            return new d(resourceCallback, Executors.directExecutor());
        }

        void a(ResourceCallback resourceCallback, Executor executor) {
            this.f17036a.add(new d(resourceCallback, executor));
        }

        boolean b(ResourceCallback resourceCallback) {
            return this.f17036a.contains(d(resourceCallback));
        }

        e c() {
            return new e(new ArrayList(this.f17036a));
        }

        void clear() {
            this.f17036a.clear();
        }

        void e(ResourceCallback resourceCallback) {
            this.f17036a.remove(d(resourceCallback));
        }

        boolean isEmpty() {
            return this.f17036a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f17036a.iterator();
        }

        int size() {
            return this.f17036a.size();
        }

        e(List<d> list) {
            this.f17036a = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, i iVar, Pools.Pool<h<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, iVar, pool, f17006x);
    }

    private GlideExecutor g() {
        if (this.f17019m) {
            return this.f17014h;
        }
        if (this.f17020n) {
            return this.f17015i;
        }
        return this.f17013g;
    }

    private boolean j() {
        if (!this.f17026t && !this.f17024r && !this.f17029w) {
            return false;
        }
        return true;
    }

    private synchronized void n() {
        if (this.f17017k != null) {
            this.f17007a.clear();
            this.f17017k = null;
            this.f17027u = null;
            this.f17022p = null;
            this.f17026t = false;
            this.f17029w = false;
            this.f17024r = false;
            this.f17028v.s(false);
            this.f17028v = null;
            this.f17025s = null;
            this.f17023q = null;
            this.f17009c.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bumptech.glide.load.engine.g.b
    public void a(g<?> gVar) {
        g().execute(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(ResourceCallback resourceCallback, Executor executor) {
        this.f17008b.throwIfRecycled();
        this.f17007a.a(resourceCallback, executor);
        boolean z3 = true;
        if (this.f17024r) {
            h(1);
            executor.execute(new b(resourceCallback));
        } else if (this.f17026t) {
            h(1);
            executor.execute(new a(resourceCallback));
        } else {
            if (this.f17029w) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    synchronized void c(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onLoadFailed(this.f17025s);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    synchronized void d(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onResourceReady(this.f17027u, this.f17023q);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    void e() {
        if (j()) {
            return;
        }
        this.f17029w = true;
        this.f17028v.a();
        this.f17011e.onEngineJobCancelled(this, this.f17017k);
    }

    synchronized void f() {
        boolean z3;
        this.f17008b.throwIfRecycled();
        Preconditions.checkArgument(j(), "Not yet complete!");
        int decrementAndGet = this.f17016j.decrementAndGet();
        if (decrementAndGet >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            l<?> lVar = this.f17027u;
            if (lVar != null) {
                lVar.d();
            }
            n();
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.f17008b;
    }

    synchronized void h(int i4) {
        l<?> lVar;
        Preconditions.checkArgument(j(), "Not yet complete!");
        if (this.f17016j.getAndAdd(i4) == 0 && (lVar = this.f17027u) != null) {
            lVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized h<R> i(Key key, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f17017k = key;
        this.f17018l = z3;
        this.f17019m = z4;
        this.f17020n = z5;
        this.f17021o = z6;
        return this;
    }

    void k() {
        synchronized (this) {
            this.f17008b.throwIfRecycled();
            if (this.f17029w) {
                n();
            } else if (!this.f17007a.isEmpty()) {
                if (!this.f17026t) {
                    this.f17026t = true;
                    Key key = this.f17017k;
                    e c4 = this.f17007a.c();
                    h(c4.size() + 1);
                    this.f17011e.onEngineJobComplete(this, key, null);
                    Iterator<d> it = c4.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f17035b.execute(new a(next.f17034a));
                    }
                    f();
                    return;
                }
                throw new IllegalStateException("Already failed once");
            } else {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
        }
    }

    void l() {
        synchronized (this) {
            this.f17008b.throwIfRecycled();
            if (this.f17029w) {
                this.f17022p.recycle();
                n();
            } else if (!this.f17007a.isEmpty()) {
                if (!this.f17024r) {
                    this.f17027u = this.f17010d.a(this.f17022p, this.f17018l);
                    this.f17024r = true;
                    e c4 = this.f17007a.c();
                    h(c4.size() + 1);
                    this.f17011e.onEngineJobComplete(this, this.f17017k, this.f17027u);
                    Iterator<d> it = c4.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f17035b.execute(new b(next.f17034a));
                    }
                    f();
                    return;
                }
                throw new IllegalStateException("Already have resource");
            } else {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.f17021o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void o(ResourceCallback resourceCallback) {
        boolean z3;
        this.f17008b.throwIfRecycled();
        this.f17007a.e(resourceCallback);
        if (this.f17007a.isEmpty()) {
            e();
            if (!this.f17024r && !this.f17026t) {
                z3 = false;
                if (z3 && this.f17016j.get() == 0) {
                    n();
                }
            }
            z3 = true;
            if (z3) {
                n();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.g.b
    public void onLoadFailed(GlideException glideException) {
        synchronized (this) {
            this.f17025s = glideException;
        }
        k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.g.b
    public void onResourceReady(Resource<R> resource, DataSource dataSource) {
        synchronized (this) {
            this.f17022p = resource;
            this.f17023q = dataSource;
        }
        l();
    }

    public synchronized void p(g<R> gVar) {
        GlideExecutor g4;
        this.f17028v = gVar;
        if (gVar.y()) {
            g4 = this.f17012f;
        } else {
            g4 = g();
        }
        g4.execute(gVar);
    }

    @VisibleForTesting
    h(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, i iVar, Pools.Pool<h<?>> pool, c cVar) {
        this.f17007a = new e();
        this.f17008b = StateVerifier.newInstance();
        this.f17016j = new AtomicInteger();
        this.f17012f = glideExecutor;
        this.f17013g = glideExecutor2;
        this.f17014h = glideExecutor3;
        this.f17015i = glideExecutor4;
        this.f17011e = iVar;
        this.f17009c = pool;
        this.f17010d = cVar;
    }
}
