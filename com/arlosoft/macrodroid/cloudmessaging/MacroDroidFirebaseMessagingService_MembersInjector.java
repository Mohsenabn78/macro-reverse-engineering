package com.arlosoft.macrodroid.cloudmessaging;

import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.templatestore.notifications.TemplateStoreNotificationHandler;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.triggers.webtrigger.WebTriggerInteractor;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MacroDroidFirebaseMessagingService_MembersInjector implements MembersInjector<MacroDroidFirebaseMessagingService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WebTriggerInteractor> f9793a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TemplateStoreNotificationHandler> f9794b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f9795c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserProvider> f9796d;

    public MacroDroidFirebaseMessagingService_MembersInjector(Provider<WebTriggerInteractor> provider, Provider<TemplateStoreNotificationHandler> provider2, Provider<MacroDroidRoomDatabase> provider3, Provider<UserProvider> provider4) {
        this.f9793a = provider;
        this.f9794b = provider2;
        this.f9795c = provider3;
        this.f9796d = provider4;
    }

    public static MembersInjector<MacroDroidFirebaseMessagingService> create(Provider<WebTriggerInteractor> provider, Provider<TemplateStoreNotificationHandler> provider2, Provider<MacroDroidRoomDatabase> provider3, Provider<UserProvider> provider4) {
        return new MacroDroidFirebaseMessagingService_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectRoomDatabase(MacroDroidFirebaseMessagingService macroDroidFirebaseMessagingService, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        macroDroidFirebaseMessagingService.roomDatabase = macroDroidRoomDatabase;
    }

    public static void injectTemplateStoreNotificationHandler(MacroDroidFirebaseMessagingService macroDroidFirebaseMessagingService, TemplateStoreNotificationHandler templateStoreNotificationHandler) {
        macroDroidFirebaseMessagingService.templateStoreNotificationHandler = templateStoreNotificationHandler;
    }

    public static void injectUserProvider(MacroDroidFirebaseMessagingService macroDroidFirebaseMessagingService, UserProvider userProvider) {
        macroDroidFirebaseMessagingService.userProvider = userProvider;
    }

    public static void injectWebTriggerInteractor(MacroDroidFirebaseMessagingService macroDroidFirebaseMessagingService, WebTriggerInteractor webTriggerInteractor) {
        macroDroidFirebaseMessagingService.webTriggerInteractor = webTriggerInteractor;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroDroidFirebaseMessagingService macroDroidFirebaseMessagingService) {
        injectWebTriggerInteractor(macroDroidFirebaseMessagingService, this.f9793a.get());
        injectTemplateStoreNotificationHandler(macroDroidFirebaseMessagingService, this.f9794b.get());
        injectRoomDatabase(macroDroidFirebaseMessagingService, this.f9795c.get());
        injectUserProvider(macroDroidFirebaseMessagingService, this.f9796d.get());
    }
}
