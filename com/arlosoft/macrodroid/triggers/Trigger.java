package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.WaitUntilTriggerAction;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroUpdateEvent;
import com.arlosoft.macrodroid.logging.LogActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.AddTriggerActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.ActivityRecognitionTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.AirplaneModeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.AndroidWearTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ApplicationInstalledRemovedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ApplicationLaunchedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.AutoRotateChangeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.AutoSyncChangeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.BatteryLevelTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.BatterySaverTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.BatteryTemperatureTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.BluetoothBeaconTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.BluetoothTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.BootTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.CalendarTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.CallActiveTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.CallEndedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.CallMissedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.CellTowerTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ClipboardChangeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.DarkThemeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.DataOnOffTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.DayDreamTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.DayTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.DeviceUnlockedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.DialNumberTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.DockTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.DrawerOpenCloseTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.EmptyTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ExternalPowerTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.FailedLoginTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.FingerprintGestureTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.FlipDeviceTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.FloatingButtonTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.FoldAngleTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.GPSEnabledTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.GeofenceTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.GoogleAssistantTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.HeadphonesTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.HomeButtonLongPressTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.HotspotTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.IncomingCallTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.IncomingSMSTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.IntentReceivedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.IpAddressChangeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.LightSensorTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.LocalePluginTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.LocationTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.LogcatTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.MacroDroidInitialisedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.MacroEnabledTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.MacroFinishedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.MediaButtonPressedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.MediaButtonV2TriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ModeEnterExitTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.MusicPlayingTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.NFCTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.NetworkRoamingChangedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.NotificationButtonTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.NotificationTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.OrientationTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.OutgoingCallTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.PebbleTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.PowerButtonLongPressTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.PowerButtonToggleTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.PriorityModeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ProximityTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.QuickSettingsTileTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.RecentAppsTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.RegularIntervalTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SMSSentTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ScreenContentTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ScreenOnOffTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ShakeDeviceTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.ShortcutTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SignalOnOffTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SilentModeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SimChangeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SleepTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SpotifyTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.StopwatchTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SunriseSunsetTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SwipeTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SystemLogTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.SystemSettingTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.TimerTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.UsbDeviceConnectionTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.VariableTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.VolumeButtonTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.VolumeLongPressTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.VpnTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.WeatherTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.WebHookTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.WidgetPressedTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.WifiConnectionTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.WifiSSIDTriggerInfo;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import com.google.android.material.snackbar.SnackbarAnimate;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public abstract class Trigger extends SelectableItem {
    public static final Object enabledStateLock = new Object();

    /* renamed from: b  reason: collision with root package name */
    transient boolean f14431b;
    private transient long parentGUID;

    public Trigger() {
    }

    private static void I(List<SelectableItemInfo> list, SelectableItemInfo selectableItemInfo) {
        if (selectableItemInfo.allowedOnDevice()) {
            list.add(selectableItemInfo);
        }
    }

    private void J() {
        Macro macro = getMacro();
        macro.setTriggerThatInvoked(this);
        TriggerContextInfo testTriggerContentInfo = getTestTriggerContentInfo();
        if (testTriggerContentInfo != null) {
            macro.setTriggerContextInfo(testTriggerContentInfo);
        }
        macro.invokeActions(macro.getTriggerContextInfo(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int K(Collator collator, Context context, SelectableItemInfo selectableItemInfo, SelectableItemInfo selectableItemInfo2) {
        return collator.compare(context.getString(selectableItemInfo.getName()), context.getString(selectableItemInfo2.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int L(Collator collator, SelectableItemCategory selectableItemCategory, SelectableItemCategory selectableItemCategory2) {
        return collator.compare(selectableItemCategory.getCategoryName(), selectableItemCategory2.getCategoryName());
    }

    public static List<SelectableItemInfo> getAllTriggersInfo(final Context context) {
        ArrayList arrayList = new ArrayList();
        I(arrayList, HeadphonesTriggerInfo.getInstance());
        I(arrayList, BluetoothTriggerInfo.getInstance());
        I(arrayList, PowerButtonToggleTriggerInfo.getInstance());
        I(arrayList, BatteryLevelTriggerInfo.getInstance());
        I(arrayList, AirplaneModeTriggerInfo.getInstance());
        I(arrayList, TimerTriggerInfo.getInstance());
        I(arrayList, WidgetPressedTriggerInfo.getInstance());
        I(arrayList, DialNumberTriggerInfo.getInstance());
        I(arrayList, IncomingSMSTriggerInfo.getInstance());
        I(arrayList, IncomingCallTriggerInfo.getInstance());
        I(arrayList, ExternalPowerTriggerInfo.getInstance());
        I(arrayList, WifiConnectionTriggerInfo.getInstance());
        I(arrayList, BootTriggerInfo.getInstance());
        I(arrayList, SignalOnOffTriggerInfo.getInstance());
        I(arrayList, RegularIntervalTriggerInfo.getInstance());
        I(arrayList, LocationTriggerInfo.getInstance());
        I(arrayList, ScreenOnOffTriggerInfo.getInstance());
        I(arrayList, ApplicationInstalledRemovedTriggerInfo.getInstance());
        I(arrayList, ShakeDeviceTriggerInfo.getInstance());
        I(arrayList, DockTriggerInfo.getInstance());
        I(arrayList, SilentModeTriggerInfo.getInstance());
        I(arrayList, NotificationTriggerInfo.getInstance());
        I(arrayList, WifiSSIDTriggerInfo.getInstance());
        I(arrayList, ModeEnterExitTriggerInfo.getInstance());
        I(arrayList, CallEndedTriggerInfo.getInstance());
        I(arrayList, DataOnOffTriggerInfo.getInstance());
        I(arrayList, FailedLoginTriggerInfo.getInstance());
        I(arrayList, ShortcutTriggerInfo.getInstance());
        I(arrayList, FlipDeviceTriggerInfo.getInstance());
        I(arrayList, ProximityTriggerInfo.getInstance());
        I(arrayList, VolumeButtonTriggerInfo.getInstance());
        I(arrayList, VolumeLongPressTriggerInfo.getInstance());
        I(arrayList, GPSEnabledTriggerInfo.getInstance());
        I(arrayList, OutgoingCallTriggerInfo.getInstance());
        I(arrayList, SMSSentTriggerInfo.getInstance());
        I(arrayList, VariableTriggerInfo.getInstance());
        I(arrayList, DeviceUnlockedTriggerInfo.getInstance());
        I(arrayList, EmptyTriggerInfo.getInstance());
        I(arrayList, HotspotTriggerInfo.getInstance());
        I(arrayList, MacroDroidInitialisedTriggerInfo.getInstance());
        I(arrayList, WeatherTriggerInfo.getInstance());
        I(arrayList, CalendarTriggerInfo.getInstance());
        I(arrayList, AndroidWearTriggerInfo.getInstance());
        I(arrayList, CallActiveTriggerInfo.getInstance());
        I(arrayList, DayTriggerInfo.getInstance());
        I(arrayList, CallMissedTriggerInfo.getInstance());
        I(arrayList, ClipboardChangeTriggerInfo.getInstance());
        I(arrayList, NetworkRoamingChangedTriggerInfo.getInstance());
        I(arrayList, SunriseSunsetTriggerInfo.getInstance());
        I(arrayList, ActivityRecognitionTriggerInfo.getInstance());
        I(arrayList, FloatingButtonTriggerInfo.getInstance());
        I(arrayList, StopwatchTriggerInfo.getInstance());
        I(arrayList, AutoSyncChangeTriggerInfo.getInstance());
        I(arrayList, AutoRotateChangeTriggerInfo.getInstance());
        I(arrayList, BatterySaverTriggerInfo.getInstance());
        I(arrayList, IntentReceivedTriggerInfo.getInstance());
        I(arrayList, OrientationTriggerInfo.getInstance());
        I(arrayList, SleepTriggerInfo.getInstance());
        if (context.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle")) {
            I(arrayList, FoldAngleTriggerInfo.getInstance());
        }
        I(arrayList, MediaButtonPressedTriggerInfo.getInstance());
        I(arrayList, MediaButtonV2TriggerInfo.getInstance());
        I(arrayList, ApplicationLaunchedTriggerInfo.getInstance());
        I(arrayList, SwipeTriggerInfo.getInstance());
        I(arrayList, NotificationButtonTriggerInfo.getInstance());
        I(arrayList, DrawerOpenCloseTriggerInfo.getInstance());
        I(arrayList, MacroEnabledTriggerInfo.getInstance());
        I(arrayList, MacroFinishedTriggerInfo.getInstance());
        I(arrayList, SystemLogTriggerInfo.getInstance());
        I(arrayList, DayDreamTriggerInfo.getInstance());
        I(arrayList, RecentAppsTriggerInfo.getInstance());
        I(arrayList, MusicPlayingTriggerInfo.getInstance());
        I(arrayList, QuickSettingsTileTriggerInfo.getInstance());
        I(arrayList, GeofenceTriggerInfo.getInstance());
        I(arrayList, NFCTriggerInfo.getInstance());
        I(arrayList, PebbleTriggerInfo.getInstance());
        I(arrayList, CellTowerTriggerInfo.getInstance());
        I(arrayList, LightSensorTriggerInfo.getInstance());
        I(arrayList, LocalePluginTriggerInfo.getInstance());
        I(arrayList, FingerprintGestureTriggerInfo.getInstance());
        I(arrayList, HomeButtonLongPressTriggerInfo.getInstance());
        I(arrayList, PowerButtonLongPressTriggerInfo.getInstance());
        I(arrayList, BluetoothBeaconTriggerInfo.getInstance());
        I(arrayList, WebHookTriggerInfo.getInstance());
        I(arrayList, UsbDeviceConnectionTriggerInfo.getInstance());
        I(arrayList, BatteryTemperatureTriggerInfo.getInstance());
        I(arrayList, PriorityModeTriggerInfo.getInstance());
        I(arrayList, LogcatTriggerInfo.getInstance());
        I(arrayList, SimChangeTriggerInfo.getInstance());
        I(arrayList, DarkThemeTriggerInfo.getInstance());
        I(arrayList, SystemSettingTriggerInfo.getInstance());
        I(arrayList, ScreenContentTriggerInfo.getInstance());
        I(arrayList, SpotifyTriggerInfo.getInstance());
        I(arrayList, GoogleAssistantTriggerInfo.getInstance());
        I(arrayList, VpnTriggerInfo.getInstance());
        I(arrayList, IpAddressChangeTriggerInfo.getInstance());
        final Collator collator = Collator.getInstance(Settings.getLocale(context));
        collator.setStrength(0);
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.triggers.s8
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int K;
                K = Trigger.K(collator, context, (SelectableItemInfo) obj, (SelectableItemInfo) obj2);
                return K;
            }
        });
        return arrayList;
    }

    public static List<SelectableItemCategory> getCategories(Context context) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        I(arrayList2, BatteryLevelTriggerInfo.getInstance());
        I(arrayList2, BatterySaverTriggerInfo.getInstance());
        I(arrayList2, ExternalPowerTriggerInfo.getInstance());
        I(arrayList2, PowerButtonToggleTriggerInfo.getInstance());
        I(arrayList2, BatteryTemperatureTriggerInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_battery_power), R.drawable.ic_power_plug_white_24dp, arrayList2));
        ArrayList arrayList3 = new ArrayList();
        I(arrayList3, AndroidWearTriggerInfo.getInstance());
        I(arrayList3, PebbleTriggerInfo.getInstance());
        I(arrayList3, BluetoothTriggerInfo.getInstance());
        I(arrayList3, HotspotTriggerInfo.getInstance());
        I(arrayList3, HeadphonesTriggerInfo.getInstance());
        I(arrayList3, SignalOnOffTriggerInfo.getInstance());
        I(arrayList3, NetworkRoamingChangedTriggerInfo.getInstance());
        I(arrayList3, WifiConnectionTriggerInfo.getInstance());
        I(arrayList3, WifiSSIDTriggerInfo.getInstance());
        I(arrayList3, DataOnOffTriggerInfo.getInstance());
        I(arrayList3, BluetoothBeaconTriggerInfo.getInstance());
        I(arrayList3, WebHookTriggerInfo.getInstance());
        I(arrayList3, UsbDeviceConnectionTriggerInfo.getInstance());
        I(arrayList3, VpnTriggerInfo.getInstance());
        I(arrayList3, IpAddressChangeTriggerInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_connectivity), R.drawable.ic_router_wireless_white_24dp, arrayList3));
        ArrayList arrayList4 = new ArrayList();
        I(arrayList4, IncomingCallTriggerInfo.getInstance());
        I(arrayList4, CallMissedTriggerInfo.getInstance());
        I(arrayList4, CallActiveTriggerInfo.getInstance());
        I(arrayList4, CallEndedTriggerInfo.getInstance());
        I(arrayList4, IncomingSMSTriggerInfo.getInstance());
        I(arrayList4, DialNumberTriggerInfo.getInstance());
        I(arrayList4, OutgoingCallTriggerInfo.getInstance());
        I(arrayList4, SMSSentTriggerInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_call_sms), R.drawable.ic_phone_classic_white_24dp, arrayList4));
        ArrayList arrayList5 = new ArrayList();
        I(arrayList5, ActivityRecognitionTriggerInfo.getInstance());
        I(arrayList5, FlipDeviceTriggerInfo.getInstance());
        I(arrayList5, ShakeDeviceTriggerInfo.getInstance());
        I(arrayList5, LightSensorTriggerInfo.getInstance());
        I(arrayList5, ProximityTriggerInfo.getInstance());
        I(arrayList5, OrientationTriggerInfo.getInstance());
        I(arrayList5, SleepTriggerInfo.getInstance());
        if (context.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle")) {
            I(arrayList5, FoldAngleTriggerInfo.getInstance());
        }
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_sensors), R.drawable.ic_compass_outline_white_24dp, arrayList5));
        ArrayList arrayList6 = new ArrayList();
        I(arrayList6, MediaButtonPressedTriggerInfo.getInstance());
        I(arrayList6, MediaButtonV2TriggerInfo.getInstance());
        I(arrayList6, ShortcutTriggerInfo.getInstance());
        I(arrayList6, SwipeTriggerInfo.getInstance());
        I(arrayList6, VolumeButtonTriggerInfo.getInstance());
        I(arrayList6, VolumeLongPressTriggerInfo.getInstance());
        I(arrayList6, WidgetPressedTriggerInfo.getInstance());
        I(arrayList6, FloatingButtonTriggerInfo.getInstance());
        I(arrayList6, FingerprintGestureTriggerInfo.getInstance());
        I(arrayList6, HomeButtonLongPressTriggerInfo.getInstance());
        I(arrayList6, PowerButtonLongPressTriggerInfo.getInstance());
        I(arrayList6, GoogleAssistantTriggerInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_user_input), R.drawable.ic_account_white_24dp, arrayList6));
        ArrayList arrayList7 = new ArrayList();
        I(arrayList7, CalendarTriggerInfo.getInstance());
        I(arrayList7, DayTriggerInfo.getInstance());
        I(arrayList7, TimerTriggerInfo.getInstance());
        I(arrayList7, StopwatchTriggerInfo.getInstance());
        I(arrayList7, RegularIntervalTriggerInfo.getInstance());
        I(arrayList7, SunriseSunsetTriggerInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_date_time), R.drawable.ic_calendar_clock_white_24dp, arrayList7));
        ArrayList arrayList8 = new ArrayList();
        I(arrayList8, BootTriggerInfo.getInstance());
        I(arrayList8, DayDreamTriggerInfo.getInstance());
        I(arrayList8, FailedLoginTriggerInfo.getInstance());
        I(arrayList8, NotificationTriggerInfo.getInstance());
        I(arrayList8, ScreenOnOffTriggerInfo.getInstance());
        I(arrayList8, DeviceUnlockedTriggerInfo.getInstance());
        I(arrayList8, SilentModeTriggerInfo.getInstance());
        I(arrayList8, DockTriggerInfo.getInstance());
        I(arrayList8, AirplaneModeTriggerInfo.Companion.getInstance());
        I(arrayList8, GPSEnabledTriggerInfo.getInstance());
        I(arrayList8, MusicPlayingTriggerInfo.getInstance());
        I(arrayList8, NFCTriggerInfo.getInstance());
        I(arrayList8, AutoRotateChangeTriggerInfo.getInstance());
        I(arrayList8, ClipboardChangeTriggerInfo.getInstance());
        I(arrayList8, AutoSyncChangeTriggerInfo.getInstance());
        I(arrayList8, IntentReceivedTriggerInfo.getInstance());
        I(arrayList8, PriorityModeTriggerInfo.getInstance());
        I(arrayList8, LogcatTriggerInfo.getInstance());
        I(arrayList8, SimChangeTriggerInfo.getInstance());
        I(arrayList8, DarkThemeTriggerInfo.getInstance());
        I(arrayList8, SystemSettingTriggerInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_device_events), R.drawable.ic_cellphone_android_white_24dp, arrayList8));
        ArrayList arrayList9 = new ArrayList();
        I(arrayList9, ApplicationInstalledRemovedTriggerInfo.getInstance());
        I(arrayList9, ApplicationLaunchedTriggerInfo.getInstance());
        I(arrayList9, LocalePluginTriggerInfo.getInstance());
        I(arrayList9, RecentAppsTriggerInfo.getInstance());
        I(arrayList9, ScreenContentTriggerInfo.getInstance());
        I(arrayList9, SpotifyTriggerInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_applications), R.drawable.ic_apps_white_24dp, arrayList9));
        ArrayList arrayList10 = new ArrayList();
        I(arrayList10, QuickSettingsTileTriggerInfo.getInstance());
        I(arrayList10, EmptyTriggerInfo.getInstance());
        I(arrayList10, MacroDroidInitialisedTriggerInfo.getInstance());
        I(arrayList10, ModeEnterExitTriggerInfo.getInstance());
        I(arrayList10, VariableTriggerInfo.getInstance());
        I(arrayList10, NotificationButtonTriggerInfo.getInstance());
        I(arrayList10, DrawerOpenCloseTriggerInfo.getInstance());
        I(arrayList10, MacroEnabledTriggerInfo.getInstance());
        I(arrayList10, MacroFinishedTriggerInfo.getInstance());
        I(arrayList10, SystemLogTriggerInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_macrodroid_specific), R.drawable.active_icon_new, arrayList10));
        ArrayList arrayList11 = new ArrayList();
        I(arrayList11, LocationTriggerInfo.getInstance());
        I(arrayList11, GeofenceTriggerInfo.getInstance());
        I(arrayList11, CellTowerTriggerInfo.getInstance());
        I(arrayList11, WeatherTriggerInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_location), R.drawable.ic_google_maps_white_24dp, arrayList11));
        final Collator collator = Collator.getInstance(Settings.getLocale(context));
        collator.setStrength(0);
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.triggers.t8
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int L;
                L = Trigger.L(collator, (SelectableItemCategory) obj, (SelectableItemCategory) obj2);
                return L;
            }
        });
        return arrayList;
    }

    public void checkPermissionsAndEnableTrigger() {
        if (!checkAllPermissions()) {
            SystemLog.logError(getMacro().getName() + " - " + getConfiguredName() + "  missing permission");
        }
        if (isEnabled()) {
            enableTriggerThreadSafe();
        }
    }

    public boolean constraintsMet() {
        return constraintsMet(null);
    }

    protected abstract void disableTrigger();

    public void disableTriggerThreadSafe() {
        synchronized (enabledStateLock) {
            if (!this.f14431b) {
                return;
            }
            this.f14431b = false;
            disableTrigger();
        }
    }

    protected abstract void enableTrigger();

    public void enableTriggerThreadSafe() {
        synchronized (enabledStateLock) {
            if (this.f14431b) {
                return;
            }
            this.f14431b = true;
            enableTrigger();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getDialogTheme() {
        return R.style.Theme_App_Dialog_Trigger;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getLogEntryStart() {
        return LogActivity.TRIGGER_FIRED_TEXT_NEW;
    }

    @Nullable
    public TriggerContextInfo getTestTriggerContentInfo() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        super.itemComplete();
        Activity activity = getActivity();
        if (activity instanceof EditMacroActivity) {
            long j4 = this.parentGUID;
            if (j4 != 0) {
                SelectableItem findChildByGUID = this.m_macro.findChildByGUID(j4);
                if (findChildByGUID instanceof WaitUntilTriggerAction) {
                    ((WaitUntilTriggerAction) findChildByGUID).refreshTrigger(this);
                    return;
                }
                return;
            }
            activity.setResult(-1, new Intent());
            EditMacroActivity editMacroActivity = (EditMacroActivity) activity;
            editMacroActivity.setHasEdited();
            editMacroActivity.refresh(false);
        } else if (this.m_returnOnComplete) {
            Intent intent = new Intent();
            intent.putExtra("Macro", this.m_macro);
            activity.setResult(1, intent);
            activity.finish();
        } else if (activity instanceof AddTriggerActivity) {
            long j5 = this.parentGUID;
            if (j5 != 0) {
                SelectableItem findChildByGUID2 = this.m_macro.findChildByGUID(j5);
                if (findChildByGUID2 instanceof WaitUntilTriggerAction) {
                    ((WaitUntilTriggerAction) findChildByGUID2).addTrigger(this);
                }
            } else {
                this.m_macro.addTrigger(this);
            }
            activity.setResult(-1);
            activity.finish();
        } else if (activity instanceof WizardActivity) {
            if (!this.m_macro.getTriggerList().contains(this)) {
                View findViewById = activity.findViewById(R.id.coordinator_layout);
                SnackbarAnimate make = SnackbarAnimate.make(findViewById, SelectableItem.r(R.string.trigger_added) + ": " + getConfiguredName(), -1);
                make.getView().setBackgroundResource(R.color.trigger_primary_dark);
                ((TextView) make.getView().findViewById(R.id.snackbar_text)).setTextColor(-1);
                TextView textView = (TextView) make.getView().findViewById(R.id.snackbar_text);
                textView.setCompoundDrawablesWithIntrinsicBounds(getIcon(), 0, 0, 0);
                textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small));
                make.show();
                this.m_macro.addTrigger(this);
                EventBusUtils.getEventBus().post(new MacroUpdateEvent(0, 0, this.m_macro.getTriggerList().size() - 1, -1));
                return;
            }
            EventBusUtils.getEventBus().post(new MacroUpdateEvent(3, 0, -1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int m() {
        return R.style.Theme_App_Dialog_Trigger;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        itemComplete();
    }

    public void setParentGUID(long j4) {
        this.parentGUID = j4;
    }

    public void testTrigger() {
        SystemLog.logInfo("Testing trigger: " + getSystemLogEntryName(new TriggerContextInfo(this)), getMacroGuid().longValue());
        J();
    }

    public void testTriggerWithConstraints() {
        SystemLog.logInfo("Testing trigger with constraints: " + getSystemLogEntryName(new TriggerContextInfo(this)), getMacroGuid().longValue());
        if (constraintsMet()) {
            J();
        } else {
            ToastCompat.makeText(getContext(), (int) R.string.constraint_check_false_not_running, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Trigger(Parcel parcel) {
        super(parcel);
    }

    public void onEditScreenClosed() {
    }
}
