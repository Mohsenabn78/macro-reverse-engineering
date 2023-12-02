package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemState;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder;

/* loaded from: classes6.dex */
public abstract class AbstractExpandableItemViewHolder extends RecyclerView.ViewHolder implements ExpandableItemViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final ExpandableItemState f34005a;

    public AbstractExpandableItemViewHolder(@NonNull View view) {
        super(view);
        this.f34005a = new ExpandableItemState();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder
    @NonNull
    public ExpandableItemState getExpandState() {
        return this.f34005a;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder
    public int getExpandStateFlags() {
        return this.f34005a.getFlags();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder
    public void setExpandStateFlags(int i4) {
        this.f34005a.setFlags(i4);
    }
}
