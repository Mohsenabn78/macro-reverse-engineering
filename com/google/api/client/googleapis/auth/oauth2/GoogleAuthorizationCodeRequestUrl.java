package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.AuthorizationRequestUrl;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.util.Collection;

/* loaded from: classes5.dex */
public class GoogleAuthorizationCodeRequestUrl extends AuthorizationCodeRequestUrl {
    @Key("access_type")
    private String accessType;
    @Key("approval_prompt")
    private String approvalPrompt;

    public GoogleAuthorizationCodeRequestUrl(String str, String str2, Collection<String> collection) {
        this(GoogleOAuthConstants.AUTHORIZATION_SERVER_URL, str, str2, collection);
    }

    public final String getAccessType() {
        return this.accessType;
    }

    public final String getApprovalPrompt() {
        return this.approvalPrompt;
    }

    public GoogleAuthorizationCodeRequestUrl setAccessType(String str) {
        this.accessType = str;
        return this;
    }

    public GoogleAuthorizationCodeRequestUrl setApprovalPrompt(String str) {
        this.approvalPrompt = str;
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public /* bridge */ /* synthetic */ AuthorizationCodeRequestUrl setResponseTypes(Collection collection) {
        return setResponseTypes((Collection<String>) collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public /* bridge */ /* synthetic */ AuthorizationCodeRequestUrl setScopes(Collection collection) {
        return setScopes((Collection<String>) collection);
    }

    public GoogleAuthorizationCodeRequestUrl(String str, String str2, String str3, Collection<String> collection) {
        super(str, str2);
        setRedirectUri(str3);
        setScopes(collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public /* bridge */ /* synthetic */ AuthorizationRequestUrl setResponseTypes(Collection collection) {
        return setResponseTypes((Collection<String>) collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public /* bridge */ /* synthetic */ AuthorizationRequestUrl setScopes(Collection collection) {
        return setScopes((Collection<String>) collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public GoogleAuthorizationCodeRequestUrl setClientId(String str) {
        return (GoogleAuthorizationCodeRequestUrl) super.setClientId(str);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public GoogleAuthorizationCodeRequestUrl setRedirectUri(String str) {
        Preconditions.checkNotNull(str);
        return (GoogleAuthorizationCodeRequestUrl) super.setRedirectUri(str);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public GoogleAuthorizationCodeRequestUrl setResponseTypes(Collection<String> collection) {
        return (GoogleAuthorizationCodeRequestUrl) super.setResponseTypes(collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public GoogleAuthorizationCodeRequestUrl setScopes(Collection<String> collection) {
        Preconditions.checkArgument(collection.iterator().hasNext());
        return (GoogleAuthorizationCodeRequestUrl) super.setScopes(collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl
    public GoogleAuthorizationCodeRequestUrl setState(String str) {
        return (GoogleAuthorizationCodeRequestUrl) super.setState(str);
    }

    public GoogleAuthorizationCodeRequestUrl(GoogleClientSecrets googleClientSecrets, String str, Collection<String> collection) {
        this(googleClientSecrets.getDetails().getClientId(), str, collection);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl, com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData
    public GoogleAuthorizationCodeRequestUrl set(String str, Object obj) {
        return (GoogleAuthorizationCodeRequestUrl) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl, com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData, java.util.AbstractMap
    public GoogleAuthorizationCodeRequestUrl clone() {
        return (GoogleAuthorizationCodeRequestUrl) super.clone();
    }
}
