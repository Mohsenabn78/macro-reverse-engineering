package com.arlosoft.macrodroid.upgrade.encouragemessage;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.homescreen.infobar.InfoBar;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EncourageUpgradeMessageManager.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class EncourageUpgradeMessageManager {
    public static final int FLASH_SALE_NOTIFICATION_ID = 7073236;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f15968a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final RemoteConfig f15969b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final PremiumStatusHandler f15970c;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: EncourageUpgradeMessageManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public EncourageUpgradeMessageManager(@ApplicationContext @NotNull Context context, @NotNull RemoteConfig remoteConfig, @NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        this.f15968a = context;
        this.f15969b = remoteConfig;
        this.f15970c = premiumStatusHandler;
    }

    @Nullable
    public final InfoBar getShowEncourageUpgradeMessage() {
        if (this.f15970c.getPremiumStatus().isPro()) {
            return null;
        }
        long encourageUpgradeMessageVariant = this.f15969b.getEncourageUpgradeMessageVariant();
        if (encourageUpgradeMessageVariant == 0) {
            return null;
        }
        if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - Settings.getLastEncouragementMessageDate(this.f15968a)) <= this.f15969b.getEncourageUpgradeMessageDaysToWait()) {
            return null;
        }
        if (encourageUpgradeMessageVariant == 1) {
            return new InfoBar.EncourageUpgradeInfo1();
        }
        return new InfoBar.EncourageUpgradeInfo2();
    }

    public final void setShownEncourageUpgradeMessage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Settings.setLastEncouragementMessageDate(context, System.currentTimeMillis());
    }
}
