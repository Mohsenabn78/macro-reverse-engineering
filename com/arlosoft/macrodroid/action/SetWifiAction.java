package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.util.Pair;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetWifiActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import com.arlosoft.macrodroid.utils.LocationUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetWifiAction extends Action {
    private static final int AP_STATE_DISABLED = 1;
    private static final int AP_STATE_DISABLING = 0;
    private static final int AP_STATE_ENABLED = 3;
    private static final int AP_STATE_ENABLING = 2;
    private static final int AP_STATE_FAILED = 4;
    public static final Parcelable.Creator<SetWifiAction> CREATOR = new b();
    private static final int STATE_CONNECT_TO_NETWORK = 3;
    private static final int STATE_FORGET_NETWORK = 4;
    private String m_SSID;
    private transient boolean m_connectAfterWifiIOn;
    private final transient BroadcastReceiver m_connectReceiver;
    private int m_networkId;
    private transient MaterialDialog m_progressDialog;
    private int m_state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") && intent.getIntExtra(HelperCommandsKt.HELPER_OPTION_SET_WIFI_STATE, 0) == 3) {
                if (!SetWifiAction.this.m_connectAfterWifiIOn) {
                    SetWifiAction.this.a0();
                } else {
                    SetWifiAction.this.m_connectAfterWifiIOn = false;
                    SetWifiAction.this.W();
                }
                if (SetWifiAction.this.m_connectReceiver != null) {
                    MacroDroidApplication.getInstance().unregisterReceiver(SetWifiAction.this.m_connectReceiver);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<SetWifiAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetWifiAction createFromParcel(Parcel parcel) {
            return new SetWifiAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetWifiAction[] newArray(int i4) {
            return new SetWifiAction[i4];
        }
    }

    /* synthetic */ SetWifiAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        WifiManager wifiManager = (WifiManager) MacroDroidApplication.getInstance().getApplicationContext().getSystemService("wifi");
        List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        if (configuredNetworks != null) {
            for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                String str = wifiConfiguration.SSID;
                if (str != null) {
                    if (str.startsWith("\"") && str.endsWith("\"")) {
                        str = str.substring(1, str.length() - 1);
                    }
                    if (str.equals(this.m_SSID)) {
                        wifiManager.enableNetwork(wifiConfiguration.networkId, true);
                    }
                }
            }
        }
    }

    private void X(List<WifiConfiguration> list) {
        if (!checkActivityAlive()) {
            return;
        }
        MaterialDialog materialDialog = this.m_progressDialog;
        if (materialDialog != null) {
            try {
                materialDialog.dismiss();
            } catch (Exception unused) {
            }
            this.m_progressDialog = null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        if (list != null) {
            int i5 = 0;
            for (WifiConfiguration wifiConfiguration : list) {
                String str = wifiConfiguration.SSID;
                if (str != null) {
                    if (str.startsWith("\"") && str.endsWith("\"")) {
                        str = str.substring(1, str.length() - 1);
                    }
                    arrayList2.add(Integer.valueOf(wifiConfiguration.networkId));
                    arrayList.add(str);
                    if (this.m_SSID.equals(str)) {
                        i4 = i5;
                    }
                    i5++;
                }
            }
        }
        String str2 = getOptions()[this.m_state];
        final String[] strArr = new String[arrayList.size()];
        final Integer[] numArr = new Integer[arrayList.size()];
        arrayList.toArray(strArr);
        arrayList2.toArray(numArr);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str2);
        builder.setSingleChoiceItems(strArr, i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.km
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                SetWifiAction.this.g0(strArr, numArr, dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void Y() {
        boolean z3;
        WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService("wifi");
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        MacroDroidApplication.getInstance().registerReceiver(this.m_connectReceiver, intentFilter);
        try {
            if (Build.VERSION.SDK_INT < 29) {
                z3 = wifiManager.setWifiEnabled(true);
            } else if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
                HelperSystemCommands.sendWifiEnableSetEnableState(getContext(), true, "");
                z3 = true;
            } else {
                ToastCompat.makeText(getContext(), (int) R.string.enable_wifi_failed, 1).show();
                return;
            }
            if (!this.m_connectAfterWifiIOn && z3 && checkActivityAlive()) {
                this.m_progressDialog = new MaterialDialog.Builder(getActivity()).title(R.string.please_wait).content(R.string.enabling_wifi).progress(true, 0).cancelable(false).widgetColor(ContextCompat.getColor(getActivity(), R.color.actions_primary)).show();
            }
        } catch (SecurityException unused) {
            Util.displayNotification(getContext(), SelectableItem.r(R.string.wifi_could_not_change), SelectableItem.r(R.string.wifi_could_not_change_body), false);
        }
    }

    private static final String Z() {
        return SelectableItem.r(R.string.select_wifi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        if (Build.VERSION.SDK_INT < 29) {
            X(((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).getConfiguredNetworks());
        } else if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
            HelperSystemCommands.getWifiNetworks(getContext(), new HelperSystemCommands.WifiNetworksHandler() { // from class: com.arlosoft.macrodroid.action.hm
                @Override // com.arlosoft.macrodroid.utils.HelperSystemCommands.WifiNetworksHandler
                public final void handleResult(List list) {
                    SetWifiAction.this.h0(list);
                }
            });
        } else {
            PermissionsHelper.showNeedsNewHelperFileDialog(getActivity(), false, false, SelectableItem.r(R.string.helper_apk_required));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public void h0(List<WifiConfiguration> list) {
        if (list.size() > 0) {
            X(list);
        } else {
            ToastCompat.makeText(getContext(), (int) R.string.please_ensure_run_helper_file_and_granted_location_permission, 1).show();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009a, code lost:
        if (r8.getWifiState() != 3) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c0(com.arlosoft.macrodroid.triggers.TriggerContextInfo r8) {
        /*
            r7 = this;
            com.arlosoft.macrodroid.app.MacroDroidApplication r8 = com.arlosoft.macrodroid.app.MacroDroidApplication.getInstance()
            android.content.Context r8 = r8.getApplicationContext()
            java.lang.String r0 = "wifi"
            java.lang.Object r8 = r8.getSystemService(r0)
            android.net.wifi.WifiManager r8 = (android.net.wifi.WifiManager) r8
            com.arlosoft.macrodroid.macro.Macro r0 = r7.getMacro()
            if (r0 == 0) goto L22
            java.lang.String r1 = r0.getName()
            if (r1 == 0) goto L22
            java.lang.String r0 = r0.getName()
            goto L24
        L22:
            java.lang.String r0 = ""
        L24:
            android.content.Context r1 = r7.getContext()
            java.lang.String r2 = "power"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.os.PowerManager r1 = (android.os.PowerManager) r1
            java.lang.String r2 = "macrodroid:setWifiAction"
            r3 = 1
            android.os.PowerManager$WakeLock r1 = r1.newWakeLock(r3, r2)
            r2 = 0
            r1.setReferenceCounted(r2)
            r4 = 5000(0x1388, double:2.4703E-320)
            r1.acquire(r4)
            int r1 = r7.m_state
            java.lang.String r4 = "Cannot set wifi, Helper File is not installed. Please see: https://macrodroidforum.com/index.php?threads/macrodroid-helper-apk.1/"
            if (r1 == 0) goto L9c
            if (r1 == r3) goto L5a
            r5 = 2
            r6 = 3
            if (r1 == r5) goto L96
            if (r1 == r6) goto L5c
            r3 = 4
            if (r1 == r3) goto L52
            goto L5a
        L52:
            int r1 = r7.m_networkId
            r8.removeNetwork(r1)
            r8.saveConfiguration()
        L5a:
            r3 = 0
            goto L9c
        L5c:
            java.lang.String r8 = com.arlosoft.macrodroid.common.ApplicationChecker.getMacroDroidHelperVersionName()
            if (r8 == 0) goto L8a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Sending request to Helper File to connect to SSID: "
            r8.append(r1)
            java.lang.String r1 = r7.m_SSID
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            java.lang.Long r1 = r7.getMacroGuid()
            long r1 = r1.longValue()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logInfo(r8, r1)
            android.content.Context r8 = r7.getContext()
            java.lang.String r1 = r7.m_SSID
            com.arlosoft.macrodroid.utils.HelperSystemCommands.sendWifiConnectToSSID(r8, r1, r0)
            goto L95
        L8a:
            java.lang.Long r8 = r7.getMacroGuid()
            long r0 = r8.longValue()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r4, r0)
        L95:
            return
        L96:
            int r8 = r8.getWifiState()
            if (r8 == r6) goto L5a
        L9c:
            boolean r8 = com.arlosoft.macrodroid.root.RootToolsHelper.isAccessGiven()
            if (r8 == 0) goto La6
            r7.e0(r3)
            goto Le7
        La6:
            java.lang.String r8 = com.arlosoft.macrodroid.common.ApplicationChecker.getMacroDroidHelperVersionName()
            if (r8 == 0) goto Ldc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Sending request to Helper File to "
            r8.append(r1)
            if (r3 == 0) goto Lbb
            java.lang.String r1 = "enable"
            goto Lbd
        Lbb:
            java.lang.String r1 = "disable"
        Lbd:
            r8.append(r1)
            java.lang.String r1 = " wifi"
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            java.lang.Long r1 = r7.getMacroGuid()
            long r1 = r1.longValue()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logInfo(r8, r1)
            android.content.Context r8 = r7.getContext()
            com.arlosoft.macrodroid.utils.HelperSystemCommands.sendWifiEnableSetEnableState(r8, r3, r0)
            goto Le7
        Ldc:
            java.lang.Long r8 = r7.getMacroGuid()
            long r0 = r8.longValue()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r4, r0)
        Le7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.SetWifiAction.c0(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    private void d0(final TriggerContextInfo triggerContextInfo, boolean z3) {
        boolean wifiEnabled;
        boolean z4;
        boolean z5;
        try {
            WifiManager wifiManager = (WifiManager) MacroDroidApplication.getInstance().getApplicationContext().getSystemService("wifi");
            int i4 = this.m_state;
            boolean z6 = true;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 4) {
                                wifiManager.removeNetwork(this.m_networkId);
                                wifiManager.saveConfiguration();
                            }
                        } else if (wifiManager.getWifiState() == 3) {
                            W();
                        } else {
                            this.m_connectAfterWifiIOn = true;
                            Y();
                        }
                        wifiEnabled = true;
                    } else {
                        if (wifiManager.getWifiState() != 3) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        wifiEnabled = wifiManager.setWifiEnabled(z5);
                    }
                } else {
                    try {
                        wifiEnabled = wifiManager.setWifiEnabled(false);
                    } catch (Exception e4) {
                        SystemLog.logError("Disabling wifi failed" + e4.toString(), getMacroGuid().longValue());
                    }
                }
            } else {
                wifiEnabled = wifiManager.setWifiEnabled(true);
            }
            if (!wifiEnabled) {
                if (Settings.Global.getInt(getContext().getContentResolver(), "airplane_mode_on", 0) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    SystemLog.logError("Failed to set wifi state - Cannot set when in airplane mode", getMacroGuid().longValue());
                } else if (z3) {
                    new Handler().postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.gm
                        @Override // java.lang.Runnable
                        public final void run() {
                            SetWifiAction.this.i0(triggerContextInfo);
                        }
                    }, 1000L);
                } else {
                    int i5 = Build.VERSION.SDK_INT;
                    if (i5 >= 29) {
                        SystemLog.logError("Failed to set wifi on Android Q, due to new Android restrictions. https://developer.android.com/about/versions/10/privacy/changes", getMacroGuid().longValue());
                    } else if (i5 >= 27) {
                        if (Settings.System.getInt(getContext().getContentResolver(), "airplane_mode_on", 0) == 0) {
                            z6 = false;
                        }
                        if (z6) {
                            SystemLog.logError("Failed to set wifi state - Cannot set when in airplane mode", getMacroGuid().longValue());
                        } else if (f0()) {
                            SystemLog.logError("Failed to set wifi state - Cannot set when hotspot is enabled", getMacroGuid().longValue());
                        } else {
                            SystemLog.logError("Failed to set wifi state", getMacroGuid().longValue());
                        }
                    } else {
                        SystemLog.logError("Failed to set wifi state", getMacroGuid().longValue());
                    }
                }
            }
        } catch (SecurityException e5) {
            SystemLog.logError("Chould not change wifi state: " + e5, getMacroGuid().longValue());
            Util.displayNotification(getContext(), SelectableItem.r(R.string.wifi_could_not_change), e5.toString(), false);
        } catch (RuntimeException e6) {
            SystemLog.logError("Failed to set wifi: " + e6.toString(), getMacroGuid().longValue());
        }
    }

    private void e0(boolean z3) {
        if (z3) {
            Util.runAsRoot(new String[]{"svc wifi enable"});
        } else {
            Util.runAsRoot(new String[]{"svc wifi disable"});
        }
    }

    private boolean f0() {
        try {
            WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService("wifi");
            Method declaredMethod = wifiManager.getClass().getDeclaredMethod("getWifiApState", new Class[0]);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(wifiManager, null)).intValue();
            if (intValue > 10) {
                intValue -= 10;
            }
            if (intValue != 1 && intValue != 4) {
                return true;
            }
            return false;
        } catch (Exception e4) {
            SystemLog.logError("Error getting wifi AP State: " + e4.getMessage(), getMacroGuid().longValue());
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Error getting wifi AP State: " + e4.getMessage()));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(String[] strArr, Integer[] numArr, DialogInterface dialogInterface, int i4) {
        ListView listView = ((AlertDialog) dialogInterface).getListView();
        if (strArr.length > 0 && numArr.length > 0) {
            this.m_SSID = strArr[listView.getCheckedItemPosition()];
            this.m_networkId = numArr[listView.getCheckedItemPosition()].intValue();
        }
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_set_wifi_enable), SelectableItem.r(R.string.action_set_wifi_disable), SelectableItem.r(R.string.action_set_wifi_toggle), SelectableItem.r(R.string.connect_to_network), SelectableItem.r(R.string.forget_network)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(TriggerContextInfo triggerContextInfo) {
        d0(triggerContextInfo, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(DialogInterface dialogInterface, int i4) {
        Y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_state = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_state;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_state];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_state;
        if (i4 != 3 && i4 != 4) {
            return "";
        }
        return this.m_SSID;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetWifiActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        int i4 = this.m_state;
        if (i4 != 3 && i4 != 4) {
            return getConfiguredName();
        }
        return getConfiguredName() + " (" + this.m_SSID + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 29) {
            return new String[0];
        }
        return new String[0];
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            d0(triggerContextInfo, true);
        } else {
            c0(triggerContextInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        if (Build.VERSION.SDK_INT < 23) {
            return getOptions();
        }
        return (String[]) Arrays.copyOfRange(getOptions(), 0, getOptions().length - 1);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLocationServicesEnabled() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public Pair<Integer, String> requiresNewHelperFileVersion() {
        Pair<Integer, String> pair;
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi") && Build.VERSION.SDK_INT >= 31) {
            pair = new Pair<>(8, "1.8");
        } else {
            pair = new Pair<>(2, "1.2");
        }
        if (Build.VERSION.SDK_INT < 29 || RootToolsHelper.isAccessGiven()) {
            return null;
        }
        return pair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_state;
        if (i4 != 3 && i4 != 4) {
            itemComplete();
            return;
        }
        WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService("wifi");
        if (Build.VERSION.SDK_INT >= 27 && !LocationUtils.isLocationEnabled(getContext())) {
            ToastCompat.makeText(getContext(), (CharSequence) SelectableItem.r(R.string.location_service_must_be_enabled), 1).show();
            SystemLog.logError("Set Wifi action could not get current SSIDs, location services must be enabled on Android 8.1+", getMacroGuid().longValue());
        } else if (wifiManager.isWifiEnabled()) {
            a0();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(R.string.wifi_currently_disabled);
            builder.setMessage(R.string.wifi_connection_must_enable).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.im
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    SetWifiAction.this.j0(dialogInterface, i5);
                }
            }).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.jm
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
        }
    }

    public void setState(int i4) {
        this.m_state = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_state);
        parcel.writeString(this.m_SSID);
        parcel.writeInt(this.m_networkId);
    }

    public SetWifiAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetWifiAction() {
        this.m_connectReceiver = new a();
        this.m_state = 0;
        this.m_SSID = Z();
    }

    private SetWifiAction(Parcel parcel) {
        super(parcel);
        this.m_connectReceiver = new a();
        this.m_state = parcel.readInt();
        this.m_SSID = parcel.readString();
        this.m_networkId = parcel.readInt();
    }
}
