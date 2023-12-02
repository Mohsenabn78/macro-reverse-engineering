package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;

    /* renamed from: w  reason: collision with root package name */
    private static final int f23073w = R.style.Widget_MaterialComponents_BottomAppBar;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Integer f23074a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23075b;

    /* renamed from: c  reason: collision with root package name */
    private final MaterialShapeDrawable f23076c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Animator f23077d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Animator f23078e;

    /* renamed from: f  reason: collision with root package name */
    private int f23079f;

    /* renamed from: g  reason: collision with root package name */
    private int f23080g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23081h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f23082i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f23083j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f23084k;

    /* renamed from: l  reason: collision with root package name */
    private int f23085l;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<AnimationListener> f23086m;
    @MenuRes

    /* renamed from: n  reason: collision with root package name */
    private int f23087n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f23088o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f23089p;

    /* renamed from: q  reason: collision with root package name */
    private Behavior f23090q;

    /* renamed from: r  reason: collision with root package name */
    private int f23091r;

    /* renamed from: s  reason: collision with root package name */
    private int f23092s;

    /* renamed from: t  reason: collision with root package name */
    private int f23093t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    AnimatorListenerAdapter f23094u;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    TransformationCallback<FloatingActionButton> f23095v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface AnimationListener {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    /* loaded from: classes5.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final Rect f23114e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<BottomAppBar> f23115f;

        /* renamed from: g  reason: collision with root package name */
        private int f23116g;

        /* renamed from: h  reason: collision with root package name */
        private final View.OnLayoutChangeListener f23117h;

        public Behavior() {
            this.f23117h = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f23115f.get();
                    if (bottomAppBar != null && (view instanceof FloatingActionButton)) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        floatingActionButton.getMeasuredContentRect(Behavior.this.f23114e);
                        int height = Behavior.this.f23114e.height();
                        bottomAppBar.Y(height);
                        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().getTopLeftCornerSize().getCornerSize(new RectF(Behavior.this.f23114e)));
                        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                        if (Behavior.this.f23116g == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                            if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f23075b;
                                return;
                            } else {
                                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f23075b;
                                return;
                            }
                        }
                        return;
                    }
                    view.removeOnLayoutChangeListener(this);
                }
            };
            this.f23114e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i4) {
            this.f23115f = new WeakReference<>(bottomAppBar);
            View P = bottomAppBar.P();
            if (P != null && !ViewCompat.isLaidOut(P)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) P.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.f23116g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (P instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) P;
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                    }
                    floatingActionButton.addOnLayoutChangeListener(this.f23117h);
                    bottomAppBar.H(floatingActionButton);
                }
                bottomAppBar.X();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i4);
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i4);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i4, int i5) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) bottomAppBar, view, view2, i4, i5);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f23117h = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f23115f.get();
                    if (bottomAppBar != null && (view instanceof FloatingActionButton)) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        floatingActionButton.getMeasuredContentRect(Behavior.this.f23114e);
                        int height = Behavior.this.f23114e.height();
                        bottomAppBar.Y(height);
                        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().getTopLeftCornerSize().getCornerSize(new RectF(Behavior.this.f23114e)));
                        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                        if (Behavior.this.f23116g == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                            if (ViewUtils.isLayoutRtl(floatingActionButton)) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f23075b;
                                return;
                            } else {
                                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f23075b;
                                return;
                            }
                        }
                        return;
                    }
                    view.removeOnLayoutChangeListener(this);
                }
            };
            this.f23114e = new Rect();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface FabAnimationMode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.SavedState.1
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
        int f23119a;

        /* renamed from: b  reason: collision with root package name */
        boolean f23120b;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f23119a);
            parcel.writeInt(this.f23120b ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f23119a = parcel.readInt();
            this.f23120b = parcel.readInt() != 0;
        }
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.f23094u);
        floatingActionButton.addOnShowAnimationListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.f23094u.onAnimationStart(animator);
                FloatingActionButton O = BottomAppBar.this.O();
                if (O != null) {
                    O.setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        floatingActionButton.addTransformationCallback(this.f23095v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        Animator animator = this.f23078e;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f23077d;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void K(int i4, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(O(), "translationX", R(i4));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void L(final int i4, final boolean z3, @NonNull List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - Q(actionMenuView, i4, z3)) > 1.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.7

                /* renamed from: a  reason: collision with root package name */
                public boolean f23104a;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.f23104a = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    boolean z4;
                    if (!this.f23104a) {
                        if (BottomAppBar.this.f23087n != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        BottomAppBar bottomAppBar = BottomAppBar.this;
                        bottomAppBar.replaceMenu(bottomAppBar.f23087n);
                        BottomAppBar.this.a0(actionMenuView, i4, z3, z4);
                    }
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        } else if (actionMenuView.getAlpha() < 1.0f) {
            list.add(ofFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        ArrayList<AnimationListener> arrayList;
        int i4 = this.f23085l - 1;
        this.f23085l = i4;
        if (i4 == 0 && (arrayList = this.f23086m) != null) {
            Iterator<AnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        ArrayList<AnimationListener> arrayList;
        int i4 = this.f23085l;
        this.f23085l = i4 + 1;
        if (i4 == 0 && (arrayList = this.f23086m) != null) {
            Iterator<AnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public FloatingActionButton O() {
        View P = P();
        if (P instanceof FloatingActionButton) {
            return (FloatingActionButton) P;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View P() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.getDependents(r4)
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L2c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L18
        L2c:
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.P():android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float R(int i4) {
        int i5;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i6 = 1;
        if (i4 == 1) {
            if (isLayoutRtl) {
                i5 = this.f23093t;
            } else {
                i5 = this.f23092s;
            }
            int measuredWidth = (getMeasuredWidth() / 2) - (this.f23075b + i5);
            if (isLayoutRtl) {
                i6 = -1;
            }
            return measuredWidth * i6;
        }
        return 0.0f;
    }

    private boolean S() {
        FloatingActionButton O = O();
        if (O != null && O.isOrWillBeShown()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i4, boolean z3) {
        if (!ViewCompat.isLaidOut(this)) {
            this.f23088o = false;
            replaceMenu(this.f23087n);
            return;
        }
        Animator animator = this.f23078e;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!S()) {
            i4 = 0;
            z3 = false;
        }
        L(i4, z3, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f23078e = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                BottomAppBar.this.M();
                BottomAppBar.this.f23088o = false;
                BottomAppBar.this.f23078e = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                BottomAppBar.this.N();
            }
        });
        this.f23078e.start();
    }

    private void U(int i4) {
        if (this.f23079f != i4 && ViewCompat.isLaidOut(this)) {
            Animator animator = this.f23077d;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f23080g == 1) {
                K(i4, arrayList);
            } else {
                J(i4, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f23077d = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    BottomAppBar.this.M();
                    BottomAppBar.this.f23077d = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    BottomAppBar.this.N();
                }
            });
            this.f23077d.start();
        }
    }

    @Nullable
    private Drawable V(@Nullable Drawable drawable) {
        if (drawable != null && this.f23074a != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTint(wrap, this.f23074a.intValue());
            return wrap;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.f23078e == null) {
            actionMenuView.setAlpha(1.0f);
            if (!S()) {
                Z(actionMenuView, 0, false);
            } else {
                Z(actionMenuView, this.f23079f, this.f23089p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        float f4;
        getTopEdgeTreatment().h(getFabTranslationX());
        View P = P();
        MaterialShapeDrawable materialShapeDrawable = this.f23076c;
        if (this.f23089p && S()) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        materialShapeDrawable.setInterpolation(f4);
        if (P != null) {
            P.setTranslationY(getFabTranslationY());
            P.setTranslationX(getFabTranslationX());
        }
    }

    private void Z(@NonNull ActionMenuView actionMenuView, int i4, boolean z3) {
        a0(actionMenuView, i4, z3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(@NonNull final ActionMenuView actionMenuView, final int i4, final boolean z3, boolean z4) {
        Runnable runnable = new Runnable() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // java.lang.Runnable
            public void run() {
                ActionMenuView actionMenuView2 = actionMenuView;
                actionMenuView2.setTranslationX(BottomAppBar.this.Q(actionMenuView2, i4, z3));
            }
        };
        if (z4) {
            actionMenuView.post(runnable);
        } else {
            runnable.run();
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f23091r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return R(this.f23079f);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f23093t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f23092s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.f23076c.getShapeAppearanceModel().getTopEdge();
    }

    protected void J(final int i4, List<Animator> list) {
        FloatingActionButton O = O();
        if (O != null && !O.isOrWillBeHidden()) {
            N();
            O.hide(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5
                @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                public void onHidden(@NonNull FloatingActionButton floatingActionButton) {
                    floatingActionButton.setTranslationX(BottomAppBar.this.R(i4));
                    floatingActionButton.show(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5.1
                        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                        public void onShown(FloatingActionButton floatingActionButton2) {
                            BottomAppBar.this.M();
                        }
                    });
                }
            });
        }
    }

    protected int Q(@NonNull ActionMenuView actionMenuView, int i4, boolean z3) {
        int i5;
        int left;
        int i6;
        boolean z4;
        if (i4 != 1 || !z3) {
            return 0;
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (isLayoutRtl) {
            i5 = getMeasuredWidth();
        } else {
            i5 = 0;
        }
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                if (isLayoutRtl) {
                    i5 = Math.min(i5, childAt.getLeft());
                } else {
                    i5 = Math.max(i5, childAt.getRight());
                }
            }
        }
        if (isLayoutRtl) {
            left = actionMenuView.getRight();
        } else {
            left = actionMenuView.getLeft();
        }
        if (isLayoutRtl) {
            i6 = this.f23092s;
        } else {
            i6 = -this.f23093t;
        }
        return i5 - (left + i6);
    }

    boolean Y(@Px int i4) {
        float f4 = i4;
        if (f4 != getTopEdgeTreatment().getFabDiameter()) {
            getTopEdgeTreatment().setFabDiameter(f4);
            this.f23076c.invalidateSelf();
            return true;
        }
        return false;
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.f23076c.getTintList();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().b();
    }

    public int getFabAlignmentMode() {
        return this.f23079f;
    }

    public int getFabAnimationMode() {
        return this.f23080g;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().c();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().d();
    }

    public boolean getHideOnScroll() {
        return this.f23081h;
    }

    public boolean isScrolledDown() {
        return getBehavior().isScrolledDown();
    }

    public boolean isScrolledUp() {
        return getBehavior().isScrolledUp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.f23076c);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        if (z3) {
            I();
            X();
        }
        W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f23079f = savedState.f23119a;
        this.f23089p = savedState.f23120b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f23119a = this.f23079f;
        savedState.f23120b = this.f23089p;
        return savedState;
    }

    public void performHide() {
        performHide(true);
    }

    public void performShow() {
        performShow(true);
    }

    public void replaceMenu(@MenuRes int i4) {
        if (i4 != 0) {
            this.f23087n = 0;
            getMenu().clear();
            inflateMenu(i4);
        }
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f23076c, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f4) {
        if (f4 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().e(f4);
            this.f23076c.invalidateSelf();
            X();
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        this.f23076c.setElevation(f4);
        getBehavior().setAdditionalHiddenOffsetY(this, this.f23076c.getShadowRadius() - this.f23076c.getShadowOffsetY());
    }

    public void setFabAlignmentMode(int i4) {
        setFabAlignmentModeAndReplaceMenu(i4, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i4, @MenuRes int i5) {
        this.f23087n = i5;
        this.f23088o = true;
        T(i4, this.f23089p);
        U(i4);
        this.f23079f = i4;
    }

    public void setFabAnimationMode(int i4) {
        this.f23080g = i4;
    }

    void setFabCornerSize(@Dimension float f4) {
        if (f4 != getTopEdgeTreatment().getFabCornerRadius()) {
            getTopEdgeTreatment().setFabCornerSize(f4);
            this.f23076c.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@Dimension float f4) {
        if (f4 != getFabCradleMargin()) {
            getTopEdgeTreatment().f(f4);
            this.f23076c.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f4) {
        if (f4 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().g(f4);
            this.f23076c.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z3) {
        this.f23081h = z3;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(V(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i4) {
        this.f23074a = Integer.valueOf(i4);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.f23090q == null) {
            this.f23090q = new Behavior();
        }
        return this.f23090q;
    }

    public void performHide(boolean z3) {
        getBehavior().slideDown(this, z3);
    }

    public void performShow(boolean z3) {
        getBehavior().slideUp(this, z3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BottomAppBar(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = com.google.android.material.bottomappbar.BottomAppBar.f23073w
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            com.google.android.material.shape.MaterialShapeDrawable r11 = new com.google.android.material.shape.MaterialShapeDrawable
            r11.<init>()
            r10.f23076c = r11
            r7 = 0
            r10.f23085l = r7
            r10.f23087n = r7
            r10.f23088o = r7
            r0 = 1
            r10.f23089p = r0
            com.google.android.material.bottomappbar.BottomAppBar$1 r0 = new com.google.android.material.bottomappbar.BottomAppBar$1
            r0.<init>()
            r10.f23094u = r0
            com.google.android.material.bottomappbar.BottomAppBar$2 r0 = new com.google.android.material.bottomappbar.BottomAppBar$2
            r0.<init>()
            r10.f23095v = r0
            android.content.Context r8 = r10.getContext()
            int[] r2 = com.google.android.material.R.styleable.BottomAppBar
            int[] r5 = new int[r7]
            r0 = r8
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.BottomAppBar_backgroundTint
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.getColorStateList(r8, r0, r1)
            int r2 = com.google.android.material.R.styleable.BottomAppBar_navigationIconTint
            boolean r3 = r0.hasValue(r2)
            if (r3 == 0) goto L4e
            r3 = -1
            int r2 = r0.getColor(r2, r3)
            r10.setNavigationIconTint(r2)
        L4e:
            int r2 = com.google.android.material.R.styleable.BottomAppBar_elevation
            int r2 = r0.getDimensionPixelSize(r2, r7)
            int r3 = com.google.android.material.R.styleable.BottomAppBar_fabCradleMargin
            int r3 = r0.getDimensionPixelOffset(r3, r7)
            float r3 = (float) r3
            int r4 = com.google.android.material.R.styleable.BottomAppBar_fabCradleRoundedCornerRadius
            int r4 = r0.getDimensionPixelOffset(r4, r7)
            float r4 = (float) r4
            int r5 = com.google.android.material.R.styleable.BottomAppBar_fabCradleVerticalOffset
            int r5 = r0.getDimensionPixelOffset(r5, r7)
            float r5 = (float) r5
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAlignmentMode
            int r9 = r0.getInt(r9, r7)
            r10.f23079f = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAnimationMode
            int r9 = r0.getInt(r9, r7)
            r10.f23080g = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_hideOnScroll
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f23081h = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingBottomSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f23082i = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingLeftSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f23083j = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingRightSystemWindowInsets
            boolean r7 = r0.getBoolean(r9, r7)
            r10.f23084k = r7
            r0.recycle()
            android.content.res.Resources r0 = r10.getResources()
            int r7 = com.google.android.material.R.dimen.mtrl_bottomappbar_fabOffsetEndMode
            int r0 = r0.getDimensionPixelOffset(r7)
            r10.f23075b = r0
            com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment r0 = new com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
            r0.<init>(r3, r4, r5)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r3 = com.google.android.material.shape.ShapeAppearanceModel.builder()
            com.google.android.material.shape.ShapeAppearanceModel$Builder r0 = r3.setTopEdge(r0)
            com.google.android.material.shape.ShapeAppearanceModel r0 = r0.build()
            r11.setShapeAppearanceModel(r0)
            r0 = 2
            r11.setShadowCompatibilityMode(r0)
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            r11.setPaintStyle(r0)
            r11.initializeElevationOverlay(r8)
            float r0 = (float) r2
            r10.setElevation(r0)
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r11, r1)
            androidx.core.view.ViewCompat.setBackground(r10, r11)
            com.google.android.material.bottomappbar.BottomAppBar$3 r11 = new com.google.android.material.bottomappbar.BottomAppBar$3
            r11.<init>()
            com.google.android.material.internal.ViewUtils.doOnApplyWindowInsets(r10, r12, r13, r6, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
