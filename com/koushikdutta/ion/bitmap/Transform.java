package com.koushikdutta.ion.bitmap;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public interface Transform {
    String key();

    Bitmap transform(Bitmap bitmap);
}
