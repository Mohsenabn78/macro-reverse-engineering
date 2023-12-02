package com.google.android.gms.internal.ads;

import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfuk extends zzful {
    public static int zza(long j4) {
        int i4 = (int) j4;
        if (i4 == j4) {
            return i4;
        }
        throw new IllegalArgumentException(zzfpw.zzb("Out of range: %s", Long.valueOf(j4)));
    }

    public static int zzb(int i4, int i5, int i6) {
        return Math.min(Math.max(i4, i5), (int) LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    public static int zzc(long j4) {
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j4 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j4;
    }
}
