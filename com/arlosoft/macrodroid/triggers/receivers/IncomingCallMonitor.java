package com.arlosoft.macrodroid.triggers.receivers;

import android.telephony.PhoneStateListener;
import com.arlosoft.macrodroid.utils.LastCallHelper;

/* loaded from: classes3.dex */
public class IncomingCallMonitor extends PhoneStateListener {
    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i4, String str) {
        if (i4 == 1) {
            LastCallHelper.lastCallNumber = str;
        }
    }
}
