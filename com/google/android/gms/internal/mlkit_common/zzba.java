package com.google.android.gms.internal.mlkit_common;

import java.util.Set;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzba {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Set set) {
        int i4;
        int i5 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i4 = obj.hashCode();
            } else {
                i4 = 0;
            }
            i5 += i4;
        }
        return i5;
    }
}
