package com.google.android.gms.internal.mlkit_translate;

import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import java.util.Random;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzow {
    @VisibleForTesting
    static final Random zza = new SecureRandom();

    public static String zza() {
        byte[] bArr = new byte[17];
        zza.nextBytes(bArr);
        bArr[0] = (byte) ((bArr[0] & Ascii.SI) | 112);
        String substring = Base64.encodeToString(bArr, 11).substring(0, 22);
        "Generated installation id: ".concat(String.valueOf(substring));
        return substring;
    }
}
