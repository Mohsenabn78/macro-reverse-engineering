package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {

    /* renamed from: s  reason: collision with root package name */
    private static final int f22902s = R.style.Widget_Design_AppBarLayout;

    /* renamed from: a  reason: collision with root package name */
    private int f22903a;

    /* renamed from: b  reason: collision with root package name */
    private int f22904b;

    /* renamed from: c  reason: collision with root package name */
    private int f22905c;

    /* renamed from: d  reason: collision with root package name */
    private int f22906d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22907e;

    /* renamed from: f  reason: collision with root package name */
    private int f22908f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private WindowInsetsCompat f22909g;

    /* renamed from: h  reason: collision with root package name */
    private List<BaseOnOffsetChangedListener> f22910h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22911i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f22912j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22913k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f22914l;
    @IdRes

    /* renamed from: m  reason: collision with root package name */
    private int f22915m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private WeakReference<View> f22916n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private ValueAnimator f22917o;

    /* renamed from: p  reason: collision with root package name */
    private final List<LiftOnScrollListener> f22918p;

    /* renamed from: q  reason: collision with root package name */
    private int[] f22919q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private Drawable f22920r;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* renamed from: k  reason: collision with root package name */
        private int f22924k;

        /* renamed from: l  reason: collision with root package name */
        private int f22925l;

        /* renamed from: m  reason: collision with root package name */
        private ValueAnimator f22926m;

        /* renamed from: n  reason: collision with root package name */
        private SavedState f22927n;
        @Nullable

        /* renamed from: o  reason: collision with root package name */
        private WeakReference<View> f22928o;

        /* renamed from: p  reason: collision with root package name */
        private BaseDragCallback f22929p;

        /* loaded from: classes5.dex */
        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean canDrag(@NonNull T t3);
        }

        public BaseBehavior() {
        }

        private boolean B(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3) {
            List<View> dependents = coordinatorLayout.getDependents(t3);
            int size = dependents.size();
            for (int i4 = 0; i4 < size; i4++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i4).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) behavior).getOverlayTop() == 0) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        private void C(CoordinatorLayout coordinatorLayout, @NonNull T t3) {
            int g4 = g();
            int v3 = v(t3, g4);
            if (v3 >= 0) {
                View childAt = t3.getChildAt(v3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int scrollFlags = layoutParams.getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i4 = -childAt.getTop();
                    int i5 = -childAt.getBottom();
                    if (v3 == t3.getChildCount() - 1) {
                        i5 += t3.getTopInset() + t3.getPaddingTop();
                    }
                    if (s(scrollFlags, 2)) {
                        i5 += ViewCompat.getMinimumHeight(childAt);
                    } else if (s(scrollFlags, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i5;
                        if (g4 < minimumHeight) {
                            i4 = minimumHeight;
                        } else {
                            i5 = minimumHeight;
                        }
                    }
                    if (s(scrollFlags, 32)) {
                        i4 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i5 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (g4 < (i5 + i4) / 2) {
                        i4 = i5;
                    }
                    o(coordinatorLayout, t3, MathUtils.clamp(i4, -t3.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void D(CoordinatorLayout coordinatorLayout, @NonNull T t3) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View t4 = t(coordinatorLayout);
            if (t4 == null || t3.getTotalScrollRange() == 0 || !(((CoordinatorLayout.LayoutParams) t4.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            m(coordinatorLayout, t3, t4);
        }

        private void E(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3, int i4, int i5, boolean z3) {
            View u3 = u(t3, i4);
            boolean z4 = false;
            if (u3 != null) {
                int scrollFlags = ((LayoutParams) u3.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(u3);
                    if (i5 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i4) < (u3.getBottom() - minimumHeight) - t3.getTopInset()) : (-i4) >= (u3.getBottom() - minimumHeight) - t3.getTopInset()) {
                        z4 = true;
                    }
                }
            }
            if (t3.isLiftOnScroll()) {
                z4 = t3.s(t(coordinatorLayout));
            }
            boolean p4 = t3.p(z4);
            if (z3 || (p4 && B(coordinatorLayout, t3))) {
                t3.jumpDrawablesToCurrentState();
            }
        }

        private void m(final CoordinatorLayout coordinatorLayout, @NonNull final T t3, @NonNull final View view) {
            if (g() != (-t3.getTotalScrollRange()) && view.canScrollVertically(1)) {
                n(coordinatorLayout, t3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            }
            if (g() != 0) {
                if (view.canScrollVertically(-1)) {
                    final int i4 = -t3.getDownNestedPreScrollRange();
                    if (i4 != 0) {
                        ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AccessibilityViewCommand() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                            public boolean perform(@NonNull View view2, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                                BaseBehavior.this.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) t3, view, 0, i4, new int[]{0, 0}, 1);
                                return true;
                            }
                        });
                        return;
                    }
                    return;
                }
                n(coordinatorLayout, t3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            }
        }

        private void n(CoordinatorLayout coordinatorLayout, @NonNull final T t3, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, final boolean z3) {
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new AccessibilityViewCommand() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    t3.setExpanded(z3);
                    return true;
                }
            });
        }

        private void o(CoordinatorLayout coordinatorLayout, @NonNull T t3, int i4, float f4) {
            int height;
            int abs = Math.abs(g() - i4);
            float abs2 = Math.abs(f4);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t3.getHeight()) + 1.0f) * 150.0f);
            }
            p(coordinatorLayout, t3, i4, height);
        }

        private void p(final CoordinatorLayout coordinatorLayout, final T t3, int i4, int i5) {
            int g4 = g();
            if (g4 == i4) {
                ValueAnimator valueAnimator = this.f22926m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f22926m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f22926m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f22926m = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.f22926m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator4) {
                        BaseBehavior.this.j(coordinatorLayout, t3, ((Integer) valueAnimator4.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.f22926m.setDuration(Math.min(i5, 600));
            this.f22926m.setIntValues(g4, i4);
            this.f22926m.start();
        }

        private boolean r(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3, @NonNull View view) {
            if (t3.i() && coordinatorLayout.getHeight() - view.getHeight() <= t3.getHeight()) {
                return true;
            }
            return false;
        }

        private static boolean s(int i4, int i5) {
            if ((i4 & i5) == i5) {
                return true;
            }
            return false;
        }

        @Nullable
        private View t(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = coordinatorLayout.getChildAt(i4);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View u(@NonNull AppBarLayout appBarLayout, int i4) {
            int abs = Math.abs(i4);
            int childCount = appBarLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = appBarLayout.getChildAt(i5);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int v(@NonNull T t3, int i4) {
            int childCount = t3.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = t3.getChildAt(i5);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (s(layoutParams.getScrollFlags(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i6 = -i4;
                if (top <= i6 && bottom >= i6) {
                    return i5;
                }
            }
            return -1;
        }

        private int y(@NonNull T t3, int i4) {
            int abs = Math.abs(i4);
            int childCount = t3.getChildCount();
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    break;
                }
                View childAt = t3.getChildAt(i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    if (scrollInterpolator != null) {
                        int scrollFlags = layoutParams.getScrollFlags();
                        if ((scrollFlags & 1) != 0) {
                            i5 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if ((scrollFlags & 2) != 0) {
                                i5 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i5 -= t3.getTopInset();
                        }
                        if (i5 > 0) {
                            float f4 = i5;
                            return Integer.signum(i4) * (childAt.getTop() + Math.round(f4 * scrollInterpolator.getInterpolation((abs - childAt.getTop()) / f4)));
                        }
                    }
                } else {
                    i6++;
                }
            }
            return i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: A */
        public int k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3, int i4, int i5, int i6) {
            int i7;
            int i8;
            int g4 = g();
            int i9 = 0;
            if (i5 != 0 && g4 >= i5 && g4 <= i6) {
                int clamp = MathUtils.clamp(i4, i5, i6);
                if (g4 != clamp) {
                    if (t3.g()) {
                        i7 = y(t3, clamp);
                    } else {
                        i7 = clamp;
                    }
                    boolean topAndBottomOffset = setTopAndBottomOffset(i7);
                    int i10 = g4 - clamp;
                    this.f22924k = clamp - i7;
                    if (topAndBottomOffset) {
                        while (i9 < t3.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t3.getChildAt(i9).getLayoutParams();
                            ChildScrollEffect scrollEffect = layoutParams.getScrollEffect();
                            if (scrollEffect != null && (layoutParams.getScrollFlags() & 1) != 0) {
                                scrollEffect.onOffsetChanged(t3, t3.getChildAt(i9), getTopAndBottomOffset());
                            }
                            i9++;
                        }
                    }
                    if (!topAndBottomOffset && t3.g()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t3);
                    }
                    t3.k(getTopAndBottomOffset());
                    if (clamp < g4) {
                        i8 = -1;
                    } else {
                        i8 = 1;
                    }
                    E(coordinatorLayout, t3, clamp, i8, false);
                    i9 = i10;
                }
            } else {
                this.f22924k = 0;
            }
            D(coordinatorLayout, t3);
            return i9;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int g() {
            return getTopAndBottomOffset() + this.f22924k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i4) {
            return onLayoutChild(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i4, int i5, int i6, int i7) {
            return onMeasureChild(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i4, i5, i6, i7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i4, int i5, int[] iArr, int i6) {
            onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i4, i5, iArr, i6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
            onNestedScroll(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i4, i5, i6, i7, i8, iArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, Parcelable parcelable) {
            onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), parcelable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
            return onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, View view3, int i4, int i5) {
            return onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, view3, i4, i5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i4) {
            onStopNestedScroll(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: q */
        public boolean b(T t3) {
            BaseDragCallback baseDragCallback = this.f22929p;
            if (baseDragCallback != null) {
                return baseDragCallback.canDrag(t3);
            }
            WeakReference<View> weakReference = this.f22928o;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view != null && view.isShown() && !view.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }

        public void setDragCallback(@Nullable BaseDragCallback baseDragCallback) {
            this.f22929p = baseDragCallback;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: w */
        public int e(@NonNull T t3) {
            return -t3.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: x */
        public int f(@NonNull T t3) {
            return t3.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: z */
        public void h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3) {
            C(coordinatorLayout, t3);
            if (t3.isLiftOnScroll()) {
                t3.p(t3.s(t(coordinatorLayout)));
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3, int i4) {
            int round;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) t3, i4);
            int pendingAction = t3.getPendingAction();
            SavedState savedState = this.f22927n;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z3 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i5 = -t3.getUpNestedPreScrollRange();
                        if (z3) {
                            o(coordinatorLayout, t3, i5, 0.0f);
                        } else {
                            j(coordinatorLayout, t3, i5);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z3) {
                            o(coordinatorLayout, t3, 0, 0.0f);
                        } else {
                            j(coordinatorLayout, t3, 0);
                        }
                    }
                }
            } else if (savedState.f22941a) {
                j(coordinatorLayout, t3, -t3.getTotalScrollRange());
            } else {
                View childAt = t3.getChildAt(savedState.f22942b);
                int i6 = -childAt.getBottom();
                if (this.f22927n.f22944d) {
                    round = ViewCompat.getMinimumHeight(childAt) + t3.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.f22927n.f22943c);
                }
                j(coordinatorLayout, t3, i6 + round);
            }
            t3.m();
            this.f22927n = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -t3.getTotalScrollRange(), 0));
            E(coordinatorLayout, t3, getTopAndBottomOffset(), 0, true);
            t3.k(getTopAndBottomOffset());
            D(coordinatorLayout, t3);
            return onLayoutChild;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3, int i4, int i5, int i6, int i7) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t3.getLayoutParams())).height == -2) {
                coordinatorLayout.onMeasureChild(t3, i4, i5, View.MeasureSpec.makeMeasureSpec(0, 0), i7);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) t3, i4, i5, i6, i7);
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t3, View view, int i4, int i5, int[] iArr, int i6) {
            int i7;
            int i8;
            if (i5 != 0) {
                if (i5 < 0) {
                    int i9 = -t3.getTotalScrollRange();
                    i7 = i9;
                    i8 = t3.getDownNestedPreScrollRange() + i9;
                } else {
                    i7 = -t3.getUpNestedPreScrollRange();
                    i8 = 0;
                }
                if (i7 != i8) {
                    iArr[1] = i(coordinatorLayout, t3, i5, i7, i8);
                }
            }
            if (t3.isLiftOnScroll()) {
                t3.p(t3.s(view));
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t3, View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
            if (i7 < 0) {
                iArr[1] = i(coordinatorLayout, t3, i7, -t3.getDownNestedScrollRange(), 0);
            }
            if (i7 == 0) {
                D(coordinatorLayout, t3);
            }
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                this.f22927n = savedState;
                super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t3, savedState.getSuperState());
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t3, parcelable);
            this.f22927n = null;
        }

        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) t3);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t3.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = t3.getChildAt(i4);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.f22941a = (-getTopAndBottomOffset()) >= t3.getTotalScrollRange();
                    savedState.f22942b = i4;
                    savedState.f22944d = bottom == ViewCompat.getMinimumHeight(childAt) + t3.getTopInset();
                    savedState.f22943c = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t3, @NonNull View view, View view2, int i4, int i5) {
            ValueAnimator valueAnimator;
            boolean z3 = (i4 & 2) != 0 && (t3.isLiftOnScroll() || r(coordinatorLayout, t3, view));
            if (z3 && (valueAnimator = this.f22926m) != null) {
                valueAnimator.cancel();
            }
            this.f22928o = null;
            this.f22925l = i5;
            return z3;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t3, View view, int i4) {
            if (this.f22925l == 0 || i4 == 1) {
                C(coordinatorLayout, t3);
                if (t3.isLiftOnScroll()) {
                    t3.p(t3.s(view));
                }
            }
            this.f22928o = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes5.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
                @Override // android.os.Parcelable.Creator
                @Nullable
                /* renamed from: a */
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                /* renamed from: b */
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                /* renamed from: c */
                public SavedState[] newArray(int i4) {
                    return new SavedState[i4];
                }
            };

            /* renamed from: a  reason: collision with root package name */
            boolean f22941a;

            /* renamed from: b  reason: collision with root package name */
            int f22942b;

            /* renamed from: c  reason: collision with root package name */
            float f22943c;

            /* renamed from: d  reason: collision with root package name */
            boolean f22944d;

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f22941a = parcel.readByte() != 0;
                this.f22942b = parcel.readInt();
                this.f22943c = parcel.readFloat();
                this.f22944d = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i4) {
                super.writeToParcel(parcel, i4);
                parcel.writeByte(this.f22941a ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f22942b);
                parcel.writeFloat(this.f22943c);
                parcel.writeByte(this.f22944d ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t3, int i4);
    }

    /* loaded from: classes5.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {

        /* loaded from: classes5.dex */
        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i4) {
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i4, int i5, int i6, int i7) {
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i4, i5, i6, i7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i4, int i5, int[] iArr, int i6) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i4, i5, iArr, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i4, i5, i6, i7, i8, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i4, int i5) {
            return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i4) {
            super.onStopNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.BaseDragCallback baseDragCallback) {
            super.setDragCallback(baseDragCallback);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z3) {
            super.setHorizontalOffsetEnabled(z3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i4) {
            return super.setLeftAndRightOffset(i4);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i4) {
            return super.setTopAndBottomOffset(i4);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z3) {
            super.setVerticalOffsetEnabled(z3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class ChildScrollEffect {
        public abstract void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f4);
    }

    /* loaded from: classes5.dex */
    public static class CompressChildScrollEffect extends ChildScrollEffect {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f22945a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        private final Rect f22946b = new Rect();

        private static void a(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ChildScrollEffect
        public void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f4) {
            a(this.f22945a, appBarLayout, view);
            float abs = this.f22945a.top - Math.abs(f4);
            if (abs <= 0.0f) {
                float clamp = 1.0f - MathUtils.clamp(Math.abs(abs / this.f22945a.height()), 0.0f, 1.0f);
                float height = (-abs) - ((this.f22945a.height() * 0.3f) * (1.0f - (clamp * clamp)));
                view.setTranslationY(height);
                view.getDrawingRect(this.f22946b);
                this.f22946b.offset(0, (int) (-height));
                ViewCompat.setClipBounds(view, this.f22946b);
                return;
            }
            ViewCompat.setClipBounds(view, null);
            view.setTranslationY(0.0f);
        }
    }

    /* loaded from: classes5.dex */
    public interface LiftOnScrollListener {
        void onUpdate(@Dimension float f4, @ColorInt int i4);
    }

    /* loaded from: classes5.dex */
    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout appBarLayout, int i4);
    }

    /* loaded from: classes5.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int j(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).g();
            }
            return 0;
        }

        private void k(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f22924k) + f()) - c(view2));
            }
        }

        private void l(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.p(appBarLayout.s(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float d(View view) {
            int i4;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int j4 = j(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + j4 > downNestedPreScrollRange) && (i4 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (j4 / i4) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int e(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.e(view);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        /* renamed from: i */
        public AppBarLayout b(@NonNull List<View> list) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = list.get(i4);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            k(view, view2);
            l(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i4) {
            return super.onLayoutChild(coordinatorLayout, view, i4);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i4, int i5, int i6, int i7) {
            return super.onMeasureChild(coordinatorLayout, view, i4, i5, i6, i7);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z3) {
            AppBarLayout b4 = b(coordinatorLayout.getDependencies(view));
            if (b4 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f22991d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    b4.setExpanded(false, !z3);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z3) {
            super.setHorizontalOffsetEnabled(z3);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i4) {
            return super.setLeftAndRightOffset(i4);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i4) {
            return super.setTopAndBottomOffset(i4);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z3) {
            super.setVerticalOffsetEnabled(z3);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void c() {
        WeakReference<View> weakReference = this.f22916n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f22916n = null;
    }

    @Nullable
    private View d(@Nullable View view) {
        int i4;
        View view2;
        if (this.f22916n == null && (i4 = this.f22915m) != -1) {
            if (view != null) {
                view2 = view.findViewById(i4);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.f22915m);
            }
            if (view2 != null) {
                this.f22916n = new WeakReference<>(view2);
            }
        }
        WeakReference<View> weakReference = this.f22916n;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private boolean h() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (((LayoutParams) getChildAt(i4).getLayoutParams()).b()) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        this.f22904b = -1;
        this.f22905c = -1;
        this.f22906d = -1;
    }

    private void n(boolean z3, boolean z4, boolean z5) {
        int i4;
        int i5;
        if (z3) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        int i6 = 0;
        if (z4) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        int i7 = i4 | i5;
        if (z5) {
            i6 = 8;
        }
        this.f22908f = i7 | i6;
        requestLayout();
    }

    private boolean o(boolean z3) {
        if (this.f22912j != z3) {
            this.f22912j = z3;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    private boolean r() {
        if (this.f22920r != null && getTopInset() > 0) {
            return true;
        }
        return false;
    }

    private boolean t() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) {
            return false;
        }
        return true;
    }

    private void u(@NonNull final MaterialShapeDrawable materialShapeDrawable, boolean z3) {
        float f4;
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        if (z3) {
            f4 = 0.0f;
        } else {
            f4 = dimension;
        }
        if (!z3) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f22917o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, dimension);
        this.f22917o = ofFloat;
        ofFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.f22917o.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.f22917o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                materialShapeDrawable.setElevation(floatValue);
                if (AppBarLayout.this.f22920r instanceof MaterialShapeDrawable) {
                    ((MaterialShapeDrawable) AppBarLayout.this.f22920r).setElevation(floatValue);
                }
                for (LiftOnScrollListener liftOnScrollListener : AppBarLayout.this.f22918p) {
                    liftOnScrollListener.onUpdate(floatValue, materialShapeDrawable.getResolvedTintColor());
                }
            }
        });
        this.f22917o.start();
    }

    private void v() {
        setWillNotDraw(!r());
    }

    public void addLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        this.f22918p.add(liftOnScrollListener);
    }

    public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.f22910h == null) {
            this.f22910h = new ArrayList();
        }
        if (baseOnOffsetChangedListener == null || this.f22910h.contains(baseOnOffsetChangedListener)) {
            return;
        }
        this.f22910h.add(baseOnOffsetChangedListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearLiftOnScrollListener() {
        this.f22918p.clear();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (r()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f22903a);
            this.f22920r.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f22920r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: f */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    boolean g() {
        return this.f22907e;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    int getDownNestedPreScrollRange() {
        int i4;
        int minimumHeight;
        int i5 = this.f22905c;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i7 = layoutParams.f22947a;
            if ((i7 & 5) == 5) {
                int i8 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i7 & 8) != 0) {
                    minimumHeight = ViewCompat.getMinimumHeight(childAt);
                } else if ((i7 & 2) != 0) {
                    minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    i4 = i8 + measuredHeight;
                    if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                        i4 = Math.min(i4, measuredHeight - getTopInset());
                    }
                    i6 += i4;
                }
                i4 = i8 + minimumHeight;
                if (childCount == 0) {
                    i4 = Math.min(i4, measuredHeight - getTopInset());
                }
                i6 += i4;
            } else if (i6 > 0) {
                break;
            }
        }
        int max = Math.max(0, i6);
        this.f22905c = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i4 = this.f22906d;
        if (i4 != -1) {
            return i4;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i7 = layoutParams.f22947a;
            if ((i7 & 1) == 0) {
                break;
            }
            i6 += measuredHeight;
            if ((i7 & 2) != 0) {
                i6 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i5++;
        }
        int max = Math.max(0, i6);
        this.f22906d = max;
        return max;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.f22915m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                minimumHeight = ViewCompat.getMinimumHeight(getChildAt(childCount - 1));
            } else {
                minimumHeight = 0;
            }
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    int getPendingAction() {
        return this.f22908f;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f22920r;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f22909g;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i4 = this.f22904b;
        if (i4 != -1) {
            return i4;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i7 = layoutParams.f22947a;
            if ((i7 & 1) == 0) {
                break;
            }
            i6 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i5 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                i6 -= getTopInset();
            }
            if ((i7 & 2) != 0) {
                i6 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i5++;
        }
        int max = Math.max(0, i6);
        this.f22904b = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean i() {
        if (getTotalScrollRange() != 0) {
            return true;
        }
        return false;
    }

    public boolean isLiftOnScroll() {
        return this.f22914l;
    }

    public boolean isLifted() {
        return this.f22913k;
    }

    void k(int i4) {
        this.f22903a = i4;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<BaseOnOffsetChangedListener> list = this.f22910h;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.f22910h.get(i5);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(this, i4);
                }
            }
        }
    }

    WindowInsetsCompat l(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.f22909g, windowInsetsCompat2)) {
            this.f22909g = windowInsetsCompat2;
            v();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    void m() {
        this.f22908f = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i4) {
        int i5;
        int i6;
        if (this.f22919q == null) {
            this.f22919q = new int[4];
        }
        int[] iArr = this.f22919q;
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + iArr.length);
        boolean z3 = this.f22912j;
        int i7 = R.attr.state_liftable;
        if (!z3) {
            i7 = -i7;
        }
        iArr[0] = i7;
        if (z3 && this.f22913k) {
            i5 = R.attr.state_lifted;
        } else {
            i5 = -R.attr.state_lifted;
        }
        iArr[1] = i5;
        int i8 = R.attr.state_collapsible;
        if (!z3) {
            i8 = -i8;
        }
        iArr[2] = i8;
        if (z3 && this.f22913k) {
            i6 = R.attr.state_collapsed;
        } else {
            i6 = -R.attr.state_collapsed;
        }
        iArr[3] = i6;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        boolean z4 = true;
        if (ViewCompat.getFitsSystemWindows(this) && t()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        j();
        this.f22907e = false;
        int childCount2 = getChildCount();
        int i8 = 0;
        while (true) {
            if (i8 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i8).getLayoutParams()).getScrollInterpolator() != null) {
                this.f22907e = true;
                break;
            } else {
                i8++;
            }
        }
        Drawable drawable = this.f22920r;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f22911i) {
            if (!this.f22914l && !h()) {
                z4 = false;
            }
            o(z4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && t()) {
            int measuredHeight = getMeasuredHeight();
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    measuredHeight += getTopInset();
                }
            } else {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i5));
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        j();
    }

    boolean p(boolean z3) {
        return q(z3, !this.f22911i);
    }

    boolean q(boolean z3, boolean z4) {
        if (z4 && this.f22913k != z3) {
            this.f22913k = z3;
            refreshDrawableState();
            if (this.f22914l && (getBackground() instanceof MaterialShapeDrawable)) {
                u((MaterialShapeDrawable) getBackground(), z3);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean removeLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        return this.f22918p.remove(liftOnScrollListener);
    }

    public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.f22910h;
        if (list == null || baseOnOffsetChangedListener == null) {
            return;
        }
        list.remove(baseOnOffsetChangedListener);
    }

    boolean s(@Nullable View view) {
        View d4 = d(view);
        if (d4 != null) {
            view = d4;
        }
        if (view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        MaterialShapeUtils.setElevation(this, f4);
    }

    public void setExpanded(boolean z3) {
        setExpanded(z3, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean z3) {
        this.f22914l = z3;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i4) {
        this.f22915m = i4;
        c();
    }

    public boolean setLiftable(boolean z3) {
        this.f22911i = true;
        return o(z3);
    }

    public void setLiftableOverrideEnabled(boolean z3) {
        this.f22911i = z3;
    }

    public boolean setLifted(boolean z3) {
        return q(z3, true);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i4) {
        if (i4 == 1) {
            super.setOrientation(i4);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        boolean z3;
        Drawable drawable2 = this.f22920r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f22920r = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f22920r.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f22920r, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.f22920r;
                if (getVisibility() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                drawable4.setVisible(z3, false);
                this.f22920r.setCallback(this);
            }
            v();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i4) {
        setStatusBarForeground(new ColorDrawable(i4));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i4) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i4));
    }

    @Deprecated
    public void setTargetElevation(float f4) {
        ViewUtilsLollipop.b(this, f4);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        boolean z3;
        super.setVisibility(i4);
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Drawable drawable = this.f22920r;
        if (drawable != null) {
            drawable.setVisible(z3, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f22920r) {
            return false;
        }
        return true;
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public void setExpanded(boolean z3, boolean z4) {
        n(z3, z4, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = com.google.android.material.appbar.AppBarLayout.f22902s
            android.content.Context r10 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r10, r11, r12, r4)
            r9.<init>(r10, r11, r12)
            r10 = -1
            r9.f22904b = r10
            r9.f22905c = r10
            r9.f22906d = r10
            r6 = 0
            r9.f22908f = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.f22918p = r0
            android.content.Context r7 = r9.getContext()
            r0 = 1
            r9.setOrientation(r0)
            int r8 = android.os.Build.VERSION.SDK_INT
            android.view.ViewOutlineProvider r0 = r9.getOutlineProvider()
            android.view.ViewOutlineProvider r1 = android.view.ViewOutlineProvider.BACKGROUND
            if (r0 != r1) goto L2f
            com.google.android.material.appbar.ViewUtilsLollipop.a(r9)
        L2f:
            com.google.android.material.appbar.ViewUtilsLollipop.c(r9, r11, r12, r4)
            int[] r2 = com.google.android.material.R.styleable.AppBarLayout
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_background
            android.graphics.drawable.Drawable r12 = r11.getDrawable(r12)
            androidx.core.view.ViewCompat.setBackground(r9, r12)
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            boolean r12 = r12 instanceof android.graphics.drawable.ColorDrawable
            if (r12 == 0) goto L6a
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            android.graphics.drawable.ColorDrawable r12 = (android.graphics.drawable.ColorDrawable) r12
            com.google.android.material.shape.MaterialShapeDrawable r0 = new com.google.android.material.shape.MaterialShapeDrawable
            r0.<init>()
            int r12 = r12.getColor()
            android.content.res.ColorStateList r12 = android.content.res.ColorStateList.valueOf(r12)
            r0.setFillColor(r12)
            r0.initializeElevationOverlay(r7)
            androidx.core.view.ViewCompat.setBackground(r9, r0)
        L6a:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_expanded
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L79
            boolean r12 = r11.getBoolean(r12, r6)
            r9.n(r12, r6, r6)
        L79:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_elevation
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L89
            int r12 = r11.getDimensionPixelSize(r12, r6)
            float r12 = (float) r12
            com.google.android.material.appbar.ViewUtilsLollipop.b(r9, r12)
        L89:
            r12 = 26
            if (r8 < r12) goto Lab
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto L9c
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setKeyboardNavigationCluster(r12)
        L9c:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto Lab
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setTouchscreenBlocksFocus(r12)
        Lab:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_liftOnScroll
            boolean r12 = r11.getBoolean(r12, r6)
            r9.f22914l = r12
            int r12 = com.google.android.material.R.styleable.AppBarLayout_liftOnScrollTargetViewId
            int r10 = r11.getResourceId(r12, r10)
            r9.f22915m = r10
            int r10 = com.google.android.material.R.styleable.AppBarLayout_statusBarForeground
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r10)
            r9.setStatusBarForeground(r10)
            r11.recycle()
            com.google.android.material.appbar.AppBarLayout$1 r10 = new com.google.android.material.appbar.AppBarLayout$1
            r10.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        removeOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        addOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes5.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;

        /* renamed from: a  reason: collision with root package name */
        int f22947a;

        /* renamed from: b  reason: collision with root package name */
        private ChildScrollEffect f22948b;

        /* renamed from: c  reason: collision with root package name */
        Interpolator f22949c;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes5.dex */
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f22947a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f22947a = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(a(obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0)));
            int i4 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i4)) {
                this.f22949c = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i4, 0));
            }
            obtainStyledAttributes.recycle();
        }

        @Nullable
        private ChildScrollEffect a(int i4) {
            if (i4 != 1) {
                return null;
            }
            return new CompressChildScrollEffect();
        }

        boolean b() {
            int i4 = this.f22947a;
            if ((i4 & 1) == 1 && (i4 & 10) != 0) {
                return true;
            }
            return false;
        }

        @Nullable
        public ChildScrollEffect getScrollEffect() {
            return this.f22948b;
        }

        public int getScrollFlags() {
            return this.f22947a;
        }

        public Interpolator getScrollInterpolator() {
            return this.f22949c;
        }

        public void setScrollEffect(@Nullable ChildScrollEffect childScrollEffect) {
            this.f22948b = childScrollEffect;
        }

        public void setScrollFlags(int i4) {
            this.f22947a = i4;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.f22949c = interpolator;
        }

        public LayoutParams(int i4, int i5) {
            super(i4, i5);
            this.f22947a = 1;
        }

        public LayoutParams(int i4, int i5, float f4) {
            super(i4, i5, f4);
            this.f22947a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f22947a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f22947a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f22947a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.f22947a = 1;
            this.f22947a = layoutParams.f22947a;
            this.f22949c = layoutParams.f22949c;
        }
    }
}
