package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListDraftsResponse extends GenericJson {
    @Key
    private List<Draft> drafts;
    @Key
    private String nextPageToken;
    @Key
    private Long resultSizeEstimate;

    static {
        Data.nullOf(Draft.class);
    }

    public List<Draft> getDrafts() {
        return this.drafts;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public Long getResultSizeEstimate() {
        return this.resultSizeEstimate;
    }

    public ListDraftsResponse setDrafts(List<Draft> list) {
        this.drafts = list;
        return this;
    }

    public ListDraftsResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public ListDraftsResponse setResultSizeEstimate(Long l4) {
        this.resultSizeEstimate = l4;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListDraftsResponse set(String str, Object obj) {
        return (ListDraftsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListDraftsResponse clone() {
        return (ListDraftsResponse) super.clone();
    }
}
