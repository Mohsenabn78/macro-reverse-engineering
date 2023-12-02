package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.homescreen.HomeFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {HomeFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesHomeFragmentInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface HomeFragmentSubcomponent extends AndroidInjector<HomeFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<HomeFragment> {
        }
    }

    private AppFragmentModule_ContributesHomeFragmentInjector() {
    }
}
