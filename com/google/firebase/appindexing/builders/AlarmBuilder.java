package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.action.PauseAction;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class AlarmBuilder extends IndexableBuilder<AlarmBuilder> {
    @NonNull
    public static final String FRIDAY = "Friday";
    @NonNull
    public static final String MONDAY = "Monday";
    @NonNull
    public static final String SATURDAY = "Saturday";
    @NonNull
    public static final String SUNDAY = "Sunday";
    @NonNull
    public static final String THURSDAY = "Thursday";
    @NonNull
    public static final String TUESDAY = "Tuesday";
    @NonNull
    public static final String WEDNESDAY = "Wednesday";

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlarmBuilder() {
        super(PauseAction.USE_ALARM_EXTRA);
    }

    @NonNull
    public AlarmBuilder setAlarmInstances(@NonNull AlarmInstanceBuilder... alarmInstanceBuilderArr) {
        a("alarmInstances", alarmInstanceBuilderArr);
        return this;
    }

    @NonNull
    public AlarmBuilder setDayOfWeek(@NonNull String... strArr) {
        String str;
        for (String str2 : strArr) {
            if (!SUNDAY.equals(str2) && !MONDAY.equals(str2) && !TUESDAY.equals(str2) && !WEDNESDAY.equals(str2) && !THURSDAY.equals(str2) && !FRIDAY.equals(str2) && !SATURDAY.equals(str2)) {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() != 0) {
                    str = "Invalid weekday ".concat(valueOf);
                } else {
                    str = new String("Invalid weekday ");
                }
                throw new IllegalArgumentException(str);
            }
        }
        put("dayOfWeek", strArr);
        return this;
    }

    @NonNull
    public AlarmBuilder setEnabled(boolean z3) {
        put("enabled", z3);
        return this;
    }

    @NonNull
    public AlarmBuilder setHour(int i4) {
        if (i4 >= 0 && i4 <= 23) {
            put("hour", i4);
            return this;
        }
        throw new IllegalArgumentException("Invalid alarm hour");
    }

    @NonNull
    public AlarmBuilder setIdentifier(@NonNull String str) {
        put("identifier", str);
        return this;
    }

    @NonNull
    public AlarmBuilder setMessage(@NonNull String str) {
        put("message", str);
        return this;
    }

    @NonNull
    public AlarmBuilder setMinute(int i4) {
        if (i4 >= 0 && i4 <= 59) {
            put("minute", i4);
            return this;
        }
        throw new IllegalArgumentException("Invalid alarm minute");
    }

    @NonNull
    public AlarmBuilder setRingtone(@NonNull String str) {
        put("ringtone", str);
        return this;
    }

    @NonNull
    public AlarmBuilder setVibrate(boolean z3) {
        put("vibrate", z3);
        return this;
    }
}
