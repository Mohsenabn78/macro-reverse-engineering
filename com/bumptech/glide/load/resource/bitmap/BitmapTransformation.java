package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

/* loaded from: classes3.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    protected abstract Bitmap a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i4, int i5);

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public final Resource<Bitmap> transform(@NonNull Context context, @NonNull Resource<Bitmap> resource, int i4, int i5) {
        if (Util.isValidDimensions(i4, i5)) {
            BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
            Bitmap bitmap = resource.get();
            if (i4 == Integer.MIN_VALUE) {
                i4 = bitmap.getWidth();
            }
            if (i5 == Integer.MIN_VALUE) {
                i5 = bitmap.getHeight();
            }
            Bitmap a4 = a(bitmapPool, bitmap, i4, i5);
            if (!bitmap.equals(a4)) {
                return BitmapResource.obtain(a4, bitmapPool);
            }
            return resource;
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i4 + " or height: " + i5 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
