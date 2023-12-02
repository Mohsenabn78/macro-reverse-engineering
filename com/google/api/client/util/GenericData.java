package com.google.api.client.util;

import com.google.api.client.util.DataMap;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class GenericData extends AbstractMap<String, Object> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    Map<String, Object> f26119a;

    /* renamed from: b  reason: collision with root package name */
    final ClassInfo f26120b;

    /* loaded from: classes5.dex */
    final class EntryIterator implements Iterator<Map.Entry<String, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f26121a;

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<Map.Entry<String, Object>> f26122b;

        /* renamed from: c  reason: collision with root package name */
        private final Iterator<Map.Entry<String, Object>> f26123c;

        EntryIterator(DataMap.EntrySet entrySet) {
            this.f26122b = entrySet.iterator();
            this.f26123c = GenericData.this.f26119a.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<String, Object> next() {
            if (!this.f26121a) {
                if (this.f26122b.hasNext()) {
                    return this.f26122b.next();
                }
                this.f26121a = true;
            }
            return this.f26123c.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f26122b.hasNext() && !this.f26123c.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f26121a) {
                this.f26123c.remove();
            }
            this.f26122b.remove();
        }
    }

    /* loaded from: classes5.dex */
    final class EntrySet extends AbstractSet<Map.Entry<String, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private final DataMap.EntrySet f26125a;

        EntrySet() {
            this.f26125a = new DataMap(GenericData.this, GenericData.this.f26120b.getIgnoreCase()).entrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            GenericData.this.f26119a.clear();
            this.f26125a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<String, Object>> iterator() {
            return new EntryIterator(this.f26125a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return GenericData.this.f26119a.size() + this.f26125a.size();
        }
    }

    /* loaded from: classes5.dex */
    public enum Flags {
        IGNORE_CASE
    }

    public GenericData() {
        this(EnumSet.noneOf(Flags.class));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return new EntrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        FieldInfo fieldInfo = this.f26120b.getFieldInfo(str);
        if (fieldInfo != null) {
            return fieldInfo.getValue(this);
        }
        if (this.f26120b.getIgnoreCase()) {
            str = str.toLowerCase();
        }
        return this.f26119a.get(str);
    }

    public final ClassInfo getClassInfo() {
        return this.f26120b;
    }

    public final Map<String, Object> getUnknownKeys() {
        return this.f26119a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends String, ?> map) {
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            set(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (this.f26120b.getFieldInfo(str) == null) {
            if (this.f26120b.getIgnoreCase()) {
                str = str.toLowerCase();
            }
            return this.f26119a.remove(str);
        }
        throw new UnsupportedOperationException();
    }

    public GenericData set(String str, Object obj) {
        FieldInfo fieldInfo = this.f26120b.getFieldInfo(str);
        if (fieldInfo != null) {
            fieldInfo.setValue(this, obj);
        } else {
            if (this.f26120b.getIgnoreCase()) {
                str = str.toLowerCase();
            }
            this.f26119a.put(str, obj);
        }
        return this;
    }

    public final void setUnknownKeys(Map<String, Object> map) {
        this.f26119a = map;
    }

    public GenericData(EnumSet<Flags> enumSet) {
        this.f26119a = ArrayMap.create();
        this.f26120b = ClassInfo.of(getClass(), enumSet.contains(Flags.IGNORE_CASE));
    }

    @Override // java.util.AbstractMap
    public GenericData clone() {
        try {
            GenericData genericData = (GenericData) super.clone();
            Data.deepCopy(this, genericData);
            genericData.f26119a = (Map) Data.clone(this.f26119a);
            return genericData;
        } catch (CloneNotSupportedException e4) {
            throw new IllegalStateException(e4);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(String str, Object obj) {
        FieldInfo fieldInfo = this.f26120b.getFieldInfo(str);
        if (fieldInfo != null) {
            Object value = fieldInfo.getValue(this);
            fieldInfo.setValue(this, obj);
            return value;
        }
        if (this.f26120b.getIgnoreCase()) {
            str = str.toLowerCase();
        }
        return this.f26119a.put(str, obj);
    }
}
