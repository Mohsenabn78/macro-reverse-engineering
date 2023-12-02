package com.arlosoft.macrodroid.extras.ui.management;

import android.content.Context;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ExtrasManager_Factory implements Factory<ExtrasManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12117a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f12118b;

    public ExtrasManager_Factory(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2) {
        this.f12117a = provider;
        this.f12118b = provider2;
    }

    public static ExtrasManager_Factory create(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2) {
        return new ExtrasManager_Factory(provider, provider2);
    }

    public static ExtrasManager newExtrasManager(Context context, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        return new ExtrasManager(context, macroDroidRoomDatabase);
    }

    public static ExtrasManager provideInstance(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2) {
        return new ExtrasManager(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public ExtrasManager get() {
        return provideInstance(this.f12117a, this.f12118b);
    }
}
