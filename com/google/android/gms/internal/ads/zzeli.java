package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzeli implements zzeqy {
    private final Set zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeli(Set set) {
        this.zza = set;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        final ArrayList arrayList = new ArrayList();
        for (String str : this.zza) {
            arrayList.add(str);
        }
        return zzfwc.zzh(new zzeqx() { // from class: com.google.android.gms.internal.ads.zzelh
            @Override // com.google.android.gms.internal.ads.zzeqx
            public final void zzh(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", arrayList);
            }
        });
    }
}
