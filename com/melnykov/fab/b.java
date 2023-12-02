package com.melnykov.fab;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: RecyclerViewScrollDetector.java */
/* loaded from: classes6.dex */
abstract class b extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private int f36158a;

    abstract void a();

    abstract void b();

    public void c(int i4) {
        this.f36158a = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
        boolean z3;
        if (Math.abs(i5) > this.f36158a) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (i5 > 0) {
                b();
            } else {
                a();
            }
        }
    }
}
