package com.arlosoft.macrodroid.triggers.activities;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class NotificationButtonNotAssignedActivity_MembersInjector implements MembersInjector<NotificationButtonNotAssignedActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f14524a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f14525b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f14526c;

    public NotificationButtonNotAssignedActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2, Provider<PremiumStatusHandler> provider3) {
        this.f14524a = provider;
        this.f14525b = provider2;
        this.f14526c = provider3;
    }

    public static MembersInjector<NotificationButtonNotAssignedActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2, Provider<PremiumStatusHandler> provider3) {
        return new NotificationButtonNotAssignedActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectPremiumStatusHandler(NotificationButtonNotAssignedActivity notificationButtonNotAssignedActivity, PremiumStatusHandler premiumStatusHandler) {
        notificationButtonNotAssignedActivity.f14523g = premiumStatusHandler;
    }

    public static void injectRemoteConfig(NotificationButtonNotAssignedActivity notificationButtonNotAssignedActivity, RemoteConfig remoteConfig) {
        notificationButtonNotAssignedActivity.f14522f = remoteConfig;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(NotificationButtonNotAssignedActivity notificationButtonNotAssignedActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(notificationButtonNotAssignedActivity, this.f14524a.get());
        injectRemoteConfig(notificationButtonNotAssignedActivity, this.f14525b.get());
        injectPremiumStatusHandler(notificationButtonNotAssignedActivity, this.f14526c.get());
    }
}
