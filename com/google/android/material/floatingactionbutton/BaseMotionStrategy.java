package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class BaseMotionStrategy implements MotionStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23613a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ExtendedFloatingActionButton f23614b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f23615c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final AnimatorTracker f23616d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private MotionSpec f23617e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private MotionSpec f23618f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMotionStrategy(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.f23614b = extendedFloatingActionButton;
        this.f23613a = extendedFloatingActionButton.getContext();
        this.f23616d = animatorTracker;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @Nullable
    public MotionSpec a() {
        return this.f23618f;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void c(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23615c.remove(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public AnimatorSet e() {
        return n(o());
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void h() {
        this.f23616d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void i(@NonNull Animator.AnimatorListener animatorListener) {
        this.f23615c.add(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void j() {
        this.f23616d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void k(@Nullable MotionSpec motionSpec) {
        this.f23618f = motionSpec;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @NonNull
    public final List<Animator.AnimatorListener> l() {
        return this.f23615c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public AnimatorSet n(@NonNull MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec.hasPropertyValues("opacity")) {
            arrayList.add(motionSpec.getAnimator("opacity", this.f23614b, View.ALPHA));
        }
        if (motionSpec.hasPropertyValues("scale")) {
            arrayList.add(motionSpec.getAnimator("scale", this.f23614b, View.SCALE_Y));
            arrayList.add(motionSpec.getAnimator("scale", this.f23614b, View.SCALE_X));
        }
        if (motionSpec.hasPropertyValues("width")) {
            arrayList.add(motionSpec.getAnimator("width", this.f23614b, ExtendedFloatingActionButton.F));
        }
        if (motionSpec.hasPropertyValues("height")) {
            arrayList.add(motionSpec.getAnimator("height", this.f23614b, ExtendedFloatingActionButton.G));
        }
        if (motionSpec.hasPropertyValues("paddingStart")) {
            arrayList.add(motionSpec.getAnimator("paddingStart", this.f23614b, ExtendedFloatingActionButton.H));
        }
        if (motionSpec.hasPropertyValues("paddingEnd")) {
            arrayList.add(motionSpec.getAnimator("paddingEnd", this.f23614b, ExtendedFloatingActionButton.I));
        }
        if (motionSpec.hasPropertyValues("labelOpacity")) {
            arrayList.add(motionSpec.getAnimator("labelOpacity", this.f23614b, new Property<ExtendedFloatingActionButton, Float>(Float.class, "LABEL_OPACITY_PROPERTY") { // from class: com.google.android.material.floatingactionbutton.BaseMotionStrategy.1
                @Override // android.util.Property
                /* renamed from: a */
                public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
                    return Float.valueOf(AnimationUtils.lerp(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.D.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.f23614b.D.getDefaultColor()))));
                }

                @Override // android.util.Property
                /* renamed from: b */
                public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f4) {
                    int colorForState = extendedFloatingActionButton.D.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.f23614b.D.getDefaultColor());
                    ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.lerp(0.0f, Color.alpha(colorForState) / 255.0f, f4.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                    if (f4.floatValue() == 1.0f) {
                        extendedFloatingActionButton.A(extendedFloatingActionButton.D);
                    } else {
                        extendedFloatingActionButton.A(valueOf);
                    }
                }
            }));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final MotionSpec o() {
        MotionSpec motionSpec = this.f23618f;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.f23617e == null) {
            this.f23617e = MotionSpec.createFromResource(this.f23613a, d());
        }
        return (MotionSpec) Preconditions.checkNotNull(this.f23617e);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.f23616d.c(animator);
    }
}
