package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListFiltersResponse extends GenericJson {
    @Key
    private List<Filter> filter;

    static {
        Data.nullOf(Filter.class);
    }

    public List<Filter> getFilter() {
        return this.filter;
    }

    public ListFiltersResponse setFilter(List<Filter> list) {
        this.filter = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListFiltersResponse set(String str, Object obj) {
        return (ListFiltersResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListFiltersResponse clone() {
        return (ListFiltersResponse) super.clone();
    }
}
