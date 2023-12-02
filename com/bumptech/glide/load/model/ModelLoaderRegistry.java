package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ModelLoaderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final MultiModelLoaderFactory f17164a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17165b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C0140a<?>> f17166a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bumptech.glide.load.model.ModelLoaderRegistry$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0140a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<ModelLoader<Model, ?>> f17167a;

            public C0140a(List<ModelLoader<Model, ?>> list) {
                this.f17167a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f17166a.clear();
        }

        @Nullable
        public <Model> List<ModelLoader<Model, ?>> b(Class<Model> cls) {
            C0140a<?> c0140a = this.f17166a.get(cls);
            if (c0140a == null) {
                return null;
            }
            return (List<ModelLoader<Model, ?>>) c0140a.f17167a;
        }

        public <Model> void c(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.f17166a.put(cls, new C0140a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public ModelLoaderRegistry(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    @NonNull
    private static <A> Class<A> a(@NonNull A a4) {
        return (Class<A>) a4.getClass();
    }

    @NonNull
    private synchronized <A> List<ModelLoader<A, ?>> b(@NonNull Class<A> cls) {
        List<ModelLoader<A, ?>> b4;
        b4 = this.f17165b.b(cls);
        if (b4 == null) {
            b4 = Collections.unmodifiableList(this.f17164a.d(cls));
            this.f17165b.c(cls, b4);
        }
        return b4;
    }

    private <Model, Data> void c(@NonNull List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        for (ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory : list) {
            modelLoaderFactory.teardown();
        }
    }

    public synchronized <Model, Data> void append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f17164a.b(cls, cls2, modelLoaderFactory);
        this.f17165b.a();
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f17164a.build(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> cls) {
        return this.f17164a.f(cls);
    }

    @NonNull
    public <A> List<ModelLoader<A, ?>> getModelLoaders(@NonNull A a4) {
        List<ModelLoader<A, ?>> b4 = b(a(a4));
        int size = b4.size();
        List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
        boolean z3 = true;
        for (int i4 = 0; i4 < size; i4++) {
            ModelLoader<A, ?> modelLoader = b4.get(i4);
            if (modelLoader.handles(a4)) {
                if (z3) {
                    emptyList = new ArrayList<>(size - i4);
                    z3 = false;
                }
                emptyList.add(modelLoader);
            }
        }
        return emptyList;
    }

    public synchronized <Model, Data> void prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f17164a.h(cls, cls2, modelLoaderFactory);
        this.f17165b.a();
    }

    public synchronized <Model, Data> void remove(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        c(this.f17164a.i(cls, cls2));
        this.f17165b.a();
    }

    public synchronized <Model, Data> void replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        c(this.f17164a.j(cls, cls2, modelLoaderFactory));
        this.f17165b.a();
    }

    private ModelLoaderRegistry(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
        this.f17165b = new a();
        this.f17164a = multiModelLoaderFactory;
    }
}
