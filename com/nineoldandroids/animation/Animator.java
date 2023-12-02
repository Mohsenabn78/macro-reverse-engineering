package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public abstract class Animator implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<AnimatorListener> f36291a = null;

    /* loaded from: classes6.dex */
    public interface AnimatorListener {
        void onAnimationCancel(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    public void addListener(AnimatorListener animatorListener) {
        if (this.f36291a == null) {
            this.f36291a = new ArrayList<>();
        }
        this.f36291a.add(animatorListener);
    }

    public abstract long getDuration();

    public ArrayList<AnimatorListener> getListeners() {
        return this.f36291a;
    }

    public abstract long getStartDelay();

    public abstract boolean isRunning();

    public boolean isStarted() {
        return isRunning();
    }

    public void removeAllListeners() {
        ArrayList<AnimatorListener> arrayList = this.f36291a;
        if (arrayList != null) {
            arrayList.clear();
            this.f36291a = null;
        }
    }

    public void removeListener(AnimatorListener animatorListener) {
        ArrayList<AnimatorListener> arrayList = this.f36291a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
        if (this.f36291a.size() == 0) {
            this.f36291a = null;
        }
    }

    public abstract Animator setDuration(long j4);

    public abstract void setInterpolator(Interpolator interpolator);

    public abstract void setStartDelay(long j4);

    @Override // 
    /* renamed from: clone */
    public Animator mo4175clone() {
        try {
            Animator animator = (Animator) super.clone();
            ArrayList<AnimatorListener> arrayList = this.f36291a;
            if (arrayList != null) {
                animator.f36291a = new ArrayList<>();
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    animator.f36291a.add(arrayList.get(i4));
                }
            }
            return animator;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public void cancel() {
    }

    public void end() {
    }

    public void setupEndValues() {
    }

    public void setupStartValues() {
    }

    public void start() {
    }

    public void setTarget(Object obj) {
    }
}
