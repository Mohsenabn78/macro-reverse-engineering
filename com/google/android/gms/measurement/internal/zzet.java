package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpe;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzet extends zzgx {

    /* renamed from: c  reason: collision with root package name */
    private char f21537c;

    /* renamed from: d  reason: collision with root package name */
    private long f21538d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private String f21539e;

    /* renamed from: f  reason: collision with root package name */
    private final zzer f21540f;

    /* renamed from: g  reason: collision with root package name */
    private final zzer f21541g;

    /* renamed from: h  reason: collision with root package name */
    private final zzer f21542h;

    /* renamed from: i  reason: collision with root package name */
    private final zzer f21543i;

    /* renamed from: j  reason: collision with root package name */
    private final zzer f21544j;

    /* renamed from: k  reason: collision with root package name */
    private final zzer f21545k;

    /* renamed from: l  reason: collision with root package name */
    private final zzer f21546l;

    /* renamed from: m  reason: collision with root package name */
    private final zzer f21547m;

    /* renamed from: n  reason: collision with root package name */
    private final zzer f21548n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzet(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21537c = (char) 0;
        this.f21538d = -1L;
        this.f21540f = new zzer(this, 6, false, false);
        this.f21541g = new zzer(this, 6, true, false);
        this.f21542h = new zzer(this, 6, false, true);
        this.f21543i = new zzer(this, 5, false, false);
        this.f21544j = new zzer(this, 5, true, false);
        this.f21545k = new zzer(this, 5, false, true);
        this.f21546l = new zzer(this, 4, false, false);
        this.f21547m = new zzer(this, 3, false, false);
        this.f21548n = new zzer(this, 2, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object f(String str) {
        if (str == null) {
            return null;
        }
        return new zzes(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(boolean z3, String str, Object obj, Object obj2, Object obj3) {
        String h4 = h(z3, obj);
        String h5 = h(z3, obj2);
        String h6 = h(z3, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(h4)) {
            sb.append(str2);
            sb.append(h4);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(h5)) {
            sb.append(str2);
            sb.append(h5);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(h6)) {
            sb.append(str3);
            sb.append(h6);
        }
        return sb.toString();
    }

    @VisibleForTesting
    static String h(boolean z3, Object obj) {
        String str;
        String th;
        String className;
        String str2 = "";
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i4 = 0;
        if (obj instanceof Long) {
            if (!z3) {
                return obj.toString();
            }
            Long l4 = (Long) obj;
            if (Math.abs(l4.longValue()) < 100) {
                return obj.toString();
            }
            char charAt = obj.toString().charAt(0);
            String valueOf = String.valueOf(Math.abs(l4.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder();
            if (charAt == '-') {
                str2 = "-";
            }
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return obj.toString();
        } else {
            if (obj instanceof Throwable) {
                Throwable th2 = (Throwable) obj;
                if (z3) {
                    th = th2.getClass().getName();
                } else {
                    th = th2.toString();
                }
                StringBuilder sb2 = new StringBuilder(th);
                String i5 = i(zzgd.class.getCanonicalName());
                StackTraceElement[] stackTrace = th2.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i4];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && i(className).equals(i5)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i4++;
                }
                return sb2.toString();
            } else if (obj instanceof zzes) {
                str = ((zzes) obj).f21536a;
                return str;
            } else if (z3) {
                return "-";
            } else {
                return obj.toString();
            }
        }
    }

    @VisibleForTesting
    static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            zzpe.zzc();
            if (((Boolean) zzeg.zzay.zza(null)).booleanValue()) {
                return "";
            }
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    protected final boolean b() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(int i4, boolean z3, boolean z4, String str, Object obj, Object obj2, Object obj3) {
        int i5;
        if (!z3 && Log.isLoggable(zzr(), i4)) {
            Log.println(i4, zzr(), g(false, str, obj, obj2, obj3));
        }
        if (!z4 && i4 >= 5) {
            Preconditions.checkNotNull(str);
            zzga l4 = this.f21734a.l();
            if (l4 == null) {
                Log.println(6, zzr(), "Scheduler not set. Not logging error/warn");
            } else if (!l4.zzy()) {
                Log.println(6, zzr(), "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i4 >= 9) {
                    i5 = 8;
                } else {
                    i5 = i4;
                }
                l4.zzp(new zzeq(this, i5, str, obj, obj2, obj3));
            }
        }
    }

    public final zzer zzc() {
        return this.f21547m;
    }

    public final zzer zzd() {
        return this.f21540f;
    }

    public final zzer zze() {
        return this.f21542h;
    }

    public final zzer zzh() {
        return this.f21541g;
    }

    public final zzer zzi() {
        return this.f21546l;
    }

    public final zzer zzj() {
        return this.f21548n;
    }

    public final zzer zzk() {
        return this.f21543i;
    }

    public final zzer zzl() {
        return this.f21545k;
    }

    public final zzer zzm() {
        return this.f21544j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    @VisibleForTesting
    public final String zzr() {
        String str;
        synchronized (this) {
            if (this.f21539e == null) {
                if (this.f21734a.zzy() != null) {
                    this.f21539e = this.f21734a.zzy();
                } else {
                    this.f21539e = this.f21734a.zzf().e();
                }
            }
            Preconditions.checkNotNull(this.f21539e);
            str = this.f21539e;
        }
        return str;
    }
}
