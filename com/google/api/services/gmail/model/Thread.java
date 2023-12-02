package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.math.BigInteger;
import java.util.List;

/* loaded from: classes5.dex */
public final class Thread extends GenericJson {
    @JsonString
    @Key
    private BigInteger historyId;
    @Key
    private String id;
    @Key
    private List<Message> messages;
    @Key
    private String snippet;

    static {
        Data.nullOf(Message.class);
    }

    public BigInteger getHistoryId() {
        return this.historyId;
    }

    public String getId() {
        return this.id;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public Thread setHistoryId(BigInteger bigInteger) {
        this.historyId = bigInteger;
        return this;
    }

    public Thread setId(String str) {
        this.id = str;
        return this;
    }

    public Thread setMessages(List<Message> list) {
        this.messages = list;
        return this;
    }

    public Thread setSnippet(String str) {
        this.snippet = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Thread set(String str, Object obj) {
        return (Thread) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Thread clone() {
        return (Thread) super.clone();
    }
}
