package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ComparisonChain {

    /* renamed from: a  reason: collision with root package name */
    private static final ComparisonChain f26767a = new ComparisonChain() { // from class: com.google.common.collect.ComparisonChain.1
        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return d(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z3, boolean z4) {
            return d(Booleans.compare(z3, z4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z3, boolean z4) {
            return d(Booleans.compare(z4, z3));
        }

        ComparisonChain d(int i4) {
            if (i4 < 0) {
                return ComparisonChain.f26768b;
            }
            return i4 > 0 ? ComparisonChain.f26769c : ComparisonChain.f26767a;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return 0;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T t3, @ParametricNullness T t4, Comparator<T> comparator) {
            return d(comparator.compare(t3, t4));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i4, int i5) {
            return d(Ints.compare(i4, i5));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j4, long j5) {
            return d(Longs.compare(j4, j5));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f4, float f5) {
            return d(Float.compare(f4, f5));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d4, double d5) {
            return d(Double.compare(d4, d5));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final ComparisonChain f26768b = new InactiveComparisonChain(-1);

    /* renamed from: c  reason: collision with root package name */
    private static final ComparisonChain f26769c = new InactiveComparisonChain(1);

    /* loaded from: classes5.dex */
    private static final class InactiveComparisonChain extends ComparisonChain {

        /* renamed from: d  reason: collision with root package name */
        final int f26770d;

        InactiveComparisonChain(int i4) {
            super();
            this.f26770d = i4;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d4, double d5) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return this.f26770d;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f4, float f5) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i4, int i5) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j4, long j5) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T t3, @ParametricNullness T t4, Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z3, boolean z4) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z3, boolean z4) {
            return this;
        }
    }

    private ComparisonChain() {
    }

    public static ComparisonChain start() {
        return f26767a;
    }

    public abstract ComparisonChain compare(double d4, double d5);

    public abstract ComparisonChain compare(float f4, float f5);

    public abstract ComparisonChain compare(int i4, int i5);

    public abstract ComparisonChain compare(long j4, long j5);

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(@ParametricNullness T t3, @ParametricNullness T t4, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z3, boolean z4);

    public abstract ComparisonChain compareTrueFirst(boolean z3, boolean z4);

    public abstract int result();
}
