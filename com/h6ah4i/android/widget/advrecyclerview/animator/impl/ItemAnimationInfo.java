package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public abstract class ItemAnimationInfo {
    public abstract void clear(@NonNull RecyclerView.ViewHolder viewHolder);

    @Nullable
    public abstract RecyclerView.ViewHolder getAvailableViewHolder();
}
