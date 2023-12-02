package com.google.android.material.color;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes5.dex */
final class Hct {

    /* renamed from: a  reason: collision with root package name */
    private float f23394a;

    /* renamed from: b  reason: collision with root package name */
    private float f23395b;

    /* renamed from: c  reason: collision with root package name */
    private float f23396c;

    private Hct(float f4, float f5, float f6) {
        i(d(f4, f5, f6));
    }

    private static Cam16 a(float f4, float f5, float f6) {
        float f7 = 100.0f;
        float f8 = 1000.0f;
        Cam16 cam16 = null;
        float f9 = 1000.0f;
        float f10 = 0.0f;
        while (Math.abs(f10 - f7) > 0.01f) {
            float f11 = ((f7 - f10) / 2.0f) + f10;
            int j4 = Cam16.d(f11, f5, f4).j();
            float j5 = ColorUtils.j(j4);
            float abs = Math.abs(f6 - j5);
            if (abs < 0.2f) {
                Cam16 b4 = Cam16.b(j4);
                float a4 = b4.a(Cam16.d(b4.k(), b4.h(), f4));
                if (a4 <= 1.0f && a4 <= f8) {
                    cam16 = b4;
                    f9 = abs;
                    f8 = a4;
                }
            }
            if (f9 == 0.0f && f8 < 1.0E-9f) {
                break;
            } else if (j5 < f6) {
                f10 = f11;
            } else {
                f7 = f11;
            }
        }
        return cam16;
    }

    public static Hct b(float f4, float f5, float f6) {
        return new Hct(f4, f5, f6);
    }

    public static Hct c(int i4) {
        Cam16 b4 = Cam16.b(i4);
        return new Hct(b4.i(), b4.h(), ColorUtils.j(i4));
    }

    private static int d(float f4, float f5, float f6) {
        return e(f4, f5, f6, ViewingConditions.f23397k);
    }

    static int e(float f4, float f5, float f6, ViewingConditions viewingConditions) {
        if (f5 >= 1.0d && Math.round(f6) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && Math.round(f6) < 100.0d) {
            float c4 = MathUtils.c(f4);
            float f7 = f5;
            Cam16 cam16 = null;
            float f8 = 0.0f;
            boolean z3 = true;
            while (Math.abs(f8 - f5) >= 0.4f) {
                Cam16 a4 = a(c4, f7, f6);
                if (z3) {
                    if (a4 != null) {
                        return a4.m(viewingConditions);
                    }
                    f7 = ((f5 - f8) / 2.0f) + f8;
                    z3 = false;
                } else {
                    if (a4 == null) {
                        f5 = f7;
                    } else {
                        f8 = f7;
                        cam16 = a4;
                    }
                    f7 = ((f5 - f8) / 2.0f) + f8;
                }
            }
            if (cam16 == null) {
                return ColorUtils.d(f6);
            }
            return cam16.m(viewingConditions);
        }
        return ColorUtils.d(f6);
    }

    private void i(int i4) {
        Cam16 b4 = Cam16.b(i4);
        float j4 = ColorUtils.j(i4);
        this.f23394a = b4.i();
        this.f23395b = b4.h();
        this.f23396c = j4;
    }

    public float f() {
        return this.f23395b;
    }

    public float g() {
        return this.f23394a;
    }

    public float h() {
        return this.f23396c;
    }

    public void j(float f4) {
        i(d(this.f23394a, this.f23395b, f4));
    }

    public int k() {
        return d(this.f23394a, this.f23395b, this.f23396c);
    }
}
