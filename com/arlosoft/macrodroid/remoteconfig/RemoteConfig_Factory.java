package com.arlosoft.macrodroid.remoteconfig;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class RemoteConfig_Factory implements Factory<RemoteConfig> {

    /* renamed from: a  reason: collision with root package name */
    private static final RemoteConfig_Factory f13286a = new RemoteConfig_Factory();

    public static RemoteConfig_Factory create() {
        return f13286a;
    }

    public static RemoteConfig newRemoteConfig() {
        return new RemoteConfig();
    }

    public static RemoteConfig provideInstance() {
        return new RemoteConfig();
    }

    @Override // javax.inject.Provider
    public RemoteConfig get() {
        return provideInstance();
    }
}
