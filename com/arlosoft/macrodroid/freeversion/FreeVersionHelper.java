package com.arlosoft.macrodroid.freeversion;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.troubleshooting.problem.PermissionChecker;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.firebase.analytics.ktx.AnalyticsKt;
import com.google.firebase.ktx.Firebase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: FreeVersionHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FreeVersionHelper {
    public static final int FREE_DAYS_ALARM_UNIQUE_ID = 72653;
    public static final int ONE_DAY_IN_MILLIS = 86400000;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PremiumStatusHandler f12180a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final RemoteConfig f12181b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final PermissionChecker f12182c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final ExtrasManager f12183d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Context f12184e;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: FreeVersionHelper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FreeVersionHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ DataSharingService $service;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(DataSharingService dataSharingService) {
            super(1);
            this.$service = dataSharingService;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            if (z3) {
                FreeVersionHelper.this.a();
                this.$service.getDataPartner().enableDataSharing();
                return;
            }
            String name = this.$service.name();
            SystemLog.logError("Failed to initialise data sharing service: " + name);
        }
    }

    @Inject
    public FreeVersionHelper(@NotNull PremiumStatusHandler premiumStatusHandler, @NotNull RemoteConfig remoteConfig, @NotNull PermissionChecker permissionChecker, @NotNull ExtrasManager extrasManager, @ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        Intrinsics.checkNotNullParameter(extrasManager, "extrasManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f12180a = premiumStatusHandler;
        this.f12181b = remoteConfig;
        this.f12182c = permissionChecker;
        this.f12183d = extrasManager;
        this.f12184e = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        Object systemService = this.f12184e.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).cancel(b());
    }

    private final PendingIntent b() {
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f12184e, FREE_DAYS_ALARM_UNIQUE_ID, new Intent(this.f12184e, FreeDaysAlarmReceiver.class), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(context, FR…entHelper.FLAG_IMMUTABLE)");
        return broadcast;
    }

    private final boolean c() {
        if (isOldInstallAllowedUnlimitedUse()) {
            AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("limited_free_use", "false");
            return true;
        } else if (!this.f12181b.getLimitedFreeUsageEnabledState()) {
            AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("limited_free_use", "false");
            return true;
        } else if (this.f12180a.getPremiumStatus().isPro()) {
            AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("limited_free_use", "false");
            return true;
        } else if (this.f12183d.isExtraInstalled(BillingModuleKt.SKU_STOPCLUB_SUB)) {
            AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("limited_free_use", "false");
            return true;
        } else {
            AnalyticsKt.getAnalytics(Firebase.INSTANCE).setUserProperty("limited_free_use", "true");
            if (getEnabledDataSharingService() != DataSharingService.NONE) {
                return true;
            }
            getEnabledDataSharingService().getDataPartner().disableDataSharing(false);
            return false;
        }
    }

    public final void addExtraDays(int i4) {
        long freeDaysExpiry = Settings.getFreeDaysExpiry(this.f12184e);
        if (freeDaysExpiry <= System.currentTimeMillis()) {
            freeDaysExpiry = System.currentTimeMillis();
        }
        Settings.setFreeDaysExpiry(this.f12184e, freeDaysExpiry + (i4 * 86400000));
        scheduleFreeDaysExpiryAlarm();
    }

    public final void displayFreeDaysExpiredNotification() {
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(this.f12184e, Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY).setSmallIcon(R.drawable.ic_clock_alert_outline).setContentTitle(this.f12184e.getString(R.string.macrodroid_free_days_expired)).setContentText(this.f12184e.getString(R.string.macrodroid_disabled_due_to_free_days)).setAutoCancel(true).setChannelId(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY).setContentIntent(PendingIntent.getActivity(this.f12184e, 0, new Intent(this.f12184e, AddDaysActivity.class), 335544320));
        Intrinsics.checkNotNullExpressionValue(contentIntent, "Builder(context, Constan…tentIntent(pendingIntent)");
        Notification build = contentIntent.build();
        Intrinsics.checkNotNullExpressionValue(build, "notificationBuilder.build()");
        Object systemService = this.f12184e.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(0, build);
    }

    @NotNull
    public final List<DataSharingService> getAvailableDataSharingServices() {
        ArrayList arrayList = new ArrayList();
        if (this.f12181b.getDataSharingEnabledHuq() || Intrinsics.areEqual(getEnabledDataSharingService().getServiceName(), DataSharingService.HUQ.getServiceName())) {
            arrayList.add(DataSharingService.HUQ);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r0 != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
        if (r0 == 0) goto L19;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.arlosoft.macrodroid.freeversion.DataSharingService getEnabledDataSharingService() {
        /*
            r3 = this;
            android.content.Context r0 = r3.f12184e
            com.arlosoft.macrodroid.freeversion.DataSharingService r0 = com.arlosoft.macrodroid.settings.Settings.getDataSharingService(r0)
            com.arlosoft.macrodroid.freeversion.DataSharingService r1 = com.arlosoft.macrodroid.freeversion.DataSharingService.DATA_AI
            if (r0 != r1) goto L13
            com.arlosoft.macrodroid.troubleshooting.problem.PermissionChecker r2 = r3.f12182c
            boolean r2 = r2.isUsageAccessEnabled()
            if (r2 == 0) goto L13
            return r1
        L13:
            com.arlosoft.macrodroid.freeversion.DataSharingService r1 = com.arlosoft.macrodroid.freeversion.DataSharingService.HUQ
            if (r0 != r1) goto L3e
            com.arlosoft.macrodroid.troubleshooting.problem.PermissionChecker r0 = r3.f12182c
            boolean r0 = r0.isLocationServicesEnabled()
            if (r0 == 0) goto L3e
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L3d
            r2 = 29
            if (r0 >= r2) goto L33
            android.content.Context r0 = r3.f12184e
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            int r0 = androidx.core.widget.z.a(r0, r2)
            if (r0 == 0) goto L3d
        L33:
            android.content.Context r0 = r3.f12184e
            java.lang.String r2 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            int r0 = androidx.core.widget.z.a(r0, r2)
            if (r0 != 0) goto L3e
        L3d:
            return r1
        L3e:
            com.arlosoft.macrodroid.freeversion.DataSharingService r0 = com.arlosoft.macrodroid.freeversion.DataSharingService.NONE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.freeversion.FreeVersionHelper.getEnabledDataSharingService():com.arlosoft.macrodroid.freeversion.DataSharingService");
    }

    public final int getRoundedDaysRemaining() {
        return (int) Math.ceil((Settings.getFreeDaysExpiry(this.f12184e) - System.currentTimeMillis()) / 8.64E7d);
    }

    @NotNull
    public final String getTimeRemainingText() {
        String format;
        String format2;
        long freeDaysExpiry = Settings.getFreeDaysExpiry(this.f12184e);
        long currentTimeMillis = System.currentTimeMillis();
        if (getEnabledDataSharingService() != DataSharingService.NONE) {
            String string = this.f12184e.getString(R.string.unlimited_free_usage_enabled);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…mited_free_usage_enabled)");
            return string;
        } else if (freeDaysExpiry < currentTimeMillis) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = this.f12184e.getString(R.string.macrodroid_free_days_expired);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…odroid_free_days_expired)");
            String format3 = String.format(string2, Arrays.copyOf(new Object[]{0}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        } else if (freeDaysExpiry - 86400000 < currentTimeMillis) {
            int ceil = (int) Math.ceil((freeDaysExpiry - currentTimeMillis) / 3600000.0d);
            if (ceil == 1) {
                format2 = this.f12184e.getString(R.string.one_hour_remaining_free_usage);
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string3 = this.f12184e.getString(R.string.x_hours_remaining_free_usage);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…urs_remaining_free_usage)");
                format2 = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(ceil)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            }
            Intrinsics.checkNotNullExpressionValue(format2, "{\n            val hoursR…)\n            }\n        }");
            return format2;
        } else {
            int ceil2 = (int) Math.ceil((freeDaysExpiry - currentTimeMillis) / 8.64E7d);
            if (ceil2 == 1) {
                format = this.f12184e.getString(R.string.one_day_remaining_free_usage);
            } else {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String string4 = this.f12184e.getString(R.string.x_days_remaining_free_usage);
                Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…ays_remaining_free_usage)");
                format = String.format(string4, Arrays.copyOf(new Object[]{Integer.valueOf(ceil2)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            Intrinsics.checkNotNullExpressionValue(format, "{\n            val daysRe…)\n            }\n        }");
            return format;
        }
    }

    public final boolean haveFreeDaysExpired() {
        if (!c() && System.currentTimeMillis() > Settings.getFreeDaysExpiry(this.f12184e)) {
            return true;
        }
        return false;
    }

    public final boolean isOldInstallAllowedUnlimitedUse() {
        if (Settings.getFirstVersionRun(this.f12184e) < 53600000) {
            return true;
        }
        return false;
    }

    public final boolean isPollfishEnabled() {
        return this.f12181b.getPollFishSurveysEnabled();
    }

    public final void scheduleFreeDaysExpiryAlarm() {
        if (c()) {
            return;
        }
        long freeDaysExpiry = Settings.getFreeDaysExpiry(this.f12184e);
        long timeInMillis = (freeDaysExpiry - Calendar.getInstance().getTimeInMillis()) / 1000;
        long j4 = 60;
        SystemLog.logDebug("Free version expires in " + (timeInMillis / ((long) Strategy.TTL_SECONDS_MAX)) + "d " + ((timeInMillis / 3600) % 24) + "h " + ((timeInMillis / j4) % j4) + "m " + (timeInMillis % j4) + "s (totalSeconds = " + timeInMillis + ", epochtime = " + timeInMillis + ")");
        AlarmHelper.scheduleExactAlarmWithInexactFallback$default(0, freeDaysExpiry, b(), false, 8, null);
    }

    public final void setEnabledDataSharingService(@NotNull DataSharingService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        Settings.setDataSharingService(this.f12184e, service);
        service.getDataPartner().initialise(new a(service));
    }
}
