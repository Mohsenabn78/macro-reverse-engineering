package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzgd implements zzgy {
    private static volatile zzgd H;
    private volatile Boolean A;
    @VisibleForTesting
    protected Boolean B;
    @VisibleForTesting
    protected Boolean C;
    private volatile boolean D;
    private int E;
    @VisibleForTesting
    final long G;

    /* renamed from: a  reason: collision with root package name */
    private final Context f21657a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21658b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21659c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21660d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f21661e;

    /* renamed from: f  reason: collision with root package name */
    private final zzab f21662f;

    /* renamed from: g  reason: collision with root package name */
    private final zzag f21663g;

    /* renamed from: h  reason: collision with root package name */
    private final zzfi f21664h;

    /* renamed from: i  reason: collision with root package name */
    private final zzet f21665i;

    /* renamed from: j  reason: collision with root package name */
    private final zzga f21666j;

    /* renamed from: k  reason: collision with root package name */
    private final zzkp f21667k;

    /* renamed from: l  reason: collision with root package name */
    private final zzlp f21668l;

    /* renamed from: m  reason: collision with root package name */
    private final zzeo f21669m;

    /* renamed from: n  reason: collision with root package name */
    private final Clock f21670n;

    /* renamed from: o  reason: collision with root package name */
    private final zziz f21671o;

    /* renamed from: p  reason: collision with root package name */
    private final zzik f21672p;

    /* renamed from: q  reason: collision with root package name */
    private final zzd f21673q;

    /* renamed from: r  reason: collision with root package name */
    private final zzio f21674r;

    /* renamed from: s  reason: collision with root package name */
    private final String f21675s;

    /* renamed from: t  reason: collision with root package name */
    private zzem f21676t;

    /* renamed from: u  reason: collision with root package name */
    private zzjz f21677u;

    /* renamed from: v  reason: collision with root package name */
    private zzao f21678v;

    /* renamed from: w  reason: collision with root package name */
    private zzek f21679w;

    /* renamed from: y  reason: collision with root package name */
    private Boolean f21681y;

    /* renamed from: z  reason: collision with root package name */
    private long f21682z;

    /* renamed from: x  reason: collision with root package name */
    private boolean f21680x = false;
    private final AtomicInteger F = new AtomicInteger(0);

    zzgd(zzhi zzhiVar) {
        long currentTimeMillis;
        Bundle bundle;
        boolean z3 = false;
        Preconditions.checkNotNull(zzhiVar);
        Context context = zzhiVar.f21766a;
        zzab zzabVar = new zzab(context);
        this.f21662f = zzabVar;
        zzed.f21493a = zzabVar;
        this.f21657a = context;
        this.f21658b = zzhiVar.f21767b;
        this.f21659c = zzhiVar.f21768c;
        this.f21660d = zzhiVar.f21769d;
        this.f21661e = zzhiVar.f21773h;
        this.A = zzhiVar.f21770e;
        this.f21675s = zzhiVar.f21775j;
        this.D = true;
        com.google.android.gms.internal.measurement.zzcl zzclVar = zzhiVar.f21772g;
        if (zzclVar != null && (bundle = zzclVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = zzclVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzib.zzd(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.f21670n = defaultClock;
        Long l4 = zzhiVar.f21774i;
        if (l4 != null) {
            currentTimeMillis = l4.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.G = currentTimeMillis;
        this.f21663g = new zzag(this);
        zzfi zzfiVar = new zzfi(this);
        zzfiVar.zzw();
        this.f21664h = zzfiVar;
        zzet zzetVar = new zzet(this);
        zzetVar.zzw();
        this.f21665i = zzetVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzw();
        this.f21668l = zzlpVar;
        this.f21669m = new zzeo(new zzhh(zzhiVar, this));
        this.f21673q = new zzd(this);
        zziz zzizVar = new zziz(this);
        zzizVar.zzb();
        this.f21671o = zzizVar;
        zzik zzikVar = new zzik(this);
        zzikVar.zzb();
        this.f21672p = zzikVar;
        zzkp zzkpVar = new zzkp(this);
        zzkpVar.zzb();
        this.f21667k = zzkpVar;
        zzio zzioVar = new zzio(this);
        zzioVar.zzw();
        this.f21674r = zzioVar;
        zzga zzgaVar = new zzga(this);
        zzgaVar.zzw();
        this.f21666j = zzgaVar;
        com.google.android.gms.internal.measurement.zzcl zzclVar2 = zzhiVar.f21772g;
        z3 = (zzclVar2 == null || zzclVar2.zzb == 0) ? true : true;
        if (context.getApplicationContext() instanceof Application) {
            zzik zzq = zzq();
            if (zzq.f21734a.f21657a.getApplicationContext() instanceof Application) {
                Application application = (Application) zzq.f21734a.f21657a.getApplicationContext();
                if (zzq.f21847c == null) {
                    zzq.f21847c = new zzij(zzq);
                }
                if (z3) {
                    application.unregisterActivityLifecycleCallbacks(zzq.f21847c);
                    application.registerActivityLifecycleCallbacks(zzq.f21847c);
                    zzq.f21734a.zzaA().zzj().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzaA().zzk().zza("Application context is not an Application");
        }
        zzgaVar.zzp(new zzgc(this, zzhiVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void a(zzgd zzgdVar, zzhi zzhiVar) {
        zzgdVar.zzaB().zzg();
        zzgdVar.f21663g.e();
        zzao zzaoVar = new zzao(zzgdVar);
        zzaoVar.zzw();
        zzgdVar.f21678v = zzaoVar;
        zzek zzekVar = new zzek(zzgdVar, zzhiVar.f21771f);
        zzekVar.zzb();
        zzgdVar.f21679w = zzekVar;
        zzem zzemVar = new zzem(zzgdVar);
        zzemVar.zzb();
        zzgdVar.f21676t = zzemVar;
        zzjz zzjzVar = new zzjz(zzgdVar);
        zzjzVar.zzb();
        zzgdVar.f21677u = zzjzVar;
        zzgdVar.f21668l.zzx();
        zzgdVar.f21664h.zzx();
        zzgdVar.f21679w.zzc();
        zzer zzi = zzgdVar.zzaA().zzi();
        zzgdVar.f21663g.zzh();
        zzi.zzb("App measurement initialized, version", 79000L);
        zzgdVar.zzaA().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzl = zzekVar.zzl();
        if (TextUtils.isEmpty(zzgdVar.f21658b)) {
            if (zzgdVar.zzv().y(zzl)) {
                zzgdVar.zzaA().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzgdVar.zzaA().zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzl)));
            }
        }
        zzgdVar.zzaA().zzc().zza("Debug-level message logging enabled");
        if (zzgdVar.E != zzgdVar.F.get()) {
            zzgdVar.zzaA().zzd().zzc("Not all components initialized", Integer.valueOf(zzgdVar.E), Integer.valueOf(zzgdVar.F.get()));
        }
        zzgdVar.f21680x = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void h() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void i(zzgw zzgwVar) {
        if (zzgwVar != null) {
            return;
        }
        throw new IllegalStateException("Component not created");
    }

    private static final void j(zzf zzfVar) {
        if (zzfVar != null) {
            if (zzfVar.b()) {
                return;
            }
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzfVar.getClass())));
        }
        throw new IllegalStateException("Component not created");
    }

    private static final void k(zzgx zzgxVar) {
        if (zzgxVar != null) {
            if (zzgxVar.zzy()) {
                return;
            }
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzgxVar.getClass())));
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzgd zzp(Context context, com.google.android.gms.internal.measurement.zzcl zzclVar, Long l4) {
        Bundle bundle;
        if (zzclVar != null && (zzclVar.zze == null || zzclVar.zzf == null)) {
            zzclVar = new com.google.android.gms.internal.measurement.zzcl(zzclVar.zza, zzclVar.zzb, zzclVar.zzc, zzclVar.zzd, null, null, zzclVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (H == null) {
            synchronized (zzgd.class) {
                if (H == null) {
                    H = new zzgd(new zzhi(context, zzclVar, l4));
                }
            }
        } else if (zzclVar != null && (bundle = zzclVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(H);
            H.A = Boolean.valueOf(zzclVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(H);
        return H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.F.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(String str, int i4, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        if (i4 != 200 && i4 != 204) {
            if (i4 == 304) {
                i4 = 304;
            }
            zzaA().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i4), th);
        }
        if (th == null) {
            zzm().f21607s.zza(true);
            if (bArr != null && bArr.length != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String optString = jSONObject.optString("deeplink", "");
                    String optString2 = jSONObject.optString("gclid", "");
                    double optDouble = jSONObject.optDouble("timestamp", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    if (TextUtils.isEmpty(optString)) {
                        zzaA().zzc().zza("Deferred Deep Link is empty.");
                        return;
                    }
                    zzlp zzv = zzv();
                    zzgd zzgdVar = zzv.f21734a;
                    if (!TextUtils.isEmpty(optString) && (queryIntentActivities = zzv.f21734a.f21657a.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.f21672p.e(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        zzlp zzv2 = zzv();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = zzv2.f21734a.f21657a.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString("deeplink", optString);
                                edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    zzv2.f21734a.f21657a.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (RuntimeException e4) {
                                zzv2.f21734a.zzaA().zzd().zzb("Failed to persist Deferred Deep Link. exception", e4);
                                return;
                            }
                        }
                        return;
                    }
                    zzaA().zzk().zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                    return;
                } catch (JSONException e5) {
                    zzaA().zzd().zzb("Failed to parse the Deferred Deep Link response. exception", e5);
                    return;
                }
            }
            zzaA().zzc().zza("Deferred Deep Link response empty.");
            return;
        }
        zzaA().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i4), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        this.E++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void e(boolean z3) {
        this.A = Boolean.valueOf(z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0095, code lost:
        if (r8.zzl() == false) goto L15;
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(com.google.android.gms.internal.measurement.zzcl r8) {
        /*
            Method dump skipped, instructions count: 821
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgd.f(com.google.android.gms.internal.measurement.zzcl):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final boolean g() {
        boolean z3;
        if (this.f21680x) {
            zzaB().zzg();
            Boolean bool = this.f21681y;
            if (bool == null || this.f21682z == 0 || (!bool.booleanValue() && Math.abs(this.f21670n.elapsedRealtime() - this.f21682z) > 1000)) {
                this.f21682z = this.f21670n.elapsedRealtime();
                boolean z4 = true;
                if (zzv().x("android.permission.INTERNET") && zzv().x("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.f21657a).isCallerInstantApp() || this.f21663g.h() || (zzlp.D(this.f21657a) && zzlp.E(this.f21657a, false)))) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Boolean valueOf = Boolean.valueOf(z3);
                this.f21681y = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzv().q(zzh().zzm(), zzh().g()) && TextUtils.isEmpty(zzh().g())) {
                        z4 = false;
                    }
                    this.f21681y = Boolean.valueOf(z4);
                }
            }
            return this.f21681y.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SideEffectFree
    public final zzga l() {
        return this.f21666j;
    }

    @WorkerThread
    public final void zzE() {
        zzaB().zzg();
        k(zzr());
        String zzl = zzh().zzl();
        Pair e4 = zzm().e(zzl);
        if (this.f21663g.zzr() && !((Boolean) e4.second).booleanValue() && !TextUtils.isEmpty((CharSequence) e4.first)) {
            zzio zzr = zzr();
            zzr.c();
            ConnectivityManager connectivityManager = (ConnectivityManager) zzr.f21734a.f21657a.getSystemService("connectivity");
            NetworkInfo networkInfo = null;
            if (connectivityManager != null) {
                try {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                } catch (SecurityException unused) {
                }
            }
            if (networkInfo != null && networkInfo.isConnected()) {
                zzlp zzv = zzv();
                zzh().f21734a.f21663g.zzh();
                URL zzE = zzv.zzE(79000L, zzl, (String) e4.first, zzm().f21608t.zza() - 1);
                if (zzE != null) {
                    zzio zzr2 = zzr();
                    zzgb zzgbVar = new zzgb(this);
                    zzr2.zzg();
                    zzr2.c();
                    Preconditions.checkNotNull(zzE);
                    Preconditions.checkNotNull(zzgbVar);
                    zzr2.f21734a.zzaB().zzo(new zzin(zzr2, zzl, zzE, null, null, zzgbVar));
                    return;
                }
                return;
            }
            zzaA().zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzaA().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
    }

    @WorkerThread
    public final void zzG(boolean z3) {
        zzaB().zzg();
        this.D = z3;
    }

    @WorkerThread
    public final boolean zzI() {
        if (this.A != null && this.A.booleanValue()) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean zzJ() {
        if (zza() == 0) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean zzK() {
        zzaB().zzg();
        return this.D;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.f21658b);
    }

    @Pure
    public final boolean zzN() {
        return this.f21661e;
    }

    @WorkerThread
    public final int zza() {
        zzaB().zzg();
        if (this.f21663g.zzv()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzaB().zzg();
        if (!this.D) {
            return 8;
        }
        Boolean g4 = zzm().g();
        if (g4 != null) {
            if (g4.booleanValue()) {
                return 0;
            }
            return 3;
        }
        zzag zzagVar = this.f21663g;
        zzab zzabVar = zzagVar.f21734a.f21662f;
        Boolean d4 = zzagVar.d("firebase_analytics_collection_enabled");
        if (d4 != null) {
            if (d4.booleanValue()) {
                return 0;
            }
            return 4;
        }
        Boolean bool2 = this.B;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                return 0;
            }
            return 5;
        } else if (this.A == null || this.A.booleanValue()) {
            return 0;
        } else {
            return 7;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    @Pure
    public final zzet zzaA() {
        k(this.f21665i);
        return this.f21665i;
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    @Pure
    public final zzga zzaB() {
        k(this.f21666j);
        return this.f21666j;
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    @Pure
    public final Context zzaw() {
        return this.f21657a;
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    @Pure
    public final Clock zzax() {
        return this.f21670n;
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    @Pure
    public final zzab zzay() {
        return this.f21662f;
    }

    @Pure
    public final zzd zzd() {
        zzd zzdVar = this.f21673q;
        if (zzdVar != null) {
            return zzdVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzag zzf() {
        return this.f21663g;
    }

    @Pure
    public final zzao zzg() {
        k(this.f21678v);
        return this.f21678v;
    }

    @Pure
    public final zzek zzh() {
        j(this.f21679w);
        return this.f21679w;
    }

    @Pure
    public final zzem zzi() {
        j(this.f21676t);
        return this.f21676t;
    }

    @Pure
    public final zzeo zzj() {
        return this.f21669m;
    }

    public final zzet zzl() {
        zzet zzetVar = this.f21665i;
        if (zzetVar != null && zzetVar.zzy()) {
            return zzetVar;
        }
        return null;
    }

    @Pure
    public final zzfi zzm() {
        i(this.f21664h);
        return this.f21664h;
    }

    @Pure
    public final zzik zzq() {
        j(this.f21672p);
        return this.f21672p;
    }

    @Pure
    public final zzio zzr() {
        k(this.f21674r);
        return this.f21674r;
    }

    @Pure
    public final zziz zzs() {
        j(this.f21671o);
        return this.f21671o;
    }

    @Pure
    public final zzjz zzt() {
        j(this.f21677u);
        return this.f21677u;
    }

    @Pure
    public final zzkp zzu() {
        j(this.f21667k);
        return this.f21667k;
    }

    @Pure
    public final zzlp zzv() {
        i(this.f21668l);
        return this.f21668l;
    }

    @Pure
    public final String zzw() {
        return this.f21658b;
    }

    @Pure
    public final String zzx() {
        return this.f21659c;
    }

    @Pure
    public final String zzy() {
        return this.f21660d;
    }

    @Pure
    public final String zzz() {
        return this.f21675s;
    }
}
