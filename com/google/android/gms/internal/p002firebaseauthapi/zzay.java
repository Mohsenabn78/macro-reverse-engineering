package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzay  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzay {
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
