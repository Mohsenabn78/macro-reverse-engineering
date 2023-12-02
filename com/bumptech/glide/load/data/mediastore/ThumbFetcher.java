package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f16774a;

    /* renamed from: b  reason: collision with root package name */
    private final c f16775b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f16776c;

    /* loaded from: classes3.dex */
    static class a implements com.bumptech.glide.load.data.mediastore.b {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f16777b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f16778a;

        a(ContentResolver contentResolver) {
            this.f16778a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.b
        public Cursor a(Uri uri) {
            return this.f16778a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f16777b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: classes3.dex */
    static class b implements com.bumptech.glide.load.data.mediastore.b {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f16779b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f16780a;

        b(ContentResolver contentResolver) {
            this.f16780a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.b
        public Cursor a(Uri uri) {
            return this.f16780a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f16779b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    ThumbFetcher(Uri uri, c cVar) {
        this.f16774a = uri;
        this.f16775b = cVar;
    }

    private static ThumbFetcher a(Context context, Uri uri, com.bumptech.glide.load.data.mediastore.b bVar) {
        return new ThumbFetcher(uri, new c(Glide.get(context).getRegistry().getImageHeaderParsers(), bVar, Glide.get(context).getArrayPool(), context.getContentResolver()));
    }

    private InputStream b() throws FileNotFoundException {
        int i4;
        InputStream d4 = this.f16775b.d(this.f16774a);
        if (d4 != null) {
            i4 = this.f16775b.a(this.f16774a);
        } else {
            i4 = -1;
        }
        if (i4 != -1) {
            return new ExifOrientationStream(d4, i4);
        }
        return d4;
    }

    public static ThumbFetcher buildImageFetcher(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.f16776c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream b4 = b();
            this.f16776c = b4;
            dataCallback.onDataReady(b4);
        } catch (FileNotFoundException e4) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            dataCallback.onLoadFailed(e4);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }
}
