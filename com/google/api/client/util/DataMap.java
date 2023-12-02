package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class DataMap extends AbstractMap<String, Object> {

    /* renamed from: a  reason: collision with root package name */
    final Object f26086a;

    /* renamed from: b  reason: collision with root package name */
    final ClassInfo f26087b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class Entry implements Map.Entry<String, Object> {

        /* renamed from: a  reason: collision with root package name */
        private Object f26088a;

        /* renamed from: b  reason: collision with root package name */
        private final FieldInfo f26089b;

        Entry(FieldInfo fieldInfo, Object obj) {
            this.f26089b = fieldInfo;
            this.f26088a = Preconditions.checkNotNull(obj);
        }

        @Override // java.util.Map.Entry
        /* renamed from: a */
        public String getKey() {
            String name = this.f26089b.getName();
            if (DataMap.this.f26087b.getIgnoreCase()) {
                return name.toLowerCase();
            }
            return name;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey().equals(entry.getKey()) && getValue().equals(entry.getValue())) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f26088a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f26088a;
            this.f26088a = Preconditions.checkNotNull(obj);
            this.f26089b.setValue(DataMap.this.f26086a, obj);
            return obj2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class EntryIterator implements Iterator<Map.Entry<String, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private int f26091a = -1;

        /* renamed from: b  reason: collision with root package name */
        private FieldInfo f26092b;

        /* renamed from: c  reason: collision with root package name */
        private Object f26093c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f26094d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f26095e;

        /* renamed from: f  reason: collision with root package name */
        private FieldInfo f26096f;

        EntryIterator() {
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<String, Object> next() {
            if (hasNext()) {
                FieldInfo fieldInfo = this.f26092b;
                this.f26096f = fieldInfo;
                Object obj = this.f26093c;
                this.f26095e = false;
                this.f26094d = false;
                this.f26092b = null;
                this.f26093c = null;
                return new Entry(fieldInfo, obj);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f26095e) {
                this.f26095e = true;
                this.f26093c = null;
                while (this.f26093c == null) {
                    int i4 = this.f26091a + 1;
                    this.f26091a = i4;
                    if (i4 >= DataMap.this.f26087b.f26083d.size()) {
                        break;
                    }
                    ClassInfo classInfo = DataMap.this.f26087b;
                    FieldInfo fieldInfo = classInfo.getFieldInfo(classInfo.f26083d.get(this.f26091a));
                    this.f26092b = fieldInfo;
                    this.f26093c = fieldInfo.getValue(DataMap.this.f26086a);
                }
            }
            if (this.f26093c != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z3;
            if (this.f26096f != null && !this.f26094d) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            this.f26094d = true;
            this.f26096f.setValue(DataMap.this.f26086a, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class EntrySet extends AbstractSet<Map.Entry<String, Object>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a */
        public EntryIterator iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            for (String str : DataMap.this.f26087b.f26083d) {
                DataMap.this.f26087b.getFieldInfo(str).setValue(DataMap.this.f26086a, null);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            for (String str : DataMap.this.f26087b.f26083d) {
                if (DataMap.this.f26087b.getFieldInfo(str).getValue(DataMap.this.f26086a) != null) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i4 = 0;
            for (String str : DataMap.this.f26087b.f26083d) {
                if (DataMap.this.f26087b.getFieldInfo(str).getValue(DataMap.this.f26086a) != null) {
                    i4++;
                }
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataMap(Object obj, boolean z3) {
        this.f26086a = obj;
        ClassInfo of = ClassInfo.of(obj.getClass(), z3);
        this.f26087b = of;
        Preconditions.checkArgument(!of.isEnum());
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public EntrySet entrySet() {
        return new EntrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: c */
    public Object put(String str, Object obj) {
        String str2;
        FieldInfo fieldInfo = this.f26087b.getFieldInfo(str);
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "no field of key ".concat(valueOf);
        } else {
            str2 = new String("no field of key ");
        }
        Preconditions.checkNotNull(fieldInfo, str2);
        Object value = fieldInfo.getValue(this.f26086a);
        fieldInfo.setValue(this.f26086a, Preconditions.checkNotNull(obj));
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        FieldInfo fieldInfo;
        if (!(obj instanceof String) || (fieldInfo = this.f26087b.getFieldInfo((String) obj)) == null) {
            return null;
        }
        return fieldInfo.getValue(this.f26086a);
    }
}
