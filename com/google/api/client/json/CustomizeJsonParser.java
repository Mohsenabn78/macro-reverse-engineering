package com.google.api.client.json;

import com.google.api.client.util.Beta;
import java.lang.reflect.Field;
import java.util.Collection;

@Beta
/* loaded from: classes5.dex */
public class CustomizeJsonParser {
    public Collection<Object> newInstanceForArray(Object obj, Field field) {
        return null;
    }

    public Object newInstanceForObject(Object obj, Class<?> cls) {
        return null;
    }

    public boolean stopAt(Object obj, String str) {
        return false;
    }

    public void handleUnrecognizedKey(Object obj, String str) {
    }
}
