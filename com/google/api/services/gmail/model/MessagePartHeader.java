package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class MessagePartHeader extends GenericJson {
    @Key
    private String name;
    @Key
    private String value;

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public MessagePartHeader setName(String str) {
        this.name = str;
        return this;
    }

    public MessagePartHeader setValue(String str) {
        this.value = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public MessagePartHeader set(String str, Object obj) {
        return (MessagePartHeader) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public MessagePartHeader clone() {
        return (MessagePartHeader) super.clone();
    }
}
