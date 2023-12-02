package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListThreadsResponse extends GenericJson {
    @Key
    private String nextPageToken;
    @Key
    private Long resultSizeEstimate;
    @Key
    private List<Thread> threads;

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public Long getResultSizeEstimate() {
        return this.resultSizeEstimate;
    }

    public List<Thread> getThreads() {
        return this.threads;
    }

    public ListThreadsResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public ListThreadsResponse setResultSizeEstimate(Long l4) {
        this.resultSizeEstimate = l4;
        return this;
    }

    public ListThreadsResponse setThreads(List<Thread> list) {
        this.threads = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListThreadsResponse set(String str, Object obj) {
        return (ListThreadsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListThreadsResponse clone() {
        return (ListThreadsResponse) super.clone();
    }
}
