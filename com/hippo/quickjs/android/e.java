package com.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.hippo.quickjs.android.TypeAdapter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InterfaceTypeAdapter.java */
/* loaded from: classes6.dex */
public class e extends TypeAdapter<Object> {

    /* renamed from: c  reason: collision with root package name */
    static final TypeAdapter.Factory f34082c = new TypeAdapter.Factory() { // from class: com.hippo.quickjs.android.c
        @Override // com.hippo.quickjs.android.TypeAdapter.Factory
        public final TypeAdapter create(TypeAdapter.Depot depot, Type type) {
            TypeAdapter e4;
            e4 = e.e(depot, type);
            return e4;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final c f34083d = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f34084a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Method> f34085b;

    /* compiled from: InterfaceTypeAdapter.java */
    /* loaded from: classes6.dex */
    private interface b {
        JSValue a(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InterfaceTypeAdapter.java */
    /* loaded from: classes6.dex */
    public static class c {
        private c() {
        }
    }

    private e(Class<?> cls, Map<String, Method> map) {
        this.f34084a = cls;
        this.f34085b = map;
    }

    @Nullable
    static Map<String, Method> c(Type type) {
        java.lang.reflect.Method[] methods;
        Class<?> l4 = m.l(type);
        if (!l4.isInterface()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (java.lang.reflect.Method method : l4.getMethods()) {
            Type p4 = m.p(type, l4, method.getGenericReturnType());
            if (p4 instanceof TypeVariable) {
                return null;
            }
            String name = method.getName();
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            int length = genericParameterTypes.length;
            Type[] typeArr = new Type[length];
            for (int i4 = 0; i4 < length; i4++) {
                Type p5 = m.p(type, l4, genericParameterTypes[i4]);
                typeArr[i4] = p5;
                if (p5 instanceof TypeVariable) {
                    return null;
                }
            }
            Method method2 = (Method) hashMap.get(name);
            if (method2 != null) {
                if (!Arrays.equals(method2.f34068c, typeArr)) {
                    return null;
                }
                if (!p4.equals(method2.f34066a)) {
                    if (m.l(p4).isAssignableFrom(m.l(method2.f34066a))) {
                    }
                }
            }
            hashMap.put(name, new Method(p4, name, typeArr));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(JSValue jSValue, TypeAdapter.Depot depot, TypeAdapter.Context context, JSObject jSObject, Object obj, java.lang.reflect.Method method, Object[] objArr) throws Throwable {
        int i4;
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr != null && objArr.length == 1 && objArr[0] == f34083d) {
            return jSValue;
        }
        String name = method.getName();
        Method method2 = this.f34085b.get(name);
        if (method2 != null) {
            if (objArr != null) {
                i4 = objArr.length;
            } else {
                i4 = 0;
            }
            if (i4 == method2.f34068c.length) {
                JSValue[] jSValueArr = new JSValue[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    jSValueArr[i5] = depot.getAdapter(method2.f34068c[i5]).toJSValue(depot, context, objArr[i5]);
                }
                return depot.getAdapter(method2.f34066a).fromJSValue(depot, context, ((JSFunction) jSObject.getProperty(name).cast(JSFunction.class)).invoke(jSObject, jSValueArr));
            }
            throw new IllegalStateException("Parameter number doesn't match: " + name);
        }
        throw new NoSuchMethodException("Can't find method: " + name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TypeAdapter e(TypeAdapter.Depot depot, Type type) {
        Map<String, Method> c4 = c(type);
        if (c4 == null) {
            return null;
        }
        return new e(m.l(type), c4).nullable();
    }

    @Override // com.hippo.quickjs.android.TypeAdapter
    public Object fromJSValue(final TypeAdapter.Depot depot, final TypeAdapter.Context context, final JSValue jSValue) {
        final JSObject jSObject = (JSObject) jSValue.cast(JSObject.class);
        Object javaObject = jSObject.getJavaObject();
        if (this.f34084a.isInstance(javaObject)) {
            return javaObject;
        }
        return Proxy.newProxyInstance(this.f34084a.getClassLoader(), new Class[]{this.f34084a, b.class}, new InvocationHandler() { // from class: com.hippo.quickjs.android.d
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, java.lang.reflect.Method method, Object[] objArr) {
                Object d4;
                d4 = e.this.d(jSValue, depot, context, jSObject, obj, method, objArr);
                return d4;
            }
        });
    }

    @Override // com.hippo.quickjs.android.TypeAdapter
    public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Object obj) {
        if (obj instanceof b) {
            return ((b) obj).a(f34083d);
        }
        JSObject createJSObject = context.createJSObject(obj);
        for (Method method : this.f34085b.values()) {
            createJSObject.setProperty(method.f34067b, context.createJSFunction(obj, method));
        }
        return createJSObject;
    }
}
