package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes5.dex */
public class Lazy<T> implements Provider<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f29215c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f29216a = f29215c;

    /* renamed from: b  reason: collision with root package name */
    private volatile Provider<T> f29217b;

    public Lazy(Provider<T> provider) {
        this.f29217b = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t3 = (T) this.f29216a;
        Object obj = f29215c;
        if (t3 == obj) {
            synchronized (this) {
                t3 = this.f29216a;
                if (t3 == obj) {
                    t3 = this.f29217b.get();
                    this.f29216a = t3;
                    this.f29217b = null;
                }
            }
        }
        return t3;
    }
}
