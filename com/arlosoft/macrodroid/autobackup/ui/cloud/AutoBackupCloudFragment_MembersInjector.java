package com.arlosoft.macrodroid.autobackup.ui.cloud;

import com.arlosoft.macrodroid.user.signin.SignInHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AutoBackupCloudFragment_MembersInjector implements MembersInjector<AutoBackupCloudFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AutoBackupCloudViewModel> f9348a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SignInHelper> f9349b;

    public AutoBackupCloudFragment_MembersInjector(Provider<AutoBackupCloudViewModel> provider, Provider<SignInHelper> provider2) {
        this.f9348a = provider;
        this.f9349b = provider2;
    }

    public static MembersInjector<AutoBackupCloudFragment> create(Provider<AutoBackupCloudViewModel> provider, Provider<SignInHelper> provider2) {
        return new AutoBackupCloudFragment_MembersInjector(provider, provider2);
    }

    public static void injectSignInHelper(AutoBackupCloudFragment autoBackupCloudFragment, SignInHelper signInHelper) {
        autoBackupCloudFragment.signInHelper = signInHelper;
    }

    public static void injectViewModel(AutoBackupCloudFragment autoBackupCloudFragment, AutoBackupCloudViewModel autoBackupCloudViewModel) {
        autoBackupCloudFragment.viewModel = autoBackupCloudViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AutoBackupCloudFragment autoBackupCloudFragment) {
        injectViewModel(autoBackupCloudFragment, this.f9348a.get());
        injectSignInHelper(autoBackupCloudFragment, this.f9349b.get());
    }
}
