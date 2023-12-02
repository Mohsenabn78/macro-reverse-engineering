package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdlo implements zzfvy {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbij zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdlo(zzdlx zzdlxVar, String str, zzbij zzbijVar) {
        this.zza = str;
        this.zzb = zzbijVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcez) obj).zzad(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
    }
}
