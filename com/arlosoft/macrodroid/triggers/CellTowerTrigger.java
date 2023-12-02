package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.celltowers.CellTowerListActivity;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.CellTowerGroup;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.CellTowerTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.CellLocationChangeReceiver;
import com.arlosoft.macrodroid.triggers.receivers.CheckCellCoverageReceiver;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CellTowerTrigger extends Trigger {
    public static final Parcelable.Creator<CellTowerTrigger> CREATOR = new a();
    private static final int REQUEST_CODE_CELL_TOWER_LIST = 63475623;
    private static CellLocationChangeReceiver s_cellLocationTriggerReceiver;
    private static PendingIntent s_pendingIntent;
    private static int s_triggerCounter;
    private static b s_updateRateReceiver;
    private String m_cellGroupName;
    private ArrayList<String> m_cellIds;
    private boolean m_inRange;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<CellTowerTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CellTowerTrigger createFromParcel(Parcel parcel) {
            return new CellTowerTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CellTowerTrigger[] newArray(int i4) {
            return new CellTowerTrigger[i4];
        }
    }

    /* loaded from: classes3.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CellTowerTrigger.scheduleNextAlarm(CellTowerTrigger.this.getContext());
        }

        /* synthetic */ b(CellTowerTrigger cellTowerTrigger, a aVar) {
            this();
        }
    }

    /* synthetic */ CellTowerTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        try {
            ((TelephonyManager) getContext().getSystemService("phone")).listen(s_cellLocationTriggerReceiver, 0);
        } catch (SecurityException unused) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.trigger_cell_tower), true, false);
            SystemLog.logError(getConfiguredName() + " requires permission", getMacroGuid().longValue());
        }
        s_cellLocationTriggerReceiver = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        s_cellLocationTriggerReceiver = new CellLocationChangeReceiver();
        try {
            ((TelephonyManager) getContext().getSystemService("phone")).listen(s_cellLocationTriggerReceiver, 16);
        } catch (SecurityException unused) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.trigger_cell_tower), true, false);
            SystemLog.logError(getConfiguredName() + " requires permission", getMacroGuid().longValue());
        }
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_cell_tower_in_range), MacroDroidApplication.getInstance().getString(R.string.trigger_cell_tower_out_of_range)};
    }

    public static void scheduleNextAlarm(Context context) {
        int cellTowerUpdateRate = Settings.getCellTowerUpdateRate(context) * 60;
        if (cellTowerUpdateRate == 0) {
            cellTowerUpdateRate = 30;
        }
        long currentTimeMillis = System.currentTimeMillis() + (cellTowerUpdateRate * 1000);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = s_pendingIntent;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
        } else {
            s_pendingIntent = PendingIntent.getBroadcast(context, 0, new Intent(context, CheckCellCoverageReceiver.class), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        }
        SystemLog.logDebug("+++ Scheduling cell tower check in: " + ((currentTimeMillis - System.currentTimeMillis()) / 1000) + "s");
        AlarmHelper.scheduleExactRTCWithAlarmOption(Settings.getCellTowerUseAlarm(context), currentTimeMillis, s_pendingIntent);
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
        this.m_inRange = z3;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.g2
                @Override // java.lang.Runnable
                public final void run() {
                    CellTowerTrigger.this.O();
                }
            });
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
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            scheduleNextAlarm(getContext());
            IntentFilter intentFilter = new IntentFilter(Util.CELL_TOWER_UPDATE_RATE_INTENT);
            s_updateRateReceiver = new b(this, null);
            getContext().registerReceiver(s_updateRateReceiver, intentFilter);
            new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.f2
                @Override // java.lang.Runnable
                public final void run() {
                    CellTowerTrigger.this.P();
                }
            });
        }
        s_triggerCounter++;
    }

    public String getCellGroupName() {
        return this.m_cellGroupName;
    }

    public List<String> getCellIds() {
        return this.m_cellIds;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.m_inRange ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_inRange) {
            return getOptions()[0];
        }
        return getOptions()[1];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_cellGroupName;
    }

    public boolean getInRange() {
        return this.m_inRange;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return CellTowerTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        if (i4 == REQUEST_CODE_CELL_TOWER_LIST && i5 == -1) {
            this.m_cellGroupName = intent.getStringExtra("CellTowerGroupName");
            this.m_cellIds = intent.getStringArrayListExtra(CellTowerListActivity.EXTRA_CELL_TOWER_LIST);
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    public void replaceLegacyIds() {
        if (this.m_cellIds != null) {
            for (int i4 = 0; i4 < this.m_cellIds.size(); i4++) {
                ArrayList<String> arrayList = this.m_cellIds;
                arrayList.set(i4, CellTowerGroup.convertLegacyCellTowerId(arrayList.get(i4)));
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLocationServicesEnabled() {
        if (Build.VERSION.SDK_INT > 26) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, CellTowerListActivity.class);
        intent.putExtra("ThemeType", 1);
        activity.startActivityForResult(intent, REQUEST_CODE_CELL_TOWER_LIST);
    }

    public void setCellGroupName(String str) {
        this.m_cellGroupName = str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_inRange ? 1 : 0);
        parcel.writeString(this.m_cellGroupName);
        parcel.writeStringList(this.m_cellIds);
    }

    public CellTowerTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private CellTowerTrigger() {
        this.m_inRange = true;
        this.m_cellIds = new ArrayList<>();
    }

    private CellTowerTrigger(Parcel parcel) {
        super(parcel);
        this.m_inRange = parcel.readInt() != 0;
        this.m_cellGroupName = parcel.readString();
        ArrayList<String> arrayList = new ArrayList<>();
        this.m_cellIds = arrayList;
        parcel.readStringList(arrayList);
    }
}
