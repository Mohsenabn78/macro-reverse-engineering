package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.triggers.services.OutgoingCallCheckerService;

/* loaded from: classes3.dex */
public class OutgoingCallTriggerReceiver extends WakefulBroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static long f15335a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f15335a > 10000) {
            f15335a = currentTimeMillis;
            Intent intent2 = new Intent(context, OutgoingCallCheckerService.class);
            intent2.putExtra(Constants.EXTRA_PHONE_NUMBER, stringExtra);
            WakefulBroadcastReceiver.startWakefulService(context, intent2);
        }
    }
}
