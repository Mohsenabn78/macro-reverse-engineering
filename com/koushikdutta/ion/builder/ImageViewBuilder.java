package com.koushikdutta.ion.builder;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.koushikdutta.ion.BitmapDrawableFactory;
import com.koushikdutta.ion.builder.ImageViewBuilder;

/* loaded from: classes6.dex */
public interface ImageViewBuilder<I extends ImageViewBuilder<?>> {
    I animateGif(AnimateGifMode animateGifMode);

    I animateIn(int i4);

    I animateIn(Animation animation);

    I animateLoad(int i4);

    I animateLoad(Animation animation);

    I bitmapDrawableFactory(BitmapDrawableFactory bitmapDrawableFactory);

    I crossfade(boolean z3);

    I deepZoom();

    I error(int i4);

    I error(Drawable drawable);

    I fadeIn(boolean z3);

    I placeholder(int i4);

    I placeholder(Drawable drawable);
}
