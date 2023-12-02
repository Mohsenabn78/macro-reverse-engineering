package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgqi extends zzgqk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgqi(zzgqh zzgqhVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgqk
    public final List zza(Object obj, long j4) {
        int i4;
        zzgpv zzgpvVar = (zzgpv) zzgsq.zzh(obj, j4);
        if (!zzgpvVar.zzc()) {
            int size = zzgpvVar.size();
            if (size == 0) {
                i4 = 10;
            } else {
                i4 = size + size;
            }
            zzgpv zzd = zzgpvVar.zzd(i4);
            zzgsq.zzv(obj, j4, zzd);
            return zzd;
        }
        return zzgpvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgqk
    public final void zzb(Object obj, long j4) {
        ((zzgpv) zzgsq.zzh(obj, j4)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgqk
    public final void zzc(Object obj, Object obj2, long j4) {
        zzgpv zzgpvVar = (zzgpv) zzgsq.zzh(obj, j4);
        zzgpv zzgpvVar2 = (zzgpv) zzgsq.zzh(obj2, j4);
        int size = zzgpvVar.size();
        int size2 = zzgpvVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzgpvVar.zzc()) {
                zzgpvVar = zzgpvVar.zzd(size2 + size);
            }
            zzgpvVar.addAll(zzgpvVar2);
        }
        if (size > 0) {
            zzgpvVar2 = zzgpvVar;
        }
        zzgsq.zzv(obj, j4, zzgpvVar2);
    }

    private zzgqi() {
        super(null);
    }
}
