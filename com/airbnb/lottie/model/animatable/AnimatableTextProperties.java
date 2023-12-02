package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class AnimatableTextProperties {
    @Nullable
    public final AnimatableColorValue color;
    @Nullable
    public final AnimatableColorValue stroke;
    @Nullable
    public final AnimatableFloatValue strokeWidth;
    @Nullable
    public final AnimatableFloatValue tracking;

    public AnimatableTextProperties(@Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableColorValue animatableColorValue2, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableFloatValue animatableFloatValue2) {
        this.color = animatableColorValue;
        this.stroke = animatableColorValue2;
        this.strokeWidth = animatableFloatValue;
        this.tracking = animatableFloatValue2;
    }
}
