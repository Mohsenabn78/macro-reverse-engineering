package com.facebook.stetho.websocket;

/* loaded from: classes3.dex */
public interface SimpleEndpoint {
    void onClose(SimpleSession simpleSession, int i4, String str);

    void onError(SimpleSession simpleSession, Throwable th);

    void onMessage(SimpleSession simpleSession, String str);

    void onMessage(SimpleSession simpleSession, byte[] bArr, int i4);

    void onOpen(SimpleSession simpleSession);
}
