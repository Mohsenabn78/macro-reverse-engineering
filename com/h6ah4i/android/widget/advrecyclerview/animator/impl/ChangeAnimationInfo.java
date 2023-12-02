package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class ChangeAnimationInfo extends ItemAnimationInfo {
    public int fromX;
    public int fromY;
    public RecyclerView.ViewHolder newHolder;
    public RecyclerView.ViewHolder oldHolder;
    public int toX;
    public int toY;

    public ChangeAnimationInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i4, int i5, int i6, int i7) {
        this.oldHolder = viewHolder;
        this.newHolder = viewHolder2;
        this.fromX = i4;
        this.fromY = i5;
        this.toX = i6;
        this.toY = i7;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAnimationInfo
    public void clear(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (this.oldHolder == viewHolder) {
            this.oldHolder = null;
        }
        if (this.newHolder == viewHolder) {
            this.newHolder = null;
        }
        if (this.oldHolder == null && this.newHolder == null) {
            this.fromX = 0;
            this.fromY = 0;
            this.toX = 0;
            this.toY = 0;
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAnimationInfo
    public RecyclerView.ViewHolder getAvailableViewHolder() {
        RecyclerView.ViewHolder viewHolder = this.oldHolder;
        if (viewHolder == null) {
            return this.newHolder;
        }
        return viewHolder;
    }

    @NonNull
    public String toString() {
        return "ChangeInfo{, oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
    }
}
