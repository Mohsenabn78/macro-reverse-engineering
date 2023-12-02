package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListSmimeInfoResponse extends GenericJson {
    @Key
    private List<SmimeInfo> smimeInfo;

    public List<SmimeInfo> getSmimeInfo() {
        return this.smimeInfo;
    }

    public ListSmimeInfoResponse setSmimeInfo(List<SmimeInfo> list) {
        this.smimeInfo = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListSmimeInfoResponse set(String str, Object obj) {
        return (ListSmimeInfoResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListSmimeInfoResponse clone() {
        return (ListSmimeInfoResponse) super.clone();
    }
}
