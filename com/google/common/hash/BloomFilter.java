package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.LockFreeBitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* loaded from: classes5.dex */
    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.LockFreeBitArray.h(((BloomFilter) bloomFilter).bits.f27820a);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface Strategy extends Serializable {
        <T> boolean d(@ParametricNullness T t3, Funnel<? super T> funnel, int i4, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        <T> boolean k(@ParametricNullness T t3, Funnel<? super T> funnel, int i4, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i4, double d4) {
        return create(funnel, i4, d4);
    }

    @VisibleForTesting
    static <T> BloomFilter<T> g(Funnel<? super T> funnel, long j4, double d4, Strategy strategy) {
        boolean z3;
        boolean z4;
        Preconditions.checkNotNull(funnel);
        boolean z5 = true;
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Expected insertions (%s) must be >= 0", j4);
        if (d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "False positive probability (%s) must be > 0.0", Double.valueOf(d4));
        if (d4 >= 1.0d) {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "False positive probability (%s) must be < 1.0", Double.valueOf(d4));
        Preconditions.checkNotNull(strategy);
        if (i4 == 0) {
            j4 = 1;
        }
        long h4 = h(j4, d4);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(h4), i(j4, h4), funnel, strategy);
        } catch (IllegalArgumentException e4) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + h4 + " bits", e4);
        }
    }

    @VisibleForTesting
    static long h(long j4, double d4) {
        if (d4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d4 = Double.MIN_VALUE;
        }
        return (long) (((-j4) * Math.log(d4)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @VisibleForTesting
    static int i(long j4, long j5) {
        return Math.max(1, (int) Math.round((j5 / j4) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i4;
        int i5;
        DataInputStream dataInputStream;
        byte readByte;
        int readInt;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        byte b4 = -1;
        try {
            dataInputStream = new DataInputStream(inputStream);
            readByte = dataInputStream.readByte();
            try {
                i5 = UnsignedBytes.toInt(dataInputStream.readByte());
            } catch (RuntimeException e4) {
                e = e4;
                i5 = -1;
            }
            try {
                readInt = dataInputStream.readInt();
            } catch (RuntimeException e5) {
                e = e5;
                b4 = readByte;
                i4 = -1;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b4) + " numHashFunctions: " + i5 + " dataLength: " + i4, e);
            }
        } catch (RuntimeException e6) {
            e = e6;
            i4 = -1;
            i5 = -1;
        }
        try {
            BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
            BloomFilterStrategies.LockFreeBitArray lockFreeBitArray = new BloomFilterStrategies.LockFreeBitArray(LongMath.checkedMultiply(readInt, 64L));
            for (int i6 = 0; i6 < readInt; i6++) {
                lockFreeBitArray.f(i6, dataInputStream.readLong());
            }
            return new BloomFilter<>(lockFreeBitArray, i5, funnel, bloomFilterStrategies);
        } catch (RuntimeException e7) {
            e = e7;
            b4 = readByte;
            i4 = readInt;
            throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b4) + " numHashFunctions: " + i5 + " dataLength: " + i4, e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(@ParametricNullness T t3) {
        return mightContain(t3);
    }

    public long approximateElementCount() {
        double b4 = this.bits.b();
        return DoubleMath.roundToLong(((-Math.log1p(-(this.bits.a() / b4))) * b4) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        if (this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy)) {
            return true;
        }
        return false;
    }

    public double expectedFpp() {
        return Math.pow(this.bits.a() / f(), this.numHashFunctions);
    }

    @VisibleForTesting
    long f() {
        return this.bits.b();
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        if (this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && f() == bloomFilter.f() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel)) {
            return true;
        }
        return false;
    }

    public boolean mightContain(@ParametricNullness T t3) {
        return this.strategy.d(t3, this.funnel, this.numHashFunctions, this.bits);
    }

    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness T t3) {
        return this.strategy.k(t3, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        boolean z3;
        boolean z4;
        boolean z5;
        Preconditions.checkNotNull(bloomFilter);
        if (this != bloomFilter) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Cannot combine a BloomFilter with itself.");
        int i4 = this.numHashFunctions;
        int i5 = bloomFilter.numHashFunctions;
        if (i4 == i5) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "BloomFilters must have the same number of hash functions (%s != %s)", i4, i5);
        if (f() == bloomFilter.f()) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "BloomFilters must have the same size underlying bit arrays (%s != %s)", f(), bloomFilter.f());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.e(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f27820a.length());
        for (int i4 = 0; i4 < this.bits.f27820a.length(); i4++) {
            dataOutputStream.writeLong(this.bits.f27820a.get(i4));
        }
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i4, Funnel<? super T> funnel, Strategy strategy) {
        Preconditions.checkArgument(i4 > 0, "numHashFunctions (%s) must be > 0", i4);
        Preconditions.checkArgument(i4 <= 255, "numHashFunctions (%s) must be <= 255", i4);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(lockFreeBitArray);
        this.numHashFunctions = i4;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j4, double d4) {
        return g(funnel, j4, d4, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i4) {
        return create(funnel, i4);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j4) {
        return create(funnel, j4, 0.03d);
    }
}
