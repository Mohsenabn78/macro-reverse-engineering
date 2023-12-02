package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExportLogAction_MembersInjector implements MembersInjector<ExportLogAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f2177a;

    public ExportLogAction_MembersInjector(Provider<MacroDroidRoomDatabase> provider) {
        this.f2177a = provider;
    }

    public static MembersInjector<ExportLogAction> create(Provider<MacroDroidRoomDatabase> provider) {
        return new ExportLogAction_MembersInjector(provider);
    }

    public static void injectRoomDatabase(ExportLogAction exportLogAction, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        exportLogAction.roomDatabase = macroDroidRoomDatabase;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ExportLogAction exportLogAction) {
        injectRoomDatabase(exportLogAction, this.f2177a.get());
    }
}
