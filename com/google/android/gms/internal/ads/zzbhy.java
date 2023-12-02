package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbhy implements zzbij {
    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcezVar = (zzcez) obj;
        try {
            String str = (String) map.get("enabled");
            if (!zzfon.zzc("true", str) && !zzfon.zzc("false", str)) {
                return;
            }
            zzfmi.zzi(zzcezVar.getContext()).zzm(Boolean.parseBoolean(str));
        } catch (IOException e4) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
