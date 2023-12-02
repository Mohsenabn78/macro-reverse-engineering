package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.motion.MotionUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] C = {16842912};
    private static final ActiveIndicatorTransform D = new ActiveIndicatorTransform();
    private static final ActiveIndicatorTransform E = new ActiveIndicatorUnlabeledTransform();
    private int A;
    @Nullable
    private BadgeDrawable B;

    /* renamed from: a  reason: collision with root package name */
    private boolean f23929a;

    /* renamed from: b  reason: collision with root package name */
    private int f23930b;

    /* renamed from: c  reason: collision with root package name */
    private int f23931c;

    /* renamed from: d  reason: collision with root package name */
    private float f23932d;

    /* renamed from: e  reason: collision with root package name */
    private float f23933e;

    /* renamed from: f  reason: collision with root package name */
    private float f23934f;

    /* renamed from: g  reason: collision with root package name */
    private int f23935g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23936h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final FrameLayout f23937i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private final View f23938j;

    /* renamed from: k  reason: collision with root package name */
    private final ImageView f23939k;

    /* renamed from: l  reason: collision with root package name */
    private final ViewGroup f23940l;

    /* renamed from: m  reason: collision with root package name */
    private final TextView f23941m;

    /* renamed from: n  reason: collision with root package name */
    private final TextView f23942n;

    /* renamed from: o  reason: collision with root package name */
    private int f23943o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private MenuItemImpl f23944p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private ColorStateList f23945q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private Drawable f23946r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private Drawable f23947s;

    /* renamed from: t  reason: collision with root package name */
    private ValueAnimator f23948t;

    /* renamed from: u  reason: collision with root package name */
    private ActiveIndicatorTransform f23949u;

    /* renamed from: v  reason: collision with root package name */
    private float f23950v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f23951w;

    /* renamed from: x  reason: collision with root package name */
    private int f23952x;

    /* renamed from: y  reason: collision with root package name */
    private int f23953y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f23954z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ActiveIndicatorTransform {
        private ActiveIndicatorTransform() {
        }

        protected float a(@FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
            float f6;
            float f7;
            int i4 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
            if (i4 == 0) {
                f6 = 0.8f;
            } else {
                f6 = 0.0f;
            }
            if (i4 == 0) {
                f7 = 1.0f;
            } else {
                f7 = 0.2f;
            }
            return AnimationUtils.lerp(0.0f, 1.0f, f6, f7, f4);
        }

        protected float b(@FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
            return AnimationUtils.lerp(0.4f, 1.0f, f4);
        }

        protected float c(@FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
            return 1.0f;
        }

        public void d(@FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @NonNull View view) {
            view.setScaleX(b(f4, f5));
            view.setScaleY(c(f4, f5));
            view.setAlpha(a(f4, f5));
        }
    }

    /* loaded from: classes5.dex */
    private static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.ActiveIndicatorTransform
        protected float c(float f4, float f5) {
            return b(f4, f5);
        }
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        this.f23929a = false;
        this.f23943o = -1;
        this.f23949u = D;
        this.f23950v = 0.0f;
        this.f23951w = false;
        this.f23952x = 0;
        this.f23953y = 0;
        this.f23954z = false;
        this.A = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f23937i = (FrameLayout) findViewById(R.id.navigation_bar_item_icon_container);
        this.f23938j = findViewById(R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        this.f23939k = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.navigation_bar_item_labels_group);
        this.f23940l = viewGroup;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.f23941m = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.f23942n = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f23930b = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f23931c = viewGroup.getPaddingBottom();
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        e(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    if (NavigationBarItemView.this.f23939k.getVisibility() == 0) {
                        NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                        navigationBarItemView.r(navigationBarItemView.f23939k);
                    }
                }
            });
        }
    }

    private void e(float f4, float f5) {
        this.f23932d = f4 - f5;
        this.f23933e = (f5 * 1.0f) / f4;
        this.f23934f = (f4 * 1.0f) / f5;
    }

    @Nullable
    private FrameLayout g(View view) {
        ImageView imageView = this.f23939k;
        if (view != imageView || !BadgeUtils.USE_COMPAT_PARENT) {
            return null;
        }
        return (FrameLayout) imageView.getParent();
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f23937i;
        if (frameLayout == null) {
            return this.f23939k;
        }
        return frameLayout;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i4 = 0;
        for (int i5 = 0; i5 < indexOfChild; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i4++;
            }
        }
        return i4;
    }

    private int getSuggestedIconHeight() {
        int i4;
        BadgeDrawable badgeDrawable = this.B;
        if (badgeDrawable != null) {
            i4 = badgeDrawable.getMinimumHeight() / 2;
        } else {
            i4 = 0;
        }
        return Math.max(i4, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + this.f23939k.getMeasuredWidth() + i4;
    }

    private int getSuggestedIconWidth() {
        int minimumWidth;
        BadgeDrawable badgeDrawable = this.B;
        if (badgeDrawable == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = badgeDrawable.getMinimumWidth() - this.B.getHorizontalOffset();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f23939k.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private boolean h() {
        if (this.B != null) {
            return true;
        }
        return false;
    }

    private boolean i() {
        if (this.f23954z && this.f23935g == 2) {
            return true;
        }
        return false;
    }

    private void j(@FloatRange(from = 0.0d, to = 1.0d) final float f4) {
        if (this.f23951w && this.f23929a && ViewCompat.isAttachedToWindow(this)) {
            ValueAnimator valueAnimator = this.f23948t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f23948t = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f23950v, f4);
            this.f23948t = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    NavigationBarItemView.this.m(((Float) valueAnimator2.getAnimatedValue()).floatValue(), f4);
                }
            });
            this.f23948t.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            this.f23948t.setDuration(MotionUtils.resolveThemeDuration(getContext(), R.attr.motionDurationLong1, getResources().getInteger(R.integer.material_motion_duration_long_1)));
            this.f23948t.start();
            return;
        }
        m(f4, f4);
    }

    private void k() {
        MenuItemImpl menuItemImpl = this.f23944p;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f4, float f5) {
        View view = this.f23938j;
        if (view != null) {
            this.f23949u.d(f4, f5, view);
        }
        this.f23950v = f4;
    }

    private static void n(@NonNull View view, float f4, float f5, int i4) {
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setVisibility(i4);
    }

    private static void o(@NonNull View view, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i4;
        layoutParams.bottomMargin = i4;
        layoutParams.gravity = i5;
        view.setLayoutParams(layoutParams);
    }

    private void p(@Nullable View view) {
        if (h() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.B, view, g(view));
        }
    }

    private void q(@Nullable View view) {
        if (!h()) {
            return;
        }
        if (view != null) {
            setClipChildren(true);
            setClipToPadding(true);
            BadgeUtils.detachBadgeDrawable(this.B, view);
        }
        this.B = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view) {
        if (!h()) {
            return;
        }
        BadgeUtils.setBadgeDrawableBounds(this.B, view, g(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i4) {
        int i5;
        if (this.f23938j == null) {
            return;
        }
        int min = Math.min(this.f23952x, i4 - (this.A * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23938j.getLayoutParams();
        if (i()) {
            i5 = min;
        } else {
            i5 = this.f23953y;
        }
        layoutParams.height = i5;
        layoutParams.width = min;
        this.f23938j.setLayoutParams(layoutParams);
    }

    private void t() {
        if (i()) {
            this.f23949u = E;
        } else {
            this.f23949u = D;
        }
    }

    private static void u(@NonNull View view, int i4) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        l();
        this.f23944p = null;
        this.f23950v = 0.0f;
        this.f23929a = false;
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        View view = this.f23938j;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.B;
    }

    @DrawableRes
    protected int getItemBackgroundResId() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.f23944p;
    }

    @DimenRes
    protected int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f23943o;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23940l.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.f23940l.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23940l.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f23940l.getMeasuredWidth() + layoutParams.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i4) {
        CharSequence title;
        int i5;
        this.f23944p = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            title = menuItemImpl.getTooltipText();
        } else {
            title = menuItemImpl.getTitle();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, title);
        }
        if (menuItemImpl.isVisible()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        setVisibility(i5);
        this.f23929a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        q(this.f23939k);
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i4) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        MenuItemImpl menuItemImpl = this.f23944p;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f23944p.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, C);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.B;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f23944p.getTitle();
            if (!TextUtils.isEmpty(this.f23944p.getContentDescription())) {
                title = this.f23944p.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.B.getContentDescription()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        post(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarItemView.2
            @Override // java.lang.Runnable
            public void run() {
                NavigationBarItemView.this.s(i4);
            }
        });
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        View view = this.f23938j;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
    }

    public void setActiveIndicatorEnabled(boolean z3) {
        int i4;
        this.f23951w = z3;
        View view = this.f23938j;
        if (view != null) {
            if (z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            view.setVisibility(i4);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i4) {
        this.f23953y = i4;
        s(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(@Px int i4) {
        this.A = i4;
        s(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z3) {
        this.f23954z = z3;
    }

    public void setActiveIndicatorWidth(int i4) {
        this.f23952x = i4;
        s(getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        this.B = badgeDrawable;
        ImageView imageView = this.f23939k;
        if (imageView != null) {
            p(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z3) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z3) {
        float f4;
        TextView textView = this.f23942n;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f23942n;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f23941m;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f23941m;
        textView4.setPivotY(textView4.getBaseline());
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        j(f4);
        int i4 = this.f23935g;
        if (i4 != -1) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        o(getIconOrContainer(), this.f23930b, 17);
                        this.f23942n.setVisibility(8);
                        this.f23941m.setVisibility(8);
                    }
                } else {
                    u(this.f23940l, this.f23931c);
                    if (z3) {
                        o(getIconOrContainer(), (int) (this.f23930b + this.f23932d), 49);
                        n(this.f23942n, 1.0f, 1.0f, 0);
                        TextView textView5 = this.f23941m;
                        float f5 = this.f23933e;
                        n(textView5, f5, f5, 4);
                    } else {
                        o(getIconOrContainer(), this.f23930b, 49);
                        TextView textView6 = this.f23942n;
                        float f6 = this.f23934f;
                        n(textView6, f6, f6, 4);
                        n(this.f23941m, 1.0f, 1.0f, 0);
                    }
                }
            } else {
                if (z3) {
                    o(getIconOrContainer(), this.f23930b, 49);
                    u(this.f23940l, this.f23931c);
                    this.f23942n.setVisibility(0);
                } else {
                    o(getIconOrContainer(), this.f23930b, 17);
                    u(this.f23940l, 0);
                    this.f23942n.setVisibility(4);
                }
                this.f23941m.setVisibility(4);
            }
        } else if (this.f23936h) {
            if (z3) {
                o(getIconOrContainer(), this.f23930b, 49);
                u(this.f23940l, this.f23931c);
                this.f23942n.setVisibility(0);
            } else {
                o(getIconOrContainer(), this.f23930b, 17);
                u(this.f23940l, 0);
                this.f23942n.setVisibility(4);
            }
            this.f23941m.setVisibility(4);
        } else {
            u(this.f23940l, this.f23931c);
            if (z3) {
                o(getIconOrContainer(), (int) (this.f23930b + this.f23932d), 49);
                n(this.f23942n, 1.0f, 1.0f, 0);
                TextView textView7 = this.f23941m;
                float f7 = this.f23933e;
                n(textView7, f7, f7, 4);
            } else {
                o(getIconOrContainer(), this.f23930b, 49);
                TextView textView8 = this.f23942n;
                float f8 = this.f23934f;
                n(textView8, f8, f8, 4);
                n(this.f23941m, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z3);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        this.f23941m.setEnabled(z3);
        this.f23942n.setEnabled(z3);
        this.f23939k.setEnabled(z3);
        if (z3) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.f23946r) {
            return;
        }
        this.f23946r = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.f23947s = drawable;
            ColorStateList colorStateList = this.f23945q;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.f23939k.setImageDrawable(drawable);
    }

    public void setIconSize(int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23939k.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i4;
        this.f23939k.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.f23945q = colorStateList;
        if (this.f23944p != null && (drawable = this.f23947s) != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            this.f23947s.invalidateSelf();
        }
    }

    public void setItemBackground(int i4) {
        setItemBackground(i4 == 0 ? null : ContextCompat.getDrawable(getContext(), i4));
    }

    public void setItemPaddingBottom(int i4) {
        if (this.f23931c != i4) {
            this.f23931c = i4;
            k();
        }
    }

    public void setItemPaddingTop(int i4) {
        if (this.f23930b != i4) {
            this.f23930b = i4;
            k();
        }
    }

    public void setItemPosition(int i4) {
        this.f23943o = i4;
    }

    public void setLabelVisibilityMode(int i4) {
        if (this.f23935g != i4) {
            this.f23935g = i4;
            t();
            s(getWidth());
            k();
        }
    }

    public void setShifting(boolean z3) {
        if (this.f23936h != z3) {
            this.f23936h = z3;
            k();
        }
    }

    public void setTextAppearanceActive(@StyleRes int i4) {
        TextViewCompat.setTextAppearance(this.f23942n, i4);
        e(this.f23941m.getTextSize(), this.f23942n.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i4) {
        TextViewCompat.setTextAppearance(this.f23941m, i4);
        e(this.f23941m.getTextSize(), this.f23942n.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f23941m.setTextColor(colorStateList);
            this.f23942n.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.f23941m.setText(charSequence);
        this.f23942n.setText(charSequence);
        MenuItemImpl menuItemImpl = this.f23944p;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.f23944p;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.f23944p.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z3, char c4) {
    }
}
