package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ClearLogAction_MembersInjector implements MembersInjector<ClearLogAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f2131a;

    public ClearLogAction_MembersInjector(Provider<MacroDroidRoomDatabase> provider) {
        this.f2131a = provider;
    }

    public static MembersInjector<ClearLogAction> create(Provider<MacroDroidRoomDatabase> provider) {
        return new ClearLogAction_MembersInjector(provider);
    }

    public static void injectRoomDatabase(ClearLogAction clearLogAction, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        clearLogAction.roomDatabase = macroDroidRoomDatabase;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ClearLogAction clearLogAction) {
        injectRoomDatabase(clearLogAction, this.f2131a.get());
    }
}
