package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SingleCheck<T> implements Provider<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f18739c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Provider<T> f18740a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f18741b = f18739c;

    private SingleCheck(Provider<T> provider) {
        this.f18740a = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p4) {
        if (!(p4 instanceof SingleCheck) && !(p4 instanceof DoubleCheck)) {
            return new SingleCheck((Provider) Preconditions.checkNotNull(p4));
        }
        return p4;
    }

    @Override // javax.inject.Provider
    public T get() {
        T t3 = (T) this.f18741b;
        if (t3 == f18739c) {
            Provider<T> provider = this.f18740a;
            if (provider == null) {
                return (T) this.f18741b;
            }
            T t4 = provider.get();
            this.f18741b = t4;
            this.f18740a = null;
            return t4;
        }
        return t3;
    }
}
