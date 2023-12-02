package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;
import java.security.SecureRandom;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmj  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzmj {
    public static final Charset zza = Charset.forName("UTF-8");

    public static int zza() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i4 = 0;
        while (i4 == 0) {
            secureRandom.nextBytes(bArr);
            i4 = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i4;
    }

    public static final zzwi zzb(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt >= '!' && charAt <= '~') {
                bArr[i4] = (byte) charAt;
            } else {
                throw new zzmi("Not a printable ASCII character: " + charAt);
            }
        }
        return zzwi.zzb(bArr);
    }
}
