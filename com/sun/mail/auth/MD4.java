package com.sun.mail.auth;

/* loaded from: classes6.dex */
public final class MD4 {

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f37573f;

    /* renamed from: d  reason: collision with root package name */
    private int f37577d;

    /* renamed from: e  reason: collision with root package name */
    private long f37578e;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f37576c = new byte[64];

    /* renamed from: a  reason: collision with root package name */
    private final int[] f37574a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final int[] f37575b = new int[16];

    static {
        byte[] bArr = new byte[136];
        f37573f = bArr;
        bArr[0] = Byte.MIN_VALUE;
    }

    public MD4() {
        g();
    }

    private static int a(int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i4 + (((~i5) & i7) | (i6 & i5)) + i8;
        return (i10 >>> (32 - i9)) | (i10 << i9);
    }

    private static int b(int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i4 + ((i5 & i7) | (i5 & i6) | (i6 & i7)) + i8 + 1518500249;
        return (i10 >>> (32 - i9)) | (i10 << i9);
    }

    private static int c(int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i4 + ((i5 ^ i6) ^ i7) + i8 + 1859775393;
        return (i10 >>> (32 - i9)) | (i10 << i9);
    }

    private void d(byte[] bArr, int i4, int i5) {
        if (i5 == 0) {
            return;
        }
        if (i4 >= 0 && i5 >= 0 && i4 <= bArr.length - i5) {
            if (this.f37578e < 0) {
                g();
            }
            this.f37578e += i5;
            int i6 = this.f37577d;
            if (i6 != 0) {
                int min = Math.min(i5, 64 - i6);
                System.arraycopy(bArr, i4, this.f37576c, this.f37577d, min);
                int i7 = this.f37577d + min;
                this.f37577d = i7;
                i4 += min;
                i5 -= min;
                if (i7 >= 64) {
                    e(this.f37576c, 0);
                    this.f37577d = 0;
                }
            }
            while (i5 >= 64) {
                e(bArr, i4);
                i5 -= 64;
                i4 += 64;
            }
            if (i5 > 0) {
                System.arraycopy(bArr, i4, this.f37576c, 0, i5);
                this.f37577d = i5;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private void e(byte[] bArr, int i4) {
        int i5 = i4;
        int i6 = 0;
        while (true) {
            int[] iArr = this.f37575b;
            if (i6 < iArr.length) {
                iArr[i6] = (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24);
                i5 += 4;
                i6++;
            } else {
                int[] iArr2 = this.f37574a;
                int i7 = iArr2[0];
                int i8 = iArr2[1];
                int i9 = iArr2[2];
                int i10 = iArr2[3];
                int a4 = a(i7, i8, i9, i10, iArr[0], 3);
                int a5 = a(i10, a4, i8, i9, this.f37575b[1], 7);
                int a6 = a(i9, a5, a4, i8, this.f37575b[2], 11);
                int a7 = a(i8, a6, a5, a4, this.f37575b[3], 19);
                int a8 = a(a4, a7, a6, a5, this.f37575b[4], 3);
                int a9 = a(a5, a8, a7, a6, this.f37575b[5], 7);
                int a10 = a(a6, a9, a8, a7, this.f37575b[6], 11);
                int a11 = a(a7, a10, a9, a8, this.f37575b[7], 19);
                int a12 = a(a8, a11, a10, a9, this.f37575b[8], 3);
                int a13 = a(a9, a12, a11, a10, this.f37575b[9], 7);
                int a14 = a(a10, a13, a12, a11, this.f37575b[10], 11);
                int a15 = a(a11, a14, a13, a12, this.f37575b[11], 19);
                int a16 = a(a12, a15, a14, a13, this.f37575b[12], 3);
                int a17 = a(a13, a16, a15, a14, this.f37575b[13], 7);
                int a18 = a(a14, a17, a16, a15, this.f37575b[14], 11);
                int a19 = a(a15, a18, a17, a16, this.f37575b[15], 19);
                int b4 = b(a16, a19, a18, a17, this.f37575b[0], 3);
                int b5 = b(a17, b4, a19, a18, this.f37575b[4], 5);
                int b6 = b(a18, b5, b4, a19, this.f37575b[8], 9);
                int b7 = b(a19, b6, b5, b4, this.f37575b[12], 13);
                int b8 = b(b4, b7, b6, b5, this.f37575b[1], 3);
                int b9 = b(b5, b8, b7, b6, this.f37575b[5], 5);
                int b10 = b(b6, b9, b8, b7, this.f37575b[9], 9);
                int b11 = b(b7, b10, b9, b8, this.f37575b[13], 13);
                int b12 = b(b8, b11, b10, b9, this.f37575b[2], 3);
                int b13 = b(b9, b12, b11, b10, this.f37575b[6], 5);
                int b14 = b(b10, b13, b12, b11, this.f37575b[10], 9);
                int b15 = b(b11, b14, b13, b12, this.f37575b[14], 13);
                int b16 = b(b12, b15, b14, b13, this.f37575b[3], 3);
                int b17 = b(b13, b16, b15, b14, this.f37575b[7], 5);
                int b18 = b(b14, b17, b16, b15, this.f37575b[11], 9);
                int b19 = b(b15, b18, b17, b16, this.f37575b[15], 13);
                int c4 = c(b16, b19, b18, b17, this.f37575b[0], 3);
                int c5 = c(b17, c4, b19, b18, this.f37575b[8], 9);
                int c6 = c(b18, c5, c4, b19, this.f37575b[4], 11);
                int c7 = c(b19, c6, c5, c4, this.f37575b[12], 15);
                int c8 = c(c4, c7, c6, c5, this.f37575b[2], 3);
                int c9 = c(c5, c8, c7, c6, this.f37575b[10], 9);
                int c10 = c(c6, c9, c8, c7, this.f37575b[6], 11);
                int c11 = c(c7, c10, c9, c8, this.f37575b[14], 15);
                int c12 = c(c8, c11, c10, c9, this.f37575b[1], 3);
                int c13 = c(c9, c12, c11, c10, this.f37575b[9], 9);
                int c14 = c(c10, c13, c12, c11, this.f37575b[5], 11);
                int c15 = c(c11, c14, c13, c12, this.f37575b[13], 15);
                int c16 = c(c12, c15, c14, c13, this.f37575b[3], 3);
                int c17 = c(c13, c16, c15, c14, this.f37575b[11], 9);
                int c18 = c(c14, c17, c16, c15, this.f37575b[7], 11);
                int c19 = c(c15, c18, c17, c16, this.f37575b[15], 15);
                int[] iArr3 = this.f37574a;
                iArr3[0] = iArr3[0] + c16;
                iArr3[1] = iArr3[1] + c19;
                iArr3[2] = iArr3[2] + c18;
                iArr3[3] = iArr3[3] + c17;
                return;
            }
        }
    }

    private void f(byte[] bArr, int i4) {
        int i5;
        long j4 = this.f37578e;
        long j5 = j4 << 3;
        int i6 = ((int) j4) & 63;
        if (i6 < 56) {
            i5 = 56 - i6;
        } else {
            i5 = 120 - i6;
        }
        int i7 = 0;
        d(f37573f, 0, i5);
        byte[] bArr2 = this.f37576c;
        bArr2[56] = (byte) j5;
        bArr2[57] = (byte) (j5 >> 8);
        bArr2[58] = (byte) (j5 >> 16);
        bArr2[59] = (byte) (j5 >> 24);
        bArr2[60] = (byte) (j5 >> 32);
        bArr2[61] = (byte) (j5 >> 40);
        bArr2[62] = (byte) (j5 >> 48);
        bArr2[63] = (byte) (j5 >> 56);
        e(bArr2, 0);
        while (true) {
            int[] iArr = this.f37574a;
            if (i7 < iArr.length) {
                int i8 = iArr[i7];
                int i9 = i4 + 1;
                bArr[i4] = (byte) i8;
                int i10 = i9 + 1;
                bArr[i9] = (byte) (i8 >> 8);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (i8 >> 16);
                i4 = i11 + 1;
                bArr[i11] = (byte) (i8 >> 24);
                i7++;
            } else {
                return;
            }
        }
    }

    private void g() {
        int[] iArr = this.f37574a;
        iArr[0] = 1732584193;
        iArr[1] = -271733879;
        iArr[2] = -1732584194;
        iArr[3] = 271733878;
        this.f37577d = 0;
        this.f37578e = 0L;
    }

    public byte[] digest(byte[] bArr) {
        g();
        d(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[16];
        f(bArr2, 0);
        return bArr2;
    }
}
