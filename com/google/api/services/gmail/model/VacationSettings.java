package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class VacationSettings extends GenericJson {
    @Key
    private Boolean enableAutoReply;
    @JsonString
    @Key
    private Long endTime;
    @Key
    private String responseBodyHtml;
    @Key
    private String responseBodyPlainText;
    @Key
    private String responseSubject;
    @Key
    private Boolean restrictToContacts;
    @Key
    private Boolean restrictToDomain;
    @JsonString
    @Key
    private Long startTime;

    public Boolean getEnableAutoReply() {
        return this.enableAutoReply;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public String getResponseBodyHtml() {
        return this.responseBodyHtml;
    }

    public String getResponseBodyPlainText() {
        return this.responseBodyPlainText;
    }

    public String getResponseSubject() {
        return this.responseSubject;
    }

    public Boolean getRestrictToContacts() {
        return this.restrictToContacts;
    }

    public Boolean getRestrictToDomain() {
        return this.restrictToDomain;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public VacationSettings setEnableAutoReply(Boolean bool) {
        this.enableAutoReply = bool;
        return this;
    }

    public VacationSettings setEndTime(Long l4) {
        this.endTime = l4;
        return this;
    }

    public VacationSettings setResponseBodyHtml(String str) {
        this.responseBodyHtml = str;
        return this;
    }

    public VacationSettings setResponseBodyPlainText(String str) {
        this.responseBodyPlainText = str;
        return this;
    }

    public VacationSettings setResponseSubject(String str) {
        this.responseSubject = str;
        return this;
    }

    public VacationSettings setRestrictToContacts(Boolean bool) {
        this.restrictToContacts = bool;
        return this;
    }

    public VacationSettings setRestrictToDomain(Boolean bool) {
        this.restrictToDomain = bool;
        return this;
    }

    public VacationSettings setStartTime(Long l4) {
        this.startTime = l4;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VacationSettings set(String str, Object obj) {
        return (VacationSettings) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VacationSettings clone() {
        return (VacationSettings) super.clone();
    }
}
