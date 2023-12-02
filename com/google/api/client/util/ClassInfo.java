package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public final class ClassInfo {

    /* renamed from: e  reason: collision with root package name */
    private static final Map<Class<?>, ClassInfo> f26078e = new WeakHashMap();

    /* renamed from: f  reason: collision with root package name */
    private static final Map<Class<?>, ClassInfo> f26079f = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f26080a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f26081b;

    /* renamed from: c  reason: collision with root package name */
    private final IdentityHashMap<String, FieldInfo> f26082c = new IdentityHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    final List<String> f26083d;

    private ClassInfo(Class<?> cls, boolean z3) {
        boolean z4;
        Field[] declaredFields;
        List<String> unmodifiableList;
        boolean z5;
        String str;
        Field field;
        this.f26080a = cls;
        this.f26081b = z3;
        if (z3 && cls.isEnum()) {
            z4 = false;
        } else {
            z4 = true;
        }
        String valueOf = String.valueOf(cls);
        StringBuilder sb = new StringBuilder(valueOf.length() + 31);
        sb.append("cannot ignore case on an enum: ");
        sb.append(valueOf);
        Preconditions.checkArgument(z4, sb.toString());
        TreeSet treeSet = new TreeSet(new Comparator<String>() { // from class: com.google.api.client.util.ClassInfo.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(String str2, String str3) {
                if (str2 == str3) {
                    return 0;
                }
                if (str2 == null) {
                    return -1;
                }
                if (str3 == null) {
                    return 1;
                }
                return str2.compareTo(str3);
            }
        });
        for (Field field2 : cls.getDeclaredFields()) {
            FieldInfo of = FieldInfo.of(field2);
            if (of != null) {
                String name = of.getName();
                name = z3 ? name.toLowerCase().intern() : name;
                FieldInfo fieldInfo = this.f26082c.get(name);
                if (fieldInfo == null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Object[] objArr = new Object[4];
                if (z3) {
                    str = "case-insensitive ";
                } else {
                    str = "";
                }
                objArr[0] = str;
                objArr[1] = name;
                objArr[2] = field2;
                if (fieldInfo == null) {
                    field = null;
                } else {
                    field = fieldInfo.getField();
                }
                objArr[3] = field;
                Preconditions.checkArgument(z5, "two fields have the same %sname <%s>: %s and %s", objArr);
                this.f26082c.put(name, of);
                treeSet.add(name);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            ClassInfo of2 = of(superclass, z3);
            treeSet.addAll(of2.f26083d);
            for (Map.Entry<String, FieldInfo> entry : of2.f26082c.entrySet()) {
                String key = entry.getKey();
                if (!this.f26082c.containsKey(key)) {
                    this.f26082c.put(key, entry.getValue());
                }
            }
        }
        if (treeSet.isEmpty()) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(treeSet));
        }
        this.f26083d = unmodifiableList;
    }

    public static ClassInfo of(Class<?> cls) {
        return of(cls, false);
    }

    public Field getField(String str) {
        FieldInfo fieldInfo = getFieldInfo(str);
        if (fieldInfo == null) {
            return null;
        }
        return fieldInfo.getField();
    }

    public FieldInfo getFieldInfo(String str) {
        if (str != null) {
            if (this.f26081b) {
                str = str.toLowerCase();
            }
            str = str.intern();
        }
        return this.f26082c.get(str);
    }

    public Collection<FieldInfo> getFieldInfos() {
        return Collections.unmodifiableCollection(this.f26082c.values());
    }

    public final boolean getIgnoreCase() {
        return this.f26081b;
    }

    public Collection<String> getNames() {
        return this.f26083d;
    }

    public Class<?> getUnderlyingClass() {
        return this.f26080a;
    }

    public boolean isEnum() {
        return this.f26080a.isEnum();
    }

    public static ClassInfo of(Class<?> cls, boolean z3) {
        ClassInfo classInfo;
        if (cls == null) {
            return null;
        }
        Map<Class<?>, ClassInfo> map = z3 ? f26079f : f26078e;
        synchronized (map) {
            classInfo = map.get(cls);
            if (classInfo == null) {
                classInfo = new ClassInfo(cls, z3);
                map.put(cls, classInfo);
            }
        }
        return classInfo;
    }
}
