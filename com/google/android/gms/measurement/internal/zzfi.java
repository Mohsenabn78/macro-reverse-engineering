package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzov;
import org.altbeacon.beacon.service.scanner.CycledLeScanner;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfi extends zzgx {

    /* renamed from: y  reason: collision with root package name */
    static final Pair f21590y = new Pair("", 0L);

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f21591c;

    /* renamed from: d  reason: collision with root package name */
    public zzfg f21592d;

    /* renamed from: e  reason: collision with root package name */
    public final zzfe f21593e;

    /* renamed from: f  reason: collision with root package name */
    public final zzfe f21594f;

    /* renamed from: g  reason: collision with root package name */
    public final zzfh f21595g;

    /* renamed from: h  reason: collision with root package name */
    private String f21596h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21597i;

    /* renamed from: j  reason: collision with root package name */
    private long f21598j;

    /* renamed from: k  reason: collision with root package name */
    public final zzfe f21599k;

    /* renamed from: l  reason: collision with root package name */
    public final zzfc f21600l;

    /* renamed from: m  reason: collision with root package name */
    public final zzfh f21601m;

    /* renamed from: n  reason: collision with root package name */
    public final zzfc f21602n;

    /* renamed from: o  reason: collision with root package name */
    public final zzfe f21603o;

    /* renamed from: p  reason: collision with root package name */
    public final zzfe f21604p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f21605q;

    /* renamed from: r  reason: collision with root package name */
    public final zzfc f21606r;

    /* renamed from: s  reason: collision with root package name */
    public final zzfc f21607s;

    /* renamed from: t  reason: collision with root package name */
    public final zzfe f21608t;

    /* renamed from: u  reason: collision with root package name */
    public final zzfh f21609u;

    /* renamed from: v  reason: collision with root package name */
    public final zzfh f21610v;

    /* renamed from: w  reason: collision with root package name */
    public final zzfe f21611w;

    /* renamed from: x  reason: collision with root package name */
    public final zzfd f21612x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfi(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21599k = new zzfe(this, "session_timeout", CycledLeScanner.ANDROID_N_MAX_SCAN_DURATION_MILLIS);
        this.f21600l = new zzfc(this, "start_new_session", true);
        this.f21603o = new zzfe(this, "last_pause_time", 0L);
        this.f21604p = new zzfe(this, "session_id", 0L);
        this.f21601m = new zzfh(this, "non_personalized_ads", null);
        this.f21602n = new zzfc(this, "allow_remote_dynamite", false);
        this.f21593e = new zzfe(this, "first_open_time", 0L);
        this.f21594f = new zzfe(this, "app_install_time", 0L);
        this.f21595g = new zzfh(this, "app_instance_id", null);
        this.f21606r = new zzfc(this, "app_backgrounded", false);
        this.f21607s = new zzfc(this, "deep_link_retrieval_complete", false);
        this.f21608t = new zzfe(this, "deep_link_retrieval_attempts", 0L);
        this.f21609u = new zzfh(this, "firebase_feature_rollouts", null);
        this.f21610v = new zzfh(this, "deferred_attribution_cache", null);
        this.f21611w = new zzfe(this, "deferred_attribution_cache_timestamp", 0L);
        this.f21612x = new zzfd(this, "default_event_parameters", null);
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    @WorkerThread
    protected final void a() {
        SharedPreferences sharedPreferences = this.f21734a.zzaw().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f21591c = sharedPreferences;
        boolean z3 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f21605q = z3;
        if (!z3) {
            SharedPreferences.Editor edit = this.f21591c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f21734a.zzf();
        this.f21592d = new zzfg(this, "health_monitor", Math.max(0L, ((Long) zzeg.zzc.zza(null)).longValue()), null);
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    protected final boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final SharedPreferences d() {
        zzg();
        c();
        Preconditions.checkNotNull(this.f21591c);
        return this.f21591c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final Pair e(String str) {
        zzg();
        zzov.zzc();
        if (this.f21734a.zzf().zzs(null, zzeg.zzaI) && !f().zzj(zzha.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        long elapsedRealtime = this.f21734a.zzax().elapsedRealtime();
        String str2 = this.f21596h;
        if (str2 != null && elapsedRealtime < this.f21598j) {
            return new Pair(str2, Boolean.valueOf(this.f21597i));
        }
        this.f21598j = elapsedRealtime + this.f21734a.zzf().zzi(str, zzeg.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f21734a.zzaw());
            this.f21596h = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.f21596h = id;
            }
            this.f21597i = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e4) {
            this.f21734a.zzaA().zzc().zzb("Unable to get advertising id", e4);
            this.f21596h = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f21596h, Boolean.valueOf(this.f21597i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final zzhb f() {
        zzg();
        return zzhb.zzc(d().getString("consent_settings", "G1"), d().getInt("consent_source", 100));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean g() {
        zzg();
        if (d().contains("measurement_enabled")) {
            return Boolean.valueOf(d().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void h(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = d().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void i(boolean z3) {
        zzg();
        this.f21734a.zzaA().zzj().zzb("App measurement setting deferred collection", Boolean.valueOf(z3));
        SharedPreferences.Editor edit = d().edit();
        edit.putBoolean("deferred_analytics_collection", z3);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean j() {
        SharedPreferences sharedPreferences = this.f21591c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k(long j4) {
        if (j4 - this.f21599k.zza() > this.f21603o.zza()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean l(int i4) {
        return zzhb.zzk(i4, d().getInt("consent_source", 100));
    }
}
