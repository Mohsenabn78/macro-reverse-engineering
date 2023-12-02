package com.arlosoft.macrodroid.triggers.services;

import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.arlosoft.macrodroid.triggers.CallEndedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.LastCallHelper;

/* loaded from: classes3.dex */
public class CallEndedCheckerService extends BaseCallCheckerService {
    public CallEndedCheckerService() {
        super("CallEndedCheckerService");
    }

    @Override // com.arlosoft.macrodroid.triggers.services.BaseCallCheckerService
    protected boolean d(Trigger trigger) {
        return trigger instanceof CallEndedTrigger;
    }

    @Override // com.arlosoft.macrodroid.triggers.services.BaseCallCheckerService
    protected void e(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    @Override // com.arlosoft.macrodroid.triggers.services.BaseCallCheckerService
    protected String f(Intent intent) {
        return LastCallHelper.lastCallNumber;
    }
}
