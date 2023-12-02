package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzffv implements zzfvy {
    final /* synthetic */ zzffy zza;
    final /* synthetic */ zzffn zzb;
    final /* synthetic */ boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzffv(zzffy zzffyVar, zzffn zzffnVar, boolean z3) {
        this.zza = zzffyVar;
        this.zzb = zzffnVar;
        this.zzc = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzffn zzffnVar = this.zzb;
        if (zzffnVar.zzj()) {
            zzffy zzffyVar = this.zza;
            zzffnVar.zzg(th);
            zzffnVar.zzf(false);
            zzffyVar.zza(zzffnVar);
            if (this.zzc) {
                this.zza.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zzb(Object obj) {
        zzffy zzffyVar = this.zza;
        zzffn zzffnVar = this.zzb;
        zzffnVar.zzf(true);
        zzffyVar.zza(zzffnVar);
        if (this.zzc) {
            this.zza.zzg();
        }
    }
}
