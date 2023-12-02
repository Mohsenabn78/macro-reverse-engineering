package com.h6ah4i.android.widget.advrecyclerview.utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter;
import com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter;

/* loaded from: classes6.dex */
public class WrappedAdapterUtils {
    private WrappedAdapterUtils() {
    }

    public static boolean invokeOnFailedToRecycleView(@NonNull RecyclerView.Adapter adapter, @NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        if (adapter instanceof WrappedAdapter) {
            return ((WrappedAdapter) adapter).onFailedToRecycleView(viewHolder, i4);
        }
        return adapter.onFailedToRecycleView(viewHolder);
    }

    public static void invokeOnViewAttachedToWindow(@NonNull RecyclerView.Adapter adapter, @NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        if (adapter instanceof WrappedAdapter) {
            ((WrappedAdapter) adapter).onViewAttachedToWindow(viewHolder, i4);
        } else {
            adapter.onViewAttachedToWindow(viewHolder);
        }
    }

    public static void invokeOnViewDetachedFromWindow(@NonNull RecyclerView.Adapter adapter, @NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        if (adapter instanceof WrappedAdapter) {
            ((WrappedAdapter) adapter).onViewDetachedFromWindow(viewHolder, i4);
        } else {
            adapter.onViewDetachedFromWindow(viewHolder);
        }
    }

    public static void invokeOnViewRecycled(@NonNull RecyclerView.Adapter adapter, @NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        if (adapter instanceof WrapperAdapter) {
            ((WrapperAdapter) adapter).onViewRecycled(viewHolder, i4);
        } else {
            adapter.onViewRecycled(viewHolder);
        }
    }
}
