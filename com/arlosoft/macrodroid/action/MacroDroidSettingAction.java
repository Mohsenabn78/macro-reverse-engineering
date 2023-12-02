package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.MacroDroidSettingActionInfo;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.constraint.FaceUpDownConstraint;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.PreferencesFragment;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.FlipDeviceTrigger;
import com.arlosoft.macrodroid.triggers.ProximityTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class MacroDroidSettingAction extends Action {
    public static final Parcelable.Creator<MacroDroidSettingAction> CREATOR = new a();
    private static final int OPTION_ACTIVITY_RECOGNITION_UPDATE_RATE = 11;
    private static final int OPTION_DEVICE_FACING_CONSTRAINT_SCREEN_OFF = 15;
    private static final int OPTION_FLIP_DEVICE_SCREEN_OFF = 5;
    private static final int OPTION_FLIP_DEVICE_VIBRATE = 6;
    private static final int OPTION_FORCE_HIDE_NOTIFICATION_ICON = 12;
    private static final int OPTION_LIGHT_SENSOR_BG_SCAN = 14;
    private static final int OPTION_NOTIFICATION_BAR_ICON = 8;
    private static final int OPTION_NOTIFICATION_BLACK_BUTTON_BAR = 17;
    private static final int OPTION_NOTIFICATION_CELL_TOWER_UPDATE_RATE = 9;
    private static final int OPTION_NOTIFICATION_PRIORITY = 13;
    private static final int OPTION_NOTIFICATION_SHOW_BUTTON_BAR = 16;
    private static final int OPTION_PLAY_SOUND_AUDIO_STREAM = 3;
    private static final int OPTION_PROXIMITY_SENSOR_SCREEN_OFF = 7;
    private static final int OPTION_READ_SCREEN_CONTENTS_UPDATE_RATE = 19;
    private static final int OPTION_SHAKE_TRIGGER_WORK_WITH_SCREEN_OFF = 18;
    private static final int OPTION_SHOW_BUTTON_BAR = 0;
    private static final int OPTION_SHOW_LANGUAGE_TO_SPEAK = 1;
    private static final int OPTION_SHOW_SPOKEN_TEXT_AUDIO_STREAM = 2;
    private static final int OPTION_WIDGET_BUTTON_VIBRATE = 4;
    private static final int OPTION_WIFI_BACKGROUND_SCAN_RATE = 10;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    transient PremiumStatusHandler f2309c;
    private int m_activityRecognitionUpdateRate;
    private int m_audioStreamSecondaryOption;
    private boolean m_booleanSecondayOption;
    private int m_cellTowerUpdateRate;
    private String m_languageSecondaryOption;
    private int m_lightSensorBgOption;
    private int m_notificationPriorityOption;
    private int m_option;
    private int m_wifiScanRate;
    private String readScreenUpdateRate;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<MacroDroidSettingAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MacroDroidSettingAction createFromParcel(Parcel parcel) {
            return new MacroDroidSettingAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MacroDroidSettingAction[] newArray(int i4) {
            return new MacroDroidSettingAction[i4];
        }
    }

    /* synthetic */ MacroDroidSettingAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void A0(String str) {
        String[] stringArray = getContext().getResources().getStringArray(R.array.cell_tower_trigger_update_rates);
        String[] stringArray2 = getContext().getResources().getStringArray(R.array.cell_tower_trigger_update_rate_names);
        int length = stringArray2.length;
        final int[] iArr = new int[length];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int intValue = Integer.valueOf(stringArray[i5]).intValue();
            iArr[i5] = intValue;
            if (this.m_cellTowerUpdateRate == intValue) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str);
        builder.setSingleChoiceItems(stringArray2, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.oa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.k0(iArr, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.l0(dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void B0(String str) {
        Locale[] localeArr = Settings.SUPPORTED_LOCALES;
        final String[] strArr = new String[localeArr.length];
        int i4 = 0;
        for (int i5 = 0; i5 < localeArr.length; i5++) {
            String displayName = localeArr[i5].getDisplayName();
            strArr[i5] = displayName;
            if (this.m_languageSecondaryOption == null) {
                this.m_languageSecondaryOption = displayName;
            }
            if (this.m_languageSecondaryOption.equals(displayName)) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str);
        builder.setSingleChoiceItems(strArr, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.m0(strArr, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ya
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.n0(dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void C0(String str) {
        String[] stringArray = getContext().getResources().getStringArray(R.array.wifi_background_scan_rates);
        String[] stringArray2 = getContext().getResources().getStringArray(R.array.wifi_background_scan_rate_names);
        int length = stringArray2.length;
        final int[] iArr = new int[length];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int intValue = Integer.valueOf(stringArray[i5]).intValue();
            iArr[i5] = intValue;
            if (this.m_lightSensorBgOption == intValue) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str);
        builder.setSingleChoiceItems(stringArray2, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ma
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.o0(iArr, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.na
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.p0(dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void D0(String str) {
        final String[] stringArray = getContext().getResources().getStringArray(R.array.notification_priority_values);
        String[] stringArray2 = getContext().getResources().getStringArray(R.array.notification_priority_names);
        int[] iArr = new int[stringArray2.length];
        int i4 = 0;
        for (int i5 = 0; i5 < stringArray.length; i5++) {
            int intValue = Integer.valueOf(stringArray[i5]).intValue();
            iArr[i5] = intValue;
            if (this.m_notificationPriorityOption == intValue) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str);
        builder.setSingleChoiceItems(stringArray2, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.za
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.q0(stringArray, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ab
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.r0(dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void E0() {
        final String[] stringArray = getContext().getResources().getStringArray(R.array.read_screen_content_update_rate_seconds);
        if (!this.f2309c.getPremiumStatus().isPro()) {
            for (int i4 = 0; i4 < stringArray.length; i4++) {
                if (Double.parseDouble(stringArray[i4]) < 2.0d) {
                    stringArray[i4] = stringArray[i4] + " (" + SelectableItem.r(R.string.pro_version_only_short) + ")";
                }
            }
        }
        if (this.readScreenUpdateRate == null) {
            int readScreenContentsUpdateRateMs = Settings.getReadScreenContentsUpdateRateMs(getContext());
            if (readScreenContentsUpdateRateMs > 1000) {
                this.readScreenUpdateRate = String.valueOf(readScreenContentsUpdateRateMs / 1000);
            } else {
                this.readScreenUpdateRate = String.valueOf(readScreenContentsUpdateRateMs / 1000.0d);
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < stringArray.length; i6++) {
            if (this.readScreenUpdateRate.equals(stringArray[i6]) || this.readScreenUpdateRate.equals(stringArray[i6])) {
                i5 = i6;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.read_screen_update_rate_seconds);
        builder.setSingleChoiceItems(stringArray, i5, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.la
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                MacroDroidSettingAction.this.s0(stringArray, dialogInterface, i7);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ua
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                MacroDroidSettingAction.this.t0(dialogInterface, i7);
            }
        });
        builder.create().show();
    }

    private void F0(String str) {
        String[] stringArray = getContext().getResources().getStringArray(R.array.wifi_background_scan_rates);
        String[] stringArray2 = getContext().getResources().getStringArray(R.array.wifi_background_scan_rate_names);
        int length = stringArray2.length;
        final int[] iArr = new int[length];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int intValue = Integer.valueOf(stringArray[i5]).intValue();
            iArr[i5] = intValue;
            if (this.m_wifiScanRate == intValue) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str);
        builder.setSingleChoiceItems(stringArray2, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.sa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.u0(iArr, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ta
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.v0(dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(int[] iArr, DialogInterface dialogInterface, int i4) {
        this.m_activityRecognitionUpdateRate = iArr[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(int[] iArr, DialogInterface dialogInterface, int i4) {
        this.m_audioStreamSecondaryOption = iArr[i4];
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_show_button_bar), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_language_to_speak), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_spoken_text_audio_stream), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_play_sound_audio_stream), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_widget_button_vibrate), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_flip_device_screen_off), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_flip_device_vibrate), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_proximity_sensore_screen_off), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_notification_bar_icon), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_cell_tower_update_rate), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_wifi_background_scan), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_activity_recognition_update_rate), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_force_hide_icon), MacroDroidApplication.getInstance().getString(R.string.action_macrodroid_settings_notification_priority), SelectableItem.r(R.string.light_sensor_bg_update_rate), SelectableItem.r(R.string.constraint_face_up_down) + " - " + SelectableItem.r(R.string.work_with_screen_off), SelectableItem.r(R.string.configure_button_bar) + " - " + SelectableItem.r(R.string.show_button_bar), SelectableItem.r(R.string.configure_button_bar) + " - " + SelectableItem.r(R.string.black_backgroud), SelectableItem.r(R.string.shake_trigger) + " - " + SelectableItem.r(R.string.work_with_screen_off), SelectableItem.r(R.string.read_screen_update_rate)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(DialogInterface dialogInterface, int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_booleanSecondayOption = z3;
    }

    private void init() {
        MacroDroidApplication.appComponentInstance.inject(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(int[] iArr, DialogInterface dialogInterface, int i4) {
        this.m_cellTowerUpdateRate = iArr[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(String[] strArr, DialogInterface dialogInterface, int i4) {
        this.m_languageSecondaryOption = strArr[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(int[] iArr, DialogInterface dialogInterface, int i4) {
        this.m_lightSensorBgOption = iArr[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(String[] strArr, DialogInterface dialogInterface, int i4) {
        this.m_notificationPriorityOption = Integer.valueOf(strArr[i4]).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(String[] strArr, DialogInterface dialogInterface, int i4) {
        if (!this.f2309c.getPremiumStatus().isPro()) {
            this.readScreenUpdateRate = ExifInterface.GPS_MEASUREMENT_2D;
        } else {
            this.readScreenUpdateRate = strArr[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(int[] iArr, DialogInterface dialogInterface, int i4) {
        this.m_wifiScanRate = iArr[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    private synchronized void w0(Class cls) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (cls.isInstance(it.next())) {
                        arrayList.add(macro);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.setEnabled(false);
            macro2.setEnabled(true);
        }
    }

    private void x0(String str) {
        String[] stringArray = getContext().getResources().getStringArray(R.array.activity_recognition_trigger_update_rates);
        String[] stringArray2 = getContext().getResources().getStringArray(R.array.activity_recognition_trigger_update_rate_names);
        int length = stringArray2.length;
        final int[] iArr = new int[length];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int intValue = Integer.valueOf(stringArray[i5]).intValue();
            iArr[i5] = intValue;
            if (this.m_activityRecognitionUpdateRate == intValue) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str);
        builder.setSingleChoiceItems(stringArray2, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.e0(iArr, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ra
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.f0(dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void y0(String str) {
        String[] stringArray = getContext().getResources().getStringArray(R.array.audio_streams);
        String[] stringArray2 = getContext().getResources().getStringArray(R.array.audio_streams_values);
        int length = stringArray2.length;
        final int[] iArr = new int[length];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int intValue = Integer.valueOf(stringArray2[i5]).intValue();
            iArr[i5] = intValue;
            if (this.m_audioStreamSecondaryOption == intValue) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str);
        builder.setSingleChoiceItems(stringArray, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.va
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.g0(iArr, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.wa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidSettingAction.this.h0(dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void z0(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str);
        builder.setSingleChoiceItems(new String[]{getContext().getString(R.string.enable), getContext().getString(R.string.disable)}, !this.m_booleanSecondayOption ? 1 : 0, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroDroidSettingAction.this.i0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.cb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroDroidSettingAction.this.j0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MacroDroidSettingActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        switch (this.m_option) {
            case 0:
                Settings.setShowNotificationButtonBar(getContext(), this.m_booleanSecondayOption);
                MacroDroidService.startService(getContext());
                return;
            case 1:
                if (this.m_languageSecondaryOption != null) {
                    Settings.setSpokenLocale(getContext(), this.m_languageSecondaryOption);
                    return;
                }
                return;
            case 2:
                Settings.setSpokenTextAudioStream(getContext(), this.m_audioStreamSecondaryOption);
                return;
            case 3:
                Settings.setPlaySoundAudioStream(getContext(), this.m_audioStreamSecondaryOption);
                return;
            case 4:
                Settings.setWidgetButtonVibrateOnPress(getContext(), this.m_booleanSecondayOption);
                return;
            case 5:
                Settings.setFlipDeviceScreenOffSetting(getContext(), this.m_booleanSecondayOption);
                w0(FlipDeviceTrigger.class);
                return;
            case 6:
                Settings.setFlipDeviceVibrateSetting(getContext(), this.m_booleanSecondayOption);
                return;
            case 7:
                Settings.setProximitySensorScreenOffSetting(getContext(), this.m_booleanSecondayOption);
                w0(ProximityTrigger.class);
                return;
            case 8:
                Settings.setForegroundServiceEnabled(getContext(), this.m_booleanSecondayOption);
                MacroDroidService.startService(getContext());
                return;
            case 9:
                Settings.setCellTowerUpdateRate(getContext(), this.m_cellTowerUpdateRate);
                getContext().sendBroadcast(new Intent(Util.CELL_TOWER_UPDATE_RATE_INTENT));
                return;
            case 10:
                Settings.setWifiBackgroundScanRate(getContext(), this.m_wifiScanRate);
                getContext().sendBroadcast(new Intent(Util.WIFI_BACKGROUND_SCAN_RATE_INTENT));
                return;
            case 11:
                Settings.setActivityRecogntionUpdateRate(getContext(), this.m_activityRecognitionUpdateRate);
                getContext().sendBroadcast(new Intent(Util.ACTIVITY_RECOGNITION_UPDATE_RATE_INTENT));
                return;
            case 12:
                Settings.setForceHideIcon(getContext(), this.m_booleanSecondayOption);
                MacroDroidService.startService(getContext());
                return;
            case 13:
                Settings.setNotificationPriority(getContext(), this.m_notificationPriorityOption);
                MacroDroidService.startService(getContext());
                return;
            case 14:
                Settings.setLightSensorBGScanRate(getContext(), this.m_lightSensorBgOption);
                getContext().sendBroadcast(new Intent(Util.LIGHT_SENSOR_BACKGROUND_SCAN_RATE_INTENT));
                return;
            case 15:
                SelectableItem.setSettingBoolean(getContext(), FaceUpDownConstraint.SETTING_KEY_SCREEN_OFF, this.m_booleanSecondayOption);
                FaceUpDownConstraint.updateConstraintState();
                return;
            case 16:
                Settings.setShowNotificationButtonBar(getContext(), this.m_booleanSecondayOption);
                MacroDroidService.updateNotification(getContext(), true, true);
                return;
            case 17:
                Settings.setButtonBarBlackBg(getContext(), this.m_booleanSecondayOption);
                MacroDroidService.updateNotification(getContext(), true, true);
                return;
            case 18:
                Settings.setShakeScreenOffSetting(getContext(), this.m_booleanSecondayOption);
                PreferencesFragment.resetAllShakeTriggerMacros();
                return;
            case 19:
                try {
                    Settings.setReadScreenContentsUpdateRateMs(getContext(), String.valueOf(Double.parseDouble(this.readScreenUpdateRate)));
                    return;
                } catch (Exception unused) {
                    SystemLog.logWarning("Read screen update rate < 2 seconds requires pro version (Setting to 2 seconds)", getMacroGuid().longValue());
                    Settings.setReadScreenContentsUpdateRateMs(getContext(), ExifInterface.GPS_MEASUREMENT_2D);
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (!checkActivityAlive()) {
            return;
        }
        String[] options = getOptions();
        int i4 = this.m_option;
        switch (i4) {
            case 0:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 12:
            case 15:
            case 16:
            case 17:
            case 18:
                z0(options[i4]);
                return;
            case 1:
                B0(options[i4]);
                return;
            case 2:
            case 3:
                y0(options[i4]);
                return;
            case 9:
                A0(options[i4]);
                return;
            case 10:
                F0(options[i4]);
                return;
            case 11:
                x0(options[i4]);
                return;
            case 13:
                D0(options[i4]);
                return;
            case 14:
                C0(options[i4]);
                return;
            case 19:
                E0();
                return;
            default:
                return;
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(!this.m_booleanSecondayOption ? 1 : 0);
        parcel.writeInt(this.m_audioStreamSecondaryOption);
        parcel.writeString(this.m_languageSecondaryOption);
        parcel.writeInt(this.m_cellTowerUpdateRate);
        parcel.writeInt(this.m_wifiScanRate);
        parcel.writeInt(this.m_activityRecognitionUpdateRate);
        parcel.writeInt(this.m_notificationPriorityOption);
        parcel.writeInt(this.m_lightSensorBgOption);
        parcel.writeString(this.readScreenUpdateRate);
    }

    public MacroDroidSettingAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private MacroDroidSettingAction() {
        init();
        this.m_option = 0;
        this.m_booleanSecondayOption = true;
    }

    private MacroDroidSettingAction(Parcel parcel) {
        super(parcel);
        init();
        this.m_option = parcel.readInt();
        this.m_booleanSecondayOption = parcel.readInt() == 0;
        this.m_audioStreamSecondaryOption = parcel.readInt();
        this.m_languageSecondaryOption = parcel.readString();
        this.m_cellTowerUpdateRate = parcel.readInt();
        this.m_wifiScanRate = parcel.readInt();
        this.m_activityRecognitionUpdateRate = parcel.readInt();
        this.m_notificationPriorityOption = parcel.readInt();
        this.m_lightSensorBgOption = parcel.readInt();
        this.readScreenUpdateRate = parcel.readString();
    }
}
