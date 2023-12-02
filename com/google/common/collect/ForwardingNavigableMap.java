package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        public StandardDescendingMap() {
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        protected Iterator<Map.Entry<K, V>> i() {
            return new Iterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.1
                @CheckForNull

                /* renamed from: a  reason: collision with root package name */
                private Map.Entry<K, V> f26840a = null;
                @CheckForNull

                /* renamed from: b  reason: collision with root package name */
                private Map.Entry<K, V> f26841b;

                {
                    this.f26841b = StandardDescendingMap.this.j().lastEntry();
                }

                @Override // java.util.Iterator
                /* renamed from: a */
                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> entry = this.f26841b;
                    if (entry != null) {
                        this.f26840a = entry;
                        this.f26841b = StandardDescendingMap.this.j().lowerEntry(this.f26841b.getKey());
                        return entry;
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.f26841b != null) {
                        return true;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.f26840a != null) {
                        StandardDescendingMap.this.j().remove(this.f26840a.getKey());
                        this.f26840a = null;
                        return;
                    }
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }
            };
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        NavigableMap<K, V> j() {
            return ForwardingNavigableMap.this;
        }
    }

    /* loaded from: classes5.dex */
    protected class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
            super(forwardingNavigableMap);
        }
    }

    protected ForwardingNavigableMap() {
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k4) {
        return h().ceilingEntry(k4);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(@ParametricNullness K k4) {
        return h().ceilingKey(k4);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return h().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return h().descendingMap();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return h().firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(@ParametricNullness K k4) {
        return h().floorEntry(k4);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(@ParametricNullness K k4) {
        return h().floorKey(k4);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(@ParametricNullness K k4, boolean z3) {
        return h().headMap(k4, z3);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(@ParametricNullness K k4) {
        return h().higherEntry(k4);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(@ParametricNullness K k4) {
        return h().higherKey(k4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSortedMap
    /* renamed from: i */
    public abstract NavigableMap<K, V> h();

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return h().lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@ParametricNullness K k4) {
        return h().lowerEntry(k4);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(@ParametricNullness K k4) {
        return h().lowerKey(k4);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return h().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return h().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return h().pollLastEntry();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(@ParametricNullness K k4, boolean z3, @ParametricNullness K k5, boolean z4) {
        return h().subMap(k4, z3, k5, z4);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(@ParametricNullness K k4, boolean z3) {
        return h().tailMap(k4, z3);
    }
}
