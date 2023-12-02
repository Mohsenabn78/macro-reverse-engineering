package com.h6ah4i.android.widget.advrecyclerview.draggable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LeftRightEdgeEffectDecorator.java */
/* loaded from: classes6.dex */
public class f extends b {
    public f(@NonNull RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.b
    protected int f(int i4) {
        if (i4 != 0) {
            if (i4 == 1) {
                return 2;
            }
            throw new IllegalArgumentException();
        }
        return 0;
    }
}
