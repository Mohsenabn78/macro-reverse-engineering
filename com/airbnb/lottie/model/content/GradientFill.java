package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes2.dex */
public class GradientFill implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final GradientType f1629a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f1630b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableGradientColorValue f1631c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableIntegerValue f1632d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatablePointValue f1633e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatablePointValue f1634f;

    /* renamed from: g  reason: collision with root package name */
    private final String f1635g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final AnimatableFloatValue f1636h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableFloatValue f1637i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f1638j;

    public GradientFill(String str, GradientType gradientType, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, boolean z3) {
        this.f1629a = gradientType;
        this.f1630b = fillType;
        this.f1631c = animatableGradientColorValue;
        this.f1632d = animatableIntegerValue;
        this.f1633e = animatablePointValue;
        this.f1634f = animatablePointValue2;
        this.f1635g = str;
        this.f1636h = animatableFloatValue;
        this.f1637i = animatableFloatValue2;
        this.f1638j = z3;
    }

    public AnimatablePointValue getEndPoint() {
        return this.f1634f;
    }

    public Path.FillType getFillType() {
        return this.f1630b;
    }

    public AnimatableGradientColorValue getGradientColor() {
        return this.f1631c;
    }

    public GradientType getGradientType() {
        return this.f1629a;
    }

    public String getName() {
        return this.f1635g;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.f1632d;
    }

    public AnimatablePointValue getStartPoint() {
        return this.f1633e;
    }

    public boolean isHidden() {
        return this.f1638j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientFillContent(lottieDrawable, baseLayer, this);
    }
}
