package com.nineoldandroids.util;

/* loaded from: classes6.dex */
public abstract class Property<T, V> {

    /* renamed from: a  reason: collision with root package name */
    private final String f36407a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<V> f36408b;

    public Property(Class<V> cls, String str) {
        this.f36407a = str;
        this.f36408b = cls;
    }

    public static <T, V> Property<T, V> of(Class<T> cls, Class<V> cls2, String str) {
        return new a(cls, cls2, str);
    }

    public abstract V get(T t3);

    public String getName() {
        return this.f36407a;
    }

    public Class<V> getType() {
        return this.f36408b;
    }

    public boolean isReadOnly() {
        return false;
    }

    public void set(T t3, V v3) {
        throw new UnsupportedOperationException("Property " + getName() + " is read-only");
    }
}
