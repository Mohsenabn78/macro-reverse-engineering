package com.arlosoft.macrodroid.homescreen.infobar;

import android.content.Context;
import com.arlosoft.macrodroid.freeversion.FreeVersionHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.upgrade.encouragemessage.EncourageUpgradeMessageManager;
import com.arlosoft.macrodroid.upgrade.flashsale.FlashSaleManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class InfoBarHandler_Factory implements Factory<InfoBarHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12368a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f12369b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FlashSaleManager> f12370c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<EncourageUpgradeMessageManager> f12371d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f12372e;

    public InfoBarHandler_Factory(Provider<Context> provider, Provider<RemoteConfig> provider2, Provider<FlashSaleManager> provider3, Provider<EncourageUpgradeMessageManager> provider4, Provider<FreeVersionHelper> provider5) {
        this.f12368a = provider;
        this.f12369b = provider2;
        this.f12370c = provider3;
        this.f12371d = provider4;
        this.f12372e = provider5;
    }

    public static InfoBarHandler_Factory create(Provider<Context> provider, Provider<RemoteConfig> provider2, Provider<FlashSaleManager> provider3, Provider<EncourageUpgradeMessageManager> provider4, Provider<FreeVersionHelper> provider5) {
        return new InfoBarHandler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static InfoBarHandler newInfoBarHandler(Context context, RemoteConfig remoteConfig, FlashSaleManager flashSaleManager, EncourageUpgradeMessageManager encourageUpgradeMessageManager, FreeVersionHelper freeVersionHelper) {
        return new InfoBarHandler(context, remoteConfig, flashSaleManager, encourageUpgradeMessageManager, freeVersionHelper);
    }

    public static InfoBarHandler provideInstance(Provider<Context> provider, Provider<RemoteConfig> provider2, Provider<FlashSaleManager> provider3, Provider<EncourageUpgradeMessageManager> provider4, Provider<FreeVersionHelper> provider5) {
        return new InfoBarHandler(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get());
    }

    @Override // javax.inject.Provider
    public InfoBarHandler get() {
        return provideInstance(this.f12368a, this.f12369b, this.f12370c, this.f12371d, this.f12372e);
    }
}
