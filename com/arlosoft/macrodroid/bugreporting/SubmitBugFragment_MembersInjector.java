package com.arlosoft.macrodroid.bugreporting;

import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SubmitBugFragment_MembersInjector implements MembersInjector<SubmitBugFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RemoteConfig> f9581a;

    public SubmitBugFragment_MembersInjector(Provider<RemoteConfig> provider) {
        this.f9581a = provider;
    }

    public static MembersInjector<SubmitBugFragment> create(Provider<RemoteConfig> provider) {
        return new SubmitBugFragment_MembersInjector(provider);
    }

    public static void injectRemoteConfig(SubmitBugFragment submitBugFragment, RemoteConfig remoteConfig) {
        submitBugFragment.f9580b = remoteConfig;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SubmitBugFragment submitBugFragment) {
        injectRemoteConfig(submitBugFragment, this.f9581a.get());
    }
}
