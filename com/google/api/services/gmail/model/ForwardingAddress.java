package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class ForwardingAddress extends GenericJson {
    @Key
    private String forwardingEmail;
    @Key
    private String verificationStatus;

    public String getForwardingEmail() {
        return this.forwardingEmail;
    }

    public String getVerificationStatus() {
        return this.verificationStatus;
    }

    public ForwardingAddress setForwardingEmail(String str) {
        this.forwardingEmail = str;
        return this;
    }

    public ForwardingAddress setVerificationStatus(String str) {
        this.verificationStatus = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ForwardingAddress set(String str, Object obj) {
        return (ForwardingAddress) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ForwardingAddress clone() {
        return (ForwardingAddress) super.clone();
    }
}
