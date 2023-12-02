package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.activities.RegularIntervalTriggerConfigureActivity;
import com.arlosoft.macrodroid.triggers.info.RegularIntervalTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.IntervalAlarmReceiver;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Date;

/* loaded from: classes3.dex */
public class RegularIntervalTrigger extends Trigger {
    public static final Parcelable.Creator<RegularIntervalTrigger> CREATOR = new a();
    public static final String IGNORE_START_TIME = "IgnoreStartTime";
    public static final String SECONDS_EXTRA = "Seconds";
    private static final int SET_INTERVAL = 1024;
    public static final String START_HOUR_EXTRA = "StartHour";
    public static final String START_MINUTE_EXTRA = "StartMinute";
    private static int s_alarmCounter;
    private transient int m_alarmId;
    private boolean m_ignoreReferenceStartTime;
    private int m_minutes;
    private transient PendingIntent m_pendingIntent;
    private int m_seconds;
    private int m_startHour;
    private int m_startMinute;
    private boolean m_useAlarm;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<RegularIntervalTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RegularIntervalTrigger createFromParcel(Parcel parcel) {
            return new RegularIntervalTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RegularIntervalTrigger[] newArray(int i4) {
            return new RegularIntervalTrigger[i4];
        }
    }

    /* synthetic */ RegularIntervalTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private long M() {
        long j4 = this.m_seconds * 1000;
        if (!this.m_ignoreReferenceStartTime) {
            Date date = new Date();
            long hours = ((((this.m_startHour * 60) * 60) + (this.m_startMinute * 60)) - ((((date.getHours() * 60) * 60) + (date.getMinutes() * 60)) + date.getSeconds())) % 86400;
            if (hours <= 0) {
                hours += 86400;
            }
            if (this.m_seconds == 0) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("RegularIntervalTrigger (enableTrigger) has a zero seconds value!"));
            }
            int i4 = this.m_seconds;
            if (hours > i4) {
                hours = Math.abs(i4 - ((86400 - hours) % i4));
            }
            return hours * 1000;
        }
        return j4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        String str;
        try {
            ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.m_pendingIntent);
            StringBuilder sb = new StringBuilder();
            sb.append("Cancelled ");
            if (this.m_useAlarm) {
                str = "alarm clock";
            } else {
                str = "regular interval";
            }
            sb.append(str);
            sb.append(" for id: ");
            sb.append(this.m_alarmId);
            SystemLog.logDebug(sb.toString(), getMacroGuid().longValue());
        } catch (Exception unused) {
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        int i4 = this.m_minutes;
        if (i4 != 0) {
            this.m_seconds = i4 * 60;
        }
        if (this.m_seconds == 0) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("RegularIntervalTrigger seconds value is zero"));
            return;
        }
        long M = M();
        int i5 = s_alarmCounter;
        s_alarmCounter = i5 + 1;
        this.m_alarmId = i5;
        Intent intent = new Intent(getContext(), IntervalAlarmReceiver.class);
        intent.putExtra(TimerTrigger.EXTRA_ALARM_ID, this.m_alarmId);
        this.m_pendingIntent = PendingIntent.getBroadcast(getContext(), this.m_alarmId, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        scheduleAlarm(getContext(), M);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        int i4 = this.m_seconds;
        return SelectableItem.r(R.string.trigger_regular_interval_text) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + String.format("%02d", Integer.valueOf(i4 / 3600)) + ":" + String.format("%02d", Integer.valueOf((i4 / 60) % 60)) + ":" + String.format("%02d", Integer.valueOf(i4 % 60));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return RegularIntervalTriggerInfo.getInstance();
    }

    public int getIntervalInSeconds() {
        return this.m_seconds;
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

    public int getRequestId() {
        return this.m_alarmId;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == 1024 && i5 == -1) {
            int intExtra = intent.getIntExtra("Seconds", 0);
            this.m_seconds = intExtra;
            this.m_minutes = 0;
            if (intExtra == 0) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("RegularIntervalTrigger (handleActivityResult) has a zero minutes value!"));
            }
            int intExtra2 = intent.getIntExtra(START_MINUTE_EXTRA, this.m_startMinute);
            this.m_startHour = intExtra2;
            this.m_startMinute = intent.getIntExtra(START_HOUR_EXTRA, intExtra2);
            this.m_ignoreReferenceStartTime = intent.getBooleanExtra(IGNORE_START_TIME, false);
            this.m_useAlarm = intent.getBooleanExtra(Constants.EXTRA_USE_ALARM, this.m_useAlarm);
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, RegularIntervalTriggerConfigureActivity.class);
        int i4 = this.m_minutes;
        if (i4 != 0) {
            this.m_seconds = i4 * 60;
        }
        intent.putExtra("Seconds", this.m_seconds);
        intent.putExtra(START_MINUTE_EXTRA, this.m_startMinute);
        intent.putExtra(START_HOUR_EXTRA, this.m_startHour);
        intent.putExtra(IGNORE_START_TIME, this.m_ignoreReferenceStartTime);
        intent.putExtra(Constants.EXTRA_USE_ALARM, this.m_useAlarm);
        activity.startActivityForResult(intent, 1024);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (this.m_seconds != 0) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    public void scheduleAlarm(Context context, long j4) {
        if (this.f14431b && this.m_pendingIntent != null) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            long M = M();
            SystemLog.logDebug("Wake up (" + this.m_alarmId + ") scheduled for: " + (j4 / 1000) + "s", getMacroGuid().longValue());
            AlarmHelper.scheduleExactRTCWithAlarmOption(this.m_useAlarm, System.currentTimeMillis() + M, this.m_pendingIntent);
        }
    }

    public void setSeconds(int i4) {
        this.m_seconds = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_minutes);
        parcel.writeInt(this.m_startMinute);
        parcel.writeInt(this.m_startHour);
        parcel.writeInt(this.m_seconds);
        parcel.writeInt(!this.m_ignoreReferenceStartTime ? 1 : 0);
        parcel.writeInt(this.m_useAlarm ? 1 : 0);
    }

    public RegularIntervalTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public RegularIntervalTrigger() {
        this.m_useAlarm = true;
        this.m_startHour = 0;
        this.m_startMinute = 0;
        this.m_ignoreReferenceStartTime = false;
    }

    private RegularIntervalTrigger(Parcel parcel) {
        super(parcel);
        this.m_minutes = parcel.readInt();
        this.m_startMinute = parcel.readInt();
        this.m_startHour = parcel.readInt();
        this.m_seconds = parcel.readInt();
        this.m_ignoreReferenceStartTime = parcel.readInt() == 0;
        this.m_useAlarm = parcel.readInt() != 0;
    }
}
