package com.arlosoft.macrodroid.action.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class KeepAwakeActionFinishedHandler extends BroadcastReceiver {
    public static final String WAKELOCK_ID_EXTRA = "WakeLockId";

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<Integer, PowerManager.WakeLock> f4780a = new HashMap<>();

    public static void registerWakeLock(int i4, PowerManager.WakeLock wakeLock) {
        f4780a.put(Integer.valueOf(i4), wakeLock);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(WAKELOCK_ID_EXTRA, -1);
        HashMap<Integer, PowerManager.WakeLock> hashMap = f4780a;
        PowerManager.WakeLock wakeLock = hashMap.get(Integer.valueOf(intExtra));
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                wakeLock.release();
            }
            hashMap.remove(Integer.valueOf(intExtra));
        }
    }
}
