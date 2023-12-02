package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @GwtTransient
    final Map<R, Map<C, V>> backingMap;
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private transient Set<C> f27428c;
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    private transient Map<R, Map<C, V>> f27429d;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    private transient StandardTable<R, C, V>.ColumnMap f27430e;
    @GwtTransient
    final Supplier<? extends Map<C, V>> factory;

    /* loaded from: classes5.dex */
    private class CellIterator implements Iterator<Table.Cell<R, C, V>> {

        /* renamed from: a  reason: collision with root package name */
        final Iterator<Map.Entry<R, Map<C, V>>> f27431a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        Map.Entry<R, Map<C, V>> f27432b;

        /* renamed from: c  reason: collision with root package name */
        Iterator<Map.Entry<C, V>> f27433c;

        private CellIterator() {
            this.f27431a = StandardTable.this.backingMap.entrySet().iterator();
            this.f27433c = Iterators.h();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Table.Cell<R, C, V> next() {
            if (!this.f27433c.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f27431a.next();
                this.f27432b = next;
                this.f27433c = next.getValue().entrySet().iterator();
            }
            Objects.requireNonNull(this.f27432b);
            Map.Entry<C, V> next2 = this.f27433c.next();
            return Tables.immutableCell(this.f27432b.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f27431a.hasNext() && !this.f27433c.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f27433c.remove();
            Map.Entry<R, Map<C, V>> entry = this.f27432b;
            Objects.requireNonNull(entry);
            if (entry.getValue().isEmpty()) {
                this.f27431a.remove();
                this.f27432b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class Column extends Maps.ViewCachingAbstractMap<R, V> {

        /* renamed from: d  reason: collision with root package name */
        final C f27435d;

        /* loaded from: classes5.dex */
        private class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            private EntrySet() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                Column.this.e(Predicates.alwaysTrue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.i(entry.getKey(), Column.this.f27435d, entry.getValue());
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                Column column = Column.this;
                return !StandardTable.this.containsColumn(column.f27435d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new EntrySetIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.o(entry.getKey(), Column.this.f27435d, entry.getValue());
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return Column.this.e(Predicates.not(Predicates.in(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i4 = 0;
                for (Map<C, V> map : StandardTable.this.backingMap.values()) {
                    if (map.containsKey(Column.this.f27435d)) {
                        i4++;
                    }
                }
                return i4;
            }
        }

        /* loaded from: classes5.dex */
        private class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {

            /* renamed from: c  reason: collision with root package name */
            final Iterator<Map.Entry<R, Map<C, V>>> f27438c;

            private EntrySetIterator() {
                this.f27438c = StandardTable.this.backingMap.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public Map.Entry<R, V> a() {
                while (this.f27438c.hasNext()) {
                    final Map.Entry<R, Map<C, V>> next = this.f27438c.next();
                    if (next.getValue().containsKey(Column.this.f27435d)) {
                        return new AbstractMapEntry<R, V>() { // from class: com.google.common.collect.StandardTable.Column.EntrySetIterator.1EntryImpl
                            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                            public R getKey() {
                                return (R) next.getKey();
                            }

                            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                            public V getValue() {
                                return (V) ((Map) next.getValue()).get(Column.this.f27435d);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                            public V setValue(V v3) {
                                return (V) NullnessCasts.a(((Map) next.getValue()).put(Column.this.f27435d, Preconditions.checkNotNull(v3)));
                            }
                        };
                    }
                }
                return b();
            }
        }

        /* loaded from: classes5.dex */
        private class KeySet extends Maps.KeySet<R, V> {
            KeySet() {
                super(Column.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                Column column = Column.this;
                return StandardTable.this.contains(obj, column.f27435d);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                Column column = Column.this;
                if (StandardTable.this.remove(obj, column.f27435d) != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return Column.this.e(Maps.w(Predicates.not(Predicates.in(collection))));
            }
        }

        /* loaded from: classes5.dex */
        private class Values extends Maps.Values<R, V> {
            Values() {
                super(Column.this);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object obj) {
                if (obj != null && Column.this.e(Maps.Q(Predicates.equalTo(obj)))) {
                    return true;
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return Column.this.e(Maps.Q(Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return Column.this.e(Maps.Q(Predicates.not(Predicates.in(collection))));
            }
        }

        Column(C c4) {
            this.f27435d = (C) Preconditions.checkNotNull(c4);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<Map.Entry<R, V>> a() {
            return new EntrySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<R> c() {
            return new KeySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.contains(obj, this.f27435d);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection<V> d() {
            return new Values();
        }

        @CanIgnoreReturnValue
        boolean e(Predicate<? super Map.Entry<R, V>> predicate) {
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v3 = value.get(this.f27435d);
                if (v3 != null && predicate.apply(Maps.immutableEntry(next.getKey(), v3))) {
                    value.remove(this.f27435d);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                    z3 = true;
                }
            }
            return z3;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            return (V) StandardTable.this.get(obj, this.f27435d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(R r4, V v3) {
            return (V) StandardTable.this.put(r4, this.f27435d, v3);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            return (V) StandardTable.this.remove(obj, this.f27435d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class ColumnKeyIterator extends AbstractIterator<C> {

        /* renamed from: c  reason: collision with root package name */
        final Map<C, V> f27444c;

        /* renamed from: d  reason: collision with root package name */
        final Iterator<Map<C, V>> f27445d;

        /* renamed from: e  reason: collision with root package name */
        Iterator<Map.Entry<C, V>> f27446e;

        private ColumnKeyIterator() {
            this.f27444c = StandardTable.this.factory.get();
            this.f27445d = StandardTable.this.backingMap.values().iterator();
            this.f27446e = Iterators.f();
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected C a() {
            while (true) {
                if (this.f27446e.hasNext()) {
                    Map.Entry<C, V> next = this.f27446e.next();
                    if (!this.f27444c.containsKey(next.getKey())) {
                        this.f27444c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (this.f27445d.hasNext()) {
                    this.f27446e = this.f27445d.next().entrySet().iterator();
                } else {
                    return b();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class ColumnKeySet extends StandardTable<R, C, V>.TableSet<C> {
        private ColumnKeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return StandardTable.this.j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            boolean z3 = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z3 = true;
                }
            }
            return z3;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (Iterators.removeAll(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z3 = true;
                }
            }
            return z3;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z3 = true;
                }
            }
            return z3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.size(iterator());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class ColumnMap extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class ColumnMapEntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {
            ColumnMapEntrySet() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (StandardTable.this.containsColumn(entry.getKey())) {
                        Map<R, V> map = ColumnMap.this.get(entry.getKey());
                        Objects.requireNonNull(map);
                        return map.equals(entry.getValue());
                    }
                    return false;
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.i(StandardTable.this.columnKeySet(), new Function<C, Map<R, V>>() { // from class: com.google.common.collect.StandardTable.ColumnMap.ColumnMapEntrySet.1
                    @Override // com.google.common.base.Function
                    /* renamed from: a */
                    public Map<R, V> apply(C c4) {
                        return StandardTable.this.column(c4);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    StandardTable.this.n(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                return Sets.e(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                Iterator it = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z3 = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(Maps.immutableEntry(next, StandardTable.this.column(next)))) {
                        StandardTable.this.n(next);
                        z3 = true;
                    }
                }
                return z3;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        /* loaded from: classes5.dex */
        private class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
            ColumnMapValues() {
                super(ColumnMap.this);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : ColumnMap.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.n(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                Iterator it = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z3 = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.n(next);
                        z3 = true;
                    }
                }
                return z3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                Iterator it = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z3 = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.n(next);
                        z3 = true;
                    }
                }
                return z3;
            }
        }

        private ColumnMap() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new ColumnMapEntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection<Map<R, V>> d() {
            return new ColumnMapValues();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: e */
        public Map<R, V> get(@CheckForNull Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                StandardTable standardTable = StandardTable.this;
                Objects.requireNonNull(obj);
                return standardTable.column(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Map<R, V> remove(@CheckForNull Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.n(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class Row extends Maps.IteratorBasedAbstractMap<C, V> {

        /* renamed from: a  reason: collision with root package name */
        final R f27453a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        Map<C, V> f27454b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Row(R r4) {
            this.f27453a = (R) Preconditions.checkNotNull(r4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<C, V>> a() {
            e();
            Map<C, V> map = this.f27454b;
            if (map == null) {
                return Iterators.h();
            }
            final Iterator<Map.Entry<C, V>> it = map.entrySet().iterator();
            return new Iterator<Map.Entry<C, V>>() { // from class: com.google.common.collect.StandardTable.Row.1
                @Override // java.util.Iterator
                /* renamed from: a */
                public Map.Entry<C, V> next() {
                    return Row.this.f((Map.Entry) it.next());
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    it.remove();
                    Row.this.d();
                }
            };
        }

        @CheckForNull
        Map<C, V> c() {
            return StandardTable.this.backingMap.get(this.f27453a);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            e();
            Map<C, V> map = this.f27454b;
            if (map != null) {
                map.clear();
            }
            d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            Map<C, V> map;
            e();
            if (obj != null && (map = this.f27454b) != null && Maps.C(map, obj)) {
                return true;
            }
            return false;
        }

        void d() {
            e();
            Map<C, V> map = this.f27454b;
            if (map != null && map.isEmpty()) {
                StandardTable.this.backingMap.remove(this.f27453a);
                this.f27454b = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void e() {
            Map<C, V> map = this.f27454b;
            if (map == null || (map.isEmpty() && StandardTable.this.backingMap.containsKey(this.f27453a))) {
                this.f27454b = c();
            }
        }

        Map.Entry<C, V> f(final Map.Entry<C, V> entry) {
            return new ForwardingMapEntry<C, V>(this) { // from class: com.google.common.collect.StandardTable.Row.2
                @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                public boolean equals(@CheckForNull Object obj) {
                    return g(obj);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                /* renamed from: f */
                public Map.Entry<C, V> e() {
                    return entry;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                public V setValue(V v3) {
                    return (V) super.setValue(Preconditions.checkNotNull(v3));
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Map<C, V> map;
            e();
            if (obj != null && (map = this.f27454b) != null) {
                return (V) Maps.D(map, obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(C c4, V v3) {
            Preconditions.checkNotNull(c4);
            Preconditions.checkNotNull(v3);
            Map<C, V> map = this.f27454b;
            if (map != null && !map.isEmpty()) {
                return this.f27454b.put(c4, v3);
            }
            return (V) StandardTable.this.put(this.f27453a, c4, v3);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            e();
            Map<C, V> map = this.f27454b;
            if (map == null) {
                return null;
            }
            V v3 = (V) Maps.E(map, obj);
            d();
            return v3;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            e();
            Map<C, V> map = this.f27454b;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class RowMap extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class EntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {
            EntrySet() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || !(entry.getValue() instanceof Map) || !Collections2.f(StandardTable.this.backingMap.entrySet(), entry)) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.i(StandardTable.this.backingMap.keySet(), new Function<R, Map<C, V>>() { // from class: com.google.common.collect.StandardTable.RowMap.EntrySet.1
                    @Override // com.google.common.base.Function
                    /* renamed from: a */
                    public Map<C, V> apply(R r4) {
                        return StandardTable.this.row(r4);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || !(entry.getValue() instanceof Map) || !StandardTable.this.backingMap.entrySet().remove(entry)) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RowMap() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set<Map.Entry<R, Map<C, V>>> a() {
            return new EntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: e */
        public Map<C, V> get(@CheckForNull Object obj) {
            if (StandardTable.this.containsRow(obj)) {
                StandardTable standardTable = StandardTable.this;
                Objects.requireNonNull(obj);
                return standardTable.row(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Map<C, V> remove(@CheckForNull Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    /* loaded from: classes5.dex */
    private abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
        private TableSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(@CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (obj3 != null && obj3.equals(get(obj, obj2))) {
            return true;
        }
        return false;
    }

    private Map<C, V> m(R r4) {
        Map<C, V> map = this.backingMap.get(r4);
        if (map == null) {
            Map<C, V> map2 = this.factory.get();
            this.backingMap.put(r4, map2);
            return map2;
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Map<R, V> n(@CheckForNull Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(@CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (i(obj, obj2, obj3)) {
            remove(obj, obj2);
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator<Table.Cell<R, C, V>> a() {
        return new CellIterator();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c4) {
        return new Column(c4);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<C> columnKeySet() {
        Set<C> set = this.f27428c;
        if (set == null) {
            ColumnKeySet columnKeySet = new ColumnKeySet();
            this.f27428c = columnKeySet;
            return columnKeySet;
        }
        return set;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.ColumnMap columnMap = this.f27430e;
        if (columnMap == null) {
            StandardTable<R, C, V>.ColumnMap columnMap2 = new ColumnMap();
            this.f27430e = columnMap2;
            return columnMap2;
        }
        return columnMap;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != null && obj2 != null && super.contains(obj, obj2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map<C, V> map : this.backingMap.values()) {
            if (Maps.C(map, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@CheckForNull Object obj) {
        if (obj != null && Maps.C(this.backingMap, obj)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object obj) {
        if (obj != null && super.containsValue(obj)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != null && obj2 != null) {
            return (V) super.get(obj, obj2);
        }
        return null;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    Iterator<C> j() {
        return new ColumnKeyIterator();
    }

    Map<R, Map<C, V>> l() {
        return new RowMap();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(R r4, C c4, V v3) {
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(c4);
        Preconditions.checkNotNull(v3);
        return m(r4).put(c4, v3);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.D(this.backingMap, obj)) == null) {
            return null;
        }
        V v3 = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v3;
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r4) {
        return new Row(r4);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.f27429d;
        if (map == null) {
            Map<R, Map<C, V>> l4 = l();
            this.f27429d = l4;
            return l4;
        }
        return map;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        int i4 = 0;
        for (Map<C, V> map : this.backingMap.values()) {
            i4 += map.size();
        }
        return i4;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }
}
