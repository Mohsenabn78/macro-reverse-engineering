package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SwipeableViewHolderUtils.java */
/* loaded from: classes6.dex */
class f {
    public static View a(@Nullable RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof SwipeableItemViewHolder) {
            return b((SwipeableItemViewHolder) viewHolder);
        }
        return null;
    }

    public static View b(@Nullable SwipeableItemViewHolder swipeableItemViewHolder) {
        if (swipeableItemViewHolder instanceof RecyclerView.ViewHolder) {
            View swipeableContainerView = swipeableItemViewHolder.getSwipeableContainerView();
            if (swipeableContainerView != ((RecyclerView.ViewHolder) swipeableItemViewHolder).itemView) {
                return swipeableContainerView;
            }
            throw new IllegalStateException("Inconsistency detected! getSwipeableContainerView() returns itemView");
        }
        return null;
    }
}
