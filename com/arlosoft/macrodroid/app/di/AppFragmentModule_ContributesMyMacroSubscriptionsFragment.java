package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.MyMacroSubscriptionsFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {MyMacroSubscriptionsFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesMyMacroSubscriptionsFragment {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface MyMacroSubscriptionsFragmentSubcomponent extends AndroidInjector<MyMacroSubscriptionsFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<MyMacroSubscriptionsFragment> {
        }
    }

    private AppFragmentModule_ContributesMyMacroSubscriptionsFragment() {
    }
}
