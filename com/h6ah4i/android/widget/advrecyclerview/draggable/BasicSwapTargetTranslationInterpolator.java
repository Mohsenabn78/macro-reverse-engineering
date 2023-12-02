package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.view.animation.Interpolator;

/* loaded from: classes6.dex */
public class BasicSwapTargetTranslationInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float f33727a;

    /* renamed from: b  reason: collision with root package name */
    private final float f33728b;

    /* renamed from: c  reason: collision with root package name */
    private final float f33729c;

    public BasicSwapTargetTranslationInterpolator() {
        this(0.3f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (Math.abs(f4 - 0.5f) < this.f33728b) {
            return (f4 - this.f33727a) * this.f33729c;
        }
        if (f4 < 0.5f) {
            return 0.0f;
        }
        return 1.0f;
    }

    public BasicSwapTargetTranslationInterpolator(float f4) {
        if (f4 >= 0.0f && f4 < 0.5f) {
            float f5 = 1.0f - (2.0f * f4);
            this.f33727a = f4;
            this.f33728b = 0.5f * f5;
            this.f33729c = 1.0f / f5;
            return;
        }
        throw new IllegalArgumentException("Invalid threshold range: " + f4);
    }
}
