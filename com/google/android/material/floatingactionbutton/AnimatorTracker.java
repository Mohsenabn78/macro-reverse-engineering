package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
class AnimatorTracker {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Animator f23612a;

    public void a() {
        Animator animator = this.f23612a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f23612a = null;
    }

    public void c(Animator animator) {
        a();
        this.f23612a = animator;
    }
}
