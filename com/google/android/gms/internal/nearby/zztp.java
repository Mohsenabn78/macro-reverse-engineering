package com.google.android.gms.internal.nearby;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zztp extends zztq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ int zza(int[] iArr, int i4, int i5, int i6) {
        while (i5 < i6) {
            if (iArr[i5] != i4) {
                i5++;
            } else {
                return i5;
            }
        }
        return -1;
    }

    public static List zzb(int... iArr) {
        int length = iArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        return new zzto(iArr, 0, length);
    }
}
