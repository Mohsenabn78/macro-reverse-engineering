package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: j  reason: collision with root package name */
    private static final Object f26728j = new Object();
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private transient Object f26729a;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    transient int[] f26730b;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    transient Object[] f26731c;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    transient Object[] f26732d;

    /* renamed from: e  reason: collision with root package name */
    private transient int f26733e;

    /* renamed from: f  reason: collision with root package name */
    private transient int f26734f;
    @CheckForNull

    /* renamed from: g  reason: collision with root package name */
    private transient Set<K> f26735g;
    @CheckForNull

    /* renamed from: h  reason: collision with root package name */
    private transient Set<Map.Entry<K, V>> f26736h;
    @CheckForNull

    /* renamed from: i  reason: collision with root package name */
    private transient Collection<V> f26737i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            Map<K, V> A = CompactHashMap.this.A();
            if (A != null) {
                return A.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int H = CompactHashMap.this.H(entry.getKey());
            if (H == -1 || !Objects.equal(CompactHashMap.this.a0(H), entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.C();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> A = CompactHashMap.this.A();
            if (A != null) {
                return A.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!CompactHashMap.this.N()) {
                int F = CompactHashMap.this.F();
                int f4 = CompactHashing.f(entry.getKey(), entry.getValue(), F, CompactHashMap.this.R(), CompactHashMap.this.P(), CompactHashMap.this.Q(), CompactHashMap.this.S());
                if (f4 == -1) {
                    return false;
                }
                CompactHashMap.this.M(f4, F);
                CompactHashMap.g(CompactHashMap.this);
                CompactHashMap.this.G();
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* loaded from: classes5.dex */
    private abstract class Itr<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        int f26742a;

        /* renamed from: b  reason: collision with root package name */
        int f26743b;

        /* renamed from: c  reason: collision with root package name */
        int f26744c;

        private Itr() {
            this.f26742a = CompactHashMap.this.f26733e;
            this.f26743b = CompactHashMap.this.D();
            this.f26744c = -1;
        }

        private void a() {
            if (CompactHashMap.this.f26733e == this.f26742a) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        @ParametricNullness
        abstract T b(int i4);

        void c() {
            this.f26742a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f26743b >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            a();
            if (hasNext()) {
                int i4 = this.f26743b;
                this.f26744c = i4;
                T b4 = b(i4);
                this.f26743b = CompactHashMap.this.E(this.f26743b);
                return b4;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z3;
            a();
            if (this.f26744c >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            CollectPreconditions.e(z3);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.K(this.f26744c));
            this.f26743b = CompactHashMap.this.r(this.f26743b, this.f26744c);
            this.f26744c = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.L();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            Map<K, V> A = CompactHashMap.this.A();
            if (A != null) {
                return A.keySet().remove(obj);
            }
            if (CompactHashMap.this.O(obj) != CompactHashMap.f26728j) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class MapEntry extends AbstractMapEntry<K, V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        private final K f26747a;

        /* renamed from: b  reason: collision with root package name */
        private int f26748b;

        MapEntry(int i4) {
            this.f26747a = (K) CompactHashMap.this.K(i4);
            this.f26748b = i4;
        }

        private void f() {
            int i4 = this.f26748b;
            if (i4 == -1 || i4 >= CompactHashMap.this.size() || !Objects.equal(this.f26747a, CompactHashMap.this.K(this.f26748b))) {
                this.f26748b = CompactHashMap.this.H(this.f26747a);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.f26747a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            Map<K, V> A = CompactHashMap.this.A();
            if (A != null) {
                return (V) NullnessCasts.a(A.get(this.f26747a));
            }
            f();
            int i4 = this.f26748b;
            if (i4 != -1) {
                return (V) CompactHashMap.this.a0(i4);
            }
            return (V) NullnessCasts.b();
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V v3) {
            Map<K, V> A = CompactHashMap.this.A();
            if (A != null) {
                return (V) NullnessCasts.a(A.put(this.f26747a, v3));
            }
            f();
            int i4 = this.f26748b;
            if (i4 != -1) {
                V v4 = (V) CompactHashMap.this.a0(i4);
                CompactHashMap.this.Z(this.f26748b, v3);
                return v4;
            }
            CompactHashMap.this.put(this.f26747a, v3);
            return (V) NullnessCasts.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.b0();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    CompactHashMap() {
        I(3);
    }

    private int B(int i4) {
        return P()[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F() {
        return (1 << (this.f26733e & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H(@CheckForNull Object obj) {
        if (N()) {
            return -1;
        }
        int d4 = Hashing.d(obj);
        int F = F();
        int h4 = CompactHashing.h(R(), d4 & F);
        if (h4 == 0) {
            return -1;
        }
        int b4 = CompactHashing.b(d4, F);
        do {
            int i4 = h4 - 1;
            int B = B(i4);
            if (CompactHashing.b(B, F) == b4 && Objects.equal(obj, K(i4))) {
                return i4;
            }
            h4 = CompactHashing.c(B, F);
        } while (h4 != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K K(int i4) {
        return (K) Q()[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object O(@CheckForNull Object obj) {
        if (N()) {
            return f26728j;
        }
        int F = F();
        int f4 = CompactHashing.f(obj, null, F, R(), P(), Q(), null);
        if (f4 == -1) {
            return f26728j;
        }
        V a02 = a0(f4);
        M(f4, F);
        this.f26734f--;
        G();
        return a02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] P() {
        int[] iArr = this.f26730b;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] Q() {
        Object[] objArr = this.f26731c;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object R() {
        Object obj = this.f26729a;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] S() {
        Object[] objArr = this.f26732d;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    private void U(int i4) {
        int min;
        int length = P().length;
        if (i4 > length && (min = Math.min((int) LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            T(min);
        }
    }

    @CanIgnoreReturnValue
    private int V(int i4, int i5, int i6, int i7) {
        Object a4 = CompactHashing.a(i5);
        int i8 = i5 - 1;
        if (i7 != 0) {
            CompactHashing.i(a4, i6 & i8, i7 + 1);
        }
        Object R = R();
        int[] P = P();
        for (int i9 = 0; i9 <= i4; i9++) {
            int h4 = CompactHashing.h(R, i9);
            while (h4 != 0) {
                int i10 = h4 - 1;
                int i11 = P[i10];
                int b4 = CompactHashing.b(i11, i4) | i9;
                int i12 = b4 & i8;
                int h5 = CompactHashing.h(a4, i12);
                CompactHashing.i(a4, i12, h4);
                P[i10] = CompactHashing.d(b4, h5, i8);
                h4 = CompactHashing.c(i11, i4);
            }
        }
        this.f26729a = a4;
        X(i8);
        return i8;
    }

    private void W(int i4, int i5) {
        P()[i4] = i5;
    }

    private void X(int i4) {
        this.f26733e = CompactHashing.d(this.f26733e, 32 - Integer.numberOfLeadingZeros(i4), 31);
    }

    private void Y(int i4, K k4) {
        Q()[i4] = k4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i4, V v3) {
        S()[i4] = v3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V a0(int i4) {
        return (V) S()[i4];
    }

    static /* synthetic */ int g(CompactHashMap compactHashMap) {
        int i4 = compactHashMap.f26734f;
        compactHashMap.f26734f = i4 - 1;
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            I(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    public static <K, V> CompactHashMap<K, V> u() {
        return new CompactHashMap<>();
    }

    @J2ktIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> C = C();
        while (C.hasNext()) {
            Map.Entry<K, V> next = C.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    public static <K, V> CompactHashMap<K, V> z(int i4) {
        return new CompactHashMap<>(i4);
    }

    @VisibleForTesting
    @CheckForNull
    Map<K, V> A() {
        Object obj = this.f26729a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    Iterator<Map.Entry<K, V>> C() {
        Map<K, V> A = A();
        if (A != null) {
            return A.entrySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.common.collect.CompactHashMap.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.CompactHashMap.Itr
            /* renamed from: d */
            public Map.Entry<K, V> b(int i4) {
                return new MapEntry(i4);
            }
        };
    }

    int D() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    int E(int i4) {
        int i5 = i4 + 1;
        if (i5 >= this.f26734f) {
            return -1;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        this.f26733e += 32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i4) {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Expected size must be >= 0");
        this.f26733e = Ints.constrainToRange(i4, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i4, @ParametricNullness K k4, @ParametricNullness V v3, int i5, int i6) {
        W(i4, CompactHashing.d(i5, 0, i6));
        Y(i4, k4);
        Z(i4, v3);
    }

    Iterator<K> L() {
        Map<K, V> A = A();
        if (A != null) {
            return A.keySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<K>() { // from class: com.google.common.collect.CompactHashMap.1
            @Override // com.google.common.collect.CompactHashMap.Itr
            @ParametricNullness
            K b(int i4) {
                return (K) CompactHashMap.this.K(i4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(int i4, int i5) {
        Object R = R();
        int[] P = P();
        Object[] Q = Q();
        Object[] S = S();
        int size = size() - 1;
        if (i4 < size) {
            Object obj = Q[size];
            Q[i4] = obj;
            S[i4] = S[size];
            Q[size] = null;
            S[size] = null;
            P[i4] = P[size];
            P[size] = 0;
            int d4 = Hashing.d(obj) & i5;
            int h4 = CompactHashing.h(R, d4);
            int i6 = size + 1;
            if (h4 == i6) {
                CompactHashing.i(R, d4, i4 + 1);
                return;
            }
            while (true) {
                int i7 = h4 - 1;
                int i8 = P[i7];
                int c4 = CompactHashing.c(i8, i5);
                if (c4 == i6) {
                    P[i7] = CompactHashing.d(i8, i4 + 1, i5);
                    return;
                }
                h4 = c4;
            }
        } else {
            Q[i4] = null;
            S[i4] = null;
            P[i4] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean N() {
        if (this.f26729a == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i4) {
        this.f26730b = Arrays.copyOf(P(), i4);
        this.f26731c = Arrays.copyOf(Q(), i4);
        this.f26732d = Arrays.copyOf(S(), i4);
    }

    Iterator<V> b0() {
        Map<K, V> A = A();
        if (A != null) {
            return A.values().iterator();
        }
        return new CompactHashMap<K, V>.Itr<V>() { // from class: com.google.common.collect.CompactHashMap.3
            @Override // com.google.common.collect.CompactHashMap.Itr
            @ParametricNullness
            V b(int i4) {
                return (V) CompactHashMap.this.a0(i4);
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (N()) {
            return;
        }
        G();
        Map<K, V> A = A();
        if (A != null) {
            this.f26733e = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            A.clear();
            this.f26729a = null;
            this.f26734f = 0;
            return;
        }
        Arrays.fill(Q(), 0, this.f26734f, (Object) null);
        Arrays.fill(S(), 0, this.f26734f, (Object) null);
        CompactHashing.g(R());
        Arrays.fill(P(), 0, this.f26734f, 0);
        this.f26734f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        Map<K, V> A = A();
        if (A != null) {
            return A.containsKey(obj);
        }
        if (H(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        Map<K, V> A = A();
        if (A != null) {
            return A.containsValue(obj);
        }
        for (int i4 = 0; i4 < this.f26734f; i4++) {
            if (Objects.equal(obj, a0(i4))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f26736h;
        if (set == null) {
            Set<Map.Entry<K, V>> v3 = v();
            this.f26736h = v3;
            return v3;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        Map<K, V> A = A();
        if (A != null) {
            return A.get(obj);
        }
        int H = H(obj);
        if (H == -1) {
            return null;
        }
        q(H);
        return a0(H);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f26735g;
        if (set == null) {
            Set<K> x3 = x();
            this.f26735g = x3;
            return x3;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness K k4, @ParametricNullness V v3) {
        int V;
        int i4;
        if (N()) {
            s();
        }
        Map<K, V> A = A();
        if (A != null) {
            return A.put(k4, v3);
        }
        int[] P = P();
        Object[] Q = Q();
        Object[] S = S();
        int i5 = this.f26734f;
        int i6 = i5 + 1;
        int d4 = Hashing.d(k4);
        int F = F();
        int i7 = d4 & F;
        int h4 = CompactHashing.h(R(), i7);
        if (h4 == 0) {
            if (i6 > F) {
                V = V(F, CompactHashing.e(F), d4, i5);
                i4 = V;
            } else {
                CompactHashing.i(R(), i7, i6);
                i4 = F;
            }
        } else {
            int b4 = CompactHashing.b(d4, F);
            int i8 = 0;
            while (true) {
                int i9 = h4 - 1;
                int i10 = P[i9];
                if (CompactHashing.b(i10, F) == b4 && Objects.equal(k4, Q[i9])) {
                    V v4 = (V) S[i9];
                    S[i9] = v3;
                    q(i9);
                    return v4;
                }
                int c4 = CompactHashing.c(i10, F);
                i8++;
                if (c4 == 0) {
                    if (i8 >= 9) {
                        return t().put(k4, v3);
                    }
                    if (i6 > F) {
                        V = V(F, CompactHashing.e(F), d4, i5);
                    } else {
                        P[i9] = CompactHashing.d(i10, i6, F);
                    }
                } else {
                    h4 = c4;
                }
            }
        }
        U(i6);
        J(i5, k4, v3, d4, i4);
        this.f26734f = i6;
        G();
        return null;
    }

    int r(int i4, int i5) {
        return i4 - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        Map<K, V> A = A();
        if (A != null) {
            return A.remove(obj);
        }
        V v3 = (V) O(obj);
        if (v3 == f26728j) {
            return null;
        }
        return v3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int s() {
        Preconditions.checkState(N(), "Arrays already allocated");
        int i4 = this.f26733e;
        int j4 = CompactHashing.j(i4);
        this.f26729a = CompactHashing.a(j4);
        X(j4 - 1);
        this.f26730b = new int[i4];
        this.f26731c = new Object[i4];
        this.f26732d = new Object[i4];
        return i4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> A = A();
        if (A != null) {
            return A.size();
        }
        return this.f26734f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @CanIgnoreReturnValue
    public Map<K, V> t() {
        Map<K, V> w3 = w(F() + 1);
        int D = D();
        while (D >= 0) {
            w3.put(K(D), a0(D));
            D = E(D);
        }
        this.f26729a = w3;
        this.f26730b = null;
        this.f26731c = null;
        this.f26732d = null;
        G();
        return w3;
    }

    Set<Map.Entry<K, V>> v() {
        return new EntrySetView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f26737i;
        if (collection == null) {
            Collection<V> y3 = y();
            this.f26737i = y3;
            return y3;
        }
        return collection;
    }

    Map<K, V> w(int i4) {
        return new LinkedHashMap(i4, 1.0f);
    }

    Set<K> x() {
        return new KeySetView();
    }

    Collection<V> y() {
        return new ValuesView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompactHashMap(int i4) {
        I(i4);
    }

    void q(int i4) {
    }
}
