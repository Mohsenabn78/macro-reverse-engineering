package com.android.dx.stock;

import com.android.dx.Code;
import com.android.dx.Comparison;
import com.android.dx.DexMaker;
import com.android.dx.Label;
import com.android.dx.Local;
import com.android.dx.MethodId;
import com.android.dx.TypeId;
import com.android.dx.rop.code.RegisterSpec;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import net.bytebuddy.pool.TypePool;

/* loaded from: classes2.dex */
public final class ProxyBuilder<T> {
    private static final String FIELD_NAME_HANDLER = "$__handler";
    private static final String FIELD_NAME_METHODS = "$__methodArray";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_BOXED;
    private static final Map<Class<?>, MethodId<?, ?>> PRIMITIVE_TO_UNBOX_METHOD;
    private static final Map<TypeId<?>, MethodId<?, ?>> PRIMITIVE_TYPE_TO_UNBOX_METHOD;
    public static final int VERSION = 1;
    private static final Map<Class<?>, Class<?>> generatedProxyClasses = Collections.synchronizedMap(new HashMap());
    private final Class<T> baseClass;
    private File dexCache;
    private InvocationHandler handler;
    private Method[] methods;
    private boolean sharedClassLoader;
    private ClassLoader parentClassLoader = ProxyBuilder.class.getClassLoader();
    private Class<?>[] constructorArgTypes = new Class[0];
    private Object[] constructorArgValues = new Object[0];
    private Set<Class<?>> interfaces = new HashSet();

    /* loaded from: classes2.dex */
    public static class MethodSetEntry {
        public final String name;
        public final Method originalMethod;
        public final Class<?>[] paramTypes;
        public final Class<?> returnType;

        public MethodSetEntry(Method method) {
            this.originalMethod = method;
            this.name = method.getName();
            this.paramTypes = method.getParameterTypes();
            this.returnType = method.getReturnType();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MethodSetEntry)) {
                return false;
            }
            MethodSetEntry methodSetEntry = (MethodSetEntry) obj;
            if (!this.name.equals(methodSetEntry.name) || !this.returnType.equals(methodSetEntry.returnType) || !Arrays.equals(this.paramTypes, methodSetEntry.paramTypes)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = 527 + this.name.hashCode() + 17;
            int hashCode2 = hashCode + (hashCode * 31) + this.returnType.hashCode();
            return hashCode2 + (hashCode2 * 31) + Arrays.hashCode(this.paramTypes);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        PRIMITIVE_TO_BOXED = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Character.TYPE, Character.class);
        PRIMITIVE_TYPE_TO_UNBOX_METHOD = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            TypeId<?> typeId = TypeId.get((Class) entry.getKey());
            TypeId typeId2 = TypeId.get((Class) entry.getValue());
            PRIMITIVE_TYPE_TO_UNBOX_METHOD.put(typeId, typeId2.getMethod(typeId2, "valueOf", typeId));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Boolean.TYPE, TypeId.get(Boolean.class).getMethod(TypeId.BOOLEAN, "booleanValue", new TypeId[0]));
        hashMap2.put(Integer.TYPE, TypeId.get(Integer.class).getMethod(TypeId.INT, "intValue", new TypeId[0]));
        hashMap2.put(Byte.TYPE, TypeId.get(Byte.class).getMethod(TypeId.BYTE, "byteValue", new TypeId[0]));
        hashMap2.put(Long.TYPE, TypeId.get(Long.class).getMethod(TypeId.LONG, "longValue", new TypeId[0]));
        hashMap2.put(Short.TYPE, TypeId.get(Short.class).getMethod(TypeId.SHORT, "shortValue", new TypeId[0]));
        hashMap2.put(Float.TYPE, TypeId.get(Float.class).getMethod(TypeId.FLOAT, "floatValue", new TypeId[0]));
        hashMap2.put(Double.TYPE, TypeId.get(Double.class).getMethod(TypeId.DOUBLE, "doubleValue", new TypeId[0]));
        hashMap2.put(Character.TYPE, TypeId.get(Character.class).getMethod(TypeId.CHAR, "charValue", new TypeId[0]));
        PRIMITIVE_TO_UNBOX_METHOD = hashMap2;
    }

    private ProxyBuilder(Class<T> cls) {
        this.baseClass = cls;
    }

    private static <T> Set<T> asSet(T... tArr) {
        return new CopyOnWriteArraySet(Arrays.asList(tArr));
    }

    private static Local<?> boxIfRequired(Code code, Local<?> local, Local<Object> local2) {
        MethodId<?, ?> methodId = PRIMITIVE_TYPE_TO_UNBOX_METHOD.get(local.getType());
        if (methodId == null) {
            return local;
        }
        code.invokeStatic(methodId, local2, local);
        return local2;
    }

    public static Object callSuper(Object obj, Method method, Object... objArr) throws Throwable {
        try {
            return obj.getClass().getMethod(superMethodName(method), method.getParameterTypes()).invoke(obj, objArr);
        } catch (InvocationTargetException e4) {
            throw e4.getCause();
        }
    }

    private static void check(boolean z3, String str) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    private static TypeId<?>[] classArrayToTypeArray(Class<?>[] clsArr) {
        TypeId<?>[] typeIdArr = new TypeId[clsArr.length];
        for (int i4 = 0; i4 < clsArr.length; i4++) {
            typeIdArr[i4] = TypeId.get(clsArr[i4]);
        }
        return typeIdArr;
    }

    public static <T> ProxyBuilder<T> forClass(Class<T> cls) {
        return new ProxyBuilder<>(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.dx.DexMaker] */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.android.dx.TypeId<G extends T>, com.android.dx.TypeId] */
    private static <T, G extends T> void generateCodeForAllMethods(DexMaker dexMaker, TypeId<G> typeId, Method[] methodArr, TypeId<T> typeId2) {
        Local local;
        MethodId methodId;
        DexMaker dexMaker2 = dexMaker;
        TypeId<T> typeId3 = typeId;
        Method[] methodArr2 = methodArr;
        TypeId typeId4 = TypeId.get(InvocationHandler.class);
        TypeId typeId5 = TypeId.get(Method[].class);
        Object field = typeId3.getField(typeId4, FIELD_NAME_HANDLER);
        Object field2 = typeId3.getField(typeId5, FIELD_NAME_METHODS);
        TypeId<?> typeId6 = TypeId.get(Method.class);
        TypeId<?> typeId7 = TypeId.get(Object[].class);
        TypeId<?> typeId8 = TypeId.OBJECT;
        MethodId method = typeId4.getMethod(typeId8, "invoke", typeId8, typeId6, typeId7);
        int i4 = 0;
        TypeId typeId9 = typeId4;
        TypeId typeId10 = typeId5;
        while (i4 < methodArr2.length) {
            Method method2 = methodArr2[i4];
            String name = method2.getName();
            Class<?>[] parameterTypes = method2.getParameterTypes();
            int length = parameterTypes.length;
            TypeId<?>[] typeIdArr = new TypeId[length];
            for (int i5 = 0; i5 < length; i5++) {
                typeIdArr[i5] = TypeId.get(parameterTypes[i5]);
            }
            Class<?> returnType = method2.getReturnType();
            TypeId typeId11 = TypeId.get(returnType);
            Object obj = field;
            MethodId methodId2 = method;
            MethodId method3 = typeId2.getMethod(typeId11, name, typeIdArr);
            Code declare = dexMaker2.declare(typeId3.getMethod(typeId11, name, typeIdArr), 1);
            Local<T> local2 = declare.getThis(typeId3);
            Local<T> newLocal = declare.newLocal(typeId9);
            TypeId<Object> typeId12 = TypeId.OBJECT;
            Local<T> newLocal2 = declare.newLocal(typeId12);
            TypeId<Integer> typeId13 = TypeId.INT;
            Local newLocal3 = declare.newLocal(typeId13);
            Local newLocal4 = declare.newLocal(typeId7);
            TypeId<?> typeId14 = typeId7;
            Local newLocal5 = declare.newLocal(typeId13);
            Local newLocal6 = declare.newLocal(typeId12);
            Local newLocal7 = declare.newLocal(typeId11);
            Local newLocal8 = declare.newLocal(typeId10);
            TypeId typeId15 = typeId10;
            Local newLocal9 = declare.newLocal(typeId6);
            Local newLocal10 = declare.newLocal(typeId13);
            TypeId<?> typeId16 = typeId6;
            Class<?> cls = PRIMITIVE_TO_BOXED.get(returnType);
            if (cls != null) {
                local = declare.newLocal(TypeId.get(cls));
            } else {
                local = null;
            }
            int length2 = parameterTypes.length;
            Local[] localArr = new Local[length2];
            Local newLocal11 = declare.newLocal(typeId11);
            Local newLocal12 = declare.newLocal(typeId9);
            TypeId typeId17 = typeId9;
            declare.loadConstant(newLocal10, Integer.valueOf(i4));
            declare.sget(field2, newLocal8);
            declare.aget(newLocal9, newLocal8, newLocal10);
            declare.loadConstant(newLocal5, Integer.valueOf(length));
            declare.newArray(newLocal4, newLocal5);
            Object obj2 = obj;
            declare.iget(obj2, newLocal, local2);
            declare.loadConstant(newLocal12, null);
            Label label = new Label();
            declare.compare(Comparison.EQ, label, newLocal12, newLocal);
            int i6 = 0;
            while (i6 < length) {
                declare.loadConstant(newLocal3, Integer.valueOf(i6));
                declare.aput(newLocal4, newLocal3, boxIfRequired(declare, declare.getParameter(i6, typeIdArr[i6]), newLocal6));
                i6++;
                obj2 = obj2;
            }
            Object obj3 = obj2;
            declare.invokeInterface(methodId2, newLocal2, newLocal, local2, newLocal9, newLocal4);
            generateCodeForReturnStatement(declare, returnType, newLocal2, newLocal7, local);
            declare.mark(label);
            for (int i7 = 0; i7 < length2; i7++) {
                localArr[i7] = declare.getParameter(i7, typeIdArr[i7]);
            }
            if (Void.TYPE.equals(returnType)) {
                methodId = method3;
                declare.invokeSuper(methodId, null, local2, localArr);
                declare.returnVoid();
            } else {
                methodId = method3;
                invokeSuper(methodId, declare, local2, localArr, newLocal11);
                declare.returnValue(newLocal11);
            }
            Code declare2 = dexMaker.declare(typeId.getMethod(typeId11, superMethodName(method2), typeIdArr), 1);
            Local<T> local3 = declare2.getThis(typeId);
            int length3 = parameterTypes.length;
            Local[] localArr2 = new Local[length3];
            for (int i8 = 0; i8 < length3; i8++) {
                localArr2[i8] = declare2.getParameter(i8, typeIdArr[i8]);
            }
            if (Void.TYPE.equals(returnType)) {
                declare2.invokeSuper(methodId, null, local3, localArr2);
                declare2.returnVoid();
            } else {
                Local<T> newLocal13 = declare2.newLocal(typeId11);
                invokeSuper(methodId, declare2, local3, localArr2, newLocal13);
                declare2.returnValue(newLocal13);
            }
            i4++;
            methodArr2 = methodArr;
            typeId3 = typeId;
            method = methodId2;
            dexMaker2 = dexMaker;
            field = obj3;
            typeId7 = typeId14;
            typeId10 = typeId15;
            typeId6 = typeId16;
            typeId9 = typeId17;
        }
    }

    private static void generateCodeForReturnStatement(Code code, Class cls, Local local, Local local2, Local local3) {
        if (PRIMITIVE_TO_UNBOX_METHOD.containsKey(cls)) {
            code.cast(local3, local);
            code.invokeVirtual(getUnboxMethodForPrimitive(cls), local2, local3, new Local[0]);
            code.returnValue(local2);
        } else if (Void.TYPE.equals(cls)) {
            code.returnVoid();
        } else {
            code.cast(local2, local);
            code.returnValue(local2);
        }
    }

    private static <T, G extends T> void generateConstructorsAndFields(DexMaker dexMaker, TypeId<G> typeId, TypeId<T> typeId2, Class<T> cls) {
        Constructor[] constructorsToOverwrite;
        TypeId<V> typeId3 = TypeId.get(InvocationHandler.class);
        TypeId<V> typeId4 = TypeId.get(Method[].class);
        dexMaker.declare(typeId.getField(typeId3, FIELD_NAME_HANDLER), 2, null);
        dexMaker.declare(typeId.getField(typeId4, FIELD_NAME_METHODS), 10, null);
        for (Constructor constructor : getConstructorsToOverwrite(cls)) {
            if (constructor.getModifiers() != 16) {
                TypeId<?>[] classArrayToTypeArray = classArrayToTypeArray(constructor.getParameterTypes());
                Code declare = dexMaker.declare(typeId.getConstructor(classArrayToTypeArray), 1);
                Local<T> local = declare.getThis(typeId);
                int length = classArrayToTypeArray.length;
                Local<?>[] localArr = new Local[length];
                for (int i4 = 0; i4 < length; i4++) {
                    localArr[i4] = declare.getParameter(i4, classArrayToTypeArray[i4]);
                }
                declare.invokeDirect(typeId2.getConstructor(classArrayToTypeArray), null, local, localArr);
                declare.returnVoid();
            }
        }
    }

    private static <T> Constructor<T>[] getConstructorsToOverwrite(Class<T> cls) {
        return (Constructor<T>[]) cls.getDeclaredConstructors();
    }

    private TypeId<?>[] getInterfacesAsTypeIds() {
        TypeId<?>[] typeIdArr = new TypeId[this.interfaces.size()];
        int i4 = 0;
        for (Class<?> cls : this.interfaces) {
            typeIdArr[i4] = TypeId.get(cls);
            i4++;
        }
        return typeIdArr;
    }

    public static InvocationHandler getInvocationHandler(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(FIELD_NAME_HANDLER);
            declaredField.setAccessible(true);
            return (InvocationHandler) declaredField.get(obj);
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        } catch (NoSuchFieldException e5) {
            throw new IllegalArgumentException("Not a valid proxy instance", e5);
        }
    }

    private static <T> String getMethodNameForProxyOf(Class<T> cls) {
        return cls.getName().replace(".", RemoteSettings.FORWARD_SLASH_STRING) + "_Proxy";
    }

    private void getMethodsToProxy(Set<MethodSetEntry> set, Set<MethodSetEntry> set2, Class<?> cls) {
        Method[] declaredMethods;
        for (Method method : cls.getDeclaredMethods()) {
            if ((method.getModifiers() & 16) != 0) {
                MethodSetEntry methodSetEntry = new MethodSetEntry(method);
                set2.add(methodSetEntry);
                set.remove(methodSetEntry);
            } else if ((method.getModifiers() & 8) == 0 && ((Modifier.isPublic(method.getModifiers()) || Modifier.isProtected(method.getModifiers()) || (this.sharedClassLoader && !Modifier.isPrivate(method.getModifiers()))) && (!method.getName().equals("finalize") || method.getParameterTypes().length != 0))) {
                MethodSetEntry methodSetEntry2 = new MethodSetEntry(method);
                if (!set2.contains(methodSetEntry2)) {
                    set.add(methodSetEntry2);
                }
            }
        }
        if (cls.isInterface()) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                getMethodsToProxy(set, set2, cls2);
            }
        }
    }

    private Method[] getMethodsToProxyRecursive() {
        int i4;
        Set<MethodSetEntry> hashSet = new HashSet<>();
        Set<MethodSetEntry> hashSet2 = new HashSet<>();
        for (Class<T> cls = this.baseClass; cls != null; cls = cls.getSuperclass()) {
            getMethodsToProxy(hashSet, hashSet2, cls);
        }
        Class<T> cls2 = this.baseClass;
        while (true) {
            i4 = 0;
            if (cls2 == null) {
                break;
            }
            Class<?>[] interfaces = cls2.getInterfaces();
            int length = interfaces.length;
            while (i4 < length) {
                getMethodsToProxy(hashSet, hashSet2, interfaces[i4]);
                i4++;
            }
            cls2 = cls2.getSuperclass();
        }
        for (Class<?> cls3 : this.interfaces) {
            getMethodsToProxy(hashSet, hashSet2, cls3);
        }
        Method[] methodArr = new Method[hashSet.size()];
        for (MethodSetEntry methodSetEntry : hashSet) {
            methodArr[i4] = methodSetEntry.originalMethod;
            i4++;
        }
        return methodArr;
    }

    private static MethodId<?, ?> getUnboxMethodForPrimitive(Class<?> cls) {
        return PRIMITIVE_TO_UNBOX_METHOD.get(cls);
    }

    private static void invokeSuper(MethodId methodId, Code code, Local local, Local[] localArr, Local local2) {
        code.invokeSuper(methodId, local2, local, localArr);
    }

    public static boolean isProxyClass(Class<?> cls) {
        try {
            cls.getDeclaredField(FIELD_NAME_HANDLER);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    private static RuntimeException launderCause(InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (!(cause instanceof Error)) {
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new UndeclaredThrowableException(cause);
        }
        throw ((Error) cause);
    }

    private Class<? extends T> loadClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return (Class<? extends T>) classLoader.loadClass(str);
    }

    public static void setInvocationHandler(Object obj, InvocationHandler invocationHandler) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(FIELD_NAME_HANDLER);
            declaredField.setAccessible(true);
            declaredField.set(obj, invocationHandler);
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        } catch (NoSuchFieldException e5) {
            throw new IllegalArgumentException("Not a valid proxy instance", e5);
        }
    }

    private static void setMethodsStaticField(Class<?> cls, Method[] methodArr) {
        try {
            Field declaredField = cls.getDeclaredField(FIELD_NAME_METHODS);
            declaredField.setAccessible(true);
            declaredField.set(null, methodArr);
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        } catch (NoSuchFieldException e5) {
            throw new AssertionError(e5);
        }
    }

    private static String superMethodName(Method method) {
        String name = method.getReturnType().getName();
        return "super$" + method.getName() + "$" + name.replace('.', '_').replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH, '_').replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, '_');
    }

    public T build() throws IOException {
        boolean z3;
        boolean z4 = true;
        if (this.handler != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        check(z3, "handler == null");
        if (this.constructorArgTypes.length != this.constructorArgValues.length) {
            z4 = false;
        }
        check(z4, "constructorArgValues.length != constructorArgTypes.length");
        try {
            try {
                T newInstance = buildProxyClass().getConstructor(this.constructorArgTypes).newInstance(this.constructorArgValues);
                setInvocationHandler(newInstance, this.handler);
                return newInstance;
            } catch (IllegalAccessException e4) {
                throw new AssertionError(e4);
            } catch (InstantiationException e5) {
                throw new AssertionError(e5);
            } catch (InvocationTargetException e6) {
                throw launderCause(e6);
            }
        } catch (NoSuchMethodException unused) {
            throw new IllegalArgumentException("No constructor for " + this.baseClass.getName() + " with parameter types " + Arrays.toString(this.constructorArgTypes));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r1.getClassLoader() == r2) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r1.getClassLoader().getParent() == r10.parentClassLoader) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        if (r3 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r10.interfaces.equals(asSet(r1.getInterfaces())) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Class<? extends T> buildProxyClass() throws java.io.IOException {
        /*
            r10 = this;
            java.util.Map<java.lang.Class<?>, java.lang.Class<?>> r0 = com.android.dx.stock.ProxyBuilder.generatedProxyClasses
            java.lang.Class<T> r1 = r10.baseClass
            java.lang.Object r1 = r0.get(r1)
            java.lang.Class r1 = (java.lang.Class) r1
            if (r1 == 0) goto L45
            boolean r2 = r10.sharedClassLoader
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L26
            java.lang.ClassLoader r2 = r10.parentClassLoader
            if (r2 == 0) goto L17
            goto L1d
        L17:
            java.lang.Class<T> r2 = r10.baseClass
            java.lang.ClassLoader r2 = r2.getClassLoader()
        L1d:
            java.lang.ClassLoader r5 = r1.getClassLoader()
            if (r5 != r2) goto L24
            goto L32
        L24:
            r3 = 0
            goto L32
        L26:
            java.lang.ClassLoader r2 = r1.getClassLoader()
            java.lang.ClassLoader r2 = r2.getParent()
            java.lang.ClassLoader r5 = r10.parentClassLoader
            if (r2 != r5) goto L24
        L32:
            if (r3 == 0) goto L45
            java.util.Set<java.lang.Class<?>> r2 = r10.interfaces
            java.lang.Class[] r3 = r1.getInterfaces()
            java.util.Set r3 = asSet(r3)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L45
            return r1
        L45:
            com.android.dx.DexMaker r1 = new com.android.dx.DexMaker
            r1.<init>()
            java.lang.Class<T> r2 = r10.baseClass
            java.lang.String r2 = getMethodNameForProxyOf(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "L"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = ";"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.android.dx.TypeId r4 = com.android.dx.TypeId.get(r3)
            java.lang.Class<T> r3 = r10.baseClass
            com.android.dx.TypeId r7 = com.android.dx.TypeId.get(r3)
            java.lang.Class<T> r3 = r10.baseClass
            generateConstructorsAndFields(r1, r4, r7, r3)
            java.lang.reflect.Method[] r3 = r10.methods
            if (r3 != 0) goto L7d
            java.lang.reflect.Method[] r3 = r10.getMethodsToProxyRecursive()
        L7d:
            r9 = r3
            com.android.dx.stock.ProxyBuilder$1 r3 = new com.android.dx.stock.ProxyBuilder$1
            r3.<init>()
            java.util.Arrays.sort(r9, r3)
            generateCodeForAllMethods(r1, r4, r9, r7)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r5 = ".generated"
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r6 = 1
            com.android.dx.TypeId[] r8 = r10.getInterfacesAsTypeIds()
            r3 = r1
            r3.declare(r4, r5, r6, r7, r8)
            boolean r3 = r10.sharedClassLoader
            if (r3 == 0) goto Lb0
            java.lang.Class<T> r3 = r10.baseClass
            java.lang.ClassLoader r3 = r3.getClassLoader()
            r1.setSharedClassLoader(r3)
        Lb0:
            java.lang.ClassLoader r3 = r10.parentClassLoader
            java.io.File r4 = r10.dexCache
            java.lang.ClassLoader r1 = r1.generateAndLoad(r3, r4)
            java.lang.Class r1 = r10.loadClass(r1, r2)     // Catch: java.lang.ClassNotFoundException -> Lc5 java.lang.IllegalAccessError -> Lcc
            setMethodsStaticField(r1, r9)
            java.lang.Class<T> r2 = r10.baseClass
            r0.put(r2, r1)
            return r1
        Lc5:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        Lcc:
            r0 = move-exception
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "cannot proxy inaccessible class "
            r2.append(r3)
            java.lang.Class<T> r3 = r10.baseClass
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.stock.ProxyBuilder.buildProxyClass():java.lang.Class");
    }

    public ProxyBuilder<T> constructorArgTypes(Class<?>... clsArr) {
        this.constructorArgTypes = clsArr;
        return this;
    }

    public ProxyBuilder<T> constructorArgValues(Object... objArr) {
        this.constructorArgValues = objArr;
        return this;
    }

    public ProxyBuilder<T> dexCache(File file) {
        File file2 = new File(file, RegisterSpec.PREFIX + Integer.toString(1));
        this.dexCache = file2;
        file2.mkdir();
        return this;
    }

    public ProxyBuilder<T> handler(InvocationHandler invocationHandler) {
        this.handler = invocationHandler;
        return this;
    }

    public ProxyBuilder<T> implementing(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            if (cls.isInterface()) {
                this.interfaces.add(cls);
            } else {
                throw new IllegalArgumentException("Not an interface: " + cls.getName());
            }
        }
        return this;
    }

    public ProxyBuilder<T> onlyMethods(Method[] methodArr) {
        this.methods = methodArr;
        return this;
    }

    public ProxyBuilder<T> parentClassLoader(ClassLoader classLoader) {
        this.parentClassLoader = classLoader;
        return this;
    }

    public ProxyBuilder<T> withSharedClassLoader() {
        this.sharedClassLoader = true;
        return this;
    }
}
