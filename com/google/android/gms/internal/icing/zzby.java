package com.google.android.gms.internal.icing;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzby implements Comparator<zzcf> {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(zzcf zzcfVar, zzcf zzcfVar2) {
        zzcf zzcfVar3 = zzcfVar;
        zzcf zzcfVar4 = zzcfVar2;
        zzbx zzbxVar = new zzbx(zzcfVar3);
        zzbx zzbxVar2 = new zzbx(zzcfVar4);
        while (zzbxVar.hasNext() && zzbxVar2.hasNext()) {
            int compare = Integer.compare(zzbxVar.zza() & 255, zzbxVar2.zza() & 255);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzcfVar3.zzc(), zzcfVar4.zzc());
    }
}
