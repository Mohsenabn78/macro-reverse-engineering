package com.airbnb.lottie.value;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* loaded from: classes2.dex */
public class LottieValueCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    private final LottieFrameInfo<T> f1889a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private BaseKeyframeAnimation<?, ?> f1890b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    protected T f1891c;

    public LottieValueCallback() {
        this.f1889a = new LottieFrameInfo<>();
        this.f1891c = null;
    }

    @Nullable
    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return this.f1891c;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T getValueInternal(float f4, float f5, T t3, T t4, float f6, float f7, float f8) {
        return getValue(this.f1889a.set(f4, f5, t3, t4, f6, f7, f8));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setAnimation(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.f1890b = baseKeyframeAnimation;
    }

    public final void setValue(@Nullable T t3) {
        this.f1891c = t3;
        BaseKeyframeAnimation<?, ?> baseKeyframeAnimation = this.f1890b;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.notifyListeners();
        }
    }

    public LottieValueCallback(@Nullable T t3) {
        this.f1889a = new LottieFrameInfo<>();
        this.f1891c = t3;
    }
}
