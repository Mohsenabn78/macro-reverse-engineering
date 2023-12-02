package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzajp implements zzaji {
    final /* synthetic */ zzajr zza;
    private final zzez zzb = new zzez(new byte[4], 4);

    public zzajp(zzajr zzajrVar) {
        this.zza = zzajrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zza(zzfa zzfaVar) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        int i4;
        if (zzfaVar.zzk() != 0 || (zzfaVar.zzk() & 128) == 0) {
            return;
        }
        zzfaVar.zzG(6);
        int zza = zzfaVar.zza() / 4;
        for (int i5 = 0; i5 < zza; i5++) {
            zzfaVar.zzA(this.zzb, 4);
            int zzd = this.zzb.zzd(16);
            this.zzb.zzl(3);
            if (zzd == 0) {
                this.zzb.zzl(13);
            } else {
                int zzd2 = this.zzb.zzd(13);
                sparseArray2 = this.zza.zzf;
                if (sparseArray2.get(zzd2) == null) {
                    zzajr zzajrVar = this.zza;
                    sparseArray3 = zzajrVar.zzf;
                    sparseArray3.put(zzd2, new zzajj(new zzajq(zzajrVar, zzd2)));
                    zzajr zzajrVar2 = this.zza;
                    i4 = zzajrVar2.zzl;
                    zzajrVar2.zzl = i4 + 1;
                }
            }
        }
        sparseArray = this.zza.zzf;
        sparseArray.remove(0);
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zzb(zzfh zzfhVar, zzaaz zzaazVar, zzajv zzajvVar) {
    }
}
