package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {UserListFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributeUserListFragmentInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface UserListFragmentSubcomponent extends AndroidInjector<UserListFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<UserListFragment> {
        }
    }

    private AppFragmentModule_ContributeUserListFragmentInjector() {
    }
}
