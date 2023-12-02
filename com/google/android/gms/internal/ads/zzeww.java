package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeww implements zzfov {
    final /* synthetic */ zzexa zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeww(zzexa zzexaVar) {
        this.zza = zzexaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfov
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzfce zze;
        zzewz zzewzVar;
        zzbzr.zzh("", (zzdwa) obj);
        com.google.android.gms.ads.internal.util.zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzexa zzexaVar = this.zza;
        zze = zzexaVar.zze();
        zzexaVar.zzd = new zzewz(null, zze, null);
        zzewzVar = this.zza.zzd;
        return zzewzVar;
    }
}
