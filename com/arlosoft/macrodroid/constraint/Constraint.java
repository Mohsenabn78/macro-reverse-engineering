package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.ActiveApplicationConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.AirplaneModeConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.ApplicationInstalledConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.AutoRotateConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.AutoSyncConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.BatteryLevelConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.BatterySaverStateConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.BluetoothConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.BrightnessConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.CalendarConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.CategoryEnabledConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.CellTowerConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.ClipboardConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.CompareValueConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.DarkThemeConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.DataOnOffConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.DayOfMonthConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.DayOfWeekConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.DeviceLockedConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.DeviceOrientationConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.DrawerStateConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.ExternalPowerConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.FaceUpDownConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.FloatingTextConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.FoldAngleConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.GPSEnabledConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.GeofenceConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.HeadphonesConnectionConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.InCallConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.InvocationMethodConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.IpAddressConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.IsAdbHackedConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.IsRoamingConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.IsRootedConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.LastRunTimeConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.LightLevelConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.LocationModeConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.LogicConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.MacroDroidVariableConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.MacroEnabledConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.MacroRunningConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.ModeConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.MonthOfYearConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.MusicActiveConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.NFCStateConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.NotificationPresentConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.NotificationVolumeConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.PebbleConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.PhoneRingingConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.PriorityModeConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.ProximitySensorConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.RoamingOnOffConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.ScreenOnOffConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.SignalOnOffConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.SpeakerPhoneConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.StopWatchConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.SunsetSunriseConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.SystemSettingConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.TimeOfDayConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.TimeSinceBootConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.TorchConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.TriggerThatInvokedConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.VolumeConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.VolumeLevelConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.VpnConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.WifiConstraintInfo;
import com.arlosoft.macrodroid.constraint.info.WifiHotSpotConstraintInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroUpdateEvent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.AddActionActivity;
import com.arlosoft.macrodroid.selectableitemlist.AddConditionActivity;
import com.arlosoft.macrodroid.selectableitemlist.AddConstraintActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import com.google.android.material.snackbar.SnackbarAnimate;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Constraint extends SelectableItem {
    protected static final int PARENT_ACTION = 1;
    protected static final int PARENT_MACRO = 0;
    protected static final int PARENT_TRIGGER = 2;
    public static final Object enabledStateLock = new Object();

    /* renamed from: b  reason: collision with root package name */
    transient boolean f10186b;
    private transient long m_parentGUID;

    public Constraint() {
        E(null);
    }

    private static void I(List<SelectableItemInfo> list, SelectableItemInfo selectableItemInfo) {
        if (selectableItemInfo.allowedOnDevice()) {
            list.add(selectableItemInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int M(Collator collator, Context context, SelectableItemInfo selectableItemInfo, SelectableItemInfo selectableItemInfo2) {
        return collator.compare(context.getString(selectableItemInfo.getName()), context.getString(selectableItemInfo2.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int N(Collator collator, SelectableItemCategory selectableItemCategory, SelectableItemCategory selectableItemCategory2) {
        return collator.compare(selectableItemCategory.getCategoryName(), selectableItemCategory2.getCategoryName());
    }

    public static List<SelectableItemInfo> getAllConstraintsInfo(final Context context, Macro macro, boolean z3) {
        ArrayList<SelectableItemInfo> arrayList = new ArrayList();
        I(arrayList, BatteryLevelConstraintInfo.getInstance());
        I(arrayList, WifiConstraintInfo.getInstance());
        I(arrayList, ScreenOnOffConstraintInfo.getInstance());
        I(arrayList, ExternalPowerConstraintInfo.getInstance());
        try {
            if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0) {
                I(arrayList, InCallConstraintInfo.getInstance());
            }
        } catch (Exception unused) {
        }
        I(arrayList, ModeConstraintInfo.getInstance());
        I(arrayList, DayOfWeekConstraintInfo.getInstance());
        I(arrayList, TimeOfDayConstraintInfo.getInstance());
        I(arrayList, HeadphonesConnectionConstraintInfo.getInstance());
        I(arrayList, ActiveApplicationConstraintInfo.getInstance());
        I(arrayList, ApplicationInstalledConstraintInfo.getInstance());
        I(arrayList, VolumeConstraintInfo.getInstance());
        I(arrayList, AirplaneModeConstraintInfo.getInstance());
        I(arrayList, PhoneRingingConstraintInfo.getInstance());
        I(arrayList, MusicActiveConstraintInfo.getInstance());
        I(arrayList, GPSEnabledConstraintInfo.getInstance());
        I(arrayList, LastRunTimeConstraintInfo.getInstance());
        I(arrayList, MacroRunningConstraintInfo.getInstance());
        I(arrayList, TimeSinceBootConstraintInfo.getInstance());
        I(arrayList, MacroDroidVariableConstraintInfo.getInstance());
        I(arrayList, FloatingTextConstraintInfo.getInstance());
        I(arrayList, CompareValueConstraintInfo.getInstance());
        I(arrayList, DrawerStateConstraintInfo.getInstance());
        I(arrayList, WifiHotSpotConstraintInfo.getInstance());
        I(arrayList, ProximitySensorConstraintInfo.getInstance());
        I(arrayList, DeviceLockedConstraintInfo.getInstance());
        I(arrayList, DataOnOffConstraintInfo.getInstance());
        I(arrayList, RoamingOnOffConstraintInfo.getInstance());
        I(arrayList, IsRoamingConstraintInfo.getInstance());
        I(arrayList, DeviceOrientationConstraintInfo.getInstance());
        I(arrayList, CalendarConstraintInfo.getInstance());
        I(arrayList, SignalOnOffConstraintInfo.getInstance());
        I(arrayList, CellTowerConstraintInfo.getInstance());
        I(arrayList, GeofenceConstraintInfo.getInstance());
        I(arrayList, AutoSyncConstraintInfo.getInstance());
        I(arrayList, NotificationVolumeConstraintInfo.getInstance());
        I(arrayList, AutoRotateConstraintInfo.getInstance());
        I(arrayList, LightLevelConstraintInfo.getInstance());
        I(arrayList, FaceUpDownConstraintInfo.getInstance());
        if (context.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle")) {
            I(arrayList, FoldAngleConstraintInfo.getInstance());
        }
        I(arrayList, LocationModeConstraintInfo.getInstance());
        I(arrayList, BrightnessConstraintInfo.getInstance());
        I(arrayList, MacroEnabledConstraintInfo.getInstance());
        I(arrayList, CategoryEnabledConstraintInfo.getInstance());
        I(arrayList, DayOfMonthConstraintInfo.getInstance());
        I(arrayList, MonthOfYearConstraintInfo.getInstance());
        if (!(macro instanceof ActionBlock)) {
            I(arrayList, TriggerThatInvokedConstraintInfo.getInstance());
            I(arrayList, InvocationMethodConstraintInfo.getInstance());
        }
        I(arrayList, VolumeLevelConstraintInfo.getInstance());
        I(arrayList, StopWatchConstraintInfo.getInstance());
        I(arrayList, SpeakerPhoneConstraintInfo.getInstance());
        I(arrayList, IsRootedConstraintInfo.getInstance());
        I(arrayList, IsAdbHackedConstraintInfo.getInstance());
        I(arrayList, NFCStateConstraintInfo.getInstance());
        I(arrayList, ClipboardConstraintInfo.getInstance());
        I(arrayList, BatteryTemperatureConstraintInfo.getInstance());
        if (!z3) {
            I(arrayList, LogicConstraintInfo.getInstance());
        }
        I(arrayList, NotificationPresentConstraintInfo.getInstance());
        I(arrayList, PriorityModeConstraintInfo.getInstance());
        I(arrayList, BatterySaverStateConstraintInfo.getInstance());
        I(arrayList, BluetoothConstraintInfo.getInstance());
        I(arrayList, PebbleConstraintInfo.getInstance());
        I(arrayList, IpAddressConstraintInfo.getInstance());
        I(arrayList, SunsetSunriseConstraintInfo.getInstance());
        I(arrayList, VpnConstraintInfo.getInstance());
        I(arrayList, DarkThemeConstraintInfo.getInstance());
        I(arrayList, TorchConstraintInfo.getInstance());
        I(arrayList, SystemSettingConstraintInfo.getInstance());
        final Collator collator = Collator.getInstance(Settings.getLocale(context));
        collator.setStrength(0);
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.constraint.s0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int M;
                M = Constraint.M(collator, context, (SelectableItemInfo) obj, (SelectableItemInfo) obj2);
                return M;
            }
        });
        for (SelectableItemInfo selectableItemInfo : arrayList) {
            context.getString(selectableItemInfo.getName());
            selectableItemInfo.getRootLevel();
        }
        return arrayList;
    }

    public static List<SelectableItemCategory> getCategories(Context context, Macro macro, boolean z3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        I(arrayList2, BluetoothConstraintInfo.getInstance());
        I(arrayList2, GPSEnabledConstraintInfo.getInstance());
        I(arrayList2, LocationModeConstraintInfo.getInstance());
        I(arrayList2, SignalOnOffConstraintInfo.getInstance());
        I(arrayList2, DataOnOffConstraintInfo.getInstance());
        I(arrayList2, IsRoamingConstraintInfo.getInstance());
        I(arrayList2, WifiHotSpotConstraintInfo.getInstance());
        I(arrayList2, WifiConstraintInfo.getInstance());
        I(arrayList2, PebbleConstraintInfo.getInstance());
        I(arrayList2, IpAddressConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_connectivity), R.drawable.ic_router_wireless_white_24dp, arrayList2));
        ArrayList arrayList3 = new ArrayList();
        I(arrayList3, InCallConstraintInfo.getInstance());
        I(arrayList3, PhoneRingingConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_phone), R.drawable.ic_phone_classic_white_24dp, arrayList3));
        ArrayList arrayList4 = new ArrayList();
        I(arrayList4, VolumeConstraintInfo.getInstance());
        I(arrayList4, BrightnessConstraintInfo.getInstance());
        I(arrayList4, SpeakerPhoneConstraintInfo.getInstance());
        I(arrayList4, ScreenOnOffConstraintInfo.getInstance());
        I(arrayList4, VolumeLevelConstraintInfo.getInstance());
        I(arrayList4, DarkThemeConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_screen_and_speaker), R.drawable.ic_account_white_24dp, arrayList4));
        ArrayList arrayList5 = new ArrayList();
        I(arrayList5, NotificationPresentConstraintInfo.getInstance());
        I(arrayList5, NotificationVolumeConstraintInfo.getInstance());
        I(arrayList5, PriorityModeConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_notification), R.drawable.ic_alert_box_white_24dp, arrayList5));
        ArrayList arrayList6 = new ArrayList();
        I(arrayList6, CalendarConstraintInfo.getInstance());
        I(arrayList6, DayOfMonthConstraintInfo.getInstance());
        I(arrayList6, DayOfWeekConstraintInfo.getInstance());
        I(arrayList6, MonthOfYearConstraintInfo.getInstance());
        I(arrayList6, StopWatchConstraintInfo.getInstance());
        I(arrayList6, TimeOfDayConstraintInfo.getInstance());
        I(arrayList6, SunsetSunriseConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_date_time), R.drawable.ic_calendar_clock_white_24dp, arrayList6));
        ArrayList arrayList7 = new ArrayList();
        I(arrayList7, CellTowerConstraintInfo.getInstance());
        I(arrayList7, GeofenceConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_location), R.drawable.ic_google_maps_white_24dp, arrayList7));
        ArrayList arrayList8 = new ArrayList();
        I(arrayList8, RoamingOnOffConstraintInfo.getInstance());
        I(arrayList8, AutoSyncConstraintInfo.getInstance());
        I(arrayList8, DeviceLockedConstraintInfo.getInstance());
        I(arrayList8, AutoRotateConstraintInfo.getInstance());
        I(arrayList8, IsRootedConstraintInfo.getInstance());
        I(arrayList8, IsAdbHackedConstraintInfo.getInstance());
        I(arrayList8, TimeSinceBootConstraintInfo.getInstance());
        I(arrayList8, AirplaneModeConstraintInfo.getInstance());
        I(arrayList8, ActiveApplicationConstraintInfo.getInstance());
        I(arrayList8, ApplicationInstalledConstraintInfo.getInstance());
        I(arrayList8, NFCStateConstraintInfo.getInstance());
        I(arrayList8, ClipboardConstraintInfo.getInstance());
        I(arrayList8, VpnConstraintInfo.getInstance());
        I(arrayList8, TorchConstraintInfo.getInstance());
        I(arrayList8, SystemSettingConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_device_state), R.drawable.ic_cellphone_settings_white_24dp, arrayList8));
        ArrayList arrayList9 = new ArrayList();
        if (!z3) {
            I(arrayList9, LogicConstraintInfo.getInstance());
        }
        I(arrayList9, LastRunTimeConstraintInfo.getInstance());
        I(arrayList9, MacroRunningConstraintInfo.getInstance());
        I(arrayList9, MacroEnabledConstraintInfo.getInstance());
        I(arrayList9, CategoryEnabledConstraintInfo.getInstance());
        I(arrayList9, ModeConstraintInfo.getInstance());
        I(arrayList9, MacroDroidVariableConstraintInfo.getInstance());
        I(arrayList9, FloatingTextConstraintInfo.getInstance());
        I(arrayList9, CompareValueConstraintInfo.getInstance());
        if (!(macro instanceof ActionBlock)) {
            I(arrayList9, TriggerThatInvokedConstraintInfo.getInstance());
            I(arrayList9, InvocationMethodConstraintInfo.getInstance());
        }
        I(arrayList9, DrawerStateConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_macrodroid_specific), R.drawable.active_icon_new, arrayList9));
        ArrayList arrayList10 = new ArrayList();
        I(arrayList10, HeadphonesConnectionConstraintInfo.getInstance());
        I(arrayList10, MusicActiveConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_media), R.drawable.ic_account_white_24dp, arrayList10));
        ArrayList arrayList11 = new ArrayList();
        I(arrayList11, ProximitySensorConstraintInfo.getInstance());
        I(arrayList11, LightLevelConstraintInfo.getInstance());
        I(arrayList11, DeviceOrientationConstraintInfo.getInstance());
        I(arrayList11, FaceUpDownConstraintInfo.getInstance());
        if (context.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle")) {
            I(arrayList11, FoldAngleConstraintInfo.getInstance());
        }
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_sensors), R.drawable.ic_compass_outline_white_24dp, arrayList11));
        ArrayList arrayList12 = new ArrayList();
        I(arrayList12, BatteryLevelConstraintInfo.getInstance());
        I(arrayList12, BatterySaverStateConstraintInfo.getInstance());
        I(arrayList12, ExternalPowerConstraintInfo.getInstance());
        I(arrayList12, BatteryTemperatureConstraintInfo.getInstance());
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_battery_power), R.drawable.ic_power_plug_white_24dp, arrayList12));
        final Collator collator = Collator.getInstance(Settings.getLocale(context));
        collator.setStrength(0);
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.constraint.t0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int N;
                N = Constraint.N(collator, (SelectableItemCategory) obj, (SelectableItemCategory) obj2);
                return N;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int J() {
        Activity activity = getActivity();
        if (activity instanceof AddConditionActivity) {
            return ContextCompat.getColor(activity, R.color.condition_accent);
        }
        return ContextCompat.getColor(activity, R.color.constraints_accent);
    }

    @Nullable
    protected SelectableItem K() {
        SelectableItem findChildByGUID;
        boolean z3;
        long j4 = this.m_parentGUID;
        if (j4 == 0) {
            return null;
        }
        do {
            findChildByGUID = this.m_macro.findChildByGUID(j4);
            z3 = findChildByGUID instanceof Constraint;
            if (z3) {
                j4 = ((Constraint) findChildByGUID).getParentGUID();
                continue;
            }
        } while (z3);
        return findChildByGUID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int L() {
        SelectableItem findChildByGUID;
        boolean z3;
        long j4 = this.m_parentGUID;
        if (j4 == 0) {
            return 0;
        }
        do {
            findChildByGUID = this.m_macro.findChildByGUID(j4);
            z3 = findChildByGUID instanceof Constraint;
            if (z3) {
                j4 = ((Constraint) findChildByGUID).getParentGUID();
                continue;
            }
        } while (z3);
        if (findChildByGUID instanceof Trigger) {
            return 2;
        }
        return 1;
    }

    public abstract boolean checkOK(TriggerContextInfo triggerContextInfo);

    public boolean constraintMet(TriggerContextInfo triggerContextInfo) {
        return checkOK(triggerContextInfo);
    }

    public Constraint createExactClone() {
        Parcel obtain = Parcel.obtain();
        obtain.writeParcelable(this, 0);
        obtain.setDataPosition(0);
        Constraint constraint = (Constraint) obtain.readParcelable(getClass().getClassLoader());
        obtain.recycle();
        return constraint;
    }

    public void disableConstraintCheckingThreadSafe() {
        synchronized (enabledStateLock) {
            if (!this.f10186b) {
                return;
            }
            this.f10186b = false;
            disableConstraintChecking();
        }
    }

    public void enableConstraintCheckingThreadSafe() {
        enableConstraintCheckingThreadSafe(false);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getDialogTheme() {
        Activity activity = getActivity();
        if (activity != null) {
            if (!(activity instanceof AddConditionActivity) && !(activity instanceof AddActionActivity)) {
                if ((activity instanceof EditMacroActivity) && ((EditMacroActivity) activity).isEditingCondition()) {
                    return R.style.Theme_App_Dialog_Condition;
                }
            } else {
                return R.style.Theme_App_Dialog_Condition;
            }
        }
        if ((activity instanceof ActionBlockEditActivity) && ((ActionBlockEditActivity) activity).isEditingCondition()) {
            return R.style.Theme_App_Dialog_Condition;
        }
        return R.style.Theme_App_Dialog_Constraint;
    }

    public int getDialogThemeSmallText() {
        Activity activity = getActivity();
        if (activity != null) {
            if (!(activity instanceof AddConditionActivity) && !(activity instanceof AddActionActivity)) {
                if ((activity instanceof EditMacroActivity) && ((EditMacroActivity) activity).isEditingCondition()) {
                    return R.style.Theme_App_Dialog_Condition_SmallText;
                }
            } else {
                return R.style.Theme_App_Dialog_Condition_SmallText;
            }
        }
        if ((activity instanceof ActionBlockEditActivity) && ((ActionBlockEditActivity) activity).isEditingCondition()) {
            return R.style.Theme_App_Dialog_Condition_SmallText;
        }
        return R.style.Theme_App_Dialog_Constraint_SmallText;
    }

    public long getParentGUID() {
        return this.m_parentGUID;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public IteratorType isChildOfIterateDictionary() {
        SelectableItem K = K();
        if (K instanceof Action) {
            return ((Action) K).isChildOfIterateDictionary();
        }
        return IteratorType.NONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        super.itemComplete();
        Activity activity = getActivity();
        if (activity instanceof ActionBlockEditActivity) {
            activity.setResult(-1, new Intent());
            ActionBlockEditActivity actionBlockEditActivity = (ActionBlockEditActivity) activity;
            actionBlockEditActivity.setHasEdited();
            actionBlockEditActivity.refresh(false);
        } else if (activity instanceof EditMacroActivity) {
            activity.setResult(-1, new Intent());
            EditMacroActivity editMacroActivity = (EditMacroActivity) activity;
            editMacroActivity.setHasEdited();
            editMacroActivity.refresh(false);
        } else if (!(activity instanceof AddConstraintActivity) && !(activity instanceof AddConditionActivity)) {
            if (activity instanceof AddActionActivity) {
                ((AddActionActivity) activity).refresh();
            } else if (activity instanceof WizardActivity) {
                if (!this.m_macro.getConstraints().contains(this)) {
                    View findViewById = activity.findViewById(R.id.coordinator_layout);
                    SnackbarAnimate make = SnackbarAnimate.make(findViewById, SelectableItem.r(R.string.constraint_added) + ": " + getConfiguredName(), -1);
                    make.getView().setBackgroundResource(R.color.constraints_primary_dark);
                    ((TextView) make.getView().findViewById(R.id.snackbar_text)).setTextColor(-1);
                    TextView textView = (TextView) make.getView().findViewById(R.id.snackbar_text);
                    textView.setCompoundDrawablesWithIntrinsicBounds(getIcon(), 0, 0, 0);
                    textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small));
                    make.show();
                    this.m_macro.addConstraint(this);
                    EventBusUtils.getEventBus().post(new MacroUpdateEvent(0, 2, this.m_macro.getConstraints().size() - 1, -1));
                    return;
                }
                EventBusUtils.getEventBus().post(new MacroUpdateEvent(3, 2, -1, -1));
            }
        } else {
            long j4 = this.m_parentGUID;
            if (j4 != 0) {
                SelectableItem findChildByGUID = this.m_macro.findChildByGUID(j4);
                if (findChildByGUID != null) {
                    findChildByGUID.addConstraint(this);
                }
            } else {
                Macro macro = this.m_macro;
                if (macro != null) {
                    macro.addConstraint(this);
                }
            }
            activity.setResult(-1);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int m() {
        return getDialogTheme();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        itemComplete();
    }

    public void setParentGUID(long j4) {
        this.m_parentGUID = j4;
    }

    public void enableConstraintCheckingThreadSafe(boolean z3) {
        synchronized (enabledStateLock) {
            if (this.f10186b) {
                return;
            }
            this.f10186b = true;
            enableConstraintChecking(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Constraint(Parcel parcel) {
        super(parcel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void enableConstraintChecking(boolean z3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void disableConstraintChecking() {
    }
}
