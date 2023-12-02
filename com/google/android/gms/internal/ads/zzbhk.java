package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzbhk implements zzbij {
    public final /* synthetic */ zzdcu zza;

    public /* synthetic */ zzbhk(zzdcu zzdcuVar) {
        this.zza = zzdcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zza(Object obj, Map map) {
        zzcez zzcezVar = (zzcez) obj;
        zzbii.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzbzr.zzj("URL missing from click GMSG.");
        } else {
            zzfwc.zzq(zzbii.zza(zzcezVar, str), new zzbhz(zzcezVar), zzcae.zza);
        }
    }
}
