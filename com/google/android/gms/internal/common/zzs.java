package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.jspecify.nullness.NullMarked;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@NullMarked
/* loaded from: classes4.dex */
public final class zzs {
    @CanIgnoreReturnValue
    public static int zza(int i4, int i5, String str) {
        String zza;
        if (i4 >= 0 && i4 < i5) {
            return i4;
        }
        if (i4 >= 0) {
            if (i5 < 0) {
                throw new IllegalArgumentException("negative size: " + i5);
            }
            zza = zzy.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i4), Integer.valueOf(i5));
        } else {
            zza = zzy.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    @CanIgnoreReturnValue
    public static int zzb(int i4, int i5, String str) {
        if (i4 >= 0 && i4 <= i5) {
            return i4;
        }
        throw new IndexOutOfBoundsException(zzd(i4, i5, FirebaseAnalytics.Param.INDEX));
    }

    public static void zzc(int i4, int i5, int i6) {
        String zzd;
        if (i4 >= 0 && i5 >= i4 && i5 <= i6) {
            return;
        }
        if (i4 >= 0 && i4 <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                zzd = zzy.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
            } else {
                zzd = zzd(i5, i6, "end index");
            }
        } else {
            zzd = zzd(i4, i6, "start index");
        }
        throw new IndexOutOfBoundsException(zzd);
    }

    private static String zzd(int i4, int i5, String str) {
        if (i4 < 0) {
            return zzy.zza("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return zzy.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }
}
