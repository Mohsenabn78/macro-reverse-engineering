package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbhq implements zzbij {
    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzcez zzcezVar = (zzcez) obj;
        zzbee zzK = zzcezVar.zzK();
        if (zzK != null && (zza = zzK.zza()) != null) {
            zzcezVar.zze("nativeAdViewSignalsReady", zza);
        } else {
            zzcezVar.zze("nativeAdViewSignalsReady", new JSONObject());
        }
    }
}
