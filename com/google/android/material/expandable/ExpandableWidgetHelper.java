package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes5.dex */
public final class ExpandableWidgetHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f23609a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23610b = false;
    @IdRes

    /* renamed from: c  reason: collision with root package name */
    private int f23611c = 0;

    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.f23609a = (View) expandableWidget;
    }

    private void a() {
        ViewParent parent = this.f23609a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.f23609a);
        }
    }

    @IdRes
    public int getExpandedComponentIdHint() {
        return this.f23611c;
    }

    public boolean isExpanded() {
        return this.f23610b;
    }

    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        this.f23610b = bundle.getBoolean("expanded", false);
        this.f23611c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f23610b) {
            a();
        }
    }

    @NonNull
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f23610b);
        bundle.putInt("expandedComponentIdHint", this.f23611c);
        return bundle;
    }

    public boolean setExpanded(boolean z3) {
        if (this.f23610b != z3) {
            this.f23610b = z3;
            a();
            return true;
        }
        return false;
    }

    public void setExpandedComponentIdHint(@IdRes int i4) {
        this.f23611c = i4;
    }
}
