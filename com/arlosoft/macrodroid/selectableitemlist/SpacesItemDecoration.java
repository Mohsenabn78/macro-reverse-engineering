package com.arlosoft.macrodroid.selectableitemlist;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private int f13365a;

    public SpacesItemDecoration(int i4) {
        this.f13365a = i4 / 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int i4 = this.f13365a;
        if (paddingLeft != i4) {
            recyclerView.setPadding(i4, 0, i4, 0);
            recyclerView.setClipToPadding(false);
        }
        rect.top = 0;
        rect.bottom = 0;
        int i5 = this.f13365a;
        rect.left = i5;
        rect.right = i5;
    }
}
