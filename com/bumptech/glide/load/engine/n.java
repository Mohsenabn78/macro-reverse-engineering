package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockedResource.java */
/* loaded from: classes3.dex */
public final class n<Z> implements Resource<Z>, FactoryPools.Poolable {

    /* renamed from: e  reason: collision with root package name */
    private static final Pools.Pool<n<?>> f17055e = FactoryPools.threadSafe(20, new a());

    /* renamed from: a  reason: collision with root package name */
    private final StateVerifier f17056a = StateVerifier.newInstance();

    /* renamed from: b  reason: collision with root package name */
    private Resource<Z> f17057b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17058c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17059d;

    /* compiled from: LockedResource.java */
    /* loaded from: classes3.dex */
    class a implements FactoryPools.Factory<n<?>> {
        a() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        /* renamed from: a */
        public n<?> create() {
            return new n<>();
        }
    }

    n() {
    }

    private void a(Resource<Z> resource) {
        this.f17059d = false;
        this.f17058c = true;
        this.f17057b = resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <Z> n<Z> b(Resource<Z> resource) {
        n<Z> nVar = (n) Preconditions.checkNotNull(f17055e.acquire());
        nVar.a(resource);
        return nVar;
    }

    private void c() {
        this.f17057b = null;
        f17055e.release(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d() {
        this.f17056a.throwIfRecycled();
        if (this.f17058c) {
            this.f17058c = false;
            if (this.f17059d) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.f17057b.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        return this.f17057b.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f17057b.getSize();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.f17056a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        this.f17056a.throwIfRecycled();
        this.f17059d = true;
        if (!this.f17058c) {
            this.f17057b.recycle();
            c();
        }
    }
}
