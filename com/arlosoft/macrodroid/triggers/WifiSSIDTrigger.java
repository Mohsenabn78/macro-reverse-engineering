package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
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
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.app.NotificationCompat;
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
import com.arlosoft.macrodroid.data.WifiCellInfo;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.WifiSSIDTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.InitiateWifScanReceiver;
import com.arlosoft.macrodroid.triggers.receivers.WifiScanCompleteReceiver;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class WifiSSIDTrigger extends Trigger {
    private static PendingIntent s_pendingIntent;
    private static int s_triggerCounter;
    private static f s_updateRateReceiver;
    private static WifiManager.WifiLock s_wifiLock;
    private static WifiManager s_wifiManager;
    private static WifiScanCompleteReceiver s_wifiScanCompleteReceiver;
    private boolean m_InRange;
    private String m_SSID;
    private List<String> m_SSIDList;
    private final transient BroadcastReceiver m_connectReceiver;
    private transient e m_localWifiScanCompleteReceiver;
    private transient MaterialDialog m_progressDialog;
    private List<WifiCellInfo> wifiCellInfoList;
    public static final String SELECT_SSID = SelectableItem.r(R.string.select_wifi);
    public static final Parcelable.Creator<WifiSSIDTrigger> CREATOR = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            WifiSSIDTrigger.this.o0();
        }
    }

    /* loaded from: classes3.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") && intent.getIntExtra(HelperCommandsKt.HELPER_OPTION_SET_WIFI_STATE, 0) == 3) {
                WifiSSIDTrigger.this.o0();
            }
        }
    }

    /* loaded from: classes3.dex */
    class d implements Parcelable.Creator<WifiSSIDTrigger> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WifiSSIDTrigger createFromParcel(Parcel parcel) {
            return new WifiSSIDTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WifiSSIDTrigger[] newArray(int i4) {
            return new WifiSSIDTrigger[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class e extends BroadcastReceiver {
        private e() {
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
                if (WifiSSIDTrigger.this.checkActivityAlive()) {
                    WifiSSIDTrigger.this.d0(scanResults);
                }
            } catch (SecurityException unused) {
                PermissionsHelper.showNeedsPermission(context, "android.permission.ACCESS_COARSE_LOCATION", null, true, false);
            }
        }

        /* synthetic */ e(WifiSSIDTrigger wifiSSIDTrigger, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    private class f extends BroadcastReceiver {
        private f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int wifiBackgroundScanRate = Settings.getWifiBackgroundScanRate(WifiSSIDTrigger.this.getContext());
            if (wifiBackgroundScanRate > 0) {
                int i4 = wifiBackgroundScanRate * 60 * 1000;
                AlarmManager alarmManager = (AlarmManager) WifiSSIDTrigger.this.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
                if (WifiSSIDTrigger.s_pendingIntent != null) {
                    alarmManager.cancel(WifiSSIDTrigger.s_pendingIntent);
                } else {
                    PendingIntent unused = WifiSSIDTrigger.s_pendingIntent = PendingIntent.getBroadcast(WifiSSIDTrigger.this.getContext(), 0, new Intent(WifiSSIDTrigger.this.getContext(), InitiateWifScanReceiver.class), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
                }
                alarmManager.setRepeating(0, System.currentTimeMillis(), i4, WifiSSIDTrigger.s_pendingIntent);
            }
        }

        /* synthetic */ f(WifiSSIDTrigger wifiSSIDTrigger, a aVar) {
            this();
        }
    }

    /* synthetic */ WifiSSIDTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Z(List<ScanResult> list, List<WifiConfiguration> list2, boolean z3) {
        Activity activity = getActivity();
        if (((MacroDroidBaseActivity) activity).isDestroyedOrFinishing()) {
            return;
        }
        MaterialDialog materialDialog = this.m_progressDialog;
        if (materialDialog != null) {
            try {
                materialDialog.dismiss();
                this.m_progressDialog = null;
            } catch (IllegalArgumentException unused) {
            }
        }
        try {
            MacroDroidApplication.getInstance().unregisterReceiver(this.m_localWifiScanCompleteReceiver);
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
        final ArrayList<WifiCellInfo> arrayList = new ArrayList();
        if (list2 != null) {
            for (WifiConfiguration wifiConfiguration : list2) {
                String str = wifiConfiguration.SSID;
                if (str != null && str != null) {
                    if (str.startsWith("\"") && str.endsWith("\"")) {
                        str = str.substring(1, str.length() - 1);
                    }
                    String str2 = wifiConfiguration.BSSID;
                    arrayList.add(new WifiCellInfo(str, str2, b0(str, str2)));
                }
            }
        }
        for (ScanResult scanResult : list) {
            String str3 = scanResult.SSID;
            String str4 = scanResult.BSSID;
            WifiCellInfo wifiCellInfo = new WifiCellInfo(str3, str4, b0(str3, str4));
            String str5 = scanResult.SSID;
            WifiCellInfo wifiCellInfo2 = new WifiCellInfo(str5, null, b0(str5, null));
            if (!arrayList.contains(wifiCellInfo2)) {
                arrayList.add(wifiCellInfo2);
            }
            if (!arrayList.contains(wifiCellInfo)) {
                arrayList.add(wifiCellInfo);
            }
        }
        for (String str6 : this.m_SSIDList) {
            WifiCellInfo wifiCellInfo3 = new WifiCellInfo(str6, null, str6);
            if (!arrayList.contains(wifiCellInfo3)) {
                arrayList.add(wifiCellInfo3);
            }
        }
        List<WifiCellInfo> list3 = this.wifiCellInfoList;
        if (list3 != null) {
            for (WifiCellInfo wifiCellInfo4 : list3) {
                if (!arrayList.contains(wifiCellInfo4)) {
                    arrayList.add(wifiCellInfo4);
                }
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.triggers.rb
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e02;
                e02 = WifiSSIDTrigger.e0((WifiCellInfo) obj, (WifiCellInfo) obj2);
                return e02;
            }
        });
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog_Trigger);
        appCompatDialog.setContentView(R.layout.dialog_wifi_ssid_trigger);
        appCompatDialog.setTitle(R.string.trigger_wifi_SSID_select);
        final ListView listView = (ListView) appCompatDialog.findViewById(R.id.list);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.button_add);
        ArrayList arrayList2 = new ArrayList();
        for (WifiCellInfo wifiCellInfo5 : arrayList) {
            arrayList2.add(c0(wifiCellInfo5.getSsid(), wifiCellInfo5.getBssid()));
        }
        listView.setAdapter((ListAdapter) new ArrayAdapter(appCompatDialog.getContext(), (int) R.layout.multi_choice_list_item, arrayList2));
        listView.setChoiceMode(2);
        getWifiCellInfoList();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            WifiCellInfo wifiCellInfo6 = (WifiCellInfo) arrayList.get(i4);
            for (int i5 = 0; i5 < this.wifiCellInfoList.size(); i5++) {
                if (this.wifiCellInfoList.get(i5).getSsid().equals(wifiCellInfo6.getSsid()) && (this.wifiCellInfoList.get(i5).getBssid() == null || this.wifiCellInfoList.get(i5).getBssid().equals(wifiCellInfo6.getBssid()))) {
                    listView.setItemChecked(i4, true);
                }
            }
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.sb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiSSIDTrigger.this.f0(listView, arrayList, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.tb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.ub
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WifiSSIDTrigger.this.h0(listView, arrayList, view);
            }
        });
        appCompatDialog.show();
    }

    private void a0() {
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
                if (checkActivityAlive()) {
                    this.m_progressDialog = new MaterialDialog.Builder(getActivity()).title(R.string.please_wait).content(R.string.enabling_wifi).progress(true, 0).cancelable(false).widgetColor(ContextCompat.getColor(getActivity(), R.color.trigger_accent)).show();
                    return;
                }
                return;
            }
            ToastCompat.makeText(getContext(), (int) R.string.enable_wifi_failed, 1).show();
        } catch (SecurityException unused) {
            Util.displayNotification(getContext(), SelectableItem.r(R.string.wifi_could_not_change), SelectableItem.r(R.string.wifi_could_not_change_body), false);
        }
    }

    private String b0(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "<" + SelectableItem.r(R.string.no_ssid) + ">";
        }
        sb.append(str);
        if (str2 != null) {
            str3 = "\n(" + str2 + ")";
        } else {
            str3 = "";
        }
        sb.append(str3);
        return sb.toString();
    }

    private CharSequence c0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "(" + SelectableItem.r(R.string.no_ssid) + ")";
        }
        if (str2 == null) {
            return Html.fromHtml("<b>" + str + "</b>");
        }
        return Html.fromHtml("<b>" + str + "</b><br/><small>" + str2 + "</small>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(final List<ScanResult> list) {
        if (Build.VERSION.SDK_INT < 29) {
            Z(list, ((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).getConfiguredNetworks(), true);
        } else if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
            HelperSystemCommands.getWifiNetworks(getContext(), new HelperSystemCommands.WifiNetworksHandler() { // from class: com.arlosoft.macrodroid.triggers.qb
                @Override // com.arlosoft.macrodroid.utils.HelperSystemCommands.WifiNetworksHandler
                public final void handleResult(List list2) {
                    WifiSSIDTrigger.this.i0(list, list2);
                }
            });
        } else {
            Z(list, new ArrayList(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e0(WifiCellInfo wifiCellInfo, WifiCellInfo wifiCellInfo2) {
        return wifiCellInfo.getDisplayName().toLowerCase().compareTo(wifiCellInfo2.getDisplayName().toLowerCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(ListView listView, List list, AppCompatDialog appCompatDialog, View view) {
        this.m_SSID = null;
        this.wifiCellInfoList.clear();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i4 = 0; i4 < checkedItemPositions.size(); i4++) {
            try {
                if (checkedItemPositions.valueAt(i4)) {
                    this.wifiCellInfoList.add((WifiCellInfo) list.get(checkedItemPositions.keyAt(i4)));
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        appCompatDialog.dismiss();
        itemComplete();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_wifi_SSID_in_range), SelectableItem.r(R.string.trigger_wifi_SSID_out_of_range)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(ListView listView, List list, View view) {
        n0(listView, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(List list, List list2) {
        Z(list, list2, true);
    }

    private void init() {
        this.m_InRange = true;
        this.m_SSIDList = new ArrayList();
        this.m_SSID = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Activity activity, DialogInterface dialogInterface, int i4) {
        Settings.setHasShownWifiSSIDWarning(activity, true);
        super.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(ListView listView, EditText editText, List list, DialogInterface dialogInterface, int i4) {
        ArrayAdapter arrayAdapter = (ArrayAdapter) listView.getAdapter();
        String obj = editText.getText().toString();
        arrayAdapter.add(obj);
        list.add(new WifiCellInfo(obj, null, obj));
        listView.setItemChecked(arrayAdapter.getCount() - 1, true);
        listView.setSelection(arrayAdapter.getCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(DialogInterface dialogInterface, int i4) {
        a0();
    }

    private void n0(final ListView listView, final List<WifiCellInfo> list) {
        Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(getConfiguredName());
        final EditText editText = new EditText(new ContextThemeWrapper(activity, m()));
        editText.setHint(R.string.trigger_wifi_SSID_enter);
        editText.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.alert_dialog_input_min_width));
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.margin_medium);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.input_text_dialog_top_margin);
        editText.setSingleLine();
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.xb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                WifiSSIDTrigger.k0(listView, editText, list, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        create.setView(editText, dimensionPixelOffset, dimensionPixelSize, dimensionPixelOffset, 0);
        create.show();
        Button button = create.getButton(-1);
        if (editText.getText().length() == 0) {
            button.setEnabled(false);
        }
        editText.addTextChangedListener(new c(button, editText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
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
        this.m_localWifiScanCompleteReceiver = new e(this, null);
        MacroDroidApplication.getInstance().registerReceiver(this.m_localWifiScanCompleteReceiver, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        ((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).startScan();
        this.m_progressDialog = new MaterialDialog.Builder(getActivity()).title(R.string.please_wait).content(R.string.trigger_wifi_SSID_scanning).progress(true, 0).cancelable(false).widgetColor(ContextCompat.getColor(getActivity(), R.color.trigger_accent)).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_InRange = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            if (s_pendingIntent != null) {
                ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(s_pendingIntent);
                s_pendingIntent = null;
            }
            if (s_updateRateReceiver != null) {
                try {
                    getContext().unregisterReceiver(s_updateRateReceiver);
                } catch (Exception e4) {
                    FirebaseAnalyticsEventLogger.logHandledException(e4);
                }
            }
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_wifiScanCompleteReceiver);
            } catch (Exception e5) {
                FirebaseAnalyticsEventLogger.logHandledException(e5);
            }
            s_wifiLock.release();
            s_wifiScanCompleteReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        int wifiBackgroundScanRate;
        if (s_triggerCounter == 0) {
            WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService("wifi");
            s_wifiManager = wifiManager;
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(2, "WifiConnectionTrigger");
            s_wifiLock = createWifiLock;
            createWifiLock.acquire();
            s_wifiScanCompleteReceiver = new WifiScanCompleteReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_wifiScanCompleteReceiver, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (com.arlosoft.macrodroid.settings.Settings.getWifiBackgroundScanRate(getContext()) * 60 > 0) {
                s_pendingIntent = PendingIntent.getBroadcast(getContext(), 0, new Intent(getContext(), InitiateWifScanReceiver.class), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
                alarmManager.setRepeating(0, System.currentTimeMillis(), wifiBackgroundScanRate * 1000, s_pendingIntent);
            }
            IntentFilter intentFilter = new IntentFilter(Util.WIFI_BACKGROUND_SCAN_RATE_INTENT);
            s_updateRateReceiver = new f(this, null);
            getContext().registerReceiver(s_updateRateReceiver, intentFilter);
            try {
                ((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).startScan();
            } catch (SecurityException unused) {
            }
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_InRange ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[!this.m_InRange ? 1 : 0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = this.m_SSID;
        if (str != null) {
            return str;
        }
        List<WifiCellInfo> wifiCellInfoList = getWifiCellInfoList();
        if (wifiCellInfoList.size() == 1) {
            return wifiCellInfoList.get(0).getSsid();
        }
        ArrayList arrayList = new ArrayList();
        for (WifiCellInfo wifiCellInfo : wifiCellInfoList) {
            if (!arrayList.contains(wifiCellInfo.getSsid())) {
                arrayList.add(wifiCellInfo.getSsid());
            }
        }
        return arrayList.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return WifiSSIDTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + MDTextUtils.truncateListIfRequired(getExtendedDetail(), 15) + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
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

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public List<WifiCellInfo> getWifiCellInfoList() {
        if (this.wifiCellInfoList == null) {
            this.wifiCellInfoList = new ArrayList();
            for (String str : getSSIDList()) {
                this.wifiCellInfoList.add(new WifiCellInfo(str, null, str));
            }
        }
        return this.wifiCellInfoList;
    }

    public boolean getWifiInRange() {
        return this.m_InRange;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (getWifiCellInfoList().size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void itemComplete() {
        final Activity activity = getActivity();
        if (activity != null && Build.VERSION.SDK_INT >= 23) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog_Trigger);
            builder.setTitle(R.string.trigger_wifi_SSID);
            builder.setMessage(R.string.trigger_wifi_SSID_marshmallow_warning);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.pb
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    WifiSSIDTrigger.this.j0(activity, dialogInterface, i4);
                }
            });
            try {
                builder.show();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        super.itemComplete();
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
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (((WifiManager) getContext().getApplicationContext().getSystemService("wifi")).isWifiEnabled()) {
            if (Build.VERSION.SDK_INT < 30) {
                o0();
                return;
            } else if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
                o0();
                return;
            } else {
                PermissionsHelper.showNeedsNewHelperFileWifiSSIDsDialog(getActivity(), getName(), new a());
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.wifi_currently_disabled);
        builder.setMessage(R.string.wifi_connection_must_enable).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.vb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                WifiSSIDTrigger.this.l0(dialogInterface, i4);
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.wb
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    public void setSSID(String str) {
        this.m_SSID = str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_SSID);
        parcel.writeInt(!this.m_InRange ? 1 : 0);
        parcel.writeStringList(this.m_SSIDList);
        parcel.writeList(this.wifiCellInfoList);
    }

    public WifiSSIDTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private WifiSSIDTrigger() {
        this.m_connectReceiver = new b();
        init();
    }

    private WifiSSIDTrigger(Parcel parcel) {
        super(parcel);
        this.m_connectReceiver = new b();
        init();
        this.m_SSIDList = new ArrayList();
        this.wifiCellInfoList = new ArrayList();
        this.m_SSID = parcel.readString();
        this.m_InRange = parcel.readInt() == 0;
        parcel.readStringList(this.m_SSIDList);
        parcel.readArrayList(WifiCellInfo.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14474a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14475b;

        c(Button button, EditText editText) {
            this.f14474a = button;
            this.f14475b = editText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f14474a;
            if (this.f14475b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
