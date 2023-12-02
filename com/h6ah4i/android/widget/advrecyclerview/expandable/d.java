package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;

/* compiled from: ExpandableSwipeableItemInternalUtils.java */
/* loaded from: classes6.dex */
class d {
    public static SwipeResultAction a(@NonNull BaseExpandableSwipeableItemAdapter<?, ?> baseExpandableSwipeableItemAdapter, @NonNull RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6) {
        if (i5 == -1) {
            return ((ExpandableSwipeableItemAdapter) baseExpandableSwipeableItemAdapter).onSwipeGroupItem(viewHolder, i4, i6);
        }
        return ((ExpandableSwipeableItemAdapter) baseExpandableSwipeableItemAdapter).onSwipeChildItem(viewHolder, i4, i5, i6);
    }
}
