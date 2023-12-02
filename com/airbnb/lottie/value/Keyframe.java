package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;

/* loaded from: classes2.dex */
public class Keyframe<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final LottieComposition f1873a;

    /* renamed from: b  reason: collision with root package name */
    private float f1874b;

    /* renamed from: c  reason: collision with root package name */
    private float f1875c;

    /* renamed from: d  reason: collision with root package name */
    private int f1876d;

    /* renamed from: e  reason: collision with root package name */
    private int f1877e;
    @Nullable
    public Float endFrame;
    @Nullable
    public T endValue;

    /* renamed from: f  reason: collision with root package name */
    private float f1878f;

    /* renamed from: g  reason: collision with root package name */
    private float f1879g;
    @Nullable
    public final Interpolator interpolator;
    public PointF pathCp1;
    public PointF pathCp2;
    public final float startFrame;
    @Nullable
    public final T startValue;
    @Nullable
    public final Interpolator xInterpolator;
    @Nullable
    public final Interpolator yInterpolator;

    public Keyframe(LottieComposition lottieComposition, @Nullable T t3, @Nullable T t4, @Nullable Interpolator interpolator, float f4, @Nullable Float f5) {
        this.f1874b = -3987645.8f;
        this.f1875c = -3987645.8f;
        this.f1876d = 784923401;
        this.f1877e = 784923401;
        this.f1878f = Float.MIN_VALUE;
        this.f1879g = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.f1873a = lottieComposition;
        this.startValue = t3;
        this.endValue = t4;
        this.interpolator = interpolator;
        this.xInterpolator = null;
        this.yInterpolator = null;
        this.startFrame = f4;
        this.endFrame = f5;
    }

    public boolean containsProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (f4 >= getStartProgress() && f4 < getEndProgress()) {
            return true;
        }
        return false;
    }

    public float getEndProgress() {
        if (this.f1873a == null) {
            return 1.0f;
        }
        if (this.f1879g == Float.MIN_VALUE) {
            if (this.endFrame == null) {
                this.f1879g = 1.0f;
            } else {
                this.f1879g = getStartProgress() + ((this.endFrame.floatValue() - this.startFrame) / this.f1873a.getDurationFrames());
            }
        }
        return this.f1879g;
    }

    public float getEndValueFloat() {
        if (this.f1875c == -3987645.8f) {
            this.f1875c = ((Float) this.endValue).floatValue();
        }
        return this.f1875c;
    }

    public int getEndValueInt() {
        if (this.f1877e == 784923401) {
            this.f1877e = ((Integer) this.endValue).intValue();
        }
        return this.f1877e;
    }

    public float getStartProgress() {
        LottieComposition lottieComposition = this.f1873a;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.f1878f == Float.MIN_VALUE) {
            this.f1878f = (this.startFrame - lottieComposition.getStartFrame()) / this.f1873a.getDurationFrames();
        }
        return this.f1878f;
    }

    public float getStartValueFloat() {
        if (this.f1874b == -3987645.8f) {
            this.f1874b = ((Float) this.startValue).floatValue();
        }
        return this.f1874b;
    }

    public int getStartValueInt() {
        if (this.f1876d == 784923401) {
            this.f1876d = ((Integer) this.startValue).intValue();
        }
        return this.f1876d;
    }

    public boolean isStatic() {
        if (this.interpolator == null && this.xInterpolator == null && this.yInterpolator == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.startValue + ", endValue=" + this.endValue + ", startFrame=" + this.startFrame + ", endFrame=" + this.endFrame + ", interpolator=" + this.interpolator + '}';
    }

    public Keyframe(LottieComposition lottieComposition, @Nullable T t3, @Nullable T t4, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f4, @Nullable Float f5) {
        this.f1874b = -3987645.8f;
        this.f1875c = -3987645.8f;
        this.f1876d = 784923401;
        this.f1877e = 784923401;
        this.f1878f = Float.MIN_VALUE;
        this.f1879g = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.f1873a = lottieComposition;
        this.startValue = t3;
        this.endValue = t4;
        this.interpolator = null;
        this.xInterpolator = interpolator;
        this.yInterpolator = interpolator2;
        this.startFrame = f4;
        this.endFrame = f5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Keyframe(LottieComposition lottieComposition, @Nullable T t3, @Nullable T t4, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f4, @Nullable Float f5) {
        this.f1874b = -3987645.8f;
        this.f1875c = -3987645.8f;
        this.f1876d = 784923401;
        this.f1877e = 784923401;
        this.f1878f = Float.MIN_VALUE;
        this.f1879g = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.f1873a = lottieComposition;
        this.startValue = t3;
        this.endValue = t4;
        this.interpolator = interpolator;
        this.xInterpolator = interpolator2;
        this.yInterpolator = interpolator3;
        this.startFrame = f4;
        this.endFrame = f5;
    }

    public Keyframe(T t3) {
        this.f1874b = -3987645.8f;
        this.f1875c = -3987645.8f;
        this.f1876d = 784923401;
        this.f1877e = 784923401;
        this.f1878f = Float.MIN_VALUE;
        this.f1879g = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.f1873a = null;
        this.startValue = t3;
        this.endValue = t3;
        this.interpolator = null;
        this.xInterpolator = null;
        this.yInterpolator = null;
        this.startFrame = Float.MIN_VALUE;
        this.endFrame = Float.valueOf(Float.MAX_VALUE);
    }
}
