package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    @J2ktIncompatible
    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: c  reason: collision with root package name */
    transient ObjectCountHashMap<E> f26664c;

    /* renamed from: d  reason: collision with root package name */
    transient long f26665d;

    /* loaded from: classes5.dex */
    abstract class Itr<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        int f26668a;

        /* renamed from: b  reason: collision with root package name */
        int f26669b = -1;

        /* renamed from: c  reason: collision with root package name */
        int f26670c;

        Itr() {
            this.f26668a = AbstractMapBasedMultiset.this.f26664c.e();
            this.f26670c = AbstractMapBasedMultiset.this.f26664c.f27311d;
        }

        private void a() {
            if (AbstractMapBasedMultiset.this.f26664c.f27311d == this.f26670c) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        @ParametricNullness
        abstract T b(int i4);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            if (this.f26668a >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (hasNext()) {
                T b4 = b(this.f26668a);
                int i4 = this.f26668a;
                this.f26669b = i4;
                this.f26668a = AbstractMapBasedMultiset.this.f26664c.s(i4);
                return b4;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z3;
            AbstractMapBasedMultiset abstractMapBasedMultiset;
            a();
            if (this.f26669b != -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            CollectPreconditions.e(z3);
            AbstractMapBasedMultiset.this.f26665d -= abstractMapBasedMultiset.f26664c.x(this.f26669b);
            this.f26668a = AbstractMapBasedMultiset.this.f26664c.t(this.f26668a, this.f26669b);
            this.f26669b = -1;
            this.f26670c = AbstractMapBasedMultiset.this.f26664c.f27311d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMapBasedMultiset(int i4) {
        this.f26664c = g(i4);
    }

    @J2ktIncompatible
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h4 = Serialization.h(objectInputStream);
        this.f26664c = g(3);
        Serialization.g(this, objectInputStream, h4);
    }

    @J2ktIncompatible
    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(@ParametricNullness E e4, int i4) {
        boolean z3;
        if (i4 == 0) {
            return count(e4);
        }
        boolean z4 = true;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "occurrences cannot be negative: %s", i4);
        int m4 = this.f26664c.m(e4);
        if (m4 == -1) {
            this.f26664c.u(e4, i4);
            this.f26665d += i4;
            return 0;
        }
        int k4 = this.f26664c.k(m4);
        long j4 = i4;
        long j5 = k4 + j4;
        if (j5 > 2147483647L) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "too many occurrences: %s", j5);
        this.f26664c.B(m4, (int) j5);
        this.f26665d += j4;
        return k4;
    }

    @Override // com.google.common.collect.AbstractMultiset
    final int b() {
        return this.f26664c.C();
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<E> c() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.1
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            @ParametricNullness
            E b(int i4) {
                return AbstractMapBasedMultiset.this.f26664c.i(i4);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f26664c.a();
        this.f26665d = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@CheckForNull Object obj) {
        return this.f26664c.f(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<Multiset.Entry<E>> e() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            /* renamed from: c */
            public Multiset.Entry<E> b(int i4) {
                return AbstractMapBasedMultiset.this.f26664c.g(i4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int e4 = this.f26664c.e();
        while (e4 >= 0) {
            multiset.add((E) this.f26664c.i(e4), this.f26664c.k(e4));
            e4 = this.f26664c.s(e4);
        }
    }

    abstract ObjectCountHashMap<E> g(int i4);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return Multisets.h(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(@CheckForNull Object obj, int i4) {
        boolean z3;
        if (i4 == 0) {
            return count(obj);
        }
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "occurrences cannot be negative: %s", i4);
        int m4 = this.f26664c.m(obj);
        if (m4 == -1) {
            return 0;
        }
        int k4 = this.f26664c.k(m4);
        if (k4 > i4) {
            this.f26664c.B(m4, k4 - i4);
        } else {
            this.f26664c.x(m4);
            i4 = k4;
        }
        this.f26665d -= i4;
        return k4;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(@ParametricNullness E e4, int i4) {
        CollectPreconditions.b(i4, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.f26664c;
        int v3 = i4 == 0 ? objectCountHashMap.v(e4) : objectCountHashMap.u(e4, i4);
        this.f26665d += i4 - v3;
        return v3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.f26665d);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean setCount(@ParametricNullness E e4, int i4, int i5) {
        CollectPreconditions.b(i4, "oldCount");
        CollectPreconditions.b(i5, "newCount");
        int m4 = this.f26664c.m(e4);
        if (m4 == -1) {
            if (i4 != 0) {
                return false;
            }
            if (i5 > 0) {
                this.f26664c.u(e4, i5);
                this.f26665d += i5;
            }
            return true;
        } else if (this.f26664c.k(m4) != i4) {
            return false;
        } else {
            if (i5 == 0) {
                this.f26664c.x(m4);
                this.f26665d -= i4;
            } else {
                this.f26664c.B(m4, i5);
                this.f26665d += i5 - i4;
            }
            return true;
        }
    }
}
