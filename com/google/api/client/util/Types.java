package com.google.api.client.util;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public class Types {
    private Types() {
    }

    private static Type a(Type type, Class<?> cls, int i4) {
        Type resolveTypeVariable;
        ParameterizedType superParameterizedType = getSuperParameterizedType(type, cls);
        if (superParameterizedType == null) {
            return null;
        }
        Type type2 = superParameterizedType.getActualTypeArguments()[i4];
        if ((type2 instanceof TypeVariable) && (resolveTypeVariable = resolveTypeVariable(Arrays.asList(type), (TypeVariable) type2)) != null) {
            return resolveTypeVariable;
        }
        return type2;
    }

    private static IllegalArgumentException b(Exception exc, Class<?> cls) {
        StringBuilder sb = new StringBuilder("unable to create new instance of class ");
        sb.append(cls.getName());
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        if (cls.isArray()) {
            arrayList.add("because it is an array");
        } else if (cls.isPrimitive()) {
            arrayList.add("because it is primitive");
        } else if (cls == Void.class) {
            arrayList.add("because it is void");
        } else {
            if (Modifier.isInterface(cls.getModifiers())) {
                arrayList.add("because it is an interface");
            } else if (Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add("because it is abstract");
            }
            if (cls.getEnclosingClass() != null && !Modifier.isStatic(cls.getModifiers())) {
                arrayList.add("because it is not static");
            }
            if (!Modifier.isPublic(cls.getModifiers())) {
                arrayList.add("possibly because it is not public");
            } else {
                try {
                    cls.getConstructor(new Class[0]);
                } catch (NoSuchMethodException unused) {
                    arrayList.add("because it has no accessible default constructor");
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z3) {
                sb.append(" and");
            } else {
                z3 = true;
            }
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(str);
        }
        return new IllegalArgumentException(sb.toString(), exc);
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type getBound(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length != 0) {
            return lowerBounds[0];
        }
        return wildcardType.getUpperBounds()[0];
    }

    public static Type getIterableParameter(Type type) {
        return a(type, Iterable.class, 0);
    }

    public static Type getMapValueParameter(Type type) {
        return a(type, Map.class, 1);
    }

    public static Class<?> getRawArrayComponentType(List<Type> list, Type type) {
        boolean z3;
        if (type instanceof TypeVariable) {
            type = resolveTypeVariable(list, (TypeVariable) type);
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawArrayComponentType(list, getArrayComponentType(type)), 0).getClass();
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawClass((ParameterizedType) type);
        }
        if (type == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "wildcard type is not supported: %s", type);
        return Object.class;
    }

    public static Class<?> getRawClass(ParameterizedType parameterizedType) {
        return (Class) parameterizedType.getRawType();
    }

    public static ParameterizedType getSuperParameterizedType(Type type, Class<?> cls) {
        Class<?> cls2;
        Type[] genericInterfaces;
        Class<?> rawClass;
        if ((type instanceof Class) || (type instanceof ParameterizedType)) {
            while (type != null && type != Object.class) {
                if (type instanceof Class) {
                    cls2 = (Class) type;
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Class<?> rawClass2 = getRawClass(parameterizedType);
                    if (rawClass2 == cls) {
                        return parameterizedType;
                    }
                    if (cls.isInterface()) {
                        for (Type type2 : rawClass2.getGenericInterfaces()) {
                            if (type2 instanceof Class) {
                                rawClass = (Class) type2;
                            } else {
                                rawClass = getRawClass((ParameterizedType) type2);
                            }
                            if (cls.isAssignableFrom(rawClass)) {
                                type = type2;
                                break;
                            }
                        }
                    }
                    cls2 = rawClass2;
                }
                type = cls2.getGenericSuperclass();
            }
            return null;
        }
        return null;
    }

    public static boolean isArray(Type type) {
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
            return false;
        }
        return true;
    }

    public static boolean isAssignableToOrFrom(Class<?> cls, Class<?> cls2) {
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return false;
        }
        return true;
    }

    public static <T> Iterable<T> iterableOf(final Object obj) {
        if (obj instanceof Iterable) {
            return (Iterable) obj;
        }
        Class<?> cls = obj.getClass();
        Preconditions.checkArgument(cls.isArray(), "not an array or Iterable: %s", cls);
        if (!cls.getComponentType().isPrimitive()) {
            return Arrays.asList((Object[]) obj);
        }
        return new Iterable<T>() { // from class: com.google.api.client.util.Types.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return new Iterator<T>() { // from class: com.google.api.client.util.Types.1.1

                    /* renamed from: a  reason: collision with root package name */
                    final int f26153a;

                    /* renamed from: b  reason: collision with root package name */
                    int f26154b = 0;

                    {
                        this.f26153a = Array.getLength(obj);
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        if (this.f26154b < this.f26153a) {
                            return true;
                        }
                        return false;
                    }

                    @Override // java.util.Iterator
                    public T next() {
                        if (hasNext()) {
                            Object obj2 = obj;
                            int i4 = this.f26154b;
                            this.f26154b = i4 + 1;
                            return (T) Array.get(obj2, i4);
                        }
                        throw new NoSuchElementException();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e4) {
            throw b(e4, cls);
        } catch (InstantiationException e5) {
            throw b(e5, cls);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.GenericDeclaration] */
    public static Type resolveTypeVariable(List<Type> list, TypeVariable<?> typeVariable) {
        Type resolveTypeVariable;
        ?? genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            Class cls = (Class) genericDeclaration;
            int size = list.size();
            ParameterizedType parameterizedType = null;
            while (parameterizedType == null) {
                size--;
                if (size < 0) {
                    break;
                }
                parameterizedType = getSuperParameterizedType(list.get(size), cls);
            }
            if (parameterizedType != null) {
                TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                int i4 = 0;
                while (i4 < typeParameters.length && !typeParameters[i4].equals(typeVariable)) {
                    i4++;
                }
                Type type = parameterizedType.getActualTypeArguments()[i4];
                if ((type instanceof TypeVariable) && (resolveTypeVariable = resolveTypeVariable(list, (TypeVariable) type)) != null) {
                    return resolveTypeVariable;
                }
                return type;
            }
        }
        return null;
    }

    public static Object toArray(Collection<?> collection, Class<?> cls) {
        if (cls.isPrimitive()) {
            Object newInstance = Array.newInstance(cls, collection.size());
            Iterator<?> it = collection.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                Array.set(newInstance, i4, it.next());
                i4++;
            }
            return newInstance;
        }
        return collection.toArray((Object[]) Array.newInstance(cls, collection.size()));
    }
}
