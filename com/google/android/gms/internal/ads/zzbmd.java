package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbmd implements zzcan {
    final /* synthetic */ zzbmf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmd(zzbmf zzbmfVar) {
        this.zza = zzbmfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzbmk zzbmkVar;
        zzbmm zzbmmVar = (zzbmm) obj;
        com.google.android.gms.ads.internal.util.zze.zza("Releasing engine reference.");
        zzbmkVar = this.zza.zzb;
        zzbmkVar.zzd();
    }
}
