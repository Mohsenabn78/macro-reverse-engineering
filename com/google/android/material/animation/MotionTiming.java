package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public class MotionTiming {

    /* renamed from: a  reason: collision with root package name */
    private long f22897a;

    /* renamed from: b  reason: collision with root package name */
    private long f22898b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f22899c;

    /* renamed from: d  reason: collision with root package name */
    private int f22900d;

    /* renamed from: e  reason: collision with root package name */
    private int f22901e;

    public MotionTiming(long j4, long j5) {
        this.f22899c = null;
        this.f22900d = 0;
        this.f22901e = 1;
        this.f22897a = j4;
        this.f22898b = j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static MotionTiming a(@NonNull ValueAnimator valueAnimator) {
        MotionTiming motionTiming = new MotionTiming(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        motionTiming.f22900d = valueAnimator.getRepeatCount();
        motionTiming.f22901e = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    private static TimeInterpolator b(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            }
            if (interpolator instanceof DecelerateInterpolator) {
                return AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            return interpolator;
        }
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public void apply(@NonNull Animator animator) {
        animator.setStartDelay(getDelay());
        animator.setDuration(getDuration());
        animator.setInterpolator(getInterpolator());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(getRepeatCount());
            valueAnimator.setRepeatMode(getRepeatMode());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (getDelay() != motionTiming.getDelay() || getDuration() != motionTiming.getDuration() || getRepeatCount() != motionTiming.getRepeatCount() || getRepeatMode() != motionTiming.getRepeatMode()) {
            return false;
        }
        return getInterpolator().getClass().equals(motionTiming.getInterpolator().getClass());
    }

    public long getDelay() {
        return this.f22897a;
    }

    public long getDuration() {
        return this.f22898b;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.f22899c;
        if (timeInterpolator == null) {
            return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        }
        return timeInterpolator;
    }

    public int getRepeatCount() {
        return this.f22900d;
    }

    public int getRepeatMode() {
        return this.f22901e;
    }

    public int hashCode() {
        return (((((((((int) (getDelay() ^ (getDelay() >>> 32))) * 31) + ((int) (getDuration() ^ (getDuration() >>> 32)))) * 31) + getInterpolator().getClass().hashCode()) * 31) + getRepeatCount()) * 31) + getRepeatMode();
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + getDelay() + " duration: " + getDuration() + " interpolator: " + getInterpolator().getClass() + " repeatCount: " + getRepeatCount() + " repeatMode: " + getRepeatMode() + "}\n";
    }

    public MotionTiming(long j4, long j5, @NonNull TimeInterpolator timeInterpolator) {
        this.f22900d = 0;
        this.f22901e = 1;
        this.f22897a = j4;
        this.f22898b = j5;
        this.f22899c = timeInterpolator;
    }
}
