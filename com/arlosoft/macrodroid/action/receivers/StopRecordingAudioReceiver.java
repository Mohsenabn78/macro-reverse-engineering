package com.arlosoft.macrodroid.action.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.action.RecordMicrophoneAction;

/* loaded from: classes2.dex */
public class StopRecordingAudioReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        RecordMicrophoneAction.stopRecording();
    }
}
