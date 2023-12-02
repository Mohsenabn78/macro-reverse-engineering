package com.koushikdutta.async.http.socketio.transport;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.callback.CompletedCallback;

/* loaded from: classes6.dex */
public interface SocketIOTransport {

    /* loaded from: classes6.dex */
    public interface StringCallback {
        void onStringAvailable(String str);
    }

    void disconnect();

    AsyncServer getServer();

    String getSessionId();

    boolean heartbeats();

    boolean isConnected();

    void send(String str);

    void setClosedCallback(CompletedCallback completedCallback);

    void setStringCallback(StringCallback stringCallback);
}
