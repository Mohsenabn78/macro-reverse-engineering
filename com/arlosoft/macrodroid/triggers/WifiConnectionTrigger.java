package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.util.SparseBooleanArray;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.info.WifiConnectionTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.WifiConnectionTriggerReceiver;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class WifiConnectionTrigger extends Trigger {
    private static int s_triggerCounter;
    private static WifiConnectionTriggerReceiver s_wifiConnectionTriggerReceiver;
    private String m_SSID;
    private List<String> m_SSIDList;
    private final transient BroadcastReceiver m_connectReceiver;
    private transient MaterialDialog m_progressDialog;
    private int m_wifiState;
    public static final String SELECT_SSID = SelectableItem.r(R.string.select_wifi);
    public static final Parcelable.Creator<WifiConnectionTrigger> CREATOR = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") && intent.getIntExtra(HelperCommandsKt.HELPER_OPTION_SET_WIFI_STATE, 0) == 3) {
                WifiConnectionTrigger.this.U();
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<WifiConnectionTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WifiConnectionTrigger createFromParcel(Parcel parcel) {
            return new WifiConnectionTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WifiConnectionTrigger[] newArray(int i4) {
            return new WifiConnectionTrigger[i4];
        }
    }

    /* synthetic */ WifiConnectionTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public void X(List<WifiConfiguration> list) {
        int i4;
        if (getActivity() != null && !((MacroDroidBaseActivity) getActivity()).isDestroyedOrFinishing()) {
            if (this.m_progressDialog != null) {
                MacroDroidApplication.getInstance().unregisterReceiver(this.m_connectReceiver);
                this.m_progressDialog.dismiss();
                this.m_progressDialog = null;
            }
            boolean z3 = true;
            if (Build.VERSION.SDK_INT > 26) {
                try {
                    if (Settings.Secure.getInt(getContext().getContentResolver(), "location_mode") == 0) {
                        ToastCompat.makeText(getContext(), (int) R.string.location_services_must_be_enabled, 1).show();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(SelectableItem.r(R.string.any_network));
            if (list != null) {
                for (WifiConfiguration wifiConfiguration : list) {
                    String str = wifiConfiguration.SSID;
                    if (str != null && str != null) {
                        if (str.startsWith("\"") && str.endsWith("\"")) {
                            str = str.substring(1, str.length() - 1);
                        }
                        arrayList.add(str);
                    }
                }
            }
            if (this.m_wifiState == 2) {
                i4 = R.string.trigger_wifi_connection_connected;
            } else {
                i4 = R.string.trigger_wifi_connection_disconnected;
            }
            String r4 = SelectableItem.r(i4);
            int size = arrayList.size();
            final String[] strArr = new String[size];
            arrayList.toArray(strArr);
            boolean[] zArr = new boolean[size];
            int i5 = 0;
            boolean z4 = false;
            while (true) {
                if (i5 < size) {
                    String str2 = this.m_SSID;
                    if (str2 != null) {
                        if (str2.equals(strArr[i5])) {
                            zArr[i5] = true;
                            break;
                        }
                    } else {
                        for (int i6 = 0; i6 < this.m_SSIDList.size(); i6++) {
                            if (this.m_SSIDList.get(i6).equals(strArr[i5])) {
                                zArr[i5] = true;
                                z4 = true;
                            }
                        }
                    }
                    i5++;
                } else {
                    z3 = z4;
                    break;
                }
            }
            this.m_SSID = null;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setTitle(r4);
            builder.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.triggers.lb
                @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                public final void onClick(DialogInterface dialogInterface, int i7, boolean z5) {
                    WifiConnectionTrigger.V(dialogInterface, i7, z5);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.mb
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i7) {
                    WifiConnectionTrigger.this.W(strArr, dialogInterface, i7);
                }
            });
            AlertDialog create = builder.create();
            create.show();
            if (!z3) {
                create.getButton(-1).setEnabled(false);
            }
        }
    }

    private void T() {
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
            if (z3) {
                this.m_progressDialog = new MaterialDialog.Builder(getActivity()).title(R.string.please_wait).content(R.string.enabling_wifi).progress(true, 0).cancelable(false).widgetColor(ContextCompat.getColor(getActivity(), R.color.trigger_primary)).show();
            } else {
                ToastCompat.makeText(getContext(), (int) R.string.enable_wifi_failed, 1).show();
            }
        } catch (SecurityException unused) {
            Util.displayNotification(getContext(), SelectableItem.r(R.string.wifi_could_not_change), SelectableItem.r(R.string.wifi_could_not_change_body), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (Build.VERSION.SDK_INT < 29) {
            X(((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).getConfiguredNetworks());
        } else if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
            HelperSystemCommands.getWifiNetworks(getContext(), new HelperSystemCommands.WifiNetworksHandler() { // from class: com.arlosoft.macrodroid.triggers.kb
                @Override // com.arlosoft.macrodroid.utils.HelperSystemCommands.WifiNetworksHandler
                public final void handleResult(List list) {
                    WifiConnectionTrigger.this.X(list);
                }
            });
        } else {
            PermissionsHelper.showNeedsNewHelperFileDialog(getActivity(), false, false, SelectableItem.r(R.string.helper_apk_required));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(DialogInterface dialogInterface, int i4, boolean z3) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        SparseBooleanArray checkedItemPositions = alertDialog.getListView().getCheckedItemPositions();
        boolean z4 = false;
        int i5 = 0;
        for (int i6 = 0; i6 < checkedItemPositions.size(); i6++) {
            if (checkedItemPositions.valueAt(i6)) {
                i5++;
            }
        }
        Button button = alertDialog.getButton(-1);
        if (i5 > 0) {
            z4 = true;
        }
        button.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(String[] strArr, DialogInterface dialogInterface, int i4) {
        SparseBooleanArray checkedItemPositions = ((AlertDialog) dialogInterface).getListView().getCheckedItemPositions();
        this.m_SSIDList.clear();
        for (int i5 = 0; i5 < checkedItemPositions.size(); i5++) {
            if (checkedItemPositions.valueAt(i5)) {
                this.m_SSIDList.add(strArr[checkedItemPositions.keyAt(i5)]);
            }
        }
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface, int i4) {
        T();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_wifi_enabled), SelectableItem.r(R.string.trigger_wifi_disabled), SelectableItem.r(R.string.trigger_wifi_connection_connected), SelectableItem.r(R.string.trigger_wifi_connection_disconnected)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_wifiState = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_wifiConnectionTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_wifiConnectionTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_wifiConnectionTriggerReceiver = new WifiConnectionTriggerReceiver();
            IntentFilter intentFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
            MacroDroidApplication.getInstance().registerReceiver(s_wifiConnectionTriggerReceiver, intentFilter);
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_wifiState;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        int i4 = this.m_wifiState;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Invalid Wifi State"));
                        return "Error";
                    }
                    return SelectableItem.r(R.string.trigger_wifi_connection_disconnected);
                }
                return SelectableItem.r(R.string.trigger_wifi_connection_connected);
            }
            return SelectableItem.r(R.string.trigger_wifi_disabled);
        }
        return SelectableItem.r(R.string.trigger_wifi_enabled);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_wifiState;
        if (i4 == 0 || i4 == 1) {
            return "";
        }
        if (i4 != 2 && i4 != 3) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("WifiConnectionTrigger: Invalid Wifi State"));
            return "";
        }
        String str = this.m_SSID;
        if (str != null) {
            return str;
        }
        if (this.m_SSIDList.size() == 1) {
            return this.m_SSIDList.get(0);
        }
        return this.m_SSIDList.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return WifiConnectionTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        int i4 = this.m_wifiState;
        if (i4 != 0 && i4 != 1) {
            String str = this.m_SSID;
            if (str == null) {
                if (this.m_SSIDList.size() > 1) {
                    str = this.m_SSIDList.size() + SelectableItem.r(R.string.ssids);
                } else if (this.m_SSIDList.size() == 1) {
                    str = this.m_SSIDList.get(0);
                } else {
                    str = "";
                }
            }
            return getConfiguredName() + " (" + MDTextUtils.truncateListIfRequired(str, 15) + ")";
        }
        return getConfiguredName();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 27) {
            return new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
        }
        return new String[0];
    }

    public List<String> getSSIDList() {
        if (this.m_SSID != null) {
            ArrayList arrayList = new ArrayList();
            this.m_SSIDList = arrayList;
            arrayList.add(this.m_SSID);
            this.m_SSID = null;
        }
        return this.m_SSIDList;
    }

    public int getWifiState() {
        return this.m_wifiState;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        String str;
        int i4 = this.m_wifiState;
        if (i4 == 0 || i4 == 1 || (str = this.m_SSID) == null || !str.equals(SELECT_SSID)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLocationServicesEnabled() {
        if (Build.VERSION.SDK_INT > 26 && this.m_wifiState > 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_wifiState;
        if (i4 != 0 && i4 != 1) {
            if (i4 == 2 || i4 == 3) {
                if (((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).isWifiEnabled()) {
                    U();
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
                builder.setTitle(R.string.wifi_currently_disabled);
                builder.setMessage(R.string.wifi_connection_must_enable).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.nb
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        WifiConnectionTrigger.this.Y(dialogInterface, i5);
                    }
                }).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.ob
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
                return;
            }
            return;
        }
        itemComplete();
    }

    public void setSSID(String str) {
        this.m_SSID = str;
    }

    public void setWifiState(int i4) {
        this.m_wifiState = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_SSID);
        parcel.writeInt(this.m_wifiState);
        parcel.writeStringList(this.m_SSIDList);
    }

    public WifiConnectionTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public WifiConnectionTrigger() {
        this.m_connectReceiver = new a();
        this.m_wifiState = 0;
        this.m_SSID = null;
        this.m_SSIDList = new ArrayList();
    }

    private WifiConnectionTrigger(Parcel parcel) {
        super(parcel);
        this.m_connectReceiver = new a();
        this.m_SSIDList = new ArrayList();
        this.m_SSID = parcel.readString();
        this.m_wifiState = parcel.readInt();
        parcel.readStringList(this.m_SSIDList);
    }
}
