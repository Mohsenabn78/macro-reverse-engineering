package com.arlosoft.macrodroid.action.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class HUDView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f4870a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4871b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4872c;

    /* renamed from: d  reason: collision with root package name */
    private final DisplayMetrics f4873d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f4874e;

    public HUDView(Context context, String str, int i4) {
        super(context);
        this.f4871b = str;
        this.f4872c = i4;
        Paint paint = new Paint();
        this.f4870a = paint;
        paint.setAntiAlias(true);
        paint.setTextSize(28.0f);
        paint.setARGB(255, 255, 0, 0);
        this.f4874e = BitmapFactory.decodeResource(getResources(), i4);
        this.f4873d = context.getResources().getDisplayMetrics();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = View.MeasureSpec.getSize(this.f4873d.widthPixels);
        Bitmap bitmap = this.f4874e;
        canvas.drawBitmap(bitmap, (size - bitmap.getWidth()) - 10, 10.0f, this.f4870a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
    }
}
