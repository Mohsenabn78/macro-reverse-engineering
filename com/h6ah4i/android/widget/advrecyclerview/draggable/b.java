package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseEdgeEffectDecorator.java */
/* loaded from: classes6.dex */
public abstract class b extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f33796a;

    /* renamed from: b  reason: collision with root package name */
    private EdgeEffect f33797b;

    /* renamed from: c  reason: collision with root package name */
    private EdgeEffect f33798c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33799d;

    /* renamed from: e  reason: collision with root package name */
    private int f33800e;

    /* renamed from: f  reason: collision with root package name */
    private int f33801f;

    public b(@NonNull RecyclerView recyclerView) {
        this.f33796a = recyclerView;
    }

    private static boolean a(Canvas canvas, RecyclerView recyclerView, int i4, EdgeEffect edgeEffect) {
        if (edgeEffect.isFinished()) {
            return false;
        }
        int save = canvas.save();
        boolean e4 = e(recyclerView);
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        canvas.rotate(180.0f);
                        if (e4) {
                            canvas.translate((-recyclerView.getWidth()) + recyclerView.getPaddingRight(), (-recyclerView.getHeight()) + recyclerView.getPaddingBottom());
                        } else {
                            canvas.translate(-recyclerView.getWidth(), -recyclerView.getHeight());
                        }
                    }
                } else {
                    canvas.rotate(90.0f);
                    if (e4) {
                        canvas.translate(recyclerView.getPaddingTop(), (-recyclerView.getWidth()) + recyclerView.getPaddingRight());
                    } else {
                        canvas.translate(0.0f, -recyclerView.getWidth());
                    }
                }
            } else if (e4) {
                canvas.translate(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop());
            }
        } else {
            canvas.rotate(-90.0f);
            if (e4) {
                canvas.translate((-recyclerView.getHeight()) + recyclerView.getPaddingTop(), recyclerView.getPaddingLeft());
            } else {
                canvas.translate(-recyclerView.getHeight(), 0.0f);
            }
        }
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private void b(RecyclerView recyclerView) {
        if (this.f33797b == null) {
            this.f33797b = new EdgeEffect(recyclerView.getContext());
        }
        l(recyclerView, this.f33797b, this.f33800e);
    }

    private void c(RecyclerView recyclerView) {
        if (this.f33798c == null) {
            this.f33798c = new EdgeEffect(recyclerView.getContext());
        }
        l(recyclerView, this.f33798c, this.f33801f);
    }

    private static boolean e(RecyclerView recyclerView) {
        return recyclerView.getLayoutManager().getClipToPadding();
    }

    private static void l(RecyclerView recyclerView, EdgeEffect edgeEffect, int i4) {
        int measuredWidth = recyclerView.getMeasuredWidth();
        int measuredHeight = recyclerView.getMeasuredHeight();
        if (e(recyclerView)) {
            measuredWidth -= recyclerView.getPaddingLeft() + recyclerView.getPaddingRight();
            measuredHeight -= recyclerView.getPaddingTop() + recyclerView.getPaddingBottom();
        }
        int max = Math.max(0, measuredWidth);
        int max2 = Math.max(0, measuredHeight);
        if (i4 == 0 || i4 == 2) {
            max = max2;
            max2 = max;
        }
        edgeEffect.setSize(max, max2);
    }

    public void d() {
        if (this.f33799d) {
            this.f33796a.removeItemDecoration(this);
        }
        i();
        this.f33796a = null;
        this.f33799d = false;
    }

    protected abstract int f(int i4);

    public void g(float f4) {
        b(this.f33796a);
        EdgeEffectCompat.onPull(this.f33797b, f4, 0.5f);
        ViewCompat.postInvalidateOnAnimation(this.f33796a);
    }

    public void h(float f4) {
        c(this.f33796a);
        EdgeEffectCompat.onPull(this.f33798c, f4, 0.5f);
        ViewCompat.postInvalidateOnAnimation(this.f33796a);
    }

    public void i() {
        EdgeEffect edgeEffect = this.f33797b;
        boolean z3 = false;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z3 = false | this.f33797b.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f33798c;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z3 |= this.f33798c.isFinished();
        }
        if (z3) {
            ViewCompat.postInvalidateOnAnimation(this.f33796a);
        }
    }

    public void j() {
        if (this.f33799d) {
            this.f33796a.removeItemDecoration(this);
            this.f33796a.addItemDecoration(this);
        }
    }

    public void k() {
        if (this.f33799d) {
            return;
        }
        this.f33800e = f(0);
        this.f33801f = f(1);
        this.f33796a.addItemDecoration(this);
        this.f33799d = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        EdgeEffect edgeEffect = this.f33797b;
        boolean z3 = false;
        if (edgeEffect != null) {
            z3 = false | a(canvas, recyclerView, this.f33800e, edgeEffect);
        }
        EdgeEffect edgeEffect2 = this.f33798c;
        if (edgeEffect2 != null) {
            z3 |= a(canvas, recyclerView, this.f33801f, edgeEffect2);
        }
        if (z3) {
            ViewCompat.postInvalidateOnAnimation(recyclerView);
        }
    }
}
