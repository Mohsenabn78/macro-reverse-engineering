package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapTargetItemOperator.java */
/* loaded from: classes6.dex */
public class g extends com.h6ah4i.android.widget.advrecyclerview.draggable.a {

    /* renamed from: r  reason: collision with root package name */
    private static final ViewPropertyAnimatorListener f33839r = new a();

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.ViewHolder f33840f;

    /* renamed from: g  reason: collision with root package name */
    private Interpolator f33841g;

    /* renamed from: h  reason: collision with root package name */
    private int f33842h;

    /* renamed from: i  reason: collision with root package name */
    private int f33843i;

    /* renamed from: j  reason: collision with root package name */
    private final Rect f33844j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f33845k;

    /* renamed from: l  reason: collision with root package name */
    private final Rect f33846l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f33847m;

    /* renamed from: n  reason: collision with root package name */
    private float f33848n;

    /* renamed from: o  reason: collision with root package name */
    private float f33849o;

    /* renamed from: p  reason: collision with root package name */
    private DraggingItemInfo f33850p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f33851q;

    public g(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, DraggingItemInfo draggingItemInfo) {
        super(recyclerView, viewHolder);
        this.f33844j = new Rect();
        this.f33845k = new Rect();
        Rect rect = new Rect();
        this.f33846l = rect;
        this.f33850p = draggingItemInfo;
        CustomRecyclerViewUtils.getDecorationOffsets(this.f33792d.getLayoutManager(), this.f33793e.itemView, rect);
    }

    private static float g(float f4, float f5) {
        float f6 = (f4 * 0.7f) + (0.3f * f5);
        if (Math.abs(f6 - f5) >= 0.01f) {
            return f6;
        }
        return f5;
    }

    private float h(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        float f4;
        float f5;
        View view = viewHolder2.itemView;
        int layoutPosition = viewHolder.getLayoutPosition();
        int layoutPosition2 = viewHolder2.getLayoutPosition();
        CustomRecyclerViewUtils.getDecorationOffsets(this.f33792d.getLayoutManager(), view, this.f33844j);
        CustomRecyclerViewUtils.getLayoutMargins(view, this.f33845k);
        Rect rect = this.f33845k;
        Rect rect2 = this.f33844j;
        int height = view.getHeight() + rect.top + rect.bottom + rect2.top + rect2.bottom;
        int width = view.getWidth() + rect.left + rect.right + rect2.left + rect2.right;
        float left = viewHolder.itemView.getLeft() - this.f33842h;
        if (width != 0) {
            f4 = left / width;
        } else {
            f4 = 0.0f;
        }
        float top = viewHolder.itemView.getTop() - this.f33843i;
        if (height != 0) {
            f5 = top / height;
        } else {
            f5 = 0.0f;
        }
        int orientation = CustomRecyclerViewUtils.getOrientation(this.f33792d);
        if (orientation == 1) {
            if (layoutPosition > layoutPosition2) {
                f4 = f5;
            } else {
                f4 = f5 + 1.0f;
            }
        } else if (orientation == 0) {
            if (layoutPosition <= layoutPosition2) {
                f4 += 1.0f;
            }
        } else {
            f4 = 0.0f;
        }
        return Math.min(Math.max(f4, 0.0f), 1.0f);
    }

    private void o(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, float f4) {
        View view = viewHolder2.itemView;
        int layoutPosition = viewHolder.getLayoutPosition();
        int layoutPosition2 = viewHolder2.getLayoutPosition();
        DraggingItemInfo draggingItemInfo = this.f33850p;
        Rect rect = draggingItemInfo.margins;
        Rect rect2 = this.f33846l;
        int i4 = draggingItemInfo.height + rect.top + rect.bottom + rect2.top + rect2.bottom;
        int i5 = draggingItemInfo.width + rect.left + rect.right + rect2.left + rect2.right;
        Interpolator interpolator = this.f33841g;
        if (interpolator != null) {
            f4 = interpolator.getInterpolation(f4);
        }
        int orientation = CustomRecyclerViewUtils.getOrientation(this.f33792d);
        if (orientation != 0) {
            if (orientation == 1) {
                if (layoutPosition > layoutPosition2) {
                    view.setTranslationY(f4 * i4);
                } else {
                    view.setTranslationY((f4 - 1.0f) * i4);
                }
            }
        } else if (layoutPosition > layoutPosition2) {
            view.setTranslationX(f4 * i5);
        } else {
            view.setTranslationX((f4 - 1.0f) * i5);
        }
    }

    public void i(boolean z3) {
        if (this.f33847m) {
            this.f33792d.removeItemDecoration(this);
        }
        RecyclerView.ItemAnimator itemAnimator = this.f33792d.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        this.f33792d.stopScroll();
        RecyclerView.ViewHolder viewHolder = this.f33840f;
        if (viewHolder != null) {
            o(this.f33793e, viewHolder, this.f33849o);
            b(this.f33840f.itemView, 1.0f, 1.0f, 0.0f, 1.0f, z3);
            this.f33840f = null;
        }
        this.f33793e = null;
        this.f33842h = 0;
        this.f33843i = 0;
        this.f33849o = 0.0f;
        this.f33848n = 0.0f;
        this.f33847m = false;
        this.f33850p = null;
    }

    public void j(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == this.f33840f) {
            k(null);
        }
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = this.f33840f;
        if (viewHolder2 == viewHolder) {
            return;
        }
        if (viewHolder2 != null) {
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder2.itemView);
            animate.cancel();
            animate.setDuration(10L).translationX(0.0f).translationY(0.0f).setListener(f33839r).start();
        }
        this.f33840f = viewHolder;
        if (viewHolder != null) {
            ViewCompat.animate(viewHolder.itemView).cancel();
        }
        this.f33851q = true;
    }

    public void l(Interpolator interpolator) {
        this.f33841g = interpolator;
    }

    public void m() {
        if (this.f33847m) {
            return;
        }
        this.f33792d.addItemDecoration(this, 0);
        this.f33847m = true;
    }

    public void n(int i4, int i5) {
        this.f33842h = i4;
        this.f33843i = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        RecyclerView.ViewHolder viewHolder = this.f33793e;
        RecyclerView.ViewHolder viewHolder2 = this.f33840f;
        if (viewHolder != null && viewHolder2 != null && viewHolder.getItemId() == this.f33850p.id) {
            float h4 = h(viewHolder, viewHolder2);
            this.f33848n = h4;
            if (this.f33851q) {
                this.f33851q = false;
                this.f33849o = h4;
            } else {
                this.f33849o = g(this.f33849o, h4);
            }
            o(viewHolder, viewHolder2, this.f33849o);
        }
    }

    /* compiled from: SwapTargetItemOperator.java */
    /* loaded from: classes6.dex */
    static class a implements ViewPropertyAnimatorListener {
        a() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            ViewCompat.animate(view).setListener(null);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
        }
    }
}
