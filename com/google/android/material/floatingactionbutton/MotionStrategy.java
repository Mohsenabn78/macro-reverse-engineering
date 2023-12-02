package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public interface MotionStrategy {
    @Nullable
    MotionSpec a();

    boolean b();

    void c(@NonNull Animator.AnimatorListener animatorListener);

    @AnimatorRes
    int d();

    AnimatorSet e();

    void f(@Nullable ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void g();

    void h();

    void i(@NonNull Animator.AnimatorListener animatorListener);

    void j();

    void k(@Nullable MotionSpec motionSpec);

    List<Animator.AnimatorListener> l();

    void onAnimationStart(Animator animator);
}
