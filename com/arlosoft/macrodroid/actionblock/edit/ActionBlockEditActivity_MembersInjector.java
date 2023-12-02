package com.arlosoft.macrodroid.actionblock.edit;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ActionBlockEditActivity_MembersInjector implements MembersInjector<ActionBlockEditActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f5540a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ActionBlockEditViewModel> f5541b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<NearbyHelper> f5542c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ActionBlockStore> f5543d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ScreenLoader> f5544e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f5545f;

    public ActionBlockEditActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ActionBlockEditViewModel> provider2, Provider<NearbyHelper> provider3, Provider<ActionBlockStore> provider4, Provider<ScreenLoader> provider5, Provider<PremiumStatusHandler> provider6) {
        this.f5540a = provider;
        this.f5541b = provider2;
        this.f5542c = provider3;
        this.f5543d = provider4;
        this.f5544e = provider5;
        this.f5545f = provider6;
    }

    public static MembersInjector<ActionBlockEditActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ActionBlockEditViewModel> provider2, Provider<NearbyHelper> provider3, Provider<ActionBlockStore> provider4, Provider<ScreenLoader> provider5, Provider<PremiumStatusHandler> provider6) {
        return new ActionBlockEditActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectActionBlockStore(ActionBlockEditActivity actionBlockEditActivity, ActionBlockStore actionBlockStore) {
        actionBlockEditActivity.actionBlockStore = actionBlockStore;
    }

    public static void injectNearbyHelper(ActionBlockEditActivity actionBlockEditActivity, NearbyHelper nearbyHelper) {
        actionBlockEditActivity.nearbyHelper = nearbyHelper;
    }

    public static void injectPremiumStatusHandler(ActionBlockEditActivity actionBlockEditActivity, PremiumStatusHandler premiumStatusHandler) {
        actionBlockEditActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectScreenLoader(ActionBlockEditActivity actionBlockEditActivity, ScreenLoader screenLoader) {
        actionBlockEditActivity.screenLoader = screenLoader;
    }

    public static void injectViewModel(ActionBlockEditActivity actionBlockEditActivity, ActionBlockEditViewModel actionBlockEditViewModel) {
        actionBlockEditActivity.viewModel = actionBlockEditViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ActionBlockEditActivity actionBlockEditActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(actionBlockEditActivity, this.f5540a.get());
        injectViewModel(actionBlockEditActivity, this.f5541b.get());
        injectNearbyHelper(actionBlockEditActivity, this.f5542c.get());
        injectActionBlockStore(actionBlockEditActivity, this.f5543d.get());
        injectScreenLoader(actionBlockEditActivity, this.f5544e.get());
        injectPremiumStatusHandler(actionBlockEditActivity, this.f5545f.get());
    }
}
