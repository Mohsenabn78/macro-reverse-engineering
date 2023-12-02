package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.utils.NotificationChannelUtil;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NotificationAction_MembersInjector implements MembersInjector<NotificationAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<NotificationChannelUtil> f2346a;

    public NotificationAction_MembersInjector(Provider<NotificationChannelUtil> provider) {
        this.f2346a = provider;
    }

    public static MembersInjector<NotificationAction> create(Provider<NotificationChannelUtil> provider) {
        return new NotificationAction_MembersInjector(provider);
    }

    public static void injectNotificationChannelUtil(NotificationAction notificationAction, NotificationChannelUtil notificationChannelUtil) {
        notificationAction.f2314c = notificationChannelUtil;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(NotificationAction notificationAction) {
        injectNotificationChannelUtil(notificationAction, this.f2346a.get());
    }
}
