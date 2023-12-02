package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes5.dex */
class ClickActionDelegate extends AccessibilityDelegateCompat {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat f24710a;

    public ClickActionDelegate(Context context, int i4) {
        this.f24710a = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i4));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(this.f24710a);
    }
}
