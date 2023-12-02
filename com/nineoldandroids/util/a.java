package com.nineoldandroids.util;

import com.google.mlkit.nl.translate.TranslateLanguage;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ReflectiveProperty.java */
/* loaded from: classes6.dex */
class a<T, V> extends Property<T, V> {

    /* renamed from: c  reason: collision with root package name */
    private Method f36409c;

    /* renamed from: d  reason: collision with root package name */
    private Method f36410d;

    /* renamed from: e  reason: collision with root package name */
    private Field f36411e;

    public a(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String str3 = "get" + str2;
        try {
            try {
                this.f36410d = cls.getMethod(str3, null);
            } catch (NoSuchMethodException unused) {
                Method declaredMethod = cls.getDeclaredMethod(str3, null);
                this.f36410d = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused2) {
            String str4 = TranslateLanguage.ICELANDIC + str2;
            try {
                try {
                    try {
                        this.f36410d = cls.getMethod(str4, null);
                    } catch (NoSuchMethodException unused3) {
                        Method declaredMethod2 = cls.getDeclaredMethod(str4, null);
                        this.f36410d = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    }
                } catch (NoSuchMethodException unused4) {
                    Field field = cls.getField(str);
                    this.f36411e = field;
                    Class<?> type = field.getType();
                    if (a(cls2, type)) {
                        return;
                    }
                    throw new NoSuchPropertyException("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                }
            } catch (NoSuchFieldException unused5) {
                throw new NoSuchPropertyException("No accessor method or field found for property with name " + str);
            }
        }
        Class<?> returnType = this.f36410d.getReturnType();
        if (a(cls2, returnType)) {
            try {
                Method declaredMethod3 = cls.getDeclaredMethod("set" + str2, returnType);
                this.f36409c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                return;
            } catch (NoSuchMethodException unused6) {
                return;
            }
        }
        throw new NoSuchPropertyException("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
    }

    private boolean a(Class<V> cls, Class cls2) {
        if (cls2 == cls) {
            return true;
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (cls2 == Float.TYPE && cls == Float.class) {
            return true;
        }
        if (cls2 == Integer.TYPE && cls == Integer.class) {
            return true;
        }
        if (cls2 == Boolean.TYPE && cls == Boolean.class) {
            return true;
        }
        if (cls2 == Long.TYPE && cls == Long.class) {
            return true;
        }
        if (cls2 == Double.TYPE && cls == Double.class) {
            return true;
        }
        if (cls2 == Short.TYPE && cls == Short.class) {
            return true;
        }
        if (cls2 == Byte.TYPE && cls == Byte.class) {
            return true;
        }
        if (cls2 == Character.TYPE && cls == Character.class) {
            return true;
        }
        return false;
    }

    @Override // com.nineoldandroids.util.Property
    public V get(T t3) {
        Method method = this.f36410d;
        if (method != null) {
            try {
                return (V) method.invoke(t3, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
        Field field = this.f36411e;
        if (field != null) {
            try {
                return (V) field.get(t3);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }

    @Override // com.nineoldandroids.util.Property
    public boolean isReadOnly() {
        if (this.f36409c == null && this.f36411e == null) {
            return true;
        }
        return false;
    }

    @Override // com.nineoldandroids.util.Property
    public void set(T t3, V v3) {
        Method method = this.f36409c;
        if (method != null) {
            try {
                method.invoke(t3, v3);
                return;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4.getCause());
            }
        }
        Field field = this.f36411e;
        if (field != null) {
            try {
                field.set(t3, v3);
                return;
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new UnsupportedOperationException("Property " + getName() + " is read-only");
    }
}
