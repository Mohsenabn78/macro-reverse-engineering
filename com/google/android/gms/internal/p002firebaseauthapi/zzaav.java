package com.google.android.gms.internal.p002firebaseauthapi;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaav  reason: invalid package */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzaav {
    public static String zza(zzaaw zzaawVar, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(str.getBytes()));
            int length = str2.length();
            int i4 = 0;
            while (i4 < length) {
                if (zze.zza(str2.charAt(i4))) {
                    char[] charArray = str2.toCharArray();
                    while (i4 < length) {
                        char c4 = charArray[i4];
                        if (zze.zza(c4)) {
                            charArray[i4] = (char) (c4 ^ ' ');
                        }
                        i4++;
                    }
                    return String.valueOf(charArray);
                }
                i4++;
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            zzaaw.zza.e("Failed to get SHA-256 MessageDigest", new Object[0]);
            return null;
        }
    }
}
