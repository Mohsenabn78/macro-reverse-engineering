package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;

/* loaded from: classes6.dex */
public interface AsyncHttpRequestBody<T> {
    T get();

    String getContentType();

    int length();

    void parse(DataEmitter dataEmitter, CompletedCallback completedCallback);

    boolean readFullyOnRequest();

    void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback);
}
