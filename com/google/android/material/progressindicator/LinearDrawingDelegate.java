package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes5.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {

    /* renamed from: c  reason: collision with root package name */
    private float f24094c;

    /* renamed from: d  reason: collision with root package name */
    private float f24095d;

    /* renamed from: e  reason: collision with root package name */
    private float f24096e;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f24094c = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        Rect clipBounds = canvas.getClipBounds();
        this.f24094c = clipBounds.width();
        float f5 = ((LinearProgressIndicatorSpec) this.f24087a).trackThickness;
        canvas.translate(clipBounds.left + (clipBounds.width() / 2.0f), clipBounds.top + (clipBounds.height() / 2.0f) + Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) this.f24087a).trackThickness) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f24087a).f24118a) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f24088b.isShowing() && ((LinearProgressIndicatorSpec) this.f24087a).showAnimationBehavior == 1) || (this.f24088b.isHiding() && ((LinearProgressIndicatorSpec) this.f24087a).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f24088b.isShowing() || this.f24088b.isHiding()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.f24087a).trackThickness * (f4 - 1.0f)) / 2.0f);
        }
        float f6 = this.f24094c;
        canvas.clipRect((-f6) / 2.0f, (-f5) / 2.0f, f6 / 2.0f, f5 / 2.0f);
        S s3 = this.f24087a;
        this.f24095d = ((LinearProgressIndicatorSpec) s3).trackThickness * f4;
        this.f24096e = ((LinearProgressIndicatorSpec) s3).trackCornerRadius * f4;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @ColorInt int i4) {
        if (f4 == f5) {
            return;
        }
        float f6 = this.f24094c;
        float f7 = this.f24096e;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i4);
        float f8 = this.f24095d;
        RectF rectF = new RectF(((-f6) / 2.0f) + (f4 * (f6 - (f7 * 2.0f))), (-f8) / 2.0f, ((-f6) / 2.0f) + (f5 * (f6 - (f7 * 2.0f))) + (f7 * 2.0f), f8 / 2.0f);
        float f9 = this.f24096e;
        canvas.drawRoundRect(rectF, f9, f9, paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.f24087a).trackColor, this.f24088b.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        float f4 = this.f24094c;
        float f5 = this.f24095d;
        RectF rectF = new RectF((-f4) / 2.0f, (-f5) / 2.0f, f4 / 2.0f, f5 / 2.0f);
        float f6 = this.f24096e;
        canvas.drawRoundRect(rectF, f6, f6, paint);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int d() {
        return ((LinearProgressIndicatorSpec) this.f24087a).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int e() {
        return -1;
    }
}
