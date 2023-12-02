package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;

/* loaded from: classes6.dex */
public abstract class ItemRemoveAnimationManager extends BaseItemAnimationManager<RemoveAnimationInfo> {
    public ItemRemoveAnimationManager(BaseItemAnimator baseItemAnimator) {
        super(baseItemAnimator);
    }

    public abstract boolean addPendingAnimation(RecyclerView.ViewHolder viewHolder);

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public long getDuration() {
        return this.f33693a.getRemoveDuration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    /* renamed from: n */
    public boolean f(@NonNull RemoveAnimationInfo removeAnimationInfo, @Nullable RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = removeAnimationInfo.holder;
        if (viewHolder2 != null) {
            if (viewHolder == null || viewHolder2 == viewHolder) {
                i(removeAnimationInfo, viewHolder2);
                dispatchFinished(removeAnimationInfo, removeAnimationInfo.holder);
                removeAnimationInfo.clear(removeAnimationInfo.holder);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void setDuration(long j4) {
        this.f33693a.setRemoveDuration(j4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchFinished(@NonNull RemoveAnimationInfo removeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchRemoveFinished(");
            sb.append(viewHolder);
            sb.append(")");
        }
        this.f33693a.dispatchRemoveFinished(viewHolder);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchStarting(@NonNull RemoveAnimationInfo removeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchRemoveStarting(");
            sb.append(viewHolder);
            sb.append(")");
        }
        this.f33693a.dispatchRemoveStarting(viewHolder);
    }
}
