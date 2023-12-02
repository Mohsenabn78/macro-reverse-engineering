package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcfq implements zzbij {
    final /* synthetic */ zzcfs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfq(zzcfs zzcfsVar) {
        this.zza = zzcfsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int i4;
        zzcez zzcezVar = (zzcez) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        zzcfs zzcfsVar = this.zza;
                        i4 = zzcfsVar.zzG;
                        if (i4 != parseInt) {
                            zzcfsVar.zzG = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e4) {
                    zzbzr.zzk("Exception occurred while getting webview content height", e4);
                }
            }
        }
    }
}
