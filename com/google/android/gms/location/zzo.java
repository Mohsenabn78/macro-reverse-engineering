package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes4.dex */
public final class zzo {
    public static int zza(int i4) {
        boolean z3;
        if (i4 != 0 && i4 != 1) {
            if (i4 == 2) {
                i4 = 2;
            } else {
                z3 = false;
                Preconditions.checkArgument(z3, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i4));
                return i4;
            }
        }
        z3 = true;
        Preconditions.checkArgument(z3, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i4));
        return i4;
    }

    public static String zzb(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return "GRANULARITY_FINE";
                }
                throw new IllegalArgumentException();
            }
            return "GRANULARITY_COARSE";
        }
        return "GRANULARITY_PERMISSION_LEVEL";
    }
}
