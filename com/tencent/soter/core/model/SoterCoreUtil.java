package com.tencent.soter.core.model;

import com.google.common.base.Ascii;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import net.bytebuddy.asm.Advice;

/* loaded from: classes6.dex */
public class SoterCoreUtil {
    public static long getCurrentTicks() {
        return System.nanoTime();
    }

    public static String getMessageDigest(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i4 = 0;
            for (byte b4 : digest) {
                int i5 = i4 + 1;
                cArr2[i4] = cArr[(b4 >>> 4) & 15];
                i4 = i5 + 1;
                cArr2[i5] = cArr[b4 & Ascii.SI];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isNullOrNil(String str) {
        return str == null || str.length() <= 0;
    }

    public static String nullAsNil(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static long ticksToNowInMs(long j4) {
        return ((System.nanoTime() - j4) / 1000) / 1000;
    }

    public static boolean isNullOrNil(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static boolean isNullOrNil(int[] iArr) {
        return iArr == null || iArr.length <= 0;
    }
}
