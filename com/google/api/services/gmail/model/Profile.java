package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public final class Profile extends GenericJson {
    @Key
    private String emailAddress;
    @JsonString
    @Key
    private BigInteger historyId;
    @Key
    private Integer messagesTotal;
    @Key
    private Integer threadsTotal;

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public BigInteger getHistoryId() {
        return this.historyId;
    }

    public Integer getMessagesTotal() {
        return this.messagesTotal;
    }

    public Integer getThreadsTotal() {
        return this.threadsTotal;
    }

    public Profile setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public Profile setHistoryId(BigInteger bigInteger) {
        this.historyId = bigInteger;
        return this;
    }

    public Profile setMessagesTotal(Integer num) {
        this.messagesTotal = num;
        return this;
    }

    public Profile setThreadsTotal(Integer num) {
        this.threadsTotal = num;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Profile set(String str, Object obj) {
        return (Profile) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Profile clone() {
        return (Profile) super.clone();
    }
}
