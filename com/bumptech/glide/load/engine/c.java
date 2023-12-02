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
/* compiled from: DataCacheGenerator.java */
/* loaded from: classes3.dex */
public class c implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final List<Key> f16875a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f16876b;

    /* renamed from: c  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f16877c;

    /* renamed from: d  reason: collision with root package name */
    private int f16878d;

    /* renamed from: e  reason: collision with root package name */
    private Key f16879e;

    /* renamed from: f  reason: collision with root package name */
    private List<ModelLoader<File, ?>> f16880f;

    /* renamed from: g  reason: collision with root package name */
    private int f16881g;

    /* renamed from: h  reason: collision with root package name */
    private volatile ModelLoader.LoadData<?> f16882h;

    /* renamed from: i  reason: collision with root package name */
    private File f16883i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f<?> fVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(fVar.c(), fVar, fetcherReadyCallback);
    }

    private boolean b() {
        if (this.f16881g < this.f16880f.size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean a() {
        while (true) {
            boolean z3 = false;
            if (this.f16880f != null && b()) {
                this.f16882h = null;
                while (!z3 && b()) {
                    List<ModelLoader<File, ?>> list = this.f16880f;
                    int i4 = this.f16881g;
                    this.f16881g = i4 + 1;
                    this.f16882h = list.get(i4).buildLoadData(this.f16883i, this.f16876b.s(), this.f16876b.f(), this.f16876b.k());
                    if (this.f16882h != null && this.f16876b.t(this.f16882h.fetcher.getDataClass())) {
                        this.f16882h.fetcher.loadData(this.f16876b.l(), this);
                        z3 = true;
                    }
                }
                return z3;
            }
            int i5 = this.f16878d + 1;
            this.f16878d = i5;
            if (i5 >= this.f16875a.size()) {
                return false;
            }
            Key key = this.f16875a.get(this.f16878d);
            File file = this.f16876b.d().get(new d(key, this.f16876b.o()));
            this.f16883i = file;
            if (file != null) {
                this.f16879e = key;
                this.f16880f = this.f16876b.j(file);
                this.f16881g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f16882h;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        this.f16877c.onDataFetcherReady(this.f16879e, obj, this.f16882h.fetcher, DataSource.DATA_DISK_CACHE, this.f16879e);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        this.f16877c.onDataFetcherFailed(this.f16879e, exc, this.f16882h.fetcher, DataSource.DATA_DISK_CACHE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<Key> list, f<?> fVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f16878d = -1;
        this.f16875a = list;
        this.f16876b = fVar;
        this.f16877c = fetcherReadyCallback;
    }
}
