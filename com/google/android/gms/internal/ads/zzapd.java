package com.google.android.gms.internal.ads;

import android.util.Base64;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzapd {
    public static String zza(byte[] bArr, boolean z3) {
        int i4;
        if (true != z3) {
            i4 = 2;
        } else {
            i4 = 11;
        }
        return Base64.encodeToString(bArr, i4);
    }

    public static byte[] zzb(String str, boolean z3) throws IllegalArgumentException {
        byte[] decode = Base64.decode(str, 2);
        if (decode.length == 0 && str.length() > 0) {
            throw new IllegalArgumentException("Unable to decode ".concat(str));
        }
        return decode;
    }
}
