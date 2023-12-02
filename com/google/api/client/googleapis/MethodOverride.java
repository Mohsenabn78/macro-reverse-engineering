package com.google.api.client.googleapis;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class MethodOverride implements HttpExecuteInterceptor, HttpRequestInitializer {
    public static final String HEADER = "X-HTTP-Method-Override";

    /* renamed from: a  reason: collision with root package name */
    private final boolean f25551a;

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f25552a;

        public MethodOverride build() {
            return new MethodOverride(this.f25552a);
        }

        public boolean getOverrideAllMethods() {
            return this.f25552a;
        }

        public Builder setOverrideAllMethods(boolean z3) {
            this.f25552a = z3;
            return this;
        }
    }

    public MethodOverride() {
        this(false);
    }

    private boolean a(HttpRequest httpRequest) throws IOException {
        String requestMethod = httpRequest.getRequestMethod();
        if (requestMethod.equals("POST")) {
            return false;
        }
        if (!requestMethod.equals("GET") ? this.f25551a : httpRequest.getUrl().build().length() > 2048) {
            return true;
        }
        return !httpRequest.getTransport().supportsMethod(requestMethod);
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void initialize(HttpRequest httpRequest) {
        httpRequest.setInterceptor(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void intercept(HttpRequest httpRequest) throws IOException {
        if (a(httpRequest)) {
            String requestMethod = httpRequest.getRequestMethod();
            httpRequest.setRequestMethod("POST");
            httpRequest.getHeaders().set(HEADER, (Object) requestMethod);
            if (requestMethod.equals("GET")) {
                httpRequest.setContent(new UrlEncodedContent(httpRequest.getUrl().clone()));
                httpRequest.getUrl().clear();
            } else if (httpRequest.getContent() == null) {
                httpRequest.setContent(new EmptyContent());
            }
        }
    }

    MethodOverride(boolean z3) {
        this.f25551a = z3;
    }
}
