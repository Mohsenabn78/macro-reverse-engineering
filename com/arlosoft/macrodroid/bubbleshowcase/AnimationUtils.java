package com.arlosoft.macrodroid.bubbleshowcase;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AnimationUtils.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AnimationUtils {
    public static final int $stable = 0;
    @NotNull
    public static final AnimationUtils INSTANCE = new AnimationUtils();

    private AnimationUtils() {
    }

    @NotNull
    public final Animation getFadeInAnimation(int i4, int i5) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setStartOffset(i4);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(i5);
        return alphaAnimation;
    }

    @NotNull
    public final Animation getScaleAnimation(int i4, int i5) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setStartOffset(i4);
        scaleAnimation.setDuration(i5);
        return scaleAnimation;
    }

    @NotNull
    public final View setAnimationToView(@NotNull View view, @NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(animation, "animation");
        view.startAnimation(animation);
        return view;
    }

    @NotNull
    public final View setBouncingAnimation(@NotNull View view, int i4, int i5) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(v….ofFloat(\"scaleY\", 1.0f))");
        ofPropertyValuesHolder.setDuration(i5);
        ofPropertyValuesHolder.setStartDelay(i4);
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setRepeatMode(2);
        ofPropertyValuesHolder.start();
        return view;
    }
}
