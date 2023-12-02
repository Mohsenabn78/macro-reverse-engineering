package com.arlosoft.macrodroid.logcat;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class LogcatButtonService_MembersInjector implements MembersInjector<LogcatButtonService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LogcatMessageRepository> f12636a;

    public LogcatButtonService_MembersInjector(Provider<LogcatMessageRepository> provider) {
        this.f12636a = provider;
    }

    public static MembersInjector<LogcatButtonService> create(Provider<LogcatMessageRepository> provider) {
        return new LogcatButtonService_MembersInjector(provider);
    }

    public static void injectLogcatMessageRepository(LogcatButtonService logcatButtonService, LogcatMessageRepository logcatMessageRepository) {
        logcatButtonService.logcatMessageRepository = logcatMessageRepository;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LogcatButtonService logcatButtonService) {
        injectLogcatMessageRepository(logcatButtonService, this.f12636a.get());
    }
}
