package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class MessagePartBody extends GenericJson {
    @Key
    private String attachmentId;
    @Key
    private String data;
    @Key
    private Integer size;

    public byte[] decodeData() {
        return Base64.decodeBase64(this.data);
    }

    public MessagePartBody encodeData(byte[] bArr) {
        this.data = Base64.encodeBase64URLSafeString(bArr);
        return this;
    }

    public String getAttachmentId() {
        return this.attachmentId;
    }

    public String getData() {
        return this.data;
    }

    public Integer getSize() {
        return this.size;
    }

    public MessagePartBody setAttachmentId(String str) {
        this.attachmentId = str;
        return this;
    }

    public MessagePartBody setData(String str) {
        this.data = str;
        return this;
    }

    public MessagePartBody setSize(Integer num) {
        this.size = num;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public MessagePartBody set(String str, Object obj) {
        return (MessagePartBody) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public MessagePartBody clone() {
        return (MessagePartBody) super.clone();
    }
}
