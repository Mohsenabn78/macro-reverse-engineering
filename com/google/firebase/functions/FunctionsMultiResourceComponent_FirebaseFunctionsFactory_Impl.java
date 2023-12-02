package com.google.firebase.functions;

import com.google.firebase.functions.FunctionsMultiResourceComponent;
import com.google.firebase.functions.dagger.internal.DaggerGenerated;
import com.google.firebase.functions.dagger.internal.InstanceFactory;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class FunctionsMultiResourceComponent_FirebaseFunctionsFactory_Impl implements FunctionsMultiResourceComponent.FirebaseFunctionsFactory {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseFunctions_Factory f31381a;

    FunctionsMultiResourceComponent_FirebaseFunctionsFactory_Impl(FirebaseFunctions_Factory firebaseFunctions_Factory) {
        this.f31381a = firebaseFunctions_Factory;
    }

    @Override // com.google.firebase.functions.FunctionsMultiResourceComponent.FirebaseFunctionsFactory
    public FirebaseFunctions create(String str) {
        return this.f31381a.get(str);
    }

    public static Provider<FunctionsMultiResourceComponent.FirebaseFunctionsFactory> create(FirebaseFunctions_Factory firebaseFunctions_Factory) {
        return InstanceFactory.create(new FunctionsMultiResourceComponent_FirebaseFunctionsFactory_Impl(firebaseFunctions_Factory));
    }
}
