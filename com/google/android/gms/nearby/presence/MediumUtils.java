package com.google.android.gms.nearby.presence;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class MediumUtils {
    private MediumUtils() {
    }

    @Nullable
    public static int[] convertConnectionMediumsToNearbyMediums(@Nullable int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int[] iArr2 = new int[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 != 4) {
                if (i5 != 5) {
                    iArr2[i4] = 0;
                } else {
                    iArr2[i4] = 5;
                }
            } else {
                iArr2[i4] = 4;
            }
        }
        return iArr2;
    }

    @Nullable
    public static int[] convertNearbyMediumsToConnectionMediums(@Nullable int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int[] iArr2 = new int[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 != 4) {
                if (i5 != 5) {
                    iArr2[i4] = 0;
                } else {
                    iArr2[i4] = 5;
                }
            } else {
                iArr2[i4] = 4;
            }
        }
        return iArr2;
    }
}
