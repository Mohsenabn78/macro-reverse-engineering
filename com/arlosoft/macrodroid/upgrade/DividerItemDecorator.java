package com.arlosoft.macrodroid.upgrade;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class DividerItemDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f15872a;

    public DividerItemDecorator(Drawable drawable) {
        this.f15872a = drawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 <= childCount - 2; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            this.f15872a.setBounds(paddingLeft, bottom, width, this.f15872a.getIntrinsicHeight() + bottom);
            this.f15872a.draw(canvas);
        }
    }
}
