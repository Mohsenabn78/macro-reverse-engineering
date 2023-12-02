package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfrm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i4) {
        int i5;
        if (i4 < 32) {
            i5 = 4;
        } else {
            i5 = 2;
        }
        return i5 * (i4 + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(@CheckForNull Object obj, @CheckForNull Object obj2, int i4, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int i5;
        int i6;
        int zzb = zzfru.zzb(obj);
        int i7 = zzb & i4;
        int zzc = zzc(obj3, i7);
        if (zzc != 0) {
            int i8 = ~i4;
            int i9 = zzb & i8;
            int i10 = -1;
            while (true) {
                i5 = zzc - 1;
                i6 = iArr[i5];
                if ((i6 & i8) != i9 || !zzfpc.zza(obj, objArr[i5]) || (objArr2 != null && !zzfpc.zza(obj2, objArr2[i5]))) {
                    int i11 = i6 & i4;
                    if (i11 == 0) {
                        break;
                    }
                    i10 = i5;
                    zzc = i11;
                }
            }
            int i12 = i6 & i4;
            if (i10 == -1) {
                zze(obj3, i7, i12);
            } else {
                iArr[i10] = (i12 & i4) | (iArr[i10] & i8);
            }
            return i5;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(Object obj, int i4) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i4] & 255;
        }
        if (obj instanceof short[]) {
            return (char) ((short[]) obj)[i4];
        }
        return ((int[]) obj)[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzd(int i4) {
        if (i4 >= 2 && i4 <= 1073741824 && Integer.highestOneBit(i4) == i4) {
            if (i4 <= 256) {
                return new byte[i4];
            }
            if (i4 <= 65536) {
                return new short[i4];
            }
            return new int[i4];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zze(Object obj, int i4, int i5) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i4] = (byte) i5;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i4] = (short) i5;
        } else {
            ((int[]) obj)[i4] = i5;
        }
    }
}
