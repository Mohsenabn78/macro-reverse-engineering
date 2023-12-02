package com.google.firebase.functions.dagger.internal;

import com.google.firebase.functions.dagger.Lazy;

/* loaded from: classes5.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final InstanceFactory<Object> f31405b = new InstanceFactory<>(null);

    /* renamed from: a  reason: collision with root package name */
    private final T f31406a;

    private InstanceFactory(T t3) {
        this.f31406a = t3;
    }

    private static <T> InstanceFactory<T> a() {
        return (InstanceFactory<T>) f31405b;
    }

    public static <T> Factory<T> create(T t3) {
        return new InstanceFactory(Preconditions.checkNotNull(t3, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t3) {
        if (t3 == null) {
            return a();
        }
        return new InstanceFactory(t3);
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.f31406a;
    }
}
