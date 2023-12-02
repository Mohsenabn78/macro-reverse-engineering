package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class Draft extends GenericJson {
    @Key
    private String id;
    @Key
    private Message message;

    public String getId() {
        return this.id;
    }

    public Message getMessage() {
        return this.message;
    }

    public Draft setId(String str) {
        this.id = str;
        return this;
    }

    public Draft setMessage(Message message) {
        this.message = message;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Draft set(String str, Object obj) {
        return (Draft) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Draft clone() {
        return (Draft) super.clone();
    }
}
