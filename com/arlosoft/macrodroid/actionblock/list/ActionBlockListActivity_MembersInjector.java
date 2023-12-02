package com.arlosoft.macrodroid.actionblock.list;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ActionBlockListActivity_MembersInjector implements MembersInjector<ActionBlockListActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f5600a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ActionBlockListViewModel> f5601b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<NearbyHelper> f5602c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ActionBlockStore> f5603d;

    public ActionBlockListActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ActionBlockListViewModel> provider2, Provider<NearbyHelper> provider3, Provider<ActionBlockStore> provider4) {
        this.f5600a = provider;
        this.f5601b = provider2;
        this.f5602c = provider3;
        this.f5603d = provider4;
    }

    public static MembersInjector<ActionBlockListActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ActionBlockListViewModel> provider2, Provider<NearbyHelper> provider3, Provider<ActionBlockStore> provider4) {
        return new ActionBlockListActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectActionBlockStore(ActionBlockListActivity actionBlockListActivity, ActionBlockStore actionBlockStore) {
        actionBlockListActivity.actionBlockStore = actionBlockStore;
    }

    public static void injectNearbyHelper(ActionBlockListActivity actionBlockListActivity, NearbyHelper nearbyHelper) {
        actionBlockListActivity.nearbyHelper = nearbyHelper;
    }

    public static void injectViewModel(ActionBlockListActivity actionBlockListActivity, ActionBlockListViewModel actionBlockListViewModel) {
        actionBlockListActivity.viewModel = actionBlockListViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ActionBlockListActivity actionBlockListActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(actionBlockListActivity, this.f5600a.get());
        injectViewModel(actionBlockListActivity, this.f5601b.get());
        injectNearbyHelper(actionBlockListActivity, this.f5602c.get());
        injectActionBlockStore(actionBlockListActivity, this.f5603d.get());
    }
}
