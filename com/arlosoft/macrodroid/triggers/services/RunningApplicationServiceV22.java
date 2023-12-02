package com.arlosoft.macrodroid.triggers.services;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(21)
/* loaded from: classes3.dex */
public class RunningApplicationServiceV22 extends Service {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15535a;

    /* JADX INFO: Access modifiers changed from: private */
    public String d(UsageStats usageStats) {
        String packageName = usageStats.getPackageName();
        if (packageName != null && packageName.equals("com.google.android.googlequicksearchbox")) {
            return "com.google.android.launcher";
        }
        return packageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TriggerContextInfo e(Trigger trigger, String str) {
        ApplicationInfo applicationInfo;
        CharSequence string;
        PackageManager packageManager = getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            string = packageManager.getApplicationLabel(applicationInfo);
        } else {
            string = getString(R.string.unknown_application);
        }
        return new TriggerContextInfo(trigger, (String) string);
    }

    private void f(b bVar) {
        bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f15535a = true;
        b bVar = new b();
        MacroStore.getInstance();
        f(bVar);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f15535a = false;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        return 1;
    }

    /* loaded from: classes3.dex */
    private class b extends AsyncTask<Void, List<Macro>, Void> {

        /* renamed from: a  reason: collision with root package name */
        private UsageStatsManager f15536a;

        private b() {
            this.f15536a = (UsageStatsManager) RunningApplicationServiceV22.this.getSystemService("usagestats");
        }

        private String b() {
            List<UsageStats> list;
            long currentTimeMillis = System.currentTimeMillis();
            UsageStats usageStats = null;
            try {
                list = this.f15536a.queryUsageStats(4, currentTimeMillis - 4500, currentTimeMillis);
            } catch (IllegalStateException e4) {
                SystemLog.logError("Failed to query application info: " + e4.toString());
                list = null;
            } catch (NullPointerException unused) {
                return "none";
            }
            if (list == null || list.size() == 0) {
                return "none";
            }
            long j4 = -1;
            for (UsageStats usageStats2 : list) {
                if (usageStats2.getLastTimeUsed() > j4) {
                    j4 = usageStats2.getLastTimeUsed();
                    usageStats = usageStats2;
                }
            }
            if (usageStats == null) {
                return "none";
            }
            if (!Settings.getAppLaunchPreventNotifications(RunningApplicationServiceV22.this)) {
                return RunningApplicationServiceV22.this.d(usageStats);
            }
            UsageEvents queryEvents = this.f15536a.queryEvents(currentTimeMillis - 2000, currentTimeMillis);
            UsageEvents.Event event = new UsageEvents.Event();
            while (queryEvents.hasNextEvent()) {
                queryEvents.getNextEvent(event);
                if (event.getEventType() == 1 && usageStats.getPackageName().equals(event.getPackageName())) {
                    return RunningApplicationServiceV22.this.d(usageStats);
                }
            }
            return "none";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            Object obj = "none";
            while (RunningApplicationServiceV22.this.f15535a) {
                ArrayList arrayList = new ArrayList();
                arrayList.clear();
                try {
                    Thread.sleep(1500L);
                } catch (InterruptedException unused) {
                }
                String b4 = b();
                if (!b4.equals("none") && !b4.equals(BuildConfig.APPLICATION_ID) && !b4.equals(obj)) {
                    for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                        Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                        while (it.hasNext()) {
                            Trigger next = it.next();
                            if (next instanceof ApplicationLaunchedTrigger) {
                                ApplicationLaunchedTrigger applicationLaunchedTrigger = (ApplicationLaunchedTrigger) next;
                                Iterator<String> it2 = applicationLaunchedTrigger.getPackageNameList().iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        String next2 = it2.next();
                                        if (applicationLaunchedTrigger.getLaunched() && next2.equals(b4) && next.constraintsMet()) {
                                            macro.setTriggerThatInvoked(next);
                                            macro.setTriggerContextInfo(RunningApplicationServiceV22.this.e(next, next2));
                                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                arrayList.add(macro);
                                            }
                                        } else if (!applicationLaunchedTrigger.getLaunched() && next2.equals(obj) && next.constraintsMet()) {
                                            macro.setTriggerThatInvoked(next);
                                            macro.setTriggerContextInfo(RunningApplicationServiceV22.this.e(next, next2));
                                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                arrayList.add(macro);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        publishProgress(arrayList);
                    }
                    obj = b4;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onProgressUpdate(List<Macro>... listArr) {
            RunningApplicationServiceV22.this.getPackageManager();
            for (Macro macro : listArr[0]) {
                macro.invokeActions(macro.getTriggerContextInfo());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r12) {
        }
    }
}
