package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListLabelsResponse extends GenericJson {
    @Key
    private List<Label> labels;

    static {
        Data.nullOf(Label.class);
    }

    public List<Label> getLabels() {
        return this.labels;
    }

    public ListLabelsResponse setLabels(List<Label> list) {
        this.labels = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListLabelsResponse set(String str, Object obj) {
        return (ListLabelsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListLabelsResponse clone() {
        return (ListLabelsResponse) super.clone();
    }
}
