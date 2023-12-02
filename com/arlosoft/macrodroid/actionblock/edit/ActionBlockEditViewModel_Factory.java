package com.arlosoft.macrodroid.actionblock.edit;

import android.content.res.Resources;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.utils.ToastHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ActionBlockEditViewModel_Factory implements Factory<ActionBlockEditViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ActionBlockStore> f5557a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ToastHelper> f5558b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Resources> f5559c;

    public ActionBlockEditViewModel_Factory(Provider<ActionBlockStore> provider, Provider<ToastHelper> provider2, Provider<Resources> provider3) {
        this.f5557a = provider;
        this.f5558b = provider2;
        this.f5559c = provider3;
    }

    public static ActionBlockEditViewModel_Factory create(Provider<ActionBlockStore> provider, Provider<ToastHelper> provider2, Provider<Resources> provider3) {
        return new ActionBlockEditViewModel_Factory(provider, provider2, provider3);
    }

    public static ActionBlockEditViewModel newActionBlockEditViewModel(ActionBlockStore actionBlockStore, ToastHelper toastHelper, Resources resources) {
        return new ActionBlockEditViewModel(actionBlockStore, toastHelper, resources);
    }

    public static ActionBlockEditViewModel provideInstance(Provider<ActionBlockStore> provider, Provider<ToastHelper> provider2, Provider<Resources> provider3) {
        return new ActionBlockEditViewModel(provider.get(), provider2.get(), provider3.get());
    }

    @Override // javax.inject.Provider
    public ActionBlockEditViewModel get() {
        return provideInstance(this.f5557a, this.f5558b, this.f5559c);
    }
}
