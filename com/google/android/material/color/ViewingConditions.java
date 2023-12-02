package com.google.android.material.color;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ViewingConditions {

    /* renamed from: k  reason: collision with root package name */
    public static final ViewingConditions f23397k = k(ColorUtils.l(), (float) ((ColorUtils.n(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    private final float f23398a;

    /* renamed from: b  reason: collision with root package name */
    private final float f23399b;

    /* renamed from: c  reason: collision with root package name */
    private final float f23400c;

    /* renamed from: d  reason: collision with root package name */
    private final float f23401d;

    /* renamed from: e  reason: collision with root package name */
    private final float f23402e;

    /* renamed from: f  reason: collision with root package name */
    private final float f23403f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f23404g;

    /* renamed from: h  reason: collision with root package name */
    private final float f23405h;

    /* renamed from: i  reason: collision with root package name */
    private final float f23406i;

    /* renamed from: j  reason: collision with root package name */
    private final float f23407j;

    private ViewingConditions(float f4, float f5, float f6, float f7, float f8, float f9, float[] fArr, float f10, float f11, float f12) {
        this.f23403f = f4;
        this.f23398a = f5;
        this.f23399b = f6;
        this.f23400c = f7;
        this.f23401d = f8;
        this.f23402e = f9;
        this.f23404g = fArr;
        this.f23405h = f10;
        this.f23406i = f11;
        this.f23407j = f12;
    }

    static ViewingConditions k(float[] fArr, float f4, float f5, float f6, boolean z3) {
        float b4;
        float exp;
        float[][] fArr2 = Cam16.f23369j;
        float f7 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f8 = fArr[1];
        float f9 = fArr[2];
        float f10 = (fArr3[0] * f7) + (fArr3[1] * f8) + (fArr3[2] * f9);
        float[] fArr4 = fArr2[1];
        float f11 = (fArr4[0] * f7) + (fArr4[1] * f8) + (fArr4[2] * f9);
        float[] fArr5 = fArr2[2];
        float f12 = (f7 * fArr5[0]) + (f8 * fArr5[1]) + (f9 * fArr5[2]);
        float f13 = (f6 / 10.0f) + 0.8f;
        if (f13 >= 0.9d) {
            b4 = MathUtils.b(0.59f, 0.69f, (f13 - 0.9f) * 10.0f);
        } else {
            b4 = MathUtils.b(0.525f, 0.59f, (f13 - 0.8f) * 10.0f);
        }
        float f14 = b4;
        if (z3) {
            exp = 1.0f;
        } else {
            exp = (1.0f - (((float) Math.exp(((-f4) - 42.0f) / 92.0f)) * 0.2777778f)) * f13;
        }
        double d4 = exp;
        if (d4 > 1.0d) {
            exp = 1.0f;
        } else if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f10) * exp) + 1.0f) - exp, (((100.0f / f11) * exp) + 1.0f) - exp, (((100.0f / f12) * exp) + 1.0f) - exp};
        float f15 = 1.0f / ((5.0f * f4) + 1.0f);
        float f16 = f15 * f15 * f15 * f15;
        float f17 = 1.0f - f16;
        float cbrt = (f16 * f4) + (0.1f * f17 * f17 * ((float) Math.cbrt(f4 * 5.0d)));
        float n4 = ColorUtils.n(f5) / fArr[1];
        double d5 = n4;
        float sqrt = ((float) Math.sqrt(d5)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d5, 0.2d));
        float pow2 = (float) Math.pow(((fArr6[2] * cbrt) * f12) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f10) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f11) / 100.0d, 0.42d), pow2};
        float f18 = fArr7[0];
        float f19 = fArr7[1];
        return new ViewingConditions(n4, ((((f18 * 400.0f) / (f18 + 27.13f)) * 2.0f) + ((f19 * 400.0f) / (f19 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, f14, f13, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    public float a() {
        return this.f23398a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f23401d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f23405h;
    }

    public float d() {
        return this.f23406i;
    }

    public float e() {
        return this.f23403f;
    }

    public float f() {
        return this.f23399b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f23402e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        return this.f23400c;
    }

    public float[] i() {
        return this.f23404g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f23407j;
    }
}
