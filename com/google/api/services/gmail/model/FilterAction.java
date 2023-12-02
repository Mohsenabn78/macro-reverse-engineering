package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class FilterAction extends GenericJson {
    @Key
    private List<String> addLabelIds;
    @Key
    private String forward;
    @Key
    private List<String> removeLabelIds;

    public List<String> getAddLabelIds() {
        return this.addLabelIds;
    }

    public String getForward() {
        return this.forward;
    }

    public List<String> getRemoveLabelIds() {
        return this.removeLabelIds;
    }

    public FilterAction setAddLabelIds(List<String> list) {
        this.addLabelIds = list;
        return this;
    }

    public FilterAction setForward(String str) {
        this.forward = str;
        return this;
    }

    public FilterAction setRemoveLabelIds(List<String> list) {
        this.removeLabelIds = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public FilterAction set(String str, Object obj) {
        return (FilterAction) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public FilterAction clone() {
        return (FilterAction) super.clone();
    }
}
