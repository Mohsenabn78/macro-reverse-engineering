package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class ComponentDiscovery<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f29189a;

    /* renamed from: b  reason: collision with root package name */
    private final RegistrarNameRetriever<T> f29190b;

    /* loaded from: classes5.dex */
    private static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<? extends Service> f29191a;

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f29191a), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", this.f29191a + " has no service info.");
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // com.google.firebase.components.ComponentDiscovery.RegistrarNameRetriever
        /* renamed from: c */
        public List<String> a(Context context) {
            Bundle b4 = b(context);
            if (b4 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b4.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b4.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private MetadataRegistrarNameRetriever(Class<? extends Service> cls) {
            this.f29191a = cls;
        }
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    interface RegistrarNameRetriever<T> {
        List<String> a(T t3);
    }

    @VisibleForTesting
    ComponentDiscovery(T t3, RegistrarNameRetriever<T> registrarNameRetriever) {
        this.f29189a = t3;
        this.f29190b = registrarNameRetriever;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static ComponentRegistrar b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e4) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e4);
        } catch (InstantiationException e5) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e5);
        } catch (NoSuchMethodException e6) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e6);
        } catch (InvocationTargetException e7) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e7);
        }
    }

    public static ComponentDiscovery<Context> forContext(Context context, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context, new MetadataRegistrarNameRetriever(cls));
    }

    @Deprecated
    public List<ComponentRegistrar> discover() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f29190b.a(this.f29189a)) {
            try {
                ComponentRegistrar b4 = b(str);
                if (b4 != null) {
                    arrayList.add(b4);
                }
            } catch (InvalidRegistrarException e4) {
                Log.w("ComponentDiscovery", "Invalid component registrar.", e4);
            }
        }
        return arrayList;
    }

    public List<Provider<ComponentRegistrar>> discoverLazy() {
        ArrayList arrayList = new ArrayList();
        for (final String str : this.f29190b.a(this.f29189a)) {
            arrayList.add(new Provider() { // from class: com.google.firebase.components.g
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    ComponentRegistrar b4;
                    b4 = ComponentDiscovery.b(str);
                    return b4;
                }
            });
        }
        return arrayList;
    }
}
