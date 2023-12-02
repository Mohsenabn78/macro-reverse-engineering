package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: BaseDraggableItemDecorator.java */
/* loaded from: classes6.dex */
abstract class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private int f33789a = 200;

    /* renamed from: b  reason: collision with root package name */
    private final int f33790b;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f33791c;

    /* renamed from: d  reason: collision with root package name */
    protected final RecyclerView f33792d;

    /* renamed from: e  reason: collision with root package name */
    protected RecyclerView.ViewHolder f33793e;

    public a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        this.f33792d = recyclerView;
        this.f33793e = viewHolder;
        this.f33790b = (int) ((recyclerView.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
    }

    protected static void c(View view, float f4) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        ViewCompat.setTranslationZ(view, f4);
        view.setAlpha(1.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f4, float f5) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.endAnimation(viewHolder);
        }
        viewHolder.itemView.setTranslationX(f4);
        viewHolder.itemView.setTranslationY(f5);
    }

    protected float a(View view, float f4, float f5, float f6, float f7) {
        float f8;
        float f9;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int width = view.getWidth() / 2;
        int height = view.getHeight() / 2;
        if (width > 0) {
            f8 = Math.abs(translationX / width);
        } else {
            f8 = 0.0f;
        }
        if (height > 0) {
            f9 = Math.abs(translationY / height);
        } else {
            f9 = 0.0f;
        }
        float abs = Math.abs(Math.max(f4, f5) - 1.0f);
        float abs2 = Math.abs(f6 * 0.033333335f);
        return Math.min(Math.max(Math.max(Math.max(Math.max(Math.max(0.0f, f8), f9), abs), abs2), Math.abs(f7 - 1.0f)), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, float f4, float f5, float f6, float f7, boolean z3) {
        float translationZ = ViewCompat.getTranslationZ(view);
        int a4 = (int) (this.f33789a * a(view, f4, f5, f6, f7));
        if (z3 && a4 > 20) {
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
            view.setScaleX(f4);
            view.setScaleY(f5);
            view.setRotation(f6);
            view.setAlpha(f7);
            ViewCompat.setTranslationZ(view, translationZ + 1.0f);
            animate.cancel();
            animate.setDuration(a4);
            animate.setInterpolator(this.f33791c);
            animate.translationX(0.0f);
            animate.translationY(0.0f);
            animate.translationZ(translationZ);
            animate.alpha(1.0f);
            animate.rotation(0.0f);
            animate.scaleX(1.0f);
            animate.scaleY(1.0f);
            animate.setListener(new C0175a(translationZ));
            animate.start();
            return;
        }
        c(view, translationZ);
    }

    public void e(int i4) {
        this.f33789a = i4;
    }

    public void f(Interpolator interpolator) {
        this.f33791c = interpolator;
    }

    /* compiled from: BaseDraggableItemDecorator.java */
    /* renamed from: com.h6ah4i.android.widget.advrecyclerview.draggable.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0175a implements ViewPropertyAnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f33794a;

        C0175a(float f4) {
            this.f33794a = f4;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            ViewCompat.animate(view).setListener(null);
            a.c(view, this.f33794a);
            if (view.getParent() instanceof RecyclerView) {
                ViewCompat.postInvalidateOnAnimation((RecyclerView) view.getParent());
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
        }
    }
}
