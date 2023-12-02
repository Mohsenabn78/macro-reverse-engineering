package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class MoveAnimationInfo extends ItemAnimationInfo {
    public final int fromX;
    public final int fromY;
    public RecyclerView.ViewHolder holder;
    public final int toX;
    public final int toY;

    public MoveAnimationInfo(@NonNull RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6, int i7) {
        this.holder = viewHolder;
        this.fromX = i4;
        this.fromY = i5;
        this.toX = i6;
        this.toY = i7;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAnimationInfo
    public void clear(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (this.holder == viewHolder) {
            this.holder = null;
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAnimationInfo
    @Nullable
    public RecyclerView.ViewHolder getAvailableViewHolder() {
        return this.holder;
    }

    @NonNull
    public String toString() {
        return "MoveAnimationInfo{holder=" + this.holder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
    }
}
