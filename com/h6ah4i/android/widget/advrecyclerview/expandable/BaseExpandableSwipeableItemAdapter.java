package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* loaded from: classes6.dex */
public interface BaseExpandableSwipeableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    int onGetChildItemSwipeReactionType(@NonNull CVH cvh, int i4, int i5, int i6, int i7);

    int onGetGroupItemSwipeReactionType(@NonNull GVH gvh, int i4, int i5, int i6);

    void onSetChildItemSwipeBackground(@NonNull CVH cvh, int i4, int i5, int i6);

    void onSetGroupItemSwipeBackground(@NonNull GVH gvh, int i4, int i5);

    void onSwipeChildItemStarted(@NonNull CVH cvh, int i4, int i5);

    void onSwipeGroupItemStarted(@NonNull GVH gvh, int i4);
}
