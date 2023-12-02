package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

/* compiled from: DrawableToBitmapConverter.java */
/* loaded from: classes3.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final BitmapPool f17278a = new C0142a();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Resource<Bitmap> a(BitmapPool bitmapPool, Drawable drawable, int i4, int i5) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z3 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(bitmapPool, current, i4, i5);
            z3 = true;
        } else {
            bitmap = null;
        }
        if (!z3) {
            bitmapPool = f17278a;
        }
        return BitmapResource.obtain(bitmap, bitmapPool);
    }

    @Nullable
    private static Bitmap b(BitmapPool bitmapPool, Drawable drawable, int i4, int i5) {
        if (i4 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i5 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i4 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i5 = drawable.getIntrinsicHeight();
            }
            Lock bitmapDrawableLock = TransformationUtils.getBitmapDrawableLock();
            bitmapDrawableLock.lock();
            Bitmap bitmap = bitmapPool.get(i4, i5, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, i4, i5);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return bitmap;
            } finally {
                bitmapDrawableLock.unlock();
            }
        }
    }

    /* compiled from: DrawableToBitmapConverter.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0142a extends BitmapPoolAdapter {
        C0142a() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
        public void put(Bitmap bitmap) {
        }
    }
}
