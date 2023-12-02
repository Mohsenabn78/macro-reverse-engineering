package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f16746a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f16747b;

    /* renamed from: c  reason: collision with root package name */
    private T f16748c;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f16747b = assetManager;
        this.f16746a = str;
    }

    protected abstract void a(T t3) throws IOException;

    protected abstract T b(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t3 = this.f16748c;
        if (t3 == null) {
            return;
        }
        try {
            a(t3);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T b4 = b(this.f16747b, this.f16746a);
            this.f16748c = b4;
            dataCallback.onDataReady(b4);
        } catch (IOException e4) {
            Log.isLoggable("AssetPathFetcher", 3);
            dataCallback.onLoadFailed(e4);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }
}
