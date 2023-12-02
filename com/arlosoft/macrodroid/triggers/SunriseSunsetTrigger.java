package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.activities.LocationChooserActivity;
import com.arlosoft.macrodroid.triggers.info.SunriseSunsetTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.SunsetSunriseReceiver;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.luckycatlabs.sunrisesunset.dto.Location;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimeZone;
import me.drakeet.support.toast.ToastCompat;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public class SunriseSunsetTrigger extends Trigger {
    public static final Parcelable.Creator<SunriseSunsetTrigger> CREATOR = new b();
    public static final int OPTION_SUNRISE = 0;
    public static final int OPTION_SUNSET = 1;
    private static final int SET_LOCATION = 1;
    private static int alarmIdSunsetSunrise = 325935;
    private static c s_timeChangedReceiver;
    private static int s_triggerCounter;
    private transient long lastTriggered;
    private int m_option;
    private transient PendingIntent pendingIntent;
    private int timeAdjustSeconds;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<SunriseSunsetTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SunriseSunsetTrigger createFromParcel(Parcel parcel) {
            return new SunriseSunsetTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SunriseSunsetTrigger[] newArray(int i4) {
            return new SunriseSunsetTrigger[i4];
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Util.timeZoneChanged(context)) {
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerList().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof SunriseSunsetTrigger) && next.f14431b) {
                            SystemLog.logVerbose("Sunrise/Sunset Trigger: Time zone change detected (" + TimeZone.getDefault().getID() + ") - Rescheduling", macro.getGUID());
                            next.disableTriggerThreadSafe();
                            next.enableTriggerThreadSafe();
                        }
                    }
                }
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* synthetic */ SunriseSunsetTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(Activity activity, DialogInterface dialogInterface, int i4) {
        try {
            Intent intent = new Intent(activity, LocationChooserActivity.class);
            intent.putExtra("title", SelectableItem.r(R.string.sunrise_sunset_location));
            activity.startActivityForResult(intent, 1);
        } catch (NoClassDefFoundError unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) getContext().getString(R.string.toast_broken_map_activity), 0).show();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(AppCompatDialog appCompatDialog, Spinner spinner, NumberPicker numberPicker, NumberPicker numberPicker2, View view) {
        appCompatDialog.dismiss();
        if (spinner.getSelectedItemPosition() == 0) {
            this.timeAdjustSeconds = 0;
        } else if (spinner.getSelectedItemPosition() == 1) {
            this.timeAdjustSeconds = -((numberPicker.getValue() * 60) + (numberPicker2.getValue() * 3600));
        } else {
            this.timeAdjustSeconds = (numberPicker.getValue() * 60) + (numberPicker2.getValue() * 3600);
        }
        if (Settings.getSunriseSunsetLatLon(getContext()).length() == 0) {
            S(getActivity());
        } else {
            super.itemComplete();
        }
    }

    private void S(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(R.string.trigger_weather_set_location);
        builder.setMessage(R.string.trigger_sunrise_sunset_location_set_message).setCancelable(true).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.e8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SunriseSunsetTrigger.this.P(activity, dialogInterface, i4);
            }
        });
        builder.show();
    }

    private void T() {
        int i4;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_sunrise_time_adjust);
        appCompatDialog.setTitle(getContext().getString(R.string.select_option));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.entry_option);
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.minute_picker);
        TableLayout tableLayout = (TableLayout) appCompatDialog.findViewById(R.id.time_selection_table);
        int i5 = 0;
        numberPicker.setMinimum(0);
        numberPicker.setMaximum(59);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.hour_picker);
        numberPicker2.setMinimum(0);
        numberPicker2.setMaximum(23);
        numberPicker2.setValue(Math.abs(this.timeAdjustSeconds) / 3600);
        numberPicker.setValue((Math.abs(this.timeAdjustSeconds) / 60) % 60);
        if (this.timeAdjustSeconds == 0) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        tableLayout.setVisibility(i4);
        int i6 = this.timeAdjustSeconds;
        if (i6 < 0) {
            i5 = 1;
        } else if (i6 > 0) {
            i5 = 2;
        }
        spinner.setSelection(i5);
        spinner.setOnItemSelectedListener(new a(tableLayout));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.c8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SunriseSunsetTrigger.this.Q(appCompatDialog, spinner, numberPicker, numberPicker2, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.d8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_sunrise_sunset_option_sunrise), SelectableItem.r(R.string.trigger_sunrise_sunset_option_sunset)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
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
        try {
            ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.pendingIntent);
            this.pendingIntent = null;
        } catch (Exception unused) {
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        scheduleWakeup(getContext());
        if (s_triggerCounter == 0) {
            s_timeChangedReceiver = new c(null);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            try {
                getContext().registerReceiver(s_timeChangedReceiver, intentFilter);
            } catch (IllegalArgumentException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        String str2;
        String str3;
        int i4 = this.timeAdjustSeconds;
        String str4 = "";
        if (i4 == 0) {
            return "";
        }
        int abs = Math.abs(i4) / 3600;
        int abs2 = (Math.abs(this.timeAdjustSeconds) / 60) % 60;
        StringBuilder sb = new StringBuilder();
        if (abs <= 0) {
            str = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(abs);
            sb2.append(SelectableItem.r(R.string.hour_one_char));
            if (abs2 <= 0) {
                str3 = "";
            } else {
                str3 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            sb2.append(str3);
            str = sb2.toString();
        }
        sb.append(str);
        if (abs2 > 0) {
            str4 = abs2 + SelectableItem.r(R.string.minute_one_char);
        }
        sb.append(str4);
        String sb3 = sb.toString();
        StringBuilder sb4 = new StringBuilder();
        if (this.timeAdjustSeconds < 0) {
            str2 = "-";
        } else {
            str2 = Marker.ANY_NON_NULL_MARKER;
        }
        sb4.append(str2);
        sb4.append(sb3);
        return sb4.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SunriseSunsetTriggerInfo.getInstance();
    }

    public long getLastTriggered() {
        return this.lastTriggered;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        String str;
        String extendedDetail = getExtendedDetail();
        StringBuilder sb = new StringBuilder();
        sb.append(getConfiguredName());
        if (TextUtils.isEmpty(extendedDetail)) {
            str = "";
        } else {
            str = " (" + extendedDetail + ")";
        }
        sb.append(str);
        return sb.toString();
    }

    public int getOption() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == 1 && i5 == -1) {
            double doubleExtra = intent.getDoubleExtra(LocationTrigger.LATITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double doubleExtra2 = intent.getDoubleExtra(LocationTrigger.LONGITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            Context context = getContext();
            Settings.setSunriseSunsetLatLon(context, doubleExtra + "," + doubleExtra2);
            super.itemComplete();
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

    public void scheduleWakeup(Context context) {
        long timeInMillis;
        int i4;
        String sunriseSunsetLatLon = Settings.getSunriseSunsetLatLon(context);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = this.pendingIntent;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
            this.pendingIntent = null;
        }
        if (TextUtils.isEmpty(sunriseSunsetLatLon)) {
            SystemLog.logError("Failed to schedule sunrise/sunset - no location set", getMacroGuid().longValue());
            return;
        }
        String[] split = sunriseSunsetLatLon.split(",");
        SunriseSunsetCalculator sunriseSunsetCalculator = new SunriseSunsetCalculator(new Location(Double.valueOf(split[0]).doubleValue(), Double.valueOf(split[1]).doubleValue()), TimeZone.getDefault());
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        calendar2.add(5, 1);
        calendar3.add(5, 2);
        long currentTimeMillis = System.currentTimeMillis();
        Calendar officialSunsetCalendarForDate = sunriseSunsetCalculator.getOfficialSunsetCalendarForDate(calendar);
        long j4 = currentTimeMillis + 90000;
        if (j4 > officialSunsetCalendarForDate.getTimeInMillis() + (this.timeAdjustSeconds * 1000)) {
            officialSunsetCalendarForDate = sunriseSunsetCalculator.getOfficialSunsetCalendarForDate(calendar2);
            if (j4 > officialSunsetCalendarForDate.getTimeInMillis() + (this.timeAdjustSeconds * 1000)) {
                officialSunsetCalendarForDate = sunriseSunsetCalculator.getOfficialSunsetCalendarForDate(calendar3);
            }
        }
        Calendar officialSunriseCalendarForDate = sunriseSunsetCalculator.getOfficialSunriseCalendarForDate(calendar);
        if (j4 > officialSunriseCalendarForDate.getTimeInMillis() + (this.timeAdjustSeconds * 1000)) {
            officialSunriseCalendarForDate = sunriseSunsetCalculator.getOfficialSunriseCalendarForDate(calendar2);
            if (j4 > officialSunriseCalendarForDate.getTimeInMillis() + (this.timeAdjustSeconds * 1000)) {
                officialSunriseCalendarForDate = sunriseSunsetCalculator.getOfficialSunriseCalendarForDate(calendar3);
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        SystemLog.logVerbose("Next SUNRISE / SUNSET: " + simpleDateFormat.format(officialSunriseCalendarForDate.getTime()) + " / " + simpleDateFormat.format(officialSunsetCalendarForDate.getTime()), getMacroGuid().longValue());
        Intent intent = new Intent(getContext(), SunsetSunriseReceiver.class);
        intent.putExtra(SunsetSunriseReceiver.EXTRA_TRIGGER_GUID, getSIGUID());
        if (this.m_option == 0) {
            intent.putExtra(SunsetSunriseReceiver.EXTRA_IS_SUNRISE, true);
            timeInMillis = officialSunriseCalendarForDate.getTimeInMillis();
            i4 = this.timeAdjustSeconds;
        } else {
            intent.putExtra(SunsetSunriseReceiver.EXTRA_IS_SUNRISE, false);
            timeInMillis = officialSunsetCalendarForDate.getTimeInMillis();
            i4 = this.timeAdjustSeconds;
        }
        long j5 = timeInMillis + (i4 * 1000);
        if (getMacro() != null) {
            SystemLog.logVerbose("Scheduling trigger wakeup for: " + simpleDateFormat.format(Long.valueOf(j5)) + " (" + ((j5 - Calendar.getInstance().getTimeInMillis()) / 1000) + "s) Macro = " + getMacro().getName(), getMacroGuid().longValue());
        }
        Context context2 = getContext();
        int i5 = alarmIdSunsetSunrise;
        alarmIdSunsetSunrise = i5 + 1;
        PendingIntent broadcast = PendingIntent.getBroadcast(context2, i5, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        this.pendingIntent = broadcast;
        AlarmHelper.scheduleExactAlarmWithInexactFallback(0, j5, broadcast, true);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        T();
    }

    public void setLastTriggered(long j4) {
        this.lastTriggered = j4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.timeAdjustSeconds);
    }

    public SunriseSunsetTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SunriseSunsetTrigger() {
        this.m_option = 0;
    }

    private SunriseSunsetTrigger(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.timeAdjustSeconds = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TableLayout f14427a;

        a(TableLayout tableLayout) {
            this.f14427a = tableLayout;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int i5;
            TableLayout tableLayout = this.f14427a;
            if (i4 == 0) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            tableLayout.setVisibility(i5);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
