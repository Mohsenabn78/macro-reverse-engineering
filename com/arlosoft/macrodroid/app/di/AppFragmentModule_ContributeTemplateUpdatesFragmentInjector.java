package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.templatestore.ui.subscription.TemplateUpdatesFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {TemplateUpdatesFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributeTemplateUpdatesFragmentInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface TemplateUpdatesFragmentSubcomponent extends AndroidInjector<TemplateUpdatesFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<TemplateUpdatesFragment> {
        }
    }

    private AppFragmentModule_ContributeTemplateUpdatesFragmentInjector() {
    }
}
