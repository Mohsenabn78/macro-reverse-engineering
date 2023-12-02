package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class WatchRequest extends GenericJson {
    @Key
    private String labelFilterAction;
    @Key
    private List<String> labelIds;
    @Key
    private String topicName;

    public String getLabelFilterAction() {
        return this.labelFilterAction;
    }

    public List<String> getLabelIds() {
        return this.labelIds;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public WatchRequest setLabelFilterAction(String str) {
        this.labelFilterAction = str;
        return this;
    }

    public WatchRequest setLabelIds(List<String> list) {
        this.labelIds = list;
        return this;
    }

    public WatchRequest setTopicName(String str) {
        this.topicName = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public WatchRequest set(String str, Object obj) {
        return (WatchRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public WatchRequest clone() {
        return (WatchRequest) super.clone();
    }
}
