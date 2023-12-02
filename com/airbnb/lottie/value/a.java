package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: LottieInterpolatedValue.java */
/* loaded from: classes2.dex */
abstract class a<T> extends LottieValueCallback<T> {

    /* renamed from: d  reason: collision with root package name */
    private final T f1894d;

    /* renamed from: e  reason: collision with root package name */
    private final T f1895e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator f1896f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(T t3, T t4) {
        this(t3, t4, new LinearInterpolator());
    }

    abstract T a(T t3, T t4, float f4);

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return a(this.f1894d, this.f1895e, this.f1896f.getInterpolation(lottieFrameInfo.getOverallProgress()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(T t3, T t4, Interpolator interpolator) {
        this.f1894d = t3;
        this.f1895e = t4;
        this.f1896f = interpolator;
    }
}
