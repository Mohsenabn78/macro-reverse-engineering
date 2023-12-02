package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.bugreporting.SubmitBugFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {SubmitBugFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesSubmitBugFragment {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface SubmitBugFragmentSubcomponent extends AndroidInjector<SubmitBugFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<SubmitBugFragment> {
        }
    }

    private AppFragmentModule_ContributesSubmitBugFragment() {
    }
}
