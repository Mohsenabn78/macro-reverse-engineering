package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzpp {
    private final zzdr[] zza;
    private final zzqh zzb;
    private final zzdu zzc;

    public zzpp(zzdr... zzdrVarArr) {
        zzqh zzqhVar = new zzqh();
        zzdu zzduVar = new zzdu();
        this.zza = r2;
        System.arraycopy(zzdrVarArr, 0, r2, 0, 0);
        this.zzb = zzqhVar;
        this.zzc = zzduVar;
        zzdr[] zzdrVarArr2 = {zzqhVar, zzduVar};
    }

    public final long zza(long j4) {
        return this.zzc.zzi(j4);
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzch zzc(zzch zzchVar) {
        this.zzc.zzk(zzchVar.zzc);
        this.zzc.zzj(zzchVar.zzd);
        return zzchVar;
    }

    public final boolean zzd(boolean z3) {
        this.zzb.zzp(z3);
        return z3;
    }

    public final zzdr[] zze() {
        return this.zza;
    }
}
