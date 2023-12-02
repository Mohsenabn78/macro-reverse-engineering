package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdlj implements zzbij {
    @Nullable
    private final zzbfv zza;
    private final zzdlx zzb;
    private final zzgvy zzc;

    public zzdlj(zzdhl zzdhlVar, zzdha zzdhaVar, zzdlx zzdlxVar, zzgvy zzgvyVar) {
        this.zza = zzdhlVar.zzc(zzdhaVar.zzz());
        this.zzb = zzdlxVar;
        this.zzc = zzgvyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbfl) this.zzc.zzb(), str);
        } catch (RemoteException e4) {
            zzbzr.zzk("Failed to call onCustomClick for asset " + str + ".", e4);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzi("/nativeAdCustomClick", this);
    }
}
