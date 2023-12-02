package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface BitmapPool {
    void clearMemory();

    @NonNull
    Bitmap get(int i4, int i5, Bitmap.Config config);

    @NonNull
    Bitmap getDirty(int i4, int i5, Bitmap.Config config);

    long getMaxSize();

    void put(Bitmap bitmap);

    void setSizeMultiplier(float f4);

    void trimMemory(int i4);
}
