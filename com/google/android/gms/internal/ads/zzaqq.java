package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzaqq extends zzaqp {
    private static zzasc zzA = null;
    private static zzaru zzB = null;
    protected static final Object zzs = new Object();
    @VisibleForTesting
    static boolean zzt = false;
    private static final String zzx = "zzaqq";
    private static long zzy;
    private static zzaqw zzz;
    private final Map zzC;
    protected boolean zzu;
    protected final String zzv;
    @VisibleForTesting
    zzasa zzw;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzaqq(Context context, String str, boolean z3) {
        super(context);
        this.zzu = false;
        this.zzC = new HashMap();
        this.zzv = str;
        this.zzu = z3;
    }

    protected static zzart zzj(Context context, boolean z3) {
        if (zzaqp.zza == null) {
            synchronized (zzs) {
                if (zzaqp.zza == null) {
                    zzart zzg = zzart.zzg(context, "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", z3);
                    if (zzg.zzr()) {
                        try {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcS)).booleanValue()) {
                                zzg.zzt("kMb1Y+NVqJaSsS3UXLtIkf/b8ynaIj/TTgy+cgaHvi+JeFiotnWAgB7yFjfJ6TG3", "ie6hg5HFEpuWzwNgwITo5zXW2wrs4LH8lgFkpMwMO4M=", new Class[0]);
                            }
                        } catch (IllegalStateException unused) {
                        }
                        zzg.zzt("sjJJMjdJ4ejENjGN3VSKrjMe8gO2ipNVGbEWPt320LzidWuv9Vye4oanMfYCO4eP", "M+JigCCNgE9WH1drVXVCETLYEk7iaWPFwZXUH8JlEbE=", Context.class);
                        zzg.zzt("x244HDzWeCJXpaVmJz6ZDJ8SomiOjqvEXNm93LF/UprnziaRy0GWl7kRtW31unI7", "QfNmx51vMYu7RTw3f+TZAS23f16Jqr3kM4ALSpqOw0Y=", Context.class);
                        zzg.zzt("kG8kAzeUJFSjvYuRDtJkr7owBxy52vKH1yfYPq05BRQDWSz1Oa+VomdlwOHttvWk", "SXEqPPoGCAhkrwWNonsWzEV+zX6m6TBLFFDVOqk+hqA=", Context.class);
                        zzg.zzt("61r5RjlUpp0Sx9otiMiZNQFewfAHPXct4XNb20i2Qy085lteyha1wknNg1lweS6E", "BxKk+MigL5QcJoHkNRs0ALc6QE50Izh8oVpecosSZ5s=", Context.class);
                        zzg.zzt("P45pDuSCFxliLUZXPnwGJMc6aor1Hy6W6MljaMLINPUk74fzm7mVCel744RvNHnU", "TPzVsbfBdc04crERn4ev6bozRLSTEZrNgI+oWWW2p5k=", Context.class);
                        Class cls = Boolean.TYPE;
                        zzg.zzt("MaMum1gy44m6JY9Yl3WvxKuatqxbLd+TDTFZCPGq8yp5qgeEGUri2jXkJQRPEPHe", "leMw6wdbg7yTx0Ew+oCz/A25ggsdiYC0Nz8e1tg0+qk=", Context.class, cls);
                        zzg.zzt("+uCX0OtEzIVzqgsdxg6723GrXdlyeMM9pbueYGMYyu0H8GGa6rDQ8O4AAKspswZ6", "E+SzUAEY63zbszVCob40KJ+9dmIewoObuvdjjndY+XY=", Context.class);
                        zzg.zzt("W3XZxcuCkVWMGpB7rckmrrZNc8kIRKZXHq2IDWH2bOmQhacxUDxUUq9zi2tOIl+6", "TZLhLjkSWa88s5Ub32Va4FnAdRMP/dTQp+jLbB+9PU0=", Context.class);
                        zzg.zzt("/B1YCWUgqT50g4+pIaGkIfc8sozI9S4hrFa6E+GipkwNaEJ+dAcpiiBy9X1FRO7k", "DBXzOY19V/PBycE+20z1TXhbkhRnxXVhJX0P/QOgZMQ=", MotionEvent.class, DisplayMetrics.class);
                        zzg.zzt("6IEdtyxtLHwQ4VrfZ9FeCKXP/aP8l8OcsmRcYSdTi2JmfIxazq45FzX1HGkFEJgb", "ScPYVWHkyWrhYKkYpKqrVrn2H6TpKiDLxnPESxYOr/U=", MotionEvent.class, DisplayMetrics.class);
                        zzg.zzt("NMP1pkZrrrrQ0P+ZBWjqO+z0j/WpBuzawmkUKjAkUeiPRyMNSyS1dkwhVpRyfOJm", "AZMD/mGrEYmMNAgrqG/aC8rQLooaM7BFn42uxO3SldA=", new Class[0]);
                        zzg.zzt("pFqkMlhSSaQ2eu0bhmIAWpk2TrQlPQpWFME4RoGI1ncpKXXKi44CuFe8cYNKvx1r", "fb3OlLRM7e1GWXw1pgCRp7yxLrLt+HeY8mbhCjTXXm8=", new Class[0]);
                        zzg.zzt("2m6PXcXEiAGusXS1ajjgFu9K1U9p6obL/gDG6se9LFdmc45IuOdD+G2rJwfF1UCD", "fUXpTL496nlEwFWDjJss3QGGSMP1brRky/zh6LpetKA=", new Class[0]);
                        zzg.zzt("iZXNXN9xUbn1GVaYCV3sL1wKWUe/HGVr+Kc3Vh94EyUz5Y8L5QIgpXYgDdLj2Tdj", "bBmsyCj4vQqoPhkiTKWAfAhlVNxJgrtws7pZHadifrc=", new Class[0]);
                        zzg.zzt("fbH/fa1wW07iSX89yPc9WELG9OXmO7CRAKCAHB+qo5oZEtCfcaUJh4I9rxcwLdCb", "uNsygnspdKDmMOnOPr9Pza3D3EK7R75fzmNVkfwdpkg=", new Class[0]);
                        zzg.zzt("HSZqqXAvfM6p9uyg5JhDHQlMlgQJzMAOkGc0u97KAICZfvxto4YfGWg7De8vgAj2", "daqH0kaQsjOZO0MCcjtalDHoDE4Fma0yQGSHO+ub6NM=", new Class[0]);
                        zzg.zzt("jrfJs+Yxsv/gGQ+cGnmY8EkHVJn84HokHsebN4IZy0eeE0ECK9wrDY7bM1U167G5", "b0nnYr5Y43sLp9uCG6eLzyBhSsauFEDPWpaZrhJ4ttc=", Context.class, cls, String.class);
                        zzg.zzt("qzPpYppPAZhPHZoGToPEj4gLCkf1GlGnviIXlGI2ic/egZu+qobDN2aG3wSrxpBD", "7Q6sBeEdJYI+qvX8cIFUZRRQ8J+ckQm34FYdYCYSS2Q=", StackTraceElement[].class);
                        zzg.zzt("ZCuJ2BZ9pjX66HItj5rJVOE3CFRvMlTjLwpTXK/hjirliOmVxPsb2SejOT7YbM4P", "ALSn7l1sKMxPVb0fohyyuRzRspt/TYmvV6oorF8J62I=", View.class, DisplayMetrics.class, cls, cls);
                        zzg.zzt("A7zcecnbEz2swWqo3WVKoAX31f8JEZNN1OTPmTjY02NSqN3cKNpjtt6CyXhCVvfg", "7m0w40FyWBTdaJl9AjXhb9wQqUd7oM1ZB0Gz0iv7tis=", Context.class, cls);
                        zzg.zzt("oOIFXcRPpX8LfJq50/GOu7yJ8Zd8cAWeHAa6OVB78FPJKt0W3zZLCFS9LAEUOvnB", "IY/8616zaYO0dHl/DcP0mMorHg57Bu7A3dpF1R9ox9k=", View.class, Activity.class, cls);
                        zzg.zzt("PS6o831i8V9Lqz6DDKDQ5j6oWxrwGrfC/yamzdSOhnJm7ZWz/0eC/urrTkyk/1l+", "xYPp9mA9NiiAUtoW1mf06CeivM3OQ2f/EXuQXBQemfo=", Long.TYPE);
                        zzg.zzt("lLEcLen4XJo/9ctFaIvSh5tcVBsSnbqu0rI+2Kifyh1W1KyZ3vLik/Ze/ZMY2qUv", "//DjFwPNWi1x71lk0qWorofqZI5qNKPVeYTJHiqA44Q=", new Class[0]);
                        try {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcX)).booleanValue()) {
                                zzg.zzt("IXWwWv5JK/+sPkAKl3c1KDv4Hvk1BPLRteoZBxJagTzyJxEU8SumoR58fR6LdW3i", "Et5K8MZEoJYE/LdMCgxh0i7wX7GVWBBs6Isd533FNz4=", Context.class);
                            }
                        } catch (IllegalStateException unused2) {
                        }
                        zzg.zzt("GBoHIt4qH+zmJyaW5BZWQ7iRD7GYoT7M+/aEI0FfH/dxT5tj7qiY2LySo84L4bT+", "V4g/Ba6gBXaRd5ZffRmw+I91AzQgJ5Lh37aLVyVGSOY=", Context.class);
                        try {
                            if (Build.VERSION.SDK_INT >= 26) {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcZ)).booleanValue()) {
                                    Class cls2 = Long.TYPE;
                                    zzg.zzt("hDi2yHM1WBnaBo8xfxWY0dwLv3vkmI37udU/dWBh2W+Ynkfo3oZQp4Q+03pBto4q", "2+LdC0cYaqAwYHmCPPvRLMkFDbEQiwTEweQcBW/SUlU=", NetworkCapabilities.class, cls2, cls2);
                                }
                            }
                        } catch (IllegalStateException unused3) {
                        }
                        try {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcr)).booleanValue()) {
                                zzg.zzt("bdLwb+FSMvnkuJhbzKDCMXfu1B/xx4c1DUAXM+xzbUjcDvNDxjFjT1GT/o1T/BYK", "os/73Qwr79ouqjFLpLjJlgtKKsT75hksFSajjoaerIA=", List.class);
                            }
                        } catch (IllegalStateException unused4) {
                        }
                        try {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
                                Class cls3 = Long.TYPE;
                                zzg.zzt("gO/haGNVF7sBb6Dp7iKXhg7Swim1l/GlLybMc7sdMRAQTJzM+NV+MpiqlcqP3EHg", "3QFFvrLAbfvZBnCmYb/H5Zm44EsMhBJStIcWOORiyIo=", cls3, cls3, cls3, cls3);
                            }
                        } catch (IllegalStateException unused5) {
                        }
                        try {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzco)).booleanValue()) {
                                zzg.zzt("8A6/EDFVHoT40S+hatGoptnyThtgSNe3d9RgnDPM1sB7IlgQEsqPlgL1Jhl6dC4s", "93eE6DMOIbdNN+XzPfwTeV3VtXW82G23sIL9X3G1CFc=", long[].class, Context.class, View.class);
                            }
                        } catch (IllegalStateException unused6) {
                        }
                    }
                    zzaqp.zza = zzg;
                }
            }
        }
        return zzaqp.zza;
    }

    static zzarv zzm(zzart zzartVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zzarj {
        Method zzj = zzartVar.zzj("/B1YCWUgqT50g4+pIaGkIfc8sozI9S4hrFa6E+GipkwNaEJ+dAcpiiBy9X1FRO7k", "DBXzOY19V/PBycE+20z1TXhbkhRnxXVhJX0P/QOgZMQ=");
        if (zzj != null && motionEvent != null) {
            try {
                return new zzarv((String) zzj.invoke(null, motionEvent, displayMetrics));
            } catch (IllegalAccessException | InvocationTargetException e4) {
                throw new zzarj(e4);
            }
        }
        throw new zzarj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void zzr(Context context, boolean z3) {
        synchronized (zzaqq.class) {
            if (!zzt) {
                zzy = System.currentTimeMillis() / 1000;
                zzaqp.zza = zzj(context, z3);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcZ)).booleanValue()) {
                    zzz = zzaqw.zzc(context);
                }
                ExecutorService zzk = zzaqp.zza.zzk();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzda)).booleanValue() && zzk != null) {
                    zzA = zzasc.zzd(context, zzk);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
                    zzB = new zzaru();
                }
                zzt = true;
            }
        }
    }

    protected static final void zzs(List list) {
        ExecutorService zzk;
        if (zzaqp.zza != null && (zzk = zzaqp.zza.zzk()) != null && !list.isEmpty()) {
            try {
                zzk.invokeAll(list, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzck)).longValue(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e4) {
                StringWriter stringWriter = new StringWriter();
                e4.printStackTrace(new PrintWriter(stringWriter));
                String.format("class methods got exception: %s", stringWriter.toString());
            }
        }
    }

    private final synchronized void zzt(zzart zzartVar, zzanq zzanqVar) {
        Long l4;
        int i4;
        MotionEvent motionEvent;
        try {
            zzarv zzm = zzm(zzartVar, this.zzb, this.zzq);
            Long l5 = zzm.zza;
            if (l5 != null) {
                zzanqVar.zzN(l5.longValue());
            }
            Long l6 = zzm.zzb;
            if (l6 != null) {
                zzanqVar.zzO(l6.longValue());
            }
            Long l7 = zzm.zzc;
            if (l7 != null) {
                zzanqVar.zzL(l7.longValue());
            }
            if (this.zzp) {
                Long l8 = zzm.zzd;
                if (l8 != null) {
                    zzanqVar.zzK(l8.longValue());
                }
                Long l9 = zzm.zze;
                if (l9 != null) {
                    zzanqVar.zzH(l9.longValue());
                }
            }
        } catch (zzarj unused) {
        }
        zzaoj zza = zzaok.zza();
        int i5 = 1;
        if (this.zzd > 0 && zzarw.zze(this.zzq)) {
            zza.zzd(zzarw.zza(this.zzk, 1, this.zzq));
            zza.zzq(zzarw.zza(this.zzn - this.zzl, 1, this.zzq));
            zza.zzr(zzarw.zza(this.zzo - this.zzm, 1, this.zzq));
            zza.zzj(zzarw.zza(this.zzl, 1, this.zzq));
            zza.zzl(zzarw.zza(this.zzm, 1, this.zzq));
            if (this.zzp && (motionEvent = this.zzb) != null) {
                long zza2 = zzarw.zza(((this.zzl - this.zzn) + motionEvent.getRawX()) - this.zzb.getX(), 1, this.zzq);
                if (zza2 != 0) {
                    zza.zzo(zza2);
                }
                long zza3 = zzarw.zza(((this.zzm - this.zzo) + this.zzb.getRawY()) - this.zzb.getY(), 1, this.zzq);
                if (zza3 != 0) {
                    zza.zzp(zza3);
                }
            }
        }
        try {
            zzarv zzi = zzi(this.zzb);
            Long l10 = zzi.zza;
            if (l10 != null) {
                zza.zzk(l10.longValue());
            }
            Long l11 = zzi.zzb;
            if (l11 != null) {
                zza.zzm(l11.longValue());
            }
            zza.zzi(zzi.zzc.longValue());
            if (this.zzp) {
                Long l12 = zzi.zze;
                if (l12 != null) {
                    zza.zzg(l12.longValue());
                }
                Long l13 = zzi.zzd;
                if (l13 != null) {
                    zza.zzh(l13.longValue());
                }
                Long l14 = zzi.zzf;
                if (l14 != null) {
                    if (l14.longValue() != 0) {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    zza.zzt(i4);
                }
                if (this.zze > 0) {
                    if (zzarw.zze(this.zzq)) {
                        l4 = Long.valueOf(Math.round(this.zzj / this.zze));
                    } else {
                        l4 = null;
                    }
                    if (l4 != null) {
                        zza.zzb(l4.longValue());
                    } else {
                        zza.zza();
                    }
                    zza.zzc(Math.round(this.zzi / this.zze));
                }
                Long l15 = zzi.zzi;
                if (l15 != null) {
                    zza.zze(l15.longValue());
                }
                Long l16 = zzi.zzj;
                if (l16 != null) {
                    zza.zzn(l16.longValue());
                }
                Long l17 = zzi.zzk;
                if (l17 != null) {
                    if (l17.longValue() != 0) {
                        i5 = 2;
                    }
                    zza.zzs(i5);
                }
            }
        } catch (zzarj unused2) {
        }
        long j4 = this.zzh;
        if (j4 > 0) {
            zza.zzf(j4);
        }
        zzanqVar.zzR((zzaok) zza.zzal());
        long j5 = this.zzd;
        if (j5 > 0) {
            zzanqVar.zzI(j5);
        }
        long j6 = this.zze;
        if (j6 > 0) {
            zzanqVar.zzJ(j6);
        }
        long j7 = this.zzf;
        if (j7 > 0) {
            zzanqVar.zzM(j7);
        }
        long j8 = this.zzg;
        if (j8 > 0) {
            zzanqVar.zzG(j8);
        }
        try {
            int size = this.zzc.size() - 1;
            if (size > 0) {
                zzanqVar.zzb();
                for (int i6 = 0; i6 < size; i6++) {
                    zzarv zzm2 = zzm(zzaqp.zza, (MotionEvent) this.zzc.get(i6), this.zzq);
                    zzaoj zza4 = zzaok.zza();
                    zza4.zzk(zzm2.zza.longValue());
                    zza4.zzm(zzm2.zzb.longValue());
                    zzanqVar.zza((zzaok) zza4.zzal());
                }
            }
        } catch (zzarj unused3) {
            zzanqVar.zzb();
        }
    }

    private static final void zzu() {
        zzasc zzascVar = zzA;
        if (zzascVar != null) {
            zzascVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    protected final long zza(StackTraceElement[] stackTraceElementArr) throws zzarj {
        Method zzj = zzaqp.zza.zzj("qzPpYppPAZhPHZoGToPEj4gLCkf1GlGnviIXlGI2ic/egZu+qobDN2aG3wSrxpBD", "7Q6sBeEdJYI+qvX8cIFUZRRQ8J+ckQm34FYdYCYSS2Q=");
        if (zzj != null && stackTraceElementArr != null) {
            try {
                return new zzark((String) zzj.invoke(null, stackTraceElementArr)).zza.longValue();
            } catch (IllegalAccessException | InvocationTargetException e4) {
                throw new zzarj(e4);
            }
        }
        throw new zzarj();
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    protected final zzanq zzb(Context context, View view, Activity activity) {
        zzu();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
            zzB.zzi();
        }
        zzanq zza = zzaon.zza();
        if (!TextUtils.isEmpty(this.zzv)) {
            zza.zzh(this.zzv);
        }
        zzq(zzj(context, this.zzu), zza, view, activity, true, context);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    protected final zzanq zzc(Context context, zzanj zzanjVar) {
        zzu();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
            zzB.zzj();
        }
        zzanq zza = zzaon.zza();
        if (!TextUtils.isEmpty(this.zzv)) {
            zza.zzh(this.zzv);
        }
        zzart zzj = zzj(context, this.zzu);
        if (zzj.zzk() != null) {
            zzs(zzp(zzj, context, zza, null));
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    protected final zzanq zzd(Context context, View view, Activity activity) {
        zzu();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
            zzB.zzk(context, view);
        }
        zzanq zza = zzaon.zza();
        zza.zzh(this.zzv);
        zzq(zzj(context, this.zzu), zza, view, activity, false, context);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    protected final zzarv zzi(MotionEvent motionEvent) throws zzarj {
        Method zzj = zzaqp.zza.zzj("6IEdtyxtLHwQ4VrfZ9FeCKXP/aP8l8OcsmRcYSdTi2JmfIxazq45FzX1HGkFEJgb", "ScPYVWHkyWrhYKkYpKqrVrn2H6TpKiDLxnPESxYOr/U=");
        if (zzj != null && motionEvent != null) {
            try {
                return new zzarv((String) zzj.invoke(null, motionEvent, this.zzq));
            } catch (IllegalAccessException | InvocationTargetException e4) {
                throw new zzarj(e4);
            }
        }
        throw new zzarj();
    }

    @Override // com.google.android.gms.internal.ads.zzaqp, com.google.android.gms.internal.ads.zzaqo
    public final void zzo(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcn)).booleanValue()) {
            return;
        }
        if (this.zzw == null) {
            zzart zzartVar = zzaqp.zza;
            this.zzw = new zzasa(zzartVar.zza, zzartVar.zzf());
        }
        this.zzw.zzd(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List zzp(zzart zzartVar, Context context, zzanq zzanqVar, zzanj zzanjVar) {
        long j4;
        long j5;
        int zza = zzartVar.zza();
        ArrayList arrayList = new ArrayList();
        if (!zzartVar.zzr()) {
            zzanqVar.zzD(16384L);
            return arrayList;
        }
        arrayList.add(new zzash(zzartVar, "jrfJs+Yxsv/gGQ+cGnmY8EkHVJn84HokHsebN4IZy0eeE0ECK9wrDY7bM1U167G5", "b0nnYr5Y43sLp9uCG6eLzyBhSsauFEDPWpaZrhJ4ttc=", zzanqVar, zza, 27, context, null));
        arrayList.add(new zzask(zzartVar, "NMP1pkZrrrrQ0P+ZBWjqO+z0j/WpBuzawmkUKjAkUeiPRyMNSyS1dkwhVpRyfOJm", "AZMD/mGrEYmMNAgrqG/aC8rQLooaM7BFn42uxO3SldA=", zzanqVar, zzy, zza, 25));
        arrayList.add(new zzasu(zzartVar, "2m6PXcXEiAGusXS1ajjgFu9K1U9p6obL/gDG6se9LFdmc45IuOdD+G2rJwfF1UCD", "fUXpTL496nlEwFWDjJss3QGGSMP1brRky/zh6LpetKA=", zzanqVar, zza, 1));
        arrayList.add(new zzasx(zzartVar, "kG8kAzeUJFSjvYuRDtJkr7owBxy52vKH1yfYPq05BRQDWSz1Oa+VomdlwOHttvWk", "SXEqPPoGCAhkrwWNonsWzEV+zX6m6TBLFFDVOqk+hqA=", zzanqVar, zza, 31, context));
        arrayList.add(new zzatc(zzartVar, "pFqkMlhSSaQ2eu0bhmIAWpk2TrQlPQpWFME4RoGI1ncpKXXKi44CuFe8cYNKvx1r", "fb3OlLRM7e1GWXw1pgCRp7yxLrLt+HeY8mbhCjTXXm8=", zzanqVar, zza, 33));
        arrayList.add(new zzasg(zzartVar, "x244HDzWeCJXpaVmJz6ZDJ8SomiOjqvEXNm93LF/UprnziaRy0GWl7kRtW31unI7", "QfNmx51vMYu7RTw3f+TZAS23f16Jqr3kM4ALSpqOw0Y=", zzanqVar, zza, 29, context));
        arrayList.add(new zzasi(zzartVar, "61r5RjlUpp0Sx9otiMiZNQFewfAHPXct4XNb20i2Qy085lteyha1wknNg1lweS6E", "BxKk+MigL5QcJoHkNRs0ALc6QE50Izh8oVpecosSZ5s=", zzanqVar, zza, 5));
        arrayList.add(new zzast(zzartVar, "P45pDuSCFxliLUZXPnwGJMc6aor1Hy6W6MljaMLINPUk74fzm7mVCel744RvNHnU", "TPzVsbfBdc04crERn4ev6bozRLSTEZrNgI+oWWW2p5k=", zzanqVar, zza, 12));
        arrayList.add(new zzasv(zzartVar, "MaMum1gy44m6JY9Yl3WvxKuatqxbLd+TDTFZCPGq8yp5qgeEGUri2jXkJQRPEPHe", "leMw6wdbg7yTx0Ew+oCz/A25ggsdiYC0Nz8e1tg0+qk=", zzanqVar, zza, 3));
        arrayList.add(new zzasj(zzartVar, "iZXNXN9xUbn1GVaYCV3sL1wKWUe/HGVr+Kc3Vh94EyUz5Y8L5QIgpXYgDdLj2Tdj", "bBmsyCj4vQqoPhkiTKWAfAhlVNxJgrtws7pZHadifrc=", zzanqVar, zza, 44));
        arrayList.add(new zzasp(zzartVar, "fbH/fa1wW07iSX89yPc9WELG9OXmO7CRAKCAHB+qo5oZEtCfcaUJh4I9rxcwLdCb", "uNsygnspdKDmMOnOPr9Pza3D3EK7R75fzmNVkfwdpkg=", zzanqVar, zza, 22));
        arrayList.add(new zzatd(zzartVar, "+uCX0OtEzIVzqgsdxg6723GrXdlyeMM9pbueYGMYyu0H8GGa6rDQ8O4AAKspswZ6", "E+SzUAEY63zbszVCob40KJ+9dmIewoObuvdjjndY+XY=", zzanqVar, zza, 48));
        arrayList.add(new zzasf(zzartVar, "W3XZxcuCkVWMGpB7rckmrrZNc8kIRKZXHq2IDWH2bOmQhacxUDxUUq9zi2tOIl+6", "TZLhLjkSWa88s5Ub32Va4FnAdRMP/dTQp+jLbB+9PU0=", zzanqVar, zza, 49));
        arrayList.add(new zzata(zzartVar, "HSZqqXAvfM6p9uyg5JhDHQlMlgQJzMAOkGc0u97KAICZfvxto4YfGWg7De8vgAj2", "daqH0kaQsjOZO0MCcjtalDHoDE4Fma0yQGSHO+ub6NM=", zzanqVar, zza, 51));
        arrayList.add(new zzasy(zzartVar, "A7zcecnbEz2swWqo3WVKoAX31f8JEZNN1OTPmTjY02NSqN3cKNpjtt6CyXhCVvfg", "7m0w40FyWBTdaJl9AjXhb9wQqUd7oM1ZB0Gz0iv7tis=", zzanqVar, zza, 61));
        if (Build.VERSION.SDK_INT >= 24) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcZ)).booleanValue()) {
                zzasc zzascVar = zzA;
                if (zzascVar != null) {
                    j4 = zzascVar.zzc();
                    j5 = zzascVar.zzb();
                } else {
                    j4 = -1;
                    j5 = -1;
                }
                arrayList.add(new zzass(zzartVar, "hDi2yHM1WBnaBo8xfxWY0dwLv3vkmI37udU/dWBh2W+Ynkfo3oZQp4Q+03pBto4q", "2+LdC0cYaqAwYHmCPPvRLMkFDbEQiwTEweQcBW/SUlU=", zzanqVar, zza, 11, zzz, j4, j5));
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcX)).booleanValue()) {
            arrayList.add(new zzasw(zzartVar, "IXWwWv5JK/+sPkAKl3c1KDv4Hvk1BPLRteoZBxJagTzyJxEU8SumoR58fR6LdW3i", "Et5K8MZEoJYE/LdMCgxh0i7wX7GVWBBs6Isd533FNz4=", zzanqVar, zza, 73));
        }
        arrayList.add(new zzasq(zzartVar, "GBoHIt4qH+zmJyaW5BZWQ7iRD7GYoT7M+/aEI0FfH/dxT5tj7qiY2LySo84L4bT+", "V4g/Ba6gBXaRd5ZffRmw+I91AzQgJ5Lh37aLVyVGSOY=", zzanqVar, zza, 76));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdc)).booleanValue()) {
            arrayList.add(new zzase(zzartVar, "lLEcLen4XJo/9ctFaIvSh5tcVBsSnbqu0rI+2Kifyh1W1KyZ3vLik/Ze/ZMY2qUv", "//DjFwPNWi1x71lk0qWorofqZI5qNKPVeYTJHiqA44Q=", zzanqVar, zza, 89));
        }
        return arrayList;
    }

    protected final void zzq(zzart zzartVar, zzanq zzanqVar, View view, Activity activity, boolean z3, Context context) {
        List list;
        if (!zzartVar.zzr()) {
            zzanqVar.zzD(16384L);
            list = Arrays.asList(new zzasm(zzartVar, zzanqVar));
        } else {
            zzt(zzartVar, zzanqVar);
            ArrayList arrayList = new ArrayList();
            if (zzartVar.zzk() != null) {
                int zza = zzartVar.zza();
                arrayList.add(new zzasm(zzartVar, zzanqVar));
                arrayList.add(new zzasu(zzartVar, "2m6PXcXEiAGusXS1ajjgFu9K1U9p6obL/gDG6se9LFdmc45IuOdD+G2rJwfF1UCD", "fUXpTL496nlEwFWDjJss3QGGSMP1brRky/zh6LpetKA=", zzanqVar, zza, 1));
                arrayList.add(new zzask(zzartVar, "NMP1pkZrrrrQ0P+ZBWjqO+z0j/WpBuzawmkUKjAkUeiPRyMNSyS1dkwhVpRyfOJm", "AZMD/mGrEYmMNAgrqG/aC8rQLooaM7BFn42uxO3SldA=", zzanqVar, zzy, zza, 25));
                arrayList.add(new zzasj(zzartVar, "iZXNXN9xUbn1GVaYCV3sL1wKWUe/HGVr+Kc3Vh94EyUz5Y8L5QIgpXYgDdLj2Tdj", "bBmsyCj4vQqoPhkiTKWAfAhlVNxJgrtws7pZHadifrc=", zzanqVar, zza, 44));
                arrayList.add(new zzast(zzartVar, "P45pDuSCFxliLUZXPnwGJMc6aor1Hy6W6MljaMLINPUk74fzm7mVCel744RvNHnU", "TPzVsbfBdc04crERn4ev6bozRLSTEZrNgI+oWWW2p5k=", zzanqVar, zza, 12));
                arrayList.add(new zzasv(zzartVar, "MaMum1gy44m6JY9Yl3WvxKuatqxbLd+TDTFZCPGq8yp5qgeEGUri2jXkJQRPEPHe", "leMw6wdbg7yTx0Ew+oCz/A25ggsdiYC0Nz8e1tg0+qk=", zzanqVar, zza, 3));
                arrayList.add(new zzasp(zzartVar, "fbH/fa1wW07iSX89yPc9WELG9OXmO7CRAKCAHB+qo5oZEtCfcaUJh4I9rxcwLdCb", "uNsygnspdKDmMOnOPr9Pza3D3EK7R75fzmNVkfwdpkg=", zzanqVar, zza, 22));
                arrayList.add(new zzasi(zzartVar, "61r5RjlUpp0Sx9otiMiZNQFewfAHPXct4XNb20i2Qy085lteyha1wknNg1lweS6E", "BxKk+MigL5QcJoHkNRs0ALc6QE50Izh8oVpecosSZ5s=", zzanqVar, zza, 5));
                arrayList.add(new zzatd(zzartVar, "+uCX0OtEzIVzqgsdxg6723GrXdlyeMM9pbueYGMYyu0H8GGa6rDQ8O4AAKspswZ6", "E+SzUAEY63zbszVCob40KJ+9dmIewoObuvdjjndY+XY=", zzanqVar, zza, 48));
                arrayList.add(new zzasf(zzartVar, "W3XZxcuCkVWMGpB7rckmrrZNc8kIRKZXHq2IDWH2bOmQhacxUDxUUq9zi2tOIl+6", "TZLhLjkSWa88s5Ub32Va4FnAdRMP/dTQp+jLbB+9PU0=", zzanqVar, zza, 49));
                arrayList.add(new zzata(zzartVar, "HSZqqXAvfM6p9uyg5JhDHQlMlgQJzMAOkGc0u97KAICZfvxto4YfGWg7De8vgAj2", "daqH0kaQsjOZO0MCcjtalDHoDE4Fma0yQGSHO+ub6NM=", zzanqVar, zza, 51));
                arrayList.add(new zzasz(zzartVar, "qzPpYppPAZhPHZoGToPEj4gLCkf1GlGnviIXlGI2ic/egZu+qobDN2aG3wSrxpBD", "7Q6sBeEdJYI+qvX8cIFUZRRQ8J+ckQm34FYdYCYSS2Q=", zzanqVar, zza, 45, new Throwable().getStackTrace()));
                arrayList.add(new zzate(zzartVar, "ZCuJ2BZ9pjX66HItj5rJVOE3CFRvMlTjLwpTXK/hjirliOmVxPsb2SejOT7YbM4P", "ALSn7l1sKMxPVb0fohyyuRzRspt/TYmvV6oorF8J62I=", zzanqVar, zza, 57, view));
                arrayList.add(new zzasy(zzartVar, "A7zcecnbEz2swWqo3WVKoAX31f8JEZNN1OTPmTjY02NSqN3cKNpjtt6CyXhCVvfg", "7m0w40FyWBTdaJl9AjXhb9wQqUd7oM1ZB0Gz0iv7tis=", zzanqVar, zza, 61));
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcl)).booleanValue()) {
                    arrayList.add(new zzasd(zzartVar, "oOIFXcRPpX8LfJq50/GOu7yJ8Zd8cAWeHAa6OVB78FPJKt0W3zZLCFS9LAEUOvnB", "IY/8616zaYO0dHl/DcP0mMorHg57Bu7A3dpF1R9ox9k=", zzanqVar, zza, 62, view, activity));
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdc)).booleanValue()) {
                    arrayList.add(new zzase(zzartVar, "lLEcLen4XJo/9ctFaIvSh5tcVBsSnbqu0rI+2Kifyh1W1KyZ3vLik/Ze/ZMY2qUv", "//DjFwPNWi1x71lk0qWorofqZI5qNKPVeYTJHiqA44Q=", zzanqVar, zza, 89));
                }
                if (z3) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcn)).booleanValue()) {
                        arrayList.add(new zzatb(zzartVar, "PS6o831i8V9Lqz6DDKDQ5j6oWxrwGrfC/yamzdSOhnJm7ZWz/0eC/urrTkyk/1l+", "xYPp9mA9NiiAUtoW1mf06CeivM3OQ2f/EXuQXBQemfo=", zzanqVar, zza, 53, this.zzw));
                    }
                } else {
                    try {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzco)).booleanValue()) {
                            arrayList.add(new zzaso(zzartVar, "8A6/EDFVHoT40S+hatGoptnyThtgSNe3d9RgnDPM1sB7IlgQEsqPlgL1Jhl6dC4s", "93eE6DMOIbdNN+XzPfwTeV3VtXW82G23sIL9X3G1CFc=", zzanqVar, zza, 85, this.zzC, view, context));
                        }
                    } catch (IllegalStateException unused) {
                    }
                    try {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcp)).booleanValue()) {
                            arrayList.add(new zzasn(zzartVar, "gO/haGNVF7sBb6Dp7iKXhg7Swim1l/GlLybMc7sdMRAQTJzM+NV+MpiqlcqP3EHg", "3QFFvrLAbfvZBnCmYb/H5Zm44EsMhBJStIcWOORiyIo=", zzanqVar, zza, 85, zzB));
                        }
                    } catch (IllegalStateException unused2) {
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcr)).booleanValue()) {
                        arrayList.add(new zzasr(zzartVar, "bdLwb+FSMvnkuJhbzKDCMXfu1B/xx4c1DUAXM+xzbUjcDvNDxjFjT1GT/o1T/BYK", "os/73Qwr79ouqjFLpLjJlgtKKsT75hksFSajjoaerIA=", zzanqVar, zza, 94, this.zzr));
                    }
                }
            }
            list = arrayList;
        }
        zzs(list);
    }
}
