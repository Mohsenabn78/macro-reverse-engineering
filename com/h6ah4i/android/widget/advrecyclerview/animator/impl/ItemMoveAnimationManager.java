package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;

/* loaded from: classes6.dex */
public abstract class ItemMoveAnimationManager extends BaseItemAnimationManager<MoveAnimationInfo> {
    public static final String TAG = "ARVItemMoveAnimMgr";

    public ItemMoveAnimationManager(@NonNull BaseItemAnimator baseItemAnimator) {
        super(baseItemAnimator);
    }

    public abstract boolean addPendingAnimation(@NonNull RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6, int i7);

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public long getDuration() {
        return this.f33693a.getMoveDuration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    /* renamed from: n */
    public boolean f(@NonNull MoveAnimationInfo moveAnimationInfo, @Nullable RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = moveAnimationInfo.holder;
        if (viewHolder2 != null) {
            if (viewHolder == null || viewHolder2 == viewHolder) {
                i(moveAnimationInfo, viewHolder2);
                dispatchFinished(moveAnimationInfo, moveAnimationInfo.holder);
                moveAnimationInfo.clear(moveAnimationInfo.holder);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void setDuration(long j4) {
        this.f33693a.setMoveDuration(j4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchFinished(@NonNull MoveAnimationInfo moveAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchMoveFinished(");
            sb.append(viewHolder);
            sb.append(")");
        }
        this.f33693a.dispatchMoveFinished(viewHolder);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchStarting(@NonNull MoveAnimationInfo moveAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchMoveStarting(");
            sb.append(viewHolder);
            sb.append(")");
        }
        this.f33693a.dispatchMoveStarting(viewHolder);
    }
}
