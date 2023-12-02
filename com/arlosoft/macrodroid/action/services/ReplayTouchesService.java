package com.arlosoft.macrodroid.action.services;

import android.app.IntentService;
import android.content.Intent;
import android.view.WindowManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.OverlayUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.DataOutputStream;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ReplayTouchesService extends IntentService {

    /* renamed from: a  reason: collision with root package name */
    private HUDView f4884a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager f4885b;

    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        long f4886a;

        /* renamed from: b  reason: collision with root package name */
        int f4887b;

        /* renamed from: c  reason: collision with root package name */
        int f4888c;

        /* renamed from: d  reason: collision with root package name */
        int f4889d;

        private b() {
        }
    }

    public ReplayTouchesService() {
        super("ReplayTouchesService");
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, OverlayUtils.getOverlayType(), 24, -3);
        this.f4885b = (WindowManager) getSystemService("window");
        HUDView hUDView = new HUDView(this, "Replaying Touch Events", R.drawable.play_translucent);
        this.f4884a = hUDView;
        this.f4885b.addView(hUDView, layoutParams);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f4885b.removeView(this.f4884a);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        DataOutputStream dataOutputStream;
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
        }
        String touchScreenDevice = Settings.getTouchScreenDevice(this);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("events");
        a aVar = null;
        try {
            try {
                DataOutputStream dataOutputStream2 = new DataOutputStream(Runtime.getRuntime().exec(new String[]{"su", "-c", "system/bin/sh"}).getOutputStream());
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String str = "sendevent " + touchScreenDevice + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                    ArrayList<b> arrayList = new ArrayList();
                    long j4 = 0;
                    for (String str2 : stringArrayListExtra) {
                        String[] split = str2.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        if (split.length == 4) {
                            b bVar = new b();
                            long doubleValue = (long) (Double.valueOf(split[0].replace("-", ".").replace(":", "")).doubleValue() * 1000.0d);
                            bVar.f4886a = doubleValue;
                            if (j4 == 0) {
                                j4 = doubleValue;
                            }
                            try {
                                bVar.f4887b = Integer.parseInt(split[1], 16);
                                bVar.f4888c = Integer.parseInt(split[2], 16);
                                try {
                                    bVar.f4889d = Integer.parseInt(split[3], 16);
                                } catch (NumberFormatException unused2) {
                                    bVar.f4889d = Integer.MIN_VALUE;
                                }
                                arrayList.add(bVar);
                            } catch (NumberFormatException unused3) {
                            }
                            aVar = null;
                        }
                    }
                    for (b bVar2 : arrayList) {
                        for (long currentTimeMillis2 = System.currentTimeMillis(); currentTimeMillis2 < (bVar2.f4886a - j4) + currentTimeMillis; currentTimeMillis2 = System.currentTimeMillis()) {
                        }
                        dataOutputStream2.writeBytes(str + bVar2.f4887b + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + bVar2.f4888c + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + bVar2.f4889d + "\n");
                    }
                    dataOutputStream2.close();
                } catch (Exception e4) {
                    e = e4;
                    dataOutputStream = dataOutputStream2;
                    try {
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ERROR REPLAYING TOUCH EVENTS: " + e.toString()));
                        dataOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            dataOutputStream.close();
                        } catch (Exception unused4) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = dataOutputStream2;
                    dataOutputStream.close();
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                dataOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
            }
        } catch (Exception unused5) {
        }
    }
}
