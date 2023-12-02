package com.google.common.collect;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private transient ArrayTable<R, C, V>.ColumnMap f26693c;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    private transient ArrayTable<R, C, V>.RowMap f26694d;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableMap<K, Integer> f26701a;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V>> a() {
            return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) { // from class: com.google.common.collect.ArrayTable.ArrayMap.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIndexedListIterator
                /* renamed from: b */
                public Map.Entry<K, V> a(int i4) {
                    return ArrayMap.this.c(i4);
                }
            };
        }

        Map.Entry<K, V> c(final int i4) {
            Preconditions.checkElementIndex(i4, size());
            return new AbstractMapEntry<K, V>() { // from class: com.google.common.collect.ArrayTable.ArrayMap.1
                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public K getKey() {
                    return (K) ArrayMap.this.d(i4);
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                @ParametricNullness
                public V getValue() {
                    return (V) ArrayMap.this.f(i4);
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                @ParametricNullness
                public V setValue(@ParametricNullness V v3) {
                    return (V) ArrayMap.this.g(i4, v3);
                }
            };
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return this.f26701a.containsKey(obj);
        }

        K d(int i4) {
            return this.f26701a.keySet().asList().get(i4);
        }

        abstract String e();

        @ParametricNullness
        abstract V f(int i4);

        @ParametricNullness
        abstract V g(int i4, @ParametricNullness V v3);

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Integer num = this.f26701a.get(obj);
            if (num == null) {
                return null;
            }
            return f(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f26701a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f26701a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(K k4, @ParametricNullness V v3) {
            Integer num = this.f26701a.get(k4);
            if (num != null) {
                return g(num.intValue(), v3);
            }
            throw new IllegalArgumentException(e() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + k4 + " not in " + this.f26701a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f26701a.size();
        }

        private ArrayMap(ImmutableMap<K, Integer> immutableMap) {
            this.f26701a = immutableMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class Column extends ArrayMap<R, V> {

        /* renamed from: b  reason: collision with root package name */
        final int f26705b;

        Column(int i4) {
            super(ArrayTable.this.rowKeyToIndex);
            this.f26705b = i4;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String e() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        V f(int i4) {
            return (V) ArrayTable.this.at(i4, this.f26705b);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        V g(int i4, @CheckForNull V v3) {
            return (V) ArrayTable.this.set(i4, this.f26705b, v3);
        }
    }

    /* loaded from: classes5.dex */
    private class ColumnMap extends ArrayMap<C, Map<R, V>> {
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String e() {
            return "Column";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* renamed from: h */
        public Map<R, V> f(int i4) {
            return new Column(i4);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: i */
        public Map<R, V> put(C c4, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* renamed from: j */
        public Map<R, V> g(int i4, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        private ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class Row extends ArrayMap<C, V> {

        /* renamed from: b  reason: collision with root package name */
        final int f26708b;

        Row(int i4) {
            super(ArrayTable.this.columnKeyToIndex);
            this.f26708b = i4;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String e() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        V f(int i4) {
            return (V) ArrayTable.this.at(this.f26708b, i4);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        @CheckForNull
        V g(int i4, @CheckForNull V v3) {
            return (V) ArrayTable.this.set(this.f26708b, i4, v3);
        }
    }

    /* loaded from: classes5.dex */
    private class RowMap extends ArrayMap<R, Map<C, V>> {
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String e() {
            return "Row";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* renamed from: h */
        public Map<C, V> f(int i4) {
            return new Row(i4);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: i */
        public Map<C, V> put(R r4, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* renamed from: j */
        public Map<C, V> g(int i4, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        private RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> copyOf = ImmutableList.copyOf(iterable);
        this.rowList = copyOf;
        ImmutableList<C> copyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = copyOf2;
        Preconditions.checkArgument(copyOf.isEmpty() == copyOf2.isEmpty());
        this.rowKeyToIndex = Maps.s(copyOf);
        this.columnKeyToIndex = Maps.s(copyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, copyOf.size(), copyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Table.Cell<R, C, V> m(int i4) {
        return new Tables.AbstractCell<R, C, V>(i4) { // from class: com.google.common.collect.ArrayTable.2

            /* renamed from: a  reason: collision with root package name */
            final int f26696a;

            /* renamed from: b  reason: collision with root package name */
            final int f26697b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f26698c;

            {
                this.f26698c = i4;
                this.f26696a = i4 / ArrayTable.this.columnList.size();
                this.f26697b = i4 % ArrayTable.this.columnList.size();
            }

            @Override // com.google.common.collect.Table.Cell
            public C getColumnKey() {
                return (C) ArrayTable.this.columnList.get(this.f26697b);
            }

            @Override // com.google.common.collect.Table.Cell
            public R getRowKey() {
                return (R) ArrayTable.this.rowList.get(this.f26696a);
            }

            @Override // com.google.common.collect.Table.Cell
            @CheckForNull
            public V getValue() {
                return (V) ArrayTable.this.at(this.f26696a, this.f26697b);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public V n(int i4) {
        return at(i4 / this.columnList.size(), i4 % this.columnList.size());
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator<Table.Cell<R, C, V>> a() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) { // from class: com.google.common.collect.ArrayTable.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIndexedListIterator
            /* renamed from: b */
            public Table.Cell<R, C, V> a(int i4) {
                return ArrayTable.this.m(i4);
            }
        };
    }

    @CheckForNull
    public V at(int i4, int i5) {
        Preconditions.checkElementIndex(i4, this.rowList.size());
        Preconditions.checkElementIndex(i5, this.columnList.size());
        return this.array[i4][i5];
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c4) {
        Preconditions.checkNotNull(c4);
        Integer num = this.columnKeyToIndex.get(c4);
        if (num == null) {
            return Collections.emptyMap();
        }
        return new Column(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.ColumnMap columnMap = this.f26693c;
        if (columnMap == null) {
            ArrayTable<R, C, V>.ColumnMap columnMap2 = new ColumnMap();
            this.f26693c = columnMap2;
            return columnMap2;
        }
        return columnMap;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (containsRow(obj) && containsColumn(obj2)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@CheckForNull Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@CheckForNull Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object obj) {
        V[][] vArr;
        for (V[] vArr2 : this.array) {
            for (V v3 : vArr2) {
                if (Objects.equal(obj, v3)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator<V> e() {
        return new AbstractIndexedListIterator<V>(size()) { // from class: com.google.common.collect.ArrayTable.3
            @Override // com.google.common.collect.AbstractIndexedListIterator
            @CheckForNull
            protected V a(int i4) {
                return (V) ArrayTable.this.n(i4);
            }
        };
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V erase(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num != null && num2 != null) {
            return at(num.intValue(), num2.intValue());
        }
        return null;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        if (!this.rowList.isEmpty() && !this.columnList.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(R r4, C c4, @CheckForNull V v3) {
        boolean z3;
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(c4);
        Integer num = this.rowKeyToIndex.get(r4);
        boolean z4 = true;
        if (num != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Row %s not in %s", r4, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c4);
        if (num2 == null) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "Column %s not in %s", c4, this.columnList);
        return set(num.intValue(), num2.intValue(), v3);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r4) {
        Preconditions.checkNotNull(r4);
        Integer num = this.rowKeyToIndex.get(r4);
        if (num == null) {
            return Collections.emptyMap();
        }
        return new Row(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.RowMap rowMap = this.f26694d;
        if (rowMap == null) {
            ArrayTable<R, C, V>.RowMap rowMap2 = new RowMap();
            this.f26694d = rowMap2;
            return rowMap2;
        }
        return rowMap;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V set(int i4, int i5, @CheckForNull V v3) {
        Preconditions.checkElementIndex(i4, this.rowList.size());
        Preconditions.checkElementIndex(i5, this.columnList.size());
        V[] vArr = this.array[i4];
        V v4 = vArr[i5];
        vArr[i5] = v3;
        return v4;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i4 = 0; i4 < this.rowList.size(); i4++) {
            V[] vArr2 = this.array[i4];
            System.arraycopy(vArr2, 0, vArr[i4], 0, vArr2.length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, ? extends V> table) {
        if (table instanceof ArrayTable) {
            return new ArrayTable<>((ArrayTable) table);
        }
        return new ArrayTable<>(table);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(Table<R, C, ? extends V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i4 = 0; i4 < this.rowList.size(); i4++) {
            V[] vArr2 = arrayTable.array[i4];
            System.arraycopy(vArr2, 0, vArr[i4], 0, vArr2.length);
        }
    }
}
