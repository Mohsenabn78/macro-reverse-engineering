package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzos;
import com.google.android.gms.internal.measurement.zzph;
import com.google.android.gms.internal.measurement.zzqu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzik extends zzf {
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    protected zzij f21847c;

    /* renamed from: d  reason: collision with root package name */
    private zzhf f21848d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f21849e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21850f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference f21851g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f21852h;
    @GuardedBy("consentLock")

    /* renamed from: i  reason: collision with root package name */
    private zzhb f21853i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicLong f21854j;

    /* renamed from: k  reason: collision with root package name */
    private long f21855k;

    /* renamed from: l  reason: collision with root package name */
    final zzs f21856l;
    @VisibleForTesting

    /* renamed from: m  reason: collision with root package name */
    protected boolean f21857m;

    /* renamed from: n  reason: collision with root package name */
    private final zzlo f21858n;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzik(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21849e = new CopyOnWriteArraySet();
        this.f21852h = new Object();
        this.f21857m = true;
        this.f21858n = new zzhz(this);
        this.f21851g = new AtomicReference();
        this.f21853i = zzhb.zza;
        this.f21855k = -1L;
        this.f21854j = new AtomicLong(0L);
        this.f21856l = new zzs(zzgdVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void n(Boolean bool, boolean z3) {
        zzg();
        zza();
        this.f21734a.zzaA().zzc().zzb("Setting app measurement enabled (FE)", bool);
        this.f21734a.zzm().h(bool);
        if (z3) {
            zzfi zzm = this.f21734a.zzm();
            zzgd zzgdVar = zzm.f21734a;
            zzm.zzg();
            SharedPreferences.Editor edit = zzm.d().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (!this.f21734a.zzK() && (bool == null || bool.booleanValue())) {
            return;
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void o() {
        long j4;
        zzg();
        String zza = this.f21734a.zzm().f21601m.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                m("app", "_npa", null, this.f21734a.zzax().currentTimeMillis());
            } else {
                if (true != "true".equals(zza)) {
                    j4 = 0;
                } else {
                    j4 = 1;
                }
                m("app", "_npa", Long.valueOf(j4), this.f21734a.zzax().currentTimeMillis());
            }
        }
        if (this.f21734a.zzJ() && this.f21857m) {
            this.f21734a.zzaA().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzz();
            zzph.zzc();
            if (this.f21734a.zzf().zzs(null, zzeg.zzaf)) {
                this.f21734a.zzu().f22007e.a();
            }
            this.f21734a.zzaB().zzp(new zzhn(this));
            return;
        }
        this.f21734a.zzaA().zzc().zza("Updating Scion state (FE)");
        this.f21734a.zzt().j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void p(zzik zzikVar, zzhb zzhbVar, zzhb zzhbVar2) {
        boolean z3;
        zzha[] zzhaVarArr = {zzha.ANALYTICS_STORAGE, zzha.AD_STORAGE};
        int i4 = 0;
        while (true) {
            if (i4 < 2) {
                zzha zzhaVar = zzhaVarArr[i4];
                if (!zzhbVar2.zzj(zzhaVar) && zzhbVar.zzj(zzhaVar)) {
                    z3 = true;
                    break;
                }
                i4++;
            } else {
                z3 = false;
                break;
            }
        }
        boolean zzn = zzhbVar.zzn(zzhbVar2, zzha.ANALYTICS_STORAGE, zzha.AD_STORAGE);
        if (!z3 && !zzn) {
            return;
        }
        zzikVar.f21734a.zzh().i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q(zzik zzikVar, zzhb zzhbVar, long j4, boolean z3, boolean z4) {
        zzikVar.zzg();
        zzikVar.zza();
        zzhb f4 = zzikVar.f21734a.zzm().f();
        if (j4 <= zzikVar.f21855k && zzhb.zzk(f4.zza(), zzhbVar.zza())) {
            zzikVar.f21734a.zzaA().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzhbVar);
            return;
        }
        zzfi zzm = zzikVar.f21734a.zzm();
        zzgd zzgdVar = zzm.f21734a;
        zzm.zzg();
        int zza = zzhbVar.zza();
        if (zzm.l(zza)) {
            SharedPreferences.Editor edit = zzm.d().edit();
            edit.putString("consent_settings", zzhbVar.zzi());
            edit.putInt("consent_source", zza);
            edit.apply();
            zzikVar.f21855k = j4;
            zzikVar.f21734a.zzt().h(z3);
            if (z4) {
                zzikVar.f21734a.zzt().zzu(new AtomicReference());
                return;
            }
            return;
        }
        zzikVar.f21734a.zzaA().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzhbVar.zza()));
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(Bundle bundle) {
        if (bundle == null) {
            this.f21734a.zzm().f21612x.zzb(new Bundle());
            return;
        }
        Bundle zza = this.f21734a.zzm().f21612x.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.f21734a.zzv().z(obj)) {
                    this.f21734a.zzv().n(this.f21858n, null, 27, null, null, 0);
                }
                this.f21734a.zzaA().zzl().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzlp.B(str)) {
                this.f21734a.zzaA().zzl().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza.remove(str);
            } else {
                zzlp zzv = this.f21734a.zzv();
                this.f21734a.zzf();
                if (zzv.u("param", str, 100, obj)) {
                    this.f21734a.zzv().o(zza, str, obj);
                }
            }
        }
        this.f21734a.zzv();
        int zzc = this.f21734a.zzf().zzc();
        if (zza.size() > zzc) {
            int i4 = 0;
            for (String str2 : new TreeSet(zza.keySet())) {
                i4++;
                if (i4 > zzc) {
                    zza.remove(str2);
                }
            }
            this.f21734a.zzv().n(this.f21858n, null, 26, null, null, 0);
            this.f21734a.zzaA().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.f21734a.zzm().f21612x.zzb(zza);
        this.f21734a.zzt().zzH(zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void e(String str, String str2, Bundle bundle) {
        zzg();
        f(str, str2, this.f21734a.zzax().currentTimeMillis(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void f(String str, String str2, long j4, Bundle bundle) {
        boolean z3;
        zzg();
        if (this.f21848d != null && !zzlp.B(str2)) {
            z3 = false;
        } else {
            z3 = true;
        }
        g(str, str2, j4, bundle, true, z3, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void g(String str, String str2, long j4, Bundle bundle, boolean z3, boolean z4, boolean z5, String str3) {
        boolean z6;
        boolean z7;
        boolean zzb;
        String str4;
        ArrayList arrayList;
        long j5;
        String str5;
        Bundle[] bundleArr;
        Class<?> cls;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzg();
        zza();
        if (this.f21734a.zzJ()) {
            List h4 = this.f21734a.zzh().h();
            if (h4 != null && !h4.contains(str2)) {
                this.f21734a.zzaA().zzc().zzc("Dropping non-safelisted event. event name, origin", str2, str);
                return;
            }
            int i4 = 0;
            if (!this.f21850f) {
                this.f21850f = true;
                try {
                    if (!this.f21734a.zzN()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.f21734a.zzaw().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", Context.class).invoke(null, this.f21734a.zzaw());
                    } catch (Exception e4) {
                        this.f21734a.zzaA().zzk().zzb("Failed to invoke Tag Manager's initialize() method", e4);
                    }
                } catch (ClassNotFoundException unused) {
                    this.f21734a.zzaA().zzi().zza("Tag Manager is not found and thus will not be used");
                }
            }
            if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
                this.f21734a.zzay();
                m(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", bundle.getString("gclid"), this.f21734a.zzax().currentTimeMillis());
            }
            this.f21734a.zzay();
            if (z3 && zzlp.zzan(str2)) {
                this.f21734a.zzv().k(bundle, this.f21734a.zzm().f21612x.zza());
            }
            if (!z5) {
                this.f21734a.zzay();
                if (!"_iap".equals(str2)) {
                    zzlp zzv = this.f21734a.zzv();
                    int i5 = 2;
                    if (zzv.w(NotificationCompat.CATEGORY_EVENT, str2)) {
                        if (!zzv.t(NotificationCompat.CATEGORY_EVENT, zzhc.zza, zzhc.zzb, str2)) {
                            i5 = 13;
                        } else {
                            zzv.f21734a.zzf();
                            if (zzv.r(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                                i5 = 0;
                            }
                        }
                    }
                    if (i5 != 0) {
                        this.f21734a.zzaA().zze().zzb("Invalid public event name. Event will not be logged (FE)", this.f21734a.zzj().d(str2));
                        zzlp zzv2 = this.f21734a.zzv();
                        this.f21734a.zzf();
                        String zzD = zzv2.zzD(str2, 40, true);
                        if (str2 != null) {
                            i4 = str2.length();
                        }
                        this.f21734a.zzv().n(this.f21858n, null, i5, "_ev", zzD, i4);
                        return;
                    }
                }
            }
            this.f21734a.zzay();
            zzir zzj = this.f21734a.zzs().zzj(false);
            if (zzj != null && !bundle.containsKey("_sc")) {
                zzj.f21863a = true;
            }
            if (z3 && !z5) {
                z6 = true;
            } else {
                z6 = false;
            }
            zzlp.zzK(zzj, bundle, z6);
            boolean equals = "am".equals(str);
            boolean B = zzlp.B(str2);
            if (z3 && this.f21848d != null && !B) {
                if (equals) {
                    z7 = true;
                } else {
                    this.f21734a.zzaA().zzc().zzc("Passing event to registered event handler (FE)", this.f21734a.zzj().d(str2), this.f21734a.zzj().b(bundle));
                    Preconditions.checkNotNull(this.f21848d);
                    this.f21848d.interceptEvent(str, str2, bundle, j4);
                    return;
                }
            } else {
                z7 = equals;
            }
            if (this.f21734a.g()) {
                int zzh = this.f21734a.zzv().zzh(str2);
                if (zzh != 0) {
                    this.f21734a.zzaA().zze().zzb("Invalid event name. Event will not be logged (FE)", this.f21734a.zzj().d(str2));
                    zzlp zzv3 = this.f21734a.zzv();
                    this.f21734a.zzf();
                    String zzD2 = zzv3.zzD(str2, 40, true);
                    if (str2 != null) {
                        i4 = str2.length();
                    }
                    this.f21734a.zzv().n(this.f21858n, str3, zzh, "_ev", zzD2, i4);
                    return;
                }
                String str6 = "_o";
                Bundle U = this.f21734a.zzv().U(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z5);
                Preconditions.checkNotNull(U);
                this.f21734a.zzay();
                if (this.f21734a.zzs().zzj(false) != null && "_ae".equals(str2)) {
                    zzkn zzknVar = this.f21734a.zzu().f22008f;
                    long elapsedRealtime = zzknVar.f22003d.f21734a.zzax().elapsedRealtime();
                    long j6 = elapsedRealtime - zzknVar.f22001b;
                    zzknVar.f22001b = elapsedRealtime;
                    if (j6 > 0) {
                        this.f21734a.zzv().i(U, j6);
                    }
                }
                zzos.zzc();
                if (this.f21734a.zzf().zzs(null, zzeg.zzae)) {
                    if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str) && "_ssr".equals(str2)) {
                        zzlp zzv4 = this.f21734a.zzv();
                        String string = U.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            string = null;
                        } else if (string != null) {
                            string = string.trim();
                        }
                        if (!zzln.zza(string, zzv4.f21734a.zzm().f21609u.zza())) {
                            zzv4.f21734a.zzm().f21609u.zzb(string);
                        } else {
                            zzv4.f21734a.zzaA().zzc().zza("Not logging duplicate session_start_with_rollout event");
                            return;
                        }
                    } else if ("_ae".equals(str2)) {
                        String zza = this.f21734a.zzv().f21734a.zzm().f21609u.zza();
                        if (!TextUtils.isEmpty(zza)) {
                            U.putString("_ffr", zza);
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(U);
                if (this.f21734a.zzf().zzs(null, zzeg.zzaG)) {
                    zzb = this.f21734a.zzu().i();
                } else {
                    zzb = this.f21734a.zzm().f21606r.zzb();
                }
                if (this.f21734a.zzm().f21603o.zza() <= 0 || !this.f21734a.zzm().k(j4) || !zzb) {
                    str4 = "_ae";
                    arrayList = arrayList2;
                    j5 = 0;
                } else {
                    this.f21734a.zzaA().zzj().zza("Current session is expired, remove the session number, ID, and engagement time");
                    arrayList = arrayList2;
                    j5 = 0;
                    str4 = "_ae";
                    m(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", null, this.f21734a.zzax().currentTimeMillis());
                    m(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno", null, this.f21734a.zzax().currentTimeMillis());
                    m(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_se", null, this.f21734a.zzax().currentTimeMillis());
                    this.f21734a.zzm().f21604p.zzb(0L);
                }
                if (U.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j5) == 1) {
                    this.f21734a.zzaA().zzj().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    this.f21734a.zzu().f22007e.b(j4, true);
                }
                ArrayList arrayList3 = new ArrayList(U.keySet());
                Collections.sort(arrayList3);
                int size = arrayList3.size();
                for (int i6 = 0; i6 < size; i6++) {
                    String str7 = (String) arrayList3.get(i6);
                    if (str7 != null) {
                        this.f21734a.zzv();
                        Object obj = U.get(str7);
                        if (obj instanceof Bundle) {
                            bundleArr = new Bundle[]{(Bundle) obj};
                        } else if (obj instanceof Parcelable[]) {
                            Parcelable[] parcelableArr = (Parcelable[]) obj;
                            bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                        } else if (obj instanceof ArrayList) {
                            ArrayList arrayList4 = (ArrayList) obj;
                            bundleArr = (Bundle[]) arrayList4.toArray(new Bundle[arrayList4.size()]);
                        } else {
                            bundleArr = null;
                        }
                        if (bundleArr != null) {
                            U.putParcelableArray(str7, bundleArr);
                        }
                    }
                }
                int i7 = 0;
                while (i7 < arrayList.size()) {
                    ArrayList arrayList5 = arrayList;
                    Bundle bundle2 = (Bundle) arrayList5.get(i7);
                    if (i7 != 0) {
                        str5 = "_ep";
                    } else {
                        str5 = str2;
                    }
                    bundle2.putString(str6, str);
                    if (z4) {
                        bundle2 = this.f21734a.zzv().T(bundle2);
                    }
                    Bundle bundle3 = bundle2;
                    String str8 = str6;
                    this.f21734a.zzt().d(new zzau(str5, new zzas(bundle3), str, j4), str3);
                    if (!z7) {
                        for (zzhg zzhgVar : this.f21849e) {
                            zzhgVar.onEvent(str, str2, new Bundle(bundle3), j4);
                        }
                    }
                    i7++;
                    arrayList = arrayList5;
                    str6 = str8;
                }
                this.f21734a.zzay();
                if (this.f21734a.zzs().zzj(false) != null && str4.equals(str2)) {
                    this.f21734a.zzu().f22008f.d(true, true, this.f21734a.zzax().elapsedRealtime());
                    return;
                }
                return;
            }
            return;
        }
        this.f21734a.zzaA().zzc().zza("Event not sent since app measurement is disabled");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(long j4, boolean z3) {
        zzg();
        zza();
        this.f21734a.zzaA().zzc().zza("Resetting analytics data (FE)");
        zzkp zzu = this.f21734a.zzu();
        zzu.zzg();
        zzu.f22008f.a();
        zzqu.zzc();
        if (this.f21734a.zzf().zzs(null, zzeg.zzan)) {
            this.f21734a.zzh().i();
        }
        boolean zzJ = this.f21734a.zzJ();
        zzfi zzm = this.f21734a.zzm();
        zzm.f21593e.zzb(j4);
        if (!TextUtils.isEmpty(zzm.f21734a.zzm().f21609u.zza())) {
            zzm.f21609u.zzb(null);
        }
        zzph.zzc();
        zzag zzf = zzm.f21734a.zzf();
        zzef zzefVar = zzeg.zzaf;
        if (zzf.zzs(null, zzefVar)) {
            zzm.f21603o.zzb(0L);
        }
        zzm.f21604p.zzb(0L);
        if (!zzm.f21734a.zzf().zzv()) {
            zzm.i(!zzJ);
        }
        zzm.f21610v.zzb(null);
        zzm.f21611w.zzb(0L);
        zzm.f21612x.zzb(null);
        if (z3) {
            this.f21734a.zzt().e();
        }
        zzph.zzc();
        if (this.f21734a.zzf().zzs(null, zzefVar)) {
            this.f21734a.zzu().f22007e.a();
        }
        this.f21857m = !zzJ;
    }

    protected final void i(String str, String str2, long j4, Bundle bundle, boolean z3, boolean z4, boolean z5, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i4 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i4 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i4];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i4] = new Bundle((Bundle) parcelable);
                        }
                        i4++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i4 < list.size()) {
                        Object obj2 = list.get(i4);
                        if (obj2 instanceof Bundle) {
                            list.set(i4, new Bundle((Bundle) obj2));
                        }
                        i4++;
                    }
                }
            }
        }
        this.f21734a.zzaB().zzp(new zzhp(this, str, str2, j4, bundle2, z3, z4, z5, str3));
    }

    final void j(String str, String str2, long j4, Object obj) {
        this.f21734a.zzaB().zzp(new zzhq(this, str, str2, obj, j4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k(String str) {
        this.f21851g.set(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void l(zzhb zzhbVar) {
        boolean z3;
        Boolean bool;
        zzg();
        if ((zzhbVar.zzj(zzha.ANALYTICS_STORAGE) && zzhbVar.zzj(zzha.AD_STORAGE)) || this.f21734a.zzt().m()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 != this.f21734a.zzK()) {
            this.f21734a.zzG(z3);
            zzfi zzm = this.f21734a.zzm();
            zzgd zzgdVar = zzm.f21734a;
            zzm.zzg();
            if (zzm.d().contains("measurement_enabled_from_api")) {
                bool = Boolean.valueOf(zzm.d().getBoolean("measurement_enabled_from_api", true));
            } else {
                bool = null;
            }
            if (!z3 || bool == null || bool.booleanValue()) {
                n(Boolean.valueOf(z3), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzg()
            r8.zza()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L64
            boolean r0 = r11 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L52
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L52
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            r11 = 1
            java.lang.String r0 = "false"
            boolean r10 = r0.equals(r10)
            r2 = 1
            if (r11 == r10) goto L37
            r10 = 0
            goto L38
        L37:
            r10 = r2
        L38:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.zzgd r10 = r8.f21734a
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzfh r10 = r10.f21601m
            long r4 = r11.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L4e
            java.lang.String r0 = "true"
        L4e:
            r10.zzb(r0)
            goto L61
        L52:
            if (r11 != 0) goto L64
            com.google.android.gms.measurement.internal.zzgd r10 = r8.f21734a
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzfh r10 = r10.f21601m
            java.lang.String r0 = "unset"
            r10.zzb(r0)
        L61:
            r6 = r11
            r3 = r1
            goto L66
        L64:
            r3 = r10
            r6 = r11
        L66:
            com.google.android.gms.measurement.internal.zzgd r10 = r8.f21734a
            boolean r10 = r10.zzJ()
            if (r10 != 0) goto L7e
            com.google.android.gms.measurement.internal.zzgd r9 = r8.f21734a
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzaA()
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzj()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L7e:
            com.google.android.gms.measurement.internal.zzgd r10 = r8.f21734a
            boolean r10 = r10.g()
            if (r10 != 0) goto L87
            return
        L87:
            com.google.android.gms.measurement.internal.zzlk r10 = new com.google.android.gms.measurement.internal.zzlk
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzgd r9 = r8.f21734a
            com.google.android.gms.measurement.internal.zzjz r9 = r9.zzt()
            r9.l(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzik.m(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.f21734a.zzax().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.f21734a.zzaB().zzp(new zzhu(this, bundle2));
    }

    public final void zzB() {
        if ((this.f21734a.zzaw().getApplicationContext() instanceof Application) && this.f21847c != null) {
            ((Application) this.f21734a.zzaw().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f21847c);
        }
    }

    public final void zzD(String str, String str2, Bundle bundle) {
        zzE(str, str2, bundle, true, true, this.f21734a.zzax().currentTimeMillis());
    }

    public final void zzE(String str, String str2, Bundle bundle, boolean z3, boolean z4, long j4) {
        Bundle bundle2;
        boolean z5;
        String str3;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (str2 != FirebaseAnalytics.Event.SCREEN_VIEW && (str2 == null || !str2.equals(FirebaseAnalytics.Event.SCREEN_VIEW))) {
            if (z4 && this.f21848d != null && !zzlp.B(str2)) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (str == null) {
                str3 = "app";
            } else {
                str3 = str;
            }
            i(str3, str2, j4, bundle2, z4, z5, z3, null);
            return;
        }
        this.f21734a.zzs().zzx(bundle2, j4);
    }

    public final void zzF(String str, String str2, Bundle bundle, String str3) {
        zzgd.h();
        i(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, this.f21734a.zzax().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void zzJ(zzhg zzhgVar) {
        zza();
        Preconditions.checkNotNull(zzhgVar);
        if (!this.f21849e.add(zzhgVar)) {
            this.f21734a.zzaA().zzk().zza("OnEventListener already registered");
        }
    }

    public final void zzK(long j4) {
        this.f21851g.set(null);
        this.f21734a.zzaB().zzp(new zzhs(this, j4));
    }

    public final void zzP(Bundle bundle) {
        zzQ(bundle, this.f21734a.zzax().currentTimeMillis());
    }

    public final void zzQ(Bundle bundle, long j4) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.f21734a.zzaA().zzk().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgz.zza(bundle2, "app_id", String.class, null);
        zzgz.zza(bundle2, "origin", String.class, null);
        zzgz.zza(bundle2, "name", String.class, null);
        zzgz.zza(bundle2, "value", Object.class, null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j4);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.f21734a.zzv().Q(string) == 0) {
            if (this.f21734a.zzv().N(string, obj) == 0) {
                Object e4 = this.f21734a.zzv().e(string, obj);
                if (e4 == null) {
                    this.f21734a.zzaA().zzd().zzc("Unable to normalize conditional user property value", this.f21734a.zzj().f(string), obj);
                    return;
                }
                zzgz.zzb(bundle2, e4);
                long j5 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    this.f21734a.zzf();
                    if (j5 > 15552000000L || j5 < 1) {
                        this.f21734a.zzaA().zzd().zzc("Invalid conditional user property timeout", this.f21734a.zzj().f(string), Long.valueOf(j5));
                        return;
                    }
                }
                long j6 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                this.f21734a.zzf();
                if (j6 <= 15552000000L && j6 >= 1) {
                    this.f21734a.zzaB().zzp(new zzht(this, bundle2));
                    return;
                } else {
                    this.f21734a.zzaA().zzd().zzc("Invalid conditional user property time to live", this.f21734a.zzj().f(string), Long.valueOf(j6));
                    return;
                }
            }
            this.f21734a.zzaA().zzd().zzc("Invalid conditional user property value", this.f21734a.zzj().f(string), obj);
            return;
        }
        this.f21734a.zzaA().zzd().zzb("Invalid conditional user property name", this.f21734a.zzj().f(string));
    }

    public final void zzR(zzhb zzhbVar, long j4) {
        zzhb zzhbVar2;
        boolean z3;
        zzhb zzhbVar3;
        boolean z4;
        boolean z5;
        zza();
        int zza = zzhbVar.zza();
        if (zza != -10 && zzhbVar.zzf() == null && zzhbVar.zzg() == null) {
            this.f21734a.zzaA().zzl().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.f21852h) {
            zzhbVar2 = this.f21853i;
            z3 = false;
            if (zzhb.zzk(zza, zzhbVar2.zza())) {
                z5 = zzhbVar.zzm(this.f21853i);
                zzha zzhaVar = zzha.ANALYTICS_STORAGE;
                if (zzhbVar.zzj(zzhaVar) && !this.f21853i.zzj(zzhaVar)) {
                    z3 = true;
                }
                zzhb zze = zzhbVar.zze(this.f21853i);
                this.f21853i = zze;
                zzhbVar3 = zze;
                z4 = z3;
                z3 = true;
            } else {
                zzhbVar3 = zzhbVar;
                z4 = false;
                z5 = false;
            }
        }
        if (!z3) {
            this.f21734a.zzaA().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzhbVar3);
            return;
        }
        long andIncrement = this.f21854j.getAndIncrement();
        if (z5) {
            this.f21851g.set(null);
            this.f21734a.zzaB().zzq(new zzif(this, zzhbVar3, j4, andIncrement, z4, zzhbVar2));
            return;
        }
        zzig zzigVar = new zzig(this, zzhbVar3, andIncrement, z4, zzhbVar2);
        if (zza != 30 && zza != -10) {
            this.f21734a.zzaB().zzp(zzigVar);
        } else {
            this.f21734a.zzaB().zzq(zzigVar);
        }
    }

    public final void zzS(Bundle bundle, int i4, long j4) {
        zza();
        String zzh = zzhb.zzh(bundle);
        if (zzh != null) {
            this.f21734a.zzaA().zzl().zzb("Ignoring invalid consent setting", zzh);
            this.f21734a.zzaA().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        zzR(zzhb.zzb(bundle, i4), j4);
    }

    @WorkerThread
    public final void zzT(zzhf zzhfVar) {
        zzhf zzhfVar2;
        boolean z3;
        zzg();
        zza();
        if (zzhfVar != null && zzhfVar != (zzhfVar2 = this.f21848d)) {
            if (zzhfVar2 == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "EventInterceptor already set.");
        }
        this.f21848d = zzhfVar;
    }

    public final void zzU(Boolean bool) {
        zza();
        this.f21734a.zzaB().zzp(new zzie(this, bool));
    }

    public final void zzW(String str, String str2, Object obj, boolean z3) {
        zzX(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", obj, true, this.f21734a.zzax().currentTimeMillis());
    }

    public final void zzX(String str, String str2, Object obj, boolean z3, long j4) {
        int i4;
        String str3;
        int length;
        int i5;
        if (z3) {
            i4 = this.f21734a.zzv().Q(str2);
        } else {
            zzlp zzv = this.f21734a.zzv();
            if (zzv.w("user property", str2)) {
                if (!zzv.t("user property", zzhe.zza, null, str2)) {
                    i4 = 15;
                } else {
                    zzv.f21734a.zzf();
                    if (zzv.r("user property", 24, str2)) {
                        i4 = 0;
                    }
                }
            }
            i4 = 6;
        }
        if (i4 != 0) {
            zzlp zzv2 = this.f21734a.zzv();
            this.f21734a.zzf();
            String zzD = zzv2.zzD(str2, 24, true);
            if (str2 != null) {
                i5 = str2.length();
            } else {
                i5 = 0;
            }
            this.f21734a.zzv().n(this.f21858n, null, i4, "_ev", zzD, i5);
            return;
        }
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (obj != null) {
            int N = this.f21734a.zzv().N(str2, obj);
            if (N != 0) {
                zzlp zzv3 = this.f21734a.zzv();
                this.f21734a.zzf();
                String zzD2 = zzv3.zzD(str2, 24, true);
                if (!(obj instanceof String) && !(obj instanceof CharSequence)) {
                    length = 0;
                } else {
                    length = obj.toString().length();
                }
                this.f21734a.zzv().n(this.f21858n, null, N, "_ev", zzD2, length);
                return;
            }
            Object e4 = this.f21734a.zzv().e(str2, obj);
            if (e4 != null) {
                j(str3, str2, j4, e4);
                return;
            }
            return;
        }
        j(str3, str2, j4, null);
    }

    public final void zzZ(zzhg zzhgVar) {
        zza();
        Preconditions.checkNotNull(zzhgVar);
        if (!this.f21849e.remove(zzhgVar)) {
            this.f21734a.zzaA().zzk().zza("OnEventListener had not been registered");
        }
    }

    public final int zzh(String str) {
        Preconditions.checkNotEmpty(str);
        this.f21734a.zzf();
        return 25;
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.f21734a.zzaB().g(atomicReference, 15000L, "boolean test flag value", new zzhw(this, atomicReference));
    }

    public final Double zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.f21734a.zzaB().g(atomicReference, 15000L, "double test flag value", new zzid(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.f21734a.zzaB().g(atomicReference, 15000L, "int test flag value", new zzic(this, atomicReference));
    }

    public final Long zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.f21734a.zzaB().g(atomicReference, 15000L, "long test flag value", new zzib(this, atomicReference));
    }

    public final String zzo() {
        return (String) this.f21851g.get();
    }

    public final String zzp() {
        zzir zzi = this.f21734a.zzs().zzi();
        if (zzi != null) {
            return zzi.zzb;
        }
        return null;
    }

    public final String zzq() {
        zzir zzi = this.f21734a.zzs().zzi();
        if (zzi != null) {
            return zzi.zza;
        }
        return null;
    }

    public final String zzr() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.f21734a.zzaB().g(atomicReference, 15000L, "String test flag value", new zzia(this, atomicReference));
    }

    public final ArrayList zzs(String str, String str2) {
        if (this.f21734a.zzaB().zzs()) {
            this.f21734a.zzaA().zzd().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.f21734a.zzay();
        if (zzab.zza()) {
            this.f21734a.zzaA().zzd().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f21734a.zzaB().g(atomicReference, 5000L, "get conditional user properties", new zzhv(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            this.f21734a.zzaA().zzd().zzb("Timed out waiting for get conditional user properties", null);
            return new ArrayList();
        }
        return zzlp.zzH(list);
    }

    public final List zzt(boolean z3) {
        zza();
        this.f21734a.zzaA().zzj().zza("Getting user properties (FE)");
        if (!this.f21734a.zzaB().zzs()) {
            this.f21734a.zzay();
            if (zzab.zza()) {
                this.f21734a.zzaA().zzd().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.f21734a.zzaB().g(atomicReference, 5000L, "get user properties", new zzhr(this, atomicReference, z3));
            List list = (List) atomicReference.get();
            if (list == null) {
                this.f21734a.zzaA().zzd().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z3));
                return Collections.emptyList();
            }
            return list;
        }
        this.f21734a.zzaA().zzd().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzu(String str, String str2, boolean z3) {
        if (this.f21734a.zzaB().zzs()) {
            this.f21734a.zzaA().zzd().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.f21734a.zzay();
        if (zzab.zza()) {
            this.f21734a.zzaA().zzd().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f21734a.zzaB().g(atomicReference, 5000L, "get user properties", new zzhx(this, atomicReference, null, str, str2, z3));
        List<zzlk> list = (List) atomicReference.get();
        if (list == null) {
            this.f21734a.zzaA().zzd().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z3));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzlk zzlkVar : list) {
            Object zza = zzlkVar.zza();
            if (zza != null) {
                arrayMap.put(zzlkVar.zzb, zza);
            }
        }
        return arrayMap;
    }

    @WorkerThread
    public final void zzz() {
        zzg();
        zza();
        if (this.f21734a.g()) {
            if (this.f21734a.zzf().zzs(null, zzeg.zzZ)) {
                zzag zzf = this.f21734a.zzf();
                zzf.f21734a.zzay();
                Boolean d4 = zzf.d("google_analytics_deferred_deep_link_enabled");
                if (d4 != null && d4.booleanValue()) {
                    this.f21734a.zzaA().zzc().zza("Deferred Deep Link feature enabled.");
                    this.f21734a.zzaB().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhm
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzik zzikVar = zzik.this;
                            zzikVar.zzg();
                            if (!zzikVar.f21734a.zzm().f21607s.zzb()) {
                                long zza = zzikVar.f21734a.zzm().f21608t.zza();
                                zzikVar.f21734a.zzm().f21608t.zzb(1 + zza);
                                zzikVar.f21734a.zzf();
                                if (zza >= 5) {
                                    zzikVar.f21734a.zzaA().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                    zzikVar.f21734a.zzm().f21607s.zza(true);
                                    return;
                                }
                                zzikVar.f21734a.zzE();
                                return;
                            }
                            zzikVar.f21734a.zzaA().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
                        }
                    });
                }
            }
            this.f21734a.zzt().A();
            this.f21857m = false;
            zzfi zzm = this.f21734a.zzm();
            zzm.zzg();
            String string = zzm.d().getString("previous_os_version", null);
            zzm.f21734a.zzg().c();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzm.d().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.f21734a.zzg().c();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    e(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
    }
}
