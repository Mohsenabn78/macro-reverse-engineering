package com.google.common.collect;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable(containerOf = {"R", "C", ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    private final int[] columnCounts;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final int[] rowCounts;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    private final V[][] values;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class Column extends ImmutableArrayMap<R, V> {
        private final int columnIndex;

        Column(int i4) {
            super(DenseImmutableTable.this.columnCounts[i4]);
            this.columnIndex = i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean j() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        @CheckForNull
        V o(int i4) {
            return (V) DenseImmutableTable.this.values[i4][this.columnIndex];
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<R, Integer> q() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }
    }

    /* loaded from: classes5.dex */
    private final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean j() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<C, Integer> q() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* renamed from: r */
        public ImmutableMap<R, V> o(int i4) {
            return new Column(i4);
        }

        private ColumnMap() {
            super(DenseImmutableTable.this.columnCounts.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        private final int size;

        ImmutableArrayMap(int i4) {
            this.size = i4;
        }

        private boolean p() {
            if (this.size == q().size()) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> f() {
            if (p()) {
                return q().keySet();
            }
            return super.f();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Integer num = q().get(obj);
            if (num == null) {
                return null;
            }
            return o(num.intValue());
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        UnmodifiableIterator<Map.Entry<K, V>> m() {
            return new AbstractIterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.DenseImmutableTable.ImmutableArrayMap.1

                /* renamed from: c  reason: collision with root package name */
                private int f26784c = -1;

                /* renamed from: d  reason: collision with root package name */
                private final int f26785d;

                {
                    this.f26785d = ImmutableArrayMap.this.q().size();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<K, V> a() {
                    int i4 = this.f26784c;
                    while (true) {
                        this.f26784c = i4 + 1;
                        int i5 = this.f26784c;
                        if (i5 < this.f26785d) {
                            Object o4 = ImmutableArrayMap.this.o(i5);
                            if (o4 != null) {
                                return Maps.immutableEntry(ImmutableArrayMap.this.n(this.f26784c), o4);
                            }
                            i4 = this.f26784c;
                        } else {
                            return b();
                        }
                    }
                }
            };
        }

        K n(int i4) {
            return q().keySet().asList().get(i4);
        }

        @CheckForNull
        abstract V o(int i4);

        abstract ImmutableMap<K, Integer> q();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class Row extends ImmutableArrayMap<C, V> {
        private final int rowIndex;

        Row(int i4) {
            super(DenseImmutableTable.this.rowCounts[i4]);
            this.rowIndex = i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean j() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        @CheckForNull
        V o(int i4) {
            return (V) DenseImmutableTable.this.values[this.rowIndex][i4];
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<C, Integer> q() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }
    }

    /* loaded from: classes5.dex */
    private final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean j() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<R, Integer> q() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* renamed from: r */
        public ImmutableMap<C, V> o(int i4) {
            return new Row(i4);
        }

        private RowMap() {
            super(DenseImmutableTable.this.rowCounts.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableSet.size(), immutableSet2.size()));
        ImmutableMap<R, Integer> s3 = Maps.s(immutableSet);
        this.rowKeyToIndex = s3;
        ImmutableMap<C, Integer> s4 = Maps.s(immutableSet2);
        this.columnKeyToIndex = s4;
        this.rowCounts = new int[s3.size()];
        this.columnCounts = new int[s4.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i4 = 0; i4 < immutableList.size(); i4++) {
            Table.Cell<R, C, V> cell = immutableList.get(i4);
            R rowKey = cell.getRowKey();
            C columnKey = cell.getColumnKey();
            Integer num = this.rowKeyToIndex.get(rowKey);
            Objects.requireNonNull(num);
            int intValue = num.intValue();
            Integer num2 = this.columnKeyToIndex.get(columnKey);
            Objects.requireNonNull(num2);
            int intValue2 = num2.intValue();
            n(rowKey, columnKey, this.values[intValue][intValue2], cell.getValue());
            this.values[intValue][intValue2] = cell.getValue();
            int[] iArr3 = this.rowCounts;
            iArr3[intValue] = iArr3[intValue] + 1;
            int[] iArr4 = this.columnCounts;
            iArr4[intValue2] = iArr4[intValue2] + 1;
            iArr[i4] = intValue;
            iArr2[i4] = intValue2;
        }
        this.cellRowIndices = iArr;
        this.cellColumnIndices = iArr2;
        this.rowMap = new RowMap();
        this.columnMap = new ColumnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num != null && num2 != null) {
            return this.values[num.intValue()][num2.intValue()];
        }
        return null;
    }

    @Override // com.google.common.collect.ImmutableTable
    ImmutableTable.SerializedForm j() {
        return ImmutableTable.SerializedForm.a(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    Table.Cell<R, C, V> r(int i4) {
        int i5 = this.cellRowIndices[i4];
        int i6 = this.cellColumnIndices[i4];
        R r4 = rowKeySet().asList().get(i5);
        C c4 = columnKeySet().asList().get(i6);
        V v3 = this.values[i5][i6];
        Objects.requireNonNull(v3);
        return ImmutableTable.g(r4, c4, v3);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    V s(int i4) {
        V v3 = this.values[this.cellRowIndices[i4]][this.cellColumnIndices[i4]];
        Objects.requireNonNull(v3);
        return v3;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf((Map) this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf((Map) this.rowMap);
    }
}
