package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbio implements zzbij {
    private final Context zza;

    public zzbio(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zza(Object obj, Map map) {
        char c4;
        if (!com.google.android.gms.ads.internal.zzt.zzn().zzu(this.zza)) {
            return;
        }
        String str = (String) map.get("eventName");
        String str2 = (String) map.get("eventId");
        int hashCode = str.hashCode();
        if (hashCode != 94399) {
            if (hashCode != 94401) {
                if (hashCode == 94407 && str.equals("_ai")) {
                    c4 = 1;
                }
                c4 = 65535;
            } else {
                if (str.equals("_ac")) {
                    c4 = 0;
                }
                c4 = 65535;
            }
        } else {
            if (str.equals("_aa")) {
                c4 = 2;
            }
            c4 = 65535;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 != 2) {
                    zzbzr.zzg("logScionEvent gmsg contained unsupported eventName");
                    return;
                } else {
                    com.google.android.gms.ads.internal.zzt.zzn().zzk(this.zza, str2);
                    return;
                }
            }
            com.google.android.gms.ads.internal.zzt.zzn().zzn(this.zza, str2);
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzn().zzm(this.zza, str2);
    }
}
