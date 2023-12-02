package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes2.dex */
public class AnimatableTransform implements ModifierContent, ContentModel {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final AnimatablePathValue f1612a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f1613b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableScaleValue f1614c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableFloatValue f1615d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableIntegerValue f1616e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final AnimatableFloatValue f1617f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final AnimatableFloatValue f1618g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final AnimatableFloatValue f1619h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableFloatValue f1620i;

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public TransformKeyframeAnimation createAnimation() {
        return new TransformKeyframeAnimation(this);
    }

    @Nullable
    public AnimatablePathValue getAnchorPoint() {
        return this.f1612a;
    }

    @Nullable
    public AnimatableFloatValue getEndOpacity() {
        return this.f1620i;
    }

    @Nullable
    public AnimatableIntegerValue getOpacity() {
        return this.f1616e;
    }

    @Nullable
    public AnimatableValue<PointF, PointF> getPosition() {
        return this.f1613b;
    }

    @Nullable
    public AnimatableFloatValue getRotation() {
        return this.f1615d;
    }

    @Nullable
    public AnimatableScaleValue getScale() {
        return this.f1614c;
    }

    @Nullable
    public AnimatableFloatValue getSkew() {
        return this.f1617f;
    }

    @Nullable
    public AnimatableFloatValue getSkewAngle() {
        return this.f1618g;
    }

    @Nullable
    public AnimatableFloatValue getStartOpacity() {
        return this.f1619h;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return null;
    }

    public AnimatableTransform(@Nullable AnimatablePathValue animatablePathValue, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable AnimatableScaleValue animatableScaleValue, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableIntegerValue animatableIntegerValue, @Nullable AnimatableFloatValue animatableFloatValue2, @Nullable AnimatableFloatValue animatableFloatValue3, @Nullable AnimatableFloatValue animatableFloatValue4, @Nullable AnimatableFloatValue animatableFloatValue5) {
        this.f1612a = animatablePathValue;
        this.f1613b = animatableValue;
        this.f1614c = animatableScaleValue;
        this.f1615d = animatableFloatValue;
        this.f1616e = animatableIntegerValue;
        this.f1619h = animatableFloatValue2;
        this.f1620i = animatableFloatValue3;
        this.f1617f = animatableFloatValue4;
        this.f1618g = animatableFloatValue5;
    }
}
