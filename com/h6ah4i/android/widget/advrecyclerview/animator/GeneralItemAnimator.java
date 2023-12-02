package com.h6ah4i.android.widget.advrecyclerview.animator;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAddAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemChangeAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemMoveAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager;

/* loaded from: classes6.dex */
public abstract class GeneralItemAnimator extends BaseItemAnimator {

    /* renamed from: b  reason: collision with root package name */
    private boolean f33686b;

    /* renamed from: c  reason: collision with root package name */
    private ItemRemoveAnimationManager f33687c;

    /* renamed from: d  reason: collision with root package name */
    private ItemAddAnimationManager f33688d;

    /* renamed from: e  reason: collision with root package name */
    private ItemChangeAnimationManager f33689e;

    /* renamed from: f  reason: collision with root package name */
    private ItemMoveAnimationManager f33690f;

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneralItemAnimator() {
        r();
    }

    private void r() {
        l();
        if (this.f33687c != null && this.f33688d != null && this.f33689e != null && this.f33690f != null) {
            return;
        }
        throw new IllegalStateException("setup incomplete");
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        if (this.f33686b) {
            StringBuilder sb = new StringBuilder();
            sb.append("animateAdd(id = ");
            sb.append(viewHolder.getItemId());
            sb.append(", position = ");
            sb.append(viewHolder.getLayoutPosition());
            sb.append(")");
        }
        return this.f33688d.addPendingAnimation(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i4, int i5, int i6, int i7) {
        String str;
        String str2;
        String str3;
        if (viewHolder == viewHolder2) {
            return this.f33690f.addPendingAnimation(viewHolder, i4, i5, i6, i7);
        }
        if (this.f33686b) {
            String str4 = "-";
            if (viewHolder == null) {
                str = "-";
            } else {
                str = Long.toString(viewHolder.getItemId());
            }
            if (viewHolder == null) {
                str2 = "-";
            } else {
                str2 = Long.toString(viewHolder.getLayoutPosition());
            }
            if (viewHolder2 == null) {
                str3 = "-";
            } else {
                str3 = Long.toString(viewHolder2.getItemId());
            }
            if (viewHolder2 != null) {
                str4 = Long.toString(viewHolder2.getLayoutPosition());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("animateChange(old.id = ");
            sb.append(str);
            sb.append(", old.position = ");
            sb.append(str2);
            sb.append(", new.id = ");
            sb.append(str3);
            sb.append(", new.position = ");
            sb.append(str4);
            sb.append(", fromX = ");
            sb.append(i4);
            sb.append(", fromY = ");
            sb.append(i5);
            sb.append(", toX = ");
            sb.append(i6);
            sb.append(", toY = ");
            sb.append(i7);
            sb.append(")");
        }
        return this.f33689e.addPendingAnimation(viewHolder, viewHolder2, i4, i5, i6, i7);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6, int i7) {
        if (this.f33686b) {
            StringBuilder sb = new StringBuilder();
            sb.append("animateMove(id = ");
            sb.append(viewHolder.getItemId());
            sb.append(", position = ");
            sb.append(viewHolder.getLayoutPosition());
            sb.append(", fromX = ");
            sb.append(i4);
            sb.append(", fromY = ");
            sb.append(i5);
            sb.append(", toX = ");
            sb.append(i6);
            sb.append(", toY = ");
            sb.append(i7);
            sb.append(")");
        }
        return this.f33690f.addPendingAnimation(viewHolder, i4, i5, i6, i7);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        if (this.f33686b) {
            StringBuilder sb = new StringBuilder();
            sb.append("animateRemove(id = ");
            sb.append(viewHolder.getItemId());
            sb.append(", position = ");
            sb.append(viewHolder.getLayoutPosition());
            sb.append(")");
        }
        return this.f33687c.addPendingAnimation(viewHolder);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator
    public boolean debugLogEnabled() {
        return this.f33686b;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator
    public boolean dispatchFinishedWhenDone() {
        if (this.f33686b) {
            isRunning();
        }
        return super.dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(@NonNull RecyclerView.ViewHolder viewHolder) {
        i(viewHolder);
        this.f33690f.endPendingAnimations(viewHolder);
        this.f33689e.endPendingAnimations(viewHolder);
        this.f33687c.endPendingAnimations(viewHolder);
        this.f33688d.endPendingAnimations(viewHolder);
        this.f33690f.endDeferredReadyAnimations(viewHolder);
        this.f33689e.endDeferredReadyAnimations(viewHolder);
        this.f33687c.endDeferredReadyAnimations(viewHolder);
        this.f33688d.endDeferredReadyAnimations(viewHolder);
        if (this.f33687c.removeFromActive(viewHolder) && this.f33686b) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [remove]");
        }
        if (this.f33688d.removeFromActive(viewHolder) && this.f33686b) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [add]");
        }
        if (this.f33689e.removeFromActive(viewHolder) && this.f33686b) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [change]");
        }
        if (this.f33690f.removeFromActive(viewHolder) && this.f33686b) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [move]");
        }
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        this.f33690f.endAllPendingAnimations();
        this.f33687c.endAllPendingAnimations();
        this.f33688d.endAllPendingAnimations();
        this.f33689e.endAllPendingAnimations();
        if (!isRunning()) {
            return;
        }
        this.f33690f.endAllDeferredReadyAnimations();
        this.f33688d.endAllDeferredReadyAnimations();
        this.f33689e.endAllDeferredReadyAnimations();
        this.f33687c.cancelAllStartedAnimations();
        this.f33690f.cancelAllStartedAnimations();
        this.f33688d.cancelAllStartedAnimations();
        this.f33689e.cancelAllStartedAnimations();
        dispatchAnimationsFinished();
    }

    protected void i(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.animate(viewHolder.itemView).cancel();
    }

    public boolean isDebug() {
        return this.f33686b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (!this.f33687c.isRunning() && !this.f33688d.isRunning() && !this.f33689e.isRunning() && !this.f33690f.isRunning()) {
            return false;
        }
        return true;
    }

    protected boolean j() {
        if (!this.f33687c.hasPending() && !this.f33690f.hasPending() && !this.f33689e.hasPending() && !this.f33688d.hasPending()) {
            return false;
        }
        return true;
    }

    protected void k() {
        m();
    }

    protected abstract void l();

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        long j4;
        long j5;
        long j6;
        boolean hasPending = this.f33687c.hasPending();
        boolean hasPending2 = this.f33690f.hasPending();
        boolean hasPending3 = this.f33689e.hasPending();
        boolean hasPending4 = this.f33688d.hasPending();
        long j7 = 0;
        if (hasPending) {
            j4 = getRemoveDuration();
        } else {
            j4 = 0;
        }
        if (hasPending2) {
            j5 = getMoveDuration();
        } else {
            j5 = 0;
        }
        if (hasPending3) {
            j6 = getChangeDuration();
        } else {
            j6 = 0;
        }
        boolean z3 = false;
        if (hasPending) {
            this.f33687c.runPendingAnimations(false, 0L);
        }
        if (hasPending2) {
            this.f33690f.runPendingAnimations(hasPending, j4);
        }
        if (hasPending3) {
            this.f33689e.runPendingAnimations(hasPending, j4);
        }
        if (hasPending4) {
            z3 = (hasPending || hasPending2 || hasPending3) ? true : true;
            long max = j4 + Math.max(j5, j6);
            if (z3) {
                j7 = max;
            }
            this.f33688d.runPendingAnimations(z3, j7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(ItemAddAnimationManager itemAddAnimationManager) {
        this.f33688d = itemAddAnimationManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(ItemChangeAnimationManager itemChangeAnimationManager) {
        this.f33689e = itemChangeAnimationManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(ItemMoveAnimationManager itemMoveAnimationManager) {
        this.f33690f = itemMoveAnimationManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(ItemRemoveAnimationManager itemRemoveAnimationManager) {
        this.f33687c = itemRemoveAnimationManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        if (!j()) {
            return;
        }
        k();
    }

    public void setDebug(boolean z3) {
        this.f33686b = z3;
    }
}
