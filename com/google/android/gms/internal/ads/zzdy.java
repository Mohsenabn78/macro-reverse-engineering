package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdy {
    @Pure
    public static int zza(int i4, int i5, int i6) {
        if (i4 >= 0 && i4 < i6) {
            return i4;
        }
        throw new IndexOutOfBoundsException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static Object zzb(@Nullable Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static String zzc(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    @Pure
    public static void zzd(boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException();
    }

    @Pure
    public static void zze(boolean z3, Object obj) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException((String) obj);
    }

    @Pure
    public static void zzf(boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalStateException();
    }
}
