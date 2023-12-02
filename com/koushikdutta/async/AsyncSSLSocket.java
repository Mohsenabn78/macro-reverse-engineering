package com.koushikdutta.async;

import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;

/* loaded from: classes6.dex */
public interface AsyncSSLSocket extends AsyncSocket {
    X509Certificate[] getPeerCertificates();

    SSLEngine getSSLEngine();
}
