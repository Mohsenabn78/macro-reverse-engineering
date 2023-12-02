package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class FieldDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final String f30073a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Object> f30074b;

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f30075a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Class<?>, Object> f30076b = null;

        Builder(String str) {
            this.f30075a = str;
        }

        @NonNull
        public FieldDescriptor build() {
            Map unmodifiableMap;
            String str = this.f30075a;
            if (this.f30076b == null) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(new HashMap(this.f30076b));
            }
            return new FieldDescriptor(str, unmodifiableMap);
        }

        @NonNull
        public <T extends Annotation> Builder withProperty(@NonNull T t3) {
            if (this.f30076b == null) {
                this.f30076b = new HashMap();
            }
            this.f30076b.put(t3.annotationType(), t3);
            return this;
        }
    }

    @NonNull
    public static Builder builder(@NonNull String str) {
        return new Builder(str);
    }

    @NonNull
    public static FieldDescriptor of(@NonNull String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        if (this.f30073a.equals(fieldDescriptor.f30073a) && this.f30074b.equals(fieldDescriptor.f30074b)) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getName() {
        return this.f30073a;
    }

    @Nullable
    public <T extends Annotation> T getProperty(@NonNull Class<T> cls) {
        return (T) this.f30074b.get(cls);
    }

    public int hashCode() {
        return (this.f30073a.hashCode() * 31) + this.f30074b.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.f30073a + ", properties=" + this.f30074b.values() + "}";
    }

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.f30073a = str;
        this.f30074b = map;
    }
}
