package com.h6ah4i.android.widget.advrecyclerview.draggable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopBottomEdgeEffectDecorator.java */
/* loaded from: classes6.dex */
public class h extends b {
    public h(@NonNull RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.b
    protected int f(int i4) {
        if (i4 == 0) {
            return 1;
        }
        if (i4 == 1) {
            return 3;
        }
        throw new IllegalArgumentException();
    }
}
