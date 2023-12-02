package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class LazySet<T> implements Provider<Set<T>> {

    /* renamed from: b  reason: collision with root package name */
    private volatile Set<T> f29219b = null;

    /* renamed from: a  reason: collision with root package name */
    private volatile Set<Provider<T>> f29218a = Collections.newSetFromMap(new ConcurrentHashMap());

    LazySet(Collection<Provider<T>> collection) {
        this.f29218a.addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LazySet<?> b(Collection<Provider<?>> collection) {
        return new LazySet<>((Set) collection);
    }

    private synchronized void d() {
        for (Provider<T> provider : this.f29218a) {
            this.f29219b.add(provider.get());
        }
        this.f29218a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Provider<T> provider) {
        if (this.f29219b == null) {
            this.f29218a.add(provider);
        } else {
            this.f29219b.add(provider.get());
        }
    }

    @Override // com.google.firebase.inject.Provider
    /* renamed from: c */
    public Set<T> get() {
        if (this.f29219b == null) {
            synchronized (this) {
                if (this.f29219b == null) {
                    this.f29219b = Collections.newSetFromMap(new ConcurrentHashMap());
                    d();
                }
            }
        }
        return Collections.unmodifiableSet(this.f29219b);
    }
}
