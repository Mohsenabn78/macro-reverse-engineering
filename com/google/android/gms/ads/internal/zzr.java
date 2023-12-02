package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzeqv;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzr {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19399a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19400b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f19401c = new TreeMap();

    /* renamed from: d  reason: collision with root package name */
    private String f19402d;

    /* renamed from: e  reason: collision with root package name */
    private String f19403e;

    /* renamed from: f  reason: collision with root package name */
    private final String f19404f;

    public zzr(Context context, String str) {
        String concat;
        this.f19399a = context.getApplicationContext();
        this.f19400b = str;
        String packageName = context.getPackageName();
        try {
            concat = packageName + "-" + Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            zzbzr.zzh("Unable to get package version name for reporting", e4);
            concat = String.valueOf(packageName).concat("-missing");
        }
        this.f19404f = concat;
    }

    public final String a() {
        return this.f19404f;
    }

    public final String b() {
        return this.f19403e;
    }

    public final String c() {
        return this.f19400b;
    }

    public final String d() {
        return this.f19402d;
    }

    public final Map e() {
        return this.f19401c;
    }

    public final void f(com.google.android.gms.ads.internal.client.zzl zzlVar, zzbzx zzbzxVar) {
        Bundle bundle;
        this.f19402d = zzlVar.zzj.zza;
        Bundle bundle2 = zzlVar.zzm;
        if (bundle2 != null) {
            bundle = bundle2.getBundle(AdMobAdapter.class.getName());
        } else {
            bundle = null;
        }
        if (bundle == null) {
            return;
        }
        String str = (String) zzbct.zzc.zze();
        for (String str2 : bundle.keySet()) {
            if (str.equals(str2)) {
                this.f19403e = bundle.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.f19401c.put(str2.substring(4), bundle.getString(str2));
            }
        }
        this.f19401c.put("SDKVersion", zzbzxVar.zza);
        if (((Boolean) zzbct.zza.zze()).booleanValue()) {
            try {
                Bundle zzc = zzeqv.zzc(this.f19399a, new JSONArray((String) zzbct.zzb.zze()));
                for (String str3 : zzc.keySet()) {
                    this.f19401c.put(str3, zzc.get(str3).toString());
                }
            } catch (JSONException e4) {
                zzbzr.zzh("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e4);
            }
        }
    }
}
