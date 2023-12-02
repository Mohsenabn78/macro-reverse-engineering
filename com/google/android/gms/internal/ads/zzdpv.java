package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class zzdpv {
    private final ConcurrentHashMap zza;
    private final zzbze zzb;
    private final zzfai zzc;
    private final String zzd;
    private final String zze;

    public zzdpv(zzdqf zzdqfVar, zzbze zzbzeVar, zzfai zzfaiVar, String str, String str2) {
        ConcurrentHashMap zzc = zzdqfVar.zzc();
        this.zza = zzc;
        this.zzb = zzbzeVar;
        this.zzc = zzfaiVar;
        this.zzd = str;
        this.zze = str2;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgN)).booleanValue()) {
            return;
        }
        int zze = com.google.android.gms.ads.nonagon.signalgeneration.zzf.zze(zzfaiVar);
        int i4 = zze - 1;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        zzc.put("se", "r_both");
                    } else {
                        zzc.put("se", "r_adstring");
                    }
                } else {
                    zzc.put("se", "r_adinfo");
                }
            } else {
                zzc.put("se", "query_g");
            }
            zzc.put("scar", "true");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhm)).booleanValue()) {
                zzc.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
            }
            if (zze == 2) {
                zzc.put("rid", str);
            }
            zzd("ragent", zzfaiVar.zzd.zzp);
            zzd("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzf.zza(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(zzfaiVar.zzd)));
            return;
        }
        zzc.put("scar", "false");
    }

    private final void zzd(String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zza.put(str, str2);
        }
    }

    public final Map zza() {
        return this.zza;
    }

    public final void zzb(zzezz zzezzVar) {
        String str;
        if (!zzezzVar.zzb.zza.isEmpty()) {
            switch (((zzezn) zzezzVar.zzb.zza.get(0)).zzb) {
                case 1:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "banner");
                    break;
                case 2:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    ConcurrentHashMap concurrentHashMap = this.zza;
                    if (true != this.zzb.zzk()) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    concurrentHashMap.put("as", str);
                    break;
                default:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, EnvironmentCompat.MEDIA_UNKNOWN);
                    break;
            }
        }
        zzd("gqi", zzezzVar.zzb.zzb.zzb);
    }

    public final void zzc(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
