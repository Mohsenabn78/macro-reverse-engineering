package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

/* loaded from: classes5.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f23051a;

    /* renamed from: b  reason: collision with root package name */
    private int f23052b;

    /* renamed from: c  reason: collision with root package name */
    private int f23053c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ViewPropertyAnimator f23054d;

    public HideBottomViewOnScrollBehavior() {
        this.f23051a = 0;
        this.f23052b = 2;
        this.f23053c = 0;
    }

    private void b(@NonNull V v3, int i4, long j4, TimeInterpolator timeInterpolator) {
        this.f23054d = v3.animate().translationY(i4).setInterpolator(timeInterpolator).setDuration(j4).setListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.f23054d = null;
            }
        });
    }

    public boolean isScrolledDown() {
        if (this.f23052b == 1) {
            return true;
        }
        return false;
    }

    public boolean isScrolledUp() {
        if (this.f23052b == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, int i4) {
        this.f23051a = v3.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v3.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v3, i4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, int i4, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
        if (i5 > 0) {
            slideDown(v3);
        } else if (i5 < 0) {
            slideUp(v3);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull View view, @NonNull View view2, int i4, int i5) {
        if (i4 == 2) {
            return true;
        }
        return false;
    }

    public void setAdditionalHiddenOffsetY(@NonNull V v3, @Dimension int i4) {
        this.f23053c = i4;
        if (this.f23052b == 1) {
            v3.setTranslationY(this.f23051a + i4);
        }
    }

    public void slideDown(@NonNull V v3) {
        slideDown(v3, true);
    }

    public void slideUp(@NonNull V v3) {
        slideUp(v3, true);
    }

    public void slideDown(@NonNull V v3, boolean z3) {
        if (isScrolledDown()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f23054d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f23052b = 1;
        int i4 = this.f23051a + this.f23053c;
        if (z3) {
            b(v3, i4, 175L, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        } else {
            v3.setTranslationY(i4);
        }
    }

    public void slideUp(@NonNull V v3, boolean z3) {
        if (isScrolledUp()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f23054d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v3.clearAnimation();
        }
        this.f23052b = 2;
        if (z3) {
            b(v3, 0, 225L, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        } else {
            v3.setTranslationY(0);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23051a = 0;
        this.f23052b = 2;
        this.f23053c = 0;
    }
}
