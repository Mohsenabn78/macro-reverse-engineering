package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class SmtpMsa extends GenericJson {
    @Key
    private String host;
    @Key
    private String password;
    @Key
    private Integer port;
    @Key
    private String securityMode;
    @Key
    private String username;

    public String getHost() {
        return this.host;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getPort() {
        return this.port;
    }

    public String getSecurityMode() {
        return this.securityMode;
    }

    public String getUsername() {
        return this.username;
    }

    public SmtpMsa setHost(String str) {
        this.host = str;
        return this;
    }

    public SmtpMsa setPassword(String str) {
        this.password = str;
        return this;
    }

    public SmtpMsa setPort(Integer num) {
        this.port = num;
        return this;
    }

    public SmtpMsa setSecurityMode(String str) {
        this.securityMode = str;
        return this;
    }

    public SmtpMsa setUsername(String str) {
        this.username = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SmtpMsa set(String str, Object obj) {
        return (SmtpMsa) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SmtpMsa clone() {
        return (SmtpMsa) super.clone();
    }
}
