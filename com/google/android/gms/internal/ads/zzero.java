package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzero implements zzeqx {
    @Nullable
    private final AdvertisingIdClient.Info zza;
    @Nullable
    private final String zzb;
    private final zzfme zzc;

    public zzero(@Nullable AdvertisingIdClient.Info info, @Nullable String str, zzfme zzfmeVar) {
        this.zza = info;
        this.zzb = str;
        this.zzc = zzfmeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        try {
            JSONObject zzf = com.google.android.gms.ads.internal.util.zzbu.zzf((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info != null && !TextUtils.isEmpty(info.getId())) {
                zzf.put("rdid", this.zza.getId());
                zzf.put("is_lat", this.zza.isLimitAdTrackingEnabled());
                zzf.put("idtype", "adid");
                zzfme zzfmeVar = this.zzc;
                if (zzfmeVar.zzc()) {
                    zzf.put("paidv1_id_android_3p", zzfmeVar.zzb());
                    zzf.put("paidv1_creation_time_android_3p", this.zzc.zza());
                    return;
                }
                return;
            }
            String str = this.zzb;
            if (str != null) {
                zzf.put("pdid", str);
                zzf.put("pdidtype", "ssaid");
            }
        } catch (JSONException e4) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed putting Ad ID.", e4);
        }
    }
}
