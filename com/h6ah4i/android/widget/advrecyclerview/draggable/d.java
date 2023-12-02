package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DraggingItemDecorator.java */
/* loaded from: classes6.dex */
public class d extends a {
    private float A;
    private float B;
    private float C;
    private float D;
    private Interpolator E;
    private Interpolator F;
    private Interpolator G;
    private float H;
    private float I;
    private float J;
    private float K;

    /* renamed from: f  reason: collision with root package name */
    private int f33811f;

    /* renamed from: g  reason: collision with root package name */
    private int f33812g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f33813h;

    /* renamed from: i  reason: collision with root package name */
    private int f33814i;

    /* renamed from: j  reason: collision with root package name */
    private int f33815j;

    /* renamed from: k  reason: collision with root package name */
    private int f33816k;

    /* renamed from: l  reason: collision with root package name */
    private int f33817l;

    /* renamed from: m  reason: collision with root package name */
    private int f33818m;

    /* renamed from: n  reason: collision with root package name */
    private int f33819n;

    /* renamed from: o  reason: collision with root package name */
    private NinePatchDrawable f33820o;

    /* renamed from: p  reason: collision with root package name */
    private final Rect f33821p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f33822q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f33823r;

    /* renamed from: s  reason: collision with root package name */
    private ItemDraggableRange f33824s;

    /* renamed from: t  reason: collision with root package name */
    private int f33825t;

    /* renamed from: u  reason: collision with root package name */
    private int f33826u;

    /* renamed from: v  reason: collision with root package name */
    private DraggingItemInfo f33827v;

    /* renamed from: w  reason: collision with root package name */
    private Paint f33828w;

    /* renamed from: x  reason: collision with root package name */
    private long f33829x;

    /* renamed from: y  reason: collision with root package name */
    private long f33830y;

    /* renamed from: z  reason: collision with root package name */
    private float f33831z;

    public d(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, ItemDraggableRange itemDraggableRange) {
        super(recyclerView, viewHolder);
        this.f33821p = new Rect();
        this.f33830y = 0L;
        this.f33831z = 1.0f;
        this.A = 0.0f;
        this.B = 1.0f;
        this.E = null;
        this.F = null;
        this.G = null;
        this.f33824s = itemDraggableRange;
        this.f33828w = new Paint();
    }

    private void G(float f4, int i4) {
        RecyclerView.ViewHolder viewHolder = this.f33793e;
        if (viewHolder != null) {
            a.d(this.f33792d, viewHolder, f4 - viewHolder.itemView.getLeft(), i4 - this.f33793e.itemView.getTop());
        }
    }

    private void I() {
        RecyclerView recyclerView = this.f33792d;
        if (recyclerView.getChildCount() > 0) {
            this.f33814i = 0;
            this.f33815j = recyclerView.getWidth() - this.f33827v.width;
            this.f33816k = 0;
            int height = recyclerView.getHeight();
            int i4 = this.f33827v.height;
            this.f33817l = height - i4;
            int i5 = this.f33825t;
            if (i5 != 0) {
                if (i5 == 1) {
                    this.f33816k = -i4;
                    this.f33817l = recyclerView.getHeight();
                    this.f33814i += recyclerView.getPaddingLeft();
                    this.f33815j -= recyclerView.getPaddingRight();
                }
            } else {
                this.f33816k += recyclerView.getPaddingTop();
                this.f33817l -= recyclerView.getPaddingBottom();
                this.f33814i = -this.f33827v.width;
                this.f33815j = recyclerView.getWidth();
            }
            this.f33815j = Math.max(this.f33814i, this.f33815j);
            this.f33817l = Math.max(this.f33816k, this.f33817l);
            if (!this.f33823r) {
                int findFirstVisibleItemPosition = CustomRecyclerViewUtils.findFirstVisibleItemPosition(recyclerView, true);
                int findLastVisibleItemPosition = CustomRecyclerViewUtils.findLastVisibleItemPosition(recyclerView, true);
                View i6 = i(recyclerView, this.f33824s, findFirstVisibleItemPosition, findLastVisibleItemPosition);
                View j4 = j(recyclerView, this.f33824s, findFirstVisibleItemPosition, findLastVisibleItemPosition);
                int i7 = this.f33825t;
                if (i7 != 0) {
                    if (i7 == 1) {
                        if (i6 != null) {
                            this.f33816k = Math.min(this.f33817l, i6.getTop());
                        }
                        if (j4 != null) {
                            this.f33817l = Math.min(this.f33817l, Math.max(0, j4.getBottom() - this.f33827v.height));
                        }
                    }
                } else {
                    if (i6 != null) {
                        this.f33814i = Math.min(this.f33814i, i6.getLeft());
                    }
                    if (j4 != null) {
                        this.f33815j = Math.min(this.f33815j, Math.max(0, j4.getRight() - this.f33827v.width));
                    }
                }
            }
        } else {
            int paddingLeft = recyclerView.getPaddingLeft();
            this.f33814i = paddingLeft;
            this.f33815j = paddingLeft;
            int paddingTop = recyclerView.getPaddingTop();
            this.f33816k = paddingTop;
            this.f33817l = paddingTop;
        }
        int i8 = this.f33818m;
        DraggingItemInfo draggingItemInfo = this.f33827v;
        this.f33811f = i8 - draggingItemInfo.grabbedPositionX;
        this.f33812g = this.f33819n - draggingItemInfo.grabbedPositionY;
        if (CustomRecyclerViewUtils.isLinearLayout(this.f33826u)) {
            this.f33811f = g(this.f33811f, this.f33814i, this.f33815j);
            this.f33812g = g(this.f33812g, this.f33816k, this.f33817l);
        }
    }

    private static int g(int i4, int i5, int i6) {
        return Math.min(Math.max(i4, i5), i6);
    }

    private Bitmap h(View view, NinePatchDrawable ninePatchDrawable) {
        int top = view.getTop();
        int left = view.getLeft();
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = this.f33821p;
        int i4 = rect.left + width + rect.right;
        int i5 = rect.top + height + rect.bottom;
        view.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        view.layout(left, top, width + left, height + top);
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (ninePatchDrawable != null) {
            ninePatchDrawable.setBounds(0, 0, i4, i5);
            ninePatchDrawable.draw(canvas);
        }
        int save = canvas.save();
        Rect rect2 = this.f33821p;
        canvas.clipRect(rect2.left, rect2.top, i4 - rect2.right, i5 - rect2.bottom);
        Rect rect3 = this.f33821p;
        canvas.translate(rect3.left, rect3.top);
        view.draw(canvas);
        canvas.restoreToCount(save);
        return createBitmap;
    }

    private static View i(RecyclerView recyclerView, ItemDraggableRange itemDraggableRange, int i4, int i5) {
        int layoutPosition;
        if (i4 == -1 || i5 == -1) {
            return null;
        }
        int childCount = recyclerView.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = recyclerView.getChildAt(i6);
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
            if (childViewHolder != null && (layoutPosition = childViewHolder.getLayoutPosition()) >= i4 && layoutPosition <= i5 && itemDraggableRange.checkInRange(layoutPosition)) {
                return childAt;
            }
        }
        return null;
    }

    private static View j(RecyclerView recyclerView, ItemDraggableRange itemDraggableRange, int i4, int i5) {
        int layoutPosition;
        if (i4 == -1 || i5 == -1) {
            return null;
        }
        for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = recyclerView.getChildAt(childCount);
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
            if (childViewHolder != null && (layoutPosition = childViewHolder.getLayoutPosition()) >= i4 && layoutPosition <= i5 && itemDraggableRange.checkInRange(layoutPosition)) {
                return childAt;
            }
        }
        return null;
    }

    private static float p(Interpolator interpolator, float f4) {
        if (interpolator != null) {
            return interpolator.getInterpolation(f4);
        }
        return f4;
    }

    public void A(RecyclerView.ViewHolder viewHolder) {
        if (this.f33793e == null) {
            this.f33793e = viewHolder;
            viewHolder.itemView.setVisibility(4);
            return;
        }
        throw new IllegalStateException("A new view holder is attempt to be assigned before invalidating the older one");
    }

    public void B(boolean z3) {
        if (this.f33823r == z3) {
            return;
        }
        this.f33823r = z3;
    }

    public void C(NinePatchDrawable ninePatchDrawable) {
        this.f33820o = ninePatchDrawable;
        if (ninePatchDrawable != null) {
            ninePatchDrawable.getPadding(this.f33821p);
        }
    }

    public void D(e eVar) {
        this.f33830y = eVar.f33832a;
        this.f33831z = eVar.f33833b;
        this.E = eVar.f33836e;
        this.A = eVar.f33834c;
        this.F = eVar.f33837f;
        this.B = eVar.f33835d;
        this.G = eVar.f33838g;
    }

    public void E(DraggingItemInfo draggingItemInfo, int i4, int i5) {
        if (this.f33822q) {
            return;
        }
        View view = this.f33793e.itemView;
        this.f33827v = draggingItemInfo;
        this.f33813h = h(view, this.f33820o);
        this.f33814i = this.f33792d.getPaddingLeft();
        this.f33816k = this.f33792d.getPaddingTop();
        this.f33825t = CustomRecyclerViewUtils.getOrientation(this.f33792d);
        this.f33826u = CustomRecyclerViewUtils.getLayoutType(this.f33792d);
        this.C = view.getScaleX();
        this.D = view.getScaleY();
        this.H = 1.0f;
        this.I = 1.0f;
        this.J = 0.0f;
        this.K = 1.0f;
        view.setVisibility(4);
        F(i4, i5, true);
        this.f33792d.addItemDecoration(this);
        this.f33829x = System.currentTimeMillis();
        this.f33822q = true;
    }

    public boolean F(int i4, int i5, boolean z3) {
        this.f33818m = i4;
        this.f33819n = i5;
        return z(z3);
    }

    public void H(DraggingItemInfo draggingItemInfo, RecyclerView.ViewHolder viewHolder) {
        if (!this.f33822q) {
            return;
        }
        if (this.f33793e != viewHolder) {
            u();
            this.f33793e = viewHolder;
        }
        this.f33813h = h(viewHolder.itemView, this.f33820o);
        this.f33827v = draggingItemInfo;
        z(true);
    }

    public void k(boolean z3) {
        if (this.f33822q) {
            this.f33792d.removeItemDecoration(this);
        }
        RecyclerView.ItemAnimator itemAnimator = this.f33792d.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        this.f33792d.stopScroll();
        G(this.f33811f, this.f33812g);
        RecyclerView.ViewHolder viewHolder = this.f33793e;
        if (viewHolder != null) {
            b(viewHolder.itemView, this.H, this.I, this.J, this.K, z3);
        }
        RecyclerView.ViewHolder viewHolder2 = this.f33793e;
        if (viewHolder2 != null) {
            viewHolder2.itemView.setVisibility(0);
        }
        this.f33793e = null;
        Bitmap bitmap = this.f33813h;
        if (bitmap != null) {
            bitmap.recycle();
            this.f33813h = null;
        }
        this.f33824s = null;
        this.f33811f = 0;
        this.f33812g = 0;
        this.f33814i = 0;
        this.f33815j = 0;
        this.f33816k = 0;
        this.f33817l = 0;
        this.f33818m = 0;
        this.f33819n = 0;
        this.f33822q = false;
    }

    public int l() {
        return this.f33811f - this.f33827v.initialItemLeft;
    }

    public int m() {
        return this.f33812g - this.f33827v.initialItemTop;
    }

    public int n() {
        return this.f33811f;
    }

    public int o() {
        return this.f33812g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        float f4;
        if (this.f33813h == null) {
            return;
        }
        int min = (int) Math.min(System.currentTimeMillis() - this.f33829x, this.f33830y);
        long j4 = this.f33830y;
        if (j4 > 0) {
            f4 = min / ((float) j4);
        } else {
            f4 = 1.0f;
        }
        float p4 = p(this.E, f4);
        float f5 = this.f33831z;
        float f6 = this.C;
        float f7 = ((f5 - f6) * p4) + f6;
        float f8 = this.D;
        float f9 = (p4 * (f5 - f8)) + f8;
        float p5 = (p(this.G, f4) * (this.B - 1.0f)) + 1.0f;
        float p6 = p(this.F, f4) * this.A;
        if (f7 > 0.0f && f9 > 0.0f && p5 > 0.0f) {
            this.f33828w.setAlpha((int) (255.0f * p5));
            int save = canvas.save();
            int i4 = this.f33811f;
            DraggingItemInfo draggingItemInfo = this.f33827v;
            canvas.translate(i4 + draggingItemInfo.grabbedPositionX, this.f33812g + draggingItemInfo.grabbedPositionY);
            canvas.scale(f7, f9);
            canvas.rotate(p6);
            Rect rect = this.f33821p;
            int i5 = rect.left;
            DraggingItemInfo draggingItemInfo2 = this.f33827v;
            canvas.translate(-(i5 + draggingItemInfo2.grabbedPositionX), -(rect.top + draggingItemInfo2.grabbedPositionY));
            canvas.drawBitmap(this.f33813h, 0.0f, 0.0f, this.f33828w);
            canvas.restoreToCount(save);
        }
        if (f4 < 1.0f) {
            ViewCompat.postInvalidateOnAnimation(this.f33792d);
        }
        this.H = f7;
        this.I = f9;
        this.J = p6;
        this.K = p5;
    }

    public int q() {
        return this.f33812g + this.f33827v.height;
    }

    public int r() {
        return this.f33811f;
    }

    public int s() {
        return this.f33811f + this.f33827v.width;
    }

    public int t() {
        return this.f33812g;
    }

    public void u() {
        RecyclerView.ViewHolder viewHolder = this.f33793e;
        if (viewHolder != null) {
            viewHolder.itemView.setTranslationX(0.0f);
            this.f33793e.itemView.setTranslationY(0.0f);
            this.f33793e.itemView.setVisibility(0);
        }
        this.f33793e = null;
    }

    public boolean v() {
        if (this.f33812g == this.f33817l) {
            return true;
        }
        return false;
    }

    public boolean w() {
        if (this.f33811f == this.f33814i) {
            return true;
        }
        return false;
    }

    public boolean x() {
        if (this.f33811f == this.f33815j) {
            return true;
        }
        return false;
    }

    public boolean y() {
        if (this.f33812g == this.f33816k) {
            return true;
        }
        return false;
    }

    public boolean z(boolean z3) {
        boolean z4;
        int i4 = this.f33811f;
        int i5 = this.f33812g;
        I();
        int i6 = this.f33811f;
        if (i4 == i6 && i5 == this.f33812g) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4 || z3) {
            G(i6, this.f33812g);
            ViewCompat.postInvalidateOnAnimation(this.f33792d);
        }
        return z4;
    }
}
