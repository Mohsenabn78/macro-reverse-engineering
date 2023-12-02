package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: classes6.dex */
public interface ExpandableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    int getChildCount(int i4);

    @IntRange(from = -134217728, to = 134217727)
    long getChildId(int i4, int i5);

    @IntRange(from = -8388608, to = 8388607)
    int getChildItemViewType(int i4, int i5);

    int getGroupCount();

    @IntRange(from = -134217728, to = 134217727)
    long getGroupId(int i4);

    @IntRange(from = -8388608, to = 8388607)
    int getGroupItemViewType(int i4);

    boolean getInitialGroupExpandedState(int i4);

    void onBindChildViewHolder(@NonNull CVH cvh, int i4, int i5, @IntRange(from = -8388608, to = 8388607) int i6);

    void onBindChildViewHolder(@NonNull CVH cvh, int i4, int i5, @IntRange(from = -8388608, to = 8388607) int i6, List<Object> list);

    void onBindGroupViewHolder(@NonNull GVH gvh, int i4, @IntRange(from = -8388608, to = 8388607) int i5);

    void onBindGroupViewHolder(@NonNull GVH gvh, int i4, @IntRange(from = -8388608, to = 8388607) int i5, List<Object> list);

    boolean onCheckCanExpandOrCollapseGroup(@NonNull GVH gvh, int i4, int i5, int i6, boolean z3);

    @NonNull
    CVH onCreateChildViewHolder(ViewGroup viewGroup, @IntRange(from = -8388608, to = 8388607) int i4);

    @NonNull
    GVH onCreateGroupViewHolder(ViewGroup viewGroup, @IntRange(from = -8388608, to = 8388607) int i4);

    boolean onHookGroupCollapse(int i4, boolean z3);

    boolean onHookGroupCollapse(int i4, boolean z3, Object obj);

    boolean onHookGroupExpand(int i4, boolean z3);

    boolean onHookGroupExpand(int i4, boolean z3, Object obj);
}
