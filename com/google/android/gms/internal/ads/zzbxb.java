package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbxb {
    private Context zza;
    private Clock zzb;
    private com.google.android.gms.ads.internal.util.zzg zzc;
    private zzbxw zzd;

    private zzbxb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbxb(zzbxa zzbxaVar) {
    }

    public final zzbxb zza(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzc = zzgVar;
        return this;
    }

    public final zzbxb zzb(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzbxb zzc(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }

    public final zzbxb zzd(zzbxw zzbxwVar) {
        this.zzd = zzbxwVar;
        return this;
    }

    public final zzbxx zze() {
        zzgwm.zzc(this.zza, Context.class);
        zzgwm.zzc(this.zzb, Clock.class);
        zzgwm.zzc(this.zzc, com.google.android.gms.ads.internal.util.zzg.class);
        zzgwm.zzc(this.zzd, zzbxw.class);
        return new zzbxd(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
