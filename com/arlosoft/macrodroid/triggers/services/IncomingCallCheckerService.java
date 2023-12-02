package com.arlosoft.macrodroid.triggers.services;

import com.arlosoft.macrodroid.triggers.IncomingCallTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;

/* loaded from: classes3.dex */
public class IncomingCallCheckerService extends BaseCallCheckerService {
    public IncomingCallCheckerService() {
        super("IncomingCallCheckerService");
    }

    @Override // com.arlosoft.macrodroid.triggers.services.BaseCallCheckerService
    protected boolean d(Trigger trigger) {
        return trigger instanceof IncomingCallTrigger;
    }
}
