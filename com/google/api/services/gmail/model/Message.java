package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Key;
import java.math.BigInteger;
import java.util.List;

/* loaded from: classes5.dex */
public final class Message extends GenericJson {
    @JsonString
    @Key
    private BigInteger historyId;
    @Key
    private String id;
    @JsonString
    @Key
    private Long internalDate;
    @Key
    private List<String> labelIds;
    @Key
    private MessagePart payload;
    @Key
    private String raw;
    @Key
    private Integer sizeEstimate;
    @Key
    private String snippet;
    @Key
    private String threadId;

    public byte[] decodeRaw() {
        return Base64.decodeBase64(this.raw);
    }

    public Message encodeRaw(byte[] bArr) {
        this.raw = Base64.encodeBase64URLSafeString(bArr);
        return this;
    }

    public BigInteger getHistoryId() {
        return this.historyId;
    }

    public String getId() {
        return this.id;
    }

    public Long getInternalDate() {
        return this.internalDate;
    }

    public List<String> getLabelIds() {
        return this.labelIds;
    }

    public MessagePart getPayload() {
        return this.payload;
    }

    public String getRaw() {
        return this.raw;
    }

    public Integer getSizeEstimate() {
        return this.sizeEstimate;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public Message setHistoryId(BigInteger bigInteger) {
        this.historyId = bigInteger;
        return this;
    }

    public Message setId(String str) {
        this.id = str;
        return this;
    }

    public Message setInternalDate(Long l4) {
        this.internalDate = l4;
        return this;
    }

    public Message setLabelIds(List<String> list) {
        this.labelIds = list;
        return this;
    }

    public Message setPayload(MessagePart messagePart) {
        this.payload = messagePart;
        return this;
    }

    public Message setRaw(String str) {
        this.raw = str;
        return this;
    }

    public Message setSizeEstimate(Integer num) {
        this.sizeEstimate = num;
        return this;
    }

    public Message setSnippet(String str) {
        this.snippet = str;
        return this;
    }

    public Message setThreadId(String str) {
        this.threadId = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Message set(String str, Object obj) {
        return (Message) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Message clone() {
        return (Message) super.clone();
    }
}
