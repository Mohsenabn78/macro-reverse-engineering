package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class Filter extends GenericJson {
    @Key
    private FilterAction action;
    @Key
    private FilterCriteria criteria;
    @Key
    private String id;

    public FilterAction getAction() {
        return this.action;
    }

    public FilterCriteria getCriteria() {
        return this.criteria;
    }

    public String getId() {
        return this.id;
    }

    public Filter setAction(FilterAction filterAction) {
        this.action = filterAction;
        return this;
    }

    public Filter setCriteria(FilterCriteria filterCriteria) {
        this.criteria = filterCriteria;
        return this;
    }

    public Filter setId(String str) {
        this.id = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Filter set(String str, Object obj) {
        return (Filter) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Filter clone() {
        return (Filter) super.clone();
    }
}
