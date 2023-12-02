package com.arlosoft.macrodroid.triggers.services;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class RunningApplicationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15526a;

    /* renamed from: b  reason: collision with root package name */
    private ActivityManager f15527b;

    /* renamed from: c  reason: collision with root package name */
    private String f15528c;

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
        return new TriggerContextInfo(trigger, (String) string, str);
    }

    @TargetApi(11)
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
        this.f15526a = true;
        this.f15527b = (ActivityManager) getSystemService("activity");
        b bVar = new b();
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        this.f15528c = "camera";
        ComponentName resolveActivity = intent.resolveActivity(packageManager);
        if (resolveActivity != null) {
            this.f15528c = resolveActivity.getPackageName();
        }
        f(bVar);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f15526a = false;
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
        private String f15529a;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f0  */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Void... r13) {
            /*
                Method dump skipped, instructions count: 304
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.services.RunningApplicationService.b.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onProgressUpdate(List<Macro>... listArr) {
            for (Macro macro : listArr[0]) {
                macro.invokeActions(macro.getTriggerContextInfo());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            MacroStore.getInstance();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r12) {
        }
    }
}
