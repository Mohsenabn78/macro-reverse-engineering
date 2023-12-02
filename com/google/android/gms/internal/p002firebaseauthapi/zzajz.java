package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.location.places.Place;
import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajz  reason: invalid package */
/* loaded from: classes4.dex */
final class zzajz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zza(byte b4, byte b5, byte b6, byte b7, char[] cArr, int i4) {
        if (!zze(b5) && (((b4 << Ascii.FS) + (b5 + 112)) >> 30) == 0 && !zze(b6) && !zze(b7)) {
            int i5 = ((b4 & 7) << 18) | ((b5 & Utf8.REPLACEMENT_BYTE) << 12) | ((b6 & Utf8.REPLACEMENT_BYTE) << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
            cArr[i4] = (char) ((i5 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
            cArr[i4 + 1] = (char) ((i5 & Place.TYPE_SUBLOCALITY_LEVEL_1) + Utf8.LOG_SURROGATE_HEADER);
            return;
        }
        throw zzahl.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzb(byte b4, byte b5, byte b6, char[] cArr, int i4) {
        if (!zze(b5)) {
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
            if (!zze(b6)) {
                cArr[i4] = (char) (((b4 & Ascii.SI) << 12) | ((b5 & Utf8.REPLACEMENT_BYTE) << 6) | (b6 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw zzahl.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(byte b4, byte b5, char[] cArr, int i4) {
        if (b4 >= -62 && !zze(b5)) {
            cArr[i4] = (char) (((b4 & Ascii.US) << 6) | (b5 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw zzahl.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzd(byte b4) {
        if (b4 >= 0) {
            return true;
        }
        return false;
    }

    private static boolean zze(byte b4) {
        if (b4 > -65) {
            return true;
        }
        return false;
    }
}
