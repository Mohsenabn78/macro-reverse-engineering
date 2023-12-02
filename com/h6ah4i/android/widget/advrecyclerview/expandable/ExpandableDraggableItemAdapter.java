package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;

/* loaded from: classes6.dex */
public interface ExpandableDraggableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    boolean onCheckChildCanDrop(int i4, int i5, int i6, int i7);

    boolean onCheckChildCanStartDrag(@NonNull CVH cvh, int i4, int i5, int i6, int i7);

    boolean onCheckGroupCanDrop(int i4, int i5);

    boolean onCheckGroupCanStartDrag(@NonNull GVH gvh, int i4, int i5, int i6);

    void onChildDragFinished(int i4, int i5, int i6, int i7, boolean z3);

    void onChildDragStarted(int i4, int i5);

    ItemDraggableRange onGetChildItemDraggableRange(@NonNull CVH cvh, int i4, int i5);

    ItemDraggableRange onGetGroupItemDraggableRange(@NonNull GVH gvh, int i4);

    void onGroupDragFinished(int i4, int i5, boolean z3);

    void onGroupDragStarted(int i4);

    void onMoveChildItem(int i4, int i5, int i6, int i7);

    void onMoveGroupItem(int i4, int i5);
}
