package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcmp implements zzcmj {
    private final zzdsx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcmp(zzdsx zzdsxVar) {
        this.zza = zzdsxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcmj
    public final void zza(Map map) {
        char c4;
        String str = (String) map.get("gesture");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int hashCode = str.hashCode();
        if (hashCode != 97520651) {
            if (hashCode == 109399814 && str.equals("shake")) {
                c4 = 0;
            }
            c4 = 65535;
        } else {
            if (str.equals("flick")) {
                c4 = 1;
            }
            c4 = 65535;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                this.zza.zzk(zzdst.NONE);
                return;
            } else {
                this.zza.zzk(zzdst.FLICK);
                return;
            }
        }
        this.zza.zzk(zzdst.SHAKE);
    }
}
