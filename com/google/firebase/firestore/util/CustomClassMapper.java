package com.google.firebase.firestore.util;

import android.net.Uri;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.PropertyName;
import com.google.firebase.firestore.ServerTimestamp;
import com.google.firebase.firestore.ThrowOnExtraProperties;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes5.dex */
public class CustomClassMapper {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<Class<?>, BeanMapper<?>> f31269a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class BeanMapper<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f31270a;

        /* renamed from: b  reason: collision with root package name */
        private final Constructor<T> f31271b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f31272c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f31273d;

        /* renamed from: e  reason: collision with root package name */
        private final Map<String, String> f31274e = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        private final Map<String, Method> f31276g = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        private final Map<String, Method> f31275f = new HashMap();

        /* renamed from: h  reason: collision with root package name */
        private final Map<String, Field> f31277h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        private final HashSet<String> f31278i = new HashSet<>();

        /* renamed from: j  reason: collision with root package name */
        private final HashSet<String> f31279j = new HashSet<>();

        BeanMapper(Class<T> cls) {
            Constructor<T> constructor;
            Method[] methods;
            Field[] fields;
            Method[] declaredMethods;
            Field[] declaredFields;
            this.f31270a = cls;
            this.f31272c = cls.isAnnotationPresent(ThrowOnExtraProperties.class);
            this.f31273d = !cls.isAnnotationPresent(IgnoreExtraProperties.class);
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                constructor = null;
            }
            this.f31271b = constructor;
            for (Method method : cls.getMethods()) {
                if (s(method)) {
                    String n4 = n(method);
                    c(n4);
                    method.setAccessible(true);
                    if (!this.f31275f.containsKey(n4)) {
                        this.f31275f.put(n4, method);
                        f(method);
                    } else {
                        throw new RuntimeException("Found conflicting getters for name " + method.getName() + " on class " + cls.getName());
                    }
                }
            }
            for (Field field : cls.getFields()) {
                if (r(field)) {
                    c(m(field));
                    e(field);
                }
            }
            Class<? super T> cls2 = cls;
            do {
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (t(method2)) {
                        String n5 = n(method2);
                        String str = this.f31274e.get(n5.toLowerCase(Locale.US));
                        if (str == null) {
                            continue;
                        } else if (str.equals(n5)) {
                            Method method3 = this.f31276g.get(n5);
                            if (method3 == null) {
                                method2.setAccessible(true);
                                this.f31276g.put(n5, method2);
                                g(method2);
                            } else if (!k(method2, method3)) {
                                if (cls2 == cls) {
                                    throw new RuntimeException("Class " + cls.getName() + " has multiple setter overloads with name " + method2.getName());
                                }
                                throw new RuntimeException("Found conflicting setters with name: " + method2.getName() + " (conflicts with " + method3.getName() + " defined on " + method3.getDeclaringClass().getName() + ")");
                            }
                        } else {
                            throw new RuntimeException("Found setter on " + cls2.getName() + " with invalid case-sensitive name: " + method2.getName());
                        }
                    }
                }
                for (Field field2 : cls2.getDeclaredFields()) {
                    String m4 = m(field2);
                    if (this.f31274e.containsKey(m4.toLowerCase(Locale.US)) && !this.f31277h.containsKey(m4)) {
                        field2.setAccessible(true);
                        this.f31277h.put(m4, field2);
                        e(field2);
                    }
                }
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    break;
                }
            } while (!cls2.equals(Object.class));
            if (!this.f31274e.isEmpty()) {
                Iterator<String> it = this.f31279j.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!this.f31276g.containsKey(next) && !this.f31277h.containsKey(next)) {
                        throw new RuntimeException("@DocumentId is annotated on property " + next + " of class " + cls.getName() + " but no field or public setter was found");
                    }
                }
                return;
            }
            throw new RuntimeException("No properties to serialize found on class " + cls.getName());
        }

        private void c(String str) {
            Map<String, String> map = this.f31274e;
            Locale locale = Locale.US;
            String put = map.put(str.toLowerCase(locale), str);
            if (put != null && !str.equals(put)) {
                throw new RuntimeException("Found two getters or fields with conflicting case sensitivity for property: " + str.toLowerCase(locale));
            }
        }

        private static String d(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(PropertyName.class)) {
                return ((PropertyName) accessibleObject.getAnnotation(PropertyName.class)).value();
            }
            return null;
        }

        private void e(Field field) {
            if (field.isAnnotationPresent(ServerTimestamp.class)) {
                Class<?> type = field.getType();
                if (type != Date.class && type != Timestamp.class) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is annotated with @ServerTimestamp but is " + type + " instead of Date or Timestamp.");
                }
                this.f31278i.add(m(field));
            }
            if (field.isAnnotationPresent(DocumentId.class)) {
                j("Field", TranslateLanguage.ICELANDIC, field.getType());
                this.f31279j.add(m(field));
            }
        }

        private void f(Method method) {
            if (method.isAnnotationPresent(ServerTimestamp.class)) {
                Class<?> returnType = method.getReturnType();
                if (returnType != Date.class && returnType != Timestamp.class) {
                    throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but returns " + returnType + " instead of Date or Timestamp.");
                }
                this.f31278i.add(n(method));
            }
            if (method.isAnnotationPresent(DocumentId.class)) {
                j("Method", "returns", method.getReturnType());
                this.f31279j.add(n(method));
            }
        }

        private void g(Method method) {
            if (!method.isAnnotationPresent(ServerTimestamp.class)) {
                if (method.isAnnotationPresent(DocumentId.class)) {
                    j("Method", "accepts", method.getParameterTypes()[0]);
                    this.f31279j.add(n(method));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but should not be. @ServerTimestamp can only be applied to fields and getters, not setters.");
        }

        private void j(String str, String str2, Type type) {
            if (type != String.class && type != DocumentReference.class) {
                throw new IllegalArgumentException(str + " is annotated with @DocumentId but " + str2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + type + " instead of String or DocumentReference.");
            }
        }

        private static boolean k(Method method, Method method2) {
            boolean z3;
            boolean z4;
            CustomClassMapper.x(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            CustomClassMapper.x(method.getReturnType().equals(Void.TYPE), "Expected void return type");
            CustomClassMapper.x(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            if (parameterTypes.length == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            CustomClassMapper.x(z3, "Expected exactly one parameter");
            if (parameterTypes2.length == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            CustomClassMapper.x(z4, "Expected exactly one parameter");
            if (!method.getName().equals(method2.getName()) || !parameterTypes[0].equals(parameterTypes2[0])) {
                return false;
            }
            return true;
        }

        private void l(Map<TypeVariable<Class<T>>, Type> map, DeserializeContext deserializeContext, T t3, HashSet<String> hashSet) {
            Iterator<String> it = this.f31279j.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!hashSet.contains(next)) {
                    ErrorPath a4 = deserializeContext.f31280a.a(next);
                    if (this.f31276g.containsKey(next)) {
                        Method method = this.f31276g.get(next);
                        Type[] genericParameterTypes = method.getGenericParameterTypes();
                        if (genericParameterTypes.length == 1) {
                            if (o(genericParameterTypes[0], map) == String.class) {
                                ApiUtil.a(method, t3, deserializeContext.f31281b.getId());
                            } else {
                                ApiUtil.a(method, t3, deserializeContext.f31281b);
                            }
                        } else {
                            throw CustomClassMapper.p(a4, "Setter does not have exactly one parameter");
                        }
                    } else {
                        Field field = this.f31277h.get(next);
                        try {
                            if (field.getType() == String.class) {
                                field.set(t3, deserializeContext.f31281b.getId());
                            } else {
                                field.set(t3, deserializeContext.f31281b);
                            }
                        } catch (IllegalAccessException e4) {
                            throw new RuntimeException(e4);
                        }
                    }
                } else {
                    throw new RuntimeException("'" + next + "' was found from document " + deserializeContext.f31281b.getPath() + ", cannot apply @DocumentId on this property for class " + this.f31270a.getName());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String m(Field field) {
            String d4 = d(field);
            if (d4 == null) {
                return field.getName();
            }
            return d4;
        }

        private static String n(Method method) {
            String d4 = d(method);
            if (d4 == null) {
                return q(method.getName());
            }
            return d4;
        }

        private Type o(Type type, Map<TypeVariable<Class<T>>, Type> map) {
            if (type instanceof TypeVariable) {
                Type type2 = map.get(type);
                if (type2 != null) {
                    return type2;
                }
                throw new IllegalStateException("Could not resolve type " + type);
            }
            return type;
        }

        private static String q(String str) {
            String[] strArr = {"get", "set", TranslateLanguage.ICELANDIC};
            String str2 = null;
            for (int i4 = 0; i4 < 3; i4++) {
                String str3 = strArr[i4];
                if (str.startsWith(str3)) {
                    str2 = str3;
                }
            }
            if (str2 != null) {
                char[] charArray = str.substring(str2.length()).toCharArray();
                for (int i5 = 0; i5 < charArray.length && Character.isUpperCase(charArray[i5]); i5++) {
                    charArray[i5] = Character.toLowerCase(charArray[i5]);
                }
                return new String(charArray);
            }
            throw new IllegalArgumentException("Unknown Bean prefix for method: " + str);
        }

        private static boolean r(Field field) {
            if (field.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(field.getModifiers()) || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || field.isAnnotationPresent(Exclude.class)) {
                return false;
            }
            return true;
        }

        private static boolean s(Method method) {
            if ((!method.getName().startsWith("get") && !method.getName().startsWith(TranslateLanguage.ICELANDIC)) || method.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.isAnnotationPresent(Exclude.class)) {
                return false;
            }
            return true;
        }

        private static boolean t(Method method) {
            if (!method.getName().startsWith("set") || method.getDeclaringClass().equals(Object.class) || Modifier.isStatic(method.getModifiers()) || !method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 1 || method.isAnnotationPresent(Exclude.class)) {
                return false;
            }
            return true;
        }

        T h(Map<String, Object> map, DeserializeContext deserializeContext) {
            return i(map, Collections.emptyMap(), deserializeContext);
        }

        T i(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2, DeserializeContext deserializeContext) {
            Constructor<T> constructor = this.f31271b;
            if (constructor != null) {
                T t3 = (T) ApiUtil.b(constructor);
                HashSet<String> hashSet = new HashSet<>();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    ErrorPath a4 = deserializeContext.f31280a.a(key);
                    if (this.f31276g.containsKey(key)) {
                        Method method = this.f31276g.get(key);
                        Type[] genericParameterTypes = method.getGenericParameterTypes();
                        if (genericParameterTypes.length == 1) {
                            ApiUtil.a(method, t3, CustomClassMapper.u(entry.getValue(), o(genericParameterTypes[0], map2), deserializeContext.a(a4)));
                            hashSet.add(key);
                        } else {
                            throw CustomClassMapper.p(a4, "Setter does not have exactly one parameter");
                        }
                    } else if (this.f31277h.containsKey(key)) {
                        Field field = this.f31277h.get(key);
                        try {
                            field.set(t3, CustomClassMapper.u(entry.getValue(), o(field.getGenericType(), map2), deserializeContext.a(a4)));
                            hashSet.add(key);
                        } catch (IllegalAccessException e4) {
                            throw new RuntimeException(e4);
                        }
                    } else {
                        String str = "No setter/field for " + key + " found on class " + this.f31270a.getName();
                        if (this.f31274e.containsKey(key.toLowerCase(Locale.US))) {
                            str = str + " (fields/setters are case sensitive!)";
                        }
                        if (!this.f31272c) {
                            if (this.f31273d) {
                                Logger.warn(CustomClassMapper.class.getSimpleName(), "%s", str);
                            }
                        } else {
                            throw new RuntimeException(str);
                        }
                    }
                }
                l(map2, deserializeContext, t3, hashSet);
                return t3;
            }
            throw CustomClassMapper.p(deserializeContext.f31280a, "Class " + this.f31270a.getName() + " does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped");
        }

        Map<String, Object> p(T t3, ErrorPath errorPath) {
            Object obj;
            Object A;
            if (this.f31270a.isAssignableFrom(t3.getClass())) {
                HashMap hashMap = new HashMap();
                for (String str : this.f31274e.values()) {
                    if (!this.f31279j.contains(str)) {
                        if (this.f31275f.containsKey(str)) {
                            obj = ApiUtil.a(this.f31275f.get(str), t3, new Object[0]);
                        } else {
                            Field field = this.f31277h.get(str);
                            if (field != null) {
                                try {
                                    obj = field.get(t3);
                                } catch (IllegalAccessException e4) {
                                    throw new RuntimeException(e4);
                                }
                            } else {
                                throw new IllegalStateException("Bean property without field or getter: " + str);
                            }
                        }
                        if (!this.f31278i.contains(str) || obj != null) {
                            A = CustomClassMapper.A(obj, errorPath.a(str));
                        } else {
                            A = FieldValue.serverTimestamp();
                        }
                        hashMap.put(str, A);
                    }
                }
                return hashMap;
            }
            throw new IllegalArgumentException("Can't serialize object of class " + t3.getClass() + " with BeanMapper for class " + this.f31270a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class DeserializeContext {

        /* renamed from: a  reason: collision with root package name */
        final ErrorPath f31280a;

        /* renamed from: b  reason: collision with root package name */
        final DocumentReference f31281b;

        DeserializeContext(ErrorPath errorPath, DocumentReference documentReference) {
            this.f31280a = errorPath;
            this.f31281b = documentReference;
        }

        DeserializeContext a(ErrorPath errorPath) {
            return new DeserializeContext(errorPath, this.f31281b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ErrorPath {

        /* renamed from: d  reason: collision with root package name */
        static final ErrorPath f31282d = new ErrorPath(null, null, 0);

        /* renamed from: a  reason: collision with root package name */
        private final int f31283a;

        /* renamed from: b  reason: collision with root package name */
        private final ErrorPath f31284b;

        /* renamed from: c  reason: collision with root package name */
        private final String f31285c;

        ErrorPath(ErrorPath errorPath, String str, int i4) {
            this.f31284b = errorPath;
            this.f31285c = str;
            this.f31283a = i4;
        }

        ErrorPath a(String str) {
            return new ErrorPath(this, str, this.f31283a + 1);
        }

        int b() {
            return this.f31283a;
        }

        public String toString() {
            int i4 = this.f31283a;
            if (i4 == 0) {
                return "";
            }
            if (i4 == 1) {
                return this.f31285c;
            }
            return this.f31284b.toString() + "." + this.f31285c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> Object A(T t3, ErrorPath errorPath) {
        if (errorPath.b() <= 500) {
            if (t3 == null) {
                return null;
            }
            if (t3 instanceof Number) {
                if (!(t3 instanceof Long) && !(t3 instanceof Integer) && !(t3 instanceof Double) && !(t3 instanceof Float)) {
                    throw B(errorPath, String.format("Numbers of type %s are not supported, please use an int, long, float or double", t3.getClass().getSimpleName()));
                }
                return t3;
            } else if (t3 instanceof String) {
                return t3;
            } else {
                if (t3 instanceof Boolean) {
                    return t3;
                }
                if (!(t3 instanceof Character)) {
                    if (t3 instanceof Map) {
                        HashMap hashMap = new HashMap();
                        for (Map.Entry entry : ((Map) t3).entrySet()) {
                            Object key = entry.getKey();
                            if (key instanceof String) {
                                String str = (String) key;
                                hashMap.put(str, A(entry.getValue(), errorPath.a(str)));
                            } else {
                                throw B(errorPath, "Maps with non-string keys are not supported");
                            }
                        }
                        return hashMap;
                    } else if (t3 instanceof Collection) {
                        if (t3 instanceof List) {
                            List list = (List) t3;
                            ArrayList arrayList = new ArrayList(list.size());
                            for (int i4 = 0; i4 < list.size(); i4++) {
                                Object obj = list.get(i4);
                                arrayList.add(A(obj, errorPath.a("[" + i4 + "]")));
                            }
                            return arrayList;
                        }
                        throw B(errorPath, "Serializing Collections is not supported, please use Lists instead");
                    } else if (!t3.getClass().isArray()) {
                        if (t3 instanceof Enum) {
                            String name = ((Enum) t3).name();
                            try {
                                return BeanMapper.m(t3.getClass().getField(name));
                            } catch (NoSuchFieldException unused) {
                                return name;
                            }
                        } else if (!(t3 instanceof Date) && !(t3 instanceof Timestamp) && !(t3 instanceof GeoPoint) && !(t3 instanceof Blob) && !(t3 instanceof DocumentReference) && !(t3 instanceof FieldValue)) {
                            if (!(t3 instanceof Uri) && !(t3 instanceof URI) && !(t3 instanceof URL)) {
                                return y(t3.getClass()).p(t3, errorPath);
                            }
                            return t3.toString();
                        } else {
                            return t3;
                        }
                    } else {
                        throw B(errorPath, "Serializing Arrays is not supported, please use Lists instead");
                    }
                }
                throw B(errorPath, "Characters are not supported, please use Strings");
            }
        }
        throw B(errorPath, "Exceeded maximum depth of 500, which likely indicates there's an object cycle");
    }

    private static IllegalArgumentException B(ErrorPath errorPath, String str) {
        String str2 = "Could not serialize object. " + str;
        if (errorPath.b() > 0) {
            str2 = str2 + " (found in field '" + errorPath.toString() + "')";
        }
        return new IllegalArgumentException(str2);
    }

    public static <T> T convertToCustomClass(Object obj, Class<T> cls, DocumentReference documentReference) {
        return (T) q(obj, cls, new DeserializeContext(ErrorPath.f31282d, documentReference));
    }

    public static Object convertToPlainJavaTypes(Object obj) {
        return z(obj);
    }

    private static <T> T e(Object obj, Class<T> cls, DeserializeContext deserializeContext) {
        BeanMapper y3 = y(cls);
        if (obj instanceof Map) {
            return (T) y3.h(v(obj, deserializeContext), deserializeContext);
        }
        ErrorPath errorPath = deserializeContext.f31280a;
        throw p(errorPath, "Can't convert object of type " + obj.getClass().getName() + " to type " + cls.getName());
    }

    private static Blob f(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Blob) {
            return (Blob) obj;
        }
        ErrorPath errorPath = deserializeContext.f31280a;
        throw p(errorPath, "Failed to convert value of type " + obj.getClass().getName() + " to Blob");
    }

    private static Boolean g(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        ErrorPath errorPath = deserializeContext.f31280a;
        throw p(errorPath, "Failed to convert value of type " + obj.getClass().getName() + " to boolean");
    }

    private static Date h(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Timestamp) {
            return ((Timestamp) obj).toDate();
        }
        ErrorPath errorPath = deserializeContext.f31280a;
        throw p(errorPath, "Failed to convert value of type " + obj.getClass().getName() + " to Date");
    }

    private static DocumentReference i(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof DocumentReference) {
            return (DocumentReference) obj;
        }
        ErrorPath errorPath = deserializeContext.f31280a;
        throw p(errorPath, "Failed to convert value of type " + obj.getClass().getName() + " to DocumentReference");
    }

    private static Double j(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (obj instanceof Long) {
            Long l4 = (Long) obj;
            Double valueOf = Double.valueOf(l4.doubleValue());
            if (valueOf.longValue() == l4.longValue()) {
                return valueOf;
            }
            ErrorPath errorPath = deserializeContext.f31280a;
            throw p(errorPath, "Loss of precision while converting number to double: " + obj + ". Did you mean to use a 64-bit long instead?");
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else {
            ErrorPath errorPath2 = deserializeContext.f31280a;
            throw p(errorPath2, "Failed to convert a value of type " + obj.getClass().getName() + " to double");
        }
    }

    private static GeoPoint k(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof GeoPoint) {
            return (GeoPoint) obj;
        }
        ErrorPath errorPath = deserializeContext.f31280a;
        throw p(errorPath, "Failed to convert value of type " + obj.getClass().getName() + " to GeoPoint");
    }

    private static Integer l(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (!(obj instanceof Long) && !(obj instanceof Double)) {
            ErrorPath errorPath = deserializeContext.f31280a;
            throw p(errorPath, "Failed to convert a value of type " + obj.getClass().getName() + " to int");
        }
        Number number = (Number) obj;
        double doubleValue = number.doubleValue();
        if (doubleValue >= -2.147483648E9d && doubleValue <= 2.147483647E9d) {
            return Integer.valueOf(number.intValue());
        }
        ErrorPath errorPath2 = deserializeContext.f31280a;
        throw p(errorPath2, "Numeric value out of 32-bit integer range: " + doubleValue + ". Did you mean to use a long or double instead of an int?");
    }

    private static Long m(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Double) {
            Double d4 = (Double) obj;
            if (d4.doubleValue() >= -9.223372036854776E18d && d4.doubleValue() <= 9.223372036854776E18d) {
                return Long.valueOf(d4.longValue());
            }
            ErrorPath errorPath = deserializeContext.f31280a;
            throw p(errorPath, "Numeric value out of 64-bit long range: " + d4 + ". Did you mean to use a double instead of a long?");
        }
        ErrorPath errorPath2 = deserializeContext.f31280a;
        throw p(errorPath2, "Failed to convert a value of type " + obj.getClass().getName() + " to long");
    }

    private static String n(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof String) {
            return (String) obj;
        }
        ErrorPath errorPath = deserializeContext.f31280a;
        throw p(errorPath, "Failed to convert value of type " + obj.getClass().getName() + " to String");
    }

    private static Timestamp o(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp((Date) obj);
        }
        ErrorPath errorPath = deserializeContext.f31280a;
        throw p(errorPath, "Failed to convert value of type " + obj.getClass().getName() + " to Timestamp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RuntimeException p(ErrorPath errorPath, String str) {
        String str2 = "Could not deserialize object. " + str;
        if (errorPath.b() > 0) {
            str2 = str2 + " (found in field '" + errorPath.toString() + "')";
        }
        return new RuntimeException(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T q(Object obj, Class<T> cls, DeserializeContext deserializeContext) {
        if (obj == 0) {
            return null;
        }
        if (!cls.isPrimitive() && !Number.class.isAssignableFrom(cls) && !Boolean.class.isAssignableFrom(cls) && !Character.class.isAssignableFrom(cls)) {
            if (String.class.isAssignableFrom(cls)) {
                return (T) n(obj, deserializeContext);
            }
            if (Date.class.isAssignableFrom(cls)) {
                return (T) h(obj, deserializeContext);
            }
            if (Timestamp.class.isAssignableFrom(cls)) {
                return (T) o(obj, deserializeContext);
            }
            if (Blob.class.isAssignableFrom(cls)) {
                return (T) f(obj, deserializeContext);
            }
            if (GeoPoint.class.isAssignableFrom(cls)) {
                return (T) k(obj, deserializeContext);
            }
            if (DocumentReference.class.isAssignableFrom(cls)) {
                return (T) i(obj, deserializeContext);
            }
            if (!cls.isArray()) {
                if (cls.getTypeParameters().length <= 0) {
                    if (cls.equals(Object.class)) {
                        return obj;
                    }
                    if (cls.isEnum()) {
                        return (T) r(obj, cls, deserializeContext);
                    }
                    return (T) e(obj, cls, deserializeContext);
                }
                ErrorPath errorPath = deserializeContext.f31280a;
                throw p(errorPath, "Class " + cls.getName() + " has generic type parameters");
            }
            throw p(deserializeContext.f31280a, "Converting to Arrays is not supported, please use Lists instead");
        }
        return (T) t(obj, cls, deserializeContext);
    }

    private static <T> T r(Object obj, Class<T> cls, DeserializeContext deserializeContext) {
        Field[] fields;
        if (obj instanceof String) {
            String str = (String) obj;
            for (Field field : cls.getFields()) {
                if (field.isEnumConstant() && str.equals(BeanMapper.m(field))) {
                    str = field.getName();
                    break;
                }
            }
            try {
                return (T) Enum.valueOf(cls, str);
            } catch (IllegalArgumentException unused) {
                throw p(deserializeContext.f31280a, "Could not find enum value of " + cls.getName() + " for value \"" + str + "\"");
            }
        }
        throw p(deserializeContext.f31280a, "Expected a String while deserializing to enum " + cls + " but got a " + obj.getClass());
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.List, T, java.util.ArrayList] */
    private static <T> T s(Object obj, ParameterizedType parameterizedType, DeserializeContext deserializeContext) {
        Class cls = (Class) parameterizedType.getRawType();
        int i4 = 0;
        if (List.class.isAssignableFrom(cls)) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                ?? r02 = (T) new ArrayList(list.size());
                while (i4 < list.size()) {
                    Object obj2 = list.get(i4);
                    ErrorPath errorPath = deserializeContext.f31280a;
                    r02.add(u(obj2, type, deserializeContext.a(errorPath.a("[" + i4 + "]"))));
                    i4++;
                }
                return r02;
            }
            ErrorPath errorPath2 = deserializeContext.f31280a;
            throw p(errorPath2, "Expected a List, but got a " + obj.getClass());
        } else if (Map.class.isAssignableFrom(cls)) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (type2.equals(String.class)) {
                Map<String, Object> v3 = v(obj, deserializeContext);
                ?? r03 = (T) new HashMap();
                for (Map.Entry<String, Object> entry : v3.entrySet()) {
                    r03.put(entry.getKey(), u(entry.getValue(), type3, deserializeContext.a(deserializeContext.f31280a.a(entry.getKey()))));
                }
                return r03;
            }
            ErrorPath errorPath3 = deserializeContext.f31280a;
            throw p(errorPath3, "Only Maps with string keys are supported, but found Map with key type " + type2);
        } else if (!Collection.class.isAssignableFrom(cls)) {
            Map<String, Object> v4 = v(obj, deserializeContext);
            BeanMapper y3 = y(cls);
            HashMap hashMap = new HashMap();
            TypeVariable<Class<T>>[] typeParameters = y3.f31270a.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length == typeParameters.length) {
                while (i4 < typeParameters.length) {
                    hashMap.put(typeParameters[i4], actualTypeArguments[i4]);
                    i4++;
                }
                return (T) y3.i(v4, hashMap, deserializeContext);
            }
            throw new IllegalStateException("Mismatched lengths for type variables and actual types");
        } else {
            throw p(deserializeContext.f31280a, "Collections are not supported, please use Lists instead");
        }
    }

    private static <T> T t(Object obj, Class<T> cls, DeserializeContext deserializeContext) {
        if (!Integer.class.isAssignableFrom(cls) && !Integer.TYPE.isAssignableFrom(cls)) {
            if (!Boolean.class.isAssignableFrom(cls) && !Boolean.TYPE.isAssignableFrom(cls)) {
                if (!Double.class.isAssignableFrom(cls) && !Double.TYPE.isAssignableFrom(cls)) {
                    if (!Long.class.isAssignableFrom(cls) && !Long.TYPE.isAssignableFrom(cls)) {
                        if (!Float.class.isAssignableFrom(cls) && !Float.TYPE.isAssignableFrom(cls)) {
                            throw p(deserializeContext.f31280a, String.format("Deserializing values to %s is not supported", cls.getSimpleName()));
                        }
                        return (T) Float.valueOf(j(obj, deserializeContext).floatValue());
                    }
                    return (T) m(obj, deserializeContext);
                }
                return (T) j(obj, deserializeContext);
            }
            return (T) g(obj, deserializeContext);
        }
        return (T) l(obj, deserializeContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T u(Object obj, Type type, DeserializeContext deserializeContext) {
        if (obj == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return (T) s(obj, (ParameterizedType) type, deserializeContext);
        }
        if (type instanceof Class) {
            return (T) q(obj, (Class) type, deserializeContext);
        }
        boolean z3 = true;
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length <= 0) {
                Type[] upperBounds = wildcardType.getUpperBounds();
                if (upperBounds.length <= 0) {
                    z3 = false;
                }
                x(z3, "Unexpected type bounds on wildcard " + type);
                return (T) u(obj, upperBounds[0], deserializeContext);
            }
            throw p(deserializeContext.f31280a, "Generic lower-bounded wildcard types are not supported");
        } else if (type instanceof TypeVariable) {
            Type[] bounds = ((TypeVariable) type).getBounds();
            if (bounds.length <= 0) {
                z3 = false;
            }
            x(z3, "Unexpected type bounds on type variable " + type);
            return (T) u(obj, bounds[0], deserializeContext);
        } else if (type instanceof GenericArrayType) {
            throw p(deserializeContext.f31280a, "Generic Arrays are not supported, please use Lists instead");
        } else {
            ErrorPath errorPath = deserializeContext.f31280a;
            throw p(errorPath, "Unknown type encountered: " + type);
        }
    }

    private static Map<String, Object> v(Object obj, DeserializeContext deserializeContext) {
        if (obj instanceof Map) {
            return (Map) obj;
        }
        ErrorPath errorPath = deserializeContext.f31280a;
        throw p(errorPath, "Expected a Map while deserializing, but got a " + obj.getClass());
    }

    private static void w(boolean z3) {
        x(z3, "Internal inconsistency");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(boolean z3, String str) {
        if (z3) {
            return;
        }
        throw new RuntimeException("Hard assert failed: " + str);
    }

    private static <T> BeanMapper<T> y(Class<T> cls) {
        ConcurrentMap<Class<?>, BeanMapper<?>> concurrentMap = f31269a;
        BeanMapper<?> beanMapper = concurrentMap.get(cls);
        if (beanMapper == null) {
            BeanMapper<T> beanMapper2 = new BeanMapper<>(cls);
            concurrentMap.put(cls, beanMapper2);
            return beanMapper2;
        }
        return beanMapper;
    }

    private static <T> Object z(T t3) {
        return A(t3, ErrorPath.f31282d);
    }

    public static Map<String, Object> convertToPlainJavaTypes(Map<?, Object> map) {
        Object z3 = z(map);
        w(z3 instanceof Map);
        return (Map) z3;
    }
}
