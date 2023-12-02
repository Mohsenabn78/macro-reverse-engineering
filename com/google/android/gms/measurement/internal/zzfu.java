package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfu extends zzku implements zzaf {

    /* renamed from: d  reason: collision with root package name */
    private final Map f21624d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    final Map f21625e;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    final Map f21626f;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    final Map f21627g;

    /* renamed from: h  reason: collision with root package name */
    private final Map f21628h;

    /* renamed from: i  reason: collision with root package name */
    private final Map f21629i;
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    final LruCache f21630j;

    /* renamed from: k  reason: collision with root package name */
    final com.google.android.gms.internal.measurement.zzr f21631k;

    /* renamed from: l  reason: collision with root package name */
    private final Map f21632l;

    /* renamed from: m  reason: collision with root package name */
    private final Map f21633m;

    /* renamed from: n  reason: collision with root package name */
    private final Map f21634n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfu(zzlh zzlhVar) {
        super(zzlhVar);
        this.f21624d = new ArrayMap();
        this.f21625e = new ArrayMap();
        this.f21626f = new ArrayMap();
        this.f21627g = new ArrayMap();
        this.f21628h = new ArrayMap();
        this.f21632l = new ArrayMap();
        this.f21633m = new ArrayMap();
        this.f21634n = new ArrayMap();
        this.f21629i = new ArrayMap();
        this.f21630j = new zzfr(this, 20);
        this.f21631k = new zzfs(this);
    }

    @WorkerThread
    private final com.google.android.gms.internal.measurement.zzff d(String str, byte[] bArr) {
        Long l4;
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzff.zzg();
        }
        try {
            com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzlj.v(com.google.android.gms.internal.measurement.zzff.zze(), bArr)).zzaD();
            zzer zzj = this.f21734a.zzaA().zzj();
            String str2 = null;
            if (zzffVar.zzu()) {
                l4 = Long.valueOf(zzffVar.zzc());
            } else {
                l4 = null;
            }
            if (zzffVar.zzt()) {
                str2 = zzffVar.zzh();
            }
            zzj.zzc("Parsed config. version, gmp_app_id", l4, str2);
            return zzffVar;
        } catch (com.google.android.gms.internal.measurement.zzll e4) {
            this.f21734a.zzaA().zzk().zzc("Unable to merge remote config. appId", zzet.f(str), e4);
            return com.google.android.gms.internal.measurement.zzff.zzg();
        } catch (RuntimeException e5) {
            this.f21734a.zzaA().zzk().zzc("Unable to merge remote config. appId", zzet.f(str), e5);
            return com.google.android.gms.internal.measurement.zzff.zzg();
        }
    }

    private final void e(String str, com.google.android.gms.internal.measurement.zzfe zzfeVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        for (com.google.android.gms.internal.measurement.zzfb zzfbVar : zzfeVar.zzg()) {
            hashSet.add(zzfbVar.zzb());
        }
        for (int i4 = 0; i4 < zzfeVar.zza(); i4++) {
            com.google.android.gms.internal.measurement.zzfc zzfcVar = (com.google.android.gms.internal.measurement.zzfc) zzfeVar.zzb(i4).zzbB();
            if (zzfcVar.zzc().isEmpty()) {
                this.f21734a.zzaA().zzk().zza("EventConfig contained null event name");
            } else {
                String zzc = zzfcVar.zzc();
                String zzb = zzhc.zzb(zzfcVar.zzc());
                if (!TextUtils.isEmpty(zzb)) {
                    zzfcVar.zzb(zzb);
                    zzfeVar.zzd(i4, zzfcVar);
                }
                if (zzfcVar.zzf() && zzfcVar.zzd()) {
                    arrayMap.put(zzc, Boolean.TRUE);
                }
                if (zzfcVar.zzg() && zzfcVar.zze()) {
                    arrayMap2.put(zzfcVar.zzc(), Boolean.TRUE);
                }
                if (zzfcVar.zzh()) {
                    if (zzfcVar.zza() >= 2 && zzfcVar.zza() <= 65535) {
                        arrayMap3.put(zzfcVar.zzc(), Integer.valueOf(zzfcVar.zza()));
                    } else {
                        this.f21734a.zzaA().zzk().zzc("Invalid sampling rate. Event name, sample rate", zzfcVar.zzc(), Integer.valueOf(zzfcVar.zza()));
                    }
                }
            }
        }
        this.f21625e.put(str, hashSet);
        this.f21626f.put(str, arrayMap);
        this.f21627g.put(str, arrayMap2);
        this.f21629i.put(str, arrayMap3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0094, code lost:
        if (r2 == null) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0118  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void f(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfu.f(java.lang.String):void");
    }

    @WorkerThread
    private final void g(final String str, com.google.android.gms.internal.measurement.zzff zzffVar) {
        if (zzffVar.zza() != 0) {
            this.f21734a.zzaA().zzj().zzb("EES programs found", Integer.valueOf(zzffVar.zza()));
            com.google.android.gms.internal.measurement.zzgt zzgtVar = (com.google.android.gms.internal.measurement.zzgt) zzffVar.zzo().get(0);
            try {
                com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
                zzcVar.zzd("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfo
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new com.google.android.gms.internal.measurement.zzn("internal.remoteConfig", new zzft(zzfu.this, str));
                    }
                });
                zzcVar.zzd("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfp
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        final zzfu zzfuVar = zzfu.this;
                        final String str2 = str;
                        return new com.google.android.gms.internal.measurement.zzu("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfn
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                zzfu zzfuVar2 = zzfu.this;
                                String str3 = str2;
                                zzh I = zzfuVar2.f22016b.zzh().I(str3);
                                HashMap hashMap = new HashMap();
                                hashMap.put("platform", "android");
                                hashMap.put("package_name", str3);
                                zzfuVar2.f21734a.zzf().zzh();
                                hashMap.put("gmp_version", 79000L);
                                if (I != null) {
                                    String o02 = I.o0();
                                    if (o02 != null) {
                                        hashMap.put("app_version", o02);
                                    }
                                    hashMap.put("app_version_int", Long.valueOf(I.R()));
                                    hashMap.put("dynamite_version", Long.valueOf(I.a0()));
                                }
                                return hashMap;
                            }
                        });
                    }
                });
                zzcVar.zzd("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfq
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new com.google.android.gms.internal.measurement.zzt(zzfu.this.f21631k);
                    }
                });
                zzcVar.zzc(zzgtVar);
                this.f21630j.put(str, zzcVar);
                this.f21734a.zzaA().zzj().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzgtVar.zza().zza()));
                for (com.google.android.gms.internal.measurement.zzgr zzgrVar : zzgtVar.zza().zzd()) {
                    this.f21734a.zzaA().zzj().zzb("EES program activity", zzgrVar.zzb());
                }
                return;
            } catch (com.google.android.gms.internal.measurement.zzd unused) {
                this.f21734a.zzaA().zzd().zzb("Failed to load EES program. appId", str);
                return;
            }
        }
        this.f21630j.remove(str);
    }

    private static final Map h(com.google.android.gms.internal.measurement.zzff zzffVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzffVar != null) {
            for (com.google.android.gms.internal.measurement.zzfj zzfjVar : zzffVar.zzp()) {
                arrayMap.put(zzfjVar.zzb(), zzfjVar.zzc());
            }
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ com.google.android.gms.internal.measurement.zzc j(zzfu zzfuVar, String str) {
        zzfuVar.a();
        Preconditions.checkNotEmpty(str);
        if (!zzfuVar.zzo(str)) {
            return null;
        }
        if (zzfuVar.f21628h.containsKey(str) && zzfuVar.f21628h.get(str) != null) {
            zzfuVar.g(str, (com.google.android.gms.internal.measurement.zzff) zzfuVar.f21628h.get(str));
        } else {
            zzfuVar.f(str);
        }
        return (com.google.android.gms.internal.measurement.zzc) zzfuVar.f21630j.snapshot().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean A(String str) {
        zzg();
        f(str);
        if (this.f21625e.get(str) != null && ((Set) this.f21625e.get(str)).contains("google_signals")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean B(String str) {
        zzg();
        f(str);
        if (this.f21625e.get(str) == null) {
            return false;
        }
        if (!((Set) this.f21625e.get(str)).contains("os_version") && !((Set) this.f21625e.get(str)).contains("device_info")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean C(String str) {
        zzg();
        f(str);
        if (this.f21625e.get(str) != null && ((Set) this.f21625e.get(str)).contains("user_id")) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzku
    protected final boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final int i(String str, String str2) {
        Integer num;
        zzg();
        f(str);
        Map map = (Map) this.f21629i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final com.google.android.gms.internal.measurement.zzff k(String str) {
        a();
        zzg();
        Preconditions.checkNotEmpty(str);
        f(str);
        return (com.google.android.gms.internal.measurement.zzff) this.f21628h.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final String l(String str) {
        zzg();
        return (String) this.f21634n.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final String m(String str) {
        zzg();
        return (String) this.f21633m.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final String n(String str) {
        zzg();
        f(str);
        return (String) this.f21632l.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final Set p(String str) {
        zzg();
        f(str);
        return (Set) this.f21625e.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void q(String str) {
        zzg();
        this.f21633m.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void r(String str) {
        zzg();
        this.f21628h.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean s(String str) {
        zzg();
        com.google.android.gms.internal.measurement.zzff k4 = k(str);
        if (k4 == null) {
            return false;
        }
        return k4.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean u(String str, String str2) {
        Boolean bool;
        zzg();
        f(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = (Map) this.f21627g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean v(String str, String str2) {
        Boolean bool;
        zzg();
        f(str);
        if (t(str) && zzlp.B(str2)) {
            return true;
        }
        if (w(str) && zzlp.C(str2)) {
            return true;
        }
        Map map = (Map) this.f21626f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean w(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final boolean x(String str, byte[] bArr, String str2, String str3) {
        a();
        zzg();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzfe zzfeVar = (com.google.android.gms.internal.measurement.zzfe) d(str, bArr).zzbB();
        e(str, zzfeVar);
        g(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar.zzaD());
        this.f21628h.put(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar.zzaD());
        this.f21632l.put(str, zzfeVar.zze());
        this.f21633m.put(str, str2);
        this.f21634n.put(str, str3);
        this.f21624d.put(str, h((com.google.android.gms.internal.measurement.zzff) zzfeVar.zzaD()));
        this.f22016b.zzh().e(str, new ArrayList(zzfeVar.zzf()));
        try {
            zzfeVar.zzc();
            bArr = ((com.google.android.gms.internal.measurement.zzff) zzfeVar.zzaD()).zzbx();
        } catch (RuntimeException e4) {
            this.f21734a.zzaA().zzk().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzet.f(str), e4);
        }
        zzak zzh = this.f22016b.zzh();
        Preconditions.checkNotEmpty(str);
        zzh.zzg();
        zzh.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzh.G().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzh.f21734a.zzaA().zzd().zzb("Failed to update remote config (got 0). appId", zzet.f(str));
            }
        } catch (SQLiteException e5) {
            zzh.f21734a.zzaA().zzd().zzc("Error storing remote config. appId", zzet.f(str), e5);
        }
        this.f21628h.put(str, (com.google.android.gms.internal.measurement.zzff) zzfeVar.zzaD());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean y(String str) {
        zzg();
        f(str);
        if (this.f21625e.get(str) != null && ((Set) this.f21625e.get(str)).contains("app_instance_id")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean z(String str) {
        zzg();
        f(str);
        if (this.f21625e.get(str) == null) {
            return false;
        }
        if (!((Set) this.f21625e.get(str)).contains("device_model") && !((Set) this.f21625e.get(str)).contains("device_info")) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzaf
    @WorkerThread
    public final String zza(String str, String str2) {
        zzg();
        f(str);
        Map map = (Map) this.f21624d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final boolean zzo(String str) {
        com.google.android.gms.internal.measurement.zzff zzffVar;
        if (TextUtils.isEmpty(str) || (zzffVar = (com.google.android.gms.internal.measurement.zzff) this.f21628h.get(str)) == null || zzffVar.zza() == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzw(String str) {
        zzg();
        f(str);
        if (this.f21625e.get(str) != null && ((Set) this.f21625e.get(str)).contains("enhanced_user_id")) {
            return true;
        }
        return false;
    }
}
