package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzu  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzu {
    public static int zza(int i4, int i5, String str) {
        String zzb;
        if (i4 >= 0 && i4 < i5) {
            return i4;
        }
        if (i4 >= 0) {
            if (i5 < 0) {
                throw new IllegalArgumentException("negative size: " + i5);
            }
            zzb = zzac.zzb("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i4), Integer.valueOf(i5));
        } else {
            zzb = zzac.zzb("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(zzb);
    }

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
                zzd = zzac.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
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
            return zzac.zzb("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return zzac.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }
}
