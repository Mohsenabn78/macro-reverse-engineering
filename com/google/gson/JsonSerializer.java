package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t3, Type type, JsonSerializationContext jsonSerializationContext);
}
