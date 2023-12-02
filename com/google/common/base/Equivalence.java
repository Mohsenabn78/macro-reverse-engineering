package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class Equivalence<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Equals extends Equivalence<Object> implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        static final Equals f26314a = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        private Object readResolve() {
            return f26314a;
        }

        @Override // com.google.common.base.Equivalence
        protected boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        protected int b(Object obj) {
            return obj.hashCode();
        }
    }

    /* loaded from: classes5.dex */
    private static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;
        @CheckForNull
        private final T target;

        EquivalentToPredicate(Equivalence<T> equivalence, @CheckForNull T t3) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.target = t3;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@CheckForNull T t3) {
            return this.equivalence.equivalent(t3, this.target);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            if (this.equivalence.equals(equivalentToPredicate.equivalence) && Objects.equal(this.target, equivalentToPredicate.target)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.equivalence, this.target);
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class Identity extends Equivalence<Object> implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        static final Identity f26315a = new Identity();
        private static final long serialVersionUID = 1;

        Identity() {
        }

        private Object readResolve() {
            return f26315a;
        }

        @Override // com.google.common.base.Equivalence
        protected boolean a(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        protected int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        @ParametricNullness
        private final T reference;

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Wrapper) {
                Wrapper wrapper = (Wrapper) obj;
                if (this.equivalence.equals(wrapper.equivalence)) {
                    return this.equivalence.equivalent((T) this.reference, (T) wrapper.reference);
                }
                return false;
            }
            return false;
        }

        @ParametricNullness
        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash((T) this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }

        private Wrapper(Equivalence<? super T> equivalence, @ParametricNullness T t3) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.reference = t3;
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.f26314a;
    }

    public static Equivalence<Object> identity() {
        return Identity.f26315a;
    }

    @ForOverride
    protected abstract boolean a(T t3, T t4);

    @ForOverride
    protected abstract int b(T t3);

    public final boolean equivalent(@CheckForNull T t3, @CheckForNull T t4) {
        if (t3 == t4) {
            return true;
        }
        if (t3 != null && t4 != null) {
            return a(t3, t4);
        }
        return false;
    }

    public final Predicate<T> equivalentTo(@CheckForNull T t3) {
        return new EquivalentToPredicate(this, t3);
    }

    public final int hash(@CheckForNull T t3) {
        if (t3 == null) {
            return 0;
        }
        return b(t3);
    }

    public final <F> Equivalence<F> onResultOf(Function<? super F, ? extends T> function) {
        return new FunctionalEquivalence(function, this);
    }

    @GwtCompatible(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> wrap(@ParametricNullness S s3) {
        return new Wrapper<>(s3);
    }
}
