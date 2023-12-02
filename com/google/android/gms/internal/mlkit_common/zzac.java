package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzac {
    public static int zza(int i4, int i5, String str) {
        String zza;
        if (i4 >= 0 && i4 < i5) {
            return i4;
        }
        if (i4 >= 0) {
            if (i5 < 0) {
                throw new IllegalArgumentException("negative size: " + i5);
            }
            zza = zzad.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i4), Integer.valueOf(i5));
        } else {
            zza = zzad.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i4, int i5, String str) {
        if (i4 >= 0 && i4 <= i5) {
            return i4;
        }
        throw new IndexOutOfBoundsException(zze(i4, i5, FirebaseAnalytics.Param.INDEX));
    }

    public static void zzc(int i4, int i5, int i6) {
        String zze;
        if (i4 >= 0 && i5 >= i4 && i5 <= i6) {
            return;
        }
        if (i4 >= 0 && i4 <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                zze = zzad.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
            } else {
                zze = zze(i5, i6, "end index");
            }
        } else {
            zze = zze(i4, i6, "start index");
        }
        throw new IndexOutOfBoundsException(zze);
    }

    public static void zzd(boolean z3, @CheckForNull Object obj) {
        if (z3) {
            return;
        }
        throw new IllegalStateException("A SourcePolicy can only set internal() or external() once.");
    }

    private static String zze(int i4, int i5, String str) {
        if (i4 < 0) {
            return zzad.zza("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return zzad.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }
}
