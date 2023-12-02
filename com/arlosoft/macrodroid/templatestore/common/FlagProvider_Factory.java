package com.arlosoft.macrodroid.templatestore.common;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class FlagProvider_Factory implements Factory<FlagProvider> {

    /* renamed from: a  reason: collision with root package name */
    private static final FlagProvider_Factory f13646a = new FlagProvider_Factory();

    public static FlagProvider_Factory create() {
        return f13646a;
    }

    public static FlagProvider newFlagProvider() {
        return new FlagProvider();
    }

    public static FlagProvider provideInstance() {
        return new FlagProvider();
    }

    @Override // javax.inject.Provider
    public FlagProvider get() {
        return provideInstance();
    }
}
