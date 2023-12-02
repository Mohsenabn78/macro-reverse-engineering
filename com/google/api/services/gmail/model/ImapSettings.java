package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class ImapSettings extends GenericJson {
    @Key
    private Boolean autoExpunge;
    @Key
    private Boolean enabled;
    @Key
    private String expungeBehavior;
    @Key
    private Integer maxFolderSize;

    public Boolean getAutoExpunge() {
        return this.autoExpunge;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public String getExpungeBehavior() {
        return this.expungeBehavior;
    }

    public Integer getMaxFolderSize() {
        return this.maxFolderSize;
    }

    public ImapSettings setAutoExpunge(Boolean bool) {
        this.autoExpunge = bool;
        return this;
    }

    public ImapSettings setEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public ImapSettings setExpungeBehavior(String str) {
        this.expungeBehavior = str;
        return this;
    }

    public ImapSettings setMaxFolderSize(Integer num) {
        this.maxFolderSize = num;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ImapSettings set(String str, Object obj) {
        return (ImapSettings) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ImapSettings clone() {
        return (ImapSettings) super.clone();
    }
}
