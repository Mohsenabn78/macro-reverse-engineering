package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
/* loaded from: classes5.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private AnimatorSet f24839b;

    public ExpandableTransformationBehavior() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    public boolean d(View view, View view2, boolean z3, boolean z4) {
        boolean z5;
        AnimatorSet animatorSet = this.f24839b;
        if (animatorSet != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            animatorSet.cancel();
        }
        AnimatorSet f4 = f(view, view2, z3, z5);
        this.f24839b = f4;
        f4.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.ExpandableTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ExpandableTransformationBehavior.this.f24839b = null;
            }
        });
        this.f24839b.start();
        if (!z4) {
            this.f24839b.end();
        }
        return true;
    }

    @NonNull
    protected abstract AnimatorSet f(View view, View view2, boolean z3, boolean z4);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
