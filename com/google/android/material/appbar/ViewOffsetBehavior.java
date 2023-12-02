package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes5.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private ViewOffsetHelper f22999a;

    /* renamed from: b  reason: collision with root package name */
    private int f23000b;

    /* renamed from: c  reason: collision with root package name */
    private int f23001c;

    public ViewOffsetBehavior() {
        this.f23000b = 0;
        this.f23001c = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i4) {
        coordinatorLayout.onLayoutChild(v3, i4);
    }

    public int getLeftAndRightOffset() {
        ViewOffsetHelper viewOffsetHelper = this.f22999a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.c();
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper viewOffsetHelper = this.f22999a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.d();
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        ViewOffsetHelper viewOffsetHelper = this.f22999a;
        if (viewOffsetHelper != null && viewOffsetHelper.e()) {
            return true;
        }
        return false;
    }

    public boolean isVerticalOffsetEnabled() {
        ViewOffsetHelper viewOffsetHelper = this.f22999a;
        if (viewOffsetHelper != null && viewOffsetHelper.f()) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i4) {
        a(coordinatorLayout, v3, i4);
        if (this.f22999a == null) {
            this.f22999a = new ViewOffsetHelper(v3);
        }
        this.f22999a.g();
        this.f22999a.a();
        int i5 = this.f23000b;
        if (i5 != 0) {
            this.f22999a.j(i5);
            this.f23000b = 0;
        }
        int i6 = this.f23001c;
        if (i6 != 0) {
            this.f22999a.i(i6);
            this.f23001c = 0;
            return true;
        }
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z3) {
        ViewOffsetHelper viewOffsetHelper = this.f22999a;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.h(z3);
        }
    }

    public boolean setLeftAndRightOffset(int i4) {
        ViewOffsetHelper viewOffsetHelper = this.f22999a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.i(i4);
        }
        this.f23001c = i4;
        return false;
    }

    public boolean setTopAndBottomOffset(int i4) {
        ViewOffsetHelper viewOffsetHelper = this.f22999a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.j(i4);
        }
        this.f23000b = i4;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z3) {
        ViewOffsetHelper viewOffsetHelper = this.f22999a;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.k(z3);
        }
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23000b = 0;
        this.f23001c = 0;
    }
}
