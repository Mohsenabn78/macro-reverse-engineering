package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.MyUserSubscriptionsFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {MyUserSubscriptionsFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesMyUserSubscriptionsFragment {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface MyUserSubscriptionsFragmentSubcomponent extends AndroidInjector<MyUserSubscriptionsFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<MyUserSubscriptionsFragment> {
        }
    }

    private AppFragmentModule_ContributesMyUserSubscriptionsFragment() {
    }
}
