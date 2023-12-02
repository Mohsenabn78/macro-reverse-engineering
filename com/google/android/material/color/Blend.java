package com.google.android.material.color;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes5.dex */
final class Blend {
    private Blend() {
    }

    public static int a(int i4, int i5) {
        Hct c4 = Hct.c(i4);
        Hct c5 = Hct.c(i5);
        return Hct.b(MathUtils.c(c4.g() + (Math.min(MathUtils.a(c4.g(), c5.g()) * 0.5f, 15.0f) * b(c4.g(), c5.g()))), c4.f(), c4.h()).k();
    }

    private static float b(float f4, float f5) {
        float f6 = f5 - f4;
        float f7 = f6 + 360.0f;
        float f8 = f6 - 360.0f;
        float abs = Math.abs(f6);
        float abs2 = Math.abs(f7);
        float abs3 = Math.abs(f8);
        if (abs <= abs2 && abs <= abs3) {
            if (f6 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return 1.0f;
            }
            return -1.0f;
        } else if (abs2 <= abs && abs2 <= abs3) {
            if (f7 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return 1.0f;
            }
            return -1.0f;
        } else if (f8 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 1.0f;
        } else {
            return -1.0f;
        }
    }
}
