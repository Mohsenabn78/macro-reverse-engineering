package com.melnykov.fab;

import android.widget.AbsListView;
import androidx.annotation.NonNull;

/* compiled from: AbsListViewScrollDetector.java */
/* loaded from: classes6.dex */
abstract class a implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private int f36154a;

    /* renamed from: b  reason: collision with root package name */
    private int f36155b;

    /* renamed from: c  reason: collision with root package name */
    private AbsListView f36156c;

    /* renamed from: d  reason: collision with root package name */
    private int f36157d;

    private int a() {
        AbsListView absListView = this.f36156c;
        if (absListView == null || absListView.getChildAt(0) == null) {
            return 0;
        }
        return this.f36156c.getChildAt(0).getTop();
    }

    private boolean b(int i4) {
        if (i4 == this.f36155b) {
            return true;
        }
        return false;
    }

    abstract void c();

    abstract void d();

    public void e(@NonNull AbsListView absListView) {
        this.f36156c = absListView;
    }

    public void f(int i4) {
        this.f36157d = i4;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
        boolean z3;
        if (i6 == 0) {
            return;
        }
        if (b(i4)) {
            int a4 = a();
            if (Math.abs(this.f36154a - a4) > this.f36157d) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (this.f36154a > a4) {
                    d();
                } else {
                    c();
                }
            }
            this.f36154a = a4;
            return;
        }
        if (i4 > this.f36155b) {
            d();
        } else {
            c();
        }
        this.f36154a = a();
        this.f36155b = i4;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i4) {
    }
}
