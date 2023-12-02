package com.arlosoft.macrodroid.user.signin;

import android.content.Context;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SignInHelper_Factory implements Factory<SignInHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f15994a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScreenLoader> f15995b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f15996c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserProvider> f15997d;

    public SignInHelper_Factory(Provider<Context> provider, Provider<ScreenLoader> provider2, Provider<TemplateStoreApi> provider3, Provider<UserProvider> provider4) {
        this.f15994a = provider;
        this.f15995b = provider2;
        this.f15996c = provider3;
        this.f15997d = provider4;
    }

    public static SignInHelper_Factory create(Provider<Context> provider, Provider<ScreenLoader> provider2, Provider<TemplateStoreApi> provider3, Provider<UserProvider> provider4) {
        return new SignInHelper_Factory(provider, provider2, provider3, provider4);
    }

    public static SignInHelper newSignInHelper(Context context, ScreenLoader screenLoader, TemplateStoreApi templateStoreApi, UserProvider userProvider) {
        return new SignInHelper(context, screenLoader, templateStoreApi, userProvider);
    }

    public static SignInHelper provideInstance(Provider<Context> provider, Provider<ScreenLoader> provider2, Provider<TemplateStoreApi> provider3, Provider<UserProvider> provider4) {
        return new SignInHelper(provider.get(), provider2.get(), provider3.get(), provider4.get());
    }

    @Override // javax.inject.Provider
    public SignInHelper get() {
        return provideInstance(this.f15994a, this.f15995b, this.f15996c, this.f15997d);
    }
}
