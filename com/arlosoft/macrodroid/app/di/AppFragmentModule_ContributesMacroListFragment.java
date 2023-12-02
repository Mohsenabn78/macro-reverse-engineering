package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.macrolist.MacroListFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {MacroListFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesMacroListFragment {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface MacroListFragmentSubcomponent extends AndroidInjector<MacroListFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<MacroListFragment> {
        }
    }

    private AppFragmentModule_ContributesMacroListFragment() {
    }
}
