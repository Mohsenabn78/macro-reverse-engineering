package com.koushikdutta.async.http.socketio.transport;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.socketio.transport.SocketIOTransport;

/* loaded from: classes6.dex */
public class WebSocketTransport implements SocketIOTransport {

    /* renamed from: a  reason: collision with root package name */
    private WebSocket f35433a;

    /* renamed from: b  reason: collision with root package name */
    private SocketIOTransport.StringCallback f35434b;

    /* renamed from: c  reason: collision with root package name */
    private String f35435c;

    /* loaded from: classes6.dex */
    class a implements WebSocket.StringCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SocketIOTransport.StringCallback f35436a;

        a(SocketIOTransport.StringCallback stringCallback) {
            this.f35436a = stringCallback;
        }

        @Override // com.koushikdutta.async.http.WebSocket.StringCallback
        public void onStringAvailable(String str) {
            this.f35436a.onStringAvailable(str);
        }
    }

    public WebSocketTransport(WebSocket webSocket, String str) {
        this.f35433a = webSocket;
        this.f35435c = str;
        webSocket.setDataCallback(new DataCallback.NullDataCallback());
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public void disconnect() {
        this.f35433a.close();
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public AsyncServer getServer() {
        return this.f35433a.getServer();
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public String getSessionId() {
        return this.f35435c;
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public boolean heartbeats() {
        return true;
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public boolean isConnected() {
        return this.f35433a.isOpen();
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public void send(String str) {
        this.f35433a.send(str);
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f35433a.setClosedCallback(completedCallback);
    }

    @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport
    public void setStringCallback(SocketIOTransport.StringCallback stringCallback) {
        if (this.f35434b == stringCallback) {
            return;
        }
        if (stringCallback == null) {
            this.f35433a.setStringCallback(null);
        } else {
            this.f35433a.setStringCallback(new a(stringCallback));
        }
        this.f35434b = stringCallback;
    }
}
