package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: classes6.dex */
public interface WrapperAdapter<VH extends RecyclerView.ViewHolder> extends WrappedAdapter<VH> {
    void getWrappedAdapters(@NonNull List<RecyclerView.Adapter> list);

    void release();

    void unwrapPosition(@NonNull UnwrapPositionResult unwrapPositionResult, int i4);

    int wrapPosition(@NonNull AdapterPathSegment adapterPathSegment, int i4);
}
