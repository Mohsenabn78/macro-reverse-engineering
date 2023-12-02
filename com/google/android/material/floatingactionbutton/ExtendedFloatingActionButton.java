package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

/* loaded from: classes5.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int E = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> F = new Property<View, Float>(Float.class, "width") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.4
        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f4) {
            view.getLayoutParams().width = f4.intValue();
            view.requestLayout();
        }
    };
    static final Property<View, Float> G = new Property<View, Float>(Float.class, "height") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.5
        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f4) {
            view.getLayoutParams().height = f4.intValue();
            view.requestLayout();
        }
    };
    static final Property<View, Float> H = new Property<View, Float>(Float.class, "paddingStart") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.6
        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f4) {
            ViewCompat.setPaddingRelative(view, f4.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }
    };
    static final Property<View, Float> I = new Property<View, Float>(Float.class, "paddingEnd") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.7
        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f4) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f4.intValue(), view.getPaddingBottom());
        }
    };
    private boolean A;
    private boolean B;
    private boolean C;
    @NonNull
    protected ColorStateList D;

    /* renamed from: q  reason: collision with root package name */
    private int f23637q;

    /* renamed from: r  reason: collision with root package name */
    private final AnimatorTracker f23638r;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    private final MotionStrategy f23639s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    private final MotionStrategy f23640t;

    /* renamed from: u  reason: collision with root package name */
    private final MotionStrategy f23641u;

    /* renamed from: v  reason: collision with root package name */
    private final MotionStrategy f23642v;

    /* renamed from: w  reason: collision with root package name */
    private final int f23643w;

    /* renamed from: x  reason: collision with root package name */
    private int f23644x;

    /* renamed from: y  reason: collision with root package name */
    private int f23645y;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> f23646z;

    /* loaded from: classes5.dex */
    class ChangeSizeStrategy extends BaseMotionStrategy {

        /* renamed from: g  reason: collision with root package name */
        private final Size f23653g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f23654h;

        ChangeSizeStrategy(AnimatorTracker animatorTracker, Size size, boolean z3) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
            this.f23653g = size;
            this.f23654h = z3;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean b() {
            if (this.f23654h != ExtendedFloatingActionButton.this.A && ExtendedFloatingActionButton.this.getIcon() != null && !TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText())) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int d() {
            if (this.f23654h) {
                return R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
            }
            return R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        @NonNull
        public AnimatorSet e() {
            float f4;
            MotionSpec o4 = o();
            if (o4.hasPropertyValues("width")) {
                PropertyValuesHolder[] propertyValues = o4.getPropertyValues("width");
                propertyValues[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f23653g.getWidth());
                o4.setPropertyValues("width", propertyValues);
            }
            if (o4.hasPropertyValues("height")) {
                PropertyValuesHolder[] propertyValues2 = o4.getPropertyValues("height");
                propertyValues2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f23653g.getHeight());
                o4.setPropertyValues("height", propertyValues2);
            }
            if (o4.hasPropertyValues("paddingStart")) {
                PropertyValuesHolder[] propertyValues3 = o4.getPropertyValues("paddingStart");
                propertyValues3[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.f23653g.b());
                o4.setPropertyValues("paddingStart", propertyValues3);
            }
            if (o4.hasPropertyValues("paddingEnd")) {
                PropertyValuesHolder[] propertyValues4 = o4.getPropertyValues("paddingEnd");
                propertyValues4[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.f23653g.a());
                o4.setPropertyValues("paddingEnd", propertyValues4);
            }
            if (o4.hasPropertyValues("labelOpacity")) {
                PropertyValuesHolder[] propertyValues5 = o4.getPropertyValues("labelOpacity");
                boolean z3 = this.f23654h;
                float f5 = 0.0f;
                if (z3) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                if (z3) {
                    f5 = 1.0f;
                }
                propertyValues5[0].setFloatValues(f4, f5);
                o4.setPropertyValues("labelOpacity", propertyValues5);
            }
            return super.n(o4);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void f(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback == null) {
                return;
            }
            if (this.f23654h) {
                onChangedCallback.onExtended(ExtendedFloatingActionButton.this);
            } else {
                onChangedCallback.onShrunken(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void g() {
            ExtendedFloatingActionButton.this.A = this.f23654h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f23653g.getLayoutParams().width;
            layoutParams.height = this.f23653g.getLayoutParams().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f23653g.b(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f23653g.a(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void j() {
            super.j();
            ExtendedFloatingActionButton.this.B = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f23653g.getLayoutParams().width;
            layoutParams.height = this.f23653g.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.A = this.f23654h;
            ExtendedFloatingActionButton.this.B = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    /* loaded from: classes5.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f23656a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private OnChangedCallback f23657b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private OnChangedCallback f23658c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f23659d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f23660e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f23659d = false;
            this.f23660e = true;
        }

        private static boolean b(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean c(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f23659d && !this.f23660e) || layoutParams.getAnchorId() != view.getId()) {
                return false;
            }
            return true;
        }

        private boolean e(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!c(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f23656a == null) {
                this.f23656a = new Rect();
            }
            Rect rect = this.f23656a;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                d(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        private boolean f(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!c(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                d(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        protected void a(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            OnChangedCallback onChangedCallback;
            boolean z3 = this.f23660e;
            if (z3) {
                onChangedCallback = this.f23658c;
            } else {
                onChangedCallback = this.f23657b;
            }
            extendedFloatingActionButton.x(z3 ? extendedFloatingActionButton.f23640t : extendedFloatingActionButton.f23641u, onChangedCallback);
        }

        protected void d(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            OnChangedCallback onChangedCallback;
            boolean z3 = this.f23660e;
            if (z3) {
                onChangedCallback = this.f23658c;
            } else {
                onChangedCallback = this.f23657b;
            }
            extendedFloatingActionButton.x(z3 ? extendedFloatingActionButton.f23639s : extendedFloatingActionButton.f23642v, onChangedCallback);
        }

        public boolean isAutoHideEnabled() {
            return this.f23659d;
        }

        public boolean isAutoShrinkEnabled() {
            return this.f23660e;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public void setAutoHideEnabled(boolean z3) {
            this.f23659d = z3;
        }

        public void setAutoShrinkEnabled(boolean z3) {
            this.f23660e = z3;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (CoordinatorLayout) extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                e(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (b(view)) {
                f(view, extendedFloatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i4) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = dependencies.get(i5);
                if (view instanceof AppBarLayout) {
                    if (e(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (b(view) && f(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i4);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f23659d = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f23660e = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes5.dex */
    class HideStrategy extends BaseMotionStrategy {

        /* renamed from: g  reason: collision with root package name */
        private boolean f23661g;

        public HideStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean b() {
            return ExtendedFloatingActionButton.this.v();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int d() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void f(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onHidden(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void g() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void h() {
            super.h();
            this.f23661g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void j() {
            super.j();
            ExtendedFloatingActionButton.this.f23637q = 0;
            if (!this.f23661g) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f23661g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f23637q = 1;
        }
    }

    /* loaded from: classes5.dex */
    class ShowStrategy extends BaseMotionStrategy {
        public ShowStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean b() {
            return ExtendedFloatingActionButton.this.w();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int d() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void f(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onShown(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void g() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void j() {
            super.j();
            ExtendedFloatingActionButton.this.f23637q = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f23637q = 2;
        }
    }

    /* loaded from: classes5.dex */
    interface Size {
        int a();

        int b();

        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        if (getVisibility() == 0) {
            if (this.f23637q != 1) {
                return false;
            }
            return true;
        } else if (this.f23637q == 2) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        if (getVisibility() != 0) {
            if (this.f23637q != 2) {
                return false;
            }
            return true;
        } else if (this.f23637q == 1) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(@NonNull final MotionStrategy motionStrategy, @Nullable final OnChangedCallback onChangedCallback) {
        if (motionStrategy.b()) {
            return;
        }
        if (!z()) {
            motionStrategy.g();
            motionStrategy.f(onChangedCallback);
            return;
        }
        measure(0, 0);
        AnimatorSet e4 = motionStrategy.e();
        e4.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.3

            /* renamed from: a  reason: collision with root package name */
            private boolean f23649a;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.f23649a = true;
                motionStrategy.h();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                motionStrategy.j();
                if (!this.f23649a) {
                    motionStrategy.f(onChangedCallback);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                motionStrategy.onAnimationStart(animator);
                this.f23649a = false;
            }
        });
        for (Animator.AnimatorListener animatorListener : motionStrategy.l()) {
            e4.addListener(animatorListener);
        }
        e4.start();
    }

    private void y() {
        this.D = getTextColors();
    }

    private boolean z() {
        if ((ViewCompat.isLaidOut(this) || (!w() && this.C)) && !isInEditMode()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23640t.i(animatorListener);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23642v.i(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23641u.i(animatorListener);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23639s.i(animatorListener);
    }

    public void extend() {
        x(this.f23640t, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.f23646z;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    int getCollapsedSize() {
        int i4 = this.f23643w;
        if (i4 < 0) {
            return (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize();
        }
        return i4;
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return this.f23640t.a();
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.f23642v.a();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.f23641u.a();
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return this.f23639s.a();
    }

    public void hide() {
        x(this.f23642v, null);
    }

    public final boolean isExtended() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.A && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.A = false;
            this.f23639s.g();
        }
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23640t.c(animatorListener);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23642v.c(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23641u.c(animatorListener);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23639s.c(animatorListener);
    }

    public void setAnimateShowBeforeLayout(boolean z3) {
        this.C = z3;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec motionSpec) {
        this.f23640t.k(motionSpec);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i4) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i4));
    }

    public void setExtended(boolean z3) {
        MotionStrategy motionStrategy;
        if (this.A == z3) {
            return;
        }
        if (z3) {
            motionStrategy = this.f23640t;
        } else {
            motionStrategy = this.f23639s;
        }
        if (motionStrategy.b()) {
            return;
        }
        motionStrategy.g();
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.f23642v.k(motionSpec);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i4) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i4));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        super.setPadding(i4, i5, i6, i7);
        if (this.A && !this.B) {
            this.f23644x = ViewCompat.getPaddingStart(this);
            this.f23645y = ViewCompat.getPaddingEnd(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i4, int i5, int i6, int i7) {
        super.setPaddingRelative(i4, i5, i6, i7);
        if (this.A && !this.B) {
            this.f23644x = i4;
            this.f23645y = i6;
        }
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.f23641u.k(motionSpec);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i4) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i4));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec motionSpec) {
        this.f23639s.k(motionSpec);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i4) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i4));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i4) {
        super.setTextColor(i4);
        y();
    }

    public void show() {
        x(this.f23641u, null);
    }

    public void shrink() {
        x(this.f23639s, null);
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    public void extend(@NonNull OnChangedCallback onChangedCallback) {
        x(this.f23640t, onChangedCallback);
    }

    public void hide(@NonNull OnChangedCallback onChangedCallback) {
        x(this.f23642v, onChangedCallback);
    }

    public void show(@NonNull OnChangedCallback onChangedCallback) {
        x(this.f23641u, onChangedCallback);
    }

    public void shrink(@NonNull OnChangedCallback onChangedCallback) {
        x(this.f23639s, onChangedCallback);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.E
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.f23637q = r10
            com.google.android.material.floatingactionbutton.AnimatorTracker r1 = new com.google.android.material.floatingactionbutton.AnimatorTracker
            r1.<init>()
            r0.f23638r = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ShowStrategy r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ShowStrategy
            r11.<init>(r1)
            r0.f23641u = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$HideStrategy r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$HideStrategy
            r12.<init>(r1)
            r0.f23642v = r12
            r13 = 1
            r0.A = r13
            r0.B = r10
            r0.C = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.f23646z = r1
            int[] r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_showMotionSpec
            com.google.android.material.animation.MotionSpec r2 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r2)
            int r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_hideMotionSpec
            com.google.android.material.animation.MotionSpec r3 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r3)
            int r4 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_extendMotionSpec
            com.google.android.material.animation.MotionSpec r4 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r4)
            int r5 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            com.google.android.material.animation.MotionSpec r5 = com.google.android.material.animation.MotionSpec.createFromAttribute(r14, r1, r5)
            int r6 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_collapsedSize
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.f23643w = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingStart(r16)
            r0.f23644x = r6
            int r6 = androidx.core.view.ViewCompat.getPaddingEnd(r16)
            r0.f23645y = r6
            com.google.android.material.floatingactionbutton.AnimatorTracker r6 = new com.google.android.material.floatingactionbutton.AnimatorTracker
            r6.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r15 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1 r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1
            r10.<init>()
            r15.<init>(r6, r10, r13)
            r0.f23640t = r15
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2 r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2
            r13.<init>()
            r7 = 0
            r10.<init>(r6, r13, r7)
            r0.f23639s = r10
            r11.k(r2)
            r12.k(r3)
            r15.k(r4)
            r10.k(r5)
            r1.recycle()
            com.google.android.material.shape.CornerSize r1 = com.google.android.material.shape.ShapeAppearanceModel.PILL
            r2 = r18
            com.google.android.material.shape.ShapeAppearanceModel$Builder r1 = com.google.android.material.shape.ShapeAppearanceModel.builder(r14, r2, r8, r9, r1)
            com.google.android.material.shape.ShapeAppearanceModel r1 = r1.build()
            r0.setShapeAppearanceModel(r1)
            r16.y()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        y();
    }

    /* loaded from: classes5.dex */
    public static abstract class OnChangedCallback {
        public void onExtended(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onHidden(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShown(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShrunken(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }
}
