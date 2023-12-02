package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class BasicAuthentication implements HttpRequestInitializer, HttpExecuteInterceptor {

    /* renamed from: a  reason: collision with root package name */
    private final String f25752a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25753b;

    public BasicAuthentication(String str, String str2) {
        this.f25752a = (String) Preconditions.checkNotNull(str);
        this.f25753b = (String) Preconditions.checkNotNull(str2);
    }

    public String getPassword() {
        return this.f25753b;
    }

    public String getUsername() {
        return this.f25752a;
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void initialize(HttpRequest httpRequest) throws IOException {
        httpRequest.setInterceptor(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void intercept(HttpRequest httpRequest) throws IOException {
        httpRequest.getHeaders().setBasicAuthentication(this.f25752a, this.f25753b);
    }
}
