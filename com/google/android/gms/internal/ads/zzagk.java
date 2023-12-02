package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzagk implements zzagh {
    private final zzfa zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzagk(zzagd zzagdVar) {
        zzfa zzfaVar = zzagdVar.zza;
        this.zza = zzfaVar;
        zzfaVar.zzF(12);
        this.zzc = zzfaVar.zzn() & 255;
        this.zzb = zzfaVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzagh
    public final int zza() {
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzagh
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzagh
    public final int zzc() {
        int i4 = this.zzc;
        if (i4 == 8) {
            return this.zza.zzk();
        }
        if (i4 == 16) {
            return this.zza.zzo();
        }
        int i5 = this.zzd;
        this.zzd = i5 + 1;
        if (i5 % 2 == 0) {
            int zzk = this.zza.zzk();
            this.zze = zzk;
            return (zzk & 240) >> 4;
        }
        return this.zze & 15;
    }
}
