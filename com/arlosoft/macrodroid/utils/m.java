package com.arlosoft.macrodroid.utils;

import java.util.Locale;

/* compiled from: HexHelper.java */
/* loaded from: classes3.dex */
class m {
    public static byte[] a(String str) {
        int i4;
        int i5;
        String lowerCase = str.toLowerCase(Locale.US);
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i7 + 1;
            char charAt = lowerCase.charAt(i7);
            if (charAt >= 'a') {
                i4 = (charAt - 'a') + 10;
            } else {
                i4 = charAt - '0';
            }
            byte b4 = (byte) (i4 << 4);
            int i9 = i8 + 1;
            char charAt2 = lowerCase.charAt(i8);
            if (charAt2 >= 'a') {
                i5 = (charAt2 - 'a') + 10;
            } else {
                i5 = charAt2 - '0';
            }
            bArr[i6] = (byte) (b4 | ((byte) i5));
            i6++;
            i7 = i9;
        }
        return bArr;
    }
}
