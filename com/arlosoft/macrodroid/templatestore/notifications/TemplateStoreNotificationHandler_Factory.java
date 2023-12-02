package com.arlosoft.macrodroid.templatestore.notifications;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateStoreNotificationHandler_Factory implements Factory<TemplateStoreNotificationHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f13651a;

    public TemplateStoreNotificationHandler_Factory(Provider<Context> provider) {
        this.f13651a = provider;
    }

    public static TemplateStoreNotificationHandler_Factory create(Provider<Context> provider) {
        return new TemplateStoreNotificationHandler_Factory(provider);
    }

    public static TemplateStoreNotificationHandler newTemplateStoreNotificationHandler(Context context) {
        return new TemplateStoreNotificationHandler(context);
    }

    public static TemplateStoreNotificationHandler provideInstance(Provider<Context> provider) {
        return new TemplateStoreNotificationHandler(provider.get());
    }

    @Override // javax.inject.Provider
    public TemplateStoreNotificationHandler get() {
        return provideInstance(this.f13651a);
    }
}
