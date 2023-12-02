package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListMessagesResponse extends GenericJson {
    @Key
    private List<Message> messages;
    @Key
    private String nextPageToken;
    @Key
    private Long resultSizeEstimate;

    public List<Message> getMessages() {
        return this.messages;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public Long getResultSizeEstimate() {
        return this.resultSizeEstimate;
    }

    public ListMessagesResponse setMessages(List<Message> list) {
        this.messages = list;
        return this;
    }

    public ListMessagesResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public ListMessagesResponse setResultSizeEstimate(Long l4) {
        this.resultSizeEstimate = l4;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListMessagesResponse set(String str, Object obj) {
        return (ListMessagesResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListMessagesResponse clone() {
        return (ListMessagesResponse) super.clone();
    }
}
