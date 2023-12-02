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
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.activities.TimerTriggerConfigureActivity;
import com.arlosoft.macrodroid.triggers.info.TimerTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.AlarmReceiver;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.UUID;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class TimerTrigger extends Trigger {
    public static final Parcelable.Creator<TimerTrigger> CREATOR = new a();
    public static final String DAYS_OF_WEEK_EXTRA = "DaysOfWeek";
    public static final String EXTRA_ALARM_ID = "alarmId";
    private static final String EXTRA_COUNT = "count";
    public static final String EXTRA_TRIGGER_TIME = "trigger_time";
    private static final int SET_TIME = 8765;
    private static b s_timeChangedReceiver = null;
    private static int s_triggerCounter = 0;
    private static int s_uniqueId = 657443637;
    private String m_alarmId;
    private boolean[] m_daysOfWeek;
    private int m_hour;
    private int m_minute;
    private transient PendingIntent m_pendingIntent;
    private int m_second;
    private boolean m_useAlarm;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<TimerTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimerTrigger createFromParcel(Parcel parcel) {
            return new TimerTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TimerTrigger[] newArray(int i4) {
            return new TimerTrigger[i4];
        }
    }

    /* loaded from: classes3.dex */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Util.timeZoneChanged(context)) {
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerList().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof TimerTrigger) && next.f14431b) {
                            SystemLog.logVerbose("Day/Time Trigger: Time zone change detected (" + TimeZone.getDefault().getID() + ") - Rescheduling", macro.getGUID());
                            next.disableTriggerThreadSafe();
                            next.enableTriggerThreadSafe();
                        }
                    }
                }
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* synthetic */ TimerTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void M(Context context, long j4, String str, int i4) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (this.m_pendingIntent != null) {
            Timber.d(this.m_classType, "Cancelling existing alarm: %s", this.m_alarmId);
            try {
                alarmManager.cancel(this.m_pendingIntent);
            } catch (Exception unused) {
            }
        }
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra(EXTRA_ALARM_ID, str);
        intent.putExtra(EXTRA_COUNT, i4);
        intent.putExtra(EXTRA_TRIGGER_TIME, j4);
        StringBuilder sb = new StringBuilder();
        sb.append("Scheduling alarm (");
        sb.append(str);
        sb.append("-");
        sb.append(i4);
        sb.append(") for: ");
        sb.append((j4 - Calendar.getInstance().getTimeInMillis()) / 1000);
        sb.append("s");
        if (getMacro() != null) {
            long timeInMillis = (j4 - Calendar.getInstance().getTimeInMillis()) / 1000;
            SystemLog.logVerbose("Day/Time Trigger - Schedule alarm (" + str + ") for: " + (timeInMillis / 3600) + "h " + ((timeInMillis / 60) % 60) + "m " + (timeInMillis % 60) + "s (totalSeconds = " + timeInMillis + ", epochtime = " + timeInMillis + ")", getMacroGuid().longValue());
        }
        Context context2 = getContext();
        int i5 = s_uniqueId;
        s_uniqueId = i5 + 1;
        PendingIntent broadcast = PendingIntent.getBroadcast(context2, i5, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        this.m_pendingIntent = broadcast;
        AlarmHelper.scheduleExactRTCWithAlarmOption(this.m_useAlarm, j4, broadcast);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0 && s_timeChangedReceiver != null) {
            try {
                getContext().unregisterReceiver(s_timeChangedReceiver);
                s_timeChangedReceiver = null;
            } catch (IllegalArgumentException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
        }
        this.f14431b = false;
        AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (this.m_pendingIntent != null) {
            Timber.d(this.m_classType, "Cancelling alarm: %s", this.m_alarmId);
            alarmManager.cancel(this.m_pendingIntent);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_timeChangedReceiver = new b(null);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            try {
                getContext().registerReceiver(s_timeChangedReceiver, intentFilter);
            } catch (IllegalArgumentException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
        }
        s_triggerCounter++;
        this.f14431b = true;
        this.m_alarmId = UUID.randomUUID().toString();
        scheduleNextAlarm(true);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        boolean z3;
        int i4 = 6;
        String[] strArr = {SelectableItem.r(R.string.monday3), SelectableItem.r(R.string.tuesday3), SelectableItem.r(R.string.wednesday3), SelectableItem.r(R.string.thursday3), SelectableItem.r(R.string.friday3), SelectableItem.r(R.string.saturday3), SelectableItem.r(R.string.sunday3)};
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", Integer.valueOf(this.m_hour)));
        sb.append(":");
        sb.append(String.format("%02d", Integer.valueOf(this.m_minute)));
        int i5 = this.m_second;
        if (i5 == 0) {
            str = "";
        } else {
            str = String.format(":%02d", Integer.valueOf(i5));
        }
        sb.append(str);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (true) {
            if (i6 < 7) {
                if (i7 == -1 && this.m_daysOfWeek[i6]) {
                    i7 = i6;
                }
                if (i7 != -1 && i8 == -1 && !this.m_daysOfWeek[i6]) {
                    i8 = i6 - 1;
                }
                if (i7 >= 0 && i8 >= 0 && this.m_daysOfWeek[i6]) {
                    z3 = false;
                    break;
                }
                i6++;
            } else {
                z3 = true;
                break;
            }
        }
        if (i8 != -1) {
            i4 = i8;
        }
        if (i7 == -1) {
            return "";
        }
        if (z3 && i4 - i7 > 1) {
            sb2.append(strArr[i7]);
            sb2.append(" - ");
            sb2.append(strArr[i4]);
        } else {
            int i9 = 0;
            while (true) {
                boolean[] zArr = this.m_daysOfWeek;
                if (i9 >= zArr.length) {
                    break;
                }
                if (zArr[i9]) {
                    sb2.append(strArr[i9]);
                    sb2.append(", ");
                }
                i9++;
            }
            sb2 = new StringBuilder(sb2.substring(0, sb2.length() - 2));
        }
        return sb2.toString();
    }

    public int getHour() {
        return this.m_hour;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return TimerTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String extendedDetail = getExtendedDetail();
        if (!TextUtils.isEmpty(extendedDetail)) {
            return extendedDetail;
        }
        return getName();
    }

    public int getMinute() {
        return this.m_minute;
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
        if (i4 == SET_TIME && i5 == -1) {
            this.m_hour = intent.getIntExtra(Constants.EXTRA_HOUR, 0);
            this.m_minute = intent.getIntExtra(Constants.EXTRA_MINUTE, 0);
            this.m_second = intent.getIntExtra(Constants.EXTRA_SECOND, 0);
            this.m_daysOfWeek = intent.getBooleanArrayExtra(DAYS_OF_WEEK_EXTRA);
            this.m_useAlarm = intent.getBooleanExtra(Constants.EXTRA_USE_ALARM, false);
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, TimerTriggerConfigureActivity.class);
        intent.putExtra(DAYS_OF_WEEK_EXTRA, this.m_daysOfWeek);
        intent.putExtra(Constants.EXTRA_HOUR, this.m_hour);
        intent.putExtra(Constants.EXTRA_MINUTE, this.m_minute);
        intent.putExtra(Constants.EXTRA_SECOND, this.m_second);
        intent.putExtra(Constants.EXTRA_USE_ALARM, this.m_useAlarm);
        activity.startActivityForResult(intent, SET_TIME);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    public void scheduleNextAlarm(boolean z3) {
        long j4 = Long.MAX_VALUE;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean[] zArr = this.m_daysOfWeek;
            if (i4 < zArr.length) {
                if (zArr[i4]) {
                    i5++;
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(13, 1);
                    Calendar calendar2 = Calendar.getInstance();
                    int i6 = (calendar.get(7) - 2) % 7;
                    int i7 = calendar.get(11);
                    int i8 = calendar.get(12);
                    calendar.get(13);
                    calendar2.add(11, this.m_hour - i7);
                    calendar2.add(12, this.m_minute - i8);
                    calendar2.set(13, 0);
                    calendar2.set(14, 0);
                    calendar2.add(13, this.m_second);
                    if (i6 != i4) {
                        calendar2.add(6, (i4 - i6) % 7);
                    }
                    if (!z3) {
                        calendar.add(10, 1);
                    }
                    if (calendar2.before(calendar)) {
                        calendar2.add(7, 7);
                    }
                    long timeInMillis = calendar2.getTimeInMillis();
                    if (timeInMillis < j4) {
                        j4 = timeInMillis;
                    }
                }
                i4++;
            } else {
                M(getContext(), j4, this.m_alarmId, i5);
                return;
            }
        }
    }

    public void setDaysOfWeek(boolean[] zArr) {
        this.m_daysOfWeek = zArr;
    }

    public void setHour(int i4) {
        this.m_hour = i4;
    }

    public void setMinute(int i4) {
        this.m_minute = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_hour);
        parcel.writeInt(this.m_minute);
        parcel.writeInt(this.m_second);
        parcel.writeBooleanArray(this.m_daysOfWeek);
        parcel.writeInt(this.m_useAlarm ? 1 : 0);
    }

    public TimerTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public TimerTrigger() {
        this.m_daysOfWeek = new boolean[7];
        this.m_useAlarm = true;
    }

    private TimerTrigger(Parcel parcel) {
        super(parcel);
        this.m_daysOfWeek = new boolean[7];
        this.m_useAlarm = true;
        this.m_hour = parcel.readInt();
        this.m_minute = parcel.readInt();
        this.m_second = parcel.readInt();
        parcel.readBooleanArray(this.m_daysOfWeek);
        this.m_useAlarm = parcel.readInt() != 0;
    }
}
