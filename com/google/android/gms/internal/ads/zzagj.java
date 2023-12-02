package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzagj implements zzagh {
    private final int zza;
    private final int zzb;
    private final zzfa zzc;

    public zzagj(zzagd zzagdVar, zzam zzamVar) {
        zzfa zzfaVar = zzagdVar.zza;
        this.zzc = zzfaVar;
        zzfaVar.zzF(12);
        int zzn = zzfaVar.zzn();
        if ("audio/raw".equals(zzamVar.zzm)) {
            int zzk = zzfj.zzk(zzamVar.zzB, zzamVar.zzz);
            if (zzn == 0 || zzn % zzk != 0) {
                zzer.zzf("AtomParsers", "Audio sample size mismatch. stsd sample size: " + zzk + ", stsz sample size: " + zzn);
                zzn = zzk;
            }
        }
        this.zza = zzn == 0 ? -1 : zzn;
        this.zzb = zzfaVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzagh
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzagh
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzagh
    public final int zzc() {
        int i4 = this.zza;
        if (i4 == -1) {
            return this.zzc.zzn();
        }
        return i4;
    }
}
