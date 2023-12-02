package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {TemplateStoreFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributeTemplateStoreFragmentInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface TemplateStoreFragmentSubcomponent extends AndroidInjector<TemplateStoreFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<TemplateStoreFragment> {
        }
    }

    private AppFragmentModule_ContributeTemplateStoreFragmentInjector() {
    }
}
