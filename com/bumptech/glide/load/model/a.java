package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: MultiModelLoader.java */
/* loaded from: classes3.dex */
class a<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader<Model, Data>> f17195a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17196b;

    /* compiled from: MultiModelLoader.java */
    /* renamed from: com.bumptech.glide.load.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0141a<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<DataFetcher<Data>> f17197a;

        /* renamed from: b  reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f17198b;

        /* renamed from: c  reason: collision with root package name */
        private int f17199c;

        /* renamed from: d  reason: collision with root package name */
        private Priority f17200d;

        /* renamed from: e  reason: collision with root package name */
        private DataFetcher.DataCallback<? super Data> f17201e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private List<Throwable> f17202f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f17203g;

        C0141a(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f17198b = pool;
            Preconditions.checkNotEmpty(list);
            this.f17197a = list;
            this.f17199c = 0;
        }

        private void a() {
            if (this.f17203g) {
                return;
            }
            if (this.f17199c < this.f17197a.size() - 1) {
                this.f17199c++;
                loadData(this.f17200d, this.f17201e);
                return;
            }
            Preconditions.checkNotNull(this.f17202f);
            this.f17201e.onLoadFailed(new GlideException("Fetch failed", new ArrayList(this.f17202f)));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.f17203g = true;
            for (DataFetcher<Data> dataFetcher : this.f17197a) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            List<Throwable> list = this.f17202f;
            if (list != null) {
                this.f17198b.release(list);
            }
            this.f17202f = null;
            for (DataFetcher<Data> dataFetcher : this.f17197a) {
                dataFetcher.cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> getDataClass() {
            return this.f17197a.get(0).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return this.f17197a.get(0).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            this.f17200d = priority;
            this.f17201e = dataCallback;
            this.f17202f = this.f17198b.acquire();
            this.f17197a.get(this.f17199c).loadData(priority, this);
            if (this.f17203g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(@Nullable Data data) {
            if (data != null) {
                this.f17201e.onDataReady(data);
            } else {
                a();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(@NonNull Exception exc) {
            ((List) Preconditions.checkNotNull(this.f17202f)).add(exc);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f17195a = list;
        this.f17196b = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model model2, int i4, int i5, @NonNull Options options) {
        ModelLoader.LoadData<Data> buildLoadData;
        int size = this.f17195a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i6 = 0; i6 < size; i6++) {
            ModelLoader<Model, Data> modelLoader = this.f17195a.get(i6);
            if (modelLoader.handles(model2) && (buildLoadData = modelLoader.buildLoadData(model2, i4, i5, options)) != null) {
                key = buildLoadData.sourceKey;
                arrayList.add(buildLoadData.fetcher);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(key, new C0141a(arrayList, this.f17196b));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model model2) {
        for (ModelLoader<Model, Data> modelLoader : this.f17195a) {
            if (modelLoader.handles(model2)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f17195a.toArray()) + '}';
    }
}
