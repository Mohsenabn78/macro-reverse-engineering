package com.koushikdutta.ion.future;

import android.widget.ImageView;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.ImageViewBitmapInfo;

/* loaded from: classes6.dex */
public interface ImageViewFuture extends Future<ImageView> {
    Future<ImageViewBitmapInfo> withBitmapInfo();
}
