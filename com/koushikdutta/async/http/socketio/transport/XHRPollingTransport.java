package com.koushikdutta.async.http.socketio.transport;

import android.net.Uri;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpGet;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.StringBody;
import com.koushikdutta.async.http.socketio.transport.SocketIOTransport;

/* loaded from: classes6.dex */
public class XHRPollingTransport implements SocketIOTransport {

    /* renamed from: a  reason: collision with root package name */
    private AsyncHttpClient f35438a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f35439b;

    /* renamed from: c  reason: collision with root package name */
    private SocketIOTransport.StringCallback f35440c;

    /* renamed from: d  reason: collision with root package name */
    private CompletedCallback f35441d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f35442e;

    /* renamed from: f  reason: collision with root package name */
    private String f35443f;

    /* loaded from: classes6.dex */
    class a extends AsyncHttpClient.StringCallback {
        a() {
        }

        @Override // com.koushikdutta.async.callback.ResultCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse, String str) {
            if (exc != null) {
                XHRPollingTransport.this.d(exc);
            } else {
                XHRPollingTransport.this.h(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends AsyncHttpClient.StringCallback {
        b() {
        }

        @Override // com.koushikdutta.async.callback.ResultCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse, String str) {
            if (exc != null) {
                XHRPollingTransport.this.d(exc);
                return;
            }
            XHRPollingTransport.this.h(str);
            XHRPollingTransport.this.f();
        }
    }

    public XHRPollingTransport(AsyncHttpClient asyncHttpClient, String str, String str2) {
        this.f35438a = asyncHttpClient;
        this.f35439b = Uri.parse(str);
        this.f35443f = str2;
        f();
        this.f35442e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Exception exc) {
        CompletedCallback completedCallback = this.f35441d;
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
        }
    }

    private String e() {
        return this.f35439b.buildUpon().appendQueryParameter("t", String.valueOf(System.currentTimeMillis())).build().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f35438a.executeString(new AsyncHttpGet(e()), new b());
    }

    private void g(String str) {
        if (!str.startsWith("5")) {
            return;
        }
        AsyncHttpPost asyncHttpPost = new AsyncHttpPost(e());
        asyncHttpPost.setBody(new StringBody(str));
        this.f35438a.executeString(asyncHttpPost, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        if (this.f35440c == null) {
            return;
        }
        if (!str.contains("�")) {
            this.f35440c.onStringAvailable(str);
            return;
        }
        String[] split = str.split("�");
        for (int i4 = 1; i4 < split.length; i4 += 2) {
            this.f35440c.onStringAvailable(split[i4 + 1]);
        }
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public void disconnect() {
        this.f35442e = false;
        d(null);
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public AsyncServer getServer() {
        return this.f35438a.getServer();
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public String getSessionId() {
        return this.f35443f;
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public boolean heartbeats() {
        return false;
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public boolean isConnected() {
        return this.f35442e;
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public void send(String str) {
        if (str.startsWith("5")) {
            g(str);
            return;
        }
        AsyncHttpPost asyncHttpPost = new AsyncHttpPost(e());
        asyncHttpPost.setBody(new StringBody(str));
        this.f35438a.executeString(asyncHttpPost, new a());
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f35441d = completedCallback;
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public void setStringCallback(SocketIOTransport.StringCallback stringCallback) {
        this.f35440c = stringCallback;
    }
}
