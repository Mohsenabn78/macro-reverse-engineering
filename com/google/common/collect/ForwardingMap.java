package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {

    /* loaded from: classes5.dex */
    protected abstract class StandardEntrySet extends Maps.EntrySet<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ForwardingMap f26837a;

        @Override // com.google.common.collect.Maps.EntrySet
        Map<K, V> d() {
            return this.f26837a;
        }
    }

    /* loaded from: classes5.dex */
    protected class StandardKeySet extends Maps.KeySet<K, V> {
        public StandardKeySet(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    /* loaded from: classes5.dex */
    protected class StandardValues extends Maps.Values<K, V> {
        public StandardValues(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    public void clear() {
        e().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return e().containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return e().containsValue(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return e().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        if (obj != this && !e().equals(obj)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: f */
    public abstract Map<K, V> e();

    /* JADX INFO: Access modifiers changed from: protected */
    public String g() {
        return Maps.F(this);
    }

    @Override // java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        return e().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return e().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return e().isEmpty();
    }

    public Set<K> keySet() {
        return e().keySet();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness K k4, @ParametricNullness V v3) {
        return e().put(k4, v3);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        e().putAll(map);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        return e().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return e().size();
    }

    public Collection<V> values() {
        return e().values();
    }
}
