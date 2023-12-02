package com.arlosoft.macrodroid.triggers.services;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;

@TargetApi(16)
/* loaded from: classes3.dex */
public class MacroDroidAccessibilityServiceJellyBean extends MacroDroidAccessibilityService {
    public static final String ACTION_GLOBAL_CONTROL = "com.arlosoft.macrodroid.triggers.services.GLOBAL_CONTROL";

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        int i6;
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                i6 = extras.getInt(Constants.EXTRA_GLOBAL_CONTROL_TYPE, -1);
            } else {
                i6 = -1;
            }
            if (i6 != -1) {
                try {
                    performGlobalAction(i6);
                    return 2;
                } catch (Exception e4) {
                    SystemLog.logError("Failed to send global command: " + e4.toString());
                    return 2;
                }
            }
            return 2;
        }
        return 2;
    }
}
