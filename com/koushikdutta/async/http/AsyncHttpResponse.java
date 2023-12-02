package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;

/* loaded from: classes6.dex */
public interface AsyncHttpResponse extends DataEmitter {
    int code();

    AsyncSocket detachSocket();

    AsyncHttpRequest getRequest();

    Headers headers();

    String message();

    String protocol();
}
