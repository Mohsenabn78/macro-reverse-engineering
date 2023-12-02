package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdph implements zzfem {
    private final Map zza;
    private final zzawz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdph(zzawz zzawzVar, Map map) {
        this.zza = map;
        this.zzb = zzawzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbC(zzfef zzfefVar, String str, Throwable th) {
        if (this.zza.containsKey(zzfefVar)) {
            this.zzb.zzc(((zzdpg) this.zza.get(zzfefVar)).zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzc(zzfef zzfefVar, String str) {
        if (this.zza.containsKey(zzfefVar)) {
            this.zzb.zzc(((zzdpg) this.zza.get(zzfefVar)).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzd(zzfef zzfefVar, String str) {
        if (this.zza.containsKey(zzfefVar)) {
            this.zzb.zzc(((zzdpg) this.zza.get(zzfefVar)).zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbB(zzfef zzfefVar, String str) {
    }
}
