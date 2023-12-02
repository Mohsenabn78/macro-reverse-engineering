package com.arlosoft.macrodroid.logcat;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class LogcatMessageSelectActivity_MembersInjector implements MembersInjector<LogcatMessageSelectActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f12655a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LogcatMessageRepository> f12656b;

    public LogcatMessageSelectActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<LogcatMessageRepository> provider2) {
        this.f12655a = provider;
        this.f12656b = provider2;
    }

    public static MembersInjector<LogcatMessageSelectActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<LogcatMessageRepository> provider2) {
        return new LogcatMessageSelectActivity_MembersInjector(provider, provider2);
    }

    public static void injectLogcatMessageRepository(LogcatMessageSelectActivity logcatMessageSelectActivity, LogcatMessageRepository logcatMessageRepository) {
        logcatMessageSelectActivity.logcatMessageRepository = logcatMessageRepository;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LogcatMessageSelectActivity logcatMessageSelectActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(logcatMessageSelectActivity, this.f12655a.get());
        injectLogcatMessageRepository(logcatMessageSelectActivity, this.f12656b.get());
    }
}
