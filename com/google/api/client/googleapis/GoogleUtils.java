package com.google.api.client.googleapis;

import com.google.api.client.util.SecurityUtils;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* loaded from: classes5.dex */
public final class GoogleUtils {
    public static final String VERSION;

    /* renamed from: a  reason: collision with root package name */
    static KeyStore f25550a;
    public static final Integer MAJOR_VERSION = 1;
    public static final Integer MINOR_VERSION = 23;
    public static final Integer BUGFIX_VERSION = 0;

    static {
        String valueOf = String.valueOf((Object) 1);
        String valueOf2 = String.valueOf((Object) 23);
        String valueOf3 = String.valueOf((Object) 0);
        StringBuilder sb = new StringBuilder(valueOf.length() + 2 + valueOf2.length() + valueOf3.length());
        sb.append(valueOf);
        sb.append(".");
        sb.append(valueOf2);
        sb.append(".");
        sb.append(valueOf3);
        VERSION = sb.toString().toString();
    }

    private GoogleUtils() {
    }

    public static synchronized KeyStore getCertificateTrustStore() throws IOException, GeneralSecurityException {
        KeyStore keyStore;
        synchronized (GoogleUtils.class) {
            if (f25550a == null) {
                f25550a = SecurityUtils.getJavaKeyStore();
                SecurityUtils.loadKeyStore(f25550a, GoogleUtils.class.getResourceAsStream("google.jks"), "notasecret");
            }
            keyStore = f25550a;
        }
        return keyStore;
    }
}
