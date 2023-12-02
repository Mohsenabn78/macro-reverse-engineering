package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

@Deprecated
/* loaded from: classes5.dex */
public class ShadowDrawableWrapper extends DrawableWrapper {

    /* renamed from: q  reason: collision with root package name */
    static final double f24151q = Math.cos(Math.toRadians(45.0d));
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final Paint f24152a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final Paint f24153b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final RectF f24154c;

    /* renamed from: d  reason: collision with root package name */
    float f24155d;

    /* renamed from: e  reason: collision with root package name */
    Path f24156e;

    /* renamed from: f  reason: collision with root package name */
    float f24157f;

    /* renamed from: g  reason: collision with root package name */
    float f24158g;

    /* renamed from: h  reason: collision with root package name */
    float f24159h;

    /* renamed from: i  reason: collision with root package name */
    float f24160i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24161j;

    /* renamed from: k  reason: collision with root package name */
    private final int f24162k;

    /* renamed from: l  reason: collision with root package name */
    private final int f24163l;

    /* renamed from: m  reason: collision with root package name */
    private final int f24164m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24165n;

    /* renamed from: o  reason: collision with root package name */
    private float f24166o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24167p;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f4, float f5, float f6) {
        super(drawable);
        this.f24161j = true;
        this.f24165n = true;
        this.f24167p = false;
        this.f24162k = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.f24163l = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.f24164m = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.f24152a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f24155d = Math.round(f4);
        this.f24154c = new RectF();
        Paint paint2 = new Paint(paint);
        this.f24153b = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f5, f6);
    }

    private void a(@NonNull Rect rect) {
        float f4 = this.f24158g;
        float f5 = 1.5f * f4;
        this.f24154c.set(rect.left + f4, rect.top + f5, rect.right - f4, rect.bottom - f5);
        Drawable wrappedDrawable = getWrappedDrawable();
        RectF rectF = this.f24154c;
        wrappedDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        b();
    }

    private void b() {
        float f4 = this.f24155d;
        RectF rectF = new RectF(-f4, -f4, f4, f4);
        RectF rectF2 = new RectF(rectF);
        float f5 = this.f24159h;
        rectF2.inset(-f5, -f5);
        Path path = this.f24156e;
        if (path == null) {
            this.f24156e = new Path();
        } else {
            path.reset();
        }
        this.f24156e.setFillType(Path.FillType.EVEN_ODD);
        this.f24156e.moveTo(-this.f24155d, 0.0f);
        this.f24156e.rLineTo(-this.f24159h, 0.0f);
        this.f24156e.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f24156e.arcTo(rectF, 270.0f, -90.0f, false);
        this.f24156e.close();
        float f6 = -rectF2.top;
        if (f6 > 0.0f) {
            float f7 = this.f24155d / f6;
            this.f24152a.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{0, this.f24162k, this.f24163l, this.f24164m}, new float[]{0.0f, f7, ((1.0f - f7) / 2.0f) + f7, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f24153b.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.f24162k, this.f24163l, this.f24164m}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f24153b.setAntiAlias(false);
    }

    private void c(@NonNull Canvas canvas) {
        boolean z3;
        boolean z4;
        int i4;
        float f4;
        int i5;
        float f5;
        float f6;
        float f7;
        int save = canvas.save();
        canvas.rotate(this.f24166o, this.f24154c.centerX(), this.f24154c.centerY());
        float f8 = this.f24155d;
        float f9 = (-f8) - this.f24159h;
        float f10 = f8 * 2.0f;
        if (this.f24154c.width() - f10 > 0.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f24154c.height() - f10 > 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        float f11 = this.f24160i;
        float f12 = f8 / ((f11 - (0.5f * f11)) + f8);
        float f13 = f8 / ((f11 - (0.25f * f11)) + f8);
        float f14 = f8 / ((f11 - (f11 * 1.0f)) + f8);
        int save2 = canvas.save();
        RectF rectF = this.f24154c;
        canvas.translate(rectF.left + f8, rectF.top + f8);
        canvas.scale(f12, f13);
        canvas.drawPath(this.f24156e, this.f24152a);
        if (z3) {
            canvas.scale(1.0f / f12, 1.0f);
            i4 = save2;
            f4 = f14;
            i5 = save;
            f5 = f13;
            canvas.drawRect(0.0f, f9, this.f24154c.width() - f10, -this.f24155d, this.f24153b);
        } else {
            i4 = save2;
            f4 = f14;
            i5 = save;
            f5 = f13;
        }
        canvas.restoreToCount(i4);
        int save3 = canvas.save();
        RectF rectF2 = this.f24154c;
        canvas.translate(rectF2.right - f8, rectF2.bottom - f8);
        float f15 = f4;
        canvas.scale(f12, f15);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f24156e, this.f24152a);
        if (z3) {
            canvas.scale(1.0f / f12, 1.0f);
            f6 = f5;
            f7 = f15;
            canvas.drawRect(0.0f, f9, this.f24154c.width() - f10, (-this.f24155d) + this.f24159h, this.f24153b);
        } else {
            f6 = f5;
            f7 = f15;
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.f24154c;
        canvas.translate(rectF3.left + f8, rectF3.bottom - f8);
        canvas.scale(f12, f7);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f24156e, this.f24152a);
        if (z4) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f9, this.f24154c.height() - f10, -this.f24155d, this.f24153b);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.f24154c;
        canvas.translate(rectF4.right - f8, rectF4.top + f8);
        float f16 = f6;
        canvas.scale(f12, f16);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f24156e, this.f24152a);
        if (z4) {
            canvas.scale(1.0f / f16, 1.0f);
            canvas.drawRect(0.0f, f9, this.f24154c.height() - f10, -this.f24155d, this.f24153b);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(i5);
    }

    public static float calculateHorizontalPadding(float f4, float f5, boolean z3) {
        if (z3) {
            return (float) (f4 + ((1.0d - f24151q) * f5));
        }
        return f4;
    }

    public static float calculateVerticalPadding(float f4, float f5, boolean z3) {
        if (z3) {
            return (float) ((f4 * 1.5f) + ((1.0d - f24151q) * f5));
        }
        return f4 * 1.5f;
    }

    private static int d(float f4) {
        int round = Math.round(f4);
        if (round % 2 == 1) {
            return round - 1;
        }
        return round;
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.f24161j) {
            a(getBounds());
            this.f24161j = false;
        }
        c(canvas);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.f24155d;
    }

    public float getMaxShadowSize() {
        return this.f24158g;
    }

    public float getMinHeight() {
        float f4 = this.f24158g;
        return (Math.max(f4, this.f24155d + ((f4 * 1.5f) / 2.0f)) * 2.0f) + (this.f24158g * 1.5f * 2.0f);
    }

    public float getMinWidth() {
        float f4 = this.f24158g;
        return (Math.max(f4, this.f24155d + (f4 / 2.0f)) * 2.0f) + (this.f24158g * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil(calculateVerticalPadding(this.f24158g, this.f24155d, this.f24165n));
        int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.f24158g, this.f24155d, this.f24165n));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.f24160i;
    }

    public void setAddPaddingForCorners(boolean z3) {
        this.f24165n = z3;
        invalidateSelf();
    }

    public void setAlpha(int i4) {
        super.setAlpha(i4);
        this.f24152a.setAlpha(i4);
        this.f24153b.setAlpha(i4);
    }

    public void setCornerRadius(float f4) {
        float round = Math.round(f4);
        if (this.f24155d == round) {
            return;
        }
        this.f24155d = round;
        this.f24161j = true;
        invalidateSelf();
    }

    public void setMaxShadowSize(float f4) {
        setShadowSize(this.f24160i, f4);
    }

    public final void setRotation(float f4) {
        if (this.f24166o != f4) {
            this.f24166o = f4;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f4, float f5) {
        if (f4 >= 0.0f && f5 >= 0.0f) {
            float d4 = d(f4);
            float d5 = d(f5);
            if (d4 > d5) {
                if (!this.f24167p) {
                    this.f24167p = true;
                }
                d4 = d5;
            }
            if (this.f24160i == d4 && this.f24158g == d5) {
                return;
            }
            this.f24160i = d4;
            this.f24158g = d5;
            this.f24159h = Math.round(d4 * 1.5f);
            this.f24157f = d5;
            this.f24161j = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("invalid shadow size");
    }

    public void setShadowSize(float f4) {
        setShadowSize(f4, this.f24158g);
    }
}
