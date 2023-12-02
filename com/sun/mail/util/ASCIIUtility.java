package com.sun.mail.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class ASCIIUtility {
    private ASCIIUtility() {
    }

    public static byte[] getBytes(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = (byte) charArray[i4];
        }
        return bArr;
    }

    public static int parseInt(byte[] bArr, int i4, int i5, int i6) throws NumberFormatException {
        int i7;
        int i8;
        boolean z3;
        if (bArr != null) {
            if (i5 > i4) {
                int i9 = 0;
                if (bArr[i4] == 45) {
                    i8 = i4 + 1;
                    i7 = Integer.MIN_VALUE;
                    z3 = true;
                } else {
                    i7 = -2147483647;
                    i8 = i4;
                    z3 = false;
                }
                int i10 = i7 / i6;
                if (i8 < i5) {
                    int i11 = i8 + 1;
                    int digit = Character.digit((char) bArr[i8], i6);
                    if (digit < 0) {
                        throw new NumberFormatException("illegal number: " + toString(bArr, i4, i5));
                    }
                    i9 = -digit;
                    i8 = i11;
                }
                while (i8 < i5) {
                    int i12 = i8 + 1;
                    int digit2 = Character.digit((char) bArr[i8], i6);
                    if (digit2 < 0) {
                        throw new NumberFormatException("illegal number");
                    }
                    if (i9 < i10) {
                        throw new NumberFormatException("illegal number");
                    }
                    int i13 = i9 * i6;
                    if (i13 < i7 + digit2) {
                        throw new NumberFormatException("illegal number");
                    }
                    i9 = i13 - digit2;
                    i8 = i12;
                }
                if (z3) {
                    if (i8 > i4 + 1) {
                        return i9;
                    }
                    throw new NumberFormatException("illegal number");
                }
                return -i9;
            }
            throw new NumberFormatException("illegal number");
        }
        throw new NumberFormatException("null");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006c -> B:15:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long parseLong(byte[] r18, int r19, int r20, int r21) throws java.lang.NumberFormatException {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            if (r18 == 0) goto L98
            java.lang.String r3 = "illegal number"
            if (r1 <= r0) goto L92
            r4 = r18[r0]
            r5 = 45
            r6 = 1
            if (r4 != r5) goto L19
            int r4 = r0 + 1
            r7 = -9223372036854775808
            r5 = 1
            goto L21
        L19:
            r4 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = r0
            r5 = 0
        L21:
            long r9 = (long) r2
            long r11 = r7 / r9
            if (r4 >= r1) goto L50
            int r13 = r4 + 1
            r4 = r18[r4]
            char r4 = (char) r4
            int r4 = java.lang.Character.digit(r4, r2)
            if (r4 < 0) goto L35
            int r4 = -r4
            long r14 = (long) r4
        L33:
            r4 = r13
            goto L52
        L35:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "illegal number: "
            r3.append(r4)
            java.lang.String r0 = toString(r18, r19, r20)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L50:
            r14 = 0
        L52:
            if (r4 >= r1) goto L84
            int r13 = r4 + 1
            r4 = r18[r4]
            char r4 = (char) r4
            int r4 = java.lang.Character.digit(r4, r2)
            if (r4 < 0) goto L7e
            int r16 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r16 < 0) goto L78
            long r14 = r14 * r9
            long r1 = (long) r4
            long r16 = r7 + r1
            int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r4 < 0) goto L72
            long r14 = r14 - r1
            r1 = r20
            r2 = r21
            goto L33
        L72:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>(r3)
            throw r0
        L78:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>(r3)
            throw r0
        L7e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>(r3)
            throw r0
        L84:
            if (r5 == 0) goto L90
            int r0 = r0 + r6
            if (r4 <= r0) goto L8a
            return r14
        L8a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>(r3)
            throw r0
        L90:
            long r0 = -r14
            return r0
        L92:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>(r3)
            throw r0
        L98:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.ASCIIUtility.parseLong(byte[], int, int, int):long");
    }

    public static String toString(byte[] bArr, int i4, int i5) {
        int i6 = i5 - i4;
        char[] cArr = new char[i6];
        int i7 = 0;
        while (i7 < i6) {
            cArr[i7] = (char) (bArr[i4] & 255);
            i7++;
            i4++;
        }
        return new String(cArr);
    }

    public static String toString(byte[] bArr) {
        return toString(bArr, 0, bArr.length);
    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        if (inputStream instanceof ByteArrayInputStream) {
            int available = inputStream.available();
            byte[] bArr = new byte[available];
            inputStream.read(bArr, 0, available);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr2, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String toString(ByteArrayInputStream byteArrayInputStream) {
        int available = byteArrayInputStream.available();
        char[] cArr = new char[available];
        byte[] bArr = new byte[available];
        byteArrayInputStream.read(bArr, 0, available);
        for (int i4 = 0; i4 < available; i4++) {
            cArr[i4] = (char) (bArr[i4] & 255);
        }
        return new String(cArr);
    }

    public static int parseInt(byte[] bArr, int i4, int i5) throws NumberFormatException {
        return parseInt(bArr, i4, i5, 10);
    }

    public static long parseLong(byte[] bArr, int i4, int i5) throws NumberFormatException {
        return parseLong(bArr, i4, i5, 10);
    }
}
