package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncSocket;

/* loaded from: classes6.dex */
public interface WebSocket extends AsyncSocket {

    /* loaded from: classes6.dex */
    public interface PingCallback {
        void onPingReceived(String str);
    }

    /* loaded from: classes6.dex */
    public interface PongCallback {
        void onPongReceived(String str);
    }

    /* loaded from: classes6.dex */
    public interface StringCallback {
        void onStringAvailable(String str);
    }

    PongCallback getPongCallback();

    AsyncSocket getSocket();

    StringCallback getStringCallback();

    boolean isBuffering();

    void ping(String str);

    void pong(String str);

    void send(String str);

    void send(byte[] bArr);

    void send(byte[] bArr, int i4, int i5);

    void setPingCallback(PingCallback pingCallback);

    void setPongCallback(PongCallback pongCallback);

    void setStringCallback(StringCallback stringCallback);
}
