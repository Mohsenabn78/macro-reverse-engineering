package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.EnvironmentCompat;
import androidx.webkit.ProxyConfig;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.sun.mail.imap.IMAPStore;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbsw implements zzbsy {
    @VisibleForTesting
    static zzbsy zza;
    @VisibleForTesting
    static zzbsy zzb;
    private static final Object zzc = new Object();
    private final Context zze;
    private final ExecutorService zzg;
    private final zzbzx zzh;
    private final Object zzd = new Object();
    private final WeakHashMap zzf = new WeakHashMap();

    protected zzbsw(Context context, zzbzx zzbzxVar) {
        zzfmc.zza();
        this.zzg = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        this.zze = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzh = zzbzxVar;
    }

    public static zzbsy zza(Context context) {
        synchronized (zzc) {
            if (zza == null) {
                if (((Boolean) zzbdn.zze.zze()).booleanValue()) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhq)).booleanValue()) {
                        zza = new zzbsw(context, zzbzx.zza());
                    }
                }
                zza = new zzbsx();
            }
        }
        return zza;
    }

    public static zzbsy zzb(Context context, zzbzx zzbzxVar) {
        synchronized (zzc) {
            if (zzb == null) {
                if (((Boolean) zzbdn.zze.zze()).booleanValue()) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhq)).booleanValue()) {
                        zzbsw zzbswVar = new zzbsw(context, zzbzxVar);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzbswVar.zzd) {
                                zzbswVar.zzf.put(thread, Boolean.TRUE);
                            }
                            thread.setUncaughtExceptionHandler(new zzbsv(zzbswVar, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzbsu(zzbswVar, Thread.getDefaultUncaughtExceptionHandler()));
                        zzb = zzbswVar;
                    }
                }
                zzb = new zzbsx();
            }
        }
        return zzb;
    }

    public static String zzc(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzd(Throwable th) {
        return zzfpw.zzc(zzbzk.zzf(zzc(th)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zze(Thread thread, Throwable th) {
        StackTraceElement[] stackTrace;
        if (th != null) {
            boolean z3 = false;
            boolean z4 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    z3 |= zzbzk.zzo(stackTraceElement.getClassName());
                    z4 |= zzbsw.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            if (z3 && !z4) {
                zzg(th, "", 1.0f);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzf(Throwable th, String str) {
        zzg(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzg(Throwable th, String str, float f4) {
        Throwable th2;
        Throwable th3;
        String str2;
        int i4;
        String str3;
        String str4;
        Handler handler = zzbzk.zza;
        boolean z3 = false;
        if (((Boolean) zzbdn.zzf.zze()).booleanValue()) {
            th2 = th;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable th4 = th; th4 != null; th4 = th4.getCause()) {
                linkedList.push(th4);
            }
            th2 = null;
            while (!linkedList.isEmpty()) {
                Throwable th5 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th5.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th5.getClass().getName(), "<filtered>", "<filtered>", 1));
                boolean z4 = false;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (zzbzk.zzo(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z4 = true;
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (TextUtils.isEmpty(className) || (!className.startsWith("android.") && !className.startsWith("java."))) {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        } else {
                            arrayList.add(stackTraceElement);
                        }
                    }
                }
                if (z4) {
                    if (th2 == null) {
                        th3 = new Throwable(th5.getMessage());
                    } else {
                        th3 = new Throwable(th5.getMessage(), th2);
                    }
                    th2 = th3;
                    th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                }
            }
        }
        if (th2 == null) {
            return;
        }
        String name = th.getClass().getName();
        String zzc2 = zzc(th);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzip)).booleanValue()) {
            str2 = zzd(th);
        } else {
            str2 = "";
        }
        double d4 = f4;
        int i5 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
        double random = Math.random();
        if (i5 > 0) {
            i4 = (int) (1.0f / f4);
        } else {
            i4 = 1;
        }
        if (random < d4) {
            ArrayList<String> arrayList2 = new ArrayList();
            try {
                z3 = Wrappers.packageManager(this.zze).isCallerInstantApp();
            } catch (Throwable th6) {
                zzbzr.zzh("Error fetching instant app info", th6);
            }
            try {
                str3 = this.zze.getPackageName();
            } catch (Throwable unused) {
                zzbzr.zzj("Cannot obtain package name, proceeding.");
                str3 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme(ProxyConfig.MATCH_HTTPS).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z3)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter(IMAPStore.ID_OS, Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
            String str5 = Build.MANUFACTURER;
            String str6 = Build.MODEL;
            if (!str6.startsWith(str5)) {
                str6 = str5 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str6;
            }
            Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzh.zza).appendQueryParameter("appid", str3).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", zzc2).appendQueryParameter("eids", TextUtils.join(",", com.google.android.gms.ads.internal.client.zzba.zza().zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "549114221").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i4)).appendQueryParameter("pb_tm", String.valueOf(zzbdn.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze)));
            if (true != this.zzh.zze) {
                str4 = "0";
            } else {
                str4 = "1";
            }
            Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("lite", str4);
            if (!TextUtils.isEmpty(str2)) {
                appendQueryParameter3.appendQueryParameter("hash", str2);
            }
            arrayList2.add(appendQueryParameter3.toString());
            for (final String str7 : arrayList2) {
                final zzbzw zzbzwVar = new zzbzw(null);
                this.zzg.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbst
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbzw.this.zza(str7);
                    }
                });
            }
        }
    }
}
