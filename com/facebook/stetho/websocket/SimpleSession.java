package com.facebook.stetho.websocket;

/* loaded from: classes3.dex */
public interface SimpleSession {
    void close(int i4, String str);

    boolean isOpen();

    void sendBinary(byte[] bArr);

    void sendText(String str);
}
