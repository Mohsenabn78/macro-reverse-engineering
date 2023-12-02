package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdix implements zzcwa {
    private final zzdha zza;
    private final zzdhf zzb;

    public zzdix(zzdha zzdhaVar, zzdhf zzdhfVar) {
        this.zza = zzdhaVar;
        this.zzb = zzdhfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwa
    public final void zzl() {
        zzdha zzdhaVar = this.zza;
        if (zzdhaVar.zzt() == null) {
            return;
        }
        zzcez zzq = zzdhaVar.zzq();
        zzcez zzr = zzdhaVar.zzr();
        if (zzq == null) {
            if (zzr == null) {
                zzq = null;
            } else {
                zzq = zzr;
            }
        }
        if (this.zzb.zzd() && zzq != null) {
            zzq.zzd("onSdkImpression", new ArrayMap());
        }
    }
}
