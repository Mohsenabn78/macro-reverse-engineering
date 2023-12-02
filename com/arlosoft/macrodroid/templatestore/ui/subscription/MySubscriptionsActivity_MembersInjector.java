package com.arlosoft.macrodroid.templatestore.ui.subscription;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MySubscriptionsActivity_MembersInjector implements MembersInjector<MySubscriptionsActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13859a;

    public MySubscriptionsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.f13859a = provider;
    }

    public static MembersInjector<MySubscriptionsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new MySubscriptionsActivity_MembersInjector(provider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MySubscriptionsActivity mySubscriptionsActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(mySubscriptionsActivity, this.f13859a.get());
    }
}
