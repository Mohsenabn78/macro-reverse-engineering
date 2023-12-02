package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

/* loaded from: classes2.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    private final MaskMode f1653a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableShapeValue f1654b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableIntegerValue f1655c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1656d;

    /* loaded from: classes2.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z3) {
        this.f1653a = maskMode;
        this.f1654b = animatableShapeValue;
        this.f1655c = animatableIntegerValue;
        this.f1656d = z3;
    }

    public MaskMode getMaskMode() {
        return this.f1653a;
    }

    public AnimatableShapeValue getMaskPath() {
        return this.f1654b;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.f1655c;
    }

    public boolean isInverted() {
        return this.f1656d;
    }
}
