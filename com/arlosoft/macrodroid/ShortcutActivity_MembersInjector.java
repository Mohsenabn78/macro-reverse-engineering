package com.arlosoft.macrodroid;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ShortcutActivity_MembersInjector implements MembersInjector<ShortcutActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2030a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f2031b;

    public ShortcutActivity_MembersInjector(Provider<PremiumStatusHandler> provider, Provider<RemoteConfig> provider2) {
        this.f2030a = provider;
        this.f2031b = provider2;
    }

    public static MembersInjector<ShortcutActivity> create(Provider<PremiumStatusHandler> provider, Provider<RemoteConfig> provider2) {
        return new ShortcutActivity_MembersInjector(provider, provider2);
    }

    public static void injectPremiumStatusHandler(ShortcutActivity shortcutActivity, PremiumStatusHandler premiumStatusHandler) {
        shortcutActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectRemoteConfig(ShortcutActivity shortcutActivity, RemoteConfig remoteConfig) {
        shortcutActivity.remoteConfig = remoteConfig;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ShortcutActivity shortcutActivity) {
        injectPremiumStatusHandler(shortcutActivity, this.f2030a.get());
        injectRemoteConfig(shortcutActivity, this.f2031b.get());
    }
}
