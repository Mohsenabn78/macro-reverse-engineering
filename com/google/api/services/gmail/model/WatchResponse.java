package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public final class WatchResponse extends GenericJson {
    @JsonString
    @Key
    private Long expiration;
    @JsonString
    @Key
    private BigInteger historyId;

    public Long getExpiration() {
        return this.expiration;
    }

    public BigInteger getHistoryId() {
        return this.historyId;
    }

    public WatchResponse setExpiration(Long l4) {
        this.expiration = l4;
        return this;
    }

    public WatchResponse setHistoryId(BigInteger bigInteger) {
        this.historyId = bigInteger;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public WatchResponse set(String str, Object obj) {
        return (WatchResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public WatchResponse clone() {
        return (WatchResponse) super.clone();
    }
}
