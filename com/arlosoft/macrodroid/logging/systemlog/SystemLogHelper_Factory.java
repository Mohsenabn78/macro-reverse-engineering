package com.arlosoft.macrodroid.logging.systemlog;

import android.content.Context;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SystemLogHelper_Factory implements Factory<SystemLogHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12711a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f12712b;

    public SystemLogHelper_Factory(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2) {
        this.f12711a = provider;
        this.f12712b = provider2;
    }

    public static SystemLogHelper_Factory create(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2) {
        return new SystemLogHelper_Factory(provider, provider2);
    }

    public static SystemLogHelper newSystemLogHelper(Context context, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        return new SystemLogHelper(context, macroDroidRoomDatabase);
    }

    public static SystemLogHelper provideInstance(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2) {
        return new SystemLogHelper(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public SystemLogHelper get() {
        return provideInstance(this.f12711a, this.f12712b);
    }
}
