package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    @CheckForNull
    private final T lowerEndpoint;
    private final BoundType upperBoundType;
    @CheckForNull
    private final T upperEndpoint;

    private GeneralRange(Comparator<? super T> comparator, boolean z3, @CheckForNull T t3, BoundType boundType, boolean z4, @CheckForNull T t4, BoundType boundType2) {
        boolean z5;
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        this.hasLowerBound = z3;
        this.hasUpperBound = z4;
        this.lowerEndpoint = t3;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t4;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z3) {
            comparator.compare((Object) NullnessCasts.a(t3), (Object) NullnessCasts.a(t3));
        }
        if (z4) {
            comparator.compare((Object) NullnessCasts.a(t4), (Object) NullnessCasts.a(t4));
        }
        if (z3 && z4) {
            int compare = comparator.compare((Object) NullnessCasts.a(t3), (Object) NullnessCasts.a(t4));
            boolean z6 = true;
            if (compare <= 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "lowerEndpoint (%s) > upperEndpoint (%s)", t3, t4);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                if (boundType == boundType3 && boundType2 == boundType3) {
                    z6 = false;
                }
                Preconditions.checkArgument(z6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> a(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange<>(comparator, false, null, boundType, false, null, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> e(Comparator<? super T> comparator, @ParametricNullness T t3, BoundType boundType) {
        return new GeneralRange<>(comparator, true, t3, boundType, false, null, BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> GeneralRange<T> p(Comparator<? super T> comparator, @ParametricNullness T t3, BoundType boundType) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, t3, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Comparator<? super T> b() {
        return this.comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(@ParametricNullness T t3) {
        if (!o(t3) && !n(t3)) {
            return true;
        }
        return false;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        if (!this.comparator.equals(generalRange.comparator) || this.hasLowerBound != generalRange.hasLowerBound || this.hasUpperBound != generalRange.hasUpperBound || !f().equals(generalRange.f()) || !h().equals(generalRange.h()) || !Objects.equal(g(), generalRange.g()) || !Objects.equal(i(), generalRange.i())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType f() {
        return this.lowerBoundType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public T g() {
        return this.lowerEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType h() {
        return this.upperBoundType;
    }

    public int hashCode() {
        return Objects.hashCode(this.comparator, g(), f(), i(), h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public T i() {
        return this.upperEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.hasLowerBound;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.hasUpperBound;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneralRange<T> m(GeneralRange<T> generalRange) {
        int compare;
        int compare2;
        T t3;
        BoundType boundType;
        BoundType boundType2;
        int compare3;
        BoundType boundType3;
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean z3 = this.hasLowerBound;
        T g4 = g();
        BoundType f4 = f();
        if (!j()) {
            z3 = generalRange.hasLowerBound;
            g4 = generalRange.g();
            f4 = generalRange.f();
        } else if (generalRange.j() && ((compare = this.comparator.compare(g(), generalRange.g())) < 0 || (compare == 0 && generalRange.f() == BoundType.OPEN))) {
            g4 = generalRange.g();
            f4 = generalRange.f();
        }
        boolean z4 = z3;
        boolean z5 = this.hasUpperBound;
        T i4 = i();
        BoundType h4 = h();
        if (!l()) {
            z5 = generalRange.hasUpperBound;
            i4 = generalRange.i();
            h4 = generalRange.h();
        } else if (generalRange.l() && ((compare2 = this.comparator.compare(i(), generalRange.i())) > 0 || (compare2 == 0 && generalRange.h() == BoundType.OPEN))) {
            i4 = generalRange.i();
            h4 = generalRange.h();
        }
        boolean z6 = z5;
        T t4 = i4;
        if (z4 && z6 && ((compare3 = this.comparator.compare(g4, t4)) > 0 || (compare3 == 0 && f4 == (boundType3 = BoundType.OPEN) && h4 == boundType3))) {
            boundType = BoundType.OPEN;
            boundType2 = BoundType.CLOSED;
            t3 = t4;
        } else {
            t3 = g4;
            boundType = f4;
            boundType2 = h4;
        }
        return new GeneralRange<>(this.comparator, z4, t3, boundType, z6, t4, boundType2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(@ParametricNullness T t3) {
        boolean z3;
        boolean z4;
        boolean z5 = false;
        if (!l()) {
            return false;
        }
        int compare = this.comparator.compare(t3, NullnessCasts.a(i()));
        if (compare > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (compare == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (h() == BoundType.OPEN) {
            z5 = true;
        }
        return (z4 & z5) | z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(@ParametricNullness T t3) {
        boolean z3;
        boolean z4;
        boolean z5 = false;
        if (!j()) {
            return false;
        }
        int compare = this.comparator.compare(t3, NullnessCasts.a(g()));
        if (compare < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (compare == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (f() == BoundType.OPEN) {
            z5 = true;
        }
        return (z4 & z5) | z3;
    }

    public String toString() {
        char c4;
        Object obj;
        Object obj2;
        char c5;
        StringBuilder sb = new StringBuilder();
        sb.append(this.comparator);
        sb.append(":");
        BoundType boundType = this.lowerBoundType;
        BoundType boundType2 = BoundType.CLOSED;
        if (boundType == boundType2) {
            c4 = TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH;
        } else {
            c4 = '(';
        }
        sb.append(c4);
        if (this.hasLowerBound) {
            obj = this.lowerEndpoint;
        } else {
            obj = "-∞";
        }
        sb.append(obj);
        sb.append(',');
        if (this.hasUpperBound) {
            obj2 = this.upperEndpoint;
        } else {
            obj2 = "∞";
        }
        sb.append(obj2);
        if (this.upperBoundType == boundType2) {
            c5 = ']';
        } else {
            c5 = ')';
        }
        sb.append(c5);
        return sb.toString();
    }
}
