package com.arlosoft.macrodroid.utils;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class NotificationChannelUtil_Factory implements Factory<NotificationChannelUtil> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f16069a;

    public NotificationChannelUtil_Factory(Provider<Context> provider) {
        this.f16069a = provider;
    }

    public static NotificationChannelUtil_Factory create(Provider<Context> provider) {
        return new NotificationChannelUtil_Factory(provider);
    }

    public static NotificationChannelUtil newNotificationChannelUtil(Context context) {
        return new NotificationChannelUtil(context);
    }

    public static NotificationChannelUtil provideInstance(Provider<Context> provider) {
        return new NotificationChannelUtil(provider.get());
    }

    @Override // javax.inject.Provider
    public NotificationChannelUtil get() {
        return provideInstance(this.f16069a);
    }
}
