package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes2.dex */
public class Repeater implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f1678a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableFloatValue f1679b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f1680c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableTransform f1681d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1682e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z3) {
        this.f1678a = str;
        this.f1679b = animatableFloatValue;
        this.f1680c = animatableFloatValue2;
        this.f1681d = animatableTransform;
        this.f1682e = z3;
    }

    public AnimatableFloatValue getCopies() {
        return this.f1679b;
    }

    public String getName() {
        return this.f1678a;
    }

    public AnimatableFloatValue getOffset() {
        return this.f1680c;
    }

    public AnimatableTransform getTransform() {
        return this.f1681d;
    }

    public boolean isHidden() {
        return this.f1682e;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }
}
