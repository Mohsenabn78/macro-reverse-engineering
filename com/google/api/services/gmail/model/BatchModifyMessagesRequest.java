package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class BatchModifyMessagesRequest extends GenericJson {
    @Key
    private List<String> addLabelIds;
    @Key
    private List<String> ids;
    @Key
    private List<String> removeLabelIds;

    public List<String> getAddLabelIds() {
        return this.addLabelIds;
    }

    public List<String> getIds() {
        return this.ids;
    }

    public List<String> getRemoveLabelIds() {
        return this.removeLabelIds;
    }

    public BatchModifyMessagesRequest setAddLabelIds(List<String> list) {
        this.addLabelIds = list;
        return this;
    }

    public BatchModifyMessagesRequest setIds(List<String> list) {
        this.ids = list;
        return this;
    }

    public BatchModifyMessagesRequest setRemoveLabelIds(List<String> list) {
        this.removeLabelIds = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public BatchModifyMessagesRequest set(String str, Object obj) {
        return (BatchModifyMessagesRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public BatchModifyMessagesRequest clone() {
        return (BatchModifyMessagesRequest) super.clone();
    }
}
