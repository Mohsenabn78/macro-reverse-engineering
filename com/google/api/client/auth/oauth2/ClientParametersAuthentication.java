package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Data;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes5.dex */
public class ClientParametersAuthentication implements HttpRequestInitializer, HttpExecuteInterceptor {

    /* renamed from: a  reason: collision with root package name */
    private final String f25496a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25497b;

    public ClientParametersAuthentication(String str, String str2) {
        this.f25496a = (String) Preconditions.checkNotNull(str);
        this.f25497b = str2;
    }

    public final String getClientId() {
        return this.f25496a;
    }

    public final String getClientSecret() {
        return this.f25497b;
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void initialize(HttpRequest httpRequest) throws IOException {
        httpRequest.setInterceptor(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void intercept(HttpRequest httpRequest) throws IOException {
        Map<String, Object> mapOf = Data.mapOf(UrlEncodedContent.getContent(httpRequest).getData());
        mapOf.put("client_id", this.f25496a);
        String str = this.f25497b;
        if (str != null) {
            mapOf.put("client_secret", str);
        }
    }
}
