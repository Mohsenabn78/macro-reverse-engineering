package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class AbstractExpandableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ExpandableItemAdapter<GVH, CVH> {
    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter
    public int getChildItemViewType(int i4, int i5) {
        return 0;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter
    public int getGroupItemViewType(int i4) {
        return 0;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter
    public boolean getInitialGroupExpandedState(int i4) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i4) {
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i4) {
        return 0;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter
    public void onBindChildViewHolder(@NonNull CVH cvh, int i4, int i5, int i6, @NonNull List<Object> list) {
        onBindChildViewHolder(cvh, i4, i5, i6);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter
    public void onBindGroupViewHolder(@NonNull GVH gvh, int i4, int i5, @NonNull List<Object> list) {
        onBindGroupViewHolder(gvh, i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        throw new IllegalStateException("This method should not be called");
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter
    public boolean onHookGroupCollapse(int i4, boolean z3) {
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter
    public boolean onHookGroupExpand(int i4, boolean z3) {
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter
    public boolean onHookGroupCollapse(int i4, boolean z3, @Nullable Object obj) {
        return onHookGroupCollapse(i4, z3);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter
    public boolean onHookGroupExpand(int i4, boolean z3, @Nullable Object obj) {
        return onHookGroupExpand(i4, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
    }
}
