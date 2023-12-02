package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;

/* loaded from: classes6.dex */
public abstract class ItemChangeAnimationManager extends BaseItemAnimationManager<ChangeAnimationInfo> {
    public ItemChangeAnimationManager(@NonNull BaseItemAnimator baseItemAnimator) {
        super(baseItemAnimator);
    }

    public abstract boolean addPendingAnimation(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i4, int i5, int i6, int i7);

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public long getDuration() {
        return this.f33693a.getChangeDuration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    /* renamed from: n */
    public boolean f(@NonNull ChangeAnimationInfo changeAnimationInfo, @Nullable RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = changeAnimationInfo.oldHolder;
        if (viewHolder2 != null && (viewHolder == null || viewHolder2 == viewHolder)) {
            i(changeAnimationInfo, viewHolder2);
            dispatchFinished(changeAnimationInfo, changeAnimationInfo.oldHolder);
            changeAnimationInfo.clear(changeAnimationInfo.oldHolder);
        }
        RecyclerView.ViewHolder viewHolder3 = changeAnimationInfo.newHolder;
        if (viewHolder3 != null && (viewHolder == null || viewHolder3 == viewHolder)) {
            i(changeAnimationInfo, viewHolder3);
            dispatchFinished(changeAnimationInfo, changeAnimationInfo.newHolder);
            changeAnimationInfo.clear(changeAnimationInfo.newHolder);
        }
        if (changeAnimationInfo.oldHolder == null && changeAnimationInfo.newHolder == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    /* renamed from: o */
    public void k(@NonNull ChangeAnimationInfo changeAnimationInfo) {
        if (changeAnimationInfo.oldHolder != null) {
            q(changeAnimationInfo);
        }
        if (changeAnimationInfo.newHolder != null) {
            p(changeAnimationInfo);
        }
    }

    protected abstract void p(ChangeAnimationInfo changeAnimationInfo);

    protected abstract void q(ChangeAnimationInfo changeAnimationInfo);

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void setDuration(long j4) {
        this.f33693a.setChangeDuration(j4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchFinished(@NonNull ChangeAnimationInfo changeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchChangeFinished(");
            sb.append(viewHolder);
            sb.append(")");
        }
        this.f33693a.dispatchChangeFinished(viewHolder, viewHolder == changeAnimationInfo.oldHolder);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchStarting(@NonNull ChangeAnimationInfo changeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchChangeStarting(");
            sb.append(viewHolder);
            sb.append(")");
        }
        this.f33693a.dispatchChangeStarting(viewHolder, viewHolder == changeAnimationInfo.oldHolder);
    }
}
