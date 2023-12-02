package com.google.api.client.http;

import java.io.IOException;

/* loaded from: classes5.dex */
public final class HttpRequestFactory {

    /* renamed from: a  reason: collision with root package name */
    private final HttpTransport f25814a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpRequestInitializer f25815b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequestFactory(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.f25814a = httpTransport;
        this.f25815b = httpRequestInitializer;
    }

    public HttpRequest buildDeleteRequest(GenericUrl genericUrl) throws IOException {
        return buildRequest("DELETE", genericUrl, null);
    }

    public HttpRequest buildGetRequest(GenericUrl genericUrl) throws IOException {
        return buildRequest("GET", genericUrl, null);
    }

    public HttpRequest buildHeadRequest(GenericUrl genericUrl) throws IOException {
        return buildRequest("HEAD", genericUrl, null);
    }

    public HttpRequest buildPatchRequest(GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        return buildRequest(HttpMethods.PATCH, genericUrl, httpContent);
    }

    public HttpRequest buildPostRequest(GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        return buildRequest("POST", genericUrl, httpContent);
    }

    public HttpRequest buildPutRequest(GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        return buildRequest("PUT", genericUrl, httpContent);
    }

    public HttpRequest buildRequest(String str, GenericUrl genericUrl, HttpContent httpContent) throws IOException {
        HttpRequest a4 = this.f25814a.a();
        HttpRequestInitializer httpRequestInitializer = this.f25815b;
        if (httpRequestInitializer != null) {
            httpRequestInitializer.initialize(a4);
        }
        a4.setRequestMethod(str);
        if (genericUrl != null) {
            a4.setUrl(genericUrl);
        }
        if (httpContent != null) {
            a4.setContent(httpContent);
        }
        return a4;
    }

    public HttpRequestInitializer getInitializer() {
        return this.f25815b;
    }

    public HttpTransport getTransport() {
        return this.f25814a;
    }
}
