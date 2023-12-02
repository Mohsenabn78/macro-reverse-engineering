package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaiz implements zzaji {
    private zzam zza;
    private zzfh zzb;
    private zzabz zzc;

    public zzaiz(String str) {
        zzak zzakVar = new zzak();
        zzakVar.zzS(str);
        this.zza = zzakVar.zzY();
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zza(zzfa zzfaVar) {
        zzdy.zzb(this.zzb);
        int i4 = zzfj.zza;
        long zzd = this.zzb.zzd();
        long zze = this.zzb.zze();
        if (zzd != -9223372036854775807L && zze != -9223372036854775807L) {
            zzam zzamVar = this.zza;
            if (zze != zzamVar.zzq) {
                zzak zzb = zzamVar.zzb();
                zzb.zzW(zze);
                zzam zzY = zzb.zzY();
                this.zza = zzY;
                this.zzc.zzk(zzY);
            }
            int zza = zzfaVar.zza();
            this.zzc.zzq(zzfaVar, zza);
            this.zzc.zzs(zzd, 1, zza, 0, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zzb(zzfh zzfhVar, zzaaz zzaazVar, zzajv zzajvVar) {
        this.zzb = zzfhVar;
        zzajvVar.zzc();
        zzabz zzv = zzaazVar.zzv(zzajvVar.zza(), 5);
        this.zzc = zzv;
        zzv.zzk(this.zza);
    }
}
