package com.google.firebase.components;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
public final class Qualified<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Annotation> f29224a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<T> f29225b;

    /* loaded from: classes5.dex */
    private @interface Unqualified {
    }

    public Qualified(Class<? extends Annotation> cls, Class<T> cls2) {
        this.f29224a = cls;
        this.f29225b = cls2;
    }

    public static <T> Qualified<T> qualified(Class<? extends Annotation> cls, Class<T> cls2) {
        return new Qualified<>(cls, cls2);
    }

    public static <T> Qualified<T> unqualified(Class<T> cls) {
        return new Qualified<>(Unqualified.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qualified.class != obj.getClass()) {
            return false;
        }
        Qualified qualified = (Qualified) obj;
        if (!this.f29225b.equals(qualified.f29225b)) {
            return false;
        }
        return this.f29224a.equals(qualified.f29224a);
    }

    public int hashCode() {
        return (this.f29225b.hashCode() * 31) + this.f29224a.hashCode();
    }

    public String toString() {
        if (this.f29224a == Unqualified.class) {
            return this.f29225b.getName();
        }
        return "@" + this.f29224a.getName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f29225b.getName();
    }
}
