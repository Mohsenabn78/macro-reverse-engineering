package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbif implements zzbij {
    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcezVar = (zzcez) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcezVar.zzbj();
        } else if ("resume".equals(str)) {
            zzcezVar.zzbk();
        }
    }
}
