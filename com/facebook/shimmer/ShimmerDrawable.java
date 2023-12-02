package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class ShimmerDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f17627a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f17628b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f17629c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f17630d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f17631e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Shimmer f17632f;

    /* loaded from: classes3.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerDrawable.this.invalidateSelf();
        }
    }

    public ShimmerDrawable() {
        Paint paint = new Paint();
        this.f17628b = paint;
        this.f17629c = new Rect();
        this.f17630d = new Matrix();
        paint.setAntiAlias(true);
    }

    private float b(float f4, float f5, float f6) {
        return f4 + ((f5 - f4) * f6);
    }

    private void c() {
        Shimmer shimmer;
        Shader radialGradient;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width != 0 && height != 0 && (shimmer = this.f17632f) != null) {
            int d4 = shimmer.d(width);
            int a4 = this.f17632f.a(height);
            Shimmer shimmer2 = this.f17632f;
            boolean z3 = true;
            if (shimmer2.f17611g != 1) {
                int i4 = shimmer2.f17608d;
                if (i4 != 1 && i4 != 3) {
                    z3 = false;
                }
                if (z3) {
                    d4 = 0;
                }
                if (!z3) {
                    a4 = 0;
                }
                float f4 = a4;
                Shimmer shimmer3 = this.f17632f;
                radialGradient = new LinearGradient(0.0f, 0.0f, d4, f4, shimmer3.f17606b, shimmer3.f17605a, Shader.TileMode.CLAMP);
            } else {
                float f5 = a4 / 2.0f;
                float max = (float) (Math.max(d4, a4) / Math.sqrt(2.0d));
                Shimmer shimmer4 = this.f17632f;
                radialGradient = new RadialGradient(d4 / 2.0f, f5, max, shimmer4.f17606b, shimmer4.f17605a, Shader.TileMode.CLAMP);
            }
            this.f17628b.setShader(radialGradient);
        }
    }

    private void d() {
        boolean z3;
        if (this.f17632f == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f17631e;
        if (valueAnimator != null) {
            z3 = valueAnimator.isStarted();
            this.f17631e.cancel();
            this.f17631e.removeAllUpdateListeners();
        } else {
            z3 = false;
        }
        Shimmer shimmer = this.f17632f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ((float) (shimmer.f17625u / shimmer.f17624t)) + 1.0f);
        this.f17631e = ofFloat;
        ofFloat.setRepeatMode(this.f17632f.f17623s);
        this.f17631e.setRepeatCount(this.f17632f.f17622r);
        ValueAnimator valueAnimator2 = this.f17631e;
        Shimmer shimmer2 = this.f17632f;
        valueAnimator2.setDuration(shimmer2.f17624t + shimmer2.f17625u);
        this.f17631e.addUpdateListener(this.f17627a);
        if (z3) {
            this.f17631e.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Shimmer shimmer;
        ValueAnimator valueAnimator = this.f17631e;
        if (valueAnimator != null && !valueAnimator.isStarted() && (shimmer = this.f17632f) != null && shimmer.f17620p && getCallback() != null) {
            this.f17631e.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f4;
        float b4;
        float b5;
        if (this.f17632f != null && this.f17628b.getShader() != null) {
            float tan = (float) Math.tan(Math.toRadians(this.f17632f.f17618n));
            float height = this.f17629c.height() + (this.f17629c.width() * tan);
            float width = this.f17629c.width() + (tan * this.f17629c.height());
            ValueAnimator valueAnimator = this.f17631e;
            float f5 = 0.0f;
            if (valueAnimator != null) {
                f4 = valueAnimator.getAnimatedFraction();
            } else {
                f4 = 0.0f;
            }
            int i4 = this.f17632f.f17608d;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        b5 = b(-width, width, f4);
                    } else {
                        b4 = b(height, -height, f4);
                    }
                } else {
                    b5 = b(width, -width, f4);
                }
                f5 = b5;
                b4 = 0.0f;
            } else {
                b4 = b(-height, height, f4);
            }
            this.f17630d.reset();
            this.f17630d.setRotate(this.f17632f.f17618n, this.f17629c.width() / 2.0f, this.f17629c.height() / 2.0f);
            this.f17630d.postTranslate(f5, b4);
            this.f17628b.getShader().setLocalMatrix(this.f17630d);
            canvas.drawRect(this.f17629c, this.f17628b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Shimmer shimmer = this.f17632f;
        if (shimmer != null && (shimmer.f17619o || shimmer.f17621q)) {
            return -3;
        }
        return -1;
    }

    public boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.f17631e;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f17629c.set(0, 0, rect.width(), rect.height());
        c();
        a();
    }

    public void setShimmer(@Nullable Shimmer shimmer) {
        PorterDuff.Mode mode;
        this.f17632f = shimmer;
        if (shimmer != null) {
            Paint paint = this.f17628b;
            if (this.f17632f.f17621q) {
                mode = PorterDuff.Mode.DST_IN;
            } else {
                mode = PorterDuff.Mode.SRC_IN;
            }
            paint.setXfermode(new PorterDuffXfermode(mode));
        }
        c();
        d();
        invalidateSelf();
    }

    public void startShimmer() {
        if (this.f17631e != null && !isShimmerStarted() && getCallback() != null) {
            this.f17631e.start();
        }
    }

    public void stopShimmer() {
        if (this.f17631e != null && isShimmerStarted()) {
            this.f17631e.cancel();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
