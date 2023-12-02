package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes2.dex */
public class ShapeFill implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1686a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f1687b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1688c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableColorValue f1689d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableIntegerValue f1690e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1691f;

    public ShapeFill(String str, boolean z3, Path.FillType fillType, @Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableIntegerValue animatableIntegerValue, boolean z4) {
        this.f1688c = str;
        this.f1686a = z3;
        this.f1687b = fillType;
        this.f1689d = animatableColorValue;
        this.f1690e = animatableIntegerValue;
        this.f1691f = z4;
    }

    @Nullable
    public AnimatableColorValue getColor() {
        return this.f1689d;
    }

    public Path.FillType getFillType() {
        return this.f1687b;
    }

    public String getName() {
        return this.f1688c;
    }

    @Nullable
    public AnimatableIntegerValue getOpacity() {
        return this.f1690e;
    }

    public boolean isHidden() {
        return this.f1691f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f1686a + '}';
    }
}
