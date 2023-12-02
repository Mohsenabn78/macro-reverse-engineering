package com.google.firebase.crashlytics.internal.network;

/* loaded from: classes5.dex */
public class HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private final int f29962a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29963b;

    public HttpResponse(int i4, String str) {
        this.f29962a = i4;
        this.f29963b = str;
    }

    public String body() {
        return this.f29963b;
    }

    public int code() {
        return this.f29962a;
    }
}
