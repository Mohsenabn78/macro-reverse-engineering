package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.util.Collection;

/* loaded from: classes5.dex */
public class PasswordTokenRequest extends TokenRequest {
    @Key
    private String password;
    @Key
    private String username;

    public PasswordTokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str, String str2) {
        super(httpTransport, jsonFactory, genericUrl, "password");
        setUsername(str);
        setPassword(str2);
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getUsername() {
        return this.username;
    }

    public PasswordTokenRequest setPassword(String str) {
        this.password = (String) Preconditions.checkNotNull(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public /* bridge */ /* synthetic */ TokenRequest setScopes(Collection collection) {
        return setScopes((Collection<String>) collection);
    }

    public PasswordTokenRequest setUsername(String str) {
        this.username = (String) Preconditions.checkNotNull(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public PasswordTokenRequest setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
        return (PasswordTokenRequest) super.setClientAuthentication(httpExecuteInterceptor);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public PasswordTokenRequest setGrantType(String str) {
        return (PasswordTokenRequest) super.setGrantType(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public PasswordTokenRequest setRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
        return (PasswordTokenRequest) super.setRequestInitializer(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public PasswordTokenRequest setScopes(Collection<String> collection) {
        return (PasswordTokenRequest) super.setScopes(collection);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public PasswordTokenRequest setTokenServerUrl(GenericUrl genericUrl) {
        return (PasswordTokenRequest) super.setTokenServerUrl(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    public PasswordTokenRequest set(String str, Object obj) {
        return (PasswordTokenRequest) super.set(str, obj);
    }
}
