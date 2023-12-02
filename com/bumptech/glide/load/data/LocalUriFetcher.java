package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f16770a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f16771b;

    /* renamed from: c  reason: collision with root package name */
    private T f16772c;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f16771b = contentResolver;
        this.f16770a = uri;
    }

    protected abstract void a(T t3) throws IOException;

    protected abstract T b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t3 = this.f16772c;
        if (t3 != null) {
            try {
                a(t3);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T b4 = b(this.f16770a, this.f16771b);
            this.f16772c = b4;
            dataCallback.onDataReady(b4);
        } catch (FileNotFoundException e4) {
            Log.isLoggable("LocalUriFetcher", 3);
            dataCallback.onLoadFailed(e4);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }
}
