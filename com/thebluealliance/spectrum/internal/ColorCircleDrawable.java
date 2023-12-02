package com.thebluealliance.spectrum.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;

/* loaded from: classes6.dex */
public class ColorCircleDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f38064a;

    /* renamed from: b  reason: collision with root package name */
    private int f38065b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f38066c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f38067d;

    public ColorCircleDrawable(@ColorInt int i4) {
        int i5;
        Paint paint = new Paint(1);
        this.f38064a = paint;
        paint.setColor(i4);
        Paint paint2 = new Paint(1);
        this.f38067d = paint2;
        if (ColorUtil.isColorDark(i4)) {
            i5 = -1;
        } else {
            i5 = -16777216;
        }
        paint2.setColor(i5);
        paint2.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.f38066c != 0) {
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), this.f38065b - this.f38066c, this.f38064a);
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), this.f38065b - this.f38066c, this.f38067d);
            return;
        }
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), this.f38065b, this.f38064a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f38065b = Math.min(rect.width(), rect.height()) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f38064a.setAlpha(i4);
    }

    public void setColor(@ColorInt int i4) {
        int i5;
        this.f38064a.setColor(i4);
        Paint paint = this.f38067d;
        if (ColorUtil.isColorDark(i4)) {
            i5 = -1;
        } else {
            i5 = -16777216;
        }
        paint.setColor(i5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f38064a.setColorFilter(colorFilter);
    }

    public void setOutlineAlpha(int i4) {
        this.f38067d.setAlpha(i4);
        invalidateSelf();
    }

    public void setOutlineColor(@ColorInt int i4) {
        this.f38067d.setColor(i4);
        invalidateSelf();
    }

    public void setOutlineWidth(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.f38066c = i4;
        this.f38067d.setStrokeWidth(i4);
        invalidateSelf();
    }
}
