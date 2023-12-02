package com.arlosoft.macrodroid.common;

import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public class SerialCalculator {
    public static String MD5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b4 : digest) {
                sb.append((CharSequence) Integer.toHexString((b4 & 255) | 256), 1, 3);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Serial Calculator Error: " + e4.getMessage()));
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b4 : bArr) {
            sb.append(Integer.toString((b4 & 255) + 256, 16).substring(1));
        }
        return sb.toString();
    }

    public static String calculateEmailPassword(String str) {
        return MD5(new StringBuilder(str).reverse().toString()).substring(10, 22);
    }

    public static String calculateSerialCode(String str) {
        return calculateSerialCode(str, 12);
    }

    public static String calculateSerialCode(String str, int i4) {
        String lowerCase = str.toLowerCase();
        for (int i5 = 0; i5 < 4; i5++) {
            for (int i6 = 0; i6 < i5; i6++) {
                try {
                    lowerCase = a(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1).digest(lowerCase.getBytes("UTF-8")));
                } catch (Exception e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Serial Calculator Error: " + e4.getMessage()));
                    return null;
                }
            }
            lowerCase = MD5(lowerCase);
        }
        return lowerCase.substring(0, 12);
    }
}
