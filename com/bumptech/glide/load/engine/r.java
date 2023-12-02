package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SourceGenerator.java */
/* loaded from: classes3.dex */
public class r implements DataFetcherGenerator, DataFetcher.DataCallback<Object>, DataFetcherGenerator.FetcherReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    private final f<?> f17109a;

    /* renamed from: b  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f17110b;

    /* renamed from: c  reason: collision with root package name */
    private int f17111c;

    /* renamed from: d  reason: collision with root package name */
    private c f17112d;

    /* renamed from: e  reason: collision with root package name */
    private Object f17113e;

    /* renamed from: f  reason: collision with root package name */
    private volatile ModelLoader.LoadData<?> f17114f;

    /* renamed from: g  reason: collision with root package name */
    private d f17115g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(f<?> fVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.f17109a = fVar;
        this.f17110b = fetcherReadyCallback;
    }

    private void b(Object obj) {
        long logTime = LogTime.getLogTime();
        try {
            Encoder<X> p4 = this.f17109a.p(obj);
            e eVar = new e(p4, obj, this.f17109a.k());
            this.f17115g = new d(this.f17114f.sourceKey, this.f17109a.o());
            this.f17109a.d().put(this.f17115g, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Finished encoding source to cache, key: ");
                sb.append(this.f17115g);
                sb.append(", data: ");
                sb.append(obj);
                sb.append(", encoder: ");
                sb.append(p4);
                sb.append(", duration: ");
                sb.append(LogTime.getElapsedMillis(logTime));
            }
            this.f17114f.fetcher.cleanup();
            this.f17112d = new c(Collections.singletonList(this.f17114f.sourceKey), this.f17109a, this);
        } catch (Throwable th) {
            this.f17114f.fetcher.cleanup();
            throw th;
        }
    }

    private boolean c() {
        if (this.f17111c < this.f17109a.g().size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean a() {
        Object obj = this.f17113e;
        if (obj != null) {
            this.f17113e = null;
            b(obj);
        }
        c cVar = this.f17112d;
        if (cVar != null && cVar.a()) {
            return true;
        }
        this.f17112d = null;
        this.f17114f = null;
        boolean z3 = false;
        while (!z3 && c()) {
            List<ModelLoader.LoadData<?>> g4 = this.f17109a.g();
            int i4 = this.f17111c;
            this.f17111c = i4 + 1;
            this.f17114f = g4.get(i4);
            if (this.f17114f != null && (this.f17109a.e().isDataCacheable(this.f17114f.fetcher.getDataSource()) || this.f17109a.t(this.f17114f.fetcher.getDataClass()))) {
                this.f17114f.fetcher.loadData(this.f17109a.l(), this);
                z3 = true;
            }
        }
        return z3;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f17114f;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f17110b.onDataFetcherFailed(key, exc, dataFetcher, this.f17114f.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f17110b.onDataFetcherReady(key, obj, dataFetcher, this.f17114f.fetcher.getDataSource(), key);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        DiskCacheStrategy e4 = this.f17109a.e();
        if (obj != null && e4.isDataCacheable(this.f17114f.fetcher.getDataSource())) {
            this.f17113e = obj;
            this.f17110b.reschedule();
            return;
        }
        this.f17110b.onDataFetcherReady(this.f17114f.sourceKey, obj, this.f17114f.fetcher, this.f17114f.fetcher.getDataSource(), this.f17115g);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        this.f17110b.onDataFetcherFailed(this.f17115g, exc, this.f17114f.fetcher, this.f17114f.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        throw new UnsupportedOperationException();
    }
}
