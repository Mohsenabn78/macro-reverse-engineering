package com.arlosoft.macrodroid.drawer;

import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MacroDroidDrawer_MembersInjector implements MembersInjector<MacroDroidDrawer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f11468a;

    public MacroDroidDrawer_MembersInjector(Provider<MacroDroidRoomDatabase> provider) {
        this.f11468a = provider;
    }

    public static MembersInjector<MacroDroidDrawer> create(Provider<MacroDroidRoomDatabase> provider) {
        return new MacroDroidDrawer_MembersInjector(provider);
    }

    public static void injectMacroDroidRoomDatabase(MacroDroidDrawer macroDroidDrawer, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        macroDroidDrawer.f11459j = macroDroidRoomDatabase;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroDroidDrawer macroDroidDrawer) {
        injectMacroDroidRoomDatabase(macroDroidDrawer, this.f11468a.get());
    }
}
