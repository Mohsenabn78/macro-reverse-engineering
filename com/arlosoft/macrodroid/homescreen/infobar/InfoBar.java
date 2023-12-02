package com.arlosoft.macrodroid.homescreen.infobar;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InfoBar.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class InfoBar {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f12354a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12355b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f12356c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12357d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f12358e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f12359f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final Integer f12360g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Integer f12361h;

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class BatteryOptimisationWarning extends InfoBar {
        public static final int $stable = 0;

        public BatteryOptimisationWarning() {
            super(R.string.troubleshoot_battery_optimization_is_enabled, R.color.home_screen_bar_warning, "battery_optimisation_warning", true, null, null, Integer.valueOf((int) R.string.ignore_battery_optimisations), null, 176, null);
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class DeviceAdminUninstall extends InfoBar {
        public static final int $stable = 0;

        public DeviceAdminUninstall() {
            super(R.string.info_bar_warning_uninstall_device_admin, R.color.home_screen_bar_warning_severe, "device_admin_uninstall_warning", false, null, null, null, null, 248, null);
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class EncourageUpgradeInfo1 extends InfoBar {
        public static final int $stable = 0;

        public EncourageUpgradeInfo1() {
            super(R.string.long_term_user_thanks_and_upgrade_encouragement_variant_1, R.color.home_screen_bar_info, "encourage_upgrade_1", true, null, null, Integer.valueOf((int) R.string.upgrade), null, 176, null);
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class EncourageUpgradeInfo2 extends InfoBar {
        public static final int $stable = 0;

        public EncourageUpgradeInfo2() {
            super(R.string.long_term_user_thanks_and_upgrade_encouragement_variant_2, R.color.home_screen_bar_info, "encourage_upgrade_2", true, null, null, Integer.valueOf((int) R.string.upgrade), null, 176, null);
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class FileAccessWarning extends InfoBar {
        public static final int $stable = 0;

        public FileAccessWarning() {
            super(R.string.android_10_file_warning, R.color.home_screen_bar_warning, "file_access_warning", false, null, null, null, null, 248, null);
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class FlashSaleInfo extends InfoBar {
        public static final int $stable = 0;

        public FlashSaleInfo() {
            super(R.string.for_limited_time_sale_price, R.color.home_screen_bar_info, "flash_sale_info", false, null, null, null, null, 248, null);
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class FreeDaysExpired extends InfoBar {
        public static final int $stable = 0;

        public FreeDaysExpired() {
            super(R.string.macrodroid_free_days_expired_info_bar_warning, R.color.home_screen_bar_warning_severe, "free_days_expired_warning", true, null, null, Integer.valueOf((int) R.string.add_days), null, 176, null);
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class HelpTranslateMessage extends InfoBar {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HelpTranslateMessage(@NotNull String localizedMessage, @NotNull String buttonText) {
            super(0, R.color.home_screen_bar_info, "help_translate_info", true, localizedMessage, buttonText, null, null, 192, null);
            Intrinsics.checkNotNullParameter(localizedMessage, "localizedMessage");
            Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class HomeScreenTilesDragInfo extends InfoBar {
        public static final int $stable = 0;

        public HomeScreenTilesDragInfo() {
            super(R.string.home_screen_tile_long_press_info, R.color.home_screen_bar_info, "tile_long_press_info", false, null, null, null, null, 248, null);
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class NotificationWarning extends InfoBar {
        public static final int $stable = 0;

        public NotificationWarning() {
            super(R.string.all_notifications_disabled_warning, R.color.home_screen_bar_warning, "notification_warning", true, null, null, null, null, 240, null);
        }
    }

    /* compiled from: InfoBar.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class TwitterInfo extends InfoBar {
        public static final int $stable = 0;

        public TwitterInfo() {
            super(R.string.twitter_sign_up_encouragement, R.color.home_screen_bar_info, "twitter_follow_info", true, null, null, Integer.valueOf((int) R.string.twitter_follow), Integer.valueOf((int) R.drawable.not_icon_twitter), 48, null);
        }
    }

    public /* synthetic */ InfoBar(int i4, int i5, String str, boolean z3, String str2, String str3, Integer num, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, i5, str, z3, str2, str3, num, num2);
    }

    @NotNull
    public final String getAnalyticsName() {
        return this.f12356c;
    }

    public final int getBgColor() {
        return this.f12355b;
    }

    @Nullable
    public final String getConfigureOverride() {
        return this.f12359f;
    }

    @Nullable
    public final Integer getConfigureOverrideRes() {
        return this.f12360g;
    }

    @Nullable
    public final Integer getIconRes() {
        return this.f12361h;
    }

    public final int getMessage() {
        return this.f12354a;
    }

    @Nullable
    public final String getMessageOveride() {
        return this.f12358e;
    }

    public final boolean getShowConfigure() {
        return this.f12357d;
    }

    private InfoBar(@StringRes int i4, @ColorRes int i5, String str, boolean z3, String str2, String str3, @StringRes Integer num, Integer num2) {
        this.f12354a = i4;
        this.f12355b = i5;
        this.f12356c = str;
        this.f12357d = z3;
        this.f12358e = str2;
        this.f12359f = str3;
        this.f12360g = num;
        this.f12361h = num2;
    }

    public /* synthetic */ InfoBar(int i4, int i5, String str, boolean z3, String str2, String str3, Integer num, Integer num2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, i5, str, (i6 & 8) != 0 ? false : z3, (i6 & 16) != 0 ? null : str2, (i6 & 32) != 0 ? null : str3, (i6 & 64) != 0 ? null : num, (i6 & 128) != 0 ? null : num2, null);
    }
}
