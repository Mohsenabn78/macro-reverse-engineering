package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public interface ExpandableItemViewHolder {
    @NonNull
    ExpandableItemState getExpandState();

    int getExpandStateFlags();

    void setExpandStateFlags(int i4);
}
