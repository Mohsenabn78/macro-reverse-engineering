package com.afollestad.materialdialogs.color;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: classes2.dex */
public class FillGridView extends GridView {
    public FillGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public FillGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FillGridView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
