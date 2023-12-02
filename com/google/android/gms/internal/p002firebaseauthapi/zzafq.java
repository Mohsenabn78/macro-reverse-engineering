package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafq  reason: invalid package */
/* loaded from: classes4.dex */
final class zzafq implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzafy zzafyVar = (zzafy) obj;
        zzafy zzafyVar2 = (zzafy) obj2;
        zzafp zzafpVar = new zzafp(zzafyVar);
        zzafp zzafpVar2 = new zzafp(zzafyVar2);
        while (zzafpVar.hasNext() && zzafpVar2.hasNext()) {
            int compareTo = Integer.valueOf(zzafpVar.zza() & 255).compareTo(Integer.valueOf(zzafpVar2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzafyVar.zzd()).compareTo(Integer.valueOf(zzafyVar2.zzd()));
    }
}
