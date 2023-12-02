package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.info.WifiConstraintInfo;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import com.arlosoft.macrodroid.utils.LocationUtils;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class WifiConstraint extends Constraint {
    public static final Parcelable.Creator<WifiConstraint> CREATOR = new c();
    private String m_SSID;
    private ArrayList<String> m_SSIDList;
    private final transient BroadcastReceiver m_connectReceiver;
    private transient d m_localWifiScanCompleteReceiver;
    private transient MaterialDialog m_progressDialog;
    private transient int m_selectedCount;
    private int m_wifiState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") && intent.getIntExtra(HelperCommandsKt.HELPER_OPTION_SET_WIFI_STATE, 0) == 3) {
                WifiConstraint.this.a0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            WifiConstraint.this.h0();
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<WifiConstraint> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WifiConstraint createFromParcel(Parcel parcel) {
            return new WifiConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WifiConstraint[] newArray(int i4) {
            return new WifiConstraint[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                List<ScanResult> scanResults = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getScanResults();
                if (scanResults != null) {
                    for (int i4 = 0; i4 < scanResults.size(); i4++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("RESULT ");
                        sb.append(i4);
                        sb.append(": ");
                        sb.append(scanResults.get(i4).SSID);
                    }
                } else {
                    scanResults = new ArrayList<>();
                }
                if (WifiConstraint.this.checkActivityAlive()) {
                    ArrayList arrayList = new ArrayList();
                    for (ScanResult scanResult : scanResults) {
                        if (!TextUtils.isEmpty(scanResult.SSID) && !arrayList.contains(scanResult.SSID)) {
                            arrayList.add(scanResult.SSID);
                        }
                    }
                    WifiConstraint.this.X(arrayList);
                }
            } catch (SecurityException unused) {
                PermissionsHelper.showNeedsPermission(context, "android.permission.ACCESS_COARSE_LOCATION", null, true, false);
            }
        }

        /* synthetic */ d(WifiConstraint wifiConstraint, a aVar) {
            this();
        }
    }

    /* synthetic */ WifiConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(List<String> list) {
        String string;
        if (!checkActivityAlive()) {
            return;
        }
        String str = this.m_SSID;
        if (str != null && !this.m_SSIDList.contains(str)) {
            this.m_SSIDList.add(this.m_SSID);
        }
        boolean z3 = true;
        if (Build.VERSION.SDK_INT >= 27 && !LocationUtils.isLocationEnabled(getContext())) {
            ToastCompat.makeText(getContext(), (CharSequence) SelectableItem.r(R.string.location_service_must_be_enabled), 1).show();
        }
        this.m_SSID = null;
        MaterialDialog materialDialog = this.m_progressDialog;
        if (materialDialog != null && materialDialog.isShowing()) {
            try {
                this.m_progressDialog.dismiss();
                this.m_progressDialog = null;
                MacroDroidApplication.getInstance().unregisterReceiver(this.m_connectReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
        this.m_selectedCount = 0;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str2 : list) {
                if (str2 != null) {
                    if (str2.startsWith("\"") && str2.endsWith("\"")) {
                        str2 = str2.substring(1, str2.length() - 1);
                    }
                    arrayList.add(str2);
                }
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.constraint.c5
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b02;
                b02 = WifiConstraint.b0((String) obj, (String) obj2);
                return b02;
            }
        });
        arrayList.add(0, getContext().getString(R.string.any_network));
        boolean[] zArr = new boolean[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if (this.m_SSIDList.contains(arrayList.get(i4))) {
                zArr[i4] = true;
                this.m_selectedCount++;
            }
        }
        if (this.m_wifiState == 2) {
            string = getContext().getString(R.string.constraint_wifi_connected_to);
        } else {
            string = getContext().getString(R.string.constraint_wifi_not_connected_to);
        }
        final String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(string);
        builder.setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.constraint.d5
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i5, boolean z4) {
                WifiConstraint.this.c0(dialogInterface, i5, z4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.e5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                WifiConstraint.this.d0(strArr, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        Button button = create.getButton(-1);
        if (this.m_selectedCount <= 0) {
            z3 = false;
        }
        button.setEnabled(z3);
    }

    private void Y() {
        WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService("wifi");
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        MacroDroidApplication.getInstance().registerReceiver(this.m_connectReceiver, intentFilter);
        try {
            if (Build.VERSION.SDK_INT < 29) {
                wifiManager.setWifiEnabled(true);
            } else if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
                HelperSystemCommands.sendWifiEnableSetEnableState(getContext(), true, "");
            } else {
                ToastCompat.makeText(getContext(), (int) R.string.enable_wifi_failed, 1).show();
                return;
            }
        } catch (SecurityException unused) {
            Util.displayNotification(getContext(), getContext().getString(R.string.constraint_wifi_could_not_change_title), getContext().getString(R.string.constraint_wifi_could_not_change_detail), false);
        }
        this.m_progressDialog = new MaterialDialog.Builder(getActivity()).title(R.string.please_wait).content(R.string.enabling_wifi).progress(true, 0).cancelable(false).widgetColor(J()).show();
    }

    private String Z(boolean z3) {
        int i4;
        int i5 = this.m_wifiState;
        if (i5 != 0 && i5 != 1) {
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
            StringBuilder sb = new StringBuilder();
            sb.append(getConfiguredName());
            sb.append(" (");
            if (z3) {
                i4 = 150;
            } else {
                i4 = 15;
            }
            sb.append(MDTextUtils.truncateListIfRequired(str, i4));
            sb.append(")");
            return sb.toString();
        }
        return getConfiguredName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        if (Build.VERSION.SDK_INT < 29) {
            ArrayList arrayList = new ArrayList();
            for (WifiConfiguration wifiConfiguration : ((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).getConfiguredNetworks()) {
                arrayList.add(wifiConfiguration.SSID);
            }
            X(arrayList);
        } else if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
            HelperSystemCommands.getWifiNetworks(getContext(), new HelperSystemCommands.WifiNetworksHandler() { // from class: com.arlosoft.macrodroid.constraint.z4
                @Override // com.arlosoft.macrodroid.utils.HelperSystemCommands.WifiNetworksHandler
                public final void handleResult(List list) {
                    WifiConstraint.this.e0(list);
                }
            });
        } else {
            PermissionsHelper.showNeedsNewHelperFileWifiSSIDsDialog(getActivity(), getName(), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b0(String str, String str2) {
        return str.toLowerCase().compareTo(str2.toLowerCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface, int i4, boolean z3) {
        boolean z4 = true;
        if (z3) {
            this.m_selectedCount++;
        } else {
            this.m_selectedCount--;
        }
        Button button = ((AlertDialog) dialogInterface).getButton(-1);
        if (this.m_selectedCount <= 0) {
            z4 = false;
        }
        button.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(String[] strArr, DialogInterface dialogInterface, int i4) {
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
    public /* synthetic */ void e0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((WifiConfiguration) it.next()).SSID);
        }
        X(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(DialogInterface dialogInterface, int i4) {
        Y();
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.constraint_wifi_enabled), MacroDroidApplication.getInstance().getString(R.string.constraint_wifi_disabled), MacroDroidApplication.getInstance().getString(R.string.constraint_wifi_connected_to), MacroDroidApplication.getInstance().getString(R.string.constraint_wifi_not_connected_to)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        if (this.m_progressDialog != null) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(this.m_connectReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            if (checkActivityAlive()) {
                try {
                    this.m_progressDialog.dismiss();
                } catch (Exception unused) {
                }
            }
            this.m_progressDialog = null;
        }
        if (!checkActivityAlive()) {
            return;
        }
        if (Build.VERSION.SDK_INT > 26) {
            try {
                if (Settings.Secure.getInt(getContext().getContentResolver(), "location_mode") == 0) {
                    ToastCompat.makeText(getContext(), (int) R.string.location_services_must_be_enabled, 1).show();
                    return;
                }
            } catch (Exception unused2) {
            }
        }
        this.m_localWifiScanCompleteReceiver = new d(this, null);
        MacroDroidApplication.getInstance().registerReceiver(this.m_localWifiScanCompleteReceiver, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        ((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).startScan();
        this.m_progressDialog = new MaterialDialog.Builder(getActivity()).title(R.string.please_wait).content(R.string.trigger_wifi_SSID_scanning).progress(true, 0).cancelable(false).widgetColor(ContextCompat.getColor(getActivity(), R.color.constraints_accent)).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_wifiState = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
        if (r3.equals("<unknown ssid>") == false) goto L29;
     */
    @Override // com.arlosoft.macrodroid.constraint.Constraint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkOK(com.arlosoft.macrodroid.triggers.TriggerContextInfo r13) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.WifiConstraint.checkOK(com.arlosoft.macrodroid.triggers.TriggerContextInfo):boolean");
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
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("WifiConstraint: Invalid Wifi State"));
                        return "Error";
                    }
                    return getContext().getString(R.string.constraint_wifi_not_connected);
                }
                return getContext().getString(R.string.constraint_wifi_connected);
            }
            return getContext().getString(R.string.constraint_wifi_disabled);
        }
        return getContext().getString(R.string.constraint_wifi_enabled);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredNameFlowControl() {
        int i4 = this.m_wifiState;
        if (i4 != 2 && i4 != 3) {
            return getConfiguredName();
        }
        return getConfiguredName() + ": " + getExtendedDetail();
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
        return WifiConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return Z(false);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return Z(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLocationServicesEnabled() {
        if (Build.VERSION.SDK_INT > 26) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.m_wifiState;
        if (i4 != 0 && i4 != 1) {
            if (i4 == 2 || i4 == 3) {
                if (((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).isWifiEnabled()) {
                    a0();
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
                builder.setTitle(R.string.constraint_wifi_currently_disabled);
                builder.setMessage(R.string.constraint_wifi_must_be_enabled).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.a5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        WifiConstraint.this.f0(dialogInterface, i5);
                    }
                }).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.b5
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

    public void setState(int i4) {
        this.m_wifiState = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_SSID);
        parcel.writeInt(this.m_wifiState);
        parcel.writeStringList(this.m_SSIDList);
    }

    public WifiConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public WifiConstraint() {
        this.m_connectReceiver = new a();
        this.m_wifiState = 0;
        this.m_SSIDList = new ArrayList<>();
    }

    private WifiConstraint(Parcel parcel) {
        super(parcel);
        this.m_connectReceiver = new a();
        this.m_SSID = parcel.readString();
        this.m_wifiState = parcel.readInt();
        ArrayList<String> arrayList = new ArrayList<>();
        this.m_SSIDList = arrayList;
        parcel.readStringList(arrayList);
    }
}
