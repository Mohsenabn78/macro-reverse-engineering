package com.koushikdutta.async.http;

import android.text.TextUtils;
import android.util.Base64;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.UUID;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes6.dex */
public class WebSocketImpl implements WebSocket {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<ByteBufferList> f35078a;

    /* renamed from: b  reason: collision with root package name */
    private AsyncSocket f35079b;

    /* renamed from: c  reason: collision with root package name */
    BufferedDataSink f35080c;

    /* renamed from: d  reason: collision with root package name */
    HybiParser f35081d;

    /* renamed from: e  reason: collision with root package name */
    CompletedCallback f35082e;

    /* renamed from: f  reason: collision with root package name */
    private WebSocket.StringCallback f35083f;

    /* renamed from: g  reason: collision with root package name */
    private DataCallback f35084g;

    /* renamed from: h  reason: collision with root package name */
    private WebSocket.PingCallback f35085h;

    /* renamed from: i  reason: collision with root package name */
    private WebSocket.PongCallback f35086i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends HybiParser {
        a(DataEmitter dataEmitter) {
            super(dataEmitter);
        }

        @Override // com.koushikdutta.async.http.HybiParser
        protected void A(byte[] bArr) {
            WebSocketImpl.this.g(new ByteBufferList(bArr));
        }

        @Override // com.koushikdutta.async.http.HybiParser
        protected void B(String str) {
            if (WebSocketImpl.this.f35085h != null) {
                WebSocketImpl.this.f35085h.onPingReceived(str);
            }
        }

        @Override // com.koushikdutta.async.http.HybiParser
        protected void C(String str) {
            if (WebSocketImpl.this.f35086i != null) {
                WebSocketImpl.this.f35086i.onPongReceived(str);
            }
        }

        @Override // com.koushikdutta.async.http.HybiParser
        protected void J(Exception exc) {
            CompletedCallback completedCallback = WebSocketImpl.this.f35082e;
            if (completedCallback != null) {
                completedCallback.onCompleted(exc);
            }
        }

        @Override // com.koushikdutta.async.http.HybiParser
        protected void L(byte[] bArr) {
            WebSocketImpl.this.f35080c.write(new ByteBufferList(bArr));
        }

        @Override // com.koushikdutta.async.http.HybiParser
        protected void y(int i4, String str) {
            WebSocketImpl.this.f35079b.close();
        }

        @Override // com.koushikdutta.async.http.HybiParser
        protected void z(String str) {
            if (WebSocketImpl.this.f35083f != null) {
                WebSocketImpl.this.f35083f.onStringAvailable(str);
            }
        }
    }

    public WebSocketImpl(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        this(asyncHttpServerRequest.getSocket());
        String str = asyncHttpServerRequest.getHeaders().get(HttpHeaders.SEC_WEBSOCKET_KEY);
        String a4 = a(str + WebSocketProtocol.ACCEPT_MAGIC);
        asyncHttpServerRequest.getHeaders().get(HttpHeaders.ORIGIN);
        asyncHttpServerResponse.code(101);
        asyncHttpServerResponse.getHeaders().set(HttpHeaders.UPGRADE, "WebSocket");
        asyncHttpServerResponse.getHeaders().set("Connection", HttpHeaders.UPGRADE);
        asyncHttpServerResponse.getHeaders().set(HttpHeaders.SEC_WEBSOCKET_ACCEPT, a4);
        String str2 = asyncHttpServerRequest.getHeaders().get(HttpHeaders.SEC_WEBSOCKET_PROTOCOL);
        if (!TextUtils.isEmpty(str2)) {
            asyncHttpServerResponse.getHeaders().set(HttpHeaders.SEC_WEBSOCKET_PROTOCOL, str2);
        }
        asyncHttpServerResponse.writeHead();
        h(false, false);
    }

    private static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
            messageDigest.update(str.getBytes("iso-8859-1"), 0, str.length());
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void addWebSocketUpgradeHeaders(AsyncHttpRequest asyncHttpRequest, String str) {
        Headers headers = asyncHttpRequest.getHeaders();
        String encodeToString = Base64.encodeToString(i(UUID.randomUUID()), 2);
        headers.set(HttpHeaders.SEC_WEBSOCKET_VERSION, "13");
        headers.set(HttpHeaders.SEC_WEBSOCKET_KEY, encodeToString);
        headers.set(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "x-webkit-deflate-frame");
        headers.set("Connection", HttpHeaders.UPGRADE);
        headers.set(HttpHeaders.UPGRADE, "websocket");
        if (str != null) {
            headers.set(HttpHeaders.SEC_WEBSOCKET_PROTOCOL, str);
        }
        headers.set(HttpHeaders.PRAGMA, "no-cache");
        headers.set(HttpHeaders.CACHE_CONTROL, "no-cache");
        if (TextUtils.isEmpty(asyncHttpRequest.getHeaders().get("User-Agent"))) {
            asyncHttpRequest.getHeaders().set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.15 Safari/537.36");
        }
    }

    public static WebSocket finishHandshake(Headers headers, AsyncHttpResponse asyncHttpResponse) {
        String str;
        String str2;
        boolean z3;
        if (asyncHttpResponse == null || asyncHttpResponse.code() != 101 || !"websocket".equalsIgnoreCase(asyncHttpResponse.headers().get(HttpHeaders.UPGRADE)) || (str = asyncHttpResponse.headers().get(HttpHeaders.SEC_WEBSOCKET_ACCEPT)) == null || (str2 = headers.get(HttpHeaders.SEC_WEBSOCKET_KEY)) == null) {
            return null;
        }
        if (!str.equalsIgnoreCase(a(str2 + WebSocketProtocol.ACCEPT_MAGIC).trim())) {
            return null;
        }
        String str3 = headers.get(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS);
        if (str3 != null && str3.equals("x-webkit-deflate-frame")) {
            z3 = true;
        } else {
            z3 = false;
        }
        WebSocketImpl webSocketImpl = new WebSocketImpl(asyncHttpResponse.detachSocket());
        webSocketImpl.h(true, z3);
        return webSocketImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ByteBufferList byteBufferList) {
        if (this.f35078a == null) {
            Util.emitAllData(this, byteBufferList);
            if (byteBufferList.remaining() > 0) {
                LinkedList<ByteBufferList> linkedList = new LinkedList<>();
                this.f35078a = linkedList;
                linkedList.add(byteBufferList);
                return;
            }
            return;
        }
        while (!isPaused()) {
            ByteBufferList remove = this.f35078a.remove();
            Util.emitAllData(this, remove);
            if (remove.remaining() > 0) {
                this.f35078a.add(0, remove);
            }
        }
        if (this.f35078a.size() == 0) {
            this.f35078a = null;
        }
    }

    private void h(boolean z3, boolean z4) {
        a aVar = new a(this.f35079b);
        this.f35081d = aVar;
        aVar.N(z3);
        this.f35081d.M(z4);
        if (this.f35079b.isPaused()) {
            this.f35079b.resume();
        }
    }

    private static byte[] i(UUID uuid) {
        byte[] bArr = new byte[16];
        ByteBuffer.wrap(bArr).asLongBuffer().put(new long[]{uuid.getMostSignificantBits(), uuid.getLeastSignificantBits()});
        return bArr;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return null;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        this.f35079b.close();
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        this.f35079b.end();
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.f35079b.getClosedCallback();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.f35084g;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public CompletedCallback getEndCallback() {
        return this.f35082e;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public WebSocket.PongCallback getPongCallback() {
        return this.f35086i;
    }

    @Override // com.koushikdutta.async.AsyncSocket, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f35079b.getServer();
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public AsyncSocket getSocket() {
        return this.f35079b;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public WebSocket.StringCallback getStringCallback() {
        return this.f35083f;
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.f35080c.getWriteableCallback();
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public boolean isBuffering() {
        if (this.f35080c.remaining() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return false;
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        return this.f35079b.isOpen();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.f35079b.isPaused();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        this.f35079b.pause();
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void ping(String str) {
        this.f35080c.write(new ByteBufferList(ByteBuffer.wrap(this.f35081d.H(str))));
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void pong(String str) {
        this.f35080c.write(new ByteBufferList(ByteBuffer.wrap(this.f35081d.I(str))));
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        this.f35079b.resume();
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void send(byte[] bArr) {
        this.f35080c.write(new ByteBufferList(this.f35081d.t(bArr)));
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f35079b.setClosedCallback(completedCallback);
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.f35084g = dataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setEndCallback(CompletedCallback completedCallback) {
        this.f35082e = completedCallback;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void setPingCallback(WebSocket.PingCallback pingCallback) {
        this.f35085h = pingCallback;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void setPongCallback(WebSocket.PongCallback pongCallback) {
        this.f35086i = pongCallback;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void setStringCallback(WebSocket.StringCallback stringCallback) {
        this.f35083f = stringCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f35080c.setWriteableCallback(writableCallback);
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        send(byteBufferList.getAllByteArray());
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void send(byte[] bArr, int i4, int i5) {
        this.f35080c.write(new ByteBufferList(this.f35081d.u(bArr, i4, i5)));
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void send(String str) {
        this.f35080c.write(new ByteBufferList(this.f35081d.s(str)));
    }

    public WebSocketImpl(AsyncSocket asyncSocket) {
        this.f35079b = asyncSocket;
        this.f35080c = new BufferedDataSink(this.f35079b);
    }
}
