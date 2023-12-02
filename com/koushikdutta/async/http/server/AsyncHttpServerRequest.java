package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.util.regex.Matcher;

/* loaded from: classes6.dex */
public interface AsyncHttpServerRequest extends DataEmitter {
    AsyncHttpRequestBody getBody();

    Headers getHeaders();

    Matcher getMatcher();

    String getMethod();

    String getPath();

    Multimap getQuery();

    AsyncSocket getSocket();
}
