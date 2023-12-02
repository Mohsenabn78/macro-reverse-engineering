package com.arlosoft.macrodroid.triggers.services;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.data.NotificationContextInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.NotificationTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.NotificationUtils;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class NotificationService extends NotificationListenerService {
    public static final String BROADCAST_SET_PRIORITY_MODE = "com.arlosoft.macrodroid.SET_PRIORITY_MODE";
    public static final String EXTRA_INTERRUPTION_FILTER_TYPE = "interruptionFilterType";

    /* renamed from: d  reason: collision with root package name */
    private static int f15502d;

    /* renamed from: e  reason: collision with root package name */
    private static NotificationService f15503e;

    /* renamed from: f  reason: collision with root package name */
    private static String f15504f;

    /* renamed from: g  reason: collision with root package name */
    private static String f15505g;

    /* renamed from: h  reason: collision with root package name */
    private static String f15506h;

    /* renamed from: i  reason: collision with root package name */
    private static String f15507i;

    /* renamed from: j  reason: collision with root package name */
    private static long f15508j;

    /* renamed from: k  reason: collision with root package name */
    private static ExecutorService f15509k = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    private final BroadcastReceiver f15510a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final BroadcastReceiver f15511b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final BroadcastReceiver f15512c = new c();

    /* loaded from: classes3.dex */
    public static class NotificationInfo {
        public final String extraText;
        public final int id;
        public final String key;
        public boolean onGoing;
        public final String packageName;
        public final String tag;
        public final String text;
        public final long timestamp;
        public final String title;

        public NotificationInfo(String str, String str2, String str3, int i4, String str4, String str5, String str6, long j4, boolean z3) {
            this.key = str;
            this.packageName = str2;
            this.tag = str3;
            this.id = i4;
            this.title = str4;
            this.text = str5;
            this.extraText = str5;
            this.timestamp = j4;
            this.onGoing = z3;
        }
    }

    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("notificaitonClearAll", false);
            boolean booleanExtra2 = intent.getBooleanExtra("notificationOngoing", false);
            if (booleanExtra) {
                try {
                    NotificationService.this.cancelAllNotifications();
                    return;
                } catch (SecurityException e4) {
                    SystemLog.logError("Failed to cancel all notifications: " + e4.getMessage());
                    FirebaseAnalyticsEventLogger.logHandledException(e4);
                    return;
                }
            }
            String stringExtra = intent.getStringExtra("notificationKey");
            boolean booleanExtra3 = intent.getBooleanExtra("ignorePersistent", false);
            try {
                if (Build.VERSION.SDK_INT >= 26 && booleanExtra2) {
                    if (booleanExtra3) {
                        NotificationService.this.snoozeNotification(stringExtra, 2147483647L);
                    }
                } else {
                    NotificationService.this.cancelNotification(stringExtra);
                }
            } catch (SecurityException e5) {
                SystemLog.logError("Failed to cancel notification: " + e5.getMessage());
                FirebaseAnalyticsEventLogger.logHandledException(e5);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("notificationKey");
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    NotificationService.this.setNotificationsShown(new String[]{stringExtra});
                    NotificationService.this.snoozeNotification(stringExtra, 100L);
                }
            } catch (SecurityException e4) {
                SystemLog.logError("Failed to cancel notification: " + e4.getMessage());
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
        }
    }

    /* loaded from: classes3.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(NotificationService.EXTRA_INTERRUPTION_FILTER_TYPE, -1);
            if (intExtra != -1) {
                try {
                    NotificationService.this.requestInterruptionFilter(intExtra);
                } catch (SecurityException unused) {
                    SystemLog.logInfo("Failed to invoke set priority, please ensure you have granted MacroDroid notification access on your device.");
                }
            }
        }
    }

    public static void clearActiveNotification(Context context, NotificationInfo notificationInfo, boolean z3) {
        Intent intent = new Intent("com.arlosoft.macrodroid.CLEAR_NOTIFICATION");
        intent.putExtra("notificationKey", notificationInfo.key);
        intent.putExtra("notificationPackage", notificationInfo.packageName);
        intent.putExtra("notificationTag", notificationInfo.tag);
        intent.putExtra("notificationId", notificationInfo.id);
        intent.putExtra("notificationOngoing", notificationInfo.onGoing);
        intent.putExtra("ignorePersistent", z3);
        context.sendBroadcast(intent);
    }

    public static void clearAllNotifications(Context context) {
        Intent intent = new Intent("com.arlosoft.macrodroid.CLEAR_NOTIFICATION");
        intent.putExtra("notificaitonClearAll", true);
        context.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(30:1|(5:3|(3:5|(2:9|10)|11)|14|15|(9:17|18|(3:20|(3:22|(2:24|25)(2:27|28)|26)|29)|30|(3:34|(1:36)|37)|38|(1:42)|43|(4:49|(1:51)(1:190)|52|(15:61|(1:63)(1:189)|64|65|66|(1:68)(1:186)|69|(1:71)(1:185)|72|(4:75|(2:76|(7:78|(2:80|(2:(2:86|(5:88|89|(2:161|162)(2:91|(2:95|(0))(1:159))|101|(4:112|(3:114|(3:122|123|(2:125|126)(1:127))|128)(2:129|(3:131|(3:139|140|(2:142|143)(1:144))|128)(3:145|(3:153|154|(2:156|157)(1:158))|128))|98|99)(5:105|106|(1:108)|109|110))(1:163))(1:164)|100)(1:166))(1:168)|167|128|98|99|100)(3:169|170|171))|111|73)|172|173|(4:176|(3:178|179|180)(1:182)|181|174)|183|184)(2:59|60))(1:47)))|191|18|(0)|30|(4:32|34|(0)|37)|38|(2:40|42)|43|(1:45)|49|(0)(0)|52|(1:54)|61|(0)(0)|64|65|66|(0)(0)|69|(0)(0)|72|(1:73)|172|173|(1:174)|183|184) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0163, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01df, code lost:
        if (r2 != false) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3 A[LOOP:2: B:30:0x00a1->B:31:0x00a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0191  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(android.service.notification.StatusBarNotification r32) {
        /*
            Method dump skipped, instructions count: 1047
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.services.NotificationService.f(android.service.notification.StatusBarNotification):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Macro macro, TriggerContextInfo triggerContextInfo) {
        macro.setTriggerContextInfo(triggerContextInfo);
        macro.invokeActions(triggerContextInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Macro macro) {
        macro.invokeActions(macro.getTriggerContextInfo());
    }

    @RequiresApi(api = 26)
    public static StatusBarNotification[] getHiddenNotifications() {
        NotificationService notificationService;
        try {
            notificationService = f15503e;
        } catch (Exception e4) {
            SystemLog.logError("Failed to retrieve active notifications: " + e4.toString());
        }
        if (notificationService != null) {
            return notificationService.getSnoozedNotifications();
        }
        h();
        return new StatusBarNotification[0];
    }

    public static List<NotificationInfo> getNotifications(int i4, boolean z3) {
        try {
            NotificationService notificationService = f15503e;
            if (notificationService != null) {
                StatusBarNotification[] activeNotifications = notificationService.getActiveNotifications();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    return parseNotifications(f15503e.getActiveNotifications(), i4, z3);
                }
            } else {
                h();
            }
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
            SystemLog.logError("Failed to retrieve active notifications: " + e4.toString());
        }
        return new ArrayList();
    }

    public static StatusBarNotification[] getStatusBarNotifications() {
        try {
            return f15503e.getActiveNotifications();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
            SystemLog.logError("Failed to retrieve active notifications: " + e4.toString());
            return new StatusBarNotification[0];
        }
    }

    private static void h() {
        Class cls;
        int i4 = f15502d + 1;
        f15502d = i4;
        if (i4 < 5) {
            SystemLog.logError("Could not obtain an active instance of the notification service - attempting to recover");
            MacroDroidApplication macroDroidApplication = MacroDroidApplication.getInstance();
            if (Build.VERSION.SDK_INT >= 26) {
                cls = NotificationServiceOreo.class;
            } else {
                cls = NotificationService.class;
            }
            MacroDroidApplication.getInstance().startService(new Intent(macroDroidApplication, cls));
            return;
        }
        SystemLog.logError("Could not obtain an active instance of the notification service - please check your notification access setting on your device and try rebooting");
        Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(MacroDroidApplication.getInstance());
        SystemLog.logDebug("Enabled packages: " + enabledListenerPackages);
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) MacroDroidApplication.getInstance().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            SystemLog.logDebug("Running service: " + it.next().service.getClassName());
        }
    }

    public static NotificationInfo parseNotification(StatusBarNotification statusBarNotification) {
        String str;
        String str2;
        String key = statusBarNotification.getKey();
        Bundle bundle = statusBarNotification.getNotification().extras;
        try {
            str = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE, "").toString().toString();
        } catch (Exception unused) {
            str = "";
        }
        try {
            str2 = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT, "").toString().toString();
        } catch (Exception unused2) {
            str2 = "";
        }
        return new NotificationInfo(key, statusBarNotification.getPackageName(), statusBarNotification.getTag(), statusBarNotification.getId(), str, str2, "", statusBarNotification.getPostTime(), statusBarNotification.isOngoing());
    }

    public static List<NotificationInfo> parseNotifications(StatusBarNotification[] statusBarNotificationArr, int i4, boolean z3) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
            if ((!z3 || !statusBarNotification.isOngoing()) && (currentTimeMillis - statusBarNotification.getPostTime()) / 1000 >= i4) {
                arrayList.add(parseNotification(statusBarNotification));
            }
        }
        return arrayList;
    }

    public static void restoreHiddenNotification(Context context, String str) {
        Intent intent = new Intent("com.arlosoft.macrodroid.RESTORE_NOTIFICATION");
        intent.putExtra("notificationKey", str);
        context.sendBroadcast(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f15503e = this;
        f15502d = 0;
        SystemLog.logVerbose("Notification Service Created");
        registerReceiver(this.f15512c, new IntentFilter(BROADCAST_SET_PRIORITY_MODE));
        registerReceiver(this.f15510a, new IntentFilter("com.arlosoft.macrodroid.CLEAR_NOTIFICATION"));
        registerReceiver(this.f15511b, new IntentFilter("com.arlosoft.macrodroid.RESTORE_NOTIFICATION"));
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        f15503e = null;
        SystemLog.logVerbose("Notification Service Destroyed");
        try {
            unregisterReceiver(this.f15512c);
        } catch (Exception unused) {
        }
        try {
            unregisterReceiver(this.f15510a);
        } catch (Exception unused2) {
        }
        try {
            unregisterReceiver(this.f15511b);
        } catch (Exception unused3) {
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        SystemLog.logVerbose("Notification Listener Connected");
        f15503e = this;
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        SystemLog.logVerbose("Notification Listener Disconnected");
    }

    @Override // android.service.notification.NotificationListenerService
    @TargetApi(19)
    public void onNotificationPosted(final StatusBarNotification statusBarNotification) {
        if (!Settings.getMacroDroidEnabled(this)) {
            return;
        }
        MacroStore.getInstance();
        f15509k.execute(new Thread(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.services.i
            @Override // java.lang.Runnable
            public final void run() {
                NotificationService.this.f(statusBarNotification);
            }
        }));
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        String str;
        ApplicationInfo applicationInfo;
        CharSequence charSequence;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList;
        String str5;
        String str6;
        StringBuilder sb;
        String str7;
        Macro macro;
        String sb2;
        String str8;
        if (!Settings.getMacroDroidEnabled(this) || statusBarNotification == null) {
            return;
        }
        String packageName = statusBarNotification.getPackageName();
        String str9 = "";
        if (statusBarNotification.getNotification().tickerText == null) {
            str = "";
        } else {
            str = statusBarNotification.getNotification().tickerText.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        statusBarNotification.isOngoing();
        Bundle bundle = statusBarNotification.getNotification().extras;
        String charSequence2 = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE, "").toString();
        String charSequence3 = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT, "").toString();
        String charSequence4 = bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT, "").toString();
        String charSequence5 = bundle.getCharSequence(NotificationCompat.EXTRA_SUB_TEXT, "").toString();
        CharSequence[] charSequenceArray = bundle.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES);
        if (charSequenceArray != null) {
            for (CharSequence charSequence6 : charSequenceArray) {
                if (charSequence6 == null) {
                    str8 = "";
                } else {
                    str8 = charSequence6.toString();
                }
                sb3.append(str8);
                sb3.append("\n");
            }
        }
        Notification.Action[] actionArr = statusBarNotification.getNotification().actions;
        StringBuilder sb4 = new StringBuilder();
        if (actionArr != null) {
            for (Notification.Action action : actionArr) {
                if (action != null) {
                    sb4.append(action.title);
                    sb4.append(", ");
                } else {
                    sb4.append(", ");
                }
            }
            if (sb4.length() > 0) {
                str9 = sb4.toString().substring(0, sb2.length() - 2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        PackageManager packageManager = getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        String str10 = "(?)";
        if (applicationInfo == null) {
            charSequence = "(?)";
        } else {
            charSequence = packageManager.getApplicationLabel(applicationInfo);
        }
        String str11 = (String) charSequence;
        if (applicationInfo != null) {
            str10 = applicationInfo.packageName;
        }
        String str12 = str10;
        Iterator<Macro> it = MacroStore.getInstance().getEnabledMacros().iterator();
        while (it.hasNext()) {
            Macro next = it.next();
            Iterator<Trigger> it2 = next.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Trigger next2 = it2.next();
                    if (next2 instanceof NotificationTrigger) {
                        NotificationTrigger notificationTrigger = (NotificationTrigger) next2;
                        if (notificationTrigger.getOption() == 1) {
                            if (NotificationUtils.checkForPackageMatch(packageName, notificationTrigger)) {
                                str2 = packageName;
                                sb = sb3;
                                str3 = str;
                                String str13 = charSequence2;
                                macro = next;
                                ArrayList arrayList3 = arrayList2;
                                String str14 = str9;
                                String str15 = charSequence5;
                                str4 = str9;
                                str6 = charSequence3;
                                TriggerContextInfo triggerContextInfo = new TriggerContextInfo(next2, new NotificationContextInfo(charSequence3, str11, str12, charSequence2, str, charSequence4, sb3.toString(), str14, charSequence5, statusBarNotification.getKey()));
                                if (TextUtils.isEmpty(notificationTrigger.getTextContent())) {
                                    if (next2.constraintsMet(triggerContextInfo)) {
                                        macro.setTriggerThatInvoked(next2);
                                        macro.setTriggerContextInfo(triggerContextInfo);
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            arrayList = arrayList3;
                                            arrayList.add(macro);
                                            notificationTrigger.setLastInvocationNow();
                                        } else {
                                            arrayList = arrayList3;
                                        }
                                        str5 = str15;
                                        str7 = str13;
                                    } else {
                                        arrayList = arrayList3;
                                        str5 = str15;
                                        str7 = str13;
                                        arrayList2 = arrayList;
                                        charSequence3 = str6;
                                        charSequence5 = str5;
                                        next = macro;
                                        packageName = str2;
                                        sb3 = sb;
                                        str = str3;
                                        str9 = str4;
                                        charSequence2 = str7;
                                    }
                                } else {
                                    arrayList = arrayList3;
                                    String replaceMagicText = MagicText.replaceMagicText(this, notificationTrigger.getTextContent(), triggerContextInfo, macro);
                                    String regexPattern = WildCardHelper.getRegexPattern(replaceMagicText, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase());
                                    String regexContainsPattern = WildCardHelper.getRegexContainsPattern(replaceMagicText, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase());
                                    if (notificationTrigger.isExcludes()) {
                                        str7 = str13;
                                        if (!WildCardHelper.matches(str7, regexContainsPattern, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase()) && !WildCardHelper.matches(str6, regexContainsPattern, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase())) {
                                            boolean isEnableRegex = notificationTrigger.isEnableRegex();
                                            boolean isIgnoreCase = notificationTrigger.isIgnoreCase();
                                            str5 = str15;
                                            if (!WildCardHelper.matches(str5, regexContainsPattern, isEnableRegex, isIgnoreCase) && next2.constraintsMet(triggerContextInfo)) {
                                                macro.setTriggerThatInvoked(next2);
                                                macro.setTriggerContextInfo(triggerContextInfo);
                                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                    arrayList.add(macro);
                                                    notificationTrigger.setLastInvocationNow();
                                                }
                                            }
                                        } else {
                                            str5 = str15;
                                        }
                                        arrayList2 = arrayList;
                                        charSequence3 = str6;
                                        charSequence5 = str5;
                                        next = macro;
                                        packageName = str2;
                                        sb3 = sb;
                                        str = str3;
                                        str9 = str4;
                                        charSequence2 = str7;
                                    } else {
                                        str5 = str15;
                                        str7 = str13;
                                        if (notificationTrigger.isExactMatch()) {
                                            if ((WildCardHelper.matches(str7, regexPattern, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase()) || WildCardHelper.matches(str6, regexPattern, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase()) || WildCardHelper.matches(str5, regexPattern, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase())) && next2.constraintsMet(triggerContextInfo)) {
                                                macro.setTriggerThatInvoked(next2);
                                                macro.setTriggerContextInfo(triggerContextInfo);
                                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                    arrayList.add(macro);
                                                    notificationTrigger.setLastInvocationNow();
                                                }
                                            }
                                            arrayList2 = arrayList;
                                            charSequence3 = str6;
                                            charSequence5 = str5;
                                            next = macro;
                                            packageName = str2;
                                            sb3 = sb;
                                            str = str3;
                                            str9 = str4;
                                            charSequence2 = str7;
                                        } else {
                                            if ((WildCardHelper.matches(str7, regexContainsPattern, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase()) || WildCardHelper.matches(str6, regexContainsPattern, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase()) || WildCardHelper.matches(str5, regexContainsPattern, notificationTrigger.isEnableRegex(), notificationTrigger.isIgnoreCase())) && next2.constraintsMet(triggerContextInfo)) {
                                                macro.setTriggerThatInvoked(next2);
                                                macro.setTriggerContextInfo(triggerContextInfo);
                                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                    arrayList.add(macro);
                                                    notificationTrigger.setLastInvocationNow();
                                                }
                                            }
                                            arrayList2 = arrayList;
                                            charSequence3 = str6;
                                            charSequence5 = str5;
                                            next = macro;
                                            packageName = str2;
                                            sb3 = sb;
                                            str = str3;
                                            str9 = str4;
                                            charSequence2 = str7;
                                        }
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    str2 = packageName;
                    str3 = str;
                    str4 = str9;
                    arrayList = arrayList2;
                    str5 = charSequence5;
                    str6 = charSequence3;
                    sb = sb3;
                    str7 = charSequence2;
                    macro = next;
                    arrayList2 = arrayList;
                    charSequence3 = str6;
                    charSequence5 = str5;
                    next = macro;
                    packageName = str2;
                    sb3 = sb;
                    str = str3;
                    str9 = str4;
                    charSequence2 = str7;
                } else {
                    str2 = packageName;
                    str3 = str;
                    str4 = str9;
                    arrayList = arrayList2;
                    str5 = charSequence5;
                    str6 = charSequence3;
                    sb = sb3;
                    str7 = charSequence2;
                    break;
                }
            }
            arrayList2 = arrayList;
            charSequence3 = str6;
            charSequence2 = str7;
            charSequence5 = str5;
            packageName = str2;
            sb3 = sb;
            str = str3;
            str9 = str4;
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            final Macro macro2 = (Macro) it3.next();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.services.h
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationService.g(Macro.this);
                }
            });
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        f15503e = this;
        SystemLog.logVerbose("Notification listener service instance obtained");
        return 1;
    }
}
