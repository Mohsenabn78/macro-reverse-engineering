package com.nineoldandroids.view;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
public abstract class ViewPropertyAnimator {

    /* renamed from: a  reason: collision with root package name */
    private static final WeakHashMap<View, ViewPropertyAnimator> f36412a = new WeakHashMap<>(0);

    public static ViewPropertyAnimator animate(View view) {
        WeakHashMap<View, ViewPropertyAnimator> weakHashMap = f36412a;
        ViewPropertyAnimator viewPropertyAnimator = weakHashMap.get(view);
        if (viewPropertyAnimator == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            if (intValue >= 14) {
                viewPropertyAnimator = new b(view);
            } else if (intValue >= 11) {
                viewPropertyAnimator = new a(view);
            } else {
                viewPropertyAnimator = new c(view);
            }
            weakHashMap.put(view, viewPropertyAnimator);
        }
        return viewPropertyAnimator;
    }

    public abstract ViewPropertyAnimator alpha(float f4);

    public abstract ViewPropertyAnimator alphaBy(float f4);

    public abstract void cancel();

    public abstract long getDuration();

    public abstract long getStartDelay();

    public abstract ViewPropertyAnimator rotation(float f4);

    public abstract ViewPropertyAnimator rotationBy(float f4);

    public abstract ViewPropertyAnimator rotationX(float f4);

    public abstract ViewPropertyAnimator rotationXBy(float f4);

    public abstract ViewPropertyAnimator rotationY(float f4);

    public abstract ViewPropertyAnimator rotationYBy(float f4);

    public abstract ViewPropertyAnimator scaleX(float f4);

    public abstract ViewPropertyAnimator scaleXBy(float f4);

    public abstract ViewPropertyAnimator scaleY(float f4);

    public abstract ViewPropertyAnimator scaleYBy(float f4);

    public abstract ViewPropertyAnimator setDuration(long j4);

    public abstract ViewPropertyAnimator setInterpolator(Interpolator interpolator);

    public abstract ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener);

    public abstract ViewPropertyAnimator setStartDelay(long j4);

    public abstract void start();

    public abstract ViewPropertyAnimator translationX(float f4);

    public abstract ViewPropertyAnimator translationXBy(float f4);

    public abstract ViewPropertyAnimator translationY(float f4);

    public abstract ViewPropertyAnimator translationYBy(float f4);

    public abstract ViewPropertyAnimator x(float f4);

    public abstract ViewPropertyAnimator xBy(float f4);

    public abstract ViewPropertyAnimator y(float f4);

    public abstract ViewPropertyAnimator yBy(float f4);
}
