package com.jaredrummler.android.colorpicker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: AlphaPatternDrawable.java */
/* loaded from: classes6.dex */
class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private int f34565a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f34566b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    private Paint f34567c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private Paint f34568d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private int f34569e;

    /* renamed from: f  reason: collision with root package name */
    private int f34570f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f34571g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i4) {
        this.f34565a = 10;
        this.f34565a = i4;
        this.f34567c.setColor(-1);
        this.f34568d.setColor(-3421237);
    }

    private void a() {
        Paint paint;
        if (getBounds().width() > 0 && getBounds().height() > 0) {
            this.f34571g = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f34571g);
            Rect rect = new Rect();
            boolean z3 = true;
            for (int i4 = 0; i4 <= this.f34570f; i4++) {
                boolean z4 = z3;
                for (int i5 = 0; i5 <= this.f34569e; i5++) {
                    int i6 = this.f34565a;
                    int i7 = i4 * i6;
                    rect.top = i7;
                    int i8 = i5 * i6;
                    rect.left = i8;
                    rect.bottom = i7 + i6;
                    rect.right = i8 + i6;
                    if (z4) {
                        paint = this.f34567c;
                    } else {
                        paint = this.f34568d;
                    }
                    canvas.drawRect(rect, paint);
                    z4 = !z4;
                }
                z3 = !z3;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f34571g;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f34571g, (Rect) null, getBounds(), this.f34566b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int height = rect.height();
        this.f34569e = (int) Math.ceil(rect.width() / this.f34565a);
        this.f34570f = (int) Math.ceil(height / this.f34565a);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        throw new UnsupportedOperationException("Alpha is not supported by this drawable.");
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("ColorFilter is not supported by this drawable.");
    }
}
