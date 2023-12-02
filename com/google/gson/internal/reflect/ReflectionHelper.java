package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class ReflectionHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final RecordHelper f32770a;

    /* loaded from: classes5.dex */
    private static abstract class RecordHelper {
        private RecordHelper() {
        }

        public abstract Method a(Class<?> cls, Field field);

        abstract <T> Constructor<T> b(Class<T> cls);

        abstract String[] c(Class<?> cls);

        abstract boolean d(Class<?> cls);
    }

    /* loaded from: classes5.dex */
    private static class RecordNotSupportedHelper extends RecordHelper {
        private RecordNotSupportedHelper() {
            super();
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method a(Class<?> cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        <T> Constructor<T> b(Class<T> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        String[] c(Class<?> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        boolean d(Class<?> cls) {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    private static class RecordSupportedHelper extends RecordHelper {

        /* renamed from: a  reason: collision with root package name */
        private final Method f32771a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f32772b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f32773c;

        /* renamed from: d  reason: collision with root package name */
        private final Method f32774d;

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method a(Class<?> cls, Field field) {
            try {
                return cls.getMethod(field.getName(), new Class[0]);
            } catch (ReflectiveOperationException e4) {
                throw ReflectionHelper.c(e4);
            }
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public <T> Constructor<T> b(Class<T> cls) {
            try {
                Object[] objArr = (Object[]) this.f32772b.invoke(cls, new Object[0]);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    clsArr[i4] = (Class) this.f32774d.invoke(objArr[i4], new Object[0]);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e4) {
                throw ReflectionHelper.c(e4);
            }
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        String[] c(Class<?> cls) {
            try {
                Object[] objArr = (Object[]) this.f32772b.invoke(cls, new Object[0]);
                String[] strArr = new String[objArr.length];
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    strArr[i4] = (String) this.f32773c.invoke(objArr[i4], new Object[0]);
                }
                return strArr;
            } catch (ReflectiveOperationException e4) {
                throw ReflectionHelper.c(e4);
            }
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        boolean d(Class<?> cls) {
            try {
                return ((Boolean) this.f32771a.invoke(cls, new Object[0])).booleanValue();
            } catch (ReflectiveOperationException e4) {
                throw ReflectionHelper.c(e4);
            }
        }

        private RecordSupportedHelper() throws NoSuchMethodException {
            super();
            this.f32771a = Class.class.getMethod("isRecord", new Class[0]);
            Method method = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.f32772b = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.f32773c = componentType.getMethod("getName", new Class[0]);
            this.f32774d = componentType.getMethod("getType", new Class[0]);
        }
    }

    static {
        RecordHelper recordNotSupportedHelper;
        try {
            recordNotSupportedHelper = new RecordSupportedHelper();
        } catch (NoSuchMethodException unused) {
            recordNotSupportedHelper = new RecordNotSupportedHelper();
        }
        f32770a = recordNotSupportedHelper;
    }

    private ReflectionHelper() {
    }

    private static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        Class<?>[] parameterTypes;
        sb.append('(');
        if (accessibleObject instanceof Method) {
            parameterTypes = ((Method) accessibleObject).getParameterTypes();
        } else {
            parameterTypes = ((Constructor) accessibleObject).getParameterTypes();
        }
        for (int i4 = 0; i4 < parameterTypes.length; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i4].getSimpleName());
        }
        sb.append(')');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RuntimeException c(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static String constructorToString(Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb);
        return sb.toString();
    }

    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String fieldToString(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String getAccessibleObjectDescription(AccessibleObject accessibleObject, boolean z3) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + fieldToString((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            b(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + constructorToString((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (z3 && Character.isLowerCase(str.charAt(0))) {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return str;
    }

    public static Method getAccessor(Class<?> cls, Field field) {
        return f32770a.a(cls, field);
    }

    public static <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls) {
        return f32770a.b(cls);
    }

    public static String[] getRecordComponentNames(Class<?> cls) {
        return f32770a.c(cls);
    }

    public static boolean isRecord(Class<?> cls) {
        return f32770a.d(cls);
    }

    public static void makeAccessible(AccessibleObject accessibleObject) throws JsonIOException {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e4) {
            String accessibleObjectDescription = getAccessibleObjectDescription(accessibleObject, false);
            throw new JsonIOException("Failed making " + accessibleObjectDescription + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e4);
        }
    }

    public static String tryMakeAccessible(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e4) {
            return "Failed making constructor '" + constructorToString(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e4.getMessage();
        }
    }
}
