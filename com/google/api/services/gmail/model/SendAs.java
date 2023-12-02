package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class SendAs extends GenericJson {
    @Key
    private String displayName;
    @Key
    private Boolean isDefault;
    @Key
    private Boolean isPrimary;
    @Key
    private String replyToAddress;
    @Key
    private String sendAsEmail;
    @Key
    private String signature;
    @Key
    private SmtpMsa smtpMsa;
    @Key
    private Boolean treatAsAlias;
    @Key
    private String verificationStatus;

    public String getDisplayName() {
        return this.displayName;
    }

    public Boolean getIsDefault() {
        return this.isDefault;
    }

    public Boolean getIsPrimary() {
        return this.isPrimary;
    }

    public String getReplyToAddress() {
        return this.replyToAddress;
    }

    public String getSendAsEmail() {
        return this.sendAsEmail;
    }

    public String getSignature() {
        return this.signature;
    }

    public SmtpMsa getSmtpMsa() {
        return this.smtpMsa;
    }

    public Boolean getTreatAsAlias() {
        return this.treatAsAlias;
    }

    public String getVerificationStatus() {
        return this.verificationStatus;
    }

    public SendAs setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public SendAs setIsDefault(Boolean bool) {
        this.isDefault = bool;
        return this;
    }

    public SendAs setIsPrimary(Boolean bool) {
        this.isPrimary = bool;
        return this;
    }

    public SendAs setReplyToAddress(String str) {
        this.replyToAddress = str;
        return this;
    }

    public SendAs setSendAsEmail(String str) {
        this.sendAsEmail = str;
        return this;
    }

    public SendAs setSignature(String str) {
        this.signature = str;
        return this;
    }

    public SendAs setSmtpMsa(SmtpMsa smtpMsa) {
        this.smtpMsa = smtpMsa;
        return this;
    }

    public SendAs setTreatAsAlias(Boolean bool) {
        this.treatAsAlias = bool;
        return this;
    }

    public SendAs setVerificationStatus(String str) {
        this.verificationStatus = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SendAs set(String str, Object obj) {
        return (SendAs) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SendAs clone() {
        return (SendAs) super.clone();
    }
}
