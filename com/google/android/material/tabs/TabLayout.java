package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
/* loaded from: classes5.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int R = R.style.Widget_Design_TabLayout;
    private static final Pools.Pool<Tab> S = new Pools.SynchronizedPool(16);
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    boolean A;
    boolean B;
    int C;
    int D;
    boolean E;
    private TabIndicatorInterpolator F;
    @Nullable
    private BaseOnTabSelectedListener G;
    private final ArrayList<BaseOnTabSelectedListener> H;
    @Nullable
    private BaseOnTabSelectedListener I;
    private ValueAnimator J;
    @Nullable
    ViewPager K;
    @Nullable
    private PagerAdapter L;
    private DataSetObserver M;
    private TabLayoutOnPageChangeListener N;
    private AdapterChangeListener O;
    private boolean P;
    private final Pools.Pool<TabView> Q;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Tab> f24467a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Tab f24468b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final SlidingTabIndicator f24469c;

    /* renamed from: d  reason: collision with root package name */
    int f24470d;

    /* renamed from: e  reason: collision with root package name */
    int f24471e;

    /* renamed from: f  reason: collision with root package name */
    int f24472f;

    /* renamed from: g  reason: collision with root package name */
    int f24473g;

    /* renamed from: h  reason: collision with root package name */
    int f24474h;

    /* renamed from: i  reason: collision with root package name */
    ColorStateList f24475i;

    /* renamed from: j  reason: collision with root package name */
    ColorStateList f24476j;

    /* renamed from: k  reason: collision with root package name */
    ColorStateList f24477k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    Drawable f24478l;

    /* renamed from: m  reason: collision with root package name */
    private int f24479m;

    /* renamed from: n  reason: collision with root package name */
    PorterDuff.Mode f24480n;

    /* renamed from: o  reason: collision with root package name */
    float f24481o;

    /* renamed from: p  reason: collision with root package name */
    float f24482p;

    /* renamed from: q  reason: collision with root package name */
    final int f24483q;

    /* renamed from: r  reason: collision with root package name */
    int f24484r;

    /* renamed from: s  reason: collision with root package name */
    private final int f24485s;

    /* renamed from: t  reason: collision with root package name */
    private final int f24486t;

    /* renamed from: u  reason: collision with root package name */
    private final int f24487u;

    /* renamed from: v  reason: collision with root package name */
    private int f24488v;

    /* renamed from: w  reason: collision with root package name */
    int f24489w;

    /* renamed from: x  reason: collision with root package name */
    int f24490x;

    /* renamed from: y  reason: collision with root package name */
    int f24491y;

    /* renamed from: z  reason: collision with root package name */
    int f24492z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f24494a;

        AdapterChangeListener() {
        }

        void a(boolean z3) {
            this.f24494a = z3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.K == viewPager) {
                tabLayout.v(pagerAdapter2, this.f24494a);
            }
        }
    }

    @Deprecated
    /* loaded from: classes5.dex */
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t3);

        void onTabSelected(T t3);

        void onTabUnselected(T t3);
    }

    /* loaded from: classes5.dex */
    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface Mode {
    }

    /* loaded from: classes5.dex */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.s();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class SlidingTabIndicator extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        ValueAnimator f24497a;

        /* renamed from: b  reason: collision with root package name */
        int f24498b;

        /* renamed from: c  reason: collision with root package name */
        float f24499c;

        /* renamed from: d  reason: collision with root package name */
        private int f24500d;

        SlidingTabIndicator(Context context) {
            super(context);
            this.f24498b = -1;
            this.f24500d = -1;
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            View childAt = getChildAt(this.f24498b);
            TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.F;
            TabLayout tabLayout = TabLayout.this;
            tabIndicatorInterpolator.d(tabLayout, childAt, tabLayout.f24478l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(View view, View view2, float f4) {
            boolean z3;
            if (view != null && view.getWidth() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.F;
                TabLayout tabLayout = TabLayout.this;
                tabIndicatorInterpolator.c(tabLayout, view, view2, f4, tabLayout.f24478l);
            } else {
                Drawable drawable = TabLayout.this.f24478l;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f24478l.getBounds().bottom);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        private void i(boolean z3, final int i4, int i5) {
            final View childAt = getChildAt(this.f24498b);
            final View childAt2 = getChildAt(i4);
            if (childAt2 == null) {
                e();
                return;
            }
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    SlidingTabIndicator.this.h(childAt, childAt2, valueAnimator.getAnimatedFraction());
                }
            };
            if (z3) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f24497a = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                valueAnimator.setDuration(i5);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(animatorUpdateListener);
                valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SlidingTabIndicator.this.f24498b = i4;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        SlidingTabIndicator.this.f24498b = i4;
                    }
                });
                valueAnimator.start();
                return;
            }
            this.f24497a.removeAllUpdateListeners();
            this.f24497a.addUpdateListener(animatorUpdateListener);
        }

        void c(int i4, int i5) {
            ValueAnimator valueAnimator = this.f24497a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f24497a.cancel();
            }
            i(true, i4, i5);
        }

        boolean d() {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                if (getChildAt(i4).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int height;
            int height2 = TabLayout.this.f24478l.getBounds().height();
            if (height2 < 0) {
                height2 = TabLayout.this.f24478l.getIntrinsicHeight();
            }
            int i4 = TabLayout.this.f24491y;
            if (i4 != 0) {
                if (i4 != 1) {
                    height = 0;
                    if (i4 != 2) {
                        if (i4 != 3) {
                            height2 = 0;
                        } else {
                            height2 = getHeight();
                        }
                    }
                } else {
                    height = (getHeight() - height2) / 2;
                    height2 = (getHeight() + height2) / 2;
                }
            } else {
                height = getHeight() - height2;
                height2 = getHeight();
            }
            if (TabLayout.this.f24478l.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f24478l.getBounds();
                TabLayout.this.f24478l.setBounds(bounds.left, height, bounds.right, height2);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.f24478l;
                if (tabLayout.f24479m != 0) {
                    drawable = DrawableCompat.wrap(drawable);
                    if (Build.VERSION.SDK_INT == 21) {
                        drawable.setColorFilter(TabLayout.this.f24479m, PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(drawable, TabLayout.this.f24479m);
                    }
                } else if (Build.VERSION.SDK_INT == 21) {
                    drawable.setColorFilter(null);
                } else {
                    DrawableCompat.setTintList(drawable, null);
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        void f(int i4, float f4) {
            ValueAnimator valueAnimator = this.f24497a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f24497a.cancel();
            }
            this.f24498b = i4;
            this.f24499c = f4;
            h(getChildAt(i4), getChildAt(this.f24498b + 1), this.f24499c);
        }

        void g(int i4) {
            Rect bounds = TabLayout.this.f24478l.getBounds();
            TabLayout.this.f24478l.setBounds(bounds.left, 0, bounds.right, i4);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
            super.onLayout(z3, i4, i5, i6, i7);
            ValueAnimator valueAnimator = this.f24497a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                i(false, this.f24498b, -1);
            } else {
                e();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i4, int i5) {
            super.onMeasure(i4, i5);
            if (View.MeasureSpec.getMode(i4) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z3 = true;
            if (tabLayout.f24489w == 1 || tabLayout.f24492z == 2) {
                int childCount = getChildCount();
                int i6 = 0;
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = getChildAt(i7);
                    if (childAt.getVisibility() == 0) {
                        i6 = Math.max(i6, childAt.getMeasuredWidth());
                    }
                }
                if (i6 <= 0) {
                    return;
                }
                if (i6 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                    boolean z4 = false;
                    for (int i8 = 0; i8 < childCount; i8++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i8).getLayoutParams();
                        if (layoutParams.width != i6 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i6;
                            layoutParams.weight = 0.0f;
                            z4 = true;
                        }
                    }
                    z3 = z4;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.f24489w = 0;
                    tabLayout2.z(false);
                }
                if (z3) {
                    super.onMeasure(i4, i5);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i4) {
            super.onRtlPropertiesChanged(i4);
            if (Build.VERSION.SDK_INT < 23 && this.f24500d != i4) {
                requestLayout();
                this.f24500d = i4;
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface TabIndicatorAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface TabIndicatorGravity {
    }

    /* loaded from: classes5.dex */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f24515a;

        /* renamed from: b  reason: collision with root package name */
        private int f24516b;

        /* renamed from: c  reason: collision with root package name */
        private int f24517c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f24515a = new WeakReference<>(tabLayout);
        }

        void a() {
            this.f24517c = 0;
            this.f24516b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i4) {
            this.f24516b = this.f24517c;
            this.f24517c = i4;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i4, float f4, int i5) {
            boolean z3;
            TabLayout tabLayout = this.f24515a.get();
            if (tabLayout != null) {
                int i6 = this.f24517c;
                boolean z4 = false;
                if (i6 == 2 && this.f24516b != 1) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                tabLayout.setScrollPosition(i4, f4, z3, (i6 == 2 && this.f24516b == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i4) {
            boolean z3;
            TabLayout tabLayout = this.f24515a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i4 && i4 < tabLayout.getTabCount()) {
                int i5 = this.f24517c;
                if (i5 != 0 && (i5 != 2 || this.f24516b != 0)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i4), z3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class TabView extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private Tab f24518a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f24519b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f24520c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private View f24521d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private BadgeDrawable f24522e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private View f24523f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private TextView f24524g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private ImageView f24525h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private Drawable f24526i;

        /* renamed from: j  reason: collision with root package name */
        private int f24527j;

        public TabView(@NonNull Context context) {
            super(context);
            this.f24527j = 2;
            y(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f24470d, TabLayout.this.f24471e, TabLayout.this.f24472f, TabLayout.this.f24473g);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private void A(@Nullable TextView textView, @Nullable ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            int i4;
            Tab tab = this.f24518a;
            CharSequence charSequence2 = null;
            if (tab != null && tab.getIcon() != null) {
                drawable = DrawableCompat.wrap(this.f24518a.getIcon()).mutate();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, TabLayout.this.f24476j);
                PorterDuff.Mode mode = TabLayout.this.f24480n;
                if (mode != null) {
                    DrawableCompat.setTintMode(drawable, mode);
                }
            }
            Tab tab2 = this.f24518a;
            if (tab2 != null) {
                charSequence = tab2.getText();
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z3 = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z3) {
                    textView.setText(charSequence);
                    if (this.f24518a.f24513g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z3 && imageView.getVisibility() == 0) {
                    i4 = (int) ViewUtils.dpToPx(getContext(), 8);
                } else {
                    i4 = 0;
                }
                if (TabLayout.this.A) {
                    if (i4 != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, i4);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i4 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i4;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Tab tab3 = this.f24518a;
            if (tab3 != null) {
                charSequence2 = tab3.f24510d;
            }
            if (Build.VERSION.SDK_INT > 23) {
                if (!z3) {
                    charSequence = charSequence2;
                }
                TooltipCompat.setTooltipText(this, charSequence);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.f24522e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.f24522e == null) {
                this.f24522e = BadgeDrawable.create(getContext());
            }
            v();
            BadgeDrawable badgeDrawable = this.f24522e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void i(@Nullable final View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    if (view.getVisibility() == 0) {
                        TabView.this.w(view);
                    }
                }
            });
        }

        private float j(@NonNull Layout layout, int i4, float f4) {
            return layout.getLineWidth(i4) * (f4 / layout.getPaint().getTextSize());
        }

        private void k(boolean z3) {
            setClipChildren(z3);
            setClipToPadding(z3);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z3);
                viewGroup.setClipToPadding(z3);
            }
        }

        @NonNull
        private FrameLayout l() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(@NonNull Canvas canvas) {
            Drawable drawable = this.f24526i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f24526i.draw(canvas);
            }
        }

        @Nullable
        private FrameLayout n(@NonNull View view) {
            if ((view != this.f24520c && view != this.f24519b) || !BadgeUtils.USE_COMPAT_PARENT) {
                return null;
            }
            return (FrameLayout) view.getParent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o() {
            if (this.f24522e != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void p() {
            FrameLayout frameLayout;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                frameLayout = l();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) frameLayout, false);
            this.f24520c = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void q() {
            FrameLayout frameLayout;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                frameLayout = l();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) frameLayout, false);
            this.f24519b = textView;
            frameLayout.addView(textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            if (this.f24521d != null) {
                u();
            }
            this.f24522e = null;
        }

        private void t(@Nullable View view) {
            if (o() && view != null) {
                k(false);
                BadgeUtils.attachBadgeDrawable(this.f24522e, view, n(view));
                this.f24521d = view;
            }
        }

        private void u() {
            if (!o()) {
                return;
            }
            k(true);
            View view = this.f24521d;
            if (view != null) {
                BadgeUtils.detachBadgeDrawable(this.f24522e, view);
                this.f24521d = null;
            }
        }

        private void v() {
            Tab tab;
            Tab tab2;
            if (!o()) {
                return;
            }
            if (this.f24523f != null) {
                u();
            } else if (this.f24520c != null && (tab2 = this.f24518a) != null && tab2.getIcon() != null) {
                View view = this.f24521d;
                ImageView imageView = this.f24520c;
                if (view != imageView) {
                    u();
                    t(this.f24520c);
                    return;
                }
                w(imageView);
            } else if (this.f24519b != null && (tab = this.f24518a) != null && tab.getTabLabelVisibility() == 1) {
                View view2 = this.f24521d;
                TextView textView = this.f24519b;
                if (view2 != textView) {
                    u();
                    t(this.f24519b);
                    return;
                }
                w(textView);
            } else {
                u();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(@NonNull View view) {
            if (o() && view == this.f24521d) {
                BadgeUtils.setBadgeDrawableBounds(this.f24522e, view, n(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        public void y(Context context) {
            int i4 = TabLayout.this.f24483q;
            GradientDrawable gradientDrawable = null;
            if (i4 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i4);
                this.f24526i = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f24526i.setState(getDrawableState());
                }
            } else {
                this.f24526i = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.f24477k != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList convertToRippleDrawableColor = RippleUtils.convertToRippleDrawableColor(TabLayout.this.f24477k);
                boolean z3 = TabLayout.this.E;
                if (z3) {
                    gradientDrawable2 = null;
                }
                if (!z3) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(convertToRippleDrawableColor, gradientDrawable2, gradientDrawable);
            }
            ViewCompat.setBackground(this, gradientDrawable2);
            TabLayout.this.invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f24526i;
            boolean z3 = false;
            if (drawable != null && drawable.isStateful()) {
                z3 = false | this.f24526i.setState(drawableState);
            }
            if (z3) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getContentHeight() {
            View[] viewArr = {this.f24519b, this.f24520c, this.f24523f};
            int i4 = 0;
            int i5 = 0;
            boolean z3 = false;
            for (int i6 = 0; i6 < 3; i6++) {
                View view = viewArr[i6];
                if (view != null && view.getVisibility() == 0) {
                    if (z3) {
                        i5 = Math.min(i5, view.getTop());
                    } else {
                        i5 = view.getTop();
                    }
                    if (z3) {
                        i4 = Math.max(i4, view.getBottom());
                    } else {
                        i4 = view.getBottom();
                    }
                    z3 = true;
                }
            }
            return i4 - i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getContentWidth() {
            View[] viewArr = {this.f24519b, this.f24520c, this.f24523f};
            int i4 = 0;
            int i5 = 0;
            boolean z3 = false;
            for (int i6 = 0; i6 < 3; i6++) {
                View view = viewArr[i6];
                if (view != null && view.getVisibility() == 0) {
                    if (z3) {
                        i5 = Math.min(i5, view.getLeft());
                    } else {
                        i5 = view.getLeft();
                    }
                    if (z3) {
                        i4 = Math.max(i4, view.getRight());
                    } else {
                        i4 = view.getRight();
                    }
                    z3 = true;
                }
            }
            return i4 - i5;
        }

        @Nullable
        public Tab getTab() {
            return this.f24518a;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f24522e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.f24522e.getContentDescription()));
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f24518a.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i4, int i5) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i4);
            int mode = View.MeasureSpec.getMode(i4);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i4 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f24484r, Integer.MIN_VALUE);
            }
            super.onMeasure(i4, i5);
            if (this.f24519b != null) {
                float f4 = TabLayout.this.f24481o;
                int i6 = this.f24527j;
                ImageView imageView = this.f24520c;
                boolean z3 = true;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i6 = 1;
                } else {
                    TextView textView = this.f24519b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f4 = TabLayout.this.f24482p;
                    }
                }
                float textSize = this.f24519b.getTextSize();
                int lineCount = this.f24519b.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f24519b);
                int i7 = (f4 > textSize ? 1 : (f4 == textSize ? 0 : -1));
                if (i7 != 0 || (maxLines >= 0 && i6 != maxLines)) {
                    if (TabLayout.this.f24492z == 1 && i7 > 0 && lineCount == 1 && ((layout = this.f24519b.getLayout()) == null || j(layout, 0, f4) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z3 = false;
                    }
                    if (z3) {
                        this.f24519b.setTextSize(0, f4);
                        this.f24519b.setMaxLines(i6);
                        super.onMeasure(i4, i5);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f24518a != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.f24518a.select();
                return true;
            }
            return performClick;
        }

        void s() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean z3) {
            if (isSelected() != z3) {
            }
            super.setSelected(z3);
            TextView textView = this.f24519b;
            if (textView != null) {
                textView.setSelected(z3);
            }
            ImageView imageView = this.f24520c;
            if (imageView != null) {
                imageView.setSelected(z3);
            }
            View view = this.f24523f;
            if (view != null) {
                view.setSelected(z3);
            }
        }

        void setTab(@Nullable Tab tab) {
            if (tab != this.f24518a) {
                this.f24518a = tab;
                x();
            }
        }

        final void x() {
            View view;
            boolean z3;
            Tab tab = this.f24518a;
            if (tab != null) {
                view = tab.getCustomView();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.f24523f = view;
                TextView textView = this.f24519b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f24520c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f24520c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.f24524g = textView2;
                if (textView2 != null) {
                    this.f24527j = TextViewCompat.getMaxLines(textView2);
                }
                this.f24525h = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.f24523f;
                if (view2 != null) {
                    removeView(view2);
                    this.f24523f = null;
                }
                this.f24524g = null;
                this.f24525h = null;
            }
            if (this.f24523f == null) {
                if (this.f24520c == null) {
                    p();
                }
                if (this.f24519b == null) {
                    q();
                    this.f24527j = TextViewCompat.getMaxLines(this.f24519b);
                }
                TextViewCompat.setTextAppearance(this.f24519b, TabLayout.this.f24474h);
                ColorStateList colorStateList = TabLayout.this.f24475i;
                if (colorStateList != null) {
                    this.f24519b.setTextColor(colorStateList);
                }
                A(this.f24519b, this.f24520c);
                v();
                i(this.f24520c);
                i(this.f24519b);
            } else {
                TextView textView3 = this.f24524g;
                if (textView3 != null || this.f24525h != null) {
                    A(textView3, this.f24525h);
                }
            }
            if (tab != null && !TextUtils.isEmpty(tab.f24510d)) {
                setContentDescription(tab.f24510d);
            }
            if (tab != null && tab.isSelected()) {
                z3 = true;
            } else {
                z3 = false;
            }
            setSelected(z3);
        }

        final void z() {
            setOrientation(!TabLayout.this.A ? 1 : 0);
            TextView textView = this.f24524g;
            if (textView == null && this.f24525h == null) {
                A(this.f24519b, this.f24520c);
            } else {
                A(textView, this.f24525h);
            }
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    private void c(@NonNull TabItem tabItem) {
        Tab newTab = newTab();
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            newTab.setText(charSequence);
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            newTab.setIcon(drawable);
        }
        int i4 = tabItem.customLayout;
        if (i4 != 0) {
            newTab.setCustomView(i4);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void d(@NonNull Tab tab) {
        TabView tabView = tab.view;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f24469c.addView(tabView, tab.getPosition(), l());
    }

    private void e(View view) {
        if (view instanceof TabItem) {
            c((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void f(int i4) {
        if (i4 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f24469c.d()) {
            int scrollX = getScrollX();
            int i5 = i(i4, 0.0f);
            if (scrollX != i5) {
                r();
                this.J.setIntValues(scrollX, i5);
                this.J.start();
            }
            this.f24469c.c(i4, this.f24490x);
            return;
        }
        setScrollPosition(i4, 0.0f, true);
    }

    private void g(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return;
                }
            } else {
                this.f24469c.setGravity(1);
                return;
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        this.f24469c.setGravity(GravityCompat.START);
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.f24467a.size();
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                Tab tab = this.f24467a.get(i4);
                if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                    z3 = true;
                    break;
                }
                i4++;
            } else {
                break;
            }
        }
        if (z3 && !this.A) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i4 = this.f24485s;
        if (i4 != -1) {
            return i4;
        }
        int i5 = this.f24492z;
        if (i5 != 0 && i5 != 2) {
            return 0;
        }
        return this.f24487u;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f24469c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h() {
        int max;
        int i4 = this.f24492z;
        if (i4 != 0 && i4 != 2) {
            max = 0;
        } else {
            max = Math.max(0, this.f24488v - this.f24470d);
        }
        ViewCompat.setPaddingRelative(this.f24469c, max, 0, 0, 0);
        int i5 = this.f24492z;
        if (i5 != 0) {
            if (i5 == 1 || i5 == 2) {
                if (this.f24489w == 2) {
                    Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                this.f24469c.setGravity(1);
            }
        } else {
            g(this.f24489w);
        }
        z(true);
    }

    private int i(int i4, float f4) {
        View childAt;
        View view;
        int i5 = this.f24492z;
        int i6 = 0;
        if ((i5 != 0 && i5 != 2) || (childAt = this.f24469c.getChildAt(i4)) == null) {
            return 0;
        }
        int i7 = i4 + 1;
        if (i7 < this.f24469c.getChildCount()) {
            view = this.f24469c.getChildAt(i7);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i6 = view.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i8 = (int) ((width + i6) * 0.5f * f4);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            return left + i8;
        }
        return left - i8;
    }

    private void j(@NonNull Tab tab, int i4) {
        tab.f(i4);
        this.f24467a.add(i4, tab);
        int size = this.f24467a.size();
        while (true) {
            i4++;
            if (i4 < size) {
                this.f24467a.get(i4).f(i4);
            } else {
                return;
            }
        }
    }

    @NonNull
    private static ColorStateList k(int i4, int i5) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i5, i4});
    }

    @NonNull
    private LinearLayout.LayoutParams l() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        y(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView n(@NonNull Tab tab) {
        TabView tabView;
        Pools.Pool<TabView> pool = this.Q;
        if (pool != null) {
            tabView = pool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.f24510d)) {
            tabView.setContentDescription(tab.f24509c);
        } else {
            tabView.setContentDescription(tab.f24510d);
        }
        return tabView;
    }

    private void o(@NonNull Tab tab) {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).onTabReselected(tab);
        }
    }

    private void p(@NonNull Tab tab) {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).onTabSelected(tab);
        }
    }

    private void q(@NonNull Tab tab) {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).onTabUnselected(tab);
        }
    }

    private void r() {
        if (this.J == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.J = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.J.setDuration(this.f24490x);
            this.J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private void setSelectedTabView(int i4) {
        boolean z3;
        int childCount = this.f24469c.getChildCount();
        if (i4 < childCount) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.f24469c.getChildAt(i5);
                boolean z4 = true;
                if (i5 == i4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                childAt.setSelected(z3);
                if (i5 != i4) {
                    z4 = false;
                }
                childAt.setActivated(z4);
            }
        }
    }

    private void u(int i4) {
        TabView tabView = (TabView) this.f24469c.getChildAt(i4);
        this.f24469c.removeViewAt(i4);
        if (tabView != null) {
            tabView.s();
            this.Q.release(tabView);
        }
        requestLayout();
    }

    private void w(@Nullable ViewPager viewPager, boolean z3, boolean z4) {
        ViewPager viewPager2 = this.K;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.N;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.O;
            if (adapterChangeListener != null) {
                this.K.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.I;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.I = null;
        }
        if (viewPager != null) {
            this.K = viewPager;
            if (this.N == null) {
                this.N = new TabLayoutOnPageChangeListener(this);
            }
            this.N.a();
            viewPager.addOnPageChangeListener(this.N);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.I = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener((BaseOnTabSelectedListener) viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                v(adapter, z3);
            }
            if (this.O == null) {
                this.O = new AdapterChangeListener();
            }
            this.O.a(z3);
            viewPager.addOnAdapterChangeListener(this.O);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.K = null;
            v(null, false);
        }
        this.P = z4;
    }

    private void x() {
        int size = this.f24467a.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f24467a.get(i4).g();
        }
    }

    private void y(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.f24492z == 1 && this.f24489w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        addOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab) {
        addTab(tab, this.f24467a.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        e(view);
    }

    public void clearOnTabSelectedListeners() {
        this.H.clear();
    }

    public int getSelectedTabPosition() {
        Tab tab = this.f24468b;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    @Nullable
    public Tab getTabAt(int i4) {
        if (i4 >= 0 && i4 < getTabCount()) {
            return this.f24467a.get(i4);
        }
        return null;
    }

    public int getTabCount() {
        return this.f24467a.size();
    }

    public int getTabGravity() {
        return this.f24489w;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.f24476j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.D;
    }

    public int getTabIndicatorGravity() {
        return this.f24491y;
    }

    int getTabMaxWidth() {
        return this.f24484r;
    }

    public int getTabMode() {
        return this.f24492z;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.f24477k;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.f24478l;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f24475i;
    }

    public boolean hasUnboundedRipple() {
        return this.E;
    }

    public boolean isInlineLabel() {
        return this.A;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.B;
    }

    protected Tab m() {
        Tab acquire = S.acquire();
        if (acquire == null) {
            return new Tab();
        }
        return acquire;
    }

    @NonNull
    public Tab newTab() {
        Tab m4 = m();
        m4.parent = this;
        m4.view = n(m4);
        if (m4.f24514h != -1) {
            m4.view.setId(m4.f24514h);
        }
        return m4;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.K == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                w((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.P) {
            setupWithViewPager(null);
            this.P = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        for (int i4 = 0; i4 < this.f24469c.getChildCount(); i4++) {
            View childAt = this.f24469c.getChildAt(i4);
            if (childAt instanceof TabView) {
                ((TabView) childAt).m(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r0 != 2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L25;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.ViewUtils.dpToPx(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.f24486t
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.ViewUtils.dpToPx(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.f24484r = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.f24492z
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public void removeAllTabs() {
        for (int childCount = this.f24469c.getChildCount() - 1; childCount >= 0; childCount--) {
            u(childCount);
        }
        Iterator<Tab> it = this.f24467a.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.e();
            t(next);
        }
        this.f24468b = null;
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        removeOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void removeTab(@NonNull Tab tab) {
        if (tab.parent == this) {
            removeTabAt(tab.getPosition());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i4) {
        int i5;
        Tab tab;
        Tab tab2 = this.f24468b;
        if (tab2 != null) {
            i5 = tab2.getPosition();
        } else {
            i5 = 0;
        }
        u(i4);
        Tab remove = this.f24467a.remove(i4);
        if (remove != null) {
            remove.e();
            t(remove);
        }
        int size = this.f24467a.size();
        for (int i6 = i4; i6 < size; i6++) {
            this.f24467a.get(i6).f(i6);
        }
        if (i5 == i4) {
            if (this.f24467a.isEmpty()) {
                tab = null;
            } else {
                tab = this.f24467a.get(Math.max(0, i4 - 1));
            }
            selectTab(tab);
        }
    }

    void s() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter = this.L;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i4 = 0; i4 < count; i4++) {
                addTab(newTab().setText(this.L.getPageTitle(i4)), false);
            }
            ViewPager viewPager = this.K;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem));
            }
        }
    }

    public void selectTab(@Nullable Tab tab) {
        selectTab(tab, true);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f4) {
        super.setElevation(f4);
        MaterialShapeUtils.setElevation(this, f4);
    }

    public void setInlineLabel(boolean z3) {
        if (this.A != z3) {
            this.A = z3;
            for (int i4 = 0; i4 < this.f24469c.getChildCount(); i4++) {
                View childAt = this.f24469c.getChildAt(i4);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).z();
                }
            }
            h();
        }
    }

    public void setInlineLabelResource(@BoolRes int i4) {
        setInlineLabel(getResources().getBoolean(i4));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        r();
        this.J.addListener(animatorListener);
    }

    public void setScrollPosition(int i4, float f4, boolean z3) {
        setScrollPosition(i4, f4, z3, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.f24478l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f24478l = drawable;
            int i4 = this.C;
            if (i4 == -1) {
                i4 = drawable.getIntrinsicHeight();
            }
            this.f24469c.g(i4);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i4) {
        this.f24479m = i4;
        z(false);
    }

    public void setSelectedTabIndicatorGravity(int i4) {
        if (this.f24491y != i4) {
            this.f24491y = i4;
            ViewCompat.postInvalidateOnAnimation(this.f24469c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i4) {
        this.C = i4;
        this.f24469c.g(i4);
    }

    public void setTabGravity(int i4) {
        if (this.f24489w != i4) {
            this.f24489w = i4;
            h();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f24476j != colorStateList) {
            this.f24476j = colorStateList;
            x();
        }
    }

    public void setTabIconTintResource(@ColorRes int i4) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i4));
    }

    public void setTabIndicatorAnimationMode(int i4) {
        this.D = i4;
        if (i4 != 0) {
            if (i4 == 1) {
                this.F = new ElasticTabIndicatorInterpolator();
                return;
            }
            throw new IllegalArgumentException(i4 + " is not a valid TabIndicatorAnimationMode");
        }
        this.F = new TabIndicatorInterpolator();
    }

    public void setTabIndicatorFullWidth(boolean z3) {
        this.B = z3;
        this.f24469c.e();
        ViewCompat.postInvalidateOnAnimation(this.f24469c);
    }

    public void setTabMode(int i4) {
        if (i4 != this.f24492z) {
            this.f24492z = i4;
            h();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f24477k != colorStateList) {
            this.f24477k = colorStateList;
            for (int i4 = 0; i4 < this.f24469c.getChildCount(); i4++) {
                View childAt = this.f24469c.getChildAt(i4);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).y(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i4) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i4));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f24475i != colorStateList) {
            this.f24475i = colorStateList;
            x();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        v(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z3) {
        if (this.E != z3) {
            this.E = z3;
            for (int i4 = 0; i4 < this.f24469c.getChildCount(); i4++) {
                View childAt = this.f24469c.getChildAt(i4);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).y(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i4) {
        setUnboundedRipple(getResources().getBoolean(i4));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    protected boolean t(Tab tab) {
        return S.release(tab);
    }

    void v(@Nullable PagerAdapter pagerAdapter, boolean z3) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.L;
        if (pagerAdapter2 != null && (dataSetObserver = this.M) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.L = pagerAdapter;
        if (z3 && pagerAdapter != null) {
            if (this.M == null) {
                this.M = new PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.M);
        }
        s();
    }

    void z(boolean z3) {
        for (int i4 = 0; i4 < this.f24469c.getChildCount(); i4++) {
            View childAt = this.f24469c.getChildAt(i4);
            childAt.setMinimumWidth(getTabMinWidth());
            y((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z3) {
                childAt.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class Tab {
        public static final int INVALID_POSITION = -1;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Object f24507a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Drawable f24508b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f24509c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f24510d;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private View f24512f;
        @Nullable
        public TabLayout parent;
        @NonNull
        public TabView view;

        /* renamed from: e  reason: collision with root package name */
        private int f24511e = -1;
        @LabelVisibility

        /* renamed from: g  reason: collision with root package name */
        private int f24513g = 1;

        /* renamed from: h  reason: collision with root package name */
        private int f24514h = -1;

        void e() {
            this.parent = null;
            this.view = null;
            this.f24507a = null;
            this.f24508b = null;
            this.f24514h = -1;
            this.f24509c = null;
            this.f24510d = null;
            this.f24511e = -1;
            this.f24512f = null;
        }

        void f(int i4) {
            this.f24511e = i4;
        }

        void g() {
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.x();
            }
        }

        @Nullable
        public BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.f24512f;
        }

        @Nullable
        public Drawable getIcon() {
            return this.f24508b;
        }

        public int getId() {
            return this.f24514h;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public int getPosition() {
            return this.f24511e;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            return this.f24513g;
        }

        @Nullable
        public Object getTag() {
            return this.f24507a;
        }

        @Nullable
        public CharSequence getText() {
            return this.f24509c;
        }

        public boolean isSelected() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition != -1 && selectedTabPosition == this.f24511e) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            this.view.r();
        }

        public void select() {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                tabLayout.selectTab(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setContentDescription(@StringRes int i4) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setContentDescription(tabLayout.getResources().getText(i4));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setCustomView(@Nullable View view) {
            this.f24512f = view;
            g();
            return this;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable drawable) {
            this.f24508b = drawable;
            TabLayout tabLayout = this.parent;
            if (tabLayout.f24489w == 1 || tabLayout.f24492z == 2) {
                tabLayout.z(true);
            }
            g();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.o() && this.view.f24522e.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        public Tab setId(int i4) {
            this.f24514h = i4;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.setId(i4);
            }
            return this;
        }

        @NonNull
        public Tab setTabLabelVisibility(@LabelVisibility int i4) {
            this.f24513g = i4;
            TabLayout tabLayout = this.parent;
            if (tabLayout.f24489w == 1 || tabLayout.f24492z == 2) {
                tabLayout.z(true);
            }
            g();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.o() && this.view.f24522e.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        public Tab setTag(@Nullable Object obj) {
            this.f24507a = obj;
            return this;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f24510d) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.f24509c = charSequence;
            g();
            return this;
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int i4) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i4, (ViewGroup) this.view, false));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence charSequence) {
            this.f24510d = charSequence;
            g();
            return this;
        }

        @NonNull
        public Tab setText(@StringRes int i4) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setText(tabLayout.getResources().getText(i4));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab setIcon(@DrawableRes int i4) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i4));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (this.H.contains(baseOnTabSelectedListener)) {
            return;
        }
        this.H.add(baseOnTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab, int i4) {
        addTab(tab, i4, this.f24467a.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i4) {
        e(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.H.remove(baseOnTabSelectedListener);
    }

    public void selectTab(@Nullable Tab tab, boolean z3) {
        Tab tab2 = this.f24468b;
        if (tab2 == tab) {
            if (tab2 != null) {
                o(tab);
                f(tab.getPosition());
                return;
            }
            return;
        }
        int position = tab != null ? tab.getPosition() : -1;
        if (z3) {
            if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                f(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        this.f24468b = tab;
        if (tab2 != null) {
            q(tab2);
        }
        if (tab != null) {
            p(tab);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.G;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.G = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    public void setScrollPosition(int i4, float f4, boolean z3, boolean z4) {
        int round = Math.round(i4 + f4);
        if (round < 0 || round >= this.f24469c.getChildCount()) {
            return;
        }
        if (z4) {
            this.f24469c.f(i4, f4);
        }
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.J.cancel();
        }
        scrollTo(i4 < 0 ? 0 : i(i4, f4), 0);
        if (z3) {
            setSelectedTabView(round);
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z3) {
        w(viewPager, z3, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r12, @androidx.annotation.Nullable android.util.AttributeSet r13, int r14) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void addTab(@NonNull Tab tab, boolean z3) {
        addTab(tab, this.f24467a.size(), z3);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        e(view);
    }

    public void addTab(@NonNull Tab tab, int i4, boolean z3) {
        if (tab.parent == this) {
            j(tab, i4);
            d(tab);
            if (z3) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        e(view);
    }

    public void setTabTextColors(int i4, int i5) {
        setTabTextColors(k(i4, i5));
    }

    public void setSelectedTabIndicator(@DrawableRes int i4) {
        if (i4 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i4));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    /* loaded from: classes5.dex */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f24531a;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.f24531a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull Tab tab) {
            this.f24531a.setCurrentItem(tab.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab tab) {
        }
    }
}
