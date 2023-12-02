package com.arlosoft.macrodroid.app.di.modules;

import com.arlosoft.macrodroid.macro.ActionBlockStore;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ApplicationModule_ProvideActionBlockStoreFactory implements Factory<ActionBlockStore> {

    /* renamed from: a  reason: collision with root package name */
    private final ApplicationModule f9286a;

    public ApplicationModule_ProvideActionBlockStoreFactory(ApplicationModule applicationModule) {
        this.f9286a = applicationModule;
    }

    public static ApplicationModule_ProvideActionBlockStoreFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideActionBlockStoreFactory(applicationModule);
    }

    public static ActionBlockStore provideInstance(ApplicationModule applicationModule) {
        return proxyProvideActionBlockStore(applicationModule);
    }

    public static ActionBlockStore proxyProvideActionBlockStore(ApplicationModule applicationModule) {
        return (ActionBlockStore) Preconditions.checkNotNull(applicationModule.provideActionBlockStore(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public ActionBlockStore get() {
        return provideInstance(this.f9286a);
    }
}
