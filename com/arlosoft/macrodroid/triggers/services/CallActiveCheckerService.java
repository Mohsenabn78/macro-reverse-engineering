package com.arlosoft.macrodroid.triggers.services;

import android.content.Intent;
import com.arlosoft.macrodroid.triggers.CallActiveTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.LastCallHelper;

/* loaded from: classes3.dex */
public class CallActiveCheckerService extends BaseCallCheckerService {
    public CallActiveCheckerService() {
        super("CallActiveCheckerService");
    }

    @Override // com.arlosoft.macrodroid.triggers.services.BaseCallCheckerService
    protected boolean d(Trigger trigger) {
        return trigger instanceof CallActiveTrigger;
    }

    @Override // com.arlosoft.macrodroid.triggers.services.BaseCallCheckerService
    protected String f(Intent intent) {
        String str = LastCallHelper.lastCallNumber;
        if (str == null) {
            return "";
        }
        return str;
    }
}
