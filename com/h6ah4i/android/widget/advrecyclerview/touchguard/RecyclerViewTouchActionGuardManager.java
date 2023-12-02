package com.h6ah4i.android.widget.advrecyclerview.touchguard;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class RecyclerViewTouchActionGuardManager {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView.OnItemTouchListener f33994a = new a();

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f33995b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33996c;

    /* renamed from: d  reason: collision with root package name */
    private int f33997d;

    /* renamed from: e  reason: collision with root package name */
    private int f33998e;

    /* renamed from: f  reason: collision with root package name */
    private int f33999f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f34000g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f34001h;

    private void a(MotionEvent motionEvent) {
        int y3 = (int) (motionEvent.getY() + 0.5f);
        this.f33998e = y3;
        this.f33997d = y3;
        this.f33996c = false;
    }

    private boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.f33996c) {
            int y3 = (int) (motionEvent.getY() + 0.5f);
            this.f33998e = y3;
            int i4 = y3 - this.f33997d;
            if (this.f34001h && Math.abs(i4) > this.f33999f && recyclerView.isAnimating()) {
                this.f33996c = true;
            }
        }
        return this.f33996c;
    }

    private void c() {
        this.f33996c = false;
        this.f33997d = 0;
        this.f33998e = 0;
    }

    public void attachRecyclerView(@NonNull RecyclerView recyclerView) {
        if (!isReleased()) {
            if (this.f33995b == null) {
                this.f33995b = recyclerView;
                recyclerView.addOnItemTouchListener(this.f33994a);
                this.f33999f = ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop();
                return;
            }
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
        throw new IllegalStateException("Accessing released object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0013, code lost:
        if (r0 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean d(androidx.recyclerview.widget.RecyclerView r5, android.view.MotionEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.f34000g
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r6.getActionMasked()
            if (r0 == 0) goto L21
            r2 = 1
            if (r0 == r2) goto L1d
            r3 = 2
            if (r0 == r3) goto L16
            r5 = 3
            if (r0 == r5) goto L1d
            goto L24
        L16:
            boolean r5 = r4.b(r5, r6)
            if (r5 == 0) goto L24
            return r2
        L1d:
            r4.c()
            goto L24
        L21:
            r4.a(r6)
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.touchguard.RecyclerViewTouchActionGuardManager.d(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
    }

    void e(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.f34000g) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            c();
        }
    }

    public boolean isEnabled() {
        return this.f34000g;
    }

    public boolean isInterceptScrollingWhileAnimationRunning() {
        return this.f34001h;
    }

    public boolean isReleased() {
        if (this.f33994a == null) {
            return true;
        }
        return false;
    }

    public void release() {
        RecyclerView.OnItemTouchListener onItemTouchListener;
        RecyclerView recyclerView = this.f33995b;
        if (recyclerView != null && (onItemTouchListener = this.f33994a) != null) {
            recyclerView.removeOnItemTouchListener(onItemTouchListener);
        }
        this.f33994a = null;
        this.f33995b = null;
    }

    public void setEnabled(boolean z3) {
        if (this.f34000g == z3) {
            return;
        }
        this.f34000g = z3;
        if (!z3) {
            c();
        }
    }

    public void setInterceptVerticalScrollingWhileAnimationRunning(boolean z3) {
        this.f34001h = z3;
    }

    /* loaded from: classes6.dex */
    class a implements RecyclerView.OnItemTouchListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return RecyclerViewTouchActionGuardManager.this.d(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            RecyclerViewTouchActionGuardManager.this.e(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z3) {
        }
    }
}
