package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {

    /* renamed from: a  reason: collision with root package name */
    static final HashFunction f27834a = new Fingerprint2011();

    Fingerprint2011() {
    }

    @VisibleForTesting
    static long a(byte[] bArr, int i4, int i5) {
        long b4;
        long j4;
        if (i5 <= 32) {
            b4 = f(bArr, i4, i5, -1397348546323613475L);
        } else if (i5 <= 64) {
            b4 = e(bArr, i4, i5);
        } else {
            b4 = b(bArr, i4, i5);
        }
        long j5 = -6505348102511208375L;
        if (i5 >= 8) {
            j4 = LittleEndianByteArray.b(bArr, i4);
        } else {
            j4 = -6505348102511208375L;
        }
        if (i5 >= 9) {
            j5 = LittleEndianByteArray.b(bArr, (i4 + i5) - 8);
        }
        long c4 = c(b4 + j5, j4);
        if (c4 == 0 || c4 == 1) {
            return c4 - 2;
        }
        return c4;
    }

    private static long b(byte[] bArr, int i4, int i5) {
        long b4 = LittleEndianByteArray.b(bArr, i4);
        int i6 = i4 + i5;
        long b5 = LittleEndianByteArray.b(bArr, i6 - 16) ^ (-8261664234251669945L);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j4 = i5;
        h(bArr, i6 - 64, j4, b5, jArr);
        h(bArr, i6 - 32, j4 * (-8261664234251669945L), -6505348102511208375L, jArr2);
        long b6 = (LittleEndianByteArray.b(bArr, i6 - 56) ^ (-6505348102511208375L)) + (g(jArr[1]) * (-8261664234251669945L));
        long rotateRight = Long.rotateRight(b6 + b4, 39) * (-8261664234251669945L);
        long rotateRight2 = Long.rotateRight(b5, 33) * (-8261664234251669945L);
        int i7 = i4;
        int i8 = (i5 - 1) & (-64);
        while (true) {
            long rotateRight3 = (Long.rotateRight(((rotateRight + rotateRight2) + jArr[0]) + LittleEndianByteArray.b(bArr, i7 + 16), 37) * (-8261664234251669945L)) ^ jArr2[1];
            long rotateRight4 = (Long.rotateRight((rotateRight2 + jArr[1]) + LittleEndianByteArray.b(bArr, i7 + 48), 42) * (-8261664234251669945L)) ^ jArr[0];
            long rotateRight5 = Long.rotateRight(b6 ^ jArr2[0], 33);
            h(bArr, i7, jArr[1] * (-8261664234251669945L), rotateRight3 + jArr2[0], jArr);
            h(bArr, i7 + 32, jArr2[1] + rotateRight5, rotateRight4, jArr2);
            i7 += 64;
            i8 -= 64;
            if (i8 == 0) {
                return c(c(jArr[0], jArr2[0]) + (g(rotateRight4) * (-8261664234251669945L)) + rotateRight3, c(jArr[1], jArr2[1]) + rotateRight5);
            }
            rotateRight = rotateRight5;
            b6 = rotateRight3;
            rotateRight2 = rotateRight4;
        }
    }

    @VisibleForTesting
    static long c(long j4, long j5) {
        long j6 = (j5 ^ j4) * (-4132994306676758123L);
        long j7 = (j4 ^ (j6 ^ (j6 >>> 47))) * (-4132994306676758123L);
        return (j7 ^ (j7 >>> 47)) * (-4132994306676758123L);
    }

    private static long e(byte[] bArr, int i4, int i5) {
        long b4 = LittleEndianByteArray.b(bArr, i4 + 24);
        int i6 = i4 + i5;
        int i7 = i6 - 16;
        long b5 = LittleEndianByteArray.b(bArr, i4) + ((i5 + LittleEndianByteArray.b(bArr, i7)) * (-6505348102511208375L));
        long rotateRight = Long.rotateRight(b5 + b4, 52);
        long rotateRight2 = Long.rotateRight(b5, 37);
        long b6 = b5 + LittleEndianByteArray.b(bArr, i4 + 8);
        int i8 = i4 + 16;
        long b7 = b6 + LittleEndianByteArray.b(bArr, i8);
        long j4 = b4 + b7;
        long rotateRight3 = rotateRight + Long.rotateRight(b7, 31) + rotateRight2 + Long.rotateRight(b6, 7);
        long b8 = LittleEndianByteArray.b(bArr, i8) + LittleEndianByteArray.b(bArr, i6 - 32);
        long b9 = LittleEndianByteArray.b(bArr, i6 - 8);
        long rotateRight4 = Long.rotateRight(b8 + b9, 52);
        long rotateRight5 = Long.rotateRight(b8, 37);
        long b10 = b8 + LittleEndianByteArray.b(bArr, i6 - 24);
        long b11 = b10 + LittleEndianByteArray.b(bArr, i7);
        return g((g(((j4 + rotateRight4 + Long.rotateRight(b11, 31) + rotateRight5 + Long.rotateRight(b10, 7)) * (-4288712594273399085L)) + ((b9 + b11 + rotateRight3) * (-6505348102511208375L))) * (-6505348102511208375L)) + rotateRight3) * (-4288712594273399085L);
    }

    @VisibleForTesting
    static long f(byte[] bArr, int i4, int i5, long j4) {
        int i6 = i5 & (-8);
        int i7 = i5 & 7;
        long j5 = j4 ^ (i5 * (-4132994306676758123L));
        for (int i8 = 0; i8 < i6; i8 += 8) {
            j5 = (j5 ^ (g(LittleEndianByteArray.b(bArr, i4 + i8) * (-4132994306676758123L)) * (-4132994306676758123L))) * (-4132994306676758123L);
        }
        if (i7 != 0) {
            j5 = (LittleEndianByteArray.c(bArr, i4 + i6, i7) ^ j5) * (-4132994306676758123L);
        }
        return g(g(j5) * (-4132994306676758123L));
    }

    private static long g(long j4) {
        return j4 ^ (j4 >>> 47);
    }

    private static void h(byte[] bArr, int i4, long j4, long j5, long[] jArr) {
        long b4 = LittleEndianByteArray.b(bArr, i4);
        long b5 = LittleEndianByteArray.b(bArr, i4 + 8);
        long b6 = LittleEndianByteArray.b(bArr, i4 + 16);
        long b7 = LittleEndianByteArray.b(bArr, i4 + 24);
        long j6 = j4 + b4;
        long j7 = b5 + j6 + b6;
        jArr[0] = j7 + b7;
        jArr[1] = Long.rotateRight(j5 + j6 + b7, 51) + Long.rotateRight(j7, 23) + j6;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i4, int i5) {
        Preconditions.checkPositionIndexes(i4, i4 + i5, bArr.length);
        return HashCode.fromLong(a(bArr, i4, i5));
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }
}
