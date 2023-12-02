package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdtp implements zzfvy {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdtr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdtp(zzdtr zzdtrVar, String str) {
        this.zzb = zzdtrVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdtf zzdtfVar;
        ((zzdsl) obj).zze();
        zzdtfVar = this.zzb.zzd;
        zzdtfVar.zzk(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
    }
}
