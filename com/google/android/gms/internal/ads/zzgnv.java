package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgnv implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgoe zzgoeVar = (zzgoe) obj;
        zzgoe zzgoeVar2 = (zzgoe) obj2;
        zzgny it = zzgoeVar.iterator();
        zzgny it2 = zzgoeVar2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo = Integer.valueOf(it.zza() & 255).compareTo(Integer.valueOf(it2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzgoeVar.zzd()).compareTo(Integer.valueOf(zzgoeVar2.zzd()));
    }
}
