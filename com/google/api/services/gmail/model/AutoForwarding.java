package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class AutoForwarding extends GenericJson {
    @Key
    private String disposition;
    @Key
    private String emailAddress;
    @Key
    private Boolean enabled;

    public String getDisposition() {
        return this.disposition;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public AutoForwarding setDisposition(String str) {
        this.disposition = str;
        return this;
    }

    public AutoForwarding setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public AutoForwarding setEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public AutoForwarding set(String str, Object obj) {
        return (AutoForwarding) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AutoForwarding clone() {
        return (AutoForwarding) super.clone();
    }
}
