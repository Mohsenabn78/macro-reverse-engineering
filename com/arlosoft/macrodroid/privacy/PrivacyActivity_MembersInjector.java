package com.arlosoft.macrodroid.privacy;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PrivacyActivity_MembersInjector implements MembersInjector<PrivacyActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13259a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f13260b;

    public PrivacyActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2) {
        this.f13259a = provider;
        this.f13260b = provider2;
    }

    public static MembersInjector<PrivacyActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2) {
        return new PrivacyActivity_MembersInjector(provider, provider2);
    }

    public static void injectRemoteConfig(PrivacyActivity privacyActivity, RemoteConfig remoteConfig) {
        privacyActivity.f13257i = remoteConfig;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PrivacyActivity privacyActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(privacyActivity, this.f13259a.get());
        injectRemoteConfig(privacyActivity, this.f13260b.get());
    }
}
