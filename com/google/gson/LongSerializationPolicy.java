package com.google.gson;

/* loaded from: classes5.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l4) {
            if (l4 == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l4);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l4) {
            if (l4 == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l4.toString());
        }
    };

    public abstract JsonElement serialize(Long l4);
}
