package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourceCacheGenerator.java */
/* loaded from: classes3.dex */
public class o implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f17060a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f17061b;

    /* renamed from: c  reason: collision with root package name */
    private int f17062c;

    /* renamed from: d  reason: collision with root package name */
    private int f17063d = -1;

    /* renamed from: e  reason: collision with root package name */
    private Key f17064e;

    /* renamed from: f  reason: collision with root package name */
    private List<ModelLoader<File, ?>> f17065f;

    /* renamed from: g  reason: collision with root package name */
    private int f17066g;

    /* renamed from: h  reason: collision with root package name */
    private volatile ModelLoader.LoadData<?> f17067h;

    /* renamed from: i  reason: collision with root package name */
    private File f17068i;

    /* renamed from: j  reason: collision with root package name */
    private p f17069j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f<?> fVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f17061b = fVar;
        this.f17060a = fetcherReadyCallback;
    }

    private boolean b() {
        if (this.f17066g < this.f17065f.size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean a() {
        List<Key> c4 = this.f17061b.c();
        boolean z3 = false;
        if (c4.isEmpty()) {
            return false;
        }
        List<Class<?>> m4 = this.f17061b.m();
        if (m4.isEmpty()) {
            if (File.class.equals(this.f17061b.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f17061b.i() + " to " + this.f17061b.q());
        }
        while (true) {
            if (this.f17065f != null && b()) {
                this.f17067h = null;
                while (!z3 && b()) {
                    List<ModelLoader<File, ?>> list = this.f17065f;
                    int i4 = this.f17066g;
                    this.f17066g = i4 + 1;
                    this.f17067h = list.get(i4).buildLoadData(this.f17068i, this.f17061b.s(), this.f17061b.f(), this.f17061b.k());
                    if (this.f17067h != null && this.f17061b.t(this.f17067h.fetcher.getDataClass())) {
                        this.f17067h.fetcher.loadData(this.f17061b.l(), this);
                        z3 = true;
                    }
                }
                return z3;
            }
            int i5 = this.f17063d + 1;
            this.f17063d = i5;
            if (i5 >= m4.size()) {
                int i6 = this.f17062c + 1;
                this.f17062c = i6;
                if (i6 >= c4.size()) {
                    return false;
                }
                this.f17063d = 0;
            }
            Key key = c4.get(this.f17062c);
            Class<?> cls = m4.get(this.f17063d);
            this.f17069j = new p(this.f17061b.b(), key, this.f17061b.o(), this.f17061b.s(), this.f17061b.f(), this.f17061b.r(cls), cls, this.f17061b.k());
            File file = this.f17061b.d().get(this.f17069j);
            this.f17068i = file;
            if (file != null) {
                this.f17064e = key;
                this.f17065f = this.f17061b.j(file);
                this.f17066g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f17067h;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        this.f17060a.onDataFetcherReady(this.f17064e, obj, this.f17067h.fetcher, DataSource.RESOURCE_DISK_CACHE, this.f17069j);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        this.f17060a.onDataFetcherFailed(this.f17069j, exc, this.f17067h.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }
}
