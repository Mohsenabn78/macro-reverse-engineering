package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeks implements zzeqy {
    private final Clock zza;
    private final zzfai zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeks(Clock clock, zzfai zzfaiVar) {
        this.zza = clock;
        this.zzb = zzfaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return zzfwc.zzh(new zzekt(this.zzb, this.zza.currentTimeMillis()));
    }
}
