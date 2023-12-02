package com.arlosoft.macrodroid.triggers.services;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.ApplicationLaunchedTrigger;
import com.arlosoft.macrodroid.triggers.RecentAppsTrigger;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: classes3.dex */
public class MacroDroidAccessibilityService extends AccessibilityService {
    public static String foregroundAppPackage = null;
    public static boolean hasInitialised = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f15500a;

    private void a(String str, String str2) {
        if (foregroundAppPackage != str) {
            foregroundAppPackage = str;
            ApplicationLaunchedTrigger.handleWindowChanged(str, str2);
            RecentAppsTrigger.handleWindowChanged(str, str2);
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        String str;
        if (accessibilityEvent.getEventType() == 32) {
            try {
                for (AccessibilityWindowInfo accessibilityWindowInfo : getWindows()) {
                    if (accessibilityWindowInfo.getType() == 1) {
                        AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
                        String str2 = TypeDescription.Generic.OfWildcardType.SYMBOL;
                        if (root != null) {
                            if (root.getPackageName() != null) {
                                str = root.getPackageName().toString();
                            } else {
                                str = TypeDescription.Generic.OfWildcardType.SYMBOL;
                            }
                            if (root.getClassName() != null) {
                                str2 = root.getClassName().toString();
                            }
                            a(str, str2);
                        } else if (accessibilityEvent.getPackageName() != null) {
                            String charSequence = accessibilityEvent.getPackageName().toString();
                            if (accessibilityEvent.getClassName() != null) {
                                str2 = accessibilityEvent.getClassName().toString();
                            }
                            a(charSequence, str2);
                        }
                    }
                }
            } catch (Exception e4) {
                SystemLog.logError(e4.toString());
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        SystemLog.logVerbose("Accessibility Service Destroyed");
        hasInitialised = false;
        super.onDestroy();
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        this.f15500a = false;
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        SystemLog.logVerbose("Accessibility Service Connected");
        this.f15500a = true;
        hasInitialised = true;
    }
}
