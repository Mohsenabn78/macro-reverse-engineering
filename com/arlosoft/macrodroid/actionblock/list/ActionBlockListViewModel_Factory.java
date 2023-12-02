package com.arlosoft.macrodroid.actionblock.list;

import com.arlosoft.macrodroid.macro.ActionBlockStore;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ActionBlockListViewModel_Factory implements Factory<ActionBlockListViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ActionBlockStore> f5611a;

    public ActionBlockListViewModel_Factory(Provider<ActionBlockStore> provider) {
        this.f5611a = provider;
    }

    public static ActionBlockListViewModel_Factory create(Provider<ActionBlockStore> provider) {
        return new ActionBlockListViewModel_Factory(provider);
    }

    public static ActionBlockListViewModel newActionBlockListViewModel(ActionBlockStore actionBlockStore) {
        return new ActionBlockListViewModel(actionBlockStore);
    }

    public static ActionBlockListViewModel provideInstance(Provider<ActionBlockStore> provider) {
        return new ActionBlockListViewModel(provider.get());
    }

    @Override // javax.inject.Provider
    public ActionBlockListViewModel get() {
        return provideInstance(this.f5611a);
    }
}
