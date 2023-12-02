package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes5.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {

    /* renamed from: c  reason: collision with root package name */
    private int f24045c;

    /* renamed from: d  reason: collision with root package name */
    private float f24046d;

    /* renamed from: e  reason: collision with root package name */
    private float f24047e;

    /* renamed from: f  reason: collision with root package name */
    private float f24048f;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f24045c = 1;
    }

    private void h(Canvas canvas, Paint paint, float f4, float f5, float f6) {
        canvas.save();
        canvas.rotate(f6);
        float f7 = this.f24048f;
        float f8 = f4 / 2.0f;
        canvas.drawRoundRect(new RectF(f7 - f8, f5, f7 + f8, -f5), f5, f5, paint);
        canvas.restore();
    }

    private int i() {
        S s3 = this.f24087a;
        return ((CircularProgressIndicatorSpec) s3).indicatorSize + (((CircularProgressIndicatorSpec) s3).indicatorInset * 2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        S s3;
        int i4;
        S s4 = this.f24087a;
        float f5 = (((CircularProgressIndicatorSpec) s4).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s4).indicatorInset;
        canvas.translate(f5, f5);
        canvas.rotate(-90.0f);
        float f6 = -f5;
        canvas.clipRect(f6, f6, f5, f5);
        if (((CircularProgressIndicatorSpec) this.f24087a).indicatorDirection == 0) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        this.f24045c = i4;
        this.f24046d = ((CircularProgressIndicatorSpec) s3).trackThickness * f4;
        this.f24047e = ((CircularProgressIndicatorSpec) s3).trackCornerRadius * f4;
        this.f24048f = (((CircularProgressIndicatorSpec) s3).indicatorSize - ((CircularProgressIndicatorSpec) s3).trackThickness) / 2.0f;
        if ((this.f24088b.isShowing() && ((CircularProgressIndicatorSpec) this.f24087a).showAnimationBehavior == 2) || (this.f24088b.isHiding() && ((CircularProgressIndicatorSpec) this.f24087a).hideAnimationBehavior == 1)) {
            this.f24048f += ((1.0f - f4) * ((CircularProgressIndicatorSpec) this.f24087a).trackThickness) / 2.0f;
        } else if ((this.f24088b.isShowing() && ((CircularProgressIndicatorSpec) this.f24087a).showAnimationBehavior == 1) || (this.f24088b.isHiding() && ((CircularProgressIndicatorSpec) this.f24087a).hideAnimationBehavior == 2)) {
            this.f24048f -= ((1.0f - f4) * ((CircularProgressIndicatorSpec) this.f24087a).trackThickness) / 2.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @ColorInt int i4) {
        float f6;
        if (f4 == f5) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i4);
        paint.setStrokeWidth(this.f24046d);
        int i5 = this.f24045c;
        float f7 = f4 * 360.0f * i5;
        if (f5 >= f4) {
            f6 = f5 - f4;
        } else {
            f6 = (1.0f + f5) - f4;
        }
        float f8 = f6 * 360.0f * i5;
        float f9 = this.f24048f;
        canvas.drawArc(new RectF(-f9, -f9, f9, f9), f7, f8, false, paint);
        if (this.f24047e > 0.0f && Math.abs(f8) < 360.0f) {
            paint.setStyle(Paint.Style.FILL);
            h(canvas, paint, this.f24046d, this.f24047e, f7);
            h(canvas, paint, this.f24046d, this.f24047e, f7 + f8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.f24087a).trackColor, this.f24088b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        paint.setStrokeWidth(this.f24046d);
        float f4 = this.f24048f;
        canvas.drawArc(new RectF(-f4, -f4, f4, f4), 0.0f, 360.0f, false, paint);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int d() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int e() {
        return i();
    }
}
