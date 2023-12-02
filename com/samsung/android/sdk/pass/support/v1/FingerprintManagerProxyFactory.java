package com.samsung.android.sdk.pass.support.v1;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.pass.support.IFingerprintManagerProxy;
import com.samsung.android.sdk.pass.support.SdkSupporter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class FingerprintManagerProxyFactory {

    /* loaded from: classes6.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private Object f37421a;

        /* renamed from: b  reason: collision with root package name */
        private Map f37422b = new HashMap();

        public a(Object obj) {
            Method[] methods;
            this.f37421a = obj;
            Method[] methods2 = IFingerprintManagerProxy.class.getMethods();
            for (Method method : obj.getClass().getMethods()) {
                String name = method.getName();
                if (a(methods2, method)) {
                    this.f37422b.put(name, method);
                }
            }
        }

        private static boolean a(Method[] methodArr, Method method) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Method method2 : methodArr) {
                if (method2.getName().equals(name)) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes == null || parameterTypes2 == null) {
                        return true;
                    }
                    if (parameterTypes.length == parameterTypes2.length) {
                        int length = parameterTypes.length;
                        boolean z3 = false;
                        for (int i4 = 0; i4 < length; i4++) {
                            if (!parameterTypes2[i4].equals(parameterTypes[i4])) {
                                z3 = true;
                            }
                        }
                        if (!z3) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return false;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Method method2 = (Method) this.f37422b.get(method.getName());
            if (method2 != null) {
                return method2.invoke(this.f37421a, objArr);
            }
            return null;
        }
    }

    public static IFingerprintManagerProxy create(Context context) {
        Object obj;
        try {
            obj = Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER).getMethod("getInstance", Context.class).invoke(null, context);
        } catch (Exception e4) {
            Log.e("FingerprintManagerProxy", "Cannot create FingerprintManagerProxy : " + e4);
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return (IFingerprintManagerProxy) Proxy.newProxyInstance(FingerprintManagerProxyFactory.class.getClassLoader(), new Class[]{IFingerprintManagerProxy.class}, new a(obj));
    }
}
