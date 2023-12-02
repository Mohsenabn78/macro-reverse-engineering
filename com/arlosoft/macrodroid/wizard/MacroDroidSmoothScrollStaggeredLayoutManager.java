package com.arlosoft.macrodroid.wizard;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager2;
import eu.davidea.flexibleadapter.common.IFlexibleLayoutManager;
import eu.davidea.flexibleadapter.common.TopSnappedSmoothScroller;

/* loaded from: classes3.dex */
public class MacroDroidSmoothScrollStaggeredLayoutManager extends StaggeredGridLayoutManager2 implements IFlexibleLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView.SmoothScroller f16507a;

    public MacroDroidSmoothScrollStaggeredLayoutManager(Context context, int i4) {
        this(context, i4, 1);
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int findFirstCompletelyVisibleItemPosition() {
        return super.findFirstCompletelyVisibleItemPositions(null)[0];
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int findFirstVisibleItemPosition() {
        return super.findFirstVisibleItemPositions(null)[0];
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int findLastCompletelyVisibleItemPosition() {
        return super.findLastCompletelyVisibleItemPositions(null)[0];
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int findLastVisibleItemPosition() {
        return super.findLastVisibleItemPositions(null)[0];
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager2, androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i4) {
        this.f16507a.setTargetPosition(i4);
        startSmoothScroll(this.f16507a);
    }

    public MacroDroidSmoothScrollStaggeredLayoutManager(Context context, int i4, int i5) {
        super(i4, i5);
        this.f16507a = new TopSnappedSmoothScroller(context, this);
    }
}
