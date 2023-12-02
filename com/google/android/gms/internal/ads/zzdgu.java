package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdgu implements zzfvy {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdgv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgu(zzdgv zzdgvVar, String str, boolean z3) {
        this.zzb = zzdgvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdha zzdhaVar;
        zzfwv zzfwvVar;
        zzdhaVar = this.zzb.zze;
        zzdhaVar.zzS((zzcez) obj);
        this.zzb.zzt(this.zza, true);
        zzfwvVar = this.zzb.zzB;
        zzfwvVar.zzd(Boolean.TRUE);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
    }
}
