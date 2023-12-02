package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.RefreshTokenRequest;
import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import java.io.IOException;
import java.util.Collection;

/* loaded from: classes5.dex */
public class GoogleRefreshTokenRequest extends RefreshTokenRequest {
    public GoogleRefreshTokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, String str, String str2, String str3) {
        super(httpTransport, jsonFactory, new GenericUrl(GoogleOAuthConstants.TOKEN_SERVER_URL), str);
        setClientAuthentication((HttpExecuteInterceptor) new ClientParametersAuthentication(str2, str3));
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public /* bridge */ /* synthetic */ RefreshTokenRequest setScopes(Collection collection) {
        return setScopes((Collection<String>) collection);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public GoogleTokenResponse execute() throws IOException {
        return (GoogleTokenResponse) executeUnparsed().parseAs((Class<Object>) GoogleTokenResponse.class);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest
    public GoogleRefreshTokenRequest setRefreshToken(String str) {
        return (GoogleRefreshTokenRequest) super.setRefreshToken(str);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public /* bridge */ /* synthetic */ TokenRequest setScopes(Collection collection) {
        return setScopes((Collection<String>) collection);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleRefreshTokenRequest setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
        return (GoogleRefreshTokenRequest) super.setClientAuthentication(httpExecuteInterceptor);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleRefreshTokenRequest setGrantType(String str) {
        return (GoogleRefreshTokenRequest) super.setGrantType(str);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleRefreshTokenRequest setRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
        return (GoogleRefreshTokenRequest) super.setRequestInitializer(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleRefreshTokenRequest setScopes(Collection<String> collection) {
        return (GoogleRefreshTokenRequest) super.setScopes(collection);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleRefreshTokenRequest setTokenServerUrl(GenericUrl genericUrl) {
        return (GoogleRefreshTokenRequest) super.setTokenServerUrl(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    public GoogleRefreshTokenRequest set(String str, Object obj) {
        return (GoogleRefreshTokenRequest) super.set(str, obj);
    }
}
