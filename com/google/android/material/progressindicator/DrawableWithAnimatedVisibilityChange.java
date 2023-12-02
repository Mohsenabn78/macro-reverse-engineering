package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {

    /* renamed from: o  reason: collision with root package name */
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> f24070o = new Property<DrawableWithAnimatedVisibilityChange, Float>(Float.class, "growFraction") { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.3
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.g());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f4) {
            drawableWithAnimatedVisibilityChange.i(f4.floatValue());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final Context f24071a;

    /* renamed from: b  reason: collision with root package name */
    final BaseProgressIndicatorSpec f24072b;

    /* renamed from: d  reason: collision with root package name */
    private ValueAnimator f24074d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f24075e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24076f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24077g;

    /* renamed from: h  reason: collision with root package name */
    private float f24078h;

    /* renamed from: i  reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f24079i;

    /* renamed from: j  reason: collision with root package name */
    private Animatable2Compat.AnimationCallback f24080j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24081k;

    /* renamed from: l  reason: collision with root package name */
    private float f24082l;

    /* renamed from: n  reason: collision with root package name */
    private int f24084n;

    /* renamed from: m  reason: collision with root package name */
    final Paint f24083m = new Paint();

    /* renamed from: c  reason: collision with root package name */
    AnimatorDurationScaleProvider f24073c = new AnimatorDurationScaleProvider();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawableWithAnimatedVisibilityChange(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.f24071a = context;
        this.f24072b = baseProgressIndicatorSpec;
        setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Animatable2Compat.AnimationCallback animationCallback = this.f24080j;
        if (animationCallback != null) {
            animationCallback.onAnimationEnd(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.f24079i;
        if (list != null && !this.f24081k) {
            for (Animatable2Compat.AnimationCallback animationCallback2 : list) {
                animationCallback2.onAnimationEnd(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Animatable2Compat.AnimationCallback animationCallback = this.f24080j;
        if (animationCallback != null) {
            animationCallback.onAnimationStart(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.f24079i;
        if (list != null && !this.f24081k) {
            for (Animatable2Compat.AnimationCallback animationCallback2 : list) {
                animationCallback2.onAnimationStart(this);
            }
        }
    }

    private void f(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z3 = this.f24081k;
        this.f24081k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f24081k = z3;
    }

    private void h() {
        if (this.f24074d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f24070o, 0.0f, 1.0f);
            this.f24074d = ofFloat;
            ofFloat.setDuration(500L);
            this.f24074d.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            k(this.f24074d);
        }
        if (this.f24075e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f24070o, 1.0f, 0.0f);
            this.f24075e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f24075e.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            j(this.f24075e);
        }
    }

    private void j(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f24075e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f24075e = valueAnimator;
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                DrawableWithAnimatedVisibilityChange.this.d();
            }
        });
    }

    private void k(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f24074d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f24074d = valueAnimator;
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                DrawableWithAnimatedVisibilityChange.this.e();
            }
        });
    }

    public void clearAnimationCallbacks() {
        this.f24079i.clear();
        this.f24079i = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        if (!this.f24072b.isShowAnimationEnabled() && !this.f24072b.isHideAnimationEnabled()) {
            return 1.0f;
        }
        if (!this.f24077g && !this.f24076f) {
            return this.f24082l;
        }
        return this.f24078h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f24084n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean hideNow() {
        return setVisible(false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.f24082l != f4) {
            this.f24082l = f4;
            invalidateSelf();
        }
    }

    public boolean isHiding() {
        ValueAnimator valueAnimator = this.f24075e;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f24077g) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        if (!isShowing() && !isHiding()) {
            return false;
        }
        return true;
    }

    public boolean isShowing() {
        ValueAnimator valueAnimator = this.f24074d;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f24076f) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(boolean z3, boolean z4, boolean z5) {
        ValueAnimator valueAnimator;
        boolean z6;
        boolean isHideAnimationEnabled;
        h();
        if (!isVisible() && !z3) {
            return false;
        }
        if (z3) {
            valueAnimator = this.f24074d;
        } else {
            valueAnimator = this.f24075e;
        }
        if (!z5) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                f(valueAnimator);
            }
            return super.setVisible(z3, false);
        } else if (z5 && valueAnimator.isRunning()) {
            return false;
        } else {
            if (z3 && !super.setVisible(z3, false)) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (z3) {
                isHideAnimationEnabled = this.f24072b.isShowAnimationEnabled();
            } else {
                isHideAnimationEnabled = this.f24072b.isHideAnimationEnabled();
            }
            if (!isHideAnimationEnabled) {
                f(valueAnimator);
                return z6;
            }
            if (!z4 && valueAnimator.isPaused()) {
                valueAnimator.resume();
            } else {
                valueAnimator.start();
            }
            return z6;
        }
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.f24079i == null) {
            this.f24079i = new ArrayList();
        }
        if (!this.f24079i.contains(animationCallback)) {
            this.f24079i.add(animationCallback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f24084n = i4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f24083m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        return setVisible(z3, z4, true);
    }

    public void start() {
        l(true, true, false);
    }

    public void stop() {
        l(false, true, false);
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f24079i;
        if (list != null && list.contains(animationCallback)) {
            this.f24079i.remove(animationCallback);
            if (this.f24079i.isEmpty()) {
                this.f24079i = null;
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean setVisible(boolean z3, boolean z4, boolean z5) {
        return l(z3, z4, z5 && this.f24073c.getSystemAnimatorDurationScale(this.f24071a.getContentResolver()) > 0.0f);
    }
}
