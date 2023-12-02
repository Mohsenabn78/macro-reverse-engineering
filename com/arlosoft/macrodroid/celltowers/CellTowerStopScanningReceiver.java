package com.arlosoft.macrodroid.celltowers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class CellTowerStopScanningReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        CellTowerBackgroundScanService.cancelScanning(context);
    }
}
