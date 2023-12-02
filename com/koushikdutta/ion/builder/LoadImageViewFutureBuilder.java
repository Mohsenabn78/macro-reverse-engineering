package com.koushikdutta.ion.builder;

import android.widget.ImageView;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.future.ImageViewFuture;

/* loaded from: classes6.dex */
public interface LoadImageViewFutureBuilder {
    Future<ImageView> load(String str, String str2);

    ImageViewFuture load(String str);
}
