package com.arlosoft.macrodroid.templatestore.ui.user;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class UserProvider_Factory implements Factory<UserProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f14196a;

    public UserProvider_Factory(Provider<Context> provider) {
        this.f14196a = provider;
    }

    public static UserProvider_Factory create(Provider<Context> provider) {
        return new UserProvider_Factory(provider);
    }

    public static UserProvider newUserProvider(Context context) {
        return new UserProvider(context);
    }

    public static UserProvider provideInstance(Provider<Context> provider) {
        return new UserProvider(provider.get());
    }

    @Override // javax.inject.Provider
    public UserProvider get() {
        return provideInstance(this.f14196a);
    }
}
