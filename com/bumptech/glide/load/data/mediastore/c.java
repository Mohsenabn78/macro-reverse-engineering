package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes3.dex */
class c {

    /* renamed from: f  reason: collision with root package name */
    private static final a f16781f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final a f16782a;

    /* renamed from: b  reason: collision with root package name */
    private final b f16783b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f16784c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f16785d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ImageHeaderParser> f16786e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<ImageHeaderParser> list, b bVar, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, f16781f, bVar, arrayPool, contentResolver);
    }

    @Nullable
    private String b(@NonNull Uri uri) {
        Cursor a4 = this.f16783b.a(uri);
        if (a4 != null) {
            try {
                if (a4.moveToFirst()) {
                    return a4.getString(0);
                }
            } finally {
                a4.close();
            }
        }
        return a4 != null ? null : null;
    }

    private boolean c(File file) {
        if (this.f16782a.a(file) && 0 < this.f16782a.c(file)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f16785d.openInputStream(uri);
                int orientation = ImageHeaderParserUtils.getOrientation(this.f16786e, inputStream, this.f16784c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return orientation;
            } catch (IOException | NullPointerException unused2) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to open uri: ");
                    sb.append(uri);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException unused3) {
                        return -1;
                    }
                }
                return -1;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b4 = b(uri);
        if (TextUtils.isEmpty(b4)) {
            return null;
        }
        File b5 = this.f16782a.b(b4);
        if (!c(b5)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b5);
        try {
            return this.f16785d.openInputStream(fromFile);
        } catch (NullPointerException e4) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e4));
        }
    }

    c(List<ImageHeaderParser> list, a aVar, b bVar, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.f16782a = aVar;
        this.f16783b = bVar;
        this.f16784c = arrayPool;
        this.f16785d = contentResolver;
        this.f16786e = list;
    }
}
