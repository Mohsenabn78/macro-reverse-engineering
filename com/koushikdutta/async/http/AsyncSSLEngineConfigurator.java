package com.koushikdutta.async.http;

import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/* loaded from: classes6.dex */
public interface AsyncSSLEngineConfigurator {
    void configureEngine(SSLEngine sSLEngine, AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i4);

    SSLEngine createEngine(SSLContext sSLContext, String str, int i4);
}
