package com.koushikdutta.ion.builder;

import com.koushikdutta.ion.bitmap.PostProcess;
import com.koushikdutta.ion.bitmap.Transform;
import com.koushikdutta.ion.builder.BitmapBuilder;

/* loaded from: classes6.dex */
public interface BitmapBuilder<B extends BitmapBuilder<?>> {
    B centerCrop();

    B centerInside();

    B fitCenter();

    B fitXY();

    B postProcess(PostProcess postProcess);

    B resize(int i4, int i5);

    B resizeHeight(int i4);

    B resizeWidth(int i4);

    B smartSize(boolean z3);

    B transform(Transform transform);
}
