package com.arlosoft.macrodroid.homescreen.quickrun;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.macrolist.HeadingColorMapper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class QuickRunAddMacrosActivity_MembersInjector implements MembersInjector<QuickRunAddMacrosActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f12383a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HeadingColorMapper> f12384b;

    public QuickRunAddMacrosActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<HeadingColorMapper> provider2) {
        this.f12383a = provider;
        this.f12384b = provider2;
    }

    public static MembersInjector<QuickRunAddMacrosActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<HeadingColorMapper> provider2) {
        return new QuickRunAddMacrosActivity_MembersInjector(provider, provider2);
    }

    public static void injectHeadingColorMapper(QuickRunAddMacrosActivity quickRunAddMacrosActivity, HeadingColorMapper headingColorMapper) {
        quickRunAddMacrosActivity.headingColorMapper = headingColorMapper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(QuickRunAddMacrosActivity quickRunAddMacrosActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(quickRunAddMacrosActivity, this.f12383a.get());
        injectHeadingColorMapper(quickRunAddMacrosActivity, this.f12384b.get());
    }
}
