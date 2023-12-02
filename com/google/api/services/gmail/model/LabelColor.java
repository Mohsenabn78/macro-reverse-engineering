package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes5.dex */
public final class LabelColor extends GenericJson {
    @Key
    private String backgroundColor;
    @Key
    private String textColor;

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public LabelColor setBackgroundColor(String str) {
        this.backgroundColor = str;
        return this;
    }

    public LabelColor setTextColor(String str) {
        this.textColor = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LabelColor set(String str, Object obj) {
        return (LabelColor) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LabelColor clone() {
        return (LabelColor) super.clone();
    }
}
