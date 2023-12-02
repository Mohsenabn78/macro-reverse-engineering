package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import java.lang.ref.WeakReference;

/* compiled from: RemovingItemDecorator.java */
/* loaded from: classes6.dex */
class b extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f33956a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView.ViewHolder f33957b;

    /* renamed from: c  reason: collision with root package name */
    private final long f33958c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f33959d;

    /* renamed from: e  reason: collision with root package name */
    private int f33960e;

    /* renamed from: f  reason: collision with root package name */
    private int f33961f;

    /* renamed from: g  reason: collision with root package name */
    private long f33962g;

    /* renamed from: h  reason: collision with root package name */
    private final long f33963h;

    /* renamed from: i  reason: collision with root package name */
    private final long f33964i;

    /* renamed from: j  reason: collision with root package name */
    private Interpolator f33965j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f33966k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f33967l;

    /* renamed from: m  reason: collision with root package name */
    private int f33968m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemovingItemDecorator.java */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f33969a;

        /* renamed from: b  reason: collision with root package name */
        private final int f33970b;

        public a(b bVar, int i4) {
            this.f33969a = new WeakReference<>(bVar);
            this.f33970b = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f33969a.get();
            this.f33969a.clear();
            this.f33969a = null;
            if (bVar != null) {
                bVar.f(this.f33970b);
            }
        }
    }

    public b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i4, long j4, long j5) {
        Rect rect = new Rect();
        this.f33959d = rect;
        boolean z3 = false;
        this.f33968m = 0;
        this.f33956a = recyclerView;
        this.f33957b = viewHolder;
        this.f33958c = viewHolder.getItemId();
        this.f33967l = (i4 == 2 || i4 == 4) ? true : true;
        this.f33963h = j4 + 50;
        this.f33964i = j5;
        this.f33960e = (int) (viewHolder.itemView.getTranslationX() + 0.5f);
        this.f33961f = (int) (viewHolder.itemView.getTranslationY() + 0.5f);
        CustomRecyclerViewUtils.getViewBounds(this.f33957b.itemView, rect);
    }

    private float a(long j4) {
        long j5 = this.f33963h;
        if (j4 < j5) {
            return 1.0f;
        }
        long j6 = this.f33964i;
        if (j4 < j5 + j6 && j6 != 0) {
            float f4 = 1.0f - (((float) (j4 - j5)) / ((float) j6));
            Interpolator interpolator = this.f33965j;
            if (interpolator != null) {
                return interpolator.getInterpolation(f4);
            }
            return f4;
        }
        return 0.0f;
    }

    private void b(Canvas canvas, Drawable drawable, float f4) {
        float f5;
        Rect rect = this.f33959d;
        int i4 = this.f33960e;
        int i5 = this.f33961f;
        boolean z3 = this.f33967l;
        if (z3) {
            f5 = 1.0f;
        } else {
            f5 = f4;
        }
        if (!z3) {
            f4 = 1.0f;
        }
        int width = (int) ((f5 * rect.width()) + 0.5f);
        int height = (int) ((f4 * rect.height()) + 0.5f);
        if (height != 0 && width != 0 && drawable != null) {
            int save = canvas.save();
            int i6 = rect.left;
            int i7 = rect.top;
            canvas.clipRect(i6 + i4, i7 + i5, i6 + i4 + width, i7 + i5 + height);
            canvas.translate((rect.left + i4) - ((rect.width() - width) / 2), (rect.top + i5) - ((rect.height() - height) / 2));
            drawable.setBounds(0, 0, rect.width(), rect.height());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    private void c() {
        this.f33956a.removeItemDecoration(this);
        g();
        this.f33956a = null;
        this.f33957b = null;
        this.f33961f = 0;
        this.f33965j = null;
    }

    protected static long d(long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= j4) {
            return currentTimeMillis - j4;
        }
        return Long.MAX_VALUE;
    }

    private void e(int i4, long j4) {
        int i5 = 1 << i4;
        int i6 = this.f33968m;
        if ((i6 & i5) != 0) {
            return;
        }
        this.f33968m = i5 | i6;
        ViewCompat.postOnAnimationDelayed(this.f33956a, new a(this, i4), j4);
    }

    private void g() {
        ViewCompat.postInvalidateOnAnimation(this.f33956a);
    }

    private boolean h(long j4) {
        long j5 = this.f33963h;
        if (j4 >= j5 && j4 < j5 + this.f33964i) {
            return true;
        }
        return false;
    }

    void f(int i4) {
        long d4 = d(this.f33962g);
        this.f33968m = (~(1 << i4)) & this.f33968m;
        if (i4 != 0) {
            if (i4 == 1) {
                c();
                return;
            }
            return;
        }
        long j4 = this.f33963h;
        if (d4 < j4) {
            e(0, j4 - d4);
            return;
        }
        g();
        e(1, this.f33964i);
    }

    public void i(Interpolator interpolator) {
        this.f33965j = interpolator;
    }

    public void j() {
        ViewCompat.animate(f.a(this.f33957b)).cancel();
        this.f33956a.addItemDecoration(this);
        this.f33962g = System.currentTimeMillis();
        this.f33961f = (int) (this.f33957b.itemView.getTranslationY() + 0.5f);
        this.f33966k = this.f33957b.itemView.getBackground();
        g();
        e(0, this.f33963h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        long d4 = d(this.f33962g);
        b(canvas, this.f33966k, a(d4));
        if (this.f33958c == this.f33957b.getItemId()) {
            this.f33960e = (int) (this.f33957b.itemView.getTranslationX() + 0.5f);
            this.f33961f = (int) (this.f33957b.itemView.getTranslationY() + 0.5f);
        }
        if (h(d4)) {
            g();
        }
    }
}
