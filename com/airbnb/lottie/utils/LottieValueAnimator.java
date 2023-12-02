package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private LottieComposition f1862j;

    /* renamed from: c  reason: collision with root package name */
    private float f1855c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1856d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f1857e = 0;

    /* renamed from: f  reason: collision with root package name */
    private float f1858f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f1859g = 0;

    /* renamed from: h  reason: collision with root package name */
    private float f1860h = -2.14748365E9f;

    /* renamed from: i  reason: collision with root package name */
    private float f1861i = 2.14748365E9f;
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    protected boolean f1863k = false;

    private float f() {
        LottieComposition lottieComposition = this.f1862j;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.f1855c);
    }

    private boolean g() {
        if (getSpeed() < 0.0f) {
            return true;
        }
        return false;
    }

    private void k() {
        if (this.f1862j == null) {
            return;
        }
        float f4 = this.f1858f;
        if (f4 >= this.f1860h && f4 <= this.f1861i) {
            return;
        }
        throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f1860h), Float.valueOf(this.f1861i), Float.valueOf(this.f1858f)));
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        a();
        i();
    }

    public void clearComposition() {
        this.f1862j = null;
        this.f1860h = -2.14748365E9f;
        this.f1861i = 2.14748365E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j4) {
        float minFrame;
        float maxFrame;
        h();
        if (this.f1862j != null && isRunning()) {
            L.beginSection("LottieValueAnimator#doFrame");
            long j5 = this.f1857e;
            long j6 = 0;
            if (j5 != 0) {
                j6 = j4 - j5;
            }
            float f4 = ((float) j6) / f();
            float f5 = this.f1858f;
            if (g()) {
                f4 = -f4;
            }
            float f6 = f5 + f4;
            this.f1858f = f6;
            boolean z3 = !MiscUtils.contains(f6, getMinFrame(), getMaxFrame());
            this.f1858f = MiscUtils.clamp(this.f1858f, getMinFrame(), getMaxFrame());
            this.f1857e = j4;
            e();
            if (z3) {
                if (getRepeatCount() != -1 && this.f1859g >= getRepeatCount()) {
                    if (this.f1855c < 0.0f) {
                        maxFrame = getMinFrame();
                    } else {
                        maxFrame = getMaxFrame();
                    }
                    this.f1858f = maxFrame;
                    i();
                    b(g());
                } else {
                    c();
                    this.f1859g++;
                    if (getRepeatMode() == 2) {
                        this.f1856d = !this.f1856d;
                        reverseAnimationSpeed();
                    } else {
                        if (g()) {
                            minFrame = getMaxFrame();
                        } else {
                            minFrame = getMinFrame();
                        }
                        this.f1858f = minFrame;
                    }
                    this.f1857e = j4;
                }
            }
            k();
            L.endSection("LottieValueAnimator#doFrame");
        }
    }

    @MainThread
    public void endAnimation() {
        i();
        b(g());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.f1862j == null) {
            return 0.0f;
        }
        if (g()) {
            minFrame = getMaxFrame() - this.f1858f;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.f1858f - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.f1862j;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.f1858f - lottieComposition.getStartFrame()) / (this.f1862j.getEndFrame() - this.f1862j.getStartFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition lottieComposition = this.f1862j;
        if (lottieComposition == null) {
            return 0L;
        }
        return lottieComposition.getDuration();
    }

    public float getFrame() {
        return this.f1858f;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.f1862j;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f4 = this.f1861i;
        if (f4 == 2.14748365E9f) {
            return lottieComposition.getEndFrame();
        }
        return f4;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.f1862j;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f4 = this.f1860h;
        if (f4 == -2.14748365E9f) {
            return lottieComposition.getStartFrame();
        }
        return f4;
    }

    public float getSpeed() {
        return this.f1855c;
    }

    protected void h() {
        if (isRunning()) {
            j(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void i() {
        j(true);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f1863k;
    }

    @MainThread
    protected void j(boolean z3) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z3) {
            this.f1863k = false;
        }
    }

    @MainThread
    public void pauseAnimation() {
        i();
    }

    @MainThread
    public void playAnimation() {
        float minFrame;
        this.f1863k = true;
        d(g());
        if (g()) {
            minFrame = getMaxFrame();
        } else {
            minFrame = getMinFrame();
        }
        setFrame((int) minFrame);
        this.f1857e = 0L;
        this.f1859g = 0;
        h();
    }

    @MainThread
    public void resumeAnimation() {
        this.f1863k = true;
        h();
        this.f1857e = 0L;
        if (g() && getFrame() == getMinFrame()) {
            this.f1858f = getMaxFrame();
        } else if (!g() && getFrame() == getMaxFrame()) {
            this.f1858f = getMinFrame();
        }
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(LottieComposition lottieComposition) {
        boolean z3;
        if (this.f1862j == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f1862j = lottieComposition;
        if (z3) {
            setMinAndMaxFrames((int) Math.max(this.f1860h, lottieComposition.getStartFrame()), (int) Math.min(this.f1861i, lottieComposition.getEndFrame()));
        } else {
            setMinAndMaxFrames((int) lottieComposition.getStartFrame(), (int) lottieComposition.getEndFrame());
        }
        float f4 = this.f1858f;
        this.f1858f = 0.0f;
        setFrame((int) f4);
        e();
    }

    public void setFrame(float f4) {
        if (this.f1858f == f4) {
            return;
        }
        this.f1858f = MiscUtils.clamp(f4, getMinFrame(), getMaxFrame());
        this.f1857e = 0L;
        e();
    }

    public void setMaxFrame(float f4) {
        setMinAndMaxFrames(this.f1860h, f4);
    }

    public void setMinAndMaxFrames(float f4, float f5) {
        float startFrame;
        float endFrame;
        if (f4 <= f5) {
            LottieComposition lottieComposition = this.f1862j;
            if (lottieComposition == null) {
                startFrame = -3.4028235E38f;
            } else {
                startFrame = lottieComposition.getStartFrame();
            }
            LottieComposition lottieComposition2 = this.f1862j;
            if (lottieComposition2 == null) {
                endFrame = Float.MAX_VALUE;
            } else {
                endFrame = lottieComposition2.getEndFrame();
            }
            this.f1860h = MiscUtils.clamp(f4, startFrame, endFrame);
            this.f1861i = MiscUtils.clamp(f5, startFrame, endFrame);
            setFrame((int) MiscUtils.clamp(this.f1858f, f4, f5));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f4), Float.valueOf(f5)));
    }

    public void setMinFrame(int i4) {
        setMinAndMaxFrames(i4, (int) this.f1861i);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i4) {
        super.setRepeatMode(i4);
        if (i4 != 2 && this.f1856d) {
            this.f1856d = false;
            reverseAnimationSpeed();
        }
    }

    public void setSpeed(float f4) {
        this.f1855c = f4;
    }
}
