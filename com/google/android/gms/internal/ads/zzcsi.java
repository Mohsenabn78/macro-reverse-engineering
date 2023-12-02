package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcsi implements zzfvy {
    final /* synthetic */ zzcsk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsi(zzcsk zzcskVar) {
        this.zza = zzcskVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzdal zzdalVar;
        zzdalVar = this.zza.zzf;
        zzdalVar.zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(@NullableDecl Object obj) {
        zzdal zzdalVar;
        zzbue zzbueVar = (zzbue) obj;
        zzdalVar = this.zza.zzf;
        zzdalVar.zzk(true);
    }
}
