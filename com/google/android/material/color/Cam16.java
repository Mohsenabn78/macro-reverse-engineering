package com.google.android.material.color;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes5.dex */
final class Cam16 {

    /* renamed from: j  reason: collision with root package name */
    static final float[][] f23369j = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: k  reason: collision with root package name */
    static final float[][] f23370k = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: a  reason: collision with root package name */
    private final float f23371a;

    /* renamed from: b  reason: collision with root package name */
    private final float f23372b;

    /* renamed from: c  reason: collision with root package name */
    private final float f23373c;

    /* renamed from: d  reason: collision with root package name */
    private final float f23374d;

    /* renamed from: e  reason: collision with root package name */
    private final float f23375e;

    /* renamed from: f  reason: collision with root package name */
    private final float f23376f;

    /* renamed from: g  reason: collision with root package name */
    private final float f23377g;

    /* renamed from: h  reason: collision with root package name */
    private final float f23378h;

    /* renamed from: i  reason: collision with root package name */
    private final float f23379i;

    private Cam16(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        this.f23371a = f4;
        this.f23372b = f5;
        this.f23373c = f6;
        this.f23374d = f7;
        this.f23375e = f8;
        this.f23376f = f9;
        this.f23377g = f10;
        this.f23378h = f11;
        this.f23379i = f12;
    }

    public static Cam16 b(int i4) {
        return c(i4, ViewingConditions.f23397k);
    }

    static Cam16 c(int i4, ViewingConditions viewingConditions) {
        double d4;
        double d5;
        float f4;
        float pow;
        float i5 = ColorUtils.i(((16711680 & i4) >> 16) / 255.0f) * 100.0f;
        float i6 = ColorUtils.i(((65280 & i4) >> 8) / 255.0f) * 100.0f;
        float i7 = ColorUtils.i((i4 & 255) / 255.0f) * 100.0f;
        float f5 = (0.41233894f * i5) + (0.35762063f * i6) + (0.18051042f * i7);
        float f6 = (0.2126f * i5) + (0.7152f * i6) + (0.0722f * i7);
        float f7 = (i5 * 0.01932141f) + (i6 * 0.11916382f) + (i7 * 0.9503448f);
        float[][] fArr = f23369j;
        float[] fArr2 = fArr[0];
        float f8 = (fArr2[0] * f5) + (fArr2[1] * f6) + (fArr2[2] * f7);
        float[] fArr3 = fArr[1];
        float f9 = (fArr3[0] * f5) + (fArr3[1] * f6) + (fArr3[2] * f7);
        float[] fArr4 = fArr[2];
        float f10 = (f5 * fArr4[0]) + (f6 * fArr4[1]) + (f7 * fArr4[2]);
        float f11 = viewingConditions.i()[0] * f8;
        float f12 = viewingConditions.i()[1] * f9;
        float f13 = viewingConditions.i()[2] * f10;
        float pow2 = (float) Math.pow((viewingConditions.c() * Math.abs(f11)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((viewingConditions.c() * Math.abs(f12)) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((viewingConditions.c() * Math.abs(f13)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f11) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f12) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f13) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d6 = signum3;
        float f14 = signum2 * 20.0f;
        float f15 = (((signum * 20.0f) + f14) + (21.0f * signum3)) / 20.0f;
        float f16 = (((signum * 40.0f) + f14) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(((float) ((signum + signum2) - (d6 * 2.0d))) / 9.0f, ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d6)) / 11.0f)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f17 = (3.1415927f * atan2) / 180.0f;
        float pow5 = ((float) Math.pow((f16 * viewingConditions.f()) / viewingConditions.a(), viewingConditions.b() * viewingConditions.j())) * 100.0f;
        float b4 = (4.0f / viewingConditions.b()) * ((float) Math.sqrt(pow5 / 100.0f)) * (viewingConditions.a() + 4.0f) * viewingConditions.d();
        if (atan2 < 20.14d) {
            f4 = 360.0f + atan2;
        } else {
            f4 = atan2;
        }
        float pow6 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(Math.toRadians(f4) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.g()) * viewingConditions.h()) * ((float) Math.hypot(d5, d4))) / (f15 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow5 / 100.0d));
        float d7 = pow6 * viewingConditions.d();
        float sqrt = ((float) Math.sqrt((pow * viewingConditions.b()) / (viewingConditions.a() + 4.0f))) * 50.0f;
        float f18 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log1p = ((float) Math.log1p(0.0228f * d7)) * 43.85965f;
        double d8 = f17;
        return new Cam16(atan2, pow6, pow5, b4, d7, sqrt, f18, log1p * ((float) Math.cos(d8)), log1p * ((float) Math.sin(d8)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Cam16 d(float f4, float f5, float f6) {
        return e(f4, f5, f6, ViewingConditions.f23397k);
    }

    private static Cam16 e(float f4, float f5, float f6, ViewingConditions viewingConditions) {
        double d4;
        float b4 = (4.0f / viewingConditions.b()) * ((float) Math.sqrt(f4 / 100.0d)) * (viewingConditions.a() + 4.0f) * viewingConditions.d();
        float d5 = f5 * viewingConditions.d();
        float sqrt = ((float) Math.sqrt(((f5 / ((float) Math.sqrt(d4))) * viewingConditions.b()) / (viewingConditions.a() + 4.0f))) * 50.0f;
        float f7 = (1.7f * f4) / ((0.007f * f4) + 1.0f);
        float log1p = ((float) Math.log1p(d5 * 0.0228d)) * 43.85965f;
        double d6 = (3.1415927f * f6) / 180.0f;
        return new Cam16(f6, f5, f4, b4, d5, sqrt, f7, log1p * ((float) Math.cos(d6)), log1p * ((float) Math.sin(d6)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a(Cam16 cam16) {
        float l4 = l() - cam16.l();
        float f4 = f() - cam16.f();
        float g4 = g() - cam16.g();
        return (float) (Math.pow(Math.sqrt((l4 * l4) + (f4 * f4) + (g4 * g4)), 0.63d) * 1.41d);
    }

    public float f() {
        return this.f23378h;
    }

    public float g() {
        return this.f23379i;
    }

    public float h() {
        return this.f23372b;
    }

    public float i() {
        return this.f23371a;
    }

    public int j() {
        return m(ViewingConditions.f23397k);
    }

    public float k() {
        return this.f23373c;
    }

    public float l() {
        return this.f23377g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(ViewingConditions viewingConditions) {
        float f4;
        float f5;
        if (h() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && k() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            f4 = h() / ((float) Math.sqrt(k() / 100.0d));
        } else {
            f4 = 0.0f;
        }
        float pow = (float) Math.pow(f4 / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.e()), 0.73d), 1.1111111111111112d);
        double i4 = (i() * 3.1415927f) / 180.0f;
        float a4 = viewingConditions.a() * ((float) Math.pow(k() / 100.0d, (1.0d / viewingConditions.b()) / viewingConditions.j()));
        float cos = ((float) (Math.cos(2.0d + i4) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.g() * viewingConditions.h();
        float f6 = a4 / viewingConditions.f();
        float sin = (float) Math.sin(i4);
        float cos2 = (float) Math.cos(i4);
        float f7 = (((0.305f + f6) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f8 = cos2 * f7;
        float f9 = f7 * sin;
        float f10 = f6 * 460.0f;
        float f11 = (((451.0f * f8) + f10) + (288.0f * f9)) / 1403.0f;
        float f12 = ((f10 - (891.0f * f8)) - (261.0f * f9)) / 1403.0f;
        float signum = Math.signum(f11) * (100.0f / viewingConditions.c()) * ((float) Math.pow((float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f11) * 27.13d) / (400.0d - Math.abs(f11))), 2.380952380952381d));
        float signum2 = Math.signum(f12) * (100.0f / viewingConditions.c()) * ((float) Math.pow((float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f12) * 27.13d) / (400.0d - Math.abs(f12))), 2.380952380952381d));
        float signum3 = Math.signum(((f10 - (f8 * 220.0f)) - (f9 * 6300.0f)) / 1403.0f) * (100.0f / viewingConditions.c()) * ((float) Math.pow((float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f5) * 27.13d) / (400.0d - Math.abs(f5))), 2.380952380952381d));
        float f13 = signum / viewingConditions.i()[0];
        float f14 = signum2 / viewingConditions.i()[1];
        float f15 = signum3 / viewingConditions.i()[2];
        float[][] fArr = f23370k;
        float[] fArr2 = fArr[0];
        float f16 = (fArr2[0] * f13) + (fArr2[1] * f14) + (fArr2[2] * f15);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return ColorUtils.g(f16, (fArr3[0] * f13) + (fArr3[1] * f14) + (fArr3[2] * f15), (f13 * fArr4[0]) + (f14 * fArr4[1]) + (f15 * fArr4[2]));
    }
}
