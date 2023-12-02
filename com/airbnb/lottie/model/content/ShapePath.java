package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes2.dex */
public class ShapePath implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f1695a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1696b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableShapeValue f1697c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1698d;

    public ShapePath(String str, int i4, AnimatableShapeValue animatableShapeValue, boolean z3) {
        this.f1695a = str;
        this.f1696b = i4;
        this.f1697c = animatableShapeValue;
        this.f1698d = z3;
    }

    public String getName() {
        return this.f1695a;
    }

    public AnimatableShapeValue getShapePath() {
        return this.f1697c;
    }

    public boolean isHidden() {
        return this.f1698d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.f1695a + ", index=" + this.f1696b + '}';
    }
}
