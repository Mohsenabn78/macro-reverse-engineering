package com.arlosoft.macrodroid.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f10014a;

    public SimpleDividerItemDecoration(Context context, @DrawableRes int i4) {
        this.f10014a = context.getResources().getDrawable(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            this.f10014a.setBounds(paddingLeft, bottom, width, this.f10014a.getIntrinsicHeight() + bottom);
            this.f10014a.draw(canvas);
        }
    }
}
