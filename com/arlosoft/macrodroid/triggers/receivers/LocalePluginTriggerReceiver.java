package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.arlosoft.macrodroid.triggers.services.LocalePluginCheckerService;
import net.dinglisch.android.tasker.TaskerPlugin;

/* loaded from: classes3.dex */
public class LocalePluginTriggerReceiver extends WakefulBroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_ACTIVITY_CLASS_NAME);
        if (stringExtra != null) {
            Intent intent2 = new Intent(context, LocalePluginCheckerService.class);
            intent2.putExtra(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_ACTIVITY_CLASS_NAME, stringExtra);
            Bundle retrievePassThroughData = TaskerPlugin.Event.retrievePassThroughData(intent);
            if (retrievePassThroughData != null) {
                TaskerPlugin.Event.addPassThroughData(intent2, retrievePassThroughData);
            }
            WakefulBroadcastReceiver.startWakefulService(context, intent2);
        }
    }
}
