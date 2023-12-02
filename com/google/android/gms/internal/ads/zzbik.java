package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbik implements zzbij {
    private final zzbil zza;

    public zzbik(zzbil zzbilVar) {
        this.zza = zzbilVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcezVar = (zzcez) obj;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f4 = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f4 = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e4) {
            zzbzr.zzh("Fail to parse float", e4);
        }
        this.zza.zzc(equals);
        this.zza.zzb(equals2, f4);
        zzcezVar.zzat(equals);
    }
}
