package com.google.gson;

/* loaded from: classes5.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    public boolean equals(Object obj) {
        return obj instanceof JsonNull;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    @Override // com.google.gson.JsonElement
    public JsonNull deepCopy() {
        return INSTANCE;
    }
}
