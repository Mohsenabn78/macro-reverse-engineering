package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {
    @CheckForNull
    @LazyInit

    /* renamed from: b  reason: collision with root package name */
    private transient ImmutableList<E> f26927b;
    @CheckForNull
    @LazyInit

    /* renamed from: c  reason: collision with root package name */
    private transient ImmutableSet<Multiset.Entry<E>> f26928c;

    /* loaded from: classes5.dex */
    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        ObjectCountHashMap<E> f26932a;

        /* renamed from: b  reason: collision with root package name */
        boolean f26933b;

        /* renamed from: c  reason: collision with root package name */
        boolean f26934c;

        public Builder() {
            this(4);
        }

        @CheckForNull
        static <T> ObjectCountHashMap<T> b(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return (ObjectCountHashMap<E>) ((RegularImmutableMultiset) iterable).f27357d;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return (ObjectCountHashMap<E>) ((AbstractMapBasedMultiset) iterable).f26664c;
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e4, int i4) {
            Objects.requireNonNull(this.f26932a);
            if (i4 == 0) {
                return this;
            }
            if (this.f26933b) {
                this.f26932a = new ObjectCountHashMap<>((ObjectCountHashMap<? extends E>) this.f26932a);
                this.f26934c = false;
            }
            this.f26933b = false;
            Preconditions.checkNotNull(e4);
            ObjectCountHashMap<E> objectCountHashMap = this.f26932a;
            objectCountHashMap.u(e4, i4 + objectCountHashMap.f(e4));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<E> setCount(E e4, int i4) {
            Objects.requireNonNull(this.f26932a);
            if (i4 == 0 && !this.f26934c) {
                this.f26932a = new ObjectCountLinkedHashMap(this.f26932a);
                this.f26934c = true;
            } else if (this.f26933b) {
                this.f26932a = new ObjectCountHashMap<>((ObjectCountHashMap<? extends E>) this.f26932a);
                this.f26934c = false;
            }
            this.f26933b = false;
            Preconditions.checkNotNull(e4);
            if (i4 == 0) {
                this.f26932a.v(e4);
            } else {
                this.f26932a.u(Preconditions.checkNotNull(e4), i4);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(int i4) {
            this.f26933b = false;
            this.f26934c = false;
            this.f26932a = ObjectCountHashMap.c(i4);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableMultiset<E> build() {
            Objects.requireNonNull(this.f26932a);
            if (this.f26932a.C() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.f26934c) {
                this.f26932a = new ObjectCountHashMap<>((ObjectCountHashMap<? extends E>) this.f26932a);
                this.f26934c = false;
            }
            this.f26933b = true;
            return new RegularImmutableMultiset(this.f26932a);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e4) {
            return addCopies(e4, 1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Objects.requireNonNull(this.f26932a);
            if (iterable instanceof Multiset) {
                Multiset d4 = Multisets.d(iterable);
                ObjectCountHashMap b4 = b(d4);
                if (b4 != null) {
                    ObjectCountHashMap<E> objectCountHashMap = this.f26932a;
                    objectCountHashMap.d(Math.max(objectCountHashMap.C(), b4.C()));
                    for (int e4 = b4.e(); e4 >= 0; e4 = b4.s(e4)) {
                        addCopies(b4.i(e4), b4.k(e4));
                    }
                } else {
                    Set<Multiset.Entry<E>> entrySet = d4.entrySet();
                    ObjectCountHashMap<E> objectCountHashMap2 = this.f26932a;
                    objectCountHashMap2.d(Math.max(objectCountHashMap2.C(), entrySet.size()));
                    for (Multiset.Entry<E> entry : d4.entrySet()) {
                        addCopies(entry.getElement(), entry.getCount());
                    }
                }
            } else {
                super.addAll((Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(boolean z3) {
            this.f26933b = false;
            this.f26934c = false;
            this.f26932a = null;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        @J2ktIncompatible
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        @J2ktIncompatible
        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (entry.getCount() <= 0 || ImmutableMultiset.this.count(entry.getElement()) != entry.getCount()) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return ImmutableMultiset.this.f();
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        /* renamed from: o */
        public Multiset.Entry<E> get(int i4) {
            return ImmutableMultiset.this.j(i4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @J2ktIncompatible
        @GwtIncompatible
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    /* loaded from: classes5.dex */
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return g(eArr);
    }

    private static <E> ImmutableMultiset<E> g(E... eArr) {
        return new Builder().add((Object[]) eArr).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMultiset<E> h(Collection<? extends Multiset.Entry<? extends E>> collection) {
        Builder builder = new Builder(collection.size());
        for (Multiset.Entry<? extends E> entry : collection) {
            builder.addCopies(entry.getElement(), entry.getCount());
        }
        return builder.build();
    }

    private ImmutableSet<Multiset.Entry<E>> i() {
        if (isEmpty()) {
            return ImmutableSet.of();
        }
        return new EntrySet();
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.f27356g;
    }

    @J2ktIncompatible
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int a(Object[] objArr, int i4) {
        UnmodifiableIterator<Multiset.Entry<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry<E> next = it.next();
            Arrays.fill(objArr, i4, next.getCount() + i4, next.getElement());
            i4 += next.getCount();
        }
        return i4;
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int add(E e4, int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f26927b;
        if (immutableList == null) {
            ImmutableList<E> asList = super.asList();
            this.f26927b = asList;
            return asList;
        }
        return immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (count(obj) > 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.Multiset
    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@CheckForNull Object obj) {
        return Multisets.f(this, obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.b(entrySet());
    }

    abstract Multiset.Entry<E> j(int i4);

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int remove(@CheckForNull Object obj, int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int setCount(E e4, int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @J2ktIncompatible
    @GwtIncompatible
    abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.f()) {
                return immutableMultiset;
            }
        }
        Builder builder = new Builder(Multisets.g(iterable));
        builder.addAll((Iterable) iterable);
        return builder.build();
    }

    public static <E> ImmutableMultiset<E> of(E e4) {
        return g(e4);
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.f26928c;
        if (immutableSet == null) {
            ImmutableSet<Multiset.Entry<E>> i4 = i();
            this.f26928c = i4;
            return i4;
        }
        return immutableSet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public UnmodifiableIterator<E> iterator() {
        final UnmodifiableIterator<Multiset.Entry<E>> it = entrySet().iterator();
        return new UnmodifiableIterator<E>(this) { // from class: com.google.common.collect.ImmutableMultiset.1

            /* renamed from: a  reason: collision with root package name */
            int f26929a;
            @CheckForNull

            /* renamed from: b  reason: collision with root package name */
            E f26930b;

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f26929a <= 0 && !it.hasNext()) {
                    return false;
                }
                return true;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.f26929a <= 0) {
                    Multiset.Entry entry = (Multiset.Entry) it.next();
                    this.f26930b = (E) entry.getElement();
                    this.f26929a = entry.getCount();
                }
                this.f26929a--;
                E e4 = this.f26930b;
                Objects.requireNonNull(e4);
                return e4;
            }
        };
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean setCount(E e4, int i4, int i5) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e4, E e5) {
        return g(e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e4, E e5, E e6) {
        return g(e4, e5, e6);
    }

    public static <E> ImmutableMultiset<E> of(E e4, E e5, E e6, E e7) {
        return g(e4, e5, e6, e7);
    }

    public static <E> ImmutableMultiset<E> of(E e4, E e5, E e6, E e7, E e8) {
        return g(e4, e5, e6, e7, e8);
    }

    public static <E> ImmutableMultiset<E> of(E e4, E e5, E e6, E e7, E e8, E e9, E... eArr) {
        return new Builder().add((Builder) e4).add((Builder<E>) e5).add((Builder<E>) e6).add((Builder<E>) e7).add((Builder<E>) e8).add((Builder<E>) e9).add((Object[]) eArr).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new Builder().addAll((Iterator) it).build();
    }
}
