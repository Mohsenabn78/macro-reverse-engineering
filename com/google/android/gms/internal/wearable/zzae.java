package com.google.android.gms.internal.wearable;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzae {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(long[] jArr, long j4, int i4, int i5) {
        while (i4 < i5) {
            if (jArr[i4] != j4) {
                i4++;
            } else {
                return i4;
            }
        }
        return -1;
    }

    public static List zzb(long... jArr) {
        int length = jArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        return new zzad(jArr, 0, length);
    }
}
