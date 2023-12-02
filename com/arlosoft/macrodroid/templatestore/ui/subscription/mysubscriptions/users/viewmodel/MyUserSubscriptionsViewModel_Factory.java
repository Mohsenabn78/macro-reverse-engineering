package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.viewmodel;

import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MyUserSubscriptionsViewModel_Factory implements Factory<MyUserSubscriptionsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f13922a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScreenLoader> f13923b;

    public MyUserSubscriptionsViewModel_Factory(Provider<MacroDroidRoomDatabase> provider, Provider<ScreenLoader> provider2) {
        this.f13922a = provider;
        this.f13923b = provider2;
    }

    public static MyUserSubscriptionsViewModel_Factory create(Provider<MacroDroidRoomDatabase> provider, Provider<ScreenLoader> provider2) {
        return new MyUserSubscriptionsViewModel_Factory(provider, provider2);
    }

    public static MyUserSubscriptionsViewModel newMyUserSubscriptionsViewModel(MacroDroidRoomDatabase macroDroidRoomDatabase, ScreenLoader screenLoader) {
        return new MyUserSubscriptionsViewModel(macroDroidRoomDatabase, screenLoader);
    }

    public static MyUserSubscriptionsViewModel provideInstance(Provider<MacroDroidRoomDatabase> provider, Provider<ScreenLoader> provider2) {
        return new MyUserSubscriptionsViewModel(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public MyUserSubscriptionsViewModel get() {
        return provideInstance(this.f13922a, this.f13923b);
    }
}
