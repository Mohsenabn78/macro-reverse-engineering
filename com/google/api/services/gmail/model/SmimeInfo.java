package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class SmimeInfo extends GenericJson {
    @Key
    private String encryptedKeyPassword;
    @JsonString
    @Key
    private Long expiration;
    @Key
    private String id;
    @Key
    private Boolean isDefault;
    @Key
    private String issuerCn;
    @Key
    private String pem;
    @Key
    private String pkcs12;

    public byte[] decodePkcs12() {
        return Base64.decodeBase64(this.pkcs12);
    }

    public SmimeInfo encodePkcs12(byte[] bArr) {
        this.pkcs12 = Base64.encodeBase64URLSafeString(bArr);
        return this;
    }

    public String getEncryptedKeyPassword() {
        return this.encryptedKeyPassword;
    }

    public Long getExpiration() {
        return this.expiration;
    }

    public String getId() {
        return this.id;
    }

    public Boolean getIsDefault() {
        return this.isDefault;
    }

    public String getIssuerCn() {
        return this.issuerCn;
    }

    public String getPem() {
        return this.pem;
    }

    public String getPkcs12() {
        return this.pkcs12;
    }

    public SmimeInfo setEncryptedKeyPassword(String str) {
        this.encryptedKeyPassword = str;
        return this;
    }

    public SmimeInfo setExpiration(Long l4) {
        this.expiration = l4;
        return this;
    }

    public SmimeInfo setId(String str) {
        this.id = str;
        return this;
    }

    public SmimeInfo setIsDefault(Boolean bool) {
        this.isDefault = bool;
        return this;
    }

    public SmimeInfo setIssuerCn(String str) {
        this.issuerCn = str;
        return this;
    }

    public SmimeInfo setPem(String str) {
        this.pem = str;
        return this;
    }

    public SmimeInfo setPkcs12(String str) {
        this.pkcs12 = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SmimeInfo set(String str, Object obj) {
        return (SmimeInfo) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SmimeInfo clone() {
        return (SmimeInfo) super.clone();
    }
}
