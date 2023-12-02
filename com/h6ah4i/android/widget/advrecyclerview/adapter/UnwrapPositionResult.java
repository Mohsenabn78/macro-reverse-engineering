package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class UnwrapPositionResult {
    @Nullable
    public RecyclerView.Adapter adapter;
    public int position = -1;
    @Nullable
    public Object tag;

    public void clear() {
        this.adapter = null;
        this.tag = null;
        this.position = -1;
    }

    public boolean isValid() {
        if (this.adapter != null && this.position != -1) {
            return true;
        }
        return false;
    }
}
