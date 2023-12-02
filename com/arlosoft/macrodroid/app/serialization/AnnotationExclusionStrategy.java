package com.arlosoft.macrodroid.app.serialization;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/* loaded from: classes3.dex */
public class AnnotationExclusionStrategy implements ExclusionStrategy {
    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if (fieldAttributes.getAnnotation(Exclude.class) != null) {
            return true;
        }
        return false;
    }
}
