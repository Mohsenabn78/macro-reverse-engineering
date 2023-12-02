package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    transient K[] f26844a;

    /* renamed from: b  reason: collision with root package name */
    transient V[] f26845b;

    /* renamed from: c  reason: collision with root package name */
    transient int f26846c;

    /* renamed from: d  reason: collision with root package name */
    transient int f26847d;

    /* renamed from: e  reason: collision with root package name */
    private transient int[] f26848e;

    /* renamed from: f  reason: collision with root package name */
    private transient int[] f26849f;

    /* renamed from: g  reason: collision with root package name */
    private transient int[] f26850g;

    /* renamed from: h  reason: collision with root package name */
    private transient int[] f26851h;

    /* renamed from: i  reason: collision with root package name */
    private transient int f26852i;

    /* renamed from: j  reason: collision with root package name */
    private transient int f26853j;

    /* renamed from: k  reason: collision with root package name */
    private transient int[] f26854k;

    /* renamed from: l  reason: collision with root package name */
    private transient int[] f26855l;
    @LazyInit

    /* renamed from: m  reason: collision with root package name */
    private transient Set<K> f26856m;
    @LazyInit

    /* renamed from: n  reason: collision with root package name */
    private transient Set<V> f26857n;
    @LazyInit

    /* renamed from: o  reason: collision with root package name */
    private transient Set<Map.Entry<K, V>> f26858o;
    @RetainedWith
    @CheckForNull
    @LazyInit

    /* renamed from: p  reason: collision with root package name */
    private transient BiMap<V, K> f26859p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class EntryForKey extends AbstractMapEntry<K, V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        final K f26860a;

        /* renamed from: b  reason: collision with root package name */
        int f26861b;

        EntryForKey(int i4) {
            this.f26860a = (K) NullnessCasts.a(HashBiMap.this.f26844a[i4]);
            this.f26861b = i4;
        }

        void f() {
            int i4 = this.f26861b;
            if (i4 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i4 <= hashBiMap.f26846c && Objects.equal(hashBiMap.f26844a[i4], this.f26860a)) {
                    return;
                }
            }
            this.f26861b = HashBiMap.this.p(this.f26860a);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.f26860a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            f();
            int i4 = this.f26861b;
            if (i4 == -1) {
                return (V) NullnessCasts.b();
            }
            return (V) NullnessCasts.a(HashBiMap.this.f26845b[i4]);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V v3) {
            f();
            int i4 = this.f26861b;
            if (i4 == -1) {
                HashBiMap.this.put(this.f26860a, v3);
                return (V) NullnessCasts.b();
            }
            V v4 = (V) NullnessCasts.a(HashBiMap.this.f26845b[i4]);
            if (!Objects.equal(v4, v3)) {
                HashBiMap.this.G(this.f26861b, v3, false);
                return v4;
            }
            return v3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {

        /* renamed from: a  reason: collision with root package name */
        final HashBiMap<K, V> f26863a;
        @ParametricNullness

        /* renamed from: b  reason: collision with root package name */
        final V f26864b;

        /* renamed from: c  reason: collision with root package name */
        int f26865c;

        EntryForValue(HashBiMap<K, V> hashBiMap, int i4) {
            this.f26863a = hashBiMap;
            this.f26864b = (V) NullnessCasts.a(hashBiMap.f26845b[i4]);
            this.f26865c = i4;
        }

        private void f() {
            int i4 = this.f26865c;
            if (i4 != -1) {
                HashBiMap<K, V> hashBiMap = this.f26863a;
                if (i4 <= hashBiMap.f26846c && Objects.equal(this.f26864b, hashBiMap.f26845b[i4])) {
                    return;
                }
            }
            this.f26865c = this.f26863a.r(this.f26864b);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getKey() {
            return this.f26864b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getValue() {
            f();
            int i4 = this.f26865c;
            if (i4 == -1) {
                return (K) NullnessCasts.b();
            }
            return (K) NullnessCasts.a(this.f26863a.f26844a[i4]);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K setValue(@ParametricNullness K k4) {
            f();
            int i4 = this.f26865c;
            if (i4 == -1) {
                this.f26863a.z(this.f26864b, k4, false);
                return (K) NullnessCasts.b();
            }
            K k5 = (K) NullnessCasts.a(this.f26863a.f26844a[i4]);
            if (!Objects.equal(k5, k4)) {
                this.f26863a.F(this.f26865c, k4, false);
                return k5;
            }
            return k4;
        }
    }

    /* loaded from: classes5.dex */
    final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        EntrySet() {
            super(HashBiMap.this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        /* renamed from: b */
        public Map.Entry<K, V> a(int i4) {
            return new EntryForKey(i4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int p4 = HashBiMap.this.p(key);
            if (p4 == -1 || !Objects.equal(value, HashBiMap.this.f26845b[p4])) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@CheckForNull Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int d4 = Hashing.d(key);
                int q4 = HashBiMap.this.q(key, d4);
                if (q4 != -1 && Objects.equal(value, HashBiMap.this.f26845b[q4])) {
                    HashBiMap.this.C(q4, d4);
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private transient Set<Map.Entry<V, K>> f26867a;
        private final HashBiMap<K, V> forward;

        Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).f26859p = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@CheckForNull Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.f26867a;
            if (set == null) {
                InverseEntrySet inverseEntrySet = new InverseEntrySet(this.forward);
                this.f26867a = inverseEntrySet;
                return inverseEntrySet;
            }
            return set;
        }

        @Override // com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @CheckForNull
        public K forcePut(@ParametricNullness V v3, @ParametricNullness K k4) {
            return this.forward.z(v3, k4, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public K get(@CheckForNull Object obj) {
            return this.forward.t(obj);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @CheckForNull
        public K put(@ParametricNullness V v3, @ParametricNullness K k4) {
            return this.forward.z(v3, k4, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        @CheckForNull
        public K remove(@CheckForNull Object obj) {
            return this.forward.E(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.f26846c;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    /* loaded from: classes5.dex */
    static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        /* renamed from: b */
        public Map.Entry<V, K> a(int i4) {
            return new EntryForValue(this.f26870a, i4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int r4 = this.f26870a.r(key);
            if (r4 == -1 || !Objects.equal(this.f26870a.f26844a[r4], value)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int d4 = Hashing.d(key);
                int s3 = this.f26870a.s(key, d4);
                if (s3 != -1 && Objects.equal(this.f26870a.f26844a[s3], value)) {
                    this.f26870a.D(s3, d4);
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class KeySet extends View<K, V, K> {
        KeySet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        @ParametricNullness
        K a(int i4) {
            return (K) NullnessCasts.a(HashBiMap.this.f26844a[i4]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int d4 = Hashing.d(obj);
            int q4 = HashBiMap.this.q(obj, d4);
            if (q4 != -1) {
                HashBiMap.this.C(q4, d4);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class ValueSet extends View<K, V, V> {
        ValueSet() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.View
        @ParametricNullness
        V a(int i4) {
            return (V) NullnessCasts.a(HashBiMap.this.f26845b[i4]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int d4 = Hashing.d(obj);
            int s3 = HashBiMap.this.s(obj, d4);
            if (s3 != -1) {
                HashBiMap.this.D(s3, d4);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class View<K, V, T> extends AbstractSet<T> {

        /* renamed from: a  reason: collision with root package name */
        final HashBiMap<K, V> f26870a;

        View(HashBiMap<K, V> hashBiMap) {
            this.f26870a = hashBiMap;
        }

        @ParametricNullness
        abstract T a(int i4);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f26870a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new Iterator<T>() { // from class: com.google.common.collect.HashBiMap.View.1

                /* renamed from: a  reason: collision with root package name */
                private int f26871a;

                /* renamed from: b  reason: collision with root package name */
                private int f26872b = -1;

                /* renamed from: c  reason: collision with root package name */
                private int f26873c;

                /* renamed from: d  reason: collision with root package name */
                private int f26874d;

                {
                    this.f26871a = ((HashBiMap) View.this.f26870a).f26852i;
                    HashBiMap<K, V> hashBiMap = View.this.f26870a;
                    this.f26873c = hashBiMap.f26847d;
                    this.f26874d = hashBiMap.f26846c;
                }

                private void a() {
                    if (View.this.f26870a.f26847d == this.f26873c) {
                        return;
                    }
                    throw new ConcurrentModificationException();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    a();
                    if (this.f26871a != -2 && this.f26874d > 0) {
                        return true;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                @ParametricNullness
                public T next() {
                    if (hasNext()) {
                        T t3 = (T) View.this.a(this.f26871a);
                        this.f26872b = this.f26871a;
                        this.f26871a = ((HashBiMap) View.this.f26870a).f26855l[this.f26871a];
                        this.f26874d--;
                        return t3;
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    boolean z3;
                    a();
                    if (this.f26872b != -1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    CollectPreconditions.e(z3);
                    View.this.f26870a.A(this.f26872b);
                    int i4 = this.f26871a;
                    HashBiMap<K, V> hashBiMap = View.this.f26870a;
                    if (i4 == hashBiMap.f26846c) {
                        this.f26871a = this.f26872b;
                    }
                    this.f26872b = -1;
                    this.f26873c = hashBiMap.f26847d;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f26870a.f26846c;
        }
    }

    private HashBiMap(int i4) {
        u(i4);
    }

    private void B(int i4, int i5, int i6) {
        boolean z3;
        if (i4 != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        j(i4, i5);
        l(i4, i6);
        H(this.f26854k[i4], this.f26855l[i4]);
        x(this.f26846c - 1, i4);
        K[] kArr = this.f26844a;
        int i7 = this.f26846c;
        kArr[i7 - 1] = null;
        this.f26845b[i7 - 1] = null;
        this.f26846c = i7 - 1;
        this.f26847d++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i4, @ParametricNullness K k4, boolean z3) {
        boolean z4;
        int i5;
        if (i4 != -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        int d4 = Hashing.d(k4);
        int q4 = q(k4, d4);
        int i6 = this.f26853j;
        if (q4 != -1) {
            if (z3) {
                i6 = this.f26854k[q4];
                i5 = this.f26855l[q4];
                C(q4, d4);
                if (i4 == this.f26846c) {
                    i4 = q4;
                }
            } else {
                throw new IllegalArgumentException("Key already present in map: " + k4);
            }
        } else {
            i5 = -2;
        }
        if (i6 == i4) {
            i6 = this.f26854k[i4];
        } else if (i6 == this.f26846c) {
            i6 = q4;
        }
        if (i5 == i4) {
            q4 = this.f26855l[i4];
        } else if (i5 != this.f26846c) {
            q4 = i5;
        }
        H(this.f26854k[i4], this.f26855l[i4]);
        j(i4, Hashing.d(this.f26844a[i4]));
        this.f26844a[i4] = k4;
        v(i4, Hashing.d(k4));
        H(i6, i4);
        H(i4, q4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i4, @ParametricNullness V v3, boolean z3) {
        boolean z4;
        if (i4 != -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        int d4 = Hashing.d(v3);
        int s3 = s(v3, d4);
        if (s3 != -1) {
            if (z3) {
                D(s3, d4);
                if (i4 == this.f26846c) {
                    i4 = s3;
                }
            } else {
                throw new IllegalArgumentException("Value already present in map: " + v3);
            }
        }
        l(i4, Hashing.d(this.f26845b[i4]));
        this.f26845b[i4] = v3;
        w(i4, d4);
    }

    private void H(int i4, int i5) {
        if (i4 == -2) {
            this.f26852i = i5;
        } else {
            this.f26855l[i4] = i5;
        }
        if (i5 == -2) {
            this.f26853j = i4;
        } else {
            this.f26854k[i5] = i4;
        }
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private int h(int i4) {
        return i4 & (this.f26848e.length - 1);
    }

    private static int[] i(int i4) {
        int[] iArr = new int[i4];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void j(int i4, int i5) {
        boolean z3;
        if (i4 != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int h4 = h(i5);
        int[] iArr = this.f26848e;
        int i6 = iArr[h4];
        if (i6 == i4) {
            int[] iArr2 = this.f26850g;
            iArr[h4] = iArr2[i4];
            iArr2[i4] = -1;
            return;
        }
        int i7 = this.f26850g[i6];
        while (true) {
            int i8 = i6;
            i6 = i7;
            if (i6 != -1) {
                if (i6 == i4) {
                    int[] iArr3 = this.f26850g;
                    iArr3[i8] = iArr3[i4];
                    iArr3[i4] = -1;
                    return;
                }
                i7 = this.f26850g[i6];
            } else {
                throw new AssertionError("Expected to find entry with key " + this.f26844a[i4]);
            }
        }
    }

    private void l(int i4, int i5) {
        boolean z3;
        if (i4 != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int h4 = h(i5);
        int[] iArr = this.f26849f;
        int i6 = iArr[h4];
        if (i6 == i4) {
            int[] iArr2 = this.f26851h;
            iArr[h4] = iArr2[i4];
            iArr2[i4] = -1;
            return;
        }
        int i7 = this.f26851h[i6];
        while (true) {
            int i8 = i6;
            i6 = i7;
            if (i6 != -1) {
                if (i6 == i4) {
                    int[] iArr3 = this.f26851h;
                    iArr3[i8] = iArr3[i4];
                    iArr3[i4] = -1;
                    return;
                }
                i7 = this.f26851h[i6];
            } else {
                throw new AssertionError("Expected to find entry with value " + this.f26845b[i4]);
            }
        }
    }

    private void m(int i4) {
        int[] iArr = this.f26850g;
        if (iArr.length < i4) {
            int a4 = ImmutableCollection.Builder.a(iArr.length, i4);
            this.f26844a = (K[]) Arrays.copyOf(this.f26844a, a4);
            this.f26845b = (V[]) Arrays.copyOf(this.f26845b, a4);
            this.f26850g = n(this.f26850g, a4);
            this.f26851h = n(this.f26851h, a4);
            this.f26854k = n(this.f26854k, a4);
            this.f26855l = n(this.f26855l, a4);
        }
        if (this.f26848e.length < i4) {
            int a5 = Hashing.a(i4, 1.0d);
            this.f26848e = i(a5);
            this.f26849f = i(a5);
            for (int i5 = 0; i5 < this.f26846c; i5++) {
                int h4 = h(Hashing.d(this.f26844a[i5]));
                int[] iArr2 = this.f26850g;
                int[] iArr3 = this.f26848e;
                iArr2[i5] = iArr3[h4];
                iArr3[h4] = i5;
                int h5 = h(Hashing.d(this.f26845b[i5]));
                int[] iArr4 = this.f26851h;
                int[] iArr5 = this.f26849f;
                iArr4[i5] = iArr5[h5];
                iArr5[h5] = i5;
            }
        }
    }

    private static int[] n(int[] iArr, int i4) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i4);
        Arrays.fill(copyOf, length, i4, -1);
        return copyOf;
    }

    @J2ktIncompatible
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h4 = Serialization.h(objectInputStream);
        u(16);
        Serialization.c(this, objectInputStream, h4);
    }

    private void v(int i4, int i5) {
        boolean z3;
        if (i4 != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int h4 = h(i5);
        int[] iArr = this.f26850g;
        int[] iArr2 = this.f26848e;
        iArr[i4] = iArr2[h4];
        iArr2[h4] = i4;
    }

    private void w(int i4, int i5) {
        boolean z3;
        if (i4 != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int h4 = h(i5);
        int[] iArr = this.f26851h;
        int[] iArr2 = this.f26849f;
        iArr[i4] = iArr2[h4];
        iArr2[h4] = i4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.i(this, objectOutputStream);
    }

    private void x(int i4, int i5) {
        int i6;
        int i7;
        if (i4 == i5) {
            return;
        }
        int i8 = this.f26854k[i4];
        int i9 = this.f26855l[i4];
        H(i8, i5);
        H(i5, i9);
        K[] kArr = this.f26844a;
        K k4 = kArr[i4];
        V[] vArr = this.f26845b;
        V v3 = vArr[i4];
        kArr[i5] = k4;
        vArr[i5] = v3;
        int h4 = h(Hashing.d(k4));
        int[] iArr = this.f26848e;
        int i10 = iArr[h4];
        if (i10 == i4) {
            iArr[h4] = i5;
        } else {
            int i11 = this.f26850g[i10];
            while (true) {
                i6 = i10;
                i10 = i11;
                if (i10 == i4) {
                    break;
                }
                i11 = this.f26850g[i10];
            }
            this.f26850g[i6] = i5;
        }
        int[] iArr2 = this.f26850g;
        iArr2[i5] = iArr2[i4];
        iArr2[i4] = -1;
        int h5 = h(Hashing.d(v3));
        int[] iArr3 = this.f26849f;
        int i12 = iArr3[h5];
        if (i12 == i4) {
            iArr3[h5] = i5;
        } else {
            int i13 = this.f26851h[i12];
            while (true) {
                i7 = i12;
                i12 = i13;
                if (i12 == i4) {
                    break;
                }
                i13 = this.f26851h[i12];
            }
            this.f26851h[i7] = i5;
        }
        int[] iArr4 = this.f26851h;
        iArr4[i5] = iArr4[i4];
        iArr4[i4] = -1;
    }

    void A(int i4) {
        C(i4, Hashing.d(this.f26844a[i4]));
    }

    void C(int i4, int i5) {
        B(i4, i5, Hashing.d(this.f26845b[i4]));
    }

    void D(int i4, int i5) {
        B(i4, Hashing.d(this.f26844a[i4]), i5);
    }

    @CheckForNull
    K E(@CheckForNull Object obj) {
        int d4 = Hashing.d(obj);
        int s3 = s(obj, d4);
        if (s3 == -1) {
            return null;
        }
        K k4 = this.f26844a[s3];
        D(s3, d4);
        return k4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.f26844a, 0, this.f26846c, (Object) null);
        Arrays.fill(this.f26845b, 0, this.f26846c, (Object) null);
        Arrays.fill(this.f26848e, -1);
        Arrays.fill(this.f26849f, -1);
        Arrays.fill(this.f26850g, 0, this.f26846c, -1);
        Arrays.fill(this.f26851h, 0, this.f26846c, -1);
        Arrays.fill(this.f26854k, 0, this.f26846c, -1);
        Arrays.fill(this.f26855l, 0, this.f26846c, -1);
        this.f26846c = 0;
        this.f26852i = -2;
        this.f26853j = -2;
        this.f26847d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        if (p(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        if (r(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f26858o;
        if (set == null) {
            EntrySet entrySet = new EntrySet();
            this.f26858o = entrySet;
            return entrySet;
        }
        return set;
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public V forcePut(@ParametricNullness K k4, @ParametricNullness V v3) {
        return y(k4, v3, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int p4 = p(obj);
        if (p4 == -1) {
            return null;
        }
        return this.f26845b[p4];
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.f26859p;
        if (biMap == null) {
            Inverse inverse = new Inverse(this);
            this.f26859p = inverse;
            return inverse;
        }
        return biMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f26856m;
        if (set == null) {
            KeySet keySet = new KeySet();
            this.f26856m = keySet;
            return keySet;
        }
        return set;
    }

    int o(@CheckForNull Object obj, int i4, int[] iArr, int[] iArr2, Object[] objArr) {
        int i5 = iArr[h(i4)];
        while (i5 != -1) {
            if (Objects.equal(objArr[i5], obj)) {
                return i5;
            }
            i5 = iArr2[i5];
        }
        return -1;
    }

    int p(@CheckForNull Object obj) {
        return q(obj, Hashing.d(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness K k4, @ParametricNullness V v3) {
        return y(k4, v3, false);
    }

    int q(@CheckForNull Object obj, int i4) {
        return o(obj, i4, this.f26848e, this.f26850g, this.f26844a);
    }

    int r(@CheckForNull Object obj) {
        return s(obj, Hashing.d(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        int d4 = Hashing.d(obj);
        int q4 = q(obj, d4);
        if (q4 == -1) {
            return null;
        }
        V v3 = this.f26845b[q4];
        C(q4, d4);
        return v3;
    }

    int s(@CheckForNull Object obj, int i4) {
        return o(obj, i4, this.f26849f, this.f26851h, this.f26845b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f26846c;
    }

    @CheckForNull
    K t(@CheckForNull Object obj) {
        int r4 = r(obj);
        if (r4 == -1) {
            return null;
        }
        return this.f26844a[r4];
    }

    void u(int i4) {
        CollectPreconditions.b(i4, "expectedSize");
        int a4 = Hashing.a(i4, 1.0d);
        this.f26846c = 0;
        this.f26844a = (K[]) new Object[i4];
        this.f26845b = (V[]) new Object[i4];
        this.f26848e = i(a4);
        this.f26849f = i(a4);
        this.f26850g = i(i4);
        this.f26851h = i(i4);
        this.f26852i = -2;
        this.f26853j = -2;
        this.f26854k = i(i4);
        this.f26855l = i(i4);
    }

    @CheckForNull
    V y(@ParametricNullness K k4, @ParametricNullness V v3, boolean z3) {
        boolean z4;
        int d4 = Hashing.d(k4);
        int q4 = q(k4, d4);
        if (q4 != -1) {
            V v4 = this.f26845b[q4];
            if (Objects.equal(v4, v3)) {
                return v3;
            }
            G(q4, v3, z3);
            return v4;
        }
        int d5 = Hashing.d(v3);
        int s3 = s(v3, d5);
        if (z3) {
            if (s3 != -1) {
                D(s3, d5);
            }
        } else {
            if (s3 == -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Value already present: %s", v3);
        }
        m(this.f26846c + 1);
        K[] kArr = this.f26844a;
        int i4 = this.f26846c;
        kArr[i4] = k4;
        this.f26845b[i4] = v3;
        v(i4, d4);
        w(this.f26846c, d5);
        H(this.f26853j, this.f26846c);
        H(this.f26846c, -2);
        this.f26846c++;
        this.f26847d++;
        return null;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    K z(@ParametricNullness V v3, @ParametricNullness K k4, boolean z3) {
        boolean z4;
        int i4;
        int d4 = Hashing.d(v3);
        int s3 = s(v3, d4);
        if (s3 != -1) {
            K k5 = this.f26844a[s3];
            if (Objects.equal(k5, k4)) {
                return k4;
            }
            F(s3, k4, z3);
            return k5;
        }
        int i5 = this.f26853j;
        int d5 = Hashing.d(k4);
        int q4 = q(k4, d5);
        if (z3) {
            if (q4 != -1) {
                i5 = this.f26854k[q4];
                C(q4, d5);
            }
        } else {
            if (q4 == -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Key already present: %s", k4);
        }
        m(this.f26846c + 1);
        K[] kArr = this.f26844a;
        int i6 = this.f26846c;
        kArr[i6] = k4;
        this.f26845b[i6] = v3;
        v(i6, d5);
        w(this.f26846c, d4);
        if (i5 == -2) {
            i4 = this.f26852i;
        } else {
            i4 = this.f26855l[i5];
        }
        H(i5, this.f26846c);
        H(this.f26846c, i4);
        this.f26846c++;
        this.f26847d++;
        return null;
    }

    public static <K, V> HashBiMap<K, V> create(int i4) {
        return new HashBiMap<>(i4);
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        Set<V> set = this.f26857n;
        if (set == null) {
            ValueSet valueSet = new ValueSet();
            this.f26857n = valueSet;
            return valueSet;
        }
        return set;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
