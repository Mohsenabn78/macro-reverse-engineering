package com.tencent.soter.core.biometric;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.tencent.soter.core.model.SLogger;

/* loaded from: classes6.dex */
class SoterBiometricAntiBruteForceStrategy {
    private static final long DEFAULT_FREEZE_TIME = -1;
    private static final int FREEZE_SECOND = 30;
    private static final String KEY_FAIL_TIMES = "key_fail_times";
    private static final String KEY_LAST_FREEZE_TIME = "key_last_freeze_time";
    private static final int MAX_FAIL_NUM = 5;
    private static final String TAG = "Soter.SoterBiometricAntiBruteForceStrategy";

    SoterBiometricAntiBruteForceStrategy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addFailTime(Context context) {
        setCurrentFailTime(context, Integer.valueOf(Integer.valueOf(getCurrentFailTime(context)).intValue() + 1).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void freeze(Context context) {
        setCurrentFailTime(context, 6);
        setLastFreezeTime(context, System.currentTimeMillis());
    }

    private static int getCurrentFailTime(Context context) {
        Integer valueOf = Integer.valueOf(getCurrentFailTimeInDB(context));
        SLogger.i(TAG, "soter: current retry time: " + valueOf, new Object[0]);
        return valueOf.intValue();
    }

    private static int getCurrentFailTimeInDB(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(KEY_FAIL_TIMES, 0);
    }

    private static long getLastFreezeTime(Context context) {
        Long valueOf = Long.valueOf(getLastFreezeTimeInDB(context));
        SLogger.i(TAG, "soter: current last freeze time: " + valueOf, new Object[0]);
        return valueOf.longValue();
    }

    private static long getLastFreezeTimeInDB(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(KEY_LAST_FREEZE_TIME, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isCurrentFailTimeAvailable(Context context) {
        if (getCurrentFailTime(context) >= 5) {
            return false;
        }
        SLogger.i(TAG, "soter: fail time available", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isCurrentTweenTimeAvailable(Context context) {
        int currentTimeMillis = (int) ((System.currentTimeMillis() - getLastFreezeTime(context)) / 1000);
        SLogger.i(TAG, "soter: tween sec after last freeze: " + currentTimeMillis, new Object[0]);
        if (currentTimeMillis <= 30) {
            return false;
        }
        SLogger.d(TAG, "soter: after last freeze", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSystemHasAntiBruteForce() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    private static void setCurrentFailTime(Context context, int i4) {
        SLogger.i(TAG, "soter: setting to time: " + i4, new Object[0]);
        if (i4 < 0) {
            SLogger.w(TAG, "soter: illegal fail time", new Object[0]);
        } else {
            setCurrentFailTimeInDB(context, i4);
        }
    }

    private static void setCurrentFailTimeInDB(Context context, int i4) {
        if (context == null) {
            SLogger.e(TAG, "soter: context is null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(KEY_FAIL_TIMES, i4);
        edit.apply();
    }

    private static void setLastFreezeTime(Context context, long j4) {
        SLogger.i(TAG, "soter: setting last freeze time: " + j4, new Object[0]);
        if (j4 < -1) {
            SLogger.w(TAG, "soter: illegal setLastFreezeTime", new Object[0]);
        } else {
            setLastFreezeTimeInDB(context, j4);
        }
    }

    private static void setLastFreezeTimeInDB(Context context, long j4) {
        if (context == null) {
            SLogger.e(TAG, "soter: context is null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(KEY_LAST_FREEZE_TIME, j4);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unFreeze(Context context) {
        setLastFreezeTime(context, -1L);
        setCurrentFailTime(context, 0);
    }
}
