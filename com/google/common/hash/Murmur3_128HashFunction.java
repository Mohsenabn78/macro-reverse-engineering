package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final HashFunction f27876a = new Murmur3_128HashFunction(0);

    /* renamed from: b  reason: collision with root package name */
    static final HashFunction f27877b = new Murmur3_128HashFunction(Hashing.f27845a);
    private static final long serialVersionUID = 0;
    private final int seed;

    /* loaded from: classes5.dex */
    private static final class Murmur3_128Hasher extends AbstractStreamingHasher {

        /* renamed from: d  reason: collision with root package name */
        private long f27878d;

        /* renamed from: e  reason: collision with root package name */
        private long f27879e;

        /* renamed from: f  reason: collision with root package name */
        private int f27880f;

        Murmur3_128Hasher(int i4) {
            super(16);
            long j4 = i4;
            this.f27878d = j4;
            this.f27879e = j4;
            this.f27880f = 0;
        }

        private void g(long j4, long j5) {
            long i4 = i(j4) ^ this.f27878d;
            this.f27878d = i4;
            long rotateLeft = Long.rotateLeft(i4, 27);
            long j6 = this.f27879e;
            this.f27878d = ((rotateLeft + j6) * 5) + 1390208809;
            long j7 = j(j5) ^ j6;
            this.f27879e = j7;
            this.f27879e = ((Long.rotateLeft(j7, 31) + this.f27878d) * 5) + 944331445;
        }

        private static long h(long j4) {
            long j5 = (j4 ^ (j4 >>> 33)) * (-49064778989728563L);
            long j6 = (j5 ^ (j5 >>> 33)) * (-4265267296055464877L);
            return j6 ^ (j6 >>> 33);
        }

        private static long i(long j4) {
            return Long.rotateLeft(j4 * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        private static long j(long j4) {
            return Long.rotateLeft(j4 * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode a() {
            long j4 = this.f27878d;
            int i4 = this.f27880f;
            long j5 = j4 ^ i4;
            long j6 = this.f27879e ^ i4;
            long j7 = j5 + j6;
            this.f27878d = j7;
            this.f27879e = j6 + j7;
            this.f27878d = h(j7);
            long h4 = h(this.f27879e);
            long j8 = this.f27878d + h4;
            this.f27878d = j8;
            this.f27879e = h4 + j8;
            return HashCode.c(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f27878d).putLong(this.f27879e).array());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void d(ByteBuffer byteBuffer) {
            g(byteBuffer.getLong(), byteBuffer.getLong());
            this.f27880f += 16;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void e(ByteBuffer byteBuffer) {
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            long j15;
            long j16;
            long j17;
            this.f27880f += byteBuffer.remaining();
            long j18 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j4 = 0;
                    j10 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j4;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 2:
                    j5 = 0;
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j10 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j4;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 3:
                    j6 = 0;
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j10 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j4;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 4:
                    j7 = 0;
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j10 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j4;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 5:
                    j8 = 0;
                    j7 = j8 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j10 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j4;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 6:
                    j9 = 0;
                    j8 = j9 ^ (UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j7 = j8 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j10 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j4;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 7:
                    j9 = (UnsignedBytes.toInt(byteBuffer.get(6)) << 48) ^ 0;
                    j8 = j9 ^ (UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j7 = j8 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j10 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j4;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 8:
                    j11 = 0;
                    j10 = byteBuffer.getLong() ^ 0;
                    j18 = j11;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 9:
                    j12 = 0;
                    j11 = j12 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j18 = j11;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 10:
                    j13 = 0;
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j11 = j12 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j18 = j11;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 11:
                    j14 = 0;
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j11 = j12 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j18 = j11;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 12:
                    j15 = 0;
                    j14 = j15 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j11 = j12 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j18 = j11;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 13:
                    j16 = 0;
                    j15 = j16 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j14 = j15 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j11 = j12 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j18 = j11;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 14:
                    j17 = 0;
                    j16 = j17 ^ (UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j15 = j16 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j14 = j15 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j11 = j12 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j18 = j11;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                case 15:
                    j17 = (UnsignedBytes.toInt(byteBuffer.get(14)) << 48) ^ 0;
                    j16 = j17 ^ (UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j15 = j16 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j14 = j15 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j11 = j12 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j18 = j11;
                    this.f27878d ^= i(j10);
                    this.f27879e ^= j(j18);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Murmur3_128HashFunction(int i4) {
        this.seed = i4;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Murmur3_128HashFunction) || this.seed != ((Murmur3_128HashFunction) obj).seed) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }
}
