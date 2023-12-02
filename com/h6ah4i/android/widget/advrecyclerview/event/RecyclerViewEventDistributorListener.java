package com.h6ah4i.android.widget.advrecyclerview.event;

import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public interface RecyclerViewEventDistributorListener {
    void onAddedToEventDistributor(@NonNull BaseRecyclerViewEventDistributor baseRecyclerViewEventDistributor);

    void onRemovedFromEventDistributor(@NonNull BaseRecyclerViewEventDistributor baseRecyclerViewEventDistributor);
}
