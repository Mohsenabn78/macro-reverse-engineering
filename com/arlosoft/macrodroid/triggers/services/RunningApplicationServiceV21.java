package com.arlosoft.macrodroid.triggers.services;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class RunningApplicationServiceV21 extends Service {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15531a;

    /* renamed from: b  reason: collision with root package name */
    private ActivityManager f15532b;

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        if (str.equals("com.google.android.apps.photos")) {
            return "com.google.android.apps.plus";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TriggerContextInfo f(Trigger trigger, String str) {
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

    private void g(b bVar) {
        bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f15531a = true;
        this.f15532b = (ActivityManager) getSystemService("activity");
        b bVar = new b();
        getPackageManager();
        new Intent("android.media.action.IMAGE_CAPTURE");
        g(bVar);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f15531a = false;
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
        private final Set<String> f15533a;

        private b() {
            this.f15533a = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            while (RunningApplicationServiceV21.this.f15531a) {
                arrayList.clear();
                try {
                    Thread.sleep(1500L);
                } catch (InterruptedException unused) {
                }
                this.f15533a.clear();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = RunningApplicationServiceV21.this.f15532b.getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    return null;
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100) {
                        this.f15533a.addAll(Arrays.asList(runningAppProcessInfo.pkgList));
                    }
                }
                if (this.f15533a != null) {
                    for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                        Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                        while (it.hasNext()) {
                            Trigger next = it.next();
                            if (next instanceof ApplicationLaunchedTrigger) {
                                ApplicationLaunchedTrigger applicationLaunchedTrigger = (ApplicationLaunchedTrigger) next;
                                if (applicationLaunchedTrigger.getLaunched()) {
                                    Iterator<String> it2 = applicationLaunchedTrigger.getPackageNameList().iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        String e4 = RunningApplicationServiceV21.this.e(it2.next());
                                        if (this.f15533a.contains(e4) && !hashSet.contains(e4) && next.constraintsMet()) {
                                            macro.setTriggerThatInvoked(next);
                                            macro.setTriggerContextInfo(RunningApplicationServiceV21.this.f(next, e4));
                                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                arrayList.add(macro);
                                            }
                                        }
                                    }
                                }
                                if (!applicationLaunchedTrigger.getLaunched()) {
                                    Iterator<String> it3 = applicationLaunchedTrigger.getPackageNameList().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            String e5 = RunningApplicationServiceV21.this.e(it3.next());
                                            if (hashSet.contains(e5) && !this.f15533a.contains(e5) && next.constraintsMet()) {
                                                macro.setTriggerThatInvoked(next);
                                                macro.setTriggerContextInfo(RunningApplicationServiceV21.this.f(next, e5));
                                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                                    arrayList.add(macro);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                hashSet.clear();
                hashSet.addAll(this.f15533a);
                publishProgress(arrayList);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onProgressUpdate(List<Macro>... listArr) {
            for (Macro macro : listArr[0]) {
                macro.invokeActions(macro.getTriggerContextInfo());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r12) {
        }
    }
}
