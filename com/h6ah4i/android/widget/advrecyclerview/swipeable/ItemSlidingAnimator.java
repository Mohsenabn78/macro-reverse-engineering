package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class ItemSlidingAnimator {
    public static final int DIR_DOWN = 3;
    public static final int DIR_LEFT = 0;
    public static final int DIR_RIGHT = 2;
    public static final int DIR_UP = 1;

    /* renamed from: a  reason: collision with root package name */
    private final e<RecyclerView.ViewHolder> f33900a;

    /* renamed from: i  reason: collision with root package name */
    private int f33908i;

    /* renamed from: b  reason: collision with root package name */
    private final Interpolator f33901b = new AccelerateDecelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private final Interpolator f33902c = new DecelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    private final Interpolator f33903d = new AccelerateInterpolator(0.8f);

    /* renamed from: g  reason: collision with root package name */
    private final int[] f33906g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    private final Rect f33907h = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final List<RecyclerView.ViewHolder> f33904e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<WeakReference<d>> f33905f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends d {

        /* renamed from: b  reason: collision with root package name */
        final float f33909b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f33910c;

        public a(RecyclerView.ViewHolder viewHolder, float f4, boolean z3) {
            super(viewHolder);
            this.f33909b = f4;
            this.f33910c = z3;
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.ItemSlidingAnimator.d
        protected void c(RecyclerView.ViewHolder viewHolder) {
            View a4 = f.a(viewHolder);
            if (this.f33910c) {
                ItemSlidingAnimator.f(viewHolder, true, (int) ((a4.getWidth() * this.f33909b) + 0.5f), 0);
            } else {
                ItemSlidingAnimator.f(viewHolder, false, 0, (int) ((a4.getHeight() * this.f33909b) + 0.5f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final int f33922a;

        /* renamed from: b  reason: collision with root package name */
        SwipeResultAction f33923b;

        public c(int i4, SwipeResultAction swipeResultAction) {
            this.f33922a = i4;
            this.f33923b = swipeResultAction;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static abstract class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<RecyclerView.ViewHolder> f33924a;

        public d(RecyclerView.ViewHolder viewHolder) {
            this.f33924a = new WeakReference<>(viewHolder);
        }

        public boolean a(RecyclerView.ViewHolder viewHolder) {
            if (this.f33924a.get() == viewHolder) {
                return true;
            }
            return false;
        }

        public boolean b(RecyclerView.ViewHolder viewHolder) {
            if (this.f33924a.get() == null) {
                return true;
            }
            return false;
        }

        protected abstract void c(RecyclerView.ViewHolder viewHolder);

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView.ViewHolder viewHolder = this.f33924a.get();
            if (viewHolder != null) {
                c(viewHolder);
            }
        }
    }

    public ItemSlidingAnimator(e<RecyclerView.ViewHolder> eVar) {
        this.f33900a = eVar;
    }

    private boolean a(RecyclerView.ViewHolder viewHolder, boolean z3, int i4, int i5, long j4, Interpolator interpolator, c cVar) {
        if (!(viewHolder instanceof SwipeableItemViewHolder)) {
            return false;
        }
        View a4 = f.a(viewHolder);
        int translationX = (int) (a4.getTranslationX() + 0.5f);
        int translationY = (int) (a4.getTranslationY() + 0.5f);
        endAnimation(viewHolder);
        int translationX2 = (int) (a4.getTranslationX() + 0.5f);
        int translationY2 = (int) (a4.getTranslationY() + 0.5f);
        if (j4 != 0 && ((translationX2 != i4 || translationY2 != i5) && Math.max(Math.abs(i4 - translationX), Math.abs(i5 - translationY)) > this.f33908i)) {
            a4.setTranslationX(translationX);
            a4.setTranslationY(translationY);
            new b(this.f33900a, this.f33904e, viewHolder, i4, i5, j4, z3, interpolator, cVar).a();
            return true;
        }
        a4.setTranslationX(i4);
        a4.setTranslationY(i5);
        return false;
    }

    private boolean b(RecyclerView.ViewHolder viewHolder, boolean z3, int i4, int i5, long j4, Interpolator interpolator, c cVar) {
        return a(viewHolder, z3, i4, i5, j4, interpolator, cVar);
    }

    private void c(RecyclerView.ViewHolder viewHolder) {
        for (int size = this.f33905f.size() - 1; size >= 0; size--) {
            d dVar = this.f33905f.get(size).get();
            if (dVar != null && dVar.a(viewHolder)) {
                viewHolder.itemView.removeCallbacks(dVar);
                this.f33905f.remove(size);
            } else if (dVar == null || dVar.b(viewHolder)) {
                this.f33905f.remove(size);
            }
        }
    }

    private void d(RecyclerView.ViewHolder viewHolder, d dVar) {
        this.f33905f.add(new WeakReference<>(dVar));
        viewHolder.itemView.post(dVar);
    }

    private static void e(RecyclerView.ViewHolder viewHolder, boolean z3, int i4, int i5) {
        if (!(viewHolder instanceof SwipeableItemViewHolder)) {
            return;
        }
        View a4 = f.a(viewHolder);
        ViewCompat.animate(a4).cancel();
        a4.setTranslationX(i4);
        a4.setTranslationY(i5);
    }

    static void f(RecyclerView.ViewHolder viewHolder, boolean z3, int i4, int i5) {
        e(viewHolder, z3, i4, i5);
    }

    private boolean g(RecyclerView.ViewHolder viewHolder, int i4, boolean z3, long j4, c cVar) {
        boolean z4;
        long j5;
        boolean z5;
        if (!(viewHolder instanceof SwipeableItemViewHolder)) {
            return false;
        }
        View a4 = f.a(viewHolder);
        ViewGroup viewGroup = (ViewGroup) a4.getParent();
        if (viewGroup == null) {
            return false;
        }
        int left = a4.getLeft();
        int right = a4.getRight();
        int top = a4.getTop();
        int i5 = right - left;
        int bottom = a4.getBottom() - top;
        viewGroup.getWindowVisibleDisplayFrame(this.f33907h);
        int width = this.f33907h.width();
        int height = this.f33907h.height();
        if (i5 != 0 && bottom != 0) {
            viewGroup.getLocationInWindow(this.f33906g);
            int[] iArr = this.f33906g;
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            z4 = z3;
                            width = 0;
                        } else {
                            height -= i7 - top;
                            z4 = z3;
                            width = 0;
                        }
                    } else {
                        width -= i6 - left;
                        z4 = z3;
                    }
                    height = 0;
                } else {
                    height = -(i7 + bottom);
                    width = 0;
                }
            } else {
                width = -(i6 + i5);
                height = 0;
            }
            z4 = z3;
        } else {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            width = 0;
                        }
                    }
                } else {
                    height = -height;
                }
                width = 0;
                z4 = false;
            } else {
                width = -width;
            }
            height = 0;
            z4 = false;
        }
        if (z4) {
            if (ViewCompat.isAttachedToWindow(a4) && a4.getVisibility() == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        if (z4) {
            j5 = j4;
        } else {
            j5 = 0;
        }
        if (i4 != 0 && i4 != 2) {
            z5 = false;
        } else {
            z5 = true;
        }
        return b(viewHolder, z5, width, height, j5, this.f33903d, cVar);
    }

    private boolean h(RecyclerView.ViewHolder viewHolder, float f4, boolean z3, boolean z4, boolean z5, Interpolator interpolator, long j4, c cVar) {
        boolean z6;
        long j5;
        float f5 = f4;
        View a4 = f.a(viewHolder);
        if (z5) {
            if (ViewCompat.isAttachedToWindow(a4) && a4.getVisibility() == 0) {
                z6 = true;
            } else {
                z6 = false;
            }
        } else {
            z6 = z5;
        }
        if (z6) {
            j5 = j4;
        } else {
            j5 = 0;
        }
        if (f5 != 0.0f) {
            int width = a4.getWidth();
            int height = a4.getHeight();
            if (z4 && (!z3 || width != 0)) {
                if (z3) {
                    f5 *= width;
                }
                return b(viewHolder, true, (int) (f5 + 0.5f), 0, j5, interpolator, cVar);
            } else if (!z4 && (!z3 || height != 0)) {
                if (z3) {
                    f5 *= height;
                }
                return b(viewHolder, false, 0, (int) (f5 + 0.5f), j5, interpolator, cVar);
            } else if (cVar == null) {
                d(viewHolder, new a(viewHolder, f4, z4));
                return false;
            } else {
                throw new IllegalStateException("Unexpected state in slideToSpecifiedPositionInternal (swipeFinish == null)");
            }
        }
        return b(viewHolder, z4, 0, 0, j5, interpolator, cVar);
    }

    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        if (!(viewHolder instanceof SwipeableItemViewHolder)) {
            return;
        }
        c(viewHolder);
        ViewCompat.animate(f.a(viewHolder)).cancel();
        if (!this.f33904e.remove(viewHolder)) {
            return;
        }
        throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [slide]");
    }

    public void endAnimations() {
        for (int size = this.f33904e.size() - 1; size >= 0; size--) {
            endAnimation(this.f33904e.get(size));
        }
    }

    public boolean finishSwipeSlideToDefaultPosition(RecyclerView.ViewHolder viewHolder, boolean z3, boolean z4, long j4, int i4, SwipeResultAction swipeResultAction) {
        c(viewHolder);
        return h(viewHolder, 0.0f, false, z3, z4, this.f33901b, j4, new c(i4, swipeResultAction));
    }

    public boolean finishSwipeSlideToOutsideOfWindow(RecyclerView.ViewHolder viewHolder, int i4, boolean z3, long j4, int i5, SwipeResultAction swipeResultAction) {
        c(viewHolder);
        return g(viewHolder, i4, z3, j4, new c(i5, swipeResultAction));
    }

    public int getImmediatelySetTranslationThreshold() {
        return this.f33908i;
    }

    public int getSwipeContainerViewTranslationX(RecyclerView.ViewHolder viewHolder) {
        return (int) (f.a(viewHolder).getTranslationX() + 0.5f);
    }

    public int getSwipeContainerViewTranslationY(RecyclerView.ViewHolder viewHolder) {
        return (int) (f.a(viewHolder).getTranslationY() + 0.5f);
    }

    public boolean isRunning(RecyclerView.ViewHolder viewHolder) {
        return this.f33904e.contains(viewHolder);
    }

    public void setImmediatelySetTranslationThreshold(int i4) {
        this.f33908i = i4;
    }

    public void slideToDefaultPosition(RecyclerView.ViewHolder viewHolder, boolean z3, boolean z4, long j4) {
        c(viewHolder);
        h(viewHolder, 0.0f, false, z3, z4, this.f33901b, j4, null);
    }

    public void slideToOutsideOfWindow(RecyclerView.ViewHolder viewHolder, int i4, boolean z3, long j4) {
        c(viewHolder);
        g(viewHolder, i4, z3, j4, null);
    }

    public void slideToSpecifiedPosition(RecyclerView.ViewHolder viewHolder, float f4, boolean z3, boolean z4, boolean z5, long j4) {
        c(viewHolder);
        h(viewHolder, f4, z3, z4, z5, this.f33902c, j4, null);
    }

    public boolean isRunning() {
        return !this.f33904e.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements ViewPropertyAnimatorListener, ViewPropertyAnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private e<RecyclerView.ViewHolder> f33911a;

        /* renamed from: b  reason: collision with root package name */
        private List<RecyclerView.ViewHolder> f33912b;

        /* renamed from: c  reason: collision with root package name */
        private RecyclerView.ViewHolder f33913c;

        /* renamed from: d  reason: collision with root package name */
        private ViewPropertyAnimatorCompat f33914d;

        /* renamed from: e  reason: collision with root package name */
        private final int f33915e;

        /* renamed from: f  reason: collision with root package name */
        private final int f33916f;

        /* renamed from: g  reason: collision with root package name */
        private final long f33917g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f33918h;

        /* renamed from: i  reason: collision with root package name */
        private final c f33919i;

        /* renamed from: j  reason: collision with root package name */
        private final Interpolator f33920j;

        /* renamed from: k  reason: collision with root package name */
        private float f33921k;

        b(e<RecyclerView.ViewHolder> eVar, List<RecyclerView.ViewHolder> list, RecyclerView.ViewHolder viewHolder, int i4, int i5, long j4, boolean z3, Interpolator interpolator, c cVar) {
            this.f33911a = eVar;
            this.f33912b = list;
            this.f33913c = viewHolder;
            this.f33915e = i4;
            this.f33916f = i5;
            this.f33918h = z3;
            this.f33919i = cVar;
            this.f33917g = j4;
            this.f33920j = interpolator;
        }

        void a() {
            int height;
            View a4 = f.a(this.f33913c);
            if (this.f33918h) {
                height = a4.getWidth();
            } else {
                height = a4.getHeight();
            }
            this.f33921k = 1.0f / Math.max(1.0f, height);
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(a4);
            this.f33914d = animate;
            animate.setDuration(this.f33917g);
            this.f33914d.translationX(this.f33915e);
            this.f33914d.translationY(this.f33916f);
            Interpolator interpolator = this.f33920j;
            if (interpolator != null) {
                this.f33914d.setInterpolator(interpolator);
            }
            this.f33914d.setListener(this);
            this.f33914d.setUpdateListener(this);
            this.f33912b.add(this.f33913c);
            this.f33914d.start();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            this.f33914d.setListener(null);
            com.h6ah4i.android.widget.advrecyclerview.swipeable.a.a(view);
            view.setTranslationX(this.f33915e);
            view.setTranslationY(this.f33916f);
            this.f33912b.remove(this.f33913c);
            ViewParent parent = this.f33913c.itemView.getParent();
            if (parent != null) {
                ViewCompat.postInvalidateOnAnimation((View) parent);
            }
            c cVar = this.f33919i;
            if (cVar != null) {
                cVar.f33923b.slideAnimationEnd();
            }
            this.f33912b = null;
            this.f33914d = null;
            this.f33913c = null;
            this.f33911a = null;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            float translationY;
            if (this.f33918h) {
                translationY = view.getTranslationX();
            } else {
                translationY = view.getTranslationY();
            }
            e<RecyclerView.ViewHolder> eVar = this.f33911a;
            RecyclerView.ViewHolder viewHolder = this.f33913c;
            eVar.q(viewHolder, viewHolder.getLayoutPosition(), translationY * this.f33921k, true, this.f33918h, false);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
        }
    }
}
