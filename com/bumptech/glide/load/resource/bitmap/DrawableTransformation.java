package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class DrawableTransformation implements Transformation<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Transformation<Bitmap> f17245a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17246b;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z3) {
        this.f17245a = transformation;
        this.f17246b = z3;
    }

    private Resource<Drawable> a(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.obtain(context.getResources(), resource);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f17245a.equals(((DrawableTransformation) obj).f17245a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f17245a.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<Drawable> transform(@NonNull Context context, @NonNull Resource<Drawable> resource, int i4, int i5) {
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Drawable drawable = resource.get();
        Resource<Bitmap> a4 = a.a(bitmapPool, drawable, i4, i5);
        if (a4 == null) {
            if (!this.f17246b) {
                return resource;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        Resource<Bitmap> transform = this.f17245a.transform(context, a4, i4, i5);
        if (transform.equals(a4)) {
            transform.recycle();
            return resource;
        }
        return a(context, transform);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f17245a.updateDiskCacheKey(messageDigest);
    }

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }
}
