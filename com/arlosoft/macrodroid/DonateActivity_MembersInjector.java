package com.arlosoft.macrodroid;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DonateActivity_MembersInjector implements MembersInjector<DonateActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f1959a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BillingDataSource> f1960b;

    public DonateActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2) {
        this.f1959a = provider;
        this.f1960b = provider2;
    }

    public static MembersInjector<DonateActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2) {
        return new DonateActivity_MembersInjector(provider, provider2);
    }

    public static void injectBillingDataSource(DonateActivity donateActivity, BillingDataSource billingDataSource) {
        donateActivity.billingDataSource = billingDataSource;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(DonateActivity donateActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(donateActivity, this.f1959a.get());
        injectBillingDataSource(donateActivity, this.f1960b.get());
    }
}
