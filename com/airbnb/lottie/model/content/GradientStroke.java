package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: classes2.dex */
public class GradientStroke implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f1639a;

    /* renamed from: b  reason: collision with root package name */
    private final GradientType f1640b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableGradientColorValue f1641c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableIntegerValue f1642d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatablePointValue f1643e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatablePointValue f1644f;

    /* renamed from: g  reason: collision with root package name */
    private final AnimatableFloatValue f1645g;

    /* renamed from: h  reason: collision with root package name */
    private final ShapeStroke.LineCapType f1646h;

    /* renamed from: i  reason: collision with root package name */
    private final ShapeStroke.LineJoinType f1647i;

    /* renamed from: j  reason: collision with root package name */
    private final float f1648j;

    /* renamed from: k  reason: collision with root package name */
    private final List<AnimatableFloatValue> f1649k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final AnimatableFloatValue f1650l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f1651m;

    public GradientStroke(String str, GradientType gradientType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f4, List<AnimatableFloatValue> list, @Nullable AnimatableFloatValue animatableFloatValue2, boolean z3) {
        this.f1639a = str;
        this.f1640b = gradientType;
        this.f1641c = animatableGradientColorValue;
        this.f1642d = animatableIntegerValue;
        this.f1643e = animatablePointValue;
        this.f1644f = animatablePointValue2;
        this.f1645g = animatableFloatValue;
        this.f1646h = lineCapType;
        this.f1647i = lineJoinType;
        this.f1648j = f4;
        this.f1649k = list;
        this.f1650l = animatableFloatValue2;
        this.f1651m = z3;
    }

    public ShapeStroke.LineCapType getCapType() {
        return this.f1646h;
    }

    @Nullable
    public AnimatableFloatValue getDashOffset() {
        return this.f1650l;
    }

    public AnimatablePointValue getEndPoint() {
        return this.f1644f;
    }

    public AnimatableGradientColorValue getGradientColor() {
        return this.f1641c;
    }

    public GradientType getGradientType() {
        return this.f1640b;
    }

    public ShapeStroke.LineJoinType getJoinType() {
        return this.f1647i;
    }

    public List<AnimatableFloatValue> getLineDashPattern() {
        return this.f1649k;
    }

    public float getMiterLimit() {
        return this.f1648j;
    }

    public String getName() {
        return this.f1639a;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.f1642d;
    }

    public AnimatablePointValue getStartPoint() {
        return this.f1643e;
    }

    public AnimatableFloatValue getWidth() {
        return this.f1645g;
    }

    public boolean isHidden() {
        return this.f1651m;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientStrokeContent(lottieDrawable, baseLayer, this);
    }
}
