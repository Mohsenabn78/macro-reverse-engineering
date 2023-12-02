package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: classes5.dex */
public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;

    /* renamed from: o  reason: collision with root package name */
    static final int f24026o = R.style.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: a  reason: collision with root package name */
    S f24027a;

    /* renamed from: b  reason: collision with root package name */
    private int f24028b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24029c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24030d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24031e;

    /* renamed from: f  reason: collision with root package name */
    private final int f24032f;

    /* renamed from: g  reason: collision with root package name */
    private long f24033g;

    /* renamed from: h  reason: collision with root package name */
    AnimatorDurationScaleProvider f24034h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24035i;

    /* renamed from: j  reason: collision with root package name */
    private int f24036j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f24037k;

    /* renamed from: l  reason: collision with root package name */
    private final Runnable f24038l;

    /* renamed from: m  reason: collision with root package name */
    private final Animatable2Compat.AnimationCallback f24039m;

    /* renamed from: n  reason: collision with root package name */
    private final Animatable2Compat.AnimationCallback f24040n;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface ShowAnimationBehavior {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i4, f24026o), attributeSet, i4);
        this.f24033g = -1L;
        this.f24035i = false;
        this.f24036j = 4;
        this.f24037k = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.k();
            }
        };
        this.f24038l = new Runnable() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.2
            @Override // java.lang.Runnable
            public void run() {
                BaseProgressIndicator.this.j();
                BaseProgressIndicator.this.f24033g = -1L;
            }
        };
        this.f24039m = new Animatable2Compat.AnimationCallback() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.3
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                BaseProgressIndicator.this.setIndeterminate(false);
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setProgressCompat(baseProgressIndicator.f24028b, BaseProgressIndicator.this.f24029c);
            }
        };
        this.f24040n = new Animatable2Compat.AnimationCallback() { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.4
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                super.onAnimationEnd(drawable);
                if (!BaseProgressIndicator.this.f24035i) {
                    BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                    baseProgressIndicator.setVisibility(baseProgressIndicator.f24036j);
                }
            }
        };
        Context context2 = getContext();
        this.f24027a = i(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.BaseProgressIndicator, i4, i5, new int[0]);
        this.f24031e = obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.f24032f = Math.min(obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        obtainStyledAttributes.recycle();
        this.f24034h = new AnimatorDurationScaleProvider();
        this.f24030d = true;
    }

    @Nullable
    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().n();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f24032f > 0) {
            this.f24033g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean m() {
        if ((getProgressDrawable() != null && getProgressDrawable().isVisible()) || (getIndeterminateDrawable() != null && getIndeterminateDrawable().isVisible())) {
            return false;
        }
        return true;
    }

    private void n() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m().d(this.f24039m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.f24040n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.f24040n);
        }
    }

    private void o() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.f24040n);
            getIndeterminateDrawable().m().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.f24040n);
        }
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        if (isIndeterminate()) {
            return getIndeterminateDrawable();
        }
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f24027a.hideAnimationBehavior;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f24027a.indicatorColors;
    }

    public int getShowAnimationBehavior() {
        return this.f24027a.showAnimationBehavior;
    }

    @ColorInt
    public int getTrackColor() {
        return this.f24027a.trackColor;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.f24027a.trackCornerRadius;
    }

    @Px
    public int getTrackThickness() {
        return this.f24027a.trackThickness;
    }

    protected void h(boolean z3) {
        if (!this.f24030d) {
            return;
        }
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(p(), false, z3);
    }

    public void hide() {
        boolean z3;
        if (getVisibility() != 0) {
            removeCallbacks(this.f24037k);
            return;
        }
        removeCallbacks(this.f24038l);
        long uptimeMillis = SystemClock.uptimeMillis() - this.f24033g;
        int i4 = this.f24032f;
        if (uptimeMillis >= i4) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            this.f24038l.run();
        } else {
            postDelayed(this.f24038l, i4 - uptimeMillis);
        }
    }

    abstract S i(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() != 0) {
                    return false;
                }
                return true;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (p()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f24038l);
        removeCallbacks(this.f24037k);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        o();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i4, int i5) {
        int paddingLeft;
        int paddingTop;
        super.onMeasure(i4, i5);
        DrawingDelegate<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate == null) {
            return;
        }
        int e4 = currentDrawingDelegate.e();
        int d4 = currentDrawingDelegate.d();
        if (e4 < 0) {
            paddingLeft = getMeasuredWidth();
        } else {
            paddingLeft = e4 + getPaddingLeft() + getPaddingRight();
        }
        if (d4 < 0) {
            paddingTop = getMeasuredHeight();
        } else {
            paddingTop = d4 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i4) {
        boolean z3;
        super.onVisibilityChanged(view, i4);
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        h(z3);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        h(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        if (ViewCompat.isAttachedToWindow(this) && getWindowVisibility() == 0 && l()) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.f24034h = animatorDurationScaleProvider;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f24073c = animatorDurationScaleProvider;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f24073c = animatorDurationScaleProvider;
        }
    }

    public void setHideAnimationBehavior(int i4) {
        this.f24027a.hideAnimationBehavior = i4;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z3) {
        if (z3 == isIndeterminate()) {
            return;
        }
        DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
        if (drawableWithAnimatedVisibilityChange != null) {
            drawableWithAnimatedVisibilityChange.hideNow();
        }
        super.setIndeterminate(z3);
        DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
        if (drawableWithAnimatedVisibilityChange2 != null) {
            drawableWithAnimatedVisibilityChange2.setVisible(p(), false, false);
        }
        if ((drawableWithAnimatedVisibilityChange2 instanceof IndeterminateDrawable) && p()) {
            ((IndeterminateDrawable) drawableWithAnimatedVisibilityChange2).m().g();
        }
        this.f24035i = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof IndeterminateDrawable) {
            ((DrawableWithAnimatedVisibilityChange) drawable).hideNow();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.f24027a.indicatorColors = iArr;
            getIndeterminateDrawable().m().c();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i4) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i4, false);
    }

    public void setProgressCompat(int i4, boolean z3) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.f24028b = i4;
                this.f24029c = z3;
                this.f24035i = true;
                if (getIndeterminateDrawable().isVisible() && this.f24034h.getSystemAnimatorDurationScale(getContext().getContentResolver()) != 0.0f) {
                    getIndeterminateDrawable().m().f();
                    return;
                } else {
                    this.f24039m.onAnimationEnd(getIndeterminateDrawable());
                    return;
                }
            }
            return;
        }
        super.setProgress(i4);
        if (getProgressDrawable() != null && !z3) {
            getProgressDrawable().jumpToCurrentState();
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof DeterminateDrawable) {
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.hideNow();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.s(getProgress() / getMax());
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i4) {
        this.f24027a.showAnimationBehavior = i4;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i4) {
        S s3 = this.f24027a;
        if (s3.trackColor != i4) {
            s3.trackColor = i4;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i4) {
        S s3 = this.f24027a;
        if (s3.trackCornerRadius != i4) {
            s3.trackCornerRadius = Math.min(i4, s3.trackThickness / 2);
        }
    }

    public void setTrackThickness(@Px int i4) {
        S s3 = this.f24027a;
        if (s3.trackThickness != i4) {
            s3.trackThickness = i4;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i4) {
        if (i4 != 0 && i4 != 4 && i4 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f24036j = i4;
    }

    public void show() {
        if (this.f24031e > 0) {
            removeCallbacks(this.f24037k);
            postDelayed(this.f24037k, this.f24031e);
            return;
        }
        this.f24037k.run();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
