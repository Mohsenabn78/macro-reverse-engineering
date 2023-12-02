package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;

/* loaded from: classes6.dex */
public abstract class ItemAddAnimationManager extends BaseItemAnimationManager<AddAnimationInfo> {
    public ItemAddAnimationManager(BaseItemAnimator baseItemAnimator) {
        super(baseItemAnimator);
    }

    public abstract boolean addPendingAnimation(RecyclerView.ViewHolder viewHolder);

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public long getDuration() {
        return this.f33693a.getAddDuration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    /* renamed from: n */
    public boolean f(@NonNull AddAnimationInfo addAnimationInfo, @Nullable RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = addAnimationInfo.holder;
        if (viewHolder2 != null) {
            if (viewHolder == null || viewHolder2 == viewHolder) {
                i(addAnimationInfo, viewHolder2);
                dispatchFinished(addAnimationInfo, addAnimationInfo.holder);
                addAnimationInfo.clear(addAnimationInfo.holder);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void setDuration(long j4) {
        this.f33693a.setAddDuration(j4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchFinished(@NonNull AddAnimationInfo addAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchAddFinished(");
            sb.append(viewHolder);
            sb.append(")");
        }
        this.f33693a.dispatchAddFinished(viewHolder);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public void dispatchStarting(@NonNull AddAnimationInfo addAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchAddStarting(");
            sb.append(viewHolder);
            sb.append(")");
        }
        this.f33693a.dispatchAddStarting(viewHolder);
    }
}
