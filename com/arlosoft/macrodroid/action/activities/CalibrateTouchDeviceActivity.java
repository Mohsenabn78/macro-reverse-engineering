package com.arlosoft.macrodroid.action.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.FileUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class CalibrateTouchDeviceActivity extends MacroDroidDialogBaseActivity {

    /* renamed from: d  reason: collision with root package name */
    private TextView f2800d;

    /* renamed from: e  reason: collision with root package name */
    private b f2801e;

    /* loaded from: classes2.dex */
    private class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private String f2802a;

        private b() {
            this.f2802a = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            File[] rootGetFilesInDir = FileUtils.rootGetFilesInDir(new File("/dev/input"));
            if (rootGetFilesInDir == null) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("/dev/input is not a valid directory"));
                ToastCompat.makeText(CalibrateTouchDeviceActivity.this.getApplicationContext(), (CharSequence) "/dev/input is not a valid directory", 0).show();
                return null;
            }
            c[] cVarArr = new c[rootGetFilesInDir.length];
            SystemLog.logVerbose("++ Calibrating touch screen");
            for (int i4 = 0; i4 < rootGetFilesInDir.length; i4++) {
                SystemLog.logVerbose("Testing: " + rootGetFilesInDir[i4].getAbsolutePath());
                c cVar = new c(rootGetFilesInDir[i4].getAbsolutePath());
                cVarArr[i4] = cVar;
                cVar.start();
            }
            try {
                Thread.sleep(6000L);
            } catch (InterruptedException unused) {
            }
            for (int i5 = 0; i5 < rootGetFilesInDir.length; i5++) {
                cVarArr[i5].a();
                if (cVarArr[i5].b()) {
                    this.f2802a = rootGetFilesInDir[i5].getAbsolutePath();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r32) {
            if (!isCancelled()) {
                if (this.f2802a != null) {
                    ToastCompat.makeText(CalibrateTouchDeviceActivity.this.getApplicationContext(), (int) R.string.calibration_complete, 1).show();
                    Settings.setTouchScreenDevice(CalibrateTouchDeviceActivity.this, this.f2802a);
                    CalibrateTouchDeviceActivity.this.setResult(-1, new Intent());
                    CalibrateTouchDeviceActivity.this.finish();
                    return;
                }
                CalibrateTouchDeviceActivity.this.f2800d.setText(R.string.calibration_failed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final String f2804a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2805b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2806c;

        /* renamed from: d  reason: collision with root package name */
        private DataOutputStream f2807d;

        public void a() {
            this.f2806c = false;
            try {
                DataOutputStream dataOutputStream = this.f2807d;
                if (dataOutputStream != null) {
                    dataOutputStream.writeBytes("\u0003");
                    this.f2807d.flush();
                    this.f2807d.close();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }

        public boolean b() {
            return this.f2805b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00dc, code lost:
            r9.f2805b = true;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r9 = this;
                java.lang.ProcessBuilder r0 = new java.lang.ProcessBuilder     // Catch: java.lang.Exception -> Le2
                java.lang.String r1 = "su"
                java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch: java.lang.Exception -> Le2
                r0.<init>(r1)     // Catch: java.lang.Exception -> Le2
                r1 = 1
                java.lang.ProcessBuilder r0 = r0.redirectErrorStream(r1)     // Catch: java.lang.Exception -> Le2
                java.lang.Process r0 = r0.start()     // Catch: java.lang.Exception -> Le2
                java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: java.lang.Exception -> Le2
                java.io.OutputStream r3 = r0.getOutputStream()     // Catch: java.lang.Exception -> Le2
                r2.<init>(r3)     // Catch: java.lang.Exception -> Le2
                r9.f2807d = r2     // Catch: java.lang.Exception -> Le2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Le2
                r2.<init>()     // Catch: java.lang.Exception -> Le2
                com.arlosoft.macrodroid.action.activities.CalibrateTouchDeviceActivity r3 = com.arlosoft.macrodroid.action.activities.CalibrateTouchDeviceActivity.this     // Catch: java.lang.Exception -> Le2
                android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch: java.lang.Exception -> Le2
                java.lang.String r3 = r3.dataDir     // Catch: java.lang.Exception -> Le2
                r2.append(r3)     // Catch: java.lang.Exception -> Le2
                java.lang.String r3 = "/socat EXEC:\"getevent "
                r2.append(r3)     // Catch: java.lang.Exception -> Le2
                java.lang.String r3 = r9.f2804a     // Catch: java.lang.Exception -> Le2
                r2.append(r3)     // Catch: java.lang.Exception -> Le2
                java.lang.String r3 = "\",pty,ctty stdio\n"
                r2.append(r3)     // Catch: java.lang.Exception -> Le2
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Le2
                java.io.DataOutputStream r3 = r9.f2807d     // Catch: java.lang.Exception -> Le2
                r3.writeBytes(r2)     // Catch: java.lang.Exception -> Le2
                java.io.DataOutputStream r2 = r9.f2807d     // Catch: java.lang.Exception -> Le2
                r2.flush()     // Catch: java.lang.Exception -> Le2
                java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Exception -> Le2
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> Le2
                r2.<init>(r0)     // Catch: java.lang.Exception -> Le2
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Exception -> Le2
                r0.<init>(r2)     // Catch: java.lang.Exception -> Le2
                r3 = 0
                r4 = 0
            L5d:
                boolean r5 = r9.f2806c     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                if (r5 == 0) goto Lde
                java.lang.String r5 = r0.readLine()     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                if (r5 == 0) goto L7d
                java.lang.String r6 = "LINE"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                r7.<init>()     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                java.lang.String r8 = ">>> "
                r7.append(r8)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                r7.append(r5)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                java.lang.String r7 = r7.toString()     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                android.util.Log.w(r6, r7)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
            L7d:
                if (r5 == 0) goto L5d
                int r6 = r5.length()     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                r7 = 5
                if (r6 <= r7) goto L5d
                java.lang.String r6 = "WARNING"
                boolean r6 = r5.startsWith(r6)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                if (r6 != 0) goto L5d
                java.lang.String r6 = "not found"
                boolean r6 = r5.contains(r6)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                if (r6 != 0) goto L5d
                if (r3 != 0) goto Lb7
                java.lang.String r6 = " 0035 "
                boolean r6 = r5.contains(r6)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                if (r6 == 0) goto Lb7
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                r3.<init>()     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                java.lang.String r6 = "Seen 0035: "
                r3.append(r6)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                java.lang.String r6 = r9.f2804a     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                r3.append(r6)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                java.lang.String r3 = r3.toString()     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                com.arlosoft.macrodroid.logging.systemlog.SystemLog.logVerbose(r3)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                r3 = 1
            Lb7:
                if (r4 != 0) goto Ld8
                java.lang.String r6 = " 0036 "
                boolean r5 = r5.contains(r6)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                if (r5 == 0) goto Ld8
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                r4.<init>()     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                java.lang.String r5 = "Seen 0036: "
                r4.append(r5)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                java.lang.String r5 = r9.f2804a     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                r4.append(r5)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                java.lang.String r4 = r4.toString()     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                com.arlosoft.macrodroid.logging.systemlog.SystemLog.logVerbose(r4)     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
                r4 = 1
            Ld8:
                if (r3 == 0) goto L5d
                if (r4 == 0) goto L5d
                r9.f2805b = r1     // Catch: java.io.IOException -> Lde java.lang.Exception -> Le2
            Lde:
                r2.close()     // Catch: java.lang.Exception -> Le2
                goto L100
            Le2:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Exception while reading input touches: "
                r2.append(r3)
                java.lang.String r0 = r0.getMessage()
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r1.<init>(r0)
                com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r1)
            L100:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.activities.CalibrateTouchDeviceActivity.c.run():void");
        }

        private c(String str) {
            this.f2804a = str;
            this.f2806c = true;
        }
    }

    public void onCancelClick(View view) {
        this.f2801e.cancel(true);
        setResult(0, new Intent());
        finish();
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.action_launch_and_press_calibrating_touch_screen);
        setContentView(R.layout.calibrate_touch_device);
        getWindow().setLayout(-1, -2);
        TextView textView = (TextView) findViewById(R.id.calibrate_touch_device_instruction_text);
        this.f2800d = textView;
        textView.setText(R.string.needs_calibration_info);
        b bVar = new b();
        this.f2801e = bVar;
        bVar.execute((Object[]) null);
    }
}
