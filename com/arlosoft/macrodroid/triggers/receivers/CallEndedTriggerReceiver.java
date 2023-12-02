package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.arlosoft.macrodroid.triggers.services.CallEndedCheckerService;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* loaded from: classes3.dex */
public class CallEndedTriggerReceiver extends WakefulBroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static long f15311a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(RemoteConfigConstants.ResponseFieldKey.STATE);
        if (stringExtra != null && stringExtra.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f15311a > 10000) {
                f15311a = currentTimeMillis;
                Intent intent2 = new Intent(context, CallEndedCheckerService.class);
                intent2.putExtra(RemoteConfigConstants.ResponseFieldKey.STATE, intent.getStringExtra(RemoteConfigConstants.ResponseFieldKey.STATE));
                WakefulBroadcastReceiver.startWakefulService(context, intent2);
            }
        }
    }
}
