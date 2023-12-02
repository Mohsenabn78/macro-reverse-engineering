package com.koushikdutta.async.http;

import android.net.Uri;
import com.koushikdutta.async.ArrayDeque;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Continuation;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Hashtable;
import java.util.Locale;

/* loaded from: classes6.dex */
public class AsyncSocketMiddleware extends SimpleMiddleware {

    /* renamed from: a  reason: collision with root package name */
    String f34990a;

    /* renamed from: b  reason: collision with root package name */
    int f34991b;

    /* renamed from: c  reason: collision with root package name */
    int f34992c;

    /* renamed from: d  reason: collision with root package name */
    protected AsyncHttpClient f34993d;

    /* renamed from: e  reason: collision with root package name */
    boolean f34994e;

    /* renamed from: f  reason: collision with root package name */
    String f34995f;

    /* renamed from: g  reason: collision with root package name */
    int f34996g;

    /* renamed from: h  reason: collision with root package name */
    InetSocketAddress f34997h;

    /* renamed from: i  reason: collision with root package name */
    Hashtable<String, e> f34998i;

    /* renamed from: j  reason: collision with root package name */
    int f34999j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends TransformFuture<AsyncSocket, InetAddress[]> {

        /* renamed from: i  reason: collision with root package name */
        Exception f35000i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.GetSocketData f35001j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Uri f35002k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ int f35003l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.koushikdutta.async.http.AsyncSocketMiddleware$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0185a implements CompletedCallback {
            C0185a() {
            }

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                a aVar = a.this;
                if (aVar.f35000i == null) {
                    aVar.f35000i = new ConnectionFailedException("Unable to connect to remote address");
                }
                a aVar2 = a.this;
                if (aVar2.setComplete(aVar2.f35000i)) {
                    a aVar3 = a.this;
                    AsyncSocketMiddleware asyncSocketMiddleware = AsyncSocketMiddleware.this;
                    AsyncHttpClientMiddleware.GetSocketData getSocketData = aVar3.f35001j;
                    asyncSocketMiddleware.j(getSocketData, aVar3.f35002k, aVar3.f35003l, false, getSocketData.connectCallback).onConnectCompleted(a.this.f35000i, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class b implements ContinuationCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f35006a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ InetAddress f35007b;

            /* renamed from: com.koushikdutta.async.http.AsyncSocketMiddleware$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            class C0186a implements ConnectCallback {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ CompletedCallback f35009a;

                C0186a(CompletedCallback completedCallback) {
                    this.f35009a = completedCallback;
                }

                @Override // com.koushikdutta.async.callback.ConnectCallback
                public void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                    if (a.this.isDone()) {
                        a aVar = a.this;
                        aVar.f35000i = new Exception("internal error during connect to " + b.this.f35006a);
                        this.f35009a.onCompleted(null);
                    } else if (exc != null) {
                        a.this.f35000i = exc;
                        this.f35009a.onCompleted(null);
                    } else if (!a.this.isDone() && !a.this.isCancelled()) {
                        if (a.this.setComplete(null, asyncSocket)) {
                            a.this.f35001j.connectCallback.onConnectCompleted(null, asyncSocket);
                        }
                    } else {
                        a.this.f35001j.request.logd("Recycling extra socket leftover from cancelled operation");
                        AsyncSocketMiddleware.this.f(asyncSocket);
                        a aVar2 = a.this;
                        AsyncSocketMiddleware.this.i(asyncSocket, aVar2.f35001j.request);
                    }
                }
            }

            b(String str, InetAddress inetAddress) {
                this.f35006a = str;
                this.f35007b = inetAddress;
            }

            @Override // com.koushikdutta.async.callback.ContinuationCallback
            public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
                AsyncHttpRequest asyncHttpRequest = a.this.f35001j.request;
                asyncHttpRequest.logv("attempting connection to " + this.f35006a);
                AsyncServer server = AsyncSocketMiddleware.this.f34993d.getServer();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f35007b, a.this.f35003l);
                a aVar = a.this;
                server.connectSocket(inetSocketAddress, AsyncSocketMiddleware.this.j(aVar.f35001j, aVar.f35002k, aVar.f35003l, false, new C0186a(completedCallback)));
            }
        }

        a(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i4) {
            this.f35001j = getSocketData;
            this.f35002k = uri;
            this.f35003l = i4;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        public void j(Exception exc) {
            super.j(exc);
            AsyncSocketMiddleware asyncSocketMiddleware = AsyncSocketMiddleware.this;
            AsyncHttpClientMiddleware.GetSocketData getSocketData = this.f35001j;
            asyncSocketMiddleware.j(getSocketData, this.f35002k, this.f35003l, false, getSocketData.connectCallback).onConnectCompleted(exc, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(InetAddress[] inetAddressArr) throws Exception {
            Continuation continuation = new Continuation(new C0185a());
            for (InetAddress inetAddress : inetAddressArr) {
                continuation.add(new b(String.format(Locale.ENGLISH, "%s:%s", inetAddress, Integer.valueOf(this.f35003l)), inetAddress));
            }
            continuation.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayDeque f35011a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f35012b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f35013c;

        b(ArrayDeque arrayDeque, f fVar, String str) {
            this.f35011a = arrayDeque;
            this.f35012b = fVar;
            this.f35013c = str;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            synchronized (AsyncSocketMiddleware.this) {
                this.f35011a.remove(this.f35012b);
                AsyncSocketMiddleware.this.g(this.f35013c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncSocket f35015a;

        c(AsyncSocket asyncSocket) {
            this.f35015a = asyncSocket;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            this.f35015a.setClosedCallback(null);
            this.f35015a.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d extends DataCallback.NullDataCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncSocket f35017a;

        d(AsyncSocket asyncSocket) {
            this.f35017a = asyncSocket;
        }

        @Override // com.koushikdutta.async.callback.DataCallback.NullDataCallback, com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            super.onDataAvailable(dataEmitter, byteBufferList);
            byteBufferList.recycle();
            this.f35017a.setClosedCallback(null);
            this.f35017a.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        int f35019a;

        /* renamed from: b  reason: collision with root package name */
        ArrayDeque<AsyncHttpClientMiddleware.GetSocketData> f35020b = new ArrayDeque<>();

        /* renamed from: c  reason: collision with root package name */
        ArrayDeque<f> f35021c = new ArrayDeque<>();

        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        AsyncSocket f35022a;

        /* renamed from: b  reason: collision with root package name */
        long f35023b = System.currentTimeMillis();

        public f(AsyncSocket asyncSocket) {
            this.f35022a = asyncSocket;
        }
    }

    public AsyncSocketMiddleware(AsyncHttpClient asyncHttpClient, String str, int i4) {
        this.f34992c = 300000;
        this.f34998i = new Hashtable<>();
        this.f34999j = Integer.MAX_VALUE;
        this.f34993d = asyncHttpClient;
        this.f34990a = str;
        this.f34991b = i4;
    }

    private e e(String str) {
        e eVar = this.f34998i.get(str);
        if (eVar == null) {
            e eVar2 = new e();
            this.f34998i.put(str, eVar2);
            return eVar2;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AsyncSocket asyncSocket) {
        asyncSocket.setEndCallback(new c(asyncSocket));
        asyncSocket.setWriteableCallback(null);
        asyncSocket.setDataCallback(new d(asyncSocket));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        e eVar = this.f34998i.get(str);
        if (eVar == null) {
            return;
        }
        while (!eVar.f35021c.isEmpty()) {
            f peekLast = eVar.f35021c.peekLast();
            AsyncSocket asyncSocket = peekLast.f35022a;
            if (peekLast.f35023b + this.f34992c > System.currentTimeMillis()) {
                break;
            }
            eVar.f35021c.pop();
            asyncSocket.setClosedCallback(null);
            asyncSocket.close();
        }
        if (eVar.f35019a == 0 && eVar.f35020b.isEmpty() && eVar.f35021c.isEmpty()) {
            this.f34998i.remove(str);
        }
    }

    private void h(AsyncHttpRequest asyncHttpRequest) {
        Uri uri = asyncHttpRequest.getUri();
        String d4 = d(uri, getSchemePort(uri), asyncHttpRequest.getProxyHost(), asyncHttpRequest.getProxyPort());
        synchronized (this) {
            e eVar = this.f34998i.get(d4);
            if (eVar == null) {
                return;
            }
            eVar.f35019a--;
            while (eVar.f35019a < this.f34999j && eVar.f35020b.size() > 0) {
                AsyncHttpClientMiddleware.GetSocketData remove = eVar.f35020b.remove();
                SimpleCancellable simpleCancellable = (SimpleCancellable) remove.socketCancellable;
                if (!simpleCancellable.isCancelled()) {
                    simpleCancellable.setParent(getSocket(remove));
                }
            }
            g(d4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AsyncSocket asyncSocket, AsyncHttpRequest asyncHttpRequest) {
        ArrayDeque<f> arrayDeque;
        if (asyncSocket == null) {
            return;
        }
        Uri uri = asyncHttpRequest.getUri();
        String d4 = d(uri, getSchemePort(uri), asyncHttpRequest.getProxyHost(), asyncHttpRequest.getProxyPort());
        f fVar = new f(asyncSocket);
        synchronized (this) {
            arrayDeque = e(d4).f35021c;
            arrayDeque.push(fVar);
        }
        asyncSocket.setClosedCallback(new b(arrayDeque, fVar, d4));
    }

    String d(Uri uri, int i4, String str, int i5) {
        String str2;
        if (str != null) {
            str2 = str + ":" + i5;
        } else {
            str2 = "";
        }
        if (str != null) {
            str2 = str + ":" + i5;
        }
        return uri.getScheme() + "//" + uri.getHost() + ":" + i4 + "?proxy=" + str2;
    }

    public void disableProxy() {
        this.f34996g = -1;
        this.f34995f = null;
        this.f34997h = null;
    }

    public void enableProxy(String str, int i4) {
        this.f34995f = str;
        this.f34996g = i4;
        this.f34997h = null;
    }

    public boolean getConnectAllAddresses() {
        return this.f34994e;
    }

    public int getMaxConnectionCount() {
        return this.f34999j;
    }

    public int getSchemePort(Uri uri) {
        if (uri.getScheme() == null || !uri.getScheme().equals(this.f34990a)) {
            return -1;
        }
        if (uri.getPort() == -1) {
            return this.f34991b;
        }
        return uri.getPort();
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public Cancellable getSocket(AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        String host;
        int i4;
        String str;
        Uri uri = getSocketData.request.getUri();
        int schemePort = getSchemePort(getSocketData.request.getUri());
        if (schemePort == -1) {
            return null;
        }
        getSocketData.state.put("socket-owner", this);
        e e4 = e(d(uri, schemePort, getSocketData.request.getProxyHost(), getSocketData.request.getProxyPort()));
        synchronized (this) {
            int i5 = e4.f35019a;
            if (i5 >= this.f34999j) {
                SimpleCancellable simpleCancellable = new SimpleCancellable();
                e4.f35020b.add(getSocketData);
                return simpleCancellable;
            }
            boolean z3 = true;
            e4.f35019a = i5 + 1;
            while (!e4.f35021c.isEmpty()) {
                f pop = e4.f35021c.pop();
                AsyncSocket asyncSocket = pop.f35022a;
                if (pop.f35023b + this.f34992c < System.currentTimeMillis()) {
                    asyncSocket.setClosedCallback(null);
                    asyncSocket.close();
                } else if (asyncSocket.isOpen()) {
                    getSocketData.request.logd("Reusing keep-alive socket");
                    getSocketData.connectCallback.onConnectCompleted(null, asyncSocket);
                    SimpleCancellable simpleCancellable2 = new SimpleCancellable();
                    simpleCancellable2.setComplete();
                    return simpleCancellable2;
                }
            }
            if (this.f34994e && this.f34995f == null && getSocketData.request.getProxyHost() == null) {
                getSocketData.request.logv("Resolving domain and connecting to all available addresses");
                return (Cancellable) this.f34993d.getServer().getAllByName(uri.getHost()).then(new a(getSocketData, uri, schemePort));
            }
            getSocketData.request.logd("Connecting socket");
            if (getSocketData.request.getProxyHost() == null && (str = this.f34995f) != null) {
                getSocketData.request.enableProxy(str, this.f34996g);
            }
            if (getSocketData.request.getProxyHost() != null) {
                host = getSocketData.request.getProxyHost();
                i4 = getSocketData.request.getProxyPort();
            } else {
                host = uri.getHost();
                i4 = schemePort;
                z3 = false;
            }
            if (z3) {
                AsyncHttpRequest asyncHttpRequest = getSocketData.request;
                asyncHttpRequest.logv("Using proxy: " + host + ":" + i4);
            }
            return this.f34993d.getServer().connectSocket(host, i4, j(getSocketData, uri, schemePort, z3, getSocketData.connectCallback));
        }
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onResponseComplete(AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData) {
        if (onResponseCompleteDataOnRequestSentData.state.get("socket-owner") != this) {
            return;
        }
        try {
            f(onResponseCompleteDataOnRequestSentData.socket);
            if (onResponseCompleteDataOnRequestSentData.exception == null && onResponseCompleteDataOnRequestSentData.socket.isOpen()) {
                if (HttpUtil.isKeepAlive(onResponseCompleteDataOnRequestSentData.response.protocol(), onResponseCompleteDataOnRequestSentData.response.headers()) && HttpUtil.isKeepAlive(Protocol.HTTP_1_1, onResponseCompleteDataOnRequestSentData.request.getHeaders())) {
                    onResponseCompleteDataOnRequestSentData.request.logd("Recycling keep-alive socket");
                    i(onResponseCompleteDataOnRequestSentData.socket, onResponseCompleteDataOnRequestSentData.request);
                    return;
                }
                onResponseCompleteDataOnRequestSentData.request.logv("closing out socket (not keep alive)");
                onResponseCompleteDataOnRequestSentData.socket.setClosedCallback(null);
                onResponseCompleteDataOnRequestSentData.socket.close();
            }
            onResponseCompleteDataOnRequestSentData.request.logv("closing out socket (exception)");
            onResponseCompleteDataOnRequestSentData.socket.setClosedCallback(null);
            onResponseCompleteDataOnRequestSentData.socket.close();
        } finally {
            h(onResponseCompleteDataOnRequestSentData.request);
        }
    }

    public void setConnectAllAddresses(boolean z3) {
        this.f34994e = z3;
    }

    public void setIdleTimeoutMs(int i4) {
        this.f34992c = i4;
    }

    public void setMaxConnectionCount(int i4) {
        this.f34999j = i4;
    }

    public AsyncSocketMiddleware(AsyncHttpClient asyncHttpClient) {
        this(asyncHttpClient, "http", 80);
    }

    protected ConnectCallback j(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i4, boolean z3, ConnectCallback connectCallback) {
        return connectCallback;
    }
}
