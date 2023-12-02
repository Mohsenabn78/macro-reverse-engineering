package com.arlosoft.macrodroid.autobackup.ui;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AutoBackupActivity_MembersInjector implements MembersInjector<AutoBackupActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f9312a;

    public AutoBackupActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.f9312a = provider;
    }

    public static MembersInjector<AutoBackupActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new AutoBackupActivity_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AutoBackupActivity autoBackupActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(autoBackupActivity, this.f9312a.get());
    }
}
