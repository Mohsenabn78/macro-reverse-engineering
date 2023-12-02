package com.google.firebase.firestore.index;

import java.math.RoundingMode;

/* loaded from: classes5.dex */
public final class IntMath {

    /* renamed from: com.google.firebase.firestore.index.IntMath$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30567a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f30567a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30567a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30567a[RoundingMode.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30567a[RoundingMode.CEILING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30567a[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30567a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30567a[RoundingMode.HALF_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30567a[RoundingMode.HALF_UP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private IntMath() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        if ((r6 & r7) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
        if (r1 > 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
        if (r5 < 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
        if (r5 > 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int divide(int r5, int r6, java.math.RoundingMode r7) {
        /*
            if (r6 == 0) goto L52
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto Lb
            return r0
        Lb:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.firebase.firestore.index.IntMath.AnonymousClass1.f30567a
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L4d;
                case 2: goto L4d;
                case 3: goto L4e;
                case 4: goto L4a;
                case 5: goto L47;
                case 6: goto L22;
                case 7: goto L22;
                case 8: goto L22;
                default: goto L1c;
            }
        L1c:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L22:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L44
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L4e
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L38
            r6 = 1
            goto L39
        L38:
            r6 = 0
        L39:
            r7 = r0 & 1
            if (r7 == 0) goto L3f
            r7 = 1
            goto L40
        L3f:
            r7 = 0
        L40:
            r6 = r6 & r7
            if (r6 == 0) goto L4d
            goto L4e
        L44:
            if (r1 <= 0) goto L4d
            goto L4e
        L47:
            if (r5 >= 0) goto L4d
            goto L4e
        L4a:
            if (r5 <= 0) goto L4d
            goto L4e
        L4d:
            r2 = 0
        L4e:
            if (r2 == 0) goto L51
            int r0 = r0 + r5
        L51:
            return r0
        L52:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.index.IntMath.divide(int, int, java.math.RoundingMode):int");
    }
}
