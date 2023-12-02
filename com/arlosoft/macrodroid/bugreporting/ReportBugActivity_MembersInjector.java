package com.arlosoft.macrodroid.bugreporting;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ReportBugActivity_MembersInjector implements MembersInjector<ReportBugActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f9567a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f9568b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f9569c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ActionBlockStore> f9570d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<SystemLogHelper> f9571e;

    public ReportBugActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<PremiumStatusHandler> provider3, Provider<ActionBlockStore> provider4, Provider<SystemLogHelper> provider5) {
        this.f9567a = provider;
        this.f9568b = provider2;
        this.f9569c = provider3;
        this.f9570d = provider4;
        this.f9571e = provider5;
    }

    public static MembersInjector<ReportBugActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<PremiumStatusHandler> provider3, Provider<ActionBlockStore> provider4, Provider<SystemLogHelper> provider5) {
        return new ReportBugActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectActionBlockStore(ReportBugActivity reportBugActivity, ActionBlockStore actionBlockStore) {
        reportBugActivity.actionBlockStore = actionBlockStore;
    }

    public static void injectPremiumStatusHandler(ReportBugActivity reportBugActivity, PremiumStatusHandler premiumStatusHandler) {
        reportBugActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectRoomDatabase(ReportBugActivity reportBugActivity, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        reportBugActivity.roomDatabase = macroDroidRoomDatabase;
    }

    public static void injectSystemLogHelper(ReportBugActivity reportBugActivity, SystemLogHelper systemLogHelper) {
        reportBugActivity.systemLogHelper = systemLogHelper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ReportBugActivity reportBugActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(reportBugActivity, this.f9567a.get());
        injectRoomDatabase(reportBugActivity, this.f9568b.get());
        injectPremiumStatusHandler(reportBugActivity, this.f9569c.get());
        injectActionBlockStore(reportBugActivity, this.f9570d.get());
        injectSystemLogHelper(reportBugActivity, this.f9571e.get());
    }
}
