package com.google.android.gms.internal.places;

import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzy implements Comparator<zzw> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzw zzwVar, zzw zzwVar2) {
        int zzb;
        int zzb2;
        zzw zzwVar3 = zzwVar;
        zzw zzwVar4 = zzwVar2;
        zzab zzabVar = (zzab) zzwVar3.iterator();
        zzab zzabVar2 = (zzab) zzwVar4.iterator();
        while (zzabVar.hasNext() && zzabVar2.hasNext()) {
            zzb = zzw.zzb(zzabVar.nextByte());
            zzb2 = zzw.zzb(zzabVar2.nextByte());
            int compare = Integer.compare(zzb, zzb2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzwVar3.size(), zzwVar4.size());
    }
}
