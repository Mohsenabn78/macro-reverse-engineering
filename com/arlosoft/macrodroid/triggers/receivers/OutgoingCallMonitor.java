package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.utils.LastCallHelper;

/* loaded from: classes3.dex */
public class OutgoingCallMonitor extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LastCallHelper.lastCallNumber = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
    }
}
