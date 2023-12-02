package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f24105l = {533, 567, 850, 750};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f24106m = {1267, 1000, 333, 0};

    /* renamed from: n  reason: collision with root package name */
    private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> f24107n = new Property<LinearIndeterminateDisjointAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.3
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateDisjointAnimatorDelegate.n());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, Float f4) {
            linearIndeterminateDisjointAnimatorDelegate.r(f4.floatValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f24108d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f24109e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator[] f24110f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseProgressIndicatorSpec f24111g;

    /* renamed from: h  reason: collision with root package name */
    private int f24112h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24113i;

    /* renamed from: j  reason: collision with root package name */
    private float f24114j;

    /* renamed from: k  reason: collision with root package name */
    Animatable2Compat.AnimationCallback f24115k;

    public LinearIndeterminateDisjointAnimatorDelegate(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f24112h = 0;
        this.f24115k = null;
        this.f24111g = linearProgressIndicatorSpec;
        this.f24110f = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f24114j;
    }

    private void o() {
        if (this.f24108d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f24107n, 0.0f, 1.0f);
            this.f24108d = ofFloat;
            ofFloat.setDuration(1800L);
            this.f24108d.setInterpolator(null);
            this.f24108d.setRepeatCount(-1);
            this.f24108d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    linearIndeterminateDisjointAnimatorDelegate.f24112h = (linearIndeterminateDisjointAnimatorDelegate.f24112h + 1) % LinearIndeterminateDisjointAnimatorDelegate.this.f24111g.indicatorColors.length;
                    LinearIndeterminateDisjointAnimatorDelegate.this.f24113i = true;
                }
            });
        }
        if (this.f24109e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f24107n, 1.0f);
            this.f24109e = ofFloat2;
            ofFloat2.setDuration(1800L);
            this.f24109e.setInterpolator(null);
            this.f24109e.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LinearIndeterminateDisjointAnimatorDelegate.this.a();
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    Animatable2Compat.AnimationCallback animationCallback = linearIndeterminateDisjointAnimatorDelegate.f24115k;
                    if (animationCallback != null) {
                        animationCallback.onAnimationEnd(linearIndeterminateDisjointAnimatorDelegate.f24089a);
                    }
                }
            });
        }
    }

    private void p() {
        if (this.f24113i) {
            Arrays.fill(this.f24091c, MaterialColors.compositeARGBWithAlpha(this.f24111g.indicatorColors[this.f24112h], this.f24089a.getAlpha()));
            this.f24113i = false;
        }
    }

    private void s(int i4) {
        for (int i5 = 0; i5 < 4; i5++) {
            this.f24090b[i5] = Math.max(0.0f, Math.min(1.0f, this.f24110f[i5].getInterpolation(b(i4, f24106m[i5], f24105l[i5]))));
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void a() {
        ObjectAnimator objectAnimator = this.f24108d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f24115k = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void f() {
        ObjectAnimator objectAnimator = this.f24109e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            a();
            if (this.f24089a.isVisible()) {
                this.f24109e.setFloatValues(this.f24114j, 1.0f);
                this.f24109e.setDuration((1.0f - this.f24114j) * 1800.0f);
                this.f24109e.start();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void g() {
        o();
        q();
        this.f24108d.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void h() {
        this.f24115k = null;
    }

    @VisibleForTesting
    void q() {
        this.f24112h = 0;
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.f24111g.indicatorColors[0], this.f24089a.getAlpha());
        int[] iArr = this.f24091c;
        iArr[0] = compositeARGBWithAlpha;
        iArr[1] = compositeARGBWithAlpha;
    }

    @VisibleForTesting
    void r(float f4) {
        this.f24114j = f4;
        s((int) (f4 * 1800.0f));
        p();
        this.f24089a.invalidateSelf();
    }
}
