package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DelegateFactory<T> implements Factory<T> {

    /* renamed from: a  reason: collision with root package name */
    private Provider<T> f18722a;

    public static <T> void setDelegate(Provider<T> provider, Provider<T> provider2) {
        Preconditions.checkNotNull(provider2);
        DelegateFactory delegateFactory = (DelegateFactory) provider;
        if (delegateFactory.f18722a == null) {
            delegateFactory.f18722a = provider2;
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Provider<T> a() {
        return (Provider) Preconditions.checkNotNull(this.f18722a);
    }

    @Override // javax.inject.Provider
    public T get() {
        Provider<T> provider = this.f18722a;
        if (provider != null) {
            return provider.get();
        }
        throw new IllegalStateException();
    }

    @Deprecated
    public void setDelegatedProvider(Provider<T> provider) {
        setDelegate(this, provider);
    }
}
