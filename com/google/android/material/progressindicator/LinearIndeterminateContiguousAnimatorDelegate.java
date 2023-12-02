package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: j  reason: collision with root package name */
    private static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> f24097j = new Property<LinearIndeterminateContiguousAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.2
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateContiguousAnimatorDelegate.n());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, Float f4) {
            linearIndeterminateContiguousAnimatorDelegate.r(f4.floatValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f24098d;

    /* renamed from: e  reason: collision with root package name */
    private FastOutSlowInInterpolator f24099e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseProgressIndicatorSpec f24100f;

    /* renamed from: g  reason: collision with root package name */
    private int f24101g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24102h;

    /* renamed from: i  reason: collision with root package name */
    private float f24103i;

    public LinearIndeterminateContiguousAnimatorDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f24101g = 1;
        this.f24100f = linearProgressIndicatorSpec;
        this.f24099e = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f24103i;
    }

    private void o() {
        if (this.f24098d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f24097j, 0.0f, 1.0f);
            this.f24098d = ofFloat;
            ofFloat.setDuration(333L);
            this.f24098d.setInterpolator(null);
            this.f24098d.setRepeatCount(-1);
            this.f24098d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = LinearIndeterminateContiguousAnimatorDelegate.this;
                    linearIndeterminateContiguousAnimatorDelegate.f24101g = (linearIndeterminateContiguousAnimatorDelegate.f24101g + 1) % LinearIndeterminateContiguousAnimatorDelegate.this.f24100f.indicatorColors.length;
                    LinearIndeterminateContiguousAnimatorDelegate.this.f24102h = true;
                }
            });
        }
    }

    private void p() {
        if (this.f24102h && this.f24090b[3] < 1.0f) {
            int[] iArr = this.f24091c;
            iArr[2] = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = MaterialColors.compositeARGBWithAlpha(this.f24100f.indicatorColors[this.f24101g], this.f24089a.getAlpha());
            this.f24102h = false;
        }
    }

    private void s(int i4) {
        this.f24090b[0] = 0.0f;
        float b4 = b(i4, 0, 667);
        float[] fArr = this.f24090b;
        float interpolation = this.f24099e.getInterpolation(b4);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.f24090b;
        float interpolation2 = this.f24099e.getInterpolation(b4 + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.f24090b[5] = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void a() {
        ObjectAnimator objectAnimator = this.f24098d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void g() {
        o();
        q();
        this.f24098d.start();
    }

    @VisibleForTesting
    void q() {
        this.f24102h = true;
        this.f24101g = 1;
        Arrays.fill(this.f24091c, MaterialColors.compositeARGBWithAlpha(this.f24100f.indicatorColors[0], this.f24089a.getAlpha()));
    }

    @VisibleForTesting
    void r(float f4) {
        this.f24103i = f4;
        s((int) (f4 * 333.0f));
        p();
        this.f24089a.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void h() {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void d(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }
}
