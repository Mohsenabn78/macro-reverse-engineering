package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {

    /* renamed from: a  reason: collision with root package name */
    private float f24980a;

    /* renamed from: b  reason: collision with root package name */
    private float f24981b;

    /* renamed from: c  reason: collision with root package name */
    private float f24982c;

    /* renamed from: d  reason: collision with root package name */
    private float f24983d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24984e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24985f;

    public ScaleProvider() {
        this(true);
    }

    private static Animator a(final View view, float f4, float f5) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, scaleX * f4, scaleX * f5), PropertyValuesHolder.ofFloat(View.SCALE_Y, f4 * scaleY, f5 * scaleY));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.ScaleProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
            }
        });
        return ofPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f24984e) {
            return a(view, this.f24982c, this.f24983d);
        }
        return a(view, this.f24981b, this.f24980a);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (!this.f24985f) {
            return null;
        }
        if (this.f24984e) {
            return a(view, this.f24980a, this.f24981b);
        }
        return a(view, this.f24983d, this.f24982c);
    }

    public float getIncomingEndScale() {
        return this.f24983d;
    }

    public float getIncomingStartScale() {
        return this.f24982c;
    }

    public float getOutgoingEndScale() {
        return this.f24981b;
    }

    public float getOutgoingStartScale() {
        return this.f24980a;
    }

    public boolean isGrowing() {
        return this.f24984e;
    }

    public boolean isScaleOnDisappear() {
        return this.f24985f;
    }

    public void setGrowing(boolean z3) {
        this.f24984e = z3;
    }

    public void setIncomingEndScale(float f4) {
        this.f24983d = f4;
    }

    public void setIncomingStartScale(float f4) {
        this.f24982c = f4;
    }

    public void setOutgoingEndScale(float f4) {
        this.f24981b = f4;
    }

    public void setOutgoingStartScale(float f4) {
        this.f24980a = f4;
    }

    public void setScaleOnDisappear(boolean z3) {
        this.f24985f = z3;
    }

    public ScaleProvider(boolean z3) {
        this.f24980a = 1.0f;
        this.f24981b = 1.1f;
        this.f24982c = 0.8f;
        this.f24983d = 1.0f;
        this.f24985f = true;
        this.f24984e = z3;
    }
}
