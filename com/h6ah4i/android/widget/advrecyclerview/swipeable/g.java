package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SwipingItemOperator.java */
/* loaded from: classes6.dex */
class g {

    /* renamed from: r  reason: collision with root package name */
    private static final Interpolator f33976r = new c(0.15f);

    /* renamed from: a  reason: collision with root package name */
    private RecyclerViewSwipeManager f33977a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView.ViewHolder f33978b;

    /* renamed from: c  reason: collision with root package name */
    private View f33979c;

    /* renamed from: d  reason: collision with root package name */
    private int f33980d;

    /* renamed from: e  reason: collision with root package name */
    private int f33981e;

    /* renamed from: f  reason: collision with root package name */
    private int f33982f;

    /* renamed from: g  reason: collision with root package name */
    private int f33983g;

    /* renamed from: h  reason: collision with root package name */
    private int f33984h;

    /* renamed from: i  reason: collision with root package name */
    private final int f33985i;

    /* renamed from: j  reason: collision with root package name */
    private float f33986j;

    /* renamed from: k  reason: collision with root package name */
    private float f33987k;

    /* renamed from: l  reason: collision with root package name */
    private int f33988l;

    /* renamed from: m  reason: collision with root package name */
    private int f33989m;

    /* renamed from: n  reason: collision with root package name */
    private float f33990n;

    /* renamed from: o  reason: collision with root package name */
    private int f33991o;

    /* renamed from: p  reason: collision with root package name */
    private int f33992p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f33993q;

    public g(RecyclerViewSwipeManager recyclerViewSwipeManager, RecyclerView.ViewHolder viewHolder, int i4, boolean z3) {
        this.f33977a = recyclerViewSwipeManager;
        this.f33978b = viewHolder;
        this.f33980d = d.f(i4);
        this.f33981e = d.h(i4);
        this.f33982f = d.g(i4);
        this.f33983g = d.e(i4);
        this.f33993q = z3;
        View a4 = f.a(viewHolder);
        this.f33979c = a4;
        this.f33984h = a4.getWidth();
        int height = this.f33979c.getHeight();
        this.f33985i = height;
        this.f33986j = a(this.f33984h);
        this.f33987k = a(height);
    }

    private static float a(int i4) {
        if (i4 != 0) {
            return 1.0f / i4;
        }
        return 0.0f;
    }

    private static int b(int i4, int i5, int i6) {
        return Math.min(Math.max(i4, i5), i6);
    }

    public void c() {
        this.f33977a = null;
        this.f33978b = null;
        this.f33988l = 0;
        this.f33989m = 0;
        this.f33984h = 0;
        this.f33986j = 0.0f;
        this.f33987k = 0.0f;
        this.f33980d = 0;
        this.f33981e = 0;
        this.f33982f = 0;
        this.f33983g = 0;
        this.f33990n = 0.0f;
        this.f33991o = 0;
        this.f33992p = 0;
        this.f33979c = null;
    }

    public void d() {
        int i4 = (int) (this.f33978b.itemView.getResources().getDisplayMetrics().density * 48.0f);
        int max = Math.max(0, this.f33984h - i4);
        int max2 = Math.max(0, this.f33985i - i4);
        this.f33991o = b(this.f33977a.i(this.f33978b), -max, max);
        this.f33992p = b(this.f33977a.j(this.f33978b), -max2, max2);
    }

    public void e(int i4, int i5, int i6) {
        int i7;
        int i8;
        float f4;
        int i9;
        float signum;
        if (this.f33988l == i5 && this.f33989m == i6) {
            return;
        }
        this.f33988l = i5;
        this.f33989m = i6;
        boolean z3 = this.f33993q;
        if (z3) {
            i7 = i5 + this.f33991o;
        } else {
            i7 = this.f33992p + i6;
        }
        if (z3) {
            i8 = this.f33984h;
        } else {
            i8 = this.f33985i;
        }
        if (z3) {
            f4 = this.f33986j;
        } else {
            f4 = this.f33987k;
        }
        if (z3) {
            if (i7 > 0) {
                i9 = this.f33982f;
            } else {
                i9 = this.f33980d;
            }
        } else if (i7 > 0) {
            i9 = this.f33983g;
        } else {
            i9 = this.f33981e;
        }
        if (i9 != 1) {
            if (i9 != 2) {
                signum = 0.0f;
            } else {
                signum = Math.min(Math.max(i7 * f4, -1.0f), 1.0f);
            }
        } else {
            signum = Math.signum(i7) * f33976r.getInterpolation(Math.min(Math.abs(i7), i8) * f4);
        }
        this.f33977a.b(this.f33978b, i4, this.f33990n, signum, true, this.f33993q, false, true);
        this.f33990n = signum;
    }
}
