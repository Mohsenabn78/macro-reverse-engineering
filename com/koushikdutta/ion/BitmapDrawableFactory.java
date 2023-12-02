package com.koushikdutta.ion;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
public interface BitmapDrawableFactory {
    public static final BitmapDrawableFactory DEFAULT = new a();

    /* loaded from: classes6.dex */
    static class a implements BitmapDrawableFactory {
        a() {
        }

        @Override // com.koushikdutta.ion.BitmapDrawableFactory
        public Drawable fromBitmap(Resources resources, Bitmap bitmap) {
            return new BitmapDrawable(resources, bitmap);
        }
    }

    Drawable fromBitmap(Resources resources, Bitmap bitmap);
}
