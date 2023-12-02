package com.arlosoft.macrodroid.editscreen;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class EditMacroActivity_MembersInjector implements MembersInjector<EditMacroActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f11777a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f11778b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RemoteConfig> f11779c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ActionBlockStore> f11780d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<NearbyHelper> f11781e;

    public EditMacroActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<PremiumStatusHandler> provider2, Provider<RemoteConfig> provider3, Provider<ActionBlockStore> provider4, Provider<NearbyHelper> provider5) {
        this.f11777a = provider;
        this.f11778b = provider2;
        this.f11779c = provider3;
        this.f11780d = provider4;
        this.f11781e = provider5;
    }

    public static MembersInjector<EditMacroActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<PremiumStatusHandler> provider2, Provider<RemoteConfig> provider3, Provider<ActionBlockStore> provider4, Provider<NearbyHelper> provider5) {
        return new EditMacroActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectActionBlockStore(EditMacroActivity editMacroActivity, ActionBlockStore actionBlockStore) {
        editMacroActivity.actionBlockStore = actionBlockStore;
    }

    public static void injectNearbyHelper(EditMacroActivity editMacroActivity, NearbyHelper nearbyHelper) {
        editMacroActivity.nearbyHelper = nearbyHelper;
    }

    public static void injectPremiumStatusHandler(EditMacroActivity editMacroActivity, PremiumStatusHandler premiumStatusHandler) {
        editMacroActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectRemoteConfig(EditMacroActivity editMacroActivity, RemoteConfig remoteConfig) {
        editMacroActivity.remoteConfig = remoteConfig;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(EditMacroActivity editMacroActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(editMacroActivity, this.f11777a.get());
        injectPremiumStatusHandler(editMacroActivity, this.f11778b.get());
        injectRemoteConfig(editMacroActivity, this.f11779c.get());
        injectActionBlockStore(editMacroActivity, this.f11780d.get());
        injectNearbyHelper(editMacroActivity, this.f11781e.get());
    }
}
