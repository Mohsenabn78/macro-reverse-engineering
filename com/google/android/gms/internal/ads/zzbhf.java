package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbhf implements zzbij {
    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcezVar = (zzcez) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get(Constants.ScionAnalytics.PARAM_LABEL);
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzbzr.zzj("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzbzr.zzj("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() + (Long.parseLong(str4) - com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
                    if (true == TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzcezVar.zzm().zzc(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e4) {
                    zzbzr.zzk("Malformed timestamp for CSI tick.", e4);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzbzr.zzj("No value given for CSI experiment.");
            } else {
                zzcezVar.zzm().zza().zzd("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzbzr.zzj("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzbzr.zzj("No name given for CSI extra.");
            } else {
                zzcezVar.zzm().zza().zzd(str6, str7);
            }
        }
    }
}
