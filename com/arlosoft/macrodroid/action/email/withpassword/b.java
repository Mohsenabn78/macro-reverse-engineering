package com.arlosoft.macrodroid.action.email.withpassword;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JSSEProvider.java */
/* loaded from: classes2.dex */
public final class b extends Provider {
    public b() {
        super("HarmonyJSSE", 1.0d, "Harmony JSSE Provider");
        AccessController.doPrivileged(new PrivilegedAction() { // from class: com.arlosoft.macrodroid.action.email.withpassword.a
            @Override // java.security.PrivilegedAction
            public final Object run() {
                Void c4;
                c4 = b.this.c();
                return c4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void c() {
        put("SSLContext.TLS", "org.apache.harmony.xnet.provider.jsse.SSLContextImpl");
        put("Alg.Alias.SSLContext.TLSv1", SSLSocketFactory.TLS);
        put("KeyManagerFactory.X509", "org.apache.harmony.xnet.provider.jsse.KeyManagerFactoryImpl");
        put("TrustManagerFactory.X509", "org.apache.harmony.xnet.provider.jsse.TrustManagerFactoryImpl");
        return null;
    }
}
