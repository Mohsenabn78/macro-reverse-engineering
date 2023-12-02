package com.arlosoft.macrodroid.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.Sdk27ServicesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: AlarmHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class AlarmHelper {
    public static final int $stable = 0;
    @NotNull
    public static final AlarmHelper INSTANCE = new AlarmHelper();

    private AlarmHelper() {
    }

    private final AlarmManager a() {
        return Sdk27ServicesKt.getAlarmManager(b());
    }

    private final MacroDroidApplication b() {
        return MacroDroidApplication.Companion.getInstance();
    }

    @JvmStatic
    public static final void scheduleExactAlarmWithInexactFallback(int i4, long j4, @NotNull PendingIntent operation, boolean z3) {
        boolean canScheduleExactAlarms;
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 23) {
            if (i5 < 31) {
                INSTANCE.a().setExactAndAllowWhileIdle(i4, j4, operation);
                return;
            }
            AlarmHelper alarmHelper = INSTANCE;
            canScheduleExactAlarms = alarmHelper.a().canScheduleExactAlarms();
            if (canScheduleExactAlarms) {
                alarmHelper.a().setExactAndAllowWhileIdle(i4, j4, operation);
                return;
            }
            SystemLog.logError("Could not schedule exact alarm as permission not granted. Wake up time will be inexact");
            alarmHelper.a().set(i4, j4, operation);
            return;
        }
        INSTANCE.a().setExact(i4, j4, operation);
    }

    public static /* synthetic */ void scheduleExactAlarmWithInexactFallback$default(int i4, long j4, PendingIntent pendingIntent, boolean z3, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z3 = false;
        }
        scheduleExactAlarmWithInexactFallback(i4, j4, pendingIntent, z3);
    }

    @JvmStatic
    public static final void scheduleExactRTCWithAlarmOption(boolean z3, long j4, @NotNull PendingIntent operation) {
        boolean canScheduleExactAlarms;
        boolean canScheduleExactAlarms2;
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (z3) {
            if (Build.VERSION.SDK_INT >= 31) {
                AlarmHelper alarmHelper = INSTANCE;
                canScheduleExactAlarms2 = alarmHelper.a().canScheduleExactAlarms();
                if (canScheduleExactAlarms2) {
                    alarmHelper.a().setAlarmClock(new AlarmManager.AlarmClockInfo(j4, operation), operation);
                    return;
                }
                SystemLog.logError("Could not schedule exact alarm as permission not granted. Wake up time will be inexact");
                alarmHelper.a().set(0, j4, operation);
                return;
            }
            INSTANCE.a().setAlarmClock(new AlarmManager.AlarmClockInfo(j4, operation), operation);
            return;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            if (i4 < 31) {
                INSTANCE.a().setExactAndAllowWhileIdle(0, j4, operation);
                return;
            }
            AlarmHelper alarmHelper2 = INSTANCE;
            canScheduleExactAlarms = alarmHelper2.a().canScheduleExactAlarms();
            if (canScheduleExactAlarms) {
                alarmHelper2.a().setExactAndAllowWhileIdle(0, j4, operation);
                return;
            }
            SystemLog.logError("Could not schedule exact alarm as permission not granted. Wake up time will be inexact");
            alarmHelper2.a().set(0, j4, operation);
            return;
        }
        INSTANCE.a().setExact(0, j4, operation);
    }
}
