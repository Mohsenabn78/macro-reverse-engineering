package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.JSONArrayParser;
import org.json.JSONArray;

/* loaded from: classes6.dex */
public class JSONArrayBody implements AsyncHttpRequestBody<JSONArray> {
    public static final String CONTENT_TYPE = "application/json";

    /* renamed from: a  reason: collision with root package name */
    byte[] f35108a;

    /* renamed from: b  reason: collision with root package name */
    JSONArray f35109b;

    /* loaded from: classes6.dex */
    class a implements FutureCallback<JSONArray> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f35110a;

        a(CompletedCallback completedCallback) {
            this.f35110a = completedCallback;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, JSONArray jSONArray) {
            JSONArrayBody.this.f35109b = jSONArray;
            this.f35110a.onCompleted(exc);
        }
    }

    public JSONArrayBody() {
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return "application/json";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        byte[] bytes = this.f35109b.toString().getBytes();
        this.f35108a = bytes;
        return bytes.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        new JSONArrayParser().parse(dataEmitter).setCallback(new a(completedCallback));
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        Util.writeAll(dataSink, this.f35108a, completedCallback);
    }

    public JSONArrayBody(JSONArray jSONArray) {
        this();
        this.f35109b = jSONArray;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public JSONArray get() {
        return this.f35109b;
    }
}
