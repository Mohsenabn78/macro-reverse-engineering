package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPath;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class RecyclerViewDragDropManager implements DraggableItemConstants {
    public static final int ITEM_MOVE_MODE_DEFAULT = 0;
    public static final int ITEM_MOVE_MODE_SWAP = 1;
    private com.h6ah4i.android.widget.advrecyclerview.draggable.c A;
    RecyclerView.ViewHolder B;
    private DraggingItemInfo C;
    private com.h6ah4i.android.widget.advrecyclerview.draggable.d D;
    private com.h6ah4i.android.widget.advrecyclerview.draggable.g E;
    private NestedScrollView F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int T;
    private ItemDraggableRange U;
    private ItemDraggableRange V;
    private e W;
    private OnItemDragEventListener X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f33733a;

    /* renamed from: c0  reason: collision with root package name */
    private Object f33738c0;

    /* renamed from: f  reason: collision with root package name */
    private com.h6ah4i.android.widget.advrecyclerview.draggable.b f33743f;

    /* renamed from: g  reason: collision with root package name */
    private NinePatchDrawable f33745g;

    /* renamed from: h  reason: collision with root package name */
    private float f33746h;

    /* renamed from: i  reason: collision with root package name */
    private int f33747i;

    /* renamed from: j  reason: collision with root package name */
    private int f33748j;

    /* renamed from: k  reason: collision with root package name */
    private int f33749k;

    /* renamed from: l  reason: collision with root package name */
    private int f33750l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f33752n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f33753o;

    /* renamed from: r  reason: collision with root package name */
    private boolean f33756r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f33757s;

    /* renamed from: t  reason: collision with root package name */
    private int f33758t;

    /* renamed from: u  reason: collision with root package name */
    private int f33759u;
    public static final Interpolator DEFAULT_SWAP_TARGET_TRANSITION_INTERPOLATOR = new BasicSwapTargetTranslationInterpolator();
    public static final Interpolator DEFAULT_ITEM_SETTLE_BACK_INTO_PLACE_ANIMATION_INTERPOLATOR = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f33735b = DEFAULT_SWAP_TARGET_TRANSITION_INTERPOLATOR;

    /* renamed from: m  reason: collision with root package name */
    private long f33751m = -1;

    /* renamed from: p  reason: collision with root package name */
    private boolean f33754p = true;

    /* renamed from: v  reason: collision with root package name */
    private final Rect f33760v = new Rect();

    /* renamed from: w  reason: collision with root package name */
    private int f33761w = 200;

    /* renamed from: x  reason: collision with root package name */
    private Interpolator f33762x = DEFAULT_ITEM_SETTLE_BACK_INTO_PLACE_ANIMATION_INTERPOLATOR;

    /* renamed from: y  reason: collision with root package name */
    private int f33763y = 0;

    /* renamed from: z  reason: collision with root package name */
    private com.h6ah4i.android.widget.advrecyclerview.draggable.e f33764z = new com.h6ah4i.android.widget.advrecyclerview.draggable.e();
    private int S = 0;

    /* renamed from: a0  reason: collision with root package name */
    private float f33734a0 = 1.0f;

    /* renamed from: b0  reason: collision with root package name */
    private int f33736b0 = 0;

    /* renamed from: d0  reason: collision with root package name */
    private g f33740d0 = new g();

    /* renamed from: e0  reason: collision with root package name */
    private d f33742e0 = new d();

    /* renamed from: f0  reason: collision with root package name */
    private final Runnable f33744f0 = new c();

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.OnItemTouchListener f33739d = new a();

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView.OnScrollListener f33741e = new b();

    /* renamed from: c  reason: collision with root package name */
    private f f33737c = new f(this);

    /* renamed from: q  reason: collision with root package name */
    private int f33755q = ViewConfiguration.getLongPressTimeout();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface ItemMoveMode {
    }

    /* loaded from: classes6.dex */
    public interface OnItemDragEventListener {
        void onItemDragFinished(int i4, int i5, boolean z3);

        void onItemDragMoveDistanceUpdated(int i4, int i5);

        void onItemDragPositionChanged(int i4, int i5);

        void onItemDragStarted(int i4);
    }

    /* loaded from: classes6.dex */
    class a implements RecyclerView.OnItemTouchListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return RecyclerViewDragDropManager.this.F(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z3) {
            RecyclerViewDragDropManager.this.J(z3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            RecyclerViewDragDropManager.this.M(recyclerView, motionEvent);
        }
    }

    /* loaded from: classes6.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i4) {
            RecyclerViewDragDropManager.this.K(recyclerView, i4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i4, int i5) {
            RecyclerViewDragDropManager.this.L(recyclerView, i4, i5);
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerViewDragDropManager recyclerViewDragDropManager = RecyclerViewDragDropManager.this;
            if (recyclerViewDragDropManager.B != null) {
                recyclerViewDragDropManager.d(recyclerViewDragDropManager.s());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView f33768a;

        /* renamed from: b  reason: collision with root package name */
        public DraggingItemInfo f33769b;

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView.ViewHolder f33770c;

        /* renamed from: d  reason: collision with root package name */
        public int f33771d;

        /* renamed from: e  reason: collision with root package name */
        public int f33772e;

        /* renamed from: f  reason: collision with root package name */
        public int f33773f;

        /* renamed from: g  reason: collision with root package name */
        public int f33774g;

        /* renamed from: h  reason: collision with root package name */
        public int f33775h;

        /* renamed from: i  reason: collision with root package name */
        public int f33776i;

        /* renamed from: j  reason: collision with root package name */
        public int f33777j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f33778k;

        /* renamed from: l  reason: collision with root package name */
        public ItemDraggableRange f33779l;

        /* renamed from: m  reason: collision with root package name */
        public ItemDraggableRange f33780m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f33781n;

        d() {
        }

        public void a() {
            this.f33768a = null;
            this.f33769b = null;
            this.f33770c = null;
        }

        public void b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, DraggingItemInfo draggingItemInfo, int i4, int i5, ItemDraggableRange itemDraggableRange, ItemDraggableRange itemDraggableRange2, boolean z3) {
            this.f33768a = recyclerView;
            this.f33769b = draggingItemInfo;
            this.f33770c = viewHolder;
            this.f33771d = i4;
            this.f33772e = i5;
            this.f33779l = itemDraggableRange;
            this.f33780m = itemDraggableRange2;
            this.f33781n = z3;
            int layoutType = CustomRecyclerViewUtils.getLayoutType(recyclerView);
            this.f33777j = layoutType;
            boolean z4 = true;
            if (CustomRecyclerViewUtils.extractOrientation(layoutType) != 1) {
                z4 = false;
            }
            this.f33778k = z4;
            int i6 = i4 - draggingItemInfo.grabbedPositionX;
            this.f33775h = i6;
            this.f33773f = i6;
            int i7 = i5 - draggingItemInfo.grabbedPositionY;
            this.f33776i = i7;
            this.f33774g = i7;
            if (z4) {
                int max = Math.max(i6, recyclerView.getPaddingLeft());
                this.f33773f = max;
                this.f33773f = Math.min(max, Math.max(0, (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f33769b.width));
                return;
            }
            int max2 = Math.max(i7, recyclerView.getPaddingTop());
            this.f33774g = max2;
            this.f33774g = Math.min(max2, Math.max(0, (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - this.f33769b.height));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private RecyclerViewDragDropManager f33782a;

        /* renamed from: b  reason: collision with root package name */
        private MotionEvent f33783b;

        public e(RecyclerViewDragDropManager recyclerViewDragDropManager) {
            this.f33782a = recyclerViewDragDropManager;
        }

        public void a() {
            removeMessages(1);
            MotionEvent motionEvent = this.f33783b;
            if (motionEvent != null) {
                motionEvent.recycle();
                this.f33783b = null;
            }
        }

        public boolean b() {
            return hasMessages(2);
        }

        public void c() {
            removeCallbacksAndMessages(null);
            this.f33782a = null;
        }

        public void d() {
            removeMessages(2);
        }

        public void e() {
            removeMessages(3);
        }

        public void f() {
            if (b()) {
                return;
            }
            sendEmptyMessage(2);
        }

        public void g() {
            sendEmptyMessage(3);
        }

        public void h(MotionEvent motionEvent, int i4) {
            a();
            this.f33783b = MotionEvent.obtain(motionEvent);
            sendEmptyMessageAtTime(1, motionEvent.getDownTime() + i4);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        this.f33782a.y();
                        return;
                    }
                    return;
                }
                this.f33782a.b(true);
                return;
            }
            this.f33782a.z(this.f33783b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<RecyclerViewDragDropManager> f33784a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f33785b;

        public f(RecyclerViewDragDropManager recyclerViewDragDropManager) {
            this.f33784a = new WeakReference<>(recyclerViewDragDropManager);
        }

        public void a() {
            this.f33784a.clear();
            this.f33785b = false;
        }

        public void b() {
            RecyclerViewDragDropManager recyclerViewDragDropManager;
            RecyclerView s3;
            if (this.f33785b || (recyclerViewDragDropManager = this.f33784a.get()) == null || (s3 = recyclerViewDragDropManager.s()) == null) {
                return;
            }
            ViewCompat.postOnAnimation(s3, this);
            this.f33785b = true;
        }

        public void c() {
            if (!this.f33785b) {
                return;
            }
            this.f33785b = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerViewDragDropManager recyclerViewDragDropManager = this.f33784a.get();
            if (recyclerViewDragDropManager == null || !this.f33785b) {
                return;
            }
            recyclerViewDragDropManager.A();
            RecyclerView s3 = recyclerViewDragDropManager.s();
            if (s3 != null && this.f33785b) {
                ViewCompat.postOnAnimation(s3, this);
            } else {
                this.f33785b = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f33786a;

        /* renamed from: b  reason: collision with root package name */
        public int f33787b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f33788c;

        g() {
        }

        public void a() {
            this.f33786a = null;
            this.f33787b = -1;
            this.f33788c = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0078, code lost:
        if ((r3 & r4) == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007a, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
        if ((r3 & r4) == 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B(androidx.recyclerview.widget.RecyclerView r8, boolean r9) {
        /*
            r7 = this;
            androidx.core.widget.NestedScrollView r0 = r7.F
            int r1 = r0.getScrollX()
            int r2 = r0.getScrollY()
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            int r4 = r7.q()
            r3.right = r4
            r3.left = r4
            int r4 = r7.r()
            r3.bottom = r4
            r3.top = r4
            androidx.recyclerview.widget.RecyclerView r4 = r7.f33733a
            D(r4, r0, r3)
            int r4 = r3.left
            int r4 = r4 - r1
            int r1 = r3.top
            int r1 = r1 - r2
            if (r9 == 0) goto L31
            int r2 = r0.getWidth()
            goto L35
        L31:
            int r2 = r0.getHeight()
        L35:
            r3 = 1065353216(0x3f800000, float:1.0)
            float r2 = (float) r2
            float r3 = r3 / r2
            if (r9 == 0) goto L3c
            goto L3d
        L3c:
            r4 = r1
        L3d:
            float r1 = (float) r4
            float r1 = r1 * r3
            r2 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 - r2
            float r3 = java.lang.Math.abs(r1)
            r4 = 1050253722(0x3e99999a, float:0.3)
            float r3 = r2 - r3
            float r4 = r4 - r3
            r3 = 0
            float r3 = java.lang.Math.max(r3, r4)
            r4 = 1079334229(0x40555555, float:3.3333333)
            float r3 = r3 * r4
            int r4 = r7.S
            float r1 = java.lang.Math.signum(r1)
            int r1 = (int) r1
            r5 = 1103626240(0x41c80000, float:25.0)
            float r6 = r7.f33734a0
            float r6 = r6 * r5
            float r5 = r7.f33746h
            float r6 = r6 * r5
            float r6 = r6 * r3
            float r6 = r6 + r2
            int r2 = (int) r6
            int r1 = r1 * r2
            r2 = 0
            if (r1 <= 0) goto L7c
            if (r9 == 0) goto L76
            r3 = 8
            goto L77
        L76:
            r3 = 2
        L77:
            r3 = r3 & r4
            if (r3 != 0) goto L87
        L7a:
            r1 = 0
            goto L87
        L7c:
            if (r1 >= 0) goto L87
            if (r9 == 0) goto L82
            r3 = 4
            goto L83
        L82:
            r3 = 1
        L83:
            r3 = r3 & r4
            if (r3 != 0) goto L87
            goto L7a
        L87:
            if (r1 == 0) goto L95
            r7.Q(r8)
            if (r9 == 0) goto L92
            r0.scrollBy(r1, r2)
            goto L95
        L92:
            r0.scrollBy(r2, r1)
        L95:
            com.h6ah4i.android.widget.advrecyclerview.draggable.d r9 = r7.D
            int r0 = r7.q()
            int r1 = r7.r()
            boolean r9 = r9.F(r0, r1, r2)
            if (r9 == 0) goto Lbe
            com.h6ah4i.android.widget.advrecyclerview.draggable.g r9 = r7.E
            if (r9 == 0) goto Lb8
            com.h6ah4i.android.widget.advrecyclerview.draggable.d r0 = r7.D
            int r0 = r0.n()
            com.h6ah4i.android.widget.advrecyclerview.draggable.d r1 = r7.D
            int r1 = r1.o()
            r9.n(r0, r1)
        Lb8:
            r7.d(r8)
            r7.G()
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.B(androidx.recyclerview.widget.RecyclerView, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0156, code lost:
        r1 = r17.f33746h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0158, code lost:
        r5 = r1 * 0.005f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009d, code lost:
        if ((r7 & r16) == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009f, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
        if ((r7 & r16) == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0143, code lost:
        r1 = -r17.f33746h;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void C(androidx.recyclerview.widget.RecyclerView r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.C(androidx.recyclerview.widget.RecyclerView, boolean):void");
    }

    private static boolean D(View view, View view2, Rect rect) {
        ViewParent parent;
        do {
            parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ((ViewGroup) parent).offsetDescendantRectToMyCoords(view, rect);
            view = (View) parent;
        } while (parent != view2);
        return true;
    }

    private void E() {
        Log.i("ARVDragDropManager", "a view holder object which is bound to currently dragging item is recycled");
        this.B = null;
        this.D.u();
    }

    private void G() {
        if (this.X == null) {
            return;
        }
        this.X.onItemDragMoveDistanceUpdated(this.Q + this.D.l(), this.R + this.D.m());
    }

    private void N(RecyclerView recyclerView, @Nullable RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, Rect rect, int i4, int i5) {
        View view;
        int i6;
        int decoratedMeasuredWidth;
        int i7;
        OnItemDragEventListener onItemDragEventListener = this.X;
        if (onItemDragEventListener != null) {
            onItemDragEventListener.onItemDragPositionChanged(i4, i5);
        }
        RecyclerView.LayoutManager layoutManager = this.f33733a.getLayoutManager();
        int layoutType = CustomRecyclerViewUtils.getLayoutType(this.f33733a);
        boolean z3 = true;
        if (CustomRecyclerViewUtils.extractOrientation(layoutType) != 1) {
            z3 = false;
        }
        int findFirstVisibleItemPosition = CustomRecyclerViewUtils.findFirstVisibleItemPosition(this.f33733a, false);
        if (viewHolder != null) {
            view = viewHolder.itemView;
        } else {
            view = null;
        }
        View view2 = viewHolder2.itemView;
        View findViewByPosition = CustomRecyclerViewUtils.findViewByPosition(layoutManager, findFirstVisibleItemPosition);
        if (viewHolder != null) {
            i6 = viewHolder.getLayoutPosition();
        } else {
            i6 = -1;
        }
        int layoutPosition = viewHolder2.getLayoutPosition();
        Integer p4 = p(view, z3);
        Integer p5 = p(view2, z3);
        Integer p6 = p(findViewByPosition, z3);
        this.A.q(i4, i5, layoutType);
        if (findFirstVisibleItemPosition == i6 && p6 != null && p5 != null) {
            R(recyclerView, -(p5.intValue() - p6.intValue()), z3);
            P(recyclerView);
        } else if (findFirstVisibleItemPosition == layoutPosition && view != null && p4 != null && !p4.equals(p5)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (z3) {
                decoratedMeasuredWidth = layoutManager.getDecoratedMeasuredHeight(view) + marginLayoutParams.topMargin;
                i7 = marginLayoutParams.bottomMargin;
            } else {
                decoratedMeasuredWidth = layoutManager.getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin;
                i7 = marginLayoutParams.rightMargin;
            }
            R(recyclerView, -(decoratedMeasuredWidth + i7), z3);
            P(recyclerView);
        }
    }

    private static void O(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ItemAnimator itemAnimator;
        if (recyclerView != null) {
            itemAnimator = recyclerView.getItemAnimator();
        } else {
            itemAnimator = null;
        }
        if (itemAnimator != null) {
            itemAnimator.endAnimation(viewHolder);
        }
    }

    private static void P(RecyclerView recyclerView) {
        RecyclerView.ItemAnimator itemAnimator;
        if (recyclerView != null) {
            itemAnimator = recyclerView.getItemAnimator();
        } else {
            itemAnimator = null;
        }
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
    }

    private void Q(RecyclerView recyclerView) {
        if (this.E != null) {
            P(recyclerView);
        }
    }

    private static void R(RecyclerView recyclerView, int i4, boolean z3) {
        if (z3) {
            recyclerView.scrollBy(0, i4);
        } else {
            recyclerView.scrollBy(i4, 0);
        }
    }

    private int S(int i4) {
        this.f33758t = 0;
        this.f33757s = true;
        this.f33733a.scrollBy(i4, 0);
        this.f33757s = false;
        return this.f33758t;
    }

    private int T(int i4) {
        this.f33759u = 0;
        this.f33757s = true;
        this.f33733a.scrollBy(0, i4);
        this.f33757s = false;
        return this.f33759u;
    }

    private void U(RecyclerView recyclerView, MotionEvent motionEvent, RecyclerView.ViewHolder viewHolder, ItemDraggableRange itemDraggableRange, AdapterPath adapterPath, int i4, Object obj) {
        int i5;
        int i6;
        O(recyclerView, viewHolder);
        this.W.a();
        this.C = new DraggingItemInfo(recyclerView, viewHolder, this.I, this.J);
        this.B = viewHolder;
        this.U = itemDraggableRange;
        this.V = f(adapterPath, itemDraggableRange);
        NestedScrollView g4 = g(this.f33733a);
        if (g4 != null && !this.f33733a.isNestedScrollingEnabled()) {
            this.F = g4;
        } else {
            this.F = null;
        }
        this.T = recyclerView.getOverScrollMode();
        recyclerView.setOverScrollMode(2);
        this.I = (int) (motionEvent.getX() + 0.5f);
        this.J = (int) (motionEvent.getY() + 0.5f);
        NestedScrollView nestedScrollView = this.F;
        if (nestedScrollView != null) {
            i5 = nestedScrollView.getScrollX();
        } else {
            i5 = 0;
        }
        this.G = i5;
        NestedScrollView nestedScrollView2 = this.F;
        if (nestedScrollView2 != null) {
            i6 = nestedScrollView2.getScrollY();
        } else {
            i6 = 0;
        }
        this.H = i6;
        int i7 = this.J;
        this.P = i7;
        this.N = i7;
        this.L = i7;
        int i8 = this.I;
        this.O = i8;
        this.M = i8;
        this.K = i8;
        this.S = 0;
        this.f33736b0 = this.f33763y;
        this.f33738c0 = obj;
        this.f33733a.getParent().requestDisallowInterceptTouchEvent(true);
        V();
        this.A.v(this.C, viewHolder, this.U, i4, this.f33736b0);
        this.A.onBindViewHolder(viewHolder, i4);
        com.h6ah4i.android.widget.advrecyclerview.draggable.d dVar = new com.h6ah4i.android.widget.advrecyclerview.draggable.d(this.f33733a, viewHolder, this.V);
        this.D = dVar;
        dVar.C(this.f33745g);
        this.D.D(this.f33764z);
        this.D.E(this.C, this.I, this.J);
        int layoutType = CustomRecyclerViewUtils.getLayoutType(this.f33733a);
        if (!this.f33756r && CustomRecyclerViewUtils.isLinearLayout(layoutType)) {
            com.h6ah4i.android.widget.advrecyclerview.draggable.g gVar = new com.h6ah4i.android.widget.advrecyclerview.draggable.g(this.f33733a, viewHolder, this.C);
            this.E = gVar;
            gVar.l(this.f33735b);
            this.E.m();
            this.E.n(this.D.n(), this.D.o());
        }
        com.h6ah4i.android.widget.advrecyclerview.draggable.b bVar = this.f33743f;
        if (bVar != null) {
            bVar.j();
        }
        this.A.s();
        OnItemDragEventListener onItemDragEventListener = this.X;
        if (onItemDragEventListener != null) {
            onItemDragEventListener.onItemDragStarted(this.A.m());
            this.X.onItemDragMoveDistanceUpdated(0, 0);
        }
    }

    private void V() {
        this.f33737c.b();
    }

    private void W() {
        f fVar = this.f33737c;
        if (fVar != null) {
            fVar.c();
        }
    }

    private static boolean X() {
        return true;
    }

    private void Y(RecyclerView recyclerView, int i4, @Nullable RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
        boolean z3;
        Rect layoutMargins = CustomRecyclerViewUtils.getLayoutMargins(viewHolder2.itemView, this.f33760v);
        int t3 = t(viewHolder2);
        int abs = Math.abs(i4 - t3);
        if (i4 == -1 || t3 == -1 || ItemIdComposer.extractWrappedIdPart(this.A.getItemId(i4)) != ItemIdComposer.extractWrappedIdPart(this.C.id)) {
            return;
        }
        boolean z4 = true;
        boolean z5 = false;
        if (CustomRecyclerViewUtils.isLinearLayout(CustomRecyclerViewUtils.getLayoutType(recyclerView)) && !this.f33756r) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (abs == 0) {
            z4 = false;
        } else if (abs == 1 && viewHolder != null && z3) {
            View view = viewHolder.itemView;
            View view2 = viewHolder2.itemView;
            Rect rect = this.C.margins;
            if (this.Y) {
                int min = Math.min(view.getLeft() - rect.left, view2.getLeft() - layoutMargins.left);
                float max = min + ((Math.max(view.getRight() + rect.right, view2.getRight() + layoutMargins.right) - min) * 0.5f);
                int q4 = q();
                DraggingItemInfo draggingItemInfo = this.C;
                float f4 = (q4 - draggingItemInfo.grabbedPositionX) + (draggingItemInfo.width * 0.5f);
                if (t3 >= i4 ? f4 > max : f4 < max) {
                    z5 = true;
                }
            }
            if (!z5 && this.Z) {
                int min2 = Math.min(view.getTop() - rect.top, view2.getTop() - layoutMargins.top);
                float max2 = min2 + ((Math.max(view.getBottom() + rect.bottom, view2.getBottom() + layoutMargins.bottom) - min2) * 0.5f);
                int r4 = r();
                DraggingItemInfo draggingItemInfo2 = this.C;
                float f5 = (r4 - draggingItemInfo2.grabbedPositionY) + (draggingItemInfo2.height * 0.5f);
                if (t3 >= i4) {
                }
            }
            z4 = z5;
        }
        if (z4) {
            N(recyclerView, viewHolder, viewHolder2, layoutMargins, i4, t3);
        }
    }

    private void Z() {
        int orientation = CustomRecyclerViewUtils.getOrientation(this.f33733a);
        if (orientation != 0) {
            if (orientation == 1) {
                int r4 = r();
                int i4 = this.L;
                int i5 = this.N;
                int i6 = i4 - i5;
                int i7 = this.f33748j;
                if (i6 > i7 || this.P - r4 > i7) {
                    this.S = 1 | this.S;
                }
                if (this.P - i4 > i7 || r4 - i5 > i7) {
                    this.S |= 2;
                    return;
                }
                return;
            }
            return;
        }
        int q4 = q();
        int i8 = this.K;
        int i9 = this.M;
        int i10 = i8 - i9;
        int i11 = this.f33748j;
        if (i10 > i11 || this.O - q4 > i11) {
            this.S |= 4;
        }
        if (this.O - i8 > i11 || q4 - i9 > i11) {
            this.S |= 8;
        }
    }

    private boolean a(RecyclerView.ViewHolder viewHolder, int i4, int i5) {
        int adapterPosition = viewHolder.getAdapterPosition();
        int unwrapPosition = WrapperAdapterUtils.unwrapPosition(this.f33733a.getAdapter(), this.A, (Object) null, adapterPosition);
        if (unwrapPosition == -1) {
            return false;
        }
        View view = viewHolder.itemView;
        int translationY = (int) (view.getTranslationY() + 0.5f);
        int left = view.getLeft();
        int top = i5 - (view.getTop() + translationY);
        if (!this.A.i(viewHolder, unwrapPosition, i4 - (left + ((int) (view.getTranslationX() + 0.5f))), top) || viewHolder.getAdapterPosition() != adapterPosition) {
            return false;
        }
        return true;
    }

    private void a0(float f4) {
        if (f4 != 0.0f) {
            if (f4 < 0.0f) {
                this.f33743f.g(f4);
                return;
            } else {
                this.f33743f.h(f4);
                return;
            }
        }
        this.f33743f.i();
    }

    private void b0(ItemDraggableRange itemDraggableRange, int i4) {
        int max = Math.max(0, this.A.getItemCount() - 1);
        if (itemDraggableRange.getStart() <= itemDraggableRange.getEnd()) {
            if (itemDraggableRange.getStart() >= 0) {
                if (itemDraggableRange.getEnd() <= max) {
                    if (itemDraggableRange.checkInRange(i4)) {
                        return;
                    }
                    throw new IllegalStateException("Invalid wrappedAdapterRange specified --- does not contain drag target item (wrappedAdapterRange = " + itemDraggableRange + ", position = " + i4 + ")");
                }
                throw new IllegalStateException("Invalid wrappedAdapterRange specified --- end >= count (wrappedAdapterRange = " + itemDraggableRange + ")");
            }
            throw new IllegalStateException("Invalid wrappedAdapterRange specified --- start < 0 (wrappedAdapterRange = " + itemDraggableRange + ")");
        }
        throw new IllegalStateException("Invalid wrappedAdapterRange specified --- start > wrappedAdapterRange (wrappedAdapterRange = " + itemDraggableRange + ")");
    }

    private boolean c(RecyclerView recyclerView, MotionEvent motionEvent, boolean z3) {
        RecyclerView.ViewHolder findChildViewHolderUnderWithoutTranslation;
        if (this.C != null) {
            return false;
        }
        int x3 = (int) (motionEvent.getX() + 0.5f);
        int y3 = (int) (motionEvent.getY() + 0.5f);
        this.I = x3;
        this.J = y3;
        if (this.f33751m == -1) {
            return false;
        }
        if ((z3 && ((!this.Y || Math.abs(x3 - this.f33749k) <= this.f33747i) && (!this.Z || Math.abs(y3 - this.f33750l) <= this.f33747i))) || (findChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(recyclerView, this.f33749k, this.f33750l)) == null || !a(findChildViewHolderUnderWithoutTranslation, x3, y3)) {
            return false;
        }
        RecyclerView.Adapter adapter = this.f33733a.getAdapter();
        AdapterPath adapterPath = new AdapterPath();
        int unwrapPosition = WrapperAdapterUtils.unwrapPosition(adapter, this.A, null, findChildViewHolderUnderWithoutTranslation.getAdapterPosition(), adapterPath);
        ItemDraggableRange n4 = this.A.n(findChildViewHolderUnderWithoutTranslation, unwrapPosition);
        if (n4 == null) {
            n4 = new ItemDraggableRange(0, Math.max(0, this.A.getItemCount() - 1));
        }
        ItemDraggableRange itemDraggableRange = n4;
        b0(itemDraggableRange, unwrapPosition);
        U(recyclerView, motionEvent, findChildViewHolderUnderWithoutTranslation, itemDraggableRange, adapterPath, unwrapPosition, adapterPath.lastSegment().tag);
        return true;
    }

    private boolean e(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (!(viewHolder instanceof DraggableItemViewHolder)) {
            return false;
        }
        int t3 = t(viewHolder);
        com.h6ah4i.android.widget.advrecyclerview.draggable.c cVar = this.A;
        if (t3 < 0 || t3 >= cVar.getItemCount()) {
            return false;
        }
        return true;
    }

    private ItemDraggableRange f(AdapterPath adapterPath, ItemDraggableRange itemDraggableRange) {
        RecyclerView.Adapter adapter = this.f33733a.getAdapter();
        return new ItemDraggableRange(WrapperAdapterUtils.wrapPosition(adapterPath, this.A, adapter, itemDraggableRange.getStart()), WrapperAdapterUtils.wrapPosition(adapterPath, this.A, adapter, itemDraggableRange.getEnd()));
    }

    private static NestedScrollView g(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof NestedScrollView) {
                return (NestedScrollView) parent;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.g h(com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.g r9, com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.d r10, boolean r11) {
        /*
            r8 = this;
            r9.a()
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r10.f33770c
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L1e
            int r0 = r8.t(r0)
            if (r0 == r1) goto L30
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r10.f33770c
            long r4 = r0.getItemId()
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggingItemInfo r0 = r10.f33769b
            long r6 = r0.id
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L30
        L1e:
            int r0 = r10.f33777j
            if (r0 == 0) goto L3c
            if (r0 == r2) goto L3c
            r4 = 2
            if (r0 == r4) goto L37
            r4 = 3
            if (r0 == r4) goto L37
            r4 = 4
            if (r0 == r4) goto L32
            r4 = 5
            if (r0 == r4) goto L32
        L30:
            r11 = r3
            goto L40
        L32:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = m(r10, r11)
            goto L40
        L37:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = i(r10, r11)
            goto L40
        L3c:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = l(r10, r11)
        L40:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r10.f33770c
            if (r11 != r0) goto L47
            r9.f33788c = r2
            r11 = r3
        L47:
            int r0 = r8.t(r11)
            if (r11 == 0) goto L58
            com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange r10 = r10.f33779l
            if (r10 == 0) goto L58
            boolean r10 = r10.checkInRange(r0)
            if (r10 != 0) goto L58
            goto L59
        L58:
            r3 = r11
        L59:
            r9.f33786a = r3
            if (r3 == 0) goto L5e
            r1 = r0
        L5e:
            r9.f33787b = r1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.h(com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager$g, com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager$d, boolean):com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager$g");
    }

    private static RecyclerView.ViewHolder i(d dVar, boolean z3) {
        if (z3) {
            return null;
        }
        RecyclerView.ViewHolder j4 = j(dVar);
        if (j4 == null) {
            return k(dVar);
        }
        return j4;
    }

    private static RecyclerView.ViewHolder j(d dVar) {
        return CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, dVar.f33771d, dVar.f33772e);
    }

    private static RecyclerView.ViewHolder k(d dVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        float f4;
        float f5;
        int i8;
        int i9;
        int spanCount = CustomRecyclerViewUtils.getSpanCount(dVar.f33768a);
        int height = dVar.f33768a.getHeight();
        int width = dVar.f33768a.getWidth();
        if (dVar.f33778k) {
            i4 = dVar.f33768a.getPaddingLeft();
        } else {
            i4 = 0;
        }
        if (!dVar.f33778k) {
            i5 = dVar.f33768a.getPaddingTop();
        } else {
            i5 = 0;
        }
        if (dVar.f33778k) {
            i6 = dVar.f33768a.getPaddingRight();
        } else {
            i6 = 0;
        }
        if (!dVar.f33778k) {
            i7 = dVar.f33768a.getPaddingBottom();
        } else {
            i7 = 0;
        }
        int i10 = ((width - i4) - i6) / spanCount;
        int i11 = ((height - i5) - i7) / spanCount;
        int i12 = dVar.f33771d;
        int i13 = dVar.f33772e;
        int start = dVar.f33780m.getStart();
        int end = dVar.f33780m.getEnd();
        if (dVar.f33778k) {
            f4 = i12 - i4;
            f5 = i10;
        } else {
            f4 = i13 - i5;
            f5 = i11;
        }
        for (int min = Math.min(Math.max((int) (f4 / f5), 0), spanCount - 1); min >= 0; min--) {
            boolean z3 = dVar.f33778k;
            if (z3) {
                i8 = (i10 * min) + i4 + (i10 / 2);
            } else {
                i8 = i12;
            }
            if (!z3) {
                i9 = (i11 * min) + i5 + (i11 / 2);
            } else {
                i9 = i13;
            }
            RecyclerView.ViewHolder findChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, i8, i9);
            if (findChildViewHolderUnderWithoutTranslation != null) {
                int adapterPosition = findChildViewHolderUnderWithoutTranslation.getAdapterPosition();
                if (adapterPosition != -1 && adapterPosition >= start && adapterPosition <= end) {
                    return findChildViewHolderUnderWithoutTranslation;
                }
                return null;
            }
        }
        return null;
    }

    private static RecyclerView.ViewHolder l(d dVar, boolean z3) {
        int left;
        int i4;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        RecyclerView.ViewHolder viewHolder = dVar.f33770c;
        if (viewHolder == null) {
            return null;
        }
        if (!dVar.f33781n && !z3) {
            int adapterPosition = viewHolder.getAdapterPosition();
            if (dVar.f33778k) {
                left = dVar.f33770c.itemView.getTop();
            } else {
                left = dVar.f33770c.itemView.getLeft();
            }
            if (dVar.f33778k) {
                i4 = dVar.f33774g;
            } else {
                i4 = dVar.f33773f;
            }
            if (i4 < left) {
                if (adapterPosition <= 0) {
                    return null;
                }
                findViewHolderForAdapterPosition = dVar.f33768a.findViewHolderForAdapterPosition(adapterPosition - 1);
            } else if (i4 <= left || adapterPosition >= dVar.f33768a.getAdapter().getItemCount() - 1) {
                return null;
            } else {
                findViewHolderForAdapterPosition = dVar.f33768a.findViewHolderForAdapterPosition(adapterPosition + 1);
            }
            return findViewHolderForAdapterPosition;
        }
        float f4 = viewHolder.itemView.getResources().getDisplayMetrics().density * 8.0f;
        float min = Math.min(dVar.f33769b.width * 0.2f, f4);
        float min2 = Math.min(dVar.f33769b.height * 0.2f, f4);
        DraggingItemInfo draggingItemInfo = dVar.f33769b;
        float f5 = dVar.f33773f + (draggingItemInfo.width * 0.5f);
        float f6 = dVar.f33774g + (draggingItemInfo.height * 0.5f);
        RecyclerView.ViewHolder findChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, f5 - min, f6 - min2);
        if (findChildViewHolderUnderWithoutTranslation != CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, f5 + min, f6 + min2)) {
            return null;
        }
        return findChildViewHolderUnderWithoutTranslation;
    }

    private static RecyclerView.ViewHolder m(d dVar, boolean z3) {
        RecyclerView.ViewHolder viewHolder;
        RecyclerView.ViewHolder viewHolder2;
        RecyclerView.ViewHolder viewHolder3;
        if (z3 || dVar.f33770c == null) {
            return null;
        }
        int i4 = dVar.f33773f;
        int i5 = i4 + 1;
        DraggingItemInfo draggingItemInfo = dVar.f33769b;
        int i6 = draggingItemInfo.width;
        int i7 = ((i6 / 2) + i4) - 1;
        int i8 = (i4 + i6) - 2;
        int i9 = dVar.f33774g;
        int i10 = i9 + 1;
        int i11 = draggingItemInfo.height;
        int i12 = ((i11 / 2) + i9) - 1;
        int i13 = (i9 + i11) - 2;
        if (dVar.f33778k) {
            float f4 = i12;
            viewHolder = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, i5, f4);
            viewHolder2 = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, i8, f4);
            viewHolder3 = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, i7, f4);
        } else {
            float f5 = i7;
            RecyclerView.ViewHolder findChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, f5, i10);
            RecyclerView.ViewHolder findChildViewHolderUnderWithoutTranslation2 = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, f5, i12);
            RecyclerView.ViewHolder findChildViewHolderUnderWithoutTranslation3 = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(dVar.f33768a, f5, i13);
            viewHolder = findChildViewHolderUnderWithoutTranslation;
            viewHolder2 = findChildViewHolderUnderWithoutTranslation2;
            viewHolder3 = findChildViewHolderUnderWithoutTranslation3;
        }
        if (viewHolder3 == dVar.f33770c) {
            return null;
        }
        if (viewHolder3 != viewHolder && viewHolder3 != viewHolder2) {
            return null;
        }
        return viewHolder3;
    }

    private void n(boolean z3) {
        int i4;
        int i5;
        if (!isDragging()) {
            return;
        }
        e eVar = this.W;
        if (eVar != null) {
            eVar.d();
            this.W.e();
        }
        RecyclerView recyclerView = this.f33733a;
        if (recyclerView != null && this.B != null) {
            recyclerView.setOverScrollMode(this.T);
        }
        com.h6ah4i.android.widget.advrecyclerview.draggable.d dVar = this.D;
        if (dVar != null) {
            dVar.e(this.f33761w);
            this.D.f(this.f33762x);
            this.D.k(true);
        }
        com.h6ah4i.android.widget.advrecyclerview.draggable.g gVar = this.E;
        if (gVar != null) {
            gVar.e(this.f33761w);
            this.D.f(this.f33762x);
            this.E.i(true);
        }
        com.h6ah4i.android.widget.advrecyclerview.draggable.b bVar = this.f33743f;
        if (bVar != null) {
            bVar.i();
        }
        W();
        RecyclerView recyclerView2 = this.f33733a;
        if (recyclerView2 != null && recyclerView2.getParent() != null) {
            this.f33733a.getParent().requestDisallowInterceptTouchEvent(false);
        }
        RecyclerView recyclerView3 = this.f33733a;
        if (recyclerView3 != null) {
            recyclerView3.invalidate();
        }
        this.U = null;
        this.V = null;
        this.D = null;
        this.E = null;
        this.B = null;
        this.C = null;
        this.f33738c0 = null;
        this.F = null;
        this.I = 0;
        this.J = 0;
        this.G = 0;
        this.H = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.Y = false;
        this.Z = false;
        com.h6ah4i.android.widget.advrecyclerview.draggable.c cVar = this.A;
        if (cVar != null) {
            i4 = cVar.m();
            i5 = this.A.l();
            this.A.r(i4, i5, z3);
        } else {
            i4 = -1;
            i5 = -1;
        }
        OnItemDragEventListener onItemDragEventListener = this.X;
        if (onItemDragEventListener != null) {
            onItemDragEventListener.onItemDragFinished(i4, i5, z3);
        }
    }

    private static Integer p(View view, boolean z3) {
        int left;
        if (view != null) {
            if (z3) {
                left = view.getTop();
            } else {
                left = view.getLeft();
            }
            return Integer.valueOf(left);
        }
        return null;
    }

    private int q() {
        int i4 = this.I;
        NestedScrollView nestedScrollView = this.F;
        if (nestedScrollView != null) {
            return i4 + (nestedScrollView.getScrollX() - this.G);
        }
        return i4;
    }

    private int r() {
        int i4 = this.J;
        NestedScrollView nestedScrollView = this.F;
        if (nestedScrollView != null) {
            return i4 + (nestedScrollView.getScrollY() - this.H);
        }
        return i4;
    }

    private int t(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return -1;
        }
        return WrapperAdapterUtils.unwrapPosition(this.f33733a.getAdapter(), this.A, this.f33738c0, viewHolder.getAdapterPosition());
    }

    private boolean u(RecyclerView recyclerView, MotionEvent motionEvent) {
        boolean z3;
        RecyclerView.ViewHolder findChildViewHolderUnderWithoutTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithoutTranslation(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (!e(recyclerView, findChildViewHolderUnderWithoutTranslation)) {
            return false;
        }
        int x3 = (int) (motionEvent.getX() + 0.5f);
        int y3 = (int) (motionEvent.getY() + 0.5f);
        if (!a(findChildViewHolderUnderWithoutTranslation, x3, y3)) {
            return false;
        }
        int orientation = CustomRecyclerViewUtils.getOrientation(this.f33733a);
        int spanCount = CustomRecyclerViewUtils.getSpanCount(this.f33733a);
        this.I = x3;
        this.f33749k = x3;
        this.J = y3;
        this.f33750l = y3;
        this.f33751m = findChildViewHolderUnderWithoutTranslation.getItemId();
        boolean z4 = true;
        if (orientation != 0 && (orientation != 1 || spanCount <= 1)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.Y = z3;
        if (orientation != 1 && (orientation != 0 || spanCount <= 1)) {
            z4 = false;
        }
        this.Z = z4;
        if (this.f33753o) {
            return c(recyclerView, motionEvent, false);
        }
        if (!this.f33752n) {
            return false;
        }
        this.W.h(motionEvent, this.f33755q);
        return false;
    }

    private void v(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i4;
        int i5;
        this.I = (int) (motionEvent.getX() + 0.5f);
        this.J = (int) (motionEvent.getY() + 0.5f);
        NestedScrollView nestedScrollView = this.F;
        if (nestedScrollView != null) {
            i4 = nestedScrollView.getScrollX();
        } else {
            i4 = 0;
        }
        this.G = i4;
        NestedScrollView nestedScrollView2 = this.F;
        if (nestedScrollView2 != null) {
            i5 = nestedScrollView2.getScrollY();
        } else {
            i5 = 0;
        }
        this.H = i5;
        this.M = Math.min(this.M, this.I);
        this.N = Math.min(this.N, this.J);
        this.O = Math.max(this.O, this.I);
        this.P = Math.max(this.P, this.J);
        Z();
        if (this.D.F(q(), r(), false)) {
            com.h6ah4i.android.widget.advrecyclerview.draggable.g gVar = this.E;
            if (gVar != null) {
                gVar.n(this.D.n(), this.D.o());
            }
            d(recyclerView);
            G();
        }
    }

    private boolean w(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f33754p) {
            return c(recyclerView, motionEvent, true);
        }
        return false;
    }

    private boolean x(int i4, boolean z3) {
        boolean z4 = true;
        if (i4 != 1) {
            z4 = false;
        }
        boolean isDragging = isDragging();
        e eVar = this.W;
        if (eVar != null) {
            eVar.a();
        }
        this.f33749k = 0;
        this.f33750l = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.f33751m = -1L;
        this.Y = false;
        this.Z = false;
        if (z3 && isDragging()) {
            n(z4);
        }
        return isDragging;
    }

    void A() {
        RecyclerView recyclerView = this.f33733a;
        int orientation = CustomRecyclerViewUtils.getOrientation(recyclerView);
        boolean z3 = true;
        if (orientation != 0) {
            if (orientation != 1) {
                return;
            }
            z3 = false;
        }
        if (this.F != null) {
            B(recyclerView, z3);
        } else {
            C(recyclerView, z3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000d, code lost:
        if (r0 != 3) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean F(androidx.recyclerview.widget.RecyclerView r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            int r0 = r5.getActionMasked()
            if (r0 == 0) goto L26
            r1 = 1
            if (r0 == r1) goto L21
            r2 = 2
            if (r0 == r2) goto L10
            r4 = 3
            if (r0 == r4) goto L21
            goto L31
        L10:
            boolean r0 = r3.isDragging()
            if (r0 == 0) goto L1a
            r3.v(r4, r5)
            goto L32
        L1a:
            boolean r4 = r3.w(r4, r5)
            if (r4 == 0) goto L31
            goto L32
        L21:
            boolean r1 = r3.x(r0, r1)
            goto L32
        L26:
            boolean r0 = r3.isDragging()
            if (r0 != 0) goto L31
            boolean r1 = r3.u(r4, r5)
            goto L32
        L31:
            r1 = 0
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.F(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == this.B) {
            E();
            return;
        }
        com.h6ah4i.android.widget.advrecyclerview.draggable.g gVar = this.E;
        if (gVar != null) {
            gVar.j(viewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(RecyclerView.ViewHolder viewHolder) {
        if (this.B != null) {
            E();
        }
        this.B = viewHolder;
        this.D.A(viewHolder);
    }

    void J(boolean z3) {
        if (z3) {
            b(true);
        }
    }

    void K(RecyclerView recyclerView, int i4) {
        if (i4 == 1) {
            b(true);
        }
    }

    void L(RecyclerView recyclerView, int i4, int i5) {
        if (this.f33757s) {
            this.f33758t = i4;
            this.f33759u = i5;
        } else if (isDragging()) {
            ViewCompat.postOnAnimationDelayed(this.f33733a, this.f33744f0, 500L);
        }
    }

    void M(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!isDragging()) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    return;
                }
            } else {
                v(recyclerView, motionEvent);
                return;
            }
        }
        x(actionMasked, true);
    }

    public void attachRecyclerView(@NonNull RecyclerView recyclerView) {
        if (!isReleased()) {
            if (this.f33733a == null) {
                this.f33733a = recyclerView;
                recyclerView.addOnScrollListener(this.f33741e);
                this.f33733a.addOnItemTouchListener(this.f33739d);
                this.f33746h = this.f33733a.getResources().getDisplayMetrics().density;
                int scaledTouchSlop = ViewConfiguration.get(this.f33733a.getContext()).getScaledTouchSlop();
                this.f33747i = scaledTouchSlop;
                this.f33748j = (int) ((scaledTouchSlop * 1.5f) + 0.5f);
                this.W = new e(this);
                if (X()) {
                    int orientation = CustomRecyclerViewUtils.getOrientation(this.f33733a);
                    if (orientation != 0) {
                        if (orientation == 1) {
                            this.f33743f = new h(this.f33733a);
                        }
                    } else {
                        this.f33743f = new com.h6ah4i.android.widget.advrecyclerview.draggable.f(this.f33733a);
                    }
                    com.h6ah4i.android.widget.advrecyclerview.draggable.b bVar = this.f33743f;
                    if (bVar != null) {
                        bVar.k();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
        throw new IllegalStateException("Accessing released object");
    }

    void b(boolean z3) {
        x(3, false);
        if (z3) {
            n(false);
        } else if (isDragging()) {
            this.W.f();
        }
    }

    public void cancelDrag() {
        b(false);
    }

    @NonNull
    public RecyclerView.Adapter createWrappedAdapter(@NonNull RecyclerView.Adapter adapter) {
        if (adapter.hasStableIds()) {
            if (this.A == null) {
                com.h6ah4i.android.widget.advrecyclerview.draggable.c cVar = new com.h6ah4i.android.widget.advrecyclerview.draggable.c(this, adapter);
                this.A = cVar;
                return cVar;
            }
            throw new IllegalStateException("already have a wrapped adapter");
        }
        throw new IllegalArgumentException("The passed adapter does not support stable IDs");
    }

    void d(RecyclerView recyclerView) {
        RecyclerView.ViewHolder viewHolder;
        int i4;
        RecyclerView.ViewHolder viewHolder2 = this.B;
        d dVar = this.f33742e0;
        dVar.b(recyclerView, viewHolder2, this.C, q(), r(), this.U, this.V, this.f33756r);
        int m4 = this.A.m();
        int l4 = this.A.l();
        boolean z3 = false;
        g h4 = h(this.f33740d0, dVar, false);
        int i5 = h4.f33787b;
        if (i5 != -1) {
            z3 = !this.f33756r;
            if (!z3) {
                z3 = this.A.h(m4, i5);
            }
            if (!z3 && (i4 = (h4 = h(this.f33740d0, dVar, true)).f33787b) != -1) {
                z3 = this.A.h(m4, i4);
            }
        }
        if (z3 && h4.f33786a == null) {
            throw new IllegalStateException("bug check");
        }
        if (z3) {
            Y(recyclerView, l4, viewHolder2, h4.f33786a);
        }
        com.h6ah4i.android.widget.advrecyclerview.draggable.g gVar = this.E;
        if (gVar != null) {
            if (z3) {
                viewHolder = h4.f33786a;
            } else {
                viewHolder = null;
            }
            gVar.k(viewHolder);
        }
        if (z3) {
            this.W.g();
        }
        h4.a();
        dVar.a();
    }

    public float getDragEdgeScrollSpeed() {
        return this.f33734a0;
    }

    @Nullable
    public Interpolator getDragStartItemAlphaAnimationInterpolator() {
        return this.f33764z.f33838g;
    }

    public int getDragStartItemAnimationDuration() {
        return this.f33764z.f33832a;
    }

    @Nullable
    public Interpolator getDragStartItemRotationAnimationInterpolator() {
        return this.f33764z.f33837f;
    }

    @Nullable
    public Interpolator getDragStartItemScaleAnimationInterpolator() {
        return this.f33764z.f33836e;
    }

    public float getDraggingItemAlpha() {
        return this.f33764z.f33835d;
    }

    public float getDraggingItemRotation() {
        return this.f33764z.f33834c;
    }

    public float getDraggingItemScale() {
        return this.f33764z.f33833b;
    }

    public int getItemMoveMode() {
        return this.f33763y;
    }

    public int getItemSettleBackIntoPlaceAnimationDuration() {
        return this.f33761w;
    }

    @Nullable
    public Interpolator getItemSettleBackIntoPlaceAnimationInterpolator() {
        return this.f33762x;
    }

    @Nullable
    public OnItemDragEventListener getOnItemDragEventListener() {
        return this.X;
    }

    public boolean isCheckCanDropEnabled() {
        return this.f33756r;
    }

    public boolean isDragging() {
        if (this.C != null && !this.W.b()) {
            return true;
        }
        return false;
    }

    public boolean isInitiateOnLongPressEnabled() {
        return this.f33752n;
    }

    public boolean isInitiateOnMoveEnabled() {
        return this.f33754p;
    }

    public boolean isInitiateOnTouchEnabled() {
        return this.f33753o;
    }

    public boolean isReleased() {
        if (this.f33739d == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ViewHolder o() {
        return this.B;
    }

    public void release() {
        RecyclerView.OnScrollListener onScrollListener;
        RecyclerView.OnItemTouchListener onItemTouchListener;
        b(true);
        e eVar = this.W;
        if (eVar != null) {
            eVar.c();
            this.W = null;
        }
        com.h6ah4i.android.widget.advrecyclerview.draggable.b bVar = this.f33743f;
        if (bVar != null) {
            bVar.d();
            this.f33743f = null;
        }
        RecyclerView recyclerView = this.f33733a;
        if (recyclerView != null && (onItemTouchListener = this.f33739d) != null) {
            recyclerView.removeOnItemTouchListener(onItemTouchListener);
        }
        this.f33739d = null;
        RecyclerView recyclerView2 = this.f33733a;
        if (recyclerView2 != null && (onScrollListener = this.f33741e) != null) {
            recyclerView2.removeOnScrollListener(onScrollListener);
        }
        this.f33741e = null;
        f fVar = this.f33737c;
        if (fVar != null) {
            fVar.a();
            this.f33737c = null;
        }
        this.A = null;
        this.f33733a = null;
        this.f33735b = null;
    }

    RecyclerView s() {
        return this.f33733a;
    }

    public void setCheckCanDropEnabled(boolean z3) {
        this.f33756r = z3;
    }

    public void setDragEdgeScrollSpeed(float f4) {
        this.f33734a0 = Math.min(Math.max(f4, 0.0f), 2.0f);
    }

    public void setDragStartItemAlphaAnimationInterpolator(Interpolator interpolator) {
        this.f33764z.f33838g = interpolator;
    }

    public void setDragStartItemAnimationDuration(int i4) {
        this.f33764z.f33832a = i4;
    }

    public void setDragStartItemRotationAnimationInterpolator(Interpolator interpolator) {
        this.f33764z.f33837f = interpolator;
    }

    public void setDragStartItemScaleAnimationInterpolator(Interpolator interpolator) {
        this.f33764z.f33836e = interpolator;
    }

    public void setDraggingItemAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.f33764z.f33835d = f4;
    }

    public void setDraggingItemRotation(float f4) {
        this.f33764z.f33834c = f4;
    }

    public void setDraggingItemScale(float f4) {
        this.f33764z.f33833b = f4;
    }

    public void setDraggingItemShadowDrawable(@Nullable NinePatchDrawable ninePatchDrawable) {
        this.f33745g = ninePatchDrawable;
    }

    public void setInitiateOnLongPress(boolean z3) {
        this.f33752n = z3;
    }

    public void setInitiateOnMove(boolean z3) {
        this.f33754p = z3;
    }

    public void setInitiateOnTouch(boolean z3) {
        this.f33753o = z3;
    }

    public void setItemMoveMode(int i4) {
        this.f33763y = i4;
    }

    public void setItemSettleBackIntoPlaceAnimationDuration(int i4) {
        this.f33761w = i4;
    }

    public void setItemSettleBackIntoPlaceAnimationInterpolator(@Nullable Interpolator interpolator) {
        this.f33762x = interpolator;
    }

    public void setLongPressTimeout(int i4) {
        this.f33755q = i4;
    }

    public void setOnItemDragEventListener(@Nullable OnItemDragEventListener onItemDragEventListener) {
        this.X = onItemDragEventListener;
    }

    public void setSwapTargetTranslationInterpolator(@Nullable Interpolator interpolator) {
        this.f33735b = interpolator;
    }

    void y() {
        RecyclerView.ViewHolder findViewHolderForItemId = this.f33733a.findViewHolderForItemId(this.C.id);
        if (findViewHolderForItemId == null) {
            return;
        }
        int width = findViewHolderForItemId.itemView.getWidth();
        int height = findViewHolderForItemId.itemView.getHeight();
        DraggingItemInfo draggingItemInfo = this.C;
        if (width != draggingItemInfo.width || height != draggingItemInfo.height) {
            DraggingItemInfo createWithNewView = DraggingItemInfo.createWithNewView(draggingItemInfo, findViewHolderForItemId);
            this.C = createWithNewView;
            this.D.H(createWithNewView, findViewHolderForItemId);
        }
    }

    void z(MotionEvent motionEvent) {
        if (this.f33752n) {
            c(this.f33733a, motionEvent, false);
        }
    }

    public Interpolator setSwapTargetTranslationInterpolator() {
        return this.f33735b;
    }
}
