package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public class FieldInfo {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Field, FieldInfo> f26115d = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f26116a;

    /* renamed from: b  reason: collision with root package name */
    private final Field f26117b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26118c;

    FieldInfo(Field field, String str) {
        String intern;
        this.f26117b = field;
        if (str == null) {
            intern = null;
        } else {
            intern = str.intern();
        }
        this.f26118c = intern;
        this.f26116a = Data.isPrimitive(getType());
    }

    public static Object getFieldValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static FieldInfo of(Enum<?> r5) {
        try {
            FieldInfo of = of(r5.getClass().getField(r5.name()));
            Preconditions.checkArgument(of != null, "enum constant missing @Value or @NullValue annotation: %s", r5);
            return of;
        } catch (NoSuchFieldException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void setFieldValue(Field field, Object obj, Object obj2) {
        if (Modifier.isFinal(field.getModifiers())) {
            Object fieldValue = getFieldValue(field, obj);
            if (obj2 == null) {
                if (fieldValue == null) {
                    return;
                }
            } else if (obj2.equals(fieldValue)) {
                return;
            }
            String valueOf = String.valueOf(fieldValue);
            String valueOf2 = String.valueOf(obj2);
            String valueOf3 = String.valueOf(field.getName());
            String name = obj.getClass().getName();
            StringBuilder sb = new StringBuilder(valueOf.length() + 48 + valueOf2.length() + valueOf3.length() + name.length());
            sb.append("expected final value <");
            sb.append(valueOf);
            sb.append("> but was <");
            sb.append(valueOf2);
            sb.append("> on ");
            sb.append(valueOf3);
            sb.append(" field in ");
            sb.append(name);
            throw new IllegalArgumentException(sb.toString());
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e4) {
            throw new IllegalArgumentException(e4);
        } catch (SecurityException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public <T extends Enum<T>> T enumValue() {
        return (T) Enum.valueOf(this.f26117b.getDeclaringClass(), this.f26117b.getName());
    }

    public ClassInfo getClassInfo() {
        return ClassInfo.of(this.f26117b.getDeclaringClass());
    }

    public Field getField() {
        return this.f26117b;
    }

    public Type getGenericType() {
        return this.f26117b.getGenericType();
    }

    public String getName() {
        return this.f26118c;
    }

    public Class<?> getType() {
        return this.f26117b.getType();
    }

    public Object getValue(Object obj) {
        return getFieldValue(this.f26117b, obj);
    }

    public boolean isFinal() {
        return Modifier.isFinal(this.f26117b.getModifiers());
    }

    public boolean isPrimitive() {
        return this.f26116a;
    }

    public void setValue(Object obj, Object obj2) {
        setFieldValue(this.f26117b, obj, obj2);
    }

    public static FieldInfo of(Field field) {
        String str = null;
        if (field == null) {
            return null;
        }
        Map<Field, FieldInfo> map = f26115d;
        synchronized (map) {
            FieldInfo fieldInfo = map.get(field);
            boolean isEnumConstant = field.isEnumConstant();
            if (fieldInfo == null && (isEnumConstant || !Modifier.isStatic(field.getModifiers()))) {
                if (isEnumConstant) {
                    Value value = (Value) field.getAnnotation(Value.class);
                    if (value != null) {
                        str = value.value();
                    } else if (((NullValue) field.getAnnotation(NullValue.class)) == null) {
                        return null;
                    }
                } else {
                    Key key = (Key) field.getAnnotation(Key.class);
                    if (key == null) {
                        return null;
                    }
                    str = key.value();
                    field.setAccessible(true);
                }
                if ("##default".equals(str)) {
                    str = field.getName();
                }
                fieldInfo = new FieldInfo(field, str);
                map.put(field, fieldInfo);
            }
            return fieldInfo;
        }
    }
}
