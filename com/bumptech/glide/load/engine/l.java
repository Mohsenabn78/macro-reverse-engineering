package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* compiled from: EngineResource.java */
/* loaded from: classes3.dex */
class l<Z> implements Resource<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17046a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17047b;

    /* renamed from: c  reason: collision with root package name */
    private final Resource<Z> f17048c;

    /* renamed from: d  reason: collision with root package name */
    private a f17049d;

    /* renamed from: e  reason: collision with root package name */
    private Key f17050e;

    /* renamed from: f  reason: collision with root package name */
    private int f17051f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17052g;

    /* compiled from: EngineResource.java */
    /* loaded from: classes3.dex */
    interface a {
        void onResourceReleased(Key key, l<?> lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Resource<Z> resource, boolean z3, boolean z4) {
        this.f17048c = (Resource) Preconditions.checkNotNull(resource);
        this.f17046a = z3;
        this.f17047b = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        if (!this.f17052g) {
            this.f17051f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resource<Z> b() {
        return this.f17048c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f17046a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        synchronized (this.f17049d) {
            synchronized (this) {
                int i4 = this.f17051f;
                if (i4 > 0) {
                    int i5 = i4 - 1;
                    this.f17051f = i5;
                    if (i5 == 0) {
                        this.f17049d.onResourceReleased(this.f17050e, this);
                    }
                } else {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void e(Key key, a aVar) {
        this.f17050e = key;
        this.f17049d = aVar;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.f17048c.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        return this.f17048c.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f17048c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        if (this.f17051f <= 0) {
            if (!this.f17052g) {
                this.f17052g = true;
                if (this.f17047b) {
                    this.f17048c.recycle();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f17046a + ", listener=" + this.f17049d + ", key=" + this.f17050e + ", acquired=" + this.f17051f + ", isRecycled=" + this.f17052g + ", resource=" + this.f17048c + '}';
    }
}
