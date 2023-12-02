package com.koushikdutta.async.http.server;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;

/* loaded from: classes6.dex */
public class UnknownRequestBody implements AsyncHttpRequestBody<Void> {

    /* renamed from: a  reason: collision with root package name */
    int f35366a;

    /* renamed from: b  reason: collision with root package name */
    private String f35367b;

    /* renamed from: c  reason: collision with root package name */
    DataEmitter f35368c;

    public UnknownRequestBody(String str) {
        this.f35366a = -1;
        this.f35367b = str;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public Void get() {
        return null;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return this.f35367b;
    }

    public DataEmitter getEmitter() {
        return this.f35368c;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        return this.f35366a;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        this.f35368c = dataEmitter;
        dataEmitter.setEndCallback(completedCallback);
        dataEmitter.setDataCallback(new DataCallback.NullDataCallback());
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return false;
    }

    @Deprecated
    public void setCallbacks(DataCallback dataCallback, CompletedCallback completedCallback) {
        this.f35368c.setEndCallback(completedCallback);
        this.f35368c.setDataCallback(dataCallback);
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        Util.pump(this.f35368c, dataSink, completedCallback);
        if (this.f35368c.isPaused()) {
            this.f35368c.resume();
        }
    }

    public UnknownRequestBody(DataEmitter dataEmitter, String str, int i4) {
        this.f35367b = str;
        this.f35368c = dataEmitter;
        this.f35366a = i4;
    }
}
