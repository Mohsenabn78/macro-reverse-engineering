package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import javax.annotation.CheckForNull;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Interners {

    /* loaded from: classes5.dex */
    public static class InternerBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final MapMaker f26979a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f26980b;

        public <E> Interner<E> build() {
            if (!this.f26980b) {
                this.f26979a.weakKeys();
            }
            return new InternerImpl(this.f26979a);
        }

        public InternerBuilder concurrencyLevel(int i4) {
            this.f26979a.concurrencyLevel(i4);
            return this;
        }

        public InternerBuilder strong() {
            this.f26980b = true;
            return this;
        }

        @GwtIncompatible("java.lang.ref.WeakReference")
        public InternerBuilder weak() {
            this.f26980b = false;
            return this;
        }

        private InternerBuilder() {
            this.f26979a = new MapMaker();
            this.f26980b = true;
        }
    }

    /* loaded from: classes5.dex */
    private static class InternerFunction<E> implements Function<E, E> {

        /* renamed from: a  reason: collision with root package name */
        private final Interner<E> f26981a;

        public InternerFunction(Interner<E> interner) {
            this.f26981a = interner;
        }

        @Override // com.google.common.base.Function
        public E apply(E e4) {
            return this.f26981a.intern(e4);
        }

        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof InternerFunction) {
                return this.f26981a.equals(((InternerFunction) obj).f26981a);
            }
            return false;
        }

        public int hashCode() {
            return this.f26981a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static final class InternerImpl<E> implements Interner<E> {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        final MapMakerInternalMap<E, MapMaker.Dummy, ?, ?> f26982a;

        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry] */
        @Override // com.google.common.collect.Interner
        public E intern(E e4) {
            E e5;
            do {
                ?? g4 = this.f26982a.g(e4);
                if (g4 != 0 && (e5 = (E) g4.getKey()) != null) {
                    return e5;
                }
            } while (this.f26982a.putIfAbsent(e4, MapMaker.Dummy.VALUE) != null);
            return e4;
        }

        private InternerImpl(MapMaker mapMaker) {
            this.f26982a = MapMakerInternalMap.f(mapMaker.f(Equivalence.equals()));
        }
    }

    private Interners() {
    }

    public static <E> Function<E, E> asFunction(Interner<E> interner) {
        return new InternerFunction((Interner) Preconditions.checkNotNull(interner));
    }

    public static InternerBuilder newBuilder() {
        return new InternerBuilder();
    }

    public static <E> Interner<E> newStrongInterner() {
        return newBuilder().strong().build();
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> Interner<E> newWeakInterner() {
        return newBuilder().weak().build();
    }
}
