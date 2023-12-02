package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class HistoryLabelRemoved extends GenericJson {
    @Key
    private List<String> labelIds;
    @Key
    private Message message;

    public List<String> getLabelIds() {
        return this.labelIds;
    }

    public Message getMessage() {
        return this.message;
    }

    public HistoryLabelRemoved setLabelIds(List<String> list) {
        this.labelIds = list;
        return this;
    }

    public HistoryLabelRemoved setMessage(Message message) {
        this.message = message;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public HistoryLabelRemoved set(String str, Object obj) {
        return (HistoryLabelRemoved) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public HistoryLabelRemoved clone() {
        return (HistoryLabelRemoved) super.clone();
    }
}
