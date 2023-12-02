package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f24049l = {0, 1350, 2700, 4050};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f24050m = {667, 2017, 3367, 4717};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f24051n = {1000, 2350, 3700, 5050};

    /* renamed from: o  reason: collision with root package name */
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> f24052o = new Property<CircularIndeterminateAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.3
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate.o());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f4) {
            circularIndeterminateAnimatorDelegate.t(f4.floatValue());
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> f24053p = new Property<CircularIndeterminateAnimatorDelegate, Float>(Float.class, "completeEndFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.4
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate.p());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f4) {
            circularIndeterminateAnimatorDelegate.u(f4.floatValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f24054d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f24055e;

    /* renamed from: f  reason: collision with root package name */
    private final FastOutSlowInInterpolator f24056f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseProgressIndicatorSpec f24057g;

    /* renamed from: h  reason: collision with root package name */
    private int f24058h;

    /* renamed from: i  reason: collision with root package name */
    private float f24059i;

    /* renamed from: j  reason: collision with root package name */
    private float f24060j;

    /* renamed from: k  reason: collision with root package name */
    Animatable2Compat.AnimationCallback f24061k;

    public CircularIndeterminateAnimatorDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f24058h = 0;
        this.f24061k = null;
        this.f24057g = circularProgressIndicatorSpec;
        this.f24056f = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.f24059i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f24060j;
    }

    private void q() {
        if (this.f24054d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f24052o, 0.0f, 1.0f);
            this.f24054d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f24054d.setInterpolator(null);
            this.f24054d.setRepeatCount(-1);
            this.f24054d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.f24058h = (circularIndeterminateAnimatorDelegate.f24058h + 4) % CircularIndeterminateAnimatorDelegate.this.f24057g.indicatorColors.length;
                }
            });
        }
        if (this.f24055e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f24053p, 0.0f, 1.0f);
            this.f24055e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f24055e.setInterpolator(this.f24056f);
            this.f24055e.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateAnimatorDelegate.this.a();
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    Animatable2Compat.AnimationCallback animationCallback = circularIndeterminateAnimatorDelegate.f24061k;
                    if (animationCallback != null) {
                        animationCallback.onAnimationEnd(circularIndeterminateAnimatorDelegate.f24089a);
                    }
                }
            });
        }
    }

    private void r(int i4) {
        for (int i5 = 0; i5 < 4; i5++) {
            float b4 = b(i4, f24051n[i5], 333);
            if (b4 >= 0.0f && b4 <= 1.0f) {
                int i6 = i5 + this.f24058h;
                int[] iArr = this.f24057g.indicatorColors;
                int length = i6 % iArr.length;
                int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(iArr[length], this.f24089a.getAlpha());
                int compositeARGBWithAlpha2 = MaterialColors.compositeARGBWithAlpha(this.f24057g.indicatorColors[(length + 1) % iArr.length], this.f24089a.getAlpha());
                this.f24091c[0] = ArgbEvaluatorCompat.getInstance().evaluate(this.f24056f.getInterpolation(b4), Integer.valueOf(compositeARGBWithAlpha), Integer.valueOf(compositeARGBWithAlpha2)).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f4) {
        this.f24060j = f4;
    }

    private void v(int i4) {
        float[] fArr = this.f24090b;
        float f4 = this.f24059i;
        fArr[0] = (f4 * 1520.0f) - 20.0f;
        fArr[1] = f4 * 1520.0f;
        for (int i5 = 0; i5 < 4; i5++) {
            float b4 = b(i4, f24049l[i5], 667);
            float[] fArr2 = this.f24090b;
            fArr2[1] = fArr2[1] + (this.f24056f.getInterpolation(b4) * 250.0f);
            float b5 = b(i4, f24050m[i5], 667);
            float[] fArr3 = this.f24090b;
            fArr3[0] = fArr3[0] + (this.f24056f.getInterpolation(b5) * 250.0f);
        }
        float[] fArr4 = this.f24090b;
        float f5 = fArr4[0];
        float f6 = fArr4[1];
        float f7 = f5 + ((f6 - f5) * this.f24060j);
        fArr4[0] = f7;
        fArr4[0] = f7 / 360.0f;
        fArr4[1] = f6 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void a() {
        ObjectAnimator objectAnimator = this.f24054d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f24061k = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void f() {
        ObjectAnimator objectAnimator = this.f24055e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f24089a.isVisible()) {
                this.f24055e.start();
            } else {
                a();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void g() {
        q();
        s();
        this.f24054d.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void h() {
        this.f24061k = null;
    }

    @VisibleForTesting
    void s() {
        this.f24058h = 0;
        this.f24091c[0] = MaterialColors.compositeARGBWithAlpha(this.f24057g.indicatorColors[0], this.f24089a.getAlpha());
        this.f24060j = 0.0f;
    }

    @VisibleForTesting
    void t(float f4) {
        this.f24059i = f4;
        int i4 = (int) (f4 * 5400.0f);
        v(i4);
        r(i4);
        this.f24089a.invalidateSelf();
    }
}
