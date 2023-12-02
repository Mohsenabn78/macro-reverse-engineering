package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean d(@ParametricNullness T t3, Funnel<? super T> funnel, int i4, LockFreeBitArray lockFreeBitArray) {
            long b4 = lockFreeBitArray.b();
            long asLong = Hashing.murmur3_128().hashObject(t3, funnel).asLong();
            int i5 = (int) asLong;
            int i6 = (int) (asLong >>> 32);
            for (int i7 = 1; i7 <= i4; i7++) {
                int i8 = (i7 * i6) + i5;
                if (i8 < 0) {
                    i8 = ~i8;
                }
                if (!lockFreeBitArray.d(i8 % b4)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean k(@ParametricNullness T t3, Funnel<? super T> funnel, int i4, LockFreeBitArray lockFreeBitArray) {
            long b4 = lockFreeBitArray.b();
            long asLong = Hashing.murmur3_128().hashObject(t3, funnel).asLong();
            int i5 = (int) asLong;
            int i6 = (int) (asLong >>> 32);
            boolean z3 = false;
            for (int i7 = 1; i7 <= i4; i7++) {
                int i8 = (i7 * i6) + i5;
                if (i8 < 0) {
                    i8 = ~i8;
                }
                z3 |= lockFreeBitArray.g(i8 % b4);
            }
            return z3;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long b(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long c(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean d(@ParametricNullness T t3, Funnel<? super T> funnel, int i4, LockFreeBitArray lockFreeBitArray) {
            long b4 = lockFreeBitArray.b();
            byte[] e4 = Hashing.murmur3_128().hashObject(t3, funnel).e();
            long b5 = b(e4);
            long c4 = c(e4);
            for (int i5 = 0; i5 < i4; i5++) {
                if (!lockFreeBitArray.d((Long.MAX_VALUE & b5) % b4)) {
                    return false;
                }
                b5 += c4;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean k(@ParametricNullness T t3, Funnel<? super T> funnel, int i4, LockFreeBitArray lockFreeBitArray) {
            long b4 = lockFreeBitArray.b();
            byte[] e4 = Hashing.murmur3_128().hashObject(t3, funnel).e();
            long b5 = b(e4);
            long c4 = c(e4);
            boolean z3 = false;
            for (int i5 = 0; i5 < i4; i5++) {
                z3 |= lockFreeBitArray.g((Long.MAX_VALUE & b5) % b4);
                b5 += c4;
            }
            return z3;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class LockFreeBitArray {

        /* renamed from: a  reason: collision with root package name */
        final AtomicLongArray f27820a;

        /* renamed from: b  reason: collision with root package name */
        private final LongAddable f27821b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LockFreeBitArray(long j4) {
            Preconditions.checkArgument(j4 > 0, "data length is zero!");
            this.f27820a = new AtomicLongArray(Ints.checkedCast(LongMath.divide(j4, 64L, RoundingMode.CEILING)));
            this.f27821b = LongAddables.a();
        }

        public static long[] h(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i4 = 0; i4 < length; i4++) {
                jArr[i4] = atomicLongArray.get(i4);
            }
            return jArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long a() {
            return this.f27821b.sum();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long b() {
            return this.f27820a.length() * 64;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LockFreeBitArray c() {
            return new LockFreeBitArray(h(this.f27820a));
        }

        boolean d(long j4) {
            if (((1 << ((int) j4)) & this.f27820a.get((int) (j4 >>> 6))) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(LockFreeBitArray lockFreeBitArray) {
            boolean z3;
            if (this.f27820a.length() == lockFreeBitArray.f27820a.length()) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "BitArrays must be of equal length (%s != %s)", this.f27820a.length(), lockFreeBitArray.f27820a.length());
            for (int i4 = 0; i4 < this.f27820a.length(); i4++) {
                f(i4, lockFreeBitArray.f27820a.get(i4));
            }
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(h(this.f27820a), h(((LockFreeBitArray) obj).f27820a));
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(int i4, long j4) {
            long j5;
            long j6;
            boolean z3;
            while (true) {
                j5 = this.f27820a.get(i4);
                j6 = j5 | j4;
                if (j5 == j6) {
                    z3 = false;
                    break;
                } else if (this.f27820a.compareAndSet(i4, j5, j6)) {
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                this.f27821b.add(Long.bitCount(j6) - Long.bitCount(j5));
            }
        }

        boolean g(long j4) {
            long j5;
            long j6;
            if (d(j4)) {
                return false;
            }
            int i4 = (int) (j4 >>> 6);
            long j7 = 1 << ((int) j4);
            do {
                j5 = this.f27820a.get(i4);
                j6 = j5 | j7;
                if (j5 == j6) {
                    return false;
                }
            } while (!this.f27820a.compareAndSet(i4, j5, j6));
            this.f27821b.a();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(h(this.f27820a));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LockFreeBitArray(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.f27820a = new AtomicLongArray(jArr);
            this.f27821b = LongAddables.a();
            long j4 = 0;
            for (long j5 : jArr) {
                j4 += Long.bitCount(j5);
            }
            this.f27821b.add(j4);
        }
    }
}
