package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfeu {
    private final HashMap zza;
    private final zzffa zzb;

    private zzfeu() {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        this.zzb = new zzffa(com.google.android.gms.ads.internal.zzt.zzB());
        hashMap.put("new_csi", "1");
    }

    public static zzfeu zzb(String str) {
        zzfeu zzfeuVar = new zzfeu();
        zzfeuVar.zza.put("action", str);
        return zzfeuVar;
    }

    public static zzfeu zzc(String str) {
        zzfeu zzfeuVar = new zzfeu();
        zzfeuVar.zza.put(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, str);
        return zzfeuVar;
    }

    public final zzfeu zza(@NonNull String str, @NonNull String str2) {
        this.zza.put(str, str2);
        return this;
    }

    public final zzfeu zzd(@NonNull String str) {
        this.zzb.zzb(str);
        return this;
    }

    public final zzfeu zze(@NonNull String str, @NonNull String str2) {
        this.zzb.zzc(str, str2);
        return this;
    }

    public final zzfeu zzf(zzezn zzeznVar) {
        this.zza.put("aai", zzeznVar.zzx);
        return this;
    }

    public final zzfeu zzg(zzezq zzezqVar) {
        if (!TextUtils.isEmpty(zzezqVar.zzb)) {
            this.zza.put("gqi", zzezqVar.zzb);
        }
        return this;
    }

    public final zzfeu zzh(zzezz zzezzVar, @Nullable zzbze zzbzeVar) {
        String str;
        zzezy zzezyVar = zzezzVar.zzb;
        zzg(zzezyVar.zzb);
        if (!zzezyVar.zza.isEmpty()) {
            switch (((zzezn) zzezyVar.zza.get(0)).zzb) {
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
                    if (zzbzeVar != null) {
                        HashMap hashMap = this.zza;
                        if (true != zzbzeVar.zzk()) {
                            str = "0";
                        } else {
                            str = "1";
                        }
                        hashMap.put("as", str);
                        break;
                    }
                    break;
                default:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, EnvironmentCompat.MEDIA_UNKNOWN);
                    break;
            }
        }
        return this;
    }

    public final zzfeu zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final Map zzj() {
        HashMap hashMap = new HashMap(this.zza);
        for (zzfez zzfezVar : this.zzb.zza()) {
            hashMap.put(zzfezVar.zza, zzfezVar.zzb);
        }
        return hashMap;
    }
}
