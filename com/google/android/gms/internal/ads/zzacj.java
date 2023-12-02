package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzacj implements zzabv {
    final /* synthetic */ zzacm zza;
    private final long zzb;

    public zzacj(zzacm zzacmVar, long j4) {
        this.zza = zzacmVar;
        this.zzb = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        zzacp[] zzacpVarArr;
        zzacp[] zzacpVarArr2;
        zzacp[] zzacpVarArr3;
        zzacpVarArr = this.zza.zzg;
        zzabt zza = zzacpVarArr[0].zza(j4);
        int i4 = 1;
        while (true) {
            zzacm zzacmVar = this.zza;
            zzacpVarArr2 = zzacmVar.zzg;
            if (i4 < zzacpVarArr2.length) {
                zzacpVarArr3 = zzacmVar.zzg;
                zzabt zza2 = zzacpVarArr3[i4].zza(j4);
                if (zza2.zza.zzc < zza.zza.zzc) {
                    zza = zza2;
                }
                i4++;
            } else {
                return zza;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return true;
    }
}
