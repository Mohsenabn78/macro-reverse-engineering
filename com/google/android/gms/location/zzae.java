package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes4.dex */
public final class zzae {
    public static int zza(int i4) {
        boolean z3;
        if (i4 != 100 && i4 != 102 && i4 != 104) {
            if (i4 == 105) {
                i4 = 105;
            } else {
                z3 = false;
                Preconditions.checkArgument(z3, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i4));
                return i4;
            }
        }
        z3 = true;
        Preconditions.checkArgument(z3, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i4));
        return i4;
    }

    public static String zzb(int i4) {
        if (i4 != 100) {
            if (i4 != 102) {
                if (i4 != 104) {
                    if (i4 == 105) {
                        return "PASSIVE";
                    }
                    throw new IllegalArgumentException();
                }
                return "LOW_POWER";
            }
            return "BALANCED_POWER_ACCURACY";
        }
        return "HIGH_ACCURACY";
    }
}
