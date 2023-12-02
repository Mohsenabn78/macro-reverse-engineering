package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetAirplaneModeActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionRequestActivity;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.AdbHelperUtil;
import com.arlosoft.macrodroid.utils.RootHelper;
import com.arlosoft.macrodroid.voiceservice.MacroDroidVoiceService;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes2.dex */
public class SetAirplaneModeAction extends Action {
    public static final Parcelable.Creator<SetAirplaneModeAction> CREATOR = new b();
    private static final String MACRODROID_DIGITAL_ASSISTANT = "com.arlosoft.macrodroid/com.arlosoft.macrodroid.voiceservice.MacroDroidVoiceService";
    private static final int MECHANISM_ADB_HACK = 2;
    private static final int MECHANISM_ASSIST = 1;
    private static final int MECHANISM_ROOT = 0;
    private static int s_actionCounter;
    private static c s_airplaneModeTriggerReceiver;
    private boolean configComplete;
    private transient boolean isEditing;
    private boolean m_keepBluetoothOn;
    private boolean m_keepWifiOn;
    private int m_state;
    private int mechanismOption;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Function0<Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            SetAirplaneModeAction.this.itemComplete();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<SetAirplaneModeAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetAirplaneModeAction createFromParcel(Parcel parcel) {
            return new SetAirplaneModeAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetAirplaneModeAction[] newArray(int i4) {
            return new SetAirplaneModeAction[i4];
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!intent.getBooleanExtra(RemoteConfigConstants.ResponseFieldKey.STATE, false)) {
                try {
                    Util.runAsRoot(new String[]{"settings put global airplane_mode_radios cell,wimax,bluetooth,nfc,wifi"}, false);
                } catch (Exception unused) {
                }
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* synthetic */ SetAirplaneModeAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void V() {
        this.mechanismOption = 1;
    }

    private void X() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_airplane_mode_options);
        builder.setMultiChoiceItems(new String[]{SelectableItem.r(R.string.action_set_airplane_mode_keep_wifi_on), SelectableItem.r(R.string.action_set_airplane_mode_keep_bluetooth_on)}, new boolean[]{this.m_keepWifiOn, this.m_keepBluetoothOn}, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.action.hi
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i4, boolean z3) {
                SetAirplaneModeAction.this.e0(dialogInterface, i4, z3);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ii
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetAirplaneModeAction.this.f0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private String[] Y() {
        return new String[]{SelectableItem.r(R.string.root_only), SelectableItem.r(R.string.trigger_airplane_mode_use_macrodroid_as_default_assist_app), SelectableItem.r(R.string.adb_hack)};
    }

    private String[] Z() {
        return new String[]{SelectableItem.r(R.string.action_set_airplane_mode_on), SelectableItem.r(R.string.action_set_airplane_mode_off), SelectableItem.r(R.string.action_set_airplane_mode_toggle)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface, int i4) {
        int i5;
        if (this.mechanismOption == 0 && ((i5 = this.m_state) == 0 || i5 == 2)) {
            X();
            return;
        }
        this.isEditing = false;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(DialogInterface dialogInterface, int i4, boolean z3) {
        if (i4 == 0) {
            this.m_keepWifiOn = z3;
        } else if (i4 == 1) {
            this.m_keepBluetoothOn = z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(boolean z3) {
        boolean z4;
        boolean z5 = false;
        try {
            String string = Settings.Secure.getString(getContext().getContentResolver(), "assistant");
            Settings.Secure.putString(getContext().getContentResolver(), "assistant", MACRODROID_DIGITAL_ASSISTANT);
            Settings.Secure.putString(getContext().getContentResolver(), "voice_interaction_service", MACRODROID_DIGITAL_ASSISTANT);
            Thread.sleep(1000L);
            Intent intent = new Intent(MacroDroidVoiceService.ACTION);
            intent.putExtra("ACTION", "android.settings.VOICE_CONTROL_AIRPLANE_MODE");
            intent.putExtra("airplane_mode_enabled", z3);
            getContext().sendBroadcast(intent);
            Thread.sleep(1000L);
            z5 = Settings.Secure.putString(getContext().getContentResolver(), "assistant", string);
            z4 = Settings.Secure.putString(getContext().getContentResolver(), "voice_interaction_service", string);
        } catch (Exception unused) {
            z4 = z5;
        }
        if (!z4) {
            SystemLog.logError("Could not set airplane mode, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS", getMacroGuid().longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0() {
        try {
            Util.runAsRootInBg(new String[]{"svc wifi enable"});
        } catch (Exception e4) {
            SystemLog.logError("WifiManager refused to set wifi on: " + e4.toString(), getMacroGuid().longValue());
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter != null) {
            try {
                bluetoothAdapter.enable();
            } catch (SecurityException unused) {
                if (Build.VERSION.SDK_INT >= 31) {
                    PermissionsHelper.showNeedsPermission(getContext(), "android.permission.BLUETOOTH_CONNECT", getName(), true, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.mechanismOption = i4;
    }

    protected AlertDialog W() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(Z(), this.m_state, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.di
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetAirplaneModeAction.this.a0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ei
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetAirplaneModeAction.this.b0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fi
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SetAirplaneModeAction.this.c0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.gi
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SetAirplaneModeAction.this.d0(dialogInterface);
            }
        });
        return create;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void doDisable() {
        int i4 = s_actionCounter - 1;
        s_actionCounter = i4;
        if (i4 == 0) {
            MacroDroidApplication.getInstance().unregisterReceiver(s_airplaneModeTriggerReceiver);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doEnable() {
        if (s_actionCounter == 0) {
            s_airplaneModeTriggerReceiver = new c(null);
            MacroDroidApplication.getInstance().registerReceiver(s_airplaneModeTriggerReceiver, new IntentFilter("android.intent.action.AIRPLANE_MODE"));
        }
        s_actionCounter++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public List<String> getAdbHackPermissionRequired() {
        if (this.configComplete && this.mechanismOption == 2) {
            return Collections.singletonList("android.permission.WRITE_SECURE_SETTINGS");
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.mechanismOption;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return Z()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        int i4 = this.mechanismOption;
        if (i4 == 0) {
            if (!RootToolsHelper.isAccessGiven()) {
                return SelectableItem.r(R.string.rooted_device_required);
            }
            return null;
        }
        boolean z3 = true;
        if (i4 == 1) {
            if (!ApplicationChecker.isMacroDroidAssistDefault(getContext())) {
                return SelectableItem.r(R.string.requires_assist_and_voice_input);
            }
            return null;
        } else if (i4 == 2) {
            if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_SECURE_SETTINGS") != 0) {
                z3 = false;
            }
            if (!z3) {
                return SelectableItem.r(R.string.rooted_or_adb_hack_required) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "android.permission.WRITE_SECURE_SETTINGS";
            }
            return null;
        } else {
            return null;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = "";
        if (this.m_state == 1) {
            return "";
        }
        if (this.m_keepWifiOn) {
            StringBuilder sb = new StringBuilder();
            sb.append(SelectableItem.r(R.string.action_set_airplane_mode_keep_wifi_on));
            if (this.m_keepBluetoothOn) {
                str = ", " + SelectableItem.r(R.string.action_set_airplane_mode_keep_bluetooth_on);
            }
            sb.append(str);
            return sb.toString();
        } else if (!this.m_keepBluetoothOn) {
            return "";
        } else {
            return SelectableItem.r(R.string.action_set_airplane_mode_keep_bluetooth_on);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetAirplaneModeActionInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (Build.VERSION.SDK_INT >= 24) {
            super.handleItemSelected();
            return;
        }
        this.mechanismOption = 0;
        W();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void handleOptionsDialogCancelled() {
        this.isEditing = false;
        super.handleOptionsDialogCancelled();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        if (this.mechanismOption == 2) {
            AdbHelperUtil.showAdbHackDetails(getActivity(), getAdbHackPermissionRequired(), new a());
        } else if (Build.VERSION.SDK_INT >= 24) {
            PermissionRequestActivity.showDefaultAppsSettings(getActivity());
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        boolean z3;
        boolean z4;
        final boolean z5;
        boolean z6;
        String str;
        String str2;
        if (Settings.System.getInt(getContext().getContentResolver(), "airplane_mode_on", 0) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        final BluetoothAdapter adapter = ((BluetoothManager) getContext().getSystemService("bluetooth")).getAdapter();
        if (adapter != null && adapter.isEnabled()) {
            z4 = true;
        } else {
            z4 = false;
        }
        int i4 = this.m_state;
        if (i4 != 0) {
            if (i4 == 1 || i4 != 2) {
                z5 = false;
            } else {
                z5 = !z3;
            }
        } else {
            z5 = true;
        }
        int i5 = this.mechanismOption;
        if (i5 == 1) {
            Intent intent = new Intent(MacroDroidVoiceService.ACTION);
            intent.putExtra("ACTION", "android.settings.VOICE_CONTROL_AIRPLANE_MODE");
            intent.putExtra("airplane_mode_enabled", z5);
            getContext().sendBroadcast(intent);
        } else if (i5 == 2) {
            new Thread(new Runnable() { // from class: com.arlosoft.macrodroid.action.ai
                @Override // java.lang.Runnable
                public final void run() {
                    SetAirplaneModeAction.this.g0(z5);
                }
            }).start();
        } else {
            if (((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).getWifiState() == 3) {
                z6 = true;
            } else {
                z6 = false;
            }
            int idForMethodInClass = RootHelper.getIdForMethodInClass("android.net.IConnectivityManager", "setAirplaneMode");
            String[] strArr = new String[1];
            StringBuilder sb = new StringBuilder();
            sb.append("service call connectivity ");
            sb.append(idForMethodInClass);
            sb.append(" i32 ");
            String str3 = "1";
            if (z5) {
                str = "1";
            } else {
                str = "0";
            }
            sb.append(str);
            strArr[0] = sb.toString();
            Util.runAsRootInBg(strArr);
            String[] strArr2 = new String[2];
            StringBuilder sb2 = new StringBuilder();
            sb2.append("settings put global airplane_mode_on ");
            if (!z5) {
                str3 = "0";
            }
            sb2.append(str3);
            strArr2[0] = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("su -c am broadcast -a android.intent.action.AIRPLANE_MODE --ez state ");
            if (z5) {
                str2 = "true";
            } else {
                str2 = "false";
            }
            sb3.append(str2);
            strArr2[1] = sb3.toString();
            Util.runAsRootInBg(strArr2);
            if (this.m_keepWifiOn && z6) {
                new Handler(getContext().getMainLooper()).postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.bi
                    @Override // java.lang.Runnable
                    public final void run() {
                        SetAirplaneModeAction.this.h0();
                    }
                }, 1000L);
            }
            if (this.m_keepBluetoothOn && z4) {
                new Handler(getContext().getMainLooper()).postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.ci
                    @Override // java.lang.Runnable
                    public final void run() {
                        SetAirplaneModeAction.this.i0(adapter);
                    }
                }, 1000L);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        super.itemComplete();
        this.configComplete = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return Y();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        this.isEditing = true;
        super.onItemSelected();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresDefaultAssist() {
        if (!this.isEditing && this.configComplete && this.mechanismOption == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        W();
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
        parcel.writeInt(this.m_keepWifiOn ? 1 : 0);
        parcel.writeInt(this.m_keepBluetoothOn ? 1 : 0);
        parcel.writeInt(this.mechanismOption);
        parcel.writeInt(this.configComplete ? 1 : 0);
    }

    public SetAirplaneModeAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        V();
    }

    public SetAirplaneModeAction() {
        this.isEditing = false;
        this.m_state = 0;
        this.m_keepWifiOn = false;
        V();
    }

    private SetAirplaneModeAction(Parcel parcel) {
        super(parcel);
        this.isEditing = false;
        this.m_state = parcel.readInt();
        this.m_keepWifiOn = parcel.readInt() != 0;
        this.m_keepBluetoothOn = parcel.readInt() != 0;
        this.mechanismOption = parcel.readInt();
        this.configComplete = parcel.readInt() != 0;
    }
}
