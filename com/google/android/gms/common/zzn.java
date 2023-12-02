package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@CheckReturnValue
/* loaded from: classes4.dex */
public final class zzn {

    /* renamed from: e  reason: collision with root package name */
    private static volatile zzaf f20781e;

    /* renamed from: g  reason: collision with root package name */
    private static Context f20783g;

    /* renamed from: a  reason: collision with root package name */
    static final zzl f20777a = new zzf(zzj.a("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* renamed from: b  reason: collision with root package name */
    static final zzl f20778b = new zzg(zzj.a("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* renamed from: c  reason: collision with root package name */
    static final zzl f20779c = new zzh(zzj.a("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* renamed from: d  reason: collision with root package name */
    static final zzl f20780d = new zzi(zzj.a("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* renamed from: f  reason: collision with root package name */
    private static final Object f20782f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx a(String str, zzj zzjVar, boolean z3, boolean z4) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return h(str, zzjVar, z3, z4);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx b(String str, boolean z3, boolean z4, boolean z5) {
        return i(str, z3, false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx c(String str, boolean z3, boolean z4, boolean z5) {
        return i(str, z3, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String d(boolean z3, String str, zzj zzjVar) throws Exception {
        boolean z4;
        String str2;
        if (!z3 && h(str, zzjVar, true, false).f20799a) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (true != z4) {
            str2 = "not allowed";
        } else {
            str2 = "debug cert rejected";
        }
        MessageDigest zza = AndroidUtilsLight.zza(KeyPropertiesCompact.DIGEST_SHA256);
        Preconditions.checkNotNull(zza);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(zza.digest(zzjVar.b())), Boolean.valueOf(z3), "12451000.false");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void e(Context context) {
        synchronized (zzn.class) {
            if (f20783g == null) {
                if (context != null) {
                    f20783g = context.getApplicationContext();
                    return;
                }
                return;
            }
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                j();
                return f20781e.zzg();
            } catch (RemoteException | DynamiteModule.LoadingException e4) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return false;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                j();
                return f20781e.zzi();
            } catch (RemoteException | DynamiteModule.LoadingException e4) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return false;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static zzx h(final String str, final zzj zzjVar, final boolean z3, boolean z4) {
        try {
            j();
            Preconditions.checkNotNull(f20783g);
            try {
                if (f20781e.zzh(new zzs(str, zzjVar, z3, z4), ObjectWrapper.wrap(f20783g.getPackageManager()))) {
                    return zzx.b();
                }
                return new zzv(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzn.d(z3, str, zzjVar);
                    }
                }, null);
            } catch (RemoteException e4) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
                return zzx.d("module call", e4);
            }
        } catch (DynamiteModule.LoadingException e5) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            return zzx.d("module init: ".concat(String.valueOf(e5.getMessage())), e5);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    private static zzx i(String str, boolean z3, boolean z4, boolean z5, boolean z6) {
        zzx d4;
        zzq zzf;
        PackageManager.NameNotFoundException nameNotFoundException;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(f20783g);
            try {
                j();
                zzo zzoVar = new zzo(str, z3, false, ObjectWrapper.wrap(f20783g), false);
                try {
                    if (z6) {
                        zzf = f20781e.zze(zzoVar);
                    } else {
                        zzf = f20781e.zzf(zzoVar);
                    }
                    if (zzf.zzb()) {
                        d4 = zzx.f(zzf.zzc());
                    } else {
                        String zza = zzf.zza();
                        if (zzf.zzd() == 4) {
                            nameNotFoundException = new PackageManager.NameNotFoundException();
                        } else {
                            nameNotFoundException = null;
                        }
                        if (zza == null) {
                            zza = "error checking package certificate";
                        }
                        d4 = zzx.g(zzf.zzc(), zzf.zzd(), zza, nameNotFoundException);
                    }
                } catch (RemoteException e4) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
                    d4 = zzx.d("module call", e4);
                }
            } catch (DynamiteModule.LoadingException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
                d4 = zzx.d("module init: ".concat(String.valueOf(e5.getMessage())), e5);
            }
            return d4;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static void j() throws DynamiteModule.LoadingException {
        if (f20781e != null) {
            return;
        }
        Preconditions.checkNotNull(f20783g);
        synchronized (f20782f) {
            if (f20781e == null) {
                f20781e = com.google.android.gms.common.internal.zzae.zzb(DynamiteModule.load(f20783g, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
