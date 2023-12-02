package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class HistoryLabelAdded extends GenericJson {
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

    public HistoryLabelAdded setLabelIds(List<String> list) {
        this.labelIds = list;
        return this;
    }

    public HistoryLabelAdded setMessage(Message message) {
        this.message = message;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public HistoryLabelAdded set(String str, Object obj) {
        return (HistoryLabelAdded) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public HistoryLabelAdded clone() {
        return (HistoryLabelAdded) super.clone();
    }
}
