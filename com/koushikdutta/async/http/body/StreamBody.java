package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class StreamBody implements AsyncHttpRequestBody<InputStream> {
    public static final String CONTENT_TYPE = "application/binary";

    /* renamed from: a  reason: collision with root package name */
    InputStream f35143a;

    /* renamed from: b  reason: collision with root package name */
    int f35144b;

    /* renamed from: c  reason: collision with root package name */
    String f35145c = "application/binary";

    public StreamBody(InputStream inputStream, int i4) {
        this.f35143a = inputStream;
        this.f35144b = i4;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return this.f35145c;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        return this.f35144b;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        throw new AssertionError("not implemented");
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        throw new AssertionError("not implemented");
    }

    public StreamBody setContentType(String str) {
        this.f35145c = str;
        return this;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        long j4;
        InputStream inputStream = this.f35143a;
        int i4 = this.f35144b;
        if (i4 < 0) {
            j4 = 2147483647L;
        } else {
            j4 = i4;
        }
        Util.pump(inputStream, j4, dataSink, completedCallback);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public InputStream get() {
        return this.f35143a;
    }
}
