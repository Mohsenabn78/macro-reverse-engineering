package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes5.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    protected OverlayViewGroup f23914a;

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.f23914a.a(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.f23914a.e(drawable);
    }

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    /* loaded from: classes5.dex */
    static class OverlayViewGroup extends ViewGroup {

        /* renamed from: e  reason: collision with root package name */
        static Method f23915e;

        /* renamed from: a  reason: collision with root package name */
        ViewGroup f23916a;

        /* renamed from: b  reason: collision with root package name */
        View f23917b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<Drawable> f23918c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f23919d;

        static {
            try {
                Class cls = Integer.TYPE;
                f23915e = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        private void b() {
            if (!this.f23919d) {
                return;
            }
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void c() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f23918c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f23919d = true;
                    this.f23916a.removeView(this);
                }
            }
        }

        private void d(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f23916a.getLocationOnScreen(iArr2);
            this.f23917b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            b();
            if (this.f23918c == null) {
                this.f23918c = new ArrayList<>();
            }
            if (!this.f23918c.contains(drawable)) {
                this.f23918c.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int size;
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f23916a.getLocationOnScreen(iArr);
            this.f23917b.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.f23917b.getWidth(), this.f23917b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f23918c;
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            for (int i4 = 0; i4 < size; i4++) {
                this.f23918c.get(i4).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void e(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f23918c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                c();
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f23916a != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f23916a != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    d(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
                return null;
            }
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@NonNull Drawable drawable) {
            ArrayList<Drawable> arrayList;
            if (!super.verifyDrawable(drawable) && ((arrayList = this.f23918c) == null || !arrayList.contains(drawable))) {
                return false;
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        }
    }
}
