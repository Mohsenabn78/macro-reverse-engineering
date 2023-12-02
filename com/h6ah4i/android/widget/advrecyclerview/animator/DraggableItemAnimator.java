package com.h6ah4i.android.widget.advrecyclerview.animator;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class DraggableItemAnimator extends RefactoredDefaultItemAnimator {
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i4, int i5, int i6, int i7) {
        if (viewHolder == viewHolder2 && i4 == i6 && i5 == i7) {
            dispatchChangeFinished(viewHolder, true);
            return false;
        }
        return super.animateChange(viewHolder, viewHolder2, i4, i5, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator, com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator
    public void l() {
        super.l();
        super.setSupportsChangeAnimations(false);
    }
}
