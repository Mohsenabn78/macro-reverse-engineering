package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfph {
    public static int zza(int i4, int i5, String str) {
        String zzb;
        if (i4 >= 0 && i4 < i5) {
            return i4;
        }
        if (i4 >= 0) {
            if (i5 < 0) {
                throw new IllegalArgumentException("negative size: " + i5);
            }
            zzb = zzfpw.zzb("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i4), Integer.valueOf(i5));
        } else {
            zzb = zzfpw.zzb("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(zzb);
    }

    public static int zzb(int i4, int i5, String str) {
        if (i4 >= 0 && i4 <= i5) {
            return i4;
        }
        throw new IndexOutOfBoundsException(zzj(i4, i5, FirebaseAnalytics.Param.INDEX));
    }

    public static Object zzc(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static Object zzd(@CheckForNull Object obj, String str, @CheckForNull Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(zzfpw.zzb(str, obj2));
    }

    public static void zze(boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void zzf(boolean z3, @CheckForNull Object obj) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException((String) obj);
    }

    public static void zzg(int i4, int i5, int i6) {
        String zzj;
        if (i4 >= 0 && i5 >= i4 && i5 <= i6) {
            return;
        }
        if (i4 >= 0 && i4 <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                zzj = zzfpw.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
            } else {
                zzj = zzj(i5, i6, "end index");
            }
        } else {
            zzj = zzj(i4, i6, "start index");
        }
        throw new IndexOutOfBoundsException(zzj);
    }

    public static void zzh(boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalStateException();
    }

    public static void zzi(boolean z3, @CheckForNull Object obj) {
        if (z3) {
            return;
        }
        throw new IllegalStateException((String) obj);
    }

    private static String zzj(int i4, int i5, String str) {
        if (i4 < 0) {
            return zzfpw.zzb("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return zzfpw.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }
}
