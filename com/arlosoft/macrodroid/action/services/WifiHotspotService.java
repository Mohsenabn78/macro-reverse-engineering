package com.arlosoft.macrodroid.action.services;

import android.app.IntentService;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.annotation.RequiresApi;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.action.hotspot.MyOnStartTetheringCallback;
import com.arlosoft.macrodroid.action.hotspot.MyOreoWifiManager;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class WifiHotspotService extends IntentService {
    public static final String FORCE_LEGACY_MECHANISM_EXTRA = "ForceLegacy";
    public static final String MECHANISM = "Mechanism";
    public static final String TURN_ON_WIFI_EXTRA = "TurnOnWifi";
    public static final String WIFI_AP_STATE_EXTRA = "WifiAPState";

    /* renamed from: a  reason: collision with root package name */
    private transient int f4964a;

    /* renamed from: b  reason: collision with root package name */
    private transient WifiManager f4965b;

    /* renamed from: c  reason: collision with root package name */
    private transient boolean f4966c;

    /* renamed from: d  reason: collision with root package name */
    private transient String f4967d;

    public WifiHotspotService() {
        super("WifiHotspotService");
        this.f4964a = -1;
    }

    private void a(Object obj) throws ReflectiveOperationException {
        Class<?> cls = Class.forName("android.net.IConnectivityManager");
        ResultReceiver resultReceiver = new ResultReceiver(null);
        try {
            try {
                cls.getDeclaredMethod("startTethering", Integer.TYPE, ResultReceiver.class, Boolean.TYPE).invoke(obj, 0, resultReceiver, Boolean.FALSE);
            } catch (Exception unused) {
                cls.getDeclaredMethod("startTethering", Integer.TYPE, ResultReceiver.class, Boolean.TYPE).invoke(obj, 0, resultReceiver, Boolean.FALSE);
            }
        } catch (Exception unused2) {
            try {
                cls.getDeclaredMethod("startTethering", Integer.TYPE, ResultReceiver.class, Boolean.TYPE, String.class).invoke(obj, 0, resultReceiver, Boolean.FALSE, BuildConfig.APPLICATION_ID);
            } catch (Exception e4) {
                SystemLog.logError("Cannot start tethering: " + e4.toString());
            }
        }
    }

    private int b() {
        try {
            int intValue = ((Integer) this.f4965b.getClass().getMethod("getWifiApState", new Class[0]).invoke(this.f4965b, new Object[0])).intValue();
            if (intValue > 10) {
                return intValue - 10;
            }
            return intValue;
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("WifiHotspotService: getWifiAPState failed: " + e4.getMessage()));
            return 4;
        }
    }

    private boolean c() {
        int intValue;
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        try {
            Method declaredMethod = wifiManager.getClass().getDeclaredMethod("getWifiApState", new Class[0]);
            declaredMethod.setAccessible(true);
            intValue = ((Integer) declaredMethod.invoke(wifiManager, null)).intValue();
            if (intValue > 10) {
                intValue -= 10;
            }
        } catch (Exception e4) {
            SystemLog.logError("Error getting wifi AP State: " + e4.getMessage());
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Error getting wifi AP State: " + e4.getMessage()));
        }
        if (intValue != 2 && intValue != 3) {
            return false;
        }
        return true;
    }

    private void d(boolean z3, int i4, boolean z4) {
        if (z3 && this.f4964a == -1) {
            this.f4964a = this.f4965b.getWifiState();
        }
        int i5 = 10;
        if (z3 && this.f4965b.getConnectionInfo() != null) {
            try {
                this.f4965b.setWifiEnabled(false);
            } catch (SecurityException unused) {
                Util.displayNotification(this, "Could not change wifi state", "The wifi state could not be changed due to a problem with your wifi driver. This is most likely due to a problem in a custom ROM.", false);
            } catch (Exception e4) {
                SystemLog.logError("Could not change wifi state: " + e4.toString());
            }
            int i6 = 10;
            while (i6 > 0 && this.f4965b.getWifiState() != 1) {
                try {
                    Thread.sleep(500L);
                    i6--;
                } catch (Exception unused2) {
                }
            }
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 26 && !z4 && i4 == 0) {
            f(z3);
        } else if (i7 >= 25 && (!z4 || i4 == 1)) {
            e(z3);
        } else {
            g(z3);
            this.f4964a = -1;
        }
        if (!z3) {
            int b4 = b();
            while (true) {
                try {
                    Thread.sleep(500L);
                    i5--;
                } catch (Exception unused3) {
                }
                if (i5 <= 0 || (b4 != 0 && b4 != 3 && b4 != 4)) {
                    break;
                }
            }
            try {
                Thread.sleep(1000L);
                if (this.f4966c) {
                    if (Build.VERSION.SDK_INT < 29) {
                        this.f4965b.setWifiEnabled(true);
                    } else {
                        h();
                    }
                }
            } catch (Exception unused4) {
                Util.displayNotification(this, "Could not change wifi state", "The wifi state could not be changed due to a problem with your wifi driver. This is most likley due to a problem in a custom ROM.", false);
            }
        }
    }

    private int e(boolean z3) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            if (z3) {
                a(connectivityManager);
            } else {
                ConnectivityManager.class.getDeclaredMethod("stopTethering", Integer.TYPE).invoke(connectivityManager, 0);
            }
        } catch (Exception e4) {
            SystemLog.logError("Failed to set hotspot on API25+: " + e4.toString());
        }
        return 0;
    }

    @RequiresApi(api = 26)
    private int f(boolean z3) {
        a aVar = new a();
        MyOreoWifiManager myOreoWifiManager = new MyOreoWifiManager(this);
        if (z3) {
            myOreoWifiManager.startTethering(aVar, new Handler());
        } else {
            myOreoWifiManager.stopTethering();
        }
        try {
            Thread.sleep(2000L);
        } catch (Exception unused) {
        }
        if (c() != z3) {
            e(z3);
            return 0;
        }
        return 0;
    }

    private int g(boolean z3) {
        int i4;
        try {
            try {
                this.f4965b.setWifiEnabled(false);
            } catch (SecurityException unused) {
                Util.displayNotification(this, "Could not change wifi state", "The wifi state could not be changed due to a problem with your wifi driver. This is most likely due to a problem in a custom ROM.", false);
            }
            this.f4965b.getClass().getMethod("setWifiApEnabled", WifiConfiguration.class, Boolean.TYPE).invoke(this.f4965b, null, Boolean.valueOf(z3));
            i4 = ((Integer) this.f4965b.getClass().getMethod("getWifiApState", new Class[0]).invoke(this.f4965b, new Object[0])).intValue();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
            SystemLog.logError("WifiHotspotService: setWifiApEnabled failed: " + e4.getMessage());
            Util.displayNotification(this, "MacroDroid Error", "WifiHotspot Action Failed", false);
            i4 = -1;
        }
        if (z3) {
            int b4 = b();
            int i5 = 10;
            while (i5 > 0 && (b4 == 2 || b4 == 1 || b4 == 4)) {
                try {
                    Thread.sleep(500L);
                    i5--;
                } catch (Exception unused2) {
                }
            }
        }
        return i4;
    }

    public static String getNestedExceptionMessages(Throwable th) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(th.getClass().getName());
            sb.append(": ");
            sb.append(th.getMessage());
            if (th.getCause() == null) {
                return sb.toString();
            }
            sb.append('\n');
            th = th.getCause();
        }
    }

    private void h() {
        if (RootToolsHelper.isAccessGiven()) {
            Util.runAsRoot(new String[]{"svc wifi enable"});
        } else if (ApplicationChecker.getMacroDroidHelperVersionName() != null) {
            SystemLog.logInfo("Sending request to Helper File to enable wifi", 0L);
            HelperSystemCommands.sendWifiEnableSetEnableState(this, true, this.f4967d);
        } else {
            SystemLog.logError("Cannot set wifi, Helper File is not installed. Please see: https://macrodroidforum.com/index.php?threads/macrodroid-helper-apk.1/", 0L);
        }
    }

    public static boolean isSecurityException(Throwable th) {
        while (!(th instanceof SecurityException)) {
            if (th.getCause() == null) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        this.f4965b = (WifiManager) getApplicationContext().getSystemService("wifi");
        boolean z3 = false;
        boolean booleanExtra = intent.getBooleanExtra(FORCE_LEGACY_MECHANISM_EXTRA, false);
        int intExtra = intent.getIntExtra(WIFI_AP_STATE_EXTRA, 0);
        int intExtra2 = intent.getIntExtra(MECHANISM, 0);
        this.f4966c = intent.getBooleanExtra(TURN_ON_WIFI_EXTRA, false);
        this.f4967d = intent.getStringExtra("com.arlosoft.macrodroid.MACRO_NAME");
        if (intExtra != 0) {
            if (intExtra != 1) {
                if (intExtra == 2) {
                    int b4 = b();
                    if (b4 != 2 && b4 != 3) {
                        z3 = true;
                    }
                    d(z3, intExtra2, booleanExtra);
                    return;
                }
                return;
            }
            d(false, intExtra2, booleanExtra);
            return;
        }
        d(true, intExtra2, booleanExtra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends MyOnStartTetheringCallback {
        a() {
        }

        @Override // com.arlosoft.macrodroid.action.hotspot.MyOnStartTetheringCallback
        public void onTetheringFailed() {
        }

        @Override // com.arlosoft.macrodroid.action.hotspot.MyOnStartTetheringCallback
        public void onTetheringStarted() {
        }
    }
}
