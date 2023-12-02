package com.arlosoft.macrodroid.triggers.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.receivers.SignalOnOffTriggerReceiver;

/* loaded from: classes3.dex */
public class PhoneStateMonitorService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static SignalOnOffTriggerReceiver f15522a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (f15522a == null) {
            try {
                f15522a = new SignalOnOffTriggerReceiver();
                ((TelephonyManager) getSystemService("phone")).listen(f15522a, 33);
            } catch (SecurityException unused) {
                SystemLog.logError("Monitoring phone state failed - missing READ_PHONE_STATE permission");
                PermissionsHelper.showNeedsPermission(this, "android.permission.READ_PHONE_STATE", getString(R.string.trigger_call_active), true, false);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        ((TelephonyManager) getSystemService("phone")).listen(f15522a, 0);
        f15522a = null;
        super.onDestroy();
    }
}
