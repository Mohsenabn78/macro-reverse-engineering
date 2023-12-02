package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.plugins.pluginlist.PluginListFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {PluginListFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesPluginListInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface PluginListFragmentSubcomponent extends AndroidInjector<PluginListFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<PluginListFragment> {
        }
    }

    private AppFragmentModule_ContributesPluginListInjector() {
    }
}
