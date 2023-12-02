package com.koushikdutta.async.http;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLException;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import com.koushikdutta.async.http.callback.RequestCallback;
import com.koushikdutta.async.http.spdy.SpdyMiddleware;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.parser.JSONArrayParser;
import com.koushikdutta.async.parser.JSONObjectParser;
import com.koushikdutta.async.parser.StringParser;
import com.koushikdutta.async.stream.OutputStreamDataCallback;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class AsyncHttpClient {

    /* renamed from: f  reason: collision with root package name */
    private static AsyncHttpClient f34893f;

    /* renamed from: a  reason: collision with root package name */
    final List<AsyncHttpClientMiddleware> f34894a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    SpdyMiddleware f34895b;

    /* renamed from: c  reason: collision with root package name */
    AsyncSocketMiddleware f34896c;

    /* renamed from: d  reason: collision with root package name */
    HttpTransportMiddleware f34897d;

    /* renamed from: e  reason: collision with root package name */
    AsyncServer f34898e;

    /* loaded from: classes6.dex */
    public static abstract class DownloadCallback extends RequestCallbackBase<ByteBufferList> {
    }

    /* loaded from: classes6.dex */
    public static abstract class FileCallback extends RequestCallbackBase<File> {
    }

    /* loaded from: classes6.dex */
    public static abstract class JSONArrayCallback extends RequestCallbackBase<JSONArray> {
    }

    /* loaded from: classes6.dex */
    public static abstract class JSONObjectCallback extends RequestCallbackBase<JSONObject> {
    }

    /* loaded from: classes6.dex */
    public static abstract class StringCallback extends RequestCallbackBase<String> {
    }

    /* loaded from: classes6.dex */
    public interface WebSocketConnectCallback {
        void onCompleted(Exception exc, WebSocket webSocket);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements HttpConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestCallback f34899a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f34900b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AsyncParser f34901c;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* renamed from: com.koushikdutta.async.http.AsyncHttpClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0182a<T> implements FutureCallback<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AsyncHttpResponse f34903a;

            C0182a(AsyncHttpResponse asyncHttpResponse) {
                this.f34903a = asyncHttpResponse;
            }

            @Override // com.koushikdutta.async.future.FutureCallback
            public void onCompleted(Exception exc, T t3) {
                a aVar = a.this;
                AsyncHttpClient.this.q(aVar.f34899a, aVar.f34900b, this.f34903a, exc, t3);
            }
        }

        a(RequestCallback requestCallback, SimpleFuture simpleFuture, AsyncParser asyncParser) {
            this.f34899a = requestCallback;
            this.f34900b = simpleFuture;
            this.f34901c = asyncParser;
        }

        @Override // com.koushikdutta.async.http.callback.HttpConnectCallback
        public void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
            if (exc != null) {
                AsyncHttpClient.this.q(this.f34899a, this.f34900b, asyncHttpResponse, exc, null);
                return;
            }
            AsyncHttpClient.this.r(this.f34899a, asyncHttpResponse);
            this.f34900b.setParent((Cancellable) this.f34901c.parse(asyncHttpResponse).setCallback(new C0182a(asyncHttpResponse)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements HttpConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f34905a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WebSocketConnectCallback f34906b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f34907c;

        b(SimpleFuture simpleFuture, WebSocketConnectCallback webSocketConnectCallback, AsyncHttpRequest asyncHttpRequest) {
            this.f34905a = simpleFuture;
            this.f34906b = webSocketConnectCallback;
            this.f34907c = asyncHttpRequest;
        }

        @Override // com.koushikdutta.async.http.callback.HttpConnectCallback
        public void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
            WebSocketConnectCallback webSocketConnectCallback;
            if (exc != null) {
                if (this.f34905a.setComplete(exc) && (webSocketConnectCallback = this.f34906b) != null) {
                    webSocketConnectCallback.onCompleted(exc, null);
                    return;
                }
                return;
            }
            WebSocket finishHandshake = WebSocketImpl.finishHandshake(this.f34907c.getHeaders(), asyncHttpResponse);
            if (finishHandshake == null) {
                exc = new WebSocketHandshakeException("Unable to complete websocket handshake");
                if (!this.f34905a.setComplete(exc)) {
                    return;
                }
            } else if (!this.f34905a.setComplete((SimpleFuture) finishHandshake)) {
                return;
            }
            WebSocketConnectCallback webSocketConnectCallback2 = this.f34906b;
            if (webSocketConnectCallback2 != null) {
                webSocketConnectCallback2.onCompleted(exc, finishHandshake);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f34909a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f34910b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f34911c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ HttpConnectCallback f34912d;

        c(AsyncHttpRequest asyncHttpRequest, int i4, l lVar, HttpConnectCallback httpConnectCallback) {
            this.f34909a = asyncHttpRequest;
            this.f34910b = i4;
            this.f34911c = lVar;
            this.f34912d = httpConnectCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncHttpClient.this.n(this.f34909a, this.f34910b, this.f34911c, this.f34912d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData f34914a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f34915b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f34916c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ HttpConnectCallback f34917d;

        d(AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData, l lVar, AsyncHttpRequest asyncHttpRequest, HttpConnectCallback httpConnectCallback) {
            this.f34914a = onResponseCompleteDataOnRequestSentData;
            this.f34915b = lVar;
            this.f34916c = asyncHttpRequest;
            this.f34917d = httpConnectCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Cancellable cancellable = this.f34914a.socketCancellable;
            if (cancellable != null) {
                cancellable.cancel();
                AsyncSocket asyncSocket = this.f34914a.socket;
                if (asyncSocket != null) {
                    asyncSocket.close();
                }
            }
            AsyncHttpClient.this.u(this.f34915b, new TimeoutException(), null, this.f34916c, this.f34917d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements ConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        boolean f34919a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f34920b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f34921c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ HttpConnectCallback f34922d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData f34923e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f34924f;

        e(AsyncHttpRequest asyncHttpRequest, l lVar, HttpConnectCallback httpConnectCallback, AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData, int i4) {
            this.f34920b = asyncHttpRequest;
            this.f34921c = lVar;
            this.f34922d = httpConnectCallback;
            this.f34923e = onResponseCompleteDataOnRequestSentData;
            this.f34924f = i4;
        }

        @Override // com.koushikdutta.async.callback.ConnectCallback
        public void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
            if (this.f34919a && asyncSocket != null) {
                asyncSocket.setDataCallback(new DataCallback.NullDataCallback());
                asyncSocket.setEndCallback(new CompletedCallback.NullCompletedCallback());
                asyncSocket.close();
                throw new AssertionError("double connect callback");
            }
            this.f34919a = true;
            this.f34920b.logv("socket connected");
            if (this.f34921c.isCancelled()) {
                if (asyncSocket != null) {
                    asyncSocket.close();
                    return;
                }
                return;
            }
            l lVar = this.f34921c;
            if (lVar.f34959k != null) {
                AsyncHttpClient.this.f34898e.removeAllCallbacks(lVar.f34958j);
            }
            if (exc != null) {
                AsyncHttpClient.this.u(this.f34921c, exc, null, this.f34920b, this.f34922d);
                return;
            }
            AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData = this.f34923e;
            onResponseCompleteDataOnRequestSentData.socket = asyncSocket;
            l lVar2 = this.f34921c;
            lVar2.f34957i = asyncSocket;
            AsyncHttpClient.this.o(this.f34920b, this.f34924f, lVar2, this.f34922d, onResponseCompleteDataOnRequestSentData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f extends com.koushikdutta.async.http.a {

        /* renamed from: r  reason: collision with root package name */
        final /* synthetic */ l f34926r;

        /* renamed from: s  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f34927s;

        /* renamed from: t  reason: collision with root package name */
        final /* synthetic */ HttpConnectCallback f34928t;

        /* renamed from: u  reason: collision with root package name */
        final /* synthetic */ AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData f34929u;

        /* renamed from: v  reason: collision with root package name */
        final /* synthetic */ int f34930v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AsyncHttpRequest asyncHttpRequest, l lVar, AsyncHttpRequest asyncHttpRequest2, HttpConnectCallback httpConnectCallback, AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData, int i4) {
            super(asyncHttpRequest);
            this.f34926r = lVar;
            this.f34927s = asyncHttpRequest2;
            this.f34928t = httpConnectCallback;
            this.f34929u = onResponseCompleteDataOnRequestSentData;
            this.f34930v = i4;
        }

        @Override // com.koushikdutta.async.http.a, com.koushikdutta.async.DataEmitterBase
        protected void a(Exception exc) {
            if (exc != null) {
                this.f34927s.loge("exception during response", exc);
            }
            if (this.f34926r.isCancelled()) {
                return;
            }
            if (exc instanceof AsyncSSLException) {
                this.f34927s.loge("SSL Exception", exc);
                AsyncSSLException asyncSSLException = (AsyncSSLException) exc;
                this.f34927s.onHandshakeException(asyncSSLException);
                if (asyncSSLException.getIgnore()) {
                    return;
                }
            }
            AsyncSocket socket = socket();
            if (socket == null) {
                return;
            }
            super.a(exc);
            if ((!socket.isOpen() || exc != null) && headers() == null && exc != null) {
                AsyncHttpClient.this.u(this.f34926r, exc, null, this.f34927s, this.f34928t);
            }
            this.f34929u.exception = exc;
            for (AsyncHttpClientMiddleware asyncHttpClientMiddleware : AsyncHttpClient.this.f34894a) {
                asyncHttpClientMiddleware.onResponseComplete(this.f34929u);
            }
        }

        @Override // com.koushikdutta.async.http.a
        protected void d() {
            super.d();
            if (this.f34926r.isCancelled()) {
                return;
            }
            l lVar = this.f34926r;
            if (lVar.f34959k != null) {
                AsyncHttpClient.this.f34898e.removeAllCallbacks(lVar.f34958j);
            }
            AsyncHttpRequest asyncHttpRequest = this.f34927s;
            asyncHttpRequest.logv("Received headers:\n" + toString());
            for (AsyncHttpClientMiddleware asyncHttpClientMiddleware : AsyncHttpClient.this.f34894a) {
                asyncHttpClientMiddleware.onHeadersReceived(this.f34929u);
            }
        }

        @Override // com.koushikdutta.async.http.AsyncHttpResponse
        public AsyncSocket detachSocket() {
            this.f34927s.logd("Detaching socket");
            AsyncSocket socket = socket();
            if (socket == null) {
                return null;
            }
            socket.setWriteableCallback(null);
            socket.setClosedCallback(null);
            socket.setEndCallback(null);
            socket.setDataCallback(null);
            g(null);
            return socket;
        }

        @Override // com.koushikdutta.async.http.a
        protected void f(Exception exc) {
            if (exc != null) {
                AsyncHttpClient.this.u(this.f34926r, exc, null, this.f34927s, this.f34928t);
                return;
            }
            this.f34927s.logv("request completed");
            if (this.f34926r.isCancelled()) {
                return;
            }
            l lVar = this.f34926r;
            if (lVar.f34959k != null && this.f35091k == null) {
                AsyncHttpClient.this.f34898e.removeAllCallbacks(lVar.f34958j);
                l lVar2 = this.f34926r;
                lVar2.f34958j = AsyncHttpClient.this.f34898e.postDelayed(lVar2.f34959k, AsyncHttpClient.p(this.f34927s));
            }
            for (AsyncHttpClientMiddleware asyncHttpClientMiddleware : AsyncHttpClient.this.f34894a) {
                asyncHttpClientMiddleware.onRequestSent(this.f34929u);
            }
        }

        @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataTrackingEmitter
        public void setDataEmitter(DataEmitter dataEmitter) {
            this.f34929u.bodyEmitter = dataEmitter;
            for (AsyncHttpClientMiddleware asyncHttpClientMiddleware : AsyncHttpClient.this.f34894a) {
                asyncHttpClientMiddleware.onBodyDecoder(this.f34929u);
            }
            super.setDataEmitter(this.f34929u.bodyEmitter);
            Headers headers = this.f35091k;
            int code = code();
            if ((code == 301 || code == 302 || code == 307) && this.f34927s.getFollowRedirect()) {
                String str = headers.get(HttpHeaders.LOCATION);
                try {
                    Uri parse = Uri.parse(str);
                    if (parse.getScheme() == null) {
                        parse = Uri.parse(new URL(new URL(this.f34927s.getUri().toString()), str).toString());
                    }
                    String str2 = "HEAD";
                    if (!this.f34927s.getMethod().equals("HEAD")) {
                        str2 = "GET";
                    }
                    AsyncHttpRequest asyncHttpRequest = new AsyncHttpRequest(parse, str2);
                    AsyncHttpRequest asyncHttpRequest2 = this.f34927s;
                    asyncHttpRequest.f34971k = asyncHttpRequest2.f34971k;
                    asyncHttpRequest.f34970j = asyncHttpRequest2.f34970j;
                    asyncHttpRequest.f34969i = asyncHttpRequest2.f34969i;
                    asyncHttpRequest.f34967g = asyncHttpRequest2.f34967g;
                    asyncHttpRequest.f34968h = asyncHttpRequest2.f34968h;
                    AsyncHttpClient.v(asyncHttpRequest);
                    AsyncHttpClient.l(this.f34927s, asyncHttpRequest, "User-Agent");
                    AsyncHttpClient.l(this.f34927s, asyncHttpRequest, HttpHeaders.RANGE);
                    this.f34927s.logi("Redirecting");
                    asyncHttpRequest.logi("Redirected");
                    AsyncHttpClient.this.m(asyncHttpRequest, this.f34930v + 1, this.f34926r, this.f34928t);
                    setDataCallback(new DataCallback.NullDataCallback());
                    return;
                } catch (Exception e4) {
                    AsyncHttpClient.this.u(this.f34926r, e4, this, this.f34927s, this.f34928t);
                    return;
                }
            }
            AsyncHttpRequest asyncHttpRequest3 = this.f34927s;
            asyncHttpRequest3.logv("Final (post cache response) headers:\n" + toString());
            AsyncHttpClient.this.u(this.f34926r, null, this, this.f34927s, this.f34928t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class g implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.koushikdutta.async.http.a f34932a;

        g(com.koushikdutta.async.http.a aVar) {
            this.f34932a = aVar;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (exc != null) {
                this.f34932a.a(exc);
            } else {
                this.f34932a.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.koushikdutta.async.http.a f34934a;

        h(com.koushikdutta.async.http.a aVar) {
            this.f34934a = aVar;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (exc != null) {
                this.f34934a.a(exc);
            } else {
                this.f34934a.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestCallback f34936a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f34937b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AsyncHttpResponse f34938c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Exception f34939d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f34940e;

        i(RequestCallback requestCallback, SimpleFuture simpleFuture, AsyncHttpResponse asyncHttpResponse, Exception exc, Object obj) {
            this.f34936a = requestCallback;
            this.f34937b = simpleFuture;
            this.f34938c = asyncHttpResponse;
            this.f34939d = exc;
            this.f34940e = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncHttpClient.this.t(this.f34936a, this.f34937b, this.f34938c, this.f34939d, this.f34940e);
        }
    }

    /* loaded from: classes6.dex */
    class j extends SimpleFuture<File> {

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ l f34942i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ OutputStream f34943j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ File f34944k;

        j(l lVar, OutputStream outputStream, File file) {
            this.f34942i = lVar;
            this.f34943j = outputStream;
            this.f34944k = file;
        }

        @Override // com.koushikdutta.async.future.SimpleCancellable
        public void a() {
            try {
                this.f34942i.get().setDataCallback(new DataCallback.NullDataCallback());
                this.f34942i.get().close();
            } catch (Exception unused) {
            }
            try {
                this.f34943j.close();
            } catch (Exception unused2) {
            }
            this.f34944k.delete();
        }
    }

    /* loaded from: classes6.dex */
    class k implements HttpConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        long f34946a = 0;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OutputStream f34947b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f34948c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FileCallback f34949d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f34950e;

        /* loaded from: classes6.dex */
        class a extends OutputStreamDataCallback {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AsyncHttpResponse f34952b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ long f34953c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(OutputStream outputStream, AsyncHttpResponse asyncHttpResponse, long j4) {
                super(outputStream);
                this.f34952b = asyncHttpResponse;
                this.f34953c = j4;
            }

            @Override // com.koushikdutta.async.stream.OutputStreamDataCallback, com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                k.this.f34946a += byteBufferList.remaining();
                super.onDataAvailable(dataEmitter, byteBufferList);
                k kVar = k.this;
                AsyncHttpClient.this.s(kVar.f34949d, this.f34952b, kVar.f34946a, this.f34953c);
            }
        }

        /* loaded from: classes6.dex */
        class b implements CompletedCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AsyncHttpResponse f34955a;

            b(AsyncHttpResponse asyncHttpResponse) {
                this.f34955a = asyncHttpResponse;
            }

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception e4) {
                try {
                    k.this.f34947b.close();
                } catch (IOException e5) {
                    e4 = e5;
                }
                Exception exc = e4;
                if (exc != null) {
                    k.this.f34948c.delete();
                    k kVar = k.this;
                    AsyncHttpClient.this.q(kVar.f34949d, kVar.f34950e, this.f34955a, exc, null);
                    return;
                }
                k kVar2 = k.this;
                AsyncHttpClient.this.q(kVar2.f34949d, kVar2.f34950e, this.f34955a, null, kVar2.f34948c);
            }
        }

        k(OutputStream outputStream, File file, FileCallback fileCallback, SimpleFuture simpleFuture) {
            this.f34947b = outputStream;
            this.f34948c = file;
            this.f34949d = fileCallback;
            this.f34950e = simpleFuture;
        }

        @Override // com.koushikdutta.async.http.callback.HttpConnectCallback
        public void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
            if (exc == null) {
                AsyncHttpClient.this.r(this.f34949d, asyncHttpResponse);
                asyncHttpResponse.setDataCallback(new a(this.f34947b, asyncHttpResponse, HttpUtil.contentLength(asyncHttpResponse.headers())));
                asyncHttpResponse.setEndCallback(new b(asyncHttpResponse));
                return;
            }
            try {
                this.f34947b.close();
            } catch (IOException unused) {
            }
            this.f34948c.delete();
            AsyncHttpClient.this.q(this.f34949d, this.f34950e, asyncHttpResponse, exc, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class l extends SimpleFuture<AsyncHttpResponse> {

        /* renamed from: i  reason: collision with root package name */
        public AsyncSocket f34957i;

        /* renamed from: j  reason: collision with root package name */
        public Object f34958j;

        /* renamed from: k  reason: collision with root package name */
        public Runnable f34959k;

        private l() {
        }

        @Override // com.koushikdutta.async.future.SimpleFuture, com.koushikdutta.async.future.SimpleCancellable, com.koushikdutta.async.future.Cancellable
        public boolean cancel() {
            if (!super.cancel()) {
                return false;
            }
            AsyncSocket asyncSocket = this.f34957i;
            if (asyncSocket != null) {
                asyncSocket.setDataCallback(new DataCallback.NullDataCallback());
                this.f34957i.close();
            }
            Object obj = this.f34958j;
            if (obj != null) {
                AsyncHttpClient.this.f34898e.removeAllCallbacks(obj);
                return true;
            }
            return true;
        }

        /* synthetic */ l(AsyncHttpClient asyncHttpClient, c cVar) {
            this();
        }
    }

    public AsyncHttpClient(AsyncServer asyncServer) {
        this.f34898e = asyncServer;
        AsyncSocketMiddleware asyncSocketMiddleware = new AsyncSocketMiddleware(this);
        this.f34896c = asyncSocketMiddleware;
        insertMiddleware(asyncSocketMiddleware);
        SpdyMiddleware spdyMiddleware = new SpdyMiddleware(this);
        this.f34895b = spdyMiddleware;
        insertMiddleware(spdyMiddleware);
        HttpTransportMiddleware httpTransportMiddleware = new HttpTransportMiddleware();
        this.f34897d = httpTransportMiddleware;
        insertMiddleware(httpTransportMiddleware);
        this.f34895b.addEngineConfigurator(new SSLEngineSNIConfigurator());
    }

    public static AsyncHttpClient getDefaultInstance() {
        if (f34893f == null) {
            f34893f = new AsyncHttpClient(AsyncServer.getDefault());
        }
        return f34893f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(AsyncHttpRequest asyncHttpRequest, AsyncHttpRequest asyncHttpRequest2, String str) {
        String str2 = asyncHttpRequest.getHeaders().get(str);
        if (!TextUtils.isEmpty(str2)) {
            asyncHttpRequest2.getHeaders().set(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AsyncHttpRequest asyncHttpRequest, int i4, l lVar, HttpConnectCallback httpConnectCallback) {
        if (this.f34898e.isAffinityThread()) {
            n(asyncHttpRequest, i4, lVar, httpConnectCallback);
        } else {
            this.f34898e.post(new c(asyncHttpRequest, i4, lVar, httpConnectCallback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AsyncHttpRequest asyncHttpRequest, int i4, l lVar, HttpConnectCallback httpConnectCallback) {
        if (i4 > 15) {
            u(lVar, new RedirectLimitExceededException("too many redirects"), null, asyncHttpRequest, httpConnectCallback);
            return;
        }
        asyncHttpRequest.getUri();
        AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData = new AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData();
        asyncHttpRequest.f34971k = System.currentTimeMillis();
        onResponseCompleteDataOnRequestSentData.request = asyncHttpRequest;
        asyncHttpRequest.logd("Executing request.");
        for (AsyncHttpClientMiddleware asyncHttpClientMiddleware : this.f34894a) {
            asyncHttpClientMiddleware.onRequest(onResponseCompleteDataOnRequestSentData);
        }
        if (asyncHttpRequest.getTimeout() > 0) {
            d dVar = new d(onResponseCompleteDataOnRequestSentData, lVar, asyncHttpRequest, httpConnectCallback);
            lVar.f34959k = dVar;
            lVar.f34958j = this.f34898e.postDelayed(dVar, p(asyncHttpRequest));
        }
        onResponseCompleteDataOnRequestSentData.connectCallback = new e(asyncHttpRequest, lVar, httpConnectCallback, onResponseCompleteDataOnRequestSentData, i4);
        v(asyncHttpRequest);
        if (asyncHttpRequest.getBody() != null && asyncHttpRequest.getHeaders().get("Content-Type") == null) {
            asyncHttpRequest.getHeaders().set("Content-Type", asyncHttpRequest.getBody().getContentType());
        }
        for (AsyncHttpClientMiddleware asyncHttpClientMiddleware2 : this.f34894a) {
            Cancellable socket = asyncHttpClientMiddleware2.getSocket(onResponseCompleteDataOnRequestSentData);
            if (socket != null) {
                onResponseCompleteDataOnRequestSentData.socketCancellable = socket;
                lVar.setParent(socket);
                return;
            }
        }
        u(lVar, new IllegalArgumentException("invalid uri=" + asyncHttpRequest.getUri() + " middlewares=" + this.f34894a), null, asyncHttpRequest, httpConnectCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AsyncHttpRequest asyncHttpRequest, int i4, l lVar, HttpConnectCallback httpConnectCallback, AsyncHttpClientMiddleware.OnResponseCompleteDataOnRequestSentData onResponseCompleteDataOnRequestSentData) {
        f fVar = new f(asyncHttpRequest, lVar, asyncHttpRequest, httpConnectCallback, onResponseCompleteDataOnRequestSentData, i4);
        onResponseCompleteDataOnRequestSentData.sendHeadersCallback = new g(fVar);
        onResponseCompleteDataOnRequestSentData.receiveHeadersCallback = new h(fVar);
        onResponseCompleteDataOnRequestSentData.response = fVar;
        fVar.g(onResponseCompleteDataOnRequestSentData.socket);
        Iterator<AsyncHttpClientMiddleware> it = this.f34894a.iterator();
        while (it.hasNext() && !it.next().exchangeHeaders(onResponseCompleteDataOnRequestSentData)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long p(AsyncHttpRequest asyncHttpRequest) {
        return asyncHttpRequest.getTimeout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void q(RequestCallback<T> requestCallback, SimpleFuture<T> simpleFuture, AsyncHttpResponse asyncHttpResponse, Exception exc, T t3) {
        this.f34898e.post(new i(requestCallback, simpleFuture, asyncHttpResponse, exc, t3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(RequestCallback requestCallback, AsyncHttpResponse asyncHttpResponse) {
        if (requestCallback != null) {
            requestCallback.onConnect(asyncHttpResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(RequestCallback requestCallback, AsyncHttpResponse asyncHttpResponse, long j4, long j5) {
        if (requestCallback != null) {
            requestCallback.onProgress(asyncHttpResponse, j4, j5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void t(RequestCallback<T> requestCallback, SimpleFuture<T> simpleFuture, AsyncHttpResponse asyncHttpResponse, Exception exc, T t3) {
        boolean complete;
        if (exc != null) {
            complete = simpleFuture.setComplete(exc);
        } else {
            complete = simpleFuture.setComplete((SimpleFuture<T>) t3);
        }
        if (complete && requestCallback != null) {
            requestCallback.onCompleted(exc, asyncHttpResponse, t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(l lVar, Exception exc, com.koushikdutta.async.http.a aVar, AsyncHttpRequest asyncHttpRequest, HttpConnectCallback httpConnectCallback) {
        boolean complete;
        this.f34898e.removeAllCallbacks(lVar.f34958j);
        if (exc != null) {
            asyncHttpRequest.loge("Connection error", exc);
            complete = lVar.setComplete(exc);
        } else {
            asyncHttpRequest.logd("Connection successful");
            complete = lVar.setComplete((l) aVar);
        }
        if (complete) {
            httpConnectCallback.onConnectCompleted(exc, aVar);
        } else if (aVar != null) {
            aVar.setDataCallback(new DataCallback.NullDataCallback());
            aVar.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static void v(AsyncHttpRequest asyncHttpRequest) {
        if (asyncHttpRequest.f34967g != null) {
            return;
        }
        try {
            List<Proxy> select = ProxySelector.getDefault().select(URI.create(asyncHttpRequest.getUri().toString()));
            if (select.isEmpty()) {
                return;
            }
            Proxy proxy = select.get(0);
            if (proxy.type() != Proxy.Type.HTTP || !(proxy.address() instanceof InetSocketAddress)) {
                return;
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
            asyncHttpRequest.enableProxy(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
        } catch (Exception unused) {
        }
    }

    public Future<AsyncHttpResponse> execute(AsyncHttpRequest asyncHttpRequest, HttpConnectCallback httpConnectCallback) {
        l lVar = new l(this, null);
        m(asyncHttpRequest, 0, lVar, httpConnectCallback);
        return lVar;
    }

    public Future<ByteBufferList> executeByteBufferList(AsyncHttpRequest asyncHttpRequest, DownloadCallback downloadCallback) {
        return execute(asyncHttpRequest, new ByteBufferListParser(), downloadCallback);
    }

    public Future<File> executeFile(AsyncHttpRequest asyncHttpRequest, String str, FileCallback fileCallback) {
        File file = new File(str);
        file.getParentFile().mkdirs();
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
            l lVar = new l(this, null);
            j jVar = new j(lVar, bufferedOutputStream, file);
            jVar.setParent((Cancellable) lVar);
            m(asyncHttpRequest, 0, lVar, new k(bufferedOutputStream, file, fileCallback, jVar));
            return jVar;
        } catch (FileNotFoundException e4) {
            SimpleFuture simpleFuture = new SimpleFuture();
            simpleFuture.setComplete((Exception) e4);
            return simpleFuture;
        }
    }

    public Future<JSONArray> executeJSONArray(AsyncHttpRequest asyncHttpRequest, JSONArrayCallback jSONArrayCallback) {
        return execute(asyncHttpRequest, new JSONArrayParser(), jSONArrayCallback);
    }

    public Future<JSONObject> executeJSONObject(AsyncHttpRequest asyncHttpRequest, JSONObjectCallback jSONObjectCallback) {
        return execute(asyncHttpRequest, new JSONObjectParser(), jSONObjectCallback);
    }

    public Future<String> executeString(AsyncHttpRequest asyncHttpRequest, StringCallback stringCallback) {
        return execute(asyncHttpRequest, new StringParser(), stringCallback);
    }

    public Collection<AsyncHttpClientMiddleware> getMiddleware() {
        return this.f34894a;
    }

    public SpdyMiddleware getSSLSocketMiddleware() {
        return this.f34895b;
    }

    public AsyncServer getServer() {
        return this.f34898e;
    }

    public AsyncSocketMiddleware getSocketMiddleware() {
        return this.f34896c;
    }

    public void insertMiddleware(AsyncHttpClientMiddleware asyncHttpClientMiddleware) {
        this.f34894a.add(0, asyncHttpClientMiddleware);
    }

    public Future<WebSocket> websocket(AsyncHttpRequest asyncHttpRequest, String str, WebSocketConnectCallback webSocketConnectCallback) {
        WebSocketImpl.addWebSocketUpgradeHeaders(asyncHttpRequest, str);
        SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent((Cancellable) execute(asyncHttpRequest, new b(simpleFuture, webSocketConnectCallback, asyncHttpRequest)));
        return simpleFuture;
    }

    public Future<AsyncHttpResponse> execute(String str, HttpConnectCallback httpConnectCallback) {
        return execute(new AsyncHttpGet(str), httpConnectCallback);
    }

    public <T> SimpleFuture<T> execute(AsyncHttpRequest asyncHttpRequest, AsyncParser<T> asyncParser, RequestCallback<T> requestCallback) {
        l lVar = new l(this, null);
        SimpleFuture<T> simpleFuture = new SimpleFuture<>();
        m(asyncHttpRequest, 0, lVar, new a(requestCallback, simpleFuture, asyncParser));
        simpleFuture.setParent((Cancellable) lVar);
        return simpleFuture;
    }

    public Future<WebSocket> websocket(String str, String str2, WebSocketConnectCallback webSocketConnectCallback) {
        return websocket(new AsyncHttpGet(str.replace("ws://", "http://").replace("wss://", "https://")), str2, webSocketConnectCallback);
    }

    /* loaded from: classes6.dex */
    public static abstract class RequestCallbackBase<T> implements RequestCallback<T> {
        @Override // com.koushikdutta.async.http.callback.RequestCallback
        public void onConnect(AsyncHttpResponse asyncHttpResponse) {
        }

        @Override // com.koushikdutta.async.http.callback.RequestCallback
        public void onProgress(AsyncHttpResponse asyncHttpResponse, long j4, long j5) {
        }
    }
}
