package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class HistoryMessageAdded extends GenericJson {
    @Key
    private Message message;

    public Message getMessage() {
        return this.message;
    }

    public HistoryMessageAdded setMessage(Message message) {
        this.message = message;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public HistoryMessageAdded set(String str, Object obj) {
        return (HistoryMessageAdded) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public HistoryMessageAdded clone() {
        return (HistoryMessageAdded) super.clone();
    }
}
