package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.troubleshooting.help.TroubleShootingHelpFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {TroubleShootingHelpFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesTroubleShootingHelpFragmentInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface TroubleShootingHelpFragmentSubcomponent extends AndroidInjector<TroubleShootingHelpFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<TroubleShootingHelpFragment> {
        }
    }

    private AppFragmentModule_ContributesTroubleShootingHelpFragmentInjector() {
    }
}
