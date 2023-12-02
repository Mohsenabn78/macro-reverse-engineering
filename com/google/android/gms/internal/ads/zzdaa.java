package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdaa extends zzdaq implements zzbhe {
    public zzdaa(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbhe
    public final synchronized void zzbz(final String str, final String str2) {
        zzp(new zzdap() { // from class: com.google.android.gms.internal.ads.zzczz
            @Override // com.google.android.gms.internal.ads.zzdap
            public final void zza(Object obj) {
                ((AppEventListener) obj).onAppEvent(str, str2);
            }
        });
    }
}
