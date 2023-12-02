package com.h6ah4i.android.widget.advrecyclerview.draggable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* loaded from: classes6.dex */
public interface DraggableItemAdapter<T extends RecyclerView.ViewHolder> {
    boolean onCheckCanDrop(int i4, int i5);

    boolean onCheckCanStartDrag(@NonNull T t3, int i4, int i5, int i6);

    @Nullable
    ItemDraggableRange onGetItemDraggableRange(@NonNull T t3, int i4);

    void onItemDragFinished(int i4, int i5, boolean z3);

    void onItemDragStarted(int i4);

    void onMoveItem(int i4, int i5);
}
