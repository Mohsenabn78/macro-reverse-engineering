package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.troubleshooting.problem.ProblemListFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {ProblemListFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributeProblemListFragmentInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface ProblemListFragmentSubcomponent extends AndroidInjector<ProblemListFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<ProblemListFragment> {
        }
    }

    private AppFragmentModule_ContributeProblemListFragmentInjector() {
    }
}
