package com.arlosoft.macrodroid.helper.receiver;

import com.arlosoft.macrodroid.helper.HelperResultHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class HelperResultsReceiver_MembersInjector implements MembersInjector<HelperResultsReceiver> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HelperResultHandler> f12293a;

    public HelperResultsReceiver_MembersInjector(Provider<HelperResultHandler> provider) {
        this.f12293a = provider;
    }

    public static MembersInjector<HelperResultsReceiver> create(Provider<HelperResultHandler> provider) {
        return new HelperResultsReceiver_MembersInjector(provider);
    }

    public static void injectHelperResultHandler(HelperResultsReceiver helperResultsReceiver, HelperResultHandler helperResultHandler) {
        helperResultsReceiver.helperResultHandler = helperResultHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(HelperResultsReceiver helperResultsReceiver) {
        injectHelperResultHandler(helperResultsReceiver, this.f12293a.get());
    }
}
