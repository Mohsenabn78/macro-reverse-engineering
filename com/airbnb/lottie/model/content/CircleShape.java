package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes2.dex */
public class CircleShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f1622a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f1623b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatablePointValue f1624c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1625d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1626e;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z3, boolean z4) {
        this.f1622a = str;
        this.f1623b = animatableValue;
        this.f1624c = animatablePointValue;
        this.f1625d = z3;
        this.f1626e = z4;
    }

    public String getName() {
        return this.f1622a;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.f1623b;
    }

    public AnimatablePointValue getSize() {
        return this.f1624c;
    }

    public boolean isHidden() {
        return this.f1626e;
    }

    public boolean isReversed() {
        return this.f1625d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }
}
