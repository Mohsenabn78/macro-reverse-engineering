package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class Rotate extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f17258b = "com.bumptech.glide.load.resource.bitmap.Rotate".getBytes(Key.CHARSET);

    /* renamed from: a  reason: collision with root package name */
    private final int f17259a;

    public Rotate(int i4) {
        this.f17259a = i4;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i4, int i5) {
        return TransformationUtils.rotateImage(bitmap, this.f17259a);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof Rotate) || this.f17259a != ((Rotate) obj).f17259a) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(-950519196, Util.hashCode(this.f17259a));
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f17258b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f17259a).array());
    }
}
