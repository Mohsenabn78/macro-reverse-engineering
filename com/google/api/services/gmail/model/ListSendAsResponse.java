package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListSendAsResponse extends GenericJson {
    @Key
    private List<SendAs> sendAs;

    public List<SendAs> getSendAs() {
        return this.sendAs;
    }

    public ListSendAsResponse setSendAs(List<SendAs> list) {
        this.sendAs = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListSendAsResponse set(String str, Object obj) {
        return (ListSendAsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListSendAsResponse clone() {
        return (ListSendAsResponse) super.clone();
    }
}
