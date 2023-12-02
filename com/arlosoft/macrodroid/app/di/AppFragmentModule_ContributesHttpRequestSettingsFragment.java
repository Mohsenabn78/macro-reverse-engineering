package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {HttpRequestSettingsFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesHttpRequestSettingsFragment {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface HttpRequestSettingsFragmentSubcomponent extends AndroidInjector<HttpRequestSettingsFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<HttpRequestSettingsFragment> {
        }
    }

    private AppFragmentModule_ContributesHttpRequestSettingsFragment() {
    }
}
