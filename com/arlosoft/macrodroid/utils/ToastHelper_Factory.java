package com.arlosoft.macrodroid.utils;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ToastHelper_Factory implements Factory<ToastHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f16087a;

    public ToastHelper_Factory(Provider<Context> provider) {
        this.f16087a = provider;
    }

    public static ToastHelper_Factory create(Provider<Context> provider) {
        return new ToastHelper_Factory(provider);
    }

    public static ToastHelper newToastHelper(Context context) {
        return new ToastHelper(context);
    }

    public static ToastHelper provideInstance(Provider<Context> provider) {
        return new ToastHelper(provider.get());
    }

    @Override // javax.inject.Provider
    public ToastHelper get() {
        return provideInstance(this.f16087a);
    }
}
