package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes3.dex */
public class LockableScrollView extends NestedScrollView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16462a;

    public LockableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16462a = true;
    }

    public boolean isScrollable() {
        return this.f16462a;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f16462a) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z3 = this.f16462a;
        if (z3) {
            return super.onTouchEvent(motionEvent);
        }
        return z3;
    }

    public void setScrollingEnabled(boolean z3) {
        this.f16462a = z3;
    }
}
