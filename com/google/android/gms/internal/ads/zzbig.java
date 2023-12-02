package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbig implements zzbij {
    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcezVar = (zzcez) obj;
        if (map.keySet().contains("start")) {
            zzcezVar.zzN().zzl();
        } else if (map.keySet().contains("stop")) {
            zzcezVar.zzN().zzm();
        } else if (map.keySet().contains("cancel")) {
            zzcezVar.zzN().zzk();
        }
    }
}
