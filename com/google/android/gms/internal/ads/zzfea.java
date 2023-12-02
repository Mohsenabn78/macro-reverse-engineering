package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfea implements zzfvy {
    final /* synthetic */ zzfdq zza;
    final /* synthetic */ zzfec zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfea(zzfec zzfecVar, zzfdq zzfdqVar) {
        this.zzb = zzfecVar;
        this.zza = zzfdqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzfee zzfeeVar;
        zzfeeVar = this.zzb.zza.zzd;
        zzfeeVar.zzb(this.zza, th);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zzb(Object obj) {
        zzfee zzfeeVar;
        zzfeeVar = this.zzb.zza.zzd;
        zzfeeVar.zzd(this.zza);
    }
}
