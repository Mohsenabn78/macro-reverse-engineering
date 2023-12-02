package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzemx {
    public final zzfwm zza;
    private final long zzb;
    private final Clock zzc;

    public zzemx(zzfwm zzfwmVar, long j4, Clock clock) {
        this.zza = zzfwmVar;
        this.zzc = clock;
        this.zzb = clock.elapsedRealtime() + j4;
    }

    public final boolean zza() {
        if (this.zzb < this.zzc.elapsedRealtime()) {
            return true;
        }
        return false;
    }
}
