package com.google.api.client.auth.oauth2;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public class AuthorizationCodeRequestUrl extends AuthorizationRequestUrl {
    public AuthorizationCodeRequestUrl(String str, String str2) {
        super(str, str2, Collections.singleton("code"));
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public /* bridge */ /* synthetic */ AuthorizationRequestUrl setResponseTypes(Collection collection) {
        return setResponseTypes((Collection<String>) collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public /* bridge */ /* synthetic */ AuthorizationRequestUrl setScopes(Collection collection) {
        return setScopes((Collection<String>) collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public AuthorizationCodeRequestUrl setClientId(String str) {
        return (AuthorizationCodeRequestUrl) super.setClientId(str);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public AuthorizationCodeRequestUrl setRedirectUri(String str) {
        return (AuthorizationCodeRequestUrl) super.setRedirectUri(str);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public AuthorizationCodeRequestUrl setResponseTypes(Collection<String> collection) {
        return (AuthorizationCodeRequestUrl) super.setResponseTypes(collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public AuthorizationCodeRequestUrl setScopes(Collection<String> collection) {
        return (AuthorizationCodeRequestUrl) super.setScopes(collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public AuthorizationCodeRequestUrl setState(String str) {
        return (AuthorizationCodeRequestUrl) super.setState(str);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationRequestUrl, com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData
    public AuthorizationCodeRequestUrl set(String str, Object obj) {
        return (AuthorizationCodeRequestUrl) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationRequestUrl, com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AuthorizationCodeRequestUrl clone() {
        return (AuthorizationCodeRequestUrl) super.clone();
    }
}
