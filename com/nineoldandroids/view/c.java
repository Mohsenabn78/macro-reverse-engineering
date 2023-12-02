package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.app.FrameMetricsAggregator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewPropertyAnimatorPreHC.java */
/* loaded from: classes6.dex */
public class c extends ViewPropertyAnimator {

    /* renamed from: b  reason: collision with root package name */
    private final AnimatorProxy f36452b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<View> f36453c;

    /* renamed from: d  reason: collision with root package name */
    private long f36454d;

    /* renamed from: h  reason: collision with root package name */
    private Interpolator f36458h;

    /* renamed from: e  reason: collision with root package name */
    private boolean f36455e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f36456f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f36457g = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f36459i = false;

    /* renamed from: j  reason: collision with root package name */
    private Animator.AnimatorListener f36460j = null;

    /* renamed from: k  reason: collision with root package name */
    private b f36461k = new b(this, null);

    /* renamed from: l  reason: collision with root package name */
    ArrayList<C0211c> f36462l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private Runnable f36463m = new a();

    /* renamed from: n  reason: collision with root package name */
    private HashMap<Animator, d> f36464n = new HashMap<>();

    /* compiled from: ViewPropertyAnimatorPreHC.java */
    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewPropertyAnimatorPreHC.java */
    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private b() {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (c.this.f36460j != null) {
                c.this.f36460j.onAnimationCancel(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (c.this.f36460j != null) {
                c.this.f36460j.onAnimationEnd(animator);
            }
            c.this.f36464n.remove(animator);
            if (c.this.f36464n.isEmpty()) {
                c.this.f36460j = null;
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (c.this.f36460j != null) {
                c.this.f36460j.onAnimationRepeat(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (c.this.f36460j != null) {
                c.this.f36460j.onAnimationStart(animator);
            }
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            d dVar = (d) c.this.f36464n.get(valueAnimator);
            if ((dVar.f36470a & FrameMetricsAggregator.EVERY_DURATION) != 0 && (view = (View) c.this.f36453c.get()) != null) {
                view.invalidate();
            }
            ArrayList<C0211c> arrayList = dVar.f36471b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    C0211c c0211c = arrayList.get(i4);
                    c.this.k(c0211c.f36467a, c0211c.f36468b + (c0211c.f36469c * animatedFraction));
                }
            }
            View view2 = (View) c.this.f36453c.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewPropertyAnimatorPreHC.java */
    /* renamed from: com.nineoldandroids.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0211c {

        /* renamed from: a  reason: collision with root package name */
        int f36467a;

        /* renamed from: b  reason: collision with root package name */
        float f36468b;

        /* renamed from: c  reason: collision with root package name */
        float f36469c;

        C0211c(int i4, float f4, float f5) {
            this.f36467a = i4;
            this.f36468b = f4;
            this.f36469c = f5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewPropertyAnimatorPreHC.java */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int f36470a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<C0211c> f36471b;

        d(int i4, ArrayList<C0211c> arrayList) {
            this.f36470a = i4;
            this.f36471b = arrayList;
        }

        boolean a(int i4) {
            ArrayList<C0211c> arrayList;
            if ((this.f36470a & i4) != 0 && (arrayList = this.f36471b) != null) {
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f36471b.get(i5).f36467a == i4) {
                        this.f36471b.remove(i5);
                        this.f36470a = (~i4) & this.f36470a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(View view) {
        this.f36453c = new WeakReference<>(view);
        this.f36452b = AnimatorProxy.wrap(view);
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
        if (this.f36464n.size() > 0) {
            Iterator<Animator> it = this.f36464n.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    animator = it.next();
                    d dVar = this.f36464n.get(animator);
                    if (dVar.a(i4) && dVar.f36470a == 0) {
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
        this.f36462l.add(new C0211c(i4, f4, f5));
        View view = this.f36453c.get();
        if (view != null) {
            view.removeCallbacks(this.f36463m);
            view.post(this.f36463m);
        }
    }

    private float j(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 != 8) {
                        if (i4 != 16) {
                            if (i4 != 32) {
                                if (i4 != 64) {
                                    if (i4 != 128) {
                                        if (i4 != 256) {
                                            if (i4 != 512) {
                                                return 0.0f;
                                            }
                                            return this.f36452b.getAlpha();
                                        }
                                        return this.f36452b.getY();
                                    }
                                    return this.f36452b.getX();
                                }
                                return this.f36452b.getRotationY();
                            }
                            return this.f36452b.getRotationX();
                        }
                        return this.f36452b.getRotation();
                    }
                    return this.f36452b.getScaleY();
                }
                return this.f36452b.getScaleX();
            }
            return this.f36452b.getTranslationY();
        }
        return this.f36452b.getTranslationX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i4, float f4) {
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
                                                this.f36452b.setAlpha(f4);
                                                return;
                                            }
                                            return;
                                        }
                                        this.f36452b.setY(f4);
                                        return;
                                    }
                                    this.f36452b.setX(f4);
                                    return;
                                }
                                this.f36452b.setRotationY(f4);
                                return;
                            }
                            this.f36452b.setRotationX(f4);
                            return;
                        }
                        this.f36452b.setRotation(f4);
                        return;
                    }
                    this.f36452b.setScaleY(f4);
                    return;
                }
                this.f36452b.setScaleX(f4);
                return;
            }
            this.f36452b.setTranslationY(f4);
            return;
        }
        this.f36452b.setTranslationX(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ArrayList arrayList = (ArrayList) this.f36462l.clone();
        this.f36462l.clear();
        int size = arrayList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 |= ((C0211c) arrayList.get(i5)).f36467a;
        }
        this.f36464n.put(ofFloat, new d(i4, arrayList));
        ofFloat.addUpdateListener(this.f36461k);
        ofFloat.addListener(this.f36461k);
        if (this.f36457g) {
            ofFloat.setStartDelay(this.f36456f);
        }
        if (this.f36455e) {
            ofFloat.setDuration(this.f36454d);
        }
        if (this.f36459i) {
            ofFloat.setInterpolator(this.f36458h);
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
        if (this.f36464n.size() > 0) {
            for (Animator animator : ((HashMap) this.f36464n.clone()).keySet()) {
                animator.cancel();
            }
        }
        this.f36462l.clear();
        View view = this.f36453c.get();
        if (view != null) {
            view.removeCallbacks(this.f36463m);
        }
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getDuration() {
        if (this.f36455e) {
            return this.f36454d;
        }
        return new ValueAnimator().getDuration();
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getStartDelay() {
        if (this.f36457g) {
            return this.f36456f;
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
            this.f36455e = true;
            this.f36454d = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        this.f36459i = true;
        this.f36458h = interpolator;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener) {
        this.f36460j = animatorListener;
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setStartDelay(long j4) {
        if (j4 >= 0) {
            this.f36457g = true;
            this.f36456f = j4;
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
