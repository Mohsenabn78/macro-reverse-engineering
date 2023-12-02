package com.fasterxml.jackson.core.io;

/* loaded from: classes3.dex */
public final class NumberInput {
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";

    /* renamed from: a  reason: collision with root package name */
    static final String f17745a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* renamed from: b  reason: collision with root package name */
    static final String f17746b = String.valueOf(Long.MAX_VALUE);

    public static boolean inLongRange(char[] cArr, int i4, int i5, boolean z3) {
        String str = z3 ? f17745a : f17746b;
        int length = str.length();
        if (i5 < length) {
            return true;
        }
        if (i5 > length) {
            return false;
        }
        for (int i6 = 0; i6 < length; i6++) {
            int charAt = cArr[i4 + i6] - str.charAt(i6);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    public static double parseAsDouble(String str, double d4) {
        if (str == null) {
            return d4;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return d4;
        }
        try {
            return parseDouble(trim);
        } catch (NumberFormatException unused) {
            return d4;
        }
    }

    public static int parseAsInt(String str, int i4) {
        if (str == null) {
            return i4;
        }
        String trim = str.trim();
        int length = trim.length();
        if (length == 0) {
            return i4;
        }
        int i5 = 0;
        if (length > 0) {
            char charAt = trim.charAt(0);
            if (charAt == '+') {
                trim = trim.substring(1);
                length = trim.length();
            } else if (charAt == '-') {
                i5 = 1;
            }
        }
        while (i5 < length) {
            char charAt2 = trim.charAt(i5);
            if (charAt2 <= '9' && charAt2 >= '0') {
                i5++;
            } else {
                try {
                    return (int) parseDouble(trim);
                } catch (NumberFormatException unused) {
                    return i4;
                }
            }
        }
        try {
            return Integer.parseInt(trim);
        } catch (NumberFormatException unused2) {
            return i4;
        }
    }

    public static long parseAsLong(String str, long j4) {
        if (str == null) {
            return j4;
        }
        String trim = str.trim();
        int length = trim.length();
        if (length == 0) {
            return j4;
        }
        int i4 = 0;
        if (length > 0) {
            char charAt = trim.charAt(0);
            if (charAt == '+') {
                trim = trim.substring(1);
                length = trim.length();
            } else if (charAt == '-') {
                i4 = 1;
            }
        }
        while (i4 < length) {
            char charAt2 = trim.charAt(i4);
            if (charAt2 <= '9' && charAt2 >= '0') {
                i4++;
            } else {
                try {
                    return (long) parseDouble(trim);
                } catch (NumberFormatException unused) {
                    return j4;
                }
            }
        }
        try {
            return Long.parseLong(trim);
        } catch (NumberFormatException unused2) {
            return j4;
        }
    }

    public static double parseDouble(String str) throws NumberFormatException {
        if (NASTY_SMALL_DOUBLE.equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    public static int parseInt(char[] cArr, int i4, int i5) {
        int i6;
        int i7 = cArr[i4] - '0';
        int i8 = i5 + i4;
        int i9 = i4 + 1;
        if (i9 < i8) {
            int i10 = (i7 * 10) + (cArr[i9] - '0');
            int i11 = i9 + 1;
            if (i11 < i8) {
                int i12 = (i10 * 10) + (cArr[i11] - '0');
                int i13 = i11 + 1;
                if (i13 < i8) {
                    int i14 = (i12 * 10) + (cArr[i13] - '0');
                    int i15 = i13 + 1;
                    if (i15 < i8) {
                        int i16 = (i14 * 10) + (cArr[i15] - '0');
                        int i17 = i15 + 1;
                        if (i17 < i8) {
                            int i18 = (i16 * 10) + (cArr[i17] - '0');
                            int i19 = i17 + 1;
                            if (i19 < i8) {
                                int i20 = (i18 * 10) + (cArr[i19] - '0');
                                int i21 = i19 + 1;
                                if (i21 < i8) {
                                    int i22 = (i20 * 10) + (cArr[i21] - '0');
                                    return i21 + 1 < i8 ? (i22 * 10) + (cArr[i6] - '0') : i22;
                                }
                                return i20;
                            }
                            return i18;
                        }
                        return i16;
                    }
                    return i14;
                }
                return i12;
            }
            return i10;
        }
        return i7;
    }

    public static long parseLong(char[] cArr, int i4, int i5) {
        int i6 = i5 - 9;
        return (parseInt(cArr, i4, i6) * 1000000000) + parseInt(cArr, i4 + i6, 9);
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(String str, boolean z3) {
        String str2 = z3 ? f17745a : f17746b;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            int charAt = str.charAt(i4) - str2.charAt(i4);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:
        return java.lang.Integer.parseInt(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int parseInt(java.lang.String r8) {
        /*
            r0 = 0
            char r1 = r8.charAt(r0)
            int r2 = r8.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto Lf
            r0 = 1
        Lf:
            r3 = 10
            if (r0 == 0) goto L23
            if (r2 == r4) goto L1e
            if (r2 <= r3) goto L18
            goto L1e
        L18:
            char r1 = r8.charAt(r4)
            r4 = 2
            goto L2c
        L1e:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L23:
            r5 = 9
            if (r2 <= r5) goto L2c
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L2c:
            r5 = 57
            if (r1 > r5) goto L82
            r6 = 48
            if (r1 >= r6) goto L35
            goto L82
        L35:
            int r1 = r1 - r6
            if (r4 >= r2) goto L7e
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L79
            if (r4 >= r6) goto L43
            goto L79
        L43:
            int r1 = r1 * 10
            int r4 = r4 - r6
            int r1 = r1 + r4
            if (r7 >= r2) goto L7e
            int r4 = r7 + 1
            char r7 = r8.charAt(r7)
            if (r7 > r5) goto L74
            if (r7 >= r6) goto L54
            goto L74
        L54:
            int r1 = r1 * 10
            int r7 = r7 - r6
            int r1 = r1 + r7
            if (r4 >= r2) goto L7e
        L5a:
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L6f
            if (r4 >= r6) goto L65
            goto L6f
        L65:
            int r1 = r1 * 10
            int r4 = r4 + (-48)
            int r1 = r1 + r4
            if (r7 < r2) goto L6d
            goto L7e
        L6d:
            r4 = r7
            goto L5a
        L6f:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L74:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L79:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L7e:
            if (r0 == 0) goto L81
            int r1 = -r1
        L81:
            return r1
        L82:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseInt(java.lang.String):int");
    }
}
