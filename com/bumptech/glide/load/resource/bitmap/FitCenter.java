package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class FitCenter extends BitmapTransformation {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f17247a = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(Key.CHARSET);

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i4, int i5) {
        return TransformationUtils.fitCenter(bitmapPool, bitmap, i4, i5);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1572326941;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f17247a);
    }
}
