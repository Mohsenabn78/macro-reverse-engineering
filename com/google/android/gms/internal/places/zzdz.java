package com.google.android.gms.internal.places;

import com.google.android.gms.location.places.Place;
import com.google.common.base.Ascii;
import okio.Utf8;

/* loaded from: classes4.dex */
final class zzdz {
    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(byte b4, char[] cArr, int i4) {
        cArr[i4] = (char) b4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zze(byte b4) {
        if (b4 >= 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzf(byte b4) {
        if (b4 < -32) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzg(byte b4) {
        if (b4 < -16) {
            return true;
        }
        return false;
    }

    private static boolean zzh(byte b4) {
        if (b4 > -65) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(byte b4, byte b5, char[] cArr, int i4) throws zzbk {
        if (b4 >= -62 && !zzh(b5)) {
            cArr[i4] = (char) (((b4 & Ascii.US) << 6) | (b5 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw zzbk.zzbu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(byte b4, byte b5, byte b6, char[] cArr, int i4) throws zzbk {
        if (!zzh(b5) && ((b4 != -32 || b5 >= -96) && ((b4 != -19 || b5 < -96) && !zzh(b6)))) {
            cArr[i4] = (char) (((b4 & Ascii.SI) << 12) | ((b5 & Utf8.REPLACEMENT_BYTE) << 6) | (b6 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw zzbk.zzbu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(byte b4, byte b5, byte b6, byte b7, char[] cArr, int i4) throws zzbk {
        if (!zzh(b5) && (((b4 << Ascii.FS) + (b5 + 112)) >> 30) == 0 && !zzh(b6) && !zzh(b7)) {
            int i5 = ((b4 & 7) << 18) | ((b5 & Utf8.REPLACEMENT_BYTE) << 12) | ((b6 & Utf8.REPLACEMENT_BYTE) << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
            cArr[i4] = (char) ((i5 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
            cArr[i4 + 1] = (char) ((i5 & Place.TYPE_SUBLOCALITY_LEVEL_1) + Utf8.LOG_SURROGATE_HEADER);
            return;
        }
        throw zzbk.zzbu();
    }
}
