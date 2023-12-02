package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes5.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {

    /* renamed from: a  reason: collision with root package name */
    private float f25130a;

    /* renamed from: b  reason: collision with root package name */
    private float f25131b;

    /* renamed from: c  reason: collision with root package name */
    private float f25132c;

    /* renamed from: d  reason: collision with root package name */
    private float f25133d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25134e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25135f;

    public ScaleProvider() {
        this(true);
    }

    private static Animator a(final View view, float f4, float f5) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, scaleX * f4, scaleX * f5), PropertyValuesHolder.ofFloat(View.SCALE_Y, f4 * scaleY, f5 * scaleY));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.platform.ScaleProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
            }
        });
        return ofPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f25134e) {
            return a(view, this.f25132c, this.f25133d);
        }
        return a(view, this.f25131b, this.f25130a);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (!this.f25135f) {
            return null;
        }
        if (this.f25134e) {
            return a(view, this.f25130a, this.f25131b);
        }
        return a(view, this.f25133d, this.f25132c);
    }

    public float getIncomingEndScale() {
        return this.f25133d;
    }

    public float getIncomingStartScale() {
        return this.f25132c;
    }

    public float getOutgoingEndScale() {
        return this.f25131b;
    }

    public float getOutgoingStartScale() {
        return this.f25130a;
    }

    public boolean isGrowing() {
        return this.f25134e;
    }

    public boolean isScaleOnDisappear() {
        return this.f25135f;
    }

    public void setGrowing(boolean z3) {
        this.f25134e = z3;
    }

    public void setIncomingEndScale(float f4) {
        this.f25133d = f4;
    }

    public void setIncomingStartScale(float f4) {
        this.f25132c = f4;
    }

    public void setOutgoingEndScale(float f4) {
        this.f25131b = f4;
    }

    public void setOutgoingStartScale(float f4) {
        this.f25130a = f4;
    }

    public void setScaleOnDisappear(boolean z3) {
        this.f25135f = z3;
    }

    public ScaleProvider(boolean z3) {
        this.f25130a = 1.0f;
        this.f25131b = 1.1f;
        this.f25132c = 0.8f;
        this.f25133d = 1.0f;
        this.f25135f = true;
        this.f25134e = z3;
    }
}
