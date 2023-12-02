package com.h6ah4i.android.widget.advrecyclerview.swipeable.action;

/* loaded from: classes6.dex */
public abstract class SwipeResultAction {

    /* renamed from: a  reason: collision with root package name */
    private final int f33955a;

    /* JADX INFO: Access modifiers changed from: protected */
    public SwipeResultAction(int i4) {
        this.f33955a = i4;
    }

    public int getResultActionType() {
        return this.f33955a;
    }

    public final void performAction() {
        b();
    }

    public final void slideAnimationEnd() {
        c();
        a();
    }

    protected void a() {
    }

    protected void b() {
    }

    protected void c() {
    }
}
