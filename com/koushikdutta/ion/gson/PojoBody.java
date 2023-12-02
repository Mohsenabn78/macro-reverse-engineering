package com.koushikdutta.ion.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public class PojoBody<T> implements AsyncHttpRequestBody<T> {
    public static final String CONTENT_TYPE = "application/json";

    /* renamed from: a  reason: collision with root package name */
    T f35880a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f35881b;

    /* renamed from: c  reason: collision with root package name */
    Type f35882c;

    /* renamed from: d  reason: collision with root package name */
    Gson f35883d;

    public PojoBody(Gson gson, T t3, TypeToken<T> typeToken) {
        this.f35880a = t3;
        if (typeToken != null) {
            this.f35882c = typeToken.getType();
        }
        this.f35883d = gson;
        if (!t3.getClass().isPrimitive() && !(t3 instanceof String)) {
            return;
        }
        throw new AssertionError("must provide a non-primitive type");
    }

    byte[] a() {
        byte[] bArr = this.f35881b;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        Type type = this.f35882c;
        if (type == null) {
            this.f35883d.toJson(this.f35880a, outputStreamWriter);
        } else {
            this.f35883d.toJson(this.f35880a, type, outputStreamWriter);
        }
        try {
            outputStreamWriter.flush();
            byteArrayOutputStream.flush();
        } catch (Exception unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.f35881b = byteArray;
        return byteArray;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public T get() {
        return this.f35880a;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return "application/json";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        return a().length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        Util.writeAll(dataSink, a(), completedCallback);
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
    }
}
