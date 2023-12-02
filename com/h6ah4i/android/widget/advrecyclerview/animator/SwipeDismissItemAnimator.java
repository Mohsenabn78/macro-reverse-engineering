package com.h6ah4i.android.widget.advrecyclerview.animator;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.RemoveAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder;

/* loaded from: classes6.dex */
public class SwipeDismissItemAnimator extends DraggableItemAnimator {
    public static final Interpolator MOVE_INTERPOLATOR = new AccelerateDecelerateInterpolator();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static class SwipeDismissRemoveAnimationInfo extends RemoveAnimationInfo {
        public SwipeDismissRemoveAnimationInfo(@NonNull RecyclerView.ViewHolder viewHolder) {
            super(viewHolder);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.DraggableItemAnimator, com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator, com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator
    protected void l() {
        n(new RefactoredDefaultItemAnimator.DefaultItemAddAnimationManager(this));
        q(new SwipeDismissItemRemoveAnimationManager(this));
        o(new RefactoredDefaultItemAnimator.DefaultItemChangeAnimationManager(this));
        p(new RefactoredDefaultItemAnimator.DefaultItemMoveAnimationManager(this));
        setRemoveDuration(150L);
        setMoveDuration(150L);
    }

    /* loaded from: classes6.dex */
    protected static class SwipeDismissItemRemoveAnimationManager extends ItemRemoveAnimationManager {

        /* renamed from: f  reason: collision with root package name */
        protected static final Interpolator f33691f = new AccelerateDecelerateInterpolator();

        public SwipeDismissItemRemoveAnimationManager(@NonNull BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        protected static boolean o(RecyclerView.ViewHolder viewHolder) {
            if (!(viewHolder instanceof SwipeableItemViewHolder)) {
                return false;
            }
            SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
            int swipeResult = swipeableItemViewHolder.getSwipeResult();
            int afterSwipeReaction = swipeableItemViewHolder.getAfterSwipeReaction();
            if ((swipeResult != 2 && swipeResult != 3 && swipeResult != 4 && swipeResult != 5) || afterSwipeReaction != 1) {
                return false;
            }
            return true;
        }

        protected static boolean p(RemoveAnimationInfo removeAnimationInfo) {
            return removeAnimationInfo instanceof SwipeDismissRemoveAnimationInfo;
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager
        public boolean addPendingAnimation(@NonNull RecyclerView.ViewHolder viewHolder) {
            if (o(viewHolder)) {
                View view = viewHolder.itemView;
                e(viewHolder);
                view.setTranslationX((int) (view.getTranslationX() + 0.5f));
                view.setTranslationY((int) (view.getTranslationY() + 0.5f));
                g(new SwipeDismissRemoveAnimationInfo(viewHolder));
                return true;
            }
            e(viewHolder);
            g(new RemoveAnimationInfo(viewHolder));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: r */
        public void i(@NonNull RemoveAnimationInfo removeAnimationInfo, @Nullable RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (p(removeAnimationInfo)) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                return;
            }
            view.setAlpha(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: s */
        public void j(@NonNull RemoveAnimationInfo removeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (p(removeAnimationInfo)) {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                return;
            }
            view.setAlpha(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: t */
        public void k(@NonNull RemoveAnimationInfo removeAnimationInfo) {
            ViewPropertyAnimatorCompat animate;
            if (o(removeAnimationInfo.holder)) {
                animate = ViewCompat.animate(removeAnimationInfo.holder.itemView);
                animate.setDuration(getDuration());
            } else {
                animate = ViewCompat.animate(removeAnimationInfo.holder.itemView);
                animate.setDuration(getDuration());
                animate.setInterpolator(f33691f);
                animate.alpha(0.0f);
            }
            m(removeAnimationInfo, removeAnimationInfo.holder, animate);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        /* renamed from: q */
        public void h(@NonNull RemoveAnimationInfo removeAnimationInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        }
    }
}
