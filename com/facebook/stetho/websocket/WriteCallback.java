package com.facebook.stetho.websocket;

import java.io.IOException;

/* loaded from: classes3.dex */
interface WriteCallback {
    void onFailure(IOException iOException);

    void onSuccess();
}
