package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.math.BigInteger;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListHistoryResponse extends GenericJson {
    @Key
    private List<History> history;
    @JsonString
    @Key
    private BigInteger historyId;
    @Key
    private String nextPageToken;

    static {
        Data.nullOf(History.class);
    }

    public List<History> getHistory() {
        return this.history;
    }

    public BigInteger getHistoryId() {
        return this.historyId;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ListHistoryResponse setHistory(List<History> list) {
        this.history = list;
        return this;
    }

    public ListHistoryResponse setHistoryId(BigInteger bigInteger) {
        this.historyId = bigInteger;
        return this;
    }

    public ListHistoryResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListHistoryResponse set(String str, Object obj) {
        return (ListHistoryResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListHistoryResponse clone() {
        return (ListHistoryResponse) super.clone();
    }
}
