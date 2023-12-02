package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Runnable f22981d;

    /* renamed from: e  reason: collision with root package name */
    OverScroller f22982e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22983f;

    /* renamed from: g  reason: collision with root package name */
    private int f22984g;

    /* renamed from: h  reason: collision with root package name */
    private int f22985h;

    /* renamed from: i  reason: collision with root package name */
    private int f22986i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f22987j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final CoordinatorLayout f22988a;

        /* renamed from: b  reason: collision with root package name */
        private final V f22989b;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v3) {
            this.f22988a = coordinatorLayout;
            this.f22989b = v3;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f22989b != null && (overScroller = HeaderBehavior.this.f22982e) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.j(this.f22988a, this.f22989b, headerBehavior.f22982e.getCurrY());
                    ViewCompat.postOnAnimation(this.f22989b, this);
                    return;
                }
                HeaderBehavior.this.h(this.f22988a, this.f22989b);
            }
        }
    }

    public HeaderBehavior() {
        this.f22984g = -1;
        this.f22986i = -1;
    }

    private void c() {
        if (this.f22987j == null) {
            this.f22987j = VelocityTracker.obtain();
        }
    }

    boolean b(V v3) {
        return false;
    }

    final boolean d(CoordinatorLayout coordinatorLayout, @NonNull V v3, int i4, int i5, float f4) {
        Runnable runnable = this.f22981d;
        if (runnable != null) {
            v3.removeCallbacks(runnable);
            this.f22981d = null;
        }
        if (this.f22982e == null) {
            this.f22982e = new OverScroller(v3.getContext());
        }
        this.f22982e.fling(0, getTopAndBottomOffset(), 0, Math.round(f4), 0, 0, i4, i5);
        if (this.f22982e.computeScrollOffset()) {
            FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v3);
            this.f22981d = flingRunnable;
            ViewCompat.postOnAnimation(v3, flingRunnable);
            return true;
        }
        h(coordinatorLayout, v3);
        return false;
    }

    int e(@NonNull V v3) {
        return -v3.getHeight();
    }

    int f(@NonNull V v3) {
        return v3.getHeight();
    }

    int g() {
        return getTopAndBottomOffset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int i(CoordinatorLayout coordinatorLayout, V v3, int i4, int i5, int i6) {
        return k(coordinatorLayout, v3, g() - i4, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(CoordinatorLayout coordinatorLayout, V v3, int i4) {
        return k(coordinatorLayout, v3, i4, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int k(CoordinatorLayout coordinatorLayout, V v3, int i4, int i5, int i6) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i5 != 0 && topAndBottomOffset >= i5 && topAndBottomOffset <= i6 && topAndBottomOffset != (clamp = MathUtils.clamp(i4, i5, i6))) {
            setTopAndBottomOffset(clamp);
            return topAndBottomOffset - clamp;
        }
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v3, @NonNull MotionEvent motionEvent) {
        boolean z3;
        int findPointerIndex;
        if (this.f22986i < 0) {
            this.f22986i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f22983f) {
            int i4 = this.f22984g;
            if (i4 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i4)) == -1) {
                return false;
            }
            int y3 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y3 - this.f22985h) > this.f22986i) {
                this.f22985h = y3;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f22984g = -1;
            int x3 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            if (b(v3) && coordinatorLayout.isPointInChildBounds(v3, x3, y4)) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f22983f = z3;
            if (z3) {
                this.f22985h = y4;
                this.f22984g = motionEvent.getPointerId(0);
                c();
                OverScroller overScroller = this.f22982e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f22982e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f22987j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f22984g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f22985h = r12
            goto L4c
        L2d:
            int r0 = r11.f22984g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f22985h
            int r7 = r1 - r0
            r11.f22985h = r0
            int r8 = r11.e(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.i(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f22987j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f22987j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f22987j
            int r4 = r11.f22984g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.f(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.d(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f22983f = r3
            r11.f22984g = r1
            android.view.VelocityTracker r13 = r11.f22987j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f22987j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f22987j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f22983f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22984g = -1;
        this.f22986i = -1;
    }

    void h(CoordinatorLayout coordinatorLayout, V v3) {
    }
}
