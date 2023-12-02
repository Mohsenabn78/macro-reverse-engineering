package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: c  reason: collision with root package name */
    private transient Class<E> f26802c;

    /* renamed from: d  reason: collision with root package name */
    private transient E[] f26803d;

    /* renamed from: e  reason: collision with root package name */
    private transient int[] f26804e;

    /* renamed from: f  reason: collision with root package name */
    private transient int f26805f;

    /* renamed from: g  reason: collision with root package name */
    private transient long f26806g;

    /* loaded from: classes5.dex */
    abstract class Itr<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        int f26811a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f26812b = -1;

        Itr() {
        }

        abstract T a(int i4);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.f26811a < EnumMultiset.this.f26803d.length) {
                int[] iArr = EnumMultiset.this.f26804e;
                int i4 = this.f26811a;
                if (iArr[i4] > 0) {
                    return true;
                }
                this.f26811a = i4 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T a4 = a(this.f26811a);
                int i4 = this.f26811a;
                this.f26812b = i4;
                this.f26811a = i4 + 1;
                return a4;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z3;
            if (this.f26812b >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            CollectPreconditions.e(z3);
            if (EnumMultiset.this.f26804e[this.f26812b] > 0) {
                EnumMultiset.h(EnumMultiset.this);
                EnumMultiset enumMultiset = EnumMultiset.this;
                EnumMultiset.i(enumMultiset, enumMultiset.f26804e[this.f26812b]);
                EnumMultiset.this.f26804e[this.f26812b] = 0;
            }
            this.f26812b = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.f26802c = cls;
        Preconditions.checkArgument(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.f26803d = enumConstants;
        this.f26804e = new int[enumConstants.length];
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    static /* synthetic */ int h(EnumMultiset enumMultiset) {
        int i4 = enumMultiset.f26805f;
        enumMultiset.f26805f = i4 - 1;
        return i4;
    }

    static /* synthetic */ long i(EnumMultiset enumMultiset, long j4) {
        long j5 = enumMultiset.f26806g - j4;
        enumMultiset.f26806g = j5;
        return j5;
    }

    private void j(Object obj) {
        Preconditions.checkNotNull(obj);
        if (l(obj)) {
            return;
        }
        throw new ClassCastException("Expected an " + this.f26802c + " but got " + obj);
    }

    private boolean l(@CheckForNull Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r5 = (Enum) obj;
        int ordinal = r5.ordinal();
        E[] eArr = this.f26803d;
        if (ordinal >= eArr.length || eArr[ordinal] != r5) {
            return false;
        }
        return true;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.f26802c = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.f26803d = enumConstants;
        this.f26804e = new int[enumConstants.length];
        Serialization.f(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f26802c);
        Serialization.k(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ int add(Object obj, int i4) {
        return add((EnumMultiset<E>) ((Enum) obj), i4);
    }

    @Override // com.google.common.collect.AbstractMultiset
    int b() {
        return this.f26805f;
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> c() {
        return new EnumMultiset<E>.Itr<E>() { // from class: com.google.common.collect.EnumMultiset.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.EnumMultiset.Itr
            /* renamed from: b */
            public E a(int i4) {
                return (E) EnumMultiset.this.f26803d[i4];
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.f26804e, 0);
        this.f26806g = 0L;
        this.f26805f = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        if (obj != null && l(obj)) {
            return this.f26804e[((Enum) obj).ordinal()];
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> e() {
        return new EnumMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.EnumMultiset.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.EnumMultiset.Itr
            /* renamed from: b */
            public Multiset.Entry<E> a(final int i4) {
                return new Multisets.AbstractEntry<E>() { // from class: com.google.common.collect.EnumMultiset.2.1
                    @Override // com.google.common.collect.Multiset.Entry
                    /* renamed from: a */
                    public E getElement() {
                        return (E) EnumMultiset.this.f26803d[i4];
                    }

                    @Override // com.google.common.collect.Multiset.Entry
                    public int getCount() {
                        return EnumMultiset.this.f26804e[i4];
                    }
                };
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.h(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i4) {
        if (obj == null || !l(obj)) {
            return 0;
        }
        Enum r12 = (Enum) obj;
        CollectPreconditions.b(i4, "occurrences");
        if (i4 == 0) {
            return count(obj);
        }
        int ordinal = r12.ordinal();
        int[] iArr = this.f26804e;
        int i5 = iArr[ordinal];
        if (i5 == 0) {
            return 0;
        }
        if (i5 <= i4) {
            iArr[ordinal] = 0;
            this.f26805f--;
            this.f26806g -= i5;
        } else {
            iArr[ordinal] = i5 - i4;
            this.f26806g -= i4;
        }
        return i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i4) {
        return setCount((EnumMultiset<E>) ((Enum) obj), i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.f26806g);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    @CanIgnoreReturnValue
    public int add(E e4, int i4) {
        j(e4);
        CollectPreconditions.b(i4, "occurrences");
        if (i4 == 0) {
            return count(e4);
        }
        int ordinal = e4.ordinal();
        int i5 = this.f26804e[ordinal];
        long j4 = i4;
        long j5 = i5 + j4;
        Preconditions.checkArgument(j5 <= 2147483647L, "too many occurrences: %s", j5);
        this.f26804e[ordinal] = (int) j5;
        if (i5 == 0) {
            this.f26805f++;
        }
        this.f26806g += j4;
        return i5;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean setCount(@ParametricNullness Object obj, int i4, int i5) {
        return super.setCount(obj, i4, i5);
    }

    @CanIgnoreReturnValue
    public int setCount(E e4, int i4) {
        j(e4);
        CollectPreconditions.b(i4, "count");
        int ordinal = e4.ordinal();
        int[] iArr = this.f26804e;
        int i5 = iArr[ordinal];
        iArr[ordinal] = i4;
        this.f26806g += i4 - i5;
        if (i5 == 0 && i4 > 0) {
            this.f26805f++;
        } else if (i5 > 0 && i4 == 0) {
            this.f26805f--;
        }
        return i5;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        Iterables.addAll(create, iterable);
        return create;
    }
}
