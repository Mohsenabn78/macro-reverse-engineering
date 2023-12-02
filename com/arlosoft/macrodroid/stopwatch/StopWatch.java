package com.arlosoft.macrodroid.stopwatch;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.StopwatchTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class StopWatch {
    private static void a(@NonNull String str) {
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof StopwatchTrigger) {
                    StopwatchTrigger stopwatchTrigger = (StopwatchTrigger) next;
                    if (str.equals(stopwatchTrigger.getStopwatchName())) {
                        stopwatchTrigger.scheduleAlarm();
                    }
                }
            }
        }
    }

    public static void cancelAlarmsForStopwatch(@NonNull String str) {
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof StopwatchTrigger) {
                    StopwatchTrigger stopwatchTrigger = (StopwatchTrigger) next;
                    if (str.equals(stopwatchTrigger.getStopwatchName())) {
                        stopwatchTrigger.cancelAlarm();
                    }
                }
            }
        }
    }

    public static String formatStopwatchTime(long j4) {
        long j5 = j4 / 1000;
        return String.format("%02d", Long.valueOf(j5 / 3600)) + ":" + String.format("%02d", Long.valueOf((j5 / 60) % 60)) + ":" + String.format("%02d", Long.valueOf(j5 % 60));
    }

    public static long getStopWatchDuration(@NonNull Context context, @NonNull String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        long j4 = defaultSharedPreferences.getLong("stopwatch_start_" + str, 0L);
        long j5 = defaultSharedPreferences.getLong("stopwatch_stop_" + str, 0L);
        if (j4 == 0) {
            return 0L;
        }
        if (j5 == 0) {
            return System.currentTimeMillis() - j4;
        }
        return j5 - j4;
    }

    public static List<String> getStopWatches(@NonNull Context context) {
        Set<String> stringSet = PreferenceManager.getDefaultSharedPreferences(context).getStringSet("stopwatches", new ArraySet());
        stringSet.remove(null);
        ArrayList arrayList = new ArrayList(stringSet);
        Collections.sort(arrayList);
        return arrayList;
    }

    public static boolean isActive(@NonNull Context context, @NonNull String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        long j4 = defaultSharedPreferences.getLong("stopwatch_start_" + str, 0L);
        long j5 = defaultSharedPreferences.getLong("stopwatch_stop_" + str, 0L);
        if (j4 != 0 && j5 == 0) {
            return true;
        }
        return false;
    }

    public static void pauseStopWatch(@NonNull Context context, @NonNull String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        long j4 = defaultSharedPreferences.getLong("stopwatch_start_" + str, 0L);
        long j5 = defaultSharedPreferences.getLong("stopwatch_stop_" + str, 0L);
        if (j4 != 0 && j5 == 0) {
            edit.putLong("stopwatch_stop_" + str, System.currentTimeMillis());
        }
        edit.apply();
        cancelAlarmsForStopwatch(str);
    }

    public static void resetStopWatch(@NonNull Context context, @NonNull String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("stopwatch_start_" + str, 0L);
        edit.putLong("stopwatch_stop_" + str, 0L);
        edit.apply();
        cancelAlarmsForStopwatch(str);
    }

    public static void setStopWatches(@NonNull Context context, @NonNull List<String> list) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (list.contains(null)) {
            list.remove((Object) null);
        }
        edit.putStringSet("stopwatches", new ArraySet(list));
        edit.apply();
    }

    public static void startStopWatch(Context context, @NonNull String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        long j4 = defaultSharedPreferences.getLong("stopwatch_start_" + str, 0L);
        long j5 = defaultSharedPreferences.getLong("stopwatch_stop_" + str, 0L);
        if (j4 == 0 && j5 == 0) {
            edit.putLong("stopwatch_start_" + str, System.currentTimeMillis());
        } else if (j5 != 0) {
            edit.putLong("stopwatch_start_" + str, System.currentTimeMillis() - (j5 - j4));
            edit.putLong("stopwatch_stop_" + str, 0L);
        }
        edit.apply();
        a(str);
    }
}
