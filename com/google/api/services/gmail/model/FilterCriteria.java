package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class FilterCriteria extends GenericJson {
    @Key
    private Boolean excludeChats;
    @Key
    private String from;
    @Key
    private Boolean hasAttachment;
    @Key
    private String negatedQuery;
    @Key
    private String query;
    @Key
    private Integer size;
    @Key
    private String sizeComparison;
    @Key
    private String subject;
    @Key
    private String to;

    public Boolean getExcludeChats() {
        return this.excludeChats;
    }

    public String getFrom() {
        return this.from;
    }

    public Boolean getHasAttachment() {
        return this.hasAttachment;
    }

    public String getNegatedQuery() {
        return this.negatedQuery;
    }

    public String getQuery() {
        return this.query;
    }

    public Integer getSize() {
        return this.size;
    }

    public String getSizeComparison() {
        return this.sizeComparison;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getTo() {
        return this.to;
    }

    public FilterCriteria setExcludeChats(Boolean bool) {
        this.excludeChats = bool;
        return this;
    }

    public FilterCriteria setFrom(String str) {
        this.from = str;
        return this;
    }

    public FilterCriteria setHasAttachment(Boolean bool) {
        this.hasAttachment = bool;
        return this;
    }

    public FilterCriteria setNegatedQuery(String str) {
        this.negatedQuery = str;
        return this;
    }

    public FilterCriteria setQuery(String str) {
        this.query = str;
        return this;
    }

    public FilterCriteria setSize(Integer num) {
        this.size = num;
        return this;
    }

    public FilterCriteria setSizeComparison(String str) {
        this.sizeComparison = str;
        return this;
    }

    public FilterCriteria setSubject(String str) {
        this.subject = str;
        return this;
    }

    public FilterCriteria setTo(String str) {
        this.to = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public FilterCriteria set(String str, Object obj) {
        return (FilterCriteria) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public FilterCriteria clone() {
        return (FilterCriteria) super.clone();
    }
}
