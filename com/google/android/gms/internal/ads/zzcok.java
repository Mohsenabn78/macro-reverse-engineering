package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcok {
    private final zzfev zza;
    private final zzdqa zzb;
    private final zzezz zzc;

    public zzcok(zzdqa zzdqaVar, zzezz zzezzVar, zzfev zzfevVar) {
        this.zza = zzfevVar;
        this.zzb = zzdqaVar;
        this.zzc = zzezzVar;
    }

    private static String zzb(int i4) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            return "u";
                        }
                        return "ac";
                    }
                    return "cb";
                }
                return "cc";
            }
            return "bb";
        }
        return "h";
    }

    public final void zza(long j4, int i4) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            zzfev zzfevVar = this.zza;
            zzfeu zzb = zzfeu.zzb("ad_closed");
            zzb.zzg(this.zzc.zzb.zzb);
            zzb.zza("show_time", String.valueOf(j4));
            zzb.zza(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
            zzb.zza("acr", zzb(i4));
            zzfevVar.zzb(zzb);
            return;
        }
        zzdpz zza = this.zzb.zza();
        zza.zze(this.zzc.zzb.zzb);
        zza.zzb("action", "ad_closed");
        zza.zzb("show_time", String.valueOf(j4));
        zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        zza.zzb("acr", zzb(i4));
        zza.zzg();
    }
}
