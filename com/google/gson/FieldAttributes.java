package com.google.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class FieldAttributes {

    /* renamed from: a  reason: collision with root package name */
    private final Field f32542a;

    public FieldAttributes(Field field) {
        Objects.requireNonNull(field);
        this.f32542a = field;
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.f32542a.getAnnotation(cls);
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.f32542a.getAnnotations());
    }

    public Class<?> getDeclaredClass() {
        return this.f32542a.getType();
    }

    public Type getDeclaredType() {
        return this.f32542a.getGenericType();
    }

    public Class<?> getDeclaringClass() {
        return this.f32542a.getDeclaringClass();
    }

    public String getName() {
        return this.f32542a.getName();
    }

    public boolean hasModifier(int i4) {
        if ((i4 & this.f32542a.getModifiers()) != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f32542a.toString();
    }
}
