package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class Converter<A, B> implements Function<A, B> {
    @RetainedWith
    @CheckForNull
    @LazyInit

    /* renamed from: a  reason: collision with root package name */
    private transient Converter<B, A> f26305a;
    private final boolean handleNullAutomatically;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        A a(@CheckForNull C c4) {
            return this.first.a(this.second.a(c4));
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        C b(@CheckForNull A a4) {
            return this.second.b(this.first.b(a4));
        }

        @Override // com.google.common.base.Converter
        protected A e(C c4) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            if (!this.first.equals(converterComposition.first) || !this.second.equals(converterComposition.second)) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.base.Converter
        protected C f(A a4) {
            throw new AssertionError();
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    /* loaded from: classes5.dex */
    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        @Override // com.google.common.base.Converter
        protected A e(B b4) {
            return this.backwardFunction.apply(b4);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            if (!this.forwardFunction.equals(functionBasedConverter.forwardFunction) || !this.backwardFunction.equals(functionBasedConverter.backwardFunction)) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.base.Converter
        protected B f(A a4) {
            return this.forwardFunction.apply(a4);
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }
    }

    /* loaded from: classes5.dex */
    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        B a(@CheckForNull A a4) {
            return this.original.b(a4);
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        A b(@CheckForNull B b4) {
            return this.original.a(b4);
        }

        @Override // com.google.common.base.Converter
        protected B e(A a4) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        @Override // com.google.common.base.Converter
        protected A f(B b4) {
            throw new AssertionError();
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    private A g(@CheckForNull B b4) {
        return (A) e(NullnessCasts.a(b4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    private B h(@CheckForNull A a4) {
        return (B) f(NullnessCasts.a(a4));
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.f26310b;
    }

    @CheckForNull
    A a(@CheckForNull B b4) {
        if (this.handleNullAutomatically) {
            if (b4 == null) {
                return null;
            }
            return (A) Preconditions.checkNotNull(e(b4));
        }
        return g(b4);
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return c(converter);
    }

    @Override // com.google.common.base.Function
    @InlineMe(replacement = "this.convert(a)")
    @Deprecated
    public final B apply(A a4) {
        return convert(a4);
    }

    @CheckForNull
    B b(@CheckForNull A a4) {
        if (this.handleNullAutomatically) {
            if (a4 == null) {
                return null;
            }
            return (B) Preconditions.checkNotNull(f(a4));
        }
        return h(a4);
    }

    <C> Converter<A, C> c(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @CheckForNull
    public final B convert(@CheckForNull A a4) {
        return b(a4);
    }

    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() { // from class: com.google.common.base.Converter.1
            @Override // java.lang.Iterable
            public Iterator<B> iterator() {
                return new Iterator<B>() { // from class: com.google.common.base.Converter.1.1

                    /* renamed from: a  reason: collision with root package name */
                    private final Iterator<? extends A> f26308a;

                    {
                        this.f26308a = iterable.iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f26308a.hasNext();
                    }

                    @Override // java.util.Iterator
                    public B next() {
                        return (B) Converter.this.convert(this.f26308a.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f26308a.remove();
                    }
                };
            }
        };
    }

    @ForOverride
    protected abstract A e(B b4);

    @Override // com.google.common.base.Function
    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @ForOverride
    protected abstract B f(A a4);

    @CheckReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.f26305a;
        if (converter == null) {
            ReverseConverter reverseConverter = new ReverseConverter(this);
            this.f26305a = reverseConverter;
            return reverseConverter;
        }
        return converter;
    }

    Converter(boolean z3) {
        this.handleNullAutomatically = z3;
    }

    /* loaded from: classes5.dex */
    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        static final IdentityConverter<?> f26310b = new IdentityConverter<>();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return f26310b;
        }

        @Override // com.google.common.base.Converter
        <S> Converter<T, S> c(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        public String toString() {
            return "Converter.identity()";
        }

        @Override // com.google.common.base.Converter
        /* renamed from: i */
        public IdentityConverter<T> reverse() {
            return this;
        }

        @Override // com.google.common.base.Converter
        protected T e(T t3) {
            return t3;
        }

        @Override // com.google.common.base.Converter
        protected T f(T t3) {
            return t3;
        }
    }
}
