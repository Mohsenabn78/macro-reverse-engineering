package com.google.api.client.util;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class Data {
    public static final BigDecimal NULL_BIG_DECIMAL;
    public static final BigInteger NULL_BIG_INTEGER;
    public static final Boolean NULL_BOOLEAN;
    public static final Byte NULL_BYTE;
    public static final Character NULL_CHARACTER;
    public static final DateTime NULL_DATE_TIME;
    public static final Double NULL_DOUBLE;
    public static final Float NULL_FLOAT;
    public static final Integer NULL_INTEGER;
    public static final Long NULL_LONG;
    public static final Short NULL_SHORT;
    public static final String NULL_STRING;

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<Class<?>, Object> f26085a;

    static {
        Boolean bool = new Boolean(true);
        NULL_BOOLEAN = bool;
        String str = new String();
        NULL_STRING = str;
        Character ch = new Character((char) 0);
        NULL_CHARACTER = ch;
        Byte b4 = new Byte((byte) 0);
        NULL_BYTE = b4;
        Short sh = new Short((short) 0);
        NULL_SHORT = sh;
        Integer num = new Integer(0);
        NULL_INTEGER = num;
        Float f4 = new Float(0.0f);
        NULL_FLOAT = f4;
        Long l4 = new Long(0L);
        NULL_LONG = l4;
        Double d4 = new Double((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        NULL_DOUBLE = d4;
        BigInteger bigInteger = new BigInteger("0");
        NULL_BIG_INTEGER = bigInteger;
        BigDecimal bigDecimal = new BigDecimal("0");
        NULL_BIG_DECIMAL = bigDecimal;
        DateTime dateTime = new DateTime(0L);
        NULL_DATE_TIME = dateTime;
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = new ConcurrentHashMap<>();
        f26085a = concurrentHashMap;
        concurrentHashMap.put(Boolean.class, bool);
        concurrentHashMap.put(String.class, str);
        concurrentHashMap.put(Character.class, ch);
        concurrentHashMap.put(Byte.class, b4);
        concurrentHashMap.put(Short.class, sh);
        concurrentHashMap.put(Integer.class, num);
        concurrentHashMap.put(Float.class, f4);
        concurrentHashMap.put(Long.class, l4);
        concurrentHashMap.put(Double.class, d4);
        concurrentHashMap.put(BigInteger.class, bigInteger);
        concurrentHashMap.put(BigDecimal.class, bigDecimal);
        concurrentHashMap.put(DateTime.class, dateTime);
    }

    public static <T> T clone(T t3) {
        T t4;
        if (t3 != null && !isPrimitive(t3.getClass())) {
            if (t3 instanceof GenericData) {
                return (T) ((GenericData) t3).clone();
            }
            Class<?> cls = t3.getClass();
            if (cls.isArray()) {
                t4 = (T) Array.newInstance(cls.getComponentType(), Array.getLength(t3));
            } else if (t3 instanceof ArrayMap) {
                t4 = (T) ((ArrayMap) t3).clone();
            } else if ("java.util.Arrays$ArrayList".equals(cls.getName())) {
                Object[] array = ((List) t3).toArray();
                deepCopy(array, array);
                return (T) Arrays.asList(array);
            } else {
                t4 = (T) Types.newInstance(cls);
            }
            deepCopy(t3, t4);
            return t4;
        }
        return t3;
    }

    public static void deepCopy(Object obj, Object obj2) {
        boolean z3;
        ClassInfo of;
        Class<?> cls = obj.getClass();
        boolean z4 = true;
        int i4 = 0;
        if (cls == obj2.getClass()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (cls.isArray()) {
            if (Array.getLength(obj) != Array.getLength(obj2)) {
                z4 = false;
            }
            Preconditions.checkArgument(z4);
            for (Object obj3 : Types.iterableOf(obj)) {
                Array.set(obj2, i4, clone(obj3));
                i4++;
            }
        } else if (Collection.class.isAssignableFrom(cls)) {
            Collection<Object> collection = (Collection) obj;
            if (ArrayList.class.isAssignableFrom(cls)) {
                ((ArrayList) obj2).ensureCapacity(collection.size());
            }
            Collection collection2 = (Collection) obj2;
            for (Object obj4 : collection) {
                collection2.add(clone(obj4));
            }
        } else {
            boolean isAssignableFrom = GenericData.class.isAssignableFrom(cls);
            if (!isAssignableFrom && Map.class.isAssignableFrom(cls)) {
                if (ArrayMap.class.isAssignableFrom(cls)) {
                    ArrayMap arrayMap = (ArrayMap) obj2;
                    ArrayMap arrayMap2 = (ArrayMap) obj;
                    int size = arrayMap2.size();
                    while (i4 < size) {
                        arrayMap.set(i4, clone(arrayMap2.getValue(i4)));
                        i4++;
                    }
                    return;
                }
                Map map = (Map) obj2;
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    map.put(entry.getKey(), clone(entry.getValue()));
                }
                return;
            }
            if (isAssignableFrom) {
                of = ((GenericData) obj).f26120b;
            } else {
                of = ClassInfo.of(cls);
            }
            for (String str : of.f26083d) {
                FieldInfo fieldInfo = of.getFieldInfo(str);
                if (!fieldInfo.isFinal() && (!isAssignableFrom || !fieldInfo.isPrimitive())) {
                    Object value = fieldInfo.getValue(obj);
                    if (value != null) {
                        fieldInfo.setValue(obj2, clone(value));
                    }
                }
            }
        }
    }

    public static boolean isNull(Object obj) {
        if (obj != null && obj == f26085a.get(obj.getClass())) {
            return true;
        }
        return false;
    }

    public static boolean isPrimitive(Type type) {
        if (type instanceof WildcardType) {
            type = Types.getBound((WildcardType) type);
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Class cls = (Class) type;
        if (!cls.isPrimitive() && cls != Character.class && cls != String.class && cls != Integer.class && cls != Long.class && cls != Short.class && cls != Byte.class && cls != Float.class && cls != Double.class && cls != BigInteger.class && cls != BigDecimal.class && cls != DateTime.class && cls != Boolean.class) {
            return false;
        }
        return true;
    }

    public static boolean isValueOfPrimitiveType(Object obj) {
        if (obj != null && !isPrimitive(obj.getClass())) {
            return false;
        }
        return true;
    }

    public static Map<String, Object> mapOf(Object obj) {
        if (obj != null && !isNull(obj)) {
            if (obj instanceof Map) {
                return (Map) obj;
            }
            return new DataMap(obj, false);
        }
        return Collections.emptyMap();
    }

    public static Collection<Object> newCollectionInstance(Type type) {
        Class cls;
        if (type instanceof WildcardType) {
            type = Types.getBound((WildcardType) type);
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        if (type instanceof Class) {
            cls = (Class) type;
        } else {
            cls = null;
        }
        if (type != null && !(type instanceof GenericArrayType) && (cls == null || (!cls.isArray() && !cls.isAssignableFrom(ArrayList.class)))) {
            if (cls != null) {
                if (cls.isAssignableFrom(HashSet.class)) {
                    return new HashSet();
                }
                if (cls.isAssignableFrom(TreeSet.class)) {
                    return new TreeSet();
                }
                return (Collection) Types.newInstance(cls);
            }
            String valueOf = String.valueOf(type);
            StringBuilder sb = new StringBuilder(valueOf.length() + 39);
            sb.append("unable to create new instance of type: ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        }
        return new ArrayList();
    }

    public static Map<String, Object> newMapInstance(Class<?> cls) {
        if (cls != null && !cls.isAssignableFrom(ArrayMap.class)) {
            if (cls.isAssignableFrom(TreeMap.class)) {
                return new TreeMap();
            }
            return (Map) Types.newInstance(cls);
        }
        return ArrayMap.create();
    }

    public static <T> T nullOf(Class<?> cls) {
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = f26085a;
        T t3 = (T) concurrentHashMap.get(cls);
        if (t3 == null) {
            synchronized (concurrentHashMap) {
                t3 = concurrentHashMap.get(cls);
                if (t3 == null) {
                    int i4 = 0;
                    if (cls.isArray()) {
                        Class<?> cls2 = cls;
                        do {
                            cls2 = cls2.getComponentType();
                            i4++;
                        } while (cls2.isArray());
                        t3 = (T) Array.newInstance(cls2, new int[i4]);
                    } else if (cls.isEnum()) {
                        FieldInfo fieldInfo = ClassInfo.of(cls).getFieldInfo(null);
                        Preconditions.checkNotNull(fieldInfo, "enum missing constant with @NullValue annotation: %s", cls);
                        t3 = fieldInfo.enumValue();
                    } else {
                        t3 = Types.newInstance(cls);
                    }
                    f26085a.put(cls, t3);
                }
            }
        }
        return t3;
    }

    public static Object parsePrimitiveValue(Type type, String str) {
        Class cls;
        if (type instanceof Class) {
            cls = (Class) type;
        } else {
            cls = null;
        }
        if (type == null || cls != null) {
            if (cls == Void.class) {
                return null;
            }
            if (str != null && cls != null && !cls.isAssignableFrom(String.class)) {
                if (cls != Character.class && cls != Character.TYPE) {
                    if (cls != Boolean.class && cls != Boolean.TYPE) {
                        if (cls != Byte.class && cls != Byte.TYPE) {
                            if (cls != Short.class && cls != Short.TYPE) {
                                if (cls != Integer.class && cls != Integer.TYPE) {
                                    if (cls != Long.class && cls != Long.TYPE) {
                                        if (cls != Float.class && cls != Float.TYPE) {
                                            if (cls != Double.class && cls != Double.TYPE) {
                                                if (cls == DateTime.class) {
                                                    return DateTime.parseRfc3339(str);
                                                }
                                                if (cls == BigInteger.class) {
                                                    return new BigInteger(str);
                                                }
                                                if (cls == BigDecimal.class) {
                                                    return new BigDecimal(str);
                                                }
                                                if (cls.isEnum()) {
                                                    return ClassInfo.of(cls).getFieldInfo(str).enumValue();
                                                }
                                            } else {
                                                return Double.valueOf(str);
                                            }
                                        } else {
                                            return Float.valueOf(str);
                                        }
                                    } else {
                                        return Long.valueOf(str);
                                    }
                                } else {
                                    return Integer.valueOf(str);
                                }
                            } else {
                                return Short.valueOf(str);
                            }
                        } else {
                            return Byte.valueOf(str);
                        }
                    } else {
                        return Boolean.valueOf(str);
                    }
                } else if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                } else {
                    String valueOf = String.valueOf(cls);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 37);
                    sb.append("expected type Character/char but got ");
                    sb.append(valueOf);
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                return str;
            }
        }
        String valueOf2 = String.valueOf(type);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 35);
        sb2.append("expected primitive class, but got: ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static Type resolveWildcardTypeOrTypeVariable(List<Type> list, Type type) {
        if (type instanceof WildcardType) {
            type = Types.getBound((WildcardType) type);
        }
        while (type instanceof TypeVariable) {
            Type resolveTypeVariable = Types.resolveTypeVariable(list, (TypeVariable) type);
            if (resolveTypeVariable != null) {
                type = resolveTypeVariable;
            }
            if (type instanceof TypeVariable) {
                type = ((TypeVariable) type).getBounds()[0];
            }
        }
        return type;
    }
}
