package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class FactoryPools {

    /* renamed from: a  reason: collision with root package name */
    private static final Resetter<Object> f17590a = new a();

    /* loaded from: classes3.dex */
    public interface Factory<T> {
        T create();
    }

    /* loaded from: classes3.dex */
    public interface Poolable {
        @NonNull
        StateVerifier getVerifier();
    }

    /* loaded from: classes3.dex */
    public interface Resetter<T> {
        void reset(@NonNull T t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes3.dex */
    public class b<T> implements Factory<List<T>> {
        b() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        @NonNull
        /* renamed from: a */
        public List<T> create() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes3.dex */
    public class c<T> implements Resetter<List<T>> {
        c() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        /* renamed from: a */
        public void reset(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class d<T> implements Pools.Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Factory<T> f17591a;

        /* renamed from: b  reason: collision with root package name */
        private final Resetter<T> f17592b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools.Pool<T> f17593c;

        d(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.f17593c = pool;
            this.f17591a = factory;
            this.f17592b = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f17593c.acquire();
            if (acquire == null) {
                acquire = this.f17591a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Created new ");
                    sb.append(acquire.getClass());
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).getVerifier().a(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t3) {
            if (t3 instanceof Poolable) {
                ((Poolable) t3).getVerifier().a(true);
            }
            this.f17592b.reset(t3);
            return this.f17593c.release(t3);
        }
    }

    private FactoryPools() {
    }

    @NonNull
    private static <T extends Poolable> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory) {
        return b(pool, factory, c());
    }

    @NonNull
    private static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new d(pool, factory, resetter);
    }

    @NonNull
    private static <T> Resetter<T> c() {
        return (Resetter<T>) f17590a;
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> simple(int i4, @NonNull Factory<T> factory) {
        return a(new Pools.SimplePool(i4), factory);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> threadSafe(int i4, @NonNull Factory<T> factory) {
        return a(new Pools.SynchronizedPool(i4), factory);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList(int i4) {
        return b(new Pools.SynchronizedPool(i4), new b(), new c());
    }

    /* loaded from: classes3.dex */
    class a implements Resetter<Object> {
        a() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(@NonNull Object obj) {
        }
    }
}
