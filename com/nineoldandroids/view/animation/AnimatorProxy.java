package com.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
public final class AnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY;

    /* renamed from: q  reason: collision with root package name */
    private static final WeakHashMap<View, AnimatorProxy> f36432q;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<View> f36433a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f36435c;

    /* renamed from: e  reason: collision with root package name */
    private float f36437e;

    /* renamed from: f  reason: collision with root package name */
    private float f36438f;

    /* renamed from: g  reason: collision with root package name */
    private float f36439g;

    /* renamed from: h  reason: collision with root package name */
    private float f36440h;

    /* renamed from: i  reason: collision with root package name */
    private float f36441i;

    /* renamed from: l  reason: collision with root package name */
    private float f36444l;

    /* renamed from: m  reason: collision with root package name */
    private float f36445m;

    /* renamed from: b  reason: collision with root package name */
    private final Camera f36434b = new Camera();

    /* renamed from: d  reason: collision with root package name */
    private float f36436d = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f36442j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f36443k = 1.0f;

    /* renamed from: n  reason: collision with root package name */
    private final RectF f36446n = new RectF();

    /* renamed from: o  reason: collision with root package name */
    private final RectF f36447o = new RectF();

    /* renamed from: p  reason: collision with root package name */
    private final Matrix f36448p = new Matrix();

    static {
        boolean z3;
        if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {
            z3 = true;
        } else {
            z3 = false;
        }
        NEEDS_PROXY = z3;
        f36432q = new WeakHashMap<>();
    }

    private AnimatorProxy(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f36433a = new WeakReference<>(view);
    }

    private void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f36448p;
        matrix.reset();
        d(matrix, view);
        this.f36448p.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f4 = rectF.right;
        float f5 = rectF.left;
        if (f4 < f5) {
            rectF.right = f5;
            rectF.left = f4;
        }
        float f6 = rectF.bottom;
        float f7 = rectF.top;
        if (f6 < f7) {
            rectF.top = f6;
            rectF.bottom = f7;
        }
    }

    private void b() {
        View view = this.f36433a.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f36447o;
            a(rectF, view);
            rectF.union(this.f36446n);
            ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
    }

    private void c() {
        View view = this.f36433a.get();
        if (view != null) {
            a(this.f36446n, view);
        }
    }

    private void d(Matrix matrix, View view) {
        float f4;
        float f5;
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z3 = this.f36435c;
        if (z3) {
            f4 = this.f36437e;
        } else {
            f4 = width / 2.0f;
        }
        if (z3) {
            f5 = this.f36438f;
        } else {
            f5 = height / 2.0f;
        }
        float f6 = this.f36439g;
        float f7 = this.f36440h;
        float f8 = this.f36441i;
        if (f6 != 0.0f || f7 != 0.0f || f8 != 0.0f) {
            Camera camera = this.f36434b;
            camera.save();
            camera.rotateX(f6);
            camera.rotateY(f7);
            camera.rotateZ(-f8);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f4, -f5);
            matrix.postTranslate(f4, f5);
        }
        float f9 = this.f36442j;
        float f10 = this.f36443k;
        if (f9 != 1.0f || f10 != 1.0f) {
            matrix.postScale(f9, f10);
            matrix.postTranslate((-(f4 / width)) * ((f9 * width) - width), (-(f5 / height)) * ((f10 * height) - height));
        }
        matrix.postTranslate(this.f36444l, this.f36445m);
    }

    public static AnimatorProxy wrap(View view) {
        WeakHashMap<View, AnimatorProxy> weakHashMap = f36432q;
        AnimatorProxy animatorProxy = weakHashMap.get(view);
        if (animatorProxy == null || animatorProxy != view.getAnimation()) {
            AnimatorProxy animatorProxy2 = new AnimatorProxy(view);
            weakHashMap.put(view, animatorProxy2);
            return animatorProxy2;
        }
        return animatorProxy;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f4, Transformation transformation) {
        View view = this.f36433a.get();
        if (view != null) {
            transformation.setAlpha(this.f36436d);
            d(transformation.getMatrix(), view);
        }
    }

    public float getAlpha() {
        return this.f36436d;
    }

    public float getPivotX() {
        return this.f36437e;
    }

    public float getPivotY() {
        return this.f36438f;
    }

    public float getRotation() {
        return this.f36441i;
    }

    public float getRotationX() {
        return this.f36439g;
    }

    public float getRotationY() {
        return this.f36440h;
    }

    public float getScaleX() {
        return this.f36442j;
    }

    public float getScaleY() {
        return this.f36443k;
    }

    public int getScrollX() {
        View view = this.f36433a.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int getScrollY() {
        View view = this.f36433a.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float getTranslationX() {
        return this.f36444l;
    }

    public float getTranslationY() {
        return this.f36445m;
    }

    public float getX() {
        View view = this.f36433a.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getLeft() + this.f36444l;
    }

    public float getY() {
        View view = this.f36433a.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getTop() + this.f36445m;
    }

    public void setAlpha(float f4) {
        if (this.f36436d != f4) {
            this.f36436d = f4;
            View view = this.f36433a.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setPivotX(float f4) {
        if (!this.f36435c || this.f36437e != f4) {
            c();
            this.f36435c = true;
            this.f36437e = f4;
            b();
        }
    }

    public void setPivotY(float f4) {
        if (!this.f36435c || this.f36438f != f4) {
            c();
            this.f36435c = true;
            this.f36438f = f4;
            b();
        }
    }

    public void setRotation(float f4) {
        if (this.f36441i != f4) {
            c();
            this.f36441i = f4;
            b();
        }
    }

    public void setRotationX(float f4) {
        if (this.f36439g != f4) {
            c();
            this.f36439g = f4;
            b();
        }
    }

    public void setRotationY(float f4) {
        if (this.f36440h != f4) {
            c();
            this.f36440h = f4;
            b();
        }
    }

    public void setScaleX(float f4) {
        if (this.f36442j != f4) {
            c();
            this.f36442j = f4;
            b();
        }
    }

    public void setScaleY(float f4) {
        if (this.f36443k != f4) {
            c();
            this.f36443k = f4;
            b();
        }
    }

    public void setScrollX(int i4) {
        View view = this.f36433a.get();
        if (view != null) {
            view.scrollTo(i4, view.getScrollY());
        }
    }

    public void setScrollY(int i4) {
        View view = this.f36433a.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i4);
        }
    }

    public void setTranslationX(float f4) {
        if (this.f36444l != f4) {
            c();
            this.f36444l = f4;
            b();
        }
    }

    public void setTranslationY(float f4) {
        if (this.f36445m != f4) {
            c();
            this.f36445m = f4;
            b();
        }
    }

    public void setX(float f4) {
        View view = this.f36433a.get();
        if (view != null) {
            setTranslationX(f4 - view.getLeft());
        }
    }

    public void setY(float f4) {
        View view = this.f36433a.get();
        if (view != null) {
            setTranslationY(f4 - view.getTop());
        }
    }
}
