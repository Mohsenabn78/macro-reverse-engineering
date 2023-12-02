package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestParamsFragment;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Module(subcomponents = {HttpRequestParamsFragmentSubcomponent.class})
/* loaded from: classes3.dex */
public abstract class AppFragmentModule_ContributesHttpRequestParamsFragment {

    @Subcomponent
    /* loaded from: classes3.dex */
    public interface HttpRequestParamsFragmentSubcomponent extends AndroidInjector<HttpRequestParamsFragment> {

        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends AndroidInjector.Builder<HttpRequestParamsFragment> {
        }
    }

    private AppFragmentModule_ContributesHttpRequestParamsFragment() {
    }
}
