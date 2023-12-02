package com.arlosoft.macrodroid.triggers.services;

import android.accessibilityservice.AccessibilityService;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.VolumeButtonTrigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class VolumeButtonAccessibilityService extends AccessibilityService {
    public static boolean isInitialised = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f15562a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15563b = false;

    @Override // android.app.Service
    public void onDestroy() {
        SystemLog.logVerbose("Volume Button Accessibility Service Destroyed");
        isInitialised = false;
        super.onDestroy();
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected boolean onKeyEvent(KeyEvent keyEvent) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = true;
        if (keyEvent.getKeyCode() == 25) {
            z3 = false;
            z4 = true;
        } else {
            if (keyEvent.getKeyCode() == 24) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 25 || keyEvent.getKeyCode() == 24) {
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof VolumeButtonTrigger) && next.constraintsMet()) {
                            VolumeButtonTrigger volumeButtonTrigger = (VolumeButtonTrigger) next;
                            if (volumeButtonTrigger.getMonitorOption() == 0 && ((volumeButtonTrigger.isVolumeUp() && z3) || (!volumeButtonTrigger.isVolumeUp() && z4))) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo()) && volumeButtonTrigger.isDontChangeVolume()) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            if (keyEvent.getKeyCode() == 25) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f15562a = z6;
            if (keyEvent.getKeyCode() != 24) {
                z7 = false;
            }
            this.f15563b = z7;
        } else if (keyEvent.getAction() == 1 && (keyEvent.getKeyCode() == 25 || keyEvent.getKeyCode() == 24)) {
            if (keyEvent.getEventTime() - keyEvent.getDownTime() > 300) {
                z5 = true;
            } else {
                z5 = false;
            }
            ArrayList arrayList = new ArrayList();
            boolean z8 = false;
            for (Macro macro2 : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it2 = macro2.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Trigger next2 = it2.next();
                        if ((next2 instanceof VolumeButtonTrigger) && next2.constraintsMet()) {
                            VolumeButtonTrigger volumeButtonTrigger2 = (VolumeButtonTrigger) next2;
                            if (volumeButtonTrigger2.getMonitorOption() == 0 && ((volumeButtonTrigger2.isVolumeUp() && z3) || (!volumeButtonTrigger2.isVolumeUp() && z4))) {
                                if (volumeButtonTrigger2.isLongPress() == z5) {
                                    macro2.setTriggerThatInvoked(next2);
                                    if (macro2.canInvoke(macro2.getTriggerContextInfo())) {
                                        arrayList.add(macro2);
                                        z8 = true;
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Macro macro3 = (Macro) it3.next();
                macro3.invokeActions(macro3.getTriggerContextInfo());
            }
            if (!z8) {
                AudioManager audioManager = (AudioManager) getSystemService("audio");
                if (keyEvent.getKeyCode() == 25) {
                    if (!this.f15562a) {
                        audioManager.adjustVolume(-1, 1);
                    }
                    this.f15562a = false;
                } else if (keyEvent.getKeyCode() == 24) {
                    if (!this.f15563b) {
                        audioManager.adjustVolume(1, 1);
                    }
                    this.f15563b = false;
                }
            }
        }
        return false;
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        SystemLog.logVerbose("Volume Button Accessibility Service Connected");
        isInitialised = true;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }
}
