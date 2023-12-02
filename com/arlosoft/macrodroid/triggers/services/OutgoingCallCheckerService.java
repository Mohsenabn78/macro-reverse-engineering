package com.arlosoft.macrodroid.triggers.services;

import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.arlosoft.macrodroid.triggers.OutgoingCallTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;

/* loaded from: classes3.dex */
public class OutgoingCallCheckerService extends BaseCallCheckerService {
    public OutgoingCallCheckerService() {
        super("OutgoingCallCheckerService");
    }

    @Override // com.arlosoft.macrodroid.triggers.services.BaseCallCheckerService
    protected boolean d(Trigger trigger) {
        return trigger instanceof OutgoingCallTrigger;
    }

    @Override // com.arlosoft.macrodroid.triggers.services.BaseCallCheckerService
    protected void e(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
