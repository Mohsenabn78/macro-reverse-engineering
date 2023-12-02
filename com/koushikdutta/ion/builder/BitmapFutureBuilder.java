package com.koushikdutta.ion.builder;

import android.graphics.Bitmap;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.LocallyCachedStatus;

/* loaded from: classes6.dex */
public interface BitmapFutureBuilder {
    Future<Bitmap> asBitmap();

    BitmapInfo asCachedBitmap();

    LocallyCachedStatus isLocallyCached();

    void removeCachedBitmap();
}
