package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes5.dex */
class ViewOffsetHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f23002a;

    /* renamed from: b  reason: collision with root package name */
    private int f23003b;

    /* renamed from: c  reason: collision with root package name */
    private int f23004c;

    /* renamed from: d  reason: collision with root package name */
    private int f23005d;

    /* renamed from: e  reason: collision with root package name */
    private int f23006e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23007f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23008g = true;

    public ViewOffsetHelper(View view) {
        this.f23002a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f23002a;
        ViewCompat.offsetTopAndBottom(view, this.f23005d - (view.getTop() - this.f23003b));
        View view2 = this.f23002a;
        ViewCompat.offsetLeftAndRight(view2, this.f23006e - (view2.getLeft() - this.f23004c));
    }

    public int b() {
        return this.f23003b;
    }

    public int c() {
        return this.f23006e;
    }

    public int d() {
        return this.f23005d;
    }

    public boolean e() {
        return this.f23008g;
    }

    public boolean f() {
        return this.f23007f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f23003b = this.f23002a.getTop();
        this.f23004c = this.f23002a.getLeft();
    }

    public void h(boolean z3) {
        this.f23008g = z3;
    }

    public boolean i(int i4) {
        if (this.f23008g && this.f23006e != i4) {
            this.f23006e = i4;
            a();
            return true;
        }
        return false;
    }

    public boolean j(int i4) {
        if (this.f23007f && this.f23005d != i4) {
            this.f23005d = i4;
            a();
            return true;
        }
        return false;
    }

    public void k(boolean z3) {
        this.f23007f = z3;
    }
}
