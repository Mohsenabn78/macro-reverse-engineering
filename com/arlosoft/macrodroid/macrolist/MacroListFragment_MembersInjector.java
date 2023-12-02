package com.arlosoft.macrodroid.macrolist;

import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MacroListFragment_MembersInjector implements MembersInjector<MacroListFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RemoteConfig> f12947a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f12948b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<NearbyHelper> f12949c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ActionBlockStore> f12950d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<CategoriesHelper> f12951e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ExtrasManager> f12952f;

    public MacroListFragment_MembersInjector(Provider<RemoteConfig> provider, Provider<PremiumStatusHandler> provider2, Provider<NearbyHelper> provider3, Provider<ActionBlockStore> provider4, Provider<CategoriesHelper> provider5, Provider<ExtrasManager> provider6) {
        this.f12947a = provider;
        this.f12948b = provider2;
        this.f12949c = provider3;
        this.f12950d = provider4;
        this.f12951e = provider5;
        this.f12952f = provider6;
    }

    public static MembersInjector<MacroListFragment> create(Provider<RemoteConfig> provider, Provider<PremiumStatusHandler> provider2, Provider<NearbyHelper> provider3, Provider<ActionBlockStore> provider4, Provider<CategoriesHelper> provider5, Provider<ExtrasManager> provider6) {
        return new MacroListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectActionBlockStore(MacroListFragment macroListFragment, ActionBlockStore actionBlockStore) {
        macroListFragment.f12890e = actionBlockStore;
    }

    public static void injectCategoriesHelper(MacroListFragment macroListFragment, CategoriesHelper categoriesHelper) {
        macroListFragment.f12891f = categoriesHelper;
    }

    public static void injectExtrasManager(MacroListFragment macroListFragment, ExtrasManager extrasManager) {
        macroListFragment.f12892g = extrasManager;
    }

    public static void injectNearbyHelper(MacroListFragment macroListFragment, NearbyHelper nearbyHelper) {
        macroListFragment.f12889d = nearbyHelper;
    }

    public static void injectPremiumStatusHandler(MacroListFragment macroListFragment, PremiumStatusHandler premiumStatusHandler) {
        macroListFragment.f12888c = premiumStatusHandler;
    }

    public static void injectRemoteConfig(MacroListFragment macroListFragment, RemoteConfig remoteConfig) {
        macroListFragment.f12887b = remoteConfig;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroListFragment macroListFragment) {
        injectRemoteConfig(macroListFragment, this.f12947a.get());
        injectPremiumStatusHandler(macroListFragment, this.f12948b.get());
        injectNearbyHelper(macroListFragment, this.f12949c.get());
        injectActionBlockStore(macroListFragment, this.f12950d.get());
        injectCategoriesHelper(macroListFragment, this.f12951e.get());
        injectExtrasManager(macroListFragment, this.f12952f.get());
    }
}
