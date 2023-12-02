package com.koushikdutta.async.http.callback;

import com.koushikdutta.async.callback.ResultCallback;
import com.koushikdutta.async.http.AsyncHttpResponse;

/* loaded from: classes6.dex */
public interface RequestCallback<T> extends ResultCallback<AsyncHttpResponse, T> {
    void onConnect(AsyncHttpResponse asyncHttpResponse);

    void onProgress(AsyncHttpResponse asyncHttpResponse, long j4, long j5);
}
