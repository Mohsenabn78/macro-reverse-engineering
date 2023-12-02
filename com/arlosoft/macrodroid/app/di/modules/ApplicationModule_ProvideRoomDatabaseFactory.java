package com.arlosoft.macrodroid.app.di.modules;

import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ApplicationModule_ProvideRoomDatabaseFactory implements Factory<MacroDroidRoomDatabase> {

    /* renamed from: a  reason: collision with root package name */
    private final ApplicationModule f9287a;

    public ApplicationModule_ProvideRoomDatabaseFactory(ApplicationModule applicationModule) {
        this.f9287a = applicationModule;
    }

    public static ApplicationModule_ProvideRoomDatabaseFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideRoomDatabaseFactory(applicationModule);
    }

    public static MacroDroidRoomDatabase provideInstance(ApplicationModule applicationModule) {
        return proxyProvideRoomDatabase(applicationModule);
    }

    public static MacroDroidRoomDatabase proxyProvideRoomDatabase(ApplicationModule applicationModule) {
        return (MacroDroidRoomDatabase) Preconditions.checkNotNull(applicationModule.provideRoomDatabase(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public MacroDroidRoomDatabase get() {
        return provideInstance(this.f9287a);
    }
}
