package com.obsez.android.lib.filechooser.internals;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
public class WrappedDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f36561a;

    public WrappedDrawable(Drawable drawable) {
        this.f36561a = drawable;
    }

    protected Drawable a() {
        return this.f36561a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable a4 = a();
        if (a4 != null) {
            a4.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable a4 = a();
        if (a4 != null) {
            return a4.getBounds().height();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable a4 = a();
        if (a4 != null) {
            return a4.getBounds().width();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable a4 = a();
        if (a4 != null) {
            return a4.getOpacity();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        Drawable a4 = a();
        if (a4 != null) {
            a4.setAlpha(i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i4, int i5, int i6, int i7) {
        super.setBounds(i4, i5, i6, i7);
        Drawable a4 = a();
        if (a4 != null) {
            a4.setBounds(i4, i5, i6, i7);
        }
    }

    public void setBoundsInDp(float f4, float f5, float f6, float f7) {
        super.setBounds((int) UiUtil.dip2px(f4), (int) UiUtil.dip2px(f5), (int) UiUtil.dip2px(f6), (int) UiUtil.dip2px(f7));
        Drawable a4 = a();
        if (a4 != null) {
            a4.setBounds((int) UiUtil.dip2px(f4), (int) UiUtil.dip2px(f5), (int) UiUtil.dip2px(f6), (int) UiUtil.dip2px(f7));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable a4 = a();
        if (a4 != null) {
            a4.setColorFilter(colorFilter);
        }
    }

    public WrappedDrawable(Drawable drawable, float f4, float f5) {
        this.f36561a = drawable;
        setBounds(0, 0, (int) UiUtil.dip2px(f4), (int) UiUtil.dip2px(f5));
    }
}
