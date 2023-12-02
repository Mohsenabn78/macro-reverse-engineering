package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.NotificationButtonTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.activities.NotificationButtonNotAssignedActivity;
import com.arlosoft.macrodroid.triggers.services.MacroDroidAccessibilityServiceJellyBean;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class NotificationBarButtonReceiver extends BroadcastReceiver {
    private void a(Context context) {
        if (Build.VERSION.SDK_INT < 31) {
            try {
                Object systemService = context.getSystemService("statusbar");
                Method method = Class.forName("android.app.StatusBarManager").getMethod("collapsePanels", new Class[0]);
                method.setAccessible(true);
                method.invoke(systemService, new Object[0]);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Could not collapse notification panel: " + e4.getMessage()));
            }
        } else if (!Util.isMacroDroidAccessibilityEnabled(context)) {
            SystemLog.logError("Could not collapse button bar, the MacroDroid accessibility service must be enabled on Android 12+");
        } else {
            Intent intent = new Intent(context, MacroDroidAccessibilityServiceJellyBean.class);
            intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 15);
            context.startService(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        int i4 = intent.getExtras().getInt(Util.NOTIFICATION_BUTTON_EXTRA);
        boolean z3 = false;
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof NotificationButtonTrigger) {
                        NotificationButtonTrigger notificationButtonTrigger = (NotificationButtonTrigger) next;
                        if (notificationButtonTrigger.getId() == i4 && next.constraintsMet()) {
                            if (notificationButtonTrigger.getCollapseNotification()) {
                                a(context);
                            }
                            if (macro.isEnabled()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            }
                            z3 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
        if (!z3) {
            a(context);
            Intent intent2 = new Intent(context, NotificationButtonNotAssignedActivity.class);
            intent2.addFlags(268435456);
            intent2.putExtra(NotificationButtonNotAssignedActivity.EXTRA_BUTTON_ID, i4);
            context.startActivity(intent2);
        }
    }
}
