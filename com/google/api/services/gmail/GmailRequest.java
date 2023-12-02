package com.google.api.services.gmail;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public abstract class GmailRequest<T> extends AbstractGoogleJsonClientRequest<T> {
    @Key
    private String alt;
    @Key
    private String fields;
    @Key
    private String key;
    @Key("oauth_token")
    private String oauthToken;
    @Key
    private Boolean prettyPrint;
    @Key
    private String quotaUser;
    @Key
    private String userIp;

    public GmailRequest(Gmail gmail, String str, String str2, Object obj, Class<T> cls) {
        super(gmail, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    public String getFields() {
        return this.fields;
    }

    public String getKey() {
        return this.key;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    public String getUserIp() {
        return this.userIp;
    }

    public GmailRequest<T> setAlt(String str) {
        this.alt = str;
        return this;
    }

    public GmailRequest<T> setFields(String str) {
        this.fields = str;
        return this;
    }

    public GmailRequest<T> setKey(String str) {
        this.key = str;
        return this;
    }

    public GmailRequest<T> setOauthToken(String str) {
        this.oauthToken = str;
        return this;
    }

    public GmailRequest<T> setPrettyPrint(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public GmailRequest<T> setQuotaUser(String str) {
        this.quotaUser = str;
        return this;
    }

    public GmailRequest<T> setUserIp(String str) {
        this.userIp = str;
        return this;
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public final Gmail getAbstractGoogleClient() {
        return (Gmail) super.getAbstractGoogleClient();
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public GmailRequest<T> setDisableGZipContent(boolean z3) {
        return (GmailRequest) super.setDisableGZipContent(z3);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public GmailRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (GmailRequest) super.setRequestHeaders(httpHeaders);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    public GmailRequest<T> set(String str, Object obj) {
        return (GmailRequest) super.set(str, obj);
    }
}
