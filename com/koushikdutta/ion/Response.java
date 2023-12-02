package com.koushikdutta.ion;

import com.koushikdutta.async.http.AsyncHttpRequest;

/* loaded from: classes6.dex */
public class Response<T> {

    /* renamed from: a  reason: collision with root package name */
    private ResponseServedFrom f35774a;

    /* renamed from: b  reason: collision with root package name */
    private AsyncHttpRequest f35775b;

    /* renamed from: c  reason: collision with root package name */
    private T f35776c;

    /* renamed from: d  reason: collision with root package name */
    private Exception f35777d;

    /* renamed from: e  reason: collision with root package name */
    private HeadersResponse f35778e;

    public Response(AsyncHttpRequest asyncHttpRequest, ResponseServedFrom responseServedFrom, HeadersResponse headersResponse, Exception exc, T t3) {
        this.f35775b = asyncHttpRequest;
        this.f35774a = responseServedFrom;
        this.f35778e = headersResponse;
        this.f35777d = exc;
        this.f35776c = t3;
    }

    public Exception getException() {
        return this.f35777d;
    }

    public HeadersResponse getHeaders() {
        return this.f35778e;
    }

    public AsyncHttpRequest getRequest() {
        return this.f35775b;
    }

    public T getResult() {
        return this.f35776c;
    }

    public ResponseServedFrom getServedFrom() {
        return this.f35774a;
    }
}
