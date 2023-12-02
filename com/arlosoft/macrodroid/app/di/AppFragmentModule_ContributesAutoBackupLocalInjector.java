package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {AutoBackupLocalFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesAutoBackupLocalInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface AutoBackupLocalFragmentSubcomponent extends AndroidInjector<AutoBackupLocalFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<AutoBackupLocalFragment> {
        }
    }

    private AppFragmentModule_ContributesAutoBackupLocalInjector() {
    }
}
