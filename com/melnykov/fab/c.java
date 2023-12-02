package com.melnykov.fab;

import android.widget.ScrollView;
import com.melnykov.fab.ObservableScrollView;

/* compiled from: ScrollViewScrollDetector.java */
/* loaded from: classes6.dex */
abstract class c implements ObservableScrollView.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private int f36159a;

    /* renamed from: b  reason: collision with root package name */
    private int f36160b;

    abstract void a();

    abstract void b();

    public void c(int i4) {
        this.f36160b = i4;
    }

    @Override // com.melnykov.fab.ObservableScrollView.OnScrollChangedListener
    public void onScrollChanged(ScrollView scrollView, int i4, int i5, int i6, int i7) {
        boolean z3;
        if (Math.abs(i5 - this.f36159a) > this.f36160b) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (i5 > this.f36159a) {
                b();
            } else {
                a();
            }
        }
        this.f36159a = i5;
    }
}
