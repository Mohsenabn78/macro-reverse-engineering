package com.google.firebase.functions;

import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.functions.dagger.internal.DaggerGenerated;
import com.google.firebase.functions.dagger.internal.Factory;
import com.google.firebase.functions.dagger.internal.QualifierMetadata;
import com.google.firebase.functions.dagger.internal.ScopeMetadata;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Deferred;
import java.util.concurrent.Executor;
import javax.inject.Provider;

@QualifierMetadata({"com.google.firebase.annotations.concurrent.Lightweight"})
@DaggerGenerated
@ScopeMetadata("javax.inject.Singleton")
/* loaded from: classes5.dex */
public final class FirebaseContextProvider_Factory implements Factory<FirebaseContextProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<com.google.firebase.inject.Provider<InternalAuthProvider>> f31353a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.google.firebase.inject.Provider<FirebaseInstanceIdInternal>> f31354b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Deferred<InteropAppCheckTokenProvider>> f31355c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Executor> f31356d;

    public FirebaseContextProvider_Factory(Provider<com.google.firebase.inject.Provider<InternalAuthProvider>> provider, Provider<com.google.firebase.inject.Provider<FirebaseInstanceIdInternal>> provider2, Provider<Deferred<InteropAppCheckTokenProvider>> provider3, Provider<Executor> provider4) {
        this.f31353a = provider;
        this.f31354b = provider2;
        this.f31355c = provider3;
        this.f31356d = provider4;
    }

    public static FirebaseContextProvider_Factory create(Provider<com.google.firebase.inject.Provider<InternalAuthProvider>> provider, Provider<com.google.firebase.inject.Provider<FirebaseInstanceIdInternal>> provider2, Provider<Deferred<InteropAppCheckTokenProvider>> provider3, Provider<Executor> provider4) {
        return new FirebaseContextProvider_Factory(provider, provider2, provider3, provider4);
    }

    public static FirebaseContextProvider newInstance(com.google.firebase.inject.Provider<InternalAuthProvider> provider, com.google.firebase.inject.Provider<FirebaseInstanceIdInternal> provider2, Deferred<InteropAppCheckTokenProvider> deferred, Executor executor) {
        return new FirebaseContextProvider(provider, provider2, deferred, executor);
    }

    @Override // javax.inject.Provider
    public FirebaseContextProvider get() {
        return newInstance(this.f31353a.get(), this.f31354b.get(), this.f31355c.get(), this.f31356d.get());
    }
}
