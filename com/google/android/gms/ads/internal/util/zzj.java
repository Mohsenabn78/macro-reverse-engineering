package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.Util;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzauz;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbcx;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzfwm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzj implements zzg {

    /* renamed from: b  reason: collision with root package name */
    private boolean f19336b;

    /* renamed from: d  reason: collision with root package name */
    private zzfwm f19338d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences f19340f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private SharedPreferences.Editor f19341g;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f19343i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private String f19344j;

    /* renamed from: a  reason: collision with root package name */
    private final Object f19335a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final List f19337c = new ArrayList();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private zzauz f19339e = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19342h = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19345k = true;

    /* renamed from: l  reason: collision with root package name */
    private String f19346l = Util.ANY_CONTACT_ID;

    /* renamed from: m  reason: collision with root package name */
    private String f19347m = Util.ANY_CONTACT_ID;

    /* renamed from: n  reason: collision with root package name */
    private String f19348n = Util.ANY_CONTACT_ID;

    /* renamed from: o  reason: collision with root package name */
    private int f19349o = -1;

    /* renamed from: p  reason: collision with root package name */
    private zzbyu f19350p = new zzbyu("", 0);

    /* renamed from: q  reason: collision with root package name */
    private long f19351q = 0;

    /* renamed from: r  reason: collision with root package name */
    private long f19352r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f19353s = -1;

    /* renamed from: t  reason: collision with root package name */
    private int f19354t = 0;

    /* renamed from: u  reason: collision with root package name */
    private Set f19355u = Collections.emptySet();

    /* renamed from: v  reason: collision with root package name */
    private JSONObject f19356v = new JSONObject();

    /* renamed from: w  reason: collision with root package name */
    private boolean f19357w = true;

    /* renamed from: x  reason: collision with root package name */
    private boolean f19358x = true;

    /* renamed from: y  reason: collision with root package name */
    private String f19359y = null;

    /* renamed from: z  reason: collision with root package name */
    private String f19360z = "";
    private boolean A = false;
    private String B = "";
    private int C = -1;
    private int D = -1;
    private long E = 0;

    private final void b() {
        zzfwm zzfwmVar = this.f19338d;
        if (zzfwmVar == null || zzfwmVar.isDone()) {
            return;
        }
        try {
            this.f19338d.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e4) {
            Thread.currentThread().interrupt();
            zzbzr.zzk("Interrupted while waiting for preferences loaded.", e4);
        } catch (CancellationException e5) {
            e = e5;
            zzbzr.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e6) {
            e = e6;
            zzbzr.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e7) {
            e = e7;
            zzbzr.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final void c() {
        zzcae.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzi
            @Override // java.lang.Runnable
            public final void run() {
                zzj.this.zzg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Context context, String str) {
        NetworkSecurityPolicy networkSecurityPolicy;
        SharedPreferences sharedPreferences = context.getSharedPreferences("admob", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.f19335a) {
            this.f19340f = sharedPreferences;
            this.f19341g = edit;
            if (PlatformVersion.isAtLeastM()) {
                networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
                networkSecurityPolicy.isCleartextTrafficPermitted();
            }
            this.f19342h = this.f19340f.getBoolean("use_https", this.f19342h);
            this.f19357w = this.f19340f.getBoolean("content_url_opted_out", this.f19357w);
            this.f19343i = this.f19340f.getString("content_url_hashes", this.f19343i);
            this.f19345k = this.f19340f.getBoolean("gad_idless", this.f19345k);
            this.f19358x = this.f19340f.getBoolean("content_vertical_opted_out", this.f19358x);
            this.f19344j = this.f19340f.getString("content_vertical_hashes", this.f19344j);
            this.f19354t = this.f19340f.getInt("version_code", this.f19354t);
            this.f19350p = new zzbyu(this.f19340f.getString("app_settings_json", this.f19350p.zzc()), this.f19340f.getLong("app_settings_last_update_ms", this.f19350p.zza()));
            this.f19351q = this.f19340f.getLong("app_last_background_time_ms", this.f19351q);
            this.f19353s = this.f19340f.getInt("request_in_session_count", this.f19353s);
            this.f19352r = this.f19340f.getLong("first_ad_req_time_ms", this.f19352r);
            this.f19355u = this.f19340f.getStringSet("never_pool_slots", this.f19355u);
            this.f19359y = this.f19340f.getString("display_cutout", this.f19359y);
            this.C = this.f19340f.getInt("app_measurement_npa", this.C);
            this.D = this.f19340f.getInt("sd_app_measure_npa", this.D);
            this.E = this.f19340f.getLong("sd_app_measure_npa_ts", this.E);
            this.f19360z = this.f19340f.getString("inspector_info", this.f19360z);
            this.A = this.f19340f.getBoolean("linked_device", this.A);
            this.B = this.f19340f.getString("linked_ad_unit", this.B);
            this.f19346l = this.f19340f.getString("IABTCF_gdprApplies", this.f19346l);
            this.f19348n = this.f19340f.getString("IABTCF_PurposeConsents", this.f19348n);
            this.f19347m = this.f19340f.getString("IABTCF_TCString", this.f19347m);
            this.f19349o = this.f19340f.getInt("gad_has_consent_for_cookies", this.f19349o);
            try {
                this.f19356v = new JSONObject(this.f19340f.getString("native_advanced_settings", "{}"));
            } catch (JSONException e4) {
                zzbzr.zzk("Could not convert native advanced settings to json object", e4);
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzA(String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
            return;
        }
        b();
        synchronized (this.f19335a) {
            if (this.B.equals(str)) {
                return;
            }
            this.B = str;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putString("linked_ad_unit", str);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzB(boolean z3) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
            return;
        }
        b();
        synchronized (this.f19335a) {
            if (this.A == z3) {
                return;
            }
            this.A = z3;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putBoolean("linked_device", z3);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzC(String str) {
        b();
        synchronized (this.f19335a) {
            if (TextUtils.equals(this.f19359y, str)) {
                return;
            }
            this.f19359y = str;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putString("display_cutout", str);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzD(long j4) {
        b();
        synchronized (this.f19335a) {
            if (this.f19352r == j4) {
                return;
            }
            this.f19352r = j4;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putLong("first_ad_req_time_ms", j4);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzE(int i4) {
        b();
        synchronized (this.f19335a) {
            this.f19349o = i4;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                if (i4 == -1) {
                    editor.remove("gad_has_consent_for_cookies");
                } else {
                    editor.putInt("gad_has_consent_for_cookies", i4);
                }
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzF(@NonNull String str, @NonNull String str2) {
        char c4;
        b();
        synchronized (this.f19335a) {
            int hashCode = str.hashCode();
            if (hashCode != -2004976699) {
                if (hashCode != 83641339) {
                    if (hashCode == 1218895378 && str.equals("IABTCF_TCString")) {
                        c4 = 1;
                    }
                    c4 = 65535;
                } else {
                    if (str.equals("IABTCF_gdprApplies")) {
                        c4 = 0;
                    }
                    c4 = 65535;
                }
            } else {
                if (str.equals("IABTCF_PurposeConsents")) {
                    c4 = 2;
                }
                c4 = 65535;
            }
            if (c4 != 0) {
                if (c4 != 1) {
                    if (c4 != 2) {
                        return;
                    }
                    this.f19348n = str2;
                } else {
                    this.f19347m = str2;
                }
            } else {
                this.f19346l = str2;
            }
            if (this.f19341g != null) {
                if (str2.equals(Util.ANY_CONTACT_ID)) {
                    this.f19341g.remove(str);
                } else {
                    this.f19341g.putString(str, str2);
                }
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzG(String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
            return;
        }
        b();
        synchronized (this.f19335a) {
            if (this.f19360z.equals(str)) {
                return;
            }
            this.f19360z = str;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putString("inspector_info", str);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzH(boolean z3) {
        b();
        synchronized (this.f19335a) {
            if (z3 == this.f19345k) {
                return;
            }
            this.f19345k = z3;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putBoolean("gad_idless", z3);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzI(String str, String str2, boolean z3) {
        b();
        synchronized (this.f19335a) {
            JSONArray optJSONArray = this.f19356v.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject == null) {
                    return;
                }
                if (str2.equals(optJSONObject.optString("template_id"))) {
                    if (z3 && optJSONObject.optBoolean("uses_media_view", false)) {
                        return;
                    }
                    length = i4;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z3);
                jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.f19356v.put(str, optJSONArray);
            } catch (JSONException e4) {
                zzbzr.zzk("Could not update native advanced settings", e4);
            }
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.f19356v.toString());
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzJ(int i4) {
        b();
        synchronized (this.f19335a) {
            if (this.f19353s == i4) {
                return;
            }
            this.f19353s = i4;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putInt("request_in_session_count", i4);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzK(int i4) {
        b();
        synchronized (this.f19335a) {
            if (this.D == i4) {
                return;
            }
            this.D = i4;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putInt("sd_app_measure_npa", i4);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzL(long j4) {
        b();
        synchronized (this.f19335a) {
            if (this.E == j4) {
                return;
            }
            this.E = j4;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putLong("sd_app_measure_npa_ts", j4);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzM() {
        boolean z3;
        b();
        synchronized (this.f19335a) {
            z3 = this.f19357w;
        }
        return z3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzN() {
        boolean z3;
        b();
        synchronized (this.f19335a) {
            z3 = this.f19358x;
        }
        return z3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzO() {
        boolean z3;
        b();
        synchronized (this.f19335a) {
            z3 = this.A;
        }
        return z3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzP() {
        boolean z3;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzau)).booleanValue()) {
            return false;
        }
        b();
        synchronized (this.f19335a) {
            z3 = this.f19345k;
        }
        return z3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zza() {
        int i4;
        b();
        synchronized (this.f19335a) {
            i4 = this.f19354t;
        }
        return i4;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzb() {
        int i4;
        b();
        synchronized (this.f19335a) {
            i4 = this.f19349o;
        }
        return i4;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzc() {
        int i4;
        b();
        synchronized (this.f19335a) {
            i4 = this.f19353s;
        }
        return i4;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zzd() {
        long j4;
        b();
        synchronized (this.f19335a) {
            j4 = this.f19351q;
        }
        return j4;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zze() {
        long j4;
        b();
        synchronized (this.f19335a) {
            j4 = this.f19352r;
        }
        return j4;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zzf() {
        long j4;
        b();
        synchronized (this.f19335a) {
            j4 = this.E;
        }
        return j4;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    @Nullable
    public final zzauz zzg() {
        if (!this.f19336b) {
            return null;
        }
        if ((zzM() && zzN()) || !((Boolean) zzbcx.zzb.zze()).booleanValue()) {
            return null;
        }
        synchronized (this.f19335a) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.f19339e == null) {
                this.f19339e = new zzauz();
            }
            this.f19339e.zze();
            zzbzr.zzi("start fetching content...");
            return this.f19339e;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final zzbyu zzh() {
        zzbyu zzbyuVar;
        b();
        synchronized (this.f19335a) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzkc)).booleanValue() && this.f19350p.zzj()) {
                for (Runnable runnable : this.f19337c) {
                    runnable.run();
                }
            }
            zzbyuVar = this.f19350p;
        }
        return zzbyuVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final zzbyu zzi() {
        zzbyu zzbyuVar;
        synchronized (this.f19335a) {
            zzbyuVar = this.f19350p;
        }
        return zzbyuVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    @Nullable
    public final String zzj() {
        String str;
        b();
        synchronized (this.f19335a) {
            str = this.f19343i;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    @Nullable
    public final String zzk() {
        String str;
        b();
        synchronized (this.f19335a) {
            str = this.f19344j;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzl() {
        String str;
        b();
        synchronized (this.f19335a) {
            str = this.B;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzm() {
        String str;
        b();
        synchronized (this.f19335a) {
            str = this.f19359y;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    @Nullable
    public final String zzn(@NonNull String str) {
        char c4;
        b();
        synchronized (this.f19335a) {
            int hashCode = str.hashCode();
            if (hashCode != -2004976699) {
                if (hashCode != 83641339) {
                    if (hashCode == 1218895378 && str.equals("IABTCF_TCString")) {
                        c4 = 1;
                    }
                    c4 = 65535;
                } else {
                    if (str.equals("IABTCF_gdprApplies")) {
                        c4 = 0;
                    }
                    c4 = 65535;
                }
            } else {
                if (str.equals("IABTCF_PurposeConsents")) {
                    c4 = 2;
                }
                c4 = 65535;
            }
            if (c4 != 0) {
                if (c4 != 1) {
                    if (c4 != 2) {
                        return null;
                    }
                    return this.f19348n;
                }
                return this.f19347m;
            }
            return this.f19346l;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzo() {
        String str;
        b();
        synchronized (this.f19335a) {
            str = this.f19360z;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final JSONObject zzp() {
        JSONObject jSONObject;
        b();
        synchronized (this.f19335a) {
            jSONObject = this.f19356v;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzq(Runnable runnable) {
        this.f19337c.add(runnable);
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzr(final Context context) {
        synchronized (this.f19335a) {
            if (this.f19340f != null) {
                return;
            }
            this.f19338d = zzcae.zza.zza(new Runnable(context, "admob") { // from class: com.google.android.gms.ads.internal.util.zzh
                public final /* synthetic */ Context zzb;
                public final /* synthetic */ String zzc = "admob";

                @Override // java.lang.Runnable
                public final void run() {
                    zzj.this.a(this.zzb, this.zzc);
                }
            });
            this.f19336b = true;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzs() {
        b();
        synchronized (this.f19335a) {
            this.f19356v = new JSONObject();
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzt(long j4) {
        b();
        synchronized (this.f19335a) {
            if (this.f19351q == j4) {
                return;
            }
            this.f19351q = j4;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putLong("app_last_background_time_ms", j4);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzu(String str) {
        b();
        synchronized (this.f19335a) {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            if (str != null && !str.equals(this.f19350p.zzc())) {
                this.f19350p = new zzbyu(str, currentTimeMillis);
                SharedPreferences.Editor editor = this.f19341g;
                if (editor != null) {
                    editor.putString("app_settings_json", str);
                    this.f19341g.putLong("app_settings_last_update_ms", currentTimeMillis);
                    this.f19341g.apply();
                }
                c();
                for (Runnable runnable : this.f19337c) {
                    runnable.run();
                }
                return;
            }
            this.f19350p.zzg(currentTimeMillis);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzv(int i4) {
        b();
        synchronized (this.f19335a) {
            if (this.f19354t == i4) {
                return;
            }
            this.f19354t = i4;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putInt("version_code", i4);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzw(@Nullable String str) {
        b();
        synchronized (this.f19335a) {
            if (str.equals(this.f19343i)) {
                return;
            }
            this.f19343i = str;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putString("content_url_hashes", str);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzx(boolean z3) {
        b();
        synchronized (this.f19335a) {
            if (this.f19357w == z3) {
                return;
            }
            this.f19357w = z3;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putBoolean("content_url_opted_out", z3);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzy(@Nullable String str) {
        b();
        synchronized (this.f19335a) {
            if (str.equals(this.f19344j)) {
                return;
            }
            this.f19344j = str;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putString("content_vertical_hashes", str);
                this.f19341g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzz(boolean z3) {
        b();
        synchronized (this.f19335a) {
            if (this.f19358x == z3) {
                return;
            }
            this.f19358x = z3;
            SharedPreferences.Editor editor = this.f19341g;
            if (editor != null) {
                editor.putBoolean("content_vertical_opted_out", z3);
                this.f19341g.apply();
            }
            c();
        }
    }
}
