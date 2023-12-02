package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* compiled from: LruPoolStrategy.java */
/* loaded from: classes3.dex */
interface d {
    @Nullable
    Bitmap get(int i4, int i5, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i4, int i5, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
