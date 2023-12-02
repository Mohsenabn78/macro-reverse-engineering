package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return e().cellSet();
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        e().clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(@ParametricNullness C c4) {
        return e().column(c4);
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        return e().columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        return e().columnMap();
    }

    @Override // com.google.common.collect.Table
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return e().contains(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@CheckForNull Object obj) {
        return e().containsColumn(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@CheckForNull Object obj) {
        return e().containsRow(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@CheckForNull Object obj) {
        return e().containsValue(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean equals(@CheckForNull Object obj) {
        if (obj != this && !e().equals(obj)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: f */
    public abstract Table<R, C, V> e();

    @Override // com.google.common.collect.Table
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return e().get(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return e().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return e().isEmpty();
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness R r4, @ParametricNullness C c4, @ParametricNullness V v3) {
        return e().put(r4, c4, v3);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        e().putAll(table);
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return e().remove(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(@ParametricNullness R r4) {
        return e().row(r4);
    }

    @Override // com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return e().rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        return e().rowMap();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return e().size();
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        return e().values();
    }
}
