package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public interface zzhb extends zzge {
    public static final zzfpi zza = new zzfpi() { // from class: com.google.android.gms.internal.ads.zzgv
        @Override // com.google.android.gms.internal.ads.zzfpi
        public final boolean zza(Object obj) {
            String str = (String) obj;
            if (str != null) {
                String zza2 = zzfon.zza(str);
                if (!TextUtils.isEmpty(zza2)) {
                    if ((!zza2.contains("text") || zza2.contains("text/vtt")) && !zza2.contains("html") && !zza2.contains("xml")) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    };

    @Override // com.google.android.gms.internal.ads.zzge
    Map zze();
}
