package com.arlosoft.macrodroid.action.services;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.WindowManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.LaunchAndPressAction;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.OverlayUtils;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class RecordInputService extends IntentService {
    public static final String EXTRA_FROM_ACTIVITY = "FromActivity";
    public static final int EXTRA_FROM_ADD_ACTION = 1;
    public static final int EXTRA_FROM_EDIT_ACTION = 2;
    public static final int EXTRA_FROM_WIZARD_ACTION = 0;

    /* renamed from: a  reason: collision with root package name */
    private HUDView f4875a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager f4876b;

    /* renamed from: c  reason: collision with root package name */
    private b f4877c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4878d;

    /* renamed from: e  reason: collision with root package name */
    private DataOutputStream f4879e;

    /* renamed from: f  reason: collision with root package name */
    private int f4880f;

    /* renamed from: g  reason: collision with root package name */
    private LaunchAndPressAction f4881g;

    /* renamed from: h  reason: collision with root package name */
    private Macro f4882h;

    /* loaded from: classes2.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                RecordInputService.this.f4878d = false;
                if (RecordInputService.this.f4879e != null) {
                    DataOutputStream dataOutputStream = RecordInputService.this.f4879e;
                    dataOutputStream.writeBytes("\u0003");
                    RecordInputService.this.f4879e.flush();
                    RecordInputService.this.f4879e.close();
                }
            } catch (IOException unused) {
            }
        }
    }

    public RecordInputService() {
        super("RecordInputService");
        setIntentRedelivery(true);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, OverlayUtils.getOverlayType(), 24, -3);
        this.f4876b = (WindowManager) getSystemService("window");
        HUDView hUDView = new HUDView(this, "Recording Touch Events", R.drawable.record_translucent);
        this.f4875a = hUDView;
        try {
            this.f4876b.addView(hUDView, layoutParams);
        } catch (Exception unused) {
        }
        this.f4877c = new b();
        MacroDroidApplication.getInstance().registerReceiver(this.f4877c, new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        Intent intent;
        super.onDestroy();
        MacroDroidApplication.getInstance().unregisterReceiver(this.f4877c);
        try {
            this.f4876b.removeView(this.f4875a);
        } catch (Exception unused) {
        }
        int i4 = this.f4880f;
        if (i4 != 0) {
            if (i4 == 1) {
                intent = new Intent(this, EditMacroActivity.class);
                intent.addFlags(67108864);
                this.f4882h.addAction(this.f4881g);
            } else {
                intent = new Intent(this, EditMacroActivity.class);
                intent.putExtra("MacroId", this.f4882h.getId());
            }
            MacroStore.getInstance().updateMacro(this.f4882h);
        } else {
            this.f4882h.addAction(this.f4881g);
            intent = new Intent(this, WizardActivity.class);
            intent.putExtra("Macro", this.f4882h);
        }
        intent.addFlags(335544320);
        startActivity(intent);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String readLine;
        String touchScreenDevice = Settings.getTouchScreenDevice(this);
        ArrayList<String> arrayList = new ArrayList<>();
        this.f4881g = (LaunchAndPressAction) intent.getExtras().getParcelable("action");
        this.f4882h = (Macro) intent.getExtras().getParcelable("Macro");
        this.f4880f = intent.getExtras().getInt(EXTRA_FROM_ACTIVITY, 0);
        try {
            Process start = new ProcessBuilder("su").redirectErrorStream(true).start();
            this.f4879e = new DataOutputStream(start.getOutputStream());
            this.f4879e.writeBytes(getApplicationInfo().dataDir + "/socat EXEC:\"getevent -t " + touchScreenDevice + "\",pty,ctty stdio\n");
            this.f4879e.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            this.f4878d = true;
            do {
                if (this.f4878d && (readLine = bufferedReader.readLine()) != null) {
                    arrayList.add(readLine.replaceAll("(\\[|\\])", "").trim());
                }
            } while (this.f4878d);
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("RecordInputService: Exception while reading input touches: " + e4.getMessage()));
        }
        this.f4881g.setEventList(arrayList);
    }
}
