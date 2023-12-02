package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes2.dex */
public class PolystarShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f1662a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f1663b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f1664c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f1665d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableFloatValue f1666e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatableFloatValue f1667f;

    /* renamed from: g  reason: collision with root package name */
    private final AnimatableFloatValue f1668g;

    /* renamed from: h  reason: collision with root package name */
    private final AnimatableFloatValue f1669h;

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableFloatValue f1670i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f1671j;

    /* loaded from: classes2.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        Type(int i4) {
            this.value = i4;
        }

        public static Type forValue(int i4) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i4) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z3) {
        this.f1662a = str;
        this.f1663b = type;
        this.f1664c = animatableFloatValue;
        this.f1665d = animatableValue;
        this.f1666e = animatableFloatValue2;
        this.f1667f = animatableFloatValue3;
        this.f1668g = animatableFloatValue4;
        this.f1669h = animatableFloatValue5;
        this.f1670i = animatableFloatValue6;
        this.f1671j = z3;
    }

    public AnimatableFloatValue getInnerRadius() {
        return this.f1667f;
    }

    public AnimatableFloatValue getInnerRoundedness() {
        return this.f1669h;
    }

    public String getName() {
        return this.f1662a;
    }

    public AnimatableFloatValue getOuterRadius() {
        return this.f1668g;
    }

    public AnimatableFloatValue getOuterRoundedness() {
        return this.f1670i;
    }

    public AnimatableFloatValue getPoints() {
        return this.f1664c;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.f1665d;
    }

    public AnimatableFloatValue getRotation() {
        return this.f1666e;
    }

    public Type getType() {
        return this.f1663b;
    }

    public boolean isHidden() {
        return this.f1671j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new PolystarContent(lottieDrawable, baseLayer, this);
    }
}
