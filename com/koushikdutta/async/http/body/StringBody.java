package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.StringParser;

/* loaded from: classes6.dex */
public class StringBody implements AsyncHttpRequestBody<String> {
    public static final String CONTENT_TYPE = "text/plain";

    /* renamed from: a  reason: collision with root package name */
    byte[] f35146a;

    /* renamed from: b  reason: collision with root package name */
    String f35147b;

    /* loaded from: classes6.dex */
    class a implements FutureCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f35148a;

        a(CompletedCallback completedCallback) {
            this.f35148a = completedCallback;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, String str) {
            StringBody.this.f35147b = str;
            this.f35148a.onCompleted(exc);
        }
    }

    public StringBody() {
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return "text/plain";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        if (this.f35146a == null) {
            this.f35146a = this.f35147b.getBytes();
        }
        return this.f35146a.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        new StringParser().parse(dataEmitter).setCallback(new a(completedCallback));
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    public String toString() {
        return this.f35147b;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        if (this.f35146a == null) {
            this.f35146a = this.f35147b.getBytes();
        }
        Util.writeAll(dataSink, this.f35146a, completedCallback);
    }

    public StringBody(String str) {
        this();
        this.f35147b = str;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String get() {
        return toString();
    }
}
