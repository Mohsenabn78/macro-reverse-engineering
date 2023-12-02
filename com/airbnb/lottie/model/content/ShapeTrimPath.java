package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes2.dex */
public class ShapeTrimPath implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f1713a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f1714b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f1715c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableFloatValue f1716d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableFloatValue f1717e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1718f;

    /* loaded from: classes2.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i4) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i4);
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z3) {
        this.f1713a = str;
        this.f1714b = type;
        this.f1715c = animatableFloatValue;
        this.f1716d = animatableFloatValue2;
        this.f1717e = animatableFloatValue3;
        this.f1718f = z3;
    }

    public AnimatableFloatValue getEnd() {
        return this.f1716d;
    }

    public String getName() {
        return this.f1713a;
    }

    public AnimatableFloatValue getOffset() {
        return this.f1717e;
    }

    public AnimatableFloatValue getStart() {
        return this.f1715c;
    }

    public Type getType() {
        return this.f1714b;
    }

    public boolean isHidden() {
        return this.f1718f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.f1715c + ", end: " + this.f1716d + ", offset: " + this.f1717e + "}";
    }
}
