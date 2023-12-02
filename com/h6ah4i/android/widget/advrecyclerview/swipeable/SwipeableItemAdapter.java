package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;

/* loaded from: classes6.dex */
public interface SwipeableItemAdapter<T extends RecyclerView.ViewHolder> {
    int onGetSwipeReactionType(@NonNull T t3, int i4, int i5, int i6);

    void onSetSwipeBackground(@NonNull T t3, int i4, int i5);

    @Nullable
    SwipeResultAction onSwipeItem(@NonNull T t3, int i4, int i5);

    void onSwipeItemStarted(@NonNull T t3, int i4);
}
