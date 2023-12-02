package com.google.android.recaptcha.internal;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzdi {
    public static void zza(boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void zzb(boolean z3, @CheckForNull Object obj) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException((String) obj);
    }

    public static void zzc(boolean z3, String str, char c4) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException(zzdl.zza(str, Character.valueOf(c4)));
    }

    public static void zzd(int i4, int i5, int i6) {
        String zzf;
        if (i4 >= 0 && i5 >= i4 && i5 <= i6) {
            return;
        }
        if (i4 >= 0 && i4 <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                zzf = zzdl.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
            } else {
                zzf = zzf(i5, i6, "end index");
            }
        } else {
            zzf = zzf(i4, i6, "start index");
        }
        throw new IndexOutOfBoundsException(zzf);
    }

    public static void zze(boolean z3, @CheckForNull Object obj) {
        if (z3) {
            return;
        }
        throw new IllegalStateException((String) obj);
    }

    private static String zzf(int i4, int i5, String str) {
        if (i4 < 0) {
            return zzdl.zza("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        return zzdl.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
    }
}
