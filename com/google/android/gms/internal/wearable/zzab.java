package com.google.android.gms.internal.wearable;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzab extends zzac {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(float[] fArr, float f4, int i4, int i5) {
        while (i4 < i5) {
            if (fArr[i4] != f4) {
                i4++;
            } else {
                return i4;
            }
        }
        return -1;
    }

    public static List zzb(float... fArr) {
        int length = fArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        return new zzaa(fArr, 0, length);
    }
}
