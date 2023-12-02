package com.arlosoft.macrodroid.troubleshooting.help;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.accessibility.KeepAccessibilityServicesRunningActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.translations.UserTranslationHelper;
import com.arlosoft.macrodroid.utils.UninstallHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HelpItem.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class HelpItem {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f15817a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15818b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Integer f15819c;

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class AccessibilityServiceDisabled extends HelpItem {
        public static final int $stable = 0;

        public AccessibilityServiceDisabled() {
            super(R.string.troubleshoot_accessibility_service_disabled_title, R.string.troubleshoot_accessibility_service_disabled_description, Integer.valueOf((int) R.string.keep_accessibility_services_running), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                context.startActivity(new Intent(context, KeepAccessibilityServicesRunningActivity.class));
            } catch (ActivityNotFoundException unused) {
            }
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class AccessibilityServiceSlowdown extends HelpItem {
        public static final int $stable = 0;

        public AccessibilityServiceSlowdown() {
            super(R.string.troubleshoot_accessibility_service_causes_slowdown_title, R.string.troubleshoot_accessibility_service_causes_slowdown_description, Integer.valueOf((int) R.string.troubleshoot_accessibility_services_link), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                context.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class AppKilledInBackground extends HelpItem {
        public static final int $stable = 0;

        public AppKilledInBackground() {
            super(R.string.troubleshoot_app_killed_in_background_title, R.string.troubleshoot_app_killed_in_background_description, Integer.valueOf((int) R.string.dont_kill_my_app_com), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public int getOptionalButtonCount(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getPowerManangerIntents(context).size();
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://dontkillmyapp.com")));
            } catch (ActivityNotFoundException unused) {
            }
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performOptionalAction(@NotNull Context context, int i4) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                List<Intent> powerManangerIntents = getPowerManangerIntents(context);
                if (i4 < powerManangerIntents.size()) {
                    powerManangerIntents.get(i4).addFlags(268435456);
                    context.startActivity(powerManangerIntents.get(i4));
                }
            } catch (Exception unused) {
                ToastCompat.makeText(context.getApplicationContext(), (int) R.string.cannot_launch_settings, 1).show();
            }
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class BluetoothActionPopup extends HelpItem {
        public static final int $stable = 0;

        public BluetoothActionPopup() {
            super(R.string.troubleshoot_bluetooth_action_prompt_title, R.string.troubleshoot_bluetooth_action_prompt_description, Integer.valueOf((int) R.string.configure), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID, null));
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public boolean shouldShow() {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            Locale locale = Locale.ROOT;
            String lowerCase = MANUFACTURER.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (!Intrinsics.areEqual(lowerCase, "xiaomi")) {
                Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                String lowerCase2 = MANUFACTURER.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (!Intrinsics.areEqual(lowerCase2, "huawei")) {
                    return false;
                }
                return true;
            }
            return true;
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public boolean shouldShowConfigureButton() {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            String lowerCase = MANUFACTURER.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return Intrinsics.areEqual(lowerCase, "xiaomi");
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ButtonBarBorder extends HelpItem {
        public static final int $stable = 0;

        public ButtonBarBorder() {
            super(R.string.troubleshoot_button_bar_style_title, R.string.troubleshoot_button_bar_style_description, null, 4, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public boolean shouldShow() {
            if (Build.VERSION.SDK_INT >= 31) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class DontUnderstandFeature extends HelpItem {
        public static final int $stable = 0;

        public DontUnderstandFeature() {
            super(R.string.troubleshoot_dont_understand_feature_title, R.string.troubleshoot_dont_understand_feature_descritption, null, 4, null);
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class GeofencesNotWorking extends HelpItem {
        public static final int $stable = 0;

        public GeofencesNotWorking() {
            super(R.string.troubleshoot_geofence_not_working_title, R.string.troubleshoot_geofence_not_working_description, Integer.valueOf((int) R.string.action_clear_app_data), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", "com.google.android.gms", null));
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class HidePersistentNotification extends HelpItem {
        public static final int $stable = 0;

        public HidePersistentNotification() {
            super(R.string.troubleshoot_how_hide_persistent_notification_title, R.string.troubleshoot_how_hide_persistent_notification_description, Integer.valueOf((int) R.string.settings), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public boolean shouldShow() {
            if (Build.VERSION.SDK_INT >= 26) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class HighBatteryDrain extends HelpItem {
        public static final int $stable = 0;

        public HighBatteryDrain() {
            super(R.string.troubleshoot_high_battery_drain_title, R.string.troubleshoot_high_battery_drain_description, null, 4, null);
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class InteractionInGames extends HelpItem {
        public static final int $stable = 0;

        public InteractionInGames() {
            super(R.string.troubleshoot_ui_interaction_in_games_title, R.string.troubleshoot_ui_interaction_in_games_description, null, 4, null);
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class NotStartOnLaunch extends HelpItem {
        public static final int $stable = 0;

        public NotStartOnLaunch() {
            super(R.string.troubleshoot_app_not_start_on_boot_title, R.string.troubleshoot_app_not_start_on_boot_description, null, 4, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public int getOptionalButtonCount(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getPowerManangerIntents(context).size();
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performOptionalAction(@NotNull Context context, int i4) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                List<Intent> autoStartIntents = getAutoStartIntents(context);
                if (i4 < autoStartIntents.size()) {
                    autoStartIntents.get(i4).addFlags(268435456);
                    context.startActivity(autoStartIntents.get(i4));
                }
            } catch (Exception unused) {
                ToastCompat.makeText(context.getApplicationContext(), (int) R.string.cannot_launch_settings, 1).show();
            }
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ProVersionNotApplied extends HelpItem {
        public static final int $stable = 0;

        public ProVersionNotApplied() {
            super(R.string.troubleshoot_pro_version_not_applied_title, R.string.troubleshoot_pro_version_not_applied_description, Integer.valueOf((int) R.string.action_clear_app_data), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", "com.android.vending", null));
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class SpeakTextNotWorking extends HelpItem {
        public static final int $stable = 0;

        public SpeakTextNotWorking() {
            super(R.string.troubleshoot_accessibility_speak_text_action_not_working_title, R.string.troubleshoot_accessibility_speak_text_action_not_working_description, Integer.valueOf((int) R.string.open_text_to_speech_settings), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Intent intent = new Intent("com.android.settings.TTS_SETTINGS");
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e4) {
                SystemLog.logError("Could not open TTS settings: " + e4);
                ToastCompat.makeText(context.getApplicationContext(), (int) R.string.error, 0).show();
            }
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class TranslationsPoorOrMissing extends HelpItem {
        public static final int $stable = 0;

        public TranslationsPoorOrMissing() {
            super(R.string.troubleshoot_translations_poor_or_missing_title, R.string.translation_info, Integer.valueOf((int) R.string.request_translation_access), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            UserTranslationHelper.INSTANCE.createTranslationOfferEmail(context);
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class UIInteractionStopsWorking extends HelpItem {
        public static final int $stable = 0;

        public UIInteractionStopsWorking() {
            super(R.string.troubleshoot_high_ui_interaction_stops_working_title, R.string.troubleshoot_high_ui_interaction_stops_working_description, Integer.valueOf((int) R.string.troubleshoot_accessibility_services_link), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                context.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class UnableToUninstall extends HelpItem {
        public static final int $stable = 0;

        public UnableToUninstall() {
            super(R.string.troubleshoot_cant_uninstall_title, R.string.troubleshoot_cant_uninstall_description, Integer.valueOf((int) R.string.uninstall_macrodroid), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            UninstallHelper.uninstallMacroDroid(context);
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class WhyLocationPremission extends HelpItem {
        public static final int $stable = 0;

        public WhyLocationPremission() {
            super(R.string.troubleshoot_why_location_permission_title, R.string.troubleshoot_why_location_permission_description, Integer.valueOf((int) R.string.link_wifi_location), null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.help.HelpItem
        public void performAction(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(context.getString(R.string.link_wifi_location))));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: HelpItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class WhyNeedHelperFile extends HelpItem {
        public static final int $stable = 0;

        public WhyNeedHelperFile() {
            super(R.string.troubleshoot_why_need_helper_file_title, R.string.troubleshoot_why_need_helper_file_description, null, 4, null);
        }
    }

    public /* synthetic */ HelpItem(int i4, int i5, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, i5, num);
    }

    @NotNull
    public final List<Intent> getAutoStartIntents(@NotNull Context context) {
        List<Intent> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Intent[]{new Intent("miui.intent.action.OP_AUTO_START").addCategory("android.intent.category.DEFAULT"), new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity")), new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity")), new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")), new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager")), new Intent().setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")), new Intent().setComponent(new ComponentName("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity")), new Intent().setComponent(new ComponentName("com.htc.pitroad", "com.htc.pitroad.landingpage.activity.LandingPageActivity")), new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.MainActivity")), new Intent().setComponent(new ComponentName("com.transsion.phonemanager", "com.itel.autobootmanager.activity.AutoBootMgrActivity"))});
        ArrayList arrayList = new ArrayList();
        for (Intent intent : listOf) {
            if (intent != null && intent.resolveActivity(context.getPackageManager()) != null && context.getPackageManager().resolveActivity(intent, 65536) != null) {
                arrayList.add(intent);
            }
        }
        return arrayList;
    }

    @Nullable
    public final Integer getButtonText() {
        return this.f15819c;
    }

    public final int getDescription() {
        return this.f15818b;
    }

    public int getOptionalButtonCount(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return 0;
    }

    @NotNull
    public final List<Intent> getPowerManangerIntents(@NotNull Context context) {
        List<Intent> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Intent[]{new Intent("miui.intent.action.POWER_HIDE_MODE_APP_LIST").addCategory("android.intent.category.DEFAULT"), new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.powercenter.PowerSettings")), new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.power.ui.HwPowerManagerActivity")), new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")), new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager")), new Intent().setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")), new Intent().setComponent(new ComponentName("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity")), new Intent().setComponent(new ComponentName("com.htc.pitroad", "com.htc.pitroad.landingpage.activity.LandingPageActivity")), new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.MainActivity")), new Intent().setComponent(new ComponentName("com.transsion.phonemanager", "com.itel.autobootmanager.activity.AutoBootMgrActivity"))});
        ArrayList arrayList = new ArrayList();
        for (Intent intent : listOf) {
            if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                Intrinsics.checkNotNullExpressionValue(intent, "intent");
                arrayList.add(intent);
            }
        }
        return arrayList;
    }

    public final int getTitle() {
        return this.f15817a;
    }

    public void performAction(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void performOptionalAction(@NotNull Context context, int i4) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean shouldShow() {
        return true;
    }

    public boolean shouldShowConfigureButton() {
        return true;
    }

    private HelpItem(@StringRes int i4, @StringRes int i5, @StringRes Integer num) {
        this.f15817a = i4;
        this.f15818b = i5;
        this.f15819c = num;
    }

    public /* synthetic */ HelpItem(int i4, int i5, Integer num, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, i5, (i6 & 4) != 0 ? null : num, null);
    }
}
