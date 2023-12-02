package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.annotation.NonNull;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemState;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder;

/* loaded from: classes6.dex */
public abstract class AbstractDraggableSwipeableItemViewHolder extends AbstractSwipeableItemViewHolder implements DraggableItemViewHolder {

    /* renamed from: k  reason: collision with root package name */
    private final DraggableItemState f34004k;

    public AbstractDraggableSwipeableItemViewHolder(@NonNull View view) {
        super(view);
        this.f34004k = new DraggableItemState();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder
    @NonNull
    public DraggableItemState getDragState() {
        return this.f34004k;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder
    public int getDragStateFlags() {
        return this.f34004k.getFlags();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder
    public void setDragStateFlags(int i4) {
        this.f34004k.setFlags(i4);
    }
}
