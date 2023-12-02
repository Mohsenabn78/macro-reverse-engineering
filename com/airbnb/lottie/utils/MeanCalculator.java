package com.airbnb.lottie.utils;

/* loaded from: classes2.dex */
public class MeanCalculator {

    /* renamed from: a  reason: collision with root package name */
    private float f1864a;

    /* renamed from: b  reason: collision with root package name */
    private int f1865b;

    public void add(float f4) {
        float f5 = this.f1864a + f4;
        this.f1864a = f5;
        int i4 = this.f1865b + 1;
        this.f1865b = i4;
        if (i4 == Integer.MAX_VALUE) {
            this.f1864a = f5 / 2.0f;
            this.f1865b = i4 / 2;
        }
    }

    public float getMean() {
        int i4 = this.f1865b;
        if (i4 == 0) {
            return 0.0f;
        }
        return this.f1864a / i4;
    }
}
