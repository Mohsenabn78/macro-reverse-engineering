package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzffw implements zzfvy {
    final /* synthetic */ zzffy zza;
    final /* synthetic */ zzffn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzffw(zzffy zzffyVar, zzffn zzffnVar) {
        this.zza = zzffyVar;
        this.zzb = zzffnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzffy zzffyVar = this.zza;
        zzffn zzffnVar = this.zzb;
        zzffnVar.zzg(th);
        zzffnVar.zzf(false);
        zzffyVar.zza(zzffnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zzb(Object obj) {
    }
}
