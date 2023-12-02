package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class Label extends GenericJson {
    @Key
    private LabelColor color;
    @Key
    private String id;
    @Key
    private String labelListVisibility;
    @Key
    private String messageListVisibility;
    @Key
    private Integer messagesTotal;
    @Key
    private Integer messagesUnread;
    @Key
    private String name;
    @Key
    private Integer threadsTotal;
    @Key
    private Integer threadsUnread;
    @Key
    private String type;

    public LabelColor getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }

    public String getLabelListVisibility() {
        return this.labelListVisibility;
    }

    public String getMessageListVisibility() {
        return this.messageListVisibility;
    }

    public Integer getMessagesTotal() {
        return this.messagesTotal;
    }

    public Integer getMessagesUnread() {
        return this.messagesUnread;
    }

    public String getName() {
        return this.name;
    }

    public Integer getThreadsTotal() {
        return this.threadsTotal;
    }

    public Integer getThreadsUnread() {
        return this.threadsUnread;
    }

    public String getType() {
        return this.type;
    }

    public Label setColor(LabelColor labelColor) {
        this.color = labelColor;
        return this;
    }

    public Label setId(String str) {
        this.id = str;
        return this;
    }

    public Label setLabelListVisibility(String str) {
        this.labelListVisibility = str;
        return this;
    }

    public Label setMessageListVisibility(String str) {
        this.messageListVisibility = str;
        return this;
    }

    public Label setMessagesTotal(Integer num) {
        this.messagesTotal = num;
        return this;
    }

    public Label setMessagesUnread(Integer num) {
        this.messagesUnread = num;
        return this;
    }

    public Label setName(String str) {
        this.name = str;
        return this;
    }

    public Label setThreadsTotal(Integer num) {
        this.threadsTotal = num;
        return this;
    }

    public Label setThreadsUnread(Integer num) {
        this.threadsUnread = num;
        return this;
    }

    public Label setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Label set(String str, Object obj) {
        return (Label) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Label clone() {
        return (Label) super.clone();
    }
}
