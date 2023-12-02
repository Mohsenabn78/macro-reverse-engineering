package com.arlosoft.macrodroid.action.hotspot;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.lang.reflect.Method;

@RequiresApi(api = 26)
/* loaded from: classes2.dex */
public class MyOreoWifiManager {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3685b = "MyOreoWifiManager";

    /* renamed from: a  reason: collision with root package name */
    private Context f3686a;

    public MyOreoWifiManager(Context context) {
        this.f3686a = context;
    }

    public void startTethering(MyOnStartTetheringCallback myOnStartTetheringCallback, Handler handler) {
        Object obj;
        Object systemService;
        Class<?> cls = null;
        try {
            obj = new CallbackMaker(this.f3686a, myOnStartTetheringCallback).getCallBackClass().getDeclaredConstructor(Integer.TYPE).newInstance(0);
        } catch (Exception e4) {
            e4.printStackTrace();
            obj = null;
        }
        systemService = this.f3686a.getApplicationContext().getSystemService(ConnectivityManager.class);
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        try {
            try {
                cls = Class.forName("android.net.ConnectivityManager$OnStartTetheringCallback");
            } catch (ClassNotFoundException e5) {
                e5.printStackTrace();
            }
            Class<?> cls2 = connectivityManager.getClass();
            Class<?> cls3 = Integer.TYPE;
            Class<?> cls4 = Boolean.TYPE;
            Method declaredMethod = cls2.getDeclaredMethod("startTethering", cls3, cls4, cls, Handler.class);
            if (declaredMethod == null) {
                Method declaredMethod2 = connectivityManager.getClass().getDeclaredMethod("startTethering", cls3, cls4, cls);
                if (declaredMethod2 == null) {
                    StringBuilder sb = new StringBuilder();
                    for (Method method : connectivityManager.getClass().getDeclaredMethods()) {
                        if (method.getName().contains("startTethering")) {
                            sb.append(method.toString() + "\n");
                        }
                    }
                    if (sb.length() == 0) {
                        SystemLog.logError("ConnectivityManager.startTetheringMethod() is not found");
                        return;
                    }
                    FirebaseAnalyticsEventLogger.logHotSpotMethods(sb.toString());
                    SystemLog.logError("ConnectivityManager.startTetheringMethod() not found. Did find: " + sb.toString());
                    return;
                }
                declaredMethod2.invoke(connectivityManager, 0, Boolean.FALSE, obj);
                return;
            }
            declaredMethod.invoke(connectivityManager, 0, Boolean.FALSE, obj, handler);
        } catch (Exception unused) {
            SystemLog.logError("Could not modify hotspot: $e");
        }
    }

    public void stopTethering() {
        Object systemService;
        systemService = this.f3686a.getApplicationContext().getSystemService(ConnectivityManager.class);
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        try {
            Method declaredMethod = connectivityManager.getClass().getDeclaredMethod("stopTethering", Integer.TYPE);
            if (declaredMethod == null) {
                Log.e(f3685b, "stopTetheringMethod is null");
            } else {
                declaredMethod.invoke(connectivityManager, 0);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
