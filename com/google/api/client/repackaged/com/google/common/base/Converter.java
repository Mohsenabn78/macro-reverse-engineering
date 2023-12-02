package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes5.dex */
public abstract class Converter<A, B> implements Function<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private transient Converter<B, A> f25941a;
    private final boolean handleNullAutomatically;

    /* loaded from: classes5.dex */
    private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        @Nullable
        A a(@Nullable C c4) {
            return this.first.a(this.second.a(c4));
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        @Nullable
        C b(@Nullable A a4) {
            return this.second.b(this.first.b(a4));
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        protected A c(C c4) {
            throw new AssertionError();
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        protected C e(A a4) {
            throw new AssertionError();
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter, com.google.api.client.repackaged.com.google.common.base.Function
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            if (!this.first.equals(converterComposition.first) || !this.second.equals(converterComposition.second)) {
                return false;
            }
            return true;
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

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        protected A c(B b4) {
            return this.backwardFunction.apply(b4);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        protected B e(A a4) {
            return this.forwardFunction.apply(a4);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter, com.google.api.client.repackaged.com.google.common.base.Function
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            if (!this.forwardFunction.equals(functionBasedConverter.forwardFunction) || !this.backwardFunction.equals(functionBasedConverter.backwardFunction)) {
                return false;
            }
            return true;
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

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        @Nullable
        B a(@Nullable A a4) {
            return this.original.b(a4);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        @Nullable
        A b(@Nullable B b4) {
            return this.original.a(b4);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        protected B c(A a4) {
            throw new AssertionError();
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        protected A e(B b4) {
            throw new AssertionError();
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter, com.google.api.client.repackaged.com.google.common.base.Function
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
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

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.f25946b;
    }

    @Nullable
    A a(@Nullable B b4) {
        if (this.handleNullAutomatically) {
            if (b4 == null) {
                return null;
            }
            return (A) Preconditions.checkNotNull(c(b4));
        }
        return c(b4);
    }

    public <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Function
    @Nullable
    @Deprecated
    public final B apply(@Nullable A a4) {
        return convert(a4);
    }

    @Nullable
    B b(@Nullable A a4) {
        if (this.handleNullAutomatically) {
            if (a4 == null) {
                return null;
            }
            return (B) Preconditions.checkNotNull(e(a4));
        }
        return e(a4);
    }

    protected abstract A c(B b4);

    @Nullable
    public final B convert(@Nullable A a4) {
        return b(a4);
    }

    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() { // from class: com.google.api.client.repackaged.com.google.common.base.Converter.1
            @Override // java.lang.Iterable
            public Iterator<B> iterator() {
                return new Iterator<B>() { // from class: com.google.api.client.repackaged.com.google.common.base.Converter.1.1

                    /* renamed from: a  reason: collision with root package name */
                    private final Iterator<? extends A> f25944a;

                    {
                        this.f25944a = iterable.iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f25944a.hasNext();
                    }

                    @Override // java.util.Iterator
                    public B next() {
                        return (B) Converter.this.convert(this.f25944a.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.f25944a.remove();
                    }
                };
            }
        };
    }

    protected abstract B e(A a4);

    @Override // com.google.api.client.repackaged.com.google.common.base.Function
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.f25941a;
        if (converter == null) {
            ReverseConverter reverseConverter = new ReverseConverter(this);
            this.f25941a = reverseConverter;
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
        static final IdentityConverter f25946b = new IdentityConverter();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return f25946b;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        public <S> Converter<T, S> andThen(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        public String toString() {
            return "Converter.identity()";
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        /* renamed from: f */
        public IdentityConverter<T> reverse() {
            return this;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        protected T c(T t3) {
            return t3;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        protected T e(T t3) {
            return t3;
        }
    }
}
