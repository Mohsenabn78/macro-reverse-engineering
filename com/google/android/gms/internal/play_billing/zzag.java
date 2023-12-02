package com.google.android.gms.internal.play_billing;

import java.util.Set;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzag {
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
