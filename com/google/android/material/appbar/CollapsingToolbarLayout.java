package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int D = R.style.Widget_Design_CollapsingToolbar;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;
    private boolean A;
    private int B;
    private boolean C;

    /* renamed from: a  reason: collision with root package name */
    private boolean f22950a;

    /* renamed from: b  reason: collision with root package name */
    private int f22951b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f22952c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private View f22953d;

    /* renamed from: e  reason: collision with root package name */
    private View f22954e;

    /* renamed from: f  reason: collision with root package name */
    private int f22955f;

    /* renamed from: g  reason: collision with root package name */
    private int f22956g;

    /* renamed from: h  reason: collision with root package name */
    private int f22957h;

    /* renamed from: i  reason: collision with root package name */
    private int f22958i;

    /* renamed from: j  reason: collision with root package name */
    private final Rect f22959j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    final CollapsingTextHelper f22960k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    final ElevationOverlayProvider f22961l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22962m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f22963n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Drawable f22964o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    Drawable f22965p;

    /* renamed from: q  reason: collision with root package name */
    private int f22966q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f22967r;

    /* renamed from: s  reason: collision with root package name */
    private ValueAnimator f22968s;

    /* renamed from: t  reason: collision with root package name */
    private long f22969t;

    /* renamed from: u  reason: collision with root package name */
    private int f22970u;

    /* renamed from: v  reason: collision with root package name */
    private AppBarLayout.OnOffsetChangedListener f22971v;

    /* renamed from: w  reason: collision with root package name */
    int f22972w;

    /* renamed from: x  reason: collision with root package name */
    private int f22973x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    WindowInsetsCompat f22974y;

    /* renamed from: z  reason: collision with root package name */
    private int f22975z;

    /* loaded from: classes5.dex */
    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i4) {
            int i5;
            int height;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f22972w = i4;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.f22974y;
            if (windowInsetsCompat != null) {
                i5 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i5 = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper j4 = CollapsingToolbarLayout.j(childAt);
                int i7 = layoutParams.f22978a;
                if (i7 != 1) {
                    if (i7 == 2) {
                        j4.j(Math.round((-i4) * layoutParams.f22979b));
                    }
                } else {
                    j4.j(MathUtils.clamp(-i4, 0, CollapsingToolbarLayout.this.h(childAt)));
                }
            }
            CollapsingToolbarLayout.this.t();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f22965p != null && i5 > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height2 = (CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - i5;
            float f4 = height2;
            CollapsingToolbarLayout.this.f22960k.setFadeModeStartFraction(Math.min(1.0f, (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f4));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f22960k.setCurrentOffsetY(collapsingToolbarLayout3.f22972w + height2);
            CollapsingToolbarLayout.this.f22960k.setExpansionFraction(Math.abs(i4) / f4);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface TitleCollapseMode {
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a(int i4) {
        TimeInterpolator timeInterpolator;
        c();
        ValueAnimator valueAnimator = this.f22968s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f22968s = valueAnimator2;
            if (i4 > this.f22966q) {
                timeInterpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            } else {
                timeInterpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            valueAnimator2.setInterpolator(timeInterpolator);
            this.f22968s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator3) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator3.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.f22968s.cancel();
        }
        this.f22968s.setDuration(this.f22969t);
        this.f22968s.setIntValues(this.f22966q, i4);
        this.f22968s.start();
    }

    private void b(AppBarLayout appBarLayout) {
        if (k()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void c() {
        if (!this.f22950a) {
            return;
        }
        ViewGroup viewGroup = null;
        this.f22952c = null;
        this.f22953d = null;
        int i4 = this.f22951b;
        if (i4 != -1) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(i4);
            this.f22952c = viewGroup2;
            if (viewGroup2 != null) {
                this.f22953d = d(viewGroup2);
            }
        }
        if (this.f22952c == null) {
            int childCount = getChildCount();
            int i5 = 0;
            while (true) {
                if (i5 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i5);
                if (l(childAt)) {
                    viewGroup = (ViewGroup) childAt;
                    break;
                }
                i5++;
            }
            this.f22952c = viewGroup;
        }
        s();
        this.f22950a = false;
    }

    @NonNull
    private View d(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return view;
    }

    private static int g(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getMeasuredHeight();
    }

    private static CharSequence i(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    static ViewOffsetHelper j(@NonNull View view) {
        int i4 = R.id.view_offset_helper;
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(i4);
        if (viewOffsetHelper == null) {
            ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
            view.setTag(i4, viewOffsetHelper2);
            return viewOffsetHelper2;
        }
        return viewOffsetHelper;
    }

    private boolean k() {
        if (this.f22973x == 1) {
            return true;
        }
        return false;
    }

    private static boolean l(View view) {
        if (!(view instanceof Toolbar) && !(view instanceof android.widget.Toolbar)) {
            return false;
        }
        return true;
    }

    private boolean m(View view) {
        View view2 = this.f22953d;
        if (view2 != null && view2 != this) {
            if (view == view2) {
                return true;
            }
        } else if (view == this.f22952c) {
            return true;
        }
        return false;
    }

    private void o(boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        View view = this.f22953d;
        if (view == null) {
            view = this.f22952c;
        }
        int h4 = h(view);
        DescendantOffsetUtils.getDescendantRect(this, this.f22954e, this.f22959j);
        ViewGroup viewGroup = this.f22952c;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i4 = toolbar.getTitleMarginStart();
            i6 = toolbar.getTitleMarginEnd();
            i7 = toolbar.getTitleMarginTop();
            i5 = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT >= 24 && (viewGroup instanceof android.widget.Toolbar)) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i4 = toolbar2.getTitleMarginStart();
            i6 = toolbar2.getTitleMarginEnd();
            i7 = toolbar2.getTitleMarginTop();
            i5 = toolbar2.getTitleMarginBottom();
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        CollapsingTextHelper collapsingTextHelper = this.f22960k;
        Rect rect = this.f22959j;
        int i9 = rect.left;
        if (z3) {
            i8 = i6;
        } else {
            i8 = i4;
        }
        int i10 = i9 + i8;
        int i11 = rect.top + h4 + i7;
        int i12 = rect.right;
        if (!z3) {
            i4 = i6;
        }
        collapsingTextHelper.setCollapsedBounds(i10, i11, i12 - i4, (rect.bottom + h4) - i5);
    }

    private void p() {
        setContentDescription(getTitle());
    }

    private void q(@NonNull Drawable drawable, int i4, int i5) {
        r(drawable, this.f22952c, i4, i5);
    }

    private void r(@NonNull Drawable drawable, @Nullable View view, int i4, int i5) {
        if (k() && view != null && this.f22962m) {
            i5 = view.getBottom();
        }
        drawable.setBounds(0, 0, i4, i5);
    }

    private void s() {
        View view;
        if (!this.f22962m && (view = this.f22954e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f22954e);
            }
        }
        if (this.f22962m && this.f22952c != null) {
            if (this.f22954e == null) {
                this.f22954e = new View(getContext());
            }
            if (this.f22954e.getParent() == null) {
                this.f22952c.addView(this.f22954e, -1, -1);
            }
        }
    }

    private void u(int i4, int i5, int i6, int i7, boolean z3) {
        View view;
        boolean z4;
        int i8;
        int i9;
        if (this.f22962m && (view = this.f22954e) != null) {
            boolean z5 = false;
            if (ViewCompat.isAttachedToWindow(view) && this.f22954e.getVisibility() == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f22963n = z4;
            if (z4 || z3) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    z5 = true;
                }
                o(z5);
                CollapsingTextHelper collapsingTextHelper = this.f22960k;
                if (z5) {
                    i8 = this.f22957h;
                } else {
                    i8 = this.f22955f;
                }
                int i10 = this.f22959j.top + this.f22956g;
                int i11 = i6 - i4;
                if (z5) {
                    i9 = this.f22955f;
                } else {
                    i9 = this.f22957h;
                }
                collapsingTextHelper.setExpandedBounds(i8, i10, i11 - i9, (i7 - i5) - this.f22958i);
                this.f22960k.recalculate(z3);
            }
        }
    }

    private void v() {
        if (this.f22952c != null && this.f22962m && TextUtils.isEmpty(this.f22960k.getText())) {
            setTitle(i(this.f22952c));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i4;
        Drawable drawable;
        super.draw(canvas);
        c();
        if (this.f22952c == null && (drawable = this.f22964o) != null && this.f22966q > 0) {
            drawable.mutate().setAlpha(this.f22966q);
            this.f22964o.draw(canvas);
        }
        if (this.f22962m && this.f22963n) {
            if (this.f22952c != null && this.f22964o != null && this.f22966q > 0 && k() && this.f22960k.getExpansionFraction() < this.f22960k.getFadeModeThresholdFraction()) {
                int save = canvas.save();
                canvas.clipRect(this.f22964o.getBounds(), Region.Op.DIFFERENCE);
                this.f22960k.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                this.f22960k.draw(canvas);
            }
        }
        if (this.f22965p != null && this.f22966q > 0) {
            WindowInsetsCompat windowInsetsCompat = this.f22974y;
            if (windowInsetsCompat != null) {
                i4 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                this.f22965p.setBounds(0, -this.f22972w, getWidth(), i4 - this.f22972w);
                this.f22965p.mutate().setAlpha(this.f22966q);
                this.f22965p.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j4) {
        boolean z3;
        if (this.f22964o != null && this.f22966q > 0 && m(view)) {
            r(this.f22964o, view, getWidth(), getHeight());
            this.f22964o.mutate().setAlpha(this.f22966q);
            this.f22964o.draw(canvas);
            z3 = true;
        } else {
            z3 = false;
        }
        if (super.drawChild(canvas, view, j4) || z3) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f22965p;
        boolean z3 = false;
        if (drawable != null && drawable.isStateful()) {
            z3 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f22964o;
        if (drawable2 != null && drawable2.isStateful()) {
            z3 |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.f22960k;
        if (collapsingTextHelper != null) {
            z3 |= collapsingTextHelper.setState(drawableState);
        }
        if (z3) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f22960k.getCollapsedTextGravity();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.f22960k.getCollapsedTypeface();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.f22964o;
    }

    public int getExpandedTitleGravity() {
        return this.f22960k.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f22958i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f22957h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f22955f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f22956g;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.f22960k.getExpandedTypeface();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.f22960k.getHyphenationFrequency();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.f22960k.getLineCount();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.f22960k.getLineSpacingAdd();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.f22960k.getLineSpacingMultiplier();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.f22960k.getMaxLines();
    }

    int getScrimAlpha() {
        return this.f22966q;
    }

    public long getScrimAnimationDuration() {
        return this.f22969t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i4;
        int i5 = this.f22970u;
        if (i5 >= 0) {
            return i5 + this.f22975z + this.B;
        }
        WindowInsetsCompat windowInsetsCompat = this.f22974y;
        if (windowInsetsCompat != null) {
            i4 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i4 = 0;
        }
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + i4, getHeight());
        }
        return getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.f22965p;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.f22962m) {
            return this.f22960k.getText();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.f22973x;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f22960k.getPositionInterpolator();
    }

    final int h(@NonNull View view) {
        return ((getHeight() - j(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isExtraMultilineHeightEnabled() {
        return this.C;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isForceApplySystemWindowInsetTop() {
        return this.A;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.f22960k.isRtlTextDirectionHeuristicsEnabled();
    }

    public boolean isTitleEnabled() {
        return this.f22962m;
    }

    WindowInsetsCompat n(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.f22974y, windowInsetsCompat2)) {
            this.f22974y = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            b(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.f22971v == null) {
                this.f22971v = new OffsetUpdateListener();
            }
            appBarLayout.addOnOffsetChangedListener(this.f22971v);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.f22971v;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        WindowInsetsCompat windowInsetsCompat = this.f22974y;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i9 = 0; i9 < childCount2; i9++) {
            j(getChildAt(i9)).g();
        }
        u(i4, i5, i6, i7, false);
        v();
        t();
        int childCount3 = getChildCount();
        for (int i10 = 0; i10 < childCount3; i10++) {
            j(getChildAt(i10)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6;
        c();
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        WindowInsetsCompat windowInsetsCompat = this.f22974y;
        if (windowInsetsCompat != null) {
            i6 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i6 = 0;
        }
        if ((mode == 0 || this.A) && i6 > 0) {
            this.f22975z = i6;
            super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i6, 1073741824));
        }
        if (this.C && this.f22960k.getMaxLines() > 1) {
            v();
            u(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int expandedLineCount = this.f22960k.getExpandedLineCount();
            if (expandedLineCount > 1) {
                this.B = Math.round(this.f22960k.getExpandedTextFullHeight()) * (expandedLineCount - 1);
                super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.B, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f22952c;
        if (viewGroup != null) {
            View view = this.f22953d;
            if (view != null && view != this) {
                setMinimumHeight(g(view));
            } else {
                setMinimumHeight(g(viewGroup));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        Drawable drawable = this.f22964o;
        if (drawable != null) {
            q(drawable, i4, i5);
        }
    }

    public void setCollapsedTitleGravity(int i4) {
        this.f22960k.setCollapsedTextGravity(i4);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i4) {
        this.f22960k.setCollapsedTextAppearance(i4);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i4) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.f22960k.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f22964o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f22964o = drawable3;
            if (drawable3 != null) {
                q(drawable3, getWidth(), getHeight());
                this.f22964o.setCallback(this);
                this.f22964o.setAlpha(this.f22966q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i4) {
        setContentScrim(new ColorDrawable(i4));
    }

    public void setContentScrimResource(@DrawableRes int i4) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i4));
    }

    public void setExpandedTitleColor(@ColorInt int i4) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setExpandedTitleGravity(int i4) {
        this.f22960k.setExpandedTextGravity(i4);
    }

    public void setExpandedTitleMargin(int i4, int i5, int i6, int i7) {
        this.f22955f = i4;
        this.f22956g = i5;
        this.f22957h = i6;
        this.f22958i = i7;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i4) {
        this.f22958i = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i4) {
        this.f22957h = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i4) {
        this.f22955f = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i4) {
        this.f22956g = i4;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i4) {
        this.f22960k.setExpandedTextAppearance(i4);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f22960k.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.f22960k.setExpandedTypeface(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z3) {
        this.C = z3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z3) {
        this.A = z3;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i4) {
        this.f22960k.setHyphenationFrequency(i4);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f4) {
        this.f22960k.setLineSpacingAdd(f4);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f4) {
        this.f22960k.setLineSpacingMultiplier(f4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i4) {
        this.f22960k.setMaxLines(i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z3) {
        this.f22960k.setRtlTextDirectionHeuristicsEnabled(z3);
    }

    void setScrimAlpha(int i4) {
        ViewGroup viewGroup;
        if (i4 != this.f22966q) {
            if (this.f22964o != null && (viewGroup = this.f22952c) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.f22966q = i4;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j4) {
        this.f22969t = j4;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i4) {
        if (this.f22970u != i4) {
            this.f22970u = i4;
            t();
        }
    }

    public void setScrimsShown(boolean z3) {
        setScrimsShown(z3, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        boolean z3;
        Drawable drawable2 = this.f22965p;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f22965p = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f22965p.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f22965p, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.f22965p;
                if (getVisibility() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                drawable4.setVisible(z3, false);
                this.f22965p.setCallback(this);
                this.f22965p.setAlpha(this.f22966q);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i4) {
        setStatusBarScrim(new ColorDrawable(i4));
    }

    public void setStatusBarScrimResource(@DrawableRes int i4) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i4));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f22960k.setText(charSequence);
        p();
    }

    public void setTitleCollapseMode(int i4) {
        this.f22973x = i4;
        boolean k4 = k();
        this.f22960k.setFadeModeEnabled(k4);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            b((AppBarLayout) parent);
        }
        if (k4 && this.f22964o == null) {
            setContentScrimColor(this.f22961l.compositeOverlayWithThemeSurfaceColorIfNeeded(getResources().getDimension(R.dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEnabled(boolean z3) {
        if (z3 != this.f22962m) {
            this.f22962m = z3;
            p();
            s();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.f22960k.setPositionInterpolator(timeInterpolator);
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
        Drawable drawable = this.f22965p;
        if (drawable != null && drawable.isVisible() != z3) {
            this.f22965p.setVisible(z3, false);
        }
        Drawable drawable2 = this.f22964o;
        if (drawable2 != null && drawable2.isVisible() != z3) {
            this.f22964o.setVisible(z3, false);
        }
    }

    final void t() {
        boolean z3;
        if (this.f22964o != null || this.f22965p != null) {
            if (getHeight() + this.f22972w < getScrimVisibleHeightTrigger()) {
                z3 = true;
            } else {
                z3 = false;
            }
            setScrimsShown(z3);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f22964o && drawable != this.f22965p) {
            return false;
        }
        return true;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f22960k.setCollapsedTextColor(colorStateList);
    }

    public void setScrimsShown(boolean z3, boolean z4) {
        if (this.f22967r != z3) {
            if (z4) {
                a(z3 ? 255 : 0);
            } else {
                setScrimAlpha(z3 ? 255 : 0);
            }
            this.f22967r = z3;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes5.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;

        /* renamed from: a  reason: collision with root package name */
        int f22978a;

        /* renamed from: b  reason: collision with root package name */
        float f22979b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f22978a = 0;
            this.f22979b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f22978a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public int getCollapseMode() {
            return this.f22978a;
        }

        public float getParallaxMultiplier() {
            return this.f22979b;
        }

        public void setCollapseMode(int i4) {
            this.f22978a = i4;
        }

        public void setParallaxMultiplier(float f4) {
            this.f22979b = f4;
        }

        public LayoutParams(int i4, int i5) {
            super(i4, i5);
            this.f22978a = 0;
            this.f22979b = 0.5f;
        }

        public LayoutParams(int i4, int i5, int i6) {
            super(i4, i5, i6);
            this.f22978a = 0;
            this.f22979b = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f22978a = 0;
            this.f22979b = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f22978a = 0;
            this.f22979b = 0.5f;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f22978a = 0;
            this.f22979b = 0.5f;
        }
    }
}
