package com.arlosoft.macrodroid.logging.systemlog;

import android.content.Context;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SystemLogViewModel_Factory implements Factory<SystemLogViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12736a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f12737b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SystemLogHelper> f12738c;

    public SystemLogViewModel_Factory(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<SystemLogHelper> provider3) {
        this.f12736a = provider;
        this.f12737b = provider2;
        this.f12738c = provider3;
    }

    public static SystemLogViewModel_Factory create(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<SystemLogHelper> provider3) {
        return new SystemLogViewModel_Factory(provider, provider2, provider3);
    }

    public static SystemLogViewModel newSystemLogViewModel(Context context, MacroDroidRoomDatabase macroDroidRoomDatabase, SystemLogHelper systemLogHelper) {
        return new SystemLogViewModel(context, macroDroidRoomDatabase, systemLogHelper);
    }

    public static SystemLogViewModel provideInstance(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<SystemLogHelper> provider3) {
        return new SystemLogViewModel(provider.get(), provider2.get(), provider3.get());
    }

    @Override // javax.inject.Provider
    public SystemLogViewModel get() {
        return provideInstance(this.f12736a, this.f12737b, this.f12738c);
    }
}
