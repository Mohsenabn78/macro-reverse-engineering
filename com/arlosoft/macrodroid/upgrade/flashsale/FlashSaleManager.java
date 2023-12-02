package com.arlosoft.macrodroid.upgrade.flashsale;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.extensions.IntExtensionsKt;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: FlashSaleManager.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FlashSaleManager {
    public static final int FLASH_SALE_NOTIFICATION_ID = 7073236;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final RemoteConfig f15975a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final PremiumStatusHandler f15976b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: FlashSaleManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public FlashSaleManager(@NotNull RemoteConfig remoteConfig, @NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        this.f15975a = remoteConfig;
        this.f15976b = premiumStatusHandler;
    }

    public final boolean canStartNewFlash() {
        if (isFlashSaleActive() || this.f15976b.getPremiumStatus().isPro()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Gradients gradients = Gradients.INSTANCE;
        if (Settings.getInstallDate(gradients.getContext()) <= 0) {
            return false;
        }
        long days = TimeUnit.MILLISECONDS.toDays(currentTimeMillis - Settings.getInstallDate(gradients.getContext()));
        int nextFlashSaleDayNumber = Settings.getNextFlashSaleDayNumber(gradients.getContext());
        if ((nextFlashSaleDayNumber <= 0 && (nextFlashSaleDayNumber = (int) this.f15975a.getFlashSaleDayWait()) == 0) || days < nextFlashSaleDayNumber) {
            return false;
        }
        return true;
    }

    public final void clearFlashSaleNotification(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        from.cancel(7073236);
    }

    public final void createFlashSaleNotification(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.material_ic_money_off_24px_svg).setContentTitle(context.getString(R.string.flash_sale)).setContentText(context.getString(R.string.for_limited_time_sale_price)).setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, UpgradeActivity2.class), 268435456 | PendingIntentHelper.FLAG_IMMUTABLE)).setPriority(2).setDefaults(-1).setChannelId(Constants.NOTIFICATION_CHANNEL_INFO).setAutoCancel(true);
        Intrinsics.checkNotNullExpressionValue(autoCancel, "Builder(context)\n       …     .setAutoCancel(true)");
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        from.notify(7073236, autoCancel.build());
        Settings.setCanShowFlashNotification(context, false);
    }

    public final long getFlashSaleExpiry() {
        return Settings.getFlashSaleExpiry(Gradients.INSTANCE.getContext());
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        return this.f15976b;
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        return this.f15975a;
    }

    public final boolean isFlashSaleActive() {
        if (this.f15976b.getPremiumStatus().isPro() || System.currentTimeMillis() >= getFlashSaleExpiry()) {
            return false;
        }
        return true;
    }

    public final boolean startNewFlashSaleIfAppropriate() {
        if (canStartNewFlash()) {
            long currentTimeMillis = System.currentTimeMillis();
            Gradients gradients = Gradients.INSTANCE;
            long days = TimeUnit.MILLISECONDS.toDays(currentTimeMillis - Settings.getInstallDate(gradients.getContext()));
            FirebaseAnalyticsEventLogger.logFlashSaleEnabled(days);
            Settings.setNextFlashSaleDayNumber(gradients.getContext(), ((int) days) + ((int) this.f15975a.getFlashSaleDayWait()));
            Settings.setFlashSaleExpiry(gradients.getContext(), currentTimeMillis + IntExtensionsKt.getHoursToMilliseconds(24));
            return true;
        }
        return false;
    }
}
