package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class AdapterPathSegment {
    @NonNull
    public final RecyclerView.Adapter adapter;
    @Nullable
    public final Object tag;

    public AdapterPathSegment(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj) {
        this.adapter = adapter;
        this.tag = obj;
    }
}
