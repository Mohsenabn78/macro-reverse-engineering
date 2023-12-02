package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zziz extends zzf {

    /* renamed from: c  reason: collision with root package name */
    private volatile zzir f21881c;

    /* renamed from: d  reason: collision with root package name */
    private volatile zzir f21882d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    protected zzir f21883e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f21884f;
    @GuardedBy("activityLock")

    /* renamed from: g  reason: collision with root package name */
    private Activity f21885g;
    @GuardedBy("activityLock")

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f21886h;

    /* renamed from: i  reason: collision with root package name */
    private volatile zzir f21887i;

    /* renamed from: j  reason: collision with root package name */
    private zzir f21888j;
    @GuardedBy("activityLock")

    /* renamed from: k  reason: collision with root package name */
    private boolean f21889k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f21890l;

    public zziz(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21890l = new Object();
        this.f21884f = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void d(zzir zzirVar, zzir zzirVar2, long j4, boolean z3, Bundle bundle) {
        boolean z4;
        Bundle bundle2;
        String str;
        long j5;
        long j6;
        zzg();
        boolean z5 = false;
        if (zzirVar2 != null && zzirVar2.zzc == zzirVar.zzc && zzis.zza(zzirVar2.zzb, zzirVar.zzb) && zzis.zza(zzirVar2.zza, zzirVar.zza)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z3 && this.f21883e != null) {
            z5 = true;
        }
        if (z4) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            zzlp.zzK(zzirVar, bundle3, true);
            if (zzirVar2 != null) {
                String str2 = zzirVar2.zza;
                if (str2 != null) {
                    bundle3.putString("_pn", str2);
                }
                String str3 = zzirVar2.zzb;
                if (str3 != null) {
                    bundle3.putString("_pc", str3);
                }
                bundle3.putLong("_pi", zzirVar2.zzc);
            }
            if (z5) {
                zzkn zzknVar = this.f21734a.zzu().f22008f;
                long j7 = j4 - zzknVar.f22001b;
                zzknVar.f22001b = j4;
                if (j7 > 0) {
                    this.f21734a.zzv().i(bundle3, j7);
                }
            }
            if (!this.f21734a.zzf().zzu()) {
                bundle3.putLong("_mst", 1L);
            }
            if (true != zzirVar.zze) {
                str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            } else {
                str = "app";
            }
            String str4 = str;
            long currentTimeMillis = this.f21734a.zzax().currentTimeMillis();
            if (zzirVar.zze) {
                j5 = currentTimeMillis;
                long j8 = zzirVar.zzf;
                if (j8 != 0) {
                    j6 = j8;
                    this.f21734a.zzq().f(str4, "_vs", j6, bundle3);
                }
            } else {
                j5 = currentTimeMillis;
            }
            j6 = j5;
            this.f21734a.zzq().f(str4, "_vs", j6, bundle3);
        }
        if (z5) {
            e(this.f21883e, true, j4);
        }
        this.f21883e = zzirVar;
        if (zzirVar.zze) {
            this.f21888j = zzirVar;
        }
        this.f21734a.zzt().i(zzirVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void e(zzir zzirVar, boolean z3, long j4) {
        boolean z4;
        this.f21734a.zzd().zzf(this.f21734a.zzax().elapsedRealtime());
        if (zzirVar != null && zzirVar.f21863a) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f21734a.zzu().f22008f.d(z4, z3, j4) && zzirVar != null) {
            zzirVar.f21863a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void j(zziz zzizVar, Bundle bundle, zzir zzirVar, zzir zzirVar2, long j4) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzizVar.d(zzirVar, zzirVar2, j4, true, zzizVar.f21734a.zzv().U(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    @MainThread
    private final zzir l(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzir zzirVar = (zzir) this.f21884f.get(activity);
        if (zzirVar == null) {
            zzir zzirVar2 = new zzir(null, g(activity.getClass(), "Activity"), this.f21734a.zzv().zzq());
            this.f21884f.put(activity, zzirVar2);
            zzirVar = zzirVar2;
        }
        if (this.f21887i != null) {
            return this.f21887i;
        }
        return zzirVar;
    }

    @MainThread
    private final void m(Activity activity, zzir zzirVar, boolean z3) {
        zzir zzirVar2;
        zzir zzirVar3;
        String str;
        if (this.f21881c == null) {
            zzirVar2 = this.f21882d;
        } else {
            zzirVar2 = this.f21881c;
        }
        zzir zzirVar4 = zzirVar2;
        if (zzirVar.zzb == null) {
            if (activity != null) {
                str = g(activity.getClass(), "Activity");
            } else {
                str = null;
            }
            zzirVar3 = new zzir(zzirVar.zza, str, zzirVar.zzc, zzirVar.zze, zzirVar.zzf);
        } else {
            zzirVar3 = zzirVar;
        }
        this.f21882d = this.f21881c;
        this.f21881c = zzirVar3;
        this.f21734a.zzaB().zzp(new zziu(this, zzirVar3, zzirVar4, this.f21734a.zzax().elapsedRealtime(), z3));
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean c() {
        return false;
    }

    @VisibleForTesting
    final String g(Class cls, String str) {
        String str2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        if (length > 0) {
            str2 = split[length - 1];
        } else {
            str2 = "";
        }
        int length2 = str2.length();
        this.f21734a.zzf();
        if (length2 > 100) {
            this.f21734a.zzf();
            return str2.substring(0, 100);
        }
        return str2;
    }

    public final zzir zzi() {
        return this.f21881c;
    }

    @WorkerThread
    public final zzir zzj(boolean z3) {
        zza();
        zzg();
        if (!z3) {
            return this.f21883e;
        }
        zzir zzirVar = this.f21883e;
        if (zzirVar != null) {
            return zzirVar;
        }
        return this.f21888j;
    }

    @MainThread
    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.f21734a.zzf().zzu() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f21884f.put(activity, new zzir(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    @MainThread
    public final void zzs(Activity activity) {
        synchronized (this.f21890l) {
            if (activity == this.f21885g) {
                this.f21885g = null;
            }
        }
        if (!this.f21734a.zzf().zzu()) {
            return;
        }
        this.f21884f.remove(activity);
    }

    @MainThread
    public final void zzt(Activity activity) {
        synchronized (this.f21890l) {
            this.f21889k = false;
            this.f21886h = true;
        }
        long elapsedRealtime = this.f21734a.zzax().elapsedRealtime();
        if (!this.f21734a.zzf().zzu()) {
            this.f21881c = null;
            this.f21734a.zzaB().zzp(new zziw(this, elapsedRealtime));
            return;
        }
        zzir l4 = l(activity);
        this.f21882d = this.f21881c;
        this.f21881c = null;
        this.f21734a.zzaB().zzp(new zzix(this, l4, elapsedRealtime));
    }

    @MainThread
    public final void zzu(Activity activity) {
        synchronized (this.f21890l) {
            this.f21889k = true;
            if (activity != this.f21885g) {
                synchronized (this.f21890l) {
                    this.f21885g = activity;
                    this.f21886h = false;
                }
                if (this.f21734a.zzf().zzu()) {
                    this.f21887i = null;
                    this.f21734a.zzaB().zzp(new zziy(this));
                }
            }
        }
        if (!this.f21734a.zzf().zzu()) {
            this.f21881c = this.f21887i;
            this.f21734a.zzaB().zzp(new zziv(this));
            return;
        }
        m(activity, l(activity), false);
        zzd zzd = this.f21734a.zzd();
        zzd.f21734a.zzaB().zzp(new zzc(zzd, zzd.f21734a.zzax().elapsedRealtime()));
    }

    @MainThread
    public final void zzv(Activity activity, Bundle bundle) {
        zzir zzirVar;
        if (!this.f21734a.zzf().zzu() || bundle == null || (zzirVar = (zzir) this.f21884f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzirVar.zzc);
        bundle2.putString("name", zzirVar.zza);
        bundle2.putString("referrer_name", zzirVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        if (r1 <= 100) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
        if (r1 <= 100) goto L36;
     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzw(@androidx.annotation.NonNull android.app.Activity r4, @androidx.annotation.Size(max = 36, min = 1) java.lang.String r5, @androidx.annotation.Size(max = 36, min = 1) java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzgd r0 = r3.f21734a
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            boolean r0 = r0.zzu()
            if (r0 != 0) goto L1c
            com.google.android.gms.measurement.internal.zzgd r4 = r3.f21734a
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.zza(r5)
            return
        L1c:
            com.google.android.gms.measurement.internal.zzir r0 = r3.f21881c
            if (r0 != 0) goto L30
            com.google.android.gms.measurement.internal.zzgd r4 = r3.f21734a
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.zza(r5)
            return
        L30:
            java.util.Map r1 = r3.f21884f
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L48
            com.google.android.gms.measurement.internal.zzgd r4 = r3.f21734a
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.zza(r5)
            return
        L48:
            if (r6 != 0) goto L54
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.g(r6, r1)
        L54:
            java.lang.String r1 = r0.zzb
            boolean r1 = com.google.android.gms.measurement.internal.zzis.zza(r1, r6)
            java.lang.String r0 = r0.zza
            boolean r0 = com.google.android.gms.measurement.internal.zzis.zza(r0, r5)
            if (r1 == 0) goto L75
            if (r0 != 0) goto L65
            goto L75
        L65:
            com.google.android.gms.measurement.internal.zzgd r4 = r3.f21734a
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.zza(r5)
            return
        L75:
            r0 = 100
            if (r5 == 0) goto La3
            int r1 = r5.length()
            if (r1 <= 0) goto L8b
            int r1 = r5.length()
            com.google.android.gms.measurement.internal.zzgd r2 = r3.f21734a
            r2.zzf()
            if (r1 > r0) goto L8b
            goto La3
        L8b:
            com.google.android.gms.measurement.internal.zzgd r4 = r3.f21734a
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            int r5 = r5.length()
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.zzb(r6, r5)
            return
        La3:
            if (r6 == 0) goto Lcf
            int r1 = r6.length()
            if (r1 <= 0) goto Lb7
            int r1 = r6.length()
            com.google.android.gms.measurement.internal.zzgd r2 = r3.f21734a
            r2.zzf()
            if (r1 > r0) goto Lb7
            goto Lcf
        Lb7:
            com.google.android.gms.measurement.internal.zzgd r4 = r3.f21734a
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            int r5 = r6.length()
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.zzb(r6, r5)
            return
        Lcf:
            com.google.android.gms.measurement.internal.zzgd r0 = r3.f21734a
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            if (r5 != 0) goto Lde
            java.lang.String r1 = "null"
            goto Ldf
        Lde:
            r1 = r5
        Ldf:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.zzc(r2, r1, r6)
            com.google.android.gms.measurement.internal.zzir r0 = new com.google.android.gms.measurement.internal.zzir
            com.google.android.gms.measurement.internal.zzgd r1 = r3.f21734a
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            long r1 = r1.zzq()
            r0.<init>(r5, r6, r1)
            java.util.Map r5 = r3.f21884f
            r5.put(r4, r0)
            r5 = 1
            r3.m(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziz.zzw(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r2 > 100) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
        if (r4 > 100) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzx(android.os.Bundle r13, long r14) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziz.zzx(android.os.Bundle, long):void");
    }
}
