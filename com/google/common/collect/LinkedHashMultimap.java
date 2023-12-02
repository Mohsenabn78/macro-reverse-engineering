package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    @J2ktIncompatible
    @GwtIncompatible
    private static final long serialVersionUID = 1;
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    transient int f27034h;

    /* renamed from: i  reason: collision with root package name */
    private transient ValueEntry<K, V> f27035i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {
        @CheckForNull
        ValueEntry<K, V> nextInValueBucket;
        @CheckForNull
        ValueEntry<K, V> predecessorInMultimap;
        @CheckForNull
        ValueSetLink<K, V> predecessorInValueSet;
        final int smearedValueHash;
        @CheckForNull
        ValueEntry<K, V> successorInMultimap;
        @CheckForNull
        ValueSetLink<K, V> successorInValueSet;

        ValueEntry(@ParametricNullness K k4, @ParametricNullness V v3, int i4, @CheckForNull ValueEntry<K, V> valueEntry) {
            super(k4, v3);
            this.smearedValueHash = i4;
            this.nextInValueBucket = valueEntry;
        }

        static <K, V> ValueEntry<K, V> i() {
            return new ValueEntry<>(null, null, 0, null);
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> a() {
            ValueSetLink<K, V> valueSetLink = this.predecessorInValueSet;
            Objects.requireNonNull(valueSetLink);
            return valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void b(ValueSetLink<K, V> valueSetLink) {
            this.successorInValueSet = valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void c(ValueSetLink<K, V> valueSetLink) {
            this.predecessorInValueSet = valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> e() {
            ValueSetLink<K, V> valueSetLink = this.successorInValueSet;
            Objects.requireNonNull(valueSetLink);
            return valueSetLink;
        }

        public ValueEntry<K, V> f() {
            ValueEntry<K, V> valueEntry = this.predecessorInMultimap;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        public ValueEntry<K, V> g() {
            ValueEntry<K, V> valueEntry = this.successorInMultimap;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        boolean h(@CheckForNull Object obj, int i4) {
            if (this.smearedValueHash == i4 && com.google.common.base.Objects.equal(getValue(), obj)) {
                return true;
            }
            return false;
        }

        public void j(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }

        public void l(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        private final K f27039a;
        @VisibleForTesting

        /* renamed from: b  reason: collision with root package name */
        ValueEntry<K, V>[] f27040b;

        /* renamed from: c  reason: collision with root package name */
        private int f27041c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f27042d = 0;

        /* renamed from: e  reason: collision with root package name */
        private ValueSetLink<K, V> f27043e = this;

        /* renamed from: f  reason: collision with root package name */
        private ValueSetLink<K, V> f27044f = this;

        ValueSet(@ParametricNullness K k4, int i4) {
            this.f27039a = k4;
            this.f27040b = new ValueEntry[Hashing.a(i4, 1.0d)];
        }

        private int g() {
            return this.f27040b.length - 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void h() {
            if (Hashing.b(this.f27041c, this.f27040b.length, 1.0d)) {
                int length = this.f27040b.length * 2;
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[length];
                this.f27040b = valueEntryArr;
                int i4 = length - 1;
                for (ValueSetLink valueSetLink = (ValueSetLink<K, V>) this.f27043e; valueSetLink != this; valueSetLink = (ValueSetLink<K, V>) valueSetLink.e()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) valueSetLink;
                    int i5 = valueEntry.smearedValueHash & i4;
                    valueEntry.nextInValueBucket = valueEntryArr[i5];
                    valueEntryArr[i5] = valueEntry;
                }
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> a() {
            return this.f27044f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@ParametricNullness V v3) {
            int d4 = Hashing.d(v3);
            int g4 = g() & d4;
            ValueEntry<K, V> valueEntry = this.f27040b[g4];
            for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.h(v3, d4)) {
                    return false;
                }
            }
            ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.f27039a, v3, d4, valueEntry);
            LinkedHashMultimap.P(this.f27044f, valueEntry3);
            LinkedHashMultimap.P(valueEntry3, this);
            LinkedHashMultimap.O(LinkedHashMultimap.this.f27035i.f(), valueEntry3);
            LinkedHashMultimap.O(valueEntry3, LinkedHashMultimap.this.f27035i);
            this.f27040b[g4] = valueEntry3;
            this.f27041c++;
            this.f27042d++;
            h();
            return true;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void b(ValueSetLink<K, V> valueSetLink) {
            this.f27043e = valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void c(ValueSetLink<K, V> valueSetLink) {
            this.f27044f = valueSetLink;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f27040b, (Object) null);
            this.f27041c = 0;
            for (ValueSetLink<K, V> valueSetLink = this.f27043e; valueSetLink != this; valueSetLink = valueSetLink.e()) {
                LinkedHashMultimap.M((ValueEntry) valueSetLink);
            }
            LinkedHashMultimap.P(this, this);
            this.f27042d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            int d4 = Hashing.d(obj);
            for (ValueEntry<K, V> valueEntry = this.f27040b[g() & d4]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.h(obj, d4)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink<K, V> e() {
            return this.f27043e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new Iterator<V>() { // from class: com.google.common.collect.LinkedHashMultimap.ValueSet.1

                /* renamed from: a  reason: collision with root package name */
                ValueSetLink<K, V> f27046a;
                @CheckForNull

                /* renamed from: b  reason: collision with root package name */
                ValueEntry<K, V> f27047b;

                /* renamed from: c  reason: collision with root package name */
                int f27048c;

                {
                    this.f27046a = ValueSet.this.f27043e;
                    this.f27048c = ValueSet.this.f27042d;
                }

                private void a() {
                    if (ValueSet.this.f27042d == this.f27048c) {
                        return;
                    }
                    throw new ConcurrentModificationException();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    a();
                    if (this.f27046a != ValueSet.this) {
                        return true;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                @ParametricNullness
                public V next() {
                    if (hasNext()) {
                        ValueEntry<K, V> valueEntry = (ValueEntry) this.f27046a;
                        V value = valueEntry.getValue();
                        this.f27047b = valueEntry;
                        this.f27046a = valueEntry.e();
                        return value;
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    boolean z3;
                    a();
                    if (this.f27047b != null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
                    ValueSet.this.remove(this.f27047b.getValue());
                    this.f27048c = ValueSet.this.f27042d;
                    this.f27047b = null;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@CheckForNull Object obj) {
            int d4 = Hashing.d(obj);
            int g4 = g() & d4;
            ValueEntry<K, V> valueEntry = null;
            for (ValueEntry<K, V> valueEntry2 = this.f27040b[g4]; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.h(obj, d4)) {
                    if (valueEntry == null) {
                        this.f27040b[g4] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.N(valueEntry2);
                    LinkedHashMultimap.M(valueEntry2);
                    this.f27041c--;
                    this.f27042d++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f27041c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface ValueSetLink<K, V> {
        ValueSetLink<K, V> a();

        void b(ValueSetLink<K, V> valueSetLink);

        void c(ValueSetLink<K, V> valueSetLink);

        ValueSetLink<K, V> e();
    }

    private LinkedHashMultimap(int i4, int i5) {
        super(Platform.f(i4));
        this.f27034h = 2;
        CollectPreconditions.b(i5, "expectedValuesPerKey");
        this.f27034h = i5;
        ValueEntry<K, V> i6 = ValueEntry.i();
        this.f27035i = i6;
        O(i6, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void M(ValueEntry<K, V> valueEntry) {
        O(valueEntry.f(), valueEntry.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void N(ValueSetLink<K, V> valueSetLink) {
        P(valueSetLink.a(), valueSetLink.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void O(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.l(valueEntry2);
        valueEntry2.j(valueEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void P(ValueSetLink<K, V> valueSetLink, ValueSetLink<K, V> valueSetLink2) {
        valueSetLink.b(valueSetLink2);
        valueSetLink2.c(valueSetLink);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @J2ktIncompatible
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        ValueEntry<K, V> i4 = ValueEntry.i();
        this.f27035i = i4;
        O(i4, i4);
        this.f27034h = 2;
        int readInt = objectInputStream.readInt();
        Map f4 = Platform.f(12);
        for (int i5 = 0; i5 < readInt; i5++) {
            Object readObject = objectInputStream.readObject();
            f4.put(readObject, u(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i6 = 0; i6 < readInt2; i6++) {
            Object readObject2 = objectInputStream.readObject();
            Object readObject3 = objectInputStream.readObject();
            Collection collection = (Collection) f4.get(readObject2);
            Objects.requireNonNull(collection);
            collection.add(readObject3);
        }
        B(f4);
    }

    @J2ktIncompatible
    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        for (K k4 : keySet()) {
            objectOutputStream.writeObject(k4);
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: F */
    public Set<V> t() {
        return Platform.g(this.f27034h);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.f27035i;
        O(valueEntry, valueEntry);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(@CheckForNull Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Set get(@ParametricNullness Object obj) {
        return super.get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> i() {
        return new Iterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.LinkedHashMultimap.1

            /* renamed from: a  reason: collision with root package name */
            ValueEntry<K, V> f27036a;
            @CheckForNull

            /* renamed from: b  reason: collision with root package name */
            ValueEntry<K, V> f27037b;

            {
                this.f27036a = LinkedHashMultimap.this.f27035i.g();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, V> next() {
                if (hasNext()) {
                    ValueEntry<K, V> valueEntry = this.f27036a;
                    this.f27037b = valueEntry;
                    this.f27036a = valueEntry.g();
                    return valueEntry;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f27036a != LinkedHashMultimap.this.f27035i) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z3;
                if (this.f27037b != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
                LinkedHashMultimap.this.remove(this.f27037b.getKey(), this.f27037b.getValue());
                this.f27037b = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    Iterator<V> j() {
        return Maps.O(i());
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@ParametricNullness Object obj, @ParametricNullness Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object obj, Iterable iterable) {
        return replaceValues((LinkedHashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> u(@ParametricNullness K k4) {
        return new ValueSet(k4, this.f27034h);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i4, int i5) {
        return new LinkedHashMultimap<>(Maps.k(i4), Maps.k(i5));
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@ParametricNullness Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public Set<V> replaceValues(@ParametricNullness K k4, Iterable<? extends V> iterable) {
        return super.replaceValues((LinkedHashMultimap<K, V>) k4, (Iterable) iterable);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> create = create(multimap.keySet().size(), 2);
        create.putAll(multimap);
        return create;
    }
}
