package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class SelectableItemsRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16468a;

    public SelectableItemsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16468a = false;
        setExpanded(true);
    }

    private boolean a() {
        return this.f16468a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i4, int i5) {
        if (a()) {
            super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i4, i5);
        getLayoutParams().height = -2;
    }

    public void setExpanded(boolean z3) {
        this.f16468a = z3;
    }
}
