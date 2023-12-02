package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class BatchDeleteMessagesRequest extends GenericJson {
    @Key
    private List<String> ids;

    public List<String> getIds() {
        return this.ids;
    }

    public BatchDeleteMessagesRequest setIds(List<String> list) {
        this.ids = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public BatchDeleteMessagesRequest set(String str, Object obj) {
        return (BatchDeleteMessagesRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public BatchDeleteMessagesRequest clone() {
        return (BatchDeleteMessagesRequest) super.clone();
    }
}
