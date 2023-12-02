package com.yalantis.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
public class FastBitmapDrawable extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f38476b;

    /* renamed from: d  reason: collision with root package name */
    private int f38478d;

    /* renamed from: e  reason: collision with root package name */
    private int f38479e;

    /* renamed from: a  reason: collision with root package name */
    private final Paint f38475a = new Paint(2);

    /* renamed from: c  reason: collision with root package name */
    private int f38477c = 255;

    public FastBitmapDrawable(Bitmap bitmap) {
        setBitmap(bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f38476b;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f38476b, (Rect) null, getBounds(), this.f38475a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f38477c;
    }

    public Bitmap getBitmap() {
        return this.f38476b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f38479e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f38478d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f38479e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f38478d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f38477c = i4;
        this.f38475a.setAlpha(i4);
    }

    public void setBitmap(Bitmap bitmap) {
        this.f38476b = bitmap;
        if (bitmap != null) {
            this.f38478d = bitmap.getWidth();
            this.f38479e = this.f38476b.getHeight();
            return;
        }
        this.f38479e = 0;
        this.f38478d = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f38475a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z3) {
        this.f38475a.setFilterBitmap(z3);
    }
}
