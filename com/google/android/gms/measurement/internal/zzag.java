package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzag extends zzgw {

    /* renamed from: b  reason: collision with root package name */
    private Boolean f21432b;

    /* renamed from: c  reason: collision with root package name */
    private zzaf f21433c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f21434d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21433c = new zzaf() { // from class: com.google.android.gms.measurement.internal.zzae
            @Override // com.google.android.gms.measurement.internal.zzaf
            public final String zza(String str, String str2) {
                return null;
            }
        };
    }

    private final String a(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e4) {
            this.f21734a.zzaA().zzd().zzb("Could not find SystemProperties class", e4);
            return "";
        } catch (IllegalAccessException e5) {
            this.f21734a.zzaA().zzd().zzb("Could not access SystemProperties.get()", e5);
            return "";
        } catch (NoSuchMethodException e6) {
            this.f21734a.zzaA().zzd().zzb("Could not find SystemProperties.get() method", e6);
            return "";
        } catch (InvocationTargetException e7) {
            this.f21734a.zzaA().zzd().zzb("SystemProperties.get() threw an exception", e7);
            return "";
        }
    }

    public static final long zzA() {
        return ((Long) zzeg.zzD.zza(null)).longValue();
    }

    public static final long zzz() {
        return ((Long) zzeg.zzd.zza(null)).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b(@Size(min = 1) String str) {
        return zzf(str, zzeg.zzH, 500, 2000);
    }

    @VisibleForTesting
    final Bundle c() {
        try {
            if (this.f21734a.zzaw().getPackageManager() == null) {
                this.f21734a.zzaA().zzd().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(this.f21734a.zzaw()).getApplicationInfo(this.f21734a.zzaw().getPackageName(), 128);
            if (applicationInfo == null) {
                this.f21734a.zzaA().zzd().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e4) {
            this.f21734a.zzaA().zzd().zzb("Failed to load metadata: Package name not found", e4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean d(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle c4 = c();
        if (c4 == null) {
            this.f21734a.zzaA().zzd().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!c4.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(c4.getBoolean(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String e() {
        this.f21734a.zzay();
        return "FA";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List f(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.c()
            r1 = 0
            if (r0 != 0) goto L1d
            com.google.android.gms.measurement.internal.zzgd r4 = r3.f21734a
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzd()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L1b:
            r4 = r1
            goto L2c
        L1d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L24
            goto L1b
        L24:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L2c:
            if (r4 == 0) goto L58
            com.google.android.gms.measurement.internal.zzgd r0 = r3.f21734a     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.Context r0 = r0.zzaw()     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L48
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L48
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            if (r4 != 0) goto L43
            return r1
        L43:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            return r4
        L48:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzgd r0 = r3.f21734a
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r2, r4)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzag.f(java.lang.String):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(zzaf zzafVar) {
        this.f21433c = zzafVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean h() {
        if (this.f21432b == null) {
            Boolean d4 = d("app_measurement_lite");
            this.f21432b = d4;
            if (d4 == null) {
                this.f21432b = Boolean.FALSE;
            }
        }
        if (!this.f21432b.booleanValue() && this.f21734a.zzN()) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final double zza(String str, zzef zzefVar) {
        if (str == null) {
            return ((Double) zzefVar.zza(null)).doubleValue();
        }
        String zza = this.f21433c.zza(str, zzefVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Double) zzefVar.zza(null)).doubleValue();
        }
        try {
            return ((Double) zzefVar.zza(Double.valueOf(Double.parseDouble(zza)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzefVar.zza(null)).doubleValue();
        }
    }

    public final int zzc() {
        if (this.f21734a.zzv().zzai(201500000, true)) {
            return 100;
        }
        return 25;
    }

    public final int zzd(@Size(min = 1) String str) {
        return zzf(str, zzeg.zzI, 25, 100);
    }

    @WorkerThread
    public final int zze(String str, zzef zzefVar) {
        if (str == null) {
            return ((Integer) zzefVar.zza(null)).intValue();
        }
        String zza = this.f21433c.zza(str, zzefVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Integer) zzefVar.zza(null)).intValue();
        }
        try {
            return ((Integer) zzefVar.zza(Integer.valueOf(Integer.parseInt(zza)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzefVar.zza(null)).intValue();
        }
    }

    @WorkerThread
    public final int zzf(String str, zzef zzefVar, int i4, int i5) {
        return Math.max(Math.min(zze(str, zzefVar), i5), i4);
    }

    public final long zzh() {
        this.f21734a.zzay();
        return 79000L;
    }

    @WorkerThread
    public final long zzi(String str, zzef zzefVar) {
        if (str == null) {
            return ((Long) zzefVar.zza(null)).longValue();
        }
        String zza = this.f21433c.zza(str, zzefVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Long) zzefVar.zza(null)).longValue();
        }
        try {
            return ((Long) zzefVar.zza(Long.valueOf(Long.parseLong(zza)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzefVar.zza(null)).longValue();
        }
    }

    public final String zzl() {
        return a("debug.firebase.analytics.app", "");
    }

    public final String zzm() {
        return a("debug.deferred.deeplink", "");
    }

    @WorkerThread
    public final String zzo(String str, zzef zzefVar) {
        if (str == null) {
            return (String) zzefVar.zza(null);
        }
        return (String) zzefVar.zza(this.f21433c.zza(str, zzefVar.zzb()));
    }

    public final boolean zzr() {
        Boolean d4 = d("google_analytics_adid_collection_enabled");
        if (d4 != null && !d4.booleanValue()) {
            return false;
        }
        return true;
    }

    @WorkerThread
    public final boolean zzs(String str, zzef zzefVar) {
        if (str == null) {
            return ((Boolean) zzefVar.zza(null)).booleanValue();
        }
        String zza = this.f21433c.zza(str, zzefVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Boolean) zzefVar.zza(null)).booleanValue();
        }
        return ((Boolean) zzefVar.zza(Boolean.valueOf("1".equals(zza)))).booleanValue();
    }

    public final boolean zzt(String str) {
        return "1".equals(this.f21433c.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzu() {
        Boolean d4 = d("google_analytics_automatic_screen_reporting_enabled");
        if (d4 != null && !d4.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzv() {
        this.f21734a.zzay();
        Boolean d4 = d("firebase_analytics_collection_deactivated");
        if (d4 != null && d4.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean zzw(String str) {
        return "1".equals(this.f21433c.zza(str, "measurement.event_sampling_enabled"));
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzy() {
        if (this.f21434d == null) {
            synchronized (this) {
                if (this.f21434d == null) {
                    ApplicationInfo applicationInfo = this.f21734a.zzaw().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z3 = false;
                        if (str != null && str.equals(myProcessName)) {
                            z3 = true;
                        }
                        this.f21434d = Boolean.valueOf(z3);
                    }
                    if (this.f21434d == null) {
                        this.f21434d = Boolean.TRUE;
                        this.f21734a.zzaA().zzd().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f21434d.booleanValue();
    }
}
