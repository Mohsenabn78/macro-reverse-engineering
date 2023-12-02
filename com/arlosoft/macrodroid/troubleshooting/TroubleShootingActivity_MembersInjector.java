package com.arlosoft.macrodroid.troubleshooting;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TroubleShootingActivity_MembersInjector implements MembersInjector<TroubleShootingActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f15808a;

    public TroubleShootingActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.f15808a = provider;
    }

    public static MembersInjector<TroubleShootingActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new TroubleShootingActivity_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TroubleShootingActivity troubleShootingActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(troubleShootingActivity, this.f15808a.get());
    }
}
