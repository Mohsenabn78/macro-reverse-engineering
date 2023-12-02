package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
class MetadataBackendRegistry implements BackendRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final BackendFactoryProvider f18713a;

    /* renamed from: b  reason: collision with root package name */
    private final CreationContextFactory f18714b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, TransportBackend> f18715c;

    /* loaded from: classes.dex */
    static class BackendFactoryProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Context f18716a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f18717b = null;

        BackendFactoryProvider(Context context) {
            this.f18716a = context;
        }

        private Map<String, String> a(Context context) {
            Bundle d4 = d(context);
            if (d4 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : d4.keySet()) {
                Object obj = d4.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String trim = str2.trim();
                        if (!trim.isEmpty()) {
                            hashMap.put(trim, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private Map<String, String> c() {
            if (this.f18717b == null) {
                this.f18717b = a(this.f18716a);
            }
            return this.f18717b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo == null) {
                    Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        @Nullable
        BackendFactory b(String str) {
            String str2 = c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str2).asSubclass(BackendFactory.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e4) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e4);
                return null;
            } catch (IllegalAccessException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e5);
                return null;
            } catch (InstantiationException e6) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e6);
                return null;
            } catch (NoSuchMethodException e7) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e7);
                return null;
            } catch (InvocationTargetException e8) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e8);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        this(new BackendFactoryProvider(context), creationContextFactory);
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRegistry
    @Nullable
    public synchronized TransportBackend get(String str) {
        if (this.f18715c.containsKey(str)) {
            return this.f18715c.get(str);
        }
        BackendFactory b4 = this.f18713a.b(str);
        if (b4 == null) {
            return null;
        }
        TransportBackend create = b4.create(this.f18714b.a(str));
        this.f18715c.put(str, create);
        return create;
    }

    MetadataBackendRegistry(BackendFactoryProvider backendFactoryProvider, CreationContextFactory creationContextFactory) {
        this.f18715c = new HashMap();
        this.f18713a = backendFactoryProvider;
        this.f18714b = creationContextFactory;
    }
}
