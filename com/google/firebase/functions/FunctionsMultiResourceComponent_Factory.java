package com.google.firebase.functions;

import com.google.firebase.functions.FunctionsMultiResourceComponent;
import com.google.firebase.functions.dagger.internal.DaggerGenerated;
import com.google.firebase.functions.dagger.internal.Factory;
import com.google.firebase.functions.dagger.internal.QualifierMetadata;
import com.google.firebase.functions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@ScopeMetadata("javax.inject.Singleton")
/* loaded from: classes5.dex */
public final class FunctionsMultiResourceComponent_Factory implements Factory<FunctionsMultiResourceComponent> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FunctionsMultiResourceComponent.FirebaseFunctionsFactory> f31380a;

    public FunctionsMultiResourceComponent_Factory(Provider<FunctionsMultiResourceComponent.FirebaseFunctionsFactory> provider) {
        this.f31380a = provider;
    }

    public static FunctionsMultiResourceComponent_Factory create(Provider<FunctionsMultiResourceComponent.FirebaseFunctionsFactory> provider) {
        return new FunctionsMultiResourceComponent_Factory(provider);
    }

    public static FunctionsMultiResourceComponent newInstance(Object obj) {
        return new FunctionsMultiResourceComponent((FunctionsMultiResourceComponent.FirebaseFunctionsFactory) obj);
    }

    @Override // javax.inject.Provider
    public FunctionsMultiResourceComponent get() {
        return newInstance(this.f31380a.get());
    }
}
