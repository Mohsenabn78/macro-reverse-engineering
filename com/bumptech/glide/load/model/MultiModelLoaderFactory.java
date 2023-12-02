package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class MultiModelLoaderFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final c f17168e = new c();

    /* renamed from: f  reason: collision with root package name */
    private static final ModelLoader<Object, Object> f17169f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<b<?, ?>> f17170a;

    /* renamed from: b  reason: collision with root package name */
    private final c f17171b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<b<?, ?>> f17172c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17173d;

    /* loaded from: classes3.dex */
    private static class a implements ModelLoader<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        @Nullable
        public ModelLoader.LoadData<Object> buildLoadData(@NonNull Object obj, int i4, int i5, @NonNull Options options) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(@NonNull Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Model> f17174a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f17175b;

        /* renamed from: c  reason: collision with root package name */
        final ModelLoaderFactory<? extends Model, ? extends Data> f17176c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.f17174a = cls;
            this.f17175b = cls2;
            this.f17176c = modelLoaderFactory;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f17174a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (a(cls) && this.f17175b.isAssignableFrom(cls2)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    static class c {
        c() {
        }

        @NonNull
        public <Model, Data> com.bumptech.glide.load.model.a<Model, Data> a(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new com.bumptech.glide.load.model.a<>(list, pool);
        }
    }

    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f17168e);
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z3) {
        int i4;
        b<?, ?> bVar = new b<>(cls, cls2, modelLoaderFactory);
        List<b<?, ?>> list = this.f17170a;
        if (z3) {
            i4 = list.size();
        } else {
            i4 = 0;
        }
        list.add(i4, bVar);
    }

    @NonNull
    private <Model, Data> ModelLoader<Model, Data> c(@NonNull b<?, ?> bVar) {
        return (ModelLoader) Preconditions.checkNotNull(bVar.f17176c.build(this));
    }

    @NonNull
    private static <Model, Data> ModelLoader<Model, Data> e() {
        return (ModelLoader<Model, Data>) f17169f;
    }

    @NonNull
    private <Model, Data> ModelLoaderFactory<Model, Data> g(@NonNull b<?, ?> bVar) {
        return (ModelLoaderFactory<Model, Data>) bVar.f17176c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        a(cls, cls2, modelLoaderFactory, true);
    }

    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z3 = false;
            for (b<?, ?> bVar : this.f17170a) {
                if (this.f17172c.contains(bVar)) {
                    z3 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f17172c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f17172c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f17171b.a(arrayList, this.f17173d);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z3) {
                return e();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f17172c.clear();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model> List<ModelLoader<Model, ?>> d(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f17170a) {
                if (!this.f17172c.contains(bVar) && bVar.a(cls)) {
                    this.f17172c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f17172c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f17172c.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized List<Class<?>> f(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f17170a) {
            if (!arrayList.contains(bVar.f17175b) && bVar.a(cls)) {
                arrayList.add(bVar.f17175b);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void h(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        a(cls, cls2, modelLoaderFactory, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f17170a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.b(cls, cls2)) {
                it.remove();
                arrayList.add(g(next));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> i4;
        i4 = i(cls, cls2);
        b(cls, cls2, modelLoaderFactory);
        return i4;
    }

    @VisibleForTesting
    MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f17170a = new ArrayList();
        this.f17172c = new HashSet();
        this.f17173d = pool;
        this.f17171b = cVar;
    }
}
