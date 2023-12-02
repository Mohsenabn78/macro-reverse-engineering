package com.koushikdutta.ion;

import com.koushikdutta.async.http.Headers;

/* loaded from: classes6.dex */
public class HeadersResponse {

    /* renamed from: a  reason: collision with root package name */
    Headers f35712a;

    /* renamed from: b  reason: collision with root package name */
    int f35713b;

    /* renamed from: c  reason: collision with root package name */
    String f35714c;

    public HeadersResponse(int i4, String str, Headers headers) {
        this.f35712a = headers;
        this.f35713b = i4;
        this.f35714c = str;
    }

    public int code() {
        return this.f35713b;
    }

    public Headers getHeaders() {
        return this.f35712a;
    }

    public String message() {
        return this.f35714c;
    }

    public HeadersResponse code(int i4) {
        this.f35713b = i4;
        return this;
    }

    public HeadersResponse message(String str) {
        this.f35714c = str;
        return this;
    }
}
