package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class AddAnimationInfo extends ItemAnimationInfo {
    public RecyclerView.ViewHolder holder;

    public AddAnimationInfo(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.holder = viewHolder;
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
        return "AddAnimationInfo{holder=" + this.holder + '}';
    }
}
