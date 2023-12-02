package com.koushikdutta.async.http;

import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;

/* loaded from: classes6.dex */
public class AsyncSSLSocketMiddleware extends AsyncSocketMiddleware {

    /* renamed from: k  reason: collision with root package name */
    protected SSLContext f34973k;

    /* renamed from: l  reason: collision with root package name */
    protected TrustManager[] f34974l;

    /* renamed from: m  reason: collision with root package name */
    protected HostnameVerifier f34975m;

    /* renamed from: n  reason: collision with root package name */
    protected List<AsyncSSLEngineConfigurator> f34976n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements AsyncSSLSocketWrapper.HandshakeCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConnectCallback f34977a;

        a(ConnectCallback connectCallback) {
            this.f34977a = connectCallback;
        }

        @Override // com.koushikdutta.async.AsyncSSLSocketWrapper.HandshakeCallback
        public void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
            this.f34977a.onConnectCompleted(exc, asyncSSLSocket);
        }
    }

    /* loaded from: classes6.dex */
    class b implements ConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConnectCallback f34979a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f34980b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.GetSocketData f34981c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Uri f34982d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f34983e;

        /* loaded from: classes6.dex */
        class a implements CompletedCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AsyncSocket f34985a;

            /* renamed from: com.koushikdutta.async.http.AsyncSSLSocketMiddleware$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            class C0183a implements LineEmitter.StringCallback {

                /* renamed from: a  reason: collision with root package name */
                String f34987a;

                C0183a() {
                }

                @Override // com.koushikdutta.async.LineEmitter.StringCallback
                public void onStringAvailable(String str) {
                    b.this.f34981c.request.logv(str);
                    if (this.f34987a == null) {
                        String trim = str.trim();
                        this.f34987a = trim;
                        if (!trim.matches("HTTP/1.\\d 2\\d\\d .*")) {
                            a.this.f34985a.setDataCallback(null);
                            a.this.f34985a.setEndCallback(null);
                            ConnectCallback connectCallback = b.this.f34979a;
                            connectCallback.onConnectCompleted(new IOException("non 2xx status line: " + this.f34987a), a.this.f34985a);
                        }
                    } else if (TextUtils.isEmpty(str.trim())) {
                        a.this.f34985a.setDataCallback(null);
                        a.this.f34985a.setEndCallback(null);
                        a aVar = a.this;
                        b bVar = b.this;
                        AsyncSSLSocketMiddleware.this.m(aVar.f34985a, bVar.f34981c, bVar.f34982d, bVar.f34983e, bVar.f34979a);
                    }
                }
            }

            /* renamed from: com.koushikdutta.async.http.AsyncSSLSocketMiddleware$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            class C0184b implements CompletedCallback {
                C0184b() {
                }

                @Override // com.koushikdutta.async.callback.CompletedCallback
                public void onCompleted(Exception exc) {
                    if (!a.this.f34985a.isOpen() && exc == null) {
                        exc = new IOException("socket closed before proxy connect response");
                    }
                    a aVar = a.this;
                    b.this.f34979a.onConnectCompleted(exc, aVar.f34985a);
                }
            }

            a(AsyncSocket asyncSocket) {
                this.f34985a = asyncSocket;
            }

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                if (exc != null) {
                    b.this.f34979a.onConnectCompleted(exc, this.f34985a);
                    return;
                }
                LineEmitter lineEmitter = new LineEmitter();
                lineEmitter.setLineCallback(new C0183a());
                this.f34985a.setDataCallback(lineEmitter);
                this.f34985a.setEndCallback(new C0184b());
            }
        }

        b(ConnectCallback connectCallback, boolean z3, AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i4) {
            this.f34979a = connectCallback;
            this.f34980b = z3;
            this.f34981c = getSocketData;
            this.f34982d = uri;
            this.f34983e = i4;
        }

        @Override // com.koushikdutta.async.callback.ConnectCallback
        public void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
            if (exc != null) {
                this.f34979a.onConnectCompleted(exc, asyncSocket);
            } else if (!this.f34980b) {
                AsyncSSLSocketMiddleware.this.m(asyncSocket, this.f34981c, this.f34982d, this.f34983e, this.f34979a);
            } else {
                String format = String.format(Locale.ENGLISH, "CONNECT %s:%s HTTP/1.1\r\nHost: %s\r\n\r\n", this.f34982d.getHost(), Integer.valueOf(this.f34983e), this.f34982d.getHost());
                AsyncHttpRequest asyncHttpRequest = this.f34981c.request;
                asyncHttpRequest.logv("Proxying: " + format);
                Util.writeAll(asyncSocket, format.getBytes(), new a(asyncSocket));
            }
        }
    }

    public AsyncSSLSocketMiddleware(AsyncHttpClient asyncHttpClient) {
        super(asyncHttpClient, ProxyConfig.MATCH_HTTPS, GrpcUtil.DEFAULT_PORT_SSL);
        this.f34976n = new ArrayList();
    }

    public void addEngineConfigurator(AsyncSSLEngineConfigurator asyncSSLEngineConfigurator) {
        this.f34976n.add(asyncSSLEngineConfigurator);
    }

    public void clearEngineConfigurators() {
        this.f34976n.clear();
    }

    public SSLContext getSSLContext() {
        SSLContext sSLContext = this.f34973k;
        if (sSLContext == null) {
            return AsyncSSLSocketWrapper.getDefaultSSLContext();
        }
        return sSLContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.http.AsyncSocketMiddleware
    public ConnectCallback j(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i4, boolean z3, ConnectCallback connectCallback) {
        return new b(connectCallback, z3, getSocketData, uri, i4);
    }

    protected SSLEngine k(AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i4) {
        SSLContext sSLContext = getSSLContext();
        Iterator<AsyncSSLEngineConfigurator> it = this.f34976n.iterator();
        SSLEngine sSLEngine = null;
        while (it.hasNext() && (sSLEngine = it.next().createEngine(sSLContext, str, i4)) == null) {
        }
        for (AsyncSSLEngineConfigurator asyncSSLEngineConfigurator : this.f34976n) {
            asyncSSLEngineConfigurator.configureEngine(sSLEngine, getSocketData, str, i4);
        }
        return sSLEngine;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AsyncSSLSocketWrapper.HandshakeCallback l(AsyncHttpClientMiddleware.GetSocketData getSocketData, ConnectCallback connectCallback) {
        return new a(connectCallback);
    }

    protected void m(AsyncSocket asyncSocket, AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i4, ConnectCallback connectCallback) {
        AsyncSSLSocketWrapper.handshake(asyncSocket, uri.getHost(), i4, k(getSocketData, uri.getHost(), i4), this.f34974l, this.f34975m, true, l(getSocketData, connectCallback));
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f34975m = hostnameVerifier;
    }

    public void setSSLContext(SSLContext sSLContext) {
        this.f34973k = sSLContext;
    }

    public void setTrustManagers(TrustManager[] trustManagerArr) {
        this.f34974l = trustManagerArr;
    }
}
