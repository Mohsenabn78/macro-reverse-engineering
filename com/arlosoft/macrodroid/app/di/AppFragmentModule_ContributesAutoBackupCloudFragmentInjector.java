package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {AutoBackupCloudFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesAutoBackupCloudFragmentInjector {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface AutoBackupCloudFragmentSubcomponent extends AndroidInjector<AutoBackupCloudFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<AutoBackupCloudFragment> {
        }
    }

    private AppFragmentModule_ContributesAutoBackupCloudFragmentInjector() {
    }
}
