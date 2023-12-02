package com.airbnb.lottie.value;

import androidx.annotation.RestrictTo;

/* loaded from: classes2.dex */
public class LottieFrameInfo<T> {

    /* renamed from: a  reason: collision with root package name */
    private float f1880a;

    /* renamed from: b  reason: collision with root package name */
    private float f1881b;

    /* renamed from: c  reason: collision with root package name */
    private T f1882c;

    /* renamed from: d  reason: collision with root package name */
    private T f1883d;

    /* renamed from: e  reason: collision with root package name */
    private float f1884e;

    /* renamed from: f  reason: collision with root package name */
    private float f1885f;

    /* renamed from: g  reason: collision with root package name */
    private float f1886g;

    public float getEndFrame() {
        return this.f1881b;
    }

    public T getEndValue() {
        return this.f1883d;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.f1885f;
    }

    public float getLinearKeyframeProgress() {
        return this.f1884e;
    }

    public float getOverallProgress() {
        return this.f1886g;
    }

    public float getStartFrame() {
        return this.f1880a;
    }

    public T getStartValue() {
        return this.f1882c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieFrameInfo<T> set(float f4, float f5, T t3, T t4, float f6, float f7, float f8) {
        this.f1880a = f4;
        this.f1881b = f5;
        this.f1882c = t3;
        this.f1883d = t4;
        this.f1884e = f6;
        this.f1885f = f7;
        this.f1886g = f8;
        return this;
    }
}
