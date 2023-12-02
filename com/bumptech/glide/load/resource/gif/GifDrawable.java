package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;

    /* renamed from: a  reason: collision with root package name */
    private final a f17298a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17299b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17300c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17301d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17302e;

    /* renamed from: f  reason: collision with root package name */
    private int f17303f;

    /* renamed from: g  reason: collision with root package name */
    private int f17304g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17305h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f17306i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f17307j;

    /* renamed from: k  reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f17308k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a extends Drawable.ConstantState {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        final GifFrameLoader f17309a;

        a(GifFrameLoader gifFrameLoader) {
            this.f17309a = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i4, int i5, Bitmap bitmap) {
        this(context, gifDecoder, transformation, i4, i5, bitmap);
    }

    private Drawable.Callback a() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect b() {
        if (this.f17307j == null) {
            this.f17307j = new Rect();
        }
        return this.f17307j;
    }

    private Paint c() {
        if (this.f17306i == null) {
            this.f17306i = new Paint(2);
        }
        return this.f17306i;
    }

    private void d() {
        List<Animatable2Compat.AnimationCallback> list = this.f17308k;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f17308k.get(i4).onAnimationEnd(this);
            }
        }
    }

    private void e() {
        this.f17303f = 0;
    }

    private void f() {
        Preconditions.checkArgument(!this.f17301d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f17298a.f17309a.f() == 1) {
            invalidateSelf();
        } else if (!this.f17299b) {
            this.f17299b = true;
            this.f17298a.f17309a.v(this);
            invalidateSelf();
        }
    }

    private void g() {
        this.f17299b = false;
        this.f17298a.f17309a.w(this);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f17308k;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f17301d) {
            return;
        }
        if (this.f17305h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), b());
            this.f17305h = false;
        }
        canvas.drawBitmap(this.f17298a.f17309a.c(), (Rect) null, b(), c());
    }

    public ByteBuffer getBuffer() {
        return this.f17298a.f17309a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f17298a;
    }

    public Bitmap getFirstFrame() {
        return this.f17298a.f17309a.e();
    }

    public int getFrameCount() {
        return this.f17298a.f17309a.f();
    }

    public int getFrameIndex() {
        return this.f17298a.f17309a.d();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.f17298a.f17309a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f17298a.f17309a.j();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f17298a.f17309a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        return this.f17298a.f17309a.m();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f17299b;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f17305h = true;
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public void onFrameReady() {
        if (a() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (getFrameIndex() == getFrameCount() - 1) {
            this.f17303f++;
        }
        int i4 = this.f17304g;
        if (i4 != -1 && this.f17303f >= i4) {
            d();
            stop();
        }
    }

    public void recycle() {
        this.f17301d = true;
        this.f17298a.f17309a.a();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f17308k == null) {
            this.f17308k = new ArrayList();
        }
        this.f17308k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        c().setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c().setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f17298a.f17309a.r(transformation, bitmap);
    }

    public void setLoopCount(int i4) {
        int i5 = -1;
        if (i4 <= 0 && i4 != -1 && i4 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i4 == 0) {
            int k4 = this.f17298a.f17309a.k();
            if (k4 != 0) {
                i5 = k4;
            }
            this.f17304g = i5;
            return;
        }
        this.f17304g = i4;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        Preconditions.checkArgument(!this.f17301d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f17302e = z3;
        if (!z3) {
            g();
        } else if (this.f17300c) {
            f();
        }
        return super.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f17300c = true;
        e();
        if (this.f17302e) {
            f();
        }
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.f17299b, "You cannot restart a currently running animation.");
        this.f17298a.f17309a.s();
        start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f17300c = false;
        g();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f17308k;
        if (list != null && animationCallback != null) {
            return list.remove(animationCallback);
        }
        return false;
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i4, int i5, Bitmap bitmap) {
        this(new a(new GifFrameLoader(Glide.get(context), gifDecoder, i4, i5, transformation, bitmap)));
    }

    GifDrawable(a aVar) {
        this.f17302e = true;
        this.f17304g = -1;
        this.f17298a = (a) Preconditions.checkNotNull(aVar);
    }
}
