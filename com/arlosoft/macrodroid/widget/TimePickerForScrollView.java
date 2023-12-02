package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.TimePicker;

/* loaded from: classes3.dex */
public class TimePickerForScrollView extends TimePicker {
    public TimePickerForScrollView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (motionEvent.getActionMasked() == 0 && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
            return false;
        }
        return false;
    }

    public TimePickerForScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TimePickerForScrollView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
