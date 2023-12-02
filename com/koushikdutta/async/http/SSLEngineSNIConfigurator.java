package com.koushikdutta.async.http;

import android.os.Build;
import com.google.android.gms.security.ProviderInstaller;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import java.lang.reflect.Field;
import java.util.Hashtable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/* loaded from: classes6.dex */
public class SSLEngineSNIConfigurator implements AsyncSSLEngineConfigurator {

    /* renamed from: a  reason: collision with root package name */
    Hashtable<String, a> f35072a = new Hashtable<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements AsyncSSLEngineConfigurator {

        /* renamed from: a  reason: collision with root package name */
        Field f35073a;

        /* renamed from: b  reason: collision with root package name */
        Field f35074b;

        /* renamed from: c  reason: collision with root package name */
        Field f35075c;

        /* renamed from: d  reason: collision with root package name */
        Field f35076d;

        /* renamed from: e  reason: collision with root package name */
        boolean f35077e;

        public a(Class cls) {
            try {
                Field declaredField = cls.getSuperclass().getDeclaredField("peerHost");
                this.f35073a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getSuperclass().getDeclaredField("peerPort");
                this.f35074b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("sslParameters");
                this.f35075c = declaredField3;
                declaredField3.setAccessible(true);
                Field declaredField4 = this.f35075c.getType().getDeclaredField("useSni");
                this.f35076d = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        }

        @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
        public void configureEngine(SSLEngine sSLEngine, AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i4) {
            if (this.f35076d != null && !this.f35077e) {
                try {
                    this.f35073a.set(sSLEngine, str);
                    this.f35074b.set(sSLEngine, Integer.valueOf(i4));
                    this.f35076d.set(this.f35075c.get(sSLEngine), Boolean.TRUE);
                } catch (IllegalAccessException unused) {
                }
            }
        }

        @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
        public SSLEngine createEngine(SSLContext sSLContext, String str, int i4) {
            return null;
        }
    }

    a a(SSLEngine sSLEngine) {
        String canonicalName = sSLEngine.getClass().getCanonicalName();
        a aVar = this.f35072a.get(canonicalName);
        if (aVar == null) {
            a aVar2 = new a(sSLEngine.getClass());
            this.f35072a.put(canonicalName, aVar2);
            return aVar2;
        }
        return aVar;
    }

    @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
    public void configureEngine(SSLEngine sSLEngine, AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i4) {
        a(sSLEngine).configureEngine(sSLEngine, getSocketData, str, i4);
    }

    @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
    public SSLEngine createEngine(SSLContext sSLContext, String str, int i4) {
        boolean z3;
        if (!ProviderInstaller.PROVIDER_NAME.equals(sSLContext.getProvider().getName()) && Build.VERSION.SDK_INT < 23) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            return sSLContext.createSSLEngine(str, i4);
        }
        return sSLContext.createSSLEngine();
    }
}
