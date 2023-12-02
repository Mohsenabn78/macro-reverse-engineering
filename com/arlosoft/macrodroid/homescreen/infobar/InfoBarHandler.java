package com.arlosoft.macrodroid.homescreen.infobar;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationManagerCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.freeversion.AddDaysActivity;
import com.arlosoft.macrodroid.freeversion.FreeVersionHelper;
import com.arlosoft.macrodroid.homescreen.infobar.InfoBar;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.translations.TranslationsActivity;
import com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.upgrade.encouragemessage.EncourageUpgradeMessageManager;
import com.arlosoft.macrodroid.upgrade.flashsale.FlashSaleManager;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InfoBarHandler.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class InfoBarHandler {
    public static final int MIN_INSTALL_DAYS_TO_SHOW_TRANSLATE_MESSAGE = 7;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12362a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final RemoteConfig f12363b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final FlashSaleManager f12364c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final EncourageUpgradeMessageManager f12365d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final FreeVersionHelper f12366e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final InfoBarSettings f12367f;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: InfoBarHandler.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public InfoBarHandler(@ApplicationContext @NotNull Context context, @NotNull RemoteConfig remoteConfig, @NotNull FlashSaleManager flashSaleManager, @NotNull EncourageUpgradeMessageManager encourageUpgradeMessageManager, @NotNull FreeVersionHelper freeVersionHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(flashSaleManager, "flashSaleManager");
        Intrinsics.checkNotNullParameter(encourageUpgradeMessageManager, "encourageUpgradeMessageManager");
        Intrinsics.checkNotNullParameter(freeVersionHelper, "freeVersionHelper");
        this.f12362a = context;
        this.f12363b = remoteConfig;
        this.f12364c = flashSaleManager;
        this.f12365d = encourageUpgradeMessageManager;
        this.f12366e = freeVersionHelper;
        this.f12367f = new InfoBarSettings(context);
    }

    private final String a() {
        boolean z3;
        if (this.f12367f.getHelpTranslateMessageLastShown() == 0) {
            if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - Settings.getInstallDate(this.f12362a)) > 7) {
                String helpTranslateMessage = this.f12363b.getHelpTranslateMessage();
                if (helpTranslateMessage.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    this.f12367f.setHelpTranslateMessageLastShown(System.currentTimeMillis());
                }
                return helpTranslateMessage;
            }
            return "";
        }
        return "";
    }

    private final void b() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/macro_droid"));
        intent.addFlags(268435456);
        this.f12362a.startActivity(intent);
    }

    private final boolean c() {
        boolean isIgnoringBatteryOptimizations;
        if (Build.VERSION.SDK_INT >= 23) {
            Object systemService = this.f12362a.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(this.f12362a.getPackageName());
            return !isIgnoringBatteryOptimizations;
        }
        return false;
    }

    private final boolean d() {
        boolean equals;
        equals = m.equals(Build.MANUFACTURER, "xiaomi", true);
        if (equals && this.f12367f.getCanShowDeviceAdminUnistallInfo()) {
            ComponentName componentName = new ComponentName(this.f12362a, MacroDroidDeviceAdminReceiver.class);
            Object systemService = this.f12362a.getSystemService("device_policy");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
            if (((DevicePolicyManager) systemService).isAdminActive(componentName)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final void e() {
        Intent intent = new Intent(this.f12362a, AddDaysActivity.class);
        intent.addFlags(268435456);
        this.f12362a.startActivity(intent);
    }

    private final void f() {
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            String packageName = this.f12362a.getPackageName();
            intent.setData(Uri.parse("package:" + packageName));
            intent.addFlags(268435456);
            this.f12362a.startActivity(intent);
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            intent2.addFlags(268435456);
            this.f12362a.startActivity(intent2);
        }
    }

    private final void g() {
        Intent putExtra = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", this.f12362a.getPackageName());
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Settings.ACTION_A…AGE, context.packageName)");
        putExtra.addFlags(268435456);
        this.f12362a.startActivity(putExtra);
    }

    private final void h() {
        Intent intent = new Intent(this.f12362a, TranslationsActivity.class);
        intent.addFlags(268435456);
        this.f12362a.startActivity(intent);
    }

    private final void i() {
        Intent intent = new Intent(this.f12362a, UpgradeActivity2.class);
        intent.addFlags(268435456);
        this.f12362a.startActivity(intent);
    }

    @NotNull
    public final Context getContext() {
        return this.f12362a;
    }

    @NotNull
    public final EncourageUpgradeMessageManager getEncourageUpgradeMessageManager() {
        return this.f12365d;
    }

    @NotNull
    public final FlashSaleManager getFlashSaleManager() {
        return this.f12364c;
    }

    @NotNull
    public final FreeVersionHelper getFreeVersionHelper() {
        return this.f12366e;
    }

    @Nullable
    public final InfoBar getInfoBarToDisplay(int i4) {
        boolean z3;
        if (this.f12366e.haveFreeDaysExpired()) {
            return new InfoBar.FreeDaysExpired();
        }
        if (this.f12367f.getShouldShowFileAccessWarning(i4)) {
            return new InfoBar.FileAccessWarning();
        }
        if (this.f12367f.getShouldShowHomeScreenLongPressInfo()) {
            return new InfoBar.HomeScreenTilesDragInfo();
        }
        if (this.f12364c.isFlashSaleActive()) {
            return new InfoBar.FlashSaleInfo();
        }
        if (this.f12367f.getShouldShowTwitterInfo()) {
            return new InfoBar.TwitterInfo();
        }
        InfoBar showEncourageUpgradeMessage = this.f12365d.getShowEncourageUpgradeMessage();
        if (showEncourageUpgradeMessage != null) {
            return showEncourageUpgradeMessage;
        }
        if (Build.VERSION.SDK_INT >= 26 && !NotificationManagerCompat.from(this.f12362a).areNotificationsEnabled() && this.f12367f.getShouldShowNotificationBlockedWarning()) {
            return new InfoBar.NotificationWarning();
        }
        if (d()) {
            return new InfoBar.DeviceAdminUninstall();
        }
        if (c()) {
            return new InfoBar.BatteryOptimisationWarning();
        }
        String a4 = a();
        if (a4.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            String string = this.f12362a.getString(R.string.translations);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.translations)");
            return new InfoBar.HelpTranslateMessage(a4, string);
        }
        return null;
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        return this.f12363b;
    }

    public final void handleConfigureButton(@NotNull InfoBar infoBar) {
        boolean z3;
        Intrinsics.checkNotNullParameter(infoBar, "infoBar");
        if (infoBar instanceof InfoBar.NotificationWarning) {
            g();
        } else if (infoBar instanceof InfoBar.HelpTranslateMessage) {
            h();
        } else {
            if (infoBar instanceof InfoBar.EncourageUpgradeInfo1) {
                z3 = true;
            } else {
                z3 = infoBar instanceof InfoBar.EncourageUpgradeInfo2;
            }
            if (z3) {
                i();
            } else if (infoBar instanceof InfoBar.TwitterInfo) {
                b();
            } else if (infoBar instanceof InfoBar.BatteryOptimisationWarning) {
                f();
            } else if (infoBar instanceof InfoBar.FreeDaysExpired) {
                e();
            }
        }
    }

    public final void markAsShown(@NotNull InfoBar infoBar) {
        boolean z3;
        Intrinsics.checkNotNullParameter(infoBar, "infoBar");
        if (infoBar instanceof InfoBar.FileAccessWarning) {
            this.f12367f.setShouldShowFileAccessWarning(false);
        } else if (infoBar instanceof InfoBar.HomeScreenTilesDragInfo) {
            this.f12367f.setShouldShowHomeScreenLongPressInfo(false);
        } else if (infoBar instanceof InfoBar.NotificationWarning) {
            this.f12367f.setShouldShowNotificationBlockedWarning(false);
        } else {
            if (infoBar instanceof InfoBar.EncourageUpgradeInfo1) {
                z3 = true;
            } else {
                z3 = infoBar instanceof InfoBar.EncourageUpgradeInfo2;
            }
            if (z3) {
                this.f12365d.setShownEncourageUpgradeMessage(this.f12362a);
            } else if (infoBar instanceof InfoBar.TwitterInfo) {
                this.f12367f.setShouldShowTwitterInfo(false);
            } else if (infoBar instanceof InfoBar.DeviceAdminUninstall) {
                this.f12367f.setCanShowDeviceAdminUnistallInfo(false);
            }
        }
    }
}
