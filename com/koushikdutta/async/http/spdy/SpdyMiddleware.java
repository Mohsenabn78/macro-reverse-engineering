package com.koushikdutta.async.http.spdy;

import android.net.Uri;
import android.text.TextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.MultiFuture;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncSSLEngineConfigurator;
import com.koushikdutta.async.http.AsyncSSLSocketMiddleware;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.Protocol;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.http.spdy.AsyncSpdyConnection;
import com.koushikdutta.async.util.Charsets;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: classes6.dex */
public class SpdyMiddleware extends AsyncSSLSocketMiddleware {
    private static final g A = new g(null);

    /* renamed from: o  reason: collision with root package name */
    boolean f35481o;

    /* renamed from: p  reason: collision with root package name */
    Field f35482p;

    /* renamed from: q  reason: collision with root package name */
    Field f35483q;

    /* renamed from: r  reason: collision with root package name */
    Field f35484r;

    /* renamed from: s  reason: collision with root package name */
    Field f35485s;

    /* renamed from: t  reason: collision with root package name */
    Field f35486t;

    /* renamed from: u  reason: collision with root package name */
    Field f35487u;

    /* renamed from: v  reason: collision with root package name */
    Field f35488v;

    /* renamed from: w  reason: collision with root package name */
    Method f35489w;

    /* renamed from: x  reason: collision with root package name */
    Method f35490x;

    /* renamed from: y  reason: collision with root package name */
    Hashtable<String, h> f35491y;

    /* renamed from: z  reason: collision with root package name */
    boolean f35492z;

    /* loaded from: classes6.dex */
    class a implements AsyncSSLEngineConfigurator {
        a() {
        }

        @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
        public void configureEngine(SSLEngine sSLEngine, AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i4) {
            SpdyMiddleware.this.u(sSLEngine, getSocketData, str, i4);
        }

        @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
        public SSLEngine createEngine(SSLContext sSLContext, String str, int i4) {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class b implements AsyncSSLSocketWrapper.HandshakeCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.GetSocketData f35494a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f35495b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ConnectCallback f35496c;

        /* loaded from: classes6.dex */
        class a extends AsyncSpdyConnection {

            /* renamed from: s  reason: collision with root package name */
            boolean f35498s;

            a(AsyncSocket asyncSocket, Protocol protocol) {
                super(asyncSocket, protocol);
            }

            @Override // com.koushikdutta.async.http.spdy.AsyncSpdyConnection, com.koushikdutta.async.http.spdy.FrameReader.Handler
            public void settings(boolean z3, j jVar) {
                super.settings(z3, jVar);
                if (!this.f35498s) {
                    this.f35498s = true;
                    b bVar = b.this;
                    h hVar = SpdyMiddleware.this.f35491y.get(bVar.f35495b);
                    if (hVar.f35511k.setComplete()) {
                        AsyncHttpRequest asyncHttpRequest = b.this.f35494a.request;
                        asyncHttpRequest.logv("using new spdy connection for host: " + b.this.f35494a.request.getUri().getHost());
                        b bVar2 = b.this;
                        SpdyMiddleware.this.w(bVar2.f35494a, this, bVar2.f35496c);
                    }
                    hVar.setComplete((h) this);
                }
            }
        }

        b(AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, ConnectCallback connectCallback) {
            this.f35494a = getSocketData;
            this.f35495b = str;
            this.f35496c = connectCallback;
        }

        @Override // com.koushikdutta.async.AsyncSSLSocketWrapper.HandshakeCallback
        public void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
            this.f35494a.request.logv("checking spdy handshake");
            if (exc == null) {
                SpdyMiddleware spdyMiddleware = SpdyMiddleware.this;
                if (spdyMiddleware.f35490x != null) {
                    try {
                        byte[] bArr = (byte[]) SpdyMiddleware.this.f35490x.invoke(null, Long.valueOf(((Long) spdyMiddleware.f35487u.get(asyncSSLSocket.getSSLEngine())).longValue()));
                        if (bArr == null) {
                            SpdyMiddleware.this.v(this.f35495b, this.f35496c, null, asyncSSLSocket);
                            SpdyMiddleware.this.x(this.f35495b);
                            return;
                        }
                        String str = new String(bArr);
                        Protocol protocol = Protocol.get(str);
                        if (protocol == null || !protocol.needsSpdyConnection()) {
                            SpdyMiddleware.this.v(this.f35495b, this.f35496c, null, asyncSSLSocket);
                            SpdyMiddleware.this.x(this.f35495b);
                            return;
                        }
                        try {
                            new a(asyncSSLSocket, Protocol.get(str)).sendConnectionPreface();
                            return;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return;
                        }
                    } catch (Exception e5) {
                        throw new AssertionError(e5);
                    }
                }
            }
            SpdyMiddleware.this.v(this.f35495b, this.f35496c, exc, asyncSSLSocket);
            SpdyMiddleware.this.x(this.f35495b);
        }
    }

    /* loaded from: classes6.dex */
    class c implements ConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f35500a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ConnectCallback f35501b;

        c(String str, ConnectCallback connectCallback) {
            this.f35500a = str;
            this.f35501b = connectCallback;
        }

        @Override // com.koushikdutta.async.callback.ConnectCallback
        public void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
            h remove;
            if (exc != null && (remove = SpdyMiddleware.this.f35491y.remove(this.f35500a)) != null) {
                remove.setComplete(exc);
            }
            this.f35501b.onConnectCompleted(exc, asyncSocket);
        }
    }

    /* loaded from: classes6.dex */
    class d implements FutureCallback<AsyncSpdyConnection> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.GetSocketData f35503a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SimpleCancellable f35504b;

        d(AsyncHttpClientMiddleware.GetSocketData getSocketData, SimpleCancellable simpleCancellable) {
            this.f35503a = getSocketData;
            this.f35504b = simpleCancellable;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, AsyncSpdyConnection asyncSpdyConnection) {
            if (exc instanceof g) {
                this.f35503a.request.logv("spdy not available");
                this.f35504b.setParent(SpdyMiddleware.super.getSocket(this.f35503a));
            } else if (exc != null) {
                if (this.f35504b.setComplete()) {
                    this.f35503a.connectCallback.onConnectCompleted(exc, null);
                }
            } else {
                AsyncHttpRequest asyncHttpRequest = this.f35503a.request;
                asyncHttpRequest.logv("using existing spdy connection for host: " + this.f35503a.request.getUri().getHost());
                if (this.f35504b.setComplete()) {
                    SpdyMiddleware spdyMiddleware = SpdyMiddleware.this;
                    AsyncHttpClientMiddleware.GetSocketData getSocketData = this.f35503a;
                    spdyMiddleware.w(getSocketData, asyncSpdyConnection, getSocketData.connectCallback);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    class e implements FutureCallback<Headers> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.OnExchangeHeaderData f35506a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AsyncSpdyConnection.SpdySocket f35507b;

        e(AsyncHttpClientMiddleware.OnExchangeHeaderData onExchangeHeaderData, AsyncSpdyConnection.SpdySocket spdySocket) {
            this.f35506a = onExchangeHeaderData;
            this.f35507b = spdySocket;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, Headers headers) {
            this.f35506a.receiveHeadersCallback.onCompleted(exc);
            AsyncSpdyConnection.SpdySocket spdySocket = this.f35507b;
            this.f35506a.response.emitter(HttpUtil.getBodyDecoder(spdySocket, spdySocket.getConnection().f35452g, headers, false));
        }
    }

    /* loaded from: classes6.dex */
    class f extends TransformFuture<Headers, List<com.koushikdutta.async.http.spdy.d>> {

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.OnExchangeHeaderData f35509i;

        f(AsyncHttpClientMiddleware.OnExchangeHeaderData onExchangeHeaderData) {
            this.f35509i = onExchangeHeaderData;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(List<com.koushikdutta.async.http.spdy.d> list) throws Exception {
            Headers headers = new Headers();
            for (com.koushikdutta.async.http.spdy.d dVar : list) {
                headers.add(dVar.f35541a.j(), dVar.f35542b.j());
            }
            String[] split = headers.remove(com.koushikdutta.async.http.spdy.d.f35534d.j()).split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, 2);
            this.f35509i.response.code(Integer.parseInt(split[0]));
            if (split.length == 2) {
                this.f35509i.response.message(split[1]);
            }
            this.f35509i.response.protocol(headers.remove(com.koushikdutta.async.http.spdy.d.f35540j.j()));
            this.f35509i.response.headers(headers);
            setComplete((f) headers);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class g extends Exception {
        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    public SpdyMiddleware(AsyncHttpClient asyncHttpClient) {
        super(asyncHttpClient);
        this.f35491y = new Hashtable<>();
        addEngineConfigurator(new a());
    }

    private boolean s(AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        if (getSocketData.request.getBody() == null) {
            return true;
        }
        return false;
    }

    static byte[] t(Protocol... protocolArr) {
        ByteBuffer allocate = ByteBuffer.allocate(8192);
        for (Protocol protocol : protocolArr) {
            if (protocol != Protocol.HTTP_1_0) {
                allocate.put((byte) protocol.toString().length());
                allocate.put(protocol.toString().getBytes(Charsets.UTF_8));
            }
        }
        allocate.flip();
        return new ByteBufferList(allocate).getAllByteArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(SSLEngine sSLEngine, AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i4) {
        if (!this.f35481o && this.f35492z) {
            this.f35481o = true;
            try {
                this.f35482p = sSLEngine.getClass().getSuperclass().getDeclaredField("peerHost");
                this.f35483q = sSLEngine.getClass().getSuperclass().getDeclaredField("peerPort");
                Field declaredField = sSLEngine.getClass().getDeclaredField("sslParameters");
                this.f35484r = declaredField;
                this.f35485s = declaredField.getType().getDeclaredField("npnProtocols");
                this.f35486t = this.f35484r.getType().getDeclaredField("alpnProtocols");
                this.f35488v = this.f35484r.getType().getDeclaredField("useSni");
                this.f35487u = sSLEngine.getClass().getDeclaredField("sslNativePointer");
                String str2 = this.f35484r.getType().getPackage().getName() + ".NativeCrypto";
                Class<?> cls = Class.forName(str2, true, this.f35484r.getType().getClassLoader());
                Class<?> cls2 = Long.TYPE;
                this.f35489w = cls.getDeclaredMethod("SSL_get_npn_negotiated_protocol", cls2);
                this.f35490x = Class.forName(str2, true, this.f35484r.getType().getClassLoader()).getDeclaredMethod("SSL_get0_alpn_selected", cls2);
                this.f35482p.setAccessible(true);
                this.f35483q.setAccessible(true);
                this.f35484r.setAccessible(true);
                this.f35485s.setAccessible(true);
                this.f35486t.setAccessible(true);
                this.f35488v.setAccessible(true);
                this.f35487u.setAccessible(true);
                this.f35489w.setAccessible(true);
                this.f35490x.setAccessible(true);
            } catch (Exception unused) {
                this.f35484r = null;
                this.f35485s = null;
                this.f35486t = null;
                this.f35488v = null;
                this.f35487u = null;
                this.f35489w = null;
                this.f35490x = null;
            }
        }
        if (s(getSocketData) && this.f35484r != null) {
            try {
                byte[] t3 = t(Protocol.SPDY_3);
                this.f35482p.set(sSLEngine, str);
                this.f35483q.set(sSLEngine, Integer.valueOf(i4));
                Object obj = this.f35484r.get(sSLEngine);
                this.f35486t.set(obj, t3);
                this.f35488v.set(obj, Boolean.TRUE);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, ConnectCallback connectCallback, Exception exc, AsyncSSLSocket asyncSSLSocket) {
        h hVar = this.f35491y.get(str);
        if (hVar == null || hVar.f35511k.setComplete()) {
            connectCallback.onConnectCompleted(exc, asyncSSLSocket);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(AsyncHttpClientMiddleware.GetSocketData getSocketData, AsyncSpdyConnection asyncSpdyConnection, ConnectCallback connectCallback) {
        boolean z3;
        AsyncHttpRequest asyncHttpRequest = getSocketData.request;
        getSocketData.protocol = asyncSpdyConnection.f35452g.toString();
        AsyncHttpRequestBody body = getSocketData.request.getBody();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.koushikdutta.async.http.spdy.d(com.koushikdutta.async.http.spdy.d.f35535e, asyncHttpRequest.getMethod()));
        arrayList.add(new com.koushikdutta.async.http.spdy.d(com.koushikdutta.async.http.spdy.d.f35536f, y(asyncHttpRequest.getUri())));
        String str = asyncHttpRequest.getHeaders().get("Host");
        Protocol protocol = Protocol.SPDY_3;
        Protocol protocol2 = asyncSpdyConnection.f35452g;
        if (protocol == protocol2) {
            arrayList.add(new com.koushikdutta.async.http.spdy.d(com.koushikdutta.async.http.spdy.d.f35540j, "HTTP/1.1"));
            arrayList.add(new com.koushikdutta.async.http.spdy.d(com.koushikdutta.async.http.spdy.d.f35539i, str));
        } else if (Protocol.HTTP_2 == protocol2) {
            arrayList.add(new com.koushikdutta.async.http.spdy.d(com.koushikdutta.async.http.spdy.d.f35538h, str));
        } else {
            throw new AssertionError();
        }
        arrayList.add(new com.koushikdutta.async.http.spdy.d(com.koushikdutta.async.http.spdy.d.f35537g, asyncHttpRequest.getUri().getScheme()));
        Multimap multiMap = asyncHttpRequest.getHeaders().getMultiMap();
        for (String str2 : multiMap.keySet()) {
            if (!l.a(asyncSpdyConnection.f35452g, str2)) {
                for (String str3 : multiMap.get(str2)) {
                    arrayList.add(new com.koushikdutta.async.http.spdy.d(str2.toLowerCase(Locale.US), str3));
                }
            }
        }
        asyncHttpRequest.logv("\n" + asyncHttpRequest);
        if (body != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        connectCallback.onConnectCompleted(null, asyncSpdyConnection.newStream(arrayList, z3, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str) {
        h remove = this.f35491y.remove(str);
        if (remove != null) {
            remove.setComplete((Exception) A);
        }
    }

    private static String y(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        if (encodedPath == null) {
            encodedPath = RemoteSettings.FORWARD_SLASH_STRING;
        } else if (!encodedPath.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            encodedPath = RemoteSettings.FORWARD_SLASH_STRING + encodedPath;
        }
        if (!TextUtils.isEmpty(uri.getEncodedQuery())) {
            return encodedPath + TypeDescription.Generic.OfWildcardType.SYMBOL + uri.getEncodedQuery();
        }
        return encodedPath;
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public boolean exchangeHeaders(AsyncHttpClientMiddleware.OnExchangeHeaderData onExchangeHeaderData) {
        if (!(onExchangeHeaderData.socket instanceof AsyncSpdyConnection.SpdySocket)) {
            return super.exchangeHeaders(onExchangeHeaderData);
        }
        if (onExchangeHeaderData.request.getBody() != null) {
            onExchangeHeaderData.response.sink(onExchangeHeaderData.socket);
        }
        onExchangeHeaderData.sendHeadersCallback.onCompleted(null);
        AsyncSpdyConnection.SpdySocket spdySocket = (AsyncSpdyConnection.SpdySocket) onExchangeHeaderData.socket;
        ((f) spdySocket.headers().then(new f(onExchangeHeaderData))).setCallback((FutureCallback) new e(onExchangeHeaderData, spdySocket));
        return true;
    }

    @Override // com.koushikdutta.async.http.AsyncSocketMiddleware, com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public Cancellable getSocket(AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        Uri uri = getSocketData.request.getUri();
        int schemePort = getSchemePort(getSocketData.request.getUri());
        if (schemePort == -1) {
            return null;
        }
        if (!this.f35492z) {
            return super.getSocket(getSocketData);
        }
        if (!s(getSocketData)) {
            return super.getSocket(getSocketData);
        }
        String str = uri.getHost() + schemePort;
        h hVar = this.f35491y.get(str);
        if (hVar != null) {
            if (hVar.tryGetException() instanceof g) {
                return super.getSocket(getSocketData);
            }
            if (hVar.tryGet() != null && !hVar.tryGet().f35446a.isOpen()) {
                this.f35491y.remove(str);
                hVar = null;
            }
        }
        if (hVar == null) {
            getSocketData.state.put("spdykey", str);
            Cancellable socket = super.getSocket(getSocketData);
            if (!socket.isDone() && !socket.isCancelled()) {
                h hVar2 = new h(null);
                this.f35491y.put(str, hVar2);
                return hVar2.f35511k;
            }
            return socket;
        }
        getSocketData.request.logv("waiting for potential spdy connection for host: " + getSocketData.request.getUri().getHost());
        SimpleCancellable simpleCancellable = new SimpleCancellable();
        hVar.setCallback((FutureCallback) new d(getSocketData, simpleCancellable));
        return simpleCancellable;
    }

    public boolean getSpdyEnabled() {
        return this.f35492z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.http.AsyncSSLSocketMiddleware, com.koushikdutta.async.http.AsyncSocketMiddleware
    public ConnectCallback j(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i4, boolean z3, ConnectCallback connectCallback) {
        ConnectCallback j4 = super.j(getSocketData, uri, i4, z3, connectCallback);
        String str = (String) getSocketData.state.get("spdykey");
        if (str == null) {
            return j4;
        }
        return new c(str, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.http.AsyncSSLSocketMiddleware
    public AsyncSSLSocketWrapper.HandshakeCallback l(AsyncHttpClientMiddleware.GetSocketData getSocketData, ConnectCallback connectCallback) {
        String str = (String) getSocketData.state.get("spdykey");
        if (str == null) {
            return super.l(getSocketData, connectCallback);
        }
        return new b(getSocketData, str, connectCallback);
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onRequestSent(AsyncHttpClientMiddleware.OnRequestSentData onRequestSentData) {
        if ((onRequestSentData.socket instanceof AsyncSpdyConnection.SpdySocket) && onRequestSentData.request.getBody() != null) {
            onRequestSentData.response.sink().end();
        }
    }

    @Override // com.koushikdutta.async.http.AsyncSSLSocketMiddleware
    public void setSSLContext(SSLContext sSLContext) {
        super.setSSLContext(sSLContext);
        this.f35481o = false;
    }

    public void setSpdyEnabled(boolean z3) {
        this.f35492z = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class h extends MultiFuture<AsyncSpdyConnection> {

        /* renamed from: k  reason: collision with root package name */
        SimpleCancellable f35511k;

        private h() {
            this.f35511k = new SimpleCancellable();
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }
}
