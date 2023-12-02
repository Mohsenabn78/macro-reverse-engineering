package com.arlosoft.macrodroid.macro;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class ContinuePausedActionsHandler extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Long, List<Intent>> f12806a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static int f12807b = 920875;

    /* renamed from: c  reason: collision with root package name */
    private static int f12808c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<Long, TriggerContextInfo> f12809d = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Macro macro, int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack stack, ResumeMacroInfo resumeMacroInfo, PowerManager.WakeLock wakeLock) {
        try {
            macro.invokeActions(macro.getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
        } finally {
            if (wakeLock.isHeld()) {
                wakeLock.release();
            }
        }
    }

    private static void c(final Macro macro, Context context, final int i4, final Stack<Integer> stack, @Nullable final ResumeMacroInfo resumeMacroInfo, final TriggerContextInfo triggerContextInfo, int i5, final boolean z3) {
        final PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "macrodroid:waitForTime");
        newWakeLock.setReferenceCounted(false);
        newWakeLock.acquire(i5 + 500);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.macro.a
            @Override // java.lang.Runnable
            public final void run() {
                ContinuePausedActionsHandler.b(Macro.this, i4, triggerContextInfo, z3, stack, resumeMacroInfo, newWakeLock);
            }
        }, i5);
    }

    public static void cancelAlarmsForMacro(Context context, Macro macro) {
        List<Intent> list = f12806a.get(Long.valueOf(macro.getGUID()));
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (list != null) {
            for (Intent intent : list) {
                PendingIntent broadcast = PendingIntent.getBroadcast(context.getApplicationContext(), intent.getIntExtra("id", -1), intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
                if (broadcast != null) {
                    broadcast.cancel();
                    alarmManager.cancel(broadcast);
                    SystemLog.logVerbose("Cancelled alarm id: " + intent.getIntExtra("id", -1) + " for " + macro.getName(), macro.getGUID());
                }
            }
            list.clear();
            f12806a.put(Long.valueOf(macro.getGUID()), list);
        }
    }

    @SuppressLint({"NewApi"})
    public static synchronized int setAlarm(Macro macro, Context context, int i4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, TriggerContextInfo triggerContextInfo, int i5, boolean z3, boolean z4) {
        int i6;
        synchronized (ContinuePausedActionsHandler.class) {
            f12807b++;
            if (i5 / 1000 < 5) {
                c(macro, context, i4, stack, resumeMacroInfo, triggerContextInfo, i5, z3);
                return f12807b;
            }
            SystemLog.logVerbose("Scheduling macro (" + f12807b + "): " + macro.getName() + " to resume in: " + i5 + "ms action index: " + i4, macro.getGUID());
            Calendar calendar = Calendar.getInstance();
            calendar.add(14, i5);
            Intent intent = new Intent(context, ContinuePausedActionsHandler.class);
            intent.setAction(Long.toString(System.currentTimeMillis()));
            intent.putExtra("id", f12807b);
            int i7 = f12808c + 1;
            f12808c = i7;
            intent.putExtra("intent_number", i7);
            intent.putExtra(Util.EXTRA_GUID, macro.getGUID());
            intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
            intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, stack);
            intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, z3);
            intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
            if (Build.MANUFACTURER.toLowerCase().equals("huawei") && ((i6 = Build.VERSION.SDK_INT) == 21 || i6 == 22)) {
                f12809d.put(Long.valueOf(macro.getGUID()), triggerContextInfo);
            } else {
                intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context.getApplicationContext(), f12807b, intent, PendingIntentHelper.FLAG_IMMUTABLE | 134217728);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            AlarmHelper.scheduleExactRTCWithAlarmOption(z4, calendar.getTimeInMillis(), broadcast);
            Map<Long, List<Intent>> map = f12806a;
            List<Intent> list = map.get(Long.valueOf(macro.getGUID()));
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(intent);
            Timber.d("New intent number " + f12808c + " Macro: " + macro.getName() + " has " + list.size() + " waiting intents", new Object[0]);
            SystemLog.logVerbose("Intent details at creation");
            StringBuilder sb = new StringBuilder();
            sb.append("ID = ");
            sb.append(intent.getIntExtra("id", -1));
            SystemLog.logVerbose(sb.toString());
            SystemLog.logVerbose("GUID = " + intent.getLongExtra(Util.EXTRA_GUID, -1L));
            SystemLog.logVerbose("Next Action = " + intent.getIntExtra(Constants.EXTRA_NEXT_ACTION_INDEX, -1));
            map.put(Long.valueOf(macro.getGUID()), list);
            return f12807b;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Macro macroByGUID;
        boolean z3;
        TriggerContextInfo triggerContextInfo;
        Stack<Integer> stack;
        int i4;
        long j4 = 0;
        long longExtra = intent.getLongExtra(Util.EXTRA_GUID, 0L);
        int intExtra = intent.getIntExtra("id", -1);
        int intExtra2 = intent.getIntExtra(Constants.EXTRA_NEXT_ACTION_INDEX, -1);
        Macro macro = (Macro) intent.getParcelableExtra("Macro");
        if (macro == null && longExtra == 0) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ContinuePausedActionsReceiver - no id value: " + intExtra));
            SystemLog.logWarning("Failed to resume macro after wait before next, id was -1");
            return;
        }
        if (macro != null) {
            macroByGUID = macro;
        } else {
            macroByGUID = MacroStore.getInstance().getMacroByGUID(longExtra);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Waking up intent to resume macro. ID = ");
        sb.append(intExtra);
        sb.append(", GUID = ");
        sb.append(longExtra);
        sb.append(", hasMacro = ");
        if (macro != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        sb.append(z3);
        sb.append(", nextActionIndex = ");
        sb.append(intExtra2);
        String sb2 = sb.toString();
        if (macroByGUID != null) {
            j4 = macroByGUID.getGUID();
        }
        SystemLog.logVerbose(sb2, j4);
        if (Build.MANUFACTURER.toLowerCase().equals("huawei") && ((i4 = Build.VERSION.SDK_INT) == 21 || i4 == 22)) {
            triggerContextInfo = f12809d.remove(Long.valueOf(longExtra));
        } else {
            triggerContextInfo = (TriggerContextInfo) intent.getParcelableExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
        }
        TriggerContextInfo triggerContextInfo2 = triggerContextInfo;
        if (intent.hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
            try {
                stack = Util.deserializeStack((ArrayList) intent.getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX));
            } catch (Exception unused) {
                stack = new Stack<>();
            }
        } else {
            stack = new Stack<>();
        }
        ResumeMacroInfo resumeMacroInfo = (ResumeMacroInfo) intent.getParcelableExtra(Constants.EXTRA_RESUME_MACRO_INFO);
        int intExtra3 = intent.getIntExtra("intent_number", -1);
        boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, false);
        if (macroByGUID != null && intExtra2 >= 0) {
            Timber.d("Invoking next actions for: " + macroByGUID.getName() + ". Intent number = " + intExtra3, new Object[0]);
            ArrayList arrayList = new ArrayList(macroByGUID.getActions());
            Stack<Integer> stack2 = new Stack<>();
            stack2.addAll(stack);
            macroByGUID.invokeActions(arrayList, intExtra2, triggerContextInfo2, booleanExtra, stack2, resumeMacroInfo);
            List<Intent> list = f12806a.get(Long.valueOf(macroByGUID.getGUID()));
            if (list != null) {
                Iterator<Intent> it = list.iterator();
                while (it.hasNext()) {
                    Intent next = it.next();
                    if (next != null && next.getIntExtra("intent_number", -1) == intExtra3) {
                        it.remove();
                        Timber.d("Removed waiting intent for " + macroByGUID.getName() + " intent number = " + intExtra3, new Object[0]);
                    }
                }
                Timber.d("Number of waiting intents for " + macroByGUID.getName() + " = " + list.size(), new Object[0]);
                return;
            }
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ContinuePausedActionsReceiver - macro = " + macroByGUID + " nextActionIndex = " + intExtra2 + " guid = " + longExtra));
        SystemLog.logWarning("Failed to resume macro after wait before next, macro was null");
    }
}
