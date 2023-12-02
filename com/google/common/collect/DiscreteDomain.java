package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class DiscreteDomain<C extends Comparable> {
    final boolean supportsFastOffset;

    /* loaded from: classes5.dex */
    private static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private static final BigIntegerDomain f26792a = new BigIntegerDomain();

        /* renamed from: b  reason: collision with root package name */
        private static final BigInteger f26793b = BigInteger.valueOf(Long.MIN_VALUE);

        /* renamed from: c  reason: collision with root package name */
        private static final BigInteger f26794c = BigInteger.valueOf(Long.MAX_VALUE);
        private static final long serialVersionUID = 0;

        BigIntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f26792a;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: c */
        public long distance(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(f26793b).min(f26794c).longValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: e */
        public BigInteger next(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: f */
        public BigInteger a(BigInteger bigInteger, long j4) {
            CollectPreconditions.c(j4, "distance");
            return bigInteger.add(BigInteger.valueOf(j4));
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: g */
        public BigInteger previous(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    /* loaded from: classes5.dex */
    private static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private static final IntegerDomain f26795a = new IntegerDomain();
        private static final long serialVersionUID = 0;

        IntegerDomain() {
            super(true);
        }

        private Object readResolve() {
            return f26795a;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: c */
        public long distance(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: e */
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: f */
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        /* renamed from: g */
        public Integer next(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: h */
        public Integer a(Integer num, long j4) {
            CollectPreconditions.c(j4, "distance");
            return Integer.valueOf(Ints.checkedCast(num.longValue() + j4));
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        /* renamed from: i */
        public Integer previous(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    /* loaded from: classes5.dex */
    private static final class LongDomain extends DiscreteDomain<Long> implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private static final LongDomain f26796a = new LongDomain();
        private static final long serialVersionUID = 0;

        LongDomain() {
            super(true);
        }

        private Object readResolve() {
            return f26796a;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: c */
        public long distance(Long l4, Long l5) {
            long longValue = l5.longValue() - l4.longValue();
            if (l5.longValue() > l4.longValue() && longValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l5.longValue() < l4.longValue() && longValue > 0) {
                return Long.MIN_VALUE;
            }
            return longValue;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: e */
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: f */
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        /* renamed from: g */
        public Long next(Long l4) {
            long longValue = l4.longValue();
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(longValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DiscreteDomain
        /* renamed from: h */
        public Long a(Long l4, long j4) {
            boolean z3;
            CollectPreconditions.c(j4, "distance");
            long longValue = l4.longValue() + j4;
            if (longValue < 0) {
                if (l4.longValue() < 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "overflow");
            }
            return Long.valueOf(longValue);
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        /* renamed from: i */
        public Long previous(Long l4) {
            long longValue = l4.longValue();
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(longValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.f26792a;
    }

    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.f26795a;
    }

    public static DiscreteDomain<Long> longs() {
        return LongDomain.f26796a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C a(C c4, long j4) {
        CollectPreconditions.c(j4, "distance");
        C c5 = c4;
        for (long j5 = 0; j5 < j4; j5++) {
            c5 = next(c5);
            if (c5 == null) {
                throw new IllegalArgumentException("overflowed computing offset(" + c4 + ", " + j4 + ")");
            }
        }
        return c5;
    }

    public abstract long distance(C c4, C c5);

    @CanIgnoreReturnValue
    public C maxValue() {
        throw new NoSuchElementException();
    }

    @CanIgnoreReturnValue
    public C minValue() {
        throw new NoSuchElementException();
    }

    @CheckForNull
    public abstract C next(C c4);

    @CheckForNull
    public abstract C previous(C c4);

    protected DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean z3) {
        this.supportsFastOffset = z3;
    }
}
