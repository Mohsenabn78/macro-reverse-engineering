package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class JsonObject extends JsonElement {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedTreeMap<String, JsonElement> f32596a = new LinkedTreeMap<>(false);

    public void add(String str, JsonElement jsonElement) {
        LinkedTreeMap<String, JsonElement> linkedTreeMap = this.f32596a;
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public void addProperty(String str, String str2) {
        add(str, str2 == null ? JsonNull.INSTANCE : new JsonPrimitive(str2));
    }

    public Map<String, JsonElement> asMap() {
        return this.f32596a;
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.f32596a.entrySet();
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof JsonObject) || !((JsonObject) obj).f32596a.equals(this.f32596a))) {
            return false;
        }
        return true;
    }

    public JsonElement get(String str) {
        return this.f32596a.get(str);
    }

    public JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.f32596a.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.f32596a.get(str);
    }

    public JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.f32596a.get(str);
    }

    public boolean has(String str) {
        return this.f32596a.containsKey(str);
    }

    public int hashCode() {
        return this.f32596a.hashCode();
    }

    public boolean isEmpty() {
        if (this.f32596a.size() == 0) {
            return true;
        }
        return false;
    }

    public Set<String> keySet() {
        return this.f32596a.keySet();
    }

    public JsonElement remove(String str) {
        return this.f32596a.remove(str);
    }

    public int size() {
        return this.f32596a.size();
    }

    public void addProperty(String str, Number number) {
        add(str, number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, JsonElement> entry : this.f32596a.entrySet()) {
            jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return jsonObject;
    }

    public void addProperty(String str, Boolean bool) {
        add(str, bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    public void addProperty(String str, Character ch) {
        add(str, ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }
}
