package com.arlosoft.macrodroid.extras.ui.viewmodel;

import android.content.Context;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.extras.ExtrasDownloader;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ExtrasViewModel_Factory implements Factory<ExtrasViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12128a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ExtrasManager> f12129b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f12130c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<RemoteConfig> f12131d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ExtrasDownloader> f12132e;

    public ExtrasViewModel_Factory(Provider<Context> provider, Provider<ExtrasManager> provider2, Provider<MacroDroidRoomDatabase> provider3, Provider<RemoteConfig> provider4, Provider<ExtrasDownloader> provider5) {
        this.f12128a = provider;
        this.f12129b = provider2;
        this.f12130c = provider3;
        this.f12131d = provider4;
        this.f12132e = provider5;
    }

    public static ExtrasViewModel_Factory create(Provider<Context> provider, Provider<ExtrasManager> provider2, Provider<MacroDroidRoomDatabase> provider3, Provider<RemoteConfig> provider4, Provider<ExtrasDownloader> provider5) {
        return new ExtrasViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ExtrasViewModel newExtrasViewModel(Context context, ExtrasManager extrasManager, MacroDroidRoomDatabase macroDroidRoomDatabase, RemoteConfig remoteConfig, ExtrasDownloader extrasDownloader) {
        return new ExtrasViewModel(context, extrasManager, macroDroidRoomDatabase, remoteConfig, extrasDownloader);
    }

    public static ExtrasViewModel provideInstance(Provider<Context> provider, Provider<ExtrasManager> provider2, Provider<MacroDroidRoomDatabase> provider3, Provider<RemoteConfig> provider4, Provider<ExtrasDownloader> provider5) {
        return new ExtrasViewModel(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get());
    }

    @Override // javax.inject.Provider
    public ExtrasViewModel get() {
        return provideInstance(this.f12128a, this.f12129b, this.f12130c, this.f12131d, this.f12132e);
    }
}
