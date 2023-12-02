package com.google.firebase.components;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class OptionalProvider<T> implements Provider<T>, Deferred<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Deferred.DeferredHandler<Object> f29220c = new Deferred.DeferredHandler() { // from class: com.google.firebase.components.p
        @Override // com.google.firebase.inject.Deferred.DeferredHandler
        public final void handle(Provider provider) {
            OptionalProvider.e(provider);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Provider<Object> f29221d = new Provider() { // from class: com.google.firebase.components.q
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            Object f4;
            f4 = OptionalProvider.f();
            return f4;
        }
    };
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private Deferred.DeferredHandler<T> f29222a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Provider<T> f29223b;

    private OptionalProvider(Deferred.DeferredHandler<T> deferredHandler, Provider<T> provider) {
        this.f29222a = deferredHandler;
        this.f29223b = provider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> OptionalProvider<T> d() {
        return new OptionalProvider<>(f29220c, f29221d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.handle(provider);
        deferredHandler2.handle(provider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> OptionalProvider<T> h(Provider<T> provider) {
        return new OptionalProvider<>(null, provider);
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        return this.f29223b.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Provider<T> provider) {
        Deferred.DeferredHandler<T> deferredHandler;
        if (this.f29223b == f29221d) {
            synchronized (this) {
                deferredHandler = this.f29222a;
                this.f29222a = null;
                this.f29223b = provider;
            }
            deferredHandler.handle(provider);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }

    @Override // com.google.firebase.inject.Deferred
    public void whenAvailable(@NonNull final Deferred.DeferredHandler<T> deferredHandler) {
        Provider<T> provider;
        Provider<T> provider2;
        Provider<T> provider3 = this.f29223b;
        Provider<Object> provider4 = f29221d;
        if (provider3 != provider4) {
            deferredHandler.handle(provider3);
            return;
        }
        synchronized (this) {
            provider = this.f29223b;
            if (provider != provider4) {
                provider2 = provider;
            } else {
                final Deferred.DeferredHandler<T> deferredHandler2 = this.f29222a;
                this.f29222a = new Deferred.DeferredHandler() { // from class: com.google.firebase.components.s
                    @Override // com.google.firebase.inject.Deferred.DeferredHandler
                    public final void handle(Provider provider5) {
                        OptionalProvider.g(Deferred.DeferredHandler.this, deferredHandler, provider5);
                    }
                };
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.handle(provider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Provider provider) {
    }
}
