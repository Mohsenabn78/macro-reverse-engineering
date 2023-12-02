package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* loaded from: classes3.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f17338a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceTranscoder<Bitmap, byte[]> f17339b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<GifDrawable, byte[]> f17340c;

    public DrawableBytesTranscoder(@NonNull BitmapPool bitmapPool, @NonNull ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, @NonNull ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f17338a = bitmapPool;
        this.f17339b = resourceTranscoder;
        this.f17340c = resourceTranscoder2;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    public Resource<byte[]> transcode(@NonNull Resource<Drawable> resource, @NonNull Options options) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f17339b.transcode(BitmapResource.obtain(((BitmapDrawable) drawable).getBitmap(), this.f17338a), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.f17340c.transcode(a(resource), options);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static Resource<GifDrawable> a(@NonNull Resource<Drawable> resource) {
        return resource;
    }
}
