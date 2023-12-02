package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestContentBodyFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {HttpRequestContentBodyFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesHttpRequestContentBodyFragment {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface HttpRequestContentBodyFragmentSubcomponent extends AndroidInjector<HttpRequestContentBodyFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<HttpRequestContentBodyFragment> {
        }
    }

    private AppFragmentModule_ContributesHttpRequestContentBodyFragment() {
    }
}
