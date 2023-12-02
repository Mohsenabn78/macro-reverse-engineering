package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.activities.DayOfMonthConfigureActivity;
import com.arlosoft.macrodroid.triggers.activities.DayOfWeekConfigureActivity;
import com.arlosoft.macrodroid.triggers.info.DayTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.DayTriggerReceiver;
import com.arlosoft.macrodroid.utils.DateTimeUtils;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: classes3.dex */
public class DayTrigger extends Trigger {
    public static final Parcelable.Creator<DayTrigger> CREATOR = new a();
    private static final String EXTRA_ALARM_ID = "alarmId";
    private static final int ID_SET_DAY_OF_MONTH = 2;
    private static final int ID_SET_DAY_OF_WEEK = 1;
    public static final int OPTION_DAY_OF_MONTH = 1;
    public static final int OPTION_DAY_OF_WEEK = 0;
    private static int s_uniqueId = 20000;
    private String m_alarmId;
    private transient int m_alarmTrackerId;
    private int m_dayOfMonth;
    private int m_dayOfWeek;
    private int m_hour;
    private int m_minute;
    private int m_monthOfYear;
    private int m_option;
    private transient PendingIntent m_pendingIntent;
    private final transient b m_timeChangedReceiver;
    private boolean m_useAlarm;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DayTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DayTrigger createFromParcel(Parcel parcel) {
            return new DayTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DayTrigger[] newArray(int i4) {
            return new DayTrigger[i4];
        }
    }

    /* loaded from: classes3.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DayTrigger dayTrigger = DayTrigger.this;
            if (dayTrigger.f14431b && Util.timeZoneChanged(dayTrigger.getContext())) {
                SystemLog.logVerbose("Day of Week/Month Trigger: Time zone change detected (" + TimeZone.getDefault().getID() + ") - Rescheduling");
                DayTrigger.this.disableTriggerThreadSafe();
                DayTrigger.this.enableTriggerThreadSafe();
            }
        }

        /* synthetic */ b(DayTrigger dayTrigger, a aVar) {
            this();
        }
    }

    /* synthetic */ DayTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void M(Context context, long j4, String str) {
        try {
            if (this.m_pendingIntent != null) {
                ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.m_pendingIntent);
                this.m_pendingIntent = null;
            }
        } catch (Exception unused) {
        }
        SystemLog.logVerbose(getMacro().getName() + " - Scheduling next wakeup for " + ((j4 - System.currentTimeMillis()) / 1000) + "s", getMacroGuid().longValue());
        Intent intent = new Intent(context, DayTriggerReceiver.class);
        intent.putExtra("alarmId", str);
        this.m_pendingIntent = PendingIntent.getBroadcast(getContext(), this.m_alarmTrackerId, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        AlarmHelper.scheduleExactRTCWithAlarmOption(this.m_useAlarm, j4, this.m_pendingIntent);
    }

    private String[] getOptions() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.trigger_day_of_week), MacroDroidApplication.getInstance().getString(R.string.trigger_day_of_month)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        getContext().unregisterReceiver(this.m_timeChangedReceiver);
        ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.m_pendingIntent);
        this.m_pendingIntent = null;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        this.m_alarmId = UUID.randomUUID().toString();
        int i4 = s_uniqueId;
        s_uniqueId = i4 + 1;
        this.m_alarmTrackerId = i4;
        getContext().registerReceiver(this.m_timeChangedReceiver, new IntentFilter("android.intent.action.TIME_SET"));
        scheduleNextAlarm(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_option == 0) {
            return SelectableItem.r(R.string.trigger_day_of_week);
        }
        return SelectableItem.r(R.string.trigger_day_of_month);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        if (this.m_option == 0) {
            return DateTimeUtils.getFullDayName(this.m_dayOfWeek) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + String.format("%02d", Integer.valueOf(this.m_hour)) + ":" + String.format("%02d", Integer.valueOf(this.m_minute));
        }
        if (this.m_monthOfYear == 0) {
            str = SelectableItem.r(R.string.every_month);
        } else {
            str = DateTimeUtils.getMonthNames()[this.m_monthOfYear - 1];
        }
        return this.m_dayOfMonth + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str + " (" + String.format("%02d", Integer.valueOf(this.m_hour)) + ":" + String.format("%02d", Integer.valueOf(this.m_minute)) + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return DayTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getExtendedDetail();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new String[0];
        }
        return super.getPermissions();
    }

    public String getRequestId() {
        return this.m_alarmId;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == 1 && i5 == -1) {
            this.m_hour = intent.getIntExtra(Constants.EXTRA_HOUR, 0);
            this.m_minute = intent.getIntExtra(Constants.EXTRA_MINUTE, 0);
            this.m_dayOfWeek = intent.getIntExtra(Constants.EXTRA_DAY_OF_WEEK, 0);
            this.m_useAlarm = intent.getBooleanExtra(Constants.EXTRA_USE_ALARM, this.m_useAlarm);
            itemComplete();
        }
        if (i4 == 2 && i5 == -1) {
            this.m_hour = intent.getIntExtra(Constants.EXTRA_HOUR, 0);
            this.m_minute = intent.getIntExtra(Constants.EXTRA_MINUTE, 0);
            this.m_dayOfMonth = intent.getIntExtra(Constants.EXTRA_DAY_OF_MONTH, 0);
            this.m_monthOfYear = intent.getIntExtra(Constants.EXTRA_MONTH_OF_YEAR, 0);
            this.m_useAlarm = intent.getBooleanExtra(Constants.EXTRA_USE_ALARM, this.m_useAlarm);
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    public void scheduleNextAlarm(boolean z3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        int i4 = calendar.get(11);
        int i5 = calendar.get(12);
        int i6 = calendar.get(13);
        int i7 = this.m_option;
        if (i7 == 0) {
            int i8 = (calendar.get(7) - 2) % 7;
            calendar2.add(11, this.m_hour - i4);
            calendar2.add(12, this.m_minute - i5);
            calendar2.set(13, 0);
            int i9 = this.m_dayOfWeek;
            if (i8 != i9) {
                calendar2.add(6, (i9 - i8) % 7);
            }
            if (!z3) {
                calendar.add(10, 1);
            }
            if (calendar2.before(calendar)) {
                calendar2.add(7, 7);
            }
        } else if (i7 == 1) {
            int i10 = calendar.get(5);
            int i11 = calendar.get(2) + 1;
            calendar2.set(11, this.m_hour);
            calendar2.set(12, this.m_minute);
            calendar2.set(13, 0);
            calendar2.set(5, this.m_dayOfMonth);
            int i12 = this.m_monthOfYear;
            if (i12 == 0) {
                calendar2.set(2, calendar.get(2));
                int i13 = this.m_dayOfMonth;
                if (i10 > i13 || ((i10 == i13 && i4 > this.m_hour) || ((i10 == i13 && i4 == this.m_hour && i5 >= this.m_minute) || (i10 == i13 && i4 == this.m_hour && i5 == this.m_minute && i6 > 0)))) {
                    calendar2.add(2, 1);
                }
            } else {
                calendar2.set(2, i12 - 1);
                calendar2.set(1, calendar.get(1));
                int i14 = this.m_monthOfYear;
                if (i11 > i14 || ((i11 == i14 && i10 > this.m_dayOfMonth) || ((i11 == i14 && i10 == this.m_dayOfMonth && i4 > this.m_hour) || ((i11 == i14 && i10 == this.m_dayOfMonth && i4 == this.m_hour && i5 >= this.m_minute) || (i11 == i14 && i10 == this.m_dayOfMonth && i4 == this.m_hour && i5 == this.m_minute && i6 > 0))))) {
                    calendar2.add(1, 1);
                }
            }
        }
        M(getContext(), calendar2.getTimeInMillis(), this.m_alarmId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Activity activity = getActivity();
        if (this.m_option == 0) {
            Intent intent = new Intent(activity, DayOfWeekConfigureActivity.class);
            intent.putExtra(Constants.EXTRA_DAY_OF_WEEK, this.m_dayOfWeek);
            intent.putExtra(Constants.EXTRA_HOUR, this.m_hour);
            intent.putExtra(Constants.EXTRA_MINUTE, this.m_minute);
            intent.putExtra(Constants.EXTRA_USE_ALARM, this.m_useAlarm);
            activity.startActivityForResult(intent, 1);
            return;
        }
        Intent intent2 = new Intent(activity, DayOfMonthConfigureActivity.class);
        intent2.putExtra(Constants.EXTRA_DAY_OF_MONTH, this.m_dayOfMonth);
        intent2.putExtra(Constants.EXTRA_MONTH_OF_YEAR, this.m_monthOfYear);
        intent2.putExtra(Constants.EXTRA_HOUR, this.m_hour);
        intent2.putExtra(Constants.EXTRA_MINUTE, this.m_minute);
        intent2.putExtra(Constants.EXTRA_USE_ALARM, this.m_useAlarm);
        activity.startActivityForResult(intent2, 2);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.m_hour);
        parcel.writeInt(this.m_minute);
        parcel.writeInt(this.m_dayOfWeek);
        parcel.writeInt(this.m_dayOfMonth);
        parcel.writeInt(this.m_monthOfYear);
        parcel.writeInt(this.m_useAlarm ? 1 : 0);
    }

    public DayTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private DayTrigger() {
        this.m_timeChangedReceiver = new b(this, null);
        this.m_useAlarm = true;
    }

    private DayTrigger(Parcel parcel) {
        super(parcel);
        this.m_timeChangedReceiver = new b(this, null);
        this.m_useAlarm = true;
        this.m_option = parcel.readInt();
        this.m_hour = parcel.readInt();
        this.m_minute = parcel.readInt();
        this.m_dayOfWeek = parcel.readInt();
        this.m_dayOfMonth = parcel.readInt();
        this.m_monthOfYear = parcel.readInt();
        this.m_useAlarm = parcel.readInt() != 0;
    }
}
