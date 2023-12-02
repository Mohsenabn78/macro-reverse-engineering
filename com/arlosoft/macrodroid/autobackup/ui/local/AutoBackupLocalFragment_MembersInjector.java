package com.arlosoft.macrodroid.autobackup.ui.local;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AutoBackupLocalFragment_MembersInjector implements MembersInjector<AutoBackupLocalFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AutoBackupLocalPresenter> f9410a;

    public AutoBackupLocalFragment_MembersInjector(Provider<AutoBackupLocalPresenter> provider) {
        this.f9410a = provider;
    }

    public static MembersInjector<AutoBackupLocalFragment> create(Provider<AutoBackupLocalPresenter> provider) {
        return new AutoBackupLocalFragment_MembersInjector(provider);
    }

    public static void injectPresenter(AutoBackupLocalFragment autoBackupLocalFragment, AutoBackupLocalPresenter autoBackupLocalPresenter) {
        autoBackupLocalFragment.presenter = autoBackupLocalPresenter;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AutoBackupLocalFragment autoBackupLocalFragment) {
        injectPresenter(autoBackupLocalFragment, this.f9410a.get());
    }
}
