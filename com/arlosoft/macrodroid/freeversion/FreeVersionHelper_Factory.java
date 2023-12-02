package com.arlosoft.macrodroid.freeversion;

import android.content.Context;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.troubleshooting.problem.PermissionChecker;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class FreeVersionHelper_Factory implements Factory<FreeVersionHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f12185a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f12186b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PermissionChecker> f12187c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ExtrasManager> f12188d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Context> f12189e;

    public FreeVersionHelper_Factory(Provider<PremiumStatusHandler> provider, Provider<RemoteConfig> provider2, Provider<PermissionChecker> provider3, Provider<ExtrasManager> provider4, Provider<Context> provider5) {
        this.f12185a = provider;
        this.f12186b = provider2;
        this.f12187c = provider3;
        this.f12188d = provider4;
        this.f12189e = provider5;
    }

    public static FreeVersionHelper_Factory create(Provider<PremiumStatusHandler> provider, Provider<RemoteConfig> provider2, Provider<PermissionChecker> provider3, Provider<ExtrasManager> provider4, Provider<Context> provider5) {
        return new FreeVersionHelper_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FreeVersionHelper newFreeVersionHelper(PremiumStatusHandler premiumStatusHandler, RemoteConfig remoteConfig, PermissionChecker permissionChecker, ExtrasManager extrasManager, Context context) {
        return new FreeVersionHelper(premiumStatusHandler, remoteConfig, permissionChecker, extrasManager, context);
    }

    public static FreeVersionHelper provideInstance(Provider<PremiumStatusHandler> provider, Provider<RemoteConfig> provider2, Provider<PermissionChecker> provider3, Provider<ExtrasManager> provider4, Provider<Context> provider5) {
        return new FreeVersionHelper(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get());
    }

    @Override // javax.inject.Provider
    public FreeVersionHelper get() {
        return provideInstance(this.f12185a, this.f12186b, this.f12187c, this.f12188d, this.f12189e);
    }
}
