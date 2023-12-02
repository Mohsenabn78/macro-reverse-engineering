package com.h6ah4i.android.widget.advrecyclerview.animator;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.AddAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ChangeAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAddAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemChangeAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemMoveAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.MoveAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.RemoveAnimationInfo;
import java.util.List;

/* loaded from: classes6.dex */
public class RefactoredDefaultItemAnimator extends GeneralItemAnimator {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        if (list.isEmpty() && !super.canReuseUpdatedViewHolder(viewHolder, list)) {
            return false;
        }
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator
    protected void k() {
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator
    public void l() {
        n(new DefaultItemAddAnimationManager(this));
        q(new DefaultItemRemoveAnimationManager(this));
        o(new DefaultItemChangeAnimationManager(this));
        p(new DefaultItemMoveAnimationManager(this));
    }

    /* loaded from: classes6.dex */
    protected static class DefaultItemAddAnimationManager extends ItemAddAnimationManager {
        public DefaultItemAddAnimationManager(@NonNull BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAddAnimationManager
        public boolean addPendingAnimation(@NonNull RecyclerView.ViewHolder viewHolder) {
            l(viewHolder);
            viewHolder.itemView.setAlpha(0.0f);
            g(new AddAnimationInfo(viewHolder));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: o */
        public void h(@NonNull AddAnimationInfo addAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
            viewHolder.itemView.setAlpha(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: p */
        public void i(@NonNull AddAnimationInfo addAnimationInfo, @Nullable RecyclerView.ViewHolder viewHolder) {
            viewHolder.itemView.setAlpha(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: r */
        public void k(@NonNull AddAnimationInfo addAnimationInfo) {
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(addAnimationInfo.holder.itemView);
            animate.alpha(1.0f);
            animate.setDuration(getDuration());
            m(addAnimationInfo, addAnimationInfo.holder, animate);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: q */
        public void j(@NonNull AddAnimationInfo addAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        }
    }

    /* loaded from: classes6.dex */
    protected static class DefaultItemChangeAnimationManager extends ItemChangeAnimationManager {
        public DefaultItemChangeAnimationManager(@NonNull BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemChangeAnimationManager
        public boolean addPendingAnimation(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i4, int i5, int i6, int i7) {
            float translationX = viewHolder.itemView.getTranslationX();
            float translationY = viewHolder.itemView.getTranslationY();
            float alpha = viewHolder.itemView.getAlpha();
            l(viewHolder);
            int i8 = (int) ((i6 - i4) - translationX);
            int i9 = (int) ((i7 - i5) - translationY);
            viewHolder.itemView.setTranslationX(translationX);
            viewHolder.itemView.setTranslationY(translationY);
            viewHolder.itemView.setAlpha(alpha);
            if (viewHolder2 != null) {
                l(viewHolder2);
                viewHolder2.itemView.setTranslationX(-i8);
                viewHolder2.itemView.setTranslationY(-i9);
                viewHolder2.itemView.setAlpha(0.0f);
            }
            g(new ChangeAnimationInfo(viewHolder, viewHolder2, i4, i5, i6, i7));
            return true;
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemChangeAnimationManager
        protected void p(@NonNull ChangeAnimationInfo changeAnimationInfo) {
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(changeAnimationInfo.newHolder.itemView);
            animate.translationX(0.0f);
            animate.translationY(0.0f);
            animate.setDuration(getDuration());
            animate.alpha(1.0f);
            m(changeAnimationInfo, changeAnimationInfo.newHolder, animate);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemChangeAnimationManager
        protected void q(@NonNull ChangeAnimationInfo changeAnimationInfo) {
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(changeAnimationInfo.oldHolder.itemView);
            animate.setDuration(getDuration());
            animate.translationX(changeAnimationInfo.toX - changeAnimationInfo.fromX);
            animate.translationY(changeAnimationInfo.toY - changeAnimationInfo.fromY);
            animate.alpha(0.0f);
            m(changeAnimationInfo, changeAnimationInfo.oldHolder, animate);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: s */
        public void i(@NonNull ChangeAnimationInfo changeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: t */
        public void j(@NonNull ChangeAnimationInfo changeAnimationInfo, @Nullable RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: r */
        public void h(@NonNull ChangeAnimationInfo changeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        }
    }

    /* loaded from: classes6.dex */
    protected static class DefaultItemMoveAnimationManager extends ItemMoveAnimationManager {
        public DefaultItemMoveAnimationManager(@NonNull BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemMoveAnimationManager
        public boolean addPendingAnimation(@NonNull RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6, int i7) {
            View view = viewHolder.itemView;
            int translationX = (int) (i4 + view.getTranslationX());
            int translationY = (int) (i5 + viewHolder.itemView.getTranslationY());
            l(viewHolder);
            int i8 = i6 - translationX;
            int i9 = i7 - translationY;
            MoveAnimationInfo moveAnimationInfo = new MoveAnimationInfo(viewHolder, translationX, translationY, i6, i7);
            if (i8 == 0 && i9 == 0) {
                dispatchFinished(moveAnimationInfo, moveAnimationInfo.holder);
                moveAnimationInfo.clear(moveAnimationInfo.holder);
                return false;
            }
            if (i8 != 0) {
                view.setTranslationX(-i8);
            }
            if (i9 != 0) {
                view.setTranslationY(-i9);
            }
            g(moveAnimationInfo);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: o */
        public void h(@NonNull MoveAnimationInfo moveAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            int i4 = moveAnimationInfo.toX - moveAnimationInfo.fromX;
            int i5 = moveAnimationInfo.toY - moveAnimationInfo.fromY;
            if (i4 != 0) {
                ViewCompat.animate(view).translationX(0.0f);
            }
            if (i5 != 0) {
                ViewCompat.animate(view).translationY(0.0f);
            }
            if (i4 != 0) {
                view.setTranslationX(0.0f);
            }
            if (i5 != 0) {
                view.setTranslationY(0.0f);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: p */
        public void i(@NonNull MoveAnimationInfo moveAnimationInfo, @Nullable RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: r */
        public void k(@NonNull MoveAnimationInfo moveAnimationInfo) {
            View view = moveAnimationInfo.holder.itemView;
            int i4 = moveAnimationInfo.toX - moveAnimationInfo.fromX;
            int i5 = moveAnimationInfo.toY - moveAnimationInfo.fromY;
            if (i4 != 0) {
                ViewCompat.animate(view).translationX(0.0f);
            }
            if (i5 != 0) {
                ViewCompat.animate(view).translationY(0.0f);
            }
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
            animate.setDuration(getDuration());
            m(moveAnimationInfo, moveAnimationInfo.holder, animate);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: q */
        public void j(@NonNull MoveAnimationInfo moveAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        }
    }

    /* loaded from: classes6.dex */
    protected static class DefaultItemRemoveAnimationManager extends ItemRemoveAnimationManager {
        public DefaultItemRemoveAnimationManager(@NonNull BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager
        public boolean addPendingAnimation(@NonNull RecyclerView.ViewHolder viewHolder) {
            l(viewHolder);
            g(new RemoveAnimationInfo(viewHolder));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: p */
        public void i(@NonNull RemoveAnimationInfo removeAnimationInfo, @Nullable RecyclerView.ViewHolder viewHolder) {
            viewHolder.itemView.setAlpha(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: q */
        public void j(@NonNull RemoveAnimationInfo removeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
            viewHolder.itemView.setAlpha(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: r */
        public void k(@NonNull RemoveAnimationInfo removeAnimationInfo) {
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(removeAnimationInfo.holder.itemView);
            animate.setDuration(getDuration());
            animate.alpha(0.0f);
            m(removeAnimationInfo, removeAnimationInfo.holder, animate);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: o */
        public void h(@NonNull RemoveAnimationInfo removeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        }
    }
}
