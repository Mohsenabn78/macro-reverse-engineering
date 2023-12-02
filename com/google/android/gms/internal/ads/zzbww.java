package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbww {
    private final Clock zza;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzbxw zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbww(Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbxw zzbxwVar) {
        this.zza = clock;
        this.zzb = zzgVar;
        this.zzc = zzbxwVar;
    }

    public final void zza() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzar)).booleanValue()) {
            return;
        }
        this.zzc.zzt();
    }

    public final void zzb(int i4, long j4) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaq)).booleanValue()) {
            return;
        }
        if (j4 - this.zzb.zzf() < 0) {
            com.google.android.gms.ads.internal.util.zze.zza("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzar)).booleanValue()) {
            this.zzb.zzK(-1);
            this.zzb.zzL(j4);
        } else {
            this.zzb.zzK(i4);
            this.zzb.zzL(j4);
        }
        zza();
    }
}
