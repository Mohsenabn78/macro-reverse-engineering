package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzadk implements zzabv {
    final /* synthetic */ zzabv zza;
    final /* synthetic */ zzadl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadk(zzadl zzadlVar, zzabv zzabvVar) {
        this.zzb = zzadlVar;
        this.zza = zzabvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        long j5;
        long j6;
        zzabt zzg = this.zza.zzg(j4);
        zzabw zzabwVar = zzg.zza;
        long j7 = zzabwVar.zzb;
        long j8 = zzabwVar.zzc;
        j5 = this.zzb.zzb;
        zzabw zzabwVar2 = new zzabw(j7, j8 + j5);
        zzabw zzabwVar3 = zzg.zzb;
        long j9 = zzabwVar3.zzb;
        long j10 = zzabwVar3.zzc;
        j6 = this.zzb.zzb;
        return new zzabt(zzabwVar2, new zzabw(j9, j10 + j6));
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return this.zza.zzh();
    }
}
