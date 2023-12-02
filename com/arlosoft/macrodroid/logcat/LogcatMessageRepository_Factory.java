package com.arlosoft.macrodroid.logcat;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class LogcatMessageRepository_Factory implements Factory<LogcatMessageRepository> {

    /* renamed from: a  reason: collision with root package name */
    private static final LogcatMessageRepository_Factory f12646a = new LogcatMessageRepository_Factory();

    public static LogcatMessageRepository_Factory create() {
        return f12646a;
    }

    public static LogcatMessageRepository newLogcatMessageRepository() {
        return new LogcatMessageRepository();
    }

    public static LogcatMessageRepository provideInstance() {
        return new LogcatMessageRepository();
    }

    @Override // javax.inject.Provider
    public LogcatMessageRepository get() {
        return provideInstance();
    }
}
