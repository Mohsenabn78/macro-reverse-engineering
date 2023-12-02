package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private transient Object f26751a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private transient int[] f26752b;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    transient Object[] f26753c;

    /* renamed from: d  reason: collision with root package name */
    private transient int f26754d;

    /* renamed from: e  reason: collision with root package name */
    private transient int f26755e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashSet() {
        r(3);
    }

    @CanIgnoreReturnValue
    private int A(int i4, int i5, int i6, int i7) {
        Object a4 = CompactHashing.a(i5);
        int i8 = i5 - 1;
        if (i7 != 0) {
            CompactHashing.i(a4, i6 & i8, i7 + 1);
        }
        Object x3 = x();
        int[] w3 = w();
        for (int i9 = 0; i9 <= i4; i9++) {
            int h4 = CompactHashing.h(x3, i9);
            while (h4 != 0) {
                int i10 = h4 - 1;
                int i11 = w3[i10];
                int b4 = CompactHashing.b(i11, i4) | i9;
                int i12 = b4 & i8;
                int h5 = CompactHashing.h(a4, i12);
                CompactHashing.i(a4, i12, h4);
                w3[i10] = CompactHashing.d(b4, h5, i8);
                h4 = CompactHashing.c(i11, i4);
            }
        }
        this.f26751a = a4;
        D(i8);
        return i8;
    }

    private void B(int i4, E e4) {
        v()[i4] = e4;
    }

    private void C(int i4, int i5) {
        w()[i4] = i5;
    }

    private void D(int i4) {
        this.f26754d = CompactHashing.d(this.f26754d, 32 - Integer.numberOfLeadingZeros(i4), 31);
    }

    public static <E> CompactHashSet<E> g() {
        return new CompactHashSet<>();
    }

    private Set<E> h(int i4) {
        return new LinkedHashSet(i4, 1.0f);
    }

    public static <E> CompactHashSet<E> i(int i4) {
        return new CompactHashSet<>(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E l(int i4) {
        return (E) v()[i4];
    }

    private int m(int i4) {
        return w()[i4];
    }

    private int p() {
        return (1 << (this.f26754d & 31)) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            r(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    private Object[] v() {
        Object[] objArr = this.f26753c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] w() {
        int[] iArr = this.f26752b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @J2ktIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    private Object x() {
        Object obj = this.f26751a;
        Objects.requireNonNull(obj);
        return obj;
    }

    private void z(int i4) {
        int min;
        int length = w().length;
        if (i4 > length && (min = Math.min((int) LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            y(min);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@ParametricNullness E e4) {
        if (u()) {
            e();
        }
        Set<E> j4 = j();
        if (j4 != null) {
            return j4.add(e4);
        }
        int[] w3 = w();
        Object[] v3 = v();
        int i4 = this.f26755e;
        int i5 = i4 + 1;
        int d4 = Hashing.d(e4);
        int p4 = p();
        int i6 = d4 & p4;
        int h4 = CompactHashing.h(x(), i6);
        if (h4 == 0) {
            if (i5 > p4) {
                p4 = A(p4, CompactHashing.e(p4), d4, i4);
            } else {
                CompactHashing.i(x(), i6, i5);
            }
        } else {
            int b4 = CompactHashing.b(d4, p4);
            int i7 = 0;
            while (true) {
                int i8 = h4 - 1;
                int i9 = w3[i8];
                if (CompactHashing.b(i9, p4) == b4 && com.google.common.base.Objects.equal(e4, v3[i8])) {
                    return false;
                }
                int c4 = CompactHashing.c(i9, p4);
                i7++;
                if (c4 == 0) {
                    if (i7 >= 9) {
                        return f().add(e4);
                    }
                    if (i5 > p4) {
                        p4 = A(p4, CompactHashing.e(p4), d4, i4);
                    } else {
                        w3[i8] = CompactHashing.d(i9, i5, p4);
                    }
                } else {
                    h4 = c4;
                }
            }
        }
        z(i5);
        s(i4, e4, d4, p4);
        this.f26755e = i5;
        q();
        return true;
    }

    int c(int i4, int i5) {
        return i4 - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (u()) {
            return;
        }
        q();
        Set<E> j4 = j();
        if (j4 != null) {
            this.f26754d = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            j4.clear();
            this.f26751a = null;
            this.f26755e = 0;
            return;
        }
        Arrays.fill(v(), 0, this.f26755e, (Object) null);
        CompactHashing.g(x());
        Arrays.fill(w(), 0, this.f26755e, 0);
        this.f26755e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (u()) {
            return false;
        }
        Set<E> j4 = j();
        if (j4 != null) {
            return j4.contains(obj);
        }
        int d4 = Hashing.d(obj);
        int p4 = p();
        int h4 = CompactHashing.h(x(), d4 & p4);
        if (h4 == 0) {
            return false;
        }
        int b4 = CompactHashing.b(d4, p4);
        do {
            int i4 = h4 - 1;
            int m4 = m(i4);
            if (CompactHashing.b(m4, p4) == b4 && com.google.common.base.Objects.equal(obj, l(i4))) {
                return true;
            }
            h4 = CompactHashing.c(m4, p4);
        } while (h4 != 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int e() {
        Preconditions.checkState(u(), "Arrays already allocated");
        int i4 = this.f26754d;
        int j4 = CompactHashing.j(i4);
        this.f26751a = CompactHashing.a(j4);
        D(j4 - 1);
        this.f26752b = new int[i4];
        this.f26753c = new Object[i4];
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @CanIgnoreReturnValue
    public Set<E> f() {
        Set<E> h4 = h(p() + 1);
        int n4 = n();
        while (n4 >= 0) {
            h4.add(l(n4));
            n4 = o(n4);
        }
        this.f26751a = h4;
        this.f26752b = null;
        this.f26753c = null;
        q();
        return h4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> j4 = j();
        if (j4 != null) {
            return j4.iterator();
        }
        return new Iterator<E>() { // from class: com.google.common.collect.CompactHashSet.1

            /* renamed from: a  reason: collision with root package name */
            int f26756a;

            /* renamed from: b  reason: collision with root package name */
            int f26757b;

            /* renamed from: c  reason: collision with root package name */
            int f26758c = -1;

            {
                this.f26756a = CompactHashSet.this.f26754d;
                this.f26757b = CompactHashSet.this.n();
            }

            private void a() {
                if (CompactHashSet.this.f26754d == this.f26756a) {
                    return;
                }
                throw new ConcurrentModificationException();
            }

            void b() {
                this.f26756a += 32;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f26757b >= 0) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public E next() {
                a();
                if (hasNext()) {
                    int i4 = this.f26757b;
                    this.f26758c = i4;
                    E e4 = (E) CompactHashSet.this.l(i4);
                    this.f26757b = CompactHashSet.this.o(this.f26757b);
                    return e4;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z3;
                a();
                if (this.f26758c >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                CollectPreconditions.e(z3);
                b();
                CompactHashSet compactHashSet = CompactHashSet.this;
                compactHashSet.remove(compactHashSet.l(this.f26758c));
                this.f26757b = CompactHashSet.this.c(this.f26757b, this.f26758c);
                this.f26758c = -1;
            }
        };
    }

    @VisibleForTesting
    @CheckForNull
    Set<E> j() {
        Object obj = this.f26751a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    int n() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    int o(int i4) {
        int i5 = i4 + 1;
        if (i5 >= this.f26755e) {
            return -1;
        }
        return i5;
    }

    void q() {
        this.f26754d += 32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i4) {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Expected size must be >= 0");
        this.f26754d = Ints.constrainToRange(i4, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj) {
        if (u()) {
            return false;
        }
        Set<E> j4 = j();
        if (j4 != null) {
            return j4.remove(obj);
        }
        int p4 = p();
        int f4 = CompactHashing.f(obj, null, p4, x(), w(), v(), null);
        if (f4 == -1) {
            return false;
        }
        t(f4, p4);
        this.f26755e--;
        q();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i4, @ParametricNullness E e4, int i5, int i6) {
        C(i4, CompactHashing.d(i5, 0, i6));
        B(i4, e4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> j4 = j();
        if (j4 != null) {
            return j4.size();
        }
        return this.f26755e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i4, int i5) {
        Object x3 = x();
        int[] w3 = w();
        Object[] v3 = v();
        int size = size() - 1;
        if (i4 < size) {
            Object obj = v3[size];
            v3[i4] = obj;
            v3[size] = null;
            w3[i4] = w3[size];
            w3[size] = 0;
            int d4 = Hashing.d(obj) & i5;
            int h4 = CompactHashing.h(x3, d4);
            int i6 = size + 1;
            if (h4 == i6) {
                CompactHashing.i(x3, d4, i4 + 1);
                return;
            }
            while (true) {
                int i7 = h4 - 1;
                int i8 = w3[i7];
                int c4 = CompactHashing.c(i8, i5);
                if (c4 == i6) {
                    w3[i7] = CompactHashing.d(i8, i4 + 1, i5);
                    return;
                }
                h4 = c4;
            }
        } else {
            v3[i4] = null;
            w3[i4] = 0;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (u()) {
            return new Object[0];
        }
        Set<E> j4 = j();
        return j4 != null ? j4.toArray() : Arrays.copyOf(v(), this.f26755e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean u() {
        if (this.f26751a == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i4) {
        this.f26752b = Arrays.copyOf(w(), i4);
        this.f26753c = Arrays.copyOf(v(), i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashSet(int i4) {
        r(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        if (u()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set<E> j4 = j();
        if (j4 != null) {
            return (T[]) j4.toArray(tArr);
        }
        return (T[]) ObjectArrays.g(v(), 0, this.f26755e, tArr);
    }
}
