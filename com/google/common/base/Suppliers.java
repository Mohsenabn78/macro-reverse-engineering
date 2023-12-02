package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Suppliers;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Suppliers {

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        volatile transient T f26388a;

        /* renamed from: b  reason: collision with root package name */
        volatile transient long f26389b;
        final Supplier<T> delegate;
        final long durationNanos;

        ExpiringMemoizingSupplier(Supplier<T> supplier, long j4, TimeUnit timeUnit) {
            boolean z3;
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
            this.durationNanos = timeUnit.toNanos(j4);
            if (j4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "duration (%s %s) must be > 0", j4, timeUnit);
        }

        @Override // com.google.common.base.Supplier
        @ParametricNullness
        public T get() {
            long j4 = this.f26389b;
            long nanoTime = System.nanoTime();
            if (j4 == 0 || nanoTime - j4 >= 0) {
                synchronized (this) {
                    if (j4 == this.f26389b) {
                        T t3 = this.delegate.get();
                        this.f26388a = t3;
                        long j5 = nanoTime + this.durationNanos;
                        if (j5 == 0) {
                            j5 = 1;
                        }
                        this.f26389b = j5;
                        return t3;
                    }
                }
            }
            return (T) NullnessCasts.a(this.f26388a);
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
        }
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a  reason: collision with root package name */
        volatile transient boolean f26390a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        transient T f26391b;
        final Supplier<T> delegate;

        MemoizingSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        @ParametricNullness
        public T get() {
            if (!this.f26390a) {
                synchronized (this) {
                    if (!this.f26390a) {
                        T t3 = this.delegate.get();
                        this.f26391b = t3;
                        this.f26390a = true;
                        return t3;
                    }
                }
            }
            return (T) NullnessCasts.a(this.f26391b);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f26390a) {
                obj = "<supplier that returned " + this.f26391b + ">";
            } else {
                obj = this.delegate;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {

        /* renamed from: c  reason: collision with root package name */
        private static final Supplier<Void> f26392c = new Supplier() { // from class: com.google.common.base.a
            @Override // com.google.common.base.Supplier
            public final Object get() {
                Void b4;
                b4 = Suppliers.NonSerializableMemoizingSupplier.b();
                return b4;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private volatile Supplier<T> f26393a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        private T f26394b;

        NonSerializableMemoizingSupplier(Supplier<T> supplier) {
            this.f26393a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.base.Supplier
        @ParametricNullness
        public T get() {
            Supplier<T> supplier = this.f26393a;
            Supplier<T> supplier2 = (Supplier<T>) f26392c;
            if (supplier != supplier2) {
                synchronized (this) {
                    if (this.f26393a != supplier2) {
                        T t3 = this.f26393a.get();
                        this.f26394b = t3;
                        this.f26393a = supplier2;
                        return t3;
                    }
                }
            }
            return (T) NullnessCasts.a(this.f26394b);
        }

        public String toString() {
            Object obj = this.f26393a;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == f26392c) {
                obj = "<supplier that returned " + this.f26394b + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* loaded from: classes5.dex */
    private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<? super F, T> function;
        final Supplier<F> supplier;

        SupplierComposition(Function<? super F, T> function, Supplier<F> supplier) {
            this.function = (Function) Preconditions.checkNotNull(function);
            this.supplier = (Supplier) Preconditions.checkNotNull(supplier);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            SupplierComposition supplierComposition = (SupplierComposition) obj;
            if (!this.function.equals(supplierComposition.function) || !this.supplier.equals(supplierComposition.supplier)) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.base.Supplier
        @ParametricNullness
        public T get() {
            return this.function.apply((F) this.supplier.get());
        }

        public int hashCode() {
            return Objects.hashCode(this.function, this.supplier);
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
        }
    }

    /* loaded from: classes5.dex */
    private interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    /* loaded from: classes5.dex */
    private enum SupplierFunctionImpl implements SupplierFunction<Object> {
        INSTANCE;

        @Override // com.google.common.base.Function
        @CheckForNull
        /* renamed from: b */
        public Object apply(Supplier<Object> supplier) {
            return supplier.get();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    /* loaded from: classes5.dex */
    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        @ParametricNullness
        final T instance;

        SupplierOfInstance(@ParametricNullness T t3) {
            this.instance = t3;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.equal(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        @ParametricNullness
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return Objects.hashCode(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    /* loaded from: classes5.dex */
    private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;

        ThreadSafeSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        @ParametricNullness
        public T get() {
            T t3;
            synchronized (this.delegate) {
                t3 = this.delegate.get();
            }
            return t3;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }
    }

    private Suppliers() {
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier) {
        return new SupplierComposition(function, supplier);
    }

    public static <T> Supplier<T> memoize(Supplier<T> supplier) {
        if (!(supplier instanceof NonSerializableMemoizingSupplier) && !(supplier instanceof MemoizingSupplier)) {
            if (supplier instanceof Serializable) {
                return new MemoizingSupplier(supplier);
            }
            return new NonSerializableMemoizingSupplier(supplier);
        }
        return supplier;
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> supplier, long j4, TimeUnit timeUnit) {
        return new ExpiringMemoizingSupplier(supplier, j4, timeUnit);
    }

    public static <T> Supplier<T> ofInstance(@ParametricNullness T t3) {
        return new SupplierOfInstance(t3);
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return SupplierFunctionImpl.INSTANCE;
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> supplier) {
        return new ThreadSafeSupplier(supplier);
    }
}
