package com.arlosoft.macrodroid.freeversion;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class FreeDaysAlarmReceiver_MembersInjector implements MembersInjector<FreeDaysAlarmReceiver> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f12178a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f12179b;

    public FreeDaysAlarmReceiver_MembersInjector(Provider<FreeVersionHelper> provider, Provider<PremiumStatusHandler> provider2) {
        this.f12178a = provider;
        this.f12179b = provider2;
    }

    public static MembersInjector<FreeDaysAlarmReceiver> create(Provider<FreeVersionHelper> provider, Provider<PremiumStatusHandler> provider2) {
        return new FreeDaysAlarmReceiver_MembersInjector(provider, provider2);
    }

    public static void injectFreeVersionHelper(FreeDaysAlarmReceiver freeDaysAlarmReceiver, FreeVersionHelper freeVersionHelper) {
        freeDaysAlarmReceiver.freeVersionHelper = freeVersionHelper;
    }

    public static void injectPremiumStatusHandler(FreeDaysAlarmReceiver freeDaysAlarmReceiver, PremiumStatusHandler premiumStatusHandler) {
        freeDaysAlarmReceiver.premiumStatusHandler = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FreeDaysAlarmReceiver freeDaysAlarmReceiver) {
        injectFreeVersionHelper(freeDaysAlarmReceiver, this.f12178a.get());
        injectPremiumStatusHandler(freeDaysAlarmReceiver, this.f12179b.get());
    }
}
