package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;

/* loaded from: classes6.dex */
public class RecyclerViewSwipeManager implements SwipeableItemConstants {
    private OnItemSwipeEventListener A;
    private b B;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f33926b;

    /* renamed from: f  reason: collision with root package name */
    private int f33930f;

    /* renamed from: g  reason: collision with root package name */
    private int f33931g;

    /* renamed from: h  reason: collision with root package name */
    private int f33932h;

    /* renamed from: i  reason: collision with root package name */
    private int f33933i;

    /* renamed from: j  reason: collision with root package name */
    private int f33934j;

    /* renamed from: k  reason: collision with root package name */
    private int f33935k;

    /* renamed from: m  reason: collision with root package name */
    private boolean f33937m;

    /* renamed from: n  reason: collision with root package name */
    private ItemSlidingAnimator f33938n;

    /* renamed from: o  reason: collision with root package name */
    private e<RecyclerView.ViewHolder> f33939o;

    /* renamed from: p  reason: collision with root package name */
    private RecyclerView.ViewHolder f33940p;

    /* renamed from: t  reason: collision with root package name */
    private int f33944t;

    /* renamed from: u  reason: collision with root package name */
    private int f33945u;

    /* renamed from: v  reason: collision with root package name */
    private int f33946v;

    /* renamed from: w  reason: collision with root package name */
    private int f33947w;

    /* renamed from: x  reason: collision with root package name */
    private int f33948x;

    /* renamed from: z  reason: collision with root package name */
    private g f33950z;

    /* renamed from: c  reason: collision with root package name */
    private long f33927c = 300;

    /* renamed from: d  reason: collision with root package name */
    private long f33928d = 200;

    /* renamed from: e  reason: collision with root package name */
    private long f33929e = 200;

    /* renamed from: l  reason: collision with root package name */
    private long f33936l = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f33941q = -1;

    /* renamed from: r  reason: collision with root package name */
    private long f33942r = -1;

    /* renamed from: s  reason: collision with root package name */
    private final Rect f33943s = new Rect();

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView.OnItemTouchListener f33925a = new a();

    /* renamed from: y  reason: collision with root package name */
    private VelocityTracker f33949y = VelocityTracker.obtain();
    private int C = ViewConfiguration.getLongPressTimeout();

    /* loaded from: classes6.dex */
    public interface OnItemSwipeEventListener {
        void onItemSwipeFinished(int i4, int i5, int i6);

        void onItemSwipeStarted(int i4);
    }

    /* loaded from: classes6.dex */
    class a implements RecyclerView.OnItemTouchListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return RecyclerViewSwipeManager.this.v(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z3) {
            RecyclerViewSwipeManager.this.w(z3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            RecyclerViewSwipeManager.this.x(recyclerView, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private RecyclerViewSwipeManager f33952a;

        /* renamed from: b  reason: collision with root package name */
        private MotionEvent f33953b;

        public b(RecyclerViewSwipeManager recyclerViewSwipeManager) {
            this.f33952a = recyclerViewSwipeManager;
        }

        public void a() {
            removeMessages(1);
            MotionEvent motionEvent = this.f33953b;
            if (motionEvent != null) {
                motionEvent.recycle();
                this.f33953b = null;
            }
        }

        public boolean b() {
            return hasMessages(2);
        }

        public void c() {
            removeCallbacksAndMessages(null);
            this.f33952a = null;
        }

        public void d() {
            removeMessages(2);
        }

        public void e() {
            if (b()) {
                return;
            }
            sendEmptyMessage(2);
        }

        public void f(MotionEvent motionEvent, int i4) {
            a();
            this.f33953b = MotionEvent.obtain(motionEvent);
            sendEmptyMessageAtTime(1, motionEvent.getDownTime() + i4);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 != 1) {
                if (i4 == 2) {
                    this.f33952a.d(true);
                    return;
                }
                return;
            }
            this.f33952a.s(this.f33953b);
        }
    }

    private void A(MotionEvent motionEvent, RecyclerView.ViewHolder viewHolder, int i4) {
        this.B.a();
        this.f33940p = viewHolder;
        this.f33941q = i4;
        this.f33942r = this.f33939o.getItemId(i4);
        this.f33946v = (int) (motionEvent.getX() + 0.5f);
        int y3 = (int) (motionEvent.getY() + 0.5f);
        this.f33947w = y3;
        this.f33944t = this.f33946v;
        this.f33945u = y3;
        this.f33936l = -1L;
        CustomRecyclerViewUtils.getLayoutMargins(viewHolder.itemView, this.f33943s);
        g gVar = new g(this, this.f33940p, this.f33948x, this.f33937m);
        this.f33950z = gVar;
        gVar.d();
        this.f33949y.clear();
        this.f33949y.addMovement(motionEvent);
        this.f33926b.getParent().requestDisallowInterceptTouchEvent(true);
        OnItemSwipeEventListener onItemSwipeEventListener = this.A;
        if (onItemSwipeEventListener != null) {
            onItemSwipeEventListener.onItemSwipeStarted(i4);
        }
        this.f33939o.p(this, viewHolder, i4, this.f33942r);
    }

    private static void E(int i4, int i5) {
        if ((i5 == 2 || i5 == 1) && i4 != 2 && i4 != 3 && i4 != 4 && i4 != 5) {
            throw new IllegalStateException("Unexpected after reaction has been requested: result = " + i4 + ", afterReaction = " + i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(SwipeableItemViewHolder swipeableItemViewHolder, boolean z3, float f4, boolean z4, boolean z5) {
        int height;
        if (z4 ^ z5) {
            float f5 = 0.0f;
            if (f4 != 0.0f && !u(f4)) {
                View b4 = f.b(swipeableItemViewHolder);
                if (z3) {
                    height = b4.getWidth();
                } else {
                    height = b4.getHeight();
                }
                float f6 = height;
                if (z5) {
                    if (f6 != 0.0f) {
                        f5 = 1.0f / f6;
                    }
                    f6 = f5;
                }
                return f4 * f6;
            }
            return f4;
        }
        return f4;
    }

    private boolean e(MotionEvent motionEvent, RecyclerView.ViewHolder viewHolder) {
        int l4 = l(viewHolder);
        if (l4 == -1) {
            return false;
        }
        A(motionEvent, viewHolder, l4);
        return true;
    }

    private static int f(float f4, boolean z3) {
        if (z3) {
            if (f4 < 0.0f) {
                return 1;
            }
            return 3;
        } else if (f4 < 0.0f) {
            return 2;
        } else {
            return 4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(int r18) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager.g(int):void");
    }

    static int h(@Nullable RecyclerView.Adapter adapter, long j4, int i4) {
        if (adapter == null) {
            return -1;
        }
        int itemCount = adapter.getItemCount();
        if (i4 >= 0 && i4 < itemCount && adapter.getItemId(i4) == j4) {
            return i4;
        }
        for (int i5 = 0; i5 < itemCount; i5++) {
            if (adapter.getItemId(i5) == j4) {
                return i5;
            }
        }
        return -1;
    }

    private int l(RecyclerView.ViewHolder viewHolder) {
        return WrapperAdapterUtils.unwrapPosition(this.f33926b.getAdapter(), this.f33939o, CustomRecyclerViewUtils.getSynchronizedPosition(viewHolder));
    }

    private boolean m(RecyclerView recyclerView, MotionEvent motionEvent) {
        int l4;
        RecyclerView.ViewHolder findChildViewHolderUnderWithTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithTranslation(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (!(findChildViewHolderUnderWithTranslation instanceof SwipeableItemViewHolder) || (l4 = l(findChildViewHolderUnderWithTranslation)) < 0 || l4 >= this.f33939o.getItemCount()) {
            return false;
        }
        if (ItemIdComposer.extractWrappedIdPart(findChildViewHolderUnderWithTranslation.getItemId()) != ItemIdComposer.extractWrappedIdPart(this.f33939o.getItemId(l4))) {
            return false;
        }
        int x3 = (int) (motionEvent.getX() + 0.5f);
        int y3 = (int) (motionEvent.getY() + 0.5f);
        View view = findChildViewHolderUnderWithTranslation.itemView;
        int translationY = (int) (view.getTranslationY() + 0.5f);
        int left = view.getLeft();
        int l5 = this.f33939o.l(findChildViewHolderUnderWithTranslation, l4, x3 - (left + ((int) (view.getTranslationX() + 0.5f))), y3 - (view.getTop() + translationY));
        if (l5 == 0) {
            return false;
        }
        this.f33934j = x3;
        this.f33935k = y3;
        this.f33936l = findChildViewHolderUnderWithTranslation.getItemId();
        this.f33948x = l5;
        if ((16777216 & l5) != 0) {
            this.B.f(motionEvent, this.C);
            return true;
        }
        return true;
    }

    private boolean n(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f33936l == -1) {
            return false;
        }
        int x3 = ((int) (motionEvent.getX() + 0.5f)) - this.f33934j;
        int y3 = ((int) (motionEvent.getY() + 0.5f)) - this.f33935k;
        if (this.f33937m) {
            y3 = x3;
            x3 = y3;
        }
        if (Math.abs(x3) > this.f33930f) {
            this.f33936l = -1L;
            return false;
        } else if (Math.abs(y3) <= this.f33930f) {
            return false;
        } else {
            boolean z3 = true;
            if (!this.f33937m ? y3 >= 0 ? (this.f33948x & 2097152) == 0 : (this.f33948x & 512) == 0 : y3 >= 0 ? (this.f33948x & 32768) == 0 : (this.f33948x & 8) == 0) {
                z3 = false;
            }
            if (z3) {
                this.f33936l = -1L;
                return false;
            }
            RecyclerView.ViewHolder findChildViewHolderUnderWithTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithTranslation(recyclerView, motionEvent.getX(), motionEvent.getY());
            if (findChildViewHolderUnderWithTranslation != null && findChildViewHolderUnderWithTranslation.getItemId() == this.f33936l) {
                return e(motionEvent, findChildViewHolderUnderWithTranslation);
            }
            this.f33936l = -1L;
            return false;
        }
    }

    private void o(MotionEvent motionEvent) {
        this.f33946v = (int) (motionEvent.getX() + 0.5f);
        this.f33947w = (int) (motionEvent.getY() + 0.5f);
        this.f33949y.addMovement(motionEvent);
        int i4 = this.f33946v - this.f33944t;
        int i5 = this.f33947w - this.f33945u;
        this.f33950z.e(k(), i4, i5);
    }

    private boolean p(MotionEvent motionEvent, boolean z3) {
        int i4;
        if (motionEvent != null) {
            i4 = motionEvent.getActionMasked();
            this.f33946v = (int) (motionEvent.getX() + 0.5f);
            this.f33947w = (int) (motionEvent.getY() + 0.5f);
        } else {
            i4 = 3;
        }
        if (isSwiping()) {
            if (z3) {
                r(i4);
                return true;
            }
            return true;
        }
        q();
        return false;
    }

    private void q() {
        b bVar = this.B;
        if (bVar != null) {
            bVar.a();
        }
        this.f33936l = -1L;
        this.f33948x = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r(int r13) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager.r(int):void");
    }

    private static boolean u(float f4) {
        if (f4 != -65536.0f && f4 != 65536.0f && f4 != -65537.0f && f4 != 65537.0f) {
            return false;
        }
        return true;
    }

    private static int y(int i4) {
        if (i4 != 3) {
            if (i4 != 4) {
                if (i4 == 5) {
                    return 3;
                }
                return 0;
            }
            return 2;
        }
        return 1;
    }

    private void z(RecyclerView.ViewHolder viewHolder, float f4, boolean z3, boolean z4, boolean z5) {
        if (f4 == -65536.0f) {
            this.f33938n.slideToOutsideOfWindow(viewHolder, 0, z5, this.f33929e);
        } else if (f4 == -65537.0f) {
            this.f33938n.slideToOutsideOfWindow(viewHolder, 1, z5, this.f33929e);
        } else if (f4 == 65536.0f) {
            this.f33938n.slideToOutsideOfWindow(viewHolder, 2, z5, this.f33929e);
        } else if (f4 == 65537.0f) {
            this.f33938n.slideToOutsideOfWindow(viewHolder, 3, z5, this.f33929e);
        } else if (f4 == 0.0f) {
            this.f33938n.slideToDefaultPosition(viewHolder, z4, z5, this.f33927c);
        } else {
            this.f33938n.slideToSpecifiedPosition(viewHolder, f4, z3, z4, z5, this.f33928d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        return this.f33937m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return D(this.f33941q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int D(int i4) {
        int h4 = h(this.f33939o, this.f33942r, i4);
        this.f33941q = h4;
        return h4;
    }

    public void attachRecyclerView(@NonNull RecyclerView recyclerView) {
        if (!isReleased()) {
            if (this.f33926b == null) {
                int orientation = CustomRecyclerViewUtils.getOrientation(recyclerView);
                if (orientation != -1) {
                    this.f33926b = recyclerView;
                    recyclerView.addOnItemTouchListener(this.f33925a);
                    ViewConfiguration viewConfiguration = ViewConfiguration.get(recyclerView.getContext());
                    this.f33930f = viewConfiguration.getScaledTouchSlop();
                    this.f33931g = viewConfiguration.getScaledMinimumFlingVelocity();
                    this.f33932h = viewConfiguration.getScaledMaximumFlingVelocity();
                    this.f33933i = this.f33930f * 5;
                    ItemSlidingAnimator itemSlidingAnimator = new ItemSlidingAnimator(this.f33939o);
                    this.f33938n = itemSlidingAnimator;
                    itemSlidingAnimator.setImmediatelySetTranslationThreshold((int) ((recyclerView.getResources().getDisplayMetrics().density * 8.0f) + 0.5f));
                    boolean z3 = true;
                    if (orientation != 1) {
                        z3 = false;
                    }
                    this.f33937m = z3;
                    this.B = new b(this);
                    return;
                }
                throw new IllegalStateException("failed to determine layout orientation");
            }
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
        throw new IllegalStateException("Accessing released object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(androidx.recyclerview.widget.RecyclerView.ViewHolder r14, int r15, float r16, float r17, boolean r18, boolean r19, boolean r20, boolean r21) {
        /*
            r13 = this;
            r0 = r16
            r3 = r17
            r10 = r18
            r11 = r19
            r1 = r14
            com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder r1 = (com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder) r1
            android.view.View r2 = com.h6ah4i.android.widget.advrecyclerview.swipeable.f.b(r1)
            if (r2 != 0) goto L12
            return
        L12:
            r2 = 0
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r4 != 0) goto L23
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L1e
            r0 = 0
            r12 = 0
            goto L28
        L1e:
            int r0 = f(r0, r11)
            goto L27
        L23:
            int r0 = f(r3, r11)
        L27:
            r12 = r0
        L28:
            if (r4 == 0) goto L56
            boolean r0 = r1.isProportionalSwipeAmountModeEnabled()
            if (r11 == 0) goto L35
            float r2 = r1.getMaxLeftSwipeAmount()
            goto L39
        L35:
            float r2 = r1.getMaxUpSwipeAmount()
        L39:
            if (r11 == 0) goto L40
            float r4 = r1.getMaxRightSwipeAmount()
            goto L44
        L40:
            float r4 = r1.getMaxDownSwipeAmount()
        L44:
            float r2 = a(r1, r11, r2, r0, r10)
            float r0 = a(r1, r11, r4, r0, r10)
            float r1 = java.lang.Math.max(r3, r2)
            float r0 = java.lang.Math.min(r1, r0)
            r6 = r0
            goto L57
        L56:
            r6 = r3
        L57:
            r4 = r13
            r5 = r14
            r7 = r18
            r8 = r19
            r9 = r20
            r4.z(r5, r6, r7, r8, r9)
            r8 = r13
            com.h6ah4i.android.widget.advrecyclerview.swipeable.e<androidx.recyclerview.widget.RecyclerView$ViewHolder> r0 = r8.f33939o
            r1 = r14
            r2 = r15
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r21
            r7 = r12
            r0.r(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager.b(androidx.recyclerview.widget.RecyclerView$ViewHolder, int, float, float, boolean, boolean, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.ViewHolder viewHolder) {
        ItemSlidingAnimator itemSlidingAnimator = this.f33938n;
        if (itemSlidingAnimator != null) {
            itemSlidingAnimator.endAnimation(viewHolder);
        }
    }

    public void cancelSwipe() {
        d(false);
    }

    @NonNull
    public RecyclerView.Adapter createWrappedAdapter(@NonNull RecyclerView.Adapter adapter) {
        if (adapter.hasStableIds()) {
            if (this.f33939o == null) {
                e<RecyclerView.ViewHolder> eVar = new e<>(this, adapter);
                this.f33939o = eVar;
                return eVar;
            }
            throw new IllegalStateException("already have a wrapped adapter");
        }
        throw new IllegalArgumentException("The passed adapter does not support stable IDs");
    }

    void d(boolean z3) {
        p(null, false);
        if (z3) {
            g(1);
        } else if (isSwiping()) {
            this.B.e();
        }
    }

    public long getMoveToOutsideWindowAnimationDuration() {
        return this.f33929e;
    }

    public long getMoveToSpecifiedPositionAnimationDuration() {
        return this.f33928d;
    }

    @Nullable
    public OnItemSwipeEventListener getOnItemSwipeEventListener() {
        return this.A;
    }

    public long getReturnToDefaultPositionAnimationDuration() {
        return this.f33927c;
    }

    public int getSwipeThresholdDistance() {
        return this.f33933i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(RecyclerView.ViewHolder viewHolder) {
        return this.f33938n.getSwipeContainerViewTranslationX(viewHolder);
    }

    public boolean isReleased() {
        if (this.f33925a == null) {
            return true;
        }
        return false;
    }

    public boolean isSwiping() {
        if (this.f33940p != null && !this.B.b()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(RecyclerView.ViewHolder viewHolder) {
        return this.f33938n.getSwipeContainerViewTranslationY(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f33941q;
    }

    public boolean performFakeSwipe(RecyclerView.ViewHolder viewHolder, int i4) {
        int i5 = 0;
        if (!(viewHolder instanceof SwipeableItemViewHolder) || isSwiping()) {
            return false;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return false;
                        }
                    }
                }
                if (this.f33937m) {
                    return false;
                }
            }
            if (!this.f33937m) {
                return false;
            }
        }
        int l4 = l(viewHolder);
        if (l4 == -1) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
        A(obtain, viewHolder, l4);
        obtain.recycle();
        if (i4 != 2 && i4 != 3) {
            if (i4 == 4 || i4 == 5) {
                i5 = 1;
            }
        } else {
            i5 = -1;
        }
        b(viewHolder, l4, 0.0f, i5, false, this.f33937m, false, true);
        g(i4);
        return true;
    }

    public void release() {
        RecyclerView.OnItemTouchListener onItemTouchListener;
        d(true);
        b bVar = this.B;
        if (bVar != null) {
            bVar.c();
            this.B = null;
        }
        RecyclerView recyclerView = this.f33926b;
        if (recyclerView != null && (onItemTouchListener = this.f33925a) != null) {
            recyclerView.removeOnItemTouchListener(onItemTouchListener);
        }
        this.f33925a = null;
        VelocityTracker velocityTracker = this.f33949y;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f33949y = null;
        }
        ItemSlidingAnimator itemSlidingAnimator = this.f33938n;
        if (itemSlidingAnimator != null) {
            itemSlidingAnimator.endAnimations();
            this.f33938n = null;
        }
        this.f33939o = null;
        this.f33926b = null;
    }

    void s(MotionEvent motionEvent) {
        RecyclerView.ViewHolder findViewHolderForItemId = this.f33926b.findViewHolderForItemId(this.f33936l);
        if (findViewHolderForItemId != null) {
            e(motionEvent, findViewHolderForItemId);
        }
    }

    public void setLongPressTimeout(int i4) {
        this.C = i4;
    }

    public void setMoveToOutsideWindowAnimationDuration(long j4) {
        this.f33929e = j4;
    }

    public void setMoveToSpecifiedPositionAnimationDuration(long j4) {
        this.f33928d = j4;
    }

    public void setOnItemSwipeEventListener(@Nullable OnItemSwipeEventListener onItemSwipeEventListener) {
        this.A = onItemSwipeEventListener;
    }

    public void setReturnToDefaultPositionAnimationDuration(long j4) {
        this.f33927c = j4;
    }

    public void setSwipeThresholdDistance(int i4) {
        this.f33933i = Math.max(i4, this.f33930f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(RecyclerView.ViewHolder viewHolder) {
        ItemSlidingAnimator itemSlidingAnimator = this.f33938n;
        if (itemSlidingAnimator != null && itemSlidingAnimator.isRunning(viewHolder)) {
            return true;
        }
        return false;
    }

    boolean v(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                } else if (isSwiping()) {
                    o(motionEvent);
                    return true;
                } else if (n(recyclerView, motionEvent)) {
                    return true;
                } else {
                    return false;
                }
            }
            if (p(motionEvent, true)) {
                return true;
            }
            return false;
        } else if (!isSwiping()) {
            m(recyclerView, motionEvent);
            return false;
        } else {
            return false;
        }
    }

    void w(boolean z3) {
        if (z3) {
            d(true);
        }
    }

    void x(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!isSwiping()) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    return;
                }
            } else {
                o(motionEvent);
                return;
            }
        }
        p(motionEvent, true);
    }
}
