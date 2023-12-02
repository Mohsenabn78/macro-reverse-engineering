package com.arlosoft.macrodroid.autobackup.ui.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AutoBackupLocalPresenter_Factory implements Factory<AutoBackupLocalPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f9414a;

    public AutoBackupLocalPresenter_Factory(Provider<Context> provider) {
        this.f9414a = provider;
    }

    public static AutoBackupLocalPresenter_Factory create(Provider<Context> provider) {
        return new AutoBackupLocalPresenter_Factory(provider);
    }

    public static AutoBackupLocalPresenter newAutoBackupLocalPresenter(Context context) {
        return new AutoBackupLocalPresenter(context);
    }

    public static AutoBackupLocalPresenter provideInstance(Provider<Context> provider) {
        return new AutoBackupLocalPresenter(provider.get());
    }

    @Override // javax.inject.Provider
    public AutoBackupLocalPresenter get() {
        return provideInstance(this.f9414a);
    }
}
