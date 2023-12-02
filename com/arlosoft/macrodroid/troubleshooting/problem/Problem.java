package com.arlosoft.macrodroid.troubleshooting.problem;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.IntentCompat;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.settings.notificationbar.NotificationBarPreferencesActivity;
import com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver;
import com.arlosoft.macrodroid.troubleshooting.problem.Problem;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Problem.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class Problem {
    public static final int $stable = 8;

    /* renamed from: a  reason: collision with root package name */
    private final int f15826a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Integer f15827b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15828c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Integer f15829d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final List<Macro> f15830e;

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class AccessibilityMalfunction extends Problem {
        public static final int $stable = 0;

        public AccessibilityMalfunction() {
            super(R.string.troubleshoot_accessibility_malfunction, Integer.valueOf((int) R.string.settings), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_accessibility_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class BatteryOptimizationIsEnabled extends Problem {
        public static final int $stable = 0;

        public BatteryOptimizationIsEnabled() {
            super(R.string.troubleshoot_battery_optimization_is_enabled, Integer.valueOf((int) R.string.ignore_battery_optimisations), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                String packageName = activity.getPackageName();
                intent.setData(Uri.parse("package:" + packageName));
                activity.startActivity(intent);
            } catch (Exception unused) {
                activity.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class DontKeepActivitiesEnabled extends Problem {
        public static final int $stable = 0;

        public DontKeepActivitiesEnabled() {
            super(R.string.troubleshoot_dont_keep_activities_enabled, Integer.valueOf((int) R.string.configure), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ForceHideIconEnabled extends Problem {
        public static final int $stable = 0;

        public ForceHideIconEnabled() {
            super(R.string.troubleshoot_force_hide_icon_enabled, Integer.valueOf((int) R.string.configure), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivity(new Intent(activity, NotificationBarPreferencesActivity.class));
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class MiuiAutoStartNotEnabled extends Problem {
        public static final int $stable = 0;

        public MiuiAutoStartNotEnabled() {
            super(R.string.troubleshoot_miui_autostart_must_be_enabled_description, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            activity.startActivity(intent);
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class NotificationsDisabled extends Problem {
        public static final int $stable = 0;

        public NotificationsDisabled() {
            super(R.string.all_notifications_disabled_warning, Integer.valueOf((int) R.string.configure_notifications), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent putExtra = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Settings.ACTION_A…GE, activity.packageName)");
            activity.startActivity(putExtra);
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class PermissionsWillBeDisabled extends Problem {
        public static final int $stable = 0;

        public PermissionsWillBeDisabled() {
            super(R.string.troubleshoot_permissions_can_be_auto_disabled, Integer.valueOf((int) R.string.troubleshoot_go_to_permissions_settings), 0, Integer.valueOf((int) R.string.troubleshoot_hide_warning), 4, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivityForResult(IntentCompat.createManageUnusedAppRestrictionsIntent(activity, activity.getPackageName()), 0);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure2(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Settings.setHidePermissionRemoverWarning(activity, true);
            activity.finish();
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresAccessibility extends Problem {
        public static final int $stable = 0;

        public RequiresAccessibility() {
            super(R.string.troubleshoot_accessibility_required, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_accessibility_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresBackgroundLocationPermission extends Problem {
        public static final int $stable = 0;

        /* compiled from: Problem.kt */
        /* loaded from: classes3.dex */
        static final class a extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f15831d = new a();

            a() {
                super(1);
            }

            public final void invoke(boolean z3) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }

        public RequiresBackgroundLocationPermission() {
            super(R.string.background_location_permission_required, Integer.valueOf((int) R.string.enable), 0, Integer.valueOf((int) R.string.settings), null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Observable<Boolean> observeOn = new RxPermissions((FragmentActivity) activity).request("android.permission.ACCESS_BACKGROUND_LOCATION").observeOn(AndroidSchedulers.mainThread());
            final a aVar = a.f15831d;
            observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.troubleshooting.problem.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Problem.RequiresBackgroundLocationPermission.b(Function1.this, obj);
                }
            });
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure2(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                String packageName = activity.getPackageName();
                intent.setData(Uri.parse("package:" + packageName));
                activity.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) "DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN not supported on this device", 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresDefaultAssist extends Problem {
        public static final int $stable = 0;

        public RequiresDefaultAssist() {
            super(R.string.requires_assist_and_voice_input, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.VOICE_INPUT_SETTINGS"));
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresDeviceAdmin extends Problem {
        public static final int $stable = 0;

        public RequiresDeviceAdmin() {
            super(R.string.required_device_administrator, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            PermissionsHelper.showDeviceAdminRequiredDialog(activity, new ComponentName(activity, MacroDroidDeviceAdminReceiver.class), false, false);
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresDrawOverlays extends Problem {
        public static final int $stable = 0;

        public RequiresDrawOverlays() {
            super(R.string.requires_draw_overlays, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            String packageName = activity.getPackageName();
            intent.setData(Uri.parse("package:" + packageName));
            try {
                activity.startActivity(intent);
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresFilePathReconfiguration extends Problem {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final String f15832f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequiresFilePathReconfiguration(@NotNull String actionName) {
            super(0, null, 0, null, 12, null);
            Intrinsics.checkNotNullParameter(actionName, "actionName");
            this.f15832f = actionName;
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        @NotNull
        public String getDescriptionText(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = context.getString(R.string.troubleshoot_requires_file_path_reconfiguration, this.f15832f);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…onfiguration, actionName)");
                String format = String.format(string, Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            } catch (Exception unused) {
                return this.f15832f;
            }
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        @NotNull
        public String getTitleText(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return this.f15832f;
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivityForResult(IntentCompat.createManageUnusedAppRestrictionsIntent(activity, activity.getPackageName()), 0);
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresFingerprintInteractionAccessibility extends Problem {
        public static final int $stable = 0;

        public RequiresFingerprintInteractionAccessibility() {
            super(R.string.accessibility_fingerprint_description, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_accessibility_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresLocationServices extends Problem {
        public static final int $stable = 0;

        public RequiresLocationServices() {
            super(R.string.location_services_disabled, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } catch (ActivityNotFoundException unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) "DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN not supported on this device", 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresNewHelperFile extends Problem {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final String f15833f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequiresNewHelperFile(@NotNull String dialogTitle) {
            super(R.string.helper_file_required, Integer.valueOf((int) R.string.get_helper_file), 0, null, 12, null);
            Intrinsics.checkNotNullParameter(dialogTitle, "dialogTitle");
            this.f15833f = dialogTitle;
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            PermissionsHelper.showNeedsNewHelperFileDialog(activity, false, false, this.f15833f);
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresNotificationAccess extends Problem {
        public static final int $stable = 0;

        public RequiresNotificationAccess() {
            super(R.string.notification_access_required, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_notification_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresStandardPermission extends Problem {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final String f15834f;

        /* compiled from: Problem.kt */
        /* loaded from: classes3.dex */
        static final class a extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f15835d = new a();

            a() {
                super(1);
            }

            public final void invoke(boolean z3) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequiresStandardPermission(@NotNull String permission) {
            super(0, Integer.valueOf((int) R.string.enable), R.string.troubleshoot_missing_permission, null, 8, null);
            Intrinsics.checkNotNullParameter(permission, "permission");
            this.f15834f = permission;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        @NotNull
        public String getDescriptionText(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = context.getString(R.string.troubleshoot_macros_require_permissions);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…cros_require_permissions)");
                String substring = this.f15834f.substring(19);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                String format = String.format(string, Arrays.copyOf(new Object[]{substring}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            } catch (Exception unused) {
                return this.f15834f;
            }
        }

        @NotNull
        public final String getPermission() {
            return this.f15834f;
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Observable<Boolean> observeOn = new RxPermissions((FragmentActivity) activity).request(this.f15834f).observeOn(AndroidSchedulers.mainThread());
            final a aVar = a.f15835d;
            observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.troubleshooting.problem.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Problem.RequiresStandardPermission.b(Function1.this, obj);
                }
            });
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresUiInteractionAccessibility extends Problem {
        public static final int $stable = 0;

        public RequiresUiInteractionAccessibility() {
            super(R.string.troubleshoot_accessibility_ui_interaction_required, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_accessibility_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresUsageAccess extends Problem {
        public static final int $stable = 0;

        public RequiresUsageAccess() {
            super(R.string.usage_access_required, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresVolumeAccessibility extends Problem {
        public static final int $stable = 0;

        public RequiresVolumeAccessibility() {
            super(R.string.troubleshoot_accessibility_volume_required, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_accessibility_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class RequiresWriteSettings extends Problem {
        public static final int $stable = 0;

        public RequiresWriteSettings() {
            super(R.string.requires_write_settings, Integer.valueOf((int) R.string.enable), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse(activity.getPackageName()));
            try {
                activity.startActivity(intent);
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_settings), 1).show();
            }
        }
    }

    /* compiled from: Problem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class UiInteractionAccessibilityMalfunction extends Problem {
        public static final int $stable = 0;

        public UiInteractionAccessibilityMalfunction() {
            super(R.string.troubleshoot_accessibility_ui_interaction_malfunction, Integer.valueOf((int) R.string.settings), 0, null, 12, null);
        }

        @Override // com.arlosoft.macrodroid.troubleshooting.problem.Problem
        public void invokeConfigure(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
                ToastCompat.makeText(activity.getApplicationContext(), (CharSequence) activity.getString(R.string.cannot_launch_accessibility_settings), 1).show();
            }
        }
    }

    public /* synthetic */ Problem(int i4, Integer num, int i5, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, num, i5, num2);
    }

    @Nullable
    public final Integer getButton2Text() {
        return this.f15829d;
    }

    @Nullable
    public final Integer getButtonText() {
        return this.f15827b;
    }

    public final int getDescription() {
        return this.f15826a;
    }

    @NotNull
    public String getDescriptionText(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(this.f15826a);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(description)");
        return string;
    }

    @NotNull
    public final List<Macro> getMacroList() {
        return this.f15830e;
    }

    public final int getTitle() {
        return this.f15828c;
    }

    @Nullable
    public String getTitleText(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i4 = this.f15828c;
        if (i4 == 0) {
            return null;
        }
        return context.getString(i4);
    }

    public abstract void invokeConfigure(@NotNull Activity activity);

    public void invokeConfigure2(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    private Problem(@StringRes int i4, @StringRes Integer num, @StringRes int i5, @StringRes Integer num2) {
        this.f15826a = i4;
        this.f15827b = num;
        this.f15828c = i5;
        this.f15829d = num2;
        this.f15830e = new ArrayList();
    }

    public /* synthetic */ Problem(int i4, Integer num, int i5, Integer num2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, num, (i6 & 4) != 0 ? 0 : i5, (i6 & 8) != 0 ? null : num2, null);
    }
}
