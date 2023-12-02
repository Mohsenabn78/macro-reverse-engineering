package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class RecyclerViewAdapterUtils {
    private RecyclerViewAdapterUtils() {
    }

    @Nullable
    public static RecyclerView getParentRecyclerView(@Nullable View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof RecyclerView) {
            return (RecyclerView) parent;
        }
        if (!(parent instanceof View)) {
            return null;
        }
        return getParentRecyclerView((View) parent);
    }

    @Nullable
    public static View getParentViewHolderItemView(@Nullable View view) {
        RecyclerView parentRecyclerView = getParentRecyclerView(view);
        if (parentRecyclerView == null) {
            return null;
        }
        return parentRecyclerView.findContainingItemView(view);
    }

    @Nullable
    public static RecyclerView.ViewHolder getViewHolder(@Nullable View view) {
        RecyclerView parentRecyclerView = getParentRecyclerView(view);
        if (parentRecyclerView == null) {
            return null;
        }
        return parentRecyclerView.findContainingViewHolder(view);
    }
}
