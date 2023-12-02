package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.mail.UIDFolder;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {

    /* renamed from: a  reason: collision with root package name */
    static final HashFunction f27833a = new FarmHashFingerprint64();

    FarmHashFingerprint64() {
    }

    @VisibleForTesting
    static long a(byte[] bArr, int i4, int i5) {
        if (i5 <= 32) {
            if (i5 <= 16) {
                return b(bArr, i4, i5);
            }
            return e(bArr, i4, i5);
        } else if (i5 <= 64) {
            return f(bArr, i4, i5);
        } else {
            return g(bArr, i4, i5);
        }
    }

    private static long b(byte[] bArr, int i4, int i5) {
        if (i5 >= 8) {
            long j4 = (i5 * 2) - 7286425919675154353L;
            long b4 = LittleEndianByteArray.b(bArr, i4) - 7286425919675154353L;
            long b5 = LittleEndianByteArray.b(bArr, (i4 + i5) - 8);
            return c((Long.rotateRight(b5, 37) * j4) + b4, (Long.rotateRight(b4, 25) + b5) * j4, j4);
        } else if (i5 >= 4) {
            return c(i5 + ((LittleEndianByteArray.a(bArr, i4) & UIDFolder.MAXUID) << 3), LittleEndianByteArray.a(bArr, (i4 + i5) - 4) & UIDFolder.MAXUID, (i5 * 2) - 7286425919675154353L);
        } else if (i5 <= 0) {
            return -7286425919675154353L;
        } else {
            return h((((bArr[i4] & 255) + ((bArr[(i5 >> 1) + i4] & 255) << 8)) * (-7286425919675154353L)) ^ ((i5 + ((bArr[i4 + (i5 - 1)] & 255) << 2)) * (-4348849565147123417L))) * (-7286425919675154353L);
        }
    }

    private static long c(long j4, long j5, long j6) {
        long j7 = (j4 ^ j5) * j6;
        long j8 = ((j7 ^ (j7 >>> 47)) ^ j5) * j6;
        return (j8 ^ (j8 >>> 47)) * j6;
    }

    private static long e(byte[] bArr, int i4, int i5) {
        long j4 = (i5 * 2) - 7286425919675154353L;
        long b4 = LittleEndianByteArray.b(bArr, i4) * (-5435081209227447693L);
        long b5 = LittleEndianByteArray.b(bArr, i4 + 8);
        int i6 = i4 + i5;
        long b6 = LittleEndianByteArray.b(bArr, i6 - 8) * j4;
        return c((LittleEndianByteArray.b(bArr, i6 - 16) * (-7286425919675154353L)) + Long.rotateRight(b4 + b5, 43) + Long.rotateRight(b6, 30), b6 + b4 + Long.rotateRight(b5 - 7286425919675154353L, 18), j4);
    }

    private static long f(byte[] bArr, int i4, int i5) {
        long j4 = (i5 * 2) - 7286425919675154353L;
        long b4 = LittleEndianByteArray.b(bArr, i4) * (-7286425919675154353L);
        long b5 = LittleEndianByteArray.b(bArr, i4 + 8);
        int i6 = i4 + i5;
        long b6 = LittleEndianByteArray.b(bArr, i6 - 8) * j4;
        long rotateRight = Long.rotateRight(b4 + b5, 43) + Long.rotateRight(b6, 30) + (LittleEndianByteArray.b(bArr, i6 - 16) * (-7286425919675154353L));
        long c4 = c(rotateRight, b6 + Long.rotateRight(b5 - 7286425919675154353L, 18) + b4, j4);
        long b7 = LittleEndianByteArray.b(bArr, i4 + 16) * j4;
        long b8 = LittleEndianByteArray.b(bArr, i4 + 24);
        long b9 = (rotateRight + LittleEndianByteArray.b(bArr, i6 - 32)) * j4;
        return c(((c4 + LittleEndianByteArray.b(bArr, i6 - 24)) * j4) + Long.rotateRight(b7 + b8, 43) + Long.rotateRight(b9, 30), b7 + Long.rotateRight(b8 + b4, 18) + b9, j4);
    }

    private static long g(byte[] bArr, int i4, int i5) {
        long j4 = 81;
        long j5 = (j4 * (-5435081209227447693L)) + 113;
        long h4 = h((j5 * (-7286425919675154353L)) + 113) * (-7286425919675154353L);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long b4 = (j4 * (-7286425919675154353L)) + LittleEndianByteArray.b(bArr, i4);
        int i6 = i5 - 1;
        int i7 = i4 + ((i6 / 64) * 64);
        int i8 = i6 & 63;
        int i9 = (i7 + i8) - 63;
        int i10 = i4;
        while (true) {
            long rotateRight = (Long.rotateRight(((b4 + j5) + jArr[0]) + LittleEndianByteArray.b(bArr, i10 + 8), 37) * (-5435081209227447693L)) ^ jArr2[1];
            long rotateRight2 = (Long.rotateRight(j5 + jArr[1] + LittleEndianByteArray.b(bArr, i10 + 48), 42) * (-5435081209227447693L)) + jArr[0] + LittleEndianByteArray.b(bArr, i10 + 40);
            long rotateRight3 = Long.rotateRight(h4 + jArr2[0], 33) * (-5435081209227447693L);
            i(bArr, i10, jArr[1] * (-5435081209227447693L), rotateRight + jArr2[0], jArr);
            i(bArr, i10 + 32, rotateRight3 + jArr2[1], rotateRight2 + LittleEndianByteArray.b(bArr, i10 + 16), jArr2);
            int i11 = i10 + 64;
            if (i11 == i7) {
                long j6 = (-5435081209227447693L) + ((rotateRight & 255) << 1);
                long j7 = jArr2[0] + i8;
                jArr2[0] = j7;
                long j8 = jArr[0] + j7;
                jArr[0] = j8;
                jArr2[0] = jArr2[0] + j8;
                long rotateRight4 = (Long.rotateRight(((rotateRight3 + rotateRight2) + jArr[0]) + LittleEndianByteArray.b(bArr, i9 + 8), 37) * j6) ^ (jArr2[1] * 9);
                long rotateRight5 = (Long.rotateRight(rotateRight2 + jArr[1] + LittleEndianByteArray.b(bArr, i9 + 48), 42) * j6) + (jArr[0] * 9) + LittleEndianByteArray.b(bArr, i9 + 40);
                long rotateRight6 = Long.rotateRight(rotateRight + jArr2[0], 33) * j6;
                i(bArr, i9, jArr[1] * j6, rotateRight4 + jArr2[0], jArr);
                i(bArr, i9 + 32, rotateRight6 + jArr2[1], rotateRight5 + LittleEndianByteArray.b(bArr, i9 + 16), jArr2);
                return c(c(jArr[0], jArr2[0], j6) + (h(rotateRight5) * (-4348849565147123417L)) + rotateRight4, c(jArr[1], jArr2[1], j6) + rotateRight6, j6);
            }
            i10 = i11;
            h4 = rotateRight;
            j5 = rotateRight2;
            b4 = rotateRight3;
        }
    }

    private static long h(long j4) {
        return j4 ^ (j4 >>> 47);
    }

    private static void i(byte[] bArr, int i4, long j4, long j5, long[] jArr) {
        long b4 = LittleEndianByteArray.b(bArr, i4);
        long b5 = LittleEndianByteArray.b(bArr, i4 + 8);
        long b6 = LittleEndianByteArray.b(bArr, i4 + 16);
        long b7 = LittleEndianByteArray.b(bArr, i4 + 24);
        long j6 = j4 + b4;
        long j7 = b5 + j6 + b6;
        jArr[0] = j7 + b7;
        jArr[1] = Long.rotateRight(j5 + j6 + b7, 21) + Long.rotateRight(j7, 44) + j6;
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
        return "Hashing.farmHashFingerprint64()";
    }
}
