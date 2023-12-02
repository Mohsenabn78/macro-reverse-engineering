package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzemy implements zzeqy {
    private final AtomicReference zza = new AtomicReference();
    private final Clock zzb;
    private final zzeqy zzc;
    private final long zzd;

    public zzemy(zzeqy zzeqyVar, long j4, Clock clock) {
        this.zzb = clock;
        this.zzc = zzeqyVar;
        this.zzd = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 16;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        zzemx zzemxVar = (zzemx) this.zza.get();
        if (zzemxVar == null || zzemxVar.zza()) {
            zzemxVar = new zzemx(this.zzc.zzb(), this.zzd, this.zzb);
            this.zza.set(zzemxVar);
        }
        return zzemxVar.zza;
    }
}
