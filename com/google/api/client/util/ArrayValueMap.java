package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes5.dex */
public final class ArrayValueMap {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, ArrayValue> f26067a = ArrayMap.create();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Field, ArrayValue> f26068b = ArrayMap.create();

    /* renamed from: c  reason: collision with root package name */
    private final Object f26069c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ArrayValue {

        /* renamed from: a  reason: collision with root package name */
        final Class<?> f26070a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<Object> f26071b = new ArrayList<>();

        ArrayValue(Class<?> cls) {
            this.f26070a = cls;
        }

        void a(Class<?> cls, Object obj) {
            boolean z3;
            if (cls == this.f26070a) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.f26071b.add(obj);
        }

        Object b() {
            return Types.toArray(this.f26071b, this.f26070a);
        }
    }

    public ArrayValueMap(Object obj) {
        this.f26069c = obj;
    }

    public void put(Field field, Class<?> cls, Object obj) {
        ArrayValue arrayValue = this.f26068b.get(field);
        if (arrayValue == null) {
            arrayValue = new ArrayValue(cls);
            this.f26068b.put(field, arrayValue);
        }
        arrayValue.a(cls, obj);
    }

    public void setValues() {
        for (Map.Entry<String, ArrayValue> entry : this.f26067a.entrySet()) {
            ((Map) this.f26069c).put(entry.getKey(), entry.getValue().b());
        }
        for (Map.Entry<Field, ArrayValue> entry2 : this.f26068b.entrySet()) {
            FieldInfo.setFieldValue(entry2.getKey(), this.f26069c, entry2.getValue().b());
        }
    }

    public void put(String str, Class<?> cls, Object obj) {
        ArrayValue arrayValue = this.f26067a.get(str);
        if (arrayValue == null) {
            arrayValue = new ArrayValue(cls);
            this.f26067a.put(str, arrayValue);
        }
        arrayValue.a(cls, obj);
    }
}
