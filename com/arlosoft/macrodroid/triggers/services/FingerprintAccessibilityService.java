package com.arlosoft.macrodroid.triggers.services;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.FingerprintGestureController;
import android.os.Build;
import android.os.Handler;
import android.view.accessibility.AccessibilityEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.FingerprintGestureTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class FingerprintAccessibilityService extends AccessibilityService {
    public static boolean isInitialised = false;

    /* loaded from: classes3.dex */
    class a extends FingerprintGestureController.FingerprintGestureCallback {
        a() {
        }

        @Override // android.accessibilityservice.FingerprintGestureController.FingerprintGestureCallback
        public void onGestureDetected(int i4) {
            super.onGestureDetected(i4);
            FingerprintAccessibilityService.this.b(i4);
        }

        @Override // android.accessibilityservice.FingerprintGestureController.FingerprintGestureCallback
        public void onGestureDetectionAvailabilityChanged(boolean z3) {
            super.onGestureDetectionAvailabilityChanged(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if ((next instanceof FingerprintGestureTrigger) && ((FingerprintGestureTrigger) next).checkMatchesGesture(i4) && next.constraintsMet()) {
                    macro.setTriggerThatInvoked(next);
                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                        arrayList.add(macro);
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        SystemLog.logVerbose("Fingerprint Accessibility Service Destroyed");
        isInitialised = false;
        super.onDestroy();
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        FingerprintGestureController fingerprintGestureController;
        boolean isGestureDetectionAvailable;
        SystemLog.logInfo("Fingerprint accessibility service connected");
        isInitialised = true;
        if (Build.VERSION.SDK_INT >= 26 && (fingerprintGestureController = getFingerprintGestureController()) != null) {
            try {
                isGestureDetectionAvailable = fingerprintGestureController.isGestureDetectionAvailable();
                if (isGestureDetectionAvailable) {
                    SystemLog.logInfo("Device reports that Fingerprint gesture detection is available (although it may still not be implemented on some devices that report this)");
                } else {
                    SystemLog.logInfo("Device reports that Fingerprint gesture detection is not available");
                }
            } catch (Exception unused) {
            }
            fingerprintGestureController.registerFingerprintGestureCallback(new a(), new Handler());
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }
}
