package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {TemplateListFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributeTemplateListFragmentInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface TemplateListFragmentSubcomponent extends AndroidInjector<TemplateListFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<TemplateListFragment> {
        }
    }

    private AppFragmentModule_ContributeTemplateListFragmentInjector() {
    }
}
