package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.app.FrameMetricsAggregator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewPropertyAnimatorHC.java */
/* loaded from: classes6.dex */
public class a extends ViewPropertyAnimator {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<View> f36413b;

    /* renamed from: c  reason: collision with root package name */
    private long f36414c;

    /* renamed from: g  reason: collision with root package name */
    private Interpolator f36418g;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36415d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f36416e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f36417f = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f36419h = false;

    /* renamed from: i  reason: collision with root package name */
    private Animator.AnimatorListener f36420i = null;

    /* renamed from: j  reason: collision with root package name */
    private b f36421j = new b(this, null);

    /* renamed from: k  reason: collision with root package name */
    ArrayList<c> f36422k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private Runnable f36423l = new RunnableC0210a();

    /* renamed from: m  reason: collision with root package name */
    private HashMap<Animator, d> f36424m = new HashMap<>();

    /* compiled from: ViewPropertyAnimatorHC.java */
    /* renamed from: com.nineoldandroids.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC0210a implements Runnable {
        RunnableC0210a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewPropertyAnimatorHC.java */
    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private b() {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (a.this.f36420i != null) {
                a.this.f36420i.onAnimationCancel(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (a.this.f36420i != null) {
                a.this.f36420i.onAnimationEnd(animator);
            }
            a.this.f36424m.remove(animator);
            if (a.this.f36424m.isEmpty()) {
                a.this.f36420i = null;
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (a.this.f36420i != null) {
                a.this.f36420i.onAnimationRepeat(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (a.this.f36420i != null) {
                a.this.f36420i.onAnimationStart(animator);
            }
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            d dVar = (d) a.this.f36424m.get(valueAnimator);
            if ((dVar.f36430a & FrameMetricsAggregator.EVERY_DURATION) != 0 && (view = (View) a.this.f36413b.get()) != null) {
                view.invalidate();
            }
            ArrayList<c> arrayList = dVar.f36431b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    c cVar = arrayList.get(i4);
                    a.this.k(cVar.f36427a, cVar.f36428b + (cVar.f36429c * animatedFraction));
                }
            }
            View view2 = (View) a.this.f36413b.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        /* synthetic */ b(a aVar, RunnableC0210a runnableC0210a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewPropertyAnimatorHC.java */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        int f36427a;

        /* renamed from: b  reason: collision with root package name */
        float f36428b;

        /* renamed from: c  reason: collision with root package name */
        float f36429c;

        c(int i4, float f4, float f5) {
            this.f36427a = i4;
            this.f36428b = f4;
            this.f36429c = f5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewPropertyAnimatorHC.java */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int f36430a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<c> f36431b;

        d(int i4, ArrayList<c> arrayList) {
            this.f36430a = i4;
            this.f36431b = arrayList;
        }

        boolean a(int i4) {
            ArrayList<c> arrayList;
            if ((this.f36430a & i4) != 0 && (arrayList = this.f36431b) != null) {
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f36431b.get(i5).f36427a == i4) {
                        this.f36431b.remove(i5);
                        this.f36430a = (~i4) & this.f36430a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(View view) {
        this.f36413b = new WeakReference<>(view);
    }

    private void g(int i4, float f4) {
        float j4 = j(i4);
        i(i4, j4, f4 - j4);
    }

    private void h(int i4, float f4) {
        i(i4, j(i4), f4);
    }

    private void i(int i4, float f4, float f5) {
        Animator animator;
        if (this.f36424m.size() > 0) {
            Iterator<Animator> it = this.f36424m.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    animator = it.next();
                    d dVar = this.f36424m.get(animator);
                    if (dVar.a(i4) && dVar.f36430a == 0) {
                        break;
                    }
                } else {
                    animator = null;
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.f36422k.add(new c(i4, f4, f5));
        View view = this.f36413b.get();
        if (view != null) {
            view.removeCallbacks(this.f36423l);
            view.post(this.f36423l);
        }
    }

    private float j(int i4) {
        View view = this.f36413b.get();
        if (view != null) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 4) {
                        if (i4 != 8) {
                            if (i4 != 16) {
                                if (i4 != 32) {
                                    if (i4 != 64) {
                                        if (i4 != 128) {
                                            if (i4 != 256) {
                                                if (i4 == 512) {
                                                    return view.getAlpha();
                                                }
                                                return 0.0f;
                                            }
                                            return view.getY();
                                        }
                                        return view.getX();
                                    }
                                    return view.getRotationY();
                                }
                                return view.getRotationX();
                            }
                            return view.getRotation();
                        }
                        return view.getScaleY();
                    }
                    return view.getScaleX();
                }
                return view.getTranslationY();
            }
            return view.getTranslationX();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i4, float f4) {
        View view = this.f36413b.get();
        if (view != null) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 4) {
                        if (i4 != 8) {
                            if (i4 != 16) {
                                if (i4 != 32) {
                                    if (i4 != 64) {
                                        if (i4 != 128) {
                                            if (i4 != 256) {
                                                if (i4 == 512) {
                                                    view.setAlpha(f4);
                                                    return;
                                                }
                                                return;
                                            }
                                            view.setY(f4);
                                            return;
                                        }
                                        view.setX(f4);
                                        return;
                                    }
                                    view.setRotationY(f4);
                                    return;
                                }
                                view.setRotationX(f4);
                                return;
                            }
                            view.setRotation(f4);
                            return;
                        }
                        view.setScaleY(f4);
                        return;
                    }
                    view.setScaleX(f4);
                    return;
                }
                view.setTranslationY(f4);
                return;
            }
            view.setTranslationX(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ArrayList arrayList = (ArrayList) this.f36422k.clone();
        this.f36422k.clear();
        int size = arrayList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 |= ((c) arrayList.get(i5)).f36427a;
        }
        this.f36424m.put(ofFloat, new d(i4, arrayList));
        ofFloat.addUpdateListener(this.f36421j);
        ofFloat.addListener(this.f36421j);
        if (this.f36417f) {
            ofFloat.setStartDelay(this.f36416e);
        }
        if (this.f36415d) {
            ofFloat.setDuration(this.f36414c);
        }
        if (this.f36419h) {
            ofFloat.setInterpolator(this.f36418g);
        }
        ofFloat.start();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alpha(float f4) {
        g(512, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alphaBy(float f4) {
        h(512, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void cancel() {
        if (this.f36424m.size() > 0) {
            for (Animator animator : ((HashMap) this.f36424m.clone()).keySet()) {
                animator.cancel();
            }
        }
        this.f36422k.clear();
        View view = this.f36413b.get();
        if (view != null) {
            view.removeCallbacks(this.f36423l);
        }
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getDuration() {
        if (this.f36415d) {
            return this.f36414c;
        }
        return new ValueAnimator().getDuration();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getStartDelay() {
        if (this.f36417f) {
            return this.f36416e;
        }
        return 0L;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotation(float f4) {
        g(16, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationBy(float f4) {
        h(16, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationX(float f4) {
        g(32, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationXBy(float f4) {
        h(32, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationY(float f4) {
        g(64, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationYBy(float f4) {
        h(64, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleX(float f4) {
        g(4, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleXBy(float f4) {
        h(4, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleY(float f4) {
        g(8, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleYBy(float f4) {
        h(8, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setDuration(long j4) {
        if (j4 >= 0) {
            this.f36415d = true;
            this.f36414c = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        this.f36419h = true;
        this.f36418g = interpolator;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener) {
        this.f36420i = animatorListener;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setStartDelay(long j4) {
        if (j4 >= 0) {
            this.f36417f = true;
            this.f36416e = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void start() {
        l();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationX(float f4) {
        g(1, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationXBy(float f4) {
        h(1, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationY(float f4) {
        g(2, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationYBy(float f4) {
        h(2, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator x(float f4) {
        g(128, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator xBy(float f4) {
        h(128, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator y(float f4) {
        g(256, f4);
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator yBy(float f4) {
        h(256, f4);
        return this;
    }
}
