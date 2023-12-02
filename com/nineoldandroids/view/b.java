package com.nineoldandroids.view;

import android.animation.Animator;
import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorICS.java */
/* loaded from: classes6.dex */
class b extends ViewPropertyAnimator {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<android.view.ViewPropertyAnimator> f36449b;

    /* compiled from: ViewPropertyAnimatorICS.java */
    /* loaded from: classes6.dex */
    class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Animator.AnimatorListener f36450a;

        a(Animator.AnimatorListener animatorListener) {
            this.f36450a = animatorListener;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.f36450a.onAnimationCancel(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.f36450a.onAnimationEnd(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
            this.f36450a.onAnimationRepeat(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            this.f36450a.onAnimationStart(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(View view) {
        this.f36449b = new WeakReference<>(view.animate());
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alpha(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alphaBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void cancel() {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getDuration() {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1L;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getStartDelay() {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1L;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotation(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationX(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationXBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationY(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationYBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleX(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleXBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleY(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleYBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setDuration(long j4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            if (animatorListener == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new a(animatorListener));
            }
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setStartDelay(long j4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void start() {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationX(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationXBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationY(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationYBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator x(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator xBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator y(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f4);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator yBy(float f4) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f36449b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f4);
        }
        return this;
    }
}
