package com.koushikdutta.ion.conscrypt;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.security.ProviderInstaller;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.AsyncSSLSocketMiddleware;
import com.koushikdutta.async.http.SimpleMiddleware;
import java.security.Provider;
import java.security.Security;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes6.dex */
public class ConscryptMiddleware extends SimpleMiddleware {

    /* renamed from: e  reason: collision with root package name */
    static final Object f35822e = new Object();

    /* renamed from: f  reason: collision with root package name */
    static boolean f35823f;

    /* renamed from: g  reason: collision with root package name */
    static boolean f35824g;

    /* renamed from: a  reason: collision with root package name */
    boolean f35825a;

    /* renamed from: b  reason: collision with root package name */
    boolean f35826b = true;

    /* renamed from: c  reason: collision with root package name */
    AsyncSSLSocketMiddleware f35827c;

    /* renamed from: d  reason: collision with root package name */
    Context f35828d;

    public ConscryptMiddleware(Context context, AsyncSSLSocketMiddleware asyncSSLSocketMiddleware) {
        this.f35827c = asyncSSLSocketMiddleware;
        this.f35828d = context.getApplicationContext();
    }

    public static void initialize(Context context) {
        try {
            synchronized (f35822e) {
                if (f35823f) {
                    return;
                }
                f35823f = true;
                if (Security.getProvider(ProviderInstaller.PROVIDER_NAME) != null) {
                    f35824g = true;
                    return;
                }
                SSLContext sSLContext = SSLContext.getDefault();
                SSLSocketFactory defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
                ProviderInstaller.installIfNeeded(context);
                Provider[] providers = Security.getProviders();
                Provider provider = Security.getProvider(ProviderInstaller.PROVIDER_NAME);
                Security.removeProvider(ProviderInstaller.PROVIDER_NAME);
                Security.insertProviderAt(provider, providers.length);
                SSLContext.setDefault(sSLContext);
                HttpsURLConnection.setDefaultSSLSocketFactory(defaultSSLSocketFactory);
                f35824g = true;
            }
        } catch (Throwable th) {
            Log.w("IonConscrypt", "Conscrypt initialization failed.", th);
        }
    }

    public void enable(boolean z3) {
        this.f35826b = z3;
        if (!z3) {
            this.f35825a = false;
            this.f35827c.setSSLContext(null);
        }
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public Cancellable getSocket(AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        if (!this.f35826b) {
            return null;
        }
        initialize();
        return super.getSocket(getSocketData);
    }

    public void initialize() {
        initialize(this.f35828d);
        if (f35824g && !this.f35825a && this.f35826b) {
            this.f35825a = true;
            try {
                SSLContext sSLContext = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS, ProviderInstaller.PROVIDER_NAME);
                sSLContext.init(null, null, null);
                if (this.f35827c.getSSLContext() == AsyncSSLSocketWrapper.getDefaultSSLContext()) {
                    this.f35827c.setSSLContext(sSLContext);
                }
            } catch (Exception unused) {
            }
        }
    }
}
