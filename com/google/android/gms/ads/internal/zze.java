package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbbe;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbmp;
import com.google.android.gms.internal.ads.zzbmt;
import com.google.android.gms.internal.ads.zzbmw;
import com.google.android.gms.internal.ads.zzbmz;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcah;
import com.google.android.gms.internal.ads.zzffm;
import com.google.android.gms.internal.ads.zzffn;
import com.google.android.gms.internal.ads.zzfgb;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfwc;
import com.google.android.gms.internal.ads.zzfwm;
import com.google.android.gms.internal.ads.zzfwn;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zze {

    /* renamed from: a  reason: collision with root package name */
    private Context f19377a;

    /* renamed from: b  reason: collision with root package name */
    private long f19378b = 0;

    @VisibleForTesting
    final void a(Context context, zzbzx zzbzxVar, boolean z3, @Nullable zzbyu zzbyuVar, String str, @Nullable String str2, @Nullable Runnable runnable, final zzfgb zzfgbVar) {
        PackageInfo packageInfo;
        if (zzt.zzB().elapsedRealtime() - this.f19378b < 5000) {
            zzbzr.zzj("Not retrying to fetch app settings");
            return;
        }
        this.f19378b = zzt.zzB().elapsedRealtime();
        if (zzbyuVar != null && !TextUtils.isEmpty(zzbyuVar.zzc())) {
            if (zzt.zzB().currentTimeMillis() - zzbyuVar.zza() <= ((Long) zzba.zzc().zzb(zzbbm.zzdN)).longValue() && zzbyuVar.zzi()) {
                return;
            }
        }
        if (context == null) {
            zzbzr.zzj("Context not provided to fetch application settings");
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            zzbzr.zzj("App settings could not be fetched. Required parameters missing");
        } else {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.f19377a = applicationContext;
            final zzffn zza = zzffm.zza(context, 4);
            zza.zzh();
            zzbmz zza2 = zzt.zzf().zza(this.f19377a, zzbzxVar, zzfgbVar);
            zzbmt zzbmtVar = zzbmw.zza;
            zzbmp zza3 = zza2.zza("google.afma.config.fetchAppSettings", zzbmtVar, zzbmtVar);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z3);
                jSONObject.put("pn", context.getPackageName());
                zzbbe zzbbeVar = zzbbm.zza;
                jSONObject.put("experiment_ids", TextUtils.join(",", zzba.zza().zza()));
                jSONObject.put("js", zzbzxVar.zza);
                try {
                    ApplicationInfo applicationInfo = this.f19377a.getApplicationInfo();
                    if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                        jSONObject.put("version", packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
                }
                zzfwm zzb = zza3.zzb(jSONObject);
                zzfvj zzfvjVar = new zzfvj() { // from class: com.google.android.gms.ads.internal.zzd
                    @Override // com.google.android.gms.internal.ads.zzfvj
                    public final zzfwm zza(Object obj) {
                        zzfgb zzfgbVar2 = zzfgb.this;
                        zzffn zzffnVar = zza;
                        JSONObject jSONObject2 = (JSONObject) obj;
                        boolean optBoolean = jSONObject2.optBoolean("isSuccessful", false);
                        if (optBoolean) {
                            zzt.zzo().zzh().zzu(jSONObject2.getString("appSettingsJson"));
                        }
                        zzffnVar.zzf(optBoolean);
                        zzfgbVar2.zzb(zzffnVar.zzl());
                        return zzfwc.zzh(null);
                    }
                };
                zzfwn zzfwnVar = zzcae.zzf;
                zzfwm zzm = zzfwc.zzm(zzb, zzfvjVar, zzfwnVar);
                if (runnable != null) {
                    zzb.zzc(runnable, zzfwnVar);
                }
                zzcah.zza(zzm, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e4) {
                zzbzr.zzh("Error requesting application settings", e4);
                zza.zzg(e4);
                zza.zzf(false);
                zzfgbVar.zzb(zza.zzl());
            }
        }
    }

    public final void zza(Context context, zzbzx zzbzxVar, String str, @Nullable Runnable runnable, zzfgb zzfgbVar) {
        a(context, zzbzxVar, true, null, str, null, runnable, zzfgbVar);
    }

    public final void zzc(Context context, zzbzx zzbzxVar, String str, zzbyu zzbyuVar, zzfgb zzfgbVar) {
        String str2;
        if (zzbyuVar != null) {
            str2 = zzbyuVar.zzb();
        } else {
            str2 = null;
        }
        a(context, zzbzxVar, false, zzbyuVar, str2, str, null, zzfgbVar);
    }
}
