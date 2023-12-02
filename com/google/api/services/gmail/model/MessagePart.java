package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class MessagePart extends GenericJson {
    @Key
    private MessagePartBody body;
    @Key
    private String filename;
    @Key
    private List<MessagePartHeader> headers;
    @Key
    private String mimeType;
    @Key
    private String partId;
    @Key
    private List<MessagePart> parts;

    public MessagePartBody getBody() {
        return this.body;
    }

    public String getFilename() {
        return this.filename;
    }

    public List<MessagePartHeader> getHeaders() {
        return this.headers;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getPartId() {
        return this.partId;
    }

    public List<MessagePart> getParts() {
        return this.parts;
    }

    public MessagePart setBody(MessagePartBody messagePartBody) {
        this.body = messagePartBody;
        return this;
    }

    public MessagePart setFilename(String str) {
        this.filename = str;
        return this;
    }

    public MessagePart setHeaders(List<MessagePartHeader> list) {
        this.headers = list;
        return this;
    }

    public MessagePart setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public MessagePart setPartId(String str) {
        this.partId = str;
        return this;
    }

    public MessagePart setParts(List<MessagePart> list) {
        this.parts = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public MessagePart set(String str, Object obj) {
        return (MessagePart) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public MessagePart clone() {
        return (MessagePart) super.clone();
    }
}
