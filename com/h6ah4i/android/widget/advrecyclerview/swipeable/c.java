package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.animation.Interpolator;

/* compiled from: RubberBandInterpolator.java */
/* loaded from: classes6.dex */
class c implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float f33971a;

    public c(float f4) {
        this.f33971a = f4;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        float f5 = 1.0f - f4;
        return this.f33971a * (1.0f - (f5 * f5));
    }
}
