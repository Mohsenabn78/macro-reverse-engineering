package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbwy {
    private final Clock zza;
    private final zzbww zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbwy(Clock clock, zzbww zzbwwVar) {
        this.zza = clock;
        this.zzb = zzbwwVar;
    }

    public static zzbwy zza(Context context) {
        return zzbxx.zzd(context).zzb();
    }

    public final void zzb(int i4, long j4) {
        this.zzb.zzb(i4, j4);
    }

    public final void zzc() {
        this.zzb.zza();
    }

    public final void zzd(com.google.android.gms.ads.internal.client.zzff zzffVar) {
        this.zzb.zzb(-1, this.zza.currentTimeMillis());
    }

    public final void zze() {
        this.zzb.zzb(-1, this.zza.currentTimeMillis());
    }
}
