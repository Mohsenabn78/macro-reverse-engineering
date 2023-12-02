package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes2.dex */
public class RectangleShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f1673a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f1674b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f1675c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableFloatValue f1676d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1677e;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatableValue<PointF, PointF> animatableValue2, AnimatableFloatValue animatableFloatValue, boolean z3) {
        this.f1673a = str;
        this.f1674b = animatableValue;
        this.f1675c = animatableValue2;
        this.f1676d = animatableFloatValue;
        this.f1677e = z3;
    }

    public AnimatableFloatValue getCornerRadius() {
        return this.f1676d;
    }

    public String getName() {
        return this.f1673a;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.f1674b;
    }

    public AnimatableValue<PointF, PointF> getSize() {
        return this.f1675c;
    }

    public boolean isHidden() {
        return this.f1677e;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.f1674b + ", size=" + this.f1675c + '}';
    }
}
