package com.koushikdutta.ion.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes6.dex */
public class GsonBody<T extends JsonElement> implements AsyncHttpRequestBody<T> {
    public static final String CONTENT_TYPE = "application/json";

    /* renamed from: a  reason: collision with root package name */
    byte[] f35870a;

    /* renamed from: b  reason: collision with root package name */
    T f35871b;

    /* renamed from: c  reason: collision with root package name */
    Gson f35872c;

    public GsonBody(Gson gson, T t3) {
        this.f35871b = t3;
        this.f35872c = gson;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return "application/json";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        if (this.f35870a == null) {
            this.f35870a = this.f35871b.toString().getBytes();
        }
        return this.f35870a.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        throw new AssertionError("not implemented");
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        if (this.f35870a == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f35872c.toJson((JsonElement) this.f35871b, (Appendable) new OutputStreamWriter(byteArrayOutputStream));
            this.f35870a = byteArrayOutputStream.toByteArray();
        }
        Util.writeAll(dataSink, this.f35870a, completedCallback);
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public T get() {
        return this.f35871b;
    }
}
