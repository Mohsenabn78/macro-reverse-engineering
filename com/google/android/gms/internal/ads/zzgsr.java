package com.google.android.gms.internal.ads;

import com.google.android.gms.location.places.Place;
import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgsr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zza(byte b4, byte b5, byte b6, byte b7, char[] cArr, int i4) {
        if (!zzg(b5) && (((b4 << Ascii.FS) + (b5 + 112)) >> 30) == 0 && !zzg(b6) && !zzg(b7)) {
            int i5 = ((b4 & 7) << 18) | ((b5 & Utf8.REPLACEMENT_BYTE) << 12) | ((b6 & Utf8.REPLACEMENT_BYTE) << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
            cArr[i4] = (char) ((i5 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
            cArr[i4 + 1] = (char) ((i5 & Place.TYPE_SUBLOCALITY_LEVEL_1) + Utf8.LOG_SURROGATE_HEADER);
            return;
        }
        throw zzgpy.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzb(byte b4, byte b5, byte b6, char[] cArr, int i4) {
        if (!zzg(b5)) {
            if (b4 == -32) {
                if (b5 >= -96) {
                    b4 = -32;
                }
            }
            if (b4 == -19) {
                if (b5 < -96) {
                    b4 = -19;
                }
            }
            if (!zzg(b6)) {
                cArr[i4] = (char) (((b4 & Ascii.SI) << 12) | ((b5 & Utf8.REPLACEMENT_BYTE) << 6) | (b6 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw zzgpy.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(byte b4, byte b5, char[] cArr, int i4) {
        if (b4 >= -62 && !zzg(b5)) {
            cArr[i4] = (char) (((b4 & Ascii.US) << 6) | (b5 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw zzgpy.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzd(byte b4) {
        if (b4 >= 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zze(byte b4) {
        if (b4 < -16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzf(byte b4) {
        if (b4 < -32) {
            return true;
        }
        return false;
    }

    private static boolean zzg(byte b4) {
        if (b4 > -65) {
            return true;
        }
        return false;
    }
}
