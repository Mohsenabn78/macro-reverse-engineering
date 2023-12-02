package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.JSONObjectParser;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class JSONObjectBody implements AsyncHttpRequestBody<JSONObject> {
    public static final String CONTENT_TYPE = "application/json";

    /* renamed from: a  reason: collision with root package name */
    byte[] f35112a;

    /* renamed from: b  reason: collision with root package name */
    JSONObject f35113b;

    /* loaded from: classes6.dex */
    class a implements FutureCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f35114a;

        a(CompletedCallback completedCallback) {
            this.f35114a = completedCallback;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, JSONObject jSONObject) {
            JSONObjectBody.this.f35113b = jSONObject;
            this.f35114a.onCompleted(exc);
        }
    }

    public JSONObjectBody() {
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return "application/json";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        byte[] bytes = this.f35113b.toString().getBytes();
        this.f35112a = bytes;
        return bytes.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        new JSONObjectParser().parse(dataEmitter).setCallback(new a(completedCallback));
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        Util.writeAll(dataSink, this.f35112a, completedCallback);
    }

    public JSONObjectBody(JSONObject jSONObject) {
        this();
        this.f35113b = jSONObject;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public JSONObject get() {
        return this.f35113b;
    }
}
