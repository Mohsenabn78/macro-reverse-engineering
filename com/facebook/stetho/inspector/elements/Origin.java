package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.json.annotation.JsonValue;

/* loaded from: classes3.dex */
public enum Origin {
    INJECTED("injected"),
    USER_AGENT("user-agent"),
    INSPECTOR("inspector"),
    REGULAR("regular");
    
    private final String mValue;

    Origin(String str) {
        this.mValue = str;
    }

    @JsonValue
    public String getProtocolValue() {
        return this.mValue;
    }
}
