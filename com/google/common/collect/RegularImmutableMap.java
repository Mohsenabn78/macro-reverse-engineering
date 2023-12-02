package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import kotlin.UShort;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {

    /* renamed from: i  reason: collision with root package name */
    static final ImmutableMap<Object, Object> f27343i = new RegularImmutableMap(null, new Object[0], 0);
    @J2ktIncompatible
    private static final long serialVersionUID = 0;
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    private final transient Object f27344f;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    final transient Object[] f27345g;

    /* renamed from: h  reason: collision with root package name */
    private final transient int f27346h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: c  reason: collision with root package name */
        private final transient ImmutableMap<K, V> f27347c;

        /* renamed from: d  reason: collision with root package name */
        private final transient Object[] f27348d;

        /* renamed from: e  reason: collision with root package name */
        private final transient int f27349e;

        /* renamed from: f  reason: collision with root package name */
        private final transient int f27350f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i4, int i5) {
            this.f27347c = immutableMap;
            this.f27348d = objArr;
            this.f27349e = i4;
            this.f27350f = i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int a(Object[] objArr, int i4) {
            return asList().a(objArr, i4);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.f27347c.get(key))) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> l() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // com.google.common.collect.ImmutableCollection
                public boolean f() {
                    return true;
                }

                @Override // java.util.List
                /* renamed from: l */
                public Map.Entry<K, V> get(int i4) {
                    Preconditions.checkElementIndex(i4, EntrySet.this.f27350f);
                    int i5 = i4 * 2;
                    Object obj = EntrySet.this.f27348d[EntrySet.this.f27349e + i5];
                    Objects.requireNonNull(obj);
                    Object obj2 = EntrySet.this.f27348d[i5 + (EntrySet.this.f27349e ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.f27350f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f27350f;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    /* loaded from: classes5.dex */
    static final class KeySet<K> extends ImmutableSet<K> {

        /* renamed from: c  reason: collision with root package name */
        private final transient ImmutableMap<K, ?> f27351c;

        /* renamed from: d  reason: collision with root package name */
        private final transient ImmutableList<K> f27352d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f27351c = immutableMap;
            this.f27352d = immutableList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int a(Object[] objArr, int i4) {
            return asList().a(objArr, i4);
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.f27352d;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (this.f27351c.get(obj) != null) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f27351c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }
    }

    /* loaded from: classes5.dex */
    static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* renamed from: c  reason: collision with root package name */
        private final transient Object[] f27353c;

        /* renamed from: d  reason: collision with root package name */
        private final transient int f27354d;

        /* renamed from: e  reason: collision with root package name */
        private final transient int f27355e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public KeysOrValuesAsList(Object[] objArr, int i4, int i5) {
            this.f27353c = objArr;
            this.f27354d = i4;
            this.f27355e = i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i4) {
            Preconditions.checkElementIndex(i4, this.f27355e);
            Object obj = this.f27353c[(i4 * 2) + this.f27354d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f27355e;
        }
    }

    private RegularImmutableMap(@CheckForNull Object obj, Object[] objArr, int i4) {
        this.f27344f = obj;
        this.f27345g = objArr;
        this.f27346h = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> m(int i4, Object[] objArr) {
        return n(i4, objArr, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> n(int i4, Object[] objArr, ImmutableMap.Builder<K, V> builder) {
        if (i4 == 0) {
            return (RegularImmutableMap) f27343i;
        }
        if (i4 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            CollectPreconditions.a(obj, obj2);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i4, objArr.length >> 1);
        Object o4 = o(objArr, i4, ImmutableSet.i(i4), 0);
        if (o4 instanceof Object[]) {
            Object[] objArr2 = (Object[]) o4;
            ImmutableMap.Builder.DuplicateKey duplicateKey = (ImmutableMap.Builder.DuplicateKey) objArr2[2];
            if (builder != null) {
                builder.f26902e = duplicateKey;
                Object obj3 = objArr2[0];
                int intValue = ((Integer) objArr2[1]).intValue();
                objArr = Arrays.copyOf(objArr, intValue * 2);
                o4 = obj3;
                i4 = intValue;
            } else {
                throw duplicateKey.a();
            }
        }
        return new RegularImmutableMap<>(o4, objArr, i4);
    }

    @CheckForNull
    private static Object o(Object[] objArr, int i4, int i5, int i6) {
        ImmutableMap.Builder.DuplicateKey duplicateKey = null;
        if (i4 == 1) {
            Object obj = objArr[i6];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i6 ^ 1];
            Objects.requireNonNull(obj2);
            CollectPreconditions.a(obj, obj2);
            return null;
        }
        int i7 = i5 - 1;
        int i8 = -1;
        if (i5 <= 128) {
            byte[] bArr = new byte[i5];
            Arrays.fill(bArr, (byte) -1);
            int i9 = 0;
            for (int i10 = 0; i10 < i4; i10++) {
                int i11 = (i10 * 2) + i6;
                int i12 = (i9 * 2) + i6;
                Object obj3 = objArr[i11];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i11 ^ 1];
                Objects.requireNonNull(obj4);
                CollectPreconditions.a(obj3, obj4);
                int c4 = Hashing.c(obj3.hashCode());
                while (true) {
                    int i13 = c4 & i7;
                    int i14 = bArr[i13] & 255;
                    if (i14 == 255) {
                        bArr[i13] = (byte) i12;
                        if (i9 < i10) {
                            objArr[i12] = obj3;
                            objArr[i12 ^ 1] = obj4;
                        }
                        i9++;
                    } else if (obj3.equals(objArr[i14])) {
                        int i15 = i14 ^ 1;
                        Object obj5 = objArr[i15];
                        Objects.requireNonNull(obj5);
                        duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj3, obj4, obj5);
                        objArr[i15] = obj4;
                        break;
                    } else {
                        c4 = i13 + 1;
                    }
                }
            }
            return i9 == i4 ? bArr : new Object[]{bArr, Integer.valueOf(i9), duplicateKey};
        } else if (i5 <= 32768) {
            short[] sArr = new short[i5];
            Arrays.fill(sArr, (short) -1);
            int i16 = 0;
            for (int i17 = 0; i17 < i4; i17++) {
                int i18 = (i17 * 2) + i6;
                int i19 = (i16 * 2) + i6;
                Object obj6 = objArr[i18];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i18 ^ 1];
                Objects.requireNonNull(obj7);
                CollectPreconditions.a(obj6, obj7);
                int c5 = Hashing.c(obj6.hashCode());
                while (true) {
                    int i20 = c5 & i7;
                    int i21 = sArr[i20] & UShort.MAX_VALUE;
                    if (i21 == 65535) {
                        sArr[i20] = (short) i19;
                        if (i16 < i17) {
                            objArr[i19] = obj6;
                            objArr[i19 ^ 1] = obj7;
                        }
                        i16++;
                    } else if (obj6.equals(objArr[i21])) {
                        int i22 = i21 ^ 1;
                        Object obj8 = objArr[i22];
                        Objects.requireNonNull(obj8);
                        duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj6, obj7, obj8);
                        objArr[i22] = obj7;
                        break;
                    } else {
                        c5 = i20 + 1;
                    }
                }
            }
            return i16 == i4 ? sArr : new Object[]{sArr, Integer.valueOf(i16), duplicateKey};
        } else {
            int[] iArr = new int[i5];
            Arrays.fill(iArr, -1);
            int i23 = 0;
            int i24 = 0;
            while (i23 < i4) {
                int i25 = (i23 * 2) + i6;
                int i26 = (i24 * 2) + i6;
                Object obj9 = objArr[i25];
                Objects.requireNonNull(obj9);
                Object obj10 = objArr[i25 ^ 1];
                Objects.requireNonNull(obj10);
                CollectPreconditions.a(obj9, obj10);
                int c6 = Hashing.c(obj9.hashCode());
                while (true) {
                    int i27 = c6 & i7;
                    int i28 = iArr[i27];
                    if (i28 == i8) {
                        iArr[i27] = i26;
                        if (i24 < i23) {
                            objArr[i26] = obj9;
                            objArr[i26 ^ 1] = obj10;
                        }
                        i24++;
                    } else if (obj9.equals(objArr[i28])) {
                        int i29 = i28 ^ 1;
                        Object obj11 = objArr[i29];
                        Objects.requireNonNull(obj11);
                        duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj9, obj10, obj11);
                        objArr[i29] = obj10;
                        break;
                    } else {
                        c6 = i27 + 1;
                        i8 = -1;
                    }
                }
                i23++;
                i8 = -1;
            }
            return i24 == i4 ? iArr : new Object[]{iArr, Integer.valueOf(i24), duplicateKey};
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public static Object p(Object[] objArr, int i4, int i5, int i6) {
        Object o4 = o(objArr, i4, i5, i6);
        if (!(o4 instanceof Object[])) {
            return o4;
        }
        throw ((ImmutableMap.Builder.DuplicateKey) ((Object[]) o4)[2]).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public static Object q(@CheckForNull Object obj, Object[] objArr, int i4, int i5, @CheckForNull Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i4 == 1) {
            Object obj3 = objArr[i5];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i5 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int c4 = Hashing.c(obj2.hashCode());
                while (true) {
                    int i6 = c4 & length;
                    int i7 = bArr[i6] & 255;
                    if (i7 == 255) {
                        return null;
                    }
                    if (obj2.equals(objArr[i7])) {
                        return objArr[i7 ^ 1];
                    }
                    c4 = i6 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int c5 = Hashing.c(obj2.hashCode());
                while (true) {
                    int i8 = c5 & length2;
                    int i9 = sArr[i8] & UShort.MAX_VALUE;
                    if (i9 == 65535) {
                        return null;
                    }
                    if (obj2.equals(objArr[i9])) {
                        return objArr[i9 ^ 1];
                    }
                    c5 = i8 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int c6 = Hashing.c(obj2.hashCode());
                while (true) {
                    int i10 = c6 & length3;
                    int i11 = iArr[i10];
                    if (i11 == -1) {
                        return null;
                    }
                    if (obj2.equals(objArr[i11])) {
                        return objArr[i11 ^ 1];
                    }
                    c6 = i10 + 1;
                }
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> e() {
        return new EntrySet(this, this.f27345g, 0, this.f27346h);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> f() {
        return new KeySet(this, new KeysOrValuesAsList(this.f27345g, 0, this.f27346h));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> g() {
        return new KeysOrValuesAsList(this.f27345g, 1, this.f27346h);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        V v3 = (V) q(this.f27344f, this.f27345g, this.f27346h, 0, obj);
        if (v3 == null) {
            return null;
        }
        return v3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean j() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f27346h;
    }
}
