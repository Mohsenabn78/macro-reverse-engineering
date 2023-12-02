package com.google.android.gms.internal.ads;

import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@RequiresApi(api = 21)
/* loaded from: classes4.dex */
public final class zzbjd extends zzbjf {
    private final OnH5AdsEventListener zza;

    public zzbjd(OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = onH5AdsEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbjg
    public final void zzb(String str) {
        this.zza.onH5AdsEvent(str);
    }
}
