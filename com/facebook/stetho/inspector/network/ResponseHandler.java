package com.facebook.stetho.inspector.network;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface ResponseHandler {
    void onEOF();

    void onError(IOException iOException);

    void onRead(int i4);

    void onReadDecoded(int i4);
}
