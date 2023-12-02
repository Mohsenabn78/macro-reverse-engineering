package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.viewmodel;

import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MyMacroSubscriptionsViewModel_Factory implements Factory<MyMacroSubscriptionsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f13898a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScreenLoader> f13899b;

    public MyMacroSubscriptionsViewModel_Factory(Provider<MacroDroidRoomDatabase> provider, Provider<ScreenLoader> provider2) {
        this.f13898a = provider;
        this.f13899b = provider2;
    }

    public static MyMacroSubscriptionsViewModel_Factory create(Provider<MacroDroidRoomDatabase> provider, Provider<ScreenLoader> provider2) {
        return new MyMacroSubscriptionsViewModel_Factory(provider, provider2);
    }

    public static MyMacroSubscriptionsViewModel newMyMacroSubscriptionsViewModel(MacroDroidRoomDatabase macroDroidRoomDatabase, ScreenLoader screenLoader) {
        return new MyMacroSubscriptionsViewModel(macroDroidRoomDatabase, screenLoader);
    }

    public static MyMacroSubscriptionsViewModel provideInstance(Provider<MacroDroidRoomDatabase> provider, Provider<ScreenLoader> provider2) {
        return new MyMacroSubscriptionsViewModel(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public MyMacroSubscriptionsViewModel get() {
        return provideInstance(this.f13898a, this.f13899b);
    }
}
