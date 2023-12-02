package com.airbnb.lottie.value;

/* loaded from: classes2.dex */
public class ScaleXY {

    /* renamed from: a  reason: collision with root package name */
    private float f1892a;

    /* renamed from: b  reason: collision with root package name */
    private float f1893b;

    public ScaleXY(float f4, float f5) {
        this.f1892a = f4;
        this.f1893b = f5;
    }

    public boolean equals(float f4, float f5) {
        if (this.f1892a == f4 && this.f1893b == f5) {
            return true;
        }
        return false;
    }

    public float getScaleX() {
        return this.f1892a;
    }

    public float getScaleY() {
        return this.f1893b;
    }

    public void set(float f4, float f5) {
        this.f1892a = f4;
        this.f1893b = f5;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
