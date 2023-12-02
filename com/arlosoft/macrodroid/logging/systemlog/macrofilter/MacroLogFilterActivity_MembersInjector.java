package com.arlosoft.macrodroid.logging.systemlog.macrofilter;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.macrolist.HeadingColorMapper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MacroLogFilterActivity_MembersInjector implements MembersInjector<MacroLogFilterActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f12781a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HeadingColorMapper> f12782b;

    public MacroLogFilterActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<HeadingColorMapper> provider2) {
        this.f12781a = provider;
        this.f12782b = provider2;
    }

    public static MembersInjector<MacroLogFilterActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<HeadingColorMapper> provider2) {
        return new MacroLogFilterActivity_MembersInjector(provider, provider2);
    }

    public static void injectHeadingColorMapper(MacroLogFilterActivity macroLogFilterActivity, HeadingColorMapper headingColorMapper) {
        macroLogFilterActivity.headingColorMapper = headingColorMapper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroLogFilterActivity macroLogFilterActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(macroLogFilterActivity, this.f12781a.get());
        injectHeadingColorMapper(macroLogFilterActivity, this.f12782b.get());
    }
}
